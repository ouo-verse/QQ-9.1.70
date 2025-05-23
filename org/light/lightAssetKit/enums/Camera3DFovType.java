package org.light.lightAssetKit.enums;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum Camera3DFovType {
    VERTICAL(0, "vertical"),
    HORIZONTAL(1, "horizontal");

    public String name;
    public int value;

    Camera3DFovType(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
