package org.libpag;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.util.Pair;

/* loaded from: classes29.dex */
public class PAGDecoder {
    private long nativeContext;

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    PAGDecoder(long j3) {
        this.nativeContext = 0L;
        PAGLicenseManager.a(null);
        this.nativeContext = j3;
    }

    public static PAGDecoder Make(PAGComposition pAGComposition) {
        return Make(pAGComposition, pAGComposition.frameRate(), 1.0f);
    }

    private static native long MakeFrom(PAGComposition pAGComposition, float f16, float f17);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean checkFrameChanged(int i3);

    public native boolean copyFrameTo(Bitmap bitmap, int i3);

    protected void finalize() {
        nativeFinalize();
    }

    public Bitmap frameAtIndex(int i3) {
        boolean copyFrameTo;
        Pair a16 = a.a(width(), height(), false);
        Object obj = a16.first;
        if (obj == null) {
            return null;
        }
        Object obj2 = a16.second;
        if (obj2 != null && Build.VERSION.SDK_INT >= 26) {
            copyFrameTo = readFrame(i3, (HardwareBuffer) obj2);
            ((HardwareBuffer) a16.second).close();
        } else {
            copyFrameTo = copyFrameTo((Bitmap) obj, i3);
        }
        if (!copyFrameTo) {
            return null;
        }
        return (Bitmap) a16.first;
    }

    public native float frameRate();

    public native int height();

    public native int numFrames();

    public native boolean readFrame(int i3, HardwareBuffer hardwareBuffer);

    public void release() {
        nativeRelease();
    }

    public native int width();

    public static PAGDecoder Make(PAGComposition pAGComposition, float f16, float f17) {
        long MakeFrom = MakeFrom(pAGComposition, f16, f17);
        if (MakeFrom == 0) {
            return null;
        }
        return new PAGDecoder(MakeFrom);
    }
}
