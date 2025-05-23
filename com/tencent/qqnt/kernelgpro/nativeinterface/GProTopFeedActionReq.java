package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProTopFeedActionReq {
    public int action;
    public long cancelTime;
    public int cardType;
    public long channelId;
    public long createTime;
    public long guildId;
    public int labelId;
    public boolean needNotify;
    public int topType;
    public String feedId = "";
    public String userId = "";
    public ArrayList<Long> roleIds = new ArrayList<>();

    public int getAction() {
        return this.action;
    }

    public long getCancelTime() {
        return this.cancelTime;
    }

    public int getCardType() {
        return this.cardType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getLabelId() {
        return this.labelId;
    }

    public boolean getNeedNotify() {
        return this.needNotify;
    }

    public ArrayList<Long> getRoleIds() {
        return this.roleIds;
    }

    public int getTopType() {
        return this.topType;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "GProTopFeedActionReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",feedId=" + this.feedId + ",userId=" + this.userId + ",createTime=" + this.createTime + ",action=" + this.action + ",labelId=" + this.labelId + ",cancelTime=" + this.cancelTime + ",needNotify=" + this.needNotify + ",roleIds=" + this.roleIds + ",cardType=" + this.cardType + ",topType=" + this.topType + ",}";
    }
}
