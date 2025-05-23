package com.tencent.mobileqq.nearby.redtouch;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cd$PullRedpointReq;
import tencent.im.oidb.cmd0x6cd$RedpointInfo;
import tencent.im.oidb.cmd0x6ce$ReadRedpointReq;
import tencent.im.oidb.cmd0x6f5$RspBody;
import tencent.im.oidb.cmd0x6f5$TaskInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocalRedTouchManager implements Manager, Handler.Callback {
    public static Map<Integer, Integer> H;

    @Deprecated
    public static final int[] I;
    private f C;
    g G;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f253039d;

    /* renamed from: e, reason: collision with root package name */
    boolean f253040e = false;

    /* renamed from: f, reason: collision with root package name */
    final Object f253041f = new Object();

    /* renamed from: h, reason: collision with root package name */
    private MqqHandler f253042h = new MqqHandler(ThreadManagerV2.getFileThreadLooper(), this);

    /* renamed from: i, reason: collision with root package name */
    private String f253043i = null;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<Integer, RedPointConfig> f253044m = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, f> D = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, RedTouchItem> E = new ConcurrentHashMap<>();
    private Vector<RedTouchItem> F = new Vector<>();

    static {
        HashMap hashMap = new HashMap(5);
        H = hashMap;
        I = new int[]{10001};
        hashMap.put(10005, Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST));
    }

    public LocalRedTouchManager(QQAppInterface qQAppInterface) {
        this.f253039d = qQAppInterface;
        this.G = new a(qQAppInterface, this);
        g();
    }

    private void C() {
        FileUtils.writeObject("red_point_info_" + this.f253039d.getCurrentAccountUin(), this.E);
    }

    private void E(RedTouchItem redTouchItem, int i3) {
        RedTouchItem redTouchItem2 = this.E.get(Integer.valueOf(i3));
        int i16 = 0;
        if (redTouchItem2 == null) {
            RedTouchItem redTouchItem3 = new RedTouchItem();
            h.a(redTouchItem3, redTouchItem);
            int i17 = redTouchItem.passThroughLevel;
            if (i17 - 1 >= 0) {
                i16 = i17 - 1;
            }
            redTouchItem3.passThroughLevel = i16;
            this.E.put(Integer.valueOf(i3), redTouchItem3);
            return;
        }
        if (redTouchItem2.unReadFlag) {
            int b16 = h.b(redTouchItem2.redtouchType);
            int b17 = h.b(redTouchItem.redtouchType);
            if (b17 > b16) {
                RedTouchItem redTouchItem4 = new RedTouchItem();
                h.a(redTouchItem4, redTouchItem);
                int i18 = redTouchItem.passThroughLevel;
                if (i18 - 1 >= 0) {
                    i16 = i18 - 1;
                }
                redTouchItem4.passThroughLevel = i16;
                this.E.put(Integer.valueOf(i3), redTouchItem4);
                return;
            }
            if (b17 == b16 && redTouchItem.redtouchType == 2) {
                redTouchItem2.count += redTouchItem.count;
                return;
            }
            return;
        }
        RedTouchItem redTouchItem5 = new RedTouchItem();
        h.a(redTouchItem5, redTouchItem);
        int i19 = redTouchItem.passThroughLevel;
        if (i19 - 1 >= 0) {
            i16 = i19 - 1;
        }
        redTouchItem5.passThroughLevel = i16;
        this.E.put(Integer.valueOf(i3), redTouchItem5);
    }

    private void F(int i3) {
        f fVar;
        f fVar2;
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "updateParents:" + i3);
        }
        RedTouchItem redTouchItem = this.E.get(Integer.valueOf(i3));
        if (redTouchItem != null && redTouchItem.passThroughLevel > 0) {
            for (int i16 = 0; i16 < redTouchItem.passThroughLevel && (fVar = this.D.get(Integer.valueOf(i3))) != null && (fVar2 = fVar.f253082b) != null; i16++) {
                RedTouchItem redTouchItem2 = this.E.get(Integer.valueOf(fVar2.f253081a));
                if (redTouchItem2 != null) {
                    redTouchItem2.unReadFlag = false;
                }
                if (fVar.f253082b.f253083c != null) {
                    for (int i17 = 0; i17 < fVar.f253082b.f253083c.size(); i17++) {
                        RedTouchItem redTouchItem3 = this.E.get(Integer.valueOf(fVar.f253082b.f253083c.get(i17).f253081a));
                        if (redTouchItem3 != null && redTouchItem3.unReadFlag && !redTouchItem3.isClosed && redTouchItem3.passThroughLevel > 0) {
                            E(redTouchItem3, fVar.f253082b.f253081a);
                        }
                    }
                }
                i3 = fVar.f253082b.f253081a;
            }
        }
    }

    private void g() {
        f fVar = new f();
        this.C = fVar;
        fVar.f253081a = -1;
        this.D.put(-1, this.C);
        f fVar2 = new f();
        fVar2.f253081a = 10018;
        fVar2.f253082b = this.C;
        this.D.put(10018, fVar2);
        f fVar3 = new f();
        fVar3.f253081a = -3;
        fVar3.f253082b = this.C;
        this.D.put(-3, fVar3);
        fVar3.f253083c = new ArrayList();
        f fVar4 = new f();
        fVar4.f253081a = -7;
        this.D.put(-7, fVar4);
        fVar4.f253082b = fVar3;
        fVar3.f253083c.add(fVar4);
        fVar4.f253083c = new ArrayList();
        f fVar5 = new f();
        fVar5.f253081a = -4;
        this.D.put(-4, fVar5);
        fVar5.f253082b = fVar3;
        fVar3.f253083c.add(fVar5);
        fVar5.f253083c = new ArrayList();
        f fVar6 = new f();
        fVar6.f253081a = 10015;
        this.D.put(10015, fVar6);
        fVar6.f253082b = fVar4;
        fVar4.f253083c.add(fVar6);
        f fVar7 = new f();
        fVar7.f253081a = 10016;
        this.D.put(10016, fVar7);
        fVar7.f253082b = fVar4;
        fVar4.f253083c.add(fVar7);
        f fVar8 = new f();
        fVar8.f253081a = BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST;
        fVar8.f253082b = fVar4;
        fVar4.f253083c.add(fVar8);
        this.D.put(Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST), fVar8);
        f fVar9 = new f();
        fVar9.f253081a = 10019;
        this.D.put(10019, fVar9);
        fVar9.f253082b = fVar5;
        fVar5.f253083c.add(fVar9);
        f fVar10 = new f();
        fVar10.f253081a = 10020;
        this.D.put(10020, fVar10);
        fVar10.f253082b = fVar5;
        fVar5.f253083c.add(fVar10);
        f fVar11 = new f();
        fVar11.f253081a = 10022;
        this.D.put(10022, fVar11);
        fVar11.f253082b = fVar5;
        fVar5.f253083c.add(fVar11);
        f fVar12 = new f();
        fVar12.f253081a = 10021;
        this.D.put(10021, fVar12);
        fVar12.f253082b = fVar5;
        fVar5.f253083c.add(fVar12);
        f fVar13 = new f();
        fVar13.f253081a = 10029;
        this.D.put(10029, fVar13);
        fVar13.f253082b = fVar5;
        fVar5.f253083c.add(fVar13);
        f fVar14 = new f();
        fVar14.f253081a = 10031;
        this.D.put(10031, fVar14);
        fVar14.f253082b = fVar5;
        fVar5.f253083c.add(fVar14);
        f fVar15 = new f();
        fVar15.f253081a = 10030;
        this.D.put(10030, fVar15);
        fVar15.f253082b = fVar5;
        fVar5.f253083c.add(fVar15);
        f fVar16 = new f();
        fVar16.f253081a = 10023;
        fVar16.f253082b = fVar5;
        this.D.put(10023, fVar16);
        fVar5.f253083c.add(fVar16);
        f fVar17 = new f();
        fVar17.f253081a = 10024;
        fVar17.f253082b = fVar5;
        this.D.put(10024, fVar17);
        fVar5.f253083c.add(fVar17);
        f fVar18 = new f();
        fVar18.f253081a = 10025;
        fVar18.f253082b = fVar5;
        this.D.put(10025, fVar18);
        fVar5.f253083c.add(fVar18);
        f fVar19 = new f();
        fVar19.f253081a = 10026;
        fVar19.f253082b = fVar5;
        this.D.put(10026, fVar19);
        fVar5.f253083c.add(fVar19);
        f fVar20 = new f();
        fVar20.f253081a = 10027;
        fVar20.f253082b = fVar5;
        this.D.put(10027, fVar20);
        fVar5.f253083c.add(fVar20);
        f fVar21 = new f();
        fVar21.f253081a = 10028;
        fVar21.f253082b = fVar5;
        this.D.put(10028, fVar21);
        fVar5.f253083c.add(fVar21);
        f fVar22 = new f();
        fVar22.f253081a = -2;
        fVar22.f253082b = this.C;
        this.D.put(-2, fVar22);
        this.C.f253083c = Arrays.asList(fVar3, fVar22);
        fVar22.f253083c = new ArrayList();
        f fVar23 = new f();
        fVar23.f253081a = BusinessInfoCheckUpdateItem.UIAPPID_NEARBY;
        this.D.put(Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY), fVar23);
        fVar23.f253082b = fVar22;
        fVar22.f253083c.add(fVar23);
        f fVar24 = new f();
        fVar24.f253081a = 10011;
        fVar24.f253082b = fVar23;
        this.D.put(10011, fVar24);
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar24);
        fVar23.f253083c = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f fVar25 = new f();
        fVar25.f253081a = BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_VISITOR;
        fVar25.f253082b = fVar24;
        this.D.put(Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_VISITOR), fVar25);
        arrayList2.add(fVar25);
        f fVar26 = new f();
        fVar26.f253081a = BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_RANKING;
        fVar26.f253082b = fVar24;
        this.D.put(Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_RANKING), fVar26);
        arrayList2.add(fVar26);
        fVar24.f253083c = arrayList2;
        f fVar27 = new f();
        fVar27.f253081a = -5;
        fVar27.f253082b = fVar22;
        fVar22.f253083c.add(fVar27);
        fVar27.f253083c = new ArrayList();
        this.D.put(Integer.valueOf(fVar27.f253081a), fVar27);
        f fVar28 = new f();
        fVar28.f253081a = -6;
        fVar28.f253082b = fVar22;
        fVar22.f253083c.add(fVar28);
        fVar28.f253083c = new ArrayList();
        this.D.put(Integer.valueOf(fVar28.f253081a), fVar28);
        f fVar29 = new f();
        fVar29.f253081a = 10014;
        fVar29.f253082b = fVar28;
        fVar28.f253083c.add(fVar29);
        this.D.put(Integer.valueOf(fVar29.f253081a), fVar29);
        f fVar30 = new f();
        fVar30.f253081a = 10013;
        fVar30.f253082b = fVar22;
        fVar22.f253083c.add(fVar30);
        this.D.put(Integer.valueOf(fVar30.f253081a), fVar30);
        f fVar31 = new f();
        fVar31.f253081a = 10032;
        this.D.put(10032, fVar31);
        fVar31.f253082b = fVar5;
        fVar5.f253083c.add(fVar31);
    }

    private void l(RedTouchItem redTouchItem, boolean z16) {
        boolean z17 = false;
        boolean z18 = true;
        if (QLog.isColorLevel()) {
            QLog.d("LocalRedTouchManager", 2, String.format(Locale.getDefault(), "handleRedPoint item=%s saveToFile=%s", redTouchItem, Boolean.valueOf(z16)));
        }
        RedPointConfig redPointConfig = this.f253044m.get(Integer.valueOf(redTouchItem.taskId));
        if (redPointConfig != null) {
            this.G.b(redTouchItem, redPointConfig.redPointId);
            RedTouchItem j3 = j(redPointConfig.redPointId);
            if (j3 != null) {
                RedPointConfig redPointConfig2 = this.f253044m.get(Integer.valueOf(j3.taskId));
                if (redPointConfig2 != null && redPointConfig2.priority > redPointConfig.priority && j3.unReadFlag) {
                    if (QLog.isColorLevel()) {
                        QLog.i("LocalRedTouchManager", 2, "handleRedPoint, ignore lower priority");
                    }
                } else {
                    z17 = true;
                }
                z18 = z17;
            }
            if (z18 && this.D.containsKey(Integer.valueOf(redPointConfig.redPointId))) {
                RedTouchItem redTouchItem2 = this.E.get(Integer.valueOf(redPointConfig.redPointId));
                if (redTouchItem2 != null && redTouchItem2.unReadFlag && redTouchItem2.redtouchType == 2 && redTouchItem.redtouchType == 2) {
                    redTouchItem.count += redTouchItem2.count;
                }
                redTouchItem.passThroughLevel = redPointConfig.passThroughLevel;
                this.E.put(Integer.valueOf(redPointConfig.redPointId), redTouchItem);
                F(redPointConfig.redPointId);
                if (z16) {
                    B();
                }
            }
        }
    }

    private boolean m() {
        boolean z16;
        synchronized (this.f253041f) {
            z16 = this.f253040e;
        }
        return z16;
    }

    private void n() {
        ConcurrentHashMap concurrentHashMap;
        if (this.f253040e) {
            return;
        }
        i();
        ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) FileUtils.readObject("red_point_configs_" + this.f253039d.getCurrentAccountUin());
        if (concurrentHashMap2 != null) {
            this.f253044m.clear();
            this.f253044m.putAll(concurrentHashMap2);
        }
        try {
            concurrentHashMap = (ConcurrentHashMap) FileUtils.readObject("red_point_info_" + this.f253039d.getCurrentAccountUin());
        } catch (Throwable th5) {
            QLog.d("LocalRedTouchManager", 1, th5.getMessage(), th5);
            concurrentHashMap = null;
        }
        if (concurrentHashMap != null) {
            this.E.clear();
            this.E.putAll(concurrentHashMap);
        }
        synchronized (this.f253041f) {
            this.f253040e = true;
        }
    }

    private boolean o(RedTouchItem redTouchItem) {
        long currentTimeMillis = System.currentTimeMillis();
        if (redTouchItem == null || !redTouchItem.unReadFlag || redTouchItem.isClosed) {
            return true;
        }
        if (redTouchItem.validTimeRemained < 0) {
            return false;
        }
        int i3 = (int) ((currentTimeMillis - redTouchItem.receiveTime) / 1000);
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "isOutOfDate,remain:" + redTouchItem.validTimeRemained + " consume:" + i3);
        }
        if (i3 < redTouchItem.validTimeRemained) {
            return false;
        }
        if (redTouchItem.unReadFlag) {
            redTouchItem.unReadFlag = false;
            RedPointConfig redPointConfig = this.f253044m.get(Integer.valueOf(redTouchItem.taskId));
            if (redPointConfig != null) {
                F(redPointConfig.redPointId);
            }
            B();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (!m()) {
            n();
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.f253044m);
        if (concurrentHashMap.size() > 0) {
            QLog.d("LocalRedTouchManager", 1, "pullRedPointInfo using config");
            ArrayList arrayList = new ArrayList();
            for (Integer num : concurrentHashMap.keySet()) {
                RedPointConfig redPointConfig = (RedPointConfig) concurrentHashMap.get(num);
                RedTouchItem j3 = j(redPointConfig.redPointId);
                cmd0x6cd$PullRedpointReq cmd0x6cd_pullredpointreq = new cmd0x6cd$PullRedpointReq();
                cmd0x6cd_pullredpointreq.uint32_taskid.set(num.intValue());
                if (j3 != null) {
                    cmd0x6cd_pullredpointreq.uint64_last_pull_seq.set(j3.curSeq);
                } else {
                    cmd0x6cd_pullredpointreq.uint64_last_pull_seq.set(0L);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("LocalRedTouchManager", 2, String.format("pullRedPointInfo. addPull, taskId=%d seq=%d redpointId=%d pLevel=%d bLevel=%d", num, Long.valueOf(cmd0x6cd_pullredpointreq.uint64_last_pull_seq.get()), Integer.valueOf(redPointConfig.redPointId), Integer.valueOf(redPointConfig.passThroughLevel), Integer.valueOf(redPointConfig.bindLevel)));
                }
                arrayList.add(cmd0x6cd_pullredpointreq);
            }
            if (arrayList.size() > 0) {
                ((RedtouchHandler) this.f253039d.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).H2(arrayList, false);
                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.f253039d.getAccount(), "pull_red_touch_time2", Long.valueOf(SystemClock.elapsedRealtime()));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "pull config on null");
        }
        ((RedtouchHandler) this.f253039d.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).D2();
    }

    public void A(cmd0x6f5$RspBody cmd0x6f5_rspbody) {
        PBRepeatMessageField<cmd0x6f5$TaskInfo> pBRepeatMessageField;
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs");
        }
        if (!m()) {
            n();
        }
        StringBuilder sb5 = new StringBuilder();
        if (cmd0x6f5_rspbody != null && (pBRepeatMessageField = cmd0x6f5_rspbody.rpt_task_info) != null && pBRepeatMessageField.has()) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            List<cmd0x6f5$TaskInfo> list = cmd0x6f5_rspbody.rpt_task_info.get();
            for (cmd0x6f5$TaskInfo cmd0x6f5_taskinfo : list) {
                RedPointConfig redPointConfig = new RedPointConfig();
                redPointConfig.taskId = cmd0x6f5_taskinfo.uint32_task_id.get();
                redPointConfig.redPointId = cmd0x6f5_taskinfo.uint32_appid.get();
                redPointConfig.passThroughLevel = cmd0x6f5_taskinfo.uint32_passthrough_level.get();
                redPointConfig.bindLevel = cmd0x6f5_taskinfo.uint32_show_level.get();
                redPointConfig.priority = cmd0x6f5_taskinfo.uint32_priority.get();
                concurrentHashMap.put(Integer.valueOf(redPointConfig.taskId), redPointConfig);
                if (QLog.isColorLevel()) {
                    sb5.append("\n");
                    sb5.append(redPointConfig.toString());
                }
            }
            this.f253044m.clear();
            this.f253044m.putAll(concurrentHashMap);
            if (QLog.isColorLevel()) {
                QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs, config size = " + list.size() + " " + sb5.toString());
            }
            FileUtils.writeObject("red_point_configs_" + this.f253039d.getCurrentAccountUin(), concurrentHashMap);
        }
    }

    public void B() {
        if (this.f253042h.hasMessages(0)) {
            this.f253042h.removeMessages(0);
        }
        this.f253042h.sendEmptyMessage(0);
    }

    public void D(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "setRedPointConfigVersion, version = " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f253043i = str;
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.f253039d.getAccount(), "red_point_config_version", str);
        }
    }

    public boolean b(int i3, boolean z16) {
        return d(j(i3), z16);
    }

    public boolean c(RedTouchItem redTouchItem) {
        boolean z16;
        if (redTouchItem == null || !redTouchItem.unReadFlag) {
            return false;
        }
        if (redTouchItem.validTimeRemained < 0 || ((int) ((System.currentTimeMillis() - redTouchItem.receiveTime) / 1000)) < redTouchItem.validTimeRemained) {
            z16 = true;
        } else {
            redTouchItem.unReadFlag = false;
            RedPointConfig redPointConfig = this.f253044m.get(Integer.valueOf(redTouchItem.taskId));
            if (redPointConfig != null) {
                F(redPointConfig.redPointId);
            }
            B();
            z16 = false;
        }
        if (redTouchItem.redtouchType == 2) {
            if (!z16 || redTouchItem.count <= 0) {
                return false;
            }
            return true;
        }
        return z16;
    }

    public boolean d(RedTouchItem redTouchItem, boolean z16) {
        boolean z17;
        if (redTouchItem != null && redTouchItem.unReadFlag && !redTouchItem.isClosed && (z16 || !o(redTouchItem))) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (redTouchItem != null && redTouchItem.redtouchType == 2) {
            if (z17 && redTouchItem.count > 0) {
                return true;
            }
            return false;
        }
        return z17;
    }

    public boolean e(RedTouchItem redTouchItem) {
        if (redTouchItem != null && redTouchItem.unReadFlag && !o(redTouchItem)) {
            return true;
        }
        return false;
    }

    public void f(int i3) {
        RedTouchItem redTouchItem;
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "clearParentsButSelf, redPointId=" + i3);
        }
        ConcurrentHashMap<Integer, RedTouchItem> concurrentHashMap = this.E;
        if (concurrentHashMap != null && (redTouchItem = concurrentHashMap.get(Integer.valueOf(i3))) != null && redTouchItem.unReadFlag && redTouchItem.passThroughLevel > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("LocalRedTouchManager", 2, "rt=" + redTouchItem.toString());
            }
            redTouchItem.unReadFlag = false;
            F(i3);
            redTouchItem.passThroughLevel = 0;
            redTouchItem.unReadFlag = true;
            B();
            if (this.f253042h.hasMessages(1)) {
                this.f253042h.removeMessages(1);
            }
            this.f253042h.sendEmptyMessage(1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if (r0.curSeq > r1.curSeq) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int h() {
        byte[] bArr;
        RedTouchItem j3 = j(10016);
        RedTouchItem j16 = j(10015);
        int i3 = 3;
        if (j3 == null || j16 == null) {
            if (j3 == null) {
                if (j16 == null) {
                    j3 = null;
                    i3 = 1;
                }
                j3 = j16;
            }
            i3 = 4;
        }
        if (j3 != null && (bArr = j3.bytes) != null && bArr.length > 0) {
            try {
                return new JSONObject(new String(bArr, "utf-8")).optInt("type", 1);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("LocalRedTouchManager", 2, e16, new Object[0]);
                    return i3;
                }
                return i3;
            }
        }
        return i3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                ((IRedTouchServer) this.f253039d.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f253039d);
            }
        } else {
            C();
        }
        return false;
    }

    public String i() {
        if (this.f253043i == null) {
            this.f253043i = (String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f253039d.getAccount(), "red_point_config_version", "");
        }
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "getRedPointConfigVersion, version = " + this.f253043i);
        }
        return this.f253043i;
    }

    public RedTouchItem j(int i3) {
        RedTouchItem redTouchItem;
        ConcurrentHashMap<Integer, RedTouchItem> concurrentHashMap = this.E;
        if (concurrentHashMap != null) {
            redTouchItem = concurrentHashMap.get(Integer.valueOf(i3));
        } else {
            redTouchItem = null;
        }
        QLog.isColorLevel();
        return redTouchItem;
    }

    public void k() {
        if (this.F.size() > 0) {
            Iterator<RedTouchItem> it = this.F.iterator();
            while (it.hasNext()) {
                l(it.next(), false);
            }
            C();
            this.G.a(this.F);
            this.F.clear();
            ((IRedTouchServer) this.f253039d.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f253039d);
        }
    }

    public void p(List<RedTouchItem> list, boolean z16) {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onGetRedPointInfo, list size=");
        if (list == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(list.size());
        }
        sb5.append(valueOf);
        sb5.append(", hasMore=");
        sb5.append(z16);
        QLog.i("LocalRedTouchManager", 1, sb5.toString());
        if (list != null && list.size() != 0) {
            this.F.addAll(list);
            if (!z16) {
                for (int size = this.F.size() - 1; size >= 0; size--) {
                    if (this.F.get(size).taskId == 10001) {
                        this.F.remove(size);
                    }
                }
                if (list.get(0).configVersion.equals(this.f253043i)) {
                    k();
                } else {
                    ((RedtouchHandler) this.f253039d.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).D2();
                }
            }
        }
    }

    public void q(short s16) {
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "onGetUnreadRedTouchFlag: " + ((int) s16));
        }
        long longValue = ((Long) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f253039d.getAccount(), "pull_red_touch_time2", (Object) 0L)).longValue();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (s16 > 0 || elapsedRealtime - longValue > 43200000) {
            z();
        }
    }

    public void r(byte[] bArr) {
        int i3;
        QLog.i("LocalRedTouchManager", 1, "onLinePush");
        if (!m()) {
            n();
        }
        cmd0x6cd$RedpointInfo cmd0x6cd_redpointinfo = new cmd0x6cd$RedpointInfo();
        try {
            cmd0x6cd_redpointinfo.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        RedTouchItem redTouchItem = RedTouchItem.getRedTouchItem(cmd0x6cd_redpointinfo);
        if (redTouchItem == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            RedPointConfig redPointConfig = this.f253044m.get(Integer.valueOf(redTouchItem.taskId));
            if (redPointConfig == null) {
                i3 = 0;
            } else {
                i3 = redPointConfig.redPointId;
            }
            QLog.i("LocalRedTouchManager", 2, String.format("onLinePush item:%s appid=%d version=%s", redTouchItem, Integer.valueOf(i3), this.f253043i));
        }
        if (cmd0x6cd_redpointinfo.str_config_version.get().equals(this.f253043i)) {
            l(redTouchItem, true);
            ((IRedTouchServer) this.f253039d.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f253039d);
            this.G.a(Collections.singletonList(redTouchItem));
        } else {
            this.F.add(redTouchItem);
            ((RedtouchHandler) this.f253039d.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).D2();
        }
    }

    public void s(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "onProfileRedTouchClick, isFromFriendElseNearby:" + z16);
        }
        u(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST);
        if (z16) {
            f(10016);
            f(10015);
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f253039d.getRuntimeService(IRedTouchManager.class, "");
        if (iRedTouchManager == null) {
            return;
        }
        iRedTouchManager.dismissRedTouch("100510");
        iRedTouchManager.dismissRedTouch("100460");
        u(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY);
        u(-7);
    }

    public void t(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "onRedPointChanged redPointId:" + i3);
        }
        F(i3);
        B();
        if (this.f253042h.hasMessages(1)) {
            this.f253042h.removeMessages(1);
        }
        this.f253042h.sendEmptyMessage(1);
    }

    public void u(int i3) {
        w(i3, false, 0L, false, true);
    }

    public void v(int i3, boolean z16) {
        w(i3, false, 0L, false, z16);
    }

    public void w(int i3, boolean z16, long j3, boolean z17, boolean z18) {
        RedTouchItem redTouchItem;
        boolean z19;
        if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "onRedPointClick, redPointId=" + i3 + ", bCustom=" + z16 + ", customSeq=" + j3 + ", customReadFlag=" + z17 + ", bReport=" + z18);
        }
        ConcurrentHashMap<Integer, RedTouchItem> concurrentHashMap = this.E;
        if (concurrentHashMap != null && (redTouchItem = concurrentHashMap.get(Integer.valueOf(i3))) != null && redTouchItem.unReadFlag) {
            if (QLog.isColorLevel()) {
                QLog.d("LocalRedTouchManager", 2, "rt=" + redTouchItem.toString());
            }
            if (z16 && z17) {
                z19 = true;
            } else {
                z19 = false;
            }
            redTouchItem.unReadFlag = z19;
            if (QLog.isColorLevel()) {
                QLog.d("LocalRedTouchManager", 2, "rt.unReadFlag set to " + redTouchItem.unReadFlag);
            }
            F(i3);
            B();
            if (this.f253042h.hasMessages(1)) {
                this.f253042h.removeMessages(1);
            }
            this.f253042h.sendEmptyMessage(1);
            if (z18) {
                cmd0x6ce$ReadRedpointReq cmd0x6ce_readredpointreq = new cmd0x6ce$ReadRedpointReq();
                cmd0x6ce_readredpointreq.uint32_appid.set(i3);
                if (z16) {
                    cmd0x6ce_readredpointreq.uint64_read_seq.set(j3);
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(cmd0x6ce_readredpointreq);
                ((RedtouchHandler) this.f253039d.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).I2(arrayList);
            }
        }
    }

    public void z() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager.1
            @Override // java.lang.Runnable
            public void run() {
                LocalRedTouchManager.this.y();
            }
        }, 64, null, true);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }

    public void x(int i3) {
    }
}
