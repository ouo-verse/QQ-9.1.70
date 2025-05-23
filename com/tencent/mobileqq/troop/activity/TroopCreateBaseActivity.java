package com.tencent.mobileqq.troop.activity;

import android.app.Dialog;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class TroopCreateBaseActivity extends AbsBaseWebViewActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected Dialog f293667a0;

    /* renamed from: b0, reason: collision with root package name */
    protected a f293668b0;

    /* renamed from: c0, reason: collision with root package name */
    CustomWebView f293669c0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f293670d;

        /* renamed from: e, reason: collision with root package name */
        String f293671e;

        /* renamed from: f, reason: collision with root package name */
        TroopCreateBaseActivity f293672f;

        public a(TroopCreateBaseActivity troopCreateBaseActivity, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, troopCreateBaseActivity, Integer.valueOf(i3), str);
                return;
            }
            this.f293672f = troopCreateBaseActivity;
            this.f293670d = i3;
            this.f293671e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (this.f293672f != null) {
                if (TextUtils.isEmpty(this.f293671e)) {
                    int i3 = this.f293670d;
                    if (i3 == 0) {
                        this.f293672f.P2();
                    } else if (i3 == 1) {
                        this.f293672f.Q2();
                    } else if (i3 == 2) {
                        this.f293672f.R2();
                    }
                } else {
                    CustomWebView customWebView = this.f293672f.f293669c0;
                    if (customWebView != null) {
                        customWebView.callJs(this.f293671e, "");
                    }
                }
                this.f293672f.M2(this.f293670d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TroopCreateBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void M2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f293669c0.getWindowToken(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N2() {
        Dialog dialog = this.f293667a0;
        if (dialog != null) {
            if (dialog.isShowing()) {
                this.f293667a0.dismiss();
            }
            this.f293667a0 = null;
        }
    }

    protected void P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.f293669c0.canGoBack()) {
            this.f293669c0.goBack();
        } else {
            finish();
        }
    }

    protected void Q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    protected void R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        String queryParameter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        TouchWebView webView = getWebView(null);
        this.f293669c0 = webView;
        webView.setId(R.id.webview);
        setContentView(this.f293669c0);
        String stringExtra = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        Uri parse = Uri.parse(stringExtra);
        if (parse.isHierarchical() && (queryParameter = parse.getQueryParameter("_wv")) != null) {
            try {
                this.mRulesFromUrl = Long.parseLong(queryParameter, 10);
            } catch (NumberFormatException unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("TroopCreateBaseActivity", 4, "_wv param not found");
                }
            }
        }
        this.f293669c0.loadUrl(stringExtra);
        this.leftView.setOnClickListener(new a(this, 0, null));
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        a aVar = this.f293668b0;
        if (aVar != null) {
            aVar.onClick(this.leftView);
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity
    protected void onReceivedTitle(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) webView, (Object) str);
        } else {
            setTitle(str);
        }
    }
}
