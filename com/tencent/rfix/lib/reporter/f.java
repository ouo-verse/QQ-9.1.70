package com.tencent.rfix.lib.reporter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.RFixParams;
import com.tencent.rfix.lib.reporter.RFixQualitySampler;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.ProcessUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f {
    static IPatchRedirector $redirector_;

    protected static Map<String, String> c(Context context) {
        String str;
        String packageName = context.getPackageName();
        String processName = ProcessUtils.getProcessName(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            str = packageManager.getApplicationLabel(InstalledAppListMonitor.getPackageInfo(packageManager, packageName, 0).applicationInfo).toString();
        } catch (Exception unused) {
            str = null;
        }
        RFixParams params = RFix.getInstance().getParams();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "0ac00056535");
        hashMap.put("token", "5422841524");
        hashMap.put("device_id", params.getDeviceId());
        hashMap.put("user_id", params.getUserId());
        hashMap.put(AudienceReportConst.CLIENT_TYPE, "Android");
        hashMap.put("client_version", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("client_brand", params.getDeviceManufacturer());
        hashMap.put("client_model", params.getDeviceModel());
        hashMap.put("app_bundle", packageName);
        hashMap.put("app_name", str);
        hashMap.put("app_version", params.getAppVersion(context));
        hashMap.put("sdk_version", "1.2.4-beta4-SNAPSHOT");
        hashMap.put("sdk_appid", params.getAppId());
        hashMap.put("process_name", processName);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(final Context context, final RFixLoadResult rFixLoadResult, final boolean z16, final long j3) {
        RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.lib.reporter.e
            @Override // java.lang.Runnable
            public final void run() {
                f.g(context, rFixLoadResult, z16, j3);
            }
        });
    }

    public static boolean f(final Context context, final RFixLoadResult rFixLoadResult, final boolean z16, final long j3) {
        if (ProcessUtils.isInMainProcess(context)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.rfix.lib.reporter.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.e(context, rFixLoadResult, z16, j3);
                }
            }, 5000L);
            return true;
        }
        g(context, rFixLoadResult, z16, j3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, RFixLoadResult rFixLoadResult, boolean z16, long j3) {
        boolean z17;
        int i3;
        String str;
        String str2;
        RFixPatchInfo rFixPatchInfo;
        int i16 = 0;
        String str3 = null;
        if (rFixLoadResult != null && (rFixPatchInfo = rFixLoadResult.patchInfo) != null) {
            int i17 = rFixPatchInfo.configId;
            if (i17 <= 0) {
                i17 = rFixPatchInfo.lastConfigId;
            }
            i3 = rFixPatchInfo.configType;
            String str4 = rFixPatchInfo.patchType;
            if (!TextUtils.isEmpty(rFixPatchInfo.version) && rFixPatchInfo.version.length() >= 8) {
                str3 = rFixPatchInfo.version.substring(0, 8);
            }
            z17 = rFixLoadResult.isLoaderSuccess();
            str2 = str3;
            i16 = i17;
            str = str4;
        } else {
            z17 = false;
            i3 = 0;
            str = null;
            str2 = null;
        }
        i(context, String.valueOf(i16), String.valueOf(i3), str, str2, "Launch", z16, null, null, j3, String.valueOf(z17), null, null, String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.APP_BASE_CONTEXT_ATTACH)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.APP_FIRST_ACTIVITY_RESUME)), null, null, null, null, null, null, null, null);
    }

    public static boolean h(Context context, String str, String str2, String str3, String str4, String str5, boolean z16, String str6, String str7, long j3) {
        return i(context, str, str2, str3, str4, str5, z16, str6, str7, j3, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static boolean i(Context context, String str, String str2, String str3, String str4, String str5, boolean z16, String str6, String str7, long j3, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        if (context == null || str5 == null) {
            return false;
        }
        RFixLog.d("RFix.RFixQualityReporter", String.format("reportEvent eventName=%s eventSuccess=%s eventCode=%s eventCodeExt=%s eventTimeCost=%s configId=%s configType=%s patchType=%s patchVersion=%s", str5, Boolean.valueOf(z16), str6, str7, Long.valueOf(j3), str, str2, str3, str4));
        RFixQualitySampler.ReportType d16 = RFixQualitySampler.d(context, str5, z16);
        if (d16 == RFixQualitySampler.ReportType.None) {
            RFixLog.d("RFix.RFixQualityReporter", String.format("reportEvent eventName=%s intercept by sample!", str5));
            return false;
        }
        Map<String, String> c16 = c(context);
        c16.put("config_id", str);
        c16.put("config_type", str2);
        c16.put("patch_type", str3);
        c16.put("patch_version", str4);
        c16.put("event_name", str5);
        c16.put("event_success", z16 ? "1" : "0");
        c16.put("event_code", str6);
        c16.put("event_code_ext", str7);
        c16.put("event_time_cost", String.valueOf(j3));
        c16.put(TVKDataBinder.KEY_REPORT_TYPE, d16 == null ? "" : d16.toString());
        c16.put("ext1", str8);
        c16.put("ext2", str9);
        c16.put("ext3", str10);
        c16.put("time_track1", str11);
        c16.put("time_track2", str12);
        c16.put("time_track3", str13);
        c16.put("time_track4", str14);
        c16.put("time_track5", str15);
        c16.put("time_track6", str16);
        c16.put("time_track7", str17);
        c16.put("time_track8", str18);
        c16.put("time_track9", str19);
        c16.put("time_track10", str20);
        return com.tencent.rfix.lib.atta.e.c(context).h(c16);
    }
}
