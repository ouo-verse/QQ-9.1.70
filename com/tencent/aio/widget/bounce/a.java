package com.tencent.aio.widget.bounce;

import kotlin.Metadata;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0000\u001a*\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0000\u00a8\u0006\t"}, d2 = {"", "dampedDistance", "", "mScreenHeightPixels", "height", "maxDragHeight", "b", "originTranslation", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    public static final float a(int i3, int i16, int i17, int i18) {
        int coerceAtLeast;
        float coerceAtMost;
        int coerceAtLeast2;
        float coerceAtLeast3;
        int i19 = 1;
        float f16 = 2.5f;
        if (i3 >= 0) {
            if (2.5f < 10) {
                f16 = 2.5f * i18;
            }
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i16 / 2, i17);
            coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast(i3 * 0.5f, 0.0f);
            float f17 = 1;
            float f18 = -coerceAtLeast3;
            if (coerceAtLeast2 != 0) {
                i19 = coerceAtLeast2;
            }
            return f16 * (f17 - ((float) Math.pow(100.0f, f18 / i19)));
        }
        if (2.5f < 10) {
            f16 = 2.5f * i18;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i16 / 2, i17);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 * 0.5f, 0.0f);
        float f19 = -f16;
        float f26 = 1;
        float f27 = -(-coerceAtMost);
        if (coerceAtLeast != 0) {
            i19 = coerceAtLeast;
        }
        return f19 * (f26 - ((float) Math.pow(100.0f, f27 / i19)));
    }

    public static final int b(float f16, int i3, int i16, int i17) {
        int coerceAtLeast;
        float log;
        float f17;
        int roundToInt;
        int roundToInt2;
        int coerceAtLeast2;
        float log2;
        float f18 = 2.5f;
        if (f16 >= 0) {
            if (2.5f < 10) {
                f18 = 2.5f * i17;
            }
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i3 / 2, i16);
            log2 = MathKt__MathJVMKt.log(1 - (f16 / f18), 100.0f);
            f17 = ((-coerceAtLeast2) * log2) / 0.5f;
        } else {
            if (2.5f < 10) {
                f18 = 2.5f * i17;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 / 2, i16);
            log = MathKt__MathJVMKt.log(1 - ((-f16) / f18), 100.0f);
            f17 = -(((-coerceAtLeast) * log) / 0.5f);
        }
        if (!Float.isNaN(f17)) {
            roundToInt2 = MathKt__MathJVMKt.roundToInt(f17);
            return roundToInt2;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(f16);
        return roundToInt;
    }
}
