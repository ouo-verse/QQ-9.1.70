package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CreatorIdentity {
    public int creatorIdentityType;
    public String icon = "";
    public String jumpUrl = "";
    public String smallIcon = "";

    public int getCreatorIdentityType() {
        return this.creatorIdentityType;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getSmallIcon() {
        return this.smallIcon;
    }

    public String toString() {
        return "CreatorIdentity{creatorIdentityType=" + this.creatorIdentityType + ",icon=" + this.icon + ",jumpUrl=" + this.jumpUrl + ",smallIcon=" + this.smallIcon + ",}";
    }
}
