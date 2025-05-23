package com.qzone.homepage.diy.util;

import FACADE_DIY.BatchGetFacadeRsp;
import FACADE_DIY.GetFacadeReqExt;
import FACADE_DIY.UserFacadeInfo;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.homepage.diy.protocol.QzoneDIYData;
import com.qzone.homepage.diy.protocol.QzoneDIYRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDIYData;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.MonitorManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDIYService extends Observable implements IQZoneServiceListener {

    /* renamed from: h, reason: collision with root package name */
    private static QzoneDIYService f47533h;

    /* renamed from: e, reason: collision with root package name */
    private String f47535e;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Long, QzoneDIYData> f47534d = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final a f47536f = new a("TABLE_QZONE_DIY", QzoneDIYData.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        long f47542a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f47543b;

        /* renamed from: c, reason: collision with root package name */
        String f47544c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f47545d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f47546e = new C0391a();

        /* compiled from: P */
        /* renamed from: com.qzone.homepage.diy.util.QzoneDIYService$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0391a implements a.InterfaceC10828a {
            C0391a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("QzoneDIYService", 4, "DbCacheManager onClosed PersonalFontService table:" + a.this.f47544c);
                }
                a aVar2 = a.this;
                aVar2.f47542a = 0L;
                aVar2.f47543b = null;
            }
        }

        public a(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f47544c = str;
            this.f47545d = cls;
        }
    }

    public static QzoneDIYService L() {
        if (f47533h == null) {
            synchronized (QzoneDIYService.class) {
                if (f47533h == null) {
                    f47533h = new QzoneDIYService();
                }
            }
        }
        return f47533h;
    }

    public boolean G(long j3) {
        QzoneDIYData qzoneDIYData = this.f47534d.get(Long.valueOf(j3));
        if (qzoneDIYData != null) {
            if (!TextUtils.isEmpty(qzoneDIYData.layout)) {
                return true;
            }
            this.f47534d.remove(Long.valueOf(j3));
            return false;
        }
        O(j3);
        return false;
    }

    public void H(final long j3) {
        if (QZLog.isDevelopLevel()) {
            QZLog.i("QzoneDIYService", 4, "cleanDIYData uin = " + j3);
        }
        this.f47534d.remove(Long.valueOf(j3));
        VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.homepage.diy.util.QzoneDIYService.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (QzoneDIYService.this.f47536f) {
                    QzoneDIYService qzoneDIYService = QzoneDIYService.this;
                    qzoneDIYService.I(qzoneDIYService.f47536f);
                    if (QzoneDIYService.this.f47536f.f47543b == null) {
                        return;
                    }
                    QzoneDIYService.this.f47536f.f47543b.b0("uin=?", new String[]{j3 + ""});
                }
            }
        });
    }

    public QzoneDIYData J(long j3) {
        QzoneDIYData qzoneDIYData = this.f47534d.get(Long.valueOf(j3));
        if (qzoneDIYData != null) {
            return qzoneDIYData;
        }
        O(j3);
        return null;
    }

    public String K() {
        return this.f47535e;
    }

    public void N() {
        if (TextUtils.isEmpty(this.f47535e)) {
            this.f47535e = LocalMultiProcConfig.getString(LocalMultiProcConfig.QZONE_DIY_JUMP_URL, "");
        }
    }

    public void O(final long j3) {
        if (this.f47534d.get(Long.valueOf(j3)) != null) {
            return;
        }
        VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.homepage.diy.util.QzoneDIYService.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (QzoneDIYService.this.f47536f) {
                    QzoneDIYService qzoneDIYService = QzoneDIYService.this;
                    qzoneDIYService.I(qzoneDIYService.f47536f);
                    if (QzoneDIYService.this.f47536f.f47543b == null) {
                        return;
                    }
                    DbCacheManager dbCacheManager = QzoneDIYService.this.f47536f.f47543b;
                    dbCacheManager.r0("uin=?");
                    dbCacheManager.t0(new String[]{"" + j3});
                    QzoneDIYData qzoneDIYData = (QzoneDIYData) dbCacheManager.k0("uin=?", new String[]{"" + j3});
                    if (qzoneDIYData != null) {
                        QzoneDIYService.this.f47534d.put(Long.valueOf(j3), qzoneDIYData);
                    }
                    QzoneDIYService.this.N();
                }
            }
        });
    }

    public void P(final long j3) {
        if (QZLog.isDevelopLevel()) {
            QZLog.i("QzoneDIYService", 4, "requestDIYData uin = " + j3);
        }
        VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.homepage.diy.util.QzoneDIYService.2
            @Override // java.lang.Runnable
            public void run() {
                if (!QzoneDIYService.this.f47534d.containsKey(Long.valueOf(j3))) {
                    synchronized (QzoneDIYService.this.f47536f) {
                        QzoneDIYService qzoneDIYService = QzoneDIYService.this;
                        qzoneDIYService.I(qzoneDIYService.f47536f);
                        if (QzoneDIYService.this.f47536f.f47543b == null) {
                            return;
                        }
                        DbCacheManager dbCacheManager = QzoneDIYService.this.f47536f.f47543b;
                        dbCacheManager.r0("uin=?");
                        dbCacheManager.t0(new String[]{"" + j3});
                        QzoneDIYData qzoneDIYData = (QzoneDIYData) dbCacheManager.k0("uin=?", new String[]{"" + j3});
                        if (qzoneDIYData != null) {
                            QzoneDIYService.this.f47534d.put(Long.valueOf(j3), qzoneDIYData);
                        }
                    }
                }
                QzoneDIYData qzoneDIYData2 = (QzoneDIYData) QzoneDIYService.this.f47534d.get(Long.valueOf(j3));
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(j3));
                HashMap hashMap = new HashMap();
                if (qzoneDIYData2 != null) {
                    GetFacadeReqExt getFacadeReqExt = new GetFacadeReqExt();
                    getFacadeReqExt.cachedChecksum = qzoneDIYData2.checksum;
                    if (TextUtils.isEmpty(qzoneDIYData2.layout)) {
                        getFacadeReqExt.cachedChecksum = "";
                    }
                    hashMap.put(Long.valueOf(j3), getFacadeReqExt);
                }
                QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneDIYRequest(arrayList, hashMap), null, QzoneDIYService.this, 1));
            }
        });
    }

    public void R(String str) {
        if (QZLog.isColorLevel()) {
            QZLog.i("QzoneDIYService", 2, " saveJumpUrl = " + str);
        }
        LocalMultiProcConfig.putString(LocalMultiProcConfig.QZONE_DIY_JUMP_URL, str);
        this.f47535e = str;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 1) {
            return;
        }
        M(qZoneTask);
    }

    private void M(QZoneTask qZoneTask) {
        JceStruct jceStruct;
        QZoneResult result = qZoneTask.getResult(1);
        if (result != null && result.getReturnCode() == 0) {
            QZoneRequest qZoneRequest = qZoneTask.mRequest;
            if ((qZoneRequest instanceof QzoneDIYRequest) && (jceStruct = ((QzoneDIYRequest) qZoneRequest).rsp) != null && (jceStruct instanceof BatchGetFacadeRsp)) {
                BatchGetFacadeRsp batchGetFacadeRsp = (BatchGetFacadeRsp) jceStruct;
                Map<Long, UserFacadeInfo> map = batchGetFacadeRsp.info;
                HashMap hashMap = new HashMap(map.size());
                for (Map.Entry<Long, UserFacadeInfo> entry : map.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        hashMap.put(entry.getKey(), QzoneDIYData.createQzoneDIYData(entry.getKey().longValue(), entry.getValue()));
                    }
                }
                R(batchGetFacadeRsp.jumpUrl);
                Q(hashMap);
                return;
            }
            return;
        }
        MonitorManager.f().h(24, 3, "request diy data code != 0", false);
        QZLog.e("QzoneDIYService", 1, "handleDIYData   fail code:" + qZoneTask.mResultCode);
    }

    public void Q(final Map<Long, QzoneDIYData> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.homepage.diy.util.QzoneDIYService.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (QzoneDIYService.this.f47536f) {
                    QzoneDIYService qzoneDIYService = QzoneDIYService.this;
                    qzoneDIYService.I(qzoneDIYService.f47536f);
                    if (QzoneDIYService.this.f47536f.f47543b == null) {
                        return;
                    }
                    DbCacheManager dbCacheManager = QzoneDIYService.this.f47536f.f47543b;
                    for (Map.Entry entry : map.entrySet()) {
                        if (entry != null && entry.getValue() != null) {
                            QzoneDIYData qzoneDIYData = (QzoneDIYData) entry.getValue();
                            if (QZLog.isColorLevel()) {
                                QZLog.i("QzoneDIYService", 2, qzoneDIYData.toString());
                            }
                            if (qzoneDIYData.code != -25012) {
                                c7.a.c().d(qzoneDIYData);
                                QzoneDIYService.this.f47534d.put((Long) entry.getKey(), (QzoneDIYData) entry.getValue());
                                dbCacheManager.r0("uin=?");
                                dbCacheManager.t0(new String[]{"" + qzoneDIYData.uin});
                                dbCacheManager.o0(qzoneDIYData, 2);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(a aVar) {
        DbCacheManager dbCacheManager;
        if (aVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != aVar.f47542a || (dbCacheManager = aVar.f47543b) == null || dbCacheManager.isClosed()) {
            aVar.f47542a = uin;
            DbCacheManager e16 = c.g().e(aVar.f47545d, uin, aVar.f47544c);
            aVar.f47543b = e16;
            e16.U(aVar.f47546e);
        }
    }

    public void F(ArrayList<BusinessFeedData> arrayList) {
        CellDIYData cellDIYData;
        if (arrayList == null) {
            return;
        }
        final HashMap hashMap = new HashMap(arrayList.size());
        Iterator<BusinessFeedData> it = arrayList.iterator();
        while (it.hasNext()) {
            BusinessFeedData next = it.next();
            if (next != null && (cellDIYData = next.cellDIYData) != null) {
                hashMap.put(Long.valueOf(cellDIYData.uin), next.cellDIYData);
            }
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.homepage.diy.util.QzoneDIYService.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap2 = new HashMap();
                Iterator it5 = hashMap.entrySet().iterator();
                while (it5.hasNext()) {
                    CellDIYData cellDIYData2 = (CellDIYData) ((Map.Entry) it5.next()).getValue();
                    if (cellDIYData2 != null) {
                        if (QZLog.isDevelopLevel()) {
                            QZLog.i("QzoneDIYService", 4, "batchRequestDIYData cellDIYData = " + cellDIYData2.toString() + " uin = " + cellDIYData2.uin);
                        }
                        if (cellDIYData2.iEnable != -1) {
                            long j3 = cellDIYData2.uin;
                            if (j3 <= 0) {
                                continue;
                            } else {
                                if (!QzoneDIYService.this.f47534d.containsKey(Long.valueOf(j3))) {
                                    synchronized (QzoneDIYService.this.f47536f) {
                                        QzoneDIYService qzoneDIYService = QzoneDIYService.this;
                                        qzoneDIYService.I(qzoneDIYService.f47536f);
                                        if (QzoneDIYService.this.f47536f.f47543b == null) {
                                            return;
                                        }
                                        DbCacheManager dbCacheManager = QzoneDIYService.this.f47536f.f47543b;
                                        dbCacheManager.r0("uin=?");
                                        dbCacheManager.t0(new String[]{"" + j3});
                                        QzoneDIYData qzoneDIYData = (QzoneDIYData) dbCacheManager.k0("uin=?", new String[]{"" + j3});
                                        if (qzoneDIYData != null) {
                                            QzoneDIYService.this.f47534d.put(Long.valueOf(j3), qzoneDIYData);
                                        }
                                    }
                                }
                                arrayList2.add(Long.valueOf(j3));
                                QzoneDIYData qzoneDIYData2 = (QzoneDIYData) QzoneDIYService.this.f47534d.get(Long.valueOf(j3));
                                if (qzoneDIYData2 != null) {
                                    GetFacadeReqExt getFacadeReqExt = new GetFacadeReqExt();
                                    getFacadeReqExt.cachedChecksum = qzoneDIYData2.checksum;
                                    if (TextUtils.isEmpty(qzoneDIYData2.layout)) {
                                        getFacadeReqExt.cachedChecksum = "";
                                    }
                                    hashMap2.put(Long.valueOf(j3), getFacadeReqExt);
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
                QZLog.i("QzoneDIYService", 1, "batchRequestDIYData QzoneDIYRequest size = " + arrayList2.size());
                if (arrayList2.size() > 0) {
                    QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneDIYRequest(arrayList2, hashMap2), null, QzoneDIYService.this, 1));
                }
            }
        });
    }
}
