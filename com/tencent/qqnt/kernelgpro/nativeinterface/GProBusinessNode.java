package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProBusinessNode implements Serializable {
    public long dataVersion;
    public long expiresMs;
    public GProLobbyRoomInfo lobbyRoomInfo;
    public int mutexType;
    public byte[] nodeData;
    public int nodeType;
    public GProPlayInfo playInfo;
    public GProVoiceSmobaGameRoomStateInfo roomStateInfo;
    public GProVoiceInfo screenShareInfo;
    long serialVersionUID;

    public GProBusinessNode() {
        this.serialVersionUID = 1L;
        this.nodeData = new byte[0];
        this.roomStateInfo = new GProVoiceSmobaGameRoomStateInfo();
        this.screenShareInfo = new GProVoiceInfo();
        this.playInfo = new GProPlayInfo();
        this.lobbyRoomInfo = new GProLobbyRoomInfo();
    }

    public long getDataVersion() {
        return this.dataVersion;
    }

    public long getExpiresMs() {
        return this.expiresMs;
    }

    public GProLobbyRoomInfo getLobbyRoomInfo() {
        return this.lobbyRoomInfo;
    }

    public int getMutexType() {
        return this.mutexType;
    }

    public byte[] getNodeData() {
        return this.nodeData;
    }

    public int getNodeType() {
        return this.nodeType;
    }

    public GProPlayInfo getPlayInfo() {
        return this.playInfo;
    }

    public GProVoiceSmobaGameRoomStateInfo getRoomStateInfo() {
        return this.roomStateInfo;
    }

    public GProVoiceInfo getScreenShareInfo() {
        return this.screenShareInfo;
    }

    public String toString() {
        return "GProBusinessNode{mutexType=" + this.mutexType + ",nodeType=" + this.nodeType + ",nodeData=" + this.nodeData + ",dataVersion=" + this.dataVersion + ",expiresMs=" + this.expiresMs + ",roomStateInfo=" + this.roomStateInfo + ",screenShareInfo=" + this.screenShareInfo + ",playInfo=" + this.playInfo + ",lobbyRoomInfo=" + this.lobbyRoomInfo + ",}";
    }

    public GProBusinessNode(int i3, int i16, byte[] bArr, long j3, long j16, GProVoiceSmobaGameRoomStateInfo gProVoiceSmobaGameRoomStateInfo, GProVoiceInfo gProVoiceInfo, GProPlayInfo gProPlayInfo, GProLobbyRoomInfo gProLobbyRoomInfo) {
        this.serialVersionUID = 1L;
        this.nodeData = new byte[0];
        this.roomStateInfo = new GProVoiceSmobaGameRoomStateInfo();
        this.screenShareInfo = new GProVoiceInfo();
        this.playInfo = new GProPlayInfo();
        new GProLobbyRoomInfo();
        this.mutexType = i3;
        this.nodeType = i16;
        this.nodeData = bArr;
        this.dataVersion = j3;
        this.expiresMs = j16;
        this.roomStateInfo = gProVoiceSmobaGameRoomStateInfo;
        this.screenShareInfo = gProVoiceInfo;
        this.playInfo = gProPlayInfo;
        this.lobbyRoomInfo = gProLobbyRoomInfo;
    }
}
