package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFeedRedTouchTransInfo {
    public long createTs;
    public int insertPageType;
    public int msgType;
    public int pageType;
    public int redType;
    public String feedId = "";
    public String author = "";

    public String getAuthor() {
        return this.author;
    }

    public long getCreateTs() {
        return this.createTs;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getInsertPageType() {
        return this.insertPageType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public int getPageType() {
        return this.pageType;
    }

    public int getRedType() {
        return this.redType;
    }

    public String toString() {
        return "GProFeedRedTouchTransInfo{feedId=" + this.feedId + ",author=" + this.author + ",createTs=" + this.createTs + ",msgType=" + this.msgType + ",pageType=" + this.pageType + ",redType=" + this.redType + ",insertPageType=" + this.insertPageType + ",}";
    }
}
