package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiAvatarSubCategoryInfo {
    public int subCategoryInfoType;
    public String subCategoryInfoId = "";
    public byte[] subCategoryBody = new byte[0];

    public byte[] getSubCategoryBody() {
        return this.subCategoryBody;
    }

    public String getSubCategoryInfoId() {
        return this.subCategoryInfoId;
    }

    public int getSubCategoryInfoType() {
        return this.subCategoryInfoType;
    }

    public String toString() {
        return "AiAvatarSubCategoryInfo{subCategoryInfoType=" + this.subCategoryInfoType + ",subCategoryInfoId=" + this.subCategoryInfoId + ",subCategoryBody=" + this.subCategoryBody + ",}";
    }
}
