package com.tencent.qqmusic.mediaplayer.seektable.flac;

import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BytesUtil {
    public static int from(byte[] bArr) throws RuntimeException {
        if (bArr.length <= 4) {
            if (bArr.length == 3) {
                return (bArr[2] & 255) | ((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8);
            }
            if (bArr.length == 2) {
                return (bArr[1] & RegisterType.DOUBLE_HI) | ((bArr[0] & 255) << 8);
            }
            if (bArr.length == 1) {
                return bArr[0] & 255;
            }
            throw new RuntimeException("bytes must be greater than 8 bit!");
        }
        throw new RuntimeException("bytes can't be greater than 32 bit!");
    }
}
