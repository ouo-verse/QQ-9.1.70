package com.tencent.luggage.wxa.fm;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements WebResourceRequest {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.xweb.WebResourceRequest f126255a;

    public a(com.tencent.xweb.WebResourceRequest webResourceRequest) {
        this.f126255a = webResourceRequest;
    }

    @Override // android.webkit.WebResourceRequest
    public String getMethod() {
        return this.f126255a.getMethod();
    }

    @Override // android.webkit.WebResourceRequest
    public Map getRequestHeaders() {
        return this.f126255a.getRequestHeaders();
    }

    @Override // android.webkit.WebResourceRequest
    public Uri getUrl() {
        return this.f126255a.getUrl();
    }

    @Override // android.webkit.WebResourceRequest
    public boolean hasGesture() {
        return this.f126255a.hasGesture();
    }

    @Override // android.webkit.WebResourceRequest
    public boolean isForMainFrame() {
        return this.f126255a.isForMainFrame();
    }

    @Override // android.webkit.WebResourceRequest
    public boolean isRedirect() {
        return this.f126255a.isRedirect();
    }
}
