package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildBottomTabExpData implements Serializable {
    public GProDiscoveryData discoveryData;
    public long expId;
    public String expIndex;
    public boolean isHit;
    long serialVersionUID;
    public int tabType;
    public GProNewUserGuideData userGuideData;

    public GProGuildBottomTabExpData() {
        this.serialVersionUID = 1L;
        this.expIndex = "";
        this.userGuideData = new GProNewUserGuideData();
        this.discoveryData = new GProDiscoveryData();
    }

    public GProDiscoveryData getDiscoveryData() {
        return this.discoveryData;
    }

    public long getExpId() {
        return this.expId;
    }

    public String getExpIndex() {
        return this.expIndex;
    }

    public boolean getIsHit() {
        return this.isHit;
    }

    public int getTabType() {
        return this.tabType;
    }

    public GProNewUserGuideData getUserGuideData() {
        return this.userGuideData;
    }

    public String toString() {
        return "GProGuildBottomTabExpData{isHit=" + this.isHit + ",expId=" + this.expId + ",expIndex=" + this.expIndex + ",tabType=" + this.tabType + ",userGuideData=" + this.userGuideData + ",discoveryData=" + this.discoveryData + ",}";
    }

    public GProGuildBottomTabExpData(boolean z16, long j3, String str, int i3, GProNewUserGuideData gProNewUserGuideData, GProDiscoveryData gProDiscoveryData) {
        this.serialVersionUID = 1L;
        this.expIndex = "";
        this.userGuideData = new GProNewUserGuideData();
        new GProDiscoveryData();
        this.isHit = z16;
        this.expId = j3;
        this.expIndex = str;
        this.tabType = i3;
        this.userGuideData = gProNewUserGuideData;
        this.discoveryData = gProDiscoveryData;
    }
}
