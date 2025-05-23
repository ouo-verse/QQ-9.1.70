package com.tencent.mobileqq.qqwink.api.impl.hybrid;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

@KeepClassConstructor
/* loaded from: classes17.dex */
public class WinkPublishTitleBarView extends SwiftIphoneTitleBarUI {
    static IPatchRedirector $redirector_;

    public WinkPublishTitleBarView(v vVar) {
        super(vVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void b0(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = this.H;
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.H.getContext()) + x.c(this.H.getContext(), 28.0f), 0, 0);
            this.H.setLayoutParams(layoutParams);
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
                        ImmersiveUtils.setStatusTextColor(true, this.f314045d.E.getWindow());
                        ImmersiveUtils.setStatusBarDarkMode(this.f314045d.E.getWindow(), false);
                        this.f314045d.P.getWebTitleBarInterface().a3().setBackgroundColor(resources.getColor(R.color.qvideo_skin_color_bg_default));
                    }
                }
                this.G.setImageDrawable(resources.getDrawable(R.drawable.f161679om3));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                layoutParams.height = x.c(this.f314045d.E, 28.0f);
                layoutParams.width = x.c(this.f314045d.E, 28.0f);
                layoutParams.setMargins(x.c(this.f314045d.E, 16.0f), 0, x.c(this.f314045d.E, 8.0f), 0);
                layoutParams.addRule(15, -1);
                this.G.setLayoutParams(layoutParams);
                this.G.setVisibility(0);
                this.f314054i.setVisibility(8);
                ImmersiveUtils.setStatusTextColor(true, this.f314045d.E.getWindow());
                this.f314059m.setTextColor(resources.getColor(R.color.caz));
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
