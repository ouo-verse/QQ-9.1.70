package com.tencent.smtt.utils;

import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* compiled from: P */
/* loaded from: classes25.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    private static String f369752b = "";

    /* renamed from: c, reason: collision with root package name */
    private static byte[] f369753c;

    /* renamed from: g, reason: collision with root package name */
    private static String f369755g;

    /* renamed from: d, reason: collision with root package name */
    private Cipher f369756d;

    /* renamed from: e, reason: collision with root package name */
    private Cipher f369757e;

    /* renamed from: a, reason: collision with root package name */
    protected static final char[] f369751a = "0123456789abcdef".toCharArray();

    /* renamed from: f, reason: collision with root package name */
    private static i f369754f = null;

    i() throws Exception {
        this.f369756d = null;
        this.f369757e = null;
        f369755g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i3 = 0; i3 < 12; i3++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        f369753c = (str + f369755g).getBytes();
        this.f369756d = Cipher.getInstance("RSA/ECB/NoPadding");
        this.f369756d.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode((d() + e()).getBytes(), 0))));
        f369752b = b(this.f369756d.doFinal(f369753c));
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f369755g.getBytes()));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.f369757e = cipher;
        cipher.init(1, generateSecret);
    }

    public static i a() {
        try {
            if (f369754f == null) {
                f369754f = new i();
            }
            return f369754f;
        } catch (Exception e16) {
            f369754f = null;
            e16.printStackTrace();
            return null;
        }
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            char[] cArr2 = f369751a;
            cArr[i17] = cArr2[i16 >>> 4];
            cArr[i17 + 1] = cArr2[i16 & 15];
        }
        return new String(cArr);
    }

    private String d() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0";
    }

    private String e() {
        return "fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB";
    }

    public byte[] c(byte[] bArr) {
        TbsLog.i("Post3DESEncryption", "DesDecrypt deskeys is " + f369755g);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f369755g.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, generateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e16) {
            try {
                TbsLog.i("Post3DESEncryption", "DesDecrypt exception,  content is " + d(bArr));
            } catch (Throwable unused) {
            }
            TbsLog.i(e16);
            return null;
        }
    }

    public String d(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            sb5.append(RelationNTPushServiceImpl.PRE_HEX_STRING);
            String hexString = Integer.toHexString(i16);
            if (hexString.length() < 2) {
                sb5.append(0);
            }
            sb5.append(hexString);
            if (i3 != bArr.length - 1) {
                sb5.append(",");
            }
        }
        return sb5.toString();
    }

    public byte[] a(byte[] bArr) throws Exception {
        return this.f369757e.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, generateSecret);
        return cipher.doFinal(bArr);
    }

    public String b() {
        return f369752b;
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, generateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String c() {
        return f369755g;
    }
}
