package com.bumptech.glide;

/* compiled from: P */
/* loaded from: classes.dex */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);

    private final float multiplier;

    MemoryCategory(float f16) {
        this.multiplier = f16;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
