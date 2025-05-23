package com.tencent.mobileqq.pluginsdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.BaseFragmentActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;

/* loaded from: classes16.dex */
public class BasePluginFragmentActivity extends BaseFragmentActivity implements IPluginFragmentActivity, SkinnableActivityProcesser.Callback, PluginInterfaceHelper.OnPluginInterfaceLoadedListener {
    static IPatchRedirector $redirector_;
    public static int i_support_immersive;
    private static Boolean sIsLiquid;
    private static boolean sSkilEngineInit;
    private Dialog jumpDialog;
    private Activity mActivity;
    protected String mApkFilePath;
    private PluginConfig mConfig;
    public View mContentView;
    public Context mContext;
    private ClassLoader mDexClassLoader;
    boolean mFinished;
    private BasePluginActivity.ImmersiveConfig mImmerConfit;
    protected boolean mIsRunInPlugin;
    protected boolean mIsTab;
    protected FragmentActivity mOutActivity;
    protected PackageInfo mPackageInfo;
    private SparseArray<List> mPermissionCallerMap;
    protected String mPluginID;
    protected int mPluginResourcesType;
    protected boolean mUseSkinEngine;
    View mViewShadow;
    SkinnableActivityProcesser processer;

    /* loaded from: classes16.dex */
    public static class PluginConfig {
        static IPatchRedirector $redirector_;
        public boolean enableNight;
        public int titleHeight;

