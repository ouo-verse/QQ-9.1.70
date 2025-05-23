package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAVRoomAddUpInfo {
    public GProAVDevOptInfo avDevOpt;
    public int micVolume;
    public String roomId;

    public GProAVRoomAddUpInfo() {
        this.roomId = "";
        this.avDevOpt = new GProAVDevOptInfo();
    }

    public GProAVDevOptInfo getAvDevOpt() {
        return this.avDevOpt;
    }

    public int getMicVolume() {
        return this.micVolume;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProAVRoomAddUpInfo{roomId=" + this.roomId + ",avDevOpt=" + this.avDevOpt + ",micVolume=" + this.micVolume + ",}";
    }

    public GProAVRoomAddUpInfo(String str, GProAVDevOptInfo gProAVDevOptInfo, int i3) {
        this.roomId = "";
        new GProAVDevOptInfo();
        this.roomId = str;
        this.avDevOpt = gProAVDevOptInfo;
        this.micVolume = i3;
    }
}
