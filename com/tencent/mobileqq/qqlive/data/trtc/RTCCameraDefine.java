package com.tencent.mobileqq.qqlive.data.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RTCCameraDefine {
    static IPatchRedirector $redirector_ = null;
    public static final int RTC_CAMERA_EVENT_CLOSE = 2;
    public static final int RTC_CAMERA_EVENT_OPEN = 1;
    public static final int RTC_CAMERA_EVENT_SWITCH = 3;
    public static final int RTC_CAMERA_ID_BACK = 2;
    public static final int RTC_CAMERA_ID_FRONT = 1;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCCameraEvent {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCCameraID {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class RTCMirrorType {
        private static final /* synthetic */ RTCMirrorType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RTCMirrorType RTC_ALL_PIPELINE;
        public static final RTCMirrorType RTC_MIRROR_ENCODER;
        public static final RTCMirrorType RTC_MIRROR_LOCAL_RENDER;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56757);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            RTCMirrorType rTCMirrorType = new RTCMirrorType("RTC_MIRROR_LOCAL_RENDER", 0);
            RTC_MIRROR_LOCAL_RENDER = rTCMirrorType;
            RTCMirrorType rTCMirrorType2 = new RTCMirrorType("RTC_MIRROR_ENCODER", 1);
            RTC_MIRROR_ENCODER = rTCMirrorType2;
            RTCMirrorType rTCMirrorType3 = new RTCMirrorType("RTC_ALL_PIPELINE", 2);
            RTC_ALL_PIPELINE = rTCMirrorType3;
            $VALUES = new RTCMirrorType[]{rTCMirrorType, rTCMirrorType2, rTCMirrorType3};
        }

        RTCMirrorType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static RTCMirrorType valueOf(String str) {
            return (RTCMirrorType) Enum.valueOf(RTCMirrorType.class, str);
        }

        public static RTCMirrorType[] values() {
            return (RTCMirrorType[]) $VALUES.clone();
        }
    }

    public RTCCameraDefine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
