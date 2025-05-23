package com.qq.wx.voice.vad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TRSilkDecoder {

    /* renamed from: a, reason: collision with root package name */
    private static int f41131a = 24000;

    /* renamed from: b, reason: collision with root package name */
    private static int f41132b = 16000;

    /* renamed from: c, reason: collision with root package name */
    private static TRSilk f41133c;

    public TRSilkDecoder() {
        f41133c = new TRSilk();
    }

    private static byte[] a(byte[] bArr, int i3) {
        if (bArr != null && i3 > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i16 = 0; i16 < i3; i16 += 64) {
                byte[] silkDecode = f41133c.silkDecode(bArr, i16, Math.min(64, i3 - i16));
                if (silkDecode != null) {
                    try {
                        byteArrayOutputStream.write(silkDecode);
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

    public static byte[] processSilkToPCM(byte[] bArr) {
        TRSilk tRSilk;
        if (bArr == null) {
            return null;
        }
        if (bArr.length > 0 && (tRSilk = f41133c) != null) {
            try {
                tRSilk.silkDecodeInit(f41131a, f41132b);
                bArr = a(bArr, bArr.length);
                f41133c.silkDecodeRelease();
                return bArr;
            } catch (TRSilkException e16) {
                e16.printStackTrace();
                return bArr;
            }
        }
        return bArr;
    }
}
