package com.tencent.upload.utils;

import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Const {
    static IPatchRedirector $redirector_ = null;
    public static final String ENTRANCE_KEY = "EX_IMAGE_UPLOAD_ENTRANCE";
    public static final String UPLOAD_ENTRANCE_TAG = "photo_upload_entrance";
    private static Map retMap;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class BusinessType {
        private static final /* synthetic */ BusinessType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BusinessType DefaultLog;
        public static final BusinessType DefaultOther;
        public static final BusinessType DefaultPhoto;
        public static final BusinessType DefaultVideo;
        public static final BusinessType FlockPhoto;
        public static final BusinessType GuildPhoto;
        public static final BusinessType GuildVideo;
        public static final BusinessType QCirclePhoto;
        public static final BusinessType QCircleVideo;
        public static final BusinessType QZonePhoto;
        public static final BusinessType QZoneVideo;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34577);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BusinessType businessType = new BusinessType("DefaultPhoto", 0);
            DefaultPhoto = businessType;
            BusinessType businessType2 = new BusinessType("DefaultVideo", 1);
            DefaultVideo = businessType2;
            BusinessType businessType3 = new BusinessType("DefaultOther", 2);
            DefaultOther = businessType3;
            BusinessType businessType4 = new BusinessType("DefaultLog", 3);
            DefaultLog = businessType4;
            BusinessType businessType5 = new BusinessType("QCirclePhoto", 4);
            QCirclePhoto = businessType5;
            BusinessType businessType6 = new BusinessType("QCircleVideo", 5);
            QCircleVideo = businessType6;
            BusinessType businessType7 = new BusinessType("GuildPhoto", 6);
            GuildPhoto = businessType7;
            BusinessType businessType8 = new BusinessType("GuildVideo", 7);
            GuildVideo = businessType8;
            BusinessType businessType9 = new BusinessType("QZonePhoto", 8);
            QZonePhoto = businessType9;
            BusinessType businessType10 = new BusinessType("QZoneVideo", 9);
            QZoneVideo = businessType10;
            BusinessType businessType11 = new BusinessType("FlockPhoto", 10);
            FlockPhoto = businessType11;
            $VALUES = new BusinessType[]{businessType, businessType2, businessType3, businessType4, businessType5, businessType6, businessType7, businessType8, businessType9, businessType10, businessType11};
        }

        BusinessType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static BusinessType valueOf(String str) {
            return (BusinessType) Enum.valueOf(BusinessType.class, str);
        }

        public static BusinessType[] values() {
            return (BusinessType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class ClickReport {
        static IPatchRedirector $redirector_ = null;
        public static final int CLICK_REPORT_READ_SOURCE_ENTRANCE_ALBUM_LIST = 2;
        public static final int CLICK_REPORT_READ_SOURCE_ENTRANCE_OTHER = 6;
        public static final int CLICK_REPORT_READ_SOURCE_ENTRANCE_PHOTO_LIST = 4;
        public static final int CLICK_REPORT_READ_SOURCE_ENTRANCE_TAB_ACTIVITY_PLUS_ICON = 5;

        ClickReport() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ConnectType {
        private static final /* synthetic */ ConnectType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ConnectType Epoll;
        public static final ConnectType Select;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34601);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ConnectType connectType = new ConnectType("Select", 0);
            Select = connectType;
            ConnectType connectType2 = new ConnectType("Epoll", 1);
            Epoll = connectType2;
            $VALUES = new ConnectType[]{connectType, connectType2};
        }

        ConnectType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ConnectType valueOf(String str) {
            return (ConnectType) Enum.valueOf(ConnectType.class, str);
        }

        public static ConnectType[] values() {
            return (ConnectType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class FailureCode {
        static IPatchRedirector $redirector_ = null;
        public static final int CONNECTION_FAILED = 0;
        public static final int FORCE_CHANGEROUTE = 6;
        public static final int HANDSHAKE_FAILED = 1;
        public static final int SERVER_CLOSED = 5;
        public static final int SOCKET_FAILED = 4;
        public static final int TIMEOUT_FAILED = 3;
        public static final int UNPACKET_FAILED = 2;

        public FailureCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static String print(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 6) {
                                    return "unknown";
                                }
                                return "forceChangeRoute";
                            }
                            return "serverClosed";
                        }
                        return "socketFailed";
                    }
                    return "unpacketFailed";
                }
                return "handshakeFailed";
            }
            return "connectionFailed";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class FileType {
        private static final /* synthetic */ FileType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FileType Log;
        public static final FileType Other;
        public static final FileType Photo;
        public static final FileType Video;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34611);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            FileType fileType = new FileType("Photo", 0);
            Photo = fileType;
            FileType fileType2 = new FileType(ComponentFactory.ComponentType.VIDEO, 1);
            Video = fileType2;
            FileType fileType3 = new FileType("Other", 2);
            Other = fileType3;
            FileType fileType4 = new FileType("Log", 3);
            Log = fileType4;
            $VALUES = new FileType[]{fileType, fileType2, fileType3, fileType4};
        }

        FileType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FileType valueOf(String str) {
            return (FileType) Enum.valueOf(FileType.class, str);
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class SwitchConfigKey {
        static IPatchRedirector $redirector_ = null;
        public static final String QQCIRCLE_CHANGE_ROUTE_FOR_IPV6 = "qqcircle_change_route_for_ipv6";
        public static final String QQCIRCLE_CHANGE_TEST_SERVER_IP = "qqcircle_change_test_server_ip";
        public static final String QQCIRCLE_ENABLE_NEW_CHANGE_STACKTYPE = "qqcircle_enable_new_change_stacktype";
        public static final String QQCIRCLE_ENABLE_RESET = "qqcircle_enable_reset";
        public static final String QQCIRCLE_UPLOAD_GET_DOMAIN_IP_FIRST_FOR_IPV4 = "qqcircle_upload_get_domain_ip_first_for_ipv4";
        public static final String QQCIRCLE_UPLOAD_NOT_USE_WIFI_BSSID = "qqcircle_upload_not_use_wifi_bssid";
        public static final String UPLOAD_PIC_COMPRESS_USE_NEW_STRATEGY = "upload_pic_compress_use_new_strategy";
        public static final String UPLOAD_PIC_VIDEO_CONNECT_TYPE_USE_EPOLL = "upload_pic_video_connect_type_use_epoll";
        public static final String UPS_USE_NEW_STRATEGY = "ups_use_new_strategy";
        public static final String VALUE_TRUE = "true";

        public SwitchConfigKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class UploadRetCode {
        private static final /* synthetic */ UploadRetCode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final UploadRetCode ALBUM_DELETED;
        public static final UploadRetCode ALL_IP_FAILED;
        public static final UploadRetCode CANCELED;
        public static final UploadRetCode CANCEL_INNER;
        public static final UploadRetCode DATA_COMPLETE_TIMEOUT;
        public static final UploadRetCode DATA_ENCODE_ERROR;
        public static final UploadRetCode DATA_ENCODE_EXCEPTION;
        public static final UploadRetCode DATA_UNPACK_FAILED_RETCODE;
        public static final UploadRetCode DNS_PARSER_ERROR;
        public static final UploadRetCode EAGAIN;
        public static final UploadRetCode ECONNABORTED;
        public static final UploadRetCode EHOSTUNREACH;
        public static final UploadRetCode EINPROGRESS;
        public static final UploadRetCode ENETDOWN;
        public static final UploadRetCode ENETUNREACH;
        public static final UploadRetCode ERROR_BATCH_COMMIT;
        public static final UploadRetCode ERROR_DATA_IS_EMPTY;
        public static final UploadRetCode ERROR_PRE_UPLOAD_HIT;
        public static final UploadRetCode ETIMEDOUT;
        public static final UploadRetCode EXPORTING_COMPLETE;
        public static final UploadRetCode FAST_SUCCEED;
        public static final UploadRetCode FILE_LENGTH_INVALID;
        public static final UploadRetCode FILE_NOT_EXIST;
        public static final UploadRetCode HANDSHAKE_FAILED;
        public static final UploadRetCode HANDSHAKE_TIMEOUT;
        public static final UploadRetCode IO_ERROR_RETCODE;
        public static final UploadRetCode IO_EXCEPTION;
        public static final UploadRetCode NDK_NETWORK_ERROR;
        public static final UploadRetCode NETWORK_NOT_AVAILABLE;
        public static final UploadRetCode NO_ROUTE;
        public static final UploadRetCode NO_SESSION;
        public static final UploadRetCode OOM;
        public static final UploadRetCode PAUSED;
        public static final UploadRetCode REQUEST_TIMEOUT;
        public static final UploadRetCode RESPONSE_IS_NULL;
        public static final UploadRetCode RESPONSE_OVERWRITE_RANGE_IS_NULL;
        public static final UploadRetCode SERVER_DISCONNECT;
        public static final UploadRetCode SERVER_RESET;
        public static final UploadRetCode SESSION_ALL_ROUTE_FAILED;
        public static final UploadRetCode SESSION_CONN_SEND_FAILED;
        public static final UploadRetCode SESSION_DETECT_ERROR;
        public static final UploadRetCode SESSION_DISCONNECT;
        public static final UploadRetCode SESSION_DIVIDE_PACKET_ERROR;
        public static final UploadRetCode SESSION_REQUEST_ENCODE_ERROR;
        public static final UploadRetCode SESSION_STATE_ERROR;
        public static final UploadRetCode SESSION_STATE_INVALID;
        public static final UploadRetCode SESSION_WITHOUT_CONN;
        public static final UploadRetCode SOCKET_FD_OVERLOAD;
        public static final UploadRetCode SUCCEED;
        public static final UploadRetCode UNKNOWN_EXCEPTION;
        public static final UploadRetCode UNMATCH_SIZE_EXCEPTION;
        private int code;
        private String desc;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34619);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
                return;
            }
            UploadRetCode uploadRetCode = new UploadRetCode("SUCCEED", 0, 0, "\u6210\u529f");
            SUCCEED = uploadRetCode;
            UploadRetCode uploadRetCode2 = new UploadRetCode("SERVER_RESET", 1, 104, "\u670d\u52a1\u5668\u91cd\u7f6e\uff0c\u8bf7\u91cd\u8bd5\uff01");
            SERVER_RESET = uploadRetCode2;
            UploadRetCode uploadRetCode3 = new UploadRetCode("SERVER_DISCONNECT", 2, 115, "\u670d\u52a1\u5668\u65ad\u5f00\uff0c\u8bf7\u91cd\u8bd5\uff01");
            SERVER_DISCONNECT = uploadRetCode3;
            UploadRetCode uploadRetCode4 = new UploadRetCode("DATA_UNPACK_FAILED_RETCODE", 3, 500, "\u6536\u5230\u7684\u6570\u636e\u89e3\u5305\u51fa\u9519");
            DATA_UNPACK_FAILED_RETCODE = uploadRetCode4;
            UploadRetCode uploadRetCode5 = new UploadRetCode("DNS_PARSER_ERROR", 4, PlayerResources.ViewId.CURRUNT_TIME, ImageTaskConst.ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_UNKNOW_HOST_EXP_DESC);
            DNS_PARSER_ERROR = uploadRetCode5;
            UploadRetCode uploadRetCode6 = new UploadRetCode("DATA_COMPLETE_TIMEOUT", 5, 600, "\u63a5\u6536\u7b49\u5f85\u5b8c\u6210\u5f02\u5e38");
            DATA_COMPLETE_TIMEOUT = uploadRetCode6;
            UploadRetCode uploadRetCode7 = new UploadRetCode("DATA_ENCODE_ERROR", 6, 601, "\u6570\u636e\u6253\u5305\u5f02\u5e38");
            DATA_ENCODE_ERROR = uploadRetCode7;
            UploadRetCode uploadRetCode8 = new UploadRetCode("SESSION_STATE_ERROR", 7, 602, "Session\u8fde\u63a5\u5f02\u5e38");
            SESSION_STATE_ERROR = uploadRetCode8;
            UploadRetCode uploadRetCode9 = new UploadRetCode("EAGAIN", 8, 11, "\u63a5\u5165\u670d\u52a1\u5668\u51fa\u9519");
            EAGAIN = uploadRetCode9;
            UploadRetCode uploadRetCode10 = new UploadRetCode("ENETDOWN", 9, 100, "Network is down");
            ENETDOWN = uploadRetCode10;
            UploadRetCode uploadRetCode11 = new UploadRetCode("ENETUNREACH", 10, 101, "Network is unreachable");
            ENETUNREACH = uploadRetCode11;
            UploadRetCode uploadRetCode12 = new UploadRetCode("ECONNABORTED", 11, 103, "Software caused connection abort");
            ECONNABORTED = uploadRetCode12;
            UploadRetCode uploadRetCode13 = new UploadRetCode("ETIMEDOUT", 12, 110, "Connection timed out");
            ETIMEDOUT = uploadRetCode13;
            UploadRetCode uploadRetCode14 = new UploadRetCode("EHOSTUNREACH", 13, 113, "No route to host");
            EHOSTUNREACH = uploadRetCode14;
            UploadRetCode uploadRetCode15 = new UploadRetCode("EINPROGRESS", 14, 115, "Operation now in progress");
            EINPROGRESS = uploadRetCode15;
            UploadRetCode uploadRetCode16 = new UploadRetCode("NETWORK_NOT_AVAILABLE", 15, 35000, "\u7f51\u7edc\u4e0d\u53ef\u7528");
            NETWORK_NOT_AVAILABLE = uploadRetCode16;
            UploadRetCode uploadRetCode17 = new UploadRetCode("REQUEST_TIMEOUT", 16, -4, "\u670d\u52a1\u5668\u56de\u5305\u8d85\u65f6");
            REQUEST_TIMEOUT = uploadRetCode17;
            UploadRetCode uploadRetCode18 = new UploadRetCode("FILE_NOT_EXIST", 17, -7, ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC);
            FILE_NOT_EXIST = uploadRetCode18;
            UploadRetCode uploadRetCode19 = new UploadRetCode("FILE_LENGTH_INVALID", 18, -8, "\u6587\u4ef6\u957f\u5ea6\u4e0d\u5408\u6cd5");
            FILE_LENGTH_INVALID = uploadRetCode19;
            UploadRetCode uploadRetCode20 = new UploadRetCode("IO_ERROR_RETCODE", 19, -15, "IO\u8bfb\u5199\u5f02\u5e38");
            IO_ERROR_RETCODE = uploadRetCode20;
            UploadRetCode uploadRetCode21 = new UploadRetCode("ALL_IP_FAILED", 20, -18, "\u65e0\u6cd5\u8fde\u63a5\u5230\u670d\u52a1\u5668\uff0c\u8bf7\u91cd\u8bd5\uff01");
            ALL_IP_FAILED = uploadRetCode21;
            UploadRetCode uploadRetCode22 = new UploadRetCode("CANCELED", 21, -20, "\u4efb\u52a1\u53d6\u6d88");
            CANCELED = uploadRetCode22;
            UploadRetCode uploadRetCode23 = new UploadRetCode("ERROR_BATCH_COMMIT", 22, -30, "\u63a5\u6536\u6570\u636e\u5f02\u5e38,\u6279\u91cf\u53d1\u8868");
            ERROR_BATCH_COMMIT = uploadRetCode23;
            UploadRetCode uploadRetCode24 = new UploadRetCode("CANCEL_INNER", 23, -60, "\u5185\u90e8\u53d6\u6d88");
            CANCEL_INNER = uploadRetCode24;
            UploadRetCode uploadRetCode25 = new UploadRetCode("ALBUM_DELETED", 24, -207, "\u76f8\u518c\u4e0d\u5b58\u5728");
            ALBUM_DELETED = uploadRetCode25;
            UploadRetCode uploadRetCode26 = new UploadRetCode("EXPORTING_COMPLETE", 25, -233, "\u5408\u6210\u672a\u5b8c\u6210");
            EXPORTING_COMPLETE = uploadRetCode26;
            UploadRetCode uploadRetCode27 = new UploadRetCode("FAST_SUCCEED", 26, -20001, "\u79d2\u4f20\u6210\u529f");
            FAST_SUCCEED = uploadRetCode27;
            UploadRetCode uploadRetCode28 = new UploadRetCode("PAUSED", 27, -20003, "\u4efb\u52a1\u6682\u505c");
            PAUSED = uploadRetCode28;
            UploadRetCode uploadRetCode29 = new UploadRetCode("RESPONSE_IS_NULL", 28, AppConstants.RichMediaErrorCode.ERROR_NET_OTHER, "\u670d\u52a1\u5668\u56de\u5305\u4e3a\u7a7a");
            RESPONSE_IS_NULL = uploadRetCode29;
            UploadRetCode uploadRetCode30 = new UploadRetCode("RESPONSE_OVERWRITE_RANGE_IS_NULL", 29, -20008, "overwrite_range\u4e3a\u7a7a");
            RESPONSE_OVERWRITE_RANGE_IS_NULL = uploadRetCode30;
            UploadRetCode uploadRetCode31 = new UploadRetCode("NO_SESSION", 30, -20011, "\u7f51\u7edc\u5f02\u5e38,\u8bf7\u5c1d\u8bd5\u5207\u6362\u7f51\u7edc\u540e\u91cd\u8bd5\uff01");
            NO_SESSION = uploadRetCode31;
            UploadRetCode uploadRetCode32 = new UploadRetCode("SESSION_DISCONNECT", 31, -20012, "Session\u65ad\u5f00");
            SESSION_DISCONNECT = uploadRetCode32;
            UploadRetCode uploadRetCode33 = new UploadRetCode("SESSION_STATE_INVALID", 32, -20013, "Session\u72b6\u6001\u975e\u6cd5");
            SESSION_STATE_INVALID = uploadRetCode33;
            UploadRetCode uploadRetCode34 = new UploadRetCode("SESSION_DETECT_ERROR", 33, -20014, "\u7f51\u7edc\u63a2\u6d4b\u5931\u8d25");
            SESSION_DETECT_ERROR = uploadRetCode34;
            UploadRetCode uploadRetCode35 = new UploadRetCode("NDK_NETWORK_ERROR", 34, -20015, "NDK Network Error");
            NDK_NETWORK_ERROR = uploadRetCode35;
            UploadRetCode uploadRetCode36 = new UploadRetCode("NO_ROUTE", 35, -20100, "\u6ca1\u6709\u53ef\u7528\u8def\u7531");
            NO_ROUTE = uploadRetCode36;
            UploadRetCode uploadRetCode37 = new UploadRetCode("SESSION_ALL_ROUTE_FAILED", 36, -20101, "\u7f51\u7edc\u901a\u9053\u5efa\u7acb\u5931\u8d25");
            SESSION_ALL_ROUTE_FAILED = uploadRetCode37;
            UploadRetCode uploadRetCode38 = new UploadRetCode("SESSION_CONN_SEND_FAILED", 37, -20102, "NetworkEngine Send Failed");
            SESSION_CONN_SEND_FAILED = uploadRetCode38;
            UploadRetCode uploadRetCode39 = new UploadRetCode("SESSION_WITHOUT_CONN", 38, -20103, "Connection\u4e3a\u7a7a");
            SESSION_WITHOUT_CONN = uploadRetCode39;
            UploadRetCode uploadRetCode40 = new UploadRetCode("SESSION_DIVIDE_PACKET_ERROR", 39, -20104, "\u63a5\u6536\u6570\u636e\u5f02\u5e38,\u5206\u5305\u5931\u8d25");
            SESSION_DIVIDE_PACKET_ERROR = uploadRetCode40;
            UploadRetCode uploadRetCode41 = new UploadRetCode("SESSION_REQUEST_ENCODE_ERROR", 40, -20105, "Request encode error");
            SESSION_REQUEST_ENCODE_ERROR = uploadRetCode41;
            UploadRetCode uploadRetCode42 = new UploadRetCode("DATA_ENCODE_EXCEPTION", 41, -20106, "\u4e0a\u4f20\u6570\u636ejce\u7f16\u7801\u5f02\u5e38");
            DATA_ENCODE_EXCEPTION = uploadRetCode42;
            UploadRetCode uploadRetCode43 = new UploadRetCode("HANDSHAKE_FAILED", 42, -20290, "\u63e1\u624b\u5931\u8d25");
            HANDSHAKE_FAILED = uploadRetCode43;
            UploadRetCode uploadRetCode44 = new UploadRetCode("HANDSHAKE_TIMEOUT", 43, -20291, "\u63e1\u624b\u8d85\u65f6");
            HANDSHAKE_TIMEOUT = uploadRetCode44;
            UploadRetCode uploadRetCode45 = new UploadRetCode("OOM", 44, -21001, "Out Of Memory");
            OOM = uploadRetCode45;
            UploadRetCode uploadRetCode46 = new UploadRetCode("IO_EXCEPTION", 45, -22000, "IO\u5f02\u5e38");
            IO_EXCEPTION = uploadRetCode46;
            UploadRetCode uploadRetCode47 = new UploadRetCode("ERROR_PRE_UPLOAD_HIT", 46, -55555, "\u9884\u4e0a\u4f20\u547d\u4e2d");
            ERROR_PRE_UPLOAD_HIT = uploadRetCode47;
            UploadRetCode uploadRetCode48 = new UploadRetCode("ERROR_DATA_IS_EMPTY", 47, 1005, "\u89e3\u6790\u6570\u636e\u4e3a\u7a7a\u5931\u8d25");
            ERROR_DATA_IS_EMPTY = uploadRetCode48;
            UploadRetCode uploadRetCode49 = new UploadRetCode("UNKNOWN_EXCEPTION", 48, -80000, "\u4e0a\u4f20\u51fa\u9519");
            UNKNOWN_EXCEPTION = uploadRetCode49;
            UploadRetCode uploadRetCode50 = new UploadRetCode("UNMATCH_SIZE_EXCEPTION", 49, -80001, "\u6587\u4ef6\u5927\u5c0f\u4e0d\u5339\u914d");
            UNMATCH_SIZE_EXCEPTION = uploadRetCode50;
            UploadRetCode uploadRetCode51 = new UploadRetCode("SOCKET_FD_OVERLOAD", 50, PlayerResources.ViewId.ADVTISMENT_VIDEO_TIP, "\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\uff01");
            SOCKET_FD_OVERLOAD = uploadRetCode51;
            $VALUES = new UploadRetCode[]{uploadRetCode, uploadRetCode2, uploadRetCode3, uploadRetCode4, uploadRetCode5, uploadRetCode6, uploadRetCode7, uploadRetCode8, uploadRetCode9, uploadRetCode10, uploadRetCode11, uploadRetCode12, uploadRetCode13, uploadRetCode14, uploadRetCode15, uploadRetCode16, uploadRetCode17, uploadRetCode18, uploadRetCode19, uploadRetCode20, uploadRetCode21, uploadRetCode22, uploadRetCode23, uploadRetCode24, uploadRetCode25, uploadRetCode26, uploadRetCode27, uploadRetCode28, uploadRetCode29, uploadRetCode30, uploadRetCode31, uploadRetCode32, uploadRetCode33, uploadRetCode34, uploadRetCode35, uploadRetCode36, uploadRetCode37, uploadRetCode38, uploadRetCode39, uploadRetCode40, uploadRetCode41, uploadRetCode42, uploadRetCode43, uploadRetCode44, uploadRetCode45, uploadRetCode46, uploadRetCode47, uploadRetCode48, uploadRetCode49, uploadRetCode50, uploadRetCode51};
        }

        UploadRetCode(String str, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            } else {
                this.code = i16;
                this.desc = str2;
            }
        }

        public static UploadRetCode valueOf(String str) {
            return (UploadRetCode) Enum.valueOf(UploadRetCode.class, str);
        }

        public static UploadRetCode[] values() {
            return (UploadRetCode[]) $VALUES.clone();
        }

        public int getCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.code;
        }

        public String getDesc() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.desc;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34621);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        retMap = new HashMap();
        for (UploadRetCode uploadRetCode : UploadRetCode.values()) {
            retMap.put(Integer.valueOf(uploadRetCode.code), uploadRetCode);
        }
    }

    public Const() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getReadSource(int i3) {
        switch (i3) {
            case 11:
                return 5;
            case 12:
                return 2;
            case 13:
                return 4;
            default:
                return 6;
        }
    }

    public static UploadRetCode getRetCode(int i3) {
        if (retMap.containsKey(Integer.valueOf(i3))) {
            return (UploadRetCode) retMap.get(Integer.valueOf(i3));
        }
        return UploadRetCode.UNKNOWN_EXCEPTION;
    }
}
