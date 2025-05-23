package org.light.lightAssetKit.enums;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum LipsType {
    Image(0, "Image"),
    Color(1, "Color"),
    Lut(2, "Lut");

    public String name;
    public int value;

    LipsType(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
