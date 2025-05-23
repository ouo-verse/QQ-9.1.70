package com.tencent.weiyun.transmission.utils;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.ErrorCode;

/* compiled from: P */
/* loaded from: classes27.dex */
class ErrorMessages {
    static IPatchRedirector $redirector_ = null;
    private static final String ERR_COMMON_TIPS = "\u51fa\u73b0\u9519\u8bef \u8bf7\u91cd\u8bd5!";
    private static final String ERR_DST_FILE_NOT_EXIST = "\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5df2\u7ecf\u88ab\u5220\u9664";
    private static final String ERR_FILE_MODIFIED = "\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5df2\u7ecf\u88ab\u5220\u9664";
    private static final String ERR_FILE_NOT_ACCESS = "\u8bfb\u5199\u6587\u4ef6\u5931\u8d25";
    private static final String ERR_FILE_SIZE_EXCEED = "\u6587\u4ef6\u5927\u5c0f\u8d85\u51fa2G\u9650\u5236!";
    private static final String ERR_FILE_TYPE_NOT_SUPPORT = "\u8be5\u6587\u4ef6\u7c7b\u578b\u6682\u4e0d\u652f\u6301!";
    private static final String ERR_INVALID_PARAMETER = "\u65e0\u6548\u7684\u53c2\u6570!";
    private static final String ERR_INVALID_PROTO = "\u65e0\u6548\u7684\u534f\u8bae!";
    private static final String ERR_NETWORK_EXCEPTION = "\u7f51\u7edc\u53d1\u751f\u5f02\u5e38 \u8bf7\u68c0\u67e5\u60a8\u7684\u7f51\u7edc\u8bbe\u7f6e!";
    private static final String ERR_NETWORK_NOT_AVAILABLE = "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528!";
    private static final String ERR_NETWORK_TIMEOUT = "\u7f51\u7edc\u8d85\u65f6 \u8bf7\u68c0\u67e5\u60a8\u7684\u7f51\u7edc\u8bbe\u7f6e!";
    private static final String ERR_NO_NETWORK = "\u6ca1\u6709\u7f51\u7edc!";
    private static final String ERR_QQDISK_ADD_UPLOAD_TASK_FAIL = "\u4e0a\u4f20\u4efb\u52a1\u6dfb\u52a0\u5931\u8d25!";
    private static final String ERR_QQDISK_DOWNLOAD_DIR = "\u6682\u4e0d\u652f\u6301\u4e0b\u8f7d\u76ee\u5f55!";
    private static final String ERR_QQDISK_DOWNLOAD_LACK_SPACE = "sd\u5361\u7a7a\u95f4\u4e0d\u8db3!";
    private static final String ERR_QQDISK_DOWNLOAD_UNABLE_OVERWRITE = "\u65e0\u6cd5\u8986\u76d6\u540c\u540d\u6587\u4ef6!";
    private static final String ERR_QQDISK_INVALID_RSP = "\u65e0\u6548\u7684\u54cd\u5e94!";
    private static final String ERR_QQDISK_NO_LOGIN = "\u60a8\u8fd8\u6ca1\u6709\u767b\u5f55 \u8bf7\u5148\u767b\u5f55!";
    private static final String ERR_QQDISK_SERVER_ERROR = "\u670d\u52a1\u5668\u9519\u8bef!";
    private static final String ERR_QQDISK_TOO_MANY_FILES = "\u6587\u4ef6\u6570\u91cf\u592a\u591a!";
    private static final String ERR_QQDISK_UPLOAD_DIR = "\u6682\u65f6\u4e0d\u652f\u6301\u4e0a\u4f20\u76ee\u5f55!";
    private static final String ERR_QQDISK_UPLOAD_LACK_SPACE = "\u8f6c\u5b58\u5931\u8d25\uff0c\u5fae\u4e91\u7a7a\u95f4\u4e0d\u8db3!";
    private static final String ERR_QQDISK_UPLOAD_TO_ROOT = "\u4e0d\u80fd\u4e0a\u4f20\u5230\u6839\u76ee\u5f55!";
    private static final String ERR_RECV_FAILED = "\u63a5\u6536\u6570\u636e\u5931\u8d25!";
    private static final String ERR_REQUEST_UPLOAD_ADDRESS_TIME = "\u8bf7\u6c42\u4e0a\u4f20\u5730\u5740\u8d85\u65f6!";
    private static final String ERR_SEND_FAILED = "\u6570\u636e\u53d1\u9001\u5931\u8d25!";
    private static final String ERR_SEND_REQUEST_ERROR = "\u53d1\u9001\u8bf7\u6c42\u51fa\u9519!";
    private static final String ERR_SRC_FILE_NOT_EXIST = "\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5df2\u7ecf\u88ab\u5220\u9664";
    private static final String ERR_THUNBNAIL_NOT_EXIST = "\u7f29\u7565\u56fe\u4e0d\u5b58\u5728!";
    private static final String ERR_UNKNOWN_EXCEPTION = "\u64cd\u4f5c\u51fa\u9519 \u8bf7\u91cd\u8bd5\uff01";
    private static final String ERR_UPLOAD_ADDRESS = "\u9519\u8bef\u7684\u4e0a\u4f20\u5730\u5740!";
    private static final String ERR_USER_CANCELED = "\u53d6\u6d88\u4e86\u4e0a\u4f20\u3001\u4e0b\u8f7d\u8fc7\u7a0b!";
    private static final String ERR_WRONG_HTTP_RESPONSE = "\u4e0b\u8f7d\u5931\u8d25 \u6587\u4ef6\u88ab\u5220\u9664\u6216\u8005\u6ca1\u6709\u6743\u9650\u4e0b\u8f7d!";
    private static final String TAG = "ErrorMessages";
    private static final SparseArray<String> sErrorMessageMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        sErrorMessageMap = sparseArray;
        sparseArray.put(1830001, ERR_NETWORK_TIMEOUT);
        sparseArray.put(1830002, ERR_NETWORK_TIMEOUT);
        sparseArray.put(1830003, ERR_NETWORK_EXCEPTION);
        sparseArray.put(1830004, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_RESET_BY_PEER, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_BROKEN_PIPE, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_TOO_MANY_OPEN_FILES, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_BIND_ERROR, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_ADDRESS_FAMILY, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_CONNECT_FAIL, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_CONN_REFUSED, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_UNKNOWN_HOST, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_PROTOCOL, ERR_INVALID_PROTO);
        sparseArray.put(ErrorCode.TRAN_SOCKET_PORT_UNREACHABLE, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_NO_ROUT_TO_HOST, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_END_OF_FILE, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_CONN_CLOSE_ERROR, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_ERROR, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_MALFORMED_URL, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_ERROR_OTHERS, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_SOCKET_UNEXPECTED_END_OF_STREAM, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_CHANNEL_ASYNCHRONOUS_CLOSE, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_CHANNEL_CLOSED_BY_INTERRUPT, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_CHANNEL_NOT_YET_CONNECTED, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_CHANNEL_CLOSED, ERR_NETWORK_EXCEPTION);
        sparseArray.put(ErrorCode.TRAN_HTTP_EMPTY_BODY, ERR_QQDISK_INVALID_RSP);
        sparseArray.put(ErrorCode.TRAN_HTTP_EMPTY_PART, ERR_QQDISK_INVALID_RSP);
        sparseArray.put(ErrorCode.TRAN_HTTP_INVALID_URL, ERR_INVALID_PARAMETER);
        sparseArray.put(ErrorCode.TRAN_HTTP_READ_CONTENT_ERROR, ERR_QQDISK_INVALID_RSP);
        sparseArray.put(ErrorCode.TRAN_SEND_REQUEST_EXCEPTION, ERR_SEND_REQUEST_ERROR);
        sparseArray.put(ErrorCode.TRAN_UPLOAD_ADDRESS_INVALID, ERR_UPLOAD_ADDRESS);
        sparseArray.put(ErrorCode.TRAN_UPLOAD_REQUEST_TIMEOUT, ERR_REQUEST_UPLOAD_ADDRESS_TIME);
        sparseArray.put(ErrorCode.TRAN_ADDRESS_IS_EMPTY, ERR_INVALID_PARAMETER);
        sparseArray.put(ErrorCode.TRAN_OFFSET_IS_WRONG, ERR_INVALID_PARAMETER);
        sparseArray.put(ErrorCode.TRAN_INVALID_PARAMETER, ERR_INVALID_PARAMETER);
        sparseArray.put(ErrorCode.TRAN_NO_NETWORK, ERR_NO_NETWORK);
        sparseArray.put(ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, ERR_NETWORK_NOT_AVAILABLE);
        sparseArray.put(ErrorCode.TRAN_REMOTE_FILE_NOT_EXIST, "\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5df2\u7ecf\u88ab\u5220\u9664");
        sparseArray.put(ErrorCode.TRAN_LOCAL_FILE_NOT_EXIST, "\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5df2\u7ecf\u88ab\u5220\u9664");
        sparseArray.put(ErrorCode.TRAN_DIR_CREATE_FAIL, ERR_FILE_NOT_ACCESS);
        sparseArray.put(ErrorCode.TRAN_FILE_SEEK_FAILED, ERR_FILE_NOT_ACCESS);
        sparseArray.put(ErrorCode.TRAN_FILE_TYPE_NOT_SUPPORT, ERR_FILE_TYPE_NOT_SUPPORT);
        sparseArray.put(ErrorCode.TRAN_FILE_MODIFIED, "\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5df2\u7ecf\u88ab\u5220\u9664");
        sparseArray.put(ErrorCode.TRAN_FILE_SIZE_EXCEED, ERR_FILE_SIZE_EXCEED);
        sparseArray.put(ErrorCode.TRAN_XERRNO_THUMBNAIL_NOT_EXIST, ERR_THUNBNAIL_NOT_EXIST);
        sparseArray.put(ErrorCode.TRAN_USER_CANCELED, ERR_USER_CANCELED);
        sparseArray.put(ErrorCode.TRAN_UNKNOWN_EXCEPTION, ERR_UNKNOWN_EXCEPTION);
        sparseArray.put(ErrorCode.CMD_SERVER_ERROR, ERR_QQDISK_SERVER_ERROR);
        sparseArray.put(ErrorCode.CMD_INVALID_RSP, ERR_QQDISK_INVALID_RSP);
        sparseArray.put(ErrorCode.CMD_NO_LOGIN, ERR_QQDISK_NO_LOGIN);
        sparseArray.put(ErrorCode.TRAN_UPLOAD_SPACE_LACK, ERR_QQDISK_UPLOAD_LACK_SPACE);
        sparseArray.put(ErrorCode.TRAN_DOWNLOAD_SPACE_LACK, ERR_QQDISK_DOWNLOAD_LACK_SPACE);
        sparseArray.put(ErrorCode.TRAN_UPLOAD_NO_SUPPORT_DIR, ERR_QQDISK_UPLOAD_DIR);
    }

    ErrorMessages() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getErrorString(int i3) {
        String str = sErrorMessageMap.get(i3);
        if (str == null) {
            TsLog.w(TAG, "Not find the error string, please check classes ErrorCode and ErrorMessage.");
            return null;
        }
        return str;
    }
}
