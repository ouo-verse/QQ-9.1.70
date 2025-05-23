package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCreateLobbyRsp {
    public GProLobbyRoomInfo lobbyRoomInfo;

    public GProCreateLobbyRsp() {
        this.lobbyRoomInfo = new GProLobbyRoomInfo();
    }

    public GProLobbyRoomInfo getLobbyRoomInfo() {
        return this.lobbyRoomInfo;
    }

    public String toString() {
        return "GProCreateLobbyRsp{lobbyRoomInfo=" + this.lobbyRoomInfo + ",}";
    }

    public GProCreateLobbyRsp(GProLobbyRoomInfo gProLobbyRoomInfo) {
        new GProLobbyRoomInfo();
        this.lobbyRoomInfo = gProLobbyRoomInfo;
    }
}
