package org.light;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum LightFaceDirection {
    LightFaceDirectionPosition(1),
    LightFaceDirectionSide(2);

    private int value;

    LightFaceDirection(int i3) {
        this.value = i3;
    }

    public int value() {
        return this.value;
    }

    public static LightFaceDirection valueOf(int i3) {
        if (i3 == 1) {
            return LightFaceDirectionPosition;
        }
        if (i3 != 2) {
            return LightFaceDirectionPosition;
        }
        return LightFaceDirectionSide;
    }
}
