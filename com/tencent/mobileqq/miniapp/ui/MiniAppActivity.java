package com.tencent.mobileqq.miniapp.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.c;
import com.tencent.mobileqq.miniapp.d;
import com.tencent.mobileqq.miniapp.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected String f246819a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f246820b0;

    /* renamed from: c0, reason: collision with root package name */
    public d f246821c0;

    /* renamed from: d0, reason: collision with root package name */
    private MiniAppBaseFragment f246822d0;

    public MiniAppActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void F2(MiniAppBaseFragment miniAppBaseFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) miniAppBaseFragment);
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ckj, miniAppBaseFragment);
        beginTransaction.commit();
        this.f246822d0 = miniAppBaseFragment;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f167548ag);
        Bundle extras = getIntent().getExtras();
        MiniAppLoadingFragment miniAppLoadingFragment = new MiniAppLoadingFragment();
        miniAppLoadingFragment.setArguments(extras);
        F2(miniAppLoadingFragment);
        g.m();
        this.f246819a0 = getIntent().getStringExtra("key_appid");
        this.f246820b0 = getIntent().getIntExtra("key_appType", 0);
        MiniAppOptions miniAppOptions = (MiniAppOptions) getIntent().getParcelableExtra("key_options");
        c cVar = new c();
        cVar.f246789h = 2;
        cVar.f246788f = true;
        cVar.f246791m = new Object[]{this, this.f246819a0, Integer.valueOf(this.f246820b0), miniAppOptions};
        com.tencent.biz.qqstory.base.c.a().dispatch("MiniAppManager", cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        c cVar = new c();
        cVar.f246789h = 3;
        cVar.f246788f = true;
        cVar.f246791m = new Object[]{this.f246819a0, Integer.valueOf(this.f246820b0)};
        com.tencent.biz.qqstory.base.c.a().dispatch("MiniAppManager", cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        moveTaskToBack(true);
        overridePendingTransition(R.anim.f155031h7, R.anim.f154442w);
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
