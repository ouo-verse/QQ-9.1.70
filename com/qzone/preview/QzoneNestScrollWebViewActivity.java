package com.qzone.preview;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.misc.web.webview.QzoneWebViewPluginManager;
import com.qzone.preview.view.NestedScrollView;
import com.qzone.preview.view.NestedScrollWebView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.am;
import com.qzone.util.ar;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.g;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.bx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.util.SystemUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
abstract class QzoneNestScrollWebViewActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    protected AuthorizeConfig f49701a0;

    /* renamed from: b0, reason: collision with root package name */
    protected long f49702b0;

    /* renamed from: c0, reason: collision with root package name */
    protected NestedScrollWebView f49703c0;

    /* renamed from: d0, reason: collision with root package name */
    protected BusinessFeedData f49704d0;

    /* renamed from: e0, reason: collision with root package name */
    protected s7.b f49705e0;

    /* renamed from: f0, reason: collision with root package name */
    protected WebViewProgressBar f49706f0;

    /* renamed from: g0, reason: collision with root package name */
    private bx f49707g0;

    /* renamed from: h0, reason: collision with root package name */
    protected long f49708h0;

    /* renamed from: i0, reason: collision with root package name */
    protected long f49709i0;

    /* renamed from: j0, reason: collision with root package name */
    private NestedScrollView f49710j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f49711k0;

    /* renamed from: l0, reason: collision with root package name */
    protected String f49712l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f49713m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f49714n0;

    /* renamed from: o0, reason: collision with root package name */
    private Drawable f49715o0;

    /* renamed from: p0, reason: collision with root package name */
    private Drawable f49716p0;

    /* renamed from: q0, reason: collision with root package name */
    private RelativeLayout f49717q0;

    /* renamed from: r0, reason: collision with root package name */
    private TextView f49718r0;

    /* renamed from: s0, reason: collision with root package name */
    private ImageView f49719s0;

    /* renamed from: t0, reason: collision with root package name */
    private RelativeLayout f49720t0;

    /* renamed from: u0, reason: collision with root package name */
    private Drawable f49721u0;

    /* renamed from: v0, reason: collision with root package name */
    private RelativeLayout f49722v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f49723w0;

    /* renamed from: x0, reason: collision with root package name */
    private View.OnTouchListener f49724x0;

    /* renamed from: y0, reason: collision with root package name */
    protected int f49725y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f49726z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() & 255) == 0) {
                QzoneNestScrollWebViewActivity.this.f49702b0 = System.currentTimeMillis();
            }
            return view.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            QzoneNestScrollWebViewActivity.this.finish();
            QzoneNestScrollWebViewActivity.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            return false;
        }
    }

    private int f3() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (DisplayUtil.isNavigationBarShow(this) && DisplayUtil.getNavigationBarHeight(this) > 0 && SystemUtil.getNotchHeight(this, getOutActivity()) <= 0) {
            return point.y - DisplayUtil.getNavigationBarHeight(this);
        }
        return point.y;
    }

    private void g3() {
        if (this.f49703c0.canGoBack() && g.b(this)) {
            this.f49703c0.goBack();
        } else {
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(Drawable drawable, int i3) {
        drawable.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
    }

    protected abstract void d3(RelativeLayout relativeLayout);

    protected abstract int e3();

    protected abstract void initData();

    protected void initView() {
        this.f49723w0 = f3();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(com.tencent.mobileqq.R.id.a3w);
        this.f49720t0 = relativeLayout;
        GdtUIUtils.setNightThemeByView(relativeLayout.findViewById(com.tencent.mobileqq.R.id.f_1));
        this.f49726z0 = true;
        this.f49725y0 = ar.d(50.0f);
        this.f49703c0 = (NestedScrollWebView) findViewById(com.tencent.mobileqq.R.id.hir);
        this.f49706f0 = (WebViewProgressBar) findViewById(com.tencent.mobileqq.R.id.f166676ha4);
        this.f49710j0 = (NestedScrollView) findViewById(com.tencent.mobileqq.R.id.hee);
        this.f49719s0 = (ImageView) findViewById(com.tencent.mobileqq.R.id.f166998jt1);
        this.f49717q0 = (RelativeLayout) findViewById(com.tencent.mobileqq.R.id.jtv);
        this.f49718r0 = (TextView) findViewById(com.tencent.mobileqq.R.id.f167000jt3);
        Drawable drawable = getResources().getDrawable(com.tencent.mobileqq.R.drawable.bw8);
        this.f49715o0 = drawable;
        drawable.setAlpha(255);
        Drawable drawable2 = getResources().getDrawable(com.tencent.mobileqq.R.drawable.b8c);
        this.f49716p0 = drawable2;
        drawable2.setAlpha(0);
        this.f49721u0 = getResources().getDrawable(com.tencent.mobileqq.R.drawable.bq8);
        this.f49718r0.setBackgroundDrawable(this.f49716p0);
        this.f49717q0.setBackgroundDrawable(this.f49715o0);
        this.f49719s0.setImageDrawable(this.f49721u0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(com.tencent.mobileqq.R.id.d4t);
        this.f49722v0 = relativeLayout2;
        d3(relativeLayout2);
        this.f49710j0.setHeaderHeight(e3() - this.f49725y0);
        this.f49703c0.setHeaderHeight(e3() - this.f49725y0);
        this.f49714n0 = e3() - this.f49725y0;
        bx bxVar = new bx();
        this.f49707g0 = bxVar;
        this.f49706f0.setController(bxVar);
        this.f49707g0.k(this.f49706f0);
        this.f49706f0.setVisibility(8);
        this.f49703c0.setOnTouchListener(new a());
        final TextView textView = (TextView) findViewById(com.tencent.mobileqq.R.id.title);
        this.f49705e0 = new s7.b(this, this, getIntent(), QzoneWebViewPluginManager.getInstance().getRuntime(), true) { // from class: com.qzone.preview.QzoneNestScrollWebViewActivity.2
            @Override // s7.b, com.tencent.mobileqq.webview.AbsWebView
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!QzoneNestScrollWebViewActivity.this.f49711k0) {
                    QzoneNestScrollWebViewActivity.this.h3(2000, System.currentTimeMillis() - QzoneNestScrollWebViewActivity.this.f49708h0);
                    QzoneNestScrollWebViewActivity.this.f49711k0 = true;
                }
                if (QzoneNestScrollWebViewActivity.this.f49707g0 != null && QzoneNestScrollWebViewActivity.this.f49707g0.c() != 2) {
                    QzoneNestScrollWebViewActivity.this.f49707g0.a((byte) 2);
                }
                QzoneNestScrollWebViewActivity.this.f49710j0.setAutoScorll(true);
                if (QzoneNestScrollWebViewActivity.this.f49726z0) {
                    QzoneNestScrollWebViewActivity.this.f49710j0.smoothScrollTo(0, 0);
                    QzoneNestScrollWebViewActivity.this.f49726z0 = false;
                } else {
                    QzoneNestScrollWebViewActivity.this.f49710j0.postDelayed(new Runnable() { // from class: com.qzone.preview.QzoneNestScrollWebViewActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QzoneNestScrollWebViewActivity.this.f49710j0.getScrollY() <= QzoneNestScrollWebViewActivity.this.e3() / 2 || QzoneNestScrollWebViewActivity.this.f49710j0.getScrollY() >= QzoneNestScrollWebViewActivity.this.e3()) {
                                return;
                            }
                            QzoneNestScrollWebViewActivity.this.f49710j0.smoothScrollTo(0, QzoneNestScrollWebViewActivity.this.e3());
                        }
                    }, 200L);
                }
                QzoneNestScrollWebViewActivity.this.f49709i0 = System.currentTimeMillis();
                QzoneNestScrollWebViewActivity.this.f49706f0.setVisibility(8);
            }

            @Override // com.tencent.mobileqq.webview.AbsWebView
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                QzoneNestScrollWebViewActivity.this.f49710j0.setAutoScorll(false);
                QzoneNestScrollWebViewActivity.this.f49708h0 = System.currentTimeMillis();
                if (QzoneNestScrollWebViewActivity.this.f49707g0 != null && QzoneNestScrollWebViewActivity.this.f49707g0.c() != 0) {
                    QzoneNestScrollWebViewActivity.this.f49707g0.a((byte) 0);
                }
                QzoneNestScrollWebViewActivity.this.f49706f0.setVisibility(0);
            }

            @Override // com.tencent.mobileqq.webview.AbsWebView
            public void onProgressChanged(WebView webView, int i3) {
                super.onProgressChanged(webView, i3);
                if (QzoneNestScrollWebViewActivity.this.f49710j0.getScrollY() <= QzoneNestScrollWebViewActivity.this.e3() / 2 || QzoneNestScrollWebViewActivity.this.f49710j0.getScrollY() >= QzoneNestScrollWebViewActivity.this.e3() || QzoneNestScrollWebViewActivity.this.f49726z0) {
                    return;
                }
                QzoneNestScrollWebViewActivity.this.f49710j0.smoothScrollTo(0, QzoneNestScrollWebViewActivity.this.e3());
            }

            @Override // com.tencent.mobileqq.webview.AbsWebView
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (am.h(str)) {
                    return;
                }
                textView.setText(str);
            }

            @Override // s7.b, com.tencent.mobileqq.webview.AbsWebView
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (QLog.isColorLevel()) {
                    QLog.d("QZoneBrowserVideoActivity", 2, "loadUrl in shouldOverrideUrlLoading url=" + str);
                }
                if (!TextUtils.isEmpty(str) && str.startsWith("jsbridge://")) {
                    return true;
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (str.startsWith("file://") || str.startsWith("data:") || URLUtil.isNetworkUrl(str)) {
                    return pluginEngine != null && pluginEngine.s(str, 16L, null);
                }
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                QzoneNestScrollWebViewActivity qzoneNestScrollWebViewActivity = QzoneNestScrollWebViewActivity.this;
                if (qzoneNestScrollWebViewActivity.f49701a0 == null) {
                    qzoneNestScrollWebViewActivity.f49701a0 = AuthorizeConfig.y();
                }
                long currentTimeMillis = System.currentTimeMillis();
                QzoneNestScrollWebViewActivity qzoneNestScrollWebViewActivity2 = QzoneNestScrollWebViewActivity.this;
                if (currentTimeMillis - qzoneNestScrollWebViewActivity2.f49702b0 < 1000 || qzoneNestScrollWebViewActivity2.f49701a0.G(webView.getUrl(), scheme).booleanValue()) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
                    intent.addFlags(268435456);
                    intent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
                    intent.putExtra(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
                    try {
                        this.mContext.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                }
                return true;
            }
        };
        textView.setVisibility(8);
        this.f49705e0.setWebView(this.f49703c0);
        new m(this.f49705e0).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
        this.f49703c0.loadUrl(this.f49712l0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f49703c0.getLayoutParams();
        layoutParams.height = this.f49723w0 - this.f49725y0;
        this.f49703c0.setLayoutParams(layoutParams);
        b bVar = new b();
        this.f49724x0 = bVar;
        this.f49719s0.setOnTouchListener(bVar);
        this.f49710j0.smoothScrollTo(0, 0);
        this.f49710j0.setScrollChangeListener(new c(textView));
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.tencent.mobileqq.R.layout.bj9);
        initData();
        initView();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ViewParent parent;
        s7.b bVar = this.f49705e0;
        if (bVar != null) {
            bVar.onDestroy();
        }
        NestedScrollWebView nestedScrollWebView = this.f49703c0;
        if (nestedScrollWebView != null && (parent = nestedScrollWebView.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeAllViewsInLayout();
        }
        if (!this.f49713m0) {
            h3(2005, this.f49709i0 > 0 ? System.currentTimeMillis() - this.f49709i0 : 0L);
            this.f49713m0 = true;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements NestedScrollView.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f49732a;

        c(TextView textView) {
            this.f49732a = textView;
        }

        @Override // com.qzone.preview.view.NestedScrollView.a
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
            if (i16 != 0) {
                this.f49732a.setVisibility(0);
            } else {
                this.f49732a.setVisibility(8);
            }
            if (i16 > QzoneNestScrollWebViewActivity.this.f49714n0) {
                i16 = QzoneNestScrollWebViewActivity.this.f49714n0;
            }
            if (i16 < 0) {
                i16 = 0;
            }
            if (i16 >= QzoneNestScrollWebViewActivity.this.f49714n0 / 3) {
                QzoneNestScrollWebViewActivity qzoneNestScrollWebViewActivity = QzoneNestScrollWebViewActivity.this;
                qzoneNestScrollWebViewActivity.j3(qzoneNestScrollWebViewActivity.f49721u0, QzoneNestScrollWebViewActivity.this.getResources().getColor(com.tencent.mobileqq.R.color.f157116k8));
                this.f49732a.setTextColor(QzoneNestScrollWebViewActivity.this.getResources().getColor(com.tencent.mobileqq.R.color.f157116k8));
            } else {
                QzoneNestScrollWebViewActivity qzoneNestScrollWebViewActivity2 = QzoneNestScrollWebViewActivity.this;
                qzoneNestScrollWebViewActivity2.j3(qzoneNestScrollWebViewActivity2.f49721u0, QzoneNestScrollWebViewActivity.this.getResources().getColor(com.tencent.mobileqq.R.color.f158017al3));
                this.f49732a.setTextColor(QzoneNestScrollWebViewActivity.this.getResources().getColor(com.tencent.mobileqq.R.color.f158017al3));
            }
            int i19 = i16 * 255;
            QzoneNestScrollWebViewActivity.this.f49716p0.setAlpha((i19 / QzoneNestScrollWebViewActivity.this.f49714n0) + 0);
            QzoneNestScrollWebViewActivity.this.f49715o0.setAlpha(255 - (i19 / QzoneNestScrollWebViewActivity.this.f49714n0));
            QzoneNestScrollWebViewActivity.this.i3(i16, i18 - i16 < 0 ? 1 : 0);
        }
    }

    protected void h3(int i3, long j3) {
        if (this.f49704d0 != null) {
            QZoneWriteOperationService.v0().K(this.f49704d0.getOperationInfo().cookie, i3, 0, 0, 0, 0, false, false, null, null, 0L, false, false, null, true, j3, this.f49704d0, 0L);
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            g3();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    protected void i3(int i3, int i16) {
    }
}
