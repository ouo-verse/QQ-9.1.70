package com.tencent.midas.plugin;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogUtil;
import com.tencent.midas.comm.APPluginDataStorage;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.jsbridge.APX5;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import dalvik.system.DexClassLoader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes9.dex */
public class APPluginProxyActivity extends Activity {
    private static final String TAG = "APPluginProxyActivity";
    private static boolean cutOutEnable = false;
    private static String gPluginApkFilePath = null;
    protected static String gPluginName = "MidasPay";
    public static boolean mAppForground = true;
    private static Field sMMapField;
    private static Method sUnparcelMethod;
    private String mLaunchActivity = null;
    private IAPPluginActivity mPluginActivity = null;
    private String mPluginApkFilePath = null;
    private String mPluginName = null;
    protected int mStopFlag = 0;
    protected String mCreateErrorInfo = null;

    private String initPlugin() throws Exception {
        PackageInfo packageInfo = APPluginStatic.sPackageInfoMap.get(this.mPluginApkFilePath);
        if (packageInfo == null) {
            packageInfo = APApkFileParser.getPackageInfo(this, this.mPluginApkFilePath, 1);
            if (packageInfo == null) {
                return "Get Package Info Failed!";
            }
            if (Build.VERSION.SDK_INT >= 28 && APPluginUtils.isInNewProcess(this)) {
                try {
                    WebView.setDataDirectorySuffix("midaspay");
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            try {
                if (!APX5.isX5WebView(this)) {
                    new QmWebview(this);
                }
                packageInfo.applicationInfo.sharedLibraryFiles = getApplicationInfo().sharedLibraryFiles;
                packageInfo.applicationInfo.sourceDir = getApplicationInfo().sourceDir;
                packageInfo.applicationInfo.publicSourceDir = getApplicationInfo().publicSourceDir;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            APPluginStatic.sPackageInfoMap.put(this.mPluginApkFilePath, packageInfo);
        }
        PackageInfo packageInfo2 = packageInfo;
        String str = this.mLaunchActivity;
        if (str == null || str.length() == 0) {
            ActivityInfo[] activityInfoArr = packageInfo2.activities;
            if (activityInfoArr != null && activityInfoArr.length != 0) {
                this.mLaunchActivity = activityInfoArr[0].name;
            } else {
                return "Activity Not Found!";
            }
        }
        DexClassLoader orCreateClassLoaderByPath = APPluginLoader.getOrCreateClassLoaderByPath(this, this.mPluginName, this.mPluginApkFilePath);
        getIntent().setExtrasClassLoader(orCreateClassLoaderByPath);
        IAPPluginActivity iAPPluginActivity = (IAPPluginActivity) orCreateClassLoaderByPath.loadClass(this.mLaunchActivity).newInstance();
        this.mPluginActivity = iAPPluginActivity;
        iAPPluginActivity.IInit(this.mPluginName, this.mPluginApkFilePath, this, orCreateClassLoaderByPath, packageInfo2);
        this.mPluginActivity.ISetIntent(getIntent());
        return null;
    }

    public static boolean isMoveTaskToBack(Context context, Intent intent) {
        if (intent.getComponent() == null || !intent.getComponent().getPackageName().equals(context.getPackageName())) {
            return true;
        }
        return false;
    }

    private boolean isStart3rdApp(Intent intent) {
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
            if (!TextUtils.isEmpty(packageName) && packageName.equals("com.tencent.midas.pay")) {
                return true;
            }
            String className = component.getClassName();
            if (!TextUtils.isEmpty(className) && className.equals("com.qzone")) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void logStartPluginErrInfo(String str) {
        boolean z16;
        if (!str.contains(QCircleDaTongConstant.ElementParamValue.PERMISSION) && !str.contains("filenotfoundexception")) {
            if (!str.contains("resources$notfoundexception") && !str.contains("resourcesnotfoundexception")) {
                str.contains("classnotfoundexception");
                return;
            }
            return;
        }
        APLog.i("logStartPluginErrInfo", "mPluginApkFilePath" + this.mPluginApkFilePath);
        ApplicationInfo applicationInfo = getApplicationInfo();
        if (applicationInfo != null) {
            int i3 = applicationInfo.flags;
            boolean z17 = false;
            if ((i3 & 1) > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((i3 & 128) > 0) {
                z17 = true;
            }
            APLog.d("", "UID: " + applicationInfo.uid + ", IsSystemApp: " + z16 + ", IsUpdateSystemApp: " + z17);
        }
    }

    public static void openActivityForResult(Activity activity, String str, String str2, String str3, Intent intent, int i3) {
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult pluginName\uff1a" + str);
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult contextActivity\uff1a" + activity);
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult apkFilePath\uff1a" + str2);
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent\uff1a" + intent.getClass().getSimpleName());
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent\uff1a" + intent.getClass().getCanonicalName());
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent\uff1a" + intent.getClass().getClassLoader());
        gPluginName = str;
        try {
            gPluginApkFilePath = APPluginInstallerAndUpdater.getInstallPath(activity, str).getCanonicalPath();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        intent.putExtra("pluginsdk_pluginName", str);
        intent.putExtra("pluginsdk_launchActivity", str3);
        intent.putExtra("pluginsdk_pluginpath", str2);
        APLog.d("APPLuginProxyActivity", "put is new process: " + APMidasPayHelper.isNewProcess);
        APLog.d("APPLuginProxyActivity", "put is log enable: " + APMidasPayHelper.isLogEnable());
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_IS_NEW_PROCESS, APMidasPayHelper.isNewProcess);
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_LOG_ENABLE, APMidasPayHelper.isLogEnable());
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_LOG_CALLBACK_CLASS_NAME, APMidasPayHelper.getLogCallbackClassName());
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_CutOut_ENABLE, APMidasPayHelper.cutoutEnable);
        try {
            Class<?> cls = Class.forName("com.tencent.tauth.Tencent");
            boolean z16 = false;
            Method method = cls.getMethod("isPermissionNotGranted", new Class[0]);
            method.setAccessible(true);
            if (!((Boolean) method.invoke(cls, new Object[0])).booleanValue()) {
                z16 = true;
            }
            intent.putExtra(APPluginStatic.PARAM_PLUGIN_OPENSDK_ENABLE, z16);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        try {
            activity.startActivityForResult(intent, i3);
        } catch (Throwable th6) {
            APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult Throwable:" + th6.toString());
        }
    }

    private static void setClassLoaderToEveryBundle(Bundle bundle, ClassLoader classLoader) throws Exception {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (sUnparcelMethod == null || sMMapField == null) {
            Class<?> cls = bundle.getClass();
            Method declaredMethod = cls.getDeclaredMethod("unparcel", new Class[0]);
            sUnparcelMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            Field declaredField = cls.getDeclaredField("mMap");
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

    private void startPluginActivityForResult(Activity activity, String str, Intent intent, int i3) {
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity startPluginActivityForResult.private");
        Intent intent2 = new Intent(activity, getProxyActivity(str));
        intent2.putExtra("pluginsdk_pluginName", this.mPluginName);
        intent2.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
        intent2.putExtra("pluginsdk_launchActivity", str);
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity setExtrasClassLoader before");
        intent2.setExtrasClassLoader(intent.getExtras().getClassLoader());
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity setExtrasClassLoader after");
        intent2.addFlags(intent.getFlags());
        intent2.putExtras(intent);
        activity.startActivityForResult(intent2, i3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            dispatchTouchEvent = iAPPluginActivity.IDispatchTouchEvent(motionEvent);
        } else {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    protected Class<? extends APPluginProxyActivity> getProxyActivity(String str) {
        return getClass();
    }

    protected boolean isWrapContent() {
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            return iAPPluginActivity.IIsWrapContent();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        APLog.i("APPLuginProxyActivity", "onActivityResult requestCode:" + i3 + " resultCode:" + i16 + " mPluginActivity:" + this.mPluginActivity);
        super.onActivityResult(i3, i16, intent);
        if (this.mPluginActivity != null) {
            try {
                ClassLoader classLoader = APPluginLoader.getClassLoader(this.mPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath()));
                if (classLoader != null && intent != null) {
                    intent.setExtrasClassLoader(classLoader);
                }
                this.mPluginActivity.IOnActivityResult(i3, i16, intent);
            } catch (Exception e16) {
                APLog.w("APPLuginProxyActivity onActivityResult", e16.toString());
                e16.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        DisplayCutout displayCutout;
        ViewGroup viewGroup;
        int safeInsetLeft;
        int safeInsetRight;
        int safeInsetTop;
        int safeInsetBottom;
        int safeInsetTop2;
        super.onAttachedToWindow();
        if (cutOutEnable && Build.VERSION.SDK_INT >= 28) {
            try {
                displayCutout = getWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
                if (displayCutout != null && (viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.content)).getChildAt(0)) != null) {
                    safeInsetLeft = displayCutout.getSafeInsetLeft();
                    safeInsetRight = displayCutout.getSafeInsetRight();
                    if (safeInsetLeft <= safeInsetRight) {
                        safeInsetLeft = safeInsetRight;
                    }
                    safeInsetTop = displayCutout.getSafeInsetTop();
                    safeInsetBottom = displayCutout.getSafeInsetBottom();
                    viewGroup.setPadding(safeInsetLeft, safeInsetTop, safeInsetLeft, safeInsetBottom);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("leftPadding=");
                    sb5.append(safeInsetLeft);
                    sb5.append(",topPadding=");
                    safeInsetTop2 = displayCutout.getSafeInsetTop();
                    sb5.append(safeInsetTop2);
                    APLog.d(TAG, sb5.toString());
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException unused) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            try {
                iAPPluginActivity.IOnConfigurationChanged(configuration);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:36:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0223 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        boolean z16;
        boolean z17;
        String str;
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onCreate gPluginName:" + gPluginName + " gPluginApkFilePath1:" + gPluginApkFilePath);
        if (TextUtils.isEmpty(gPluginName)) {
            super.onCreate(bundle);
            APLog.w("APPLuginProxyActivity", "gPluginName is null");
            finish();
            APPluginStatic.removeAll();
            return;
        }
        ClassLoader classLoader = APPluginLoader.getClassLoader(gPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPathString(this, gPluginName)));
        if (bundle != null && classLoader != null) {
            APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onCreate savedInstanceState=" + bundle + ", classLoader=" + classLoader);
            bundle.setClassLoader(classLoader);
        }
        Intent intent = getIntent();
        if (bundle != null) {
            extras = bundle;
        } else {
            if (classLoader != null) {
                intent.setExtrasClassLoader(classLoader);
            }
            extras = getIntent().getExtras();
        }
        String str2 = "";
        boolean z18 = false;
        try {
            this.mPluginName = extras.getString("pluginsdk_pluginName");
            this.mLaunchActivity = extras.getString("pluginsdk_launchActivity");
            this.mPluginApkFilePath = extras.getString("pluginsdk_pluginpath");
            z16 = extras.getBoolean(APPluginStatic.PARAM_PLUGIN_IS_NEW_PROCESS);
            try {
                APLog.d("APPLuginProxyActivity", "is new process: " + z16);
                z17 = extras.getBoolean(APPluginStatic.PARAM_PLUGIN_LOG_ENABLE);
                try {
                    APLog.d("APPLuginProxyActivity", "is log enable: " + z17);
                    str2 = extras.getString(APPluginStatic.PARAM_PLUGIN_LOG_CALLBACK_CLASS_NAME);
                    APLog.d("APPLuginProxyActivity", "logCallbackClassName: " + str2);
                    if (APPluginStatic.FIRST_LAUNCH_ACTIVITY.equals(this.mLaunchActivity) || APPluginStatic.FIRST_H5_LAUNCH_ACTIVITY.equals(this.mLaunchActivity)) {
                        cutOutEnable = extras.getBoolean(APPluginStatic.PARAM_PLUGIN_CutOut_ENABLE);
                        APLog.d("APPLuginProxyActivity", "is cutOut enable: " + cutOutEnable);
                        if (z16) {
                            try {
                                APPluginDataStorage.initCache(this, APPluginDataInterface.SHARE_PREFERENCE_NAME);
                                if (extras.getBoolean(APPluginStatic.PARAM_PLUGIN_OPENSDK_ENABLE)) {
                                    Class<?> cls = Class.forName("com.tencent.tauth.Tencent");
                                    try {
                                        Method method = cls.getMethod("setIsPermissionGranted", Boolean.TYPE, String.class);
                                        String data = APPluginDataStorage.getData(this, APPluginDataInterface.SHARE_PREFERENCE_NAME, "DeviceMode");
                                        if (TextUtils.isEmpty(data)) {
                                            data = DeviceInfoMonitor.getModel();
                                            APPluginDataStorage.storeData(this, APPluginDataInterface.SHARE_PREFERENCE_NAME, "DeviceMode", data);
                                        }
                                        method.invoke(cls, Boolean.TRUE, data);
                                    } catch (NoSuchMethodException unused) {
                                        Method method2 = cls.getMethod("setIsPermissionGranted", Boolean.TYPE);
                                        method2.setAccessible(true);
                                        method2.invoke(cls, Boolean.TRUE);
                                    }
                                }
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                    }
                    if (bundle != null && !APPluginStatic.CHANNEL_LIST_ACTIVITY.equals(this.mLaunchActivity) && !APPluginStatic.CHANNEL_LIST_NEW_ACTIVITY.equals(this.mLaunchActivity)) {
                        finish();
                    }
                } catch (Exception e16) {
                    e = e16;
                    APLog.w("APPLuginProxyActivity", "bundle exception:" + e.toString());
                    e.printStackTrace();
                    finish();
                    APPluginStatic.removeAll();
                    APPluginReportManager.getInstance().reportImmediatelyOneRecord(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_OAT_ERROR, "OatDelete");
                    APLogUtil.initAPLogIfNewProcess(this, z16, z17, str2);
                    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onCreate mPluginName\uff1a" + this.mPluginName + ", mLaunchActivity\uff1a" + this.mLaunchActivity + ", mPluginApkFilePath\uff1a" + this.mPluginApkFilePath);
                    if (TextUtils.isEmpty(this.mPluginApkFilePath)) {
                    }
                    if (TextUtils.isEmpty(this.mLaunchActivity)) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                z17 = true;
                APLog.w("APPLuginProxyActivity", "bundle exception:" + e.toString());
                e.printStackTrace();
                finish();
                APPluginStatic.removeAll();
                APPluginReportManager.getInstance().reportImmediatelyOneRecord(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_OAT_ERROR, "OatDelete");
                APLogUtil.initAPLogIfNewProcess(this, z16, z17, str2);
                APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onCreate mPluginName\uff1a" + this.mPluginName + ", mLaunchActivity\uff1a" + this.mLaunchActivity + ", mPluginApkFilePath\uff1a" + this.mPluginApkFilePath);
                if (TextUtils.isEmpty(this.mPluginApkFilePath)) {
                }
                if (TextUtils.isEmpty(this.mLaunchActivity)) {
                }
            }
        } catch (Exception e18) {
            e = e18;
            z16 = false;
        }
        APLogUtil.initAPLogIfNewProcess(this, z16, z17, str2);
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onCreate mPluginName\uff1a" + this.mPluginName + ", mLaunchActivity\uff1a" + this.mLaunchActivity + ", mPluginApkFilePath\uff1a" + this.mPluginApkFilePath);
        if (TextUtils.isEmpty(this.mPluginApkFilePath)) {
            try {
                this.mPluginApkFilePath = APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath();
            } catch (Exception unused2) {
            }
        }
        if (TextUtils.isEmpty(this.mLaunchActivity)) {
            APLog.e("Midas", "APPluginProxyActivity onCreate mLaunchActivity is null");
            super.onCreate(bundle);
            finish();
            APPluginStatic.removeAll();
            return;
        }
        String str3 = this.mPluginName;
        if (str3 != null && str3.length() != 0) {
            try {
                str = initPlugin();
                if (str == null) {
                    if (Build.VERSION.SDK_INT < 30) {
                        getLayoutInflater().setFactory2(new APLayoutInflaterFactory());
                    }
                    super.onCreate(bundle);
                    try {
                        this.mPluginActivity.IOnCreate(bundle);
                        z18 = true;
                    } catch (Exception e19) {
                        e = e19;
                        z18 = true;
                        APLog.e("Midas", "APPluginProxyActivity onCreate:" + e.toString());
                        e.printStackTrace();
                        str = APPluginUtils.getExceptionInfo(e);
                        if (!z18) {
                        }
                        if (str != null) {
                        }
                        if (!cutOutEnable) {
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e26) {
                e = e26;
            }
        } else {
            str = "Param mPluingLocation missing!";
        }
        if (!z18) {
            super.onCreate(bundle);
        }
        if (str != null) {
            this.mCreateErrorInfo = str;
            APLog.e("Midas", "APPluginProxyActivity onCreate activity failed:" + str);
            logStartPluginErrInfo(this.mCreateErrorInfo);
            if (!shouldHandleStartPluginFailed(this.mCreateErrorInfo)) {
                APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, this.mPluginName, str);
                APPluginUtils.showLaunchPluginFail(this, str, true);
                finish();
                APPluginStatic.removeAll();
            }
        }
        if (!cutOutEnable && Build.VERSION.SDK_INT >= 28) {
            try {
                getWindow().addFlags(67108864);
                getWindow().addFlags(1024);
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            } catch (Exception e27) {
                e27.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            return iAPPluginActivity.IOnCreateOptionsMenu(menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        APLog.i(TAG, "onDestroy mPluginActivity:" + this.mPluginActivity);
        APLogUtil.flushIfNewProcess();
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            try {
                iAPPluginActivity.IOnDestroy();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        boolean z16;
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            z16 = iAPPluginActivity.IOnKeyDown(i3, keyEvent);
        } else {
            z16 = false;
        }
        if (!z16) {
            return super.onKeyDown(i3, keyEvent);
        }
        return z16;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            return iAPPluginActivity.IOnMenuItemSelected(i3, menuItem);
        }
        return super.onMenuItemSelected(i3, menuItem);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ClassLoader classLoader = APPluginLoader.getClassLoader(this.mPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName)));
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onNewIntent mPluginName:" + this.mPluginName + " classLoader: " + classLoader);
        if (classLoader != null) {
            intent.setExtrasClassLoader(classLoader);
        }
        if (this.mPluginActivity != null && intent.getBooleanExtra("cleartop", false)) {
            this.mPluginActivity.IOnNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            return iAPPluginActivity.IOnOptionsItemSelected(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnPause();
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            return iAPPluginActivity.IOnPrepareOptionsMenu(menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        APLog.i("APPLuginProxyActivity", "onRequestPermissionsResult requestCode:" + i3 + " permissions:" + strArr + " grantResults:" + iArr);
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (this.mPluginActivity != null) {
            try {
                APPluginLoader.getClassLoader(this.mPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath()));
                this.mPluginActivity.IOnRequestPermissionsResult(i3, strArr, iArr);
            } catch (Exception e16) {
                APLog.w("APPLuginProxyActivity onRequestPermissionsResult", e16.toString());
                e16.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        ClassLoader classLoader = APPluginLoader.getClassLoader(this.mPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName)));
        if (classLoader != null) {
            try {
                setClassLoaderToEveryBundle(bundle, classLoader);
            } catch (Exception unused) {
            }
        }
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Exception unused2) {
        }
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnResume();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnSaveInstanceState(bundle);
        }
        bundle.putString("pluginsdk_pluginName", this.mPluginName);
        bundle.putString("pluginsdk_pluginLocation", this.mPluginName);
        bundle.putString("pluginsdk_pluginpath", this.mPluginApkFilePath);
        bundle.putString("pluginsdk_launchActivity", this.mLaunchActivity);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnStart();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            return iAPPluginActivity.IOnTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnWindowFocusChanged(z16);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        APLog.i(TAG, "setRequestedOrientation requestedOrientation:" + i3);
        super.setRequestedOrientation(i3);
    }

    protected boolean shouldHandleStartPluginFailed(String str) {
        if (!str.contains(QCircleDaTongConstant.ElementParamValue.PERMISSION) && !str.contains("filenotfoundexception")) {
            if (!str.contains("resources$notfoundexception") && !str.contains("resourcesnotfoundexception")) {
                return false;
            }
            showNeedUninstanllAndInstallDialog();
            return true;
        }
        showNeedUninstanllAndInstallDialog();
        return true;
    }

    protected void showNeedUninstanllAndInstallDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("\u6e29\u99a8\u63d0\u793a");
        builder.setMessage("\u7cfb\u7edf\u7e41\u5fd9" + this.mPluginName + "\u5931\u8d25\uff0c\u8bf7\u5378\u8f7d\u91cd\u88c5~");
        builder.setPositiveButton("\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.midas.plugin.APPluginProxyActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                APPluginProxyActivity.this.finish();
            }
        });
        try {
            builder.create().show();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        if (intent.getBooleanExtra("pluginsdk_IsPluginActivity", false)) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            intent.putExtra("pluginsdk_IsPluginActivity", false);
            if (className != null && className.length() > 0) {
                startPluginActivityForResult(this, className, intent, i3);
            }
        } else {
            super.startActivityForResult(intent, i3);
        }
        this.mStopFlag = 2;
    }

    public void startActivityForResult(Intent intent, int i3, int i16) {
        APLog.i("APPLuginProxyActivity", "startActivityForResult.public");
        this.mStopFlag = 2;
        isStart3rdApp(intent);
        if (!isMoveTaskToBack(this, intent)) {
            intent.addFlags(262144);
        }
        super.startActivityForResult(intent, i3);
    }
}
