package c.t.m.g;

import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public class v3 {
    public static void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
