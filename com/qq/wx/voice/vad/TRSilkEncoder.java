package com.qq.wx.voice.vad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TRSilkEncoder {

    /* renamed from: a, reason: collision with root package name */
    private static int f41134a = 24000;

    /* renamed from: b, reason: collision with root package name */
    private static int f41135b = 16000;

    /* renamed from: c, reason: collision with root package name */
    private static TRSilk f41136c;

    public TRSilkEncoder() {
        f41136c = new TRSilk();
    }

    private static byte[] a(byte[] bArr, int i3) {
        if (bArr != null && i3 > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i16 = 0; i16 < i3; i16 += 1024) {
                byte[] silkEncode = f41136c.silkEncode(bArr, i16, Math.min(1024, i3 - i16));
                if (silkEncode != null) {
                    try {
                        byteArrayOutputStream.write(silkEncode);
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            try {
                byteArrayOutputStream.flush();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public static byte[] processPCMToSilk(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        f41136c.silkInit(f41134a, f41135b);
        try {
            bArr2 = a(bArr, bArr.length);
        } catch (TRSilkException e16) {
            e16.printStackTrace();
        }
        f41136c.silkRelease();
        return bArr2;
    }
}
