package com.eclipsesource.mmv8;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8TracerAccessible {

    @NonNull
    private static volatile IV8Tracer sTracer = IV8Tracer.DUMMY;

    public static void beginSection(@NonNull String str) {
        sTracer.beginSection("J2V8#" + str);
    }

    public static void endSection() {
        sTracer.endSection();
    }

    public static void setTracer(@NonNull IV8Tracer iV8Tracer) {
        sTracer = iV8Tracer;
    }
}
