package com.tencent.luggage.wxa.n0;

import android.util.Pair;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f135053a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f135054b = {96000, 88200, 64000, 48000, 44100, 32000, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f135055c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static byte[] a(int i3, int i16, int i17) {
        return new byte[]{(byte) (((i3 << 3) & 248) | ((i16 >> 1) & 7)), (byte) (((i16 << 7) & 128) | ((i17 << 3) & 120))};
    }

    public static int b(k kVar) {
        boolean z16;
        int a16 = kVar.a(4);
        if (a16 == 15) {
            return kVar.a(24);
        }
        if (a16 < 13) {
            z16 = true;
        } else {
            z16 = false;
        }
        a.a(z16);
        return f135054b[a16];
    }

    public static Pair a(byte[] bArr) {
        k kVar = new k(bArr);
        int a16 = a(kVar);
        int b16 = b(kVar);
        int a17 = kVar.a(4);
        if (a16 == 5 || a16 == 29) {
            b16 = b(kVar);
            if (a(kVar) == 22) {
                a17 = kVar.a(4);
            }
        }
        int i3 = f135055c[a17];
        a.a(i3 != -1);
        return Pair.create(Integer.valueOf(b16), Integer.valueOf(i3));
    }

    public static byte[] a(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = f135053a;
        byte[] bArr3 = new byte[bArr2.length + i16];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i3, bArr3, bArr2.length, i16);
        return bArr3;
    }

    public static int a(k kVar) {
        int a16 = kVar.a(5);
        return a16 == 31 ? kVar.a(6) + 32 : a16;
    }
}
