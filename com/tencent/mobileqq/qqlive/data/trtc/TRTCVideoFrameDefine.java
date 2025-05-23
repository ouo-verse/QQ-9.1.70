package com.tencent.mobileqq.qqlive.data.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TRTCVideoFrameDefine {
    static IPatchRedirector $redirector_ = null;
    public static final int RTC_VIDEO_BITMAP_FRAME = 2;
    public static final int RTC_VIDEO_BUFFER_FRAME = 1;
    public static final int RTC_VIDEO_TEXTURE_FRAME = 3;
    public static final int RTC_VIDEO_TRTC_FRAME = 4;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCVideoFrameType {
    }

    public TRTCVideoFrameDefine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
