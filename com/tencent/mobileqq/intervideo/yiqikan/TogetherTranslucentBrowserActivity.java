package com.tencent.mobileqq.intervideo.yiqikan;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.an;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TogetherTranslucentBrowserActivity extends QQTranslucentBrowserActivity {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class TogetherTranslucentBrowserFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a extends com.tencent.mobileqq.webview.swift.proxy.a {
            static IPatchRedirector $redirector_;

            a(t tVar) {
                super(tVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TogetherTranslucentBrowserFragment.this, (Object) tVar);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                } else {
                    TogetherTranslucentBrowserFragment.this.onFinalState(bundle, this.webViewKernelCallBack);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitUIContent(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                } else {
                    TogetherTranslucentBrowserFragment.this.onInitUIContent(bundle, this.webViewKernelCallBack);
                }
            }
        }

        public TogetherTranslucentBrowserFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public t getWebViewKernelCallBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (t) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
        public void onFinalState(Bundle bundle, t tVar) {
            Intent intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) tVar);
                return;
            }
            super.onFinalState(bundle, tVar);
            if (getActivity() != null && getActivity().getIntent() != null && (intent = this.intent) != null && intent.getIntExtra("key_dialog_type", -1) != -1) {
                getActivity().getWindow().setFlags(1024, 1024);
                getUIStyleHandler().T.setVisibility(8);
                getUIStyle().f314618a = true;
                an.e(super.getActivity());
                getWebTitleBarInterface().u5(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TogetherTranslucentBrowserActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                TogetherTranslucentBrowserActivity.this.finish();
            }
        }
    }

    public TogetherTranslucentBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFragmentClass = TogetherTranslucentBrowserFragment.class;
        }
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity, com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity, com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity
    public void showLoadingDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (isFinishing()) {
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.show();
            return;
        }
        int intExtra = getIntent().getIntExtra("key_dialog_type", -1);
        if (intExtra != 4 && intExtra != 5) {
            super.showLoadingDialog();
            return;
        }
        if (intExtra == 4) {
            this.loadingDialog = f.e(this);
        } else {
            this.loadingDialog = f.d(this, getIntent());
        }
        this.loadingDialog.setOnDismissListener(new a());
        this.loadingDialog.show();
    }
}
