package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebHistoryItem {

    /* renamed from: a, reason: collision with root package name */
    private IX5WebHistoryItem f369194a = null;

    /* renamed from: b, reason: collision with root package name */
    private android.webkit.WebHistoryItem f369195b = null;

    WebHistoryItem() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.f369194a = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f369194a;
        if (iX5WebHistoryItem != null) {
            return iX5WebHistoryItem.getFavicon();
        }
        return this.f369195b.getFavicon();
    }

    public String getOriginalUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f369194a;
        if (iX5WebHistoryItem != null) {
            return iX5WebHistoryItem.getOriginalUrl();
        }
        return this.f369195b.getOriginalUrl();
    }

    public String getTitle() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f369194a;
        if (iX5WebHistoryItem != null) {
            return iX5WebHistoryItem.getTitle();
        }
        return this.f369195b.getTitle();
    }

    public String getUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f369194a;
        if (iX5WebHistoryItem != null) {
            return iX5WebHistoryItem.getUrl();
        }
        return this.f369195b.getUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.f369195b = webHistoryItem;
        return webHistoryItem2;
    }
}
