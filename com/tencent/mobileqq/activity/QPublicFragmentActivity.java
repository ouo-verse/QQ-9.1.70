package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.IOException;
import java.io.InputStream;
import mqq.app.Constants;

/* loaded from: classes9.dex */
public class QPublicFragmentActivity extends QBaseActivity {
    static IPatchRedirector $redirector_ = null;
    public static final int BUSINESS_DESCRIPTION_MAX_LENGTH = 50;
    public static final String KEY_FRAGMENT_CLASS = "public_fragment_class";
    public static final String KEY_WINDOW_FEATURE = "public_fragment_window_feature";
    private static final String TAG = " QPublicFragmentActivity";
    private static ArrayMap<String, a> viewCreators;
    private QPublicBaseFragment mFrag;

    /* loaded from: classes9.dex */
    public interface a {
        View onCreateView(String str, Context context, AttributeSet attributeSet);
    }

    /* loaded from: classes9.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        public static void a(Context context, Intent intent, Bundle bundle, Class<? extends QPublicFragmentActivity> cls, Class<? extends QPublicBaseFragment> cls2) {
            if (intent == null) {
                intent = new Intent();
            }
            Context b16 = ep.b(context);
            intent.setClass(b16, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            b16.startActivity(intent, bundle);
        }

        public static void b(Context context, Intent intent, Class<? extends QPublicFragmentActivity> cls, Class<? extends QPublicBaseFragment> cls2) {
            if (intent == null) {
                intent = new Intent();
            }
            Context b16 = ep.b(context);
            intent.setClass(b16, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            b16.startActivity(intent);
        }

        public static void c(Context context, Class<? extends QPublicFragmentActivity> cls, Class<? extends QPublicBaseFragment> cls2) {
            b(context, null, cls, cls2);
        }

        public static void d(Intent intent, Class<? extends QPublicFragmentActivity> cls, Class<? extends QPublicBaseFragment> cls2) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(BaseApplication.context, cls);
            intent.addFlags(268435456);
            intent.putExtra("public_fragment_class", cls2.getName());
            BaseApplication.context.startActivity(intent);
        }

        public static void e(Activity activity, Intent intent, Class<? extends QPublicFragmentActivity> cls, Class<? extends QPublicBaseFragment> cls2, int i3) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(activity, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            activity.startActivityForResult(intent, i3);
        }

        public static void f(Context context, Intent intent, Class<? extends QPublicFragmentActivity> cls, Class<? extends QPublicBaseFragment> cls2, int i3) {
            if (intent == null) {
                intent = new Intent();
            }
            Context b16 = ep.b(context);
            intent.setClass(b16, cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            ((Activity) b16).startActivityForResult(intent, i3);
        }

        public static void g(QBaseFragment qBaseFragment, Intent intent, Class<? extends QPublicFragmentActivity> cls, Class<? extends QPublicBaseFragment> cls2, int i3) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(qBaseFragment.getActivity(), cls);
            intent.putExtra("public_fragment_class", cls2.getName());
            qBaseFragment.startActivityForResult(intent, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            viewCreators = new ArrayMap<>();
        }
    }

    public QPublicFragmentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addViewCreator(String str, a aVar) {
        viewCreators.put(str, aVar);
    }

    public static void closeQuietly(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private QPublicBaseFragment createFragment() {
        String stringExtra = getIntent().getStringExtra("public_fragment_class");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "creating fragment ", stringExtra);
        }
        try {
            QPublicBaseFragment qPublicBaseFragment = (QPublicBaseFragment) Class.forName(stringExtra).newInstance();
            qPublicBaseFragment.setArguments(getIntent().getExtras());
            return qPublicBaseFragment;
        } catch (Exception e16) {
            bn.f180605a = Log.getStackTraceString(e16);
            QLog.e(TAG, 1, "create fragment error", e16);
            return null;
        }
    }

    public static void start(Context context, Intent intent, Bundle bundle, Class<? extends QPublicBaseFragment> cls) {
        b.a(context, intent, bundle, QPublicFragmentActivity.class, cls);
    }

    public static void startForResult(Activity activity, Intent intent, Class<? extends QPublicBaseFragment> cls, int i3) {
        b.e(activity, intent, QPublicFragmentActivity.class, cls, i3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16 = true;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        } else {
            QPublicBaseFragment qPublicBaseFragment = this.mFrag;
            if (qPublicBaseFragment == null || !qPublicBaseFragment.needDispatchTouchEvent() || !this.mFrag.dispatchTouchEvent(motionEvent)) {
                z16 = super.dispatchTouchEvent(motionEvent);
            }
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (this.mFrag != null && !eo.a(i3)) {
            this.mFrag.onActivityResult(i3 & 65535, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
        } else {
            super.doOnConfigurationChanged(configuration);
            initRequestedOrientation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mFrag = createFragment();
        initRequestedOrientation();
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            this.mNeedStatusTrans = qPublicBaseFragment.needStatusTrans();
            this.mActNeedImmersive = this.mFrag.needImmersive();
            this.mFrag.initWindowStyleAndAnimation(this);
        }
        if (bundle != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "Activity restored, set classloader.");
            }
            com.tencent.mobileqq.utils.dz.a(bundle, getClass().getClassLoader());
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f167552aj);
        if (this.mFrag == null) {
            finish();
            return false;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ckj, this.mFrag);
        beginTransaction.commitAllowingStateLoss();
        return true;
    }

    @Override // mqq.app.AppActivity
    protected boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null && qPublicBaseFragment.doOnKeyDown(i3, keyEvent)) {
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null && qPublicBaseFragment.overrideFinish()) {
            activityCloseAnimation();
        } else {
            superFinish();
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null && qPublicBaseFragment.overrideFinishAfterTransition()) {
            activityCloseAnimation();
        } else {
            super.finishAfterTransition();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getCIOPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            return qPublicBaseFragment.getCIOPageName();
        }
        return super.getCIOPageName();
    }

    public QPublicBaseFragment getFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (QPublicBaseFragment) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mFrag;
    }

    protected void initRequestedOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            if (qPublicBaseFragment.isAllowLandscape()) {
                com.tencent.mobileqq.pad.c.c(this);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isSupportScreenShot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null && !qPublicBaseFragment.isSupportScreenShot()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            return qPublicBaseFragment.isWrapContent();
        }
        return super.getNeedGestureBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.onAccountChanged();
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onAccountChanged();
        }
    }

    @Override // mqq.app.AppActivity
    protected void onAccoutChangeFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.onAccoutChangeFailed();
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onAccountChangeFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment == null) {
            return super.onBackEvent();
        }
        return qPublicBaseFragment.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (View) iPatchRedirector.redirect((short) 28, this, str, context, attributeSet);
        }
        if (viewCreators.containsKey(str) && (onCreateView = viewCreators.get(str).onCreateView(str, context, attributeSet)) != null) {
            return onCreateView;
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.onEnterAnimationComplete();
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onActivityEnterAnimationComplete();
        }
    }

    @Override // mqq.app.AppActivity
    protected void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) logoutReason);
            return;
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null && qPublicBaseFragment.overrideOnLogout()) {
            return;
        }
        super.onLogout(logoutReason);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        super.onMultiWindowModeChanged(z16);
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onMultiWindowModeChanged(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onPreThemeChanged();
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onPreThemeChanged();
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
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onWindowFocusChanged(z16);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.beforeFinish();
        }
        super.finish();
        QPublicBaseFragment qPublicBaseFragment2 = this.mFrag;
        if (qPublicBaseFragment2 != null) {
            qPublicBaseFragment2.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean themeChangeRightNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        QPublicBaseFragment qPublicBaseFragment = this.mFrag;
        if (qPublicBaseFragment != null) {
            return qPublicBaseFragment.themeChangeRightNow();
        }
        return super.themeChangeRightNow();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        String obj = super.toString();
        if (this.mFrag != null) {
            String str = obj + "#" + this.mFrag.getClass().getName() + "@" + Integer.toHexString(this.mFrag.hashCode());
            String businessDescription = this.mFrag.getBusinessDescription();
            if (!TextUtils.isEmpty(businessDescription)) {
                String trim = businessDescription.trim();
                if (trim.length() > 50) {
                    trim = trim.substring(0, 50);
                }
                return str + "{" + trim + "}";
            }
            return str;
        }
        if (getIntent() != null && getIntent().getStringExtra("public_fragment_class") != null) {
            return obj + "#" + getIntent().getStringExtra("public_fragment_class");
        }
        return obj;
    }

    public static void start(Context context, Intent intent, Class<? extends QPublicBaseFragment> cls) {
        b.b(context, intent, QPublicFragmentActivity.class, cls);
    }

    public static void startForResult(Activity activity, Class<? extends QPublicBaseFragment> cls, int i3) {
        startForResult(activity, (Intent) null, cls, i3);
    }

    public static void start(Context context, Class<? extends QPublicBaseFragment> cls) {
        start(context, null, cls);
    }

    public static void startForResult(QBaseFragment qBaseFragment, Intent intent, Class<? extends QPublicBaseFragment> cls, int i3) {
        b.g(qBaseFragment, intent, QPublicFragmentActivity.class, cls, i3);
    }

    public static void startForResult(QBaseFragment qBaseFragment, Class<? extends QPublicBaseFragment> cls, int i3) {
        startForResult(qBaseFragment, (Intent) null, cls, i3);
    }
}
