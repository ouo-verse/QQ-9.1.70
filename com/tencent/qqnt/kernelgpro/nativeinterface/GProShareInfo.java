package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProShareInfo {
    public int plat;
    public int target;
    public String busiId = "";
    public String resourceId = "";
    public String stringTemplate = "";
    public byte[] busiData = new byte[0];

    public byte[] getBusiData() {
        return this.busiData;
    }

    public String getBusiId() {
        return this.busiId;
    }

    public int getPlat() {
        return this.plat;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getStringTemplate() {
        return this.stringTemplate;
    }

    public int getTarget() {
        return this.target;
    }

    public String toString() {
        return "GProShareInfo{busiId=" + this.busiId + ",resourceId=" + this.resourceId + ",stringTemplate=" + this.stringTemplate + ",busiData=" + this.busiData + ",plat=" + this.plat + ",target=" + this.target + ",}";
    }
}
