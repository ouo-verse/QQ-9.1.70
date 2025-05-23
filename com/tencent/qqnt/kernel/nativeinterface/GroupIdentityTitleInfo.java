package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupIdentityTitleInfo {
    public boolean isSet;
    public String titleId = "";
    public String name = "";

    public boolean getIsSet() {
        return this.isSet;
    }

    public String getName() {
        return this.name;
    }

    public String getTitleId() {
        return this.titleId;
    }

    public String toString() {
        return "GroupIdentityTitleInfo{titleId=" + this.titleId + ",name=" + this.name + ",isSet=" + this.isSet + ",}";
    }
}
