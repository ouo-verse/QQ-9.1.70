package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferDef {
    public static final int CHAT_TYPE_C2C = 0;
    public static final int CHAT_TYPE_DISCUSS = 2;
    public static final int CHAT_TYPE_GROUP = 1;
    public static final int CHAT_TYPE_TEMP = 3;
    public static final int CLIENT_TYPE_ANDROIDQQ = 2;
    public static final int CLIENT_TYPE_IOSQQ = 3;
    public static final int CLIENT_TYPE_PCQQ = 1;
    public static final int CLIENT_TYPE_UNKONW = 0;
    public static final int TERMINAL_TYPE_ANDROID = 2;
    public static final int TERMINAL_TYPE_IOS = 3;
    public static final int TERMINAL_TYPE_PC = 1;
    public static final int TERMINAL_TYPE_UNKONW = 0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class Recv {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        public static class EMDownloadResult {
            public static final int EMDOWNLOAD_RESULT_CANCELED = 101;
            public static final int EMDOWNLOAD_RESULT_CONNECT_BEGIN = 300;
            public static final int EMDOWNLOAD_RESULT_CONNECT_CALL_ERROR = 302;
            public static final int EMDOWNLOAD_RESULT_CONNECT_END = 400;
            public static final int EMDOWNLOAD_RESULT_CONNECT_FAILED = 303;
            public static final int EMDOWNLOAD_RESULT_CONNECT_PARAM_ERROR = 301;
            public static final int EMDOWNLOAD_RESULT_CONNECT_SSL_FAILED = 304;
            public static final int EMDOWNLOAD_RESULT_CONNECT_SSL_RECV_FAILED = 306;
            public static final int EMDOWNLOAD_RESULT_CONNECT_SSL_SEND_FAILED = 305;
            public static final int EMDOWNLOAD_RESULT_CONNECT_SSL_WRITE_FAILED = 307;
            public static final int EMDOWNLOAD_RESULT_CONNECT_VERIFY_FAILED = 308;
            public static final int EMDOWNLOAD_RESULT_FILE_CHECK_MD5_FAILED = 504;
            public static final int EMDOWNLOAD_RESULT_FILE_CREATE_FAILED = 501;
            public static final int EMDOWNLOAD_RESULT_FILE_OPEN_FAILED = 502;
            public static final int EMDOWNLOAD_RESULT_FILE_RENAME_FAILED = 505;
            public static final int EMDOWNLOAD_RESULT_FILE_WRITE_FAILED = 503;
            public static final int EMDOWNLOAD_RESULT_HTTP_RANGE_ERROR = 407;
            public static final int EMDOWNLOAD_RESULT_HTTP_SERVER_REFUSE = 408;
            public static final int EMDOWNLOAD_RESULT_INTERNAL_ERROR = 201;
            public static final int EMDOWNLOAD_RESULT_NOT_ENOUGH_SPACE = 506;
            public static final int EMDOWNLOAD_RESULT_OK = 0;
            public static final int EMDOWNLOAD_RESULT_RECV_BODY_ERROR = 406;
            public static final int EMDOWNLOAD_RESULT_RECV_ERROR = 402;
            public static final int EMDOWNLOAD_RESULT_RECV_HEADER_ERROR = 405;
            public static final int EMDOWNLOAD_RESULT_RECV_SERVER_CLOSED = 404;
            public static final int EMDOWNLOAD_RESULT_RECV_TIMEOUT = 403;
            public static final int EMDOWNLOAD_RESULT_RECV_ZERO = 401;
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        public static class ReceiveResultCS {
            public static final int RECEIVE_RESULT_CS_REQ_DOWNLOAD_DANGER_FILE = 4;
            public static final int RECEIVE_RESULT_CS_REQ_DOWNLOAD_DOWNLOAD_INFO_NULL = 5;
            public static final int RECEIVE_RESULT_CS_REQ_DOWNLOAD_DOWNLOAD_URL_NULL = 6;
            public static final int RECEIVE_RESULT_CS_REQ_DOWNLOAD_REFUSE = 3;
            public static final int RECEIVE_RESULT_CS_REQ_DOWNLOAD_RSP_DATA_NULL = 2;
            public static final int RECEIVE_RESULT_CS_REQ_DOWNLOAD_SERVER_RETURN_ERR = 7;
            public static final int RECEIVE_RESULT_CS_REQ_DOWNLOAD_TIMEOUT = 1;
            public static final int RECEIVE_RESULT_CS_SEND_SUCC_FAILED = 12;
            public static final int RECEIVE_RESULT_CS_SEND_SUCC_REPLY_DATA_NULL = 13;
            public static final int RECEIVE_RESULT_CS_SEND_SUCC_RSP_DATA_NULL = 14;
            public static final int RECEIVE_RESULT_CS_SEND_SUCC_SERVER_FAILED = 15;
            public static final int RECEIVE_RESULT_CS_SEND_SUCC_TIMEOUT = 11;
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        public static class ReceiveResultIO {
            public static final int RECEIVE_RESULT_IO_NO_SPACE = 3;
            public static final int RECEIVE_RESULT_IO_OPEN_FAILED = 1;
            public static final int RECEIVE_RESULT_IO_SAVE_PATH_ERROR = 2;
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        public static class ReceiveResultInternal {
            public static final int RECEIVE_RESULT_INTERNAL_NO_NET_WORK = 3;
            public static final int RECEIVE_RESULT_INTERNAL_RETRY_EXCEED = 2;
            public static final int RECEIVE_RESULT_INTERNAL_UUID_INVALID = 1;
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        public static class ReceiveResultType {
            public static final int RECEIVE_RESULT_TYPE_CS = 2;
            public static final int RECEIVE_RESULT_TYPE_HTTP = 4;
            public static final int RECEIVE_RESULT_TYPE_INTERNAL = 5;
            public static final int RECEIVE_RESULT_TYPE_IO = 3;
            public static final int RECEIVE_RESULT_TYPE_SUC = 0;
            public static final int RECEIVE_RESULT_TYPE_USER = 1;
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        public static class ReceiveResultUser {
            public static final int RECEIVE_RESULT_USER_CANCEL_NOT_START = 2;
            public static final int RECEIVE_RESULT_USER_CANCEL_OTHER_TERM = 4;
            public static final int RECEIVE_RESULT_USER_CANCEL_STARTED = 3;
            public static final int RECEIVE_RESULT_USER_REFUSE = 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class Send {
        public static final int BIG_DATA_CMD_ID_UPLOAD_DATA_LINE = 72;
        public static final int BIG_DATA_CMD_ID_UPLOAD_GROUP = 71;
        public static final int BIG_DATA_CMD_ID_UPLOAD_GUILD = 86;
        public static final int BIG_DATA_CMD_ID_UPLOAD_OFFLINE_FILE = 69;
        public static final int FILE_BUSINESS_ID_GROUP = 102;
        public static final int FILE_BUSINESS_ID_GROUP_TEMP = 104;
        public static final int FILE_BUSINESS_ID_GUILD = 4202;
        public static final int FILE_BUSINESS_ID_OFFLINE = 3;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        public static class DataReport {
            public static final int APP_TYPE_QQ = 0;
            public static final int PLATRFORM_ANDROID_QQ = 2;
            public static final int PLATRFORM_IOS_QQ = 1;
            public static final int PLATRFORM_PC_QQ = 0;
            public static final int UPLOAD_TYPE_BUDDY = 0;
            public static final int UPLOAD_TYPE_GROUP = 2;
            public static final int UPLOAD_TYPE_TEMP = 1;
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        public static class ResultCode {
            public static final int EMSENDER_RESULT_CAN_NOT_CONNECT = 1;
            public static final int EMSENDER_RESULT_CSFAIL = 31;
            public static final int EMSENDER_RESULT_CSTIME_OUT = 30;
            public static final int EMSENDER_RESULT_DELAY_RETRY_FAIL = 19;
            public static final int EMSENDER_RESULT_DELAY_TOO_MUCH_FAIL = 20;
            public static final int EMSENDER_RESULT_FILE_EXCEPTION = 8;
            public static final int EMSENDER_RESULT_HASH_CAL_FAIL = 32;
            public static final int EMSENDER_RESULT_NET_WORK_FAIL = 2;
            public static final int EMSENDER_RESULT_NO_AVAIL_IP = 18;
            public static final int EMSENDER_RESULT_OK = 0;
            public static final int EMSENDER_RESULT_OTHER_ERR = 17;
            public static final int EMSENDER_RESULT_PARAMETER_ERR = 7;
            public static final int EMSENDER_RESULT_QUERY_FAIL = 14;
            public static final int EMSENDER_RESULT_QUERY_TIME_OUT = 15;
            public static final int EMSENDER_RESULT_RANG_DIFF_TOO_LARGE = 16;
            public static final int EMSENDER_RESULT_ROLL_BACK_TOO_MUCH = 13;
            public static final int EMSENDER_RESULT_SENDER_GENERAL_ERR = 11;
            public static final int EMSENDER_RESULT_SERVER_CLOSE = 6;
            public static final int EMSENDER_RESULT_SERVER_DENY_ERR = 4;
            public static final int EMSENDER_RESULT_SERVER_ERR = 5;
            public static final int EMSENDER_RESULT_SERVER_RESET = 12;
            public static final int EMSENDER_RESULT_SERVER_RSP_FORMAT_ERR = 3;
            public static final int EMSENDER_RESULT_TIME_OUT = 9;
            public static final int EMSENDER_RESULT_UER_CANCEL = 33;
            public static final int EMSENDER_RESULT_WATCH_DOG_TIME_OUT = 10;
        }
    }
}
