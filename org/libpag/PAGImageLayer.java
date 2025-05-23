package org.libpag;

import java.nio.ByteBuffer;

/* loaded from: classes29.dex */
public class PAGImageLayer extends PAGLayer {
    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    public PAGImageLayer(long j3) {
        super(j3);
    }

    public static PAGImageLayer Make(int i3, int i16, long j3) {
        long nativeMake = nativeMake(i3, i16, j3);
        if (nativeMake == 0) {
            return null;
        }
        return new PAGImageLayer(nativeMake);
    }

    private static native void nativeInit();

    private static native long nativeMake(int i3, int i16, long j3);

    private native void replaceImage(long j3);

    private native void setImage(long j3);

    public native long contentDuration();

    public native PAGVideoRange[] getVideoRanges();

    public native ByteBuffer imageBytes();

    public void replaceImage(PAGImage pAGImage) {
        long j3;
        if (pAGImage == null) {
            j3 = 0;
        } else {
            j3 = pAGImage.nativeContext;
        }
        replaceImage(j3);
    }

    public void setImage(PAGImage pAGImage) {
        long j3;
        if (pAGImage == null) {
            j3 = 0;
        } else {
            j3 = pAGImage.nativeContext;
        }
        setImage(j3);
    }
}
