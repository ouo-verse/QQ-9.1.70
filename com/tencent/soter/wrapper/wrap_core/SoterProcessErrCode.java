package com.tencent.soter.wrapper.wrap_core;

import com.tencent.soter.core.model.SoterErrCode;

/* loaded from: classes25.dex */
public interface SoterProcessErrCode extends SoterErrCode {
    public static final int ERR_ACCOUNT_SALT_LEN_TOO_LONG = 1025;
    public static final int ERR_ADD_TASK_FAILED = 1023;
    public static final int ERR_ALREADY_INITIALIZED = 1028;
    public static final int ERR_AUTHKEY_ALREADY_EXPIRED = 1005;
    public static final int ERR_AUTHKEY_NOT_FOUND = 1006;
    public static final int ERR_AUTH_KEY_NOT_IN_MAP = 1009;
    public static final int ERR_BIOMETRIC_AUTHENTICATION_FAILED = 1017;
    public static final int ERR_BIOMETRIC_LOCKED = 1022;
    public static final int ERR_BIOMETRIC_LOCKED_PERMENANT = 1022;
    public static final int ERR_CLICK_NEGATIVE_BUTTON = 1029;
    public static final int ERR_CONTEXT_INSTANCE_NOT_EXISTS = 1011;
    public static final int ERR_CUSTOM_ASK_NAME_TOO_LONG = 1026;
    public static final int ERR_FINGERPRINT_AUTHENTICATION_FAILED = 1016;
    public static final int ERR_FINGERPRINT_LOCKED = 1021;
    public static final int ERR_GET_CHALLENGE = 1014;
    public static final int ERR_GET_SUPPORT_SOTER_REMOTE_FAILED = 1002;
    public static final int ERR_INIT_SIGN_FAILED = 1007;
    public static final int ERR_NOT_INIT_WRAPPER = 1008;
    public static final int ERR_NO_BIOMETRIC_ENROLLED = 1013;
    public static final int ERR_NO_BUSINESS_SCENE_PROVIDED = 1024;
    public static final int ERR_NO_FINGERPRINT_ENROLLED = 1012;
    public static final int ERR_NO_NET_WRAPPER = 1010;
    public static final int ERR_SIGNATURE_INVALID = 1027;
    public static final int ERR_SIGN_FAILED = 1018;
    public static final int ERR_START_AUTHEN_FAILED = 1015;
    public static final int ERR_UNEXPECTED_PURPOSE = 1001;
    public static final int ERR_UPLOAD_ASK_FAILED = 1003;
    public static final int ERR_UPLOAD_AUTH_KEY_FAILED = 1004;
    public static final int ERR_UPLOAD_OR_VERIFY_SIGNATURE_FAILED = 1019;
    public static final int ERR_USER_CANCELLED = 1020;
}
