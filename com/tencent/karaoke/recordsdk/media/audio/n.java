package com.tencent.karaoke.recordsdk.media.audio;

/* compiled from: P */
/* loaded from: classes7.dex */
public class n {
    public static int a(byte[] bArr, int i3) {
        for (int i16 = i3 - 2; i16 >= 0; i16 -= 2) {
            int i17 = i16 * 2;
            bArr[i17] = bArr[i16];
            int i18 = i16 + 1;
            bArr[i17 + 1] = bArr[i18];
            bArr[i17 + 2] = bArr[i16];
            bArr[i17 + 3] = bArr[i18];
        }
        return i3 * 2;
    }
}
