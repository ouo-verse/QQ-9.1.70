package kotlin.random;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016\u00a8\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", HippyControllerProps.ARRAY, "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class Random {

    /* renamed from: Default, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", HippyControllerProps.ARRAY, "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.random.Random$Default, reason: from kotlin metadata */
    /* loaded from: classes28.dex */
    public static final class Companion extends Random implements Serializable {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u00c2\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.random.Random$Default$Serialized */
        /* loaded from: classes28.dex */
        private static final class Serialized implements Serializable {

            @NotNull
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            Serialized() {
            }

            private final Object readResolve() {
                return Random.INSTANCE;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int bitCount) {
            return Random.defaultRandom.nextBits(bitCount);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        Companion() {
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(int size) {
            return Random.defaultRandom.nextBytes(size);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double until) {
            return Random.defaultRandom.nextDouble(until);
        }

        @Override // kotlin.random.Random
        public int nextInt(int until) {
            return Random.defaultRandom.nextInt(until);
        }

        @Override // kotlin.random.Random
        public long nextLong(long until) {
            return Random.defaultRandom.nextLong(until);
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] array, int fromIndex, int toIndex) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.defaultRandom.nextBytes(array, fromIndex, toIndex);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double from, double until) {
            return Random.defaultRandom.nextDouble(from, until);
        }

        @Override // kotlin.random.Random
        public int nextInt(int from, int until) {
            return Random.defaultRandom.nextInt(from, until);
        }

        @Override // kotlin.random.Random
        public long nextLong(long from, long until) {
            return Random.defaultRandom.nextLong(from, until);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 2) != 0) {
                i3 = 0;
            }
            if ((i17 & 4) != 0) {
                i16 = bArr.length;
            }
            return random.nextBytes(bArr, i3, i16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int bitCount);

    public boolean nextBoolean() {
        if (nextBits(1) != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (!(new IntRange(0, array.length).contains(fromIndex) && new IntRange(0, array.length).contains(toIndex))) {
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") or toIndex (" + toIndex + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (fromIndex <= toIndex) {
            int i3 = (toIndex - fromIndex) / 4;
            for (int i16 = 0; i16 < i3; i16++) {
                int nextInt = nextInt();
                array[fromIndex] = (byte) nextInt;
                array[fromIndex + 1] = (byte) (nextInt >>> 8);
                array[fromIndex + 2] = (byte) (nextInt >>> 16);
                array[fromIndex + 3] = (byte) (nextInt >>> 24);
                fromIndex += 4;
            }
            int i17 = toIndex - fromIndex;
            int nextBits = nextBits(i17 * 8);
            for (int i18 = 0; i18 < i17; i18++) {
                array[fromIndex + i18] = (byte) (nextBits >>> (i18 * 8));
            }
            return array;
        }
        throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") must be not greater than toIndex (" + toIndex + ").").toString());
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public double nextDouble(double until) {
        return nextDouble(0.0d, until);
    }

    public int nextInt(int until) {
        return nextInt(0, until);
    }

    public long nextLong(long until) {
        return nextLong(0L, until);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double nextDouble(double from, double until) {
        double nextDouble;
        RandomKt.checkRangeBounds(from, until);
        double d16 = until - from;
        if (Double.isInfinite(d16)) {
            if ((Double.isInfinite(from) || Double.isNaN(from)) ? false : true) {
                if ((Double.isInfinite(until) || Double.isNaN(until)) ? false : true) {
                    double d17 = 2;
                    double nextDouble2 = nextDouble() * ((until / d17) - (from / d17));
                    nextDouble = from + nextDouble2 + nextDouble2;
                    return nextDouble < until ? Math.nextAfter(until, Double.NEGATIVE_INFINITY) : nextDouble;
                }
            }
        }
        nextDouble = from + (nextDouble() * d16);
        if (nextDouble < until) {
        }
    }

    public int nextInt(int from, int until) {
        int nextInt;
        int i3;
        int i16;
        int nextInt2;
        boolean z16;
        RandomKt.checkRangeBounds(from, until);
        int i17 = until - from;
        if (i17 > 0 || i17 == Integer.MIN_VALUE) {
            if (((-i17) & i17) == i17) {
                i16 = nextBits(RandomKt.fastLog2(i17));
                return from + i16;
            }
            do {
                nextInt = nextInt() >>> 1;
                i3 = nextInt % i17;
            } while ((nextInt - i3) + (i17 - 1) < 0);
            i16 = i3;
            return from + i16;
        }
        do {
            nextInt2 = nextInt();
            z16 = false;
            if (from <= nextInt2 && nextInt2 < until) {
                z16 = true;
            }
        } while (!z16);
        return nextInt2;
    }

    public long nextLong(long from, long until) {
        long nextLong;
        boolean z16;
        long nextLong2;
        long j3;
        long j16;
        int nextInt;
        RandomKt.checkRangeBounds(from, until);
        long j17 = until - from;
        if (j17 > 0) {
            if (((-j17) & j17) == j17) {
                int i3 = (int) j17;
                int i16 = (int) (j17 >>> 32);
                if (i3 != 0) {
                    nextInt = nextBits(RandomKt.fastLog2(i3));
                } else if (i16 == 1) {
                    nextInt = nextInt();
                } else {
                    j16 = (nextBits(RandomKt.fastLog2(i16)) << 32) + (nextInt() & 4294967295L);
                    return from + j16;
                }
                j16 = nextInt & 4294967295L;
                return from + j16;
            }
            do {
                nextLong2 = nextLong() >>> 1;
                j3 = nextLong2 % j17;
            } while ((nextLong2 - j3) + (j17 - 1) < 0);
            j16 = j3;
            return from + j16;
        }
        do {
            nextLong = nextLong();
            z16 = false;
            if (from <= nextLong && nextLong < until) {
                z16 = true;
            }
        } while (!z16);
        return nextLong;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return nextBytes(array, 0, array.length);
    }

    @NotNull
    public byte[] nextBytes(int size) {
        return nextBytes(new byte[size]);
    }
}
