package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.tianshu.TianshuConstants$RedDataChangeState;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.tianshu.event.TianshuRedDataChangeEvent;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.ad.i;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89$NumRedBusiInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RedTouchManager extends Observable implements Manager {
    static IPatchRedirector $redirector_;
    private static AtomicInteger E;
    private static Object F;
    private static final Object G;
    private static Boolean H;
    private static final List<String> I;
    private long C;
    private HashMap<Integer, Boolean> D;

    /* renamed from: d, reason: collision with root package name */
    protected AppInterface f280254d;

    /* renamed from: e, reason: collision with root package name */
    private RedTouchLifeTimeManager f280255e;

    /* renamed from: f, reason: collision with root package name */
    private BusinessInfoCheckUpdate.TimeRspBody f280256f;

    /* renamed from: h, reason: collision with root package name */
    private int f280257h;

    /* renamed from: i, reason: collision with root package name */
    private int f280258i;

    /* renamed from: m, reason: collision with root package name */
    private String f280259m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 64)) {
            redirector.redirect((short) 64);
            return;
        }
        E = new AtomicInteger();
        F = new Object();
        G = new Object();
        H = null;
        I = Arrays.asList("4050.0", "4038.0");
    }

    public RedTouchManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        this.f280257h = 0;
        this.f280258i = 0;
        this.f280254d = appInterface;
        this.f280255e = RedTouchLifeTimeManager.e();
    }

    private List<String> A0(List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        boolean z16;
        if (list3.size() >= 1) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                String str = list.get(i3);
                if (!list4.contains(str)) {
                    list2.add(str);
                    break;
                }
                int i16 = 0;
                while (true) {
                    if (i16 < list3.size()) {
                        if (str.equals(list3.get(i16))) {
                            z16 = true;
                            break;
                        }
                        i16++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    list2.add(str);
                }
                i3++;
            }
            return list2;
        }
        return list;
    }

    private int B(int i3, int i16) {
        List<BusinessInfoCheckUpdate.NumRedPath> list;
        synchronized (G) {
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            int i17 = 0;
            if (A != null && A.rptMsgNumRedInfo.has()) {
                List<BusinessInfoCheckUpdate.NumRedInfo> list2 = A.rptMsgNumRedInfo.get();
                if (list2 == null) {
                    h0("getNumFromFileByPathAndType : numRedBusiList is null");
                    return 0;
                }
                for (BusinessInfoCheckUpdate.NumRedInfo numRedInfo : list2) {
                    if (numRedInfo.appid.get() == i3 && (list = numRedInfo.num_red_path.get()) != null) {
                        for (BusinessInfoCheckUpdate.NumRedPath numRedPath : list) {
                            if (100 == i16) {
                                if (numRedPath.uint32_msg_status.get() != 0 && 1 != numRedPath.uint32_msg_status.get()) {
                                }
                                i17++;
                            } else if (numRedPath.uint32_msg_status.get() == i16) {
                                i17++;
                            }
                        }
                    }
                }
            }
            return i17;
        }
    }

    private void B0(String str, List<String> list, List<String> list2) {
        JSONObject jSONObject;
        int i3;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.has("msg")) {
                    jSONObject = jSONObject2.getJSONObject("msg");
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        new JSONObject();
                        String str2 = (String) keys.next();
                        JSONObject jSONObject3 = jSONObject.getJSONObject(str2);
                        if (jSONObject3.has("stat")) {
                            i3 = jSONObject3.getInt("stat");
                        } else {
                            i3 = -1;
                        }
                        list2.add(str2);
                        if (i3 == 1) {
                            list.add(str2);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private int C(String str, int i3) {
        synchronized (G) {
            int i16 = 0;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            if (A != null && A.rptMsgNumRedInfo.has()) {
                List<BusinessInfoCheckUpdate.NumRedInfo> list = A.rptMsgNumRedInfo.get();
                if (list == null) {
                    h0("getNumFromFileByPathAndType : numRedBusiList is null");
                    return 0;
                }
                Iterator<BusinessInfoCheckUpdate.NumRedInfo> it = list.iterator();
                while (it.hasNext()) {
                    List<BusinessInfoCheckUpdate.NumRedPath> list2 = it.next().num_red_path.get();
                    if (list2 != null) {
                        for (BusinessInfoCheckUpdate.NumRedPath numRedPath : list2) {
                            if (numRedPath.str_path.get().equals(str)) {
                                if (100 == i3) {
                                    if (numRedPath.uint32_msg_status.get() != 0 && 1 != numRedPath.uint32_msg_status.get()) {
                                    }
                                    i16++;
                                } else if (numRedPath.uint32_msg_status.get() == i3) {
                                    i16++;
                                }
                            }
                        }
                    }
                }
            }
            return i16;
        }
    }

    private BusinessInfoCheckUpdate.NumRedInfo D(int i3) {
        BusinessInfoCheckUpdate.NumRedInfo numRedInfo;
        synchronized (G) {
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            if (A != null && A.rptMsgNumRedInfo.has()) {
                List<BusinessInfoCheckUpdate.NumRedInfo> list = A.rptMsgNumRedInfo.get();
                if (list == null) {
                    h0("getNumRedShowNumByAppSet : numRedBusiList is null");
                    return null;
                }
                Iterator<BusinessInfoCheckUpdate.NumRedInfo> it = list.iterator();
                while (it.hasNext()) {
                    numRedInfo = it.next();
                    if (i3 == numRedInfo.appid.get()) {
                        break;
                    }
                }
            }
            numRedInfo = null;
            if (numRedInfo == null) {
                h0("getNumRedBusiInfoByAppId : cannot find the info by appid");
                return null;
            }
            return numRedInfo;
        }
    }

    private void D0(BusinessInfoCheckUpdate.AppInfo appInfo, int i3) {
        if (i3 == 6) {
            MobileReportManager.getInstance().reportRedpoint(appInfo, 102);
        } else if (i3 == 1) {
            MobileReportManager.getInstance().reportRedpoint(appInfo, 101);
        }
    }

    private BusinessInfoCheckUpdate.AppInfo K(String str) {
        if (TextUtils.isEmpty(str)) {
            h0("getRedTouchAppInfoByPath: input path is Empty");
            return null;
        }
        BusinessInfoCheckUpdate.TimeRspBody A = A();
        if (A != null && A.rptMsgAppInfo.has()) {
            synchronized (G) {
                for (BusinessInfoCheckUpdate.AppInfo appInfo : A.rptMsgAppInfo.get()) {
                    if (appInfo.path.get().equals(str)) {
                        h0("getRedTouchAppInfoByPath path = " + str + "inewflag = " + appInfo.iNewFlag.get());
                        return appInfo;
                    }
                }
                return m(str);
            }
        }
        h0("TimeRspBody is Empty or msgAppInfo is Empty path = " + str);
        return m(str);
    }

    private void N0(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, int i16, String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable(appInfo, str, i16, i3) { // from class: com.tencent.mobileqq.redtouch.RedTouchManager.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ BusinessInfoCheckUpdate.AppInfo f280269d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f280270e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f280271f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f280272h;

            {
                this.f280269d = appInfo;
                this.f280270e = str;
                this.f280271f = i16;
                this.f280272h = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, RedTouchManager.this, appInfo, str, Integer.valueOf(i16), Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f280269d == null) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("level", 0);
                    jSONObject.put("trace_id", this.f280270e);
                    RedTouchManager.this.M0(this.f280269d, null, this.f280271f, jSONObject.toString());
                    RedTouchManager.h0("level zero report appSet:" + this.f280272h + " reportType:" + this.f280271f + "appId:" + this.f280269d.uiAppId.get());
                } catch (JSONException e16) {
                    QLog.e("RedPointLog.RedTouchManager", 1, "level zero report JSONException ", e16);
                }
            }
        });
    }

    private BusinessInfoCheckUpdate.RedTypeInfo O(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.AppInfo appInfo, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2, String str) {
        if (redTypeInfo == null) {
            return redTypeInfo2;
        }
        try {
            if (QLog.isDevelopLevel()) {
                QLog.e("RedPointLog.RedTouchManager", 4, str + redTypeInfo.red_content.get() + ", path=" + appInfo.path.get() + ",redTypeInfoContent=" + redTypeInfo2.red_content.get());
            }
            redTypeInfo.red_content.set((Integer.parseInt(redTypeInfo.red_content.get()) + Integer.parseInt(redTypeInfo2.red_content.get())) + "");
            return redTypeInfo;
        } catch (NumberFormatException e16) {
            QLog.e("RedPointLog.RedTouchManager", 1, "error getRedTypeInfo " + e16);
            return redTypeInfo;
        }
    }

    private static BusinessInfoCheckUpdate.ReportStaticsData P(String str, String str2) {
        BusinessInfoCheckUpdate.ReportStaticsData reportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
        reportStaticsData.key.set(str);
        reportStaticsData.value.set(str2);
        return reportStaticsData;
    }

    private static List<BusinessInfoCheckUpdate.ReportStaticsData> Q(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    BusinessInfoCheckUpdate.ReportStaticsData reportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
                    reportStaticsData.key.set(str2);
                    reportStaticsData.value.set(jSONObject.getString(str2));
                    arrayList.add(reportStaticsData);
                }
            }
        } catch (Exception e16) {
            QLog.e("RedPointLog.RedTouchManager", 2, "getReportStaticsData parse json exception ", e16);
        }
        if (appInfo != null) {
            arrayList.add(P("version", String.valueOf(appInfo.version.get())));
            arrayList.add(P("hash", appInfo.hash.get()));
            arrayList.add(P(WidgetCacheConstellationData.NUM, String.valueOf(appInfo.num.get())));
            arrayList.add(P("redType", String.valueOf(appInfo.type.get())));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        byte[] fileToBytes;
        File file = new File(this.f280254d.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.f280254d.getCurrentAccountUin());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        synchronized (this) {
            fileToBytes = FileUtils.fileToBytes(file);
        }
        if (fileToBytes == null) {
            return;
        }
        BusinessInfoCheckUpdate.TimeRspBody timeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
        try {
            timeRspBody.mergeFrom(fileToBytes);
            synchronized (G) {
                this.f280256f = timeRspBody;
                X0(false, this.f280254d.getApp());
            }
        } catch (Exception e17) {
            h0("mergeFrom error " + e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(BusinessInfoCheckUpdate.ReportReqBody reportReqBody) {
        if (reportReqBody == null) {
            return;
        }
        if (!k(reportReqBody.cmd.get())) {
            RFWLog.d("RedPointLog.RedTouchManager", 1, "safeSendReq can not report, cmd:" + reportReqBody.cmd.get());
            return;
        }
        byte[] U0 = U0(reportReqBody);
        if (U0.length == 0) {
            RFWLog.fatal("RedPointLog.RedTouchManager", 1, "reportReqBody:appid" + reportReqBody.appid.get() + ", missionid:" + reportReqBody.missionid.get() + ", buff:" + reportReqBody.buffer.get() + ", platver:" + reportReqBody.platver.get() + ", clientver:" + reportReqBody.clientver.get() + ", extend:" + reportReqBody.extend.get(), new Exception("safeSendRedReq debug exception"));
            return;
        }
        ToServiceMsg q16 = q(RedTouchConst.Cmd.CMD_RED_TOUCH_CLIENT_REPORT);
        q16.putWupBuffer(U0);
        W0(q16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x004e, code lost:
    
        if (r1.rptMsgNumRedInfo.get().size() > 0) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void U(byte[] bArr, int i3) {
        QQAppInterface qQAppInterface;
        boolean z16;
        BusinessInfoCheckUpdate.TimeRspBody A;
        h0("handler after push");
        AppInterface appInterface = this.f280254d;
        if (appInterface instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) appInterface;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        BusinessInfoCheckUpdate.TimeRspBody timeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
        try {
            timeRspBody.mergeFrom(bArr);
            A = A();
            V(timeRspBody, A);
            W(timeRspBody, A);
        } catch (Exception e16) {
            e = e16;
            z16 = false;
        }
        if (timeRspBody.rptMsgAppInfo.get() == null || timeRspBody.rptMsgAppInfo.get().size() <= 0) {
            if (timeRspBody.rptMsgNumRedInfo.get() != null) {
            }
            z16 = false;
            if (A != null) {
                try {
                    h(A);
                } catch (Exception e17) {
                    e = e17;
                    QLog.e("RedPointLog.RedTouchManager", 1, "TimeRspBody handle push exception " + e);
                    if (z16) {
                    }
                }
            }
            if (z16) {
                QLog.d("RedPointLog.RedTouchManager", 1, "has push data ");
                synchronized (G) {
                    K0(A());
                }
                SimpleEventBus.getInstance().dispatchEvent(new TianshuRedDataChangeEvent(com.tencent.mobileqq.tianshu.util.a.f293182a.a(timeRspBody.rptMsgAppInfo.get(), null), TianshuConstants$RedDataChangeState.NET, 3));
                ((IRedTouchServer) qQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(qQAppInterface);
                return;
            }
            SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0).edit();
            edit.putBoolean(BusinessInfoCheckUpdateItem.REDTOUCH_FORCE, true);
            edit.apply();
            if (QBaseActivity.mAppForground) {
                ((IRedTouchServer) qQAppInterface.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(true, true, i3, timeRspBody.redPullPathList.get());
                return;
            }
            return;
        }
        z16 = true;
        if (A != null) {
        }
        if (z16) {
        }
    }

    private byte[] U0(MessageMicro messageMicro) {
        try {
            return messageMicro.toByteArray();
        } catch (Exception e16) {
            QLog.d("RedPointLog.RedTouchManager", 1, "safeToByteArray fail,", e16);
            return new byte[0];
        }
    }

    private void V(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, BusinessInfoCheckUpdate.TimeRspBody timeRspBody2) {
        boolean z16;
        HashMap hashMap = new HashMap();
        for (BusinessInfoCheckUpdate.AppInfo appInfo : timeRspBody.rptMsgAppInfo.get()) {
            if (appInfo != null && (appInfo.push_to.get() == 109 || appInfo.push_to.get() == 109110)) {
                hashMap.put(appInfo.path.get(), appInfo);
            }
        }
        synchronized (G) {
            if (timeRspBody2 != null) {
                for (String str : hashMap.keySet()) {
                    Iterator<BusinessInfoCheckUpdate.AppInfo> it = timeRspBody2.rptMsgAppInfo.get().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            BusinessInfoCheckUpdate.AppInfo next = it.next();
                            if (next.path.get().equals(str)) {
                                next.set((BusinessInfoCheckUpdate.AppInfo) hashMap.get(str));
                                z16 = true;
                                break;
                            }
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        timeRspBody2.rptMsgAppInfo.add((BusinessInfoCheckUpdate.AppInfo) hashMap.get(str));
                    }
                }
            }
        }
    }

    private void W(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, BusinessInfoCheckUpdate.TimeRspBody timeRspBody2) {
        HashMap hashMap = new HashMap();
        for (BusinessInfoCheckUpdate.NumRedInfo numRedInfo : timeRspBody.rptMsgNumRedInfo.get()) {
            for (BusinessInfoCheckUpdate.NumRedPath numRedPath : numRedInfo.num_red_path.get()) {
                if (numRedPath.push_to.get() == 109 || numRedPath.push_to.get() == 109110) {
                    hashMap.put(numRedPath, numRedInfo);
                }
            }
        }
        if (timeRspBody2 != null) {
            for (BusinessInfoCheckUpdate.NumRedPath numRedPath2 : hashMap.keySet()) {
                Iterator<BusinessInfoCheckUpdate.NumRedInfo> it = timeRspBody2.rptMsgNumRedInfo.get().iterator();
                boolean z16 = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BusinessInfoCheckUpdate.NumRedInfo next = it.next();
                    if (hashMap.get(numRedPath2) != null && next.appid.get() == ((BusinessInfoCheckUpdate.NumRedInfo) hashMap.get(numRedPath2)).appid.get()) {
                        Iterator<BusinessInfoCheckUpdate.NumRedPath> it5 = next.num_red_path.get().iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                break;
                            }
                            BusinessInfoCheckUpdate.NumRedPath next2 = it5.next();
                            if (next2.uint64_msgid.get() == numRedPath2.uint64_msgid.get()) {
                                next2.set(numRedPath2);
                                z16 = true;
                                break;
                            }
                        }
                        if (!z16) {
                            next.num_red_path.add(numRedPath2);
                            z16 = true;
                            break;
                        }
                    }
                }
                if (!z16) {
                    timeRspBody2.rptMsgNumRedInfo.add((BusinessInfoCheckUpdate.NumRedInfo) hashMap.get(numRedPath2));
                }
            }
        }
    }

    private final void W0(ToServiceMsg toServiceMsg) {
        if (toServiceMsg != null && (this.f280254d instanceof QQAppInterface)) {
            toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
            ((QQAppInterface) this.f280254d).sendToService(toServiceMsg);
        }
    }

    private boolean X(int i3, List<BusinessInfoCheckUpdate.AppSetting> list, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (999999 == appInfo.uiAppId.get()) {
            return true;
        }
        if (TianshuRedTouch.INSTANCE.j()) {
            if (appInfo.path.get().contains(".") && !appInfo.path.get().endsWith(".0")) {
                return true;
            }
        } else if (appInfo.path.get().contains(".")) {
            return true;
        }
        if (appInfo.iNewFlag.get() != 1) {
            return true;
        }
        if ((i3 == 0 || i3 == 1 || i3 == 11 || i3 == 10) && appInfo.exposure_max.get() <= 0) {
            return true;
        }
        int i16 = 0;
        while (i16 < list.size() && appInfo.uiAppId.get() != list.get(i16).appid.get()) {
            i16++;
        }
        if (i16 < list.size() && !list.get(i16).setting.get()) {
            return true;
        }
        return false;
    }

    public static void X0(boolean z16, Context context) {
        if (context == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(context, "vas_mmkv_configurations");
        from.encodeBool("redTouchPrefisCacheChange", z16);
        from.commitAsync();
    }

    private static void Y0(final String str) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.redtouch.e
            @Override // java.lang.Runnable
            public final void run() {
                RedTouchManager.d0(str);
            }
        });
    }

    private void a1(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        synchronized (G) {
            this.f280256f = timeRspBody;
        }
    }

    private void c1(String str) {
        BusinessInfoCheckUpdate.TimeRspBody A = A();
        if (A == null) {
            if (QLog.isColorLevel()) {
                QLog.e("RedPointLog.RedTouchManager", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
                return;
            }
            return;
        }
        try {
            if (A.rptMsgAppInfo.has()) {
                int i3 = 0;
                while (true) {
                    if (i3 >= A.rptMsgAppInfo.size()) {
                        break;
                    }
                    BusinessInfoCheckUpdate.AppInfo appInfo = A.rptMsgAppInfo.get(i3);
                    if (str.equals(appInfo.path.get())) {
                        PBUInt32Field pBUInt32Field = appInfo.click_max;
                        pBUInt32Field.set(pBUInt32Field.get() - 1);
                        QLog.i("RedPointLog.RedTouchManager", 1, "updateMaxClickByPath" + str + ",max = " + appInfo.click_max.get());
                        if (appInfo.click_max.get() <= 0) {
                            appInfo.iNewFlag.set(0);
                            appInfo.modify_ts.set((int) (NetConnInfoCenter.getServerTimeMillis() / 1000));
                            g0(appInfo);
                            QLog.i("RedPointLog.RedTouchManager", 1, "updateMaxClickByPath less than 0 " + str);
                        }
                    } else {
                        i3++;
                    }
                }
            }
            h(A);
        } catch (Exception e16) {
            QLog.e("RedPointLog.RedTouchManager", 1, "updateMaxClickByPath: " + str, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(String str) {
        BaseApplication app;
        QQAppInterface b16 = i.b();
        if (b16 == null || (app = b16.getApp()) == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(app, "vas_mmkv_configurations");
        from.encodeString("redTouchPreflastClickPath", str);
        from.commitAsync();
    }

    private void d1(String str) {
        if (A() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("RedPointLog.RedTouchManager", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
                return;
            }
            return;
        }
        try {
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            if (A != null && A.rptMsgAppInfo.has()) {
                int i3 = 0;
                while (true) {
                    if (i3 >= A.rptMsgAppInfo.size()) {
                        break;
                    }
                    BusinessInfoCheckUpdate.AppInfo appInfo = A.rptMsgAppInfo.get(i3);
                    if (str.equals(appInfo.path.get())) {
                        PBUInt32Field pBUInt32Field = appInfo.exposure_max;
                        pBUInt32Field.set(pBUInt32Field.get() - 1);
                        QLog.i("RedPointLog.RedTouchManager", 1, "updateMaxExposeTimes" + str + ",max = " + appInfo.exposure_max.get());
                        if (appInfo.exposure_max.get() < 0) {
                            appInfo.iNewFlag.set(0);
                            g0(appInfo);
                            QLog.i("RedPointLog.RedTouchManager", 1, "updateMaxExposeTimes less than 0 " + str);
                        }
                    } else {
                        i3++;
                    }
                }
            }
            h(A);
        } catch (Exception e16) {
            QLog.e("RedPointLog.RedTouchManager", 1, "updateNewFlagByPath: " + str, e16);
        }
    }

    private boolean e0() {
        if (H == null) {
            H = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("red_no_used_local_file_in_main_process", true));
        }
        if (H.booleanValue() && MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    private void f1(int i3, int i16, int i17) {
        List<BusinessInfoCheckUpdate.NumRedPath> list;
        synchronized (G) {
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            boolean z16 = false;
            if (A != null && A.rptMsgNumRedInfo.has()) {
                List<BusinessInfoCheckUpdate.NumRedInfo> list2 = A.rptMsgNumRedInfo.get();
                if (list2 == null) {
                    h0("getNumFromFileByPathAndType : numRedBusiList is null");
                    return;
                }
                boolean z17 = false;
                for (BusinessInfoCheckUpdate.NumRedInfo numRedInfo : list2) {
                    if (numRedInfo.appid.get() == i3 && (list = numRedInfo.num_red_path.get()) != null) {
                        int i18 = 0;
                        while (true) {
                            if (i18 >= list.size()) {
                                break;
                            }
                            if (list.get(i18).uint64_msgid.get() == i16) {
                                list.get(i18).uint32_msg_status.set(i17);
                                z17 = true;
                                break;
                            }
                            i18++;
                        }
                    }
                }
                z16 = z17;
            }
            if (z16) {
                h(A);
            }
        }
    }

    public static String g(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return "null";
        }
        StringBuilder P = l.P();
        P.append(appInfo.path.get());
        P.append(":");
        List<BusinessInfoCheckUpdate.RedTypeInfo> n3 = RedTouchTextView.n(appInfo);
        if (n3 != null) {
            Iterator<BusinessInfoCheckUpdate.RedTypeInfo> it = n3.iterator();
            while (it.hasNext()) {
                P.append(it.next().red_type.get());
                P.append(",");
            }
        }
        return P.toString();
    }

    private static void g0(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new TianshuRedDataChangeEvent(new com.tencent.mobileqq.tianshu.bean.a(appInfo.appset.get(), appInfo.path.get()), TianshuConstants$RedDataChangeState.LOCAL));
    }

    private void g1(String str, boolean z16) {
        QLog.d("RedPointLog.RedTouchManager", 1, "setNewStatusByID,path = " + str);
        if (A() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("RedPointLog.RedTouchManager", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
                return;
            }
            return;
        }
        try {
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            if (A != null && A.rptMsgAppInfo.has()) {
                int i3 = 0;
                int i16 = 0;
                while (true) {
                    if (i16 >= A.rptMsgAppInfo.size()) {
                        break;
                    }
                    BusinessInfoCheckUpdate.AppInfo appInfo = A.rptMsgAppInfo.get(i16);
                    if (str.equals(appInfo.path.get())) {
                        if (appInfo.iNewFlag.get() == 1 && !z16) {
                            appInfo.modify_ts.set((int) (NetConnInfoCenter.getServerTimeMillis() / 1000));
                        }
                        PBInt32Field pBInt32Field = appInfo.iNewFlag;
                        if (z16) {
                            i3 = 1;
                        }
                        pBInt32Field.set(i3);
                        A.rptMsgAppInfo.set(i16, appInfo);
                        g0(appInfo);
                    } else {
                        i16++;
                    }
                }
            }
            h(A);
        } catch (Exception e16) {
            QLog.e("RedPointLog.RedTouchManager", 1, "updateNewFlagByPath: " + str, e16);
        }
    }

    private void h(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        ThreadManagerV2.excute(new Runnable(timeRspBody) { // from class: com.tencent.mobileqq.redtouch.RedTouchManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ BusinessInfoCheckUpdate.TimeRspBody f280260d;

            {
                this.f280260d = timeRspBody;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchManager.this, (Object) timeRspBody);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    RedTouchManager.this.V0(this.f280260d);
                }
            }
        }, 64, null, true);
    }

    public static void h0(final String str) {
        if (RFWThreadManager.isMainThread()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.redtouch.d
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.d("RedPointLog.RedTouchManager", 1, str);
                }
            });
        } else {
            QLog.d("RedPointLog.RedTouchManager", 1, str);
        }
    }

    private boolean j(Submsgtype0x89$NumRedBusiInfo submsgtype0x89$NumRedBusiInfo) {
        if (submsgtype0x89$NumRedBusiInfo == null) {
            return false;
        }
        if (submsgtype0x89$NumRedBusiInfo.uint32_plat_id.get() != 109 && submsgtype0x89$NumRedBusiInfo.uint32_plat_id.get() != 109110) {
            return false;
        }
        return true;
    }

    private void j0(BusinessInfoCheckUpdate.AppInfo appInfo, String str, String str2) {
        String str3;
        if (QLog.isColorLevel()) {
            QLog.e("RedPointLog.RedTouchManager", 2, "onRedTouchItemClick path = " + str);
        }
        boolean z16 = true;
        if (appInfo.iNewFlag.get() == 1) {
            str3 = str;
        } else {
            z16 = false;
            str3 = "";
        }
        Y0(str3);
        if (!str.contains(".")) {
            this.f280259m = str;
            this.C = System.currentTimeMillis();
        }
        t0(appInfo, str2);
        c1(str);
        setChanged();
        if (z16) {
            ((IRedTouchServer) this.f280254d.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f280254d);
        }
    }

    private boolean k1(int i3, int i16) {
        if (i16 == 30 && (this.f280257h & (1 << i3)) != 0) {
            h0("red touch in appSet:" + i3 + " had reported expose once,and expose switch is:" + this.f280257h);
            return true;
        }
        if (i16 == 31 && (this.f280258i & (1 << i3)) != 0) {
            h0("red touch in appSet:" + i3 + " had reported click once,and click switch is:" + this.f280258i);
            return true;
        }
        return false;
    }

    private BusinessInfoCheckUpdate.AppInfo m(String str) {
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        appInfo.path.set(str);
        appInfo.num.set(0);
        appInfo.type.set(-1);
        appInfo.iNewFlag.set(0);
        return appInfo;
    }

    private void m0(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, boolean z16, List<String> list, String str) {
        n0(appInfo, i3, z16, list, null, str);
    }

    private void n0(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, boolean z16, List<String> list, List<Long> list2, String str) {
        p0(appInfo, i3, z16, list, list2, str, null);
    }

    private void p0(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, boolean z16, List<String> list, List<Long> list2, String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.post(new Runnable(appInfo, i3, str2, z16, list2, list, str) { // from class: com.tencent.mobileqq.redtouch.RedTouchManager.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ String C;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ BusinessInfoCheckUpdate.AppInfo f280263d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f280264e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f280265f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f280266h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ List f280267i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ List f280268m;

                {
                    this.f280263d = appInfo;
                    this.f280264e = i3;
                    this.f280265f = str2;
                    this.f280266h = z16;
                    this.f280267i = list2;
                    this.f280268m = list;
                    this.C = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, RedTouchManager.this, appInfo, Integer.valueOf(i3), str2, Boolean.valueOf(z16), list2, list, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        RedTouchManager.this.x0(this.f280263d, this.f280264e, this.f280265f, this.f280266h, this.f280267i, this.f280268m, this.C);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 2, null, true);
        } else {
            x0(appInfo, i3, str2, z16, list2, list, str);
        }
    }

    private ToServiceMsg q(String str) {
        return new ToServiceMsg("mobileqq.service", this.f280254d.getCurrentAccountUin(), str);
    }

    private void s0(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, String str, boolean z16, int i16) {
        synchronized (G) {
            BusinessInfoCheckUpdate.NumRedInfo D = D(appInfo.uiAppId.get());
            if (D == null) {
                return;
            }
            List<BusinessInfoCheckUpdate.NumRedPath> list = D.num_red_path.get();
            if (list == null) {
                h0("onReportShowMsgs : NumRedPaths is null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (BusinessInfoCheckUpdate.NumRedPath numRedPath : list) {
                arrayList.add(Long.valueOf(numRedPath.uint64_msgid.get()));
                if (z16) {
                    f1(appInfo.uiAppId.get(), (int) numRedPath.uint64_msgid.get(), i16);
                }
            }
            n0(appInfo, i3, false, null, arrayList, str);
        }
    }

    private void t0(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        if (appInfo == null) {
            return;
        }
        if (appInfo.iNewFlag.get() == 0) {
            m0(appInfo, 6, false, null, str);
        } else {
            m0(appInfo, 6, true, null, str);
        }
    }

    private void w0(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        if (appInfo == null) {
            return;
        }
        if (appInfo.iNewFlag.get() == 0) {
            QLog.i("RedPointLog.RedTouchManager", 1, "iNewFlag is 0");
        } else {
            m0(appInfo, 1, true, null, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, String str, boolean z16, List<Long> list, List<String> list2, String str2) {
        QLog.i("RedPointLog.RedTouchManager", 1, String.format("onReportSync id = %s type = %d", appInfo.path.get(), Integer.valueOf(i3)));
        BusinessInfoCheckUpdate.ReportReqBody reportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
        reportReqBody.uin.set(y());
        reportReqBody.clientver.set(AppSetting.f99554n);
        reportReqBody.platid.set(109);
        reportReqBody.appid.set(RedTouchUtil.getAppIdByPath(appInfo.path.get()));
        reportReqBody.platver.set(Build.VERSION.SDK_INT + "");
        reportReqBody.cmd.set(i3);
        if (appInfo.extend.has()) {
            reportReqBody.extend.set(appInfo.extend.get());
        }
        if (list != null) {
            reportReqBody.msgids.set(list);
        }
        AppInterface appInterface = this.f280254d;
        if (appInterface instanceof QQAppInterface) {
            if (((QQAppInterface) appInterface).mIsShowNewLeba) {
                reportReqBody.bHebaFlag.set(true);
            } else {
                reportReqBody.bHebaFlag.set(false);
            }
        }
        if (z16) {
            if (list2 != null && list2.size() > 0) {
                reportReqBody.missionid.set(list2);
            } else if (appInfo.missions.has()) {
                reportReqBody.missionid.set(appInfo.missions.get());
            }
        }
        List<BusinessInfoCheckUpdate.ReportStaticsData> Q = Q(str2, appInfo);
        BusinessInfoCheckUpdate.ReportStaticsData reportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
        reportStaticsData.key.set(TVKLiveRequestBuilder.RequestParamKey.QIMEI36);
        reportStaticsData.value.set(String.valueOf(o.b()));
        Q.add(reportStaticsData);
        if (!TextUtils.isEmpty(str)) {
            reportReqBody.buffer.set(str);
        }
        reportReqBody.reportdata.set(Q);
        T0(reportReqBody);
        D0(appInfo, i3);
        if (i3 == 6 || i3 == 31) {
            TianShuManager.setLastClickAdTraceInfo(g.d(appInfo), appInfo.extend.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long y() {
        try {
            return Long.parseLong(this.f280254d.getCurrentAccountUin());
        } catch (NumberFormatException e16) {
            QLog.e("RedPointLog.RedTouchManager", 1, "getCurrentAccountUinLong e = " + e16.getMessage());
            return 0L;
        }
    }

    public BusinessInfoCheckUpdate.TimeRspBody A() {
        BusinessInfoCheckUpdate.TimeRspBody timeRspBody;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (BusinessInfoCheckUpdate.TimeRspBody) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (e0()) {
            return this.f280256f;
        }
        synchronized (G) {
            if (!Y() && (timeRspBody = this.f280256f) != null) {
                return timeRspBody;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.redtouch.RedTouchManager.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RedTouchManager.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            RedTouchManager.this.S();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                }, 5, null, true);
            } else {
                S();
            }
            return null;
        }
    }

    public void C0(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) timeRspBody);
            return;
        }
        if (timeRspBody == null) {
            return;
        }
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (BusinessInfoCheckUpdate.BooleanEntry booleanEntry : timeRspBody.reportCmdCtrl.get()) {
            hashMap.put(Integer.valueOf(booleanEntry.key.get()), Boolean.valueOf(booleanEntry.value.get()));
        }
        this.D = hashMap;
        K0(timeRspBody);
    }

    public void E(long[] jArr, String str, NumRedGetMsgCallback numRedGetMsgCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, jArr, str, numRedGetMsgCallback);
        } else {
            ((NumRedMsgManager) this.f280254d.getManager(QQManagerFactory.NUMREDMSG_MANAGER)).d(jArr, str, numRedGetMsgCallback);
        }
    }

    public void E0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        H0(i3 + "", i16, null);
    }

    public int F(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        h0("getExtraNumRedTotalNum appId = " + i3);
        return B(i3, i16);
    }

    public void F0(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, appInfo, Integer.valueOf(i3), str);
            return;
        }
        if (appInfo != null && appInfo.iNewFlag.get() != 0) {
            if (i3 != 30) {
                if (i3 == 31) {
                    this.f280255e.i(appInfo.buffer.get());
                    c1(appInfo.path.get());
                    m0(appInfo, i3, true, null, str);
                    ((IRedTouchServer) this.f280254d.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f280254d);
                    return;
                }
                return;
            }
            d1(appInfo.path.get());
            if (appInfo.exposure_max.get() >= 0) {
                m0(appInfo, i3, true, null, str);
            }
        }
    }

    public int G(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3)).intValue();
        }
        return C(str, i3);
    }

    public void G0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) str, i3);
        } else {
            H0(str, i3, null);
        }
    }

    public List<BusinessInfoCheckUpdate.NumRedPath> H(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        synchronized (G) {
            BusinessInfoCheckUpdate.NumRedInfo D = D(i3);
            if (D == null) {
                return null;
            }
            return D.num_red_path.get();
        }
    }

    public void H0(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, str, Integer.valueOf(i3), str2);
        } else {
            F0(v(str), i3, str2);
        }
    }

    public BusinessInfoCheckUpdate.AppInfo I(int i3, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            h0("input path is Empty");
            return null;
        }
        int G2 = G(str, 100);
        h0("getNumRedPointInfo  | appSet = " + i3 + " | path = " + str + " | num = " + G2);
        if (G2 <= 0) {
            return null;
        }
        int parseInt = Integer.parseInt(str.split("\\.")[0]);
        BusinessInfoCheckUpdate.NumRedInfo D = D(parseInt);
        if (D != null) {
            str2 = D.extend.get();
        } else {
            str2 = "";
        }
        return p(i3, parseInt, str, G2, false, str2);
    }

    public void I0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            J0(i3, i16, true, null);
        }
    }

    public int J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, i3)).intValue();
        }
        synchronized (G) {
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            int i16 = 0;
            if (A != null && A.rptMsgNumRedInfo.has()) {
                List<BusinessInfoCheckUpdate.NumRedInfo> list = A.rptMsgNumRedInfo.get();
                if (list == null) {
                    h0("getNumRedShowNumByAppSet : numRedBusiList is null");
                    return 0;
                }
                for (BusinessInfoCheckUpdate.NumRedInfo numRedInfo : list) {
                    if (i3 == numRedInfo.appset.get() && numRedInfo.appid.get() != 7719 && b0(numRedInfo.appid.get())) {
                        i16 += F(numRedInfo.appid.get(), 100);
                    }
                }
            }
            return i16;
        }
    }

    public void J0(int i3, int i16, boolean z16, IRedTouchManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), aVar);
            return;
        }
        if (z16 && k1(i3, i16)) {
            return;
        }
        if (i16 == 30) {
            this.f280257h |= 1 << i3;
            h0("expose switch changed:" + this.f280257h);
        } else if (i16 == 31) {
            this.f280258i |= 1 << i3;
            h0("click switch changed:" + this.f280258i);
        }
        List<BusinessInfoCheckUpdate.AppInfo> O0 = O0(i3);
        String str = y() + "_" + System.currentTimeMillis();
        for (BusinessInfoCheckUpdate.AppInfo appInfo : O0) {
            if (aVar != null) {
                if (aVar.a(appInfo)) {
                    N0(appInfo, i3, i16, str);
                }
            } else if (appInfo.mission_level.get() == 0) {
                N0(appInfo, i3, i16, str);
            }
        }
    }

    public void K0(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) timeRspBody);
            return;
        }
        if (timeRspBody != null && timeRspBody.rptMsgAppInfo.has()) {
            List<BusinessInfoCheckUpdate.AppInfo> list = timeRspBody.rptMsgAppInfo.get();
            ArrayList arrayList = new ArrayList();
            for (BusinessInfoCheckUpdate.AppInfo appInfo : list) {
                if (!TextUtils.isEmpty(appInfo.path.get()) && appInfo.iNewFlag.get() != 0) {
                    M0(appInfo, null, 32, null);
                    arrayList.add(appInfo.uiAppId.get() + "");
                }
            }
            h0("level zero arrived, reportAppIdList:" + arrayList);
        }
    }

    public BusinessInfoCheckUpdate.RedTypeInfo L(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 44, (Object) this, i3);
        }
        return M(i3, null);
    }

    public void L0(BusinessInfoCheckUpdate.AppInfo appInfo, JSONObject jSONObject, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, appInfo, jSONObject, Integer.valueOf(i3));
        } else {
            M0(appInfo, jSONObject, i3, null);
        }
    }

    public BusinessInfoCheckUpdate.RedTypeInfo M(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 45, (Object) this, i3, (Object) str);
        }
        return N(i3, str, null);
    }

    public void M0(BusinessInfoCheckUpdate.AppInfo appInfo, JSONObject jSONObject, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, appInfo, jSONObject, Integer.valueOf(i3), str);
            return;
        }
        BusinessInfoCheckUpdate.ReportReqBody reportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
        reportReqBody.uin.set(y());
        reportReqBody.clientver.set(AppSetting.f99554n);
        reportReqBody.platid.set(109);
        reportReqBody.platver.set(Build.VERSION.SDK_INT + "");
        if (jSONObject != null) {
            reportReqBody.buffer.set(jSONObject.toString());
        }
        reportReqBody.cmd.set(i3);
        if (appInfo != null) {
            reportReqBody.appid.set(RedTouchUtil.getAppIdByPath(appInfo.path.get()));
            if (appInfo.missions.has()) {
                reportReqBody.missionid.set(appInfo.missions.get());
            }
        }
        reportReqBody.reportdata.set(Q(str, appInfo));
        T0(reportReqBody);
    }

    public BusinessInfoCheckUpdate.RedTypeInfo N(int i3, String str, List<String> list) {
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 46, this, Integer.valueOf(i3), str, list);
        }
        List<BusinessInfoCheckUpdate.AppInfo> O0 = O0(i3);
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = null;
        if (O0 == null || O0.size() == 0) {
            return null;
        }
        s(O0, list);
        List<BusinessInfoCheckUpdate.AppSetting> P0 = P0();
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("getRedTouchInfoByAppSet:redpoint path List:");
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = null;
        for (int i16 = 0; i16 < O0.size(); i16++) {
            BusinessInfoCheckUpdate.AppInfo appInfo = O0.get(i16);
            if (appInfo.mission_level.get() == 0 && !X(i3, P0, appInfo) && ((TextUtils.isEmpty(str) || appInfo.id_list.get().contains(Long.valueOf(str))) && ((i3 != 1 || !((IDrawerApi) QRoute.api(IDrawerApi.class)).needUsedV3() || com.tencent.mobileqq.qqsettingme.a.l(appInfo.path.get())) && (redTypeInfo = appInfo.red_display_info.tab_display_info.get()) != null && (appInfo.uiAppId.get() != 100510 || redTypeInfo.red_type.get() != 5)))) {
                if (redTypeInfo3 == null || redTypeInfo3.red_priority.get() < redTypeInfo.red_priority.get()) {
                    redTypeInfo3 = redTypeInfo;
                }
                sb5.append(appInfo.path.get());
                sb5.append(",");
                if (redTypeInfo.red_type.get() == 5) {
                    redTypeInfo2 = O(redTypeInfo2, appInfo, redTypeInfo, "getRedTouchInfoByAppSet, content=");
                } else if (redTypeInfo3.red_priority.get() < redTypeInfo.red_priority.get()) {
                    redTypeInfo3 = redTypeInfo;
                }
            }
        }
        if (redTypeInfo2 != null) {
            return redTypeInfo2;
        }
        if (QLog.isColorLevel()) {
            if (redTypeInfo3 != null) {
                QLog.e("RedPointLog.RedTouchManager", 2, "getRedTouchInfoByAppSet appset = " + i3 + ";result != nullpathList = " + sb5.toString());
            } else {
                QLog.e("RedPointLog.RedTouchManager", 2, "getRedTouchInfoByAppSet appset = " + i3 + ";result = null");
            }
        }
        return redTypeInfo3;
    }

    public List<BusinessInfoCheckUpdate.AppInfo> O0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        synchronized (G) {
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            if (A != null && A.rptMsgAppInfo.has()) {
                List<BusinessInfoCheckUpdate.AppInfo> list = A.rptMsgAppInfo.get();
                ArrayList arrayList = new ArrayList();
                for (BusinessInfoCheckUpdate.AppInfo appInfo : list) {
                    if (appInfo.appset.get() == i3) {
                        arrayList.add(appInfo);
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
    }

    public List<BusinessInfoCheckUpdate.AppSetting> P0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        synchronized (G) {
            ArrayList arrayList = new ArrayList();
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            if (A != null && A.rptSetting.has()) {
                List<BusinessInfoCheckUpdate.AppSetting> list = A.rptSetting.get();
                if (list != null) {
                    arrayList.addAll(list);
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    public String R(String str, String str2) {
        JSONObject jSONObject;
        int i3;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            String str4 = null;
            try {
                JSONObject jSONObject2 = new JSONObject(str2);
                if (jSONObject2.has("msg")) {
                    jSONObject = jSONObject2.getJSONObject("msg");
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        new JSONObject();
                        String str5 = (String) keys.next();
                        JSONObject jSONObject3 = jSONObject.getJSONObject(str5);
                        if (jSONObject3.has("stat")) {
                            i3 = jSONObject3.getInt("stat");
                        } else {
                            i3 = -1;
                        }
                        if (i3 == 2) {
                            arrayList.add(str5);
                            if (!jSONObject3.has("content")) {
                                str3 = "";
                            } else {
                                str3 = jSONObject3.getString("content");
                            }
                            hashMap.put(str5, str3);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                arrayList = null;
                hashMap = null;
            }
            if (hashMap != null && hashMap.size() >= 1) {
                ArrayList arrayList2 = new ArrayList();
                BusinessInfoCheckUpdate.AppInfo v3 = v(str);
                if (v3 != null) {
                    str4 = v3.buffer.get();
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                B0(str4, arrayList3, arrayList4);
                List<String> A0 = A0(arrayList, arrayList2, arrayList3, arrayList4);
                if (A0.size() > 0) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        for (int i16 = 0; i16 < A0.size(); i16++) {
                            JSONObject jSONObject4 = new JSONObject();
                            String str6 = A0.get(i16);
                            jSONObject4.put(str6, (String) hashMap.get(str6));
                            jSONArray.mo162put(jSONObject4);
                        }
                        return jSONArray.toString();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
        return "";
    }

    public void R0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f280257h = 0;
            this.f280258i = 0;
        }
    }

    public void S0(long j3) {
        BusinessInfoCheckUpdate.AppInfo v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
            return;
        }
        if (!TextUtils.isEmpty(this.f280259m) && !this.f280259m.contains(".") && (v3 = v(this.f280259m)) != null && j3 >= 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.C;
            if (QLog.isColorLevel()) {
                QLog.e("residenceReport", 2, "residenceReport time = " + currentTimeMillis + ";path = " + this.f280259m);
            }
            this.f280259m = null;
            ThreadManagerV2.post(new Runnable(v3, currentTimeMillis) { // from class: com.tencent.mobileqq.redtouch.RedTouchManager.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ BusinessInfoCheckUpdate.AppInfo f280261d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f280262e;

                {
                    this.f280261d = v3;
                    this.f280262e = currentTimeMillis;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RedTouchManager.this, v3, Long.valueOf(currentTimeMillis));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject;
                    Exception e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BusinessInfoCheckUpdate.ReportReqBody reportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
                    reportReqBody.uin.set(RedTouchManager.this.y());
                    reportReqBody.clientver.set(AppSetting.f99554n);
                    reportReqBody.platid.set(109);
                    reportReqBody.appid.set(RedTouchUtil.getAppIdByPath(this.f280261d.path.get()));
                    reportReqBody.platver.set(Build.VERSION.SDK_INT + "");
                    reportReqBody.cmd.set(18);
                    reportReqBody.extend.set(this.f280261d.extend.get());
                    if (this.f280261d.missions.has()) {
                        reportReqBody.missionid.set(this.f280261d.missions.get());
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("time_on_page", this.f280262e);
                        } catch (Exception e17) {
                            e16 = e17;
                            QLog.e("RedPointLog.RedTouchManager", 1, "residenceReport parse json error " + e16);
                            reportReqBody.buffer.set(jSONObject.toString());
                            RedTouchManager.this.T0(reportReqBody);
                        }
                    } catch (Exception e18) {
                        jSONObject = jSONObject2;
                        e16 = e18;
                    }
                    reportReqBody.buffer.set(jSONObject.toString());
                    RedTouchManager.this.T0(reportReqBody);
                }
            }, 2, null, true);
        }
    }

    public String T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (String) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        String str = y() + "_" + System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trace_id", str);
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("RedPointLog.RedTouchManager", 1, "traceId  report JSONException ", e16);
            return str;
        }
    }

    public boolean V0(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        byte[] byteArray;
        int incrementAndGet;
        boolean pushData2File;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) timeRspBody)).booleanValue();
        }
        String currentAccountUin = this.f280254d.getCurrentAccountUin();
        Object obj = G;
        synchronized (obj) {
            try {
                byteArray = timeRspBody.toByteArray();
            } catch (Exception e16) {
                QLog.e("RedPointLog.RedTouchManager", 1, "saveTimeRepBody exception e = ", e16);
                return false;
            } catch (OutOfMemoryError unused) {
                QLog.e("RedPointLog.RedTouchManager", 1, "saveTimeRepBody oom");
                return false;
            }
        }
        synchronized (F) {
            incrementAndGet = E.incrementAndGet();
            pushData2File = FileUtils.pushData2File(new File(this.f280254d.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + currentAccountUin).getAbsolutePath(), byteArray, false);
            if (!pushData2File) {
                QLog.e("RedPointLog.RedTouchManager", 1, "saveTimeRepBody pushData2File failed");
            }
        }
        synchronized (obj) {
            if (pushData2File) {
                if (incrementAndGet == E.get()) {
                    a1(timeRspBody);
                }
            }
        }
        return pushData2File;
    }

    public boolean Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this)).booleanValue();
        }
        return QMMKV.from(this.f280254d.getApp(), "vas_mmkv_configurations").decodeBool("redTouchPrefisCacheChange", true);
    }

    public int Z0(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, this, appInfo, Boolean.valueOf(z16))).intValue();
        }
        synchronized (G) {
            if (appInfo != null) {
                if (appInfo.path.has()) {
                    BusinessInfoCheckUpdate.TimeRspBody A = A();
                    if (A == null) {
                        h0("updateAppInfo failed,TimeRspBody is Empty");
                        return -3;
                    }
                    List<BusinessInfoCheckUpdate.AppInfo> list = A.rptMsgAppInfo.get();
                    int size = list.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        if (appInfo.path.get().equals(list.get(i3).path.get())) {
                            h0("path is same = " + appInfo.path);
                            list.set(i3, appInfo);
                            break;
                        }
                        i3++;
                    }
                    if (i3 == size) {
                        if (!z16) {
                            return -3;
                        }
                        A.rptMsgAppInfo.add(appInfo);
                    }
                    h(A);
                    return 0;
                }
            }
            h0("updateAppInfo failed , appInfo is empty or appInfo path is null");
            return -3;
        }
    }

    public boolean a0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, i3)).booleanValue();
        }
        synchronized (G) {
            if (i3 == 0) {
                return false;
            }
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            if (A == null) {
                return true;
            }
            List<BusinessInfoCheckUpdate.NumRedInfo> list = A.rptMsgNumRedInfo.get();
            if (list != null) {
                for (BusinessInfoCheckUpdate.NumRedInfo numRedInfo : list) {
                    if (numRedInfo.appid.get() == i3) {
                        return numRedInfo.flag.get();
                    }
                }
            }
            return true;
        }
    }

    public boolean b0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        if (F(i3, 0) <= 0) {
            return false;
        }
        return true;
    }

    public void e1(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, BusinessInfoCheckUpdate.TimeRspBody timeRspBody2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) timeRspBody, (Object) timeRspBody2);
            return;
        }
        synchronized (G) {
            if (timeRspBody2 != null) {
                for (BusinessInfoCheckUpdate.AppInfo appInfo : timeRspBody.rptMsgAppInfo.get()) {
                    Iterator<BusinessInfoCheckUpdate.AppInfo> it = timeRspBody2.rptMsgAppInfo.get().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            BusinessInfoCheckUpdate.AppInfo next = it.next();
                            if (next.path.get().equals(appInfo.path.get())) {
                                next.set(appInfo);
                                z16 = true;
                                break;
                            }
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        timeRspBody2.rptMsgAppInfo.add(appInfo);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[Catch: all -> 0x008c, TryCatch #0 {, blocks: (B:28:0x0028, B:31:0x0031, B:13:0x003f, B:16:0x0048, B:17:0x0054, B:19:0x007c, B:20:0x008a, B:26:0x004f, B:11:0x0038), top: B:27:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f0(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, BusinessInfoCheckUpdate.TimeRspBody timeRspBody2, int i3) {
        List<BusinessInfoCheckUpdate.AppInfo> list;
        List<BusinessInfoCheckUpdate.AppInfo> arrayList;
        List<com.tencent.mobileqq.tianshu.bean.a> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, timeRspBody, timeRspBody2, Integer.valueOf(i3));
            return;
        }
        synchronized (G) {
            if (timeRspBody != null) {
                if (timeRspBody.rptMsgAppInfo.has()) {
                    list = timeRspBody.rptMsgAppInfo.get();
                    if (timeRspBody2 != null && timeRspBody2.rptMsgAppInfo.has()) {
                        arrayList = timeRspBody2.rptMsgAppInfo.get();
                        a16 = com.tencent.mobileqq.tianshu.util.a.f293182a.a(list, arrayList);
                        QLog.d("RedPointLog.RedTouchManager", 1, "notifyAppinfoChangeUpdate appInfo size " + a16.size());
                        if (!a16.isEmpty()) {
                            SimpleEventBus.getInstance().dispatchEvent(new TianshuRedDataChangeEvent(a16, TianshuConstants$RedDataChangeState.NET, i3));
                        }
                    }
                    arrayList = new ArrayList<>();
                    a16 = com.tencent.mobileqq.tianshu.util.a.f293182a.a(list, arrayList);
                    QLog.d("RedPointLog.RedTouchManager", 1, "notifyAppinfoChangeUpdate appInfo size " + a16.size());
                    if (!a16.isEmpty()) {
                    }
                }
            }
            list = new ArrayList<>();
            if (timeRspBody2 != null) {
                arrayList = timeRspBody2.rptMsgAppInfo.get();
                a16 = com.tencent.mobileqq.tianshu.util.a.f293182a.a(list, arrayList);
                QLog.d("RedPointLog.RedTouchManager", 1, "notifyAppinfoChangeUpdate appInfo size " + a16.size());
                if (!a16.isEmpty()) {
                }
            }
            arrayList = new ArrayList<>();
            a16 = com.tencent.mobileqq.tianshu.util.a.f293182a.a(list, arrayList);
            QLog.d("RedPointLog.RedTouchManager", 1, "notifyAppinfoChangeUpdate appInfo size " + a16.size());
            if (!a16.isEmpty()) {
            }
        }
    }

    public boolean h1(String str, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (i3 < 0) {
            h0("updateNumberRedInfoByPath fail path:" + str + "  number:" + i3);
            return false;
        }
        BusinessInfoCheckUpdate.TimeRspBody A = A();
        if (A == null) {
            h0("updateNumberRedInfoByPath fail, timeRspBody is null");
            return false;
        }
        try {
            if (A.rptMsgAppInfo.has()) {
                int i16 = 0;
                while (true) {
                    if (i16 >= A.rptMsgAppInfo.size()) {
                        break;
                    }
                    BusinessInfoCheckUpdate.AppInfo appInfo = A.rptMsgAppInfo.get(i16);
                    if (str.equals(appInfo.path.get())) {
                        if (appInfo.type.get() == 8) {
                            if (appInfo.num.get() <= i3 && !I.contains(str)) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (!z16) {
                                h0("updateNumberRedInfoByPath fail, not isValid path:" + str + " new number:" + i3 + " old number:" + appInfo.num.get());
                                return false;
                            }
                            h0("updateNumberRedInfoByPath success path:" + str + "  number:" + i3 + " old number:" + appInfo.num.get());
                            if (appInfo.num.get() == i3) {
                                return true;
                            }
                            appInfo.num.set(i3);
                            h(A);
                            ((IRedTouchServer) this.f280254d.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f280254d);
                            g0(appInfo);
                            return true;
                        }
                        h0("updateNumberRedInfoByPath fail path:" + str + " type:" + appInfo.type.get() + " currentNumber:" + appInfo.num.get() + " number:" + i3);
                    } else {
                        i16++;
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("RedPointLog.RedTouchManager", 1, "updateNewFlagByPath: " + str, e16);
        }
        return false;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        synchronized (G) {
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            boolean z16 = false;
            if (A != null && A.rptMsgNumRedInfo.has()) {
                List<BusinessInfoCheckUpdate.NumRedInfo> list = A.rptMsgNumRedInfo.get();
                if (list == null) {
                    return;
                }
                Iterator<BusinessInfoCheckUpdate.NumRedInfo> it = list.iterator();
                boolean z17 = false;
                while (it.hasNext()) {
                    List<BusinessInfoCheckUpdate.NumRedPath> list2 = it.next().num_red_path.get();
                    if (list2 != null) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            BusinessInfoCheckUpdate.NumRedPath numRedPath = list2.get(i3);
                            if (numRedPath.uint32_push_num_red_ts.get() + numRedPath.uint32_expire_time.get() < ((int) (System.currentTimeMillis() / 1000))) {
                                numRedPath.uint32_msg_status.set(4);
                                z17 = true;
                            }
                        }
                    }
                }
                z16 = z17;
            }
            if (z16) {
                h(A);
            }
        }
    }

    public void i0(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) appInfo, (Object) str);
            return;
        }
        if (appInfo == null) {
            return;
        }
        String str2 = appInfo.path.get();
        this.f280255e.i(appInfo.buffer.get());
        if (appInfo.type.get() == 5) {
            s0(appInfo, 9, str, true, 3);
        } else {
            j0(appInfo, str2, str);
        }
    }

    public int i1(int i3, boolean z16, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Integer) iPatchRedirector.redirect((short) 61, this, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17))).intValue();
        }
        synchronized (G) {
            BusinessInfoCheckUpdate.AppSetting appSetting = new BusinessInfoCheckUpdate.AppSetting();
            appSetting.appid.set(i3);
            appSetting.setting.set(z16);
            appSetting.modify_ts.set(j3);
            BusinessInfoCheckUpdate.TimeRspBody A = A();
            if (A != null && (A.has() || A.rptSetting.has())) {
                List<BusinessInfoCheckUpdate.AppSetting> list = A.rptSetting.get();
                int size = list.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size) {
                        break;
                    }
                    if (i3 == list.get(i16).get().appid.get()) {
                        list.set(i16, appSetting);
                        break;
                    }
                    i16++;
                }
                if (i16 == size) {
                    list.add(appSetting);
                }
                if (z17) {
                    V0(A);
                } else {
                    h(A);
                }
            } else {
                BusinessInfoCheckUpdate.TimeRspBody timeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
                timeRspBody.rptSetting.add(appSetting);
                if (z17) {
                    V0(timeRspBody);
                } else {
                    h(timeRspBody);
                }
            }
        }
        return 0;
    }

    public String j1(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        int i3;
        PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField;
        List<BusinessInfoCheckUpdate.RedTypeInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, (Object) appInfo);
        }
        if (!TextUtils.isEmpty(str) && appInfo != null) {
            if (appInfo.iNewFlag.get() != 0) {
                new ArrayList();
                BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = appInfo.red_display_info;
                if (redDisplayInfo != null && (pBRepeatMessageField = redDisplayInfo.red_type_info) != null && (list = pBRepeatMessageField.get()) != null && list.size() >= 2) {
                    i3 = list.get(1).red_type.get();
                    return str + "&status=" + i3 + "&number=" + appInfo.num.get() + "&path=" + appInfo.path.get();
                }
            }
            i3 = -1;
            return str + "&status=" + i3 + "&number=" + appInfo.num.get() + "&path=" + appInfo.path.get();
        }
        h0("url is empty or appInfo is Empty");
        return str;
    }

    public boolean k(int i3) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, i3)).booleanValue();
        }
        HashMap<Integer, Boolean> hashMap = this.D;
        if (hashMap == null || (bool = hashMap.get(Integer.valueOf(i3))) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void k0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            h0("onRedTouchItemClick path is empty");
        } else {
            j0(v(str), str, null);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        QLog.d("RedPointLog.RedTouchManager", 2, "getNewFlagOp:send redInfo start");
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
        long j3 = sharedPreferences.getLong(BusinessInfoCheckUpdateItem.CONVERSATION_REMAIN_LAST_REPORT, -1L);
        long config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_CONVERSATION_REMAIN_REPORT_CONTROL, 60);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (j3 > currentTimeMillis - config) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(BusinessInfoCheckUpdateItem.CONVERSATION_REMAIN_LAST_REPORT, currentTimeMillis);
        edit.apply();
        L0(null, null, 50);
    }

    public void l0(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInfo, (Object) str);
        } else if (appInfo.type.get() == 5) {
            s0(appInfo, 8, str, false, -1);
        } else {
            w0(appInfo, str);
        }
    }

    public BusinessInfoCheckUpdate.AppInfo n(int i3, int i16, String str, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 41, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17));
        }
        return o(i3, i16, str, i17, true);
    }

    public BusinessInfoCheckUpdate.AppInfo o(int i3, int i16, String str, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 42, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Boolean.valueOf(z16));
        }
        return p(i3, i16, str, i17, true, "");
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
            return;
        }
        RedTouchLifeTimeManager redTouchLifeTimeManager = this.f280255e;
        if (redTouchLifeTimeManager != null) {
            redTouchLifeTimeManager.f();
        }
    }

    public BusinessInfoCheckUpdate.AppInfo p(int i3, int i16, String str, int i17, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 43, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Boolean.valueOf(z16), str2);
        }
        BusinessInfoCheckUpdate.AppInfo m3 = m(str);
        m3.uiAppId.set(i16);
        m3.type.set(5);
        m3.iNewFlag.set(1);
        m3.appset.set(i3);
        m3.mission_level.set(0);
        if (!TextUtils.isEmpty(str2)) {
            m3.extend.set(str2);
        }
        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        redTypeInfo.red_type.set(9);
        redTypeInfo.red_content.set("-1");
        redTypeInfo.red_desc.set("");
        redDisplayInfo.red_type_info.add(redTypeInfo);
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        redTypeInfo2.red_type.set(5);
        redTypeInfo2.red_content.set(i17 + "");
        redTypeInfo2.red_desc.set("{'cn':'#FF0000'}");
        redDisplayInfo.tab_display_info.set(redTypeInfo2);
        redDisplayInfo.red_type_info.add(redTypeInfo2);
        m3.red_display_info.set(redDisplayInfo);
        if (z16) {
            Z0(m3, true);
            ((IRedTouchServer) this.f280254d.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f280254d);
        }
        return m3;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q0(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) appInfo, (Object) str);
            return;
        }
        if (appInfo != null && str != null && str.length() != 0) {
            d1(appInfo.path.get());
            BusinessInfoCheckUpdate.ReportReqBody reportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
            reportReqBody.uin.set(y());
            reportReqBody.clientver.set(AppSetting.f99554n);
            reportReqBody.platid.set(109);
            reportReqBody.missionid.set(appInfo.missions.get());
            reportReqBody.appid.set(appInfo.uiAppId.get());
            reportReqBody.platver.set(Build.VERSION.SDK_INT + "");
            reportReqBody.cmd.set(5);
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e16) {
                e = e16;
            }
            try {
                jSONObject.put("cmd", 5);
                JSONObject jSONObject3 = new JSONObject(str);
                Iterator keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    BusinessInfoCheckUpdate.ReportStaticsData reportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
                    reportStaticsData.key.set(str2);
                    reportStaticsData.value.set(jSONObject3.getString(str2));
                    arrayList.add(reportStaticsData);
                }
            } catch (JSONException e17) {
                e = e17;
                jSONObject2 = jSONObject;
                QLog.e("RedPointLog.RedTouchManager", 1, "error report " + e);
                jSONObject = jSONObject2;
                if (jSONObject != null) {
                }
                reportReqBody.reportdata.set(arrayList);
                T0(reportReqBody);
            }
            if (jSONObject != null) {
                reportReqBody.buffer.set(jSONObject.toString());
            }
            reportReqBody.reportdata.set(arrayList);
            T0(reportReqBody);
        }
    }

    public void r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            h0("onRedTouchItemClick path is empty");
            return;
        }
        BusinessInfoCheckUpdate.AppInfo v3 = v(str);
        if (v3 != null && v3.iNewFlag.get() == 1) {
            Y0(str);
        } else {
            Y0("");
        }
        BusinessInfoCheckUpdate.AppInfo v16 = v(str);
        if (v16 != null) {
            if (v16.iNewFlag.get() == 0) {
                m0(v16, 14, false, null, null);
            } else {
                m0(v16, 14, true, null, null);
            }
        }
        g1(str, false);
        setChanged();
        ((IRedTouchServer) this.f280254d.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f280254d);
    }

    public void r0(int i3, String str) {
        BusinessInfoCheckUpdate.NumRedInfo D;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) str);
            return;
        }
        synchronized (G) {
            int C = C(str, 100);
            if (C > 0 && (D = D(i3)) != null) {
                s0(p(D.appset.get(), i3, str, C, false, D.extend.get()), 9, "", true, 3);
            }
        }
    }

    protected void s(List<BusinessInfoCheckUpdate.AppInfo> list, List<String> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) list, (Object) list2);
            return;
        }
        if (list2 != null) {
            Iterator<BusinessInfoCheckUpdate.AppInfo> it = list.iterator();
            while (it.hasNext()) {
                BusinessInfoCheckUpdate.AppInfo next = it.next();
                for (int i3 = 0; i3 < list2.size() && !String.valueOf(next.uiAppId.get()).equals(list2.get(i3)); i3++) {
                    if (i3 == list2.size() - 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(int i3, ArrayList<String> arrayList, String str, String str2, String str3, String str4, String str5, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), arrayList, str, str2, str3, str4, str5, Integer.valueOf(i16));
            return;
        }
        BusinessInfoCheckUpdate.ReportReqBody reportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
        reportReqBody.uin.set(y());
        reportReqBody.clientver.set(AppSetting.f99554n);
        reportReqBody.platid.set(109);
        reportReqBody.appid.set(i16);
        reportReqBody.platver.set(Build.VERSION.SDK_INT + "");
        reportReqBody.cmd.set(i3);
        if (arrayList != null) {
            reportReqBody.missionid.set(arrayList);
        }
        int i17 = this.f280254d.getApplication().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0).getInt("businessinfo_last_check_update_timestamp_" + this.f280254d.getCurrentAccountUin(), 0);
        JSONObject jSONObject = null;
        try {
            if (TextUtils.isEmpty(str3)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("msg", "");
                    jSONObject = jSONObject2;
                } catch (Exception e16) {
                    e = e16;
                    jSONObject = jSONObject2;
                    if (QLog.isColorLevel()) {
                        QLog.e("RedPointLog.RedTouchManager", 2, "getAndSetAppInfoJsReport buffer json is empty", e);
                    }
                    if (jSONObject != null) {
                    }
                    T0(reportReqBody);
                }
            } else {
                jSONObject = new JSONObject(str3);
            }
            jSONObject.put("red", str);
            jSONObject.put("ret", str2);
            jSONObject.put("lastTime", i17);
            jSONObject.put("callback", str5);
            jSONObject.put("waterid", str4);
        } catch (Exception e17) {
            e = e17;
        }
        if (jSONObject != null) {
            reportReqBody.buffer.set(jSONObject.toString());
        }
        T0(reportReqBody);
    }

    public BusinessInfoCheckUpdate.AppInfo u(int i3, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            h0("input path is Empty");
            return null;
        }
        int C = C(str, 100);
        h0("getAppInfo  | appSet = " + i3 + " | path = " + str + " | num = " + C);
        if (C > 0) {
            int parseInt = Integer.parseInt(str.split("\\.")[0]);
            BusinessInfoCheckUpdate.NumRedInfo D = D(parseInt);
            if (D != null) {
                str2 = D.extend.get();
            } else {
                str2 = "";
            }
            return p(i3, parseInt, str, C, false, str2);
        }
        return K(str);
    }

    public void u0(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, appInfo, Boolean.valueOf(z16), list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("RedPointLog.RedTouchManager", 2, "onReportRedPointClickWithMissions");
        }
        if (appInfo == null) {
            QLog.e("RedPointLog.RedTouchManager", 1, "onReportRedPointClickWithMissions appinfo = null");
        } else {
            m0(appInfo, 6, z16, list, null);
        }
    }

    public BusinessInfoCheckUpdate.AppInfo v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            h0("input path is Empty");
            return null;
        }
        return K(str);
    }

    public void v0(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) appInfo);
        } else {
            w0(appInfo, null);
        }
    }

    public BusinessInfoCheckUpdate.AppInfo w(int i3, String str, String str2) {
        long parseLong;
        BusinessInfoCheckUpdate.AppInfo u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                parseLong = Long.parseLong(str2);
            } catch (NumberFormatException e16) {
                QLog.e("RedPointLog.RedTouchManager", 1, e16, new Object[0]);
            }
            u16 = u(i3, str);
            if (u16 == null && parseLong != -1) {
                if (u16.id_list.get().contains(Long.valueOf(parseLong))) {
                    return u16;
                }
                return null;
            }
        }
        parseLong = -1;
        u16 = u(i3, str);
        return u16 == null ? u16 : u16;
    }

    public JSONObject x(BusinessInfoCheckUpdate.AppInfo appInfo) {
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (JSONObject) iPatchRedirector.redirect((short) 39, (Object) this, (Object) appInfo);
        }
        if (appInfo == null) {
            return null;
        }
        try {
            if (appInfo.buffer.has()) {
                JSONObject jSONObject = new JSONObject(appInfo.buffer.get());
                String optString = jSONObject.optString("_show_mission");
                if (!TextUtils.isEmpty(optString) && (optJSONObject = jSONObject.optJSONObject("param")) != null) {
                    return optJSONObject.optJSONObject(optString);
                }
            }
        } catch (Throwable th5) {
            QLog.e("RedPointLog.RedTouchManager", 1, "getBufferExtParamAppInfo() JSONException ", th5);
        }
        return null;
    }

    public void y0(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) bArr);
            return;
        }
        if (bArr != null) {
            try {
                Submsgtype0x89$MsgBody submsgtype0x89$MsgBody = new Submsgtype0x89$MsgBody();
                submsgtype0x89$MsgBody.mergeFrom(bArr);
                List<Submsgtype0x89$NumRedBusiInfo> list = submsgtype0x89$MsgBody.rpt_msg_num_red.get();
                if (list == null) {
                    return;
                }
                for (Submsgtype0x89$NumRedBusiInfo submsgtype0x89$NumRedBusiInfo : list) {
                    if (j(submsgtype0x89$NumRedBusiInfo) && g.b(submsgtype0x89$NumRedBusiInfo.str_client_ver_begin.get(), submsgtype0x89$NumRedBusiInfo.str_client_ver_end.get())) {
                        s0(n(submsgtype0x89$NumRedBusiInfo.int32_appset.get(), submsgtype0x89$NumRedBusiInfo.uint32_app_id.get(), String.valueOf(submsgtype0x89$NumRedBusiInfo.uint64_msgid.get()), 1), 1, "", false, -1);
                    }
                }
                U(bArr, 4);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public int z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        h0("getExtraNumRedTotalNum appId = " + i3);
        synchronized (G) {
            BusinessInfoCheckUpdate.NumRedInfo D = D(i3);
            if (D == null) {
                h0("getNumFromFileByAppid : cannot find the info by appid");
                return 0;
            }
            return D.red_total_num.get();
        }
    }

    public boolean z0(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) bArr)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.e("RedPointLog.RedTouchManager", 2, "parsePushRedTouchInfo start");
        }
        try {
            U(bArr, 3);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("RedPointLog.RedTouchManager", 1, "push parse error : e = " + e16.getMessage());
        }
        if (QLog.isColorLevel()) {
            QLog.e("RedPointLog.RedTouchManager", 2, "parsePushRedTouchInfo end");
            return false;
        }
        return false;
    }
}
