package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002\u00a8\u0006\u000b"}, d2 = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ProgressionUtilKt {
    private static final int differenceModulo(int i3, int i16, int i17) {
        return mod(mod(i3, i17) - mod(i16, i17), i17);
    }

    @PublishedApi
    public static final int getProgressionLastElement(int i3, int i16, int i17) {
        if (i17 > 0) {
            return i3 >= i16 ? i16 : i16 - differenceModulo(i16, i3, i17);
        }
        if (i17 < 0) {
            return i3 <= i16 ? i16 : i16 + differenceModulo(i3, i16, -i17);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int mod(int i3, int i16) {
        int i17 = i3 % i16;
        return i17 >= 0 ? i17 : i17 + i16;
    }

    private static final long differenceModulo(long j3, long j16, long j17) {
        return mod(mod(j3, j17) - mod(j16, j17), j17);
    }

    private static final long mod(long j3, long j16) {
        long j17 = j3 % j16;
        return j17 >= 0 ? j17 : j17 + j16;
    }

    @PublishedApi
    public static final long getProgressionLastElement(long j3, long j16, long j17) {
        if (j17 > 0) {
            return j3 >= j16 ? j16 : j16 - differenceModulo(j16, j3, j17);
        }
        if (j17 < 0) {
            return j3 <= j16 ? j16 : j16 + differenceModulo(j3, j16, -j17);
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
