package org.light.lightAssetKit.enums;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum HairEffectType {
    Image(0, "Image"),
    Lut(1, "Lut"),
    Bleach(2, "Bleach");

    public String name;
    public int value;

    HairEffectType(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
