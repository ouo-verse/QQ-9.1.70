package org.tencwebrtc;

import android.annotation.TargetApi;
import android.os.Trace;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FTrace {
    @TargetApi(18)
    public static final void endTrace() {
        Trace.endSection();
    }

    @TargetApi(18)
    public static final void startTrace(String str, Object... objArr) {
        Trace.beginSection(String.format(str, objArr));
    }

    @TargetApi(18)
    public static final void startTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        Trace.beginSection(String.format(Locale.US, "%s.%s-%d", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
    }
}
