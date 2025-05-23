package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetNextPageRepliesRsp {
    public boolean hasMore;
    public int totalReplyCount;
    public ArrayList<GProStReply> replies = new ArrayList<>();
    public String attachInfo = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<GProStReply> getReplies() {
        return this.replies;
    }

    public int getTotalReplyCount() {
        return this.totalReplyCount;
    }

    public String toString() {
        return "GProGetNextPageRepliesRsp{replies=" + this.replies + ",hasMore=" + this.hasMore + ",attachInfo=" + this.attachInfo + ",totalReplyCount=" + this.totalReplyCount + ",}";
    }
}
