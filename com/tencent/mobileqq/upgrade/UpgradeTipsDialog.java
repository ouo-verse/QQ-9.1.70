package com.tencent.mobileqq.upgrade;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsbridge.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.upgrade.activity.q;
import com.tencent.mobileqq.util.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UpgradeTipsDialog extends ReportDialog implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    WebView C;
    private CheckBox D;
    private final QQAppInterface E;
    private final Activity F;
    private final UpgradeDetailWrapper G;
    private b H;
    private boolean I;
    private boolean J;
    private com.tencent.mobileqq.jsbridge.a K;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class JsCover extends a.b {
        static IPatchRedirector $redirector_;

        protected JsCover() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpgradeTipsDialog.this);
            }
        }

        public int tipsLoadComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController", 2, "loadTipsComplete");
            }
            UpgradeTipsDialog.this.I = true;
            q.b("0X8004DA0", 1, "");
            if (UpgradeTipsDialog.this.H != null) {
                UpgradeTipsDialog.this.H.E7(UpgradeTipsDialog.this);
                return 0;
            }
            try {
                UpgradeTipsDialog.this.show();
                return 0;
            } catch (Exception e16) {
                QLog.e("UpgradeController", 1, "tipsLoadComplete fail", e16);
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends WebViewClient {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpgradeTipsDialog.this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) webView, (Object) str);
            } else if (QLog.isColorLevel()) {
                QLog.d("UpgradeController", 2, "onPageFinished: " + str);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, webView, str, bitmap);
            } else if (QLog.isColorLevel()) {
                QLog.d("UpgradeController", 2, "onPageStarted: " + str);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, webView, Integer.valueOf(i3), str, str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController", 2, "onReceivedError: " + i3 + ", " + str);
            }
            q.d("Update_tips", "Upd_fail", i3);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) str)).booleanValue();
            }
            if (str == null || str.isEmpty() || "about:blank;".equals(str) || "about:blank".equals(str) || UpgradeTipsDialog.this.K.a(webView, str)) {
                return true;
            }
            UpgradeTipsDialog.this.C.loadUrl(str);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void E7(UpgradeTipsDialog upgradeTipsDialog);
    }

    public UpgradeTipsDialog(Activity activity, QQAppInterface qQAppInterface, UpgradeDetailWrapper upgradeDetailWrapper, b bVar) {
        super(activity, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, qQAppInterface, upgradeDetailWrapper, bVar);
            return;
        }
        this.J = false;
        this.G = upgradeDetailWrapper;
        this.F = activity;
        this.E = qQAppInterface;
        Q(bVar);
    }

    private void Q(b bVar) {
        requestWindowFeature(1);
        this.H = bVar;
        View inflate = getLayoutInflater().inflate(R.layout.b4i, (ViewGroup) null);
        R(inflate);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        super.setContentView(inflate);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        int i3 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i16 = getContext().getResources().getDisplayMetrics().heightPixels;
        attributes.width = BaseAIOUtils.f(260.0f, getContext().getResources());
        if (i3 <= i16) {
            attributes.height = BaseAIOUtils.f(368.0f, getContext().getResources());
        } else {
            attributes.height = BaseAIOUtils.f(300.0f, getContext().getResources());
        }
        window.setAttributes(attributes);
        setCancelable(false);
        this.C.loadUrl(k.e(this.G.f306170d.strNewTipsDescURL));
    }

    private void R(View view) {
        WebView webView = (WebView) view.findViewById(R.id.kj_);
        this.C = webView;
        webView.setVerticalFadingEdgeEnabled(false);
        this.C.setFadingEdgeLength(0);
        this.C.setHorizontalFadingEdgeEnabled(false);
        this.C.setHorizontalScrollBarEnabled(false);
        this.C.removeJavascriptInterface("searchBoxJavaBridge_");
        this.C.removeJavascriptInterface("accessibility");
        this.C.removeJavascriptInterface("accessibilityTraversal");
        this.C.setWebViewClient(new a());
        WebSettings settings = this.C.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " " + QZoneHelper.getQUA());
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        com.tencent.mobileqq.jsbridge.a aVar = new com.tencent.mobileqq.jsbridge.a();
        this.K = aVar;
        aVar.c(new JsCover(), "qqupgrade");
        this.D = (CheckBox) view.findViewById(R.id.kj6);
        this.D.setChecked(ConfigHandler.g3(this.E, true));
        this.D.setOnCheckedChangeListener(this);
        ((Button) view.findViewById(R.id.kj7)).setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.kj8);
        button.setOnClickListener(this);
        if (k.i().k() == 4) {
            button.setText(R.string.f171039by0);
        }
    }

    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.I;
    }

    public void U(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            this.H = bVar;
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            bb.b(this.F);
            super.dismiss();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, compoundButton, Boolean.valueOf(z16));
        } else {
            this.J = !this.J;
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"NonConstantResourceId"})
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.kj7) {
                try {
                    dismiss();
                } catch (Exception e16) {
                    QLog.e("UpgradeController", 1, "upgrade_tips_later dismiss fail", e16);
                }
                boolean isChecked = this.D.isChecked();
                ConfigHandler.w3(this.E, isChecked);
                if (isChecked) {
                    ConfigHandler.j3(this.E, this.G.f306170d.strNewTipsDescURL, -1);
                }
                if (this.J) {
                    ((ConfigHandler) this.E.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).v3(isChecked);
                }
                if (isChecked) {
                    str = "1";
                } else {
                    str = "0";
                }
                q.b("0X8004DA2", 1, str);
                if (!com.tencent.mobileqq.upgrade.banner.b.j(true)) {
                    q.d("Update_tips", "Clk_upd_hold", 0);
                    if (isChecked) {
                        k.i().y();
                    } else {
                        k.i().z();
                    }
                }
            } else if (id5 == R.id.kj8) {
                try {
                    dismiss();
                } catch (Exception e17) {
                    QLog.e("UpgradeController", 1, "upgrade_tips_right_now dismiss fail", e17);
                }
                q.b("0X8004DA1", 1, "");
                ConfigHandler.w3(this.E, this.D.isChecked());
                if (k.i().k() == 4) {
                    k.m().h();
                } else {
                    q.d("Update_tips", "Clk_upd_now", 0);
                    ConfigHandler.j3(this.E, this.G.f306170d.strNewTipsDescURL, -1);
                    UpgradeDetailActivity.Y2(this.F, this.G, true, true, true);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.K.d("qqupgrade");
        this.C.destroy();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.show();
            bb.a(this.F);
        }
    }
}
