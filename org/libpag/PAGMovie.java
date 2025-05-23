package org.libpag;

/* loaded from: classes29.dex */
public class PAGMovie extends PAGImage {
    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    PAGMovie(long j3) {
        super(j3);
    }

    public static PAGMovie MakeFromFile(String str) {
        long MakeFromFileInternal = MakeFromFileInternal(str, -1L, -1L, 1.0f, 1.0f);
        if (MakeFromFileInternal == 0) {
            return null;
        }
        return new PAGMovie(MakeFromFileInternal);
    }

    private static native long MakeFromFileInternal(String str, long j3, long j16, float f16, float f17);

    private static native void nativeInit();

    public native long duration();

    public static PAGMovie MakeFromFile(String str, long j3, long j16, float f16, float f17) {
        long MakeFromFileInternal = MakeFromFileInternal(str, j3, j16, f16, f17);
        if (MakeFromFileInternal == 0) {
            return null;
        }
        return new PAGMovie(MakeFromFileInternal);
    }
}
