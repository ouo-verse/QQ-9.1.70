package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GiphyElement {
    public int height;

    /* renamed from: id, reason: collision with root package name */
    public String f359177id;
    public boolean isClip;
    public int width;

    public GiphyElement() {
        this.f359177id = "";
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f359177id;
    }

    public boolean getIsClip() {
        return this.isClip;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GiphyElement{id=" + this.f359177id + ",isClip=" + this.isClip + ",width=" + this.width + ",height=" + this.height + ",}";
    }

    public GiphyElement(String str, boolean z16, int i3, int i16) {
        this.f359177id = str;
        this.isClip = z16;
        this.width = i3;
        this.height = i16;
    }
}
