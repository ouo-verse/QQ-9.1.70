package c.t.m.g;

import android.util.Base64;

/* compiled from: P */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f29819a = new byte[0];

    public static byte[] a(String str) {
        try {
            return a(str.getBytes("UTF-8"), 4);
        } catch (Throwable th5) {
            c1.b("SosoLocUtils", th5.toString());
            return f29819a;
        }
    }

    public static byte[] a(byte[] bArr, int i3) {
        byte[] a16 = p0.a(bArr);
        String a17 = s0.a("fc_base");
        if (h1.a(a17)) {
            c1.b("SosoLocUtils", "get pwd empty.");
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    byte[] a18 = s0.a(a16, a17);
                    if (!h1.a(a18)) {
                        byte[] encode = Base64.encode(a18, 2);
                        if (!h1.a(encode)) {
                            return encode;
                        }
                    }
                    return f29819a;
                }
                return f29819a;
            }
            a16 = s0.a(a16, a17);
        }
        if (h1.a(a16)) {
            c1.b("SosoLocUtils", "encrypt failed");
            return f29819a;
        }
        byte[] bArr2 = new byte[a16.length + 2];
        System.arraycopy(a(a16.length), 0, bArr2, 0, 2);
        System.arraycopy(a16, 0, bArr2, 2, a16.length);
        return bArr2;
    }

    public static byte[] a(int i3) {
        byte[] bArr = new byte[2];
        for (int i16 = 0; i16 < 2; i16++) {
            bArr[i16] = Integer.valueOf(i3 & 255).byteValue();
            i3 >>= 8;
        }
        return bArr;
    }
}
