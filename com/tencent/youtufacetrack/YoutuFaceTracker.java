package com.tencent.youtufacetrack;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YoutuFaceTracker {
    static IPatchRedirector $redirector_;
    private static long handle;
    private static YoutuFaceTracker instance;
    private long nativePtr;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FaceStatus {
        static IPatchRedirector $redirector_;
        public double illumination_score;
        public float pitch;
        public float[] pointsVis;
        public float roll;
        public float[] xys;
        public float yaw;

        public FaceStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FaceStatus3d {
        static IPatchRedirector $redirector_;
        public float[] denseFaceModel;
        public float[] expression;
        public float pitch;
        public float roll;
        public float[] transform;
        public float yaw;

        public FaceStatus3d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77721);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            instance = null;
            handle = 0L;
        }
    }

    public YoutuFaceTracker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            NativeConstructor();
        }
    }

    public static native boolean GlobalInit(String str);

    public static native boolean GlobalRelease();

    private native void NativeConstructor();

    private native void NativeDestructor();

    public static long getHandle() {
        return handle;
    }

    public static synchronized YoutuFaceTracker getInstance() {
        YoutuFaceTracker youtuFaceTracker;
        synchronized (YoutuFaceTracker.class) {
            if (instance == null) {
                instance = new YoutuFaceTracker();
            }
            youtuFaceTracker = instance;
        }
        return youtuFaceTracker;
    }

    public static native boolean nativeInit();

    public native FaceStatus[] DoDetectionProcessBitmap(Bitmap bitmap);

    public native FaceStatus[] DoDetectionProcessYUV(byte[] bArr, int i3, int i16);

    public native FaceStatus3d[] DoDetectionProcessYUVPoses(byte[] bArr, int i3, int i16);

    public native Bitmap convertYUV2Bitmap(byte[] bArr, int i3, int i16, Bitmap.Config config);

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            NativeDestructor();
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            NativeDestructor();
        }
    }
}
