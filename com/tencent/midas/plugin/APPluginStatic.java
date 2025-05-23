package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes9.dex */
public abstract class APPluginStatic {
    public static final String CHANNEL_LIST_ACTIVITY = "com.pay.ui.recoChannel.APRecoChannelActivity";
    public static final String CHANNEL_LIST_NEW_ACTIVITY = "com.pay.newui.activity.APChannelListActivity";
    public static final String FIRST_H5_LAUNCH_ACTIVITY = "com.tencent.midas.pay.APMidasH5DistributeActivity";
    public static final String FIRST_LAUNCH_ACTIVITY = "com.tencent.midas.pay.APMidasDistributeActivity";
    public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
    public static final String PARAM_CLEAR_TOP = "cleartop";
    static final String PARAM_IS_IN_PLUGIN = "pluginsdk_IsPluginActivity";
    public static final String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
    public static final String PARAM_PLUGIN_CutOut_ENABLE = "pluginsdk_cutOutEnable";
    public static final String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
    public static final String PARAM_PLUGIN_IS_NEW_PROCESS = "pluginsdk_isNewProcess";
    public static final String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
    public static final String PARAM_PLUGIN_LOG_CALLBACK_CLASS_NAME = "pluginsdk_logCallbackClassName";
    public static final String PARAM_PLUGIN_LOG_ENABLE = "pluginsdk_logEnable";
    public static final String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
    public static final String PARAM_PLUGIN_OPENSDK_ENABLE = "pluginsdk_openSDKEnable";
    public static final String PARAM_PLUGIN_PATH = "pluginsdk_pluginpath";
    public static final String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
    private static final String TAG = "APPluginStatic";
    public static final int USER_QQ_RESOURCES_NO = -1;
    public static final int USER_QQ_RESOURCES_YES = 1;
    static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap = new ConcurrentHashMap<>();
    private static ArrayList<WeakReference<IAPPluginActivity>> sInstances = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void add(IAPPluginActivity iAPPluginActivity) {
        updateReference();
        synchronized (sInstances) {
            sInstances.add(new WeakReference<>(iAPPluginActivity));
        }
    }

    static List<WeakReference<IAPPluginActivity>> getActivitys() {
        return sInstances;
    }

    public static ClassLoader getOrCreateClassLoader(Context context, String str) throws Exception {
        return APPluginLoader.getOrCreateClassLoader(context, str);
    }

    public static void release() {
        APPluginLoader.release();
        sPackageInfoMap.clear();
        APLog.d(TAG, "release sInstances size: " + sInstances.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void remove(IAPPluginActivity iAPPluginActivity) {
        updateReference();
        removeActivity(iAPPluginActivity);
    }

    private static boolean removeActivity(IAPPluginActivity iAPPluginActivity) {
        synchronized (sInstances) {
            for (int i3 = 0; i3 < sInstances.size(); i3++) {
                if (sInstances.get(i3).get() == iAPPluginActivity) {
                    sInstances.remove(i3);
                    return true;
                }
            }
            return false;
        }
    }

    public static void removeAll() {
        updateReference();
        synchronized (sInstances) {
            int i3 = 0;
            while (i3 < sInstances.size()) {
                IAPPluginActivity iAPPluginActivity = sInstances.get(i3).get();
                if (iAPPluginActivity != null) {
                    iAPPluginActivity.IFinish();
                    sInstances.remove(i3);
                    i3--;
                }
                i3++;
            }
        }
    }

    static void updateReference() {
        synchronized (sInstances) {
            int i3 = 0;
            while (i3 < sInstances.size()) {
                if (sInstances.get(i3).get() == null) {
                    sInstances.remove(i3);
                    i3--;
                }
                i3++;
            }
        }
    }
}
