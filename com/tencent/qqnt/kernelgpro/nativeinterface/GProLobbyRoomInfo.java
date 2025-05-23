package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProLobbyRoomInfo implements Serializable {
    public GProLobbyAppInfo lobbyAppInfo;
    public GProLobbyStateInfo lobbyStateInfo;
    long serialVersionUID;

    public GProLobbyRoomInfo() {
        this.serialVersionUID = 1L;
        this.lobbyStateInfo = new GProLobbyStateInfo();
        this.lobbyAppInfo = new GProLobbyAppInfo();
    }

    public GProLobbyAppInfo getLobbyAppInfo() {
        return this.lobbyAppInfo;
    }

    public GProLobbyStateInfo getLobbyStateInfo() {
        return this.lobbyStateInfo;
    }

    public String toString() {
        return "GProLobbyRoomInfo{lobbyStateInfo=" + this.lobbyStateInfo + ",lobbyAppInfo=" + this.lobbyAppInfo + ",}";
    }

    public GProLobbyRoomInfo(GProLobbyStateInfo gProLobbyStateInfo, GProLobbyAppInfo gProLobbyAppInfo) {
        this.serialVersionUID = 1L;
        this.lobbyStateInfo = new GProLobbyStateInfo();
        new GProLobbyAppInfo();
        this.lobbyStateInfo = gProLobbyStateInfo;
        this.lobbyAppInfo = gProLobbyAppInfo;
    }
}
