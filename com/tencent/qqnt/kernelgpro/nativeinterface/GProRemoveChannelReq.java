package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRemoveChannelReq {
    public long channelId;
    public long guildId;
    public int movePost;

    public GProRemoveChannelReq() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getMovePost() {
        return this.movePost;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setMovePost(int i3) {
        this.movePost = i3;
    }

    public String toString() {
        return "GProRemoveChannelReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",movePost=" + this.movePost + ",}";
    }

    public GProRemoveChannelReq(long j3, long j16, int i3) {
        this.guildId = j3;
        this.channelId = j16;
        this.movePost = i3;
    }
}
