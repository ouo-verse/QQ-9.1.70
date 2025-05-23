package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SetIdentityInteractionTagReq {
    public long groupId;
    public int interactionTagId;
    public int wearType;

    public long getGroupId() {
        return this.groupId;
    }

    public int getInteractionTagId() {
        return this.interactionTagId;
    }

    public int getWearType() {
        return this.wearType;
    }

    public String toString() {
        return "SetIdentityInteractionTagReq{groupId=" + this.groupId + ",interactionTagId=" + this.interactionTagId + ",wearType=" + this.wearType + ",}";
    }
}
