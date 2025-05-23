package com.tencent.mobileqq.troop.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCreateMapViewSupportActivity extends TroopCreateBaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: d0, reason: collision with root package name */
    AutoLocationMapView f293673d0;

    /* renamed from: e0, reason: collision with root package name */
    RelativeLayout f293674e0;

    /* renamed from: f0, reason: collision with root package name */
    int f293675f0;

    public TroopCreateMapViewSupportActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f293675f0 = 0;
        }
    }

    private void S2() {
        ViewGroup viewGroup = (ViewGroup) this.f293669c0.getParent();
        viewGroup.removeView(this.f293669c0);
        this.f293674e0 = (RelativeLayout) getLayoutInflater().inflate(R.layout.a1j, (ViewGroup) null, true);
        this.f293675f0 = (int) getResources().getDimension(R.dimen.f159377aa4);
        AutoLocationMapView autoLocationMapView = new AutoLocationMapView(this);
        this.f293673d0 = autoLocationMapView;
        autoLocationMapView.setId(R.id.gdr);
        this.f293674e0.addView(this.f293673d0, new RelativeLayout.LayoutParams(-1, this.f293675f0));
        this.f293673d0.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.gdr);
        this.f293674e0.addView(this.f293669c0, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, R.id.rlCommenTitle);
        viewGroup.addView(this.f293674e0, layoutParams2);
    }

    @Override // com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        S2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        AutoLocationMapView autoLocationMapView = this.f293673d0;
        if (autoLocationMapView != null) {
            autoLocationMapView.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnPause();
        AutoLocationMapView autoLocationMapView = this.f293673d0;
        if (autoLocationMapView != null) {
            autoLocationMapView.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        AutoLocationMapView autoLocationMapView = this.f293673d0;
        if (autoLocationMapView != null) {
            autoLocationMapView.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnStop();
        AutoLocationMapView autoLocationMapView = this.f293673d0;
        if (autoLocationMapView != null) {
            autoLocationMapView.onStop();
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onRestart();
        AutoLocationMapView autoLocationMapView = this.f293673d0;
        if (autoLocationMapView != null) {
            autoLocationMapView.onRestart();
        }
    }
}
