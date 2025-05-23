package com.tencent.mobileqq.search.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ba {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f285031a = Charset.forName("UTF-8");

    private static UUID a(byte[] bArr) {
        long j3 = 0;
        long j16 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j16 = (j16 << 8) | (bArr[i3] & 255);
        }
        for (int i16 = 8; i16 < 16; i16++) {
            j3 = (j3 << 8) | (bArr[i16] & 255);
        }
        return new UUID(j16, j3);
    }

    public static UUID b(String str, String str2) {
        if (str != null && str2 != null) {
            Charset charset = f285031a;
            return c(UUID.nameUUIDFromBytes(str.getBytes(charset)), str2.getBytes(charset));
        }
        return null;
    }

    public static UUID c(UUID uuid, byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
            messageDigest.update(d(uuid));
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            byte b16 = (byte) (digest[6] & RegisterType.DOUBLE_HI);
            digest[6] = b16;
            digest[6] = (byte) (b16 | 80);
            byte b17 = (byte) (digest[8] & 63);
            digest[8] = b17;
            digest[8] = (byte) (b17 | 128);
            return a(digest);
        } catch (NoSuchAlgorithmException unused) {
            throw new InternalError("SHA-1 not supported");
        }
    }

    private static byte[] d(UUID uuid) {
        byte[] bArr = new byte[16];
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) (255 & (mostSignificantBits >> ((7 - i3) * 8)));
        }
        for (int i16 = 8; i16 < 16; i16++) {
            bArr[i16] = (byte) ((leastSignificantBits >> ((15 - i16) * 8)) & 255);
        }
        return bArr;
    }
}
