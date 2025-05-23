package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes16.dex */
public class QCircleTitleBarView extends SwiftIphoneTitleBarUI {

    /* renamed from: s0, reason: collision with root package name */
    private int f261692s0;

    /* renamed from: t0, reason: collision with root package name */
    private Drawable f261693t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f261694u0;

    public QCircleTitleBarView(v vVar) {
        super(vVar);
    }

    private void g0() {
        int i3;
        int i16;
        int i17;
        WebViewTitleStyle webViewTitleStyle = this.f314047e.T;
        if (!(webViewTitleStyle instanceof QCircleWebViewTitleStyle)) {
            QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "[initColorOrDrawable] is not QCircleWebViewTitleStyle");
            return;
        }
        if (((QCircleWebViewTitleStyle) webViewTitleStyle).f261696m == 1) {
            this.f261692s0 = QFSQUIUtilsKt.d(BaseApplication.getContext(), R.color.qui_common_bg_nav_secondary);
            this.f261694u0 = QFSQUIUtilsKt.d(BaseApplication.getContext(), R.color.qui_common_text_primary);
            this.f261693t0 = BaseApplication.getContext().getDrawable(R.drawable.qui_chevron_left);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
            i3 = R.color.can;
        } else {
            i3 = R.color.cam;
        }
        this.f261692s0 = context.getColor(i3);
        BaseApplication context2 = BaseApplication.getContext();
        if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
            i16 = R.color.f157724cb0;
        } else {
            i16 = R.color.caz;
        }
        this.f261694u0 = context2.getColor(i16);
        BaseApplication context3 = BaseApplication.getContext();
        if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
            i17 = R.drawable.nad;
        } else {
            i17 = R.drawable.nac;
        }
        this.f261693t0 = context3.getDrawable(i17);
    }

    private void i0() {
        v vVar = this.f314045d;
        if (vVar.E != null && vVar.P != null) {
            ((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).setStatusBarColor(this.f314045d.E, this.f261692s0);
            ((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).setNavigationBarColor(this.f314045d.E, this.f261692s0);
            if (this.f314045d.P.getWebTitleBarInterface().a3() != null) {
                this.f314045d.P.getWebTitleBarInterface().a3().setBackgroundColor(this.f261692s0);
            }
            ImmersiveUtils.setStatusTextColor(!((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode(), this.f314045d.E.getWindow());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void b0(boolean z16, int i3, int i16) {
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
        int i3;
        try {
            g0();
            Activity activity = this.f314045d.E;
            if (activity != null) {
                Resources resources = activity.getResources();
                if (!this.f314047e.f314641x) {
                    this.M.setBackgroundColor(this.f261692s0);
                }
                WebViewTitleStyle webViewTitleStyle = this.f314047e.T;
                if (webViewTitleStyle instanceof QCircleWebViewTitleStyle) {
                    this.G.setBackground(null);
                    int i16 = ((QCircleWebViewTitleStyle) webViewTitleStyle).f261695i;
                    if (i16 != 0) {
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    this.G.setImageDrawable(resources.getDrawable(R.drawable.nac));
                                    this.G.setBackgroundResource(R.drawable.nah);
                                    int b16 = UIUtils.b(BaseApplication.getContext(), 14.0f);
                                    this.G.setPadding(b16, b16, b16, b16);
                                } else {
                                    this.G.setImageDrawable(resources.getDrawable(R.drawable.n_6));
                                }
                            } else {
                                this.G.setImageDrawable(resources.getDrawable(R.drawable.n_5));
                            }
                        } else {
                            this.G.setImageDrawable(resources.getDrawable(R.drawable.n_4));
                        }
                    } else {
                        this.G.setImageDrawable(this.f261693t0);
                        int b17 = UIUtils.b(BaseApplication.getContext(), 14.0f);
                        this.G.setPadding(b17, b17, b17, b17);
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                    layoutParams.height = x.c(this.f314045d.E, 52.0f);
                    layoutParams.width = x.c(this.f314045d.E, 52.0f);
                    layoutParams.setMargins(x.c(this.f314045d.E, 2.0f), 0, x.c(this.f314045d.E, 8.0f), 0);
                    layoutParams.addRule(15, -1);
                    this.G.setLayoutParams(layoutParams);
                    this.f314054i.setVisibility(8);
                }
                this.C.setTextColor(this.f261694u0);
                this.C.setBackgroundDrawable(null);
                this.f314059m.setTextColor(this.f261694u0);
                WebViewTitleStyle webViewTitleStyle2 = this.f314047e.T;
                if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                    i3 = R.color.f158017al3;
                } else {
                    i3 = R.color.black;
                }
                webViewTitleStyle2.f313800h = resources.getColor(i3);
                this.f314059m.getPaint().setFakeBoldText(true);
                i0();
            }
        } catch (Exception e16) {
            QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "initDefaultThemeTitleBar error" + e16.getMessage());
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        WebViewProgressBar webViewProgressBar = this.f314045d.T;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void n(Intent intent, String str) {
        ImageView imageView;
        int i3;
        super.n(intent, str);
        if (this.G != null && intent != null) {
            int i16 = 0;
            boolean booleanExtra = intent.getBooleanExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            FadeIconImageView fadeIconImageView = this.G;
            if (booleanExtra) {
                i16 = 8;
            }
            fadeIconImageView.setVisibility(i16);
        }
        if (intent != null && !this.f314047e.f314630m && (imageView = this.E) != null && imageView.getVisibility() == 0) {
            ImageView imageView2 = this.E;
            Resources resources = imageView2.getResources();
            if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                i3 = R.drawable.header_btn_more_nor;
            } else {
                i3 = R.drawable.f160839cp1;
            }
            imageView2.setImageDrawable(resources.getDrawable(i3));
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void o() {
        super.o();
    }
}
