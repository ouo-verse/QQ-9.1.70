package hynb.q;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    public static byte[] a(Context context, String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            str = "0plm8uhb6tfc4esz";
        }
        try {
            return b.a(str, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(Context context, String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            str = "0plm8uhb6tfc4esz";
        }
        byte[] bArr2 = null;
        for (int i3 = 0; i3 < 5; i3++) {
            try {
                bArr2 = b.b(str, bArr);
            } catch (UnsatisfiedLinkError e16) {
                if (5 == i3 + 1) {
                    throw e16;
                }
            }
            if (bArr2 != null) {
                break;
            }
        }
        return bArr2;
    }
}
