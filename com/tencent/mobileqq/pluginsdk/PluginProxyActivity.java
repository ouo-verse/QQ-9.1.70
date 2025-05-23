package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AndroidOreoUtils;
import mqq.app.IActivityDispatchCallback;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import mqq.app.ThirdAppReportHelper;

@SuppressLint({"NewApi"})
/* loaded from: classes16.dex */
public abstract class PluginProxyActivity extends FragmentActivity {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_PLUGIN_DIR_INFO_LOG = "com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG";
    public static final String ACTION_PLUGIN_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
    public static final String ACTION_PLUGIN_STARTUP_SPEED_INFO = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_SPEED_INFO";
    private static final String INNER_BUNDLE = "pluginsdk_inner_bundle";
    protected static final String INNER_INTENT_EXTRAS = "pluginsdk_inner_intent_extras";
    public static final int LAUNCH_TYPE_FIRST = 1;
    public static final int LAUNCH_TYPE_OTHER = -1;
    public static final String READER_ID = "qqreaderplugin.apk";
    private static final String TAG = "PluginProxyActivity";
    public static Locale locale;
    public static boolean mAppForground;
    public static boolean mGestureLockEnable;
    private static String mUin;
    public static IActivityDispatchCallback sActivityDispatchCallback;
    public static IPluginManifestChecker sChecker;
    private static Field sMMapField;
    private static Method sUnparcelMethod;
    public boolean mActNeedImmersive;
    AndroidOreoUtils mAndroidOreoUtils;
    private boolean mCanLock;
    private Class<?> mClassLaunchActivity;
    protected String mCreateErrorInfo;
    protected FlingHandler mFlingHandler;
    protected boolean mIsShowQQBackgroundIcon;
    protected String mLaunchActivity;
    protected boolean mNeedStatusTrans;
    private SparseArray<List> mPermissionCallerMap;
    protected IPluginActivity mPluginActivity;
    protected String mPluginApkFilePath;
    private boolean mPluginGestureLock;
    protected String mPluginID;
    protected String mPluginName;
    protected int mPluginResoucesType;
    private BroadcastReceiver mScreenOffReceiver;
    protected int mStatusColor;
    protected int mStopFlag;
    private String mUinString;
    protected boolean mUseSkinEngine;
    Object msystemBar;

    /* loaded from: classes16.dex */
    public interface IPluginManifestChecker {
        void doCheck(String str, String str2);
    }

    /* loaded from: classes16.dex */
    public static class StartActivityParams {
        static IPatchRedirector $redirector_;
        public String launchActivity;
        public ClassLoader loader;
        public String mPluginApkFilePath;
        public String mPluginID;
        public String mPluginName;
        public int mPluginResoucesType;
        public boolean mUseSkinEngine;
        public String proxyActivity;

