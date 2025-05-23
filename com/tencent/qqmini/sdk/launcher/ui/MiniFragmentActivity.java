package com.tencent.qqmini.sdk.launcher.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.AndroidOUIWrapperUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniFragmentActivity extends FragmentActivity {
    private static final String TAG = "MiniFragmentActivity";
    private MiniBaseFragment mFrag;

    private MiniBaseFragment createFragment() {
        try {
            Class cls = (Class) getIntent().getSerializableExtra("public_fragment_class");
            if (QMLog.isColorLevel()) {
                QMLog.d(TAG, "creating fragment " + cls);
            }
            if (cls != null) {
                MiniBaseFragment miniBaseFragment = (MiniBaseFragment) cls.newInstance();
                miniBaseFragment.setArguments(getIntent().getExtras());
                return miniBaseFragment;
            }
            return null;
        } catch (Exception e16) {
            QMLog.e(TAG, "create fragment error", e16);
            return null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    protected boolean doOnCreate(Bundle bundle) {
        this.mFrag = createFragment();
        setContentView(R.layout.mini_sdk_fragment_activity);
        if (this.mFrag == null) {
            finish();
            return false;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frag_container, this.mFrag);
        beginTransaction.commit();
        return true;
    }

    public MiniBaseFragment getFragment() {
        return this.mFrag;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        MiniBaseFragment fragment = getFragment();
        if (fragment != null) {
            fragment.onActivityResult(i3, i16, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MiniBaseFragment miniBaseFragment = this.mFrag;
        if (miniBaseFragment != null) {
            miniBaseFragment.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        requestWindowFeature(getIntent());
        super.onCreate(bundle);
        doOnCreate(bundle);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        MiniBaseFragment miniBaseFragment = this.mFrag;
        if (miniBaseFragment != null && miniBaseFragment.onKeyDown(i3, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    protected void requestWindowFeature(Intent intent) {
        try {
            intent.setExtrasClassLoader(getClassLoader());
            if (intent.hasExtra("public_fragment_window_feature")) {
                requestWindowFeature(intent.getIntExtra("public_fragment_window_feature", 0));
            }
        } catch (Exception e16) {
            QMLog.w(TAG, "Failed to request window feature", e16);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            super.setRequestedOrientation(i3);
        }
    }

    public String toString() {
        String str;
        String obj = super.toString();
        try {
            if (this.mFrag != null) {
                str = obj + "#" + this.mFrag.getClass().getName() + "@" + Integer.toHexString(this.mFrag.hashCode());
            } else if (getIntent() != null && getIntent().getStringExtra("public_fragment_class") != null) {
                str = obj + "#" + getIntent().getStringExtra("public_fragment_class");
            } else {
                return obj;
            }
            return str;
        } catch (Exception unused) {
            QMLog.i(TAG, "warn: intent extra get wrong");
            return obj;
        }
    }
}
