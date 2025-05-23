package com.tencent.mobileqq.shortvideo.mtveffects;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RandomGenerator {
    private Random mRandom;
    private long mSeed;

    public RandomGenerator(long j3) {
        Random random = new Random();
        this.mRandom = random;
        this.mSeed = 0L;
        random.setSeed(j3);
        this.mSeed = j3;
    }

    public long nextLong(long j3, long j16) {
        long j17 = j16 - j3;
        if (j17 <= 0) {
            return 0L;
        }
        long nextLong = (this.mRandom.nextLong() % j17) + j3;
        return nextLong < 0 ? nextLong + j17 : nextLong;
    }

    public void reset() {
        this.mRandom.setSeed(this.mSeed);
    }

    public void setSeed(long j3) {
        this.mSeed = j3;
        this.mRandom.setSeed(j3);
    }

    public long nextLong() {
        return this.mRandom.nextLong();
    }
}
