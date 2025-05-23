package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Size;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MathUtils {
    MathUtils() {
    }

    private static native void nPackTangentFrame(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36, @NonNull @Size(min = 4) float[] fArr, @IntRange(from = 0) int i3);

    public static void packTangentFrame(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36, @NonNull @Size(min = 4) float[] fArr) {
        nPackTangentFrame(f16, f17, f18, f19, f26, f27, f28, f29, f36, fArr, 0);
    }

    public static void packTangentFrame(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36, @NonNull @Size(min = 4) float[] fArr, @IntRange(from = 0) int i3) {
        nPackTangentFrame(f16, f17, f18, f19, f26, f27, f28, f29, f36, fArr, i3);
    }
}
