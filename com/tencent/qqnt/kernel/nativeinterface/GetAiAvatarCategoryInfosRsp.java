package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetAiAvatarCategoryInfosRsp {
    public ArrayList<AiAvatarCategoryInfo> categoryInfos = new ArrayList<>();
    public AiAvatarStatusInfo statusInfo = new AiAvatarStatusInfo();
    public int totalCount;

    public ArrayList<AiAvatarCategoryInfo> getCategoryInfos() {
        return this.categoryInfos;
    }

    public AiAvatarStatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public String toString() {
        return "GetAiAvatarCategoryInfosRsp{categoryInfos=" + this.categoryInfos + ",totalCount=" + this.totalCount + ",statusInfo=" + this.statusInfo + ",}";
    }
}
