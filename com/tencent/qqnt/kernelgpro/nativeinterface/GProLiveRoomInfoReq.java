package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProLiveRoomInfoReq {
    public long guildId;
    public ArrayList<Long> channelIdList = new ArrayList<>();
    public ArrayList<Long> liveRoomIdList = new ArrayList<>();
    public byte[] needDecodeData = new byte[0];

    public ArrayList<Long> getChannelIdList() {
        return this.channelIdList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<Long> getLiveRoomIdList() {
        return this.liveRoomIdList;
    }

    public byte[] getNeedDecodeData() {
        return this.needDecodeData;
    }

    public String toString() {
        return "GProLiveRoomInfoReq{guildId=" + this.guildId + ",channelIdList=" + this.channelIdList + ",liveRoomIdList=" + this.liveRoomIdList + ",needDecodeData=" + this.needDecodeData + ",}";
    }
}
