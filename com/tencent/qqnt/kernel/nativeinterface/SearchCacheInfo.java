package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchCacheInfo {
    public ArrayList<String> fields;

    /* renamed from: id, reason: collision with root package name */
    public String f359212id;

    public SearchCacheInfo() {
        this.f359212id = "";
        this.fields = new ArrayList<>();
    }

    public ArrayList<String> getFields() {
        return this.fields;
    }

    public String getId() {
        return this.f359212id;
    }

    public String toString() {
        return "SearchCacheInfo{id=" + this.f359212id + ",fields=" + this.fields + ",}";
    }

    public SearchCacheInfo(String str, ArrayList<String> arrayList) {
        this.f359212id = "";
        new ArrayList();
        this.f359212id = str;
        this.fields = arrayList;
    }
}
