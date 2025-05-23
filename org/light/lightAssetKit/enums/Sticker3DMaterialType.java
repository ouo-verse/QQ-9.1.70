package org.light.lightAssetKit.enums;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum Sticker3DMaterialType {
    Normal(0, "normal"),
    AR(1, "ar");

    public String name;
    public int value;

    Sticker3DMaterialType(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
