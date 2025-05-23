package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OSLikeItem {
    public OSLikeExtInfo extInfo;
    public int likeType;

    public OSLikeItem() {
    }

    public OSLikeExtInfo getExtInfo() {
        return this.extInfo;
    }

    public int getLikeType() {
        return this.likeType;
    }

    public String toString() {
        return "OSLikeItem{likeType=" + this.likeType + ",extInfo=" + this.extInfo + ",}";
    }

    public OSLikeItem(int i3, OSLikeExtInfo oSLikeExtInfo) {
        this.likeType = i3;
        this.extInfo = oSLikeExtInfo;
    }
}
