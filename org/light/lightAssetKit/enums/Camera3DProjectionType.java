package org.light.lightAssetKit.enums;

/* loaded from: classes29.dex */
public enum Camera3DProjectionType {
    PERSPECTIVE(0, "perspective"),
    ORTHOGRAPHIC(1, "orthographic");

    public String name;
    public int value;

    Camera3DProjectionType(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
