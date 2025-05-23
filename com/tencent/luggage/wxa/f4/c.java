package com.tencent.luggage.wxa.f4;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f125282a = new c();

    public static final byte[] a(int i3, int i16, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i17 = i3 * i16;
        int[] iArr = new int[i17];
        bitmap.getPixels(iArr, 0, i3, 0, 0, i3, i16);
        byte[] bArr = new byte[(i17 * 3) / 2];
        f125282a.a(bArr, iArr, i3, i16);
        bitmap.recycle();
        return bArr;
    }

    public final void a(byte[] bArr, int[] iArr, int i3, int i16) {
        int i17 = i3 * i16;
        int i18 = 0;
        int i19 = 0;
        for (int i26 = 0; i26 < i16; i26++) {
            int i27 = 0;
            while (i27 < i3) {
                int i28 = iArr[i19];
                int i29 = (16711680 & i28) >> 16;
                int i36 = (65280 & i28) >> 8;
                int i37 = 255;
                int i38 = (i28 & 255) >> 0;
                int i39 = (((((i29 * 66) + (i36 * 129)) + (i38 * 25)) + 128) >> 8) + 16;
                int i46 = (((((i29 * (-38)) - (i36 * 74)) + (i38 * 112)) + 128) >> 8) + 128;
                int i47 = (((((i29 * 112) - (i36 * 94)) - (i38 * 18)) + 128) >> 8) + 128;
                int i48 = i18 + 1;
                if (i39 < 0) {
                    i39 = 0;
                } else if (i39 > 255) {
                    i39 = 255;
                }
                bArr[i18] = (byte) i39;
                if (i26 % 2 == 0 && i19 % 2 == 0) {
                    int i49 = i17 + 1;
                    if (i47 < 0) {
                        i47 = 0;
                    } else if (i47 > 255) {
                        i47 = 255;
                    }
                    bArr[i17] = (byte) i47;
                    i17 = i49 + 1;
                    if (i46 < 0) {
                        i37 = 0;
                    } else if (i46 <= 255) {
                        i37 = i46;
                    }
                    bArr[i49] = (byte) i37;
                }
                i19++;
                i27++;
                i18 = i48;
            }
        }
    }
}
