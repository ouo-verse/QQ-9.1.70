package com.sina.weibo.sdk.web;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.web.b.b;
import com.sina.weibo.sdk.web.b.c;
import com.sina.weibo.sdk.web.b.d;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WebActivity extends Activity implements a {

    /* renamed from: as, reason: collision with root package name */
    private LinearLayout f61283as;

    /* renamed from: at, reason: collision with root package name */
    private TextView f61284at;

    /* renamed from: au, reason: collision with root package name */
    private TextView f61285au;

    /* renamed from: av, reason: collision with root package name */
    private WebView f61286av;

    /* renamed from: aw, reason: collision with root package name */
    private ProgressBar f61287aw;

    /* renamed from: ax, reason: collision with root package name */
    private b f61288ax;

    /* renamed from: ay, reason: collision with root package name */
    private com.sina.weibo.sdk.web.a.b f61289ay;

    /* renamed from: az, reason: collision with root package name */
    private String f61290az;

    static /* synthetic */ void d(WebActivity webActivity) {
        webActivity.f61283as.setVisibility(8);
        webActivity.f61286av.setVisibility(0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(8192);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        TextView textView = new TextView(this);
        this.f61284at = textView;
        textView.setText("\u5173\u95ed");
        this.f61284at.setTextSize(17.0f);
        this.f61284at.setTextColor(-32256);
        this.f61284at.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.web.WebActivity.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                WebActivity.this.f61289ay.t();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        TextView textView2 = new TextView(this);
        this.f61285au = textView2;
        textView2.setTextSize(18.0f);
        this.f61285au.setTextColor(-11382190);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.f61284at.setPadding(e.a(10, this), 0, e.a(10, this), 0);
        layoutParams2.addRule(13);
        relativeLayout2.addView(this.f61284at, layoutParams);
        relativeLayout2.addView(this.f61285au, layoutParams2);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, e.a(55, this)));
        this.f61286av = new QmWebview(getApplicationContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = e.a(55, this);
        relativeLayout.addView(this.f61286av, layoutParams3);
        this.f61287aw = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, e.a(3, this));
        layoutParams4.topMargin = e.a(55, this);
        relativeLayout.addView(this.f61287aw, layoutParams4);
        View view = new View(this);
        view.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", "drawable", getPackageName()));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, e.a(3, this));
        layoutParams5.topMargin = e.a(55, this);
        relativeLayout.addView(view, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f61283as = linearLayout;
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", "drawable", getPackageName()));
        this.f61283as.addView(imageView);
        TextView textView3 = new TextView(this);
        textView3.setTextSize(14.0f);
        textView3.setTextColor(-4342339);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = e.a(18, this);
        layoutParams6.bottomMargin = e.a(20, this);
        this.f61283as.addView(textView3, layoutParams6);
        textView3.setText("\u7f51\u7edc\u51fa\u9519\u5566\uff0c\u8bf7\u70b9\u51fb\u6309\u94ae\u91cd\u65b0\u52a0\u8f7d");
        Button button = new Button(this);
        button.setTextSize(16.0f);
        button.setTextColor(-8882056);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(e.a(142, this), e.a(46, this));
        layoutParams7.gravity = 17;
        this.f61283as.addView(button, layoutParams7);
        button.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", "drawable", getPackageName()));
        button.setText("\u91cd\u65b0\u52a0\u8f7d");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.web.WebActivity.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                WebActivity.d(WebActivity.this);
                WebActivity.this.f61286av.reload();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        relativeLayout.addView(this.f61283as, layoutParams8);
        this.f61283as.setVisibility(8);
        this.f61286av.setWebChromeClient(new WebChromeClient() { // from class: com.sina.weibo.sdk.web.WebActivity.4
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView, int i3) {
                JsInjector.getInstance().onProgressChanged(webView, i3);
                super.onProgressChanged(webView, i3);
                WebActivity.this.f61287aw.setProgress(i3);
                if (i3 == 100) {
                    WebActivity.this.f61287aw.setVisibility(4);
                } else {
                    WebActivity.this.f61287aw.setVisibility(0);
                }
            }

            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        setContentView(relativeLayout);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("web_type", -1);
        if (intExtra == -1) {
            finish();
            return;
        }
        if (intExtra != 1) {
            if (intExtra != 2) {
                if (intExtra == 3) {
                    this.f61288ax = new c();
                    this.f61289ay = new com.sina.weibo.sdk.web.a.c(this, this.f61288ax);
                }
            } else {
                this.f61290az = "\u5fae\u535a\u767b\u5f55";
                this.f61288ax = new com.sina.weibo.sdk.web.b.a();
                this.f61289ay = new com.sina.weibo.sdk.web.a.a(this, this, this.f61288ax);
            }
        } else {
            this.f61290az = "\u5fae\u535a\u5206\u4eab";
            this.f61288ax = new d(this);
            this.f61289ay = new com.sina.weibo.sdk.web.a.d(this, this, this.f61288ax);
        }
        this.f61286av.setWebViewClient(this.f61289ay);
        this.f61288ax.readFromBundle(extras);
        WebSettings settings = this.f61286av.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowContentAccess(false);
        settings.setUserAgentString(e.r());
        this.f61286av.requestFocus();
        this.f61286av.setScrollBarStyle(0);
        a(this.f61286av, "searchBoxJavaBridge_");
        a(this.f61286av, "accessibility");
        a(this.f61286av, "accessibilityTraversal");
        settings.setMixedContentMode(2);
        if (this.f61288ax.w()) {
            this.f61288ax.a(new b.a() { // from class: com.sina.weibo.sdk.web.WebActivity.1
                @Override // com.sina.weibo.sdk.web.b.b.a
                public final void onComplete() {
                    String url = WebActivity.this.f61288ax.getUrl();
                    if (!TextUtils.isEmpty(url)) {
                        WebActivity.this.f61286av.loadUrl(url);
                    }
                }

                @Override // com.sina.weibo.sdk.web.b.b.a
                public final void onError(String str) {
                    WebActivity.this.f61289ay.m(str);
                }
            });
        } else {
            String url = this.f61288ax.getUrl();
            if (!TextUtils.isEmpty(url)) {
                this.f61286av.loadUrl(url);
            }
        }
        TextView textView4 = this.f61285au;
        if (textView4 != null) {
            textView4.setText(this.f61290az);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            if (this.f61289ay.v()) {
                return true;
            }
            if (this.f61286av.canGoBack()) {
                this.f61286av.goBack();
                return true;
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.sina.weibo.sdk.web.a
    public final void s() {
        this.f61283as.setVisibility(0);
        this.f61286av.setVisibility(8);
    }

    @Override // com.sina.weibo.sdk.web.a
    public final void t() {
        finish();
    }

    private static void a(WebView webView, String str) {
        try {
            WebView.class.getDeclaredMethod("removeJavascriptInterface", String.class).invoke(webView, str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
