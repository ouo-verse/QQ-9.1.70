package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildMsgSearchRes {
    public long channelId;
    public long guildId;
    public long msgSeq;
    public long timeStamp;
    public long tinyId;
    public int userType;
    public String nickName = "";
    public String avatar = "";
    public String msgTxt = "";
    public String pics = "";
    public String videos = "";

    public String getAvatar() {
        return this.avatar;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getMsgTxt() {
        return this.msgTxt;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPics() {
        return this.pics;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int getUserType() {
        return this.userType;
    }

    public String getVideos() {
        return this.videos;
    }

    public String toString() {
        return "GProGuildMsgSearchRes{guildId=" + this.guildId + ",channelId=" + this.channelId + ",tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",avatar=" + this.avatar + ",timeStamp=" + this.timeStamp + ",msgSeq=" + this.msgSeq + ",msgTxt=" + this.msgTxt + ",pics=" + this.pics + ",videos=" + this.videos + ",userType=" + this.userType + ",}";
    }
}
