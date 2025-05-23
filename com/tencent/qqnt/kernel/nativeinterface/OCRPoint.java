package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class OCRPoint {

    /* renamed from: x, reason: collision with root package name */
    public String f359195x;

    /* renamed from: y, reason: collision with root package name */
    public String f359196y;

    public OCRPoint() {
        this.f359195x = "";
        this.f359196y = "";
    }

    public String getX() {
        return this.f359195x;
    }

    public String getY() {
        return this.f359196y;
    }

    public String toString() {
        return "OCRPoint{x=" + this.f359195x + ",y=" + this.f359196y + ",}";
    }

    public OCRPoint(String str, String str2) {
        this.f359195x = str;
        this.f359196y = str2;
    }
}
