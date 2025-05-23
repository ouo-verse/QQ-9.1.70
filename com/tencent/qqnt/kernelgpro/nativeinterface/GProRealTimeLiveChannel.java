package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRealTimeLiveChannel {
    public GProLiveRoomInfo roomInfo;

    public GProRealTimeLiveChannel() {
        this.roomInfo = new GProLiveRoomInfo();
    }

    public GProLiveRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public String toString() {
        return "GProRealTimeLiveChannel{roomInfo=" + this.roomInfo + ",}";
    }

    public GProRealTimeLiveChannel(GProLiveRoomInfo gProLiveRoomInfo) {
        new GProLiveRoomInfo();
        this.roomInfo = gProLiveRoomInfo;
    }
}
