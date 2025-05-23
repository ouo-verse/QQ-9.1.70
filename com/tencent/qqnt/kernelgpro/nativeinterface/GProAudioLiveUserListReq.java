package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAudioLiveUserListReq {
    public long channelId;
    public long guildId;
    public boolean needChannelState;
    public byte[] needDecodeData;
    public int numIndex;
    public int onceGetNum;
    public boolean onlyHandUpList;
    public boolean onlySpeakOrderList;

    public GProAudioLiveUserListReq() {
        this.needDecodeData = new byte[0];
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getNeedChannelState() {
        return this.needChannelState;
    }

    public byte[] getNeedDecodeData() {
        return this.needDecodeData;
    }

    public int getNumIndex() {
        return this.numIndex;
    }

    public int getOnceGetNum() {
        return this.onceGetNum;
    }

    public boolean getOnlyHandUpList() {
        return this.onlyHandUpList;
    }

    public boolean getOnlySpeakOrderList() {
        return this.onlySpeakOrderList;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setNeedChannelState(boolean z16) {
        this.needChannelState = z16;
    }

    public void setNeedDecodeData(byte[] bArr) {
        this.needDecodeData = bArr;
    }

    public void setNumIndex(int i3) {
        this.numIndex = i3;
    }

    public void setOnceGetNum(int i3) {
        this.onceGetNum = i3;
    }

    public void setOnlyHandUpList(boolean z16) {
        this.onlyHandUpList = z16;
    }

    public void setOnlySpeakOrderList(boolean z16) {
        this.onlySpeakOrderList = z16;
    }

    public String toString() {
        return "GProAudioLiveUserListReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",onceGetNum=" + this.onceGetNum + ",needChannelState=" + this.needChannelState + ",onlyHandUpList=" + this.onlyHandUpList + ",onlySpeakOrderList=" + this.onlySpeakOrderList + ",numIndex=" + this.numIndex + ",needDecodeData=" + this.needDecodeData + ",}";
    }

    public GProAudioLiveUserListReq(long j3, long j16, int i3, boolean z16, boolean z17, boolean z18, int i16, byte[] bArr) {
        this.guildId = j3;
        this.channelId = j16;
        this.onceGetNum = i3;
        this.needChannelState = z16;
        this.onlyHandUpList = z17;
        this.onlySpeakOrderList = z18;
        this.numIndex = i16;
        this.needDecodeData = bArr;
    }
}
