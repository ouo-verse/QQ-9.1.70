package android.support.v4.os;

import android.os.Trace;

/* compiled from: P */
/* loaded from: classes.dex */
class TraceJellybeanMR2 {
    TraceJellybeanMR2() {
    }

    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
