package com.tencent.luggage.wxa.ar;

import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f121783a;

        /* renamed from: b, reason: collision with root package name */
        public String f121784b;

        /* renamed from: c, reason: collision with root package name */
        public String f121785c;

        /* renamed from: d, reason: collision with root package name */
        public String f121786d;

        public a(String str, String str2, String str3, String str4) {
            this.f121783a = str;
            this.f121784b = str2;
            this.f121785c = str3;
            this.f121786d = str4;
        }

        public boolean a() {
            try {
                PublicKey generatePublic = KeyFactory.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.decode(this.f121785c, 0)));
                Signature signature = Signature.getInstance(this.f121786d);
                signature.initVerify(generatePublic);
                byte[] decode = Base64.decode(this.f121784b, 0);
                signature.update(this.f121783a.getBytes());
                return signature.verify(decode);
            } catch (Throwable th5) {
                x0.c("ECCUtil", "verify failed " + th5.getMessage());
                return false;
            }
        }
    }

    public static boolean a(String str, String str2, String str3) {
        return new a(str, str2, str3, "SHA1withECDSA").a();
    }
}
