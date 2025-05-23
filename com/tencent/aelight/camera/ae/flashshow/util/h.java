package com.tencent.aelight.camera.ae.flashshow.util;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {

    /* renamed from: g, reason: collision with root package name */
    private static int[] f65111g = {1, 97, 125};

    /* renamed from: a, reason: collision with root package name */
    private int f65112a;

    /* renamed from: d, reason: collision with root package name */
    private long f65115d;

    /* renamed from: e, reason: collision with root package name */
    private long f65116e;

    /* renamed from: b, reason: collision with root package name */
    private int f65113b = 125;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f65114c = new int[256];

    /* renamed from: f, reason: collision with root package name */
    public int f65117f = 0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void c(boolean z16);
    }

    public void b() {
        this.f65115d = 0L;
        this.f65116e = 0L;
        if (ms.a.g()) {
            ms.a.a("DarkModeChecker", "refreshTimer ");
        }
    }

    public void a(byte[] bArr, int i3, int i16, a aVar) {
        int i17;
        if (aVar == null || bArr == null) {
            return;
        }
        int[] iArr = f65111g;
        if (iArr[0] == 1) {
            int i18 = this.f65117f + 1;
            this.f65117f = i18;
            if (i18 % 8 == 0) {
                this.f65112a = ((i3 * i16) * (100 - iArr[1])) / 100;
                this.f65113b = iArr[2];
                Arrays.fill(this.f65114c, 0);
                int i19 = 1;
                while (true) {
                    i17 = 255;
                    if (i19 >= i16) {
                        break;
                    }
                    for (int i26 = 1; i26 < i3; i26 += 8) {
                        int i27 = (i19 * i3) + i26;
                        if (i27 < bArr.length) {
                            int[] iArr2 = this.f65114c;
                            int i28 = bArr[i27] & 255;
                            iArr2[i28] = iArr2[i28] + 64;
                        }
                    }
                    i19 += 8;
                }
                int i29 = 0;
                int i36 = 255;
                while (true) {
                    if (i17 < 51) {
                        i17 = i36;
                        break;
                    }
                    i29 += this.f65114c[i17];
                    if (i29 >= this.f65112a) {
                        break;
                    }
                    int i37 = i17;
                    i17--;
                    i36 = i37;
                }
                if (i17 <= this.f65113b) {
                    ms.a.i("DarkModeChecker", "darkmode = true!");
                    this.f65116e = 0L;
                    long j3 = this.f65115d;
                    if (j3 == 0) {
                        this.f65115d = System.currentTimeMillis();
                        return;
                    }
                    if (j3 <= 0 || System.currentTimeMillis() - this.f65115d < 1500) {
                        return;
                    }
                    this.f65115d = -1L;
                    ms.a.i("DarkModeChecker", "ACTION_NIGHT_MODE on!");
                    this.f65116e = 0L;
                    aVar.c(true);
                    return;
                }
                if (this.f65115d > 0) {
                    this.f65115d = 0L;
                }
                long j16 = this.f65116e;
                if (j16 == 0) {
                    this.f65116e = System.currentTimeMillis();
                    return;
                }
                if (j16 <= 0 || System.currentTimeMillis() - this.f65116e < 2000) {
                    return;
                }
                this.f65116e = -1L;
                ms.a.i("DarkModeChecker", "ACTION_NIGHT_MODE off!");
                this.f65115d = 0L;
                aVar.c(false);
            }
        }
    }
}
