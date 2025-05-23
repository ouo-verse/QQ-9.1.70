package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFeedMemberListReq {
    public long channelId;
    public long fetchCount;
    public long guildId;
    public int postRobotFilter;
    public ArrayList<Long> robotListTinyId = new ArrayList<>();
    public long roleIdIndex;
    public int sourceType;
    public long startIndex;

    public long getChannelId() {
        return this.channelId;
    }

    public long getFetchCount() {
        return this.fetchCount;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPostRobotFilter() {
        return this.postRobotFilter;
    }

    public ArrayList<Long> getRobotListTinyId() {
        return this.robotListTinyId;
    }

    public long getRoleIdIndex() {
        return this.roleIdIndex;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public long getStartIndex() {
        return this.startIndex;
    }

    public String toString() {
        return "GProFeedMemberListReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",startIndex=" + this.startIndex + ",roleIdIndex=" + this.roleIdIndex + ",fetchCount=" + this.fetchCount + ",sourceType=" + this.sourceType + ",postRobotFilter=" + this.postRobotFilter + ",robotListTinyId=" + this.robotListTinyId + ",}";
    }
}
