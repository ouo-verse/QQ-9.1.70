package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGameModesResult {

    /* renamed from: id, reason: collision with root package name */
    public String f359289id;
    public String image;
    public String name;

    public GProGameModesResult() {
        this.f359289id = "";
        this.name = "";
        this.image = "";
    }

    public String getId() {
        return this.f359289id;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProGameModesResult{id=" + this.f359289id + ",name=" + this.name + ",image=" + this.image + ",}";
    }

    public GProGameModesResult(String str, String str2, String str3) {
        this.f359289id = str;
        this.name = str2;
        this.image = str3;
    }
}
