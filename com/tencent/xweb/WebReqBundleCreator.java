package com.tencent.xweb;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebReqBundleCreator {

    /* renamed from: a, reason: collision with root package name */
    public final WebResourceRequest f384985a;

    public WebReqBundleCreator(WebResourceRequest webResourceRequest) {
        this.f384985a = webResourceRequest;
    }

    public Bundle getBundle() {
        boolean z16;
        String str;
        WebResourceRequest webResourceRequest = this.f384985a;
        if (webResourceRequest != null && webResourceRequest.getRequestHeaders() != null && !this.f384985a.isForMainFrame() && this.f384985a.getRequestHeaders().containsKey("Accept") && (str = this.f384985a.getRequestHeaders().get("Accept")) != null && str.startsWith("text/html")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putInt("resourceType", 1);
            return bundle;
        }
        return null;
    }
}
