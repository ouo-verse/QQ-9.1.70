package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GroupProfileShareInfo {
    public int plat;
    public int target;
    public String busiId = "";
    public String resourceId = "";
    public String templateName = "";
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

    public int getTarget() {
        return this.target;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String toString() {
        return "GroupProfileShareInfo{busiId=" + this.busiId + ",resourceId=" + this.resourceId + ",templateName=" + this.templateName + ",busiData=" + this.busiData + ",plat=" + this.plat + ",target=" + this.target + ",}";
    }
}
