package com.tencent.youtu.liveness;

import android.content.res.AssetManager;
import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTFaceTracker {
    static IPatchRedirector $redirector_;
    private static IYtLoggerListener loggerListener;
    private long nativePtr;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Param {
        static IPatchRedirector $redirector_;
        public int biggerFaceMode;
        public int detInterval;
        public int maxFaceSize;
        public int minFaceSize;
        public boolean nonSquareRect;
        public float threshold;

        public Param() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TrackedFace {
        static IPatchRedirector $redirector_;
        public Rect faceRect;
        public float[] faceShape;
        public float[] faceVisible;
        public int frameId;
        public float pitch;
        public float roll;
        public int traceId;
        public float yaw;

        public TrackedFace() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public YTFaceTracker(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        int NativeConstructor = NativeConstructor(str, str2);
        if (NativeConstructor == 0) {
            return;
        }
        throw new IllegalAccessError("error model dirpath and config filaneme: " + NativeConstructor);
    }

    private native int NativeConstructor(AssetManager assetManager, String str, String str2);

    private native int NativeConstructor(String str, String str2);

    private native void NativeDestructor();

    public static native String getVersion();

    public static void nativeLog(int i3, String str) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log("[YTFaceTracker.nativeLog]", str);
        }
    }

    public static native void setLoggerLevel(int i3);

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            NativeDestructor();
        }
    }

    public void finalize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            NativeDestructor();
        }
    }

    public native Param getParam();

    public native void reset();

    public native void setParam(Param param);

    public native TrackedFace[] track(int i3, byte[] bArr, int i16, int i17, int i18);

    public YTFaceTracker(AssetManager assetManager, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, assetManager, str, str2);
            return;
        }
        int NativeConstructor = NativeConstructor(assetManager, str, str2);
        if (NativeConstructor == 0) {
            return;
        }
        throw new IllegalAccessError("error model dirpath and config filaneme: " + NativeConstructor);
    }
}
