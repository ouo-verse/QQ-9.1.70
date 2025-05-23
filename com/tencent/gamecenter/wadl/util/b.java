package com.tencent.gamecenter.wadl.util;

import android.util.Pair;
import com.tencent.gamecenter.wadl.util.ApkSignatureSchemeV2Verifier;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {
    public static boolean a(String str) throws IOException {
        return ApkSignatureSchemeV2Verifier.h(str, 1896449818);
    }

    public static boolean b(String str) throws IOException {
        return ApkSignatureSchemeV2Verifier.h(str, -262969152);
    }

    private static byte[] c(String str, int i3) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        byte[] bArr = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            Pair<ByteBuffer, Long> g16 = ApkSignatureSchemeV2Verifier.g(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) g16.first;
            long longValue = ((Long) g16.second).longValue();
            if (!o.i(randomAccessFile, longValue)) {
                ByteBuffer d16 = ApkSignatureSchemeV2Verifier.d((ByteBuffer) ApkSignatureSchemeV2Verifier.c(randomAccessFile, ApkSignatureSchemeV2Verifier.f(byteBuffer, longValue)).first, i3);
                if (d16 != null) {
                    int remaining = d16.remaining();
                    bArr = new byte[remaining];
                    d16.get(bArr, 0, remaining);
                }
                randomAccessFile.close();
                return bArr;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public static byte[] d(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return c(str, 1903261812);
    }
}
