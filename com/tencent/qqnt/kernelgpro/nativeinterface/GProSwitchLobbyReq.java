package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSwitchLobbyReq {
    public GProCreateLobbyReq createLobbyReq;
    public long originLobbyId;

    public GProSwitchLobbyReq() {
        this.createLobbyReq = new GProCreateLobbyReq();
    }

    public GProCreateLobbyReq getCreateLobbyReq() {
        return this.createLobbyReq;
    }

    public long getOriginLobbyId() {
        return this.originLobbyId;
    }

    public void setCreateLobbyReq(GProCreateLobbyReq gProCreateLobbyReq) {
        this.createLobbyReq = gProCreateLobbyReq;
    }

    public void setOriginLobbyId(long j3) {
        this.originLobbyId = j3;
    }

    public String toString() {
        return "GProSwitchLobbyReq{originLobbyId=" + this.originLobbyId + ",createLobbyReq=" + this.createLobbyReq + ",}";
    }

    public GProSwitchLobbyReq(long j3, GProCreateLobbyReq gProCreateLobbyReq) {
        new GProCreateLobbyReq();
        this.originLobbyId = j3;
        this.createLobbyReq = gProCreateLobbyReq;
    }
}
