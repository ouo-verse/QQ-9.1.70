package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class aa extends Share {
    public aa(AppRuntime appRuntime, Activity activity) {
        super(appRuntime, activity);
    }

    @Override // com.tencent.biz.webviewplugin.Share, com.tencent.mobileqq.webviewplugin.n
    public String getShareUrl() {
        String str;
        com.tencent.mobileqq.webview.swift.y yVar;
        CustomWebView webView;
        if (!TextUtils.isEmpty(this.f97445d)) {
            str = this.f97445d;
        } else {
            WeakReference<com.tencent.mobileqq.webview.swift.y> weakReference = this.f97473z0;
            if (weakReference != null && (yVar = weakReference.get()) != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && (webView = ((com.tencent.mobileqq.webviewplugin.r) yVar).getWebView()) != null) {
                str = webView.getUrl();
            } else {
                str = "";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return super.getShareUrl();
        }
        return com.tencent.biz.common.util.k.g(str, new String[0]);
    }
}
