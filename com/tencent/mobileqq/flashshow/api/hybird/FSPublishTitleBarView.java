package com.tencent.mobileqq.flashshow.api.hybird;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

@KeepClassConstructor
/* loaded from: classes12.dex */
public class FSPublishTitleBarView extends SwiftIphoneTitleBarUI {
    static IPatchRedirector $redirector_;

    public FSPublishTitleBarView(v vVar) {
        super(vVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar);
        }
    }

    public static void g0(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
        window.setNavigationBarColor(i3);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void b0(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            View view = this.H;
            if (view != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.H.getContext()) + x.c(this.H.getContext(), 52.0f), 0, 0);
                this.H.setLayoutParams(layoutParams);
            }
        } catch (Exception e16) {
            QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setWarnToastVisible error");
            e16.printStackTrace();
        }
        super.b0(z16, i3, i16);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            Activity activity = this.f314045d.E;
            if (activity != null) {
                Resources resources = activity.getResources();
                if (!this.f314047e.f314641x) {
                    this.M.setBackgroundColor(resources.getColor(R.color.qvideo_skin_color_bg_default));
                    WebViewProvider webViewProvider = this.f314045d.P;
                    if (webViewProvider != null && webViewProvider.getWebTitleBarInterface().a3() != null) {
                        g0(this.f314045d.E, resources.getColor(R.color.qvideo_skin_color_bg_default));
                        this.f314045d.P.getWebTitleBarInterface().a3().setBackgroundColor(resources.getColor(R.color.qvideo_skin_color_bg_default));
                    }
                }
                WebViewTitleStyle webViewTitleStyle = this.f314047e.T;
                if (webViewTitleStyle instanceof FSWebViewTitleStyle) {
                    if (((FSWebViewTitleStyle) webViewTitleStyle).f209847i == 0) {
                        this.G.setImageDrawable(resources.getDrawable(R.drawable.f161679om3));
                        int b16 = UIUtils.b(BaseApplication.getContext(), 14.0f);
                        this.G.setPadding(b16, b16, b16, b16);
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                    layoutParams.height = x.c(this.f314045d.E, 52.0f);
                    layoutParams.width = x.c(this.f314045d.E, 52.0f);
                    layoutParams.setMargins(x.c(this.f314045d.E, 2.0f), 0, x.c(this.f314045d.E, 8.0f), 0);
                    layoutParams.addRule(15, -1);
                    this.G.setLayoutParams(layoutParams);
                    this.f314054i.setVisibility(8);
                }
                ImmersiveUtils.setStatusTextColor(true, this.f314045d.E.getWindow());
                this.f314059m.setTextColor(resources.getColor(R.color.qvideo_skin_color_text_primary));
                H(true);
                this.f314059m.getPaint().setFakeBoldText(true);
            }
        } catch (Exception e16) {
            QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "initDefaultThemeTitleBar error" + e16.getMessage());
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        WebViewProgressBar webViewProgressBar = this.f314045d.T;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
    }
}
