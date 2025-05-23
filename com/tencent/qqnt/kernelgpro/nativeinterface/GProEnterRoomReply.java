package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProEnterRoomReply {
    public String dispersionUrl;
    public Boolean isBigRoom;
    public GProLiveEnterRoomInfo roomInfo;
    public GProAvInfo sdkInfo;
    public Integer useDispersion;
    public Integer userRole;

    public String getDispersionUrl() {
        return this.dispersionUrl;
    }

    public Boolean getIsBigRoom() {
        return this.isBigRoom;
    }

    public GProLiveEnterRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public GProAvInfo getSdkInfo() {
        return this.sdkInfo;
    }

    public Integer getUseDispersion() {
        return this.useDispersion;
    }

    public Integer getUserRole() {
        return this.userRole;
    }

    public String toString() {
        return "GProEnterRoomReply{isBigRoom=" + this.isBigRoom + ",useDispersion=" + this.useDispersion + ",dispersionUrl=" + this.dispersionUrl + ",roomInfo=" + this.roomInfo + ",userRole=" + this.userRole + ",sdkInfo=" + this.sdkInfo + ",}";
    }
}
