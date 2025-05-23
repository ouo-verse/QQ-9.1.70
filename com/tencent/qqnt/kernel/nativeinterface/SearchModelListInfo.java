package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchModelListInfo {
    public boolean choose;
    public ArrayList<SearchModelInfo> modelInfos = new ArrayList<>();

    public boolean getChoose() {
        return this.choose;
    }

    public ArrayList<SearchModelInfo> getModelInfos() {
        return this.modelInfos;
    }

    public String toString() {
        return "SearchModelListInfo{choose=" + this.choose + ",modelInfos=" + this.modelInfos + ",}";
    }
}
