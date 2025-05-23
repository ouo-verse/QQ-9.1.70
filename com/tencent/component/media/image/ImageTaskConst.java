package com.tencent.component.media.image;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageTaskConst {
    public static final String CLIENT_IP = "clientIp";
    public static final String DOWNLOAD_DETAIL_INFO = "downloadDetailInfo";
    public static final String ERROR_TYPE = "errType";
    public static final String EXCEPTION_CODE = "exceptionCode";
    public static final String FAIL_CODE = "failCode";
    public static final String FILE_PATH = "filePath";
    public static final int IMAGE_TASK_DECODE_AVIF_DYNAMIC_DRAWABLE_FAILED = 114;
    public static final int IMAGE_TASK_DECODE_AVIF_IMAGE_FILE = 115;
    public static final int IMAGE_TASK_DECODE_EXCEPTION = 110;
    public static final int IMAGE_TASK_DECODE_GET_ANIMATEDWEBP_DRAWABLE_THROWABLE = 113;
    public static final int IMAGE_TASK_DECODE_GET_PHOTO_GIF_DRAWABLE_FAILED = 106;
    public static final int IMAGE_TASK_DECODE_GIF_DRAWABLE_FIALED = 107;
    public static final int IMAGE_TASK_DECODE_NORMAL_IMAGE_THROWABLE = 112;
    public static final int IMAGE_TASK_DECODE_OOM = 111;
    public static final int IMAGE_TASK_DECODE_SHARPP_GET_BITMAP_REFERENCE_FAILED = 105;
    public static final int IMAGE_TASK_DECODE_SHARPP_GET_GIF_DRAWABLE_FAILED = 103;
    public static final int IMAGE_TASK_DECODE_SHARPP_IMAGE_FILE = 104;
    public static final int IMAGE_TASK_DECODE_THROWABLE = 101;
    public static final int IMAGE_TASK_DOWNLOAD_SUCCEED_FILE_NOT_FOUND = 102;
    public static final int IMAGE_TASK_DOWNLOAD_SUCCEED_IMAGE_CAN_NOT_DECODE = 800;
    public static final int IMAGE_TASK_FAKE_FEED_LOCAL_IMAGE = 802;
    public static final int IMAGE_TASK_FETCH_CACHE_FAILED = 600;
    public static final int IMAGE_TASK_IMAGE_CAN_NOT_DOWNLOAD = 801;
    public static final int IMAGE_TASK_NO_NEXT_TASK = 700;
    public static final int IMAGE_TASK_NO_SUCH_FILE = 100;
    public static final String NOCACHE_CODE = "nocacheStatus";
    public static final String RESULT = "\u95ee\u9898\u63cf\u8ff0";
    public static final String SERVER_IP = "serverIp";
    public static final String URL = "url";

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ErrorCode {
        public static final int LOCAL_RET_CODE_CLIENT_PROTOCOL_EXP = 8;
        public static final int LOCAL_RET_CODE_CONNECTION_REFUSED = 50006;
        public static final int LOCAL_RET_CODE_CONNECT_CLOSED_EXP = 14;
        public static final int LOCAL_RET_CODE_CONNECT_POOL_TIMEOUT_EXP = 13;
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
        public static final int LOCAL_RET_CODE_NETWORK_FAIL = -99997;
        public static final int LOCAL_RET_CODE_NETWORK_IS_UNABAILABLE = 50007;
        public static final int LOCAL_RET_CODE_NETWORK_IS_UNRACHABLE = 50004;
        public static final int LOCAL_RET_CODE_NOCACHE_PIC_DELETED = -899;
        public static final int LOCAL_RET_CODE_NOCACHE_SECURITY = -5062;
        public static final int LOCAL_RET_CODE_NOCACHE_SERVER_TIMEOUT = -2005;
        public static final int LOCAL_RET_CODE_NOSPACE_LEFT_ON_DEVICE = 50003;
        public static final int LOCAL_RET_CODE_NO_CACHE = -2;
        public static final int LOCAL_RET_CODE_NO_HTTP_RSP_EXP = 11;
        public static final int LOCAL_RET_CODE_NO_ROUTE_TO_HOST = 50005;
        public static final int LOCAL_RET_CODE_OOM_ERR = 3;
        public static final int LOCAL_RET_CODE_SOCKET_EXP = 6;
        public static final int LOCAL_RET_CODE_SOCKET_TO_EXP = 7;
        public static final int LOCAL_RET_CODE_SSL_PEER_UNVERIFIED_EXP = 12;
        public static final int LOCAL_RET_CODE_TRY_FAILED = -99998;
        public static final int LOCAL_RET_CODE_TYPE_MISMATCH = -99996;
        public static final int LOCAL_RET_CODE_UNKNOW = -99999;
        public static final int LOCAL_RET_CODE_UNKNOW_HOST_EXP = 9;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ErrorDesciption {
        public static final String IMAGE_TASK_CLEAN_CACHE = ",\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
        public static final String IMAGE_TASK_DECODE_DEVELOPER = "\uff0c\u8bf7\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
        public static final String IMAGE_TASK_DECODE_EXCEPTION_DESC = "\u89e3\u7801\u5f02\u5e38";
        public static final String IMAGE_TASK_DECODE_GET_PHOTO_GIF_DRAWABLE_FAILED_DESC = "\u89e3\u7801gif\u5931\u8d25";
        public static final String IMAGE_TASK_DECODE_GIF_DRAWABLE_FIALED_DESC = "\u89e3\u7801gif\u5f02\u5e38";
        public static final String IMAGE_TASK_DECODE_NORMAL_IMAGE_THROWABLE_DESC = "\u89e3\u7801\u56fe\u7247\u5f02\u5e38";
        public static final String IMAGE_TASK_DECODE_OOM_DESC = "\u89e3\u7801oom";
        public static final String IMAGE_TASK_DECODE_SHARPP_GET_BITMAP_REFERENCE_FAILED_DESC = "\u83b7\u53d6bitmap reference\u5931\u8d25";
        public static final String IMAGE_TASK_DECODE_SHARPP_GET_GIF_DRAWABLE_FAILED_DESC = "\u89e3\u7801sharpP\u8fc7\u7a0b\u4e2d\uff0c\u83b7\u53d6gif\u56fe\u5931\u8d25";
        public static final String IMAGE_TASK_DECODE_SHARPP_IMAGE_FILE_DESC = "\u89e3\u7801sharpP\u5931\u8d25";
        public static final String IMAGE_TASK_DECODE_THROWABLE_DESC = "\u89e3\u7801\u8fc7\u7a0b\u5f02\u5e38";
        public static final String IMAGE_TASK_DOWNLOAD_DEVELOPER = "\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
        public static final String IMAGE_TASK_DOWNLOAD_SUCCEED_FILE_NOT_FOUND_DESC = "\u4e0b\u8f7d\u6210\u529f\uff0c\u4f46\u6587\u4ef6\u4e0d\u5b58\u5728";
        public static final String IMAGE_TASK_DOWNLOAD_SUCCEED_IMAGE_CAN_NOT_DECODE_DESC = "\u4e0b\u8f7d\u6210\u529f\uff0c\u672a\u80fd\u6b63\u5e38\u89e3\u7801";
        public static final String IMAGE_TASK_ERROR_DESC = "\u672a\u77e5\u9519\u8bef\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u3001kyloguo\u5904\u7406";
        public static final String IMAGE_TASK_FAKE_FEED_LOCAL_IMAGE_DESC = "\u672c\u5730\u56fe\u7247\u51fa\u9519";
        public static final String IMAGE_TASK_FETCH_CACHE_FAILED_DESC = "\u83b7\u53d6\u56fe\u7247\u7f13\u5b58\u5931\u8d25\uff0c\u6ca1\u6709\u540e\u7eed\u4e0b\u8f7d\u4efb\u52a1\u53ef\u6267\u884c";
        public static final String IMAGE_TASK_IMAGE_CAN_NOT_DOWNLOAD_DESC = "\u56fe\u7247\u4e0d\u80fd\u88ab\u4e0b\u8f7d";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_CLIENT_PROTOCOL_EXP_DESC = "HttpResponse\u89e3\u6790\u5931\u8d25";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_CONNECTION_REFUSED_DESC = "\u6ca1\u6709\u7f51\u7edc\u8bbf\u95ee\u6743\u9650\uff0c\u8bf7\u5207\u6362\u81f3\u6b63\u786e\u7684\u7f51\u7edc\u518d\u8bd5";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_CONNECT_CLOSED_EXP_DESC = "\u7f51\u7edc\u5f02\u5e38\uff0c\u670d\u52a1\u7aef\u63d0\u524d\u5173\u95ed\u8fde\u63a5";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_CONNECT_POOL_TIMEOUT_EXP_DESC = "\u672c\u5730\u8fde\u63a5\u6c60\u8d85\u65f6";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_CONNECT_TIMEOUT_EXP_DESC = "\u8fde\u63a5\u8d85\u65f6";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_CONTENT_LENGTH_VALID_DESC = "Content-Length\u88ab\u4e2d\u95f4\u7f51\u5173\u7be1\u6539";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_DECODE_FAILED_DESC = "\u4e0b\u8f7d\u89e3\u7801\u5931\u8d25";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_EXP_DESC = "\u672a\u77e5exception";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_FNF_EXP_DESC = "FileNotFound";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_ILLEGAL_FORMAT_360WIFI_DESC = "\u5c0f\u7c73wifi\u5bfc\u81f4\u7684\u975e\u6cd5\u683c\u5f0f";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_ILLEGAL_FORMAT_DESC = "\u975e\u6cd5\u683c\u5f0f";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_ILL_EXP_DESC = "\u7cfb\u7edf\u7f51\u7edc\u5e93\u5f02\u5e38";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_IO_EXP_DESC = "\u4e0b\u8f7d\u8fc7\u7a0b\u51fa\u73b0IO\u5f02\u5e38";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_LENGTH_MISMATCH_DESC = "\u4e0b\u8f7d\u7684\u6587\u4ef6\u957f\u5ea6\u4e0econtent-length\u4e0d\u5339\u914d";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NETWORK_FAIL_DESC = "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NETWORK_IS_UNABAILABLE_DESC = "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u6062\u590d\u81f3\u6b63\u5e38\u7f51\u7edc\u540e\u518d\u8bd5";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NETWORK_IS_UNRACHABLE_DESC = "\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u6062\u590d\u81f3\u6b63\u5e38\u7684\u7f51\u7edc\u72b6\u6001\u518d\u8bd5";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NOCACHE_PIC_DELETED_DESC = "\u56fe\u7247\u5df2\u5220\u9664";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NOCACHE_SECURITY_DESC = "\u56fe\u7247\u4e0d\u80fd\u67e5\u770b\uff08\u5b89\u5168\u6253\u51fb\uff09";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NOCACHE_SERVER_TIMEOUT_DESC = "\u540e\u7aef\u8d85\u65f6";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NOSPACE_LEFT_ON_DEVICE_DESC = "\u78c1\u76d8\u7a7a\u95f4\u4e0d\u8db3\uff0c\u8bf7\u6e05\u9664\u90e8\u5206\u65e0\u7528\u7684\u6587\u4ef6\u540e\u518d\u8bd5";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NO_CACHE_DESC = "no-cache";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NO_HTTP_RSP_EXP_DESC = "\u53d1\u53bb\u7684\u8bf7\u6c42\u672a\u6536\u5230\u670d\u52a1\u7aef\u56de\u5e94";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_NO_ROUTE_TO_HOST_DESC = "\u7f51\u7edc\u4e0d\u53ef\u8fbe\uff0c\u8bf7\u5207\u6362\u81f3\u6b63\u786e\u7684\u7f51\u7edc\u518d\u8bd5";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_OOM_ERR_DESC = "\u4e0b\u8f7d\u8fc7\u7a0b\u51fa\u73b0oom";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_SOCKET_EXP_DESC = "\u7f51\u7edc\u5f02\u5e38, \u8bf7\u6062\u590d\u81f3\u6b63\u5e38\u7f51\u7edc\u540e\u518d\u8bd5";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_SOCKET_TO_EXP_DESC = "\u7f51\u7edc\u6536\u53d1\u5305\u8d85\u65f6";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_SSL_PEER_UNVERIFIED_EXP_DESC = "SSL\u8bc1\u4e66\u6821\u9a8c\u5931\u8d25";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_TRY_FAILED_DESC = "\u8d85\u8fc7\u5c1d\u8bd5\u6b21\u6570";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_TYPE_MISMATCH_DESC = "\u4e0b\u8f7d\u5185\u5bb9\u4e0d\u662f\u6240\u9700\u7c7b\u578b";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_UNKNOW_DESC = "\u4e0b\u8f7d\u5668\u672a\u77e5\u9519\u8bef";
        public static final String IMAGE_TASK_LOCAL_RET_CODE_UNKNOW_HOST_EXP_DESC = "\u57df\u540d\u89e3\u6790\u5931\u8d25";
        public static final String IMAGE_TASK_NO_NEXT_TASK_DESC = "\u89e3\u7801\u5931\u8d25";
        public static final String IMAGE_TASK_NO_SUCH_FILE_DESC = "\u6587\u4ef6\u4e0d\u5b58\u5728";
    }

    public static String getImageTaskErrorDescription(int i3) {
        if (i3 != -5062) {
            if (i3 != -2005) {
                if (i3 != -899) {
                    if (i3 != 600) {
                        if (i3 != 700) {
                            if (i3 != -4) {
                                if (i3 != -3) {
                                    if (i3 != -2) {
                                        if (i3 != -1) {
                                            switch (i3) {
                                                case -99999:
                                                    return "\u4e0b\u8f7d\u5668\u672a\u77e5\u9519\u8bef\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                case -99998:
                                                    return "\u8d85\u8fc7\u5c1d\u8bd5\u6b21\u6570\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                case -99997:
                                                    return "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                case -99996:
                                                    return "\u4e0b\u8f7d\u5185\u5bb9\u4e0d\u662f\u6240\u9700\u7c7b\u578b\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                default:
                                                    switch (i3) {
                                                        case 1:
                                                            return "FileNotFound\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 2:
                                                            return "\u4e0b\u8f7d\u8fc7\u7a0b\u51fa\u73b0IO\u5f02\u5e38\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 3:
                                                            return "\u4e0b\u8f7d\u8fc7\u7a0b\u51fa\u73b0oom\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 4:
                                                            return "\u672a\u77e5exception\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 5:
                                                            return "\u7cfb\u7edf\u7f51\u7edc\u5e93\u5f02\u5e38\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 6:
                                                            return ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_SOCKET_EXP_DESC;
                                                        case 7:
                                                            return "\u7f51\u7edc\u6536\u53d1\u5305\u8d85\u65f6\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 8:
                                                            return "HttpResponse\u89e3\u6790\u5931\u8d25\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 9:
                                                            return "\u57df\u540d\u89e3\u6790\u5931\u8d25\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 10:
                                                            return "\u8fde\u63a5\u8d85\u65f6\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 11:
                                                            return "\u53d1\u53bb\u7684\u8bf7\u6c42\u672a\u6536\u5230\u670d\u52a1\u7aef\u56de\u5e94\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 12:
                                                            return "SSL\u8bc1\u4e66\u6821\u9a8c\u5931\u8d25\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 13:
                                                            return "\u672c\u5730\u8fde\u63a5\u6c60\u8d85\u65f6\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        case 14:
                                                            return "\u7f51\u7edc\u5f02\u5e38\uff0c\u670d\u52a1\u7aef\u63d0\u524d\u5173\u95ed\u8fde\u63a5\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                        default:
                                                            switch (i3) {
                                                                case 100:
                                                                    return "\u6587\u4ef6\u4e0d\u5b58\u5728\uff0c\u8bf7\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                case 101:
                                                                    return "\u89e3\u7801\u8fc7\u7a0b\u5f02\u5e38\uff0c\u8bf7\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                case 102:
                                                                    return "\u4e0b\u8f7d\u6210\u529f\uff0c\u4f46\u6587\u4ef6\u4e0d\u5b58\u5728\uff0c\u8bf7\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                case 103:
                                                                    return "\u89e3\u7801sharpP\u8fc7\u7a0b\u4e2d\uff0c\u83b7\u53d6gif\u56fe\u5931\u8d25\uff0c\u8bf7\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                case 104:
                                                                    return "\u89e3\u7801sharpP\u5931\u8d25\uff0c\u8bf7\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                case 105:
                                                                    return "\u83b7\u53d6bitmap reference\u5931\u8d25,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                case 106:
                                                                    return "\u89e3\u7801gif\u5931\u8d25,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                case 107:
                                                                    return "\u89e3\u7801gif\u5f02\u5e38,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                default:
                                                                    switch (i3) {
                                                                        case 110:
                                                                            return "\u89e3\u7801\u5f02\u5e38,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                        case 111:
                                                                            return "\u89e3\u7801oom\uff0c\u8bf7\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                        case 112:
                                                                            return "\u89e3\u7801\u56fe\u7247\u5f02\u5e38,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                        default:
                                                                            switch (i3) {
                                                                                case 800:
                                                                                    return "\u4e0b\u8f7d\u6210\u529f\uff0c\u672a\u80fd\u6b63\u5e38\u89e3\u7801,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                                case 801:
                                                                                    return "\u56fe\u7247\u4e0d\u80fd\u88ab\u4e0b\u8f7d\uff0c\u8bf7\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                                case 802:
                                                                                    return "\u672c\u5730\u56fe\u7247\u51fa\u9519,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                                                                                default:
                                                                                    switch (i3) {
                                                                                        case 50001:
                                                                                            return "\u5c0f\u7c73wifi\u5bfc\u81f4\u7684\u975e\u6cd5\u683c\u5f0f\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                                                        case 50002:
                                                                                            return "Content-Length\u88ab\u4e2d\u95f4\u7f51\u5173\u7be1\u6539\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                                                                        case 50003:
                                                                                            return ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NOSPACE_LEFT_ON_DEVICE_DESC;
                                                                                        case 50004:
                                                                                            return ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_IS_UNRACHABLE_DESC;
                                                                                        case 50005:
                                                                                            return ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NO_ROUTE_TO_HOST_DESC;
                                                                                        case 50006:
                                                                                            return ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_CONNECTION_REFUSED_DESC;
                                                                                        case 50007:
                                                                                            return ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_IS_UNABAILABLE_DESC;
                                                                                        default:
                                                                                            return ErrorDesciption.IMAGE_TASK_ERROR_DESC;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                        }
                                        return "\u975e\u6cd5\u683c\u5f0f\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                    }
                                    return "no-cache\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                                }
                                return "\u4e0b\u8f7d\u7684\u6587\u4ef6\u957f\u5ea6\u4e0econtent-length\u4e0d\u5339\u914d\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                            }
                            return "\u4e0b\u8f7d\u89e3\u7801\u5931\u8d25\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
                        }
                        return "\u89e3\u7801\u5931\u8d25,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                    }
                    return "\u83b7\u53d6\u56fe\u7247\u7f13\u5b58\u5931\u8d25\uff0c\u6ca1\u6709\u540e\u7eed\u4e0b\u8f7d\u4efb\u52a1\u53ef\u6267\u884c,\u8bf7\u6e05\u9664\u7f13\u5b58\u518d\u8bd5\u6216\u622a\u5c4f\u7ed9kyloguo\u5904\u7406";
                }
                return ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NOCACHE_PIC_DELETED_DESC;
            }
            return "\u540e\u7aef\u8d85\u65f6\uff0c\u8bf7\u622a\u5c4f\u7ed9ianmao\u5904\u7406";
        }
        return ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NOCACHE_SECURITY_DESC;
    }
}
