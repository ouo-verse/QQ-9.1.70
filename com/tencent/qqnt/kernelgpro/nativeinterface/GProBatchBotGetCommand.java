package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBatchBotGetCommand {
    public long channelId;
    public GProBotClientInfo clientInfo;
    public long filter;
    public long guildId;
    public int num;
    public int page;
    public long scene;
    public ArrayList<Long> tinyIds;
    public ArrayList<Long> uins;

    public GProBatchBotGetCommand() {
        this.uins = new ArrayList<>();
        this.tinyIds = new ArrayList<>();
        this.clientInfo = new GProBotClientInfo();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProBotClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public long getFilter() {
        return this.filter;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getNum() {
        return this.num;
    }

    public int getPage() {
        return this.page;
    }

    public long getScene() {
        return this.scene;
    }

    public ArrayList<Long> getTinyIds() {
        return this.tinyIds;
    }

    public ArrayList<Long> getUins() {
        return this.uins;
    }

    public String toString() {
        return "GProBatchBotGetCommand{uins=" + this.uins + ",tinyIds=" + this.tinyIds + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",clientInfo=" + this.clientInfo + ",num=" + this.num + ",page=" + this.page + ",scene=" + this.scene + ",filter=" + this.filter + ",}";
    }

    public GProBatchBotGetCommand(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, long j3, long j16, GProBotClientInfo gProBotClientInfo, int i3, int i16, long j17, long j18) {
        this.uins = new ArrayList<>();
        this.tinyIds = new ArrayList<>();
        new GProBotClientInfo();
        this.uins = arrayList;
        this.tinyIds = arrayList2;
        this.guildId = j3;
        this.channelId = j16;
        this.clientInfo = gProBotClientInfo;
        this.num = i3;
        this.page = i16;
        this.scene = j17;
        this.filter = j18;
    }
}
