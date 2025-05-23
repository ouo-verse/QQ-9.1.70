package org.libpag;

import java.nio.ByteBuffer;

/* loaded from: classes29.dex */
public class PAGAudioSample {
    public ByteBuffer data;
    public long duration;
    long nativeContext;
    public long timestamp;

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    PAGAudioSample(long j3, long j16, ByteBuffer byteBuffer, long j17) {
        this.timestamp = j3;
        this.duration = j16;
        this.data = byteBuffer;
        this.nativeContext = j17;
    }

    public static native ByteBuffer MergeFrames(PAGAudioSample[] pAGAudioSampleArr);

    private native void nativeFinalize();

    private static native void nativeInit();

    protected void finalize() {
        nativeFinalize();
    }
}
