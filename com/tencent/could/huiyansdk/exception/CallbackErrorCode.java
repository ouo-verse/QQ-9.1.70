package com.tencent.could.huiyansdk.exception;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CallbackErrorCode {
    static IPatchRedirector $redirector_ = null;
    public static final int HY_ACTION_REFLECTIVE_SDK_ERROR = 228;
    public static final int HY_APP_STOP_ERROR = 219;
    public static final int HY_BOT_TIME_OUT = 287;
    public static final int HY_CHECK_LIGHT_DATA_ERROR = 226;
    public static final int HY_CHECK_LIVE_DATA_ERROR = 220;
    public static final int HY_CHECK_PACKAGE_SIZE_ERROR = 225;
    public static final int HY_CHECK_PERMISSION_ERROR = 224;
    public static final int HY_DO_NOT_CHANGE_ERROR = 214;
    public static final int HY_ILLEGAL_TOKEN = 288;
    public static final int HY_INITIALIZATION_PARAMETER_EXCEPTION = 221;
    public static final int HY_INIT_SDK_ERROR = 216;
    public static final int HY_INNER_CAMERA_HOLDER_IS_NULL = -703;
    public static final int HY_INNER_CAMERA_VIEW_IS_NULL = -704;
    public static final int HY_INNER_ERROR_CODE = 213;
    public static final int HY_INNER_GET_CAMERA_SIZE_ERROR = -705;
    public static final int HY_INNER_TURING_INTERFACE_IS_NULL = -702;
    public static final int HY_INNER_TURING_NOT_CREATE = -701;
    public static final int HY_LOCAL_REF_FAILED_ERROR = 211;
    public static final int HY_NETWORK_ERROR = 210;
    public static final int HY_OPEN_CAMERA_ERROR = 215;
    public static final int HY_PERMISSION_CHECK_ERROR = 218;
    public static final int HY_PREPARE_TIME_OUT = 223;
    public static final int HY_RISK_DATA_EXCEPTION = 304;
    public static final int HY_RISK_INIT_AUTH_ERROR = 231;
    public static final int HY_SDK_GET_CONFIG_ERROR = 286;
    public static final int HY_SDK_INIT_MODEL_ERROR = 285;
    public static final int HY_SET_DISPLAY_ORIENTATION_ERROR = 230;
    public static final int HY_USER_CANCEL_ERROR = 212;
    public static final int HY_USE_BACK_CAMERA_WITH_REFLECTIVE_ERROR = 227;
    public static final int HY_VERIFY_LOCAL_ERROR = 217;
    public static final int HY_VERIFY_LOCAL_TIME_OUT = 222;
    public static final int HY_YT_FACE_REF_ANGLE_DETECT_ERROR = 229;

    CallbackErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