        public StartActivityParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13312);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 55)) {
            redirector.redirect((short) 55);
            return;
        }
        mGestureLockEnable = false;
        mAppForground = true;
        mUin = "";
        sUnparcelMethod = null;
        sMMapField = null;
    }

    public PluginProxyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mClassLaunchActivity = null;
        this.mPluginActivity = null;
        this.mUseSkinEngine = false;
        this.mPluginApkFilePath = null;
        this.mPluginName = null;
        this.mPluginID = null;
        this.mLaunchActivity = null;
        this.mUinString = null;
        this.mPluginGestureLock = false;
        this.mStopFlag = 0;
        this.mCanLock = true;
        this.mIsShowQQBackgroundIcon = true;
        this.mCreateErrorInfo = null;
        this.mStatusColor = 0;
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = true;
        this.mScreenOffReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.pluginsdk.PluginProxyActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PluginProxyActivity.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                if (PluginProxyActivity.mGestureLockEnable) {
                    PluginProxyActivity pluginProxyActivity = PluginProxyActivity.this;
                    if (pluginProxyActivity.mStopFlag == 0 && pluginProxyActivity.isPatternLockOpened()) {
                        PluginProxyActivity.this.startUnlockActivity(false);
                    }
                }
            }
        };
        this.mPermissionCallerMap = new SparseArray<>();
    }

    private boolean getAppForground(Context context) {
        try {
            int i3 = GesturePWDUtils.f213636a;
            Object invoke = GesturePWDUtils.class.getMethod("getAppForground", Context.class).invoke(GesturePWDUtils.class, this);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return true;
    }

    public static float getAvailableInnernalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    private String getCurrentUinForPlugin(Context context) {
        try {
            int i3 = GesturePWDUtils.f213636a;
            Object invoke = GesturePWDUtils.class.getMethod("getUinForPlugin", Context.class).invoke(GesturePWDUtils.class, this);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return "";
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private boolean getEnableGestureLock(Context context) {
        try {
            int i3 = GesturePWDUtils.f213636a;
            Object invoke = GesturePWDUtils.class.getMethod("enableGestureLock", Context.class).invoke(GesturePWDUtils.class, this);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    private void handleIntentForQQBrowser(Context context, Intent intent) {
        String className;
        try {
            if (intent.getComponent() != null && (className = intent.getComponent().getClassName()) != null) {
                if ((className.contains("QQBrowserActivity") || className.contains("QQBrowserDelegationActivity")) && !intent.hasExtra("StartClickTime")) {
                    intent.putExtra("StartClickTime", SystemClock.elapsedRealtime());
                    intent.putExtra("SourceActivityName", context.getClass().getSimpleName());
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean handleStartPluginFailed(Throwable th5) {
        boolean z16;
        boolean z17 = false;
        if (!(th5 instanceof FileNotFoundException) && (th5.getMessage() == null || !th5.getMessage().contains(QCircleDaTongConstant.ElementParamValue.PERMISSION))) {
            if (th5 instanceof Resources.NotFoundException) {
                showNeedUninstanllAndInstallDialog();
            } else {
                if (!(th5 instanceof ClassNotFoundException) && !(th5 instanceof PluginUtils.GetPackageInfoFailException)) {
                    return shouldHandleStartPluginFailed(this.mCreateErrorInfo);
                }
                QLog.d("plugin_tag", 1, "" + this.mPluginApkFilePath + ", leftSpace(B) = " + getAvailableInnernalMemorySize());
                PluginRecoverReceiver.broadcast(this, this.mPluginID);
                return false;
            }
        } else {
            QLog.d("plugin_tag", 1, "" + this.mPluginApkFilePath);
            ApplicationInfo applicationInfo = getApplicationInfo();
            if (applicationInfo != null) {
                int i3 = applicationInfo.flags;
                if ((i3 & 1) > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((i3 & 128) > 0) {
                    z17 = true;
                }
                QLog.d("plugin_tag", 1, "UID: " + applicationInfo.uid + ", IsSystemApp: " + z16 + ", IsUpdateSystemApp: " + z17);
                Intent intent = new Intent(ACTION_PLUGIN_DIR_INFO_LOG);
                intent.setPackage(BaseApplication.getContext().getPackageName());
                sendBroadcast(intent);
            }
            showNeedUninstanllAndInstallDialog();
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    private void initPlugin() throws Exception {
        ConcurrentHashMap<String, PackageInfo> concurrentHashMap = PluginStatic.sPackageInfoMap;
        PackageInfo packageInfo = concurrentHashMap.get(this.mPluginApkFilePath);
        if (packageInfo == null) {
            if (DebugHelper.sDebug) {
                DebugHelper.log("PluginProxyActivity.initPlugin start getPackageInfo");
            }
            try {
                packageInfo = ApkFileParser.getPackageInfoWithException(this, this.mPluginApkFilePath, 129);
                if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity.initPlugin end getPackageInfo, " + packageInfo);
                }
                if (packageInfo != null) {
                    concurrentHashMap.put(this.mPluginApkFilePath, packageInfo);
                } else {
                    throw new PluginUtils.GetPackageInfoFailException("Get Package Info Failed!");
                }
            } catch (Throwable th5) {
                throw new PluginUtils.GetPackageInfoFailException("getPackageInfoWithException", th5);
            }
        }
        PackageInfo packageInfo2 = packageInfo;
        IPluginManifestChecker iPluginManifestChecker = sChecker;
        if (iPluginManifestChecker != null) {
            iPluginManifestChecker.doCheck(this.mPluginID, this.mLaunchActivity);
        }
        String str = this.mLaunchActivity;
        if (str == null || str.length() == 0) {
            ActivityInfo[] activityInfoArr = packageInfo2.activities;
            if (activityInfoArr != null && activityInfoArr.length != 0) {
                this.mLaunchActivity = activityInfoArr[0].name;
            } else {
                throw new PluginUtils.PluginActivityNotFoundException();
            }
        }
        ClassLoader orCreateClassLoaderByPath = PluginStatic.getOrCreateClassLoaderByPath(this, this.mPluginID, this.mPluginApkFilePath, true);
        getIntent().setExtrasClassLoader(orCreateClassLoaderByPath);
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
        }
        this.mClassLaunchActivity = orCreateClassLoaderByPath.loadClass(this.mLaunchActivity);
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
        }
        IPluginActivity iPluginActivity = (IPluginActivity) this.mClassLaunchActivity.newInstance();
        this.mPluginActivity = iPluginActivity;
        iPluginActivity.IInit(this.mPluginID, this.mPluginApkFilePath, this, orCreateClassLoaderByPath, packageInfo2, this.mUseSkinEngine, this.mPluginResoucesType);
        Intent intent = new Intent(getIntent());
        Bundle bundleExtra = intent.getBundleExtra(INNER_INTENT_EXTRAS);
        if (bundleExtra != null) {
            intent.putExtras(bundleExtra);
            intent.removeExtra(INNER_INTENT_EXTRAS);
        }
        this.mPluginActivity.ISetIntent(intent);
    }

    private boolean isActivityLocaleUpdated(Locale locale2) {
        Locale locale3 = locale;
        if (locale3 == null || locale2 == null) {
            return false;
        }
        boolean equals = locale3.getLanguage().equals(locale2.getLanguage());
        boolean equals2 = locale.getCountry().equals(locale2.getCountry());
        if (equals && equals2) {
            return false;
        }
        return true;
    }

    private boolean isAppOnForeground() {
        try {
            int i3 = GesturePWDUtils.f213636a;
            Object invoke = GesturePWDUtils.class.getMethod("isAppOnForegroundByTasks", Context.class).invoke(GesturePWDUtils.class, this);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMoveTaskToBack(Context context, Intent intent) {
        if (intent.getComponent() == null || !intent.getComponent().getPackageName().equals(context.getPackageName())) {
            return true;
        }
        return false;
    }

    private boolean isStartQQ3rdApp(Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && action.equals("android.media.action.IMAGE_CAPTURE")) {
            return true;
        }
        if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.GET_CONTENT")) {
            return true;
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            if (!TextUtils.isEmpty(packageName) && packageName.equals("com.qzone")) {
                return true;
            }
            String className = component.getClassName();
            if (!TextUtils.isEmpty(className) && className.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void openActivity(Context context, String str, String str2, String str3, String str4, Intent intent) {
        intent.putExtra("pluginsdk_pluginName", str);
        intent.putExtra("pluginsdk_pluginLocation", str2);
        intent.putExtra("pluginsdk_launchActivity", str4);
        intent.putExtra("pluginsdk_pluginpath", str3);
        try {
            context.startActivity(intent);
        } catch (Throwable th5) {
            QLog.d("plugin_tag", 1, "", th5);
        }
    }

    public static void openActivityForResult(Activity activity, String str, String str2, String str3, String str4, Intent intent, int i3) {
        intent.putExtra("pluginsdk_pluginName", str);
        intent.putExtra("pluginsdk_pluginLocation", str2);
        intent.putExtra("pluginsdk_launchActivity", str4);
        intent.putExtra("pluginsdk_pluginpath", str3);
        try {
            activity.startActivityForResult(intent, i3);
        } catch (Throwable th5) {
            QLog.d("plugin_tag", 1, "", th5);
        }
    }

    private void safeShowToast(Context context, String str, int i3) {
        try {
            QLog.e("plugin_tag", 1, str);
        } catch (Throwable unused) {
        }
    }

    private void sendLaunchCompletedBroadcast() {
        Intent intent = new Intent("action_launch_completed");
        intent.putExtra("plugin_apk", this.mPluginID);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        sendBroadcast(intent);
    }

    public static void setActivityDispatchCallback(IActivityDispatchCallback iActivityDispatchCallback) {
        sActivityDispatchCallback = iActivityDispatchCallback;
    }

    private void setAppForground(Context context, boolean z16) {
        try {
            int i3 = GesturePWDUtils.f213636a;
            GesturePWDUtils.class.getMethod("setAppForground", Context.class, Boolean.TYPE).invoke(GesturePWDUtils.class, this, Boolean.valueOf(z16));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void setClassLoaderToEveryBundle(Bundle bundle, ClassLoader classLoader) throws Exception {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (sUnparcelMethod == null || sMMapField == null) {
            Class<? super Object> superclass = bundle.getClass().getSuperclass();
            Method declaredMethod = superclass.getDeclaredMethod("unparcel", new Class[0]);
            sUnparcelMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            Field declaredField = superclass.getDeclaredField("mMap");
            sMMapField = declaredField;
            declaredField.setAccessible(true);
        }
        sUnparcelMethod.invoke(bundle, new Object[0]);
        Map map = (Map) sMMapField.get(bundle);
        if (map != null) {
            for (Object obj : map.values()) {
                if (obj instanceof Bundle) {
                    setClassLoaderToEveryBundle((Bundle) obj, classLoader);
                }
            }
        }
    }

    private void setCurrentUinForPlugin(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int i3 = GesturePWDUtils.f213636a;
            GesturePWDUtils.class.getMethod("setUinForPlugin", Context.class, String.class).invoke(GesturePWDUtils.class, this, str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void showLaunchPluginFail() {
        String str = this.mCreateErrorInfo;
        if (str != null) {
            if (!str.contains("\u7a7a\u95f4") && !this.mCreateErrorInfo.contains("Space")) {
                safeShowToast(BaseApplication.getContext(), this.mPluginName + "\u542f\u52a8\u5931\u8d25!", 0);
                return;
            }
            safeShowToast(BaseApplication.getContext(), "\u7cfb\u7edf\u53ef\u7528\u5185\u5b58\u4e0d\u8db3\uff0c" + this.mPluginName + "\u542f\u52a8\u5931\u8d25!", 0);
        }
    }

    public static void uploadLaunchInfoWhenCreateClassLoader(String str, Intent intent) {
        long j3;
        try {
            Bundle extras = intent.getExtras();
            String string = extras.getString("pluginsdk_pluginLocation");
            ConcurrentHashMap<String, Long> concurrentHashMap = PluginStatic.sClassLoaderStartTimeMap;
            Long l3 = concurrentHashMap.get(string);
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = -1;
            }
            if (j3 > 0) {
                BaseApplication context = BaseApplication.getContext();
                long currentTimeMillis = System.currentTimeMillis() - intent.getLongExtra(PluginConst.STAT_LAUNCH_TIME_START, 0L);
                concurrentHashMap.put(string, 0L);
                if (extras.getString("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector") != null) {
                    Intent intent2 = new Intent(ACTION_PLUGIN_STARTUP_SPEED_INFO);
                    intent2.putExtras(extras);
                    intent2.putExtra(PluginConst.STAT_LAUNCH_TOTAL, currentTimeMillis);
                    intent2.putExtra(PluginConst.STAT_LAUNCH_CLASSLOADER, j3);
                    intent2.putExtra(PluginConst.STAT_LAUNCH_COMPONENT, str);
                    intent2.putExtra(PluginConst.STAT_LAUNCH_PROCESS, MobileQQ.processName);
                    intent2.setPackage(context.getPackageName());
                    ThreadManagerV2.excute(new Runnable(context, intent2) { // from class: com.tencent.mobileqq.pluginsdk.PluginProxyActivity.2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Context val$context;
                        final /* synthetic */ Intent val$targetIntent;

                        {
                            this.val$context = context;
                            this.val$targetIntent = intent2;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) intent2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                this.val$context.sendBroadcast(this.val$targetIntent);
                            }
                        }
                    }, 16, null, false);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void uploadStartupResult(String str, String str2, String str3, String str4) {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("clsUploader");
        String stringExtra2 = intent.getStringExtra(PluginStatic.PARAM_UIN);
        if (stringExtra != null) {
            Intent intent2 = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
            intent2.putExtra(PluginStatic.PARAM_UIN, stringExtra2);
            intent2.putExtra("pluginsdk_pluginName", str);
            intent2.putExtra("pluginsdk_pluginLocation", str2);
            intent2.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
            intent2.putExtra("pluginsdk_launchActivity", str3);
            intent2.putExtra(PluginStatic.PARAM_EXTRA_INFO, str4);
            intent2.putExtra("clsUploader", stringExtra);
            intent2.setPackage(BaseApplication.getContext().getPackageName());
            sendBroadcast(intent2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this, (Object) str)).intValue();
        }
        return super.checkSelfPermission(str);
    }

    protected boolean compatibleAndroidOreo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            dispatchTouchEvent = ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) motionEvent)).booleanValue();
        } else {
            IActivityDispatchCallback iActivityDispatchCallback = sActivityDispatchCallback;
            if (iActivityDispatchCallback != null) {
                iActivityDispatchCallback.disaptchTouchEventCallback(this, motionEvent);
            }
            IPluginActivity iPluginActivity = this.mPluginActivity;
            if (iPluginActivity != null) {
                dispatchTouchEvent = iPluginActivity.IDispatchTouchEvent(motionEvent);
            } else {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            }
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    protected boolean enablePatternLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return mGestureLockEnable;
    }

    public boolean getGestureLock(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        try {
            int i3 = GesturePWDUtils.f213636a;
            Object invoke = GesturePWDUtils.class.getMethod("getJumpLock", Context.class, String.class).invoke(GesturePWDUtils.class, this, mUin);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public int getIsSupportImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        try {
            String str = ImmersiveUtils.TAG;
            Object invoke = ImmersiveUtils.class.getMethod("isSupporImmersive", new Class[0]).invoke(ImmersiveUtils.class, new Object[0]);
            DebugHelper.log("getIsSupportImmersive ret=" + invoke);
            if (invoke instanceof Integer) {
                return ((Integer) invoke).intValue();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("pluginProxy", 2, "getIsSupportImmersive e=" + e16);
        }
        return 0;
    }

    public final String getPluginActivity() {
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = this.mLaunchActivity;
        if (TextUtils.isEmpty(str) && (extras = getIntent().getExtras()) != null) {
            return extras.getString("pluginsdk_launchActivity");
        }
        return str;
    }

    @Deprecated
    public String getPluginID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<? extends PluginProxyActivity> getProxyActivity(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Class) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        }
        return getClass();
    }

    protected void handleCrash(Bundle bundle, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) bundle, (Object) th5);
        }
    }

    public void initImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        Object obj = this.msystemBar;
        if (obj != null) {
            try {
                Method method = obj.getClass().getMethod("init", new Class[0]);
                method.setAccessible(true);
                method.invoke(this.msystemBar, new Object[0]);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    protected boolean isPatternLockOpened() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return getGestureLock(this, mUin);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isWrapContent() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            z16 = iPluginActivity.IIsWrapContent();
        } else {
            z16 = true;
        }
        DebugHelper.debug("PluginProxyActivity.isWrapContent: " + z16 + ", from = " + this.mPluginActivity);
        return z16;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (this.mPluginActivity != null) {
            try {
                ClassLoader classLoader = PluginStatic.getClassLoader(this.mPluginID);
                if (classLoader != null && intent != null) {
                    intent.setExtrasClassLoader(classLoader);
                }
                this.mPluginActivity.IOnActivityResult(i3, i16, intent);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.mCanLock = false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            z16 = iPluginActivity.IOnBackPressed();
        } else {
            z16 = false;
        }
        if (!z16) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        FlingHandler flingHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            IPluginActivity iPluginActivity = this.mPluginActivity;
            if (iPluginActivity != null) {
                iPluginActivity.IOnConfigurationChanged(configuration);
            }
            if (isWrapContent() && (flingHandler = this.mFlingHandler) != null) {
                flingHandler.onConfigurationChanged(configuration);
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0283  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Bundle bundle2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity onCreate");
        }
        this.mAndroidOreoUtils = new AndroidOreoUtils(this);
        if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(resources.getDisplayMetrics());
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            resources.getDisplayMetrics().setTo(displayMetrics);
        }
        MobileQQ.sMobileQQ.addCommonActivity(this);
        IPluginProxyComponent.registerAccountReceiverIfNeccessary();
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity onCreate.registerAccountReceiverIfNeccessary");
        }
        IllegalArgumentException illegalArgumentException = null;
        if (bundle != null) {
            bundle2 = bundle.getBundle(INNER_BUNDLE);
            extras = bundle;
        } else {
            extras = getIntent().getExtras();
            bundle2 = null;
        }
        if (!PluginStatic.isValidPluginIntent(extras)) {
            if (Build.VERSION.SDK_INT == 26 && compatibleAndroidOreo() && getApplicationInfo().targetSdkVersion >= 27 && this.mAndroidOreoUtils.isTranslucentOrFloating()) {
                QLog.i(TAG, 1, "onCreate fixOrientation when Oreo, result1 = " + this.mAndroidOreoUtils.fixOrientation());
            }
            super.onCreate(bundle);
            finish();
            return;
        }
        this.mPluginName = extras.getString("pluginsdk_pluginName");
        this.mPluginID = extras.getString("pluginsdk_pluginLocation");
        this.mLaunchActivity = extras.getString("pluginsdk_launchActivity");
        boolean z16 = false;
        this.mUseSkinEngine = extras.getBoolean(PluginStatic.PARAM_USE_SKIN_ENGINE, false);
        this.mPluginResoucesType = extras.getInt(PluginStatic.PARAM_USE_QQ_RESOURCES, 0);
        this.mPluginApkFilePath = extras.getString("pluginsdk_pluginpath");
        if (MobileQQ.sIsToolProc && (i3 = this.mPluginResoucesType) != 1 && i3 != 2) {
            throw new IllegalArgumentException("\u5de5\u5177\u8fdb\u7a0b\uff08\u5bb9\u5668\u8fdb\u7a0b\uff09\u5fc5\u987b\u5b9e\u73b0\u591a\u8d44\u6e90");
        }
        PluginRecoverReceiver.addCarePluginId(this.mPluginID);
        if (TextUtils.isEmpty(this.mPluginApkFilePath)) {
            try {
                this.mPluginApkFilePath = PluginUtils.getInstalledPluginPath(this, this.mPluginID).getCanonicalPath();
            } catch (Exception unused) {
            }
        }
        String string = extras.getString(PluginStatic.PARAM_UIN);
        this.mUinString = string;
        if (!TextUtils.isEmpty(string)) {
            String str = this.mUinString;
            mUin = str;
            setCurrentUinForPlugin(this, str);
        } else {
            mUin = getCurrentUinForPlugin(this);
        }
        if (!TextUtils.isEmpty(mUin)) {
            IPluginAdapterProxy.getProxy().currentUin = mUin;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity onCreate.fetchParams mUin " + mUin);
        }
        boolean z17 = extras.getBoolean(PluginStatic.PARAM_PLUGIN_GESTURELOCK, false);
        this.mPluginGestureLock = z17;
        if (z17 || getEnableGestureLock(this)) {
            mGestureLockEnable = true;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity onCreate start registerReceiver");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        try {
            registerReceiver(this.mScreenOffReceiver, intentFilter);
        } catch (Exception e16) {
            if (DebugHelper.sDebug) {
                DebugHelper.log("plugin_tag", "register exception.", e16);
            }
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyActivity.onCreate Params:" + this.mPluginID + ", " + this.mLaunchActivity);
        }
        String str2 = this.mPluginID;
        if (str2 != null && str2.length() != 0) {
            try {
                if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate start initPlugin");
                }
                initPlugin();
                if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate end initPlugin");
                }
                uploadLaunchInfoWhenCreateClassLoader(this.mLaunchActivity, getIntent());
                this.mPluginActivity.IOnSetTheme();
                if (Build.VERSION.SDK_INT == 26 && compatibleAndroidOreo() && getApplicationInfo().targetSdkVersion >= 27 && this.mAndroidOreoUtils.isTranslucentOrFloating()) {
                    QLog.i(TAG, 1, "onCreate fixOrientation when Oreo, result2 = " + this.mAndroidOreoUtils.fixOrientation());
                }
                if (bundle2 != null) {
                    bundle2.setClassLoader(PluginStatic.getClassLoader(this.mPluginID));
                }
                super.onCreate(bundle);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate start IOnCreate");
                }
                this.mPluginActivity.IOnCreate(bundle2);
                if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate end IOnCreate");
                }
                z16 = true;
            } catch (Throwable th6) {
                th = th6;
                z16 = true;
                this.mPluginActivity = null;
                th.printStackTrace();
                PluginRuntime.handleCrash(th, this.mPluginID, this);
                handleCrash(extras, th);
                illegalArgumentException = th;
                if (!z16) {
                }
                if (illegalArgumentException == null) {
                }
                uploadStartupResult(this.mPluginName, this.mPluginID, this.mLaunchActivity, this.mCreateErrorInfo);
                if (DebugHelper.sDebug) {
                }
                sendLaunchCompletedBroadcast();
                setStatusTrans();
            }
        } else {
            illegalArgumentException = new IllegalArgumentException("Param mPluingLocation missing!");
        }
        if (!z16) {
            if (Build.VERSION.SDK_INT == 26 && compatibleAndroidOreo() && getApplicationInfo().targetSdkVersion >= 27 && this.mAndroidOreoUtils.isTranslucentOrFloating()) {
                QLog.i(TAG, 1, "onCreate fixOrientation when Oreo, result3 = " + this.mAndroidOreoUtils.fixOrientation());
            }
            try {
                super.onCreate(bundle);
            } catch (Exception e17) {
                QLog.e(TAG, 1, "super onCreate error: ", e17);
            }
        }
        if (illegalArgumentException == null) {
            this.mCreateErrorInfo = PluginUtils.getExceptionInfo(illegalArgumentException);
            if (DebugHelper.sDebug) {
                DebugHelper.log("PluginProxyActivity.onCreate startPlugin:" + this.mPluginName + ", " + this.mCreateErrorInfo);
            }
            if (!handleStartPluginFailed(illegalArgumentException)) {
                showLaunchPluginFail();
                finish();
            }
        } else {
            this.mCreateErrorInfo = "success";
            if (DebugHelper.sDebug) {
                DebugHelper.log("PluginProxyActivity.onCreate Success");
            }
            Bundle extras2 = getIntent().getExtras();
            if (extras2 != null) {
                int i16 = extras2.getInt(FlingConstant.FLING_ACTION_KEY);
                if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity.onCreate FLING_ACTION_KEY: " + i16 + ", from: " + extras2);
                }
                if (i16 != 0 && isWrapContent()) {
                    if (1 == i16) {
                        this.mFlingHandler = new FlingTrackerHandler(this);
                    } else {
                        this.mFlingHandler = new FlingGestureHandler(this);
                    }
                }
            }
        }
        uploadStartupResult(this.mPluginName, this.mPluginID, this.mLaunchActivity, this.mCreateErrorInfo);
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyActivity onCreate start sendLaunchCompletedBroadcast");
        }
        sendLaunchCompletedBroadcast();
        setStatusTrans();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) menu)).booleanValue();
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            return iPluginActivity.IOnCreateOptionsMenu(menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onDestroy();
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            try {
                iPluginActivity.IOnDestroy();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity onDestroy");
        }
        try {
            unregisterReceiver(this.mScreenOffReceiver);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        MobileQQ.sMobileQQ.removeCommonActivity(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            z16 = iPluginActivity.IOnKeyDown(i3, keyEvent);
        } else {
            z16 = false;
        }
        if (!z16) {
            return super.onKeyDown(i3, keyEvent);
        }
        return z16;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, i3, (Object) menuItem)).booleanValue();
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            return iPluginActivity.IOnMenuItemSelected(i3, menuItem);
        }
        return super.onMenuItemSelected(i3, menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        if (TextUtils.isEmpty(this.mPluginID)) {
            QLog.w(TAG, 1, "plugin id is null in onNewIntent!");
            return;
        }
        ClassLoader classLoader = PluginStatic.getClassLoader(this.mPluginID);
        if (classLoader != null) {
            intent.setExtrasClassLoader(classLoader);
        }
        if (this.mPluginActivity != null) {
            Intent intent2 = new Intent(intent);
            intent2.setExtrasClassLoader(classLoader);
            Bundle bundleExtra = intent2.getBundleExtra(INNER_INTENT_EXTRAS);
            if (bundleExtra != null) {
                intent2.putExtras(bundleExtra);
                intent2.removeExtra(INNER_INTENT_EXTRAS);
            }
            this.mPluginActivity.IOnNewIntent(intent2);
        }
        String str = this.mPluginID;
        if (str != null && !str.equals("BuscardPlugin.apk") && intent != null && "android.nfc.action.TECH_DISCOVERED".equals(intent.getAction())) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "go buscard plugin");
            }
            try {
                ActivityLifecycle.onNewIntent(this, intent);
            } catch (Throwable unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "onNewIntent failed");
                }
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) menuItem)).booleanValue();
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            return iPluginActivity.IOnOptionsItemSelected(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onPause();
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            iPluginActivity.IOnPause();
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity.onPause");
        }
        String str = this.mPluginID;
        if (str != null && !str.equals("BuscardPlugin.apk")) {
            try {
                ActivityLifecycle.onPause(this);
            } catch (Throwable unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "disableNFCEvent failed");
                }
            }
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) menu)).booleanValue();
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            return iPluginActivity.IOnPrepareOptionsMenu(menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (iArr.length == 0) {
            return;
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            iPluginActivity.onRequestPermissionsResult(i3, strArr, iArr);
            return;
        }
        List list = this.mPermissionCallerMap.get(i3);
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj != null) {
                    if (obj instanceof QQPermissionCallback) {
                        QQPermissionCallback qQPermissionCallback = (QQPermissionCallback) obj;
                        ArrayList arrayList = new ArrayList();
                        for (int i16 = 0; i16 < iArr.length; i16++) {
                            if (iArr[i16] != 0) {
                                arrayList.add(strArr[i16]);
                            }
                        }
                        if (arrayList.size() > 0) {
                            qQPermissionCallback.deny(i3, strArr, iArr);
                        } else {
                            qQPermissionCallback.grant(i3, strArr, iArr);
                        }
                    } else {
                        QQPermissionHelper.requestResult(obj, i3, strArr, iArr);
                    }
                }
            }
        }
        if (list != null) {
            this.mPermissionCallerMap.remove(i3);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        super.onRestart();
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            iPluginActivity.IOnRestart();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) bundle);
            return;
        }
        ClassLoader classLoader = PluginStatic.getClassLoader(this.mPluginID);
        if (classLoader != null) {
            try {
                setClassLoaderToEveryBundle(bundle, classLoader);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        super.onRestoreInstanceState(bundle);
        if (this.mPluginActivity != null) {
            Bundle bundle2 = bundle.getBundle(INNER_BUNDLE);
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.setClassLoader(classLoader);
            this.mPluginActivity.IOnRestoreInstanceState(bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            super.onResume();
        } catch (Exception unused) {
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity.onResume");
        }
        if (DebugHelper.sDebug && this.mPluginActivity != null) {
            QLog.d("pluginProxy", 2, "onresume mPluginActivity=" + this.mPluginActivity + "isNeedColor=" + this.mPluginActivity.IgetImmersiveConfig().isNeedColor + "need =" + this.mActNeedImmersive);
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null && iPluginActivity.IgetImmersiveConfig().isNeedColor && this.mActNeedImmersive && this.msystemBar == null) {
            setImmersiveBar(this, true, this.mPluginActivity.IgetImmersiveConfig().mStatusColor);
            Drawable drawable = this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable;
            if (IPluginAdapterProxy.getProxy().isDefaultMode() && this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable != null) {
                setStatusDrawable(this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable);
            }
            initImmersive();
        }
        IPluginActivity iPluginActivity2 = this.mPluginActivity;
        if (iPluginActivity2 != null) {
            iPluginActivity2.IOnResume();
        }
        mAppForground = getAppForground(this);
        if (enablePatternLock() && !mAppForground && !TextUtils.isEmpty(mUin) && isPatternLockOpened() && this.mCanLock) {
            startUnlockActivity(true);
        }
        if (!mAppForground) {
            mAppForground = true;
            setAppForground(this, true);
        }
        this.mStopFlag = 0;
        this.mCanLock = true;
        String str = this.mPluginID;
        if (str != null && !str.equals("BuscardPlugin.apk")) {
            try {
                ActivityLifecycle.onResume(this);
            } catch (Throwable unused2) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "registerNFCEvent failed");
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) bundle);
            return;
        }
        if (this.mPluginActivity != null) {
            Bundle bundle2 = bundle.getBundle(INNER_BUNDLE);
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(INNER_BUNDLE, bundle2);
            }
            this.mPluginActivity.IOnSaveInstanceState(bundle2);
        }
        bundle.putString("pluginsdk_pluginName", this.mPluginName);
        bundle.putString("pluginsdk_pluginLocation", this.mPluginID);
        bundle.putString("pluginsdk_pluginpath", this.mPluginApkFilePath);
        bundle.putString("pluginsdk_launchActivity", this.mLaunchActivity);
        bundle.putBoolean(PluginStatic.PARAM_USE_SKIN_ENGINE, this.mUseSkinEngine);
        bundle.putInt(PluginStatic.PARAM_USE_QQ_RESOURCES, this.mPluginResoucesType);
        bundle.putString(PluginStatic.PARAM_UIN, this.mUinString);
        bundle.putBoolean(PluginStatic.PARAM_PLUGIN_GESTURELOCK, this.mPluginGestureLock);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        FlingHandler flingHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onStart();
        if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
            recreate();
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            iPluginActivity.IOnStart();
        }
        if (this.mIsShowQQBackgroundIcon) {
            Intent intent = new Intent("tencent.notify.foreground");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("selfuin", "");
            sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        }
        if (isWrapContent() && (flingHandler = this.mFlingHandler) != null) {
            flingHandler.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onStop();
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            iPluginActivity.IOnStop();
        }
        boolean isAppOnForeground = isAppOnForeground();
        mAppForground = isAppOnForeground;
        if (!isAppOnForeground) {
            setAppForground(this, isAppOnForeground);
        }
        this.mStopFlag = 1;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) motionEvent)).booleanValue();
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            return iPluginActivity.IOnTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            iPluginActivity.IOnUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onUserLeaveHint();
        if (this.mIsShowQQBackgroundIcon) {
            Intent intent = new Intent("tencent.notify.background");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("selfuin", "");
            intent.putExtra("classname", getClass().getName());
            try {
                sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        IActivityDispatchCallback iActivityDispatchCallback = sActivityDispatchCallback;
        if (iActivityDispatchCallback != null) {
            iActivityDispatchCallback.onWindowFocusChanged(this, z16);
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            iPluginActivity.IOnWindowFocusChanged(z16);
        }
    }

    @TargetApi(24)
    public void requestPermissions(Object obj, int i3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, obj, Integer.valueOf(i3), strArr);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            List list = this.mPermissionCallerMap.get(i3);
            if (list == null) {
                list = new ArrayList();
            }
            int size = list.size();
            int i16 = 0;
            while (true) {
                if (i16 < size) {
                    Object obj2 = list.get(i16);
                    if (obj2 != null && obj2 == obj) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                list.add(obj);
                this.mPermissionCallerMap.put(i3, list);
            }
            requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i3);
            return;
        }
        if (obj instanceof QQPermissionCallback) {
            QQPermissionCallback qQPermissionCallback = (QQPermissionCallback) obj;
            if (getApplicationInfo().targetSdkVersion < 23) {
                qQPermissionCallback.grant(i3, strArr, null);
                return;
            }
            return;
        }
        QQPermissionHelper.doExecuteSuccess(obj, i3);
    }

    public void setImmersiveBar(Activity activity, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, activity, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        try {
            SystemBarCompact.class.getDeclaredConstructors();
            this.msystemBar = SystemBarCompact.class.getConstructor(Activity.class, Boolean.TYPE, Integer.TYPE).newInstance(activity, Boolean.valueOf(z16), Integer.valueOf(i3));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (this.mAndroidOreoUtils == null) {
            this.mAndroidOreoUtils = new AndroidOreoUtils(this);
        }
        if (Build.VERSION.SDK_INT == 26 && compatibleAndroidOreo() && getApplicationInfo().targetSdkVersion >= 27 && this.mAndroidOreoUtils.isTranslucentOrFloating()) {
            AndroidOreoUtils androidOreoUtils = this.mAndroidOreoUtils;
            if (androidOreoUtils.isFixedOrientation(androidOreoUtils.getCurrentActivityInfo(), i3)) {
                QLog.i(TAG, 1, "avoid calling setRequestedOrientation when Oreo.");
                return;
            }
        }
        super.setRequestedOrientation(i3);
    }

    public void setStatusDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) drawable);
            return;
        }
        Object obj = this.msystemBar;
        if (obj != null) {
            try {
                Method method = obj.getClass().getMethod("setStatusDrawable", Drawable.class);
                method.setAccessible(true);
                method.invoke(this.msystemBar, drawable);
            } catch (Exception e16) {
                QLog.d("pluginProxy", 2, "getMethod e=" + e16);
                e16.printStackTrace();
            }
        }
    }

    public void setStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        DebugHelper.log("setStatusTrans getIsSupportImmersive=" + getIsSupportImmersive());
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null && this.mNeedStatusTrans && iPluginActivity.IgetImmersiveConfig().isTranslate && getIsSupportImmersive() == 1) {
            try {
                getWindow().addFlags(67108864);
            } catch (Exception e16) {
                DebugHelper.log(TAG, "add flags error!", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldHandleStartPluginFailed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showNeedUninstanllAndInstallDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("\u6e29\u99a8\u63d0\u793a");
        builder.setMessage("\u542f\u52a8" + this.mPluginName + "\u5931\u8d25\uff0c\u8bf7\u5378\u8f7d\u91cd\u88c5~");
        builder.setPositiveButton("\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.pluginsdk.PluginProxyActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PluginProxyActivity.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    PluginProxyActivity.this.finish();
                }
            }
        });
        AlertDialog create = builder.create();
        try {
            if (!isFinishing()) {
                create.show();
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) intent, i3);
            return;
        }
        handleIntentForQQBrowser(this, intent);
        if (intent.getBooleanExtra("pluginsdk_IsPluginActivity", false)) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            intent.putExtra("pluginsdk_IsPluginActivity", false);
            if (className != null && className.length() > 0) {
                startPluginActivityForResult(this, className, intent, i3);
            }
        } else {
            startActivityForResult(intent, i3, 2);
        }
        this.mStopFlag = 2;
    }

    public void startActivityForResultWithGesture(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, intent, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        intent.putExtra(FlingConstant.FLING_ACTION_KEY, 2);
        intent.putExtra(FlingConstant.FLING_CODE_KEY, i16);
        super.startActivityForResult(intent, i3);
    }

    public void startActivityForResultWithSnap(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, intent, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity.startActivityForResultWithSnap:" + i16);
        }
        String snapPath = ScreenCapture.getSnapPath(this, i16);
        if (snapPath != null) {
            ScreenCapture.captureViewToFile(snapPath, getWindow().getDecorView());
            intent.putExtra(FlingConstant.FLING_ACTION_KEY, 1);
            intent.putExtra(FlingConstant.FLING_CODE_KEY, i16);
        }
        super.startActivityForResult(intent, i3);
    }

    protected void startPluginActivityForResult(Activity activity, String str, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, activity, str, intent, Integer.valueOf(i3));
            return;
        }
        Intent intent2 = new Intent(activity, getProxyActivity(str));
        intent2.putExtra("pluginsdk_pluginName", this.mPluginName);
        intent2.putExtra("pluginsdk_pluginLocation", this.mPluginID);
        intent2.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
        intent2.putExtra("pluginsdk_launchActivity", str);
        intent2.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, this.mUseSkinEngine);
        int i16 = this.mPluginResoucesType;
        if (i16 == 1 || i16 == -1 || i16 == 2) {
            intent2.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, i16);
        }
        if (intent != null) {
            intent2.addFlags(intent.getFlags());
            intent2.putExtra(INNER_INTENT_EXTRAS, new Bundle(intent.getExtras()));
        }
        activity.startActivityForResult(intent2, i3);
    }

    protected void startUnlockActivity(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
            return;
        }
        try {
            int i3 = GesturePWDUnlockActivity.GESTUREPWD_LENGHT_MIN;
            startActivity(new Intent(this, (Class<?>) GesturePWDUnlockActivity.class));
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    public void superStartActivityForResult(Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, intent, Integer.valueOf(i3), bundle);
        } else {
            super.startActivityForResult(intent, i3, bundle);
        }
    }

    public void startActivityForResultWithGesture(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 42)) {
            startActivityForResultWithGesture(intent, i3, hashCode());
        } else {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) intent, i3);
        }
    }

    public static void openActivity(Context context, Intent intent, StartActivityParams startActivityParams) {
        try {
            Intent intent2 = new Intent(context, startActivityParams.loader.loadClass(startActivityParams.proxyActivity));
            intent2.putExtra("pluginsdk_pluginName", startActivityParams.mPluginName);
            intent2.putExtra("pluginsdk_pluginLocation", startActivityParams.mPluginID);
            intent2.putExtra("pluginsdk_pluginpath", startActivityParams.mPluginApkFilePath);
            intent2.putExtra("pluginsdk_launchActivity", startActivityParams.launchActivity);
            intent2.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, startActivityParams.mUseSkinEngine);
            int i3 = startActivityParams.mPluginResoucesType;
            if (i3 == 1 || i3 == -1 || i3 == 2) {
                intent2.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, i3);
            }
            intent2.putExtra(PluginStatic.PARAM_UIN, IPluginAdapterProxy.getProxy().currentUin);
            if (intent != null) {
                intent2.addFlags(intent.getFlags());
                intent2.putExtra(INNER_INTENT_EXTRAS, new Bundle(intent.getExtras()));
            }
            context.startActivity(intent2);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    public void startActivityForResultWithSnap(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
            startActivityForResultWithSnap(intent, i3, hashCode());
        } else {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) intent, i3);
        }
    }

    public void startActivityForResult(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, intent, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mStopFlag = 2;
        if (isStartQQ3rdApp(intent)) {
            this.mCanLock = false;
        }
        if (!isMoveTaskToBack(this, intent)) {
            intent.addFlags(262144);
        }
        if (i16 == 0) {
            super.startActivityForResult(intent, i3);
            return;
        }
        if (i16 == 1) {
            super.startActivityForResult(intent, i3);
        } else if (i16 != 2) {
            super.startActivityForResult(intent, i3);
        } else {
            startActivityForResultWithGesture(intent, i3);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, intent, Integer.valueOf(i3), bundle);
            return;
        }
        intent.putExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY, getPluginActivity());
        intent.putExtra("preAct_time", System.currentTimeMillis());
        FileProvider7Helper.intentCompatForN(this, intent);
        ThirdAppReportHelper.startActivityForResult(this, intent, i3, bundle);
    }
}
