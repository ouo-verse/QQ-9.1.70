package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDecorateJumpInfo {
    public int jumpType;
    public String name = "";
    public String decorateDescription = "";
    public String activityUrl = "";

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String getDecorateDescription() {
        return this.decorateDescription;
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "UfsDecorateJumpInfo{name=" + this.name + ",decorateDescription=" + this.decorateDescription + ",activityUrl=" + this.activityUrl + ",jumpType=" + this.jumpType + ",}";
    }
}
