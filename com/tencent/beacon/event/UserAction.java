package com.tencent.beacon.event;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import com.tencent.beacon.core.info.BeaconPubParams;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconInitException;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class UserAction {

    /* renamed from: a, reason: collision with root package name */
    private static String f77874a;

    /* renamed from: c, reason: collision with root package name */
    private static String f77876c;
    public static Context mContext;

    /* renamed from: b, reason: collision with root package name */
    private static BeaconConfig.Builder f77875b = BeaconConfig.builder();

    /* renamed from: d, reason: collision with root package name */
    private static boolean f77877d = true;

    public static void doUploadRecords() {
        EventModule eventModule = (EventModule) com.tencent.beacon.a.c.c.c().a(ModuleName.EVENT);
        if (eventModule != null) {
            eventModule.a(false);
        }
    }

    public static Map<String, String> getAdditionalInfo() {
        return getAdditionalInfo(null);
    }

    public static String getAppKey() {
        return f77874a;
    }

    public static String getCloudParas(String str) {
        return "";
    }

    public static BeaconPubParams getCommonParams() {
        return BeaconReport.getInstance().getCommonParams(mContext);
    }

    public static String getEventDomain() {
        return com.tencent.beacon.base.net.b.b.f77722c;
    }

    public static String getOpenID(String str) {
        EventModule eventModule = (EventModule) com.tencent.beacon.a.c.c.c().a(ModuleName.EVENT);
        if (eventModule != null) {
            return eventModule.b(str);
        }
        return "";
    }

    public static String getSDKVersion() {
        return BeaconReport.getInstance().getSDKVersion();
    }

    public static String getStrategyDomain() {
        return com.tencent.beacon.base.net.b.b.f77723d;
    }

    public static String getUserID(String str) {
        EventModule eventModule = (EventModule) com.tencent.beacon.a.c.c.c().a(ModuleName.EVENT);
        if (eventModule != null) {
            return eventModule.c(str);
        }
        return "";
    }

    public static void initUserAction(Context context) throws BeaconInitException {
        initUserAction(context, true);
    }

    public static boolean loginEvent(boolean z16, long j3, Map<String, String> map) {
        if (mContext != null) {
            map.put("A19", com.tencent.beacon.a.c.e.l().q());
        }
        return onUserAction("rqd_wgLogin", z16, j3, 0L, map, true);
    }

    public static boolean onDTUserAction(Context context, String str, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        if (context == null) {
            return false;
        }
        if (map != null) {
            com.tencent.beacon.a.c.c.c().a(context);
            com.tencent.beacon.a.c.e l3 = com.tencent.beacon.a.c.e.l();
            com.tencent.beacon.a.c.f e16 = com.tencent.beacon.a.c.f.e();
            HashMap hashMap = new HashMap(map);
            hashMap.put("dt_imei2", "" + e16.c());
            hashMap.put("dt_meid", "" + e16.g());
            hashMap.put("dt_mf", "" + l3.o());
            return onUserAction(str, z16, j3, j16, hashMap, z17, z18);
        }
        return onUserAction(str, z16, j3, j16, null, z17, z18);
    }

    public static boolean onDTUserActionToTunnel(Context context, String str, String str2, Map<String, String> map, boolean z16, boolean z17) {
        if (context == null) {
            return false;
        }
        if (map != null) {
            com.tencent.beacon.a.c.c.c().a(context);
            com.tencent.beacon.a.c.e l3 = com.tencent.beacon.a.c.e.l();
            com.tencent.beacon.a.c.f e16 = com.tencent.beacon.a.c.f.e();
            HashMap hashMap = new HashMap(map);
            hashMap.put("dt_imei2", "" + e16.c());
            hashMap.put("dt_meid", "" + e16.g());
            hashMap.put("dt_mf", "" + l3.o());
            return ReportMethodProxy.onUserActionToTunnel(str, str2, hashMap, z16, z17);
        }
        return ReportMethodProxy.onUserActionToTunnel(str, str2, null, z16, z17);
    }

    public static void onPageIn(String str) {
        com.tencent.beacon.c.a.a(com.tencent.beacon.event.c.d.d(str));
    }

    public static void onPageOut(String str) {
        com.tencent.beacon.c.a.b(com.tencent.beacon.event.c.d.d(str));
    }

    public static boolean onUserAction(String str, boolean z16, long j3, long j16, Map<String, String> map, boolean z17) {
        return onUserAction(str, z16, j3, j16, map, z17, false);
    }

    public static boolean onUserActionToTunnel(String str, String str2, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        return BeaconReport.getInstance().report(BeaconEvent.builder().withCode(str2).withType(z17 ? EventType.REALTIME : EventType.NORMAL).withParams(map).withAppKey(str).withIsSucceed(z16).build()).isSuccess();
    }

    public static void setAdditionalInfo(String str, Map<String, String> map) {
        BeaconReport.getInstance().setAdditionalParams(str, map);
    }

    public static void setAppKey(String str) {
        f77874a = str;
    }

    public static void setAppVersion(String str) {
        f77876c = str;
    }

    public static void setChannelID(String str) {
        BeaconReport.getInstance().setChannelID(str);
    }

    public static void setLogAble(boolean z16, boolean z17) {
        com.tencent.beacon.base.util.c.a(z16);
        com.tencent.beacon.base.util.c.b(z16);
    }

    public static void setOAID(String str) {
        BeaconReport.getInstance().setOAID(str);
    }

    @Deprecated
    public static void setOldInitMethodEnable(boolean z16) {
        f77877d = z16;
    }

    public static void setOmgId(String str) {
        BeaconReport.getInstance().setOmgID(str);
    }

    public static void setOpenID(String str) {
        BeaconReport.getInstance().setOpenID(null, str);
    }

    public static void setQQ(String str) {
        BeaconReport.getInstance().setQQ(str);
    }

    public static void setReportDomain(String str, String str2) {
        com.tencent.beacon.base.net.b.b.a(str, str2);
    }

    public static void setReportIP(String str, String str2) {
        com.tencent.beacon.base.net.b.b.b(str, str2);
    }

    public static void setScheduledService(ScheduledExecutorService scheduledExecutorService) {
        f77875b.setExecutorService(scheduledExecutorService);
    }

    public static void setStrictMode(boolean z16) {
        BeaconReport.getInstance().setStrictMode(z16);
    }

    public static void setUploadMode(boolean z16) {
        if (z16) {
            BeaconReport.getInstance().pauseUpload(true);
        } else {
            BeaconReport.getInstance().resumeUpload();
        }
    }

    public static void setUserID(String str, String str2) {
        BeaconReport.getInstance().setUserID(str, str2);
    }

    public static Map<String, String> getAdditionalInfo(String str) {
        EventModule eventModule = (EventModule) com.tencent.beacon.a.c.c.c().a(ModuleName.EVENT);
        if (eventModule != null) {
            return eventModule.a(str);
        }
        return null;
    }

    public static void initUserAction(Context context, boolean z16) throws BeaconInitException {
        initUserAction(context, z16, 0L);
    }

    public static boolean onUserAction(String str, Map<String, String> map, boolean z16, boolean z17) {
        return onUserAction(str, true, -1L, -1L, map, z16, z17);
    }

    public static void setAdditionalInfo(Map<String, String> map) {
        setAdditionalInfo(null, map);
    }

    public static void setUserID(String str) {
        setUserID(null, str);
    }

    public static void initUserAction(Context context, boolean z16, long j3) throws BeaconInitException {
        initUserAction(context, z16, j3, null, null);
    }

    public static boolean onUserAction(String str, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        return BeaconReport.getInstance().report(BeaconEvent.builder().withCode(str).withType(z17 ? EventType.REALTIME : EventType.NORMAL).withParams(map).withAppKey(f77874a).withIsSucceed(z16).build()).isSuccess();
    }

    @TargetApi(14)
    public static void initUserAction(Context context, boolean z16, long j3, InitHandleListener initHandleListener, UploadHandleListener uploadHandleListener) throws BeaconInitException {
        if (f77877d) {
            mContext = context;
            BeaconReport.getInstance().start(context, f77874a, f77875b.build());
        } else {
            Log.e("beacon", "UserAction.initUserAction is not available");
        }
    }

    public static boolean onUserActionToTunnel(String str, String str2, Map<String, String> map, boolean z16, boolean z17) {
        return ReportMethodProxy.onUserActionToTunnel(str, str2, true, -1L, -1L, map, z16, z17);
    }

    @Deprecated
    public static void closeUseInfoEvent() {
    }

    public static void flushObjectsToDB(boolean z16) {
    }

    public static void registerTunnel(TunnelInfo tunnelInfo) {
    }

    @Deprecated
    public static void setAutoLaunchEventUsable(boolean z16) {
    }

    public static void setJsClientId(String str) {
    }
}
