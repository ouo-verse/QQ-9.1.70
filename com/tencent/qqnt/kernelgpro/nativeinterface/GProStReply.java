package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStReply implements Serializable {
    public long createTime;
    public long createTimeNs;
    public int modifyflag;
    public boolean needFold;
    public boolean needSink;
    public int sourceType;
    public int typeFlag;
    public int typeFlag2;
    long serialVersionUID = 1;
    public String idd = "";
    public GProStUser postUser = new GProStUser();
    public String content = "";
    public GProStUser targetUser = new GProStUser();
    public byte[] busiData = new byte[0];
    public GProStLike likeInfo = new GProStLike();
    public ArrayList<String> atUinListList = new ArrayList<>();
    public ArrayList<GProFeedEntry> storeExtInfoList = new ArrayList<>();
    public String thirdId = "";
    public String targetReplyID = "";
    public GProStRichText richContents = new GProStRichText();
    public ArrayList<GProStImage> images = new ArrayList<>();

    public ArrayList<String> getAtUinListList() {
        return this.atUinListList;
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

    public String getIdd() {
        return this.idd;
    }

    public ArrayList<GProStImage> getImages() {
        return this.images;
    }

    public GProStLike getLikeInfo() {
        return this.likeInfo;
    }

    public int getModifyflag() {
        return this.modifyflag;
    }

    public boolean getNeedFold() {
        return this.needFold;
    }

    public boolean getNeedSink() {
        return this.needSink;
    }

    public GProStUser getPostUser() {
        return this.postUser;
    }

    public GProStRichText getRichContents() {
        return this.richContents;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public ArrayList<GProFeedEntry> getStoreExtInfoList() {
        return this.storeExtInfoList;
    }

    public String getTargetReplyID() {
        return this.targetReplyID;
    }

    public GProStUser getTargetUser() {
        return this.targetUser;
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

    public String toString() {
        return "GProStReply{idd=" + this.idd + ",postUser=" + this.postUser + ",createTime=" + this.createTime + ",content=" + this.content + ",targetUser=" + this.targetUser + ",busiData=" + this.busiData + ",likeInfo=" + this.likeInfo + ",typeFlag=" + this.typeFlag + ",modifyflag=" + this.modifyflag + ",atUinListList=" + this.atUinListList + ",typeFlag2=" + this.typeFlag2 + ",createTimeNs=" + this.createTimeNs + ",storeExtInfoList=" + this.storeExtInfoList + ",thirdId=" + this.thirdId + ",targetReplyID=" + this.targetReplyID + ",sourceType=" + this.sourceType + ",richContents=" + this.richContents + ",images=" + this.images + ",needFold=" + this.needFold + ",needSink=" + this.needSink + ",}";
    }
}
