package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUserFreeGiftReq implements Serializable {
    public long channelId;
    public String checkContext;
    public long guildId;
    long serialVersionUID;
    public ArrayList<Integer> themeTypes;

    public GProUserFreeGiftReq() {
        this.serialVersionUID = 1L;
        this.checkContext = "";
        this.themeTypes = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getCheckContext() {
        return this.checkContext;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<Integer> getThemeTypes() {
        return this.themeTypes;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setCheckContext(String str) {
        this.checkContext = str;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setThemeTypes(ArrayList<Integer> arrayList) {
        this.themeTypes = arrayList;
    }

    public String toString() {
        return "GProUserFreeGiftReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",checkContext=" + this.checkContext + ",themeTypes=" + this.themeTypes + ",}";
    }

    public GProUserFreeGiftReq(long j3, long j16, String str, ArrayList<Integer> arrayList) {
        this.serialVersionUID = 1L;
        this.checkContext = "";
        new ArrayList();
        this.guildId = j3;
        this.channelId = j16;
        this.checkContext = str;
        this.themeTypes = arrayList;
    }
}
