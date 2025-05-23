package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProTopFeed {
    public int cardType;
    public long createTime;
    public boolean needNotify;
    public long operatorTinyid;
    public long readTime;
    public long topTimestamp;
    public String feedId = "";
    public String userId = "";
    public GProTopFeedAbstract feedAbstract = new GProTopFeedAbstract();
    public GProStChannelSign channelSign = new GProStChannelSign();
    public GProTopFeedLabel label = new GProTopFeedLabel();
    public byte[] feed = new byte[0];
    public String feedDetailTitle = "";
    public ArrayList<Long> roleIds = new ArrayList<>();
    public GProCardInfo cardInfo = new GProCardInfo();

    public GProCardInfo getCardInfo() {
        return this.cardInfo;
    }

    public int getCardType() {
        return this.cardType;
    }

    public GProStChannelSign getChannelSign() {
        return this.channelSign;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public byte[] getFeed() {
        return this.feed;
    }

    public GProTopFeedAbstract getFeedAbstract() {
        return this.feedAbstract;
    }

    public String getFeedDetailTitle() {
        return this.feedDetailTitle;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public GProTopFeedLabel getLabel() {
        return this.label;
    }

    public boolean getNeedNotify() {
        return this.needNotify;
    }

    public long getOperatorTinyid() {
        return this.operatorTinyid;
    }

    public long getReadTime() {
        return this.readTime;
    }

    public ArrayList<Long> getRoleIds() {
        return this.roleIds;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "GProTopFeed{feedId=" + this.feedId + ",userId=" + this.userId + ",createTime=" + this.createTime + ",feedAbstract=" + this.feedAbstract + ",topTimestamp=" + this.topTimestamp + ",operatorTinyid=" + this.operatorTinyid + ",channelSign=" + this.channelSign + ",label=" + this.label + ",readTime=" + this.readTime + ",needNotify=" + this.needNotify + ",feed=" + this.feed + ",feedDetailTitle=" + this.feedDetailTitle + ",roleIds=" + this.roleIds + ",cardType=" + this.cardType + ",cardInfo=" + this.cardInfo + ",}";
    }
}
