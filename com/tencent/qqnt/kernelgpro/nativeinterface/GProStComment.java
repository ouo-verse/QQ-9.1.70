package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStComment implements Serializable {
    public long createTime;
    public long createTimeNs;
    public int externalShowLine;
    public boolean isTop;
    public boolean needFold;
    public boolean nextPageReply;
    public int replyCount;
    public long sequence;
    public int showReplyListNum;
    public int sourceType;
    public int typeFlag;
    public int typeFlag2;
    long serialVersionUID = 1;
    public String idd = "";
    public GProStUser postUser = new GProStUser();
    public String content = "";
    public ArrayList<GProStReply> vecReplyList = new ArrayList<>();
    public byte[] busiData = new byte[0];
    public GProStLike likeInfo = new GProStLike();
    public ArrayList<String> atUinListList = new ArrayList<>();
    public ArrayList<GProFeedEntry> storeExtInfoList = new ArrayList<>();
    public String thirdId = "";
    public GProStRichText richContents = new GProStRichText();
    public ArrayList<GProStImage> images = new ArrayList<>();
    public String attachInfo = "";

    public ArrayList<String> getAtUinListList() {
        return this.atUinListList;
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public String getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getCreateTimeNs() {
        return this.createTimeNs;
    }

    public int getExternalShowLine() {
        return this.externalShowLine;
    }

    public String getIdd() {
        return this.idd;
    }

    public ArrayList<GProStImage> getImages() {
        return this.images;
    }

    public boolean getIsTop() {
        return this.isTop;
    }

    public GProStLike getLikeInfo() {
        return this.likeInfo;
    }

    public boolean getNeedFold() {
        return this.needFold;
    }

    public boolean getNextPageReply() {
        return this.nextPageReply;
    }

    public GProStUser getPostUser() {
        return this.postUser;
    }

    public int getReplyCount() {
        return this.replyCount;
    }

    public GProStRichText getRichContents() {
        return this.richContents;
    }

    public long getSequence() {
        return this.sequence;
    }

    public int getShowReplyListNum() {
        return this.showReplyListNum;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public ArrayList<GProFeedEntry> getStoreExtInfoList() {
        return this.storeExtInfoList;
    }

    public String getThirdId() {
        return this.thirdId;
    }

    public int getTypeFlag() {
        return this.typeFlag;
    }

    public int getTypeFlag2() {
        return this.typeFlag2;
    }

    public ArrayList<GProStReply> getVecReplyList() {
        return this.vecReplyList;
    }

    public String toString() {
        return "GProStComment{idd=" + this.idd + ",postUser=" + this.postUser + ",createTime=" + this.createTime + ",content=" + this.content + ",replyCount=" + this.replyCount + ",vecReplyList=" + this.vecReplyList + ",busiData=" + this.busiData + ",likeInfo=" + this.likeInfo + ",typeFlag=" + this.typeFlag + ",atUinListList=" + this.atUinListList + ",typeFlag2=" + this.typeFlag2 + ",createTimeNs=" + this.createTimeNs + ",storeExtInfoList=" + this.storeExtInfoList + ",thirdId=" + this.thirdId + ",sourceType=" + this.sourceType + ",richContents=" + this.richContents + ",images=" + this.images + ",sequence=" + this.sequence + ",nextPageReply=" + this.nextPageReply + ",attachInfo=" + this.attachInfo + ",needFold=" + this.needFold + ",isTop=" + this.isTop + ",showReplyListNum=" + this.showReplyListNum + ",externalShowLine=" + this.externalShowLine + ",}";
    }
}
