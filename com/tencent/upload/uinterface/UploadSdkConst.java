package com.tencent.upload.uinterface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadSdkConst {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_LOG_BK_HOST = "mobilelog.upqzfilebk.com";
    public static final String DEFAULT_LOG_HOST = "mobilelog.upqzfile.com";
    public static final String DEFAULT_OTHER_BK_HOST = "other.upqzfilebk.com";
    public static final String DEFAULT_OTHER_HOST = "other.upqzfile.com";
    public static final String DEFAULT_PIC_BK_HOST = "pic.upqzfilebk.com";
    public static final String DEFAULT_PIC_HOST = "pic.upqzfile.com";
    public static final String DEFAULT_V6_LOG_HOST = "v6.mobilelog.upqzfile.com";
    public static final String DEFAULT_V6_OTHER_HOST = "v6.other.upqzfile.com";
    public static final String DEFAULT_VIDEO_BK_HOST = "video.upqzfilebk.com";
    public static final String DEFAULT_VIDEO_HOST = "video.upqzfile.com";

    public UploadSdkConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
