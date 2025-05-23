package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebBackForwardList {

    /* renamed from: a, reason: collision with root package name */
    private IX5WebBackForwardList f369192a = null;

    /* renamed from: b, reason: collision with root package name */
    private android.webkit.WebBackForwardList f369193b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.f369192a = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f369192a;
        if (iX5WebBackForwardList != null) {
            return iX5WebBackForwardList.getCurrentIndex();
        }
        return this.f369193b.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f369192a;
        if (iX5WebBackForwardList != null) {
            return WebHistoryItem.a(iX5WebBackForwardList.getCurrentItem());
        }
        return WebHistoryItem.a(this.f369193b.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i3) {
        IX5WebBackForwardList iX5WebBackForwardList = this.f369192a;
        if (iX5WebBackForwardList != null) {
            return WebHistoryItem.a(iX5WebBackForwardList.getItemAtIndex(i3));
        }
        return WebHistoryItem.a(this.f369193b.getItemAtIndex(i3));
    }

    public int getSize() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f369192a;
        if (iX5WebBackForwardList != null) {
            return iX5WebBackForwardList.getSize();
        }
        return this.f369193b.getSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.f369193b = webBackForwardList;
        return webBackForwardList2;
    }
}
