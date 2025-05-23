package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.hitrate.b;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes28.dex */
public class QzonePluginProxyActivity extends PluginProxyFragmentActivity implements QzoneJumpQBrowserInterface {
    private static final String KEY_CRASH_COUNT_IN_CNF_EXCEPTION = "Crash_Count_In_CNFException";
    public static final String QZONE_EXTRA_KEY_PLUGIN_ISLOADING = "QZoneExtra.Plugin.isloading";
    public static final String QZONE_PLUGIN_ACTIVITY_NAME = "qzone_plugin_activity_name";
    static final String QZONE_PLUGIN_NAME = "QZone";
    public static final String QZONE_PLUGIN_PACKAGE_NAME = "com.qzone";
    public static final String QZONE_START_UP_FAILED_COUNT_KEY = "qzone_app_start_fail_count";
    private static final String TAG = "QzonePluginProxyActivity";
    private WatchActivityManager mWatchActivityManager = new WatchActivityManager();
    private TopGestureLayout topGestureLayout;

    private void dismissPluginLoading() {
        Intent intent = new Intent("action_launch_completed");
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "FriendFeed", QzoneConfig.DefaultValue.DEFAULT_FRIENDFEED_TITLE);
        intent.putExtra("plugin_apk", this.mPluginID);
        intent.putExtra("plugin_name", config);
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getActivityNameToIntent(Intent intent) {
        return intent.getStringExtra("qzone_plugin_activity_name");
    }

    public static ClassLoader getPhotoPlusClassLoader(Context context) throws Exception {
        return ((IQzonePluginProxyActivityProxy) QRoute.api(IQzonePluginProxyActivityProxy.class)).getPhotoPlusClassLoader(context);
    }

    private static ConcurrentHashMap<String, PackageInfo> getPluginStaticPackageInfoMap() {
        try {
            Field declaredField = PluginStatic.class.getDeclaredField("sPackageInfoMap");
            declaredField.setAccessible(true);
            return (ConcurrentHashMap) declaredField.get(PluginStatic.class);
        } catch (IllegalAccessException e16) {
            QLog.w(TAG, 1, "Get PluginStatic sPackageInfoMap Failed!", e16);
            return null;
        } catch (NoSuchFieldException e17) {
            QLog.w(TAG, 1, "Get PluginStatic sPackageInfoMap Failed!", e17);
            return null;
        }
    }

    public static String getQZonePluginName() {
        return ((IQzonePluginProxyActivityProxy) QRoute.api(IQzonePluginProxyActivityProxy.class)).getPluginID();
    }

    public static ClassLoader getQzoneLiveClassLoader(Context context) throws Exception {
        return ((IQzonePluginProxyActivityProxy) QRoute.api(IQzonePluginProxyActivityProxy.class)).getQzoneLiveClassLoader(context);
    }

    public static ClassLoader getQzoneVerticalVideoClassLoader(Context context) throws Exception {
        return ((IQzonePluginProxyActivityProxy) QRoute.api(IQzonePluginProxyActivityProxy.class)).getQzoneVerticalVideoClassLoader(context);
    }

    public static ClassLoader getQzoneWeishiFeedsClassLoader(Context context) throws Exception {
        return ((IQzonePluginProxyActivityProxy) QRoute.api(IQzonePluginProxyActivityProxy.class)).getQzoneWeishiFeedsClassLoader(context);
    }

    public static void launchPluingActivityForResult(Context context, String str, Intent intent, int i3) {
        launchPluingActivityForResult(context, str, intent, i3, (b) null);
    }

