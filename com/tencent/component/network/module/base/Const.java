package com.tencent.component.network.module.base;

import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Const {
    public static final long CONN_CLEAN_PERIOD_MILLIS = 30000;
    public static final long DEFAULT_IP_VALID_TIME = 604800000;
    public static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE;
    public static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE_PROXY;
    public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_DISABLE = 1;
    public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_ENABLE = 0;
    public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_IGNORE = 2;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class DownloadType {
        public static final int DOWNLOADER_TYPE_COMMON = 2;
        public static final int DOWNLOADER_TYPE_IMAGE = 1;

        public DownloadType() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ErrorCode {
        public static final int LOCAL_RET_CODE_CLIENT_PROTOCOL_EXP = 8;
        public static final int LOCAL_RET_CODE_CONNECT_CLOSED_EXP = 14;
        public static final int LOCAL_RET_CODE_CONNECT_NOT_OPEN = 50007;
        public static final int LOCAL_RET_CODE_CONNECT_POOL_TIMEOUT_EXP = 13;
        public static final int LOCAL_RET_CODE_CONNECT_REFUSED = 50006;
        public static final int LOCAL_RET_CODE_CONNECT_TIMEOUT_EXP = 10;
        public static final int LOCAL_RET_CODE_CONTENT_LENGTH_VALID = 50002;
        public static final int LOCAL_RET_CODE_DECODE_FAILED = -4;
        public static final int LOCAL_RET_CODE_EXP = 4;
        public static final int LOCAL_RET_CODE_FNF_EXP = 1;
        public static final int LOCAL_RET_CODE_ILLEGAL_FORMAT = -1;
        public static final int LOCAL_RET_CODE_ILLEGAL_FORMAT_360WIFI = 50001;
        public static final int LOCAL_RET_CODE_ILL_EXP = 5;
        public static final int LOCAL_RET_CODE_IO_EXP = 2;
        public static final int LOCAL_RET_CODE_LENGTH_MISMATCH = -3;
        public static final int LOCAL_RET_CODE_LENGTH_MISMATCH_NEW = 50008;
        public static final int LOCAL_RET_CODE_NETWORK_FAIL = -99997;
        public static final int LOCAL_RET_CODE_NETWORK_UNREACHABLE = 50004;
        public static final int LOCAL_RET_CODE_NOSPACE_LEFT_ON_DEVICE = 50003;
        public static final int LOCAL_RET_CODE_NO_CACHE = -2;
        public static final int LOCAL_RET_CODE_NO_HTTP_RSP_EXP = 11;
        public static final int LOCAL_RET_CODE_NO_ROUTE_TO_HOST = 50005;
        public static final int LOCAL_RET_CODE_OOM_ERR = 3;
        public static final int LOCAL_RET_CODE_SOCKET_EXP = 6;
        public static final int LOCAL_RET_CODE_SOCKET_TO_EXP = 7;
        public static final int LOCAL_RET_CODE_SSL_HANDSHAKE_EXP = 15;
        public static final int LOCAL_RET_CODE_SSL_PEER_UNVERIFIED_EXP = 12;
        public static final int LOCAL_RET_CODE_TRY_FAILED = -99998;
        public static final int LOCAL_RET_CODE_TYPE_MISMATCH = -99996;
        public static final int LOCAL_RET_CODE_UNKNOW = -99999;
        public static final int LOCAL_RET_CODE_UNKNOW_HOST_EXP = 9;

        public ErrorCode() {
        }
    }

    static {
        KeepAliveStrategy.KeepAlive keepAlive = KeepAliveStrategy.KeepAlive.DISABLE;
        DEFAULT_KEEP_ALIVE = keepAlive;
        DEFAULT_KEEP_ALIVE_PROXY = keepAlive;
    }
}