        public PluginConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.titleHeight = 0;
                this.enableNight = true;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 103)) {
            redirector.redirect((short) 103);
            return;
        }
        sIsLiquid = null;
        sSkilEngineInit = false;
        i_support_immersive = -1;
    }

    public BasePluginFragmentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsTab = false;
        this.mIsRunInPlugin = false;
        this.mOutActivity = null;
        this.mContext = null;
        this.mActivity = null;
        this.mFinished = false;
        this.mContentView = null;
        this.mApkFilePath = "";
        this.mUseSkinEngine = false;
        this.mDexClassLoader = null;
        this.mConfig = new PluginConfig();
        this.mImmerConfit = new BasePluginActivity.ImmersiveConfig();
        this.mPermissionCallerMap = new SparseArray<>();
    }

    public static final Bitmap getDrawableBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof SkinnableBitmapDrawable)) {
            return null;
        }
        return ((SkinnableBitmapDrawable) drawable).getBitmap();
    }

    public static boolean reflectHasAndIsNull(Object obj, String str, Class cls) {
        if (obj == null || str == null) {
            return false;
        }
        if (cls == null) {
            try {
                cls = obj.getClass();
            } catch (Exception unused) {
                return false;
            }
        }
        Field declaredField = cls.getDeclaredField(str);
        if (declaredField == null) {
            return false;
        }
        declaredField.setAccessible(true);
        if (declaredField.get(obj) != null) {
            return false;
        }
        return true;
    }

    private void setNightMaskVisible(boolean z16) {
        View view = this.mViewShadow;
        int i3 = 0;
        if (view != null) {
            if (!z16) {
                i3 = 8;
            }
            view.setVisibility(i3);
            return;
        }
        if (z16) {
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
            imageView.setPadding(0, this.mConfig.titleHeight, 0, 0);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mViewShadow = imageView;
            View decorView = getWindow().getDecorView();
            if (decorView instanceof ViewGroup) {
                View view2 = this.mViewShadow;
                ((ViewGroup) decorView).addView(view2, view2.getLayoutParams());
            } else {
                Window window = getWindow();
                View view3 = this.mViewShadow;
                window.addContentView(view3, view3.getLayoutParams());
            }
        }
    }

    public static void setProperty(Object obj, Class cls, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IDispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return ((Boolean) iPatchRedirector.redirect((short) 80, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            return dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this);
        } else {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public View IGetContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (View) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.mContentView;
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public Handler IGetInHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (Handler) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public Resources IGetResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (Resources) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        Context context = this.mContext;
        if (context != null) {
            return context.getResources();
        }
        return this.mActivity.getResources();
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IInit(String str, String str2, Activity activity, ClassLoader classLoader, PackageInfo packageInfo, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, this, str, str2, activity, classLoader, packageInfo, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "BasePluginActivity.Init:" + str + ", " + z16 + ", " + this.mPluginResourcesType);
        }
        this.mIsRunInPlugin = true;
        this.mDexClassLoader = classLoader;
        this.mOutActivity = (FragmentActivity) activity;
        this.mPluginID = str;
        this.mApkFilePath = str2;
        this.mPackageInfo = packageInfo;
        this.mPluginResourcesType = i3;
        if (this.mContext == null) {
            this.mContext = new PluginContext(activity, 0, this.mApkFilePath, this.mDexClassLoader, activity.getResources(), this.mPluginResourcesType);
        }
        attachBaseContext(this.mContext);
        this.mUseSkinEngine = z16;
        if (!sSkilEngineInit && z16) {
            int i16 = this.mPluginResourcesType;
            if (i16 != 1 && i16 != 2) {
                try {
                    SkinEngineInitBridge.init(this);
                    sSkilEngineInit = true;
                    return;
                } catch (Exception unused) {
                    SkinEngine.getInstances().unInit();
                    return;
                }
            }
            SkinEngineInitBridge.initSkin(this);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IIsWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return ((Boolean) iPatchRedirector.redirect((short) 88, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnAttachFragment(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 56)) {
            return;
        }
        iPatchRedirector.redirect((short) 56, (Object) this, (Object) fragment);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    @TargetApi(5)
    public boolean IOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        try {
            onBackPressed();
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) configuration);
        } else {
            onConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
        } else {
            onCreate(bundle);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IOnCreateOptionsMenu(Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Boolean) iPatchRedirector.redirect((short) 75, (Object) this, (Object) menu)).booleanValue();
        }
        return onCreateOptionsMenu(menu);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IOnKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16), keyEvent)).booleanValue();
        }
        return onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IOnKeyUp(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return onKeyUp(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IOnMenuItemSelected(int i3, MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return ((Boolean) iPatchRedirector.redirect((short) 85, (Object) this, i3, (Object) menuItem)).booleanValue();
        }
        return onMenuItemSelected(i3, menuItem);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
        } else {
            onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IOnOptionsItemSelected(MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Boolean) iPatchRedirector.redirect((short) 77, (Object) this, (Object) menuItem)).booleanValue();
        }
        return onOptionsItemSelected(menuItem);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            onPause();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IOnPrepareOptionsMenu(Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Boolean) iPatchRedirector.redirect((short) 76, (Object) this, (Object) menu)).booleanValue();
        }
        return onPrepareOptionsMenu(menu);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            onRestart();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            onResume();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnSetTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            onStart();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            onStop();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public boolean IOnTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Boolean) iPatchRedirector.redirect((short) 78, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnUserInteraction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this);
        } else {
            onUserInteraction();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void IOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
        } else {
            onWindowFocusChanged(z16);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void ISetIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) intent);
        } else {
            setIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void ISetIsTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mIsTab = true;
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void ISetOutHandler(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) handler);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public void ISetParent(BasePluginActivity basePluginActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) basePluginActivity);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginActivity
    public BasePluginActivity.ImmersiveConfig IgetImmersiveConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return (BasePluginActivity.ImmersiveConfig) iPatchRedirector.redirect((short) 91, (Object) this);
        }
        return this.mImmerConfit;
    }

    @Override // mqq.app.BaseFragmentActivity, android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return ((Integer) iPatchRedirector.redirect((short) 98, (Object) this, (Object) str)).intValue();
        }
        return super.checkSelfPermission(str);
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16 = true;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 79, (Object) this, (Object) motionEvent)).booleanValue();
        } else if (reflectHasAndIsNull(this, "mWindow", Activity.class)) {
            if (motionEvent.getAction() == 0) {
                onUserInteraction();
            }
            Window window = getWindow();
            if (window == null || !window.superDispatchTouchEvent(motionEvent)) {
                z16 = onTouchEvent(motionEvent);
            }
        } else {
            z16 = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
        return z16;
    }

    @Override // android.app.Activity
    public View findViewById(int i3) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
        if (this.mIsRunInPlugin && (view = this.mContentView) != null) {
            View findViewById = view.findViewById(i3);
            if (findViewById == null) {
                try {
                    return super.findViewById(i3);
                } catch (Exception e16) {
                    DebugHelper.debug("plugin_tag", "findViewById", e16);
                    return findViewById;
                }
            }
            return findViewById;
        }
        return super.findViewById(i3);
    }

    @Override // android.app.Activity
    public void finish() {
        int i3;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
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
                    if (DebugHelper.sDebug) {
                        DebugHelper.log("plugin_tag", "BasePluginActivity.finish", e16);
                    }
                    intent = null;
                }
            }
            this.mOutActivity.setResult(i3, intent);
            this.mOutActivity.finish();
            this.mFinished = true;
            return;
        }
        super.finish();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (Context) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mOutActivity.getApplicationContext();
        }
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (ApplicationInfo) iPatchRedirector.redirect((short) 73, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo.applicationInfo;
        }
        return super.getApplicationInfo();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return ((Integer) iPatchRedirector.redirect((short) 67, (Object) this)).intValue();
        }
        if (this.mIsRunInPlugin) {
            return this.mOutActivity.getChangingConfigurations();
        }
        return super.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return (FragmentManager) iPatchRedirector.redirect((short) 93, (Object) this);
        }
        return super.getFragmentManager();
    }

    public Resources getHostResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (Resources) iPatchRedirector.redirect((short) 74, (Object) this);
        }
        return this.mOutActivity.getResources();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (LayoutInflater) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        Context context = this.mContext;
        if (context != null) {
            return LayoutInflater.from(context);
        }
        return LayoutInflater.from(this.mActivity);
    }

    @Override // mqq.app.BaseFragmentActivity
    protected String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            return (String) iPatchRedirector.redirect((short) 92, (Object) this);
        }
        return this.mPluginID;
    }

    public FragmentActivity getOutActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (FragmentActivity) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        return this.mOutActivity;
    }

    public Resources getOutResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (Resources) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mOutActivity.getResources();
        }
        return this.mActivity.getResources();
    }

    public PackageInfo getPackageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (PackageInfo) iPatchRedirector.redirect((short) 72, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo;
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (String) iPatchRedirector.redirect((short) 71, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo.packageName;
        }
        return super.getPackageName();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return (androidx.fragment.app.FragmentManager) iPatchRedirector.redirect((short) 94, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return getOutActivity().getSupportFragmentManager();
        }
        return super.getSupportFragmentManager();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return iPatchRedirector.redirect((short) 65, (Object) this, (Object) str);
        }
        if (!"window".equals(str) && !"search".equals(str)) {
            Context context = this.mContext;
            if (context != null) {
                return context.getSystemService(str);
            }
            return super.getSystemService(str);
        }
        if (this.mIsRunInPlugin) {
            return this.mOutActivity.getSystemService(str);
        }
        return super.getSystemService(str);
    }

    @Override // android.app.Activity
    public Window getWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (Window) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mOutActivity.getWindow();
        }
        return super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (WindowManager) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mOutActivity.getWindowManager();
        }
        return super.getWindowManager();
    }

    public void initNavigationBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, (Object) this);
            return;
        }
        try {
            Context context = this.mContext;
            if (context == null) {
                QLog.d("plugin_tag", 1, "[NavigationBar] initNavigationBarColor context empty:");
                return;
            }
            boolean z16 = context.getSharedPreferences("BootOptimize", 0).getBoolean("KEY_DISABLE_NAVIGATION_BAR", false);
            boolean isNightMode = IPluginAdapterProxy.getProxy().isNightMode();
            if (!z16 && isNightMode) {
                setNavigationBarColor(-16777216);
                return;
            }
            QLog.d("plugin_tag", 1, "[NavigationBar] disableNavigationBar=", Boolean.valueOf(z16), " isNightMode=", Boolean.valueOf(isNightMode));
        } catch (Throwable th5) {
            QLog.d("plugin_tag", 1, "[NavigationBar] initNavigationBarColor=", th5);
        }
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        if (this.mIsRunInPlugin) {
            return this.mFinished;
        }
        return super.isFinishing();
    }

    boolean isSamePackage(Intent intent) {
        if (!this.mIsRunInPlugin || intent == null) {
            return false;
        }
        if (intent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
            return intent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        }
        ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        if (this.mOutActivity.getPackageName().equals(component.getPackageName())) {
            List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(this.mActivity.getPackageManager(), intent, 65536);
            if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
                return false;
            }
        } else if (!getPackageName().equals(component.getPackageName())) {
            return false;
        }
        return true;
    }

    boolean isSamePackage2(Intent intent) {
        if (!this.mIsRunInPlugin || intent == null) {
            return false;
        }
        if (intent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
            return intent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        }
        ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        if (this.mOutActivity.getPackageName().equals(component.getPackageName())) {
            try {
                return BasePluginFragmentActivity.class.isAssignableFrom(Class.forName(component.getClassName(), false, this.mContext.getClassLoader()));
            } catch (ClassNotFoundException e16) {
                DebugHelper.log("plugin_tag", "isSamePackage2", e16);
                return false;
            }
        }
        if (!getPackageName().equals(component.getPackageName())) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.BaseFragmentActivity
    public boolean isShadow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    public int isSupportStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return ((Integer) iPatchRedirector.redirect((short) 89, (Object) this)).intValue();
        }
        return IPluginAdapterProxy.getProxy().isSupportImmersive();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            if (this.mIsRunInPlugin) {
                return;
            }
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(androidx.fragment.app.Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, (Object) fragment);
        } else {
            super.onAttachFragment(fragment);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
        } else {
            finish();
        }
    }

    protected void onConfig(PluginConfig pluginConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) pluginConfig);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, (Object) configuration);
        } else {
            try {
                super.onConfigurationChanged(configuration);
            } catch (Exception unused) {
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        if (this.mIsRunInPlugin) {
            FragmentActivity fragmentActivity = this.mOutActivity;
            this.mActivity = fragmentActivity;
            Window window = fragmentActivity.getWindow();
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    setProperty(this, Activity.class, "mWindow", window);
                } catch (Exception e16) {
                    QLog.d("plugin_tag", 1, "setPluginWindow", e16);
                }
            }
            onConfig(this.mConfig);
            if (this.processer == null) {
                try {
                    this.processer = new SkinnableActivityProcesser(this, this);
                } catch (Exception unused) {
                }
            }
            PluginStatic.add(this);
            super.onCreate(bundle);
            if (getIntent().getBooleanExtra(PluginConst.PARAMS_REMOTE_CONNECT_AT_LAUNCH, false)) {
                readyPluginInterface(this.mOutActivity, this);
            }
        } else {
            super.onCreate(bundle);
            this.mActivity = this;
        }
        initNavigationBarColor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        try {
            Dialog dialog = this.jumpDialog;
            if (dialog != null && dialog.isShowing()) {
                this.jumpDialog.dismiss();
            }
        } catch (Throwable th5) {
            QLog.e("BasePluginActivity", 1, th5, new Object[0]);
        }
        if (this.mIsRunInPlugin) {
            SkinnableActivityProcesser skinnableActivityProcesser = this.processer;
            if (skinnableActivityProcesser != null) {
                skinnableActivityProcesser.destory();
                this.processer = null;
            }
            this.mDexClassLoader = null;
            PluginStatic.remove(this);
            super.onDestroy();
            return;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, this, Integer.valueOf(i3), Integer.valueOf(i16), keyEvent)).booleanValue();
        }
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else if (this.mIsRunInPlugin) {
            super.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener
    public void onPluginInterfaceLoaded(PluginInterface pluginInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pluginInterface);
        } else {
            onPluginInterfaceReady(pluginInterface);
        }
    }

    protected void onPluginInterfaceReady(PluginInterface pluginInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pluginInterface);
        }
    }

    @Override // com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this);
        }
    }

    @Override // com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (iArr.length == 0) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        } else if (this.mIsRunInPlugin) {
            super.onRestart();
        } else {
            super.onRestart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        if (this.mIsRunInPlugin) {
            if (IPluginAdapterProxy.getProxy().isNightMode() && this.mConfig.enableNight) {
                setNightMaskVisible(true);
                return;
            } else {
                setNightMaskVisible(false);
                return;
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else if (this.mIsRunInPlugin) {
            super.onStart();
        } else {
            super.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else if (this.mIsRunInPlugin) {
            super.onStop();
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else {
            if (this.mIsRunInPlugin) {
                return;
            }
            super.onWindowFocusChanged(z16);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
        } else if (this.mIsRunInPlugin) {
            this.mOutActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.mIsRunInPlugin) {
            this.mActivity.overridePendingTransition(i3, i16);
        } else {
            super.overridePendingTransition(i3, i16);
        }
    }

    protected final void readyPluginInterface(Context context, PluginInterfaceHelper.OnPluginInterfaceLoadedListener onPluginInterfaceLoadedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) onPluginInterfaceLoadedListener);
        } else {
            PluginInterfaceHelper.getPluginInterface(context, onPluginInterfaceLoadedListener);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, mqq.app.IPermissionRequester
    @TargetApi(24)
    public void requestPermissions(Object obj, int i3, String... strArr) {
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, this, obj, Integer.valueOf(i3), strArr);
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
            if (isShadow() && (fragmentActivity = this.mOutActivity) != null) {
                fragmentActivity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i3);
                return;
            } else {
                requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i3);
                return;
            }
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (this.mIsRunInPlugin) {
            View inflate = LayoutInflater.from(this.mContext).inflate(i3, (ViewGroup) null);
            this.mContentView = inflate;
            if (this.mIsTab) {
                return;
            }
            this.mActivity.setContentView(inflate);
            return;
        }
        super.setContentView(i3);
    }

    public void setImmersiveConfig(BasePluginActivity.ImmersiveConfig immersiveConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, (Object) immersiveConfig);
        } else {
            this.mImmerConfit = immersiveConfig;
        }
    }

    public void setJumpDialog(Dialog dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, (Object) this, (Object) dialog);
        } else {
            this.jumpDialog = dialog;
        }
    }

    public void setNavigationBarColor(@ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, i3);
            return;
        }
        if (getWindow() == null) {
            return;
        }
        try {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setNavigationBarColor(i3);
        } catch (Exception e16) {
            QLog.e("plugin_tag", 1, "[NavigationBar] setNavigationBarColor Exception:", e16);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, android.app.Activity
    public void setRequestedOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, i3);
        } else {
            super.setRequestedOrientation(i3);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, i3);
            return;
        }
        if (this.mIsRunInPlugin) {
            this.mOutActivity.setTheme(i3);
            try {
                Context context = this.mContext;
                if (context != null && context.getTheme() != null) {
                    this.mContext.getTheme().setTo(this.mOutActivity.getTheme());
                }
                if (getTheme() != null) {
                    getTheme().setTo(this.mOutActivity.getTheme());
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("plugin_tag", 1, "setTheme Exception:", e16);
                return;
            }
        }
        super.setTheme(i3);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) charSequence);
        } else if (this.mIsRunInPlugin) {
            this.mActivity.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) intent);
            return;
        }
        try {
            super.startActivity(intent);
        } catch (NullPointerException unused) {
            startActivityForResult(intent, -1);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        List<ResolveInfo> queryIntentActivities;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) intent, i3);
            return;
        }
        if (this.mIsRunInPlugin) {
            boolean z16 = false;
            if (intent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
                z16 = intent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            } else {
                ComponentName component = intent.getComponent();
                if (component != null && (!this.mOutActivity.getPackageName().equals(component.getPackageName()) ? getPackageName().equals(component.getPackageName()) : !((queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(this.mActivity.getPackageManager(), intent, 65536)) != null && queryIntentActivities.size() != 0))) {
                    z16 = true;
                }
            }
            if (z16) {
                intent.putExtra("pluginsdk_IsPluginActivity", true);
            }
            Activity activity = this.mActivity;
            if (activity instanceof PluginProxyActivity) {
                ((PluginProxyActivity) activity).startActivityForResult(intent, i3);
                return;
            } else {
                activity.startActivityForResult(intent, i3);
                return;
            }
        }
        super.startActivityForResult(intent, i3);
    }

    @Override // mqq.app.BaseFragmentActivity
    public AppRuntime waitAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 102, (Object) this);
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime == null) {
            return null;
        }
        return waitAppRuntime.getAppRuntime(getModuleId());
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginFragmentActivity
    public void IOnAttachFragment(androidx.fragment.app.Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 57)) {
            onAttachFragment(fragment);
        } else {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) fragment);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginFragmentActivity
    public void ISetParent(BasePluginFragmentActivity basePluginFragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) basePluginFragmentActivity);
            return;
        }
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("setParent", Activity.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, basePluginFragmentActivity);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) intent, (Object) bundle);
            return;
        }
        try {
            super.startActivity(intent, bundle);
        } catch (NullPointerException unused) {
            startActivityForResult(intent, -1, bundle);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else if (this.mIsRunInPlugin) {
            this.mActivity.setTitle(i3);
        } else {
            super.setTitle(i3);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        if (this.mIsRunInPlugin) {
            this.mContentView = view;
            if (this.mIsTab) {
                return;
            }
            this.mActivity.setContentView(view);
            return;
        }
        super.setContentView(view);
    }
}
