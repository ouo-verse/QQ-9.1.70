package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.os.Trace;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TraceUtil {
    TraceUtil() {
    }

    public static void beginSection(String str) {
        if (Util.SDK_INT >= 18) {
            beginSectionV18(str);
        }
    }

    @TargetApi(18)
    private static void beginSectionV18(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        if (Util.SDK_INT >= 18) {
            endSectionV18();
        }
    }

    @TargetApi(18)
    private static void endSectionV18() {
        Trace.endSection();
    }
}
