package c.t.m.g;

import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes.dex */
public class a1 {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
