package org.libpag;

/* loaded from: classes29.dex */
public class PAGAudioReader {
    public static final int DEFAULT_CHANNELS = 2;
    public static final float DEFAULT_OUTPUT_VOLUME = 1.0f;
    public static final int DEFAULT_SAMPLE_COUNT = 1024;
    public static final int DEFAULT_SAMPLE_RATE = 44100;
    long nativeContext;

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    PAGAudioReader(long j3) {
        this.nativeContext = j3;
    }

    public static PAGAudioReader Make(int i3, int i16, int i17, float f16) {
        long nativeMake = nativeMake(i3, i16, i17, f16);
        if (nativeMake == 0) {
            return null;
        }
        return new PAGAudioReader(nativeMake);
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private static native long nativeMake(int i3, int i16, int i17, float f16);

    protected void finalize() {
        nativeFinalize();
    }

    public native boolean isEmpty();

    public native PAGAudioSample readNextSample();

    public native void seek(long j3);

    public native void setComposition(PAGComposition pAGComposition);
}
