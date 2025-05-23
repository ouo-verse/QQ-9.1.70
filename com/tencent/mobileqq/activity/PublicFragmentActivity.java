package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@Deprecated
/* loaded from: classes9.dex */
public class PublicFragmentActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    private static ArrayMap<String, a> f176715b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f176716c0 = 0;

    /* renamed from: a0, reason: collision with root package name */
    private PublicBaseFragment f176717a0;

    /* loaded from: classes9.dex */
    public interface a {
        View onCreateView(String str, Context context, AttributeSet attributeSet);
    }

    /* loaded from: classes9.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        public static void a(Context context, Intent intent, Class<? extends PublicFragmentActivity> cls, Class<? extends PublicBaseFragment> cls2) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(context, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            context.startActivity(intent);
        }

        public static void b(Context context, Class<? extends PublicFragmentActivity> cls, Class<? extends PublicBaseFragment> cls2) {
            a(context, null, cls, cls2);
        }

        public static void c(Intent intent, Class<? extends PublicFragmentActivity> cls, Class<? extends PublicBaseFragment> cls2) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(BaseApplicationImpl.getApplication(), cls);
            intent.addFlags(268435456);
            intent.putExtra("public_fragment_class", cls2.getName());
            BaseApplicationImpl.getApplication().startActivity(intent);
        }

        public static void d(Activity activity, Intent intent, Class<? extends PublicFragmentActivity> cls, Class<? extends PublicBaseFragment> cls2, int i3) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(activity, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            activity.startActivityForResult(intent, i3);
        }

        public static void e(Context context, Intent intent, Class<? extends PublicFragmentActivity> cls, Class<? extends PublicBaseFragment> cls2, int i3) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(context, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            ((Activity) context).startActivityForResult(intent, i3);
        }

        public static void f(BaseFragment baseFragment, Intent intent, Class<? extends PublicFragmentActivity> cls, Class<? extends PublicBaseFragment> cls2, int i3) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(baseFragment.getBaseActivity(), cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            baseFragment.startActivityForResult(intent, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f176715b0 = new ArrayMap<>();
        }
    }

    public PublicFragmentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private PublicBaseFragment F2() {
        String stringExtra = getIntent().getStringExtra("public_fragment_class");
        if (QLog.isColorLevel()) {
            QLog.d("PublicFragmentActivity", 2, "creating fragment ", stringExtra);
        }
        try {
            PublicBaseFragment publicBaseFragment = (PublicBaseFragment) Class.forName(stringExtra).newInstance();
            publicBaseFragment.setArguments(getIntent().getExtras());
            return publicBaseFragment;
        } catch (Exception e16) {
            bn.f180605a = Log.getStackTraceString(e16);
            QLog.e("PublicFragmentActivity", 1, "create fragment error", e16);
            return null;
        }
    }

    public static void start(Context context, Intent intent, Class<? extends PublicBaseFragment> cls) {
        b.a(context, intent, PublicFragmentActivity.class, cls);
    }

    public static void startForResult(Activity activity, Intent intent, Class<? extends PublicBaseFragment> cls, int i3) {
        b.d(activity, intent, PublicFragmentActivity.class, cls, i3);
    }

    public PublicBaseFragment G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (PublicBaseFragment) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f176717a0;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16 = true;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        } else {
            PublicBaseFragment publicBaseFragment = this.f176717a0;
            if (publicBaseFragment == null || !publicBaseFragment.needDispatchTouchEvent() || !this.f176717a0.dispatchTouchEvent(motionEvent)) {
                z16 = super.dispatchTouchEvent(motionEvent);
            }
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
        return z16;
    }

    @Override // mqq.app.AppActivity
    protected void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (this.f176717a0 != null && !eo.a(i3)) {
            this.f176717a0.onActivityResult(i3 & 65535, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
        } else {
            super.doOnConfigurationChanged(configuration);
            initRequestedOrientation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle)).booleanValue();
        }
        this.f176717a0 = F2();
        initRequestedOrientation();
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            this.mNeedStatusTrans = publicBaseFragment.needStatusTrans();
            this.mActNeedImmersive = this.f176717a0.needImmersive();
            this.f176717a0.initWindowStyleAndAnimation(this);
        }
        if (bundle != null) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicFragmentActivity", 1, "Activity restored, set classloader.");
            }
            com.tencent.mobileqq.utils.dz.a(bundle, getClass().getClassLoader());
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f167552aj);
        if (this.f176717a0 == null) {
            finish();
            return false;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ckj, this.f176717a0);
        beginTransaction.commitAllowingStateLoss();
        this.f176717a0.initSideFling(this, GestureActivityModule.getFlingHandler(this));
        return true;
    }

    @Override // mqq.app.AppActivity
    protected boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null && publicBaseFragment.doOnKeyDown(i3, keyEvent)) {
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            publicBaseFragment.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment == null || !publicBaseFragment.overrideFinish()) {
            superFinish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getCIOPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            return publicBaseFragment.getCIOPageName();
        }
        return super.getCIOPageName();
    }

    protected void initRequestedOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            if (publicBaseFragment.isAllowLandscape()) {
                com.tencent.mobileqq.pad.c.c(this);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isSupportScreenShot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null && !publicBaseFragment.isSupportScreenShot()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            return publicBaseFragment.isWrapContent();
        }
        return super.getNeedGestureBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onAccountChanged();
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            publicBaseFragment.onAccountChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment == null) {
            return super.onBackEvent();
        }
        return publicBaseFragment.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, this, str, context, attributeSet);
        }
        if (f176715b0.containsKey(str) && (onCreateView = f176715b0.get(str).onCreateView(str, context, attributeSet)) != null) {
            return onCreateView;
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        super.onMultiWindowModeChanged(z16);
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            publicBaseFragment.onMultiWindowModeChanged(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            publicBaseFragment.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onPreThemeChanged();
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            publicBaseFragment.onPreThemeChanged();
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            publicBaseFragment.onWindowFocusChanged(z16);
        }
    }

    @Override // mqq.app.AppActivity
    protected void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.requestWindowFeature(intent);
        if (intent.hasExtra("public_fragment_window_feature")) {
            requestWindowFeature(intent.getIntExtra("public_fragment_window_feature", 0));
        }
    }

    @Override // mqq.app.AppActivity
    public void superFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        PublicBaseFragment publicBaseFragment = this.f176717a0;
        if (publicBaseFragment != null) {
            publicBaseFragment.beforeFinish();
        }
        super.finish();
        PublicBaseFragment publicBaseFragment2 = this.f176717a0;
        if (publicBaseFragment2 != null) {
            publicBaseFragment2.onFinish();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        String obj = super.toString();
        if (this.f176717a0 != null) {
            return obj + "#" + this.f176717a0.getClass().getName() + "@" + Integer.toHexString(this.f176717a0.hashCode());
        }
        if (getIntent() != null && getIntent().getStringExtra("public_fragment_class") != null) {
            return obj + "#" + getIntent().getStringExtra("public_fragment_class");
        }
        return obj;
    }

    public static void start(Context context, Class<? extends PublicBaseFragment> cls) {
        start(context, null, cls);
    }
}
