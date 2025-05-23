package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQH5BrowserActivity extends QQBrowserActivity {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class QQH5BrowserFragment extends WebViewFragment {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a extends com.tencent.mobileqq.webview.swift.proxy.a {
            static IPatchRedirector $redirector_;

            a(com.tencent.mobileqq.webview.swift.utils.t tVar) {
                super(tVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQH5BrowserFragment.this, (Object) tVar);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                } else {
                    super.onFinalState(bundle);
                    QQH5BrowserFragment.this.qh(bundle);
                }
            }
        }

        public QQH5BrowserFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qh(Bundle bundle) {
            super.getQBaseActivity().getWindow().setFlags(1024, 1024);
            this.webView.setVerticalScrollBarEnabled(false);
            getUIStyleHandler().T.setVisibility(8);
            if (getSwiftTitleUI().M.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getSwiftTitleUI().M.getLayoutParams();
                layoutParams.height = (int) com.tencent.av.utils.ba.dp2px(BaseApplicationImpl.getApplication(), 60.0f);
                getSwiftTitleUI().M.setLayoutParams(layoutParams);
            }
            getSwiftTitleUI().M.setPadding(0, 0, 0, 0);
            int dp2px = (int) com.tencent.av.utils.ba.dp2px(BaseApplicationImpl.getApplication(), 12.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = (int) com.tencent.av.utils.ba.dp2px(BaseApplicationImpl.getApplication(), 15.0f);
            layoutParams2.height = (int) com.tencent.av.utils.ba.dp2px(BaseApplicationImpl.getApplication(), 15.0f);
            getSwiftTitleUI().f314054i.setLayoutParams(layoutParams2);
            getSwiftTitleUI().f314054i.setBackgroundResource(R.drawable.cns);
            getSwiftTitleUI().f314054i.setText("");
            ViewParent parent = getSwiftTitleUI().f314054i.getParent();
            if (parent instanceof RelativeLayout) {
                ((RelativeLayout) parent).setPadding(0, 0, 0, 0);
                parent.requestLayout();
            }
            View findViewById = super.getQBaseActivity().findViewById(R.id.f166810ie2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(9);
            layoutParams3.setMargins(dp2px, dp2px, 0, 0);
            findViewById.setLayoutParams(layoutParams3);
            ViewGroup.LayoutParams layoutParams4 = getSwiftTitleUI().E.getLayoutParams();
            layoutParams4.width = (int) com.tencent.av.utils.ba.dp2px(BaseApplicationImpl.getApplication(), 22.0f);
            layoutParams4.height = (int) com.tencent.av.utils.ba.dp2px(BaseApplicationImpl.getApplication(), 15.0f);
            getSwiftTitleUI().E.setLayoutParams(layoutParams4);
            getSwiftTitleUI().E.setImageResource(R.drawable.g9l);
            ViewParent parent2 = getSwiftTitleUI().E.getParent();
            if (parent2 instanceof RelativeLayout) {
                ((RelativeLayout) parent2).setPadding(0, 0, 0, 0);
                parent2.requestLayout();
            }
            View findViewById2 = super.getQBaseActivity().findViewById(R.id.f166811ie3);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(11);
            layoutParams5.setMargins(0, dp2px, dp2px, 0);
            findViewById2.setLayoutParams(layoutParams5);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a(this.webViewSurface);
        }
    }

    public QQH5BrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFragmentClass = QQH5BrowserFragment.class;
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
