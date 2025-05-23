package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f387863c;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f387864a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f387865b;

    a(Context context) {
        ad.b().a(ContextDelegate.getContext(context));
        ad b16 = ad.b();
        this.f387864a = b16.c();
        this.f387865b = b16.d();
    }

    public static a a(Context context) {
        if (f387863c == null) {
            synchronized (a.class) {
                if (f387863c == null) {
                    f387863c = new a(context.getApplicationContext());
                }
            }
        }
        return f387863c;
    }

    public final String b(String str) throws Exception {
        return new String(j.a(j.a(a()), j.a(b()), Base64.decode(str, 2)), "utf-8");
    }

    private byte[] b() {
        byte[] bArr = this.f387865b;
        return (bArr == null || bArr.length <= 0) ? ad.b().d() : bArr;
    }

    public final String a(String str) throws Exception {
        String a16 = j.a(a());
        String a17 = j.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a17.getBytes("utf-8"), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(a16.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    private byte[] a() {
        byte[] bArr = this.f387864a;
        return (bArr == null || bArr.length <= 0) ? ad.b().c() : bArr;
    }
}
