package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class SearchChatAtMeMsgsParams {
    public boolean includeAtAll;
    public int pageLimit;
    public String peerUid;

    public SearchChatAtMeMsgsParams() {
        this.peerUid = "";
    }

    public boolean getIncludeAtAll() {
        return this.includeAtAll;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "SearchChatAtMeMsgsParams{peerUid=" + this.peerUid + ",includeAtAll=" + this.includeAtAll + ",pageLimit=" + this.pageLimit + ",}";
    }

    public SearchChatAtMeMsgsParams(String str, boolean z16, int i3) {
        this.peerUid = str;
        this.includeAtAll = z16;
        this.pageLimit = i3;
    }
}
