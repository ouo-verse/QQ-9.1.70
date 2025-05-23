package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProLobbyStateInfo implements Serializable {
    public String appId;
    public long channelId;
    public boolean disableVoiceAnimation;
    public ArrayList<GProKVPair> extendDic;
    public long guildId;
    public long leaderTinyId;
    public long lobbyId;
    public int lobbyRoomCapacity;
    public int lobbyRoomCurrUserNum;
    public int lobbyRoomStatus;
    public int lobbyType;
    long serialVersionUID;

    public GProLobbyStateInfo() {
        this.serialVersionUID = 1L;
        this.appId = "";
        this.extendDic = new ArrayList<>();
    }

    public String getAppId() {
        return this.appId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public boolean getDisableVoiceAnimation() {
        return this.disableVoiceAnimation;
    }

    public ArrayList<GProKVPair> getExtendDic() {
        return this.extendDic;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getLeaderTinyId() {
        return this.leaderTinyId;
    }

    public long getLobbyId() {
        return this.lobbyId;
    }

    public int getLobbyRoomCapacity() {
        return this.lobbyRoomCapacity;
    }

    public int getLobbyRoomCurrUserNum() {
        return this.lobbyRoomCurrUserNum;
    }

    public int getLobbyRoomStatus() {
        return this.lobbyRoomStatus;
    }

    public int getLobbyType() {
        return this.lobbyType;
    }

    public String toString() {
        return "GProLobbyStateInfo{lobbyId=" + this.lobbyId + ",appId=" + this.appId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",leaderTinyId=" + this.leaderTinyId + ",lobbyType=" + this.lobbyType + ",lobbyRoomCurrUserNum=" + this.lobbyRoomCurrUserNum + ",lobbyRoomCapacity=" + this.lobbyRoomCapacity + ",lobbyRoomStatus=" + this.lobbyRoomStatus + ",extendDic=" + this.extendDic + ",disableVoiceAnimation=" + this.disableVoiceAnimation + ",}";
    }

    public GProLobbyStateInfo(long j3, String str, long j16, long j17, long j18, int i3, int i16, int i17, int i18, ArrayList<GProKVPair> arrayList, boolean z16) {
        this.serialVersionUID = 1L;
        this.appId = "";
        new ArrayList();
        this.lobbyId = j3;
        this.appId = str;
        this.guildId = j16;
        this.channelId = j17;
        this.leaderTinyId = j18;
        this.lobbyType = i3;
        this.lobbyRoomCurrUserNum = i16;
        this.lobbyRoomCapacity = i17;
        this.lobbyRoomStatus = i18;
        this.extendDic = arrayList;
        this.disableVoiceAnimation = z16;
    }
}
