package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameRoomStateInfo implements Serializable {
    public GProVoiceSmobaGameCaptainUserInfo captainInfo;
    public long captainTinyId;
    public long currentNum;
    public GProVoiceSmobaGameGameStaticInfo gameInfo;
    public long gameStartTime;
    public long roomId;
    public int roomState;
    public int roomType;
    long serialVersionUID;

    public GProVoiceSmobaGameRoomStateInfo() {
        this.serialVersionUID = 1L;
        this.gameInfo = new GProVoiceSmobaGameGameStaticInfo();
        this.captainInfo = new GProVoiceSmobaGameCaptainUserInfo();
    }

    public GProVoiceSmobaGameCaptainUserInfo getCaptainInfo() {
        return this.captainInfo;
    }

    public long getCaptainTinyId() {
        return this.captainTinyId;
    }

    public long getCurrentNum() {
        return this.currentNum;
    }

    public GProVoiceSmobaGameGameStaticInfo getGameInfo() {
        return this.gameInfo;
    }

    public long getGameStartTime() {
        return this.gameStartTime;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public int getRoomState() {
        return this.roomState;
    }

    public int getRoomType() {
        return this.roomType;
    }

    public String toString() {
        return "GProVoiceSmobaGameRoomStateInfo{roomId=" + this.roomId + ",roomType=" + this.roomType + ",gameInfo=" + this.gameInfo + ",roomState=" + this.roomState + ",gameStartTime=" + this.gameStartTime + ",currentNum=" + this.currentNum + ",captainTinyId=" + this.captainTinyId + ",captainInfo=" + this.captainInfo + ",}";
    }

    public GProVoiceSmobaGameRoomStateInfo(long j3, int i3, GProVoiceSmobaGameGameStaticInfo gProVoiceSmobaGameGameStaticInfo, int i16, long j16, long j17, long j18, GProVoiceSmobaGameCaptainUserInfo gProVoiceSmobaGameCaptainUserInfo) {
        this.serialVersionUID = 1L;
        this.gameInfo = new GProVoiceSmobaGameGameStaticInfo();
        new GProVoiceSmobaGameCaptainUserInfo();
        this.roomId = j3;
        this.roomType = i3;
        this.gameInfo = gProVoiceSmobaGameGameStaticInfo;
        this.roomState = i16;
        this.gameStartTime = j16;
        this.currentNum = j17;
        this.captainTinyId = j18;
        this.captainInfo = gProVoiceSmobaGameCaptainUserInfo;
    }
}
