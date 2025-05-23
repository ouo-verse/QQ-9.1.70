package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAVRoomCtrlOptInfo implements Serializable {
    public GProAVDevOptInfo devOpt;
    public boolean isCurrentRoom;
    public int micVolume;
    public int numRoomId;
    public String privateMapKey;
    public String roomId;
    public int sdkAppId;
    long serialVersionUID;

    public GProAVRoomCtrlOptInfo() {
        this.serialVersionUID = 1L;
        this.roomId = "";
        this.devOpt = new GProAVDevOptInfo();
        this.privateMapKey = "";
    }

    public GProAVDevOptInfo getDevOpt() {
        return this.devOpt;
    }

    public boolean getIsCurrentRoom() {
        return this.isCurrentRoom;
    }

    public int getMicVolume() {
        return this.micVolume;
    }

    public int getNumRoomId() {
        return this.numRoomId;
    }

    public String getPrivateMapKey() {
        return this.privateMapKey;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getSdkAppId() {
        return this.sdkAppId;
    }

    public String toString() {
        return "GProAVRoomCtrlOptInfo{roomId=" + this.roomId + ",numRoomId=" + this.numRoomId + ",devOpt=" + this.devOpt + ",micVolume=" + this.micVolume + ",isCurrentRoom=" + this.isCurrentRoom + ",sdkAppId=" + this.sdkAppId + ",privateMapKey=" + this.privateMapKey + ",}";
    }

    public GProAVRoomCtrlOptInfo(String str, int i3, GProAVDevOptInfo gProAVDevOptInfo, int i16, boolean z16, int i17, String str2) {
        this.serialVersionUID = 1L;
        this.roomId = "";
        new GProAVDevOptInfo();
        this.roomId = str;
        this.numRoomId = i3;
        this.devOpt = gProAVDevOptInfo;
        this.micVolume = i16;
        this.isCurrentRoom = z16;
        this.sdkAppId = i17;
        this.privateMapKey = str2;
    }
}