    public static void setActivityNameToIntent(Intent intent, String str) {
        intent.putExtra("qzone_plugin_activity_name", str);
        int sceneIdByActivityName = QZoneHelper.getSceneIdByActivityName(str);
        if (sceneIdByActivityName > 0) {
            intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, sceneIdByActivityName);
        }
    }

    public static void toExActivityWithResult(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putBoolean("cleartop", true);
        bundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
        bundle.putString("PhotoConst.PLUGIN_NAME", QZONE_PLUGIN_NAME);
        bundle.putString("PhotoConst.PLUGIN_APK", ((IQzonePluginProxyActivityProxy) QRoute.api(IQzonePluginProxyActivityProxy.class)).getPluginID());
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public String getPluginID() {
        return ((IQzonePluginProxyActivityProxy) QRoute.api(IQzonePluginProxyActivityProxy.class)).getPluginID();
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity
    protected int getPluginResType() {
        return 1;
    }

    public IPluginActivity getRealPluginActivity() {
        return this.mPluginActivity;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity
    protected int getThemeResId() {
        return 0;
    }

    public WatchActivityManager getWatchActivityManager() {
        return this.mWatchActivityManager;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        ViewUtils.resetScreenSize();
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FlingHandler flingHandler = this.mFlingHandler;
        if (flingHandler != null && (flingHandler instanceof FlingGestureHandler)) {
            QZoneTopGestureLayout qZoneTopGestureLayout = new QZoneTopGestureLayout(this);
            this.topGestureLayout = qZoneTopGestureLayout;
            ((FlingGestureHandler) this.mFlingHandler).setTopLayout(qZoneTopGestureLayout);
        }
        if (!TextUtils.isEmpty(this.mCreateErrorInfo) && !this.mCreateErrorInfo.equals("success")) {
            if (bundle == null) {
                bundle = getIntent().getExtras();
            }
            String string = bundle.getString("pluginsdk_launchActivity");
            StringBuffer stringBuffer = new StringBuffer(HardCodeUtil.qqStr(R.string.s4v));
            stringBuffer.append(string);
            stringBuffer.append(" ");
            stringBuffer.append(this.mCreateErrorInfo);
            QLog.e(QZLog.TO_DEVICE_TAG, 1, stringBuffer.toString());
            ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(new QZoneStartupFailException(this.mCreateErrorInfo), HardCodeUtil.qqStr(R.string.s4i) + getPluginActivity());
            dismissPluginLoading();
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string2 = extras.getString("from_plugin");
            String string3 = extras.getString("uin");
            getIntent().putExtra("from_plugin", "");
            if (!TextUtils.isEmpty(string2) && string2.equals("QZoneVideoPlugin")) {
                launchPluingActivityForResult(this, string3, getIntent(), 1000);
            }
        }
        this.mWatchActivityManager.onCreate(this);
        VideoReport.addToDetectionWhitelist(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mWatchActivityManager.onDestroy();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        this.mWatchActivityManager.onKeyDown(i3, keyEvent);
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            this.mWatchActivityManager.onResume();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[onResume] error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mWatchActivityManager.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public boolean shouldHandleStartPluginFailed(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PLUGIN_PERMISSION_ERROR_HANDLE, 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PLUGIN_ERROR_HANDLE_COUNT, -1);
        if (config == 0) {
            if (!z16) {
                return false;
            }
            return super.shouldHandleStartPluginFailed(str);
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("classnotfoundexception")) {
            SharedPreferences sharedPreferences = getSharedPreferences(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, 0);
            int i3 = sharedPreferences.getInt(KEY_CRASH_COUNT_IN_CNF_EXCEPTION, 0);
            sharedPreferences.edit().putInt(KEY_CRASH_COUNT_IN_CNF_EXCEPTION, i3 + 1).commit();
            if (i3 == 0) {
                QLog.e("Plugin", 1, "kill process with first Exception:" + lowerCase);
                finish();
                SystemMethodProxy.killProcess(Process.myPid());
            } else {
                if (config >= 0 && i3 >= config) {
                    if (!z16) {
                        return false;
                    }
                    return super.shouldHandleStartPluginFailed(lowerCase);
                }
                QLog.e("Plugin", 1, "show dialog with non-first Exception:" + lowerCase);
                showNeedUninstanllAndInstallDialog();
            }
            return true;
        }
        if (!z16) {
            return false;
        }
        return super.shouldHandleStartPluginFailed(lowerCase);
    }

    public static void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, b bVar) {
        launchPluingActivityForResult(context, str, intent, i3, null, true, bVar, false);
    }

    public static void launchPluingActivityForResult(Activity activity, String str, Intent intent, int i3, boolean z16) {
        launchPluingActivityForResult(activity, str, intent, i3, null, true, null, z16);
    }

    public static void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16) {
        launchPluingActivityForResult(context, str, intent, i3, onDismissListener, z16, null, false);
    }

    public static void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16, b bVar, boolean z17) {
        ((IQzonePluginProxyActivityProxy) QRoute.api(IQzonePluginProxyActivityProxy.class)).launchPluingActivityForResult(context, str, intent, i3, onDismissListener, z16, bVar, z17);
    }
}
