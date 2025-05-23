package nn4;

import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u00a8\u0006\b"}, d2 = {"", "", "a", "v", "b", "", PM.BASE, "c", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {
    @NotNull
    public static final String a(long j3) {
        return b(j3);
    }

    @NotNull
    public static final String b(long j3) {
        return c(j3, 10);
    }

    @NotNull
    public static final String c(long j3, int i3) {
        int checkRadix;
        int checkRadix2;
        int checkRadix3;
        if (j3 >= 0) {
            checkRadix3 = CharsKt__CharJVMKt.checkRadix(i3);
            String l3 = Long.toString(j3, checkRadix3);
            Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
            return l3;
        }
        long j16 = i3;
        long j17 = ((j3 >>> 1) / j16) << 1;
        long j18 = j3 - (j17 * j16);
        if (j18 >= j16) {
            j18 -= j16;
            j17++;
        }
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        String l16 = Long.toString(j17, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l16, "toString(this, checkRadix(radix))");
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(i3);
        String l17 = Long.toString(j18, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(l17, "toString(this, checkRadix(radix))");
        return l16 + l17;
    }
}
