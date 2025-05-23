package cooperation.plugin;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ds;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.shadow.dynamic.host.QShadowLoadInfo;
import cooperation.plugin.IPluginManager;
import cooperation.qzone.util.NetworkState;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class j {
    private static boolean a(String[] strArr) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (strArr == null || strArr.length == 0 || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            for (String str : strArr) {
                if (TextUtils.equals(str, runningAppProcessInfo.processName)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean b(IPluginManager.i iVar, HashMap<String, String> hashMap) {
        String str;
        long j3;
        try {
            str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        } catch (Throwable unused) {
            QLog.e("plugin_tag", 1, "getAccount failed \uff01\uff01\uff01");
            str = "";
        }
        hashMap.put("qq_num", str);
        PluginBaseInfo pluginBaseInfo = iVar.f390217w;
        if (pluginBaseInfo == null) {
            QLog.e("plugin_tag", 1, "plugin info is null!");
            return false;
        }
        try {
            hashMap.put("plugin_id", pluginBaseInfo.mID);
            hashMap.put("plugin_type", String.valueOf(pluginBaseInfo.mSubType));
            hashMap.put("plugin_version", pluginBaseInfo.mVersion);
            hashMap.put("plugin_md5", pluginBaseInfo.mMD5);
            hashMap.put("plugin_name", pluginBaseInfo.mName);
            hashMap.put("plugin_state", String.valueOf(pluginBaseInfo.mState));
            hashMap.put("plugin_download_duration", String.valueOf(pluginBaseInfo.downloadDuration));
            hashMap.put("plugin_start_network_type", String.valueOf(pluginBaseInfo.startDownloadNetType));
            hashMap.put("plugin_network_type", String.valueOf(NetworkState.getNetworkType()));
            hashMap.put("plugin_low_device", Boolean.toString(DeviceInfoUtils.isLowPerfDevice()));
            hashMap.put("plugin_is_foreground", Boolean.toString(Foreground.isCurrentProcessForeground()));
            hashMap.put("plugin_process", Arrays.toString(pluginBaseInfo.mProcesses));
            hashMap.put("plugin_process_running", Boolean.toString(a(pluginBaseInfo.mProcesses)));
            hashMap.put("plugin_install_code", Integer.toString(pluginBaseInfo.installCode));
            if (pluginBaseInfo.mSubType == 1) {
                j3 = pluginBaseInfo.costDex2Oat;
            } else {
                j3 = pluginBaseInfo.costDex2Oat + pluginBaseInfo.costApk + pluginBaseInfo.costLib;
            }
            hashMap.put("plugin_install_duration", Long.toString(j3));
            iVar.a();
            return true;
        } catch (Exception e16) {
            QLog.e("plugin_tag", 1, "plugin set info error!", e16);
            return false;
        }
    }

    private static void c(IPluginManager.i iVar, HashMap<String, String> hashMap, boolean z16) {
        if (Float.compare(ds.b(0.0f, 1.0f), 0.001f) > 0) {
            QLog.e("plugin_tag", 1, "Do not need to report this plugin launch event!");
            return;
        }
        if (iVar == null) {
            QLog.e("plugin_tag", 1, "params is null, do not report this event!");
            return;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null && !hashMap.isEmpty()) {
            hashMap2.putAll(hashMap);
        }
        if (!b(iVar, hashMap2)) {
            return;
        }
        hashMap2.put("plugin_result", Boolean.toString(z16));
        hashMap2.put("plugin_launch_type", String.valueOf(iVar.f390216v));
        QLog.i("plugin_tag", 2, "report plugin launch event: " + hashMap2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(hashMap2.get("qq_num"), "qqPluginLaunchDataReport", true, 0L, 0L, hashMap2, null);
    }

    public static void d(IPluginManager.i iVar, boolean z16) {
        c(iVar, null, z16);
    }

    public static void e(IPluginManager.i iVar) {
        if (Float.compare(ds.b(0.0f, 1.0f), 0.001f) > 0) {
            QLog.e("plugin_tag", 1, "Do not need to report this plugin launch event!");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (b(iVar, hashMap)) {
            return;
        }
        QLog.i("plugin_tag", 2, "report plugin launched state event: " + hashMap);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(hashMap.get("qq_num"), "qqPluginLaunchedDataReport", true, 0L, 0L, hashMap, null);
    }

    public static void f(IPluginManager.i iVar, QShadowLoadInfo qShadowLoadInfo, boolean z16) {
        HashMap hashMap = new HashMap();
        if (qShadowLoadInfo != null) {
            hashMap.put("plugin_load_runtime", Long.toString(qShadowLoadInfo.loadRuntimeTime));
            hashMap.put("plugin_load_loader", Long.toString(qShadowLoadInfo.loadLoaderTime));
            hashMap.put("plugin_load_plugin", Long.toString(qShadowLoadInfo.loadPluginTime));
            hashMap.put("plugin_load_app", Long.toString(qShadowLoadInfo.appCreateTime));
            hashMap.put("plugin_bind_service", Long.toString(qShadowLoadInfo.bindServiceTime));
            hashMap.put("plugin_is_hot_launch", Boolean.toString(qShadowLoadInfo.isHotLaunch));
        }
        hashMap.put("plugin_inner_launch", "true");
        c(iVar, hashMap, z16);
    }
}
