package android.support.v4.os;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TraceCompat {
    TraceCompat() {
    }

    public static void beginSection(String str) {
        TraceJellybeanMR2.beginSection(str);
    }

    public static void endSection() {
        TraceJellybeanMR2.endSection();
    }
}
