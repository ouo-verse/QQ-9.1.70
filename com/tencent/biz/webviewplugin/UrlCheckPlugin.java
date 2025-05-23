package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.o;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* loaded from: classes32.dex */
public class UrlCheckPlugin extends WebViewPlugin {
    public static int K = 0;
    public static int L = 2;
    public static int M = 3;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.biz.o f97509e;

    /* renamed from: d, reason: collision with root package name */
    public int f97508d = K;

    /* renamed from: f, reason: collision with root package name */
    QBaseActivity f97510f = null;

    /* renamed from: h, reason: collision with root package name */
    CustomWebView f97511h = null;

    /* renamed from: i, reason: collision with root package name */
    WindowManager f97512i = null;

    /* renamed from: m, reason: collision with root package name */
    WindowManager.LayoutParams f97513m = null;
    RelativeLayout C = null;
    TextView D = null;
    ImageView E = null;
    int F = 0;
    int G = 0;
    int H = 0;
    boolean I = false;
    public Runnable J = new Runnable() { // from class: com.tencent.biz.webviewplugin.UrlCheckPlugin.4
        @Override // java.lang.Runnable
        public void run() {
            UrlCheckPlugin.this.p();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements o.a {
        a() {
        }

        @Override // com.tencent.biz.o.a
        public void N1(boolean z16, int i3, int i16) {
            CustomWebView customWebView;
            int i17;
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "onSoftKeyboardToggled");
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "isCheatDialogShow:" + UrlCheckPlugin.this.f97508d);
            }
            if (z16) {
                UrlCheckPlugin urlCheckPlugin = UrlCheckPlugin.this;
                if (urlCheckPlugin.f97510f == null || (customWebView = urlCheckPlugin.f97511h) == null || (i17 = urlCheckPlugin.F) < 1 || i17 > 2 || urlCheckPlugin.I) {
                    return;
                }
                if (urlCheckPlugin.f97508d != UrlCheckPlugin.L) {
                    urlCheckPlugin.I = true;
                    urlCheckPlugin.s(R.string.aja);
                } else if (i17 == 2) {
                    customWebView.removeCallbacks(urlCheckPlugin.J);
                    UrlCheckPlugin.this.p();
                    UrlCheckPlugin urlCheckPlugin2 = UrlCheckPlugin.this;
                    urlCheckPlugin2.I = true;
                    urlCheckPlugin2.s(R.string.aja);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlCheckPlugin.this.p();
        }
    }

    private void q() {
        if (this.f97509e == null) {
            this.f97509e = new com.tencent.biz.o(this.f97511h, new a());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "URL_CHECK";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        ImageView imageView;
        CustomWebView e16 = this.mRuntime.e();
        this.f97511h = e16;
        if (e16 == null) {
            return false;
        }
        Activity a16 = this.mRuntime.a();
        if (!(a16 instanceof QBaseActivity)) {
            return false;
        }
        this.f97510f = (QBaseActivity) a16;
        q();
        if (j3 == 8589934597L) {
            com.tencent.biz.o oVar = this.f97509e;
            if (oVar != null) {
                oVar.a();
                this.f97509e = null;
            }
            if (this.f97508d == L && (imageView = this.E) != null) {
                imageView.setOnClickListener(null);
                this.f97511h.removeCallbacks(this.J);
                p();
            }
        } else if (j3 == 8589934594L && this.F == 2 && this.f97508d != L) {
            this.f97511h.postDelayed(new Runnable() { // from class: com.tencent.biz.webviewplugin.UrlCheckPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    UrlCheckPlugin.this.s(R.string.ibj);
                }
            }, this.G);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        com.tencent.biz.o oVar = this.f97509e;
        if (oVar != null) {
            oVar.a();
            this.f97509e = null;
        }
        super.onDestroy();
    }

    public void p() {
        Activity a16 = this.mRuntime.a();
        if (a16 == null || a16.isFinishing() || this.C == null || this.f97508d != L) {
            return;
        }
        WindowManager windowManager = a16.getWindowManager();
        this.f97508d = M;
        try {
            windowManager.removeView(this.C);
        } catch (IllegalArgumentException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("WebViewPlugin", 2, "removeView Error:" + e16.getMessage());
            }
        }
    }

    public void r(int i3, int i16, int i17) {
        this.F = i3;
        this.G = i16;
        this.H = i17;
    }

    public void s(int i3) {
        int i16;
        Activity a16 = this.mRuntime.a();
        if ((a16 instanceof QBaseActivity) && this.f97511h != null) {
            if (this.C == null) {
                QBaseActivity qBaseActivity = (QBaseActivity) a16;
                this.f97510f = qBaseActivity;
                RelativeLayout relativeLayout = (RelativeLayout) qBaseActivity.getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) null);
                this.C = relativeLayout;
                this.D = (TextView) relativeLayout.findViewById(R.id.toast_msg);
                this.E = (ImageView) this.C.findViewById(R.id.js_);
                this.f97512i = this.f97510f.getWindowManager();
                this.f97513m = new WindowManager.LayoutParams();
                Resources resources = this.f97510f.getResources();
                try {
                    i16 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
                } catch (Exception unused) {
                    i16 = (int) ((resources.getDisplayMetrics().density * 25.0f) + 0.5d);
                }
                WindowManager.LayoutParams layoutParams = this.f97513m;
                layoutParams.gravity = 49;
                layoutParams.y = this.f97510f.getTitleBarHeight() + i16;
                WindowManager.LayoutParams layoutParams2 = this.f97513m;
                layoutParams2.type = 1002;
                layoutParams2.format = 1;
                layoutParams2.flags = 262664;
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                ImageView imageView = this.E;
                if (imageView != null) {
                    imageView.setOnClickListener(new b());
                }
            }
            if (this.f97512i == null) {
                this.f97512i = this.f97510f.getWindowManager();
            }
            TextView textView = this.D;
            if (textView != null) {
                textView.setText(this.f97510f.getResources().getText(i3));
            }
            this.f97511h.postDelayed(this.J, this.H + this.G);
            this.f97508d = L;
            try {
                this.f97512i.addView(this.C, this.f97513m);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("WebViewPlugin", 2, "addView exception:" + e16.getMessage());
                }
            }
        }
    }
}
