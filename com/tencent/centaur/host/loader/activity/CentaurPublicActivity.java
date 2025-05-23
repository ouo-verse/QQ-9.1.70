package com.tencent.centaur.host.loader.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes5.dex */
public class CentaurPublicActivity extends AppCompatActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    protected CentaurPublicFragment f99081b0;

    public CentaurPublicActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected CentaurPublicFragment F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CentaurPublicFragment) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            CentaurPublicFragment centaurPublicFragment = (CentaurPublicFragment) Class.forName(getIntent().getStringExtra("public_fragment_class")).newInstance();
            centaurPublicFragment.setArguments(getIntent().getExtras());
            return centaurPublicFragment;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment == null || !centaurPublicFragment.overrideFinish()) {
            superFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null) {
            centaurPublicFragment.onActivityResult(i3, i16, intent);
        }
    }

    protected boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null && centaurPublicFragment.onBackEvent()) {
            return true;
        }
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (!onBackEvent()) {
            super.onBackPressed();
            if (!getSupportFragmentManager().popBackStackImmediate()) {
                finish();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
            return;
        }
        requestWindowFeature(getIntent());
        super.onCreate(bundle);
        if (getSupportFragmentManager().findFragmentById(R.id.ckj) != null) {
            this.f99081b0 = (CentaurPublicFragment) getSupportFragmentManager().findFragmentById(R.id.ckj);
        } else {
            this.f99081b0 = F2();
        }
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null) {
            centaurPublicFragment.initWindowStyleAndAnimation(this);
        }
        setContentView(R.layout.e17);
        if (this.f99081b0 == null) {
            finish();
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ckj, this.f99081b0);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null && centaurPublicFragment.doOnKeyDown(i3, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        super.onMultiWindowModeChanged(z16);
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null) {
            centaurPublicFragment.onMultiWindowModeChanged(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null) {
            centaurPublicFragment.onNewIntent(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null) {
            centaurPublicFragment.onRequestPermissionsResult(i3, strArr, iArr);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null) {
            centaurPublicFragment.onWindowFocusChanged(z16);
        }
    }

    protected void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
        } else if (intent.hasExtra("public_fragment_window_feature")) {
            requestWindowFeature(intent.getIntExtra("public_fragment_window_feature", 0));
        }
    }

    public void superFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        CentaurPublicFragment centaurPublicFragment = this.f99081b0;
        if (centaurPublicFragment != null) {
            centaurPublicFragment.beforeFinish();
        }
        super.finish();
        CentaurPublicFragment centaurPublicFragment2 = this.f99081b0;
        if (centaurPublicFragment2 != null) {
            centaurPublicFragment2.onFinish();
        }
    }
}
