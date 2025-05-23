package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckUrlInfo {
    public ArrayList<String> urls;

    public CheckUrlInfo() {
        this.urls = new ArrayList<>();
    }

    public ArrayList<String> getUrls() {
        return this.urls;
    }

    public String toString() {
        return "CheckUrlInfo{urls=" + this.urls + ",}";
    }

    public CheckUrlInfo(ArrayList<String> arrayList) {
        new ArrayList();
        this.urls = arrayList;
    }
}
