package com.tencent.mobileqq.wholepeople;

import android.app.Activity;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private WebView f315342d;

    /* renamed from: e, reason: collision with root package name */
    private RedTouch f315343e;

    /* renamed from: f, reason: collision with root package name */
    private int f315344f = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    ColorFilter f315345h = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f315346d;

        a(String str) {
            this.f315346d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (QLog.isColorLevel()) {
                QLog.i("WholePeoplePlugin", 2, "onClick " + this.f315346d);
            }
            c.this.callJs(this.f315346d, "");
        }
    }

    private void p(boolean z16, boolean z17, String str) {
        Activity a16 = this.mRuntime.a();
        WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
        if (webViewFragment != null) {
            ImageView imageView = webViewFragment.getSwiftTitleUI().E;
            if (this.f315344f == Integer.MAX_VALUE) {
                this.f315344f = imageView.getPaddingRight();
            }
            if (z16 && !TextUtils.isEmpty(str)) {
                imageView.setImageResource(R.drawable.aag);
                if (webViewFragment.getSwiftTitleUI().f314059m != null) {
                    int currentTextColor = webViewFragment.getSwiftTitleUI().f314059m.getCurrentTextColor();
                    imageView.setColorFilter(new PorterDuffColorFilter(currentTextColor, PorterDuff.Mode.SRC_IN));
                    if (QLog.isColorLevel()) {
                        QLog.i("WholePeoplePlugin", 2, "titleColor:" + currentTextColor);
                    }
                } else {
                    imageView.setColorFilter(this.f315345h);
                }
                imageView.setVisibility(0);
                if (z17) {
                    if (this.f315343e == null) {
                        this.f315343e = new RedTouch(a16, imageView).setGravity(53).applyTo();
                    }
                    Bundle e16 = com.tencent.mobileqq.campuscircle.a.c().e();
                    if (e16 != null) {
                        int i3 = e16.getInt("redPointCount", 0);
                        int i16 = e16.getInt("redNumCount", 0);
                        int i17 = i16 > 0 ? i16 > 99 ? 12 : 10 : 0;
                        this.f315343e.parseRedTouch(com.tencent.mobileqq.wholepeople.a.c(i16, i3));
                        imageView.setPadding(imageView.getPaddingLeft(), imageView.getPaddingTop(), this.f315344f + BaseAIOUtils.f(i17, this.f315342d.getResources()), imageView.getPaddingBottom());
                    } else {
                        RedTouch redTouch = this.f315343e;
                        if (redTouch != null) {
                            redTouch.clearRedTouch();
                        }
                    }
                } else {
                    RedTouch redTouch2 = this.f315343e;
                    if (redTouch2 != null) {
                        redTouch2.clearRedTouch();
                    }
                }
                imageView.setOnClickListener(new a(str));
                return;
            }
            imageView.setVisibility(8);
            imageView.setPadding(imageView.getPaddingLeft(), imageView.getPaddingTop(), this.f315344f, imageView.getPaddingBottom());
            return;
        }
        QLog.e("WholePeoplePlugin", 1, "setRightButton, not support " + a16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "allpeoplevote";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069 A[Catch: JSONException -> 0x009d, TryCatch #0 {JSONException -> 0x009d, blocks: (B:16:0x002d, B:18:0x0035, B:21:0x003c, B:26:0x0063, B:28:0x0069, B:33:0x0098), top: B:15:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin.b bVar;
        Activity a16;
        int i3;
        int i16;
        String optString;
        if (str2 == null || !str2.equalsIgnoreCase("allpeoplevote") || str3 == null || (bVar = this.mRuntime) == null || bVar.a() == null) {
            return false;
        }
        if (str3.equalsIgnoreCase(IndividuationPlugin.Method_setRightButton) && strArr.length == 1) {
            try {
                Activity a17 = this.mRuntime.a();
                if (a17 != null && !a17.isFinishing()) {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    String optString2 = jSONObject.optString("callback");
                    try {
                        String optString3 = jSONObject.optString("show");
                        optString = jSONObject.optString("showRedNum");
                        i3 = Integer.parseInt(optString3);
                    } catch (Exception unused) {
                        i3 = 0;
                    }
                    try {
                        i16 = Integer.parseInt(optString);
                    } catch (Exception unused2) {
                        i16 = 0;
                        if (QLog.isColorLevel()) {
                        }
                        p(i3 != 1, i16 == 1, optString2);
                        return true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("WholePeoplePlugin", 2, "setRightButton show=" + i3 + " showRedNum=" + i16 + " callback=" + optString2);
                    }
                    p(i3 != 1, i16 == 1, optString2);
                }
                return true;
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("WholePeoplePlugin", 2, "setRightButton error", e16);
                }
            }
        } else if (str3.equalsIgnoreCase("readRedPoint") && (a16 = this.mRuntime.a()) != null && !a16.isFinishing()) {
            com.tencent.mobileqq.campuscircle.a.c().a();
            RedTouch redTouch = this.f315343e;
            if (redTouch != null && redTouch.hasRedTouch()) {
                this.f315343e.clearRedTouch();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        this.f315342d = this.mRuntime.e();
    }
}
