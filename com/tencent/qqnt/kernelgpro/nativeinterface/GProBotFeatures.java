package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBotFeatures {
    public GProBotInfo botInfo;
    public ArrayList<GProBotFeatureInfo> commandInfos;
    public ArrayList<GProBotFeatureInfo> serviceInfos;

    public GProBotFeatures() {
        this.botInfo = new GProBotInfo();
        this.serviceInfos = new ArrayList<>();
        this.commandInfos = new ArrayList<>();
    }

    public GProBotInfo getBotInfo() {
        return this.botInfo;
    }

    public ArrayList<GProBotFeatureInfo> getCommandInfos() {
        return this.commandInfos;
    }

    public ArrayList<GProBotFeatureInfo> getServiceInfos() {
        return this.serviceInfos;
    }

    public String toString() {
        return "GProBotFeatures{botInfo=" + this.botInfo + ",serviceInfos=" + this.serviceInfos + ",commandInfos=" + this.commandInfos + ",}";
    }

    public GProBotFeatures(GProBotInfo gProBotInfo, ArrayList<GProBotFeatureInfo> arrayList, ArrayList<GProBotFeatureInfo> arrayList2) {
        this.botInfo = new GProBotInfo();
        this.serviceInfos = new ArrayList<>();
        new ArrayList();
        this.botInfo = gProBotInfo;
        this.serviceInfos = arrayList;
        this.commandInfos = arrayList2;
    }
}
