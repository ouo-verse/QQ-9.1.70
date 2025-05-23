package com.tencent.dlsdk.yybutil.apkchannel.v2;

import com.tencent.dlsdk.yybutil.apkchannel.v2.ApkSignatureSchemeV2Verifier;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static byte[] a(String str) {
        return b(str, 1903261812);
    }

    private static byte[] b(String str, int i3) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            try {
                c<ByteBuffer, Long> a16 = ApkSignatureSchemeV2Verifier.a(randomAccessFile);
                ByteBuffer byteBuffer = a16.f100553a;
                long longValue = a16.f100554b.longValue();
                if (!a.a(randomAccessFile, longValue)) {
                    ByteBuffer a17 = ApkSignatureSchemeV2Verifier.a(ApkSignatureSchemeV2Verifier.a(randomAccessFile, ApkSignatureSchemeV2Verifier.a(byteBuffer, longValue)).f100553a, i3);
                    int remaining = a17.remaining();
                    byte[] bArr = new byte[remaining];
                    a17.get(bArr, 0, remaining);
                    randomAccessFile.close();
                    return bArr;
                }
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            } catch (Throwable th5) {
                randomAccessFile.close();
                throw th5;
            }
        } finally {
        }
    }
}
