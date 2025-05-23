package org.libpag;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class VideoDecoder {
    static {
        org.extra.tools.a.b("pag");
    }

    public static native void RegisterSoftwareDecoderFactory(long j3);

    public static native void SetMaxHardwareDecoderCount(int i3);
}
