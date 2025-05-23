package com.google.android.filament;

import androidx.annotation.IntRange;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Viewport {
    public int bottom;

    @IntRange(from = 0)
    public int height;
    public int left;

    @IntRange(from = 0)
    public int width;

    public Viewport(int i3, int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18) {
        this.left = i3;
        this.bottom = i16;
        this.width = i17;
        this.height = i18;
    }
}
