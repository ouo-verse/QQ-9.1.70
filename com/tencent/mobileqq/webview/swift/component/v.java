package com.tencent.mobileqq.webview.swift.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mobileqq.webview.swift.SwiftFloatViewUI;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.bx;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.smtt.sdk.WebView;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class v extends b.C8976b implements View.OnClickListener, Animation.AnimationListener {
    static IPatchRedirector $redirector_;
    public SwiftIphoneTitleBarUI C;
    public SwiftFloatViewUI D;
    public Activity E;
    public ViewGroup F;
    public ImageView G;
    public ImageView H;
    private boolean I;
    Animation J;
    Animation K;
    public View L;
    public ViewGroup M;
    public TextView N;
    public WebViewProvider P;
    public View Q;
    public boolean R;
    public ViewGroup S;
    public WebViewProgressBar T;
    public bx U;
    public ViewGroup V;
    public FrameLayout W;
    public TextView X;
    public TextView Y;
    public ProgressBar Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f314499a0;

    /* renamed from: b0, reason: collision with root package name */
    public View f314500b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f314501c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f314502d0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f314503e;

    /* renamed from: e0, reason: collision with root package name */
    public String f314504e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f314505f;

    /* renamed from: f0, reason: collision with root package name */
    private SwiftBrowserStatistics f314506f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f314507g0;

    /* renamed from: h, reason: collision with root package name */
    long f314508h;

    /* renamed from: h0, reason: collision with root package name */
    private c f314509h0;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f314510i;

    /* renamed from: i0, reason: collision with root package name */
    private d f314511i0;

    /* renamed from: m, reason: collision with root package name */
    public final com.tencent.mobileqq.webview.swift.r f314512m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements TouchWebView.OnOverScrollHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TouchWebView f314513d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RefreshView f314514e;

        a(TouchWebView touchWebView, RefreshView refreshView) {
            this.f314513d = touchWebView;
            this.f314514e = refreshView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, v.this, touchWebView, refreshView);
            }
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnOverScrollHandler
        public void onBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserUIStyleHandler", 1, "onBack()");
            }
            v vVar = v.this;
            vVar.f314503e = false;
            vVar.f314507g0 = 0;
            this.f314514e.onBack();
            v.this.S(false, 0);
            v.this.R(true);
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnOverScrollHandler
        public void onOverScroll(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            v.this.f314507g0 += i3;
            if (QLog.isDebugVersion()) {
                QLog.d("SwiftBrowserUIStyleHandler", 1, "onOverScroll deltaY: " + i3 + ", curScrollY: " + v.this.f314507g0 + ", isWebViewOverScroll: " + v.this.f314503e);
            }
            v vVar = v.this;
            if (!vVar.f314503e) {
                vVar.f314503e = true;
                String url = this.f314513d.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    try {
                        Uri parse = Uri.parse(url);
                        if (parse != null && parse.isHierarchical()) {
                            v.this.X.setText(String.format(v.this.X.getResources().getString(R.string.f214385sr), parse.getHost()));
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
            this.f314514e.onOverScroll(i3);
            v vVar2 = v.this;
            vVar2.S(true, vVar2.f314507g0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements TouchWebView.OnScrollChangedListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) v.this);
            }
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
                return;
            }
            if (System.currentTimeMillis() - v.this.f314508h > 1000) {
                int i19 = i16 - i18;
                if (i19 > 0) {
                    if (Math.abs(i19) > 50) {
                        v.this.R(false);
                        v.this.f314508h = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                if (Math.abs(i19) > 50) {
                    v.this.R(true);
                    v.this.f314508h = System.currentTimeMillis();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c extends DecelerateInterpolator {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f314517a;

        /* renamed from: b, reason: collision with root package name */
        private int f314518b;

        c(float f16, int i3, int i16) {
            super(f16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, v.this, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f314517a = i3;
                this.f314518b = i16;
            }
        }

        public float a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this, i3)).floatValue();
            }
            int abs = Math.abs(i3);
            int abs2 = Math.abs(this.f314517a);
            int abs3 = Math.abs(this.f314518b);
            if (abs < abs2) {
                return 0.0f;
            }
            if (abs > abs3) {
                return 1.0f;
            }
            return getInterpolation((abs - abs2) / (abs3 - abs2));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void a(int i3, Bundle bundle);
    }

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314503e = false;
        this.f314505f = true;
        this.f314508h = 0L;
        this.f314512m = new com.tencent.mobileqq.webview.swift.r();
        this.F = null;
        this.I = false;
        this.R = false;
        this.f314499a0 = false;
        this.f314501c0 = -1;
        this.f314502d0 = 1;
        this.f314504e0 = "";
        this.f314506f0 = null;
        this.f314507g0 = 0;
    }

    private boolean G() {
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isAllowLandscape(BaseApplication.getContext()) && !this.f314512m.f314633p) {
            return true;
        }
        return false;
    }

    private void J(Bundle bundle) {
        String str;
        QLog.d("SwiftBrowserUIStyleHandler", 1, "processPageCommitVisible");
        try {
            boolean isNightMode = this.f314441d.getWebViewProvider().isNightMode();
            if (bundle != null && bundle.containsKey("url")) {
                str = bundle.getString("url");
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (1 == this.f314502d0) {
                if (com.tencent.mobileqq.webview.swift.utils.f.b() && !com.tencent.mobileqq.webview.swift.utils.f.c(str) && isNightMode) {
                    if (this.f314441d.getWebView() != null) {
                        this.f314441d.getWebView().setBackgroundColor(-1);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("SwiftBrowserUIStyleHandler", 2, "[processPageCommitVisible], webview.setBackgroundColor(WebViewConstant.DEFAULT_WEBVIEW_BGCOLOR_DAY)");
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserUIStyleHandler", 2, "[processPageCommitVisible], do nothing, DEFAULT_INVALID_COLOR != mBrowserWebviewColor");
            }
        } catch (Exception e16) {
            QLog.e("SwiftBrowserUIStyleHandler", 1, "processPageCommitVisible, error", e16);
        }
    }

    private void K() {
        RefreshView refreshView;
        bx bxVar = this.U;
        if (bxVar != null) {
            bxVar.a((byte) 2);
        }
        this.Z.setVisibility(8);
        if (!this.f314512m.Q && this.X != null && this.f314441d.getWebView() != null) {
            TouchWebView touchWebView = (TouchWebView) this.f314441d.getWebView();
            ViewGroup viewGroup = this.S;
            if (viewGroup instanceof RefreshView) {
                refreshView = (RefreshView) viewGroup;
            } else {
                refreshView = null;
            }
            if (refreshView != null && this.f314505f) {
                this.f314509h0 = k();
                touchWebView.setOnOverScrollHandler(new a(touchWebView, refreshView));
                touchWebView.setOnScrollChangedListener(new b());
                e0(this.f314441d.getWebView());
            }
        }
    }

    private void L(Bundle bundle) {
        String str;
        bx bxVar;
        if (!this.f314506f0.f314380x0 && (bxVar = this.U) != null && bxVar.c() != 0) {
            this.U.a((byte) 0);
        }
        this.Z.setVisibility(8);
        Uri uri = null;
        if (bundle != null && bundle.containsKey("url")) {
            str = bundle.getString("url");
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            uri = Uri.parse(str);
        }
        if (uri != null && uri.isHierarchical() && "simple".equals(uri.getQueryParameter("style"))) {
            this.C.E.setVisibility(8);
            this.f314512m.L = true;
        }
        n(this.f314441d.getWebView());
    }

    private void M(Uri uri) {
        String str = "unknown";
        if (uri != null) {
            try {
                str = uri.getHost();
            } catch (Throwable th5) {
                QLog.e("SwiftBrowserUIStyleHandler", 1, th5, new Object[0]);
                return;
            }
        }
        if ((this.f314512m.f314620c & 131072) != 0) {
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).e(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 131072, 0, "", "", str, "");
        }
        if ((this.f314512m.f314620c & 16777216) != 0) {
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).e(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 16777216, 0, "", "", str, "");
        }
        if ((this.f314512m.f314620c & 2) != 0) {
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).e(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 2, 0, "", "", str, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(boolean z16, int i3) {
        float f16;
        boolean z17;
        int i16;
        if (this.f314441d.getWebView() == null) {
            return;
        }
        if (z16) {
            f16 = this.f314509h0.a(i3);
        } else {
            f16 = 1.0f;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("SwiftBrowserUIStyleHandler", 2, "setBrowserTipsShow: " + z16 + ", alpha: " + f16);
        }
        TouchWebView touchWebView = (TouchWebView) this.f314441d.getWebView();
        int i17 = 8;
        if (this.Y != null) {
            if (touchWebView.getX5WebViewExtension() != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            TextView textView = this.Y;
            if (z17 && z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            textView.setVisibility(i16);
            AccessibilityUtil.g(this.Y);
            this.Y.setAlpha(f16);
        }
        TextView textView2 = this.X;
        if (textView2 != null) {
            if (z16) {
                i17 = 0;
            }
            textView2.setVisibility(i17);
            this.X.setAlpha(f16);
        }
    }

    private c k() {
        int[] iArr = new int[2];
        this.S.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int[] iArr2 = new int[2];
        this.X.getLocationOnScreen(iArr2);
        int i16 = iArr2[1];
        this.Y.getLocationOnScreen(iArr2);
        int height = iArr2[1] + this.Y.getHeight();
        int i17 = -(i16 - i3);
        int i18 = -(height - i3);
        if (QLog.isDevelopLevel()) {
            QLog.i("SwiftBrowserUIStyleHandler", 2, "calculateScrollYInterpolator startY: " + i17 + ", endY: " + i18);
        }
        return new c(3.0f, i17, i18);
    }

    private void l(String str, String str2, long j3) {
        long j16;
        if ((this.f314512m.f314620c & j3) == 0) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!"1".equals(AuthorizeConfig.y().x("wv_ctrl_switch", ""))) {
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserUIStyleHandler", 2, "checkWvParamAuthorize disable");
                    return;
                }
                return;
            }
            if (!AuthorizeConfig.y().F(str2, str)) {
                com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
                j16 = currentTimeMillis;
                rVar.f314620c = (~j3) & rVar.f314620c;
                QLog.d("SwiftBrowserUIStyleHandler", 1, "no authorize for wv param domain:", str2, " wv:", j3 + " cmdName:", str);
            } else {
                j16 = currentTimeMillis;
                SwiftBrowserStatistics.P(str, str2);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserUIStyleHandler", 2, "checkWvParamAuthorize cost:", Long.valueOf(currentTimeMillis2 - j16), " domain:", str2, " wv:", Long.valueOf(j3));
            }
        } catch (Throwable th5) {
            QLog.e("SwiftBrowserUIStyleHandler", 1, th5, new Object[0]);
        }
    }

    private int q(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                str = str.substring(2);
            }
            try {
                if (!str.startsWith("#")) {
                    str = "#" + str;
                }
                return Color.parseColor(str);
            } catch (NumberFormatException e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("SwiftBrowserUIStyleHandler", 4, "Illegal getColorIntFromUrlParams: " + e16.getMessage(), e16);
                }
            }
        }
        return -1;
    }

    private void r() {
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if ((rVar.f314621d & 8192) > 0) {
            rVar.A = true;
        }
        long j3 = rVar.f314625h;
        if ((1 & j3) > 0) {
            rVar.f314619b = true;
        }
        if ((j3 & 8) > 0) {
            rVar.f314641x = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private WebViewTitleStyle s(String str) {
        Uri parse;
        boolean z16;
        int i3;
        int i16;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || !parse.isHierarchical()) {
            return null;
        }
        String queryParameter = parse.getQueryParameter("_nav_bgclr");
        String queryParameter2 = parse.getQueryParameter("_nav_statusclr");
        String queryParameter3 = parse.getQueryParameter("_nav_titleclr");
        String queryParameter4 = parse.getQueryParameter("_nav_txtclr");
        int i17 = 0;
        int i18 = -1;
        boolean z17 = true;
        try {
            if (!TextUtils.isEmpty(queryParameter)) {
                i3 = q(queryParameter);
                z16 = true;
            } else {
                z16 = false;
                i3 = -1;
            }
            try {
                if (!TextUtils.isEmpty(queryParameter2)) {
                    i17 = q(queryParameter2);
                    z16 = true;
                }
                try {
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        i16 = q(queryParameter3);
                        z16 = true;
                    } else {
                        i16 = -1;
                    }
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = ", e);
                        z17 = z16;
                        if (z17) {
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    i16 = -1;
                }
            } catch (Exception e18) {
                e = e18;
                i16 = -1;
                i17 = i16;
                QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = ", e);
                z17 = z16;
                if (z17) {
                }
            }
        } catch (Exception e19) {
            e = e19;
            z16 = false;
            i3 = -1;
            i16 = -1;
        }
        if (!TextUtils.isEmpty(queryParameter4)) {
            i18 = q(queryParameter4);
            if (z17) {
                return null;
            }
            WebViewTitleStyle webViewTitleStyle = new WebViewTitleStyle();
            webViewTitleStyle.f313797d = i17;
            webViewTitleStyle.f313798e = i3;
            webViewTitleStyle.f313799f = i16;
            webViewTitleStyle.f313800h = i18;
            return webViewTitleStyle;
        }
        z17 = z16;
        if (z17) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private WebViewTitleStyle t(String str) {
        Uri parse;
        int i3;
        int i16;
        int i17;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || !parse.isHierarchical()) {
            return null;
        }
        String queryParameter = parse.getQueryParameter("_wvNb");
        String queryParameter2 = parse.getQueryParameter("_wvNs");
        String queryParameter3 = parse.getQueryParameter("_wvNt");
        String queryParameter4 = parse.getQueryParameter("_wvNi");
        int i18 = -1;
        boolean z16 = true;
        boolean z17 = false;
        try {
            if (!TextUtils.isEmpty(queryParameter)) {
                i3 = q(queryParameter);
                z17 = true;
            } else {
                i3 = -1;
            }
            try {
                if (!TextUtils.isEmpty(queryParameter2)) {
                    i16 = q(queryParameter2);
                    z17 = true;
                } else {
                    i16 = i3;
                }
                try {
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        i17 = q(queryParameter3);
                        z17 = true;
                    } else {
                        i17 = -1;
                    }
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = " + e.getMessage(), e);
                        z16 = z17;
                        if (z16) {
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    i17 = -1;
                }
            } catch (Exception e18) {
                e = e18;
                i16 = -1;
                i17 = i16;
                QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = " + e.getMessage(), e);
                z16 = z17;
                if (z16) {
                }
            }
        } catch (Exception e19) {
            e = e19;
            i3 = -1;
            i16 = -1;
        }
        if (!TextUtils.isEmpty(queryParameter4)) {
            i18 = q(queryParameter4);
            if (z16) {
                return null;
            }
            WebViewTitleStyle webViewTitleStyle = new WebViewTitleStyle();
            webViewTitleStyle.f313797d = i16;
            webViewTitleStyle.f313798e = i3;
            webViewTitleStyle.f313799f = i17;
            webViewTitleStyle.f313800h = i18;
            return webViewTitleStyle;
        }
        z16 = z17;
        if (z16) {
        }
    }

    public void A(Intent intent, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent, (Object) str);
            return;
        }
        this.C.n(intent, str);
        o(this.f314512m.K, false);
        E();
    }

    public void B(Intent intent) {
        String stringExtra;
        Uri parse;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("url")) && (parse = Uri.parse((stringExtra = intent.getStringExtra("url")))) != null && parse.isHierarchical()) {
            if ("1".equals(parse.getQueryParameter("_qStyle"))) {
                WebViewTitleStyle webViewTitleStyle = new WebViewTitleStyle();
                webViewTitleStyle.f313797d = -16777216;
                webViewTitleStyle.f313798e = -1;
                webViewTitleStyle.f313799f = -16777216;
                webViewTitleStyle.f313800h = -16777216;
                this.f314512m.T = webViewTitleStyle;
                if (QLog.isDevelopLevel()) {
                    QLog.i("SwiftBrowserUIStyleHandler", 2, "parse style from url[_qStyle]: " + webViewTitleStyle);
                    return;
                }
                return;
            }
            WebViewTitleStyle t16 = t(stringExtra);
            if (t16 != null) {
                this.f314512m.T = t16;
                if (QLog.isDevelopLevel()) {
                    QLog.i("SwiftBrowserUIStyleHandler", 2, "parse style from url[_wvXX]: " + t16);
                    return;
                }
                return;
            }
            WebViewTitleStyle s16 = s(stringExtra);
            if (s16 != null) {
                this.f314512m.T = s16;
                if (QLog.isDevelopLevel()) {
                    QLog.i("SwiftBrowserUIStyleHandler", 2, "parse style from url[_nav_]: " + s16);
                    return;
                }
                return;
            }
            WebViewTitleStyle webViewTitleStyle2 = (WebViewTitleStyle) intent.getParcelableExtra(QQBrowserActivityConstants.KEY_TITLE_STYLE);
            if (webViewTitleStyle2 != null) {
                this.f314512m.T = webViewTitleStyle2;
                if (QLog.isDevelopLevel()) {
                    QLog.i("SwiftBrowserUIStyleHandler", 2, "parse style from intent[titleStyle]: " + webViewTitleStyle2);
                    return;
                }
                return;
            }
            String host = parse.getHost();
            WebViewTitleStyle webViewTitleStyle3 = com.tencent.mobileqq.webview.n.a().f314000a.get(host);
            if (webViewTitleStyle3 != null) {
                this.f314512m.T = webViewTitleStyle3;
                if (QLog.isDevelopLevel()) {
                    QLog.i("SwiftBrowserUIStyleHandler", 2, "parse style from styleMap[" + host + "]:" + webViewTitleStyle3);
                }
            }
        }
    }

    public void C(Intent intent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        if ((this.f314512m.f314620c & 131072) == 0 && !intent.getBooleanExtra(OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, false)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.f314512m.f314618a = true;
        }
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if ((rVar.f314620c & 16777216) == 0 && !intent.getBooleanExtra("isTransparentTitle", false)) {
            z17 = false;
        } else {
            z17 = true;
        }
        rVar.f314619b = z17;
        com.tencent.mobileqq.webview.swift.r rVar2 = this.f314512m;
        if ((rVar2.f314621d & 1) == 0 && !intent.getBooleanExtra("isTransparentTitleAndClickable", false)) {
            z18 = false;
        } else {
            z18 = true;
        }
        rVar2.f314641x = z18;
        com.tencent.mobileqq.webview.swift.r rVar3 = this.f314512m;
        if ((rVar3.f314620c & 2) == 0 && !intent.getBooleanExtra("hide_more_button", false)) {
            z19 = false;
        } else {
            z19 = true;
        }
        rVar3.f314630m = z19;
        com.tencent.mobileqq.webview.swift.r rVar4 = this.f314512m;
        if ((rVar4.f314620c & 1) == 0 && !intent.getBooleanExtra("hide_operation_bar", false) && !"noBottomBar".equals(intent.getStringExtra("webStyle"))) {
            z26 = false;
        } else {
            z26 = true;
        }
        rVar4.f314631n = z26;
        com.tencent.mobileqq.webview.swift.r rVar5 = this.f314512m;
        if ((rVar5.f314621d & 256) != 0) {
            z27 = true;
        } else {
            z27 = false;
        }
        rVar5.f314643z = z27;
        if (!TextUtils.isEmpty(intent.getStringExtra("key_params_qq"))) {
            com.tencent.mobileqq.webview.swift.r rVar6 = this.f314512m;
            rVar6.f314630m = true;
            rVar6.f314631n = true;
        }
        int intExtra = intent.getIntExtra("reqType", -1);
        com.tencent.mobileqq.webview.swift.r rVar7 = this.f314512m;
        if (!rVar7.f314631n && intExtra == 6) {
            rVar7.f314631n = true;
        }
        rVar7.f314632o = intent.getBooleanExtra("fromOneCLickCLose", false);
        this.f314512m.B = intent.getBooleanExtra("rightTopCancel", false);
        this.f314512m.C = intent.getBooleanExtra("webViewMoveTop", false);
        if (!this.f314512m.f314630m && (intExtra == 3 || intExtra == 1 || !intent.getBooleanExtra("ba_is_login", true) || intExtra == 7)) {
            this.f314512m.f314630m = true;
        }
        com.tencent.mobileqq.webview.swift.r rVar8 = this.f314512m;
        long j3 = rVar8.f314620c;
        if ((131072 & j3) > 0) {
            rVar8.f314618a = true;
        }
        if ((536870912 & j3) != 0) {
            rVar8.D = true;
        }
        if ((2048 & j3) > 0 && !G()) {
            com.tencent.mobileqq.webview.swift.r rVar9 = this.f314512m;
            rVar9.f314629l = true;
            rVar9.f314634q = Boolean.FALSE;
        }
        if ((this.f314512m.f314621d & 4) > 0 && !G()) {
            com.tencent.mobileqq.webview.swift.r rVar10 = this.f314512m;
            rVar10.f314629l = false;
            rVar10.f314634q = Boolean.TRUE;
        }
        com.tencent.mobileqq.webview.swift.r rVar11 = this.f314512m;
        long j16 = rVar11.f314621d;
        if ((j16 & 2) > 0) {
            rVar11.f314635r = true;
        }
        if ((512 & j16) > 0) {
            rVar11.Q = true;
        }
        if ((j16 & 1024) > 0) {
            rVar11.O = true;
            rVar11.R = true;
        }
        r();
        if (intent.getBooleanExtra("from_single_task", false)) {
            this.f314512m.V = true;
            return;
        }
        com.tencent.mobileqq.webview.swift.r rVar12 = this.f314512m;
        if ((rVar12.f314620c & WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) > 0) {
            rVar12.U = AuthorizeConfig.y().O("aio_authorize_config", intent.getStringExtra("url"));
        }
    }

    public void D() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.E.getWindow().setBackgroundDrawable(null);
        boolean isNightMode = this.f314441d.getWebViewProvider().isNightMode();
        int i16 = this.f314502d0;
        if (1 == i16) {
            if (isNightMode) {
                i16 = -16777216;
            } else {
                i16 = -1;
            }
        }
        if (this.f314512m.Q && Color.alpha(i16) >= 255) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserUIStyleHandler", 2, String.format("initWebViewInContentView needSetContainerBg=%b webViewBgColor=#%x, nightMode=%b", Boolean.valueOf(z16), Integer.valueOf(this.f314502d0), Boolean.valueOf(isNightMode)));
        }
        ViewGroup viewGroup = this.V;
        if (viewGroup != null) {
            if (z16) {
                i3 = com.tencent.mobileqq.webview.swift.utils.n.token_background_content_bg;
            } else {
                i3 = 0;
            }
            viewGroup.setBackgroundResource(i3);
        }
        if (this.f314441d.getWebView() != null) {
            WebView webView = this.f314441d.getWebView();
            webView.setId(R.id.webview);
            webView.setBackgroundColor(i16);
            this.S.addView(webView, 0, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (this.f314441d.getWebView() != null && !this.f314512m.f314618a) {
            p((TouchWebView) this.f314441d.getWebView());
        }
    }

    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        if (!this.f314512m.O) {
            return false;
        }
        return !((com.tencent.mobileqq.webview.swift.injector.r) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.r.class)).isDefaultTheme();
    }

    public boolean H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if (rVar.K == null) {
            rVar.K = this.C.f(str);
        }
        JSONObject jSONObject = this.f314512m.K;
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        if (this.f314512m.K.optInt("trans", -1) == 0) {
            this.f314512m.H = true;
        } else {
            this.f314512m.H = this.C.a();
        }
        return true;
    }

    public void I(String str) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Uri parse = Uri.parse(str);
        if (parse.isHierarchical()) {
            String queryParameter = parse.getQueryParameter("_wv");
            if (queryParameter != null) {
                try {
                    this.f314512m.f314620c = Long.parseLong(queryParameter, 10);
                } catch (NumberFormatException e16) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wv param(" + queryParameter + ") error:" + e16.getMessage());
                }
                l("ui.wvHideActionBtn", str, 2L);
                l("ui.wvFullScreen", str, 131072L);
                l("ui.wvTransparentTitle", str, 16777216L);
            }
            String queryParameter2 = parse.getQueryParameter("_fv");
            if (queryParameter2 != null) {
                try {
                    this.f314512m.f314622e = Long.parseLong(queryParameter2, 10);
                } catch (NumberFormatException e17) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + queryParameter2 + ") error:" + e17.getMessage());
                }
            }
            String queryParameter3 = parse.getQueryParameter("_fu");
            this.f314512m.f314623f = false;
            if (queryParameter3 != null) {
                try {
                    if (Long.parseLong(queryParameter3) == 2019) {
                        this.f314512m.f314623f = true;
                    }
                } catch (NumberFormatException e18) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + queryParameter3 + ") error:" + e18.getMessage());
                }
            }
            String queryParameter4 = parse.getQueryParameter("_wwv");
            if (queryParameter4 != null) {
                try {
                    this.f314512m.f314621d = Long.parseLong(queryParameter4, 10);
                } catch (NumberFormatException e19) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wwv param(" + queryParameter4 + ") error:" + e19.getMessage());
                }
            }
            String queryParameter5 = parse.getQueryParameter("_cwv");
            if (queryParameter5 != null) {
                try {
                    this.f314512m.f314625h = Long.parseLong(queryParameter5, 10);
                } catch (NumberFormatException e26) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _cwv param(" + queryParameter4 + ") error:" + e26.getMessage());
                }
            }
            String queryParameter6 = parse.getQueryParameter(WadlProxyConsts.CHANNEL);
            if (!TextUtils.isEmpty(queryParameter6)) {
                this.f314512m.f314626i = URLDecoder.decode(queryParameter6);
            }
            String queryParameter7 = parse.getQueryParameter("subIndex");
            if (!TextUtils.isEmpty(queryParameter7)) {
                try {
                    this.f314512m.f314627j = Integer.parseInt(queryParameter7.trim());
                } catch (NumberFormatException e27) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser subIndex param(" + queryParameter7 + ") error:" + e27.getMessage());
                }
            }
            String queryParameter8 = parse.getQueryParameter("bgColor");
            if ("00000000".equals(parse.getQueryParameter("_cntclr"))) {
                this.f314502d0 = 0;
            } else if (!TextUtils.isEmpty(queryParameter8)) {
                try {
                    this.f314502d0 = (int) Long.parseLong(queryParameter8, 16);
                } catch (NumberFormatException e28) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser bgColor param(" + queryParameter8 + ") error:" + e28.getMessage());
                }
            }
            String queryParameter9 = parse.getQueryParameter("titleAlpha");
            if (!TextUtils.isEmpty(queryParameter9)) {
                try {
                    this.f314512m.f314628k = Integer.parseInt(queryParameter9.trim());
                } catch (NumberFormatException e29) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser titleAlpha param(" + queryParameter9 + ") error:" + e29.getMessage());
                }
            }
            String queryParameter10 = parse.getQueryParameter("_disableWVQuit");
            if (queryParameter10 != null) {
                try {
                    com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
                    if (1 == Integer.parseInt(queryParameter10, 10)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    rVar.f314624g = z16;
                } catch (NumberFormatException e36) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _disableWVQuit param(" + queryParameter10 + ") error:" + e36.getMessage());
                }
            }
            String queryParameter11 = parse.getQueryParameter("_disablePadCompact");
            if (queryParameter11 != null) {
                try {
                    com.tencent.mobileqq.webview.swift.r rVar2 = this.f314512m;
                    if (1 == Integer.parseInt(queryParameter11, 10)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    rVar2.f314633p = z17;
                } catch (NumberFormatException e37) {
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _disablePadCompact param(" + queryParameter11 + ") error:" + e37.getMessage());
                }
            }
            String authority = parse.getAuthority();
            if (!TextUtils.isEmpty(authority) && authority.endsWith("urlshare.cn")) {
                this.f314512m.W = true;
            } else {
                this.f314512m.W = false;
            }
        }
        M(parse);
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        this.f314512m.f314635r = true;
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserUIStyleHandler", 2, "--> restoreOrientationFollowSenSor");
        }
        this.E.setRequestedOrientation(2);
    }

    public void O(View view, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.C.x(view, i3, i16, i17);
        }
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        View view = this.D.f314018i;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.D.f314012c;
        if (view2 != null) {
            if (view2.getVisibility() == 8 || this.D.f314012c.getVisibility() == 4) {
                this.D.f314012c.setVisibility(0);
            }
        }
    }

    public void R(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if (rVar.f314632o && !rVar.f314618a) {
            if (QLog.isDebugVersion()) {
                QLog.i("SwiftBrowserUIStyleHandler", 4, "setBottomBarVisible: " + z16 + ", needHideBottomBar: " + this.f314512m.f314631n);
            }
            if (this.F == null || this.I == z16) {
                return;
            }
            if (z16) {
                TouchWebView touchWebView = (TouchWebView) this.f314441d.getWebView();
                if (touchWebView != null && !touchWebView.canGoBack() && !touchWebView.canGoForward()) {
                    return;
                }
                this.I = true;
                this.F.setVisibility(0);
                this.F.clearAnimation();
                this.F.setAnimation(this.J);
                this.J.start();
                ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).e(null, "dc00898", "", "", "0X8009B1E", "0X8009B1E", 0, 0, "", "", "", "");
                return;
            }
            this.I = false;
            j();
            this.F.clearAnimation();
            this.F.setAnimation(this.K);
            this.K.start();
        }
    }

    @Deprecated
    public void T(View view, boolean z16, int i3, int i16) {
        Drawable a16;
        Drawable a17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, view, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (view == null) {
            return;
        }
        if (z16) {
            if (F() && (a17 = ((com.tencent.mobileqq.webview.swift.injector.r) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.r.class)).a(i3)) != null) {
                view.setBackgroundDrawable(a17);
                view.setTag(R.id.f9219578, Integer.valueOf(i3));
                return;
            } else {
                view.setBackgroundResource(i16);
                view.setTag(R.id.f9219578, Integer.valueOf(i16));
                return;
            }
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (F() && (a16 = ((com.tencent.mobileqq.webview.swift.injector.r) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.r.class)).a(i3)) != null) {
                imageView.setImageDrawable(a16);
                view.setTag(R.id.f9219578, Integer.valueOf(i3));
                return;
            } else {
                imageView.setImageResource(i16);
                view.setTag(R.id.f9219578, Integer.valueOf(i16));
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AbsBaseWebViewActivity", 2, "-->setShowDefaultThemeIcon err! resId=" + i3);
        }
    }

    public void U(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        } else {
            this.D.h(z16);
        }
    }

    public void V(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
        } else {
            this.D.i(z16);
        }
    }

    public void W(boolean z16) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if (rVar.f314642y == z16) {
            return;
        }
        rVar.f314642y = z16;
        Activity activity = this.E;
        if (activity instanceof QIphoneTitleBarActivity) {
            view = ((QIphoneTitleBarActivity) activity).getTitleBarView();
        } else if (this.P != null) {
            view = this.C.M;
        } else {
            view = null;
        }
        if (view != null) {
            com.tencent.mobileqq.webview.swift.utils.o.e(view, R.drawable.qui_bg_nav_secondary);
            if (z16) {
                O(view, 255, 0, 200);
            } else {
                O(view, 0, 255, 200);
            }
        }
    }

    public void X(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onClickListener);
        } else {
            this.f314510i = onClickListener;
        }
    }

    public void Y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
            return;
        }
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI = this.C;
        swiftIphoneTitleBarUI.f314047e.f314640w = z16;
        if (z16) {
            swiftIphoneTitleBarUI.c0("");
        } else {
            swiftIphoneTitleBarUI.h();
        }
    }

    public void Z(boolean z16, int i3) {
        int i16;
        int i17;
        FrameLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        ViewGroup viewGroup = this.M;
        if (viewGroup == null) {
            return;
        }
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        viewGroup.setVisibility(i16);
        TextView textView = this.N;
        if (i3 == 0) {
            i17 = R.string.ftc;
        } else {
            i17 = R.string.gfy;
        }
        textView.setText(i17);
        if (this.f314441d.getWebView() == null || (layoutParams = (FrameLayout.LayoutParams) this.S.getLayoutParams()) == null) {
            return;
        }
        if (z16) {
            layoutParams.bottomMargin = (int) (this.E.getResources().getDisplayMetrics().density * 75.0f);
        } else {
            layoutParams.bottomMargin = 0;
        }
        this.S.setLayoutParams(layoutParams);
    }

    public void a0(boolean z16, int i3, int i16, int i17, boolean z17, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z17), str, str2, str3);
        } else {
            if (this.f314441d.getWebView() == null) {
                return;
            }
            this.C.T((TouchWebView) this.f314441d.getWebView(), z16, i3, i16, i17, z17, str, str2, str3);
        }
    }

    public void b0(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) dVar);
        } else {
            this.f314511i0 = dVar;
        }
    }

    public void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        this.f314512m.f314635r = true;
        int i3 = this.E.getResources().getConfiguration().orientation;
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserUIStyleHandler", 2, "--> supportOrientationFollowSenSor curOrientation = " + i3);
        }
        if (i3 == 1) {
            f0();
        } else {
            this.E.setRequestedOrientation(2);
        }
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if (rVar.C) {
            rVar.H = this.C.a();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.e();
        this.E = this.f314441d.getActivity();
        this.P = this.f314441d.getWebViewProvider();
        this.f314506f0 = (SwiftBrowserStatistics) this.f314441d.getProvider().a(-2);
    }

    public void e0(WebView webView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) webView);
            return;
        }
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if (rVar.f314632o) {
            if (rVar.f314639v) {
                n(webView);
                return;
            }
            boolean canGoBack = webView.canGoBack();
            ImageView imageView = this.G;
            if (imageView != null) {
                imageView.setEnabled(canGoBack);
            }
            ImageView imageView2 = this.H;
            if (imageView2 != null) {
                imageView2.setEnabled(webView.canGoForward());
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        ViewParent parent;
        Configuration configuration;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3, (Object) bundle);
            return;
        }
        super.f(i3, bundle);
        if (QLog.isDevelopLevel()) {
            QLog.i("SwiftBrowserUIStyleHandler", 2, "onLifeCycleStateChanged state=" + i3);
        }
        d dVar = this.f314511i0;
        if (dVar != null) {
            dVar.a(i3, bundle);
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 7) {
                        if (i3 != 8) {
                            if (i3 == 11) {
                                J(bundle);
                                return;
                            }
                            return;
                        }
                        K();
                        return;
                    }
                    L(bundle);
                    return;
                }
                SwiftFloatViewUI swiftFloatViewUI = this.D;
                if (swiftFloatViewUI.f314012c != null && 8 == swiftFloatViewUI.f314014e.getVisibility()) {
                    this.D.d();
                }
                if (bundle.containsKey("Configuration")) {
                    configuration = (Configuration) bundle.getParcelable("Configuration");
                } else {
                    configuration = null;
                }
                if (configuration != null && (view = this.D.f314014e) != null && configuration.orientation == 2 && view.getVisibility() == 0) {
                    this.D.f314014e.setVisibility(8);
                    return;
                }
                return;
            }
            View view2 = this.Q;
            if (view2 != null && (parent = view2.getParent()) != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.Q);
            }
            this.C.v();
            this.C.onDestroy();
            return;
        }
        com.tencent.mobileqq.webview.util.s.a("Web_updateTitleBarUI");
        if (this.f314512m.D) {
            this.C.f0();
        }
        com.tencent.mobileqq.webview.util.s.b("Web_updateTitleBarUI");
    }

    public void f0() {
        boolean z16;
        boolean booleanValue;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        int i16 = 0;
        int i17 = 1;
        if (!rVar.f314629l && !rVar.f314634q.booleanValue()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !G()) {
            com.tencent.mobileqq.webview.swift.r rVar2 = this.f314512m;
            if (rVar2.f314630m && !rVar2.f314635r) {
                booleanValue = true;
            } else {
                booleanValue = false;
            }
        } else {
            booleanValue = this.f314512m.f314634q.booleanValue();
        }
        boolean isAllowLandscape = ((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isAllowLandscape(BaseApplication.getContext());
        if (isAllowLandscape) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        if (booleanValue) {
            if (isAllowLandscape) {
                i17 = 12;
            }
            i3 = i17;
        } else {
            com.tencent.mobileqq.webview.swift.r rVar3 = this.f314512m;
            if (rVar3.f314629l) {
                if (isAllowLandscape) {
                    i16 = 11;
                }
                i3 = i16;
            } else if (rVar3.f314635r) {
                i3 = 2;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserUIStyleHandler", 2, " --> updateScreenOrientation " + i3 + ", isAllowLandscape " + isAllowLandscape);
        }
        this.E.setRequestedOrientation(i3);
    }

    public void j() {
        FrameLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.f314441d.getWebView() == null || this.F == null || (layoutParams = (FrameLayout.LayoutParams) this.S.getLayoutParams()) == null) {
            return;
        }
        if (this.I) {
            layoutParams.bottomMargin = (int) (this.f314512m.f314636s * this.E.getResources().getDisplayMetrics().density);
        } else {
            layoutParams.bottomMargin = 0;
        }
        this.S.setLayoutParams(layoutParams);
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.C = com.tencent.mobileqq.webview.d.a(this);
            this.D = com.tencent.mobileqq.webview.swift.s.a(this);
        }
    }

    public void n(WebView webView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) webView);
            return;
        }
        if (this.f314512m.f314632o) {
            ImageView imageView = this.G;
            if (imageView != null) {
                imageView.setEnabled(false);
            }
            ImageView imageView2 = this.H;
            if (imageView2 != null) {
                imageView2.setEnabled(false);
            }
        }
    }

    public void o(JSONObject jSONObject, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, jSONObject, Boolean.valueOf(z16));
        } else {
            this.C.b(jSONObject, z16);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) animation);
            return;
        }
        if (animation == this.J) {
            ViewGroup viewGroup2 = this.F;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            j();
            return;
        }
        if (animation == this.K && (viewGroup = this.F) != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            ComponentCallbacks2 componentCallbacks2 = this.E;
            if (componentCallbacks2 instanceof View.OnClickListener) {
                ((View.OnClickListener) componentCallbacks2).onClick(view);
            }
            TouchWebView touchWebView = (TouchWebView) this.f314441d.getWebView();
            int id5 = view.getId();
            if (id5 == R.id.f164559a43) {
                if (touchWebView != null && touchWebView.canGoBack()) {
                    touchWebView.stopLoading();
                    touchWebView.goBack();
                    WebViewPluginEngine pluginEngine = touchWebView.getPluginEngine();
                    if (pluginEngine != null) {
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("target", 3);
                        pluginEngine.s(touchWebView.getUrl(), 8589934610L, hashMap);
                    }
                    e0(touchWebView);
                    ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).e(null, "dc00898", "", "", "0X8009B21", "0X8009B21", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.cjs && touchWebView != null && touchWebView.canGoForward()) {
                touchWebView.stopLoading();
                touchWebView.goForward();
                WebViewPluginEngine pluginEngine2 = touchWebView.getPluginEngine();
                if (pluginEngine2 != null) {
                    HashMap hashMap2 = new HashMap(1);
                    hashMap2.put("target", 3);
                    pluginEngine2.s(touchWebView.getUrl(), 8589934602L, hashMap2);
                }
                e0(touchWebView);
                ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).e(null, "dc00898", "", "", "0X8009B20", "0X8009B20", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) touchWebView);
        } else {
            this.C.c(touchWebView);
        }
    }

    public TouchWebView u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (TouchWebView) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return (TouchWebView) this.f314441d.getWebView();
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        ViewStub viewStub = (ViewStub) this.W.findViewById(R.id.f164623vx);
        if (viewStub == null) {
            return;
        }
        this.M = (ViewGroup) viewStub.inflate();
        TextView textView = (TextView) this.W.findViewById(R.id.e68);
        this.N = textView;
        textView.setOnClickListener(this.f314510i);
        this.M.setVisibility(8);
    }

    public void x(Intent intent, String str) {
        ViewStub viewStub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) intent, (Object) str);
            return;
        }
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if (rVar.f314618a || this.F != null || !rVar.f314632o || (viewStub = (ViewStub) this.W.findViewById(R.id.ad6)) == null) {
            return;
        }
        this.F = (ViewGroup) viewStub.inflate();
        ImageView imageView = (ImageView) this.W.findViewById(R.id.f164559a43);
        this.G = imageView;
        imageView.setOnClickListener(this);
        this.G.setEnabled(false);
        ImageView imageView2 = (ImageView) this.W.findViewById(R.id.cjs);
        this.H = imageView2;
        imageView2.setOnClickListener(this);
        this.H.setEnabled(false);
        this.F.setVisibility(8);
        float f16 = (int) (this.E.getResources().getDisplayMetrics().density * 50.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f16, 0.0f);
        this.J = translateAnimation;
        translateAnimation.setDuration(300L);
        this.J.setAnimationListener(this);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, f16);
        this.K = translateAnimation2;
        translateAnimation2.setDuration(300L);
        this.K.setAnimationListener(this);
    }

    @TargetApi(14)
    public void y(WebBrowserViewContainerKt webBrowserViewContainerKt, Intent intent, TouchWebView touchWebView) {
        View view;
        bx bxVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, webBrowserViewContainerKt, intent, touchWebView);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FrameLayout c16 = webBrowserViewContainerKt.c();
        this.W = c16;
        c16.setVisibility(0);
        com.tencent.mobileqq.webview.swift.r rVar = this.f314512m;
        if (rVar.f314618a && rVar.f314622e != 0) {
            webBrowserViewContainerKt.a(rVar.W);
            this.D.c(webBrowserViewContainerKt, this.f314510i);
            this.D.f(this.E);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        this.f314506f0.T = currentTimeMillis2 - currentTimeMillis;
        this.T = (WebViewProgressBar) this.W.findViewById(R.id.g1p);
        bx bxVar2 = new bx();
        this.U = bxVar2;
        this.T.setController(bxVar2);
        this.U.l(!this.f314499a0);
        if (this.f314506f0.f314380x0 && (bxVar = this.U) != null && bxVar.c() != 0) {
            this.U.a((byte) 0);
        }
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_initView_WebViewWrapper");
        this.S = (ViewGroup) this.W.findViewById(R.id.l2a);
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_initView_WebViewWrapper");
        this.f314506f0.L = System.currentTimeMillis() - currentTimeMillis2;
        if (!this.f314512m.Q) {
            this.f314500b0 = this.W.findViewById(R.id.aea);
            this.X = (TextView) this.W.findViewById(R.id.aeb);
            this.Y = (TextView) this.W.findViewById(R.id.jbx);
            this.X.setVisibility(4);
            this.Y.setVisibility(4);
            if (this.f314512m.f314619b && (this.E instanceof QBaseActivity)) {
                ((ViewGroup.MarginLayoutParams) this.X.getLayoutParams()).topMargin = ((QBaseActivity) this.E).getTitleBarHeight();
            }
        }
        if (!this.R) {
            this.Z = (ProgressBar) this.W.findViewById(R.id.i5n);
        }
        if (this.f314512m.P && (view = this.f314500b0) != null) {
            view.setPadding(0, (int) al.a(BaseApplication.getContext(), 30.0f), 0, 0);
        }
        f0();
        D();
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI = this.C;
        if (swiftIphoneTitleBarUI != null) {
            swiftIphoneTitleBarUI.l();
        }
    }

    public void z() {
        ViewStub viewStub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (!this.f314512m.B || (viewStub = (ViewStub) this.W.findViewById(R.id.vax)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.L = inflate;
        inflate.getLayoutParams();
        this.L.setOnClickListener(this.f314510i);
    }
}
