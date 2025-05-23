package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAvChannelStateMsg {
    public long appid;
    public int atType;
    public long channelId;
    public long fromTinyId;
    public long guildId;
    public boolean needNotify;
    public long roomId;
    public long timestamp;
    public String summary = "";

    /* renamed from: msg, reason: collision with root package name */
    public String f359281msg = "";

    public long getAppid() {
        return this.appid;
    }

    public int getAtType() {
        return this.atType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getFromTinyId() {
        return this.fromTinyId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getMsg() {
        return this.f359281msg;
    }

    public boolean getNeedNotify() {
        return this.needNotify;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getSummary() {
        return this.summary;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "GProAvChannelStateMsg{guildId=" + this.guildId + ",channelId=" + this.channelId + ",timestamp=" + this.timestamp + ",appid=" + this.appid + ",roomId=" + this.roomId + ",summary=" + this.summary + ",msg=" + this.f359281msg + ",needNotify=" + this.needNotify + ",atType=" + this.atType + ",fromTinyId=" + this.fromTinyId + ",}";
    }
}
