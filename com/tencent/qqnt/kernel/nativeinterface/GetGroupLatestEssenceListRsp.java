package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetGroupLatestEssenceListRsp {
    public boolean isEnd;
    public int totalCount;
    public ArrayList<EssenceMsgInfo> msgList = new ArrayList<>();
    public String jumpUrl = "";
    public String nextPageCookie = "";

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public ArrayList<EssenceMsgInfo> getMsgList() {
        return this.msgList;
    }

    public String getNextPageCookie() {
        return this.nextPageCookie;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public String toString() {
        return "GetGroupLatestEssenceListRsp{msgList=" + this.msgList + ",totalCount=" + this.totalCount + ",jumpUrl=" + this.jumpUrl + ",isEnd=" + this.isEnd + ",nextPageCookie=" + this.nextPageCookie + ",}";
    }
}
