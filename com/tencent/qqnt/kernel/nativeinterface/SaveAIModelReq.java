package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SaveAIModelReq {
    public String modelId = "";
    public String uid = "";
    public ArrayList<String> buttonIds = new ArrayList<>();
    public ArrayList<String> unSelectedbtnIds = new ArrayList<>();

    public ArrayList<String> getButtonIds() {
        return this.buttonIds;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getUid() {
        return this.uid;
    }

    public ArrayList<String> getUnSelectedbtnIds() {
        return this.unSelectedbtnIds;
    }

    public String toString() {
        return "SaveAIModelReq{modelId=" + this.modelId + ",uid=" + this.uid + ",buttonIds=" + this.buttonIds + ",unSelectedbtnIds=" + this.unSelectedbtnIds + ",}";
    }
}
