package org.light.lightAssetKit.enums;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum SmoothSharpenType {
    SharpenDefault(0, "SharpenDefault"),
    HighPass(1, "HighPass");

    public String name;
    public int value;

    SmoothSharpenType(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
