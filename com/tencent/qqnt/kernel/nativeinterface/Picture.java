package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class Picture {

    /* renamed from: id, reason: collision with root package name */
    public String f359200id = "";
    public ArrayList<URL> urls = new ArrayList<>();
    public String localCachePath = "";

    public String getId() {
        return this.f359200id;
    }

    public String getLocalCachePath() {
        return this.localCachePath;
    }

    public ArrayList<URL> getUrls() {
        return this.urls;
    }
}
