package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProItemIdInfo implements Serializable {
    public long channelId;
    public long guildId;
    public long itemIdI64;
    public String itemIdStr;
    public int itemType;
    public String originId;
    long serialVersionUID;

    public GProItemIdInfo() {
        this.serialVersionUID = 1L;
        this.itemIdStr = "";
        this.originId = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getItemIdI64() {
        return this.itemIdI64;
    }

    public String getItemIdStr() {
        return this.itemIdStr;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getOriginId() {
        return this.originId;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setItemIdI64(long j3) {
        this.itemIdI64 = j3;
    }

    public void setItemIdStr(String str) {
        this.itemIdStr = str;
    }

    public void setItemType(int i3) {
        this.itemType = i3;
    }

    public void setOriginId(String str) {
        this.originId = str;
    }

    public String toString() {
        return "GProItemIdInfo{itemIdStr=" + this.itemIdStr + ",itemIdI64=" + this.itemIdI64 + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",itemType=" + this.itemType + ",originId=" + this.originId + ",}";
    }

    public GProItemIdInfo(String str, long j3, long j16, long j17, int i3, String str2) {
        this.serialVersionUID = 1L;
        this.itemIdStr = str;
        this.itemIdI64 = j3;
        this.guildId = j16;
        this.channelId = j17;
        this.itemType = i3;
        this.originId = str2;
    }
}
