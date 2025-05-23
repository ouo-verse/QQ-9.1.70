package c.t.m.g;

import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: P */
/* loaded from: classes.dex */
public class t0 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f29999a = new byte[0];

    public static String a(String str) {
        if (str.contains("-----")) {
            str = str.split("-----")[2];
        }
        return str.replaceAll("\n", "");
    }

    public void a(byte[] bArr) {
        synchronized (this.f29999a) {
            try {
                KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
            } finally {
            }
        }
    }
}
