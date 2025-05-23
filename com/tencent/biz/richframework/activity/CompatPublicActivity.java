package com.tencent.biz.richframework.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.biz.richframework.compat.AndroidOUIWrapperUtil;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public class CompatPublicActivity extends ComponentBaseActivity {
    public static final String KEY_FINISH_WITH_ANIMATION = "finish_with_animation";
    public static final String KEY_FRAGMENT_CLASS = "public_fragment_class";
    public static final String KEY_THEME_ID = "key_theme_id";
    public static final String KEY_TRANSACTION_ANIMATION = "transaction_animation";
    public static final String KEY_WINDOW_FEATURE = "public_fragment_window_feature";
    private static final String TAG = "CompatPublicActivity";
    private static final ArrayMap<String, IViewCreator> viewCreators = new ArrayMap<>();
    protected CompatPublicFragment mFrag;

    /* loaded from: classes5.dex */
    public interface IViewCreator {
        View onCreateView(String str, Context context, AttributeSet attributeSet);
    }

    public static void addViewCreator(String str, IViewCreator iViewCreator) {
        viewCreators.put(str, iViewCreator);
    }

    private void dispatchResultToChildFragment(Fragment fragment, int i3, int i16, Intent intent) {
        if (fragment.getHost() == null) {
            return;
        }
        for (Fragment fragment2 : fragment.getChildFragmentManager().getFragments()) {
            if (fragment2 != null) {
                fragment2.onActivityResult(65535 & i3, i16, intent);
                dispatchResultToChildFragment(fragment2, i3, i16, intent);
            }
        }
    }

    private void patchSavedInstanceState(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("android:support:fragments");
        if (parcelable != null) {
            try {
                Class<?> cls = Class.forName("android.support.v4.app.FragmentManagerState");
                Class<?> cls2 = Class.forName("android.support.v4.app.FragmentState");
                if (cls.isInstance(parcelable)) {
                    Field declaredField = cls.getDeclaredField("mActive");
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    if (declaredField.getType().isArray()) {
                        Object obj = declaredField.get(parcelable);
                        int length = Array.getLength(obj);
                        for (int i3 = 0; i3 < length; i3++) {
                            Object obj2 = Array.get(obj, i3);
                            if (obj2 != null && cls2.isInstance(obj2)) {
                                Field declaredField2 = cls2.getDeclaredField("mArguments");
                                if (!declaredField2.isAccessible()) {
                                    declaredField2.setAccessible(true);
                                }
                                Object obj3 = declaredField2.get(obj2);
                                if (obj3 != null && (obj3 instanceof Bundle)) {
                                    ((Bundle) obj3).setClassLoader(getClass().getClassLoader());
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
                RFWLog.d(TAG, RFWLog.CLR, "Patch error");
            }
        }
    }

    private void setTheme() {
        int intExtra = getIntent().getIntExtra(KEY_THEME_ID, -1);
        if (intExtra != -1) {
            getTheme().applyStyle(intExtra, true);
        }
    }

    public static void start(Context context, Intent intent, Class<? extends CompatPublicFragment> cls) {
        Launcher.start(context, intent, CompatPublicActivity.class, cls);
    }

    public static void startForResult(Activity activity, Intent intent, Class<? extends CompatPublicFragment> cls, int i3) {
        Launcher.startForResult(activity, intent, (Class<? extends CompatPublicActivity>) CompatPublicActivity.class, cls, i3);
    }

    private void triggerFinish() {
        if (getIntent().getBooleanExtra(KEY_FINISH_WITH_ANIMATION, false)) {
            finishAfterTransition();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CompatPublicFragment createFragment() {
        String stringExtra = getIntent().getStringExtra("public_fragment_class");
        RFWLog.d(TAG, RFWLog.CLR, "creating fragment ", stringExtra);
        try {
            CompatPublicFragment compatPublicFragment = (CompatPublicFragment) Class.forName(stringExtra).newInstance();
            compatPublicFragment.setArguments(getIntent().getExtras());
            return compatPublicFragment;
        } catch (Exception e16) {
            RFWLog.fatal(TAG, RFWLog.USR, "create fragment error", e16);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment == null || !compatPublicFragment.overrideFinish()) {
            superFinish();
        }
    }

    public CompatPublicFragment getFragment() {
        return this.mFrag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment != null) {
            compatPublicFragment.onActivityResult(65535 & i3, i16, intent);
            dispatchResultToChildFragment(this.mFrag, i3, i16, intent);
        }
    }

    protected boolean onBackEvent() {
        boolean z16;
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment != null && compatPublicFragment.onBackEvent()) {
            z16 = true;
        } else {
            z16 = false;
        }
        RFWLog.d("ASDynamicEngine_back", RFWLog.USR, "doDispatchKeyEvent fsActivity:" + z16);
        return z16;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!onBackEvent()) {
            try {
                super.onBackPressed();
                if (!getSupportFragmentManager().popBackStackImmediate()) {
                    RFWLog.d("ASDynamicEngine_back", RFWLog.USR, "doDispatchKeyEvent fsActivity finish this:");
                    triggerFinish();
                }
            } catch (Throwable th5) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.d(TAG, RFWLog.CLR, "", th5);
                }
                triggerFinish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(getIntent());
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        setTheme();
        super.onCreate(bundle);
        if (getSupportFragmentManager() != null && getSupportFragmentManager().findFragmentById(R.id.ckj) != null) {
            this.mFrag = (CompatPublicFragment) getSupportFragmentManager().findFragmentById(R.id.ckj);
        } else {
            this.mFrag = createFragment();
        }
        if (bundle != null) {
            RFWLog.d(TAG, RFWLog.USR, "Activity restored, set classloader.");
            patchSavedInstanceState(bundle);
        }
        setContentView(R.layout.f169063hn0);
        if (this.mFrag == null) {
            RFWLog.d(TAG, RFWLog.USR, "onCreate error frag null.");
            finish();
        } else {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int[] intArrayExtra = getIntent().getIntArrayExtra(KEY_TRANSACTION_ANIMATION);
            if (intArrayExtra != null && intArrayExtra.length == 4) {
                beginTransaction.setCustomAnimations(intArrayExtra[0], intArrayExtra[1], intArrayExtra[2], intArrayExtra[3]);
            }
            beginTransaction.replace(R.id.ckj, this.mFrag);
            beginTransaction.commitAllowingStateLoss();
        }
        RFWLog.d(TAG, RFWLog.USR, "onCreate success");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        ArrayMap<String, IViewCreator> arrayMap = viewCreators;
        if (arrayMap.containsKey(str) && (onCreateView = arrayMap.get(str).onCreateView(str, context, attributeSet)) != null) {
            return onCreateView;
        }
        return super.onCreateView(str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment != null && compatPublicFragment.doOnKeyDown(i3, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z16) {
        super.onMultiWindowModeChanged(z16);
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment != null) {
            compatPublicFragment.onMultiWindowModeChanged(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment != null) {
            compatPublicFragment.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment != null) {
            compatPublicFragment.onWindowFocusChanged(z16);
        }
    }

    protected void requestWindowFeature(Intent intent) {
        if (intent.hasExtra("public_fragment_window_feature")) {
            requestWindowFeature(intent.getIntExtra("public_fragment_window_feature", 0));
        }
    }

    public void superFinish() {
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment != null) {
            compatPublicFragment.beforeFinish();
        }
        super.finish();
        CompatPublicFragment compatPublicFragment2 = this.mFrag;
        if (compatPublicFragment2 != null) {
            compatPublicFragment2.onFinish();
        }
    }

    public String toString() {
        String obj = super.toString();
        if (this.mFrag != null) {
            return obj + "#" + this.mFrag.getClass().getName() + "@" + Integer.toHexString(this.mFrag.hashCode());
        }
        if (getIntent() != null && getIntent().getStringExtra("public_fragment_class") != null) {
            return obj + "#" + getIntent().getStringExtra("public_fragment_class");
        }
        return obj;
    }

    public static void start(Context context, Class<? extends CompatPublicFragment> cls) {
        start(context, null, cls);
    }

    public static void startForResult(Activity activity, Class<? extends CompatPublicFragment> cls, int i3) {
        startForResult(activity, (Intent) null, cls, i3);
    }

    public static void startForResult(Fragment fragment, Intent intent, Class<? extends CompatPublicFragment> cls, int i3) {
        Launcher.startForResult(fragment, intent, (Class<? extends CompatPublicActivity>) CompatPublicActivity.class, cls, i3);
    }

    /* loaded from: classes5.dex */
    public static class Launcher {
        public static void start(Context context, Intent intent, Class<? extends CompatPublicActivity> cls, Class<? extends CompatPublicFragment> cls2) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(context, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            context.startActivity(intent);
        }

        public static void startForResult(Activity activity, Intent intent, Class<? extends CompatPublicActivity> cls, Class<? extends CompatPublicFragment> cls2, int i3) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(activity, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            activity.startActivityForResult(intent, i3);
        }

        public static void start(Intent intent, Class<? extends CompatPublicActivity> cls, Class<? extends CompatPublicFragment> cls2) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(AutoShadowPluginRuntime.getInstance().getApplication(), cls);
            intent.addFlags(268435456);
            intent.putExtra("public_fragment_class", cls2.getName());
            AutoShadowPluginRuntime.getInstance().getApplication().startActivity(intent);
        }

        public static void startForResult(Fragment fragment, Intent intent, Class<? extends CompatPublicActivity> cls, Class<? extends CompatPublicFragment> cls2, int i3) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(fragment.getActivity(), cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            fragment.startActivityForResult(intent, i3);
        }
    }

    public static void startForResult(Fragment fragment, Class<? extends CompatPublicFragment> cls, int i3) {
        startForResult(fragment, (Intent) null, cls, i3);
    }
}
