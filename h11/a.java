package h11;

import android.text.TextUtils;
import java.io.IOException;
import t01.c;
import t01.d;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends c {

    /* renamed from: e, reason: collision with root package name */
    private static ThreadLocal<byte[]> f404069e = new ThreadLocal<>();

    public a(d dVar) {
        super(dVar);
    }

    protected static byte[] a() {
        byte[] bArr = f404069e.get();
        if (bArr == null) {
            byte[] bArr2 = new byte[4];
            f404069e.set(bArr2);
            return bArr2;
        }
        return bArr;
    }

    public boolean b(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int c16 = c();
        for (int i3 = 0; i3 < 4; i3++) {
            if (((c16 >> (i3 * 8)) & 255) != str.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    public int c() throws IOException {
        byte[] a16 = a();
        read(a16, 0, 4);
        return ((a16[3] & 255) << 24) | (a16[0] & 255) | ((a16[1] & 255) << 8) | ((a16[2] & 255) << 16);
    }

    public int d() throws IOException {
        byte[] a16 = a();
        read(a16, 0, 4);
        return ((a16[0] & 255) << 24) | (a16[3] & 255) | ((a16[2] & 255) << 8) | ((a16[1] & 255) << 16);
    }

    public short e() throws IOException {
        byte[] a16 = a();
        read(a16, 0, 2);
        return (short) (((a16[0] & 255) << 8) | (a16[1] & 255));
    }
}
