package org.apache.commons.lang.math;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class JVMRandom extends Random {
    private static final Random SHARED_RANDOM = new Random();
    private static final long serialVersionUID = 1;
    private boolean constructed = true;

    private static int bitsRequired(long j3) {
        int i3 = 0;
        long j16 = j3;
        while (j3 >= 0) {
            if (j16 == 0) {
                return i3;
            }
            i3++;
            j3 <<= 1;
            j16 >>= 1;
        }
        return 64 - i3;
    }

    private static long next63bits() {
        return SHARED_RANDOM.nextLong() & Long.MAX_VALUE;
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return SHARED_RANDOM.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Random
    public double nextDouble() {
        return SHARED_RANDOM.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return SHARED_RANDOM.nextFloat();
    }

    @Override // java.util.Random
    public synchronized double nextGaussian() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Random
    public int nextInt() {
        return nextInt(Integer.MAX_VALUE);
    }

    @Override // java.util.Random
    public long nextLong() {
        return nextLong(Long.MAX_VALUE);
    }

    @Override // java.util.Random
    public synchronized void setSeed(long j3) {
        if (this.constructed) {
            throw new UnsupportedOperationException();
        }
    }

    public static long nextLong(long j3) {
        long next63bits;
        long j16;
        if (j3 <= 0) {
            throw new IllegalArgumentException("Upper bound for nextInt must be positive");
        }
        if (((-j3) & j3) == j3) {
            return next63bits() >> (63 - bitsRequired(j3 - 1));
        }
        do {
            next63bits = next63bits();
            j16 = next63bits % j3;
        } while ((next63bits - j16) + (j3 - 1) < 0);
        return j16;
    }

    @Override // java.util.Random
    public int nextInt(int i3) {
        return SHARED_RANDOM.nextInt(i3);
    }
}
