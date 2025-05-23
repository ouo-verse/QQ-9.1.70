package com.tencent.mobileqq.guild.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.bn;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QQGuildAIOSingleTaskTransActivity extends BaseActivity {

    /* renamed from: b0, reason: collision with root package name */
    private static ArrayMap<String, a> f213884b0 = new ArrayMap<>();

    /* renamed from: a0, reason: collision with root package name */
    private QPublicBaseFragment f213885a0;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface a {
        View onCreateView(String str, Context context, AttributeSet attributeSet);
    }

    private QPublicBaseFragment createFragment() {
        String stringExtra = getIntent().getStringExtra("public_fragment_class");
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildAIOSingleTaskTransActivity", 2, "creating fragment ", stringExtra);
        }
        try {
            QPublicBaseFragment qPublicBaseFragment = (QPublicBaseFragment) Class.forName(stringExtra).newInstance();
            qPublicBaseFragment.setArguments(getIntent().getExtras());
            return qPublicBaseFragment;
        } catch (Exception e16) {
            bn.f180605a = Log.getStackTraceString(e16);
            QLog.e("QQGuildAIOSingleTaskTransActivity", 1, "create fragment error", e16);
            return null;
        }
    }

    private void patchSavedInstanceState(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("android:support:fragments");
        if (parcelable != null) {
            try {
                Class<?> cls = Class.forName("androidx.fragment.app.FragmentManagerState");
                Class<?> cls2 = Class.forName("androidx.fragment.app.FragmentState");
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
                QLog.d("QQGuildAIOSingleTaskTransActivity", 2, "Patch error");
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null && qPublicBaseFragment.needDispatchTouchEvent() && this.f213885a0.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onActivityResult(i3 & 65535, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        QPublicBaseFragment createFragment = createFragment();
        this.f213885a0 = createFragment;
        if (createFragment != null) {
            this.mNeedStatusTrans = createFragment.needStatusTrans();
            this.mActNeedImmersive = this.f213885a0.needImmersive();
            this.f213885a0.initWindowStyleAndAnimation(this);
        }
        if (bundle != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGuildAIOSingleTaskTransActivity", 1, "Activity restored, set classloader.");
            }
            patchSavedInstanceState(bundle);
            F2(bundle);
        }
        super.doOnCreate(bundle);
        if (this.f213885a0 == null) {
            finish();
            return false;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.content, this.f213885a0);
        beginTransaction.commitAllowingStateLoss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment == null || !qPublicBaseFragment.doOnKeyDown(i3, keyEvent)) {
            return super.doOnKeyDown(i3, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        if (getIntent().getIntExtra("channel_type", -1) != intent.getIntExtra("channel_type", -1)) {
            finish();
            BaseApplicationImpl.getApplication().startActivity(intent);
            return;
        }
        setIntent(intent);
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        if (QLog.isColorLevel()) {
            QLog.i("QQGuildAIOSingleTaskTransActivity", 1, QLog.getStackTraceString(new Throwable("finish activity")));
        }
        QLog.i("QQGuildAIOSingleTaskTransActivity", 1, "finish");
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment == null || !qPublicBaseFragment.overrideFinish()) {
            superFinish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getCIOPageName() {
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            return qPublicBaseFragment.getCIOPageName();
        }
        return super.getCIOPageName();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity
    public ChatFragment getChatFragment() {
        return super.getChatFragment();
    }

    public QPublicBaseFragment getFragment() {
        return this.f213885a0;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isSupportScreenShot() {
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        return qPublicBaseFragment == null || qPublicBaseFragment.isSupportScreenShot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            return qPublicBaseFragment.isWrapContent();
        }
        return super.getNeedGestureBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        super.onAccountChanged();
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onAccountChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        removeFragmentState(bundle);
        super.onCreate(bundle);
        if (AppSetting.t(getBaseContext())) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        return (!f213884b0.containsKey(str) || (onCreateView = f213884b0.get(str).onCreateView(str, context, attributeSet)) == null) ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f213885a0 != null) {
            this.f213885a0 = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        super.onMultiWindowModeChanged(z16);
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onMultiWindowModeChanged(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        super.onPreThemeChanged();
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onPreThemeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        removeFragmentState(bundle);
        super.onSaveInstanceState(bundle);
        F2(bundle);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onWindowFocusChanged(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        super.requestWindowFeature(intent);
        if (intent.hasExtra("public_fragment_window_feature")) {
            requestWindowFeature(intent.getIntExtra("public_fragment_window_feature", 0));
        }
    }

    @Override // mqq.app.AppActivity
    public void superFinish() {
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.beforeFinish();
        }
        super.finish();
        QPublicBaseFragment qPublicBaseFragment2 = this.f213885a0;
        if (qPublicBaseFragment2 != null) {
            qPublicBaseFragment2.onFinish();
        }
    }

    public String toString() {
        String str;
        String obj = super.toString();
        try {
            if (this.f213885a0 != null) {
                str = obj + "#" + this.f213885a0.getClass().getName() + "@" + Integer.toHexString(this.f213885a0.hashCode());
            } else {
                if (getIntent() == null || getIntent().getStringExtra("public_fragment_class") == null) {
                    return obj;
                }
                str = obj + "#" + getIntent().getStringExtra("public_fragment_class");
            }
            return str;
        } catch (Exception e16) {
            QLog.e("QQGuildAIOSingleTaskTransActivity", 1, "toString error", e16);
            return obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class b {
        public static void a(Intent intent, Class<? extends QQGuildAIOSingleTaskTransActivity> cls, Class<? extends QPublicBaseFragment> cls2) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(BaseApplicationImpl.getApplication(), cls);
            intent.addFlags(268435456);
            intent.putExtra("public_fragment_class", cls2.getName());
            BaseApplicationImpl.getApplication().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        QLog.i("QQGuildAIOSingleTaskTransActivity", 1, "onBackEvent");
        QPublicBaseFragment qPublicBaseFragment = this.f213885a0;
        if (qPublicBaseFragment == null) {
            return super.onBackEvent();
        }
        return qPublicBaseFragment.onBackEvent();
    }

    private void F2(Bundle bundle) {
        if (bundle != null) {
            removeFragmentState(bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
        }
    }

    private void removeFragmentState(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:viewHierarchyState");
            bundle.remove("android:fragments");
            bundle.remove("android:support:fragments");
        }
    }
}
