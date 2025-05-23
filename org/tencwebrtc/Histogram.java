package org.tencwebrtc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class Histogram {
    private final long handle;

    Histogram(long j3) {
        this.handle = j3;
    }

    public static Histogram createCounts(String str, int i3, int i16, int i17) {
        return new Histogram(nativeCreateCounts(str, i3, i16, i17));
    }

    public static Histogram createEnumeration(String str, int i3) {
        return new Histogram(nativeCreateEnumeration(str, i3));
    }

    private static native void nativeAddSample(long j3, int i3);

    private static native long nativeCreateCounts(String str, int i3, int i16, int i17);

    private static native long nativeCreateEnumeration(String str, int i3);

    public void addSample(int i3) {
        nativeAddSample(this.handle, i3);
    }
}
