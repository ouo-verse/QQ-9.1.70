package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetLiveAudioPollingInfoReq {
    public ArrayList<Integer> categoryTypeList = new ArrayList<>();
    public long guildId;

    public ArrayList<Integer> getCategoryTypeList() {
        return this.categoryTypeList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGetLiveAudioPollingInfoReq{guildId=" + this.guildId + ",categoryTypeList=" + this.categoryTypeList + ",}";
    }
}
