package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class SearchMsgWithKeywordsParams {
    public int chatType;
    public int pageLimit;
    public String peerUid;
    public int searchFields;

    public SearchMsgWithKeywordsParams() {
        this.peerUid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getSearchFields() {
        return this.searchFields;
    }

    public String toString() {
        return "SearchMsgWithKeywordsParams{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",searchFields=" + this.searchFields + ",pageLimit=" + this.pageLimit + ",}";
    }

    public SearchMsgWithKeywordsParams(int i3, String str, int i16, int i17) {
        this.chatType = i3;
        this.peerUid = str;
        this.searchFields = i16;
        this.pageLimit = i17;
    }
}
