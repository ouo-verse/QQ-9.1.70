package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                sTraceCounterMethod = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e16) {
                Log.i(TAG, "Unable to initialize via reflection.", e16);
            }
        }
    }

    TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.beginAsyncSection(str, i3);
            return;
        }
        try {
            sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i3));
        } catch (Exception unused) {
            Log.v(TAG, "Unable to invoke asyncTraceBegin() via reflection.");
        }
    }

    public static void beginSection(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void endAsyncSection(@NonNull String str, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.endAsyncSection(str, i3);
            return;
        }
        try {
            sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i3));
        } catch (Exception unused) {
            Log.v(TAG, "Unable to invoke endAsyncSection() via reflection.");
        }
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        boolean isEnabled;
        if (Build.VERSION.SDK_INT >= 29) {
            isEnabled = Trace.isEnabled();
            return isEnabled;
        }
        try {
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception unused) {
            Log.v(TAG, "Unable to invoke isTagEnabled() via reflection.");
            return false;
        }
    }

    public static void setCounter(@NonNull String str, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.setCounter(str, i3);
            return;
        }
        try {
            sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i3));
        } catch (Exception unused) {
            Log.v(TAG, "Unable to invoke traceCounter() via reflection.");
        }
    }
}
