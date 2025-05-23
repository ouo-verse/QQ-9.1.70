package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPlusPanelBotFeature {
    public GProBotInfo botInfo;
    public GProBotFeatureInfo commandInfo;
    public String elementId;
    public String icon;
    public GProBotFeatureInfo serviceInfo;
    public String serviceName;

    public GProPlusPanelBotFeature() {
        this.botInfo = new GProBotInfo();
        this.serviceInfo = new GProBotFeatureInfo();
        this.commandInfo = new GProBotFeatureInfo();
        this.icon = "";
        this.serviceName = "";
        this.elementId = "";
    }

    public GProBotInfo getBotInfo() {
        return this.botInfo;
    }

    public GProBotFeatureInfo getCommandInfo() {
        return this.commandInfo;
    }

    public String getElementId() {
        return this.elementId;
    }

    public String getIcon() {
        return this.icon;
    }

    public GProBotFeatureInfo getServiceInfo() {
        return this.serviceInfo;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String toString() {
        return "GProPlusPanelBotFeature{botInfo=" + this.botInfo + ",serviceInfo=" + this.serviceInfo + ",commandInfo=" + this.commandInfo + ",icon=" + this.icon + ",serviceName=" + this.serviceName + ",elementId=" + this.elementId + ",}";
    }

    public GProPlusPanelBotFeature(GProBotInfo gProBotInfo, GProBotFeatureInfo gProBotFeatureInfo, GProBotFeatureInfo gProBotFeatureInfo2, String str, String str2, String str3) {
        this.botInfo = new GProBotInfo();
        this.serviceInfo = new GProBotFeatureInfo();
        new GProBotFeatureInfo();
        this.botInfo = gProBotInfo;
        this.serviceInfo = gProBotFeatureInfo;
        this.commandInfo = gProBotFeatureInfo2;
        this.icon = str;
        this.serviceName = str2;
        this.elementId = str3;
    }
}
