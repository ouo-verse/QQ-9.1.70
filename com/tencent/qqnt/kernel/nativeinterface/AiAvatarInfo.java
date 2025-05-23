package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiAvatarInfo {
    public ArrayList<AiGenPicInfo> picInfoList = new ArrayList<>();

    public ArrayList<AiGenPicInfo> getPicInfoList() {
        return this.picInfoList;
    }

    public String toString() {
        return "AiAvatarInfo{picInfoList=" + this.picInfoList + ",}";
    }
}
