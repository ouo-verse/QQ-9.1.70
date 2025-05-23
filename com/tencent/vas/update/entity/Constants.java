package com.tencent.vas.update.entity;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Constants {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class Cmd {
        public static final String CMD_GETURL = "GetUrlReq";
        public static final String CMD_RSP_GETURL = "GetUrlRsp";
        public static final String CMD_RSP_SYNCVCR = "SyncVCRRsp";
        public static final String CMD_SYNCVCR = "SyncVCRReq";

        public Cmd() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class CompressMode {
        public static final int COMPRESS_GZ = 2;
        public static final int COMPRESS_LZMA = 4;
        public static final int COMPRESS_NONE = 0;
        public static final int COMPRESS_ZIP = 1;

        public CompressMode() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class DbTable {
        public static final int TABLE_FILE_MD5 = 2;
        public static final int TABLE_LOCAL = 0;
        public static final int TABLE_POLLTIME = 3;
        public static final int TABLE_SHOULD_UPDATE = 1;

        public DbTable() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class DeltaMode {
        public static final int DELTA_BSDIFF = 1;
        public static final int DELTA_NORMAL = 0;

        public DeltaMode() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class DownloadFrom {
        public static final int DLFROM_CONTINUE_FLAG = 4;
        public static final int DLFROM_LOGIN = 1;
        public static final int DLFROM_MANUAL = 3;
        public static final int DLFROM_ONTIMER = 2;
        public static final int DLFROM_QUEUE_DOWNLOAD = 5;
        public static final int DLFROM_UNKNOW = 0;

        public DownloadFrom() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class LocalNetType {
        public static final int NET_TYPE_2G = 5;
        public static final int NET_TYPE_3G = 4;
        public static final int NET_TYPE_4G = 3;
        public static final int NET_TYPE_NOT_REACH = 1;
        public static final int NET_TYPE_UNKNOW = 0;
        public static final int NET_TYPE_WIFI = 2;
        public static final int NET_TYPE_XG = 6;

        public LocalNetType() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class NetType {
        public static final int MASK_NET_2G = 2;
        public static final int MASK_NET_3G = 4;
        public static final int MASK_NET_4G = 8;
        public static final int MASK_NET_WIFI = 1;
        public static final int MASK_NET_XG = 14;

        public NetType() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class Report {
        public static final String PLATFORM_ANDROID = "2";

        public Report() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SyncErrorCode {
        public static final int SYNC_RESULT_ERROR = 1;
        public static final int SYNC_SENDPB_ERR = 3;
        public static final int SYNC_SUCCESS = 0;
        public static final int SYNC_SWITCH_STOP = 2;

        public SyncErrorCode() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SyncItemOptType {
        public static final int TYPE_DELETE = 2;
        public static final int TYPE_MODIFIED = 1;

        public SyncItemOptType() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SyncMode {
        public static final int SYNC_ALL = 0;
        public static final int SYNC_INCREMENT = 1;

        public SyncMode() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SyncSwitchType {
        public static final int SYNC_SWITCH_TYPE_STOP = 1;

        public SyncSwitchType() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class Timer {
        public static final int TYPE_GET_URL = 1;
        public static final int TYPE_UPDATE_ITEM = 2;

        public Timer() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class UpdateErrorCode {
        public static final int UPDATE_BSPATCH_COPY_ERR = 22;
        public static final int UPDATE_BSPATCH_ERR = 15;
        public static final int UPDATE_CHECK_MD5_ERR = 17;
        public static final int UPDATE_DELAY_RETRY = 20;
        public static final int UPDATE_DELTA_MODE_ERR = 16;
        public static final int UPDATE_DOWNLOAD_EMPTY_LIMIT = 24;
        public static final int UPDATE_DOWNLOAD_FILE_ERR = 23;
        public static final int UPDATE_DOWNLOAD_FLOW_LIMIT2 = 25;
        public static final int UPDATE_DOWNLOAD_PARAM_ERROR = 6;
        public static final int UPDATE_FLOW_LIMIT = 10;
        public static final int UPDATE_FROM_NULL = 11;
        public static final int UPDATE_HTTP_ERROR = 8;
        public static final int UPDATE_IGNORE_DOWNLOAD = 26;
        public static final int UPDATE_MOVEFILE_ERR = 12;
        public static final int UPDATE_NEED_DOWNLOAD = 1;
        public static final int UPDATE_NO_SORAGE_MODE = 18;
        public static final int UPDATE_NO_UNCOMPRESS_MODE = 14;
        public static final int UPDATE_REQ_URL_SENDPB_ERR = 2;
        public static final int UPDATE_REQ_URL_TIMEOUT = 3;
        public static final int UPDATE_RSP_URL_CODE_ERR = 4;
        public static final int UPDATE_RSP_URL_DSTMD5_ERR = 5;
        public static final int UPDATE_RSP_URL_MD5_ERROR = 21;
        public static final int UPDATE_RSP_URL_NOT_EXIST = 19;
        public static final int UPDATE_SIZE_ERROR = 7;
        public static final int UPDATE_SUCCESS = 0;
        public static final int UPDATE_UNCOMPRESS_ERR = 13;
        public static final int UPDATE_UNCOMPRESS_ERR_2 = 25;
        public static final int UPDATE_UNKNOW_ERROR = 999;
        public static final int UPDATE_USER_ABORT = 9;

        public UpdateErrorCode() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class UpdateFrom {
        public static final String SILENT_DOWNLOAD = "silent_download";
        public static final String SILENT_UPDATE = "silent_update";

        public UpdateFrom() {
        }
    }
}
