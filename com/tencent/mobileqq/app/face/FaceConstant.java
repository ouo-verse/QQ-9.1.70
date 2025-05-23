package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface FaceConstant {
    public static final String ACTION_QQHEAD_CHANGED = "com.tencent.qqhead.changed";
    public static final int AVATAR_DOWNLOAD = 1003;
    public static final String AVATAR_HANDLER = "com.tencent.mobileqq.avatar.handler.AvatarHandler";
    public static final boolean ENABLE_GET_QQHEAD_STAT = true;
    public static final int FACE_WIDTH_HEIGHT = 50;
    public static final int HEAD_USERLOG_OUTPUT_COSTTIME_LIMIT = 3000;
    public static final String KEY_PRO_AVATAR_FRAME_COLOR = "key_pro_avatar_frame_color";
    public static final String KEY_PRO_AVATAR_FRAME_SIZE = "key_pro_avatar_frame_size";
    public static final String MMKV_KEY_AVATAR_SELF_URL = "mmkv_key_avatar_self_url_";
    public static final String MMKV_KEY_USER_AVATAR_INFO = "mmkv_key_user_avatar_info_";
    public static final String MMKV_KEY_ZPLAN_AVATAR_HEAD_IMG_STAMP = "qqavatar_zplan_avatar_head_img_stamp_";
    public static final String MMKV_KEY_ZPLAN_AVATAR_UPDATE_TIME = "qqavatar_zplan_avatar_update_time_";
    public static final String NEARBY_MODULAR_MODULE_ID = "module_nearby";
    public static final String TOGGLE_QQ_AVATAR_BUGFIX_106568443 = "qq_avatar_bugfix_106568443";
    public static final String TOGGLE_QQ_AVATAR_ENABLE_BG_SET_DIMENS = "qq_avatar_enable_bg_set_dimens";
    public static final String TOGGLE_QQ_AVATAR_ENABLE_SETTING_HD_URL = "qq_avatar_enable_setting_hd_url";
    public static final String TOGGLE_QQ_AVATAR_SUPPORT_HEAD_SIZE = "qq_avatar_support_head_size";
    public static final String TOGGLE_QQ_AVATAR_ZPLAN_FACE_PATH_SWITCH = "qq_avatar_zplan_face_path_switch";
    public static final String TOGGLE_QQ_AVATAR_ZPLAN_MANUAL_CANCEL_SWITCH = "qq_avatar_zplan_manual_cancel_switch";
    public static final String TOGGLE_QQ_AVATAR_ZPLAN_UPLOAD_SAVE_DB_SWITCH = "qq_avatar_zplan_upload_save_db_switch";
    public static final String VAS_SPECIAL_SHAPE_MASK = "vas_special_shape_mask";
    public static final String ZPLAN_OUT_BOUND_AVATAR_CLIP_PERCENT = "zplan_out_bound_avatar_clip_percent";
    public static final String ZPLAN_OUT_BOUND_AVATAR_FLAG = "zplan_out_bound_avatar_flag";
    public static final String ZPLAN_OUT_BOUND_BG_URL = "zplan_out_bound_bg_url";

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface Apollo {
        public static final IPatchRedirector $redirector_ = null;
        public static final int[] FACE_BG_COLOR_INDEXED;
        public static final int[] FACE_CATEGORY_ALL;
        public static final int FACE_CATEGORY_FIGURE = 1;
        public static final String FACE_CATEGORY_FIGURE_POSTFIX = "body";
        public static final int FACE_CATEGORY_HEAD = 0;
        public static final String FACE_CATEGORY_HEAD_POSTFIX = "head";
        public static final int FACE_CLIP_SPEC_HEIGHT_2D = 80;
        public static final int FACE_CLIP_SPEC_HEIGHT_3D = 120;
        public static final int FACE_DEFAULT_SIZE_SPEC;
        public static final int FACE_REGION_HALF_FIGURE_CIRCLE_LEFT_2X = 5;
        public static final int FACE_REGION_HALF_FIGURE_CIRCLE_TOP_2X = 40;
        public static final int FACE_REGION_HALF_FIGURE_H = 60;
        public static final int FACE_REGION_HALF_FIGURE_R = 40;
        public static final int FACE_REGION_HALF_FIGURE_W = 45;
        public static final int FACE_REGION_HEAD_H = 40;
        public static final int FACE_REGION_HEAD_W = 40;
        public static final int[] FACE_SHAPE_ALL;
        public static final int[] FACE_SIZE_ALL;
        public static final int FACE_SIZE_BIG = 2;
        public static final int FACE_SIZE_BIG_VALUE = 640;
        public static final int FACE_SIZE_MID = 1;
        public static final int FACE_SIZE_MID_VALUE = 140;
        public static final int FACE_SIZE_SMALL = 0;
        public static final int FACE_SIZE_SMALL_VALUE = 100;
        public static final int[] FACE_SPEC_ALL;
        public static final int FACE_TYPE_2D_AVATAR = 3;
        public static final int FACE_TYPE_3D_AVATAR = 4;
        public static final int FACE_TYPE_AVATAR_DEFAULT = 2;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(34116), (Class<?>) Apollo.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
                return;
            }
            int[] iArr = {0, 1};
            FACE_CATEGORY_ALL = iArr;
            int[] iArr2 = {0, 1, 2};
            FACE_SIZE_ALL = iArr2;
            FACE_DEFAULT_SIZE_SPEC = com.tencent.mobileqq.avatar.utils.a.k(0, 0);
            FACE_SPEC_ALL = com.tencent.mobileqq.avatar.utils.a.j(iArr, iArr2);
            FACE_SHAPE_ALL = new int[]{0, 8, 7, 6};
            FACE_BG_COLOR_INDEXED = new int[]{-2611, -5427, -7983, -665107, -1190657, -2304513, -2826497};
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface AvatarHandlerCmd {
        public static final String CMD_GETQQHEAD = "AvatarInfoSvr.QQHeadUrlReq";
        public static final String CMD_GETQQHEAD_NEW = "IncreaseURLSvr.QQHeadUrlReq";
        public static final String CMD_GETQQHEAD_QCALL = "MultibusidURLSvr.HeadUrlReq";
        public static final String CMD_GETQQHEAD_STRANGER = "MultibusidURLSvr.HeadUrlReq";
        public static final String CMD_GET_APOLLO_HEAD = "OidbSvc.0xedb";
        public static final String CMD_GET_QQ_HEAD_NT = "OidbSvcTrpcTcp.0xfe1";
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface AvatarHandlerNotifyType {
        public static final int TYPE_GET_APOLLO_HEAD = 8;
        public static final int TYPE_GET_APOLLO_HEAD_INFO = 7;
        public static final int TYPE_GET_CUSTOM_HEAD = 1;
        public static final int TYPE_GET_HEAD_INFO = 0;
        public static final int TYPE_GET_HEAD_INFO_FAIL = 6;
        public static final int TYPE_GET_MOBILE_QQHEAD = 2;
        public static final int TYPE_GET_QCALL_HEAD = 5;
        public static final int TYPE_GET_STRANGER_HEAD = 4;
        public static final int TYPE_GET_TROOP_HEAD = 3;
        public static final int TYPE_NOTIFY_STRANGER_DOWNLOADURL_READY = 9;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface AvatarInfoBuilderKeys {
        public static final String APNG_FACE_FLAG = "apngFaceFlag";
        public static final String AVATAR_TYPE = "avatar_type";
        public static final String FACE_FLAG = "faceFlag";
        public static final String HEAD_IMG_TIMESTAMP = "headImgTimestamp";
        public static final String INFO_REQUEST_TIME = "infoRequestTime";
        public static final String STATIC_ZPLAN_FACE_FLAG = "staticZplanFaceFlag";
        public static final String UIN = "uin";
        public static final String URL = "url";
        public static final String ZPLAN_FACE_BG_URL = "zplanFaceBgUrl";
        public static final String ZPLAN_FACE_CLIP_PERCENT = "zplanFaceClipPercent";
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface FaceType {
        public static final int FACE_TYPE_OHTER_SYSTEM = -55;
        public static final int FACE_TYPE_TROOP_SYSTEM = -56;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadBroadcast {
        public static final String BROADCAST_QQHEAD_GET_HEAD_REQ = "com.tencent.qqhead.getheadreq";
        public static final String BROADCAST_QQHEAD_GET_HEAD_RESP = "com.tencent.qqhead.getheadresp";
        public static final String BROADCAST_QQHEAD_REFRESH_HEAD_REQ = "com.tencent.qqhead.refreshheadreq";
        public static final String BROADCAST_QQHEAD_SELF_UPDATE = "com.tencent.qqhead.selfupdate";
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadConfig {
        public static final IPatchRedirector $redirector_ = null;
        public static final long CHECK_FACE_UPDATE_PERIOD = 86400000;
        public static final Bitmap.Config FACE_BITMAP_CONFIG;
        public static final int REQ_FACEINFO_LIST_NUM_LIMIT = 50;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(34133), (Class<?>) HeadConfig.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                FACE_BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadDownload {
        public static final int QQHEAD_DOWNLOAD_TIMEOUT = 3000;
        public static final long QQHEAD_SDCARD_MIN_STORAGE_SIZE = 2048;
        public static final long QQHEAD_SYSTEM_MIN_STORAGE_SIZE = 102400;
        public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION = 9204;
        public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_FAIL = 9203;
        public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_HTTP_RESPONSE_FAIL = 9207;
        public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_NETWORK_FAIL = 9206;
        public static final int RESULT_CODE_QQHEAD_GET_URL_FAIL = 9201;
        public static final int RESULT_CODE_QQHEAD_SAVE_FILE_FAIL = 9202;
        public static final int RESULT_CODE_QQHEAD_STORGE_EXCEPTION = 9208;
        public static final int RESULT_CODE_QQHEAD_SUCCESS = 0;
        public static final int RESULT_CODE_QQHEAD_TIME_OUT = 9205;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadFile {
        public static final byte QQHEAD_FILE_TYPE_DELETED = 2;
        public static final byte QQHEAD_FILE_TYPE_EXIST = 1;
        public static final byte QQHEAD_FILE_TYPE_UNKNOW = 0;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadLevel {
        public static final byte QQHEAD_LEVEL_FOREVER = 0;
        public static final byte QQHEAD_LEVEL_TEMPORARY = 1;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadParams {
        public static final String EXTRA_NAME_FACE_TIMESTAMP = "faceTimestamp";
        public static final String EXTRA_NAME_KEYLIST = "faceKeyList";
        public static final String PARAM_RESULT_CODE = "param_result_code";
        public static final String PARAM_RESULT_DESC = "param_result_desc";
        public static final String PARAM_ZPLAN_AVATAR = "param_zplan_avatar";
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadSetting {
        public static final int MAX_LOWL_EVEL_SETTING_INITCACHE = 100;
        public static final int MAX_SETTING_CACHE = 4000;
        public static final int MAX_SETTING_CACHE_2000 = 2000;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadShape {
        public static final byte FACE_SHAPE_APOLLO_FIGURE = 8;
        public static final byte FACE_SHAPE_APOLLO_FIGURE_HALF = 7;
        public static final byte FACE_SHAPE_APOLLO_HEAD_CIRCLE = 6;
        public static final byte FACE_SHAPE_CIRCLE = 3;
        public static final byte FACE_SHAPE_DEFAULT = 3;
        public static final byte FACE_SHAPE_DISUSSION = 3;
        public static final byte FACE_SHAPE_FORCE_CIRCLE = 4;
        public static final byte FACE_SHAPE_FORCE_SQUARE = 5;
        public static final byte FACE_SHAPE_MAX_VALUE = 8;
        public static final byte FACE_SHAPE_PUBLIC_ACCOUNT = 4;
        public static final byte FACE_SHAPE_ROUND = 2;
        public static final byte FACE_SHAPE_SQUARE = 1;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadSize {
        public static final IPatchRedirector $redirector_ = null;
        public static final int DEFAULT_AVATAR_SIZE = 140;
        public static final int DEFAULT_HD_AVATAR_SIZE = 1080;
        public static final int DYNAMIC_SIZE_BIG = 640;
        public static final int DYNAMIC_SIZE_MIDDLE = 200;
        public static final int DYNAMIC_SIZE_SMALL = 100;
        public static final int[] SIZE_RANGE;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(34151), (Class<?>) HeadSize.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                SIZE_RANGE = new int[]{0, 100, 200, 640, 140, 1080};
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadType {
        public static final int FACE_TYPE_MATCH_FRIEND = 202;
        public static final int FACE_TYPE_OHTER_SYSTEM = -55;
        public static final int FACE_TYPE_TROOP_SYSTEM = -56;
        public static final int QQHEAD_TYPE_APOLLO = 116;
        public static final int QQHEAD_TYPE_BLESS = 108;
        public static final int QQHEAD_TYPE_DATALINE = 102;
        public static final int QQHEAD_TYPE_DATALINE_IPAD = 107;
        public static final int QQHEAD_TYPE_DATALINE_PHONE = 120;
        public static final int QQHEAD_TYPE_DEVICE = 104;
        public static final int QQHEAD_TYPE_DISUSSION = 101;
        public static final int QQHEAD_TYPE_GROUP = 4;
        public static final int QQHEAD_TYPE_GROUP_NEW = 8;
        public static final int QQHEAD_TYPE_GUILD = 117;
        public static final int QQHEAD_TYPE_GUILD_USER_TINYID = 118;
        public static final int QQHEAD_TYPE_IMAX_AD = 114;
        public static final int QQHEAD_TYPE_MERGE_KANDIAN = 111;
        public static final int QQHEAD_TYPE_MOBILE_NUMBER = 11;
        public static final int QQHEAD_TYPE_NEW_TROOP = 113;
        public static final int QQHEAD_TYPE_PSTN_DISCUSSION = 1001;
        public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT = 115;
        public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_ECSHOP = 106;
        public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_SUBSCRIPT = 105;
        public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_XIN_KANDIAN = 110;
        public static final int QQHEAD_TYPE_QCALL = 16;
        public static final int QQHEAD_TYPE_SERVICE_ACCOUNT_FOLDER = 112;
        public static final int QQHEAD_TYPE_STRANGER = 32;
        public static final int QQHEAD_TYPE_SUBACCOUNT = 103;
        public static final int QQHEAD_TYPE_TEMP_GAME_MSG = 119;
        public static final int QQHEAD_TYPE_USER = 1;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface HeadUpload {
        public static final String QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL = "image illegal, size must be square.";
        public static final String QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST = "file not exist";
        public static final String QQ_HEAD_UPLOAD_ERRMSG_NETWORK_ERROR = "network error";
        public static final String QQ_HEAD_UPLOAD_ERRMSG_SUCCESS = "ok";
        public static final String QQ_HEAD_UPLOAD_ERRMSG_UNKNOW_ERROR = "unkown error";
        public static final String QQ_HEAD_UPLOAD_ERRMSG_UPLOAD_FAILED = "upload failed";
        public static final int QQ_HEAD_UPLOAD_FAILEDCODE_SUCCESS = 0;
        public static final int QQ_HEAD_UPLOAD_FAILED_CODE_IMAGE_ILLEGAL = -10000;
        public static final int QQ_HEAD_UPLOAD_FAILED_CODE_NETWORK_ERROR = -10001;
        public static final int QQ_HEAD_UPLOAD_FAILED_CODE_UNKNOW_ERROR = -99999;
        public static final int QQ_HEAD_UPLOAD_FAILED_CODE_UPLOAD_FAILED = -10002;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface LogTag {
        public static final String MAGIC_AVATAR = "magicAvatar.";
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface Nearby {
        public static final IPatchRedirector $redirector_ = null;
        public static final String NEAR_BY_FACE_HANDLER;
        public static final int TYPE_FACE_DOWNLOAD_SUCCESS = 0;
        public static final int TYPE_GET_FACEINFO_FINISHED = 1;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(34155), (Class<?>) Nearby.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                NEAR_BY_FACE_HANDLER = ((IQQNearbyAvatarHandlerApi) QRoute.api(IQQNearbyAvatarHandlerApi.class)).getClassName();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface OutboundSceneId {
        public static final int SCENE_AIO = 101;
        public static final int SCENE_CONTACTS = 103;
        public static final int SCENE_DEFAULT = 0;
        public static final int SCENE_DRAWER_FRAME = 104;
        public static final int SCENE_NORMAL = 1;
        public static final int SCENE_PROFILE_CARD = 102;
        public static final int SCENE_RECENT = 100;
        public static final int SCENE_SHARE_TO_FRIEND = 105;
        public static final int SCENE_UNKNOWN = 10000;
        public static final int SCENE_VAS_AVATAR_SETTING = 106;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface ProAvatarBeanKeys {
        public static final String USE_LOCAL_AVATAR_INFO = "use_local_avatar_info";
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface ResourceFetcherType {
        public static final int DYNAMIC_HEAD = 1;
        public static final int DYNAMIC_HEAD_MP4 = 4;
        public static final int QCIRCLE_APERTURE = 5;
        public static final int VAS_DYNAMIC_HEAD = 2;
        public static final int VAS_PENDANT = 3;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface UinType {
        public static final int ID_OPENID = 204;
        public static final int ID_TINYID = 202;
        public static final int ID_UIN = 200;
        public static final int ID_URL = 205;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface ZplanFaceFlag {
        public static final byte DEFAULT_VALUE = 0;
    }
}
