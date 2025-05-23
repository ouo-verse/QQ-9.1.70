package com.tencent.luggage.wxa.tg;

import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f141315a = {RegisterType.REFERENCE, 52, 86, 120, -112, -85, -51, -17};

    /* renamed from: b, reason: collision with root package name */
    public static String f141316b;

    public static String a(String str, String str2, String str3) {
        if (str == null || str.isEmpty() || !str.equals(SecretUtils.DES)) {
            return null;
        }
        return a(str2, str3);
    }

    public static String b(String str, String str2, String str3) {
        if (str == null || str.isEmpty() || !str.equals(SecretUtils.DES)) {
            return null;
        }
        return b(str2, str3);
    }

    public static String a(String str, String str2) {
        if (str != null && str.length() >= 8) {
            byte[] a16 = b.a(str2);
            if (a16 == null || a16.length == 0) {
                return null;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                h.a(3, SecretUtils.TAG, "start decode milles time = " + currentTimeMillis);
                SecretKey generateSecret = SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec(str.getBytes()));
                Cipher cipher = Cipher.getInstance(SecretUtils.ALGORITHM_DES);
                cipher.init(2, generateSecret, new IvParameterSpec(f141315a));
                String str3 = new String(cipher.doFinal(a16));
                h.a(3, SecretUtils.TAG, "end decode milles time = " + (System.currentTimeMillis() - currentTimeMillis));
                return str3;
            } catch (Exception e16) {
                h.a(6, SecretUtils.TAG, "decode des error" + h.a((Throwable) e16));
                throw e16;
            }
        }
        throw new Exception("secret key is not available");
    }

    public static String b(String str, String str2) {
        if (str != null && str.length() >= 8) {
            if (str2 == null || str2.isEmpty()) {
                return null;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                h.a(3, SecretUtils.TAG, "start encode milles time = " + currentTimeMillis);
                SecretKey generateSecret = SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec(str.getBytes()));
                Cipher cipher = Cipher.getInstance(SecretUtils.ALGORITHM_DES);
                cipher.init(1, generateSecret, new IvParameterSpec(f141315a));
                String a16 = b.a(cipher.doFinal(str2.getBytes()));
                h.a(3, SecretUtils.TAG, "end encode milles time = " + (System.currentTimeMillis() - currentTimeMillis));
                return a16;
            } catch (Exception e16) {
                h.a(6, SecretUtils.TAG, "encode des error" + h.a((Throwable) e16));
                throw e16;
            }
        }
        throw new Exception("secret key is not available");
    }

    public static synchronized String b() {
        String str;
        synchronized (l.class) {
            if (f141316b == null) {
                f141316b = a();
            }
            str = f141316b;
        }
        return str;
    }

    public static String a() {
        try {
            byte[] bArr = new byte[20];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return a(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b16 : bArr) {
            a(stringBuffer, b16);
        }
        return stringBuffer.toString();
    }

    public static void a(StringBuffer stringBuffer, byte b16) {
        stringBuffer.append("0123456789ABCDEF".charAt((b16 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b16 & RegisterType.DOUBLE_HI));
    }
}
