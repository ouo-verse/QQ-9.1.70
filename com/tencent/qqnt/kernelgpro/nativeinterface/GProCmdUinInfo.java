package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProCmdUinInfo implements Serializable {
    public long authChannelChangeSeq;
    public long channelChangeSeq;
    public long commInfoChangeSeq;
    public int feedInteractionNotify;
    public int guildManagementNotify;
    public long guildMsgCommonNotify;
    public int guildUnnotifyFlag;
    public int isMember;
    public int isTop;
    public long joinTime;
    public int myGuildGlobalAuth;
    public long myGuildPermissionChangeSeq;
    public int postFeedNotify;
    public GProQQMsgSubscribe qqMsgSubscribe;
    public int role;
    public long rolesChangeSeq;
    long serialVersionUID;
    public long shutupExpireTime;
    public long tinyid;
    public int weakNotifyDisplay;

    public GProCmdUinInfo() {
        this.serialVersionUID = 1L;
        this.qqMsgSubscribe = new GProQQMsgSubscribe();
    }

    public long getAuthChannelChangeSeq() {
        return this.authChannelChangeSeq;
    }

    public long getChannelChangeSeq() {
        return this.channelChangeSeq;
    }

    public long getCommInfoChangeSeq() {
        return this.commInfoChangeSeq;
    }

    public int getFeedInteractionNotify() {
        return this.feedInteractionNotify;
    }

    public int getGuildManagementNotify() {
        return this.guildManagementNotify;
    }

    public long getGuildMsgCommonNotify() {
        return this.guildMsgCommonNotify;
    }

    public int getGuildUnnotifyFlag() {
        return this.guildUnnotifyFlag;
    }

    public int getIsMember() {
        return this.isMember;
    }

    public int getIsTop() {
        return this.isTop;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public int getMyGuildGlobalAuth() {
        return this.myGuildGlobalAuth;
    }

    public long getMyGuildPermissionChangeSeq() {
        return this.myGuildPermissionChangeSeq;
    }

    public int getPostFeedNotify() {
        return this.postFeedNotify;
    }

    public GProQQMsgSubscribe getQqMsgSubscribe() {
        return this.qqMsgSubscribe;
    }

    public int getRole() {
        return this.role;
    }

    public long getRolesChangeSeq() {
        return this.rolesChangeSeq;
    }

    public long getShutupExpireTime() {
        return this.shutupExpireTime;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public int getWeakNotifyDisplay() {
        return this.weakNotifyDisplay;
    }

    public void setAuthChannelChangeSeq(long j3) {
        this.authChannelChangeSeq = j3;
    }

    public void setChannelChangeSeq(long j3) {
        this.channelChangeSeq = j3;
    }

    public void setCommInfoChangeSeq(long j3) {
        this.commInfoChangeSeq = j3;
    }

    public void setFeedInteractionNotify(int i3) {
        this.feedInteractionNotify = i3;
    }

    public void setGuildManagementNotify(int i3) {
        this.guildManagementNotify = i3;
    }

    public void setGuildMsgCommonNotify(long j3) {
        this.guildMsgCommonNotify = j3;
    }

    public void setGuildUnnotifyFlag(int i3) {
        this.guildUnnotifyFlag = i3;
    }

    public void setIsMember(int i3) {
        this.isMember = i3;
    }

    public void setIsTop(int i3) {
        this.isTop = i3;
    }

    public void setJoinTime(long j3) {
        this.joinTime = j3;
    }

    public void setMyGuildGlobalAuth(int i3) {
        this.myGuildGlobalAuth = i3;
    }

    public void setMyGuildPermissionChangeSeq(long j3) {
        this.myGuildPermissionChangeSeq = j3;
    }

    public void setPostFeedNotify(int i3) {
        this.postFeedNotify = i3;
    }

    public void setQqMsgSubscribe(GProQQMsgSubscribe gProQQMsgSubscribe) {
        this.qqMsgSubscribe = gProQQMsgSubscribe;
    }

    public void setRole(int i3) {
        this.role = i3;
    }

    public void setRolesChangeSeq(long j3) {
        this.rolesChangeSeq = j3;
    }

    public void setShutupExpireTime(long j3) {
        this.shutupExpireTime = j3;
    }

    public void setTinyid(long j3) {
        this.tinyid = j3;
    }

    public void setWeakNotifyDisplay(int i3) {
        this.weakNotifyDisplay = i3;
    }

    public String toString() {
        return "GProCmdUinInfo{joinTime=" + this.joinTime + ",role=" + this.role + ",isTop=" + this.isTop + ",tinyid=" + this.tinyid + ",channelChangeSeq=" + this.channelChangeSeq + ",rolesChangeSeq=" + this.rolesChangeSeq + ",weakNotifyDisplay=" + this.weakNotifyDisplay + ",commInfoChangeSeq=" + this.commInfoChangeSeq + ",shutupExpireTime=" + this.shutupExpireTime + ",authChannelChangeSeq=" + this.authChannelChangeSeq + ",myGuildPermissionChangeSeq=" + this.myGuildPermissionChangeSeq + ",qqMsgSubscribe=" + this.qqMsgSubscribe + ",guildUnnotifyFlag=" + this.guildUnnotifyFlag + ",feedInteractionNotify=" + this.feedInteractionNotify + ",guildManagementNotify=" + this.guildManagementNotify + ",postFeedNotify=" + this.postFeedNotify + ",guildMsgCommonNotify=" + this.guildMsgCommonNotify + ",myGuildGlobalAuth=" + this.myGuildGlobalAuth + ",isMember=" + this.isMember + ",}";
    }

    public GProCmdUinInfo(long j3, int i3, int i16, long j16, long j17, long j18, int i17, long j19, long j26, long j27, long j28, GProQQMsgSubscribe gProQQMsgSubscribe, int i18, int i19, int i26, int i27, long j29, int i28) {
        this.serialVersionUID = 1L;
        new GProQQMsgSubscribe();
        this.joinTime = j3;
        this.role = i3;
        this.isTop = i16;
        this.tinyid = j16;
        this.channelChangeSeq = j17;
        this.rolesChangeSeq = j18;
        this.weakNotifyDisplay = i17;
        this.commInfoChangeSeq = j19;
        this.shutupExpireTime = j26;
        this.authChannelChangeSeq = j27;
        this.myGuildPermissionChangeSeq = j28;
        this.qqMsgSubscribe = gProQQMsgSubscribe;
        this.guildUnnotifyFlag = i18;
        this.feedInteractionNotify = i19;
        this.guildManagementNotify = i26;
        this.postFeedNotify = i27;
        this.guildMsgCommonNotify = j29;
        this.isMember = i28;
    }
}
