package cooperation.qzone.plugin;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzonePatchApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.List;

/* loaded from: classes38.dex */
public class QZonePluginUtils {
    public static final String KEY_QZONE_LIVE_PLUGIN_ID = "qzone_live_pluginid";
    public static final String QZONE_LIVE_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzonelive";
    private static final String TAG = "QZonePluginManger";
    public static String mQzoneLivePluginId;

    public static String getLoadQZoneLivePluginId() {
        if (!TextUtils.isEmpty(mQzoneLivePluginId)) {
            return mQzoneLivePluginId;
        }
        String str = IQzonePatchApi.LIVE_PLUGIN_ID;
        String string = LocalMultiProcConfig.getString(KEY_QZONE_LIVE_PLUGIN_ID, IQzonePatchApi.LIVE_PLUGIN_ID);
        int useLocalLivePlugin = useLocalLivePlugin();
        int i3 = 0;
        if (useLocalLivePlugin != 0 || IQzonePatchApi.LIVE_PLUGIN_ID.equals(string)) {
            if (useLocalLivePlugin == 1) {
                str = "qzone_live_video_plugin.apk";
                if (!"qzone_live_video_plugin.apk".equals(string)) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                    while (i3 < runningAppProcesses.size()) {
                        if ("com.tencent.mobileqq:qzonelive".equals(runningAppProcesses.get(i3).processName)) {
                            if (QLog.isColorLevel()) {
                                QLog.i("QZonePluginManger", 2, "\u5207\u6362\u65f6 qzonelive \u8fdb\u7a0b\u5b58\u5728 pluginid \u4fdd\u6301\u4e0d\u53d8\uff0cgetLoadQZoneLivePluginId:" + string);
                            }
                            return string;
                        }
                        i3++;
                    }
                    LocalMultiProcConfig.putString(KEY_QZONE_LIVE_PLUGIN_ID, "qzone_live_video_plugin.apk");
                }
            }
            str = string;
        } else {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            while (i3 < runningAppProcesses2.size()) {
                if ("com.tencent.mobileqq:qzonelive".equals(runningAppProcesses2.get(i3).processName)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QZonePluginManger", 2, "\u5207\u6362\u65f6 qzonelive \u8fdb\u7a0b\u5b58\u5728 pluginid \u4fdd\u6301\u4e0d\u53d8\uff0cgetLoadQZoneLivePluginId:" + string);
                    }
                    return string;
                }
                i3++;
            }
            LocalMultiProcConfig.putString(KEY_QZONE_LIVE_PLUGIN_ID, IQzonePatchApi.LIVE_PLUGIN_ID);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QZonePluginManger", 2, "getLoadQZoneLivePluginId:" + str);
        }
        mQzoneLivePluginId = str;
        return str;
    }

    public static File getPluginInstallDir(Context context) {
        return PluginUtils.getPluginInstallDir(context);
    }

    public static int useLocalLivePlugin() {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_USE_QQ_PLUGIN_MANAGER, 1);
        if (QLog.isColorLevel()) {
            QLog.d("QZonePluginManger", 2, "[useLocalLivePlugin] value=" + config);
        }
        return config;
    }

    public static boolean fileExists(String str) {
        return str != null && new File(str).exists();
    }
}
