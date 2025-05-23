package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildMemberSearchParams {
    public long categoryId;
    public long channelId;
    public int count;
    public long guildId;
    public String keyword;
    public long pos;
    public long roleId;
    public int sourceId;

    public GProGuildMemberSearchParams() {
        this.keyword = "";
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getCount() {
        return this.count;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public long getPos() {
        return this.pos;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public void setCategoryId(long j3) {
        this.categoryId = j3;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setPos(long j3) {
        this.pos = j3;
    }

    public void setRoleId(long j3) {
        this.roleId = j3;
    }

    public void setSourceId(int i3) {
        this.sourceId = i3;
    }

    public String toString() {
        return "GProGuildMemberSearchParams{sourceId=" + this.sourceId + ",guildId=" + this.guildId + ",keyword=" + this.keyword + ",count=" + this.count + ",pos=" + this.pos + ",channelId=" + this.channelId + ",categoryId=" + this.categoryId + ",roleId=" + this.roleId + ",}";
    }

    public GProGuildMemberSearchParams(int i3, long j3, String str, int i16, long j16, long j17, long j18, long j19) {
        this.sourceId = i3;
        this.guildId = j3;
        this.keyword = str;
        this.count = i16;
        this.pos = j16;
        this.channelId = j17;
        this.categoryId = j18;
        this.roleId = j19;
    }
}
