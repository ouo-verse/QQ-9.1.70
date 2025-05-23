package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ak extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.biz.troop.b f238845d;

    public ak() {
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.f238845d = A;
        A.p();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "ftssearch";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && strArr != null && strArr.length != 0) {
            "ftssearch".equals(str2);
        }
        return false;
    }
}
