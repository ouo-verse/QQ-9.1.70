package com.tencent.smtt.utils;

import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes25.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f369758a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static j f369759b;

    /* renamed from: c, reason: collision with root package name */
    private String f369760c;

    /* renamed from: d, reason: collision with root package name */
    private String f369761d;

    /* renamed from: e, reason: collision with root package name */
    private String f369762e;

    j() {
        int nextInt = new Random().nextInt(89999999) + 10000000;
        int nextInt2 = new Random().nextInt(89999999) + 10000000;
        this.f369762e = String.valueOf(nextInt);
        this.f369760c = this.f369762e + String.valueOf(nextInt2);
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f369759b == null) {
                f369759b = new j();
            }
            jVar = f369759b;
        }
        return jVar;
    }

    public void b() throws Exception {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    public String c() throws Exception {
        Cipher cipher;
        if (this.f369761d == null) {
            byte[] bytes = this.f369760c.getBytes();
            try {
                try {
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception unused) {
                    b();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                cipher = null;
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.f369761d = b(cipher.doFinal(bytes));
        }
        return this.f369761d;
    }

    public byte[] a(byte[] bArr) throws Exception {
        return com.tencent.smtt.sdk.stat.a.a(this.f369762e.getBytes(), bArr, 1);
    }

    private String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            char[] cArr2 = f369758a;
            cArr[i17] = cArr2[i16 >>> 4];
            cArr[i17 + 1] = cArr2[i16 & 15];
        }
        return new String(cArr);
    }
}
