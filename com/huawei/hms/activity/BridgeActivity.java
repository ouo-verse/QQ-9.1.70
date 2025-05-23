package com.huawei.hms.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final String EXTRA_INTENT = "intent.extra.intent";
    public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";

    /* renamed from: b, reason: collision with root package name */
    private static final int f36612b = a("ro.build.hw_emui_api_level", 0);

    /* renamed from: a, reason: collision with root package name */
    private IBridgeActivityDelegate f36613a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f36614a;

        a(ViewGroup viewGroup) {
            this.f36614a = viewGroup;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            try {
                Object invoke = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", WindowInsets.class).invoke(null, windowInsets);
                if (invoke == null) {
                    HMSLog.i("BridgeActivity", "sideRegion is null");
                } else {
                    Rect rect = (Rect) Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(invoke, new Object[0]);
                    ViewGroup viewGroup = this.f36614a;
                    if (viewGroup != null) {
                        viewGroup.setPadding(rect.left, 0, rect.right, 0);
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
                HMSLog.e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e16.getMessage());
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    private static void a(Window window, boolean z16) {
        try {
            window.getClass().getMethod("setHwFloating", Boolean.TYPE).invoke(window, Boolean.valueOf(z16));
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e16) {
            HMSLog.e("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e16.getMessage());
        }
    }

    private boolean b() {
        Intent intent = getIntent();
        if (intent == null) {
            HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        if (intent.getBooleanExtra("intent.extra.isfullscreen", false)) {
            getWindow().setFlags(1024, 1024);
        }
        try {
            String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
            if (stringExtra != null) {
                IBridgeActivityDelegate iBridgeActivityDelegate = (IBridgeActivityDelegate) Class.forName(stringExtra).asSubclass(IBridgeActivityDelegate.class).newInstance();
                this.f36613a = iBridgeActivityDelegate;
                try {
                    iBridgeActivityDelegate.onBridgeActivityCreate(this);
                    return true;
                } catch (RuntimeException e16) {
                    HMSLog.e("BridgeActivity", "Run time Exception." + e16.getMessage());
                    return false;
                }
            }
            HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
            return false;
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | InstantiationException e17) {
            HMSLog.e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e17.getMessage());
            return false;
        }
    }

    private void c() {
        try {
            requestWindowFeature(1);
        } catch (Exception e16) {
            HMSLog.w("BridgeActivity", "requestWindowFeature " + e16.getMessage());
        }
        Window window = getWindow();
        if (f36612b >= 9) {
            window.addFlags(67108864);
            a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(0);
    }

    public static Intent getIntentStartBridgeActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(activity));
        return intent;
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(Window window) {
        if (window == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(1280);
            return;
        }
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes2), 65536);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("BridgeActivity", "com.huawei.android.view.LayoutParamsEx fail");
        }
    }

    @Override // android.app.Activity
    public void finish() {
        HMSLog.i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        Intent modifyIntentBehaviorsSafe = UIUtil.modifyIntentBehaviorsSafe(super.getIntent());
        if (modifyIntentBehaviorsSafe != null) {
            return new SafeIntent(modifyIntentBehaviorsSafe);
        }
        return null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        super.onActivityResult(i3, i16, safeIntent);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f36613a;
        if (iBridgeActivityDelegate != null && !iBridgeActivityDelegate.onBridgeActivityResult(i3, i16, safeIntent) && !isFinishing()) {
            setResult(i16, UIUtil.modifyIntentBehaviorsSafe(safeIntent));
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f36613a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeConfigurationChanged();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HMSLog.i("BridgeActivity", "BridgeActivity onCreate");
        if (getIntent() == null) {
            return;
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        c();
        a();
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(getApplicationContext());
        }
        setFullScreenWindowLayoutInDisplayCutout(getWindow());
        if (!b()) {
            setResult(1, null);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            ResolutionFlagUtil.getInstance().removeResolutionFlag(new SafeIntent(getIntent()).getStringExtra(CommonCode.MapKey.TRANSACTION_ID));
        } catch (Throwable th5) {
            HMSLog.w("BridgeActivity", "get transaction_id from intent fail: " + th5.getClass().getSimpleName());
        }
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f36613a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
        HMSLog.i("BridgeActivity", "BridgeActivity onDestroy");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f36613a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onKeyUp(i3, keyEvent);
        }
        return super.onKeyUp(i3, keyEvent);
    }

    private void a() {
        View findViewById = getWindow().findViewById(R.id.content);
        if (findViewById != null && (findViewById instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
                cls.getMethod("setDisplaySideMode", Integer.TYPE).invoke(cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 1);
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
                HMSLog.e("BridgeActivity", "An exception occurred while reading: setDisplaySideMode" + e16.getMessage());
            }
            getWindow().getDecorView().setOnApplyWindowInsetsListener(new a(viewGroup));
            return;
        }
        HMSLog.e("BridgeActivity", "rootView is null or not ViewGroup");
    }

    public static Intent getIntentStartBridgeActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra("intent.extra.isfullscreen", false);
        return intent;
    }

    private static int a(String str, int i3) {
        try {
            return ((Integer) SystemProperties.class.getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(SystemProperties.class, str, Integer.valueOf(i3))).intValue();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
            return i3;
        }
    }
}
