package com.tencent.mobileqq.winkpublish.publishconst;

import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import uq3.c;

/* compiled from: P */
/* loaded from: classes21.dex */
public class FSUploadConst {
    public static final int ERR_COMPRESS_ENV_UNPREPAERD = 1706;
    public static final int ERR_FILE_NOT_EXIST = 1700;
    public static final int ERR_GENERATE_VIDEO_COVER_FAIL = 1707;
    public static final int ERR_LOGIN_STATUS_EMPTY = 1702;
    public static final int ERR_LOGIN_UIN_ILLEGAL = 1703;
    public static final int ERR_NO_LOGIN = 1705;
    public static final int ERR_QCIRCLE_GENERATE_VIDEO_FAIL = 10000;
    public static final int ERR_QCIRCLE_GENERATE_VIDEO_OVER_TIME_FAIL = 10001;
    public static final int ERR_UPLOAD_RESULT_ILLEGAL = 1704;
    public static final String KEY_CLIENT_UPLOOAD_COVER = "is_client_upload_cover";
    public static final String KEY_COVER_SEQ = "cover_seq";
    public static final String KEY_FAKEFEED_CLIENTKEY = "mobile_fakefeeds_clientkey";
    public static final String KEY_MIX_FEED = "is_pic_video_mix_feeds";
    public static final String KEY_MIX_ORIGIN_VIDEO = "mix_isOriginalVideo";
    public static final String KEY_MIX_TIME = "mix_time";
    public static final String KEY_MIX_VIDEO_SIZE = "mix_videoSize";
    public static final String KEY_REFER = "business_refer";
    public static final String KEY_UPLOAD_HAS_SELECT_COVER = "user_select_cover";
    public static final String KEY_UPLOAD_REFER = "refer";
    public static final String KEY_VID = "vid";
    public static final String KEY_VIDEO_FORMAT = "qz_video_format";
    public static final String KEY_VIDEO_IS_HDR = "is_hdr";
    public static final String KEY_VIDEO_TYPE = "video_type";
    public static final String STATE_RUNNING = "running_task";
    public static final int SUCCESS = 0;

    public static String getMessage(int i3) {
        if (i3 != 0) {
            if (i3 != 1700) {
                if (i3 != 10000) {
                    if (i3 != 10001) {
                        switch (i3) {
                            case ERR_LOGIN_STATUS_EMPTY /* 1702 */:
                            case ERR_LOGIN_UIN_ILLEGAL /* 1703 */:
                                return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadLoginError", "\u767b\u5f55\u6001\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u540e\u91cd\u8bd5");
                            case ERR_UPLOAD_RESULT_ILLEGAL /* 1704 */:
                                return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadResultError", "\u4e0a\u4f20\u8fd4\u56de\u7ed3\u679c\u5931\u8d25");
                            case ERR_NO_LOGIN /* 1705 */:
                                return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadNotLogin", "\u767b\u5f55\u672a\u5b8c\u6210\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                            case ERR_COMPRESS_ENV_UNPREPAERD /* 1706 */:
                                return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadVideoComposeFail", "\u89c6\u9891\u5408\u6210\u5931\u8d25");
                            case ERR_GENERATE_VIDEO_COVER_FAIL /* 1707 */:
                                return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGenerateVideoCoverFail", "\u4f20\u89c6\u9891\u5c01\u9762\u5931\u8d25(\u6587\u4ef6\u4e0d\u5b58\u5728)");
                            default:
                                return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadFail", "\u4e0a\u4f20\u5931\u8d25");
                        }
                    }
                    return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "QcircleUploadGenerateVideoTimeOutFail", "\u89c6\u9891\u5408\u6210\u8d85\u65f6");
                }
                return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "QcircleUploadGenerateVideoFail", "\u89c6\u9891\u5408\u6210\u5931\u8d25");
            }
            return c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadFileNotExist", "\u6587\u4ef6\u4e0d\u5b58\u5728,\u8bf7\u68c0\u67e5\u6587\u4ef6");
        }
        return "";
    }
}
