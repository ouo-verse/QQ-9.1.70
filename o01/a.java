package o01;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int[] f421672a = new int[32];

    /* renamed from: b, reason: collision with root package name */
    public int f421673b = 0;

    public final void b(boolean z16) {
        int i3 = this.f421673b;
        int[] iArr = this.f421672a;
        if (i3 == iArr.length * 8) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length + 32);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.f421672a = copyOf;
        }
        if (z16) {
            int[] iArr2 = this.f421672a;
            int i16 = this.f421673b;
            int i17 = i16 / 8;
            iArr2[i17] = (128 >>> (i16 % 8)) | iArr2[i17];
        }
        this.f421673b++;
    }

    public final String toString() {
        StringBuilder sb5 = new StringBuilder();
        int i3 = this.f421673b;
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append(((this.f421672a[i16 / 8] >>> (7 - (i16 % 8))) & 1) == 1 ? '1' : '0');
        }
        return sb5.toString();
    }

    public final void a(int i3, int i16) {
        for (int i17 = 0; i17 < i16; i17++) {
            boolean z16 = true;
            if (((i3 >>> ((i16 - i17) - 1)) & 1) != 1) {
                z16 = false;
            }
            b(z16);
        }
    }
}
