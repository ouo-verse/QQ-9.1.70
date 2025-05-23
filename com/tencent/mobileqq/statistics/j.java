package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import com.tencent.mobileqq.pluginsdk.PluginConst;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j implements IStatisticsUploader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Random f290017a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75423);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f290017a = new Random();
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(String str, int i3, long j3) {
        if (f290017a.nextInt(1000) != 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, String.valueOf(i3));
        hashMap.put("plugin_name", str);
        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
        hashMap.put("result", String.valueOf(i3));
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(waitAppRuntime.getAccount(), "actPluginDexa2OatInfo", false, j3, 0L, hashMap, null);
            if (QLog.isColorLevel()) {
                QLog.d("PluginStatisticsCollector", 2, "uploadDexOatInfo pluginId " + str + " " + String.valueOf(i3) + " " + j3);
            }
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IStatisticsUploader
    public void uploadStartupFailure(Context context, String str, String str2, String str3, String str4, String str5) {
        String str6 = str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2, str3, str4, str6);
            return;
        }
        boolean equals = "success".equals(str6);
        if (str6 != null && str6.contains(ClassNotFoundException.class.getName())) {
            str6 = "GetAvailableInnernalMemorySize:" + FileUtils.getAvailableInnernalMemorySize() + "__" + str6;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PluginStatisticsCollector", 2, "uploadStartupFailure result = " + equals + ", pluginName = " + str2 + ", extraInfo = " + str6);
        }
        if (!equals) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            hashMap.put("plugin_name", str2);
            hashMap.put("plugin_loc", str3);
            hashMap.put("plugin_activity", str4);
            hashMap.put("plugin_extra_info", str6);
            StatisticCollector.getInstance(context).collectPerformance(str, "actPluginStartupFailure", equals, 0L, 0L, hashMap, null);
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap2.put("plugin_name", str2);
        StatisticCollector.getInstance(context).collectPerformance(str, "actPluginStartupResult", equals, 0L, 0L, hashMap2, null);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IStatisticsUploader
    public void uploadStartupSpeedInfo(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        long longExtra = intent.getLongExtra(PluginConst.STAT_LAUNCH_TOTAL, 0L);
        long longExtra2 = intent.getLongExtra(PluginConst.STAT_EXTRACT_APK_COST, 0L);
        long longExtra3 = intent.getLongExtra(PluginConst.STAT_EXTRACT_DEX2OAT_COST, 0L);
        long longExtra4 = intent.getLongExtra(PluginConst.STAT_EXTRACT_DOWNLOAD_COST, 0L);
        long longExtra5 = intent.getLongExtra(PluginConst.STAT_EXTRACT_LIB_COST, 0L);
        long longExtra6 = intent.getLongExtra(PluginConst.STAT_LAUNCH_CLASSLOADER, 0L);
        String stringExtra = intent.getStringExtra(PluginConst.STAT_LAUNCH_COMPONENT);
        String stringExtra2 = intent.getStringExtra(PluginConst.STAT_LAUNCH_PROCESS);
        String stringExtra3 = intent.getStringExtra(PluginStatic.PARAM_UIN);
        String stringExtra4 = intent.getStringExtra("pluginsdk_pluginName");
        String stringExtra5 = intent.getStringExtra("pluginsdk_pluginLocation");
        String stringExtra6 = intent.getStringExtra("pluginsdk_pluginpath");
        String stringExtra7 = intent.getStringExtra("pluginsdk_launchActivity");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("plugin_name", stringExtra4);
        hashMap.put("plugin_loc", stringExtra5);
        hashMap.put("plugin_activity", stringExtra7);
        hashMap.put("plugin_extra_info", stringExtra6);
        hashMap.put(PluginConst.STAT_EXTRACT_DEX2OAT_COST, String.valueOf(longExtra3));
        hashMap.put(PluginConst.STAT_EXTRACT_APK_COST, String.valueOf(longExtra2));
        hashMap.put(PluginConst.STAT_LAUNCH_CLASSLOADER, String.valueOf(longExtra6));
        hashMap.put(PluginConst.STAT_LAUNCH_TOTAL, String.valueOf(longExtra));
        StatisticCollector.getInstance(context).collectPerformance(stringExtra3, "actPluginSpeedInfoV2", false, longExtra, 0L, hashMap, null);
        QLog.d("plugin_tag", 1, "uploadStartupSpeedInfo  " + stringExtra5 + ", launchTotal " + longExtra + ", apkCost " + longExtra2 + ", dex2OatCost " + longExtra3 + ", libCost " + longExtra5 + ", downloadCost " + longExtra4 + ", loaderCost " + longExtra6 + ", launchComponent " + stringExtra + ", procName " + stringExtra2);
    }
}
