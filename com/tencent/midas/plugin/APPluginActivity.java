package com.tencent.midas.plugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.midas.comm.APLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: classes9.dex */
public class APPluginActivity extends Activity implements IAPPluginActivity {
    public Activity mProxyActivity = null;
    public Activity mActivity = null;
    public Context mContext = null;
    protected View mProxyContentView = null;
    protected String mPluginName = "";
    protected String mApkFilePath = "";
    protected PackageInfo mPackageInfo = null;
    protected boolean mIsRunInPlugin = false;
    private ClassLoader mDexClassLoader = null;
    private boolean mFinished = false;

    public static final Bitmap getDrawableBitmap(Drawable drawable) {
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IDispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IFinish() {
        finish();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public View IGetContentView() {
        return this.mProxyContentView;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public Handler IGetInHandler() {
        return null;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public Resources IGetResource() {
        Context context = this.mContext;
        if (context != null) {
            return context.getResources();
        }
        return this.mActivity.getResources();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IInit(String str, String str2, Activity activity, ClassLoader classLoader, PackageInfo packageInfo) {
        this.mIsRunInPlugin = true;
        this.mDexClassLoader = classLoader;
        this.mProxyActivity = activity;
        this.mPluginName = str;
        this.mApkFilePath = str2;
        this.mPackageInfo = packageInfo;
        APPluginContext aPPluginContext = new APPluginContext(activity, 0, str2, classLoader);
        this.mContext = aPPluginContext;
        attachBaseContext(aPPluginContext);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IIsWrapContent() {
        return true;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnActivityResult(int i3, int i16, Intent intent) {
        onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnCreate(Bundle bundle) {
        onCreate(bundle);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnCreateOptionsMenu(Menu menu) {
        return onCreateOptionsMenu(menu);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnDestroy() {
        onDestroy();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyDown(int i3, KeyEvent keyEvent) {
        return onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        return onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyUp(int i3, KeyEvent keyEvent) {
        return onKeyUp(i3, keyEvent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnMenuItemSelected(int i3, MenuItem menuItem) {
        return onMenuItemSelected(i3, menuItem);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnNewIntent(Intent intent) {
        onNewIntent(intent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnOptionsItemSelected(MenuItem menuItem) {
        return onOptionsItemSelected(menuItem);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnPause() {
        onPause();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnPrepareOptionsMenu(Menu menu) {
        return onPrepareOptionsMenu(menu);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    @TargetApi(23)
    public void IOnRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnRestart() {
        onRestart();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnResume() {
        onResume();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnStart() {
        onStart();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnStop() {
        onStop();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnUserInteraction() {
        onUserInteraction();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnWindowFocusChanged(boolean z16) {
        onWindowFocusChanged(z16);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    @TargetApi(23)
    public void IRequestPermissions(String[] strArr, int i3) {
        requestPermissions(strArr, i3);
        APLog.i("APPluginActivity", "IRequestPermissions() permissions=" + strArr + ", requestCode=" + i3);
        if (this.mIsRunInPlugin) {
            return;
        }
        PermissionMonitor.requestPermissions(this, strArr, i3);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void ISetIntent(Intent intent) {
        setIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public View findViewById(int i3) {
        View view;
        if (this.mIsRunInPlugin && (view = this.mProxyContentView) != null) {
            View findViewById = view.findViewById(i3);
            if (findViewById == null) {
                return super.findViewById(i3);
            }
            return findViewById;
        }
        return super.findViewById(i3);
    }

    @Override // android.app.Activity
    public void finish() {
        int i3;
        Intent intent;
        APLog.i("APPluginActivity", "APPluginActivity finish");
        if (this.mIsRunInPlugin) {
            synchronized (this) {
                i3 = 0;
                try {
                    Field declaredField = Activity.class.getDeclaredField("mResultCode");
                    declaredField.setAccessible(true);
                    i3 = ((Integer) declaredField.get(this)).intValue();
                    Field declaredField2 = Activity.class.getDeclaredField("mResultData");
                    declaredField2.setAccessible(true);
                    intent = (Intent) declaredField2.get(this);
                } catch (Exception e16) {
                    Log.e("Midas", "APPluginActivity finish Exception:" + e16.toString());
                    intent = null;
                }
            }
            if (this.mProxyActivity != null && !isFinishing()) {
                this.mProxyActivity.setResult(i3, intent);
                this.mProxyActivity.finish();
            }
            this.mFinished = true;
            return;
        }
        super.finish();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Activity activity;
        APLog.i("APPluginActivity", "APPluginActivity getApplicationContext mProxyActivity:" + this.mProxyActivity);
        if (this.mIsRunInPlugin && (activity = this.mProxyActivity) != null) {
            return activity.getApplicationContext();
        }
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo.applicationInfo;
        }
        return super.getApplicationInfo();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        if (this.mIsRunInPlugin) {
            return this.mProxyActivity.getChangingConfigurations();
        }
        return super.getChangingConfigurations();
    }

    public Resources getHostResources() {
        return this.mProxyActivity.getResources();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        Context context = this.mContext;
        if (context != null) {
            return LayoutInflater.from(context);
        }
        return LayoutInflater.from(this.mActivity);
    }

    public Activity getOutActivity() {
        return this.mProxyActivity;
    }

    public Resources getOutResources() {
        if (this.mIsRunInPlugin) {
            return this.mProxyActivity.getResources();
        }
        return this.mActivity.getResources();
    }

    public PackageInfo getPackageInfo() {
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo;
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo.packageName;
        }
        return super.getPackageName();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"window".equals(str) && !"search".equals(str)) {
            Context context = this.mContext;
            if (context != null) {
                return context.getSystemService(str);
            }
            return super.getSystemService(str);
        }
        if (this.mIsRunInPlugin) {
            return this.mProxyActivity.getSystemService(str);
        }
        return super.getSystemService(str);
    }

    @Override // android.app.Activity
    public Window getWindow() {
        if (this.mIsRunInPlugin) {
            Activity activity = this.mProxyActivity;
            if (activity == null) {
                return null;
            }
            return activity.getWindow();
        }
        return super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        if (this.mIsRunInPlugin) {
            return this.mProxyActivity.getWindowManager();
        }
        return super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        if (this.mIsRunInPlugin) {
            return this.mFinished;
        }
        return super.isFinishing();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        APLog.i("APPluginActivity", "APPluginActivity onActivityResult");
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (this.mIsRunInPlugin) {
            this.mActivity = this.mProxyActivity;
            APPluginStatic.add(this);
        } else {
            super.onCreate(bundle);
            this.mActivity = this;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        APLog.i("APPluginActivity", "onDestroy mIsRunInPlugin:" + this.mIsRunInPlugin);
        if (this.mIsRunInPlugin) {
            this.mDexClassLoader = null;
            APPluginStatic.remove(this);
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onPause();
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        APLog.i("APPluginActivity", "onRequestPermissionsResult() requestCode=" + i3);
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onWindowFocusChanged(z16);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        Activity activity;
        if (this.mIsRunInPlugin && (activity = this.mProxyActivity) != null) {
            activity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i3, int i16) {
        if (this.mIsRunInPlugin) {
            this.mActivity.overridePendingTransition(i3, i16);
        } else {
            super.overridePendingTransition(i3, i16);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i3) {
        if (this.mIsRunInPlugin) {
            View inflate = LayoutInflater.from(this).inflate(i3, (ViewGroup) null);
            this.mProxyContentView = inflate;
            this.mActivity.setContentView(inflate);
            return;
        }
        super.setContentView(i3);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        super.setRequestedOrientation(i3);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        Activity activity;
        if (this.mIsRunInPlugin && (activity = this.mProxyActivity) != null) {
            activity.setTheme(i3);
        } else {
            super.setTheme(i3);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        List<ResolveInfo> queryIntentActivities;
        if (this.mIsRunInPlugin) {
            boolean z16 = false;
            if (intent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
                z16 = intent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            } else {
                Activity activity = this.mProxyActivity;
                if (activity != null) {
                    intent.setPackage(activity.getPackageName());
                }
                Activity activity2 = this.mActivity;
                if (activity2 != null && ((queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(activity2.getPackageManager(), intent, 65536)) == null || queryIntentActivities.size() == 0)) {
                    z16 = true;
                }
            }
            if (!z16) {
                Activity activity3 = this.mActivity;
                if (activity3 != null) {
                    activity3.startActivityForResult(intent, i3);
                    return;
                }
                return;
            }
            intent.putExtra("pluginsdk_IsPluginActivity", true);
            Activity activity4 = this.mActivity;
            if (activity4 != null) {
                activity4.startActivityForResult(intent, i3);
                return;
            }
            return;
        }
        super.startActivityForResult(intent, i3);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        if (this.mIsRunInPlugin) {
            this.mProxyContentView = view;
            this.mActivity.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnRestoreInstanceState(Bundle bundle) {
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnSaveInstanceState(Bundle bundle) {
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void ISetOutHandler(Handler handler) {
    }
}
