package com.qq.e.comm.net;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static Cipher f38296a;

    /* renamed from: b, reason: collision with root package name */
    private static Cipher f38297b;

    /* renamed from: c, reason: collision with root package name */
    private static String f38298c = String.format("AES/%s/PKCS7Padding", KeyPropertiesCompact.BLOCK_MODE_ECB);

    /* renamed from: d, reason: collision with root package name */
    private static byte[] f38299d = Base64.decode("MmY1OWM5ZjViNmY1OTIxMzY4Nzk1M2JiMjNlMmNlMWU=", 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends Exception {
        public a(String str, Throwable th5) {
            super(str, th5);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.net.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0277b extends Exception {
        public C0277b(String str, Throwable th5) {
            super(str, th5);
        }
    }

    @SuppressLint({"TrulyRandom"})
    private static synchronized Cipher a() throws a {
        synchronized (b.class) {
            Cipher cipher = f38296a;
            if (cipher != null) {
                return cipher;
            }
            try {
                Cipher cipher2 = Cipher.getInstance(f38298c);
                cipher2.init(1, new SecretKeySpec(f38299d, KeyPropertiesCompact.KEY_ALGORITHM_AES));
                f38296a = cipher2;
                return cipher2;
            } catch (Exception e16) {
                throw new a("Fail To Init Cipher", e16);
            }
        }
    }

    private static synchronized Cipher b() throws a {
        synchronized (b.class) {
            Cipher cipher = f38297b;
            if (cipher != null) {
                return cipher;
            }
            try {
                Cipher cipher2 = Cipher.getInstance(f38298c);
                cipher2.init(2, new SecretKeySpec(f38299d, KeyPropertiesCompact.KEY_ALGORITHM_AES));
                f38297b = cipher2;
                return cipher2;
            } catch (Exception e16) {
                throw new a("Fail To Init Cipher", e16);
            }
        }
    }

    public static byte[] c(byte[] bArr) {
        return ZipCompress.compressByGzip(bArr);
    }

    public static byte[] d(byte[] bArr) {
        return ZipCompress.decompressByGzip(bArr);
    }

    private static byte[] e(byte[] bArr) throws a {
        try {
            return a().doFinal(bArr);
        } catch (Exception e16) {
            throw new a("Exception While encrypt byte array", e16);
        }
    }

    private static byte[] f(byte[] bArr) throws a {
        try {
            return b().doFinal(bArr);
        } catch (Exception e16) {
            throw new a("Exception While dencrypt byte array", e16);
        }
    }

    public static byte[] a(byte[] bArr) throws C0277b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(e(ZipCompress.compressByGzip(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e16) {
            throw new C0277b("Exception while packaging byte array", e16);
        }
    }

    @TargetApi(9)
    public static byte[] b(byte[] bArr) throws C0277b {
        if (bArr == null) {
            throw new C0277b("S2SS Package FormatError", null);
        }
        try {
            return ZipCompress.decompressByGzip(f(bArr));
        } catch (Exception e16) {
            throw new C0277b("Exception while packaging byte array", e16);
        }
    }
}
