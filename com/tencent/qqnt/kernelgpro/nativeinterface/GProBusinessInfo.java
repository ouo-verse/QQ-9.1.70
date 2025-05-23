package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProBusinessInfo implements Serializable {
    public long sortKey;
    long serialVersionUID = 1;
    public GProMemberInfoInGame memberInfoInGame = new GProMemberInfoInGame();
    public GProUserAVInfo userAVInfo = new GProUserAVInfo();
    public GProRobotStateInfo robotStateInfo = new GProRobotStateInfo();
    public String tipsMsg = "";
    public GProUserListGroupInfo userListGroupInfo = new GProUserListGroupInfo();
    public GProUserChannelShowState userChannelState = new GProUserChannelShowState();
    public GProLobbyMemberInfo lobbyMemberInfo = new GProLobbyMemberInfo();

    public GProLobbyMemberInfo getLobbyMemberInfo() {
        return this.lobbyMemberInfo;
    }

    public GProMemberInfoInGame getMemberInfoInGame() {
        return this.memberInfoInGame;
    }

    public GProRobotStateInfo getRobotStateInfo() {
        return this.robotStateInfo;
    }

    public long getSortKey() {
        return this.sortKey;
    }

    public String getTipsMsg() {
        return this.tipsMsg;
    }

    public GProUserAVInfo getUserAVInfo() {
        return this.userAVInfo;
    }

    public GProUserChannelShowState getUserChannelState() {
        return this.userChannelState;
    }

    public GProUserListGroupInfo getUserListGroupInfo() {
        return this.userListGroupInfo;
    }

    public void setLobbyMemberInfo(GProLobbyMemberInfo gProLobbyMemberInfo) {
        this.lobbyMemberInfo = gProLobbyMemberInfo;
    }

    public void setMemberInfoInGame(GProMemberInfoInGame gProMemberInfoInGame) {
        this.memberInfoInGame = gProMemberInfoInGame;
    }

    public void setRobotStateInfo(GProRobotStateInfo gProRobotStateInfo) {
        this.robotStateInfo = gProRobotStateInfo;
    }

    public void setSortKey(long j3) {
        this.sortKey = j3;
    }

    public void setTipsMsg(String str) {
        this.tipsMsg = str;
    }

    public void setUserAVInfo(GProUserAVInfo gProUserAVInfo) {
        this.userAVInfo = gProUserAVInfo;
    }

    public void setUserChannelState(GProUserChannelShowState gProUserChannelShowState) {
        this.userChannelState = gProUserChannelShowState;
    }

    public void setUserListGroupInfo(GProUserListGroupInfo gProUserListGroupInfo) {
        this.userListGroupInfo = gProUserListGroupInfo;
    }

    public String toString() {
        return "GProBusinessInfo{sortKey=" + this.sortKey + ",memberInfoInGame=" + this.memberInfoInGame + ",userAVInfo=" + this.userAVInfo + ",robotStateInfo=" + this.robotStateInfo + ",tipsMsg=" + this.tipsMsg + ",userListGroupInfo=" + this.userListGroupInfo + ",userChannelState=" + this.userChannelState + ",lobbyMemberInfo=" + this.lobbyMemberInfo + ",}";
    }
}
