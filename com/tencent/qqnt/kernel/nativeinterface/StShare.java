package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StShare {

    /* renamed from: qzone, reason: collision with root package name */
    public ShareToQzone f359226qzone = new ShareToQzone();
    public ShareToArk ark = new ShareToArk();
    public ShareOutside outside = new ShareOutside();
    public String title = "";
    public String summary = "";
    public String shareKey = "";

    public ShareToArk getArk() {
        return this.ark;
    }

    public ShareOutside getOutside() {
        return this.outside;
    }

    public ShareToQzone getQzone() {
        return this.f359226qzone;
    }

    public String getShareKey() {
        return this.shareKey;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTitle() {
        return this.title;
    }
}
