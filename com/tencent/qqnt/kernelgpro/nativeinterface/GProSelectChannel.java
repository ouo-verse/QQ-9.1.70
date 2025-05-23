package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSelectChannel {
    public ArrayList<Long> guildIds;
    public String labelName;

    public GProSelectChannel() {
        this.labelName = "";
        this.guildIds = new ArrayList<>();
    }

    public ArrayList<Long> getGuildIds() {
        return this.guildIds;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void setGuildIds(ArrayList<Long> arrayList) {
        this.guildIds = arrayList;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String toString() {
        return "GProSelectChannel{labelName=" + this.labelName + ",guildIds=" + this.guildIds + ",}";
    }

    public GProSelectChannel(String str, ArrayList<Long> arrayList) {
        this.labelName = "";
        new ArrayList();
        this.labelName = str;
        this.guildIds = arrayList;
    }
}
