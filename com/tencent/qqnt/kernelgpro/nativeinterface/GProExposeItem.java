package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProExposeItem {
    public GProItemCbData callback;

    /* renamed from: id, reason: collision with root package name */
    public String f359288id;

    public GProExposeItem() {
        this.f359288id = "";
        this.callback = new GProItemCbData();
    }

    public GProItemCbData getCallback() {
        return this.callback;
    }

    public String getId() {
        return this.f359288id;
    }

    public void setCallback(GProItemCbData gProItemCbData) {
        this.callback = gProItemCbData;
    }

    public void setId(String str) {
        this.f359288id = str;
    }

    public String toString() {
        return "GProExposeItem{id=" + this.f359288id + ",callback=" + this.callback + ",}";
    }

    public GProExposeItem(String str, GProItemCbData gProItemCbData) {
        this.f359288id = "";
        new GProItemCbData();
        this.f359288id = str;
        this.callback = gProItemCbData;
    }
}
