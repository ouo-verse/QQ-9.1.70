package a14;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class b {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                c.b("RMonitor_FdLeak_IOUtil", "close silently failed: " + e16.getMessage());
            }
        }
    }
}
