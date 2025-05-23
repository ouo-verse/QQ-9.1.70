package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProLobbyRoomInfo;

/* loaded from: classes17.dex */
public class GGProLobbyRoomInfo implements IGProLobbyRoomInfo {
    public final GProLobbyRoomInfo mInfo;

    public GGProLobbyRoomInfo(GProLobbyRoomInfo gProLobbyRoomInfo) {
        this.mInfo = gProLobbyRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyRoomInfo
    public IGProLobbyAppInfo getLobbyAppInfo() {
        return new GGProLobbyAppInfo(this.mInfo.getLobbyAppInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyRoomInfo
    public IGProLobbyStateInfo getLobbyStateInfo() {
        return new GGProLobbyStateInfo(this.mInfo.getLobbyStateInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyRoomInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
