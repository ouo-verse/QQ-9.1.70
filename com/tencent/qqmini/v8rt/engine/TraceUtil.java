package com.tencent.qqmini.v8rt.engine;

import android.annotation.TargetApi;
import android.os.Trace;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TraceUtil {
    TraceUtil() {
    }

    @TargetApi(18)
    private static void beginSectionV18(String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    private static void endSectionV18() {
        Trace.endSection();
    }

    public static void endSection() {
    }

    public static void beginSection(String str) {
    }
}
