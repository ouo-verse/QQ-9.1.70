package org.light.lightAssetKit.enums;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum MaterialSupportRenderToTargetType {
    RenderTarget(0, "RenderTarget"),
    CameraTexture(1, "CameraTexture");

    public String name;
    public int value;

    MaterialSupportRenderToTargetType(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
