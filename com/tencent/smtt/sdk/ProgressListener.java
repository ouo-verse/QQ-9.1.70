package com.tencent.smtt.sdk;

/* loaded from: classes23.dex */
public interface ProgressListener {
    public static final int CALLER_STOP_DOWNLOAD = -6;
    public static final int DYNAMIC_INSTALL_APP_ERROR_NO_PN = -1009;
    public static final int DYNAMIC_INSTALL_APP_ERROR_NO_SIG = -1010;
    public static final int DYNAMIC_INSTALL_CONFIG_DATA_BROKEN = -1004;
    public static final int DYNAMIC_INSTALL_CONFIG_DATA_ILLEGAL = -1003;
    public static final int DYNAMIC_INSTALL_CONFIG_FILE_BROKEN = -1001;
    public static final int DYNAMIC_INSTALL_CONFIG_FILE_ILLEGAL = -1002;
    public static final int DYNAMIC_INSTALL_CONFIG_NOT_EXIST = -1000;
    public static final int DYNAMIC_INSTALL_CONFIG_PN_ERROR = -1011;
    public static final int DYNAMIC_INSTALL_CONFIG_SIG_ERROR = -1012;
    public static final int DYNAMIC_INSTALL_FORMAT_FAILED = -1005;
    public static final int DYNAMIC_INSTALL_REQUEST_FAILED = -1006;
    public static final int DYNAMIC_INSTALL_RESPONSE_FORMAT_ERROR = -1007;
    public static final int DYNAMIC_INSTALL_SERVER_ERROR = -1008;
    public static final int HTTP_LENGTH_NOT_MATCH = -7;
    public static final int HTTP_READ_NOTHING_FROM_BUFFER = -9;
    public static final int HTTP_REDIRECT_LOCATION_NULL = -10;
    public static final int HTTP_RESPONSE_STREAM_NULL = -8;
    public static final int INIT_CORE_VERSION_ZERO = -19;
    public static final int INIT_REMOTE_FLOWED = -20;
    public static final int INIT_URL_EMPTY = -18;
    public static final int OTHER_PROCESS_LOCK = -2;
    public static final int OUT_OF_MAX_RETRY = -3;
    public static final int OUT_OF_SPACE = -5;
    public static final int REDIRECT_TOO_MUCH = -4;
    public static final int REQUEST_PARAM_ERROR = -21;
    public static final int UNKNOWN = -1;
    public static final int VERIFY_DOWNLOAD_FORBIDDEN = -16;
    public static final int VERIFY_FILE_LENGTH_ERROR = -12;
    public static final int VERIFY_FILE_NOT_EXIST_ERROR = -14;
    public static final int VERIFY_MD5_ERROR = -11;
    public static final int VERIFY_RENAME_FAILED = -17;
    public static final int VERIFY_SIGNATURE_ERROR = -13;
    public static final int VERIFY_VERSION_ERROR = -15;

    void onFailed(int i3, String str);

    void onFinished();

    void onProgress(int i3);
}
