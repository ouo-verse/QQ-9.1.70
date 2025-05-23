package o01;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f421674a;

    public b(int[] iArr, int i3) {
        int coerceAtLeast;
        int length = iArr.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                i16 = -1;
                break;
            } else if (iArr[i16] != 0) {
                break;
            } else {
                i16++;
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i16, 0);
        int length2 = (iArr.length - coerceAtLeast) + i3;
        int[] iArr2 = new int[length2];
        for (int i17 = 0; i17 < length2; i17++) {
            iArr2[i17] = 0;
        }
        this.f421674a = iArr2;
        a(iArr, coerceAtLeast, iArr2, iArr.length - coerceAtLeast);
    }

    public final b b(b bVar) {
        int[] iArr = this.f421674a;
        int length = iArr.length;
        int[] iArr2 = bVar.f421674a;
        if (length - iArr2.length < 0) {
            return this;
        }
        int i3 = iArr[0];
        int[] iArr3 = k.f421692c;
        int i16 = iArr3[i3] - iArr3[iArr2[0]];
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        int[] iArr4 = bVar.f421674a;
        int length2 = iArr4.length;
        int i17 = 0;
        int i18 = 0;
        while (i17 < length2) {
            copyOf[i18] = k.f421690a.a(k.f421692c[iArr4[i17]] + i16) ^ copyOf[i18];
            i17++;
            i18++;
        }
        return new b(copyOf, 0).b(bVar);
    }

    public final void a(int[] iArr, int i3, int[] iArr2, int i16) {
        for (int i17 = 0; i17 < i16; i17++) {
            iArr2[0 + i17] = iArr[i3 + i17];
        }
    }
}
