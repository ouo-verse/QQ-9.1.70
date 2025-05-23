package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: P */
@RequiresApi(18)
/* loaded from: classes.dex */
final class TraceApi18Impl {
    TraceApi18Impl() {
    }

    public static void beginSection(@NonNull String str) {
        android.os.Trace.beginSection(str);
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }
}
