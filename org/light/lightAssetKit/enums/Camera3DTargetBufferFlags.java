package org.light.lightAssetKit.enums;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum Camera3DTargetBufferFlags {
    NONE(0, "noClear"),
    COLOR(1, "clearColor"),
    DEPTH(2, ""),
    STENCIL(4, ""),
    ALL(7, "");

    public String name;
    public int value;

    Camera3DTargetBufferFlags(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
