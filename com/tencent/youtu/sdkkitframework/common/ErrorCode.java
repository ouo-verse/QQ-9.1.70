package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ErrorCode {
    static IPatchRedirector $redirector_ = null;
    public static final int YT_SDK_ACTION_ENCODE_VIDEO_ERROR = 400102;
    public static final int YT_SDK_ACTION_VIDEO_CONSERVATION_FAIL = 400105;
    public static final int YT_SDK_ACTION_VIDEO_CONSERVATION_SUCCESS = 400104;
    public static final int YT_SDK_AUTH_ERROR = 1048576;
    public static final int YT_SDK_CAMERA_ERROR = 3145730;
    public static final int YT_SDK_FACETRACE_INIT_FAILED = 5242881;
    public static final int YT_SDK_IMAGEREFINE_INIT_FAILED = 5242884;
    public static final int YT_SDK_JSON_PARAM_ERROR = 3145729;
    public static final int YT_SDK_NETWORK_ERROR = 2097153;
    public static final int YT_SDK_OCR_RECOGNIZED_FAIL = 400101;
    public static final int YT_SDK_PARAM_ERROR = 3145728;
    public static final int YT_SDK_POSEDETECT_INIT_FAILED = 5242882;
    public static final int YT_SDK_REFLECTION_ANGLE_DETECT_FAIL = 400103;
    public static final int YT_SDK_REFLECTION_COLOR_DATA_PARSE_ERROR = -1000027;
    public static final int YT_SDK_REFLECT_INIT_FAILED = 5242883;
    public static final int YT_SDK_TIMETICK_ERROR = 3145731;
    public static final int YT_SDK_USER_CANCEL = 6291457;
    public static final int YT_SDK_VERIFY_ERROR = 4194304;
    public static final int YT_SDK_VERIFY_MODEL_INIT_FAIL = 300101;
    public static final int YT_SDK_VERIFY_NET_RET_FAILED = 4194306;
    public static final int YT_SDK_VERIFY_SCORE_FAILED = 4194305;
    public static final int YT_SDK_VERIFY_TIMEOUT = 4194307;

    public ErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
