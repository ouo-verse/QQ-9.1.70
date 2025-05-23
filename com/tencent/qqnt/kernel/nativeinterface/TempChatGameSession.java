package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TempChatGameSession {
    public long gameAppId;
    public String nickname;
    public String peerOpenId;
    public String peerRoleId;
    public long peerTinyId;
    public Integer pushWindowFlag;
    public Integer redPointSwitch;
    public Integer sayHiType;
    public Integer seekingPartner;
    public String selfOpenId;
    public String selfRoleId;
    public long selfTinyId;

    public TempChatGameSession() {
        this.nickname = "";
        this.selfRoleId = "";
        this.selfOpenId = "";
        this.peerRoleId = "";
        this.peerOpenId = "";
    }

    public long getGameAppId() {
        return this.gameAppId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPeerOpenId() {
        return this.peerOpenId;
    }

    public String getPeerRoleId() {
        return this.peerRoleId;
    }

    public long getPeerTinyId() {
        return this.peerTinyId;
    }

    public Integer getPushWindowFlag() {
        return this.pushWindowFlag;
    }

    public Integer getRedPointSwitch() {
        return this.redPointSwitch;
    }

    public Integer getSayHiType() {
        return this.sayHiType;
    }

    public Integer getSeekingPartner() {
        return this.seekingPartner;
    }

    public String getSelfOpenId() {
        return this.selfOpenId;
    }

    public String getSelfRoleId() {
        return this.selfRoleId;
    }

    public long getSelfTinyId() {
        return this.selfTinyId;
    }

    public String toString() {
        return "TempChatGameSession{gameAppId=" + this.gameAppId + ",nickname=" + this.nickname + ",selfTinyId=" + this.selfTinyId + ",selfRoleId=" + this.selfRoleId + ",selfOpenId=" + this.selfOpenId + ",peerTinyId=" + this.peerTinyId + ",peerRoleId=" + this.peerRoleId + ",peerOpenId=" + this.peerOpenId + ",pushWindowFlag=" + this.pushWindowFlag + ",sayHiType=" + this.sayHiType + ",redPointSwitch=" + this.redPointSwitch + ",seekingPartner=" + this.seekingPartner + ",}";
    }

    public TempChatGameSession(long j3, String str, long j16, String str2, String str3, long j17, String str4, String str5, Integer num, Integer num2, Integer num3, Integer num4) {
        this.gameAppId = j3;
        this.nickname = str;
        this.selfTinyId = j16;
        this.selfRoleId = str2;
        this.selfOpenId = str3;
        this.peerTinyId = j17;
        this.peerRoleId = str4;
        this.peerOpenId = str5;
        this.pushWindowFlag = num;
        this.sayHiType = num2;
        this.redPointSwitch = num3;
        this.seekingPartner = num4;
    }
}
