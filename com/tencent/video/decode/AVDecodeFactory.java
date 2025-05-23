package com.tencent.video.decode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AVDecodeFactory {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_MP4_AVDECODE = 0;
    public static final int TYPE_YUV_AVDECODE = 1;

    public AVDecodeFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AbstractAVDecode newDecode(AVDecodeOption aVDecodeOption) {
        int i3 = aVDecodeOption.mDecodeType;
        if (i3 == 0) {
            return AVDecode.newInstance(aVDecodeOption);
        }
        if (i3 == 1) {
            return YuvAVDecode.newInstance(aVDecodeOption);
        }
        return null;
    }

    public static AbstractAVDecode newDecodeUncatched(AVDecodeOption aVDecodeOption) throws AVideoException {
        int i3 = aVDecodeOption.mDecodeType;
        if (i3 == 0) {
            return AVDecode.newInstanceUncatched(aVDecodeOption);
        }
        if (i3 == 1) {
            return YuvAVDecode.newInstance(aVDecodeOption);
        }
        return null;
    }
}
