package com.tencent.aio.runtime;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Random;

/* loaded from: classes3.dex */
public class Xoroshiro128PlusRandom extends Random {
    static IPatchRedirector $redirector_;

    /* renamed from: s0, reason: collision with root package name */
    private long f69804s0;

    /* renamed from: s1, reason: collision with root package name */
    private long f69805s1;

    public Xoroshiro128PlusRandom(long j3) {
        super(0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        long a16 = c.a(j3);
        this.f69804s0 = a16;
        long a17 = c.a(a16);
        this.f69805s1 = a17;
        if (this.f69804s0 == 0 && a17 == 0) {
            long a18 = c.a(3735928559L);
            this.f69804s0 = a18;
            this.f69805s1 = c.a(a18);
        }
    }

    @Override // java.util.Random
    protected int next(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        return ((int) nextLong()) >>> (32 - i3);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (nextLong() >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length) {
            long nextInt = nextInt();
            int min = Math.min(length - i3, 8);
            while (true) {
                int i16 = min - 1;
                if (min > 0) {
                    bArr[i3] = (byte) nextInt;
                    nextInt >>>= 8;
                    i3++;
                    min = i16;
                }
            }
        }
    }

    @Override // java.util.Random
    public double nextDouble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
        }
        return (nextLong() >>> 11) * 1.1102230246251565E-16d;
    }

    @Override // java.util.Random
    public float nextFloat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return (nextInt() >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public double nextGaussian() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Double) iPatchRedirector.redirect((short) 9, (Object) this)).doubleValue();
        }
        return super.nextGaussian();
    }

    @Override // java.util.Random
    public int nextInt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? (int) nextLong() : ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
    }

    @Override // java.util.Random
    public long nextLong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        long j3 = this.f69804s0;
        long j16 = this.f69805s1;
        long j17 = j3 + j16;
        long j18 = j16 ^ j3;
        this.f69804s0 = (Long.rotateLeft(j3, 55) ^ j18) ^ (j18 << 14);
        this.f69805s1 = Long.rotateLeft(j18, 36);
        return j17;
    }

    @Override // java.util.Random
    public void setSeed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else if (this.f69804s0 == 0 && this.f69805s1 == 0) {
        } else {
            throw new RuntimeException("No seed set");
        }
    }

    @Override // java.util.Random
    public int nextInt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? super.nextInt(i3) : ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
    }
}
