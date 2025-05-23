package n2;

import android.content.Context;
import s2.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static p2.a a(Context context) {
        if (b.f433088b == null) {
            synchronized (b.class) {
                if (b.f433088b == null) {
                    b.f433088b = new b(context);
                }
            }
        }
        return b.f433088b;
    }
}
