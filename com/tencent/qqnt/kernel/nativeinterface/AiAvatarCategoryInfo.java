package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiAvatarCategoryInfo {
    public String categoryInfoId = "";
    public String categoryInfoName = "";
    public String thumbUrl = "";
    public ArrayList<AiAvatarSubCategoryInfo> subCategoryInfos = new ArrayList<>();
    public ArrayList<AiAvatarAdditionalEntry> dynamicFields = new ArrayList<>();

    public String getCategoryInfoId() {
        return this.categoryInfoId;
    }

    public String getCategoryInfoName() {
        return this.categoryInfoName;
    }

    public ArrayList<AiAvatarAdditionalEntry> getDynamicFields() {
        return this.dynamicFields;
    }

    public ArrayList<AiAvatarSubCategoryInfo> getSubCategoryInfos() {
        return this.subCategoryInfos;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String toString() {
        return "AiAvatarCategoryInfo{categoryInfoId=" + this.categoryInfoId + ",categoryInfoName=" + this.categoryInfoName + ",thumbUrl=" + this.thumbUrl + ",subCategoryInfos=" + this.subCategoryInfos + ",dynamicFields=" + this.dynamicFields + ",}";
    }
}
