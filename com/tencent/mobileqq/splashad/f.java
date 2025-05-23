package com.tencent.mobileqq.splashad;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private boolean f288773d = false;

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "splashADPlugin";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        if (this.mRuntime.a().getIntent() != null) {
            this.f288773d = this.mRuntime.a().getIntent().getBooleanExtra("key_from_splash_ad", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 != 8589934598L) {
            return false;
        }
        QLog.i("QSplash@VasSplashUtil", 1, "handleEvent finish or destroy. isFromSP:" + this.f288773d);
        if (this.f288773d) {
            this.mRuntime.a().startActivity(SplashActivity.getAliasIntent(this.mRuntime.a()));
        }
        return true;
    }
}
