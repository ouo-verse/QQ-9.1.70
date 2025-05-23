package com.tencent.weiyun.uploader.xplatform;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadError {
    static IPatchRedirector $redirector_ = null;
    public static final int BUSI_CHANNEL_CHECK_ERR = 10009;
    public static final int BUSI_CHANNEL_EMPTY = 10007;
    public static final int BUSI_CHANNEL_ERROR = 10008;
    public static final int BUSI_CHANNEL_RSP_EMPTY = 10030;
    public static final int BUSI_EMPTY_RESULT = 10005;
    public static final int BUSI_GETDATA_EMPTY = 10006;
    public static final int BUSI_HANDLE_NO_MATCH = 10003;
    public static final int BUSI_SELECT_ERROR = 10001;
    public static final int BUSI_SELECT_TIMEOUT = 10002;
    public static final int BUSI_SEND_NO_FINISH = 10004;
    public static final int BUSI_TASK_MISS_WARNING = 10010;
    public static final int CURL_FAILED_TO_CONNECT_HOST = 20007;
    public static final int CURL_FAILURE_WITH_RECEIVING = 20056;
    public static final int CURL_FAILURE_WITH_TIMEOUT = 20028;

    public UploadError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isBusinessError(int i3) {
        if (i3 > 10000) {
            return true;
        }
        return false;
    }

    public static boolean isCurlError(int i3) {
        if (i3 <= 20100 && i3 > 20000) {
            return true;
        }
        return false;
    }

    public static boolean isServerError(int i3) {
        if (i3 < 0) {
            return true;
        }
        return false;
    }
}
