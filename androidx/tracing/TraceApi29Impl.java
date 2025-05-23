package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: P */
@RequiresApi(29)
/* loaded from: classes.dex */
final class TraceApi29Impl {
    TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i3) {
        android.os.Trace.beginAsyncSection(str, i3);
    }

    public static void endAsyncSection(@NonNull String str, int i3) {
        android.os.Trace.endAsyncSection(str, i3);
    }

    public static void setCounter(@NonNull String str, int i3) {
        android.os.Trace.setCounter(str, i3);
    }
}
