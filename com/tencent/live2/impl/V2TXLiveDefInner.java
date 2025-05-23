package com.tencent.live2.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TXLiveDefInner {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SurfaceSize {
        static IPatchRedirector $redirector_;
        public int height;
        public int width;

        public SurfaceSize(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.width = i3;
                this.height = i16;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "[width:" + this.width + "][height:" + this.height + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class TXLivePropertyKey {
        static IPatchRedirector $redirector_ = null;
        public static final String kEnableAdjustEncoderDirectionToUIOrientation = "enableAdjustEncoderDirectionToUIOrientation";
        public static final String kV2EnableAGC = "enableAGC";
        public static final String kV2EnableANS = "enableANS";
        public static final String kV2EnableCameraZoom = "enableCameraZoom";
        public static final String kV2EnableRTMPAcc = "enableRTMPAcc";
        public static final String kV2EnableRealtimeMode = "enableRealtimeMode";
        public static final String kV2EnableSEITimestampMessage = "enableSEITimestampMessage";
        public static final String kV2SetAudioCodecType = "setAudioCodecType";
        public static final String kV2SetAudioEncodeFormat = "setAudioEncodeFormat";
        public static final String kV2SetAudioRoute = "setAudioRoute";
        public static final String kV2SetDisplayRotationObtainMethod = "setDisplayRotationObtainMethod";
        public static final String kV2SetFramework = "setFramework";
        public static final String kV2SetLEBEnvironment = "setLEBEnvironment";
        public static final String kV2SetLebCacheParams = "setLebCacheParams";
        public static final String kV2SetOpenGLContext = "setOpenGLContext";
        public static final String kV2SetPreferLocalIPStack = "setPreferLocalIPStack";
        public static final String kV2SetSurface = "setSurface";
        public static final String kV2SetSurfaceSize = "setSurfaceSize";

        public TXLivePropertyKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public V2TXLiveDefInner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
