package com.tencent.mobileqq.profile;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private WebView f260131d;

    /* renamed from: e, reason: collision with root package name */
    private String f260132e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f260133f = false;

    /* renamed from: h, reason: collision with root package name */
    private Bundle f260134h;

    private boolean p(String[] strArr) {
        if (QLog.isColorLevel()) {
            QLog.i("WebViewPlugin", 2, "onAddTag");
        }
        if (this.f260134h == null) {
            this.f260134h = new Bundle();
        }
        this.f260134h.putBoolean("onTagChanged", true);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "profileJS";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934598L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        this.f260131d = this.mRuntime.e();
        if (this.mRuntime.a().getIntent() != null) {
            this.f260132e = this.mRuntime.a().getIntent().getStringExtra(QQBrowserActivity.BROADCAST_ACTION_KEY);
            this.f260133f = this.mRuntime.a().getIntent().getBooleanExtra("fromProfile", this.f260133f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin.b bVar;
        if (str2 == null || !str2.equalsIgnoreCase("profileJS") || str3 == null || (bVar = this.mRuntime) == null || bVar.a() == null) {
            return false;
        }
        if (str3.equals("onAddTag")) {
            return p(strArr);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 != 8589934598L) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebViewPlugin", 2, "handleEvent finish or destroy. fromProfile:" + this.f260133f);
        }
        String str2 = this.f260132e;
        if (str2 == null || "".equals(str2) || this.f260134h == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction(this.f260132e);
        Bundle bundle = this.f260134h;
        if (bundle != null) {
            intent.putExtra(SpecialProxy.KEY_DATA, bundle);
        }
        this.mRuntime.a().sendBroadcast(intent);
        this.f260134h = null;
        if (!this.f260133f) {
            return false;
        }
        Intent intent2 = new Intent(this.mRuntime.a(), (Class<?>) PersonalityLabelGalleryActivity.class);
        intent2.putExtra(IProfileCardConst.KEY_FROM_TYPE, 3);
        intent2.putExtra("uin", this.mRuntime.b().getCurrentAccountUin());
        this.mRuntime.a().startActivity(intent2);
        return false;
    }
}
