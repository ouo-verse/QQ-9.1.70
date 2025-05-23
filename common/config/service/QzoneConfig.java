package common.config.service;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneConfig {
    public static final String ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT = "00:00";
    public static final float ALBUM_RECOM_EVENT_CLUSTERING_VAR_DEFAULT = 0.015f;
    public static final int ALBUM_RECOM_EVENT_CORE_PTS_NUM = 3;
    public static final String AVATAR_TIMEOUT = "avatar_timeout";
    public static final String ArchiveMemory_URL = "ArchiveMemoryUrl";
    public static final String BANNER_USE_WEBSO = "bannerUserWebso";
    public static final String CAN_FINISH_ACTIVITY_WHEN_REBOOT = "can_finish_activity_when_reboot";
    public static final String CAN_REPORT_TASK_RUN_AT_FRONT = "can_report_task_run_at_front";
    public static final String CDN_PIC_START = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/";
    public static final String CUSTOM_VIP_MALL = "CustomVipMall";
    public static final String CUSTOM_VIP_PREVIEW = "CustomVipPreview";
    public static final String DEAULT_CM_PAY_JUMP_URL = "https://h5.qzone.qq.com/v2/vip/show/previewDialog?_wv=16781315&_wwv=13&actionId={actionId}&type={type}";
    public static final float DEFAULT_ADJUST_PREDECODE_MEMORY_SIZE = 0.5f;
    private static final String DEFAULT_AE_AUTO_TEMPLATE_MEMORY_LIMIT = "4096";
    private static final int DEFAULT_AE_FRAME_RATE = 30;
    private static final int DEFAULT_AE_HIGH_BITRATE = 5;
    private static final int DEFAULT_AE_HIGH_SIZE = 1920;
    private static final int DEFAULT_AE_LOW_BITRATE = 3;
    private static final int DEFAULT_AE_LOW_SIZE = 960;
    private static final int DEFAULT_AE_MIDDLE_BITRATE = 4;
    private static final int DEFAULT_AE_MIDDLE_SIZE = 1280;
    private static final int DEFAULT_AE_PIC_HIGH_SIZE = 2560;
    private static final int DEFAULT_AE_PIC_LOW_SIZE = 1080;
    private static final int DEFAULT_AE_PIC_MIDDLE_SIZE = 1920;
    private static final int DEFAULT_AE_PREVIEWMAX_RENDERSIZE_ABOVE_2G = 2048;
    private static final int DEFAULT_AE_PREVIEWMAX_RENDERSIZE_BELOW_2G = 1024;
    public static final String DEFAULT_AIO_QZONE_LOVE_GRAY_TIPS_VALUE = "{'\u60c5\u4fa3\u7a7a\u95f4':'https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=qqfrd&qzUseTransparentNavBar=1&_proxy=1'}";
    public static final String DEFAULT_ALBUM_FAKE_FEED_TAIL_CLICK_TIPS = "\u4e0a\u4f20\u4e2d\uff0c\u8bf7\u7a0d\u5019";
    public static final int DEFAULT_ALBUM_NEW_UPLOAD_SHOW = 1;
    public static final int DEFAULT_ALBUM_NEW_UPLOAD_SHOW_INTERVAL_MINUTES = 0;
    public static final String DEFAULT_APPLETS_NICKNAME = "\u5c0f\u7a0b\u5e8f\u901a\u77e5";
    public static final String DEFAULT_APPLETS_UID = "u_EevnyKhMgC1kn2zblVml3A";
    public static final String DEFAULT_APPLETS_UIN = "1038354735";
    public static final String DEFAULT_ARK_SCENE_WHITE_LIST = "1007,1008,1014,1036,2061,2072,2075,2085,2105,2112,2114,2217,2218,4012,4016,4017,4018,4019,4021,4022,4023";
    public static final String DEFAULT_BABY_ALBUM_LEFT_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_4WlIY1I3hn.png";
    public static final String DEFAULT_BABY_ALBUM_RIGHT_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_QWyT73sVVm.png";
    public static final int DEFAULT_CAN_OPEN_APP = 1;
    public static final long DEFAULT_CHOOSE_VIDEO_MAX_DURATION = 600000;
    public static final long DEFAULT_CHOOSE_VIDEO_MAX_SIZE = 1610612736;
    public static final String DEFAULT_CLOUD_PHOTO_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/main?refer=h5maker&no_upload=1&tid={tid}&_wv=2098179";
    public static final int DEFAULT_CONVERSATION_REMAIN_REPORT_CONTROL = 60;
    public static final String DEFAULT_DEL_MEDIA_FILE_DIALOG_MIX_VIDEO_PIC_MSG = "\u540c\u65f6\u5220\u9664\u76f8\u518c\u4e2d\u7684\u7167\u7247\u548c\u89c6\u9891";
    public static final String DEFAULT_DEL_MEDIA_FILE_DIALOG_ONLY_PIC_MSG = "\u540c\u65f6\u5220\u9664\u76f8\u518c\u4e2d\u7684\u7167\u7247";
    public static final String DEFAULT_DEL_MEDIA_FILE_DIALOG_ONLY_VIDEO_MSG = "\u540c\u65f6\u5220\u9664\u76f8\u518c\u4e2d\u7684\u89c6\u9891";
    public static final String DEFAULT_DOMAIN_WHITE_LIST = ".qlogo.cn;.tcb.qcloud.la;open.mp.qq.com;api-report.q.qq.com;rpt.gdt.qq.com;.pic.ap-shanghai.myqcloud.com;.gtimg.cn;graph.qq.com;";
    public static final int DEFAULT_DOWNLOAD_ON_RANGE_MODE = 1;
    public static final String DEFAULT_DROP_DOWN_DEFAULT_RECOMMEND_APPS = "[{\"appId\":\"1108291530\",\"appName\":\"\u6e38\u620f\u4e2d\u5fc3\",\"icon\":\"https://minigame.gtimg.cn/public/appicon/0/78bccc3685c866d1b1e3ba5a43f77b88_200.jpg\",\"type\":3},{\"appId\":\"1108805017\",\"appName\":\"\u4e16\u754c\u4e89\u9738\",\"icon\":\"https://minigame.gtimg.cn/public/appicon/1108805017/93ea8e3e_m.jpg\",\"type\":3},{\"appId\":\"1109508198\",\"appName\":\"\u80e1\u83b1\u4e09\u56fd\",\"icon\":\"https://minigame.gtimg.cn/public/appicon/1109508198/21ffe8c7_m.jpg\",\"type\":3},{\"appId\":\"1109836759\",\"appName\":\"\u706b\u67f4\u4eba\u795e\u5c04\u624b\",\"icon\":\"https://minigame.gtimg.cn/public/appicon/1109836759/dae44357_m.jpg\",\"type\":3},{\"appId\":\"1109694952\",\"appName\":\"\u5929\u5929\u7535\u97f3\",\"icon\":\"https://minigame.gtimg.cn/public/appicon/1109694952/634338d6_m.jpg\",\"type\":3}]";
    public static final String DEFAULT_DROP_DOWN_DEFAULT_RECOMMEND_MODULE_TITLE = "\u597d\u53cb\u5728\u73a9";
    public static final String DEFAULT_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/tpl?source=1&_ws=9&preview=1&_wv=2098179&_dynamicalbum=1&_proxy=1";
    public static final String DEFAULT_DYNAMIC_NATIVE_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/preview?_wv=2098177&source=1&tid=youth";
    public static final int DEFAULT_ENABLE_SCAN_WX_CODE = 1;
    public static final int DEFAULT_ENABLE_V6_ROUTE = 0;
    public static final int DEFAULT_ENABLE_V6_ROUTE_FOR_ALL = 7;
    public static final int DEFAULT_ENABLE_V6_TTT_REPORT = 0;
    public static final int DEFAULT_EXTEND_LIVE_SWITCH = 0;
    public static final float DEFAULT_FACE_DETECT_EYE_SCALE = 0.17f;
    public static final float DEFAULT_FACE_DETECT_SMILE_OPEN_SCALE = 0.05f;
    public static final float DEFAULT_FACE_DETECT_SMILE_SCALE = 0.07f;
    public static final int DEFAULT_FACE_SCAN_QZONE_PLUS_VERSION = 1;
    public static final int DEFAULT_FACE_SCAN_SUPPORT_LOW_VERSION = 12;
    public static final boolean DEFAULT_FEED_DROPDOWN_USE_BOTTOM_SHEET = true;
    public static final String DEFAULT_FEED_LOVE_DIAMOND_URL = "https://h5.vip.qq.com/p/pay/union?openType=webview&disableTitle=1&_wv=16781315&_wwv=13&sandbox=0&debug=0&type=!love&businessType=union&entranceId={entranceId}&disableAskFriend=0";
    public static final int DEFAULT_FEED_OPERATE_TIME = 1;
    public static final int DEFAULT_FEED_PSVADV_SHOW_POS = 1;
    public static final String DEFAULT_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG = "\u4ec5\u80fd\u5220\u9664\u8bf4\u8bf4\uff0c\u4e0d\u80fd\u64a4\u56de\u7ea2\u5305\u3002\u672a\u9886\u7ea2\u5305\uff0c\u572824\u5c0f\u65f6\u540e\u9000\u6b3e\u3002";
    public static final String DEFAULT_FEED_YELLOW_DIAMOND_URL = "https://h5.qzone.qq.com/vip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}&qua={qua}&trace_detail=%7B%22appid%22:%22FeedAN%22%7D";
    public static final String DEFAULT_FFMPEG_VIDEO_COMPRESS_PARAM = "-profile:v main -crf 29";
    public static final int DEFAULT_FIRST_TIME_ENTER_FRIEND_FEEDS_NEED_GET_MAINPAGE = 1;
    public static final String DEFAULT_FOLLOW_FANS_URL = "https://h5.qzone.qq.com/qzone/follow/{hostuin}/fans?_wv=1027&_proxy=1&loginuin={uin}";
    public static final int DEFAULT_FRIEND_FEED_QUICKLY_REPORT_NUM = 10;
    public static final int DEFAULT_GALLERY_RECOM_ALBUM_BACK_PRESS_FINISH = 0;
    public static final int DEFAULT_GALLERY_RECOM_ALBUM_FLING_CLOSE = 0;
    public static final int DEFAULT_GALLERY_RECOM_COUNT_LIMIT = 999;
    public static final long DEFAULT_GET_APPLETS_NOTIFICATION_SETTING_INTERVAL = 1;
    public static final int DEFAULT_GET_PHOTO_BY_TIME_LINE_MAX_COUNT = 100;
    public static final int DEFAULT_GO_CONTENT_BOX_MINI_PROGRAM_APPID = 0;
    public static final String DEFAULT_HERO_VIDEO_HVC_HWDEC_MODE = "vivo NEX S|";
    public static final int DEFAULT_IMAGE_MANAGER_MEMORY_SIZE = 128;
    public static final int DEFAULT_IMAGE_MANAGER_USE_ARGB8888 = 1;
    public static final String DEFAULT_INTIMATE_SAPCE_DISBAND_PAGE = "https://h5.qzone.qq.com/intimate-space/h5/disband-space?_wv=1&_wwv=8193&_bid=5588";
    public static final String DEFAULT_INTIMATE_SPACE_MANAGER_PAGE = "mqzone://arouse/intimate/managepage?";
    public static final int DEFAULT_IS_OPEN_PHOTO_SAVE = 1;
    public static final int DEFAULT_IS_OPEN_QRCODE_SCAN = 1;
    public static final String DEFAULT_IS_SHOW_ENTRANCE = "0";
    public static final int DEFAULT_JUMP_TO_WEISHI = 1;
    public static final int DEFAULT_KEY_ALLOW_ALBUM_RECOMMEND_SHOW_GALLERY = 1;
    public static final int DEFAULT_KEY_ALLOW_SCROLL_TO_RECOMMEND = 1;
    public static final int DEFAULT_KEY_DIRECT_JUMP_TO_NEW_USER_HOME = 1;
    public static final int DEFAULT_KEY_FEEDX_LAYER_REQUEST_USE_MAIN_PROCESS = 1;
    public static final int DEFAULT_KEY_FEEDX_LAYER_RESPONSE_IN_SUB_THREAD = 1;
    public static final String DEFAULT_KEY_IS_CAN_ENTER_IN_AIO_FROM_COUPLE_APP = "0";
    public static final String DEFAULT_KEY_JUMP_TO_MORE_VIDEO_URL = "https://h5.qzone.qq.com/qzone/video?_wv=3&usewk=1&_proxy=1";
    public static final String DEFAULT_KEY_MARTET_TO_DOWNLOAD_WEISHI = "market://details?id=com.tencent.weishi";
    public static final String DEFAULT_KEY_MOMENT_DISABLE_MODEL = "PEUM00,PGU110,PHN110,CPH2499,CPH2551";
    public static final int DEFAULT_KEY_OFFICIAL_ACCOUNT_CAN_SHOW_FEEDS_LIST = 0;
    public static final int DEFAULT_KEY_OPEN_LAYER_CARVED_ANIM = 1;
    public static final int DEFAULT_KEY_PUBLISH_PAGE_IF_SHOW_SYNC_QCIRCLE_BUBBLE = 1;
    public static final String DEFAULT_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_MEMORY_SWITCH_BUBBLE_TEXT = "\u5df2\u6839\u636e\u4f60\u7684\u4e60\u60ef\n\u81ea\u52a8\u6253\u5f00\u540c\u6b65";
    public static final int DEFAULT_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_PART_SHOW = 1;
    public static final String DEFAULT_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_PREVIEW_BUBBLE_TEXT = "\u8bd5\u8bd5\u6587\u5b57\u8f6c\u89c6\u9891";
    public static final String DEFAULT_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_SWITCH_BUBBLE_TEXT = "\u8bd5\u4e0b\u628a\u5185\u5bb9\u540c\u6b65\u5230\n\u5c0f\u4e16\u754c\u5427";
    public static final int DEFAULT_KEY_QAV_BACK_PRESS_SWITCH = 1;
    public static final int DEFAULT_KEY_QAV_SHOW_QZONE_ENTRANCE = 1;
    public static final int DEFAULT_KEY_QZONE_FEED_LIST_HAS_MORE_SWITCH = 1;
    public static final int DEFAULT_KEY_QZONE_MOMENT_ENTRANCE_SWITCH = 1;
    public static final int DEFAULT_KEY_QZONE_MOMENT_NEW_USER_GUIDE_SWITCH = 0;
    public static final String DEFAULT_KEY_QZONE_MOMENT_OUTER_ENTRANCE_MAIN_TEXT = "\u6b64\u523b";
    public static final int DEFAULT_KEY_QZONE_MOMENT_PUSH_GET_UNDEALCOUNT_SWITCH = 1;
    public static final int DEFAULT_KEY_SHOW_ENTRANCE_GUIDE = 1;
    public static final int DEFAULT_KEY_SYNC_QFS_MEMORY_COUNT_THRESHOLD = 1;
    public static final String DEFAULT_KEY_WEB_TO_DOWNLOAD_WEISHI = "https://isee.weishi.qq.com/iseev2/1/PSg56S8_e/index.html?_wwv=4096";
    private static final String DEFAULT_KEY_WINK_AVATAR_VIDEO_CONTROl = "{\"count\": 3,\"day\": 7,\"hour\":2}";
    private static final String DEFAULT_KEY_WINK_COMPRESS_ADAPTER_QP_PARAM = "{\"qcom\": {\"i_min\": 15,\"i_max\": 30,\"p_min\": 15,\"p_max\": 35,\"b_min\": -1,\"b_max\": -1},\"exynos\": {\"i_min\": -1,\"i_max\": -1,\"p_min\": -1,\"p_max\": -1,\"b_min\": -1,\"b_max\": -1},\"mtk\": {\"i_min\": -1,\"i_max\": -1,\"p_min\": -1,\"p_max\": -1,\"b_min\": -1,\"b_max\": -1},\"others\": {\"i_min\": -1,\"i_max\": -1,\"p_min\": -1,\"p_max\": -1,\"b_min\": -1,\"b_max\": -1}}";
    private static final String DEFAULT_KEY_WINK_SIGN_VIDEO_CONTROl = "{\"count\": 3,\"day\": 7,\"hour\":2}";
    private static final String DEFAULT_KEY_WINK_THUMB_SPS_CONFIG = "{\"profileIdc\":[110]}";
    public static final int DEFAULT_LIMIT_FACE_NUMS = 5;
    public static final String DEFAULT_LOVE_ALBUM_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_TMitj1NKy1.png";
    public static final int DEFAULT_MAKE_PHOTO_BLOG_FUNCTION_OPEN = 1;
    public static final int DEFAULT_MANUAL_LOAD_SWITCH_STATUS = 1;
    public static final long DEFAULT_MAX_P2V_VIDEO_DURING = 15000;
    public static final int DEFAULT_MAX_RANGE_NUMBER = 4;
    public static final int DEFAULT_MINI_APP_BRING_TITLE_BAR_TO_FRONT = 1;
    public static final int DEFAULT_MINI_APP_ECSHOP_NUM_MSG_ENABLE = 1;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SEARCH = 0;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SEARCH_OPEN = 1;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_CLOSE = 1;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION = 1;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_OPEN = 1;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_RED_DOT = 1;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_RED_DOT_OPEN = 1;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_SETTING = 0;
    public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_SETTING_OPEN = 1;
    public static final String DEFAULT_MINI_APP_FULL_SCREEN_TITLE = "\u5c0f\u7a0b\u5e8f";
    public static final int DEFAULT_MINI_APP_REFRESH_SHOW_ICON = 0;
    public static final int DEFAULT_MINI_APP_SHOW_FULL_SCREEN = 1;
    public static final int DEFAULT_MINI_APP_SHOW_MSG_RED_DOT = 0;
    public static final int DEFAULT_MINI_APP_SHOW_RED_DOT = 0;
    public static final int DEFAULT_MINI_APP_TOP_MAX_NUM = 50;
    public static final String DEFAULT_MINI_GAME_BASELIB = "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20190708174635_6988/lib-1.4.7.zip\",\"key2\":\"\",\"key3\":\"1.4.7\",\"key4\": {\"file_length\": 6336933},\"key5\":2}";
    public static final int DEFAULT_MINI_GAME_PAY_BY_H5 = 0;
    public static final String DEFAULT_MY_VIP_NALEPLATE_HOME_URL = "https://h5.qzone.qq.com/v2/vip/hz/medal?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32";
    public static final int DEFAULT_NAVIGATE_BACK_BY_APPINFO = 1;
    public static final int DEFAULT_NEW_STYLE_SHUOSHUO_NEW_CARD_SWITCH_OPEN = 0;
    public static final String DEFAULT_OPENDATA_DOMAIN_WHITE_LIST = ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la";
    public static final String DEFAULT_OPENURL_FILTER = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb|https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb";
    public static final int DEFAULT_OWNER_OPERATE_TIME = 3;
    public static final String DEFAULT_P2V_FUN_BLACK_LIST = "MI 3,GT-N7108,vivo Y51A,OPPO R6007,R6007,vivo Y31A,vivo Y31,vivo Y35A,CAM-AL00,CAM-UL00,CAM-TL00,M821,SM-A7000,MI 2SC,SM-G6000,Mi Note 2,M5 Note,Mi Note 2,F8332,m5 note,SM-C5000,OPPO A33m,OPPO A33,OPPO A37m,M15,MI 5C,OPPO A31,Pixel 3a,V1813BA,LIO-AL00,TAS-AL00,VOG-AL00,VOG-AL10,M2004J7BC,SM-G9860";
    public static final int DEFAULT_P2V_FUN_ENABLE = 1;
    public static final boolean DEFAULT_P2V_NEED_ORIGINAL = true;
    public static final long DEFAULT_P2V_STORAGE_LIMIT = 62914560;
    public static final int DEFAULT_P2V_SUPPORTED_CPU_FAMILY = 2;
    public static final int DEFAULT_PHOTOVIEW_LIST_SIZE_TO_FINISH = 409600;
    public static final int DEFAULT_PHOTOVIEW_PHOTO_BYTES = 3500;
    public static final int DEFAULT_PHOTOVIEW_VIDEO_BYTES = 8500;
    public static final String DEFAULT_PHOTO_BLOG_URL = "https://h5.qzone.qq.com/blog/editor2?_wv=4099&_proxy=1&source=shouzhang";
    public static final float DEFAULT_PHOTO_GROUP_LIST_IMAGE_CROP_SPACE_RATIO = 0.25f;
    public static final String DEFAULT_PICTURE_VIEWER_DANMAKU_BLACK_LIST = "";
    public static final int DEFAULT_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH = 0;
    public static final String DEFAULT_PICTURE_VIEWER_DANMAKU_GARY_RANGE = "00-100";
    public static final int DEFAULT_POLY_PRELOAD_TIME = 200;
    public static final String DEFAULT_PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA = "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4";
    public static final String DEFAULT_QCIRCLE_GROUP_AIO_REDPOINT_ICON_URL = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/changename/qvideo_aio_groupchat_entrance.png";
    public static String DEFAULT_QFLUTTER_URL = "{\"key1\":\"https://mqq-plugin.qq.com/a696131d7cde6ad2c9aae156ec1d3b5a\",\"key2\":\"\",\"key3\":\"0.0.6\",\"key4\": {\"file_length\": 7786698},\"key5\":80}";
    public static final int DEFAULT_QMUSIC_HLS_MAX_RETRY_TIMES = 3;
    public static final String DEFAULT_QQCIRCLE_CHAT_CLUSTER_UINS_ONLY_SHOW_BUBBLE = "3499975001";
    public static final int DEFAULT_QZONE_DOWNLOADER_USE_OKHTTP_MODE = 1;
    public static final String DEFAULT_QZONE_FACE_SCAN_BLACKLIST = "";
    public static final int DEFAULT_QZONE_FACE_SCAN_SWITCH = 1;
    public static final int DEFAULT_QZONE_MAIN_FORCE_SHUTDOWN_GIF_DECODE = 0;
    public static final String DEFAULT_QZONE_QUN_DETAIL = "https://h5.qzone.qq.com/groupphoto/inqq/detail/{qunid}/{albumid}/{lloc}?busi_param.2={lloc}&busi_param.7=1&busi_param.16=2&busi_param.21={uploadtime}&busi_param.34=5&refresh_type=7&index=0&_wv=1073800185&_proxy=1&qua={qua}";
    public static final String DEFAULT_RANGE_MODE_NETWORK_LEVEL = "1,2,3,6";
    public static final String DEFAULT_RANGE_MODE_PERF_LEVEL = "1,2,3";
    public static final long DEFAULT_RANGE_SIZE = 524288;
    public static final int DEFAULT_RECENT_PHOTO_CAROUSEL_COUNT = 5;
    public static final long DEFAULT_RECENT_ROUTE_EXPIRE_TIME = 7200000;
    public static final int DEFAULT_RECOMMEND_ALBUM_GALLERY_BG_SWITCH = 20;
    public static final int DEFAULT_RECOMMEND_ALBUM_GALLERY_SWITCH = 0;
    public static final int DEFAULT_RECOMMEND_COUNT_NUM_LIMIT = 999;
    public static final int DEFAULT_SECONDARY_UPLOAD_PHOTO_PAGE_TIP = 1;
    public static final String DEFAULT_SELECT_TEMPLATE_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/coverList?source=1&_ws=9&preview=1&_wv=2098179&_dynamicalbum=1";
    public static final String DEFAULT_SELF_PRAISE_ANIMATION_RES_URL = "https://d3g.qq.com/sngapp/app/update/20190307193443_9744/selfPraise.zip";
    public static final String DEFAULT_SHARE_ALBUM_INVITE_TO_FEEDS_URL = "https://h5.qzone.qq.com/manyPeopleAlbum/invite/{albumUin}/{albumid}?uin={loginUin}&_proxy=1&_wv=3&_wvv=4";
    public static final int DEFAULT_SHARE_ALBUM_TO_WEIXIN_MINI_PROGRAM_NEED_SK_VALUE = 1;
    public static final int DEFAULT_SHARE_SINGLE_BIG_PICTURE_AS_WECHAT_MINI_PROGRAM = 1;
    public static final int DEFAULT_SHOW_TIME_LINE_IN_RECENT_PHOTO_TAB = 1;
    public static final int DEFAULT_SMART_BEAUTIFY_ANIMATION_GAP = 300;
    public static final String DEFAULT_SMART_BEAUTIFY_ANIMATON_RES_MD5 = "2710f0a3dfeb2881c3af1f7849f6e700";
    public static final String DEFAULT_SMART_BEAUTIFY_ANIMATON_RES_URL = "https://d3g.qq.com/sngapp/app/update/20181213192737_5845/animation.zip";
    public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_CHECKED_STATUS = 1;
    public static final long DEFAULT_SMART_BEAUTIFY_IMAGE_CREATE_TIME_DIFF_MIN = 1;
    public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_NUM_MAX = 4;
    public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_NUM_MIN = 3;
    public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_RECOMM_DISABLE = 0;
    public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_RECOMM_ENABLE = 1;
    public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_SCAN_TAG_ENABLE = 1;
    public static final int DEFAULT_SMART_BEAUTIFY_MAX_EXPOSURE_TIMES = 2;
    public static final int DEFAULT_SMART_BEAUTIFY_MAX_WAIT_TIME = 5000;
    public static final String DEFAULT_SMART_DNSSERVICE = "182.254.116.117|182.254.118.11";
    public static final String DEFAULT_STUDY_MODE_APPID_WHITELIST = "1108338344,1108961705,1110468841,1110426672,1109048181,1109907872";
    public static final String DEFAULT_STUDY_MODE_SCENE_WHITELIST = "1173";
    public static final String DEFAULT_SUBPERSONAL_HOMEPAGE_URL = "https://h5.qzone.qq.com/v2/vip/live/profile?openid={openid}&puin={puin}&_wv=16777217";
    public static final String DEFAULT_SUBSCRIBE_PERSONAL_SHARE_FAN_GROUP_URL = "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3";
    public static final String DEFAULT_SWEET_MAIN_PAGE_JUMP_H5_URL = "https://h5.qzone.qq.com/mood/lover?_wv=1027&_proxy=1";
    public static final String DEFAULT_SWEET_MAIN_PAGE_JUMP_URL = "mqqapi://miniapp/open?_atype=0&_mappid=1108789561&_mvid=&_vt=3&referer=brandonlin&via=brandonlin&_sig=57b13f050e544ea7391452287c2f92c7ebf08e0d4bd1faef7d72c8c961ea80c9";
    public static final String DEFAULT_SWEET_MAIN_PAGE_JUMP_URL_FOR_GUEST = "mqqapi://miniapp/open?_atype=0&_mappid=1108789561&_mvid=&_path=%2Fpages%2Fhome_v2%2Floverindex%2Floverindex&_vt=3&referer=brandonlin&via=brandonlin&_sig=5769d092f16fddbe05f75e679074639954b1554710aee3060cedc8545b5c5f4b";
    public static final String DEFAULT_SWEET_SETTING_RED_DOT_ANIMATION_SRC = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/love_zone_setting_src/setting_me_love_zone_frame_ani.zip";
    public static final String DEFAULT_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_MODELS = "ALE-CL00;GT-N7108;N7108;A31c;ZTE A2019 Pro;Y51;A33";
    public static final int DEFAULT_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_OSVERSION = 20;
    public static final int DEFAULT_TIANSHU_FEATURE_RED_TOUCH_DISMISS = 1;
    public static final long DEFAULT_TIME_DELAY_TO_GET_GUIDE_QBOSS_ADV = 86400000;
    public static String DEFAULT_TISSUE_BASELIB_URL = "{\"key1\":\"https://downv6.qq.com/miniapp/tissue_1.8.3.0.zip\",\"key2\":\"\",\"key3\":\"1.8.3.0\",\"key4\": {\"file_length\": 6831540},\"key5\":99}";
    public static final String DEFAULT_TRAVEL_ALBUM_LEFT_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_PfBsCode7B.png";
    public static final String DEFAULT_TRAVEL_ALBUM_RIGHT_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_8O4HN8FsAI.png";
    public static final int DEFAULT_TROOP_GRAY_TIPS_COOL_DOWN_HOURS = 24;
    public static final int DEFAULT_TROOP_GRAY_TIPS_MIN_PHOTO_COUNT = 9;
    public static final String DEFAULT_UNION_VIP_FEED_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/feedaz/lv{level}.zip";
    public static final String DEFAULT_UNION_VIP_HEAD_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/headaz/lv{level}.zip";
    public static final String DEFAULT_UNION_VIP_HOME_URL = "https://h5.qzone.qq.com/bigVip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}";
    public static final String DEFAULT_UNION_VIP_PAY_URL = "https://h5.qzone.qq.com/vip/payBigDialog/{openUin}/{openMonth}?_wv=16781315&_wwv=13&aid={aid}";
    public static final String DEFAULT_UNION_VIP_WIDGET_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/widget/LV{level}.png";
    public static final int DEFAULT_UNREAD_FOLLOW_EXPOSURE_COUNT = 10;
    public static final int DEFAULT_UPLOAD_BIG_VIDEO_BYTE = 1610612736;
    public static final String DEFAULT_UPLOAD_CHANGEROUTE_RETCODE = "104,115,11,2,103,110,113,101,100,4";
    public static final int DEFAULT_UPLOAD_ENABLE_DOWNLOAD_SO = 0;
    public static final String DEFAULT_UPLOAD_NETWORK_UNAVAILABLE_RETCODE = "113,101,100";
    public static final int DEFAULT_USE_QQ_EMOTICON_COMMENT = 0;
    public static final String DEFAULT_VALUE_INTIMATE_SPACE_NAME = "\u4eb2\u5bc6\u7a7a\u95f4";
    public static final String DEFAULT_VALUE_MINIGAME_LAMEMP3_SO_INFO = "{\"url\":\"https://d3g.qq.com/sngapp/app/update/20201105204646_864/libminigame_lamemp3.so\",\"md5\":\"23e9ed55e3d3acd0b93c0f55cc11bdb7\",\"length\":165396}";
    public static final String DEFAULT_VALUE_MINIGAME_LAMEMP3_SO_INFO_64 = "{\"url\":\"https://d3g.qq.com/sngapp/app/update/20210902154533_8382/VD1Vg6kzck5I0UmQ6W6dPA==_libmini_lamemp3.so\",\"md5\":\"be68b968f6013572ed2a47b6519abe9a\",\"length\":224272}";
    public static final String DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_IMAGE_URL = "https://miniapp.gtimg.cn/game/audit/reason/1655265385422/1655265385422-Slice1.png";
    public static final String DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_SCENE_AND_MODE_BLACK_LIST = "desktoprecent,main,friendmore,maintj,mainph,mainpk,mainguess,pkdesktop,mainfriend";
    public static final String DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_SCENE_AND_VIA_BLACK_LIST = "[{\"scene\":2054,\"via\":\"2054_3\"}]";
    public static final String DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_SCENE_BLACK_LIST = "1001,3001,3002,3003,3007,3009,3010,3013,3015,3022,3024,3026,3027,3028,3029,2086,2103,5007";
    public static final String DEFAULT_VALUE_MINI_GAME_RETAIN_BACKGROUND_URL = "https://miniapp.gtimg.cn/game/audit/reason/1663151626420/1663151626425-game_retain_bg.png";
    public static final String DEFAULT_VALUE_MINI_GAME_RETAIN_CHANGE_ALL = "https://sola.gtimg.cn/aoi/sola/20201023212055_vhmnkmRvWb.png";
    public static final String DEFAULT_VALUE_MINI_GAME_RETAIN_LEFT_BTN_BACKGROUND_URL = "https://sola.gtimg.cn/aoi/sola/20201026161621_qKiWYA1Hc2.png";
    public static final String DEFAULT_VALUE_MINI_GAME_RETAIN_RIGHT_BTN_BACKGROUND_URL = "https://sola.gtimg.cn/aoi/sola/20201026161621_z77QU6MeWL.png";
    public static final int DEFAULT_VALUE_PRELOAD_ITEM_SIZE_FOR_AD = 3;
    public static final int DEFAULT_VALUE_PRELOAD_ITEM_SIZE_NORMAL = 8;
    public static final String DEFAULT_VALUE_QQ_VIDEO_COMMENT_PUBLIC_TIPS_CONENT = "\u4ec5\u5f53\u52a8\u6001\u4e3a\u6240\u6709\u4eba\u53ef\u89c1\u65f6,\u6b64\u8bc4\u8bba\u4ed6\u4eba\u53ef\u89c1\u5e76\u5c55\u793aIP\u5c5e\u5730";
    public static final String DEFAULT_VALUE_QZONE_INTIMATE_ACTIVATE_PAGE_URL = "https://h5.qzone.qq.com/intimate-space/h5/activate?_wv=1&_wwv=8193&_bid=5588";
    public static final String DEFAULT_VALUE_QZONE_INTIMATE_HISTORY_PAGE_URL = "https://h5.qzone.qq.com/intimate-space/h5/history-spaces?_wv=1&_wwv=73729&_bid=5588";
    public static final String DEFAULT_VALUE_QZONE_INTIMATE_SPACE_BADGE_HALO_BGURL = "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/8970/default_light.png";
    public static final String DEFAULT_VALUE_QZONE_INTIMATE_SPACE_BADGE_LOTTIE_URL = "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/8970/confetti_frist.zip";
    public static final String DEFAULT_VALUE_WEBAUDIO_SO_INFO = "{\"url\":\"https://d3g.qq.com/sngapp/app/update/20200723130554_3898/libwebAudio.so\",\"md5\":\"c387d4ac69717660762353321313c6c4\",\"length\":13345220}";
    public static final String DEFAULT_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20180412205352_WOHxRvJEI2.png";
    public static final String DEFAULT_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL_FROM_VS = "https://qzonestyle.gtimg.cn/aoi/sola/20190319155945_1kfosfdfO0.png";
    public static final int DEFAULT_VERTICAL_VIDEO_LAYER_DISABLE_UPLOAD_USER_ACTION = 0;
    public static final int DEFAULT_VERTICAL_VIDEO_LAYER_LOW_MEMORY = 5;
    public static final String DEFAULT_VERTICAL_VIDEO_PLUGIN_SIZE_TEXT = "\u63d2\u4ef6\u7ea61M";
    public static final String DEFAULT_VERTICAL_VIDEO_PLUGIN_UPDATE_TIPS = "\u5347\u7ea7\u63d2\u4ef6\uff0c\u4f53\u9a8c\u7cbe\u5f69\u5c0f\u89c6\u9891";
    public static final int DEFAULT_VIDEO_CACHE_SIZE_RATE_TIMEOUT = 3000;
    public static final String DEFAULT_VIDEO_HOST_ENABLE_HTTPDNSSERVICE = "vwecam.tc.qq.com|vliveachy.tc.qq.com|vqzone.tc.qq.com";
    public static final int DEFAULT_VIDEO_TAB_JUMP_TO_WEISHI = 1;
    public static final int DEFAULT_VIDEO_TAB_PRELOAD_NUMS = 10;
    public static final String DEFAULT_VIDEO_TVK_HOST = "vv6.video.qq.com";
    public static final String DEFAULT_WHITE_LIST_LOW = "vivo X5M|";
    public static final String DEFAULT_WHITE_LIST_MIDDLE = "VKY-AL00|BKL-AL20";
    public static final int DEFAULT_WX_MINIAPP_EABLE = 1;
    public static final long DEFAULT_ZPLAN_SETTING_GUIDE_STAY_TIME = 15000;
    public static final int DEFAULT_ZPLAN_TOGGLE_NEW_CONCISE = 1;
    public static final int DEFUALT_SHUOSHUO_NEWCARD_SHOW_VIEW = 0;
    public static final long DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS = 1095;
    public static final String DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_TIPS = "\u4f5c\u54c1\u53d1\u5e03\u5f88\u4e45\u4e86\uff0c\u6d4f\u89c8\u8bb0\u5f55\u4e0d\u652f\u6301\u67e5\u770b\u54e6";
    private static final int DEF_RENDER_MODEL_OPEN = 1;
    public static final int DEF_REPORT_CALCULATE_FRAME_COUNT = 20;
    public static final int DEF_SWITCH_ENABLED_VAL = 1;
    public static final int DETAIL_COMMENT_SOFT_ORDER_DEFAULT = 1;
    public static final String DOWNLOAD_TO_DEFAULT_TAB = "downloadToDefaultTab";
    public static final int DYNAMIC_MAX_PHOTO_NUM = 60;
    public static final int DYNAMIC_MIN_PHOTO_NUM = 3;
    public static final String ENABLE_SCAN_WX_CODE = "enable_scan_wx_code";
    public static final String FACATE_LOCAL_DATE = "Facate_Local_Date";
    public static final String FLOAT_MODEL_BLACKLIST_DEFAULT_VALUE = "N5117,R8007,Coolpad 8720L,R7007,GN9000L,G620-L75,R2017,R6007,R831S,HM 1SC,Coolpad 8705,HUAWEI B199,Coolpad 9190L,HM 1SW,Coolpad 8730L,Coolpad 9190_T00,HS-E620M,HUAWEI G660-L075,Coolpad 5952,HUAWEI G730-L075,Coolpad 8729,HUAWEI C8817L,Bird LT01,Coolpad 5892,Coolpad 7620L,GN9004,HS-X8T,iPhone 6plus,K-Touch Tou ch 2,K-Touch Tou ch3,K-Touch Tou ch3w,Lenovo A560,Lenovo A890e,Lenovo B8080-HV,Lenovo S810t,LT18,MI 3C,N5110,Nokia_XL_4G,R2010,R8000,TCL-P688L,U558,ZTE Grand S II LTE,ZTE Q505T,ZTE Q802T,Coolpad Y60-C1,Coolpad 8702,BOWAY TL2000,Best sonny_LT986,BOWAY TL6000,Coolpad 5200S,Coolpad 5311,Coolpad 5315,DOOV T35,DOOV T60,HS-EG971,HS-EG978,HTC D516d,HUAWEI G6-L22,HUAWEI G620-L72,i6200S,KliTON,koobee M2,L-002,L823,L826,L827,Lingwin K1,LNV-Lenovo A505e,M7009,M811,MI 3W,R830S,ZTE Q801L,ZTE Q701C,YUSUN L63,TCL P631M,TCL J738M,T-smart L818,OUKI G5,OPSSON Q3,\u3000\u3000,MT2L03,VOTO VT898,AOLE,N5111,LA2-L,vtel X5,ETON T3,BOWAY TL500,T-smart L808,DOOV T90,CHM-TL00,thl L968,TCL J938M,2013022,HUAWEI G750-T01,vivo Y20T,vivo Y17T,vivo Y13T,vivo Y15T,vivo X3S W,U707T,R823T,R819T,N1T,Hol-T00,H8S,H30-U10,2014011,M351,HUAWEI G610-T11,vivo X3t,HUAWEI P6-T00,HUAWEI G700-U00,ETON I6,vivo Y11i T,HM NOTE 1TD";
    public static final String GDT_CGI_REPORT_HOST = "GdtCgiReportHost";
    public static final int HOMEPAGE_GUEST_DEFAULT_COVER_SHOW_DELAY_MS_VALUE = 3000;
    public static final String IS_PATCH_ENABLE = "isPatchEnable";
    public static final String IS_SHOW_SAFE_MODE = "isShowSafeMode";
    public static final String KEY_BUSINESSDATA = "key_businessfeeddata";
    public static final String KEY_MARTET_TO_DOWNLOAD_WEISHI = "DownloadWeishiFromMarket";
    public static final String KEY_SHOW_ENTRANCE_GUIDE = "showEntranceGuide";
    public static final String KEY_SHOW_TIME_LINE_FOR_GUEST_IN_RECENT_PHOTO_TAB = "showTimelineButtonForGuestInRecentPhotoTab";
    public static final String KEY_SHOW_TIME_LINE_FOR_HOST_IN_RECENT_PHOTO_TAB = "showTimelineButtonForHostInRecentPhotoTab";
    public static final String KEY_WEB_TO_DOWNLOAD_WEISHI = "DownloadWeishiFromURL";
    public static final int LOADING = 1;
    public static final int LOAD_FAIL = 3;
    public static final int LOAD_SUCC = 2;
    private static final long LOG_MIN_INTERVAL = 1000;
    public static final String MAIN_GIF_SETTING = "GifSetting";
    public static final String MAIN_KEY_AEEDITOR = "aeeditor";
    public static final String MAIN_KEY_ARCHIVE_MEMORY = "archiveMemory";
    public static final String MAIN_KEY_BIZ = "BizFeeds";
    public static final String MAIN_KEY_BUBBLE_UNREAD = "K_QQ_VAS";

    @Deprecated
    public static final String MAIN_KEY_CLICKREPORT = "ReportSetting";
    public static final String MAIN_KEY_CLIENTREPORT = "ClientReport";
    public static final String MAIN_KEY_CONTENT_BOX_LAUNCH = "contentboxlaunch";
    public static final String MAIN_KEY_DOWNLOAD_SETTING = "DownloadSetting";
    public static final String MAIN_KEY_EASTEREGG = "EasterEgg";
    public static final String MAIN_KEY_EXTRA_CONFIG = "ExtraConfig";
    public static final String MAIN_KEY_FACADE = "QzoneFacade";
    public static final String MAIN_KEY_FAKE_FEED_SOFT_PERIOD = "fake_feed_soft_period";
    public static final String MAIN_KEY_FEED_PIC_TEXT_CARD_VIEW = "FeedPicTextCardView";
    public static final String MAIN_KEY_FORBIDDEN_PAGE_FEED = "feedForbiddenPage";
    public static final String MAIN_KEY_GETUSERTIMELOGO = "QZoneGetUserTimeLogo";
    public static final String MAIN_KEY_H5URL = "H5Url";
    public static final String MAIN_KEY_HOMEPAGE_BAR = "HomepageBar";
    public static final String MAIN_KEY_INTIMATE_SPACE = "intimate_space";
    public static final String MAIN_KEY_JUMPQZONE = "JumpQzone";
    public static final String MAIN_KEY_LIVE_VIDEO = "LiveSetting";
    public static final String MAIN_KEY_MEDIAFRAME = "MediaFrame";
    public static final String MAIN_KEY_MEMORY = "memmory_policy";
    public static final String MAIN_KEY_MINIAPP = "qqminiapp";
    public static final String MAIN_KEY_MINIAPP_QQ = "qqminiapp";
    public static final String MAIN_KEY_MINIGAME = "qqtriton";
    public static final String MAIN_KEY_MINI_APP = "qqminiapp";
    public static final String MAIN_KEY_MINI_VIDEO = "MiniVideo";
    public static final String MAIN_KEY_NAVIGATOR_BAR = "NavigationBar";
    public static final String MAIN_KEY_OFFICIAL_ACCOUNT = "OfficialAccount";
    public static final String MAIN_KEY_OFFLINE_CACHE = "QzUrlCache";
    public static final String MAIN_KEY_OUTBOX = "OutBox";
    public static final String MAIN_KEY_PERFORMANCE = "QZonePerformance";
    public static final String MAIN_KEY_PHOTOVIEW = "PhotoView";
    public static final String MAIN_KEY_PHOTO_AB_SVRLIST = "PhotoABSvrList";
    public static final String MAIN_KEY_PHOTO_ALBUM = "PhotoAlbum";
    public static final String MAIN_KEY_PHOTO_DOWNLOAD = "PhotoDownload";
    public static final String MAIN_KEY_PHOTO_EDITOR = "PhotoEditor";
    public static final String MAIN_KEY_PHOTO_SVRLIST = "PhotoSvrList";
    public static final String MAIN_KEY_PHOTO_UPLOAD = "PhotoUpload";
    public static final String MAIN_KEY_PLATO = "Plato";
    public static final String MAIN_KEY_POLY_PRAISE = "polymorphicPraise";
    public static final String MAIN_KEY_PUBLISH_MOOD = "PublishMood";
    public static final String MAIN_KEY_QQCIRCLE = "qqcircle";
    public static final String MAIN_KEY_QQ_EMOTICON_COMMENT = "QZoneCommentSetting";
    public static final String MAIN_KEY_QQ_LIVE = "qqLive";
    public static final String MAIN_KEY_QQ_SETTING = "qqsetting";
    public static final String MAIN_KEY_QQ_STORY_VIDEO_SETTING = "qqstoryvideo";
    public static final String MAIN_KEY_QQ_SUBSCRIBE_SETTING = "qqsubscribe";
    public static final String MAIN_KEY_QUN_ALBUM_SETTING = "QunAlbumSetting";
    public static final String MAIN_KEY_QZONECOVER = "QzoneCover";
    public static final String MAIN_KEY_QZONE_EXTEND_LIVE = "K_QZKuolieEnterance";
    public static final String MAIN_KEY_QZONE_FROM_QFS = "QZoneFromQFS";
    public static final String MAIN_KEY_QZONE_SETTING = "QZoneSetting";
    public static final String MAIN_KEY_QZONE_TEXTCELL_SETTING = "QZoneTextCellSetting";
    public static final String MAIN_KEY_QZ_CUSTOM_FONT = "QzCustomFont";
    public static final String MAIN_KEY_RANK_COMMENT = "rank_comment";
    public static final String MAIN_KEY_REPORT = "qzoneReport";
    public static final String MAIN_KEY_SAFEMODE = "SafeModeSetting";
    public static final String MAIN_KEY_SCHEMA = "Schema";
    public static final String MAIN_KEY_SEARCH_MOOD = "QZSearch";
    public static final String MAIN_KEY_SECRET_SHUOSHUO = "ScretShuoShuo";
    public static final String MAIN_KEY_SELF_PRAISE_ANIMATION = "self_praise_animation";
    public static final String MAIN_KEY_SHARE_TO_WX = "share_to_wx";
    public static final String MAIN_KEY_SWEET_MINI_APP = "sweet_miniapp";
    public static final String MAIN_KEY_TIANSHU_FEATURE = "tianshu_feature";
    public static final String MAIN_KEY_TRIM = "TrimVideo";
    public static final String MAIN_KEY_UGC_EMPTY_PAGE = "ugcEmptyPage";
    public static final String MAIN_KEY_UNPUBLISH_SHUO_SHUO = "UnpublishShuoShuo";
    public static final String MAIN_KEY_UPLOAD = "QzoneUploadSetting";
    public static final String MAIN_KEY_VAS = "K_QQ_VAS";
    public static final String MAIN_KEY_VERTICAL_VIDEO_LAYER = "VerticalVideoLayer";
    public static final String MAIN_KEY_VIDEOEDIT = "VideoEdit";
    public static final String MAIN_KEY_VIDEO_FLOAT = "QZVideo";
    public static final String MAIN_KEY_VIDEO_SVRLIST = "VideoSvrList";
    public static final String MAIN_KEY_WEBSO = "QzUrlCache";
    public static final String MAIN_KEY_WEBVIEW_SETTING = "WebviewSetting";
    public static final String MAIN_KEY_WEISHI_SETTING = "WeishiSetting";
    public static final String MAIN_KEY_WNSSETTINGS = "WNSSettting";
    public static final int MAKE_VIDEO_ALBUM_MAX_PHOTO_NUM = 30;
    public static final int MANAGEMENT_MAX_PHOTO_NUM = 50;
    public static final int MANAGEMENT_MAX_VIDEO_NUM = 3;
    public static final String MAX_PENDING_REPORT_TASK_NUM = "max_pending_report_task_num";
    public static final String MAX_REPORT_TASK_PENDING_DAY = "max_report_task_pengding_day";
    public static final String MEMORY_LEVEL1_RESIZE_RATION = "memory_level1_resize_ration";
    public static final String MEMORY_LEVEL1_TRIM_RATION = "memory_level1_trim_ration";
    public static final String MEMORY_LEVEL2_RESIZE_RATION = "memory_level2_resize_ration";
    public static final String MEMORY_LEVEL2_TRIM_RATION = "memory_level2_trim_ration";
    public static final String MEMORY_LEVEL3_RESIZE_RATION = "memory_level3_resize_ration";
    public static final String MEMORY_LEVEL3_TRIM_RATION = "memory_level3_trim_ration";
    public static final String MINI_APPCONFIG_CACHE_TIME = "mini_appconfig_cache_time";
    public static final String MINI_APP_APPINFOENTITY_DELEATE_INTERVAL_TIME = "mini_app_appinfoentity_interval_time";
    public static final String MINI_APP_ARK_SCENE_WHITE_LIST = "ark_scene_white_list";
    public static final String MINI_APP_CAPSULE_CLOSE_DARK_URL = "closebuttondark";
    public static final String MINI_APP_CAPSULE_CLOSE_URL = "closebutton";
    public static final String MINI_APP_CHOOSE_MEDIA_DEFAULT_COUNT = "MiniAppChooseMediaDefaultCount";
    public static final int MINI_APP_CHOOSE_MEDIA_DEFAULT_COUNT_DEFAULT = 15;
    public static final String MINI_APP_CHOOSE_MEDIA_DEFAULT_DURATION = "MiniAppChooseMediaDefaultDuration";
    public static final int MINI_APP_CHOOSE_MEDIA_DEFAULT_DURATION_DEFAULT = 10;
    public static final String MINI_APP_CHOOSE_MEDIA_MAX_COUNT = "MiniAppChooseMediaMaxCount";
    public static final int MINI_APP_CHOOSE_MEDIA_MAX_COUNT_DEFAULT = 15;
    public static final String MINI_APP_CHOOSE_MEDIA_MAX_DURATION = "MiniAppChooseMediaMaxDuration";
    public static final int MINI_APP_CHOOSE_MEDIA_MAX_DURATION_DEFAULT = 60;
    public static final int MINI_APP_DESKTOP_OPENED_AUTO_HIDE = 2;
    public static final String MINI_APP_DOWNLOAD_HTTP_CONNECT_LIVE_TIME = "mini_app_download_http_connect_live_time";
    public static final String MINI_APP_DOWNLOAD_HTTP_THREADPOOL_SIZE = "mini_app_download_http_tp_size";
    public static final String MINI_APP_DOWNLOAD_PIPELINE_ENABLE = "mini_app_download_pipeline_enable";
    public static final int MINI_APP_DOWNLOAD_PIPELINE_ENABLE_DEFAULT = 0;
    public static final String MINI_APP_ENABLE_DB_APPINFO_CACHE = "mini_app_enable_db_appinfo_cache";
    public static final String MINI_APP_ENABLE_DB_CACHE = "mini_app_enable_db_cache";
    public static final String MINI_APP_ENABLE_FAKE_APPINFO_CACHE = "mini_app_enable_fake_appinfo";
    public static final String MINI_APP_ENABLE_SEARCH_DYNAMIC_FEATURE = "mini_app_enable_search_dynamic_feature";
    public static final int MINI_APP_ENABLE_SEARCH_DYNAMIC_FEATURE_DEAFULT = 0;
    public static final String MINI_APP_EXTRA_PRELOAD = "mini_app_preload_extra";
    public static final int MINI_APP_EXTRA_PRELOAD_DEFAULT = 1;
    public static final String MINI_APP_FLUTTER_PRELAUNCH_CHECKIN_ENABLE = "mini_flutter_prelaunch_checkin_enable";
    public static final int MINI_APP_FLUTTER_PRELAUNCH_CHECKIN_ENABLE_DEFAULT = 1;
    public static final String MINI_APP_GET_PSKEY_DOMAIN = "qzone.qq.com";
    public static final String MINI_APP_GOOGLE_PLAY_AD_SWITCH = "mini_app_google_play_ad_switch";
    public static final String MINI_APP_HTTPS_IPDIRECT_ENABLE = "mini_app_https_ipdirect_enable";
    public static final String MINI_APP_INNER_BASELIB_RETRY_COUNT = "mini_app_inner_baselib_retry_count";
    public static final String MINI_APP_INTENT_INVALID_RESTART = "mini_app_intent_valid_restart";
    public static final String MINI_APP_KIINGCARD_DARK_LOTTIE = "kingcardGuideDarkLottie";
    public static final String MINI_APP_KIINGCARD_GUIDE_ICON = "kingcardGuideIcon";
    public static final String MINI_APP_KIINGCARD_GUIDE_TEXT = "kingcardGuideText";
    public static final String MINI_APP_KIINGCARD_LOTTIE = "kingcardGuideLottie";
    public static final String MINI_APP_MEDIA_USE_SUPER_PLAYER = "mediaUseSuperPlayer";
    public static final int MINI_APP_MEDIA_USE_SUPER_PLAYER_DEFAULT = 1;
    public static final String MINI_APP_MEMORY_ALERT_MODE = "mini_process_mem_alert_mode";
    public static final String MINI_APP_MEMORY_DETECT_ALERM = "mini_process_mem_detect_alerm";
    public static final String MINI_APP_MEMORY_DETECT_ENABLE = "mini_process_mem_detect_enable";
    public static final String MINI_APP_NAVIGATE_BACK_BY_APPINFO = "mini_app_navigate_back_by_appinfo";
    public static final String MINI_APP_OPEN_STORE_USE_APPID = "mini_app_open_store_use_appid";
    public static final String MINI_APP_OTHERENTITY_DELEATE_INTERVAL_TIME = "mini_app_otherentity_interval_time";
    public static final String MINI_APP_PRECACHE_PERIOD_MILLIS = "mini_app_precache_period_millis";
    public static final long MINI_APP_PRECACHE_PERIOD_MILLIS_DEFAULT = 43200000;
    public static final String MINI_APP_PRECACHE_RESOURCE_MAX_COUNT = "mini_app_precache_resource_maxsize";
    public static final int MINI_APP_PRECACHE_RESOURCE_MAX_COUNT_DEFAULT = 3;
    public static final String MINI_APP_PRECACHE_SIZE_LIMIT = "mini_app_precache_size_limit";
    public static final int MINI_APP_PRECACHE_SIZE_LIMIT_DEFAULT = 262144;
    public static final String MINI_APP_PRELOAD_INTERVAL_TIME = "mini_app_preload_interval_time";
    public static final String MINI_APP_PRELOAD_SWITCHER = "mini_app_preload_switcher";
    public static final String MINI_APP_PROCESS_KILL_MODE = "mini_app_process_kill_mode";
    public static final String MINI_APP_PROCESS_MAX_COUNT = "mini_app_process_max";
    public static final String MINI_APP_PROCESS_PRELOAD_COUNT = "mini_app_process_preload_count";
    public static final String MINI_APP_REPORT_COUNT_THRESHOLD = "mini_app_report_count_threshold";
    public static final String MINI_APP_REPORT_EVENT_CONFIG = "mini_app_report_event_config";
    public static final String MINI_APP_REPORT_FIRST_FRAME_FLUSH = "mini_app_report_first_frame_flush";
    public static final String MINI_APP_REPORT_MAX_TIME_COST = "mini_app_report_max_time_cost";
    public static final String MINI_APP_REPORT_TIME_THRESHOLD = "mini_app_report_time_threshold";
    public static final String MINI_APP_REPORT_WHITE_SCREEN_TIME_CHECK = "mini_app_report_white_screen_check";
    public static final String MINI_APP_SCHEME_APPID_WHITE_LIST = "mini_app_scheme_appid_white_list";
    public static final String MINI_APP_SCHEME_OUTSITE_BLACK_LIST = "mini_app_outsite_black_list";
    public static final int MINI_APP_SHOW_RED_DOT = 1;
    public static final String MINI_APP_SUBPKG_PATH_INTERCEPT = "mini_app_subpkg_path_intercept";
    public static final String MINI_APP_SYSTEM_PERMISSION_CONFIG = "{\"chooseLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"openLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"getLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"chooseVideo\":\"android.permission.CAMERA\",\"chooseImage\":\"android.permission.CAMERA\",\"saveImageToPhotosAlbum\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"saveVideoToPhotosAlbum\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"startRecord\":\"android.permission.RECORD_AUDIO\",\"operateRecorder\":\"android.permission.RECORD_AUDIO\",\"joinVoIPChat\":\"android.permission.RECORD_AUDIO\",\"operateCamera\":\"android.permission.CAMERA\",\"updateCamera\":\"android.permission.CAMERA\",\"insertCamera\":\"android.permission.CAMERA\"}";
    public static final String MINI_APP_UPGRADE_URL = "mini_app_upgrade_url";
    public static final String MINI_APP_USE_DOWNLOAD_OPTIMIZE = "mini_app_use_download_optimize";
    public static final String MINI_GAME_CAPSULE_SHOW_RESTART_BTN = "mini_game_capsule_show_restart_btn";
    public static final String MINI_GAME_DROP_GUIDE_EXPOSURE_TIMES_THRESHOLD = "dropGuideTimesLimit";
    public static final String MINI_GAME_DROP_GUIDE_IMAGE_URL = "qqMiniappDropGuideImageUrl";
    public static final String MINI_GAME_DROP_GUIDE_SCENE_AND_MODE_BLACK_LIST = "qqMiniappDropGuideSceneAndModeBlackList";
    public static final String MINI_GAME_DROP_GUIDE_SCENE_AND_VIA_BLACK_LIST = "qqMiniappDropGuideSceneAndViaBlackList";
    public static final String MINI_GAME_DROP_GUIDE_SCENE_BLACK_LIST = "qqMiniappDropGuideSceneBlackList";
    public static final String MINI_GAME_FORCE_DOWNLOAD_IN_MAINPROCESS = "mini_game_force_download_in_mainprocess";
    public static final int MINI_GAME_FORCE_DOWNLOAD_IN_MAINPROCESS_DEFAULT = 0;
    public static final String MINI_GAME_JANK_TRACE_SAMPLING_RATE = "mini_game_jank_trace_sampling_rate";
    public static final int MINI_GAME_JANK_TRACE_SAMPLING_RATE_DEFAULT = 100;
    public static final String MINI_GAME_PAY_BY_H5 = "mini_game_pay_by_h5";
    public static final String MINI_GAME_PROCESS_MAX_COUNT = "mini_game_process_max";
    public static final String MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_BUTTON_URL = "publicAccountGameStoreButtonUrl";
    public static final String MINI_GAME_RETAIN_ALERT_VIEW_SCENE = "qqMiniappRetainAlterViewScene";
    public static final String MINI_GAME_RETAIN_BACKGROUND_URL = "qqMiniappRetainBackgroundUrl";
    public static final String MINI_GAME_RETAIN_CHANGE_ALL = "qqMiniappRetainChangeAll";
    public static final String MINI_GAME_RETAIN_CONFIRM_ANIMATION_IMAGE_URL = "mini_game_retain_confirm_animation_image_url";
    public static final String MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD = "retainConfirmTimesLimit";
    public static final String MINI_GAME_RETAIN_CONFIRM_INTERVAL = "retainConfirmInterval";
    public static final String MINI_GAME_RETAIN_LEFT_BTN_BACKGROUND_URL = "qqMiniappRetainLeftBtnBackgroundUrl";
    public static final String MINI_GAME_RETAIN_RIGHT_BTN_BACKGROUND_URL = "qqMiniappRetainRightBtnBackgroundUrl";
    public static final String MINI_SDK_PRELAUNCH_ALL_DELAY_TIME = "mini_sdk_prelaunch_all_delay_time";
    public static final int MINI_SDK_PRELAUNCH_ALL_DELAY_TIME_DEFAULT = 60000;
    public static final String MINI_SDK_PRELAUNCH_ALL_ENABLE = "mini_sdk_prelaunch_all_enable";
    public static final int MINI_SDK_PRELAUNCH_ALL_ENABLE_DEFAULT = 1;
    public static final String MINI_SDK_PRELAUNCH_ENABLE = "mini_sdk_prelaunch_enable";
    public static final int MINI_SDK_PRELAUNCH_ENABLE_DEFAULT = 1;
    public static final int ML_EXPOSED_MEDIA_UPPER_BOUND_DEFAULT = 50;
    public static final String NEED_TO_CHANGE_FOR_RAPID_COMMENT = "needToChangeForRapidComment";
    public static final long NEW_EVENT_BUBLE_STAY_TIME_DEFAULT = 5000;
    public static final int NOT_LOAD = 0;
    public static final int OFFLINE_DECODE_PHOTO_QUALITY_DEFAULT = 90;
    public static final int PRELOAD_HTML_PAGE_URL_MAX_COUNT_DEFAULT = 100;
    public static final String PRELOAD_SMALL_GAME_ALLOW_HOURS_DEFAULT = "1,2,3,4,5,6,7,8,9,10,14,15,16,17,18";
    public static final int PRELOAD_SMALL_GAME_HTML_ENABLE_DEFAULT = 0;
    public static final int PRELOAD_SMALL_GAME_INTERVAL_SECONDS_DEFAULT = 86400;
    private static final String PRINTCONFIG_TAG = "CMD_PRINT_WNS_CONFIG";
    public static final String PUBLIC_ACCOUNT_DISCOVER_ENTRY_ENABLE = "publicAcuntDiscoverEntryEnable";
    public static final String PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA = "publicAcuntDiscoverPageSchema";
    private static final String QQCIRCLE_ENABLE_SWITCH_WNS_TO_UNITED_CONFIG = "qqcircle_enable_switch_wns_to_united_config";
    public static final String QUEUE_PAUSEABLE = "queue_pausable";
    public static final String QUEUE_PAUSE_TIMEOUT = "queue_timeout";
    public static final String QZONE_ALBUM_COMMENTS_URL = "QZoneAlbumComments";
    public static final String QZONE_ALBUM_VISITORS_URL = "QZoneAlbumVisitors";
    public static final String QZONE_CALL_APP_URL_LIST_DEFAULT = "['https?://intent\\.music\\.163\\.com.+orpheus.*','^https?://([^/]+\\.)?thefatherofsalmon\\.com[/:].+','^https?://127\\.0\\.0\\.1[/:].+','^https?://0:0:0:0:0:0:0:1[/:].+','^https?://::1[/:].+']";
    public static final String QZONE_CONFIG_DISABLE_SHOW_INTIMATE_ALBUM_TAB = "disable_show_intimate_album_tab";
    public static final String QZONE_CONFIG_DISABLE_UNPRAISED_ICON_CUSTOM = "disable_unpraised_icon_custom";
    public static final String QZONE_CONFIG_ENABLE_ATTACH_QFS_AV1_INFO = "enable_attach_qcircle_av1_info";
    public static final String QZONE_CONFIG_ENABLE_HACK_ON_RESUME_EXP = "enable_hack_on_resume_exp";
    public static final String QZONE_CONFIG_MAIN_KEY_TROOP_GRAY_TIPS = "aio_qzone_troop_gray_tips";
    public static final String QZONE_CONFIG_SECONDARY_KEY_DISABLE_CHANGE_STATUS_COLOR_OUT_QZONE = "disableChangeStatusColorOutQZone";
    public static final String QZONE_CONFIG_SECONDARY_KEY_IS_PHOTO_SAVE = "PhotoBrowserEnableSave";
    public static final String QZONE_CONFIG_SECONDARY_KEY_IS_QRCODE_SCAN = "PhotoBrowserEnableScanQRCode";
    public static final String QZONE_CONFIG_SECONDARY_KEY_LABEL_TEXT = "photocategorylabeltext";
    public static final String QZONE_CONFIG_SECONDARY_KEY_LOCATION_TEXT = "photocategorylocationtext";
    public static final String QZONE_CONFIG_SECONDARY_KEY_NEED_GETPICMARKER = "uploadneedgetpicmarker";
    public static final String QZONE_CONFIG_SECONDARY_KEY_NEED_SHOWLBSLIST = "needshowlibslist";
    public static final String QZONE_CONFIG_SECONDARY_KEY_OPEN_8970_LIBRA_IP_CONFIG = "openLibra8970IpConfig";
    public static final String QZONE_CONFIG_SECONDARY_KEY_OPEN_8970_LONG_PIC_NEW_LAYER = "openLongPic8970NewLayer";
    public static final String QZONE_CONFIG_SECONDARY_KEY_PORTRAIT_TEXT = "photocategoryportraittext";
    public static final String QZONE_CONFIG_SECONDARY_KEY_SHOW_MAKEVIDEO_IN_ACTIONSHEET = "isShowMakeVideoInActionSheet";
    public static final String QZONE_CONFIG_SECONDARY_KEY_SHOW_MAKEVIDEO_IN_TOOLBAR = "isShowMakeVideoInToolBar";
    public static final String QZONE_CONFIG_SECONDARY_KEY_TROOP_GRAY_TIPS_COOL_DOWN = "troop_gray_tips_cool_down";
    public static final String QZONE_CONFIG_SECONDARY_KEY_TROOP_GRAY_TIPS_MIN_PHOTO_COUNT = "troop_gray_tips_min_photo_count";
    public static final String QZONE_CONFIG_SECONDARY_KEY_USE_NEW_STYLE_PUBLIC_ACCOUNT_PAGE = "useNewStylePublicAccountPage";
    public static final int QZONE_Dynamic_Cover_ANIMATE_TIME_VALUE = 25;
    public static final String QZONE_Dynamic_Cover_URL_VALUE = "https://h5.qzone.qq.com/show/quickReplaceCover?_wv=131072&_fv=0";
    public static final String QZONE_EVENT_TAG_DEFAULT_PIC_URL = "QZoneEventTag_EventTagDefaultPicUrl";
    public static final String QZONE_EVENT_TAG_MAIN_KEY = "QZoneEventTag";
    public static final String QZONE_FACADE_DYNAMIC_DEFAULT_BLACK_LIST = "GT-N7108";
    public static final String QZONE_HISTORY_EVENT_TAG_CACHE_NUM = "QZoneEventTag_HistoryEventTagCacheNum";
    public static final String QZONE_IMAGE_MANAGER_GIF_PRE_DOWNLOAD = "QzoneImageManager_GifPreDownload";
    public static final String QZONE_IMAGE_MANAGER_HABO_REPORT_SAMPLE_RANGE = "QzoneImageManager_HaboReportSampleRange";
    public static final String QZONE_IMAGE_MANAGER_MAIN_KEY = "QzoneImageManager";
    public static final String QZONE_IMAGE_MANAGER_OPEN_GET_IMAGE_SUCCESS_RECORDER = "QzoneImageManager_OpenGetImageSuccessRecorder";
    public static final String QZONE_INTIMATE_SPACE_ENABLE_APPEND_FEED_IN_TAB = "qzone_intimate_space_enable_append_feed_in_tab";
    public static final String QZONE_INTIMATE_SPACE_FRAME_ENTRANCE_OPEN = "qzone_intimate_space_frame_entrance_open";
    public static final String QZONE_MOOD_EVENT_TAG_H5_URL = "qzoneMoodEventTagH5Url";
    public static final String QZONE_MOOD_EVENT_TAG_JUMP_PAGE = "QzoneSetting";
    public static final String QZONE_MOOD_EVENT_TAG_USE_H5 = "QzoneMoodEventTagUseH5";
    public static final String QZONE_RECOMMEND_EVENT_TAG_DESC_TRUNCATE_END_NUM = "QZoneEventTag_RecommendEventTagDescTruncateEndNum";
    public static final int QZONE_REG_STRING_MATCHER_LRU_MAP_SIZE_DEFAULT = 50;
    public static final String QZONE_SHOW_BREEZE_DEFAULT_BLACK_LIST = "";
    public static final String QZONE_SPECIAL_FOLLOW_COTAINER_MAIN_KEY = "QZoneSpecialFollowContainer";
    public static final String QZONE_UGC_PERMISSION_USERS_LIST_URL = "QZoneUgcPermissionUsersUrl";
    public static final String QZONE_VIDEO_AUTO_PLAY_KEY = "VideoAutoPlay";
    public static final String QZONE_VIDEO_LAYER_PASTER_VIDEO_ADV_REPLAY_TIME_STAMP_KEY = "PremovieAdvReplayTimeInterval";
    public static final String QZONE_VIDEO_MAIN_KEY = "QZVideo";
    public static final String QZPB_IP_VIDEO_HOST = "video_host_qzpb";
    public static final String QZVV_IP_VIDEO_HOST = "video_host_qzvv";
    public static final String RECENT_PHOTO_BLOCK_PATHS_DEFAULT = "MagazineUnlock";
    public static final int RECENT_PHOTO_LIMIT_MIN_SIZE_DEFAULT = 20480;
    public static final int RECENT_PHOTO_LIMIT_MIN_WIDTH_DEFAULT = 100;
    public static final int RECENT_PHOTO_MAX_NUM_DEFAULT = 200;
    public static final int REPORT_ACTION_FLOW_SIZE_DEFAULT = 800;
    public static final String SCHEME_FOR_SWEET_MAIN_PAGE_JUMP = "mqzone://arouse/lovermainpage";
    private static final String SECONDAER_KEY_AE_PICTEMPLATEFILTERBLACKLIST = "secondary_key_ae_pictemplatefilterblacklist";
    public static final String SECONDART_KEY_ALBUM_RECOM_UPLOAD_BAR_COUNT_LIMIT_LEVEL = "AlbumRecomUploadLimitedLevel";
    public static final String SECONDART_KEY_PHOTOLIST_NEED_SHOW_ALL_SELECT = "PhotoListNeedShowAllSelect";
    public static final String SECONDARYUGC_EMPTY_DEFAULT_PAGE = "ugcEmptyDefaultPage";
    public static final String SECONDARYUGC_EMPTY_NO_NETWORK_PAGE = "ugcEmptyNoNetWorkPage";
    public static final String SECONDARYUGC_SHUOSHUO_EMPTY_VIEW = "shuoshuoEmptyView";
    public static final String SECONDARY_ACC_REPORT_COUNT = "AccReportCount";
    public static final String SECONDARY_ACC_REPORT_INTERVAL = "AccReportInterval";
    public static final String SECONDARY_ACC_REPORT_SAMPLES = "AccReportSamples";
    public static final String SECONDARY_ACTIVEMOODBTN_ENTER_PHOTOUPLOAD = "activeMoodBtnEnterPhotoUpload";
    public static final String SECONDARY_ACTIVE_ONLINE_REPORT_INTERVAL = "OnlineReportIntervalActive";
    public static final String SECONDARY_ACTIVITY_SWITCH_ACC_REPORT_SAMPLES = "ActivitySwitchAccReportSamples";
    public static final String SECONDARY_AIO_CM_PAY_JUMP_URL = "aioCMShowPreviewPayUrl";
    public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_BLOG_TITLE_MAX_LENGTH = "qzoneAioFriendFeedBlogTitleMaxLength";
    public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_LOGO_WATERMARK_IMG_URL = "qzoneAioFriendFeedLogoWaterImgUrl";
    public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_NICKNAME_MAX_LENGTH = "qzoneAioFriendFeedNicknameMaxLength";
    public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_PIC_BLOG_TILTE_MAX_LENGTH = "qzoneAioFriendFeedPicBlogTitleMaxLength";
    public static final String SECONDARY_AIO_QZONE_LOVE_GRAY_TIPS_KEY = "aio_qzone_love_gray_tips";
    public static final String SECONDARY_AIO_SHOW_FEED_LIST = "AioShowFeedList";
    public static final String SECONDARY_ALBUM_FORBIDEN_PHOTO_CHECK_MAX_DAYS = "secondary_album_forbiden_photo_check_max_days";
    public static final String SECONDARY_ALBUM_HISTORY_GROUP_ACTIVITY_SUB_TITLE = "historyLocalPhotoActivitySubTitle";
    public static final String SECONDARY_ALBUM_HISTORY_GROUP_ACTIVITY_TITLE = "historyLocalPhotoActivityTitle";
    public static final String SECONDARY_ALBUM_LIKE_LIST = "AlbumLikeList";
    public static final String SECONDARY_ALBUM_LIST_MAX_COUNT = "albumListMaxCount";
    public static final String SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_AUTHORIZE_NOT_OPEN_DESC = "album_local_photo_recommend_authorize_not_open_desc";
    public static final String SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_AUTHORIZE_NOT_OPEN_TITLE = "album_local_photo_recommend_authorize_not_open_title";
    public static final String SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_AUTHORIZE_OPENED_DESC = "album_local_photo_recommend_authorize_opened_desc";
    public static final String SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_AUTHORIZE_OPENED_TITLE = "album_local_photo_recommend_authorize_opened_title";
    public static final String SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_ENABLE_SDCARD_SPACE_ADJUDE = "album_local_photo_recommend_enable_sdcard_space_adjude";
    public static final String SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_FIRST_SCAN_PHOTO_SIZE = "album_local_photo_recommend_first_scan_photo_size";
    public static final String SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_GET_POI_BATCH_SIZE = "album_local_photo_recommend_get_poi_batch_size";
    public static final String SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_INCREASE_SCAN_PHOTO_SIZE = "album_local_photo_recommend_increase_scan_photo_size";
    public static final String SECONDARY_ALBUM_PHOTO_CHECK_MAX_DAYS = "secondary_album_photo_check_max_days";
    public static final String SECONDARY_ALBUM_PHOTO_CHECK_TIME_DISTANCE = "secondary_album_photo_group_check_time_distance";
    public static final String SECONDARY_ALBUM_PHOTO_ENBALE = "secondary_album_photo_enbale";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_BANNER = "secondary_album_photo_group_banner";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_BANNER_PLAY_PHOTO = "secondary_album_photo_group_banner_play_photo";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_BANNER_VIDEO = "secondary_album_photo_group_banner_video";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_INTERVAL_HOUR = "secondary_album_photo_group_interval_hour";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_MAX_UPLOAD_PHOTO_NUM_HIGH = "secondary_album_photo_group_max_photo_num_high";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_MAX_UPLOAD_PHOTO_NUM_LOW = "secondary_album_photo_group_max_photo_num_low";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_MAX_UPLOAD_PHOTO_NUM_MIDDLE = "secondary_album_photo_group_max_photo_num_middle";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_MIN_PHOTOS_TO_VIDEO = "secondary_album_photo_group_min_photoS_to_video";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_TODAY_IN_LAST_YEAR_SHOW_TIME = "secondary_album_photo_group_today_in_last_year_show_time";
    public static final String SECONDARY_ALBUM_PHOTO_GROUP_VALID_DISTANCE = "secondary_album_photo_group_valid_distance";
    public static final String SECONDARY_ALBUM_PHOTO_HIGH_DEVICE_FIRST_GET_SMART_INFO_NUM = "albumRecommendHighDeviceFirstGetSmartInfoNum";
    public static final String SECONDARY_ALBUM_PHOTO_HIGH_DEVICE_MAX_SCAN_PHOTO_NUM = "albumRecommendHighDeviceMaxScanPhotoNum";
    public static final String SECONDARY_ALBUM_PHOTO_IN_FEED_PAGE_ENBALE = "secondary_album_photo_in_feed_page_enable";
    public static final String SECONDARY_ALBUM_PHOTO_LOW_DEVICE_FIRST_GET_SMART_INFO_NUM = "albumRecommendLowDeviceFirstGetSmartInfoNum";
    public static final String SECONDARY_ALBUM_PHOTO_LOW_DEVICE_MAX_SCAN_PHOTO_NUM = "albumRecommendLowDeviceMaxScanPhotoNum";
    public static final String SECONDARY_ALBUM_PHOTO_MIDDLE_DEVICE_FIRST_GET_SMART_INFO_NUM = "albumRecommendMiddleDeviceFirstGetSmartInfoNum";
    public static final String SECONDARY_ALBUM_PHOTO_MIDDLE_DEVICE_MAX_SCAN_PHOTO_NUM = "albumRecommendMiddleDeviceMaxScanPhotoNum";
    public static final String SECONDARY_ALBUM_PHOTO_MIN_PHOTO_CNT_PER_GROUP = "secondary_album_photo_min_photo_cnt_per_group";
    public static final String SECONDARY_ALBUM_PHOTO_MIN_SCAN_PHOTO_NUM = "albumRecommendMinScanPhotoNum";
    public static final String SECONDARY_ALBUM_PHOTO_REQ_ALL_GROUP_VERSION = "PhotoRecommendReqAllGroupVersion";
    public static final String SECONDARY_ALBUM_PHOTO_SCAN_FIRST_INTEVAL = "albumRecommendScanFirstInterval";
    public static final String SECONDARY_ALBUM_PHOTO_SCAN_TIME_INTERVAL = "albumRecommendScanTimeInterval";
    public static final String SECONDARY_ALBUM_PHOTO_SHOW_END_HOUR = "secondary_album_photo_show_end_hour";
    public static final String SECONDARY_ALBUM_PHOTO_SHOW_START_HOUR = "secondary_album_photo_show_start_hour";
    public static final String SECONDARY_ALBUM_RECOMM_EXPOSE_LIMITS = "secondary_album_recomm_rank_nums";
    public static final String SECONDARY_ALBUM_RECOMM_MONTH_LIMITS = "secondary_album_recomm_month_limits";
    public static final String SECONDARY_ALBUM_RECOMM_SWITCH = "secondary_album_recomm_switch";
    public static final String SECONDARY_ALBUM_REC_FEED_EMPTY_PIC_URL = "AlbumRecFeedEmptyPicUrl";
    public static final String SECONDARY_ALBUM_REC_FEED_EXPOSE_PERIOD = "AlbumRecFeedExposePeriod";
    public static final String SECONDARY_ALBUM_SHARE_DYNAMIC_MAX_PHOTO_NUM = "AlbumShareDynamicMaxPhotoNum";
    public static final String SECONDARY_ALBUM_SHARE_DYNAMIC_URL = "AlbumShareDynamicUrl";
    public static final String SECONDARY_ALBUM_SHOW_MODE = "themePhotoDefaultMode";
    public static final String SECONDARY_ALBUM_WATER_PIC = "AlbumWaterPic";
    public static final String SECONDARY_ATUSER_INTERACTIVE_MAX = "FriendMaxSelectCountComment";
    public static final String SECONDARY_ATUSER_PUBLISH_UGC_MAX = "FriendMaxSelectCount";
    public static final String SECONDARY_AUDIO_MAX_BITRATE = "AudioMaxBitrate";
    public static final String SECONDARY_AUDIO_MAX_SAMPLE = "AudioMaxSample";
    public static final String SECONDARY_AUDIO_MIX_MUSIC_VOLUME = "audiomixmusicvolume";
    public static final float SECONDARY_AUDIO_MIX_MUSIC_VOLUME_DEFVALUE = 1.0f;
    public static final String SECONDARY_AUDIO_MIX_ORIGINAL_VOLUME = "audiomixoriginalaudiovolume";
    public static final float SECONDARY_AUDIO_MIX_ORIGINAL_VOLUME_DEFVALUE = 0.7f;
    public static final String SECONDARY_AVATAR_PREVIEW = "AvatarPreview";
    public static final String SECONDARY_AVATAR_SETTING = "AvatarSetting";
    public static final String SECONDARY_BANNER_PHOTO_GIF_RATE_DIF = "BannerPhotoGifRateDif";
    public static final String SECONDARY_BANNER_PHTO_GIF_VALID_CNT = "banner_phto_gif_valid_cnt";
    public static final String SECONDARY_BARRAGE_EFFECT_PREVIEW = "CommentBubblePreview";
    public static final String SECONDARY_BARRAGE_PREVIEW_URL = "BarragePreviewUrl";
    public static final String SECONDARY_BG_FM_BROCAST_MANAGER_URL = "BgFMBrocastManagerUrl";
    public static final String SECONDARY_BG_MUSIC_FOR_QZVIP_MANAGER_URL = "BgMusicForQZVIPManagerUrl";
    public static final String SECONDARY_BG_MUSIC_MANAGER_URL = "BgMusicManagerUrl";
    public static final String SECONDARY_BLOG_EDIT = "BlogEdit";
    public static final String SECONDARY_BOARD_URL = "presentBoard";
    public static final String SECONDARY_BUBBLE_UNREAD_SWITCH = "SK_QQ_VAS_ShowSwitchPersonalUnread";
    public static final String SECONDARY_BUY_FEED_URL = "BuyFeedUrl";
    public static final String SECONDARY_BUY_FONT_URL = "FloatingViewForFontPay";
    public static final String SECONDARY_C2C_AIO_ENABLE_SYNC_IMAGE_TO_QZONE = "C2CAioEnableSyncImageToQzone";
    public static final String SECONDARY_C2C_AIO_SYNC_IMAGE_ALBUM_CACHE_EXPIRE_TIME = "C2CAioAlbumCacheExpireTime";
    public static final String SECONDARY_C2C_PLUS_GIFT_JUMP_URL = "C2CPlusGiftJumpUrl";
    public static final String SECONDARY_CAN_QUICK_OPEN_CAMERA = "CanQuickOpenCamera";
    public static final String SECONDARY_CAN_QUICK_OPEN_CAMERA_ANIM = "CanQuickOpenCameraAnim";
    public static final String SECONDARY_CARD_PREVIEW = "CardPreview";
    public static final String SECONDARY_CARD_STORE = "CardStore";
    public static final String SECONDARY_CATEGORY_MY_TRACKS_DISPLAY = "CategoryMyTracksDisplay";
    public static final String SECONDARY_CATEGORY_MY_TRACKS_URL = "CategoryMyTracksUrl";
    public static final String SECONDARY_CHANGE_COVER_URL = "ChangeCover";
    public static final String SECONDARY_CHECK_LIVE_M3U8_INTERVAL = "CheckLiveM3U8Interval";
    public static final String SECONDARY_CHECK_LIVE_M3U8_REPLAY_DIFF = "CheckLiveM3U8RePlayDiff";
    public static final String SECONDARY_CHECK_LIVE_M3U8_TIMES_TO_SHOW_LEAVE = "CheckLiveM3U8TimesToShowLeave";
    public static final String SECONDARY_CIRCLE_PLAY_SECOND_FAKEFEED_VALIDTIME = "CirclePlaySecondFakeFeedValidTime";
    public static final String SECONDARY_CLICKREPORT_COUNT = "TraceReportCount";
    public static final String SECONDARY_CLICKREPORT_IMEDIATELY = "LpReportImediagely";
    public static final String SECONDARY_CLICKREPORT_INTERVAL = "TraceReportInterval";
    public static final String SECONDARY_CLICKREPORT_SAMPLE = "TraceReportSamples";
    public static final String SECONDARY_CLICKREPORT_URL = "TraceReportURL";
    public static final String SECONDARY_CLIENT_COMPRESS = "ClientCompress";
    public static final String SECONDARY_CLOUD_PHOTO_DYNAMIC_ALBUM_URL = "cloudPhotoDynamicAlbumUrl";
    public static final String SECONDARY_COMMENT_MAX_INPUT_CNT = "CommentMaxInputCnt";
    public static final String SECONDARY_COMMENT_REPLY_REPORT = "CommentReplyReport";
    public static final String SECONDARY_COMMENT_REPLY_REPORT_KEY = "CommentReplyReportKey";
    public static final String SECONDARY_COMMENT_SETTING = "SeeMyCommentPermissionSetting";
    public static final String SECONDARY_COMPRESS_QUALITY_LIMIT = "CompressQualityLimit";
    public static final String SECONDARY_COMPRESS_SIZE_LIMIT = "CompressSizeLimit";
    public static final String SECONDARY_COMPRESS_TO_WEBP = "CompressToWebp";
    public static final String SECONDARY_CONTEXTBOX_LOAD_NUM = "contentbox_load_num";
    public static final String SECONDARY_CONVERSATION_REMAIN_REPORT_CONTROL = "conversation_remain_report_control";
    public static final String SECONDARY_COVER_LIST = "CoverList";
    public static final String SECONDARY_COVER_PREVIEW = "CoverPreview";
    public static final String SECONDARY_COVER_REDPCOKET_WARN_POP_BG = "secondCoverRedPocketPopBg";
    public static final String SECONDARY_COVER_STORE = "CoverStore";
    public static final String SECONDARY_CREATE_GIF_HIGH_DEVICE_SIZE = "createGifHighDeviceSize";
    public static final String SECONDARY_CREATE_GIF_LOW_DEVICE_SIZE = "createGifLowDeviceSize";
    public static final String SECONDARY_CREATE_GIF_MAX_NUM = "AutoCreateGifMaxNum";
    public static final String SECONDARY_CREATE_GIF_MIDDLE_DEVICE_SIZE = "createGifMiddleDeviceSize";
    public static final String SECONDARY_CREATE_GIF_PHOTO_CUT_FRAMES_NUMBER = "CreateGifPhotoCutFramesNumber";
    public static final String SECONDARY_CREATE_GIF_PHOTO_FRAMES_LIMIT = "CreateGifPhotoFrameTimesLimit";
    public static final String SECONDARY_CREATE_GIF_PHOTO_FRAME_TIME1 = "localPhotoCreateGifPhotoFrameTime1";
    public static final String SECONDARY_CREATE_GIF_PHOTO_FRAME_TIME2 = "localPhotoCreateGifPhotoFrameTime2";
    public static final String SECONDARY_CREATE_GIF_PHOTO_GIF_FILE_MAX_SIZE = "CreateGifGifFileMaxSize";
    public static final String SECONDARY_CREATE_GIF_PHOTO_GIF_SIZE = "localPhotoCreateGifPhotoGifSize";
    public static final String SECONDARY_CREATE_GIF_PHOTO_INTERVAL_TIME = "CreateGifPhotoIntervalTime";
    public static final String SECONDARY_CREATE_GIF_PHOTO_MAX_NUM = "localPhotoCreateGifPhotoMaxNum";
    public static final String SECONDARY_CREATE_GIF_PHOTO_MIN_NUM = "localPhotoCreateGifPhotoMinNum";
    public static final String SECONDARY_CREATE_GIF_SIZE_FOR_LONG_EDGE = "CreateGifGifSizeForLongEdge";
    public static final String SECONDARY_CROP_GIF_EDGEBOTTOM = "GifEdgeBottom";
    public static final String SECONDARY_CROP_GIF_EDGELEFT = "GifEdgeLeft";
    public static final String SECONDARY_CROP_GIF_EDGERIGHT = "GifEdgeRight";
    public static final String SECONDARY_CROP_GIF_EDGETOP = "GifEdgeTop";
    public static final String SECONDARY_CUSTOM_FONT_SHOW = "DiyFontShow";
    public static final String SECONDARY_DB_OPTIMIZE_SYNC = "DbOptiSync";
    public static final String SECONDARY_DELAY_INTERVAL = "TopBannerRequestDelayInterval";
    public static final String SECONDARY_DELAY_QUIT_POC = "delayQuitPOC";
    public static final String SECONDARY_DEL_MEDIA_FILE_DIALOG_MIX_VIDEO_PIC_MSG = "DelMediaFileDialogMixVideoPicMsg";
    public static final String SECONDARY_DEL_MEDIA_FILE_DIALOG_ONLY_PIC_MSG = "DelMediaFileDialogOnlyPicMsg";
    public static final String SECONDARY_DEL_MEDIA_FILE_DIALOG_ONLY_VIDEO_MSG = "DelMediaFileDialogOnlyVideoMsg";
    public static final String SECONDARY_DEL_MEDIA_FILE_WHEN_DEL_FEED = "DelMediaFileWhenDelFeed";
    public static final String SECONDARY_DEL_SING_ALBUM_FEED_USE_CMD_DELIC = "DelSingleAlbumFeedUseCMDdelIC";
    public static final String SECONDARY_DETAIL_ACTIVITY_VIP_BANNER = "getDetailActivityVipBannerQboss";
    public static final int SECONDARY_DETAIL_ACTIVITY_VIP_BANNER_DEFUALT_VALUE = 1;
    public static final String SECONDARY_DETAIL_COMMENT_SOFT_ORDER = "DetailCommentSoftOrder";
    public static final String SECONDARY_DETAIL_GAME_DRAG_LABEL = "DetailGameDragLabel";
    public static final String SECONDARY_DETAIL_MAXPICSHOW_NUM = "DetailMaxPicShowNum";
    public static final String SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND = "disable_album_local_photo_recommend";
    public static final String SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND_CLASSIFIER_LIST = "disable_album_local_photo_recommend_classifier_list";
    public static final String SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND_DO_RESEARCH = "disable_album_local_photo_recommend_do_research";
    public static final String SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND_GET_POI = "disable_album_local_photo_recommend_get_poi";
    public static final String SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND_UPLOAD_HISTORY = "disable_album_local_photo_recommend_upload_history";
    public static final String SECONDARY_DISABLE_FORBID_COMMENT = "DisableForbidComment";
    public static final String SECONDARY_DISABLE_SHOW_VIP_INFO = "DisableVipInfoOnFriendFeed";
    public static final String SECONDARY_DOBHE_SPLASH_PLAY_CONTROL_REQUEST_SHOULD_CLOSE = "DubheSplashPlayControlRequestShouldClose";
    public static final String SECONDARY_DOWNLOAD_ACCESS_PORT_LIST = "DownloadAccessPortList";
    public static final String SECONDARY_DOWNLOAD_BACKUP_IP = "DownloadBackupIP";
    public static final String SECONDARY_DOWNLOAD_BACKUP_IPV4 = "DownloadBackupIPV4";
    public static final String SECONDARY_DOWNLOAD_BACKUP_IP_A = "DownloadBackupIP_a";
    public static final String SECONDARY_DOWNLOAD_BACKUP_IP_B = "DownloadBackupIP_b";
    public static final String SECONDARY_DOWNLOAD_BACKUP_IP_VIDEO = "DownloadBackupIPVideo";
    public static final String SECONDARY_DOWNLOAD_DIRECT_IP = "DownloadDirectIP";
    public static final String SECONDARY_DOWNLOAD_DIRECT_IPV4 = "DownloadDirectIPV4";
    public static final String SECONDARY_DOWNLOAD_DIRECT_IP_A = "DownloadDirectIP_a";
    public static final String SECONDARY_DOWNLOAD_DIRECT_IP_B = "DownloadDirectIP_b";
    public static final String SECONDARY_DOWNLOAD_DIRECT_IP_VIDEO = "DownloadDirectIPVideo";
    public static final String SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP = "photo_backupIplist";
    public static final String SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_A = "photo_backupIplist_a";
    public static final String SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_B = "photo_backupIplist_b";
    public static final String SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_VIDEO = "video_backupIplist";
    public static final String SECONDARY_DOWNLOAD_EXTRA_DIRECT_IP_VIDEO = "video_masterIplist";
    public static final String SECONDARY_DOWNLOAD_EXTRA_MASTER_IP = "photo_masterIplist";
    public static final String SECONDARY_DOWNLOAD_EXTRA_MASTER_IP_A = "photo_masterIplist_a";
    public static final String SECONDARY_DOWNLOAD_EXTRA_MASTER_IP_B = "photo_masterIplist_b";
    public static final String SECONDARY_DOWNLOAD_FONT_ANYWAY = "DownloadFontAnyway";
    public static final String SECONDARY_DOWNLOAD_KP_DOMAIN_LIST = "KpDomainList";
    public static final String SECONDARY_DOWNLOAD_LINK_REPORT_CACHE_COUNT = "DownloadLinkReportCacheCount";
    public static final String SECONDARY_DOWNLOAD_LINK_REPORT_DOMAIN_LIST = "DownloadReportDomainList";
    public static final String SECONDARY_DOWNLOAD_LINK_REPORT_ENABLE = "DownloadLinkReportEnable";
    public static final String SECONDARY_DOWNLOAD_LINK_REPORT_SAMPLE = "DownloadLinkReportSample";
    public static final String SECONDARY_DOWNLOAD_OPTIMUMIP_QZPB_IP_VIDEO = "qzpb.qq.com";
    public static final String SECONDARY_DOWNLOAD_OPTIMUMIP_QZVV_IP_VIDEO = "optimumip_qzvv";
    public static final String SECONDARY_DOWNLOAD_PIC_QUEUE_MAX_PARALLEL_TASK_COUNT = "MaxParallelTaskCountForDownloadPicTask";
    public static final String SECONDARY_DOWNLOAD_QZONE_APP_URL = "DownloadQZoneAppUrl";
    public static final String SECONDARY_DOWNLOAD_QZONE_CLIENT = "DownloadQzoneClient";
    public static final String SECONDARY_DOWNLOAD_VIDEO_QUEUE_MAX_PARALLEL_TASK_COUNT = "MaxParallelTaskCountForDownloadVideoTask";
    public static final String SECONDARY_DOWNSONG_QQMUSIC = "DownloadSongInQQMusic";
    public static final String SECONDARY_DOWN_QQMUSIC_CLIENT = "DownloadQQMusicClient";
    public static final String SECONDARY_DRESS_UP_GROUP_URL = "DressUpGroupUrl";
    public static final String SECONDARY_DYNAMIC_ALBUM_PHOTO_SELECT_NUM = "setDynamicAlbumSelectLimit";
    public static final String SECONDARY_DYNAMIC_ALBUM_URL = "dynamicAlbumUrl";
    public static final String SECONDARY_DYNAMIC_CLOSE_DYNAMIC = "closedynamicAlbum";
    public static final String SECONDARY_DYNAMIC_COVER_PREVIEW_DEFAULT = "h5.qzone.qq.com/bgstore/dynamiccover";
    public static final String SECONDARY_DYNAMIC_COVER_PREVIEW_URL = "dynamicCoverPreviewUrl";
    public static final String SECONDARY_DYNAMIC_COVER_PREVIEW_URL_KEYWORD = "dynamicCoverPreviewKeyword";
    public static final String SECONDARY_DYNAMIC_COVER_PREVIEW_URL_KEYWORD_DEFAULT = "tplId=";
    public static final String SECONDARY_DYNAMIC_MAX_PHOTO_NUM = "DynamicMaxPhotoNum";
    public static final String SECONDARY_DYNAMIC_MIN_PHOTO_NUM = "DynamicMinPhotoNum";
    public static final String SECONDARY_EASTER_EGG = "EasterEgg";
    public static final String SECONDARY_EGGPHOTO_LAYERTYPE = "EggPhotoLayerType";
    public static final String SECONDARY_EMOJI_SHOULD_NOT_BREAK = "emojiShouldNotBreak";
    public static final String SECONDARY_ENABLEH265ENCODER = "EnableH265Encoder";
    public static final String SECONDARY_ENABLE_ANIMATED_WEBP = "ENABLE_ANIMATED_WEBP";
    public static final String SECONDARY_ENABLE_COLOR = "EnableColor";
    public static final String SECONDARY_ENABLE_JUMP_DETAIL_TRANS_ANIMATE = "secondaryEnableJumpDetailTransanimate";
    public static final int SECONDARY_ENABLE_JUMP_DETAIL_TRANS_ANIMATE_DEFAULT = 1;
    private static final String SECONDARY_ENABLE_LONG_TIME_OUT_AIGC_INTERFACE = "qqcircle_enable_long_time_out_aigc_interface";
    public static final String SECONDARY_ENABLE_SUPER_RESOLUTION = "enableSuperResolution";
    public static final String SECONDARY_ENABLE_TEMPLATESHUOSHUO = "enable_templateshuoshuo";
    public static final String SECONDARY_ENABLE_VOICE_SHUOSHUO_H5 = "secondary_enable_voice_shuoshuo_h5";
    public static final String SECONDARY_ENTER_LIVE_ROOM_AFTER_SECONDS = "EnterLiveRoomAfterSeconds";
    public static final String SECONDARY_EVENT_SUB_DESCRIPTION = "eventSubDescription";
    public static final String SECONDARY_EXCEPTION_REPORT_USESAMPLE = "exceptionReportUseSample";
    public static final String SECONDARY_EXCLUDE_PERMISION_PAGE = "ExcludePermisionPage";
    public static final String SECONDARY_EXIT_IF_FORGROUD = "ExitIfForgroud";
    public static final String SECONDARY_FACADESTORE_URL = "FacadeStore";
    public static final String SECONDARY_FACADE_JALPHA_ENABLE = "qzoneFacadeJalphaEnable";
    public static final String SECONDARY_FACE_DETECT_EYE_SCALE = "face_detect_eye_scale";
    public static final String SECONDARY_FACE_DETECT_SMILE_OPEN_SCALE = "face_detect_smile_open_scale";
    public static final String SECONDARY_FACE_DETECT_SMILE_SCALE = "face_detect_smile_scale";
    public static final String SECONDARY_FAKE_FEED_INVALID_TIME = "FakeFeedInvalidTime";
    public static final String SECONDARY_FAKE_FEED_RETRY_TIMEOUT = "FakeFeedRetryTime";
    public static final String SECONDARY_FAMOUS_HOME_PAGE = "FamousHomePage";
    public static final String SECONDARY_FAMOUS_HOME_SHARE_FACE_URL = "FamousHomeShareFaceUrl";
    public static final String SECONDARY_FAMOUS_HOME_SHARE_H5 = "FamousHomeShareH5";
    public static final String SECONDARY_FAMOUS_HOME_SHARE_QRCODE = "FamousHomeShareQRCODE";
    public static final String SECONDARY_FAMOUS_HOME_SHARE_SCHEMA = "FamousHomeShareSchema";
    public static final String SECONDARY_FAMOUS_WHITE_LIST = "famousWhiteList";
    public static final String SECONDARY_FANS_GROUP_CONFIG_ENTRANCE = "showFansGroupConfigEntrance";
    public static final String SECONDARY_FANS_GROUP_CONFIG_ENTRANCE_URL = "showFansGroupConfigEntranceUrl";
    public static final String SECONDARY_FEEDS_SHOW_MOOD_ENTRY = "FeedsShowMoodEntry";
    public static final String SECONDARY_FEEDS_SHOW_PHOTO_BUBBLE = "FeedsShowPhotoBubble";
    public static final String SECONDARY_FEED_ACTION_REPORT_SESSION_SIZE = "FeedActionReportSessionSize";
    public static final String SECONDARY_FEED_AVATAR_ICON = "secondFeedAvatarIcon";
    public static final String SECONDARY_FEED_DETAIL_RECOMM_VIDEO_COUNT = "feedDetailRecommVideoCount";
    public static final String SECONDARY_FEED_DROPDOWN_USE_BOTTOM_SHEET = "feed_dropdown_use_bottom_sheet";
    public static final String SECONDARY_FEED_FAKE_REDPOCKET_PIC = "secondFeedFakeRedPocketPic";
    public static final String SECONDARY_FEED_FAKE_REDPOCKET_PIC_HEIGHT = "secondFeedFakeRedPocketPicHeight";
    public static final String SECONDARY_FEED_FAKE_REDPOCKET_PIC_WIDTH = "secondFeedFakeRedPocketPicWidth";
    public static final String SECONDARY_FEED_GIF_ANGLE_DIFF_SENSOR_TYPE = "GifAngleDiffSensorType";
    public static final String SECONDARY_FEED_GIF_ANGLE_LOOP_TYPE = "GifAngleLoopType";
    public static final String SECONDARY_FEED_GIF_ANGLE_TO_FACTOR = "GifAngleToFactor";
    public static final String SECONDARY_FEED_GIF_MAX_FACTOR = "GifMaxFactor";
    public static final String SECONDARY_FEED_GIF_PLAY_SWITCH = "GifPlaySwitch";
    public static final String SECONDARY_FEED_GIF_SENSOR_CONTROL = "GifSensorControl";
    public static final String SECONDARY_FEED_GIF_SENSOR_MODEL = "GifChooseModel";
    public static final String SECONDARY_FEED_GIF_SENSOR_MODEL2_MAX_FACTOR = "GifModel2MaxFactor";
    public static final String SECONDARY_FEED_GIF_SENSOR_MODEL_MAX_COUNT = "GifSensorModelMaxCount";
    public static final String SECONDARY_FEED_GUIDE_UPLOAD_ALBUM_BANNER_ENABLE = "FeedGuideUploadAlbumBanner";
    public static final String SECONDARY_FEED_LOVE_DIAMOND = "FeedLoveDiamond";
    public static final String SECONDARY_FEED_PSVADV_SHOW_POS = "PsvAdvIndex";
    public static final String SECONDARY_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG = "RedPocketShuoShuoDeleteMsg";
    public static final String SECONDARY_FEED_SHARE_DYNAMIC_URL = "FeedShareDynamicUrl";
    public static final String SECONDARY_FEED_SKIN_URL = "FeedSkinUrl";
    public static final String SECONDARY_FEED_UNREAD_FOLLOW_EXPOSURE_COUNT = "follow_guide_exposure_count";
    public static final String SECONDARY_FEED_VISITOR = "FeedVisitor";
    public static final String SECONDARY_FEED_YELLOW_DIAMOND = "FeedYellowDiamond";
    public static final String SECONDARY_FIRST_TIME_ENTER_FRIEND_FEEDS_NEED_GET_MAINPAGE = "firstTimeEnterFriendFeedsNeedGetMainpage";
    public static final String SECONDARY_FLOAT_COMMENT_SOFT_ORDER = "FloatCommentSoftOrder";
    public static final String SECONDARY_FLOAT_MODEL_BLACKLIST = "FloatModelBlacklist";
    public static final String SECONDARY_FLOAT_PERFORMANCE_4CORE_CPU_RAM_SIZE = "FloatStandard4CoreCpuRamSize";
    public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_CORE = "FloatStandardCpuCore";
    public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_FEQUENCY = "FloatStandardCpuFequency";
    public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_RAM_SIZE = "FloatStandardCpuRamSize";
    public static final String SECONDARY_FLOWER_VINE_URL = "FlowerVineURL";
    public static final String SECONDARY_FLUTTER_DISABLE_MODELS = "flutter_disable_models";
    public static final String SECONDARY_FLUTTER_ENABLE = "enableFlutter";
    public static final String SECONDARY_FLUTTER_ENABLE_API_LEVEL = "flutter_enable_api_level";
    public static final String SECONDARY_FLUTTER_MEMORY_HEAP_LIMIT = "flutter_memory_heap_limit";
    public static final String SECONDARY_FOLLOW_FANS_URL = "follow_fans_url";
    public static final String SECONDARY_FONT_LIST_ATTACH_INFO = "DiyFontAttachinfo";
    public static final String SECONDARY_FONT_PREVIEW_FOR_SALE_URL = "FontPreviewUrlForSale";
    public static final String SECONDARY_FONT_PREVIEW_URL = "FontPreviewUrl";
    public static final String SECONDARY_FONT_STORE_URL = "FontStore";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_DELETED_IMAGE_URL = "forbiddenViewFeedDeletedImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_ALBUM_CONCISE_IMAGE_URL = "forbiddenViewFeedEmptyAlbumConciseImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_ALBUM_IMAGE_URL = "forbiddenViewFeedEmptyAlbumImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_IMAGE_URL = "forbiddenViewFeedEmptyImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_MOOD_CONCISE_IMAGE_URL = "forbiddenViewFeedEmptyMoodConciseImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_MOOD_IMAGE_URL = "forbiddenViewFeedEmptyMoodImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_SMALL_IMAGE_URL = "forbiddenViewFeedEmptySmallImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_NO_NETWORK_IMAGE_URL = "forbiddenViewFeedNoNetworkImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_NO_PERMISSION_IMAGE_URL = "forbiddenViewVeedNoPermissionImageUrl";
    public static final String SECONDARY_FORBIDDEN_VIEW_FEED_NO_PERMISSION_SMALL_IMAGE_URL = "forbiddenViewVeedNoPermissionSmallImageUrl";
    public static final String SECONDARY_FORBID_SHOW_DELETE_VISITOR = "ForbidShowDeleteVisitor";
    public static final String SECONDARY_FRIENDFEED_CLICK_TO_TOP_LIMIT = "FriendFeedClickToTopLimit";
    public static final String SECONDARY_FRIENDFEED_CLICK_TO_TOP_SHOW_LIMIT = "FriendFeedClickToTopShowLimit";
    public static final String SECONDARY_FRIEND_ALBUM_RECOMMOND_TITLE = "secondary_friend_album_recommond_title";
    public static final String SECONDARY_FRIEND_FEED_QUICKLY_REPORT_NUM = "friendFeedQuicklyReportNum";
    public static final String SECONDARY_FRIEND_GIF_RECOMMOND_TITLE = "secondary_friend_gif_recommond_title";
    public static final String SECONDARY_FRIEND_SETTING_PRIVACY_SECURITY = "FriendSettingPrivacyAndSecurity";
    public static final String SECONDARY_GALLERY_RECOM_ALBUM_BACK_PRESS_FINISH = "GalleryRecomAlbumBackPressFinish";
    public static final String SECONDARY_GALLERY_RECOM_ALBUM_FLING_CLOSE = "GalleryRecomAlbumFlingClose";
    public static final String SECONDARY_GALLERY_RECOM_COUNT_LIMIT = "GalleryRecomAlbumCountLimit";
    public static final String SECONDARY_GAMEBAR = "GameBar";
    public static final String SECONDARY_GETUSERTIMELOGO_INTERVAL = "GetUserTimeLogoInterval";
    public static final String SECONDARY_GET_AVATARURL = "AvatarURL";
    public static final String SECONDARY_GET_EMOTIONURL = "EmotionURL";
    public static final String SECONDARY_GET_LIVE_SIMPLE_INFO_INTERVAL = "GetLiveSimpleInfoInterval";
    public static final String SECONDARY_GET_PHOTO_BY_TIME_LINE_MAX_COUNT = "GetPhotoByTimeLineMaxCount";
    public static final String SECONDARY_GIFT_BACK = "ReturnGiftList";
    public static final String SECONDARY_GIFT_PANEL = "GiftPanel";
    public static final String SECONDARY_GIF_COVER_CALLBACK_PIECE_SIZE = "gif_cover_callback_piece_size";
    public static final int SECONDARY_GIF_COVER_CALLBACK_PIECE_SIZE_DEFAULT = 1048576;
    public static final String SECONDARY_GIF_COVER_MIN_DISK_SIZE = "gif_cover_min_disk_size";
    public static final int SECONDARY_GIF_COVER_MIN_DISK_SIZE_DEFAULT = 2097152;
    public static final String SECONDARY_GIF_DELAY = "secondary_gif_delay";
    public static final String SECONDARY_GIF_MAX_SPEED = "secondary_gif_max_speed";
    public static final String SECONDARY_GIF_MIN_MULTIPLE_SPEED = "secondary_gif_min_multiple_speed";
    public static final String SECONDARY_GIF_SIZE_LIMIT = "secondary_gif_size_limit";
    public static final String SECONDARY_GIF_UPLOAD_LIMIT_2G = "GifUploadLimt2G";
    public static final String SECONDARY_GIF_UPLOAD_LIMIT_3G = "GifUploadLimt3G";
    public static final String SECONDARY_GIF_UPLOAD_LIMIT_4G = "GifUploadLimt4G";
    public static final String SECONDARY_GIF_UPLOAD_LIMIT_WIFI = "GifUploadLimtWifi";
    public static final String SECONDARY_GPS_CACHE_TIME = "CoordinateCacheTime";
    public static final String SECONDARY_GPS_LOCATE_MAX_TIMEOUT = "GPSLocateMaxTimeout";
    public static final String SECONDARY_GPS_PRELOCATE_MAX_TIMEOUT = "GPSPrelocateMaxTimeout";
    public static final String SECONDARY_GUEST_PANEL_FOOTER_BANNER_HIDE_TIME = "guestFooterBannerHideTime";
    private static final String SECONDARY_GUILD_USE_QCIRCLE_PIC_LOADER = "guild_use_qcircle_loader";
    public static final String SECONDARY_H265ENCODERGRAYCONFIG = "H265EncoderGrayConfig";
    public static final String SECONDARY_H265ENCODERGRAYCONFIG_FORMOOD = "H265EncoderGrayConfigForMood";
    public static final String SECONDARY_H265ENCODERGRAYUSERS = "H265EncoderGrayUsers";
    public static final String SECONDARY_H265VIDEOMAXBITRATE = "H265VideoMaxBitrate";
    public static final String SECONDARY_H265VIDEOMAXFRAME = "H265VideoMaxFrame";
    public static final String SECONDARY_H265VIDEORESOLUTION = "H265VideoMaxResolution";
    public static final String SECONDARY_HAND_BLOG_EDIT = "HandBlogEdit";
    public static final String SECONDARY_HARDWARERESTRICTION_CPU_FRE_SUM = "hardwarerestriction_cpu_fre_sum";
    public static final String SECONDARY_HARDWARERESTRICTION_CPU_SIZE = "hardwarerestriction_cpu_size";
    public static final String SECONDARY_HARDWARERESTRICTION_RAM_SIZE = "hardwarerestriction_ram_size";
    public static final String SECONDARY_HARDWARERESTRICTION_RAM_SIZE_NEW = "hardwarerestriction_ram_size_new";
    public static final String SECONDARY_HBCLICK_VISITORREPORT_INTEVAL = "HBClickVisitorReportInteval";
    public static final String SECONDARY_HERO_VIDEO_AVAILABLE_CHECK = "videoHeroAvailableCheck";
    public static final String SECONDARY_HERO_VIDEO_AVAILABLE_DEFAULT = "99|default|default|default|default|default";
    public static final String SECONDARY_HERO_VIDEO_HVC_HWDEC_MODE = "videoHeroHvcHwDecMode";
    public static final String SECONDARY_HIDE_HIS_RECORD = "HideHisRecord";
    public static final String SECONDARY_HIDE_VISIT_MY = "HideSeeHis";
    public static final String SECONDARY_HIGH_PHONE_FRICITION = "HighPhoneFriction";
    public static final String SECONDARY_HOMEPAGE_FREINDSHIP_THRESHOLD = "homepage_friendship_threshold";
    public static final String SECONDARY_HOMEPAGE_GUEST_DEFAULT_COVER_SHOW_DELAY_MS = "homepageGuestDefaultCoverShowDelayMs";
    public static final String SECONDARY_HOME_PAGE_ALBUM_TITLE = "AlbumBtnTitle";
    public static final String SECONDARY_HOOKREPORT_CONFIG = "HookReportConfig";
    public static final String SECONDARY_HTML_FORCE_CLOSE = "HtmlForceClose";
    public static final String SECONDARY_HTML_STANDARD_CPU_CORE = "HtmlStandardCpuCore";
    public static final String SECONDARY_HTML_STANDARD_CPU_FEQUENCY = "HtmlStandardCpuFequency";
    public static final String SECONDARY_HTML_STANDARD_RAM_SIZE = "HtmlStandardRAMSize";
    public static final String SECONDARY_HTTP2_CONNECT_LIVE_TIME = "http2ConnectLiveTime";
    public static final String SECONDARY_HTTP2_DOMAIN_LIST = "http2DomainList";
    public static final String SECONDARY_HTTP2_THREAD_POOL_SIZE = "http2ThreadPoolSize";
    public static final String SECONDARY_HTTP2_WIFI_THREAD_POOL_SIZE = "http2WifiThreadPoolSize";
    public static final String SECONDARY_HTTP_CONNECT_LIVE_TIME = "httpConnectLiveTime";
    public static final String SECONDARY_HTTP_THREAD_POOL_SIZE = "httpThreadPoolSize";
    public static final String SECONDARY_IGNORE_DOWNLOAD_APK_DOMAINS = "QzoneApkBanDomainList";
    public static final String SECONDARY_IGNORE_DOWNLOAD_APK_DOMAINS_DEFAULT = "douyin.com,huoshan.com,changba.com,toutiao.com,xiguaapp.cn,xiguashipin.cn,365yg.com,snssdk.com,ixigua.com,toutiaocdn.net,music.163.com,weibo.cn,autohome.com.cn";
    public static final String SECONDARY_IGNORE_LOCAL_JUDGE = "IgnoreLocalJudge";
    public static final String SECONDARY_IGNORE_WEBVIEW_SCHEME_URL = "QzoneUrlBanList";
    public static final String SECONDARY_IGNORE_WEBVIEW_SCHEME_URL_DEFAULT = "[{'domains':['^.*\\.douyin\\.com/.*'],'items':['^https?://d\\.douyin\\.com/.+']},{'domains':['^.*\\.huoshan\\.com/.*'],'items':['^https?://d\\.huoshan\\.com/.+']},{'domains':['^.*\\.toutiao\\.com/.*','^.*\\.xiguaapp\\.cn/.*','^.*\\.xiguashipin\\.cn/.*','^.*\\.365yg\\.com/.*','^.*\\.snssdk\\.com/.*','^.*\\.ixigua\\.com/.*','^.*\\.toutiaocdn\\.net/.*'],'items':['^https?://d\\.toutiao\\.com/.+','^https?://d\\.ixigua\\.com/.+']},{'domains':['^http.*'],'items':['^snssdk[0-9]+://.*','^changba://.*','^orpheus://.*']}]";
    public static final String SECONDARY_IMAGE_BIG_URL_SEGMENT = "imageBigUrlSegment";
    public static final String SECONDARY_IMAGE_CURRENT_URL_SEGMENT = "imageCurrentUrlSegment";
    public static final String SECONDARY_IMAGE_JAR_PROGRESS_TRACER = "imageJarProgressTracer";
    public static final String SECONDARY_IMAGE_UPLOAD_BAK_IP = "BackupIP_PICUP";
    public static final String SECONDARY_IMAGE_UPLOAD_HOST_IP = "PhotoURL_UP";
    public static final String SECONDARY_IMAGE_UPLOAD_HOST_IP_V6 = "PhotoURL_UP_V6";
    public static final String SECONDARY_IMAGE_UPLOAD_OPT_IP = "OptimumIP_PICUP";
    public static final String SECONDARY_IMAGE_UPLOAD_OPT_IP_V6 = "OptimumIP_PICUPV6";
    public static final String SECONDARY_INPUT_EMO_ASS_SWITCH = "InputEmoAssSwitch";
    public static final String SECONDARY_IP_NO_PMTU_DISC = "ip_no_pmtu_disc";
    public static final String SECONDARY_IS_CAN_PRELOAD_PEAK = "isCanPreloadPeak";
    public static final int SECONDARY_IS_CAN_PRELOAD_PEAK_DEFAULT = 1;
    public static final String SECONDARY_IS_LIVEVIDEO_NEW_MODE = "LiveVideo_Size_New_Mode";
    public static final String SECONDARY_JSAPI_BLACK_LIST = "jsapiblacklist";
    public static final String SECONDARY_JUMPQZONE_ENABLE = "JumpQZoneEnable";
    public static final String SECONDARY_JUMPQZONE_SCHEME_ENABLE = "JumpQZoneSchemeEnable";
    public static final String SECONDARY_JUMP_HYWS_SCHEME_ENABLE = "jump_hyws_scheme_enable";
    public static final int SECONDARY_JUMP_HYWS_SCHEME_ENABLE_DEFVALUE = 0;
    public static final String SECONDARY_JUMP_TO_NEW_PUBLIC_ACCOUNT = "JumpToNewServiceAccount";
    public static final int SECONDARY_JUMP_TO_NEW_PUBLIC_ACCOUNT_DEFAULT = 1;
    public static final String SECONDARY_JUMP_TO_PREVIEW_ALBUM_FACADE_CATE = "PreviewAlbumFacadeCate";
    public static final String SECONDARY_JUMP_TO_RECOMMEND_TAB = "DefaultSelectExplorePage";
    public static final int SECONDARY_JUMP_TO_RECOMMEND_TAB_DEFAULT = 0;
    public static final String SECONDARY_KAPU_HOST_FIREPOWER_GROWTH_URL = "kapuHostFirePowerGrowthUrl";
    public static final String SECONDARY_KAPU_HOST_MESSAGE_URL = "kapuHostMessageUrl";
    public static final String SECONDARY_KEYFRAMEINTERVALDURATION = "KeyFrameIntervalDuration";
    private static final String SECONDARY_KEY_AERES_CHECK_MD5 = "secondary_key_aeRes_check_md5";
    private static final String SECONDARY_KEY_AE_AUTO_TEMPLATE_MEMORY_LIMIT = "ae_auto_template_memory_limit";
    private static final String SECONDARY_KEY_AE_FRAME_RATE = "secondary_key_ae_frame_rate";
    private static final String SECONDARY_KEY_AE_HIGH_BITRATE = "secondary_key_ae_high_bitrate";
    private static final String SECONDARY_KEY_AE_HIGH_SIZE = "secondary_key_ae_high_size";
    private static final String SECONDARY_KEY_AE_LOW_BITRATE = "secondary_key_ae_low_bitrate";
    private static final String SECONDARY_KEY_AE_LOW_SIZE = "secondary_key_ae_low_size";
    private static final String SECONDARY_KEY_AE_MIDDLE_BITRATE = "secondary_key_ae_middle_bitrate";
    private static final String SECONDARY_KEY_AE_MIDDLE_SIZE = "secondary_key_ae_middle_size";
    private static final String SECONDARY_KEY_AE_PIC_HIGH_SIZE = "secondary_key_ae_pic_high_size";
    private static final String SECONDARY_KEY_AE_PIC_LOW_SIZE = "secondary_key_ae_pic_low_size";
    private static final String SECONDARY_KEY_AE_PIC_MIDDLE_SIZE = "secondary_key_ae_pic_middle_size";
    private static final String SECONDARY_KEY_AE_PREVIEWMAX_RENDERSIZE_ABOVE_2G = "secondary_key_ae_previewmax_rendersize_above_2g";
    private static final String SECONDARY_KEY_AE_PREVIEWMAX_RENDERSIZE_BELOW_2G = "secondary_key_ae_previewmax_rendersize_below_2g";
    public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_ALBUM_LIST_NUM_OF_COLUMN = "DetailRecomAlbumNumOfColumn";
    public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_ALBUM_LIST_NUM_OF_COLUMN_DEFAULT = 2;
    public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_DOWNNER_BOUND = "DetailRecomAlbumDownnerBound";
    public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_DOWNNER_BOUND_DEFAULT = 2;
    public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_UPPER_BOUND = "DetailRecomAlbumUpperBound";
    public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_UPPER_BOUND_DEFAULT = 99;
    public static final String SECONDARY_KEY_ALBUM_FAKE_FEED_TAIL_CLICK_TIPS = "album_fake_feed_tail_click_tips";
    public static final String SECONDARY_KEY_ALBUM_GALLERY_BG_SWITCH = "AlbumGalleryRecomAlbumBgSwitch";
    public static final String SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND = "AlbumGalleryRecomAlbumDownnerBound";
    public static final int SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND_DEFAULT = 2;
    public static final String SECONDARY_KEY_ALBUM_GALLERY_SWITCH = "AlbumGalleryRecomAlbumSwitch";
    public static final String SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND = "AlbumGalleryRecomAlbumUpperBound";
    public static final int SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND_DEFAULT = -1;
    public static final String SECONDARY_KEY_ALBUM_IS_ABLE_TO_SCAN_RECOM_UPLOAD_PHOTO = "AlbumIsAbleToScanRecomUploadPhoto";
    public static final String SECONDARY_KEY_ALBUM_NEW_UPLOAD_SHOW = "albumNewUploadShow";
    public static final String SECONDARY_KEY_ALBUM_NEW_UPLOAD_SHOW_INTERVAL = "albumNewUploadShowInterval";
    public static final String SECONDARY_KEY_ALBUM_PHOTO_SEARCH_ENTRANCE_OPEN = "AlbumPhotoSearchEntranceOpen";
    public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE = "AlbumRecomEventAlgoUserSample";
    public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_CLUSTERING_VAR = "AlbumRecomEventClusteringVariance";
    public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_CORE_PTS_NUM = "AlbumRecomEventNumOfCorePoints";
    public static final String SECONDARY_KEY_ALBUM_RECOM_ROLLBACK_TIME = "AlbumRecomRollbackTime";
    public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_BAR_PHOTO_COUNT = "AlbumRecomUploadBarPhotoCount";
    public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_DISTANCE_LIMIT = "AlbumRecomUploadDistanceLimit";
    public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_LIMITED_SCAN_TIME = "AlbumRecomUploadLimitedScanTime";
    public static final String SECONDARY_KEY_ALBUM_UPDATE_TIP_FINISH_OPEN_DESC = "AlbumListGuideFloatingViewFinishOpenDesc";
    public static final String SECONDARY_KEY_ALBUM_UPDATE_TIP_FINISH_OPEN_TITLE = "AlbumListGuideFloatingViewFinishOpenTitle";
    public static final String SECONDARY_KEY_ALBUM_UPDATE_TIP_OPEN_DESC = "AlbumListGuideFloatingViewOpenPermissionDesc";
    public static final String SECONDARY_KEY_ALBUM_UPDATE_TIP_OPEN_TITLE = "AlbumListGuideFloatingViewOpenPermissionTitle";
    public static final String SECONDARY_KEY_ALLOW_ALBUM_RECOMMEND_SHOW_GALLERY = "AllowAlbumRecommendShowGallery";
    public static final String SECONDARY_KEY_ALLOW_SCROLL_TO_RECOMMEND = "AllowScrollToRecommend";
    public static final String SECONDARY_KEY_ALLOW_SCROLL_TO_RECOMMEND_WHEN_SINGLE = "AllowScrollToRecommendWhenSingle";
    public static final String SECONDARY_KEY_APPLETS_NICKNAME = "miniappNotificationNickName";
    public static final String SECONDARY_KEY_APPLETS_UIN = "miniappNotificationUin";
    public static final String SECONDARY_KEY_BABY_ALBUM_APPLY_FUNCTION_OPEN = "babyALbumApplyFunctionOpen";
    public static final String SECONDARY_KEY_BABY_ALBUM_INVITE_FUNCTION_OPEN = "babyALbumInviteFunctionOpen";
    public static final String SECONDARY_KEY_BACK_AUTO_HIDE = "backAutoHide";
    public static final String SECONDARY_KEY_BECOME_NUAN_FRIEND_TOAST_TEXT = "becomeNuanFriendToastText";
    public static final String SECONDARY_KEY_BLOG_SHARE_SHOW_EVERNOTE = "SK_BlogShareShowEvernote";
    public static final String SECONDARY_KEY_BUGFIX_BUGFIX_RECYCLER_VIEW_COMPUTING = "enableBugfixRecyclerViewComputing";
    public static final String SECONDARY_KEY_BUGFIX_DISABLE_BLUR_CREATE_SCALED_BITMAP = "bugfixDisableBlurCreateScaledBitmap";
    public static final String SECONDARY_KEY_BUGFIX_ENABLE_FACADE_SHOW_ASYNC = "bugfixEnableFacadeShowAsync";
    public static final String SECONDARY_KEY_BUGFIX_INTENT_DATA_TOO_LARGE = "bugfixIntentDataTooLarge";
    public static final String SECONDARY_KEY_BUGFIX_KEBOARD_HEIGHT_COMPAT = "bugfixKeyboardHeightCompat";
    public static final String SECONDARY_KEY_BUGFIX_MOOD_LIST_NEED_REFRESH = "bugfixMoodListNeedRefresh";
    public static final String SECONDARY_KEY_BUGFIX_TRANSACTION_TOO_LARGE = "bugfixTransactionTooLarge";
    private static final String SECONDARY_KEY_CAMERA_FIRST_FRAME = "secondary_key_camera_first_frame";
    public static final String SECONDARY_KEY_CAMERA_PAUSE_SWITCH = "qqcircle_camera_pause_switch";
    public static final String SECONDARY_KEY_CAN_HOLD_SYSTEM_LOCK = "canHoldSystemLock";
    public static final String SECONDARY_KEY_CAN_OPEN_APP = "miniapp_able2show";
    public static final String SECONDARY_KEY_CAN_SET_LAYOUT_INFLATER_FACTORY = "enable_layout_factory";
    public static final String SECONDARY_KEY_CHOOSE_VIDEO_MAX_DURATION = "miniAppChooseVideoMaxDuration";
    public static final String SECONDARY_KEY_CHOOSE_VIDEO_MAX_SIZE = "miniAppChooseVideoMaxSize";
    public static final String SECONDARY_KEY_CLEAR_CACHE_VERSION = "Qzone_clearCacheVersion";
    public static final String SECONDARY_KEY_CLEAR_DESKTOP_EXPOSURE_REPORT_DATA = "clearDesktopExposureReportData";
    public static final String SECONDARY_KEY_CLINET_ONLINE_COLD_TIME = "ClientOnlineColdTime";
    public static final String SECONDARY_KEY_CLOSE_NATIVE_INBITMAP = "closeNativeAndInBitmap";
    public static final String SECONDARY_KEY_DESKTOP_EXPOSURE_REPORT_ON_STOP = "desktopExposureReportOnStop";
    public static final String SECONDARY_KEY_DIRECT_JUMP_TO_NEW_USER_HOME = "directJumpToNewUserHome";
    public static final String SECONDARY_KEY_DISABLE_LOCAL_PHOTO_SCAN = "secondary_key_disable_local_photo_scan";
    public static final String SECONDARY_KEY_DISABLE_QZONE_PROCESS_PLUGIN_VALID_CHECK = "disableQZoneProcessPluginValidCheck";
    public static final String SECONDARY_KEY_DISABLE_TOP_WIDGET = "secondary_key_disable_top_widget";
    public static final String SECONDARY_KEY_DISCOVERY_TITLE = "discoverytitle";
    private static final String SECONDARY_KEY_DO_SYNC_MAP = "secondary_key_aeRes_do_sync_map";
    public static final String SECONDARY_KEY_DROP_DOWN_DEFAULT_RECOMMEND_APPS = "dropDownDefaultRecomendApps";
    public static final String SECONDARY_KEY_EC_LIVE_HOST = "qzone_eclive_livehost";
    private static final String SECONDARY_KEY_EDITOR_FIRST_FRAME = "secondary_key_editor_first_frame";
    public static final String SECONDARY_KEY_ENABLE_ACTIVITY_RES_PRELOAD = "secondary_key_enable_activity_res_preload";
    public static final String SECONDARY_KEY_ENABLE_AD_LOAD_MORE_DELAY = "secondary_key_enable_ad_load_more_delay";
    public static final String SECONDARY_KEY_ENABLE_ASYNC_INFLATE = "enable_async_inflate";
    public static final String SECONDARY_KEY_ENABLE_AVIF_OCR = "enable_avif_scan_ocr";
    public static final String SECONDARY_KEY_ENABLE_AVIF_SCAN_QR_CODE = "enable_avif_scan_qr_code";
    public static final String SECONDARY_KEY_ENABLE_BIRTHDAY_LIKE = "secondary_key_enbale_birthday_like";
    public static final String SECONDARY_KEY_ENABLE_CHANGE_ZPLAN_CEILING_HEIGHT = "secondary_key_change_zplan_ceiling_height";
    public static final String SECONDARY_KEY_ENABLE_CUSTOM_LIKE = "secondary_key_enable_custom_like";
    private static final String SECONDARY_KEY_ENABLE_DIRECT_IP_CONFIG = "secondary_key_enable_direct_ip_config";
    public static final String SECONDARY_KEY_ENABLE_EXTEND_FEEDS = "enableExtendFeeds";
    public static final String SECONDARY_KEY_ENABLE_EXTEND_LIVE = "SK_QZKuoliePartyEnteranceConfig";
    public static final String SECONDARY_KEY_ENABLE_FIX_MISS_INDEX_BUG_IN_FEED_PIC_VIEWER = "enable_fix_miss_index_bug_in_feed_pic_viewer";
    public static final String SECONDARY_KEY_ENABLE_FORWARD_PANEL = "secondary_key_enable_forward_panel";
    public static final String SECONDARY_KEY_ENABLE_GUEST_JUMP_VISITOR_PAGE = "QzoneFeedVisitorCanOpenVisitorList";
    public static final String SECONDARY_KEY_ENABLE_GYROSCOPE_SENSOR = "enableGyroscopeSensor";
    public static final String SECONDARY_KEY_ENABLE_INTERCEPT_SCROLL_HORIZONTAL_EVENT = "secondary_key_enable_intercept_scroll_horizontal_event";
    public static final String SECONDARY_KEY_ENABLE_LIBTEMPLATE_INSPIRATIONAI_PB = "qqcircle_enable_libtemplate_inspirationai_pb";
    public static final String SECONDARY_KEY_ENABLE_NEW_COMMENT_SHOW_RULE = "secondary_key_enable_new_comment_show_rule";
    public static final String SECONDARY_KEY_ENABLE_NEW_ROUTER = "secondary_key_enable_new_router";
    public static final String SECONDARY_KEY_ENABLE_NEW_USER_HOME = "enableNewUserHome";
    public static final String SECONDARY_KEY_ENABLE_PRELOAD_ITEM_LAYOUT_WHEN_SCROLL = "secondary_key_enable_preload_item_layout_when_scroll";
    public static final String SECONDARY_KEY_ENABLE_PRELOAD_QZONE_WHEN_HAS_RED = "secondary_key_enable_preload_qzone_when_has_red";
    public static final String SECONDARY_KEY_ENABLE_QQ_VIDEO_COMMENT_PUBLIC_TIPS = "qzone_enable_qq_video_comment_public_tips";
    public static final String SECONDARY_KEY_ENABLE_QQ_VIDEO_SYNC_FAKE_OPERATE = "qzone_enable_qq_video_sync_fake_operate";
    public static final String SECONDARY_KEY_ENABLE_RECOVERY_LAST_FEED_INDEX = "enableRecoveryLastFeedIndex";
    public static final String SECONDARY_KEY_ENABLE_SERVICE_ACCOUNT_FOLDER = "service_enable_account_folder_list";
    public static final String SECONDARY_KEY_ENABLE_SET_AVATAR_CLIP_SIZE = "secondary_key_enable_set_avatar_clip_size";
    public static final String SECONDARY_KEY_ENABLE_SHOW_MOMENT_BANNER = "secondary_key_enable_show_moment_banner";
    public static final String SECONDARY_KEY_ENABLE_SHOW_SIGN_ENTRANCE_RED_DOT = "secondary_key_enable_show_sign_entrance_red_dot";
    public static final String SECONDARY_KEY_ENABLE_SWITCH_THREAD_FOR_AD_INIT = "secondary_key_enable_switch_thread_for_ad_init";
    public static final String SECONDARY_KEY_ENABLE_USE_MSF_IPSTACK = "secondary_key_enable_use_msf_ipstack";
    private static final String SECONDARY_KEY_ENABLE_USE_PRIVACY_FIELD = "enable_use_privacy_field";
    public static final String SECONDARY_KEY_ENABLE_WNS_PUBLIC_ACCOUNT_PUSH_INTERVAL = "wns_public_account_push_interval";
    public static final String SECONDARY_KEY_EXTERNAL_COMMENT_COUNT_FOR_NEW_FEED = "external_comment_count_for_new_feed";
    public static final String SECONDARY_KEY_FACE_SCAN_QZONE_PLUS_VERSION = "face_scan_qzone_plus_version";
    public static final String SECONDARY_KEY_FACE_SCAN_SUPPORT_LOW_VERSION = "face_scan_support_low_version";
    public static final String SECONDARY_KEY_FAKE_FEED_INTERCEPT = "secondary_key_fake_feed_intercept";
    public static final String SECONDARY_KEY_FEEDX_CRASH_PROTECT = "secondary_key_feedx_crash_protect";
    public static final String SECONDARY_KEY_FEEDX_LAYER_OPEN_HOST_RECOMMEND_ALBUM_PAGE = "LayerOpenHostRecommendAlbumPage";
    public static final String SECONDARY_KEY_FEEDX_LAYER_REQUEST_USE_MAIN_PROCESS = "FeedxLayerUseMainProcess";
    public static final String SECONDARY_KEY_FEEDX_LAYER_RESPONSE_IN_SUB_THREAD = "FeedxLayerResponseInSubThread";
    public static final String SECONDARY_KEY_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS = "QzoneFeedOpenVisitorListTimeLimitDays";
    public static final String SECONDARY_KEY_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_TIPS = "QzoneFeedOpenVisitorListTimeLimitTips";
    public static final String SECONDARY_KEY_FEED_OPERATE_TIME = "FeedOperateTime";
    public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_ARROW = "FeedPicTextCardView_PhotoArrow";
    public static final String SECONDARY_KEY_FFMPEG_VIDEO_COMPRESS_PARAM = "miniFfmpegVideoCompressParam";
    public static final String SECONDARY_KEY_FIX_BAD_PARCEL_EXCEPTION = "secondary_key_fix_bad_parcel_exception";
    public static final String SECONDARY_KEY_FORBIDDEN_PART_CONFIG = "secondary_key_forbidden_part_config";
    public static final String SECONDARY_KEY_FORBIDDEN_SECTION_CONFIG = "secondary_key_forbidden_section_config";
    public static final String SECONDARY_KEY_FRIENDFEED_TITLE = "friendfeedtitle";
    public static final String SECONDARY_KEY_GENERATE_GIF_BLACK_LIST = "GenerateGifBlackList";
    public static final String SECONDARY_KEY_GET_APPLETS_NOTIFICATION_SETTING_INTERVAL = "getappletsnotificationsettinginterval";
    public static final String SECONDARY_KEY_GET_SHARPP_SUPPORT_RESULT_FROM_CACHE = "qzoneGetSharppSupportResultFromCache";
    public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_FRAME_NUM = "GifAntishakeMaxFrameNum";
    public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME = "GifAntishakeMaxFrameShootTime";
    public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_GROUP_SHOOTTIME = "GifAntishakeMaxGroupShootTime";
    public static final String SECONDARY_KEY_GIF_ANTISHAKE_MIN_SIMILARITY = "GifAntishakeMinSimilarity";
    public static final String SECONDARY_KEY_GIF_ANTISHAKE_NEED_TO_CHECK_SHOOT_TIME = "GifAntishakeNeedToCheckShootTime";
    public static final String SECONDARY_KEY_GIF_ANTISHAKE_NEED_TO_CHECK_SIMILARITY = "GifAntishakeNeedToCheckSimilarity";
    public static final String SECONDARY_KEY_GIF_ANTISHAKE_SWITCH = "GifAntishakeSwitch";
    public static final String SECONDARY_KEY_GIF_ANTISHAKE_USE_DHASH = "GifAntishakeUseDHash";
    public static final String SECONDARY_KEY_GIF_DOWNLOAD_AND_PLAY = "GifDownloadAndPlay";
    public static final String SECONDARY_KEY_GIF_DOWNLOAD_AND_PLAY_SDK_LEVEL = "GifDownloadAndPlaySdkLevel";
    public static final String SECONDARY_KEY_GO_CONTENT_BOX_MINI_PROGRAM = "gocontentboxminiprogram";
    public static final String SECONDARY_KEY_GUEST_MIN_CPU_FREQ = "LiveVideoGuestMinCpuFreq";
    public static final String SECONDARY_KEY_GUEST_MIN_CPU_NUMBER = "LiveVideoGuestCpuNumber";
    public static final String SECONDARY_KEY_GUEST_MIN_RAM = "LiveVideoGuestMinRam";
    public static final String SECONDARY_KEY_GUEST_MORE_POPUP_SETTING = "GuestMorePopupSetting";
    public static final String SECONDARY_KEY_GUEST_SDKDEF = "LiveVideoGuestSdkDef";
    public static final String SECONDARY_KEY_GUIDE_UPLOAD_ALBUM_FINISH_OPEN = "GuideUploadAlbumBannerFinishOpenDesc";
    public static final String SECONDARY_KEY_GUIDE_UPLOAD_ALBUM_HEAD_VIEW_FINISH_OPEN = "AlbumListGuideHeaderViewFinishOpenDesc";
    public static final String SECONDARY_KEY_GUIDE_UPLOAD_ALBUM_HEAD_VIEW_OPEN = "AlbumListGuideHeaderViewOpenPermissonDesc";
    public static final String SECONDARY_KEY_GUIDE_UPLOAD_ALBUM_OPEN = "GuideUploadAlbumBannerOpenPermissionDesc";
    public static final String SECONDARY_KEY_HALF_SCREEN_WEB_FILTER_DEVICE = "qzone_intimate_half_screen_web_filter_device";
    public static final String SECONDARY_KEY_HEAD_MENU = "friendfeedheadmenu";
    public static final String SECONDARY_KEY_HIDE_AIO_FEEDS = "hideAioFeeds";
    public static final String SECONDARY_KEY_HIDE_AIO_STORY_FEED = "DisableReqAioStoryFeed";
    public static final String SECONDARY_KEY_HIDE_QZONE_STATUS_IN_CONVERSATION = "hideFeedsInConverstation";
    public static final String SECONDARY_KEY_HOST_MORE_POPUP_SETTING = "HostMorePopupSetting";
    public static final String SECONDARY_KEY_ILIVE_TIPS_LOOP_ENABLE = "iliveTopsLoopEnable";
    public static final String SECONDARY_KEY_IMAGE_DECODING_RES_REPORT_SAMPLE = "qzoneImageDecodingResReportSample";
    public static final String SECONDARY_KEY_INTERACTING_BAR_HOST_USE_ORIGINAL_LAYOUT = "InteractingBarHostUseOriginalLayout";
    public static final String SECONDARY_KEY_INTIMATE_DISCONNECT_RELATION_JUMP_URL = "qzone_intimate_space_disconnect_relation_jumpurl";
    public static final String SECONDARY_KEY_INTIMATE_ENABLE_FAKE_FEED = "qzone_intimate_enable_fake_feed";
    public static final String SECONDARY_KEY_INTIMATE_ENABLE_SHOW_AT_TOAST = "qzone_intimate_enable_show_at_toast";
    public static final String SECONDARY_KEY_INTIMATE_FAKE_FEED_TIME_OUT_MILLIS = "qzone_intimate_fake_feed_timeout_millis";
    public static final String SECONDARY_KEY_INTIMATE_GET_REAL_FEED_DELAY = "qzone_intimate_get_real_feed_delay";
    public static final String SECONDARY_KEY_INTIMATE_GET_REAL_FEED_MAX_RETRY_COUNT = "qzone_intimate_get_real_feed_max_retry_count";
    public static final String SECONDARY_KEY_INTIMATE_GET_REAL_FEED_RETRY_DELAY = "qzone_intimate_get_real_feed_retry_delay";
    public static final String SECONDARY_KEY_INTIMATE_SPACE_DRAWER_JUMPURL = "qzone_intimate_space_drawer_jumpurl";
    public static final String SECONDARY_KEY_INTIMATE_SPACE_DRAWER_SWITCHON = "intimate_space_entry";
    public static final String SECONDARY_KEY_INTIMATE_SPACE_NAME = "qzone_intimate_space_name";
    public static final String SECONDARY_KEY_IS_AUTO_ZOOM_LONG_PIC = "isAutoZoomLongPic";
    public static final String SECONDARY_KEY_IS_CAN_ENTER_IN_AIO_FROM_COUPLE_APP = "is_can_enter_aio";
    public static final String SECONDARY_KEY_IS_SHOW_ENTRANCE = "entrance";
    public static final String SECONDARY_KEY_JUMP_DULI_DETAIL_TIMEOUT = "open_duli_detial_timeout";
    public static final String SECONDARY_KEY_JUMP_TO_MORE_VIDEO = "JumpToMoreVideo";
    private static final String SECONDARY_KEY_KILL_PROCESS_IN_EDITOR_DURATION = "qqcircle_new_publish_draft_auto_save_time_interval";
    public static final String SECONDARY_KEY_LBS_SPECIAL_LOGIC_MAX_RETRY_COUNT = "LbsSpecialLogicMaxRetryCount";
    public static final String SECONDARY_KEY_LBS_SPECIAL_LOGIC_ON = "LbsSpecialLogicOn";
    public static final String SECONDARY_KEY_LOAD_FRIEND_LIST_FROMQQ_NEED_DECODE = "load_friend_list_fromqq_need_decode";
    public static final String SECONDARY_KEY_LOCATE_INTERVAL = "QzoneLocateInterval";
    public static final String SECONDARY_KEY_LOCATE_PERMISSION_INTERVAL = "QzoneLocatePermissionInterval";
    public static final String SECONDARY_KEY_LOVE_ALBUM_APPLY_FUNCTION_OPEN = "loveALbumApplyFunctionOpen";
    public static final String SECONDARY_KEY_LOVE_ALBUM_INVITE_FUNCTION_OPEN = "loveALbumInviteFunctionOpen";
    public static final String SECONDARY_KEY_MANUAL_LOAD_SWITCH_STATUS = "ManualLoadSwitchStatus";
    public static final String SECONDARY_KEY_MAX_NUM_IN_CONVERSATION = "MaxNumInConverstation";
    public static final String SECONDARY_KEY_MAX_P2V_VIDEO_DURING = "MaxP2VVideoDuring";
    private static final String SECONDARY_KEY_MAX_PHOTO_NUM_IN_RECENT_PHOTO = "secondary_key_max_photo_num_in_recent_photo";
    public static final String SECONDARY_KEY_MINIGAME_LAMEMP3_SO_INFO = "minigame_lamemp3_so_info";
    public static final String SECONDARY_KEY_MINIGAME_SHARE_RATE = "MiniGameShareRate";
    public static final String SECONDARY_KEY_MINIPROGRAM_VIDEO_CONTENTTYPE = "MiniProgramVideoContentType";
    public static final String SECONDARY_KEY_MINI_APP_BRING_TITLE_BAR_TO_FRONT = "miniappbringtitlebartofront";
    public static final String SECONDARY_KEY_MINI_APP_ECSHOP_EXPO_TIME_LIMIT = "MiniAppEcShopExpoTimeLimit";
    public static final String SECONDARY_KEY_MINI_APP_ECSHOP_NUM_MSG_ENABLE = "MiniAppEcShopNumMsgEnable";
    public static final String SECONDARY_KEY_MINI_APP_ECSHOP_URL = "miniappecshopurl";
    public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SEARCH = "miniappfullscreenshowsearch";
    public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_CLOSE = "miniappfullscreenshowclose";
    public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION = "miniappfullscreenshownotificationbtn";
    public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_RED_DOT = "miniappfullscreenshownotificationreddot";
    public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_SETTING = "miniappfullscreenshowsetting";
    public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_TITLE = "miniappfullscreentitle";
    public static final String SECONDARY_KEY_MINI_APP_GET_PSKEY_DOMAIN = "miniappgetpskeydomain";
    public static final String SECONDARY_KEY_MINI_APP_OLD_ENTRY_CLOSE_RED_DOT = "oldEntryCloseRedDot";
    public static final String SECONDARY_KEY_MINI_APP_REFRESH_SHOW_ICON = "miniapprefreshshowappicon";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_FULL_SCREEN = "miniappshowfullscreen";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_MSG_RED_DOT = "miniappshowmessagereddot";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_RED_DOT = "miniappshowreddot";
    public static final String SECONDARY_KEY_MINI_APP_SYSTEM_PERMISSION_CONFIG = "miniappsustempermissionconfig";
    public static final String SECONDARY_KEY_MINI_APP_TOP_MAX_NUM = "miniappfullscreenminedatamaxnum";
    public static final String SECONDARY_KEY_MINI_APP_TRIGGER_FULL_SCREEN_HEIGHT = "miniapptriggerfullscreenheight";
    public static final String SECONDARY_KEY_MINI_APP_TRIGGER_REFRESH_MIN_DISTANCE = "pulldownRefreshMinDistance";
    public static final String SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST = "miniappsendrequestbyhttps";
    public static final String SECONDARY_KEY_MINI_APP_USE_NATIVE_SEARCH = "SearchUseNative";
    public static final String SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_ARK_MSG_GRAY = "MiniGamePublicAccountArkMsgGray";
    public static final String SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_URL = "MiniGamePublicAccountGameStoreUrl";
    public static final String SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_MSG_LIST_COUNT = "MiniGamePublicAccountMsgListCount";
    public static final String SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_WEB_URL = "MiniGamePublicAccountWebUrl";
    public static final String SECONDARY_KEY_MINI_LOADING_AD_UNSUPPORT_VIA_LIST = "launch_adv_unsupport_via_list";
    public static final String SECONDARY_KEY_MIN_MEMEORY_CLASS_IN_ART = "MinMemoryClassInArt";
    public static final String SECONDARY_KEY_MODULE_JUMP_NATIVE = "module_jump_native";
    public static final String SECONDARY_KEY_MOMENT_DISABLE_MODEL = "momentDisableModel";
    public static final String SECONDARY_KEY_MOODLIST_ENTRANCE_GRAY = "moodListEntranceViewNewStyleGray";
    public static final String SECONDARY_KEY_MOOD_SCHEDULE_DELETE = "MoodScheduleDelete";
    public static final String SECONDARY_KEY_MULTI_ALBUM_APPLY_FUNCTION_OPEN = "multiALbumApplyFunctionOpen";
    public static final String SECONDARY_KEY_MULTI_ALBUM_INVITE_FUNCTION_OPEN = "multiALbumInviteFunctionOpen";
    public static final String SECONDARY_KEY_NEW_EVENT_BUBLE_STAY_TIME = "NewEventBubleStayTime";
    public static final String SECONDARY_KEY_NEW_STYLE_SHUOSHUO_NEW_CARD_SWITCH = "shuoshuoNewStyleNewCardSwitch";
    public static final String SECONDARY_KEY_NEW_THUMBNAIL_ENABLED = "secondary_key_new_thumbnail_enabled";
    public static final String SECONDARY_KEY_NO_CACHE_IMAGE_EXPIRED_TIME = "NoCacheImageExpiredTime";
    public static final String SECONDARY_KEY_OFFICIAL_ACCOUNT_CAN_SHOW_FEEDS_LIST = "OfficialAccountCanShowFeedsList";
    public static final String SECONDARY_KEY_OFFICIAL_ACCOUNT_REPORT_AIO_LIST_EXPO_ENABLE = "OfficialAccountReportAioListExpoEnable";
    public static final String SECONDARY_KEY_OFFICIAL_ACCOUNT_REPORT_AIO_LIST_EXPO_INIT_TIME_LIMIT = "OfficialAccountReportAioListExpoInitTimeLimit";
    public static final String SECONDARY_KEY_OFFICIAL_ACCOUNT_REPORT_TIME_LIMIT = "OfficialAccountReportTimeLimit";
    public static final String SECONDARY_KEY_OFFLINE_CACHE_BUFFER_SIZE = "OfflineCacheBufferSize";
    public static final String SECONDARY_KEY_OFFLINE_CACHE_EXT_LIST = "OfflineCacheExt2MimeType";
    public static final String SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_GZIP = "OfflineCacheSupportGZip";
    public static final String SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_WEBP_AND_SHARPP = "OfflineCacheSupportWebpAndSharppImage";
    public static final String SECONDARY_KEY_OFFLINE_CACHE_WHITELIST = "OfflineCacheWhiteList";
    public static final String SECONDARY_KEY_OFFLINE_DECODE_PHOTO_QUALITY = "QzoneOfflineDecodePhotoQuality";
    public static final String SECONDARY_KEY_OFFLINE_ENABLE = "OfflineCacheEnable";
    public static final String SECONDARY_KEY_OPEN_LAYER_CARVED_ANIM = "openLayerCarvedAnim";
    public static final String SECONDARY_KEY_OPEN_WEBSECURITYVERIFY = "openWebSecurityVerify";
    public static final String SECONDARY_KEY_OWNER_OPERATE_TIME = "OwnerOperateTime";
    public static final String SECONDARY_KEY_P2V_BLACK_LIST = "P2VFunBlackList";
    public static final String SECONDARY_KEY_P2V_FUN_ENABLE = "P2VFunEnable";
    public static final String SECONDARY_KEY_P2V_NEED_ORIGINAL = "P2VNeedOriginal";
    public static final String SECONDARY_KEY_P2V_STORAGE_LIMIT = "P2VStorageLimt";
    public static final String SECONDARY_KEY_P2V_SUPPORTED_CPU_FAMILY = "P2VSupportedCpuFamily";
    public static final String SECONDARY_KEY_PICK_GAMEMATE = "isEnablePickGameMates";
    public static final String SECONDARY_KEY_PIC_COMPRESS_QZONE_SWITCH = "qqcircle_pic_compress_qzone_switch";
    public static final String SECONDARY_KEY_PIC_TEMPLATE_QZONE_SWITCH = "qqcircle_pic_template_qzone_switch";
    public static final String SECONDARY_KEY_PLUS_DIFFERENCE = "plusdifference";
    public static final String SECONDARY_KEY_PRELOAD_FEEDX_ITEM = "secondary_key_preload_feedx_item";
    public static final String SECONDARY_KEY_PRELOAD_ITEM_SIZE_FOR_AD = "secondary_key_preload_item_size_for_ad";
    public static final String SECONDARY_KEY_PRELOAD_ITEM_SIZE_NORMAL = "secondary_key_preload_item_size_normal";
    private static final String SECONDARY_KEY_PRELOAD_PLAYER = "secondary_key_preload_player";
    public static final String SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME = "ProfileCardMiniPlayingName";
    public static final String SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME_GUEST = "ProfileCardMiniPlayingNameGuest";
    public static final String SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME_GUEST_DEFAULT = "ProfileCardMiniPlayingNameGuestDefault";
    public static final String SECONDARY_KEY_PUBLISH_GALLERY_MODE_SCHEMA = "qqcircle_gallery_publish_schema";
    public static final String SECONDARY_KEY_PUBLISH_PAGE_IF_SHOW_SYNC_QCIRCLE_BUBBLE = "secondary_key_publish_page_if_show_sync_qcircle_bubble";
    public static final String SECONDARY_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_MEMORY_SWITCH_BUBBLE_TEXT = "secondary_key_publish_page_sync_qcircle_memory_switch_bubble_text";
    public static final String SECONDARY_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_PART_SHOW = "secondary_key_publish_page_sync_qcircle_part_show";
    public static final String SECONDARY_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_PREVIEW_BUBBLE_TEXT = "secondary_key_publish_page_sync_qcircle_preview_bubble_text";
    public static final String SECONDARY_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_SWITCH_BUBBLE_TEXT = "secondary_key_publish_page_sync_qcircle_switch_bubble_text";
    public static final String SECONDARY_KEY_PUBLISH_USE_GALLERY_MODE = "qqcircle_gallery_publish_enable";
    public static final String SECONDARY_KEY_QAV_BACK_PRESS_SWITCH = "qavBackPressSwitch";
    public static final String SECONDARY_KEY_QAV_SHOW_QZONE_ENTRANCE = "qavShowQZoneEntrance";
    public static final String SECONDARY_KEY_QQCIRCLE_CHAT_CLUSTER_UINS_ONLY_SHOW_BUBBLE = "qqcircle_chat_cluster_uins_only_show_bubble";
    private static final String SECONDARY_KEY_QQCIRCLE_NEW_STYLE_DEFAULT_JUMP_PHOTOLIST = "qqcircle_new_style_default_jump_photolist";
    public static final String SECONDARY_KEY_QQ_VIDEO_CLEAR_REDPOINT_STRATEGY = "qqcircle_qqvideo_clear_redpoint_strategy";
    public static final String SECONDARY_KEY_QQ_VIDEO_COMMENT_PUBLIC_TIPS_CONENT = "qzone_qq_video_comment_public_tips_content";
    public static final String SECONDARY_KEY_QQ_VIDEO_ENABLE_CONVERT_FEED_ID = "qzone_qq_video_enable_convert_feed_id";
    public static final String SECONDARY_KEY_QQ_VIDEO_GET_REAL_FEED_DELAY = "qzone_qq_video_get_real_feed_delay";
    public static final String SECONDARY_KEY_QQ_VIDEO_GET_REAL_FEED_MAX_RETRY_COUNT = "qzone_qq_video_get_real_feed_max_retry_count";
    public static final String SECONDARY_KEY_QQ_VIDEO_GET_REAL_FEED_RETRY_DELAY = "qzone_qq_video_get_real_feed_retry_delay";
    public static final String SECONDARY_KEY_QZONEPLATO_JUMP_NATIVE = "qzoneplato_jump_native";
    public static final String SECONDARY_KEY_QZONEPLATO_SHAREHOST = "PlatoShareUrlPrefix";
    public static final String SECONDARY_KEY_QZONEVIDEO_HOST = "qzonelivevideo_livehost";
    public static final String SECONDARY_KEY_QZONE_DETAIL_COMMENT_LOAD_MORE = "secondary_key_qzone_detail_comment_load_more";
    public static final String SECONDARY_KEY_QZONE_FEED_LIST_CHECK_PRELOAD_PIC_ENABLE = "secondary_key_qzone_feed_list_check_prelaod_pic_enable";
    public static final String SECONDARY_KEY_QZONE_FEED_LIST_HAS_MORE_SWITCH = "secondary_key_qzone_feed_list_has_more_switch";
    public static final String SECONDARY_KEY_QZONE_GIF_NEED_RECYLE_BMP = "qzoneGifNeedRecycle";
    public static final String SECONDARY_KEY_QZONE_GIF_PREFER_NEW_DECODE_TASK = "qzoneGifPreferNewDecodeTask";
    public static final String SECONDARY_KEY_QZONE_GIF_SUPPORT_565 = "qzoneGifSupport565";
    public static final String SECONDARY_KEY_QZONE_INTIMATE_ACTIVATE_PAGE_URL = "qzone_intimate_activate_page_url";
    public static final String SECONDARY_KEY_QZONE_INTIMATE_HISTORY_PAGE_URL = "qzone_intimate_history_page_url";
    public static final String SECONDARY_KEY_QZONE_INTIMATE_SPACE_BADGE_HALO_BGURL = "qzone_intimate_space_badge_halo_bgurl";
    public static final String SECONDARY_KEY_QZONE_INTIMATE_SPACE_BADGE_LOTTIE_URL = "qzone_intimate_space_badge_lottie_url";
    public static final String SECONDARY_KEY_QZONE_IS_TOP_GESTURE_PART_ENABLE = "secondary_key_qzone_is_top_gesture_part_enable";
    public static final String SECONDARY_KEY_QZONE_LOCATION_CACHE_SAMPLE_RATE = "qzoneLocationCacheSampleRate";
    public static final String SECONDARY_KEY_QZONE_LOCATION_SAMPLE_RATE = "qzoneLocationSampleRate";
    public static final String SECONDARY_KEY_QZONE_MODULE_REPORT_SAMPLE = "qzoneModuleReportSample";
    public static final String SECONDARY_KEY_QZONE_MOMENT_ENTRANCE_SWITCH = "secondary_key_qzone_moment_entrance_switch";
    public static final String SECONDARY_KEY_QZONE_MOMENT_NEW_USER_GUIDE_SWITCH = "secondary_key_qzone_moment_new_user_guide_switch";
    public static final String SECONDARY_KEY_QZONE_MOMENT_OUTER_ENTRANCE_MAIN_TEXT = "secondary_key_qzone_moment_outer_entrance_main_text";
    public static final String SECONDARY_KEY_QZONE_MOMENT_PUBLISH_RETRY_LIMIT_TIMES = "secondary_key_qzone_moment_publish_retry_limit_times";
    public static final String SECONDARY_KEY_QZONE_MOMENT_PUBLISH_SUCCESS_REFRESH_DELAY = "secondary_key_qzone_moment_publish_success_refresh_delay";
    public static final String SECONDARY_KEY_QZONE_MOMENT_PUBLISH_TIPS = "secondary_key_qzone_moment_publish_tips";
    public static final String SECONDARY_KEY_QZONE_MOMENT_PUSH_GET_UNDEALCOUNT_SWITCH = "secondary_key_qzone_moment_push_get_undealcount_switch";
    public static final String SECONDARY_KEY_QZONE_MOMENT_SHARE_SWITCH = "secondary_key_qzone_moment_feed_share_ark_switch";
    public static final String SECONDARY_KEY_QZONE_PLUS_MENU_SHOW_QZMOMENT_ENTRANCE = "secondary_key_qzone_plus_menu_show_qzmoment_entrance";
    public static final String SECONDARY_KEY_QZONE_PLUS_SIGN_IN_SCHEME = "secondary_key_qzone_plus_sign_in_scheme";
    public static final String SECONDARY_KEY_QZONE_QUI_PROFILE_ENABLE = "secondary_key_qzone_qui_profile_enable";
    public static final String SECONDARY_KEY_QZONE_RECENT_ROUTE_EXPIRE = "secondary_key_qzone_recent_route_expire";
    public static final String SECONDARY_KEY_QZONE_REMOVE_ALBUM_MASK_IN_NIGHT = "secondary_key_qzone_remove_album_mask_in_night";
    public static final String SECONDARY_KEY_QZONE_SCROLL_IDLE_END_PAUSE_VIDEO = "secondary_key_qzone_scroll_idle_pause_video";
    public static final String SECONDARY_KEY_QZONE_SEARCH_RESULT_URL = "qzone_search_result_url";
    public static final String SECONDARY_KEY_QZONE_USER_HOME_SEARCH_SCHEME = "secondary_key_qzone_user_home_search_scheme";
    public static final String SECONDARY_KEY_REAL_TIME_LOG_MAX_CALL_NUM = "RealTimeLogMaxCallNum";
    public static final String SECONDARY_KEY_REAL_TIME_LOG_MAX_CONTENT_SIZE = "RealTimeLogMaxContentSize";
    public static final String SECONDARY_KEY_RECOMMEND_COUNT_NUM_LIMIT = "RecommendAlbumCountNumLimit";
    public static final String SECONDARY_KEY_REPLACE_NEW_DETAIL = "secondary_key_replace_new_detail";
    public static final String SECONDARY_KEY_REPORT_CALCULATE_FRAME_COUNT = "qqwink_report_calculate_frame_count";
    public static final String SECONDARY_KEY_RETURN_EMPTY_PATH_WHEN_COPY_FAIL = "isReturnEmptyPathWhenCopyFail";
    public static final String SECONDARY_KEY_SCHEMA_ENABLE_JUMP_MAIN_PAGE = "secondary_key_schema_jump_main_page";
    public static final String SECONDARY_KEY_SEARCH_MOOD_TIPS_FIRST_LINE = "search_mood_tips_first_line";
    public static final String SECONDARY_KEY_SEARCH_MOOD_TIPS_SECOND_LINE = "search_mood_tips_second_line";
    public static final String SECONDARY_KEY_SELF_PRAISE_ANIMATION_RES_URL = "self_praise_animation_res_url";
    public static final String SECONDARY_KEY_SELF_PRAISE_ANIMATION_SWITCH = "self_praise_animation_switch";
    public static final String SECONDARY_KEY_SERVICE_ACCOUNT_FOLDER_LIST_NOTICE_TEXT = "service_account_folder_list_notice_text";
    public static final String SECONDARY_KEY_SERVICE_ACCOUNT_FOLDER_NOTICE_HEAD_URL = "service_account_folder_list_notice_head_url";
    public static final String SECONDARY_KEY_SERVICE_ACCOUNT_FOLDER_NOTICE_NAME = "service_account_folder_list_notice_name";
    public static final String SECONDARY_KEY_SERVICE_ACCOUNT_FOLDER_NOTICE_TIME = "service_account_folder_list_notice_time";
    public static final String SECONDARY_KEY_SETTING_RED_DOT_ANIMATION_SRC = "love_zone_red_dot_frame_ani";
    public static final String SECONDARY_KEY_SHARE_ALBUM_TO_WEIXIN_MINI_PROGRAM_NEED_SK = "share_album_to_wx_miniprogram_need_sk";
    public static final String SECONDARY_KEY_SHARING_OWNERS_LIST_TITLE_BABY = "SharingOwnersListTitleBaby";
    public static final String SECONDARY_KEY_SHARING_OWNERS_LIST_TITLE_REGULAR = "SharingOwnersListTitleRegular";
    public static final String SECONDARY_KEY_SHARPP_GATE = "qzoneSharppGate";
    public static final String SECONDARY_KEY_SHARPP_LOAD_SO_RETRY_WAIT_TIME = "qzoneSharppLoadSoRetryWaitTime";
    public static final String SECONDARY_KEY_SHARPP_PLAN_B_SWITCH = "qzoneSharppPlanBSwitch";
    private static final String SECONDARY_KEY_SHOULD_PRELOAD_TRAVEL_GROUP = "secondary_key_should_preload_travel_group";
    public static final String SECONDARY_KEY_SHOULD_SCROLL_TOP_WHEN_REFRESH_FINISH = "secondary_key_should_scroll_top_when_refresh_finish";
    private static final String SECONDARY_KEY_SHOW_WINK_LIVE_ENTRANCE = "qqcircle_show_live_entrance";
    private static final String SECONDARY_KEY_SHOW_WINK_TEMPLATE_LIBRARY = "secondary_key_show_wink_template_library";
    private static final String SECONDARY_KEY_SHOW_WINK_ZSHOW = "qqcircle_enable_zshow";
    public static final String SECONDARY_KEY_SIGN_ENTRANCE_RED_DOT_EXPOSE_TIME = "secondary_key_sign_entrance_red_dot_expose_time";
    public static final String SECONDARY_KEY_STUDY_MODE_APPID_WHITELIST = "study_mode_appid_whitelist";
    public static final String SECONDARY_KEY_STUDY_MODE_SCENE_WHITELIST = "study_mode_scene_whitelist";
    private static final String SECONDARY_KEY_SUPPORT_DELETE_FEED_REEDIT = "support_delete_feed_reedit";
    private static final String SECONDARY_KEY_SUPPORT_PUBLISH_EMOJI = "secondary_key_support_publish_emoji";
    private static final String SECONDARY_KEY_SUPPORT_REEDIT_LIFE_CYCLE = "support_reedit_life_cycle";
    private static final String SECONDARY_KEY_SUPPORT_WZ_SHARE_TO_WINK = "secondary_key_support_wz_share_to_wink";
    public static final String SECONDARY_KEY_SURPRISE_CLICK_HEIGHT = "surpriseClickHeight";
    public static final String SECONDARY_KEY_SURPRISE_CLICK_WIDTH = "surpriseClickWidth";
    public static final String SECONDARY_KEY_SURPRISE_TIME_INTERVAL = "surpriseTimeInterval";
    public static final String SECONDARY_KEY_SURPRISE_WAIT_TIME = "surpriseWaitTime";
    public static final String SECONDARY_KEY_SWEET_GUEST_PAGE = "sweet_guest_page";
    public static final String SECONDARY_KEY_SWEET_MAIN_PAGE_JUMP_URL = "sweet_mainpage";
    public static final String SECONDARY_KEY_SWEET_MAIN_PAGE_JUMP_URL_FOR_GUEST = "lover_h5_url";
    public static final String SECONDARY_KEY_SYNC_QFS_MEMORY_COUNT_THRESHOLD = "secondary_key_sync_qfs_memory_count_threshold";
    public static final String SECONDARY_KEY_TIANSHU_FEATURE_RED_TOUCH_DISMISS = "red_touch_dismiss";
    public static final String SECONDARY_KEY_TIMECAPSULE_DEFAULT_EXPAND = "timecapsule_default_expand";
    public static final String SECONDARY_KEY_TRAVEL_ALBUM_APPLY_FUNCTION_OPEN = "travelALbumApplyFunctionOpen";
    public static final String SECONDARY_KEY_TRAVEL_ALBUM_INVITE_FUNCTION_OPEN = "travelALbumInviteFunctionOpen";
    public static final String SECONDARY_KEY_UPDATE_CONFIG_IF_IPSTACK_CHANGED = "secondary_key_update_config_if_ipstack_changed";
    public static final String SECONDARY_KEY_UPLOAD_SWITCH = "upload_switch";
    public static final String SECONDARY_KEY_USERHOME_MESSAGE_BOARD_URL = "user_home_message_board_url";
    public static final String SECONDARY_KEY_USERHOME_NEW_VISITOR_ANIMATION_SINGLE_FRAME_DURANTION = "user_home_new_visitor_single_frame_duration";
    public static final String SECONDARY_KEY_USER_SCROLL_THRESHOLD = "secondary_key_user_scroll_threshold";
    public static final String SECONDARY_KEY_USE_MULTI_SELECTION_MODE = "secondary_key_use_multi_selection_mode";
    public static final String SECONDARY_KEY_USE_NEW_PICTURE_RULE_FOR_NEW_FEED = "useNewPictureRuleForNewFeed";
    private static final String SECONDARY_KEY_USE_NEW_TEMPLATE_LIB_PICKER_LOGIC = "secondary_key_use_new_template_lib_picker_logic";
    public static final String SECONDARY_KEY_VIDEO_EXPOSE_REPORT_COUNT = "VideoExposeReportCount";
    private static final String SECONDARY_KEY_VIDEO_MAX_DURATION_SEC = "qqcircle_video_max_duration";
    public static final String SECONDARY_KEY_VIDEO_TAB_JUMP_TO_WEISHI = "videoTabJumpToWeishi";
    public static final String SECONDARY_KEY_VIDEO_TAB_PRELOAD_NUMS = "videoTabPreloadNums";
    public static final String SECONDARY_KEY_WEBAUDIO_SO_INFO = "webaudio_so_info";
    public static final String SECONDARY_KEY_WEBVIEW_SECURE_ALL_BUSINESS = "isNeedSecureVerifyAllBusiness";
    private static final String SECONDARY_KEY_WINK_AVATAR_VIDEO_CONTROl = "secondary_key_wink_avatar_video_control";
    private static final String SECONDARY_KEY_WINK_BITRATE_ABTEST_ENABLE = "secondart_key_wink_bitrate_abtest";
    private static final String SECONDARY_KEY_WINK_BITRATE_ABTEST_ENDNUM = "secondart_key_wink_bitrate_abtest_endnum";
    private static final String SECONDARY_KEY_WINK_COMPRESS_ADAPTER_QP_ENABLE = "secondary_key_wink_compress_adapter_qp_enable";
    private static final String SECONDARY_KEY_WINK_COMPRESS_ADAPTER_QP_PARAM = "secondary_key_wink_compress_adapter_qp_param";
    private static final String SECONDARY_KEY_WINK_COMPRESS_NEW_API_ENABLE = "secondary_key_wink_compress_new_api_enable";
    public static final String SECONDARY_KEY_WINK_ENABLE_QZONE_TEMPLATE_TAB = "qqcircle_enable_qzone_template_tab";
    public static final String SECONDARY_KEY_WINK_ENABLE_QZONE_TEXT_TAB = "qqcircle_enable_qzone_text_tab";
    public static final String SECONDARY_KEY_WINK_ENABLE_QZONE_ZSHOW_TAB = "qqcircle_enable_qzone_zshow_tab";
    public static final String SECONDARY_KEY_WINK_ENABLE_UNZIP_RENAME = "secondary_key_wink_enable_unzip_rename";
    private static final String SECONDARY_KEY_WINK_EXPORT_ENABLE_H265_TO_H264 = "secondary_key_wink_export_enable_h265_to_h264";
    private static final String SECONDARY_KEY_WINK_EXPORT_ENABLE_SOFTENCODER = "secondary_key_wink_export_enable_softencoder";
    private static final String SECONDARY_KEY_WINK_EXPORT_SUPPORT_ORIGIN_FRAMERATE = "secondary_key_wink_export_support_origin_framerate";
    private static final String SECONDARY_KEY_WINK_FIRST_SCREEN_COST_MONITOR_ENABLED = "qqwink_first_screen_cost_monitor_enabled";
    private static final String SECONDARY_KEY_WINK_FPS_MONITOR_ENABLED = "qqwink_analyse_enabled";
    private static final String SECONDARY_KEY_WINK_HDMODE_DOWNTOTHREE_ENABLE = "secondary_key_wink_hdmode_downtothree_enable";
    private static final String SECONDARY_KEY_WINK_HIGH_VIDEO_BITRATE_ENABLE = "secondart_key_wink_high_video_bitrate";
    public static final String SECONDARY_KEY_WINK_MATERIAL_CDN_CONFIG = "secondary_key_wink_material_cdn_config";
    private static final String SECONDARY_KEY_WINK_MEMORY_MONITOR_ENABLED = "qqwink_memory_monitor_enabled";
    private static final String SECONDARY_KEY_WINK_NEXT_COMPRESS_NEW_API_ENABLE = "secondary_key_wink_next_compress_new_api_enable";
    private static final String SECONDARY_KEY_WINK_PUBLISH_BIND_PEAKSERVICE = "secondary_key_wink_publish_bind_peakservice";
    private static final String SECONDARY_KEY_WINK_PUBLISH_ENABLE_COMPRESS_HDR = "secondary_key_wink_publish_enable_compress_hdr";
    private static final String SECONDARY_KEY_WINK_PUBLISH_ENABLE_HEVC = "secondary_key_wink_publish_enable_hevc";
    private static final String SECONDARY_KEY_WINK_PUBLISH_HEVC_BLACKLIST = "secondary_key_wink_publish_hevc_blacklist";
    private static final String SECONDARY_KEY_WINK_PUBLISH_HEVC_OS_VERSION = "secondary_key_wink_publish_hevc_os_version";
    private static final String SECONDARY_KEY_WINK_PUBLISH_MAX_UPLOAD_FILE_SIZE = "secondary_key_wink_publish_max_upload_file_size";
    private static final String SECONDARY_KEY_WINK_PUBLISH_SERVICE_SAMPLE_ID = "secondary_key_wink_publish_service_sample_id";
    private static final String SECONDARY_KEY_WINK_SCHEMA_ENABLE_FLATMAP_TO_INTENT = "secondary_key_wink_schema_enable_flatmap_to_intent";
    private static final String SECONDARY_KEY_WINK_SIGN_VIDEO_CONTROl = "secondary_key_wink_sign_video_control";
    private static final String SECONDARY_KEY_WINK_THUMB_SPS_CONFIG = "secondary_key_wink_thumb_sps_config";
    private static final String SECONDARY_KEY_WINK_UPLOADSPEED_TOEXPORT_ENABLE = "secondary_key_wink_uploadspeed_toexport_enable";
    public static final String SECONDARY_KEY_WNS_CGI_ENABLE_OPTIMIZATION = "enableWnsCgiOptimization";
    public static final int SECONDARY_KEY_WNS_CGI_ENABLE_OPTIMIZATION_DEFAULT = 1;
    private static final String SECONDARY_KEY_ZSHOW_FILAMENT_PREVIEW_LOADING_MAX_DURATION = "qqcircle_zshow_preview_view_loading_max_duration_8928";
    public static final String SECONDARY_KUOLIE_SYNC_BUTTON = "kuo_syns_button";
    public static final String SECONDARY_LARGE_FONT_SIZE = "LargeFontSize";
    public static final String SECONDARY_LATEST_WEBAPP_IP_COUNT = "LatestWebappIPCount";
    public static final String SECONDARY_LATEST_WEBAPP_IP_RECORD_SECONDS = "LatestWebappIPRecordSeconds";
    public static final String SECONDARY_LATEST_WEBAPP_TIMESTAMP_COUNT = "LatestWebappTimeStampCount";
    public static final String SECONDARY_LBS_PRLOAD = "LBSPreload";
    public static final String SECONDARY_LIKELIST_PAGE = "LikeListPage";
    public static final String SECONDARY_LIMIT_FACE_NUMS = "limitFaceNums";
    public static final String SECONDARY_LINK_REPORT_CMD_LIST = "LinkReportCmds";
    public static final String SECONDARY_LIVEPLUGIN_SOURL = "LivePluginSOUrl";
    public static final String SECONDARY_LIVEPLUGIN_SOVersion = "LivePluginSOVersion";
    public static final String SECONDARY_LIVEVIDEO_DULI_DOWNLOAD = "LiveVideoDuliDownload";
    public static final String SECONDARY_LIVEVIDEO_FLOATLAYER_ENTRY = "LiveVideoFloatLayerEntry";
    public static final String SECONDARY_LIVE_FEED_AUTO_PLAY_DELAY_TIMES = "LiveFeedAutoPlayDelayTimes";
    public static final String SECONDARY_LIVE_PLUGIN_AUDIO_MD5 = "livePluginAudioMd5";
    public static final String SECONDARY_LIVE_PLUGIN_AUDIO_URL = "livePluginAudioUrl";
    public static final String SECONDARY_LIVE_PLUGIN_DOWNLOAD_AVAILABLE_SPACE = "livePluginDownloadAvailableSpace";
    public static final String SECONDARY_LIVE_PLUGIN_FILTER_BUNDLE_MD5 = "livePluginFilterBundleMd5";
    public static final String SECONDARY_LIVE_PLUGIN_FILTER_BUNDLE_URL = "livePluginFilterBundleUrl";
    public static final String SECONDARY_LIVE_PLUGIN_PITU_SEG_AND_HAND_DETECT_MD5 = "livePluginSegAndHandMd5";
    public static final String SECONDARY_LIVE_PLUGIN_PITU_SEG_AND_HAND_DETECT_URL = "livePluginSegAndHandUrl";
    public static final String SECONDARY_LIVE_PLUGIN_PTU_DM_MD5 = "livePluginPtuAlgoMd5";
    public static final String SECONDARY_LIVE_PLUGIN_PTU_DM_URL = "livePluginPtuAlgoUrl";
    public static final String SECONDARY_LIVE_UGC_PERMISSION_PAGE = "liveUgcPermissionPage";
    public static final String SECONDARY_LIVE_USE_QQ_PLUGIN_MANAGER = "useQQPluginManager";
    public static final String SECONDARY_LOCALPHOTO_CHECK_EXIF_MODE = "localPhotoCheckExifMode";
    public static final String SECONDARY_LOCALVIDEOPALYDATA_COUNT_LIMIT = "localVideoPlayDataCountLimit";
    public static final String SECONDARY_LOCAL_PHOTO_ACTIVE_SCAN_TIME_INTERVAL = "localPhotoActiveScanTimeInterval";
    public static final String SECONDARY_LOCAL_PHOTO_HEAD_REQUEST_QBOSS = "localPhotoHeadRequestQboss";
    public static final String SECONDARY_LOCAL_PHOTO_MAX_SCAN_COUNT_ONEDAY = "LocalPhotoMaxScanCountOneDay";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_BUTTON = "localPhotoNotificationDialogButton";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_TEXT = "localPhotoNotificationDialogText";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_TIME = "localPhotoNotificationDialogTime";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_TITLE = "localPhotoNotificationDialogTitle";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_URL = "localPhotoNotificationDialogUrl";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_BUTTON = "localPhotoNotificationGuideButton";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_TEXT = "localPhotoNotificationGuideText";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_TIME = "localPhotoNotificationGuideTime";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_TITLE = "localPhotoNotificationGuideTitle";
    public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_URL = "localPhotoNotificationGuideUrl";
    public static final String SECONDARY_LOCAL_PHOTO_SCAN_TIME_SPAN = "LocalPhotoScanPeriod";
    public static final String SECONDARY_LOCAL_PHOTO_SWITCHER_URL = "LocalPhotoSwitcherUrl";
    public static final String SECONDARY_LOCAL_PHOTO_VIDEO_MEMORY_OPEN_RECOMM_IMG_URL = "qzoneLocalPhotoVideoMemoryEmptyImgUrl";
    public static final String SECONDARY_LOCAL_PHOTO_VIDEO_MEMORY_SWITCH = "qzoneLocalPhotoVideoMemorySwitch";
    public static final String SECONDARY_LOCAL_PHOTO_VIDEO_MEMORY_TAKE_MORE_PHOTO_IMG_URL = "qzoneLocalPhotoVideoMemoryTakeMorePhotoImgUrl";
    public static final String SECONDARY_LOCATE_MINPOI_INTERVAL = "LBSPOIListFrequency";
    public static final String SECONDARY_LOCATE_MIN_DISTANCE = "LBSIsEqualDistance";
    public static final String SECONDARY_LOG_UPLOAD_OPT_IP_V6 = "OptimumIP_MobileLogV6";
    public static final String SECONDARY_LOVER_ZONE_URL = "bar_loversspace_schema";
    public static final String SECONDARY_MAKE_PHOTO_BLOG_FUNCTION_SWITCH = "ShouZhangBlogSwitch";
    public static final String SECONDARY_MAKE_PHOTO_BLOG_URL = "PhotoBlogUrl";
    public static final String SECONDARY_MAKE_VIDEO_ALBUM_MAX_PHOTO_NUM = "MakeVideoAlbumMaxPhoto";
    public static final String SECONDARY_MANAGEMENT_MAX_PHOTO_NUM = "ManagementMaxPhotoNum";
    public static final String SECONDARY_MANAGEMENT_MAX_VIDEO_NUM = "ManagementMaxVideoNum";
    public static final String SECONDARY_MAX_DOWNLOADING_VIDEO_COUNT = "maxDownloadingVideoCount";
    public static final String SECONDARY_MAX_HOURS_PHOTO_CREATE_GIF = "maxHoursPhotoCreateGif";
    public static final String SECONDARY_MAX_RANGE_NUMBER = "MiniAppMaxRangeNumber";
    public static final String SECONDARY_MAX_RECENT_PHOTO_NUM = "MaxRecentPhotoNum";
    public static final String SECONDARY_MAX_SPEED = "ListMaxSpeed";
    public static final String SECONDARY_MEDIA_PROCESS_NO_PROGRESS_TIMEOUT_DUATION = "MediaProcessNoProgressTimeoutDuation";
    public static final String SECONDARY_MEMOEY_CAN_ARCHIVE_INTERVAL = "memory_can_archive_interval";
    public static final String SECONDARY_MEMOEY_COVER_URL = "memory_cover_url";
    public static final String SECONDARY_MEMOEY_DIVIMAGE_URL = "memory_divimage_url";
    public static final String SECONDARY_MEMOEY_OPERATE_TIMES = "memory_operate_times";
    public static final String SECONDARY_MEMOEY_TEXT = "memory_defaul_text";
    public static final String SECONDARY_MEMOEY_TEXT_CONTENT = "memory_defaul_text_content";
    public static final String SECONDARY_MEMORY_COLD_TIME = "memory_cold_time";
    public static final String SECONDARY_MEMORY_SEAL = "MemorySeal";
    public static final String SECONDARY_MENTORSHIP_APNG_URL = "mentorship_apng_url";
    public static final String SECONDARY_MENTORSHIP_APNG_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png";
    public static final String SECONDARY_MENTORSHIP_NEWYEAR_APNG_URL = "mentorship_newyear_apng_url";
    public static final String SECONDARY_MENTORSHIP_NEWYEAR_APNG_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png";
    public static final String SECONDARY_MENTORSHIP_SVIP_APNG_URL = "mentorship_svip_apng_url";
    public static final String SECONDARY_MENTORSHIP_SVIP_APNG_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png";
    public static final String SECONDARY_MENTORSHIP_YELLOWVIP_APNG_URL = "mentorship_yellowvip_apng_url";
    public static final String SECONDARY_MENTORSHIP_YELLOWVIP_APNG_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png";
    public static final String SECONDARY_MIDDLE_PHONE_FRICITION = "MiddlePhoneFriction";
    public static final String SECONDARY_MINI_AIO = "mini_aio";
    public static final String SECONDARY_MINI_APP_DEX_CONFIG = "sdk_dex_config";
    public static final String SECONDARY_MINI_APP_DOMAIN_WHITE_LIST = "defaultAllowedHostList";
    public static final String SECONDARY_MINI_APP_DOWNLOAD_ON_RANGE_MODE = "MiniAppDownloadOnRangeMode";
    public static final String SECONDARY_MINI_APP_ENABLE_INSTRUCTIONS = "MiniAppEnableInstructions";
    public static final String SECONDARY_MINI_APP_FILE_STR = "MiniAppFileString";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_DOMAIN_BLACK_LIST = "ipv6_domain_black_list";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_DOMAIN_WHITE_LIST = "ipv6_domain_white_list";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_REFERER = "MiniAppIPv6OnlyForwardingReferer";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_URL = "ipv6_http_proxy_url";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_WNSCONFIG = "ipv6_proxy_enable";
    public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_WSS_URL = "ipv6_websocket_proxy_url";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_PHOTO_AND_VIDEO_COUNT = "MiniAppMoodMaxPhotoAndVideoCount";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_PHOTO_SIZE = "MiniAppMoodMaxSinglePhotoSize";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_VIDEO_DURATION = "MiniAppMoodMaxSingleVideoDuration";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_VIDEO_SIZE = "MiniAppMoodMaxSingleVideoSize";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_TEXT_COUNT = "MiniAppMoodMaxTextCount";
    public static final String SECONDARY_MINI_APP_MOOD_MAX_VIDEO_COUNT = "MiniAppMoodMaxVideoCount";
    public static final String SECONDARY_MINI_APP_MSF_TIMEOUT_VALUE = "MiniAppMsfTimeoutValue";
    public static final String SECONDARY_MINI_APP_NEWSDK_ENABLE = "newappsdkenable";
    public static final String SECONDARY_MINI_APP_OPENURL_FILTER = "MiniAppOpenUrlFilter";
    public static final String SECONDARY_MINI_APP_PIC_URL = "mini_app_default_pic_url";
    public static final String SECONDARY_MINI_APP_PIC_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20190717211007_vRwUiJr9lM.png";
    public static final String SECONDARY_MINI_APP_PRELOAD_APP_STORE_FROM_QZONE_NAVIGATOR_BAR = "preloadAppStoreFromQzoneNavigatorBar";
    public static final String SECONDARY_MINI_APP_RDM_DOMAIN_WHITE_LIST = "MiniAppRMDDomainWhiteList";
    public static final String SECONDARY_MINI_APP_WIKI_SCENE_CONFIG_MAP = "configSceneMap";
    public static final String SECONDARY_MINI_ENABLE_HOT_RELOAD = "MiniEnableHotReload";
    public static final String SECONDARY_MINI_GAME_APILOG_BLACKLIST = "MiniGameAPILogBlackList";
    public static final String SECONDARY_MINI_GAME_APILOG_WHITELIST = "MiniGameAPILogWhiteList";
    public static final String SECONDARY_MINI_GAME_BACK_PRESS_HINT = "MiniGameBackPressHint";
    public static final String SECONDARY_MINI_GAME_BACK_PRESS_HINT_LIST = "MiniGameBackPressHintList";
    public static final String SECONDARY_MINI_GAME_BANNER_AD_MIN_WIDTH = "MiniGameBannerAdMinWidth";
    public static final String SECONDARY_MINI_GAME_BASELIB = "MiniGameBaseLib";
    public static final String SECONDARY_MINI_GAME_BLACK_DETECT_INTERVAL = "MiniGameBlackDetectInterval";
    public static final String SECONDARY_MINI_GAME_BLACK_LIST = "MiniGameBlackList";
    public static final String SECONDARY_MINI_GAME_CACHE_FREE_DIALOG_CONTENT = "MiniGameCacheFreeDialogContent";
    public static final String SECONDARY_MINI_GAME_CODE_CACHE_ENABLE = "MiniGameCodeCacheEnable";
    public static final String SECONDARY_MINI_GAME_DEFAULT_PAY_SHARE_IMG = "MiniGameDefaultPayShareImg";
    public static final String SECONDARY_MINI_GAME_DEFAULT_PAY_SHARE_TITLE = "MiniGameDefaultPayShareTitle";
    public static final String SECONDARY_MINI_GAME_DEFAULT_SHARE_IMG = "MiniGameDefaultShareImg";
    public static final String SECONDARY_MINI_GAME_DEX_ENABLE = "MiniGameDexEnable";
    public static final String SECONDARY_MINI_GAME_DOMAIN_NEED_CHECK_PORT = "MiniGameDomainNeedCheckPort";
    public static final String SECONDARY_MINI_GAME_DOWNLOADER_MODE = "MiniGameDownloaderMode";
    public static final String SECONDARY_MINI_GAME_DOWNLOADER_PRE_CONNECT_HOST = "MiniGameDownloaderPreConnectHost";
    public static final String SECONDARY_MINI_GAME_ENABLE_DOWNLOADER_PRE_CONNECT = "MiniGameDownloaderPreConnectEnable";
    public static final String SECONDARY_MINI_GAME_ENABLE_HTTP2 = "MiniGameEnableHttp2";
    public static final String SECONDARY_MINI_GAME_ENABLE_OPENGLES3 = "enableOpengles3";
    public static final String SECONDARY_MINI_GAME_ENGINE_VERSION = "MiniGameEngineVersion";
    public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_BLACK = "MiniGameErrorDialogBlack";
    public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_CONTENT = "MiniGameErrorDialogContent";
    public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_ENABLE = "MiniGameErrorDialogEnable";
    public static final String SECONDARY_MINI_GAME_FAKE_FIRSTFRAME_URL = "MiniGameFakeFirstFrameUrl";
    public static final String SECONDARY_MINI_GAME_FRAME_NO_CHANGE_LIMIT = "MiniGameFrameNoChangeLimit";
    public static final String SECONDARY_MINI_GAME_GARY_RANGE = "MiniGameGaryRange";
    public static final String SECONDARY_MINI_GAME_JS_ERROR_DETECT_INTERVAL = "MiniGameJsErrorDetectInterval";
    public static final String SECONDARY_MINI_GAME_KILL_ALL_GAMES_WHEN_DESTROY = "MiniGameKillAllGamesWhenDestroy";
    public static final String SECONDARY_MINI_GAME_KILL_ALL_GAMES_WHEN_REUSE = "MiniGameKillAllGamesWhenReuse";
    public static final String SECONDARY_MINI_GAME_KILL_OTHER_GAMES_ON_START = "MiniGameKillOtherGamesOnStart";
    public static final String SECONDARY_MINI_GAME_LAUNCH_FAIL_DIALOG_CONTENT = "MiniGameLaunchFailDialogContent";
    public static final String SECONDARY_MINI_GAME_LOG_ENABLE = "MiniGameLogEnable";
    public static final String SECONDARY_MINI_GAME_MIN_SYS_VERSION = "MiniGameMinSysVersion";
    public static final String SECONDARY_MINI_GAME_NEWSDK_ENABLE = "newsdkenable";
    public static final String SECONDARY_MINI_GAME_NO_PRESENT_DURATION_LIMIT = "MiniGameNoPresentDurationLimit";
    public static final String SECONDARY_MINI_GAME_NO_PRESENT_TOUCH_LIMIT = "MiniGameNoPresentTouchLimit";
    public static final String SECONDARY_MINI_GAME_ONSHOW_REPORT_INTERVAL = "MiniGameOnShowReportInterval";
    public static final String SECONDARY_MINI_GAME_PAY_FOR_FRIEND_URL = "MiniGameDefaultPayForFriendUrl";
    public static final String SECONDARY_MINI_GAME_PERSISTENT_DEBUG_VERSION_ENABLE = "MiniGamePersistentDebugVersionEnable";
    public static final String SECONDARY_MINI_GAME_PRECONNECT_METHOD = "MiniGameDefaultPreconnectMethod";
    public static final String SECONDARY_MINI_GAME_PRECONNECT_TIME_INTERVAL = "MiniGameDefaultPreconnectTimeInterval";
    public static final String SECONDARY_MINI_GAME_PRELOAD_BASELIB_ENABLE = "MiniGamePreloadBaseLibEnable";
    public static final String SECONDARY_MINI_GAME_PRESENT_DETECT_INTERVAL = "MiniGamePresentDetectInterval";
    public static final String SECONDARY_MINI_GAME_PRE_CONNECT_BLACK_APPID_LIST = "MiniGamePreConnectBlackAppIdList";
    public static final String SECONDARY_MINI_GAME_PRE_CONNECT_NUM = "MiniGamePreConnectNum";
    public static final String SECONDARY_MINI_GAME_RUNTIME_PRELOAD = "MiniGameRuntimePreload";
    public static final String SECONDARY_MINI_GAME_RUNTIME_PRELOAD_ON_FIRST_FRAME = "MiniGameRuntimePreloadOnFirstFrame";
    public static final String SECONDARY_MINI_GAME_STORAGE_EXCEED_DIALOG_ENABLE = "MiniGameStorageExceedDialogEnable";
    public static final String SECONDARY_MINI_GAME_STORAGE_EXCEED_LIMIT = "MiniGameStorageExceedLimit";
    public static final String SECONDARY_MINI_GAME_SUBPACK_RETRY_ON_COMPILE_COUNT = "MiniGameSubPackRetryOnCompileCount";
    public static final String SECONDARY_MINI_GAME_TRITON_BACKUP_URL = "MiniGameTritonBackupUrl";
    public static final String SECONDARY_MINI_LOADING_AD_APP_AUTO_DOWNLOAD = "launch_adv_app_auto_download";
    public static final String SECONDARY_MINI_LOADING_AD_DURATION_TIME = "launch_adv_duration";
    public static final String SECONDARY_MINI_LOADING_AD_EXTRA_PRELOAD_INTERVAL = "launch_adv_app_preload_interval";
    public static final String SECONDARY_MINI_LOADING_AD_EXTRA_PULL_PRELOAD_INTERVAL = "launch_adv_app_pull_preload_interval";
    public static final String SECONDARY_MINI_LOADING_AD_PRELOAD_LIMIT = "launch_adv_app_preload_limit";
    public static final String SECONDARY_MINI_LOADING_AD_PRELOAD_LIMIT_FOR_UIN = "launch_adv_user_preload_limit";
    public static final String SECONDARY_MINI_LOADING_AD_SELECT_LIMIT = "launch_adv_app_select_limit";
    public static final String SECONDARY_MINI_LOADING_AD_SELECT_LIMIT_FOR_UIN = "launch_adv_user_select_limit";
    public static final String SECONDARY_MINI_LOADING_AD_SKIP_TIME = "launch_adv_skip_time";
    public static final String SECONDARY_MINI_OPENDATA_DOMAIN_WHITE_LIST = "opendatahosts";
    public static final String SECONDARY_MINI_RECORD_DURATION_INTERVAL = "MiniRecordDurationInterval";
    public static final String SECONDARY_MINI_REPORT_DELAY_CHECK_DB = "MiniReportDelayCheckDB";
    public static final String SECONDARY_MINI_REPORT_DELAY_WAITING = "MiniReportDelayWaiting";
    public static final String SECONDARY_MINI_SHOW_TIMEOUT = "MiniShowTimeout";
    public static final String SECONDARY_MIN_AVAILABLE_RAM = "MinAvailableRam";
    public static final String SECONDARY_MIN_CPU = "MinCpu";
    public static final String SECONDARY_MIN_RAM = "MinRam";
    public static final String SECONDARY_MIN_RUNTIME_RAM = "MinRuntimeRam";
    public static final String SECONDARY_MIN_SDK = "MinSdkVersion";
    public static final String SECONDARY_MIN_SDK_TRIM_HW = "MinSdkVersionHw";
    public static final String SECONDARY_ML_EXPOSED_MEDIA_UPPER_BOUND = "MachineLearningExposedMediaUpperBound";
    public static final String SECONDARY_MOODLIST_BANNER_SHOW_RATIO = "MoodListShowRatio";
    public static final String SECONDARY_MOOD_EDIT = "MoodEdit";
    public static final String SECONDARY_MOOD_PHOTO_MAX_NUM = "MoodPhotoMaxNum";
    public static final String SECONDARY_MOOD_RECENT_GIF_MAX_SIZE = "MoodRecentGifMaxSize";
    public static final String SECONDARY_MOOD_RECENT_NEW_PHOTO_TIME = "MoodRecentNewPhotoTime";
    public static final String SECONDARY_MOOD_RECENT_PHOTO_COUNT = "MoodRecentPhotoCount";
    public static final String SECONDARY_MOOD_RECENT_PHOTO_TIME = "MoodRecentPhotoTime";
    public static final String SECONDARY_MOOD_RECENT_VIDEO_SIZE = "MoodRecentVideoSize";
    public static final String SECONDARY_MOOD_RECENT_VIDEO_TIME = "MoodRecentVideoTime";
    public static final String SECONDARY_MOOD_SCHEDULE_DELETE_VIDEO = "MoodScheduleDeleteVideo";
    public static final String SECONDARY_MOOD_SCHEDULE_PUBLISH_VIDEO = "MoodSchedulePublishVideo";
    public static final String SECONDARY_MOOD_WEB_PICTURE_ADD_MORE = "MoodWebPictureAddMore";
    public static final String SECONDARY_MSG_LIST_URL = "MsgListUrl";
    public static final String SECONDARY_MUSIC_COVER_PREVIEW = "MusicCoverPreview";
    public static final String SECONDARY_MUSIC_DETAIL_PAGE_FOR_QZVIP_MANAGER_URL = "BgMusicDetailForQzVipManagerUrl";
    public static final String SECONDARY_MUSIC_PLAY_DETAIL_URL = "MusicPlayDetailUrl";
    public static final String SECONDARY_NAMEPLATE_URL = "NameplateMainPageAddr";
    public static final String SECONDARY_NAME_PLAYER_PREVIEW = "PlayerPreview";
    public static final String SECONDARY_NAME_PLAYER_PREVIEW_DEFAULT = "https://h5.qzone.qq.com/playerStore/index?_wv=1027&router=home&appid=113&itemid={itemid}";
    public static final String SECONDARY_NAME_PLAYER_STORE = "PlayerStore";
    public static final String SECONDARY_NAME_PLAYER_STORE_DEFAULT = "https://h5.qzone.qq.com/playerStore/index?_wv=1027&router=home&appid=113";
    public static final String SECONDARY_NAME_RESUME_FRAGMENT = "resumedFragement";
    public static final String SECONDARY_NATIVE_HOOK = "NativeHook";
    public static final String SECONDARY_NATIVE_HOOK_SDK = "NativeHookSDK";
    public static final String SECONDARY_NAVIGATORBAR_ITEMATTRIBUTE = "ItemAttribute";
    public static final String SECONDARY_NAVIGATORBAR_ITEMCOUNT = "ItemCount";
    public static final String SECONDARY_NAVIGATORBAR_ITEMDOWNURLPREFIX = "ItemDownURLPrefix";
    public static final String SECONDARY_NAVIGATORBAR_ITEMORDER = "ItemOrder";
    public static final String SECONDARY_NEED_BACK_FEED_INTERVAL = "SchemaNeedBackFeedInternal";
    public static final String SECONDARY_NEED_DECODE = "RichTextNeedDecode";
    public static final String SECONDARY_NEED_DRAWABLE_RECYCLED = "NeedDrawableRecycled";
    public static final String SECONDARY_NEED_LOCAL_BLACK_LIST = "NeedLocalBlackList";
    public static final String SECONDARY_NEED_SYNC_TO_WEISHI = "ShowMoodSyncWeishiButton";
    public static final String SECONDARY_NEWTYPE_UPLOAD_MOBILE_LOG_HOST = "PhotoURL4";
    public static final String SECONDARY_NEW_ALBUM_CHOOSE_ORDER = "NewAlbumChooseOrder";
    public static final String SECONDARY_NEW_ALBUM_SHOW_SETTINGS = "NewAlbumShowSettings";
    public static final String SECONDARY_NEW_CARD_PREVIEW = "NewCardPreview";
    public static final String SECONDARY_NEW_CARD_PREVIEW_URL = "NewCardPreviewUrl";
    public static final String SECONDARY_NEW_CARD_STORE = "NewCardStore";
    public static final String SECONDARY_NEW_CARD_STORE_CARD_PIC_URL = "newCardStoreCardPicUrl";
    public static final String SECONDARY_NEW_ENTRY_RED_DOT_SWITCH = "AlbumNewEntryRedDotSwitch";
    public static final String SECONDARY_NICKNAME_FLASH = "NickNameFlash";
    public static final String SECONDARY_NOT_LOCATE_FROM_PROFLIE = "notlocate_from_profile";
    public static final String SECONDARY_NOT_SHOWKAPU_FROM_PROFLIE = "notshowkapu_from_profile";
    public static final String SECONDARY_ONLINE_LOACL_SAVE_FREQUENCY = "OnlineLocalSaveFrequency";
    public static final String SECONDARY_ONLINE_REPORT_FREQUENCY = "OnlineReportFrequency";
    public static final String SECONDARY_ONLINE_REPORT_INTEVAL = "OnlineReportInterval";
    public static final String SECONDARY_OPEN_ORIGINAL_UPLOAD = "OpenOriginalUpload";
    public static final String SECONDARY_OPEN_THEME_PANEL_WHEN_CREAT_ALBUM_SETTING = "openThemePanelWhenCreateAlbum";
    public static final String SECONDARY_OTHER_UPLOAD_BAK_IP = "BackupIP_OTHERUP";
    public static final String SECONDARY_OTHER_UPLOAD_HOST_IP = "OtherURL_UP";
    public static final String SECONDARY_OTHER_UPLOAD_OPT_IP = "OptimumIP_OTHERUP";
    public static final String SECONDARY_OTHER_UPLOAD_OPT_IP_V6 = "OptimumIP_OTHERUP_V6";
    public static final String SECONDARY_OUTBOX_MAX_RETRY_COUNT_PER_PERIOD = "ReConnCount";
    public static final String SECONDARY_OUTBOX_MAX_RETRY_TIMEOUT = "RetryTime";
    public static final String SECONDARY_OUTBOX_NEXT_INTERVAL = "RetryInterval";
    public static final String SECONDARY_PANORAMA_PHOTO_CHECK = "paranoramaOpenCheck";
    public static final String SECONDARY_PARTICLE_EFFECT = "particle_effect";
    public static final String SECONDARY_PARTICLE_EFFECT_BEST_PERFORM_BLACKLIST = "ParticleEffectBestPerformBlacklist";
    public static final String SECONDARY_PARTICLE_EFFECT_BEST_PERFORM_BLACKLIST_DEFUALT = "";
    public static final String SECONDARY_PARTICLE_EFFECT_BLACKLIST = "ParticleEffectBlacklist";
    public static final String SECONDARY_PARTICLE_EFFECT_BLACKLIST_DEFUALT = "";
    public static final int SECONDARY_PARTICLE_EFFECT_DEFAULT = 1;
    public static final String SECONDARY_PASSIVEFEED_ALERT_BUBBLE = "passiveBannerSwitch";
    public static final String SECONDARY_PASSIVEFEED_TAB_NAME = "passiveText";
    public static final String SECONDARY_PASSIVE_PRAISSE_PAGE = "PassivePraisePreview";
    public static final String SECONDARY_PASTER_BLACK_LIST = "PasterBlackList";
    public static final String SECONDARY_PASTER_ENABLE_PERFORMANCE_TEST = "PasterEnablePerformanceTest";
    public static final String SECONDARY_PASTER_STANDARD_CPU_CORE = "PasterStandardCpuCore";
    public static final String SECONDARY_PASTER_STANDARD_CPU_FREQUENCY = "PasterStandardCpuFrequency";
    public static final String SECONDARY_PASTER_STANDARD_RAM_SIZE = "PasterStandardRamSize";
    public static final String SECONDARY_PASTER_WHITE_LIST = "PasterWhiteList";
    public static final String SECONDARY_PERMISSION_PAGE = "SeeMyQzonePermissionSetting";
    public static final String SECONDARY_PERMMIT_PRE_DOWNLOAD_VIDEO = "PermitPreDownload";
    public static final String SECONDARY_PERSONALIZE_MAINPAGE = "PersonalizeMainPage";
    public static final String SECONDARY_PER_EXPORT_WHEN_EDIT_FINISH_QCIRCLE_PUBLISH = "PerExportWhenEditFinish_QCirclePublish";
    public static final String SECONDARY_PHOTOGUIDE_EXPOSEPHOTOMINCOUNT = "ExposePhotoMinCount";
    public static final String SECONDARY_PHOTOGUIDE_EXPOSEPHOTOTIMERANGE = "ExposePhotoTimeRange";
    public static final String SECONDARY_PHOTOGUIDE_GUIDESHOWOPEN = "GuideShowOpen";
    public static final String SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_CHANGE_STRATEGY = "PhotoUploadPhotoChangeStrategy";
    public static final String SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_MAX_SIZE = "PhotoUploadPhotoMaxSize";
    public static final String SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_MIN_SIZE = "PhotoUploadPhotoMinSize";
    public static final String SECONDARY_PHOTOGUIDE_QQ_EXPOSEPHOTOTIMERANGE = "PhotoUploadGuideScanTimeInterval";
    public static final String SECONDARY_PHOTOGUIDE_QQ_REDPOINTTIMEINTERVAL = "PhotoUploadRedPointTimeInterval";
    public static final String SECONDARY_PHOTOGUIDE_SENDRED_JUMPTOQZONE = "GuideSelectPhotoSendRedJumpToQzone";
    public static final String SECONDARY_PHOTOVIEW_BACK_TO_BACKGROUND = "backTobackground";
    public static final String SECONDARY_PHOTOVIEW_BACK_TO_BACKGROUND_PHOTO_BYTES = "backTobackgroundPhotoBytes";
    public static final String SECONDARY_PHOTOVIEW_BACK_TO_BACKGROUND_VIDEO_BYTES = "backTobackgroundVideoBytes";
    public static final String SECONDARY_PHOTOVIEW_CAN_SHOW_DELETE_BUTTON = "showDeleteButton";
    public static final String SECONDARY_PHOTOVIEW_CAN_SHOW_FACE_BUTTON = "showFaceButton";
    public static final String SECONDARY_PHOTOVIEW_CAN_SHOW_OCR_BUTTON = "PhotoViewShowOcrButton";
    public static final String SECONDARY_PHOTOVIEW_CAN_SHOW_PITU_BUTTON = "PhotoViewShowPituButton";
    public static final String SECONDARY_PHOTOVIEW_RESTRICT_BEGIN = "RestrictBeginTime";
    public static final String SECONDARY_PHOTOVIEW_RESTRICT_END = "RestrictEndTime";
    public static final String SECONDARY_PHOTOVIEW_RESTRICT_FLAG = "RestrictFlag";
    public static final String SECONDARY_PHOTOVIEW_SHOWOPDELAY = "ShowOPDelay";
    public static final String SECONDARY_PHOTOVIEW_SHOW_LOADING_DELAY = "DelayShowLoading";
    public static final String SECONDARY_PHOTO_ALBUM_PHOTO_NUM_TIPS = "PhotoAlbumPhotoNumTips";
    public static final String SECONDARY_PHOTO_ALBUM_PHOTO_NUM_TIPS_FLAG = "PhotoAlbumPhotoNumTipsFlag";
    public static final String SECONDARY_PHOTO_ANALYSE = "PhotoAnalyse";
    public static final String SECONDARY_PHOTO_BANNAER_OPTI_SWITCHER = "secondary_photo_bannaer_opti_switcher";
    public static final String SECONDARY_PHOTO_BEAUTY_MODEL = "PhotoBeautyModel";
    public static final String SECONDARY_PHOTO_BEAUTY_PHONE_MODEL = "PhotoBeautyPhoneModel";
    public static final String SECONDARY_PHOTO_BEAUTY_PHONE_SIZE = "PhotoBeautyPhoneSize";
    public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_SCROLL_SHOWTIME = "ExposePhotoBubbleScrollShowTime";
    public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_SHOWTIME = "ExposePhotoBubbleShowTime";
    public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_TIMERANGE = "ExposePhotoBubbleTimeRange";
    public static final String SECONDARY_PHOTO_CATEGORY_LIST_HEADER_TIPS = "PhotoCategoryListHeaderTips";
    public static final String SECONDARY_PHOTO_CATEGORY_SCANNER_FRONT_BLACKLIST = "PhotoCategoryScannerFrontCamBlackList";
    public static final String SECONDARY_PHOTO_CREATE_BEAUTY_SO = "PhotoGuideCreateBeautySo";
    public static final String SECONDARY_PHOTO_CREATE_BEAUTY_SO_LENGTH = "PhotoGuideCreateBeautySoLength";
    public static final String SECONDARY_PHOTO_CREATE_BEAUTY_SO_MD5 = "PhotoGuideCreateBeautySoMD5";
    public static final String SECONDARY_PHOTO_CREATE_GIF_NEED_PEOPLE = "PhotoGuideCreateGifNeedPeople";
    public static final String SECONDARY_PHOTO_CREATE_GIF_SO = "PhotoGuideCreateGifSo";
    public static final String SECONDARY_PHOTO_CREATE_GIF_SO_64 = "PhotoGuideCreateGifSo64";
    public static final String SECONDARY_PHOTO_CREATE_GIF_SO_LENGTH = "PhotoGuideCreateGifSoLength";
    public static final String SECONDARY_PHOTO_CREATE_GIF_SO_LENGTH_64 = "PhotoGuideCreateGifSoLength64";
    public static final String SECONDARY_PHOTO_CREATE_GIF_SO_MD5 = "PhotoGuideCreateGifSoMD5";
    public static final String SECONDARY_PHOTO_CREATE_GIF_SO_MD5_64 = "PhotoGuideCreateGifSoMD564";
    public static final String SECONDARY_PHOTO_CREATE_OPENCV_SO_LENGTH = "PhotoGuideCreateOpenSoLength";
    public static final String SECONDARY_PHOTO_DOWNLOAD_KEEP_ALIVE = "KeepAlive";
    public static final String SECONDARY_PHOTO_DOWNLOAD_KEEP_ALIVE_PROXY = "KeepAliveProxy";
    public static final String SECONDARY_PHOTO_GROUP_CARD_LIST_USE_THEME_COLOR = "PhotoGroupCardListUseThemeColor";
    public static final String SECONDARY_PHOTO_GROUP_LIST_IMAGE_CROP_SPACE_RATIO = "photoGroupListImageCropSpaceRatio";
    public static final String SECONDARY_PHOTO_GUIDE_ENABLE_PHOTO_MARKER = "PhotoGuideEventEnableMarker";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_ALL_ENABLE = "PhotoGuideEventAllEnable";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_MIN_FILE_LENGTH = "PhotoGuideEventChatCacheMinFileLength";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_QQ_CACHE_ICON_URL = "PhotoGuideEventChatCachePhotoQQCacheIconUrl";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_QQ_CACHE_PATH = "PhotoGuideEventChatCachePhotoQQCachePath";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_SWITCH = "PhotoGuideEventCacheSwitch";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_WX_CACHE_ICON_URL = "PhotoGuideEventChatCachePhotoWXCacheIconUrl";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_WX_CACHE_PATH = "PhotoGuideEventChatCachePhotoWXCachePath";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHECK_INTERVAL_TIME = "PhotoGuideEventUploadCheckIntervalTime";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_FESTIVAL_ENABLE = "PhotoGuideEventFestivalEnable";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_IS_SHOW_SCENE_POINT = "PhotoGuideEventShowScenePoint";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_MIN_UNEXPOSURE_PHOTOS = "PhotoGuideEventUnexposureMinPhotos";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_MIN_UN_UPLOAD_NUM = "PhotoRecommendMinUnUploadNum";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_NNJR_ENABLE = "PhotoGuideEventNnjrEnable";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_START_HOUR = "PhotoGuideEventStartHour";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_VIDEOALBUM_ENABLE = "PhotoGuideEventVideoAlbumEnable";
    public static final String SECONDARY_PHOTO_GUIDE_EVENT_WIFFI_MAX_DAYS = "PhotoGuideEventWiffMaxDay";
    public static final String SECONDARY_PHOTO_GUIDE_VERSION_STRING = "PhotoGuideEventVersionString";
    public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_LENGTH = "PhotoGuideLibCShareSoLength";
    public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_LENGTH_64 = "PhotoGuideLibCShareSoLength64";
    public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_MD5 = "PhotoGuideLibCShareSoMD5";
    public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_MD5_64 = "PhotoGuideLibCShareSoMD564";
    public static final String SECONDARY_PHOTO_LIST_VISIBLE_STATISTIC = "photoListVisibleStatistic";
    public static final String SECONDARY_PHOTO_LIST_VISIBLE_TIME_LIMIT = "photoListVisibleTimeLimit";
    public static final String SECONDARY_PHOTO_QULATITY_SO = "PhotoGuidePictureQulatitySo";
    public static final String SECONDARY_PHOTO_QULATITY_SO_64 = "PhotoGuidePictureQulatitySo64";
    public static final String SECONDARY_PHOTO_QULATITY_SO_LENGTH = "PhotoGuidePictureQulatitySoLength";
    public static final String SECONDARY_PHOTO_QULATITY_SO_LENGTH_64 = "PhotoGuidePictureQulatitySoLength64";
    public static final String SECONDARY_PHOTO_QULATITY_SO_MD5 = "PhotoGuidePictureQulatitySoMD5";
    public static final String SECONDARY_PHOTO_QULATITY_SO_MD5_64 = "PhotoGuidePictureQulatitySoMD564";
    public static final String SECONDARY_PHOTO_QZONE_VISION_SO_LENGTH = "PhotoGuideQzoneVisionSoLength";
    public static final String SECONDARY_PHOTO_QZONE_VISION_SO_LENGTH_64 = "PhotoGuideQzoneVisionSoLength64";
    public static final String SECONDARY_PHOTO_QZONE_VISION_SO_MD5 = "PhotoGuideQzoneVisionSoMD5";
    public static final String SECONDARY_PHOTO_RECYCLE = "PhotoRecycle";
    public static final String SECONDARY_PHOTO_SET_COVER = "photoBrowserSetCover";
    public static final String SECONDARY_PHOTO_TRAFFIC_THRESHOLD = "RemindUploadSizeIsLargeThreshold";
    public static final String SECONDARY_PHOTO_UPLOADRATE_SWITCH = "PhotoUpLoadRateSwitch";
    public static final String SECONDARY_PHOTO_UPLOAD_ALL_PIC_QUALITY = "MoodUploadQuality";
    public static final String SECONDARY_PHOTO_UPLOAD_AUTO_2G = "Auto2G";
    public static final String SECONDARY_PHOTO_UPLOAD_AUTO_3G = "Auto3G";
    public static final String SECONDARY_PHOTO_UPLOAD_AUTO_WIFI = "AutoWiFi";
    public static final String SECONDARY_PHOTO_UPLOAD_LOW_DEVICE = "LowDeviceWhite";
    public static final String SECONDARY_PHOTO_UPLOAD_MIDDLE_DEVICE = "MiddleDeviceWhite";
    public static final String SECONDARY_PHOTO_UPLOAD_QCIRCLE_PIC_QUALITY = "MoodUploadQualityForPicQcircle";
    public static final String SECONDARY_PHOTO_UPLOAD_QCIRCLE_VIDEO_QUALITY = "MoodUploadQualityForVideoQcircle";
    public static final String SECONDARY_PHOTO_UPLOAD_QUALITY = "UploadQuality";
    public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH = "QualityHigh";
    public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH_WEBP = "WebPQualityHigh";
    public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_LOW = "QualityLow";
    public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_LOW_WEBP = "WebPQualityLow";
    public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_MID = "QualityMid";
    public static final String SECONDARY_PHOTO_UPLOAD_RESOLUTION_HIGH = "ResolutionHigh";
    public static final String SECONDARY_PHOTO_UPLOAD_RESOLUTION_LOW = "ResolutionLow";
    public static final String SECONDARY_PHOTO_UPLOAD_TIER_1_MAX_NUM = "Tier1MaxNum";
    public static final String SECONDARY_PHOTO_UPLOAD_TIER_2_MAX_NUM = "Tier2MaxNum";
    public static final String SECONDARY_PHOTO_UPLOAD_TIER_3_MAX_NUM = "Tier3MaxNum";
    public static final String SECONDARY_PHOTO_USE_LOCAL_QUALITY = "UseLocalQuality";
    public static final String SECONDARY_PHOTO_USE_LOCAL_QUALITY_FOR_SHUOSHUO = "UseLocalQualityForShuoShuo";
    public static final String SECONDARY_PHOTO_WALL_URL = "PhotoWallUrl";
    public static final String SECONDARY_PICK_GAME_MATES = "PickGameMates";
    public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_BLACK_LIST = "PictureViewerPhotoDanmakuBlackList";
    public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_CPU_LEVEL = "PictureViewerPhotoDanmakuCpuLevel";
    public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH = "PictureViewerPhotoDanmakuDefaultSwitch";
    public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_GARY_RANGE = "PictureViewerPhotoDanmakuGaryRange";
    public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_MEMORY_LEVEL = "PictureViewerPhotoDanmakuMemoryLevel";
    public static final String SECONDARY_PICTURE_VIEWER_DOUBLE_TAP_SCALE = "pictureViewerDoubleTapScale";
    public static final String SECONDARY_PICTURE_VIEWER_MAX_SCALE = "pictureViewerMaxScale";
    public static final String SECONDARY_PICTURE_VIEWER_NICK_MAX_LENGTH = "PictureViewerNickMaxLength";
    public static final String SECONDARY_PICTURE_VIEWER_PHOTO_LIST_LOADMORE_COUNT = "pictureViewerPhotoListLoadMoreCount";
    public static final String SECONDARY_PICTURE_VIEWER_PIC_INFO_URL = "PictureViewerPicInfoUrl";
    public static final String SECONDARY_PICTURE_VIEWER_SHOW_PIC_INFO = "PictureViewerShowPicInfo";
    public static final String SECONDARY_PICTURE_VIEWER_SHOW_SHARE_BUTTONS = "pictureViewerShowShareButtons";
    public static final String SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITHOUT_PAGENUM = "PictureViewerTitleMaxLengthWithoutPageNum";
    public static final String SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITH_PAGENUM = "PictureViewerTitleMaxLengthWithPageNum";
    public static final String SECONDARY_PIC_HEIGHT_RATE = "Pic_height_Rate";
    public static final String SECONDARY_PIC_MAX_SIZE_CM = "Pic_MaxSize_CM";
    public static final String SECONDARY_PIC_WIDTH_RATE = "Pic_Width_Rate";
    public static final String SECONDARY_PLUGIN_ERROR_HANDLE_COUNT = "PluginErrorHandleCount";
    public static final String SECONDARY_PLUGIN_INSTALL_TIMEOUT = "PluginInstallTimeout";
    public static final String SECONDARY_PLUGIN_PERMISSION_ERROR_HANDLE = "PluginPermissionErrorHandle";
    public static final String SECONDARY_PLUGIN_RETRY_DOWNLOADSO_TIMES = "PluginRetryDownloadSoTimes";
    public static final String SECONDARY_PLUGIN_RETRY_DOWNLOAD_TIMES = "PluginRetryDownloadTimes";
    public static final String SECONDARY_POI_CACHE_DISTANCE = "POICacheDistance";
    public static final String SECONDARY_POI_CACHE_TIME = "POICacheTime";
    public static final String SECONDARY_POLY_MEM_LEVEL = "hardwareRestrictionMemory";
    public static final String SECONDARY_POLY_PRELOAD_TIME = "polymorphicPraisePreloadTime";
    public static final String SECONDARY_PRELOAD_ACTIVEFEEDS = "PreLoadActiveFeeds";
    public static final String SECONDARY_PRELOAD_CUSTOM_RESOURCES_INTERVAL_SECONDS = "PreloadCustomResourcesIntervals";
    public static final String SECONDARY_PRELOAD_FACADE = "preLoadFacade";
    public static final String SECONDARY_PRELOAD_GROUPFEEDS = "PreLoadGroupFeeds";
    public static final String SECONDARY_PRELOAD_HTML_PAGE_URL_MAX_COUNT = "PreloadHtmlPageUrlMaxCount";
    public static final String SECONDARY_PRELOAD_PEAK_DURATION = "preloadPeakDuration";
    public static final long SECONDARY_PRELOAD_PEAK_DURATION_DEFAULT = 180000;
    public static final String SECONDARY_PRELOAD_QZONE_PROCESS_ENABLE = "PreloadQzoneProcessEnable";
    public static final String SECONDARY_PRELOAD_QZONE_PROCESS_RAM_THRESHOLD = "PreloadQzoneProcessRamThreshold";
    public static final String SECONDARY_PRELOAD_SMALL_GAME_ALLOW_HOURS = "PreloadSmallGameAllowHourTimes";
    public static final String SECONDARY_PRELOAD_SMALL_GAME_HTML_ENABLE = "PreloadSmallGameHtmlEnable";
    public static final String SECONDARY_PRELOAD_SMALL_GAME_INTERVAL_SECONDS = "PreloadSmallGameIntervals";
    public static final String SECONDARY_PUBLISH_QUEUE_LEAVE_WIFI_CHECK_SIZE = "LeaveWifiCheckSize";
    public static final String SECONDARY_PUBLISH_QUEUE_MAX_PARALLEL_TASK_COUNT = "MaxParallelTaskCount";
    public static final String SECONDARY_PUBLISH_QUEUE_RECONNECTION_DAYS = "ReconnectionDays";
    public static final String SECONDARY_PUBLISH_QUEUE_RECONNECTION_TIMES = "ReconnectionTimes";
    public static final String SECONDARY_PUBLISH_QUEUE_SAFETY_STRIKE_CODE = "SafetyStrikeCode";
    public static final String SECONDARY_PUBLISH_QUEUE_SAFETY_STRIKE_MESSAGE = "SafetyStrikeMessage";
    public static final String SECONDARY_PUBLISH_SECRET_SHUOSHUO_H5_URL = "PublishSecretShuoshuoH5Url";
    public static final String SECONDARY_PUBLISH_SHAI_SHAI_HASHTAG_ENABLE = "PublishShaiHashtagEnable";
    public static final String SECONDARY_PULL_QBOSS_DIALOG_TIME = "detailDialogShowTime";
    public static final String SECONDARY_PUSHBANNER_ACTIVEMAXCOUN = "FeedBannerActiveMaxCount";
    public static final String SECONDARY_PUSHBANNER_DURATION = "FeedBannerDuration";
    public static final String SECONDARY_PUSH_DEDUPLICATION = "PushDeduplication";
    public static final String SECONDARY_P_CAMERA_DATOU_URL = "PCameraDatou";
    public static final String SECONDARY_QBOSS_APPID_CUSTOM_RESOURCES_INFO = "PreloadCustomResourcesQbossAppid";
    public static final String SECONDARY_QCIRCLE_EDIT_VIDEO_TIME_OUT = "QcircleEditVideoTimeout";
    public static final String SECONDARY_QCIRCLE_GROUP_AIO_REDPOINT_ICON_URL = "qqcircle_group_aio_icon_url";
    public static final String SECONDARY_QCIRCLE_VIDEO_COMPRESS_PARAM_ALL = "QcircleVideoNewVideoCompressParamAll";
    public static final String SECONDARY_QCIRCLR_ATUSER_MAX = "QCircleFriendMaxSelectCountComment";
    public static final String SECONDARY_QFLUTTER_URL = "tissue_qflutter_url";
    public static final String SECONDARY_QMUSIC_HLS_MAX_RETRY_TIMES = "QmusicHlsMaxRetryTimes";
    public static final String SECONDARY_QQCIRCLE_DISABLE_MAGIC_STUDIO_DOWNLOAD = "qqcircle_disable_magic_studio_download";
    public static final String SECONDARY_QQCIRCLE_DISABLE_MAGIC_STUDIO_EDITOR_OPTIMIZATION = "qqcircle_disable_magic_studio_optimization";
    public static final String SECONDARY_QQCIRCLE_NEW_GUIDE_ON_DYNAMIC_ENTRANCE = "qqcircle_new_guide_on_dynamic_entrance";
    public static final String SECONDARY_QQCIRCLE_NEW_GUIDE_ON_DYNAMIC_TAB = "qqcircle_new_guide_on_dynamic_tab";
    public static final String SECONDARY_QQCIRCLE_NEW_GUIDE_ON_MESSAGE_ENTRANCE = "qqcircle_new_guide_on_message_entrance";
    public static final String SECONDARY_QQCIRCLE_SHOW_BOTTOM_TAB_SWITCH = "qqcircle_show_bottom_tab_switch";
    public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_AIO_FEED = "qqcircle_show_entrance_on_aio_feed";
    public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_MAIN_TAB = "qqcircle_show_entrance_on_main_tab";
    public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_MAIN_TAB_CHILDREN_MODE = "qqcircle_show_entrance_on_main_tab_on_children_mode";
    public static final String SECONDARY_QQCIRCLE_SHOW_GROUP_AIO_REDPOINT = "qqcircle_show_group_aio_redpoint";
    public static final String SECONDARY_QQCIRCLE_SHOW_HIGH_QUALITY_IMAGE_PREVIEW = "qqcircle_show_high_quality_image_preview";
    public static final String SECONDARY_QQCIRCLE_VIDEO_MUSIC_URL = "aeeditor_edited_music_url";
    public static final String SECONDARY_QQCIRCLE_VIDEO_MUSIC_USE_WNS_URL = "aeeditor_edited_use_wns_music_url";
    public static final String SECONDARY_QQCIRCLE_WINK_FRAME_STICKER_THRESHOLD = "border_sticker_enabled_ratio_threshold";
    public static final String SECONDARY_QQCIRCLE_WINK_LIMIT_VIDEO_RESOLUTION = "qqcircle_wink_editor_limit_video_resolution";
    public static final String SECONDARY_QQCIRCLE_WINK_PRELOADWEB_LOWDEVICE = "qqcircle_wink_preloadweb_lowdevice";
    public static final String SECONDARY_QQCIRCLE_WINK_SELECT_MAX_RATIO = "qqcircle_new_publish_max_aspect_ratio";
    public static final String SECONDARY_QQCIRCLE_WINK_SELECT_MIN_RATIO = "qqcircle_new_publish_min_aspect_ratio";
    public static final String SECONDARY_QQCIRCLE_WINK_TAVLOG_OPEN = "wink_tavcut_log_open";
    public static final String SECONDARY_QQCIRCLE_WINK_TRANSITION_SWITCH = "qqcircle_wink_transition_switch";
    public static final String SECONDARY_QQCIRCLE_WINK_VIDEO_MUSIC_URL = "qqcircle_editor_use_wns_music_url";
    public static final String SECONDARY_QUICK_CAMERA_ANIM_REQ_DELAY = "QuickCameraAnimReqDelay";
    public static final String SECONDARY_QUN_ALBUM_DETAIL_URL = "QunAlbumDetail";
    public static final String SECONDARY_QUN_ALBUM_PHOTO_URL = "QunAlbumPhotoList";
    public static final String SECONDARY_QUN_ALBUM_SELECT_URL = "QunAlbumSelect";
    public static final String SECONDARY_QUN_ALBUM_URL = "QunAlbum";
    public static final String SECONDARY_QUN_FEED_URL = "QunFeed";
    public static final String SECONDARY_QUN_PASSIVE_FEED_URL = "QunPassiveFeed";
    public static final String SECONDARY_QUN_SHOW_PICTURE_INTENT_LIMIT = "QunShowPictureIntentLimit";
    public static final String SECONDARY_QUN_UPLOAD_VIDEO = "QunUploadVideo";
    public static final String SECONDARY_QUOTE_MAX_NUM = "quoteMaxNum";
    public static final String SECONDARY_QZFACADE_VISIBLE = "QZFacade_visible";
    public static final String SECONDARY_QZONECOVER_UPLOADQUALITY = "UploadQuality";
    public static final String SECONDARY_QZONECOVER_UPLOADRESOLUTION = "UploadResolution";
    public static final String SECONDARY_QZONESETTINGS_AIO_FEEDS_MAX_RETRY_COUNT = "NewestFeedsRetryNum";
    public static final String SECONDARY_QZONESETTINGS_AIO_FEEDS_MAX_UIN_NUM = "NewestFeedsUinNum";
    public static final String SECONDARY_QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME = "NewestFeedsMinRefreshTimeCell";
    public static final String SECONDARY_QZONESETTINGS_AIO_FEEDS_MIN_TIME = "NewestFeedsMinTimeCell";
    public static final String SECONDARY_QZONESETTINGS_MAXCOMMENT_BUBBLE_TEXTCOUNT = "maxCommentBubbleTextCount";
    public static final String SECONDARY_QZONESETTINGS_MAXUGCTEXTCOUNT = "maxUgcTextCount";
    public static final String SECONDARY_QZONESETTINGS_MAXUGCTEXT_VISIBLELINECOUNT = "maxUgcTextVisibleLineCount";
    public static final String SECONDARY_QZONESETTINGS_MOOD_SEND_MINTIMES = "QzoneMoodSendMinTime";
    public static final String SECONDARY_QZONESETTINGS_MULTISHAREMAXCOUNR = "multiShareMaxCount";
    public static final String SECONDARY_QZONESETTINGS_SHAREMAXSELECTCOUNT = "shareMaxSelectCount";
    public static final String SECONDARY_QZONE_BLOGLIST = "BlogListJumpUrl";
    public static final String SECONDARY_QZONE_BLOG_DETAIL = "BlogDetail";
    public static final String SECONDARY_QZONE_CALL_APP_URL_LIST = "QzoneCallAppUrlList";
    public static final String SECONDARY_QZONE_CREATE_SHORTCUT_BLACK_LIST = "QZoneAlbumOpenCreateShortcutBlackList";
    public static final String SECONDARY_QZONE_DESCRIPTIONSETTING = "DescriptionSetting";
    public static final String SECONDARY_QZONE_DOWNLOADER_USE_OKHTTP_MODE = "qzoneDownloaderUseOkHttp";
    public static final String SECONDARY_QZONE_Dynamic_Cover_ANIMATE_TIME = "QzoneDynamicCoverAnimateTime";
    public static final String SECONDARY_QZONE_Dynamic_Cover_URL = "QzoneQuickReplaceCoverUrl";
    public static final String SECONDARY_QZONE_EXPLICIT_OUT_SHARE_ENABLE = "ExplicitOutShareEnable";
    public static final String SECONDARY_QZONE_FACADE_DYNAMIC_BLACK_LIST = "qzonefacade_dynamic_black_list";
    public static final String SECONDARY_QZONE_FACE_SCAN_BLACKLIST = "qzone_face_scan_blacklist";
    public static final String SECONDARY_QZONE_FACE_SCAN_SWITCH = "qzone_face_scan_switch";
    public static final String SECONDARY_QZONE_FEED_PRELOAD = "EnableFeedPreload";
    public static final String SECONDARY_QZONE_FOREGROUND_ENABLE_CHECK_MAIN_PROCESS_PAGE = "qzone_foreground_enable_check_main_process_page";
    public static final String SECONDARY_QZONE_GIFTDETAILPAGE = "GiftDetailPage";
    public static final String SECONDARY_QZONE_GPS_COMPLEMENT = "QzoneGpsComplement";
    public static final String SECONDARY_QZONE_GPS_SWITCH = "QzoneGpsSwitch";
    public static final String SECONDARY_QZONE_GPS_TRACE = "QzoneGpsTrace";
    public static final String SECONDARY_QZONE_GROUP_AIO_REDPOINT_REPORT_METHOD = "qzone_group_aio_redpoint_report_method";
    public static final String SECONDARY_QZONE_HTTPS_IP_DIRECT_ENABLE = "QzoneHttpsIpDirectEnable";
    public static final String SECONDARY_QZONE_JUMPAVATALISTPAGE = "Avatalistpage";
    public static final String SECONDARY_QZONE_LAUNCH_SLOW_TIME = "qzone_launch_slow_threshold";
    public static final String SECONDARY_QZONE_MAIN_FORCE_SHUTDOWN_GIF_DECODE = "QzoneMainForceShutdownGifDecode";
    public static final String SECONDARY_QZONE_OPEN_ADD_SHORTCUT = "QZoneAlbumOpenAddShortcut";
    public static final String SECONDARY_QZONE_PET_ENABLE_FORANDROIDP = "qzoneEnablePetForAndroidP";
    public static final String SECONDARY_QZONE_PHONELABELSETTING = "PhoneLabelSetting";
    public static final String SECONDARY_QZONE_PICTURE_LIMIT_WIDTH = "QzonePictureLimitWidth";
    public static final String SECONDARY_QZONE_PICTURE_OPT_SCALE = "QzonePictureOptScale";
    public static final String SECONDARY_QZONE_PICTURE_PIECE_LOAD = "QzonePicturePieceLoad";
    public static final String SECONDARY_QZONE_PICUTRE_SETTING_PAGE = "QzonePictureSettingPage";
    public static final String SECONDARY_QZONE_PRELOAD_PAY_H5_ENABLE = "PreloadPayH5";
    public static final String SECONDARY_QZONE_REG_STRING_MATCHER_LRU_MAP_SIZE = "QzoneRegLruMapSize";
    public static final String SECONDARY_QZONE_SETTING_AUTO_SCROLL_TO_NEXT_VIDEO_DELAY_TIME = "AutoScrollToNextVideoDelayTime";
    public static final int SECONDARY_QZONE_SETTING_AUTO_SCROLL_TO_NEXT_VIDEO_DELAY_TIME_DEFAULT = 1000;
    public static final String SECONDARY_QZONE_SETTING_FEEDS_SINGLE_PICTURE_BIG_PICTURE_MODE_COEFFICIENT = "FeedsSinglePictureBigPictureModeCoefficent";
    public static final String SECONDARY_QZONE_SETTING_MAIN_PAGE = "QzoneSettingMainPage";
    public static final String SECONDARY_QZONE_SETTING_RES_FORBIDDEN_LIST = "ResForbiddenList";
    public static final String SECONDARY_QZONE_SETTING_SHARE_SINGLE_BIG_PICTURE_AS_WECHAT_MINI_PROGRAM = "ShareSingleBigPictureAsWeChatMiniProgram";
    public static final String SECONDARY_QZONE_SETTING_VIDEO_IDLE_SCROLL_Y_MIN_DISTANCE = "VideoIdleScrollYMinDistance";
    public static final String SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_AUTO_ROTATION_ENABLE = "VideoRecommendAutoRotationEnable";
    public static final int SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_AUTO_ROTATION_ENABLE_DEFAULT = 0;
    public static final String SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_CLEAR_REPORT_LIST = "VideoRecommendClearReportList";
    public static final int SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_CLEAR_REPORT_LIST_DEFAULT = 1;
    public static final String SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_NEED_CHECK_APP_ENTER_BACKGROUND = "VideoRecommendNeedCheckAppEnterBackground";
    public static final int SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_NEED_CHECK_APP_ENTER_BACKGROUND_DEFAULT = 0;
    public static final String SECONDARY_QZONE_SHARE_HLS_VIDEO_TYPE_FIX = "qzoneShareHlsVideoTypeFix";
    public static final String SECONDARY_QZONE_SHOW_BREEZE_BLACK_LIST = "qzoneShow_breeze_black_list";
    public static final String SECONDARY_QZONE_SHOW_GROUP_AIO_REDPOINT = "qzone_show_group_aio_redpoint";
    public static final String SECONDARY_QZONE_SHUOSHUO_CALENDAR_FRIEND_FEED = "QzoneShuoshuoCalendarFriendFeed";
    public static final String SECONDARY_QZONE_SHUOSHUO_CALENDAR_PLUS_ENTRY = "QzoneShuoshuoCalendarPlusEntry";
    public static final String SECONDARY_QZONE_SHUOSHUO_DAILY_CALENDAR = "QzoneShuoshuoDailyCalendar";
    public static final String SECONDARY_QZONE_SIMPLEUI = "qzonesimpleui";
    public static final String SECONDARY_QZONE_STARTUP_REPORT_CODE_TIME = "qzoneStartupReportCodeTime";
    public static final String SECONDARY_QZONE_SUPPORT_HEIF = "QzoneSupportHeif";
    public static final int SECONDARY_QZONE_SUPPORT_HEIF_DEFAULT = 1;
    public static final String SECONDARY_QZONE_UPDATE_SHORTCUT_BLACK_LIST = "QZoneAlbumUpdateAddShortcutBlackList";
    public static final String SECONDARY_QZONE_VIDEO_DECODE_TYPE_SW_ON_SIMPLE_UI = "SecondaryVideoDecodeTypeSWOnSimpleUI";
    public static final String SECONDARY_QZONE_VIP_PAYMENT = "FloatingViewForPay";
    public static final String SECONDARY_QZONE_VISIT_DOWNLOAD = "QzoneVisitDownload";
    public static final String SECONDARY_RANGE_MODE_NETWORK_LEVEL = "MiniAppRangeModeNetworkLevel";
    public static final String SECONDARY_RANGE_MODE_PERF_LEVEL = "MiniAppRangeModePerfLevel";
    public static final String SECONDARY_RANGE_SIZE = "MiniAppRangeSize";
    public static final String SECONDARY_RANK_COMMENT_DISPLAY_NUM_IN_PAGE = "rank_comment_displayNum_inPage";
    public static final String SECONDARY_RANK_COMMENT_LABEL_BG_COLOR = "rank_comment_label_bg_color";
    public static final String SECONDARY_RANK_COMMENT_LABEL_TEXT = "rank_comment_label_text";
    public static final String SECONDARY_RECENT_PHOTO_BLOCK_PATHS = "RecentPhotoBlockPaths";
    public static final String SECONDARY_RECENT_PHOTO_CAMERA = "RecentPhotoCamera";
    public static final int SECONDARY_RECENT_PHOTO_CAMERA_DEFAULT = 1;
    public static final String SECONDARY_RECENT_PHOTO_CAROUSEL_COUNT = "recentPhotoCarouselCount";
    public static final String SECONDARY_RECENT_PHOTO_LIMIT_SIZE = "RecentPhotoLimitSize";
    public static final String SECONDARY_RECENT_PHOTO_LIMIT_WIDTH = "RecentPhotoLimitWidth";
    public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_BABY_ICON_URL = "recommandUploadForFeedsBabyIconUrl";
    public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_BTN_COLOR_FOR_BABY = "recommandUploadForFeedsBtnColorForBaby";
    public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_BTN_COLOR_FOR_OTHER = "recommandUploadForFeedsBtnColorForOther";
    public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_MINIMAL_SHOW_COUNT = "recommandUploadForFeedsMinimalShowCount";
    public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_MULTI_ICON_URL = "recommandUploadForFeedsMultiIconUrl";
    public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_SCHEMA_BACKUP = "recommandUploadForFeedsSchemaBackup";
    public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_TRAVEL_ICON_URL = "recommandUploadForFeedsTravelIconUrl";
    public static final String SECONDARY_RECOMMEND_BANNER_CHECK_DISPLAY_INTERVAL = "RecommendBannerCheckDisplayInterval";
    public static final int SECONDARY_RECOMMEND_BANNER_CHECK_DISPLAY_INTERVAL_DEFAULT = 3;
    public static final String SECONDARY_REDPOCKET_HEIGHT = "RedPocket_height";
    public static final String SECONDARY_REDPOCKET_PAYLIST = "RedPocketPayList";
    public static final String SECONDARY_REDPOCKET_WIDTH = "RedPocket_Width";
    public static final String SECONDARY_REFRESH_INTERVAL = "FriendFeedRefreshInternal";
    public static final String SECONDARY_REFRESH_INTERVAL2 = "FriendFeedRefreshInternal2";
    public static final String SECONDARY_REGULAR_HTTP2_GRAY_CONFIG = "http2GrayConfig";
    public static final String SECONDARY_REOPEN_QZONE = "ReopenQzone";
    public static final String SECONDARY_REPORT = "Report";
    public static final String SECONDARY_REQUEST_AIO_FEEDS_DIV = "requestAIOFeedsDiv";
    public static final String SECONDARY_REQUEST_AIO_QCIRCLE_FEEDS_DIV = "requestAIOQCircleFeedsDiv";
    public static final String SECONDARY_RETRY_RETCODE = "retry_retCode";
    public static final String SECONDARY_SAFEMODE_CRASH_MAX = "CrashMax";
    public static final String SECONDARY_SAFEMODE_START_DURATION = "StartDuration";
    public static final String SECONDARY_SCHEMA_BLACK_LIST = "schemablacklist";
    public static final String SECONDARY_SECRET_FEED_DETAIL_H5_URL = "OpenSecretFeedDetailH5Url";
    public static final String SECONDARY_SECRET_FEED_LIST_H5_URL = "OpenSecretFeedListH5Url";
    public static final String SECONDARY_SELECT_TEMPLATE_DYNAMIC_ALBUM_URL = "selectTemplateDynamicAlbumUrl";
    public static final String SECONDARY_SEND_BIRTHDAY_GIFT = "SendBirthdayGift";
    public static final String SECONDARY_SERVER_PORT_LIST = "UploadPort";
    public static final String SECONDARY_SHAREWX_MULTIPIC = "wxshare_multipic";
    public static final String SECONDARY_SHARE_ALBUM_ALLOW_INVITE_TO_FEEDS = "ShareAlbumAllowInviteToFeeds";
    public static final String SECONDARY_SHARE_ALBUM_INVITE_TO_FEEDS_URL = "shareAlbumInviteToFeedsUrl";
    public static final String SECONDARY_SHARE_ALBUM_JOIN_TIME = "shareAlbumJoinTime";
    public static final String SECONDARY_SHARE_ALBUM_TO_MINIPROGRAM = "AlbumShareToMiniProgram";
    public static final String SECONDARY_SHARE_BATCH_PHOTO_TO_MINIPROGRAM = "ShareBatchPhotoToMiniProgram";
    public static final String SECONDARY_SHARE_OUTSITE_PENETRATE_ARK = "ShareOutsitePenetrateArk";
    public static final String SECONDARY_SHARE_STRUCT_LONG_MESSAGE = "canShareStructLongMessage";
    public static final String SECONDARY_SHARE_WHITE_LIST = "sharewhitelist";
    public static final String SECONDARY_SHORT_VIDEO_CAN_UPLOAD_DURATION_THRESHOLD = "VideoCanUploadDurationThreshold";
    public static final String SECONDARY_SHORT_VIDEO_CAN_UPLOAD_SIZE_THRESHOLD = "VideoCanUploadSizeThreshold";
    public static final String SECONDARY_SHORT_VIDEO_DURATION_THRESHOLD = "VideoDurationThreshold";
    public static final String SECONDARY_SHOULD_SHARE_PARTNER_SHOW_ADD_ICON = "ShouldSharePartnerShowAddIcon";
    public static final String SECONDARY_SHOW_DELICACY_PICTURE = "ShowMoreDelicacyPicture";
    public static final String SECONDARY_SHOW_ENTER_LIVE_SECONDS = "ShowEnterLiveSeconds";
    public static final String SECONDARY_SHOW_FEED_OPERATION_LAYER = "ShowFeedOpLayer";
    public static final String SECONDARY_SHOW_FLOAT_ENTRANCE = "ShowFloatEntrance";
    public static final String SECONDARY_SHOW_FLOAT_ENTRANCE_DEAFULT = "1";
    public static final String SECONDARY_SHOW_LOCAL_PHOTO_SCAN_TITLE = "ShowLocalPhotoScanTitle";
    public static final String SECONDARY_SHOW_MAGIC_STICK = "ShowMagicStick";
    public static final String SECONDARY_SHOW_RECOMMEND_PAGE_ENTRY = "ShowRecommendPageEntry";
    public static final String SECONDARY_SHOW_SHOP_ENTRANCE = "ShowShopConfigEntrance";
    public static final String SECONDARY_SHOW_SHOP_ENTRANCE_DEFAULT = "0";
    public static final String SECONDARY_SHUOSHUO_CAMERA_ICON = "secondary_shuoshuo_camera_icon";
    public static final String SECONDARY_SHUOSHUO_NEWCARD_SHOW_VIEW = "showNewCardHeadTitle";
    public static final String SECONDARY_SHUOSHUO_SHOW_WEBPICTURE = "ShuoshuoShowWebPicture";
    public static final String SECONDARY_SHUOSHUO_TOOLBAR_SHOW_DONGGANYINGJI = "shuoshuoShowDongganyingji";
    public static final String SECONDARY_SHUOSHUO_UPLOAD_VIDEO_MAX_COUNT = "ShuoShuoMaxSelectVideoNum";
    public static final String SECONDARY_SIGN_IN = "SignIn";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_ANIMATION_GAP = "qzoneSmartBeautifyImageAnimGAP";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_ANIMATION_RES_MD5 = "qzoneSmartBeautifyImageAnimResMd5";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_ANIMATION_RES_URL = "qzoneSmartBeautifyImageAnimResUrl";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_CHECKED_STATUS = "qzoneSmartBeautifyImageCheckedStatus";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_CREATE_TIME_DIFF_MIN = "qzoneSmartBeautifyImageCreateTimeDiffMin";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_MAX_EXPOSURE_TIMES = "qzoneSmartBeautifyImageMaxExposureTimes";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_MAX_WAIT_TIME = "qzoneSmartBeautifyImageMaxWaitTime";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_NUM_MAX = "qzoneSmartBeautifyImageNumMax";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_NUM_MIN = "qzoneSmartBeautifyImageNumMin";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_RECOMM = "qzoneSmartBeautifyImageRecomm";
    public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_SCAN_TAG = "qzoneSmartBeautifyImageScanTag";
    public static final String SECONDARY_SMART_DNSSERVICE = "SmartHttpDnsService";
    public static final String SECONDARY_SOUND_EFFECT_SWITCH = "FeedsSoundEffectSwitch";
    public static final String SECONDARY_SPECIALPUSH_HIDE = "SpecialPushHide";
    public static final String SECONDARY_SPECIAL_CARD_FRIEND_MANAGER_PAGE = "SpecialFriendManage";
    public static final String SECONDARY_SQL_ENABLE_WAL = "enablewal";
    public static final String SECONDARY_STARTUP_FAILED_MSG = "qzone_startup_fail_msg";
    public static final String SECONDARY_STARTUP_FAILED_TOAST_SHOW_LIMIT = "qzone_startup_failed_toast_show_limit";
    public static final String SECONDARY_START_SHOW_ENTER_LIVE_HINT = "StartShowEnterLiveHint";
    public static final String SECONDARY_STAR_VIP_MAIN_PAGE_URL = "StarVipUrl";
    public static final String SECONDARY_STAR_VIP_PAY_URL = "StarVipMainPageUrl";
    public static final String SECONDARY_SUBPERSONAL_HOMEPAGE_URL = "SubPersonalHomePageUrl";
    public static final String SECONDARY_SUB_SHOW_FEED_LIST = "SubShowFeedList";
    public static final String SECONDARY_SUPERCOVER_CPU_LEVEL = "SuperCoverCpuLevel";
    public static final String SECONDARY_SUPERCOVER_MEMORY_LEVEL = "SuperCoverMemoryLevel";
    public static final String SECONDARY_SUPER_FONT_LIST_ATTACH_INFO = "DiySuperFontAttachinfo";
    public static final String SECONDARY_SUPER_HIGH_PHONE_FRICITION = "SuperHighPhoneFriction";
    public static final String SECONDARY_SUPER_RESOLUTION_BENCHMARK_EXPIRE_TIME = "superResolutionBenchmarkExpireTime";
    public static final String SECONDARY_SUPER_RESOLUTION_DEFAULT_MODEL_ID = "superResolutionDefaultModelId";
    public static final String SECONDARY_SUPER_RESOLUTION_ENABLE_HIGH_SCALE = "superResolutionEnableHighScale";
    public static final String SECONDARY_SUPER_RESOLUTION_ENABLE_PRE_INIT_LIBRARY = "superResolutionEnablePreInitLibrary";
    public static final String SECONDARY_SUPER_RESOLUTION_GPU_MAX_SIZE = "superResolutionGpuMaxSize";
    public static final String SECONDARY_SUPER_RESOLUTION_GPU_RATIO_BOUNDARY = "superResolutionGpuRatioBoundary";
    public static final String SECONDARY_SUPER_RESOLUTION_HIGH_SCALE_TIPS = "superResolutionHighScaleTips";
    public static final String SECONDARY_SUPER_RESOLUTION_MEMORY_THRESHOLD = "superResolutionMemoryThreshold";
    public static final String SECONDARY_SUPER_RESOLUTION_MODEL_CONFIG = "superResolutionModelConfig";
    public static final String SECONDARY_SUPER_RESOLUTION_QA_PARAMETER_REX = "superResolutionQAParameterRex";
    public static final String SECONDARY_SUPER_RESOLUTION_RUN_BENCHMARK_CPU_THRESHOLD = "runBenchmarkCpuThreshold";
    public static final String SECONDARY_SUPER_RESOLUTION_SCALE_THRESHOLD = "superResolutionScaleThreshold";
    public static final String SECONDARY_SUPER_RESOLUTION_SR_PARAMETER_REX = "superResolutionSRParameterRex";
    public static final String SECONDARY_SUPPORTED_CPU_FAMILY = "SupportedCpuFamily";
    public static final String SECONDARY_SUPPORT_EDIT_VIDEO = "SupportEditVideo";
    public static final String SECONDARY_SUPPORT_MIX_MUSIC_MAX_SIZE = "SupportMixMusicMaxSize";
    public static final String SECONDARY_SUPPORT_RECORD = "SupportMiniVideo";
    public static final String SECONDARY_SUPPORT_TRIM = "SupportTrimVideo";
    public static final String SECONDARY_SUPPORT_TRIM_HW = "SupportTrimVideoHW";
    public static final String SECONDARY_SUPPORT_VIDEO_CHECKBOX = "SupportVideoCheckbox";
    public static final String SECONDARY_TAKE_PHOTO_USING_QQ_CAMERA = "takePhotoUsingQqCamera";
    public static final String SECONDARY_TCSDKREPORT_URL = "TcSDKReportURL";
    public static final String SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL = "tencentVideoRequestLevel";
    public static final String SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_MODELS = "hevcLevelBlacklistModels";
    public static final String SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_OSVERSION = "hevcLevelBlacklistOSVersion";
    public static final int SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_DEFAULT = 26;
    public static final String SECONDARY_THIRD_WEB_DOWNLOAD = "ThirdWebDownLoad";
    public static final String SECONDARY_THREAD_REGULATED_ENABEL = "threadRegulateEnable";
    public static final String SECONDARY_TIAN_SHU_BANNER_FOREGROUND_REQUEST_INTERVAL_TIME = "TianShuBannerForegroundRequestIntervalTime";
    public static final String SECONDARY_TIME_DELAY_TO_GET_GUIDE_QBOSS_ADV = "time_delay_to_get_guide_qboss_adv";
    public static final String SECONDARY_TISSUE_BASELIB_URL = "tissue_baselib_url";
    public static final String SECONDARY_TRAVELING_BOTTOM_PHOTO = "TravelingBottomPhoto";
    public static final String SECONDARY_TROOP_KEYWORD_AIO_FRESH_FREQUENCY = "SK_QQ_VAS_KeywordAIORefreshFrequency";
    public static final String SECONDARY_TRUE_TYPE_VIEW_CACHE = "TrueTypeViewCache";
    public static final String SECONDARY_UGC_PERMIT_SETTING = "UgcPermitSetting";
    public static final String SECONDARY_UNION_VIP_FEED_URL = "union_vip_feed_icon_url";
    public static final String SECONDARY_UNION_VIP_HEAD_URL = "union_vip_head_icon_url";
    public static final String SECONDARY_UNION_VIP_HOME_URL = "union_vip_home_url";
    public static final String SECONDARY_UNION_VIP_PAY_URL = "union_vip_pay_url";
    public static final String SECONDARY_UNION_VIP_WIDGET_URL = "union_vip_widget_url";
    public static final String SECONDARY_UNPUBLISH_SHUO_SHUO_H5_URL = "UnpublishShuoShuoH5Url";
    public static final String SECONDARY_UPDATE_COUNT_INTERVAL_WHENCLICKFEEDTAB = "UpdateCountIntervalWhenClickFeedTab";
    public static final String SECONDARY_UPLOAD_ALBUM_MAX_PHOTO_COUNT = "AlbumMaxPhotoCount";
    public static final String SECONDARY_UPLOAD_AVCODEC_DOWNLOAD_TIMEOUT = "UploadAvcodecDownloadTimeOut";
    public static final String SECONDARY_UPLOAD_BIG_VIDEO_BYTE = "UploadBigVideoByte";
    public static final String SECONDARY_UPLOAD_CHANGEROUTE_RETCODE = "UploadChangeRouteRetCode";
    public static final String SECONDARY_UPLOAD_CHECK_FACE_NUM = "uploadCheckFaceNum";
    public static final String SECONDARY_UPLOAD_CONNECT_TIMEOUT = "ConnectTimeout";
    public static final String SECONDARY_UPLOAD_DATA_TIMEOUT = "DataTimeout";
    public static final String SECONDARY_UPLOAD_ENABLE_DOWNLOAD_SO = "UploadEnableDownloadSo";
    public static final String SECONDARY_UPLOAD_ENABLE_V6_ROUTE = "UploadEnableV6Route";
    public static final String SECONDARY_UPLOAD_ENABLE_V6_ROUTE_FOR_ALL = "UploadEnableV6RouteForAll";
    public static final String SECONDARY_UPLOAD_ENABLE_V6_TTT_REPORT = "UploadEnableV6TTTreport";
    public static final String SECONDARY_UPLOAD_FACE_FUNTION = "uploadFaceFuntion";
    public static final String SECONDARY_UPLOAD_LP_REPORT_NOW = "UploadLPReportNow";
    public static final String SECONDARY_UPLOAD_LP_REPORT_SAMPLE = "UploadReportNeedSmaple";
    public static final String SECONDARY_UPLOAD_MD5 = "QzoneUploadSoMD5";
    public static final String SECONDARY_UPLOAD_NETWORK_UNAVAILABLE_RETCODE = "UploadNetworkUnavailableRetCode";
    public static final String SECONDARY_UPLOAD_PHOTO_PAGE_TIP = "isShowuploadPhotoYellowDiamondPhto";
    public static final String SECONDARY_UPLOAD_RECORD_VIDEO_WITH_MIX_MODE = "UploadRecordVideoWithMixMode";
    public static final String SECONDARY_UPLOAD_SHOW_POPWINDOW_TIMES = "uploadShowPopwindowTimes";
    public static final String SECONDARY_UPLOAD_SO = "QzoneUploadSo";
    public static final String SECONDARY_UPLOAD_TIMEOUT_RETRY_COUNT = "TimeoutRetryCount";
    public static final String SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT = "FileSizeLimit";
    public static final String SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT_FOR_NON_VIP = "FileSizeLimitForNonVip";
    public static final String SECONDARY_UPLOAD_VIDEO_MAX_COUNT = "MaxSelectVideoNum";
    public static final String SECONDARY_URL_ANALYSIS = "UrlAnalysisSwitch";
    public static final String SECONDARY_USC_ALL_FUNCTION_MASK = "USCAllFunctionMask";
    public static final String SECONDARY_USC_BATCH_PRIORITY = "USCBatchPriority";
    public static final String SECONDARY_USC_BUSINESS_ALL_FUNCTION_MASK = "USCBusinessAllFunctionMask";
    public static final String SECONDARY_USC_CPU_CORES = "USCCPUCores";
    public static final String SECONDARY_USC_CPU_THRESHOLD = "USCCpuThreshold";
    public static final String SECONDARY_USC_EXIF_COMPATIBLE_VERSION = "USCExifCompatibleVersion";
    public static final String SECONDARY_USC_EXIF_CURRENT_VERSION = "USCExifCurrentVersion";
    public static final String SECONDARY_USC_EXIF_ENABLE = "USCExifEnable";
    public static final String SECONDARY_USC_FORBIDDEN_DIR = "USCForbiddenDir";
    public static final String SECONDARY_USC_HIGH_MEMORY_THRESHOLD = "USCHighMemoryThreshold";
    public static final String SECONDARY_USC_JAVA_VM_MEMORY_THRESHOLD = "USCJavaVMMemoryThreshold";
    public static final String SECONDARY_USC_LOW_MEMORY_THRESHOLD = "USCLowMemoryThreshold";
    public static final String SECONDARY_USC_MEMORY_THRESHOLD = "USCMemoryThreshold";
    public static final String SECONDARY_USC_NEED_DECODE_MASK = "USCNeedDecodeMask";
    public static final String SECONDARY_USC_PHOTO_MAX_SIZE = "USCPhotoMaxSize";
    public static final String SECONDARY_USC_PHOTO_MIN_SIZE = "USCPhotoMinSize";
    public static final String SECONDARY_USC_SCAN_ALL_ENABLE = "USCScanAllEnable";
    public static final String SECONDARY_USC_SCAN_MIME_TYPE = "USCScanMimeType";
    public static final String SECONDARY_USC_SCREEN_OFF_ENABLE = "USCScreenOffEnable";
    public static final String SECONDARY_USC_UPDATE_MASK_CACHE_THRESHOLD = "USCUpdateMaskCacheThreshold";
    public static final String SECONDARY_USC_WATCHDOG_CPU_RATE = "USCWatchdogCpuRate";
    public static final String SECONDARY_USC_WATCHDOG_INTERVAL_TIME = "USCWatchDogIntervalTime";
    public static final String SECONDARY_USC_WATCHDOG_READ_CPU_ERROR_LIMIT = "USCReadCpuLimit";
    public static final String SECONDARY_USC_WATCHDOG_READ_CPU_ERROR_RETURN = "USCReadCpuErrorReturn";
    public static final String SECONDARY_USERHOME_BAR_CAMPUS_ZONE_SCHEMA = "bar_campuszone_schema";
    public static final String SECONDARY_USERHOME_BAR_FAMOUS_ZONE_SCHEMA = "bar_famouszone_schema";
    public static final String SECONDARY_USERHOME_BAR_FAMOUS_ZONE_SHOW = "bar_famouszone_visible";
    public static final String SECONDARY_USERHOME_BAR_ICON_URL = "bar_iconurl";
    public static final String SECONDARY_USERHOME_BAR_LOVER_ZONE_ICON_URL = "bar_loversspace_iconurl";
    public static final String SECONDARY_USERHOME_BAR_LOVER_ZONE_NAME = "bar_loversspace_name";
    public static final String SECONDARY_USERHOME_BAR_LOVER_ZONE_SHOW = "bar_loversspace_visible";
    public static final String SECONDARY_USERHOME_BAR_MUSIC_BAR_SHOW = "bar_music_visiable";
    public static final String SECONDARY_USERHOME_BAR_NAME = "bar_name";
    public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_COUNTID = "bar_personalize_countid";
    public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_ICON_URL = "bar_personalize_iconurl";
    public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_NAME = "bar_personalize_name";
    public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_SCHEMA = "bar_personalize_schema";
    public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_SHOW = "bar_personalize_visiable";
    public static final String SECONDARY_USERHOME_BAR_SCHEMA = "bar_schema";
    public static final String SECONDARY_USERHOME_BAR_SHOW = "bar_visiable";
    public static final String SECONDARY_USERHOME_BAR_YELLOW_DIAMOND_ICON_URL = "bar_vip_iconurl";
    public static final String SECONDARY_USERHOME_BAR_YELLOW_DIAMOND_NAME = "bar_vip_name";
    public static final String SECONDARY_USERHOME_BAR_YELLOW_DIAMOND_SHOW = "bar_vip_visible";
    public static final String SECONDARY_USERHOME_BAR_YELLOW_DIAMOND_URL = "bar_vip_jumpurl";
    public static final String SECONDARY_USERHOME_DYNAMIC_SETTING_URL = "QZoneUserHomeDynamicSettingUrl";
    public static final String SECONDARY_USERHOME_FRIEND_SETTING = "FriendSetting";
    public static final String SECONDARY_USERHOME_MORE_MENU_COVER_SETTING_SHOW = "more_menu_famouszone_cover_setting_visible";
    public static final String SECONDARY_USERHOME_MORE_MENU_FRIEND_FEED_SETTING_SHOW = "more_menu_famouszone_friend_feed_setting_visible";
    public static final String SECONDARY_USERHOME_MORE_MENU_SHARE_BACKGROUND_URL = "more_menu_share_background_url";
    public static final String SECONDARY_USERHOME_MORE_MENU_SHARE_DESCRIPTION = "more_menu_share_description";
    public static final String SECONDARY_USE_JPEG_EXIF_READER = "useJpegExifReader";
    public static final String SECONDARY_USE_QQ_CAMERA_COMPRESSION = "UseQQCameraCompression";
    public static final int SECONDARY_USE_QQ_CAMERA_COMPRESSION_DEFAULT = 2;
    public static final String SECONDARY_USE_QQ_EMOTICON_COMMENT = "UseQQEmoticonComment";
    public static final String SECONDARY_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL = "VerticalDownloadProgressBackgroundUrl";
    public static final String SECONDARY_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL_FROM_VS = "VerticalDownloadProgressBackgroundUrlFromVS";
    public static final String SECONDARY_VERTICAL_PLUGIN_DOWNLOAD_CANCELED_ON_CLOSE_BTN = "PluginDownloadCanceledOnCloseBtn";
    public static final String SECONDARY_VERTICAL_VIDEO_LAYER_DISABLE_UPLOAD_USER_ACTION = "VerticalVideoLayerDisableUploadUserAction";
    public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_SCHEME = "VerticalVideoLayerGuideScheme";
    public static final String SECONDARY_VERTICAL_VIDEO_LAYER_LOW_MEMORY = "VerticalVideoLayerLowMemory";
    public static final String SECONDARY_VERTICAL_VIDEO_PLUGIN_SIZE_TEXT = "VerticalVideoPluginSizeText";
    public static final String SECONDARY_VERTICAL_VIDEO_PLUGIN_UPDATE_TIPS = "VerticalVideoPluginUpdateTips";
    public static final String SECONDARY_VIDEOALBUM_ALBUM_SWITCH_ON_INTRO = "videoAlbumAlbumSwitchOnIntro";
    public static final String SECONDARY_VIDEOALBUM_ALBUM_SWITCH_Off_INTRO = "videoAlbumAlbumSwitchOffIntro";
    public static final String SECONDARY_VIDEOALBUM_ALBUM_SWITCH_TITLE = "videoAlbumAlbumSwitchTitle";
    public static final String SECONDARY_VIDEOALBUM_DEMO_COVER_URL = "videoAlbumDemoCoverUrl";
    public static final String SECONDARY_VIDEOALBUM_DEMO_MP4_URL = "videoAlbumDemoMp4Url";
    public static final String SECONDARY_VIDEOALBUM_VIDEO_SWITCH_OFF_INTRO = "videoAlbumVideoSwitchOffIntro";
    public static final String SECONDARY_VIDEOALBUM_VIDEO_SWITCH_ON_INTRO = "videoAlbumVideoSwitchOnIntro";
    public static final String SECONDARY_VIDEOALBUM_VIDEO_SWITCH_TITLE = "videoAlbumVideoSwitchTitle";
    public static final String SECONDARY_VIDEOEDIT_LOAD_VIDEO_FIALED_RETURN_CODE = "VideoLoadErrorReturnCode";
    public static final String SECONDARY_VIDEOEDIT_UPLOAD_MAX_SIZE_TIP_WITH_NO_WIFI = "UploadMaxSizeTipWithNoWifi";
    public static final String SECONDARY_VIDEO_AUTO_PLAY_TIPS = "VideoAutoPlayTips";
    public static final String SECONDARY_VIDEO_CACHE_PROVIDER = "videoCacheProvider";
    public static final int SECONDARY_VIDEO_CACHE_PROVIDER_DEFAULT = 1;
    public static final String SECONDARY_VIDEO_CACHE_SIZE_RATE_TIMEOUT = "GetVideoCacheSizeTimeout";
    public static final String SECONDARY_VIDEO_CHECK_FEEDS = "checkVideoFeeds";
    public static final String SECONDARY_VIDEO_CHECK_RECOMMEND = "checkVideoRecommend";
    public static final String SECONDARY_VIDEO_COMPRESS_SW_TRIM_AVERAGE_SPEED = "videoCompressSwTrimAverageSpeed";
    public static final String SECONDARY_VIDEO_COMPRESS_TIMEOUT_RECORD = "videoCompressTimeoutRecord";
    public static final String SECONDARY_VIDEO_COMPRESS_TIMEOUT_TRIM = "videoCompressTimeoutTrim";
    public static final String SECONDARY_VIDEO_CONTENT_TYPE = "videoContentType";
    public static final String SECONDARY_VIDEO_DEFAULT_DATASOURCE_TYPE = "videoDefaultDataSourceType";
    public static final String SECONDARY_VIDEO_DEFINITION_MOBILE_CONN = "videodefinitionmobileconn";
    public static final String SECONDARY_VIDEO_DEFINITION_WIFI = "videodefinitionwifi";
    public static final String SECONDARY_VIDEO_DISPLAY_FOLLOW_BUTTON = "displayFollowButtonInVideoLayer";
    public static final String SECONDARY_VIDEO_EDIT_MIN_WIDTH_MAX_SUPPORT_VALUE_QCIRCLE_PUBLISH = "EditMinWidthMaxSupportValue_QCirclePublish";
    public static final String SECONDARY_VIDEO_ENABLE_CACHE = "videoEnableCache";
    public static final String SECONDARY_VIDEO_ENABLE_LOAD_LOCAL_DNS = "enblelocaldns";
    public static final String SECONDARY_VIDEO_ENABLE_NONE_WIFI_DOWNLOAD = "enbleNoneWifiDownload";
    public static final String SECONDARY_VIDEO_ENABLE_PROXY = "videoEnableProxy";
    public static final String SECONDARY_VIDEO_ENABLE_WEISHI_DIRECT_IP = "enableWeishiDirectIp";
    public static final String SECONDARY_VIDEO_FLOAT_CONTROLLER_TIMEOUT = "videoFloatControllerTimeout";
    public static final String SECONDARY_VIDEO_FOOTER = "videoFooter";
    public static final String SECONDARY_VIDEO_FORCE_HW_COMPRESS_LIST = "ForceHwCompressList";
    public static final String SECONDARY_VIDEO_FRAME_RATE = "FrameRate";
    public static final String SECONDARY_VIDEO_FRAME_RATE_QCIRCLE_PUBLISH = "FrameRate_QCirclePublish";
    public static final String SECONDARY_VIDEO_FRAME_RATE_VIP_HIGH_QUALITY_QCIRCLE_PUBLISH = "FrameRateVipHighQuality_QCirclePublish";
    public static final String SECONDARY_VIDEO_HEIGHT_RATE = "Video_height_Rate";
    public static final String SECONDARY_VIDEO_HEIGHT_RATE_DETAIL = "Video_height_Rate_Detail";
    public static final String SECONDARY_VIDEO_HERO_PLAYER_LIBS_URL = "videoheroplayerlibsurl";
    public static final String SECONDARY_VIDEO_HOST_ENABLE_HTTPDNSSERVICE = "videoHostEnableHttpDnsService";
    public static final String SECONDARY_VIDEO_HOST_ENABLE_HTTPDNSSERVICE_PREPENDIP = "videoHostEnableHttpDnsServicePrependIp";
    public static final String SECONDARY_VIDEO_HW_BITRATE_MODE = "HwVideoBitrateMode";
    public static final String SECONDARY_VIDEO_HW_COMPRESS_ANDROID_VERSION = "HwCompressWhiteListAndroidVersion";
    public static final String SECONDARY_VIDEO_HW_COMPRESS_BLACKLIST = "HwCompressBlackList";
    public static final String SECONDARY_VIDEO_HW_FRAME_RATE = "HwFrameRate";
    public static final String SECONDARY_VIDEO_HW_LEVEL = "HwVideoLevel";
    public static final String SECONDARY_VIDEO_HW_LONGEST_EDGE = "HwVideoLongestEdge";
    public static final String SECONDARY_VIDEO_HW_MAX_BITRATE = "HwVideoMaxBitrate";
    public static final String SECONDARY_VIDEO_HW_PROFILE = "HwVideoProfile";
    public static final String SECONDARY_VIDEO_IFRAME_INTERVAL = "iFrameInterval";
    public static final String SECONDARY_VIDEO_ILLEGAL_CACHE_DURATION = "IllegalVideoCheckDataCacheDuration";
    public static final String SECONDARY_VIDEO_INTEGRATION_COMPRESS_PARAM = "VideoIntegrationCompressParam";
    public static final String SECONDARY_VIDEO_INTEGRATION_PERMISSION_PARTFRIEND = "VideoIntegrationPermissionPartFriend";
    public static final String SECONDARY_VIDEO_INTEGRATION_PERMISSION_PUBLIC = "VideoIntegrationPermissionPublic";
    public static final String SECONDARY_VIDEO_INTEGRATION_PERMISSION_QQFRIEND = "VideoIntegrationPermissionQQFriend";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_BAR_TEXT = "VideoIntegrationTipsBarText";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_ONE_FIRST_BTN = "VideoIntegrationTipsOneFirstBtn";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_ONE_FIRST_TEXT = "VideoIntegrationTipsOneFirstText";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_ONE_FOURTH_TEXT = "VideoIntegrationTipsOneFourthText";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_ONE_PIC_DAY_URL = "VideoIntegrationTipsOnePicDayUrl";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_ONE_PIC_NIGHT_URL = "VideoIntegrationTipsOnePicNightUrl";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_ONE_SECOND_BTN = "VideoIntegrationTipsOneSecondBtn";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_ONE_SECOND_TEXT = "VideoIntegrationTipsOneSecondText";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_ONE_THIRD_TEXT = "VideoIntegrationTipsOneThirdText";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_TWO_FIRST_BTN = "VideoIntegrationTipsTwoFirstBtn";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_TWO_FIRST_TEXT = "VideoIntegrationTipsTwoFirstText";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_TWO_PAG_DAY_URL = "VideoIntegrationTipsTwoPagDayUrl";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_TWO_PAG_NIGHT_URL = "VideoIntegrationTipsTwoPagNightUrl";
    public static final String SECONDARY_VIDEO_INTEGRATION_TIPS_TWO_SECOND_BTN = "VideoIntegrationTipsTwoSecondBtn";
    public static final String SECONDARY_VIDEO_INTEGRATION_TITLE_ONE = "VideoIntegrationTitleOne";
    public static final String SECONDARY_VIDEO_INTEGRATION_TITLE_TWO = "VideoIntegrationTitleTwo";
    public static final String SECONDARY_VIDEO_INTEGRATION_USER_UNCHECK_COUNT_UPPER = "VideoIntegrationUserUncheckCountUpper";
    public static final String SECONDARY_VIDEO_LEVEL = "VideoLevel";
    public static final String SECONDARY_VIDEO_LIST_BANNER_REQUEST_DURATION = "VideoListBannerReqDuration";
    public static final String SECONDARY_VIDEO_LIST_BANNER_REQUEST_QBOSS = "VideoListBannerRequestQboss";
    public static final String SECONDARY_VIDEO_LIST_BANNER_VISIBLE = "VideoListBannerVisible";
    public static final String SECONDARY_VIDEO_LIST_URL = "LiveList";
    public static final String SECONDARY_VIDEO_LITTLE_WINDOW_SETTING = "VideoFloatLittleWindows";
    public static final int SECONDARY_VIDEO_LITTLE_WINDOW_SETTING_DEFAULT = 0;
    public static final String SECONDARY_VIDEO_LONGEST_EDGE = "VideoLongestEdge";
    public static final String SECONDARY_VIDEO_LOW_SPEED_RATES = "videoLowSpeedRates";
    public static final String SECONDARY_VIDEO_LOW_SPEED_SECONDS = "videoLowSpeedSeconds";
    public static final int SECONDARY_VIDEO_LUGC_SHOW_TOP_BAR_DEFAULT = 0;
    public static final String SECONDARY_VIDEO_MAX_BITRATE = "VideoMaxBitrate";
    public static final String SECONDARY_VIDEO_MAX_BITRATE_QCIRCLE_PUBLISH = "VideoMaxBitrate_QCirclePublish";
    public static final String SECONDARY_VIDEO_MAX_BITRATE_VIP_HIGH_QUALITY_QCIRCLE_PUBLISH = "VideoMaxBitrateVipHighQuality_QCirclePublish";
    public static final String SECONDARY_VIDEO_MAX_CACHE_SIZE = "maxCacheSize";
    public static final String SECONDARY_VIDEO_MAX_SIZE_CM = "Video_MaxSize_CM";
    public static final String SECONDARY_VIDEO_NEWPARAM_ALL = "VideoNewVideoCompressParamAll";
    public static final String SECONDARY_VIDEO_NEWPARAM_ALL_QCIRCLE_PUBLISH = "VideoNewVideoCompressParamAll_QCirclePublish";
    public static final String SECONDARY_VIDEO_NEW_PARAMS = "videoNewParams";
    public static final String SECONDARY_VIDEO_NEXT_PLAYID_TIME_STAMP = "ResumePlayReportMinTime";
    public static final String SECONDARY_VIDEO_NORMAL_PATH_TYPE = "videoNormalPathType";
    public static final String SECONDARY_VIDEO_ON_CLOUD_HOSTS = "videoOnCloudHosts";
    public static final String SECONDARY_VIDEO_OTHER_CONFIG = "OtherConfig";
    public static final String SECONDARY_VIDEO_PLAY_FLRST_SEGMENT = "videoplayfirstsegment";
    public static final String SECONDARY_VIDEO_PRELOAD_DURATION = "preLoadDuration";
    public static final String SECONDARY_VIDEO_PRELOAD_MAX_SIZE = "maxPreLoadSize";
    public static final String SECONDARY_VIDEO_PRESET = "VideoPreset";
    public static final String SECONDARY_VIDEO_PRESET_FOR_LOW_CPU = "VideoPresetForLowCpu";
    public static final String SECONDARY_VIDEO_PROFILE = "VideoProfile";
    public static final String SECONDARY_VIDEO_PUBLISH_ON_ERROR_SIZE = "videoPublishOnErrorSize";
    public static final String SECONDARY_VIDEO_QUALITY_TEXT_DIFF = "videoQualityTextDiff";
    public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_FEEDS = "requestSafeUrlFeeds";
    public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_NEED_CHECK_HOST = "videorequestsafeurlcheckhost";
    public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_RECOMMEND = "requestSafeUrlRecommend";
    public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_REMOVE_TIME = "requestSafeUrlRemoveTime";
    public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_RESPONSE_RECOMMEND = "requestSafeUrlResponseRecommend";
    public static final String SECONDARY_VIDEO_RESOLUTION_QCIRCLE_PUBLISH = "VideoResolution_QCirclePublish";
    public static final String SECONDARY_VIDEO_RESOLUTION_VIP_HIGH_QUALITY_QCIRCLE_PUBLISH = "VideoResolutionVipHighQuality_QCirclePublish";
    public static final String SECONDARY_VIDEO_RETRY_DOWN_HIGH = "videoRetryDownHigh";
    public static final String SECONDARY_VIDEO_RETRY_DOWN_LOW = "videoRetryDownLow";
    public static final String SECONDARY_VIDEO_RETRY_DOWN_MEDIUM = "videoRetryDownMedium";
    public static final String SECONDARY_VIDEO_SAFE_URL_TIMEOUT = "videoSafeUrlTimeOut";
    public static final String SECONDARY_VIDEO_SCALE_RATIO_FOR_PGC = "pgcVideoDisplayScaleRatio";
    public static final String SECONDARY_VIDEO_SCALE_RATIO_FOR_UGC = "ugcVideoDisplayScaleRatio";
    public static final String SECONDARY_VIDEO_SUPER_PLAYER_ENABLED = "videoSuperPlayerEnabled";
    public static final String SECONDARY_VIDEO_SUPER_PLAYER_INIT_DELAY_TIME = "videoSuperPlayerInitDelayTime";
    public static final String SECONDARY_VIDEO_SUPER_PLAYER_INJECT_FULL_LOG = "videoSuperPlayerInjectFullLog";
    public static final String SECONDARY_VIDEO_SUPER_PLAYER_UIN_POSTFIX = "videoSuperPlayerUinPostfix";
    public static final String SECONDARY_VIDEO_SUPPORT_MULTITHREAD = "videoTrimSupportMultiThread";
    public static final String SECONDARY_VIDEO_SUPPORT_WINDOW_PLAY = "videoSupportWindowPlay";
    public static final String SECONDARY_VIDEO_TASK_RETRY_FOR_BUILD_FAILED = "videoTaskRetryForBuildFailed";
    public static final String SECONDARY_VIDEO_TASK_RETRY_FOR_CONNECT_FAILED = "videoTaskRetryForConnectFailed";
    public static final String SECONDARY_VIDEO_TASK_RETRY_FOR_DISCONNECT = "videoTaskRetryForDisconnect";
    public static final String SECONDARY_VIDEO_TASK_RETRY_FOR_TIMEOUT = "videoTaskRetryForTimeout";
    public static final String SECONDARY_VIDEO_TC_PATH_TYPE = "videoTcPathType";
    public static final String SECONDARY_VIDEO_TIME_NO_TRIM_THRESHOLD = "videoTimeNoTrimThreshold";
    public static final String SECONDARY_VIDEO_TO_GIF_FIRST_N_SECOND = "VideoToGifFirstNSecond";
    public static final String SECONDARY_VIDEO_TO_GIF_FPS = "VideoToGifFps";
    public static final String SECONDARY_VIDEO_TO_GIF_MAX_FRAME = "VideoToGifMaxFrame";
    public static final String SECONDARY_VIDEO_TO_GIF_SIZE = "VideoToGifSize";
    public static final String SECONDARY_VIDEO_TO_GIF_SIZE_FOR_LONG_EDGE = "VideoToGifSizeForLongEdge";
    public static final String SECONDARY_VIDEO_TO_GIF_TIME_PER_FRAME = "VideoToGifTimePerFrame";
    public static final String SECONDARY_VIDEO_TRIM_ENABLE_HW = "videoTrimEnableHw";
    public static final String SECONDARY_VIDEO_TRIM_MEDIUM_AVAIL_RAM = "videoTrimMediumAvailRam";
    public static final String SECONDARY_VIDEO_TRIM_MIN_AVAIL_RAM = "videoTrimMinAvailRam";
    public static final String SECONDARY_VIDEO_TRIM_SUPERFAST_AVAIL_RAM = "videoTrimSuperfastAvailRam";
    public static final String SECONDARY_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM = "videoTrimUltrafastAvailRam";
    public static final String SECONDARY_VIDEO_TUNE = "VideoTune";
    public static final String SECONDARY_VIDEO_TVK_HOST = "videoTvkHost";
    public static final String SECONDARY_VIDEO_UGC_SHOW_TOP_BAR = "VideoFloatUGCShowTopBar";
    public static final String SECONDARY_VIDEO_UPLOAD_BAK_IP = "BackupIP_VIDEOUP";
    public static final String SECONDARY_VIDEO_UPLOAD_HOST_IP = "VideoURL_UP";
    public static final String SECONDARY_VIDEO_UPLOAD_HOST_IP_V6 = "VideoURL_UP_V6";
    public static final String SECONDARY_VIDEO_UPLOAD_OPT_IP = "OptimumIP_VIDEOUP";
    public static final String SECONDARY_VIDEO_UPLOAD_OPT_IP_V6 = "OptimumIP_VIDEOUPV6";
    public static final String SECONDARY_VIDEO_UPLOAD_QUALITY_ORG_LIMIT = "FileSizeLimitForShowOrigVideo";
    public static final String SECONDARY_VIDEO_USE_WNS_CGI = "videoUseWnsCgi";
    public static final String SECONDARY_VIDEO_VKEY_TIMEOUT = "videoVkeyTimeOut";
    public static final String SECONDARY_VIDEO_WEISHI_PATH_TYPE = "videoWeishiPathType";
    public static final String SECONDARY_VIDEO_WIDTH_RATE = "Video_Width_Rate";
    public static final String SECONDARY_VIP_PK = "VipPK";
    public static final String SECONDARY_VIP_PROFILE = "VipProfile";
    public static final String SECONDARY_VISITORREPORT_COUNT = "VisitorReportCount";
    public static final String SECONDARY_VISITORREPORT_INTEVAL = "VisitorReportInteval";
    public static final String SECONDARY_VISITORREPORT_STOPTIME = "VisitorReportStopSeconds";
    public static final String SECONDARY_VISITOR_NOTIFY_SETTING = "VisitNotifySetting";
    public static final String SECONDARY_VISITOR_OTHER = "QzoneVisitor";
    public static final String SECONDARY_VISITOR_PAGE_JUMPQZONE_SCHEME_ENABLE = "VisitorPageJumpQZoneSchemeEnable";
    public static final String SECONDARY_VISITOR_REDPOCKET = "QzoneVisitorRedPocket";
    public static final String SECONDARY_VISITOR_SETTING = "SeeMyVisitorPersimmonSetting";
    public static final String SECONDARY_VISITOR_WIDGET = "PersonalQzoneVisitor";
    public static final String SECONDARY_VISIT_GUEST_ALBUM_TIME = "visitGuestAlbumTime";
    public static final String SECONDARY_VOICE_SHUOSHUO_ANIMATION = "VoiceShuoshuoAnimation";
    public static final String SECONDARY_VOICE_SHUOSHUO_ANIMATION_LENGTH = "VoiceShuoshuoAnimationLength";
    public static final String SECONDARY_VOICE_SHUOSHUO_ANIMATION_MD5 = "VoiceShuoshuoAnimationMD5";
    public static final String SECONDARY_VOICE_SHUOSHUO_ICON = "secondary_voice_shuoshuo_icon";
    public static final String SECONDARY_WEATHER_CACHE_TIME = "WeatherCacheTime";
    public static final String SECONDARY_WEBSO_COMMAND = "HttpProxyHost2Command";
    public static final String SECONDARY_WEBSO_REPORT_BATCH_COUNT = "QzhwStatUploadBatchCount";
    public static final String SECONDARY_WEBSO_REPORT_BATCH_INTERVAL = "QzhwStatUploadBatchInterval";
    public static final String SECONDARY_WEBSO_REPORT_DEFAULT_SAMPLING = "QzhwStatDefaultSampling";
    public static final String SECONDARY_WEBSO_REPORT_URL = "QzhwStatCgiURL";
    public static final String SECONDARY_WEBSO_REPORT_URL_DEFAULT = "https://h5.qzone.qq.com/report/native";
    public static final String SECONDARY_WEISHI_MAXCACHE_COUNT = "weishiCacheCount";
    public static final String SECONDARY_WEISHI_TAB_PRELOAD = "weishiTabPreload";
    public static final String SECONDARY_WEISHI_VIDEO_LONGESTEDGE = "WeishiVideoLongestEdge";
    public static final String SECONDARY_WEISHI_VIDEO_MAX_BITRATE = "WeishiVideoMaxBitrate";
    public static final String SECONDARY_WEIXIN_DOWNLOAD = "WeiXinDownload";
    public static final String SECONDARY_WHISPER_EGG = "WhisperEgg";
    public static final String SECONDARY_WIFI_OPERATOR_CRARRY = "WifiCarrierType";
    private static final String SECONDARY_WINK_AUDIO_SEEK_SWITCH = "qqcircle_audio_seek_sync_switch";
    private static final String SECONDARY_WINK_AUTO_CROP_IMAGE_SWITCH = "qqcircle_auto_crop_image_switch";
    private static final String SECONDARY_WINK_EDIT_BUBBLE_NAME = "qqcircle_new_publish_bubble_name";
    private static final String SECONDARY_WINK_EDIT_ENHANCE_CONFIG = "qqcircle_new_publish_enhance_config_url";
    private static final String SECONDARY_WINK_EDIT_ENHANCE_CONFIG_DEFAULT_URL = "https://downv6.qq.com/shadow_qqcamera/Android/res/downloadEnhanceCofig_8923.json";
    private static final String SECONDARY_WINK_EDIT_FAST_COMPRESS = "qqcircle_new_publish_fast_compress";
    private static final String SECONDARY_WINK_EDIT_FFMPEG_DECODE = "qqcircle_new_publish_edit_ffmpeg_decode";
    private static final String SECONDARY_WINK_EDIT_FFMPEG_DECODE_LEVEL = "qqcircle_new_publish_ffmpeg_decode_level";
    private static final String SECONDARY_WINK_EDIT_FREEZE_WHEN_COMPUTING_STICKER_TRACK = "qqcircle_new_publish_freeze_when_computing_sticker_track";
    private static final String SECONDARY_WINK_EDIT_HIGH_QUALITY_RENDER_LEVEL = "qqcircle_new_publish_video_high_quality_render_level";
    private static final String SECONDARY_WINK_EDIT_NON_ACCURATE_EXTRACT_FRAME = "qqcircle_new_publish_non_accurate_extract_frame";
    private static final String SECONDARY_WINK_EDIT_RENDERMODEL_EXPORT_SWITCH = "qqcircle_new_publish_export_rendermodel_switch";
    private static final String SECONDARY_WINK_EDIT_RENDERSIZE_SYNC_OUTPUT = "qqcircle_new_publish_export_rendersize_sync";
    private static final String SECONDARY_WINK_EDIT_TEMPLATE_RECOMMEND_SAMPLE_MAX_COUNT = "qqcircle_edit_template_recommend_sample_max_count";
    private static final String SECONDARY_WINK_EDIT_TEMPLATE_RECOMMEND_SAMPLE_QUALITY = "qqcircle_edit_template_recommend_sample_quality";
    private static final String SECONDARY_WINK_EDIT_TEMPLATE_RECOMMEND_SHORT_SIDE_MIN_VALUE = "qqcircle_edit_template_recommend_sample_short_side_min_value";
    private static final String SECONDARY_WINK_LIGHT_CACHE_CONFIG_MAX = "qqcircle_new_publish_light_cache_config_max";
    private static final String SECONDARY_WINK_LIGHT_CACHE_CONFIG_MIN = "qqcircle_new_publish_light_cache_config_min";
    private static final String SECONDARY_WINK_LIGHT_CACHE_CONFIG_VERSION = "qqcircle_new_publish_light_cache_config_version";
    private static final String SECONDARY_WINK_MAGIC_STUDIO_SWITCH = "qqcircle_wink_magic_studio_switch";
    private static final String SECONDARY_WINK_MATERIAL_ZIP_DELELTE = "qqcircle_material_zip_delete";
    private static final String SECONDARY_WINK_MUSIC_OFFSET_DURATION = "qqcircle_muscic_offset_duration";
    private static final String SECONDARY_WINK_ONLINE_VIDEO_PICKER_TAB_SWITCH = "qqcircle_wink_online_video_picker_tab_switch";
    private static final String SECONDARY_WINK_RELOAD_SWITCH = "qqcircle_wink_reload_switch";
    public static final String SECONDARY_WINK_SHOW_CANCEL_UPLOAD_BUTTON = "qqcircle_new_publish_show_cancel_upload_button";
    private static final String SECONDARY_WINK_SMART_FILTER_DEFAULT = "qqcircle_wink_smart_filter_default";
    private static final String SECONDARY_WINK_TEMPLATE_COLL_DURATION = "qqcircle_temlate_coll_duration_type";
    private static final String SECONDARY_WINK_TEMPLATE_HIDE_CATEGORY_ICON_MODELS = "secondary_wink_template_hide_category_icon_models";
    private static final String SECONDARY_WINK_UPDATE_PLAYER_WHEN_RESUME = "qqcircle_update_player_resume_switch";
    private static final String SECONDARY_WINK_VIDEO_PLAY_OPTIM_SWITCH = "qqcircle_video_play_optim_switch";
    public static final String SECONDARY_WOO_MAIN_ICON_SCROLL_HIDE = "WooNormalMainIconScrollHide";
    public static final String SECONDARY_ZPLAN_FILAMENT_AI_AVATART_SHOW = "ZplanFilamentAIAvatarShow";
    public static final String SECONDARY_ZPLAN_SETTING_GUIDE_STAY_TIME = "ZPlanSettingGuideStayTime";
    public static final String SECONDARY_ZPLAN_TOGGLE_NEW_CONCISE = "ZPlanToggleNewConcise";
    public static final String SECONDAY_MEMOEY_OPERATE_FREQUENCY = "memory_operate_frequency";
    public static final String SECOND_KEY_ADJUST_PREDECODE_MEMORY_SIZE = "adjustPredecodeMemorySize";
    public static final String SECOND_KEY_CLEAR_STEP = "memory_clear_step";
    public static final String SECOND_KEY_EVENTWIDGET_WEBSO_PRELOAD = "eventwidget_webso_preload";
    public static final String SECOND_KEY_IMAGE_MANAGER_MEMORY_RESTRICTION = "argb8888MemoryRestriction";
    public static final String SECOND_KEY_IMAGE_MANAGER_USE_ARGB8888 = "useArgb8888";
    public static final String SECOND_KEY_MEMORY_ENABLE_SWITCH = "memory_enable";
    public static final int SELF_PRAISE_ANIMATION_SWITCH_OPEN = 1;
    public static final int SHARE_ALBUM_TO_WEIXIN_MINI_PROGRAM_NEED_SK = 1;
    public static final int SMART_BEAUTIFY_IMAGE_STATUS_CHECKED = 1;
    public static final String SP_KEY_PRELOAD_SMALL_GAME_FINISH = "key_qzone_preload_small_game_finish_";
    public static final String SP_KEY_PRELOAD_SMALL_GAME_TIMESTAMP = "key_qzone_preload_small_game_timestamp_";
    public static final int SWITCH_VALUE_CLOSE = 0;
    public static final int SWITCH_VALUE_OPEN = 1;
    private static final String TAG = "QzoneConfig";
    public static final String TEXT_CELL_LAYOUT_CAN_TRANSMIT_TOUCH_TARGET = "text_cell_layout_can_transmit_touch_target";
    public static final String TIANSHU_CDN_PIC_START = "https://tianshu.gtimg.cn/tianshu/";
    public static final String TTT_REALTIME_REPORT_LIST = "TTTRealTimeReportList";
    public static final String TTT_REPORT_SETTING = "QzoneTTTReportSetting";
    public static final String USE_NEW_COMMAND = "use_new_command";
    public static final String WEBSO_DEFAULT_COMMAND_SETTING = "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"vv6.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"h5.gdt.qq.com\":{\"command\":\"nemoh5.gdt.lp\",\"msfCommand\":\"nemoh5.gdt.lp\"},\"club.vip.qq.com\":{\"command\":\"qzoneh5.club.wnshtml\",\"msfCommand\":\"qzoneh5.club.wnshtml\"},\".q.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"qun.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\".ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\"qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"},\".qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"} }";
    public static final String WX_MINIAPP_EABLE = "wxMiniAppEnable";
    public static final String YINGYONGBAO_SWITCH_PREFIX = "YingyongbaoSwitchPrefix";
    public static volatile QzoneConfig instance;
    private ContentObserver configUpdateObserver;
    private volatile Boolean isNewStylePublicAccountPage;
    private k05.a mStringHelper;
    private ArrayList<WeakReference<QzoneConfigChangeListener>> mCallback = new ArrayList<>();
    private Map<String, Long> mConfigLogMap = new ConcurrentHashMap();
    public CopyOnWriteArrayList<a> mUnitedConfigProviders = new CopyOnWriteArrayList<>();
    private ConcurrentHashMap<String, ConcurrentHashMap<String, String>> configMap = new ConcurrentHashMap<>();
    private volatile int loadstatus = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class DefaultValue {
        public static final int ATUSER_INTERACTIVE_MAX = 10;
        public static final int ATUSER_PUBLISH_UGC_MAX = 30;
        public static final String BIZ_DOWNLOAD_QZONE_APP_URL = "https://m.qzone.com/l?g=1472";
        public static final int C2C_AIO_IMAGE_SYNC_ALBUM_INFO_EXPIRE_TIME = 60;
        public static final int CLOSE_FUNTION = 0;
        public static final int COMPRESS_TO_WEBP = 0;
        public static final int DB_OPTIMIZE_SYNC = 1;
        public static final int DEFAULTFRIENDFEED_CLICK_TO_TOP_LIMIT = 2;
        public static final String DEFAULT_ALBUM_FEED_SHARE_DYNAMIC_URL = "https://h5.qzone.qq.com/dynamicAlbum/previewPhoto/{albumid}/{batchid}?_wv=3&_proxy=1&hostuin={hostuin}&albumType=feed";
        public static final int DEFAULT_ALBUM_IS_ABLE_TO_SCAN_RECOM_UPLOAD_PHOTO = 1;
        public static final String DEFAULT_ALBUM_LIST_MAX_COUNT = "9999,999,999";
        public static final int DEFAULT_ALBUM_PHOTO_SEARCH_ENTRANCE_ON = 1;
        public static final int DEFAULT_ALBUM_RECOM_ROLLBACK_TIME = 0;
        public static final int DEFAULT_ALBUM_RECOM_UPLOAD_BAR_PHOTO_COUNT = 5;
        public static final int DEFAULT_ALBUM_RECOM_UPLOAD_DISTANCE_LIMIT = 1000;
        public static final int DEFAULT_ALBUM_RECOM_UPLOAD_LIMIT_LEVEL = 4;
        public static final int DEFAULT_ALBUM_SHARE_DYNAMIC_MAX_PHOTO_NUM = 30;
        public static final String DEFAULT_ALBUM_SHARE_DYNAMIC_URL = "https://h5.qzone.qq.com/dynamicAlbum/previewPhoto/{albumid}?_wv=3&_proxy=1&hostuin={hostuin}";
        public static final int DEFAULT_ALBUM_SHARE_TO_WECHAT_MINI_PROGRAM = 1;
        public static final int DEFAULT_ALBUM_SHARE_TO_WECHAT_WEB = 0;
        public static final String DEFAULT_ALBUM_UPDATE_TIP_OPENED_DESC = "\u8bbe\u7f6e\u6210\u529f\u540e\uff0c\u7a7a\u95f4\u5c06\u5b9a\u671f\u626b\u63cf\u672c\u5730\u76f8\u518c\u7684\u65b0\u589e\u5185\u5bb9\uff0c\u5e76\u8fdb\u884c\u63d0\u793a\u3002\u540e\u7eed\u53ef\u5728QQ\u7a7a\u95f4-\u66f4\u591a\u8bbe\u7f6e-\u901a\u7528\u8bbe\u7f6e\u91cc\u8fdb\u884c\u6743\u9650\u66f4\u6539\u3002";
        public static final String DEFAULT_ALBUM_UPDATE_TIP_OPENED_TITLE = "\u5df2\u5f00\u542f\u672c\u5730\u7167\u7247\u66f4\u65b0\u63d0\u793a";
        public static final String DEFAULT_ALBUM_UPDATE_TIP_OPEN_DESC = "\u5f00\u542f\u540e\uff0c\u5f53\u4f60\u7684\u672c\u5730\u7167\u7247\u6709\u66f4\u65b0\u65f6\uff0c\u7a7a\u95f4\u9996\u9875\u5c06\u4e3a\u4f60\u53ca\u65f6\u63d0\u793a\uff0c\u8bb0\u5f55\u6bcf\u4e00\u4efd\u5feb\u4e50\u65f6\u5149\u3002";
        public static final String DEFAULT_ALBUM_UPDATE_TIP_OPEN_TITLE = "\u5f00\u542f\u672c\u5730\u7167\u7247\u66f4\u65b0\u63d0\u793a";
        public static final String DEFAULT_ALBUM_UPDATE_TIP_OPEN_URL = "https://qzonestyle.gtimg.cn/qzone/client/mqq/feeds/albumlead1.png";
        public static final int DEFAULT_ALBUM_WATER_PIC = 1;
        public static final long DEFAULT_APPINFOENTITY_DELEATE_INTERVAL_TIME = 172800000;
        public static final int DEFAULT_BABY_ALBUM_APPLY_FUNCTION_OPEN = 0;
        public static final int DEFAULT_BABY_ALBUM_INVITE_FUNCTION_OPEN = 1;
        public static final String DEFAULT_C2C_PLUS_AIO_GIFT_JUMP_URL = "https://h5.qzone.qq.com/giftv2/sendDialog?_wv=16781315&_wwv=13&_proxy=1&themeMode={themeMode}&uin={uin}";
        public static final String DEFAULT_CATEGORY_LIST_HEADER_TIPS = "\u667a\u80fd\u6574\u7406\u76f8\u518c\u7167\u7247,\u4ec5\u81ea\u5df1\u53ef\u89c1";
        public static final String DEFAULT_CATEGORY_SCANNER_FRONT_CAM_BLACKLIST = "N1T";
        public static final int DEFAULT_CLOSE_ALL_SELECT_BTN = 1;
        public static final String DEFAULT_CONTEXTBOX_LOAD_NUM = "10_10_10";
        public static final String DEFAULT_CREATE_ALBUM_ORDER = "0-0";
        public static final int DEFAULT_CREATE_GIF_FILE_MAX_SIZE = 10;
        public static final int DEFAULT_CREATE_GIF_PHOTO_FRAME_TIME1 = 200;
        public static final int DEFAULT_CREATE_GIF_PHOTO_FRAME_TIME2 = 200;
        public static final int DEFAULT_CREATE_GIF_PHOTO_GIF_SIZE = 512;
        public static final int DEFAULT_CREATE_GIF_PHOTO_MAX_NUM = 50;
        public static final int DEFAULT_CREATE_GIF_PHOTO_MIN_NUM = 2;
        public static final int DEFAULT_CROP_GIF_EDGEBOTTOM = 2;
        public static final int DEFAULT_CROP_GIF_EDGELEFT = 1;
        public static final int DEFAULT_CROP_GIF_EDGERIGHT = 1;
        public static final int DEFAULT_CROP_GIF_EDGETOP = 1;
        public static final int DEFAULT_DETAIL_MAXPICSHOW_NUM = 18;
        public static final String DEFAULT_DISCOVERY_TITLE = "\u53d1\u73b0";
        public static final String DEFAULT_DOWNLOAD_BEAUTY_SO_URL = "https://d3g.qq.com/sngapp/app/update/20180518104407_5319/libandroidndkbeauty.so";
        public static final String DEFAULT_DOWNLOAD_GIF_SO_URL = "https://d3g.qq.com/sngapp/app/update/20181219175050_4961/libandroidndkgif.so";
        public static final String DEFAULT_DOWNLOAD_HTTP2_DOMAIN_LIST = "m.qpic.cn,b\\d+\\.photo\\.store\\.qq\\.com,s\\d+\\.photo\\.store\\.qq\\.com,r.photo.store.qq.com,a[0-9].qpic.cn,a\\d+\\.photo\\.store\\.qq\\.com";
        public static final String DEFAULT_DOWNLOAD_HTTP2_GRAY_CONFIG = "0,70,100";
        public static final String DEFAULT_ECLIVE_LAUNCH_SCHEMA = "mqqzone://arouse/qqexplaunchlive";
        public static final String DEFAULT_ECLIVE_LIVE_SCHEMA = "mqqzone://arouse/qqexplivevideo";
        public static final String DEFAULT_EC_LIVE_URL = "https://h5.qzone.qq.com/v2/audio-live/live/";
        public static final String DEFAULT_ELEGANT_PROFILECARD_MINI_PLAYING_NAME = "\u6700\u8fd1\u7231\u73a9";
        public static final int DEFAULT_ENABLE_APPINFO_DB_CACHE = 1;
        public static final int DEFAULT_ENABLE_DB_CACHE = 0;
        public static final int DEFAULT_ENABLE_FAKE_APPINFO = 0;
        public static final int DEFAULT_ENABLE_HW_TRIM = 1;
        public static final int DEFAULT_ENABLE_NEW_PARAMS = 1;
        public static final int DEFAULT_ENABLE_SUPER_RESOLUTION = 1;
        public static final int DEFAULT_ENABLE_SUPPORT_MULTITHREAD = 1;
        public static final int DEFAULT_ENABLE_TEMPLATESHUOSHUO = 1;
        public static final int DEFAULT_ENABLE_VOICE_SHUOSHUO_H5 = 0;
        public static final int DEFAULT_EVENTWIDGET_WEBSO_PRELOAD = 0;
        public static final int DEFAULT_EXPOSE_PHOTO_MIN_COUNT = 10;
        public static final int DEFAULT_FAKE_FEED_INVALID_TIME = 30;
        public static final String DEFAULT_FAKE_FEED_RETRY_TIMEOUT = "5/5/10/20";
        public static final String DEFAULT_FAMOUS_WHITE_LIST = "1696127668,536264505,622000659,622009484,1872005011";
        public static final int DEFAULT_FEED_GIF_PLAY_SWITCH = 1;
        public static final int DEFAULT_FEED_GIF_SENSOR_MODEL_MAX_COUNT_DEFAULT = 100;
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_DELETED_IMAGE_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190329164047_5d1kR0Sx2N.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_DELETED_IMAGE_URL_NIGHT = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/default/deleteLogo.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_ALBUM_CONCISE_IMAGE_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_ALBUM_IMAGE_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_ALBUM_IMAGE_URL_NIGHT = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_IMAGE_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_IMAGE_URL_NIGHT = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_MOOD_CONCISE_IMAGE_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_MOOD_IMAGE_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_SMALL_IMAGE_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_EMPTY_SMALL_IMAGE_URL_NIGHT = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_NO_NETWORK_IMAGE_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190329164139_M5hX693Wjo.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_NO_NETWORK_IMAGE_URL_NIGHT = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/default/noNetWorkLogo.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_NO_PERMISSION_IMAGE_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190329163959_MjiOsvgXQa.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_NO_PERMISSION_IMAGE_URL_NIGHT = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/default/permissionLogo.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_NO_PERMISSION_SMALL_IMAGE_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_FORBIDDEN_VIEW_FEED_NO_PERMISSION_SMALL_IMAGE_URL_NIGHT = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        public static final int DEFAULT_FRIENDFEED_CLICK_TO_TOP_SHOW_LIMIT = 3;
        public static final String DEFAULT_FRIENDFEED_TITLE = "\u597d\u53cb\u52a8\u6001";
        public static final String DEFAULT_GENERATE_GIF_BLACK_LIST = "X9007,MI 2C,A0001";
        public static final int DEFAULT_GIF_ANTISHAKE_MAX_FRAME_NUM = 5;
        public static final String DEFAULT_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME = "3000";
        public static final String DEFAULT_GIF_ANTISHAKE_MAX_GROUP_SHOOTTIME = "60000";
        public static final String DEFAULT_GIF_ANTISHAKE_MIN_SIMILARITY = "0.6";
        public static final int DEFAULT_GIF_ANTISHAKE_NEED_TO_CHECK_SHOOT_TIME = 0;
        public static final int DEFAULT_GIF_ANTISHAKE_NEED_TO_CHECK_SIMILARITY = 1;
        public static final int DEFAULT_GIF_ANTISHAKE_SWITCH = 1;
        public static final int DEFAULT_GIF_ANTISHAKE_USE_DHASH = 1;
        public static final long DEFAULT_GIF_SO_LENGH = 38400;
        public static final int DEFAULT_GPS_COMPLEMENT = 1;
        public static final int DEFAULT_GPS_INTERVAL = 6;
        public static final int DEFAULT_GPS_TYPE = 2;
        public static final long DEFAULT_GUEST_FOOTER_BANNER_HIDE_TIME = 86400000;
        public static final String DEFAULT_GUEST_MORE_POPUP_ORIGINAL = "{\"needAddItem\":\"1\"}";
        public static final int DEFAULT_GUIDE_PHOTO_CHANGE_STRATEY = 1;
        public static final int DEFAULT_GUIDE_PHOTO_MAX_SIZE = 20000;
        public static final int DEFAULT_GUIDE_PHOTO_MIN_SIZE = 300;
        public static final int DEFAULT_GUIDE_SELECT_PHOTO_SEND_RED_JUMP_TO_QZONE = 0;
        public static final String DEFAULT_GUIDE_UPLOAD_ALBUM_HEAD_VIEW_NO_PHOTO = "\u5f00\u542f\u672c\u5730\u7167\u7247\u66f4\u65b0\u63d0\u793a\uff0c\u53ca\u65f6\u8bb0\u5f55\u5feb\u4e50\u65f6\u5149\u3002";
        public static final String DEFAULT_GUIDE_UPLOAD_ALBUM_HEAD_VIEW_SINGLE_PHOTO = "%d\u5f20\u65b0\u7167\u7247\u5f85\u4e0a\u4f20~";
        public static final String DEFAULT_GUIDE_UPLOAD_ALBUM_NO_PHOTO = "\u5f00\u542f\u672c\u5730\u7167\u7247\u66f4\u65b0\u63d0\u793a\uff0c\u53ca\u65f6\u8bb0\u5f55\u5feb\u4e50\u65f6\u5149\u3002";
        public static final String DEFAULT_GUIDE_UPLOAD_ALBUM_NO_PHOTO_URL = "https://qzonestyle.gtimg.cn/qzone/client/mqq/feeds/albumlead2.png";
        public static final String DEFAULT_GUIDE_UPLOAD_ALBUM_SINGLE_PHOTO = "\u8bd5\u8bd5\u628a\u8fd9\u4e9b\u7cbe\u5f69\u7167\u7247\u4e0a\u4f20\u5230\u7a7a\u95f4\u76f8\u518c\u5427~";
        public static final String DEFAULT_HARDWARERESTRICTION_CPU_FRE_SUM = "4000,8000,14000";
        public static final String DEFAULT_HARDWARERESTRICTION_CPU_SIZE = "1000,1500,2000";
        public static final String DEFAULT_HARDWARERESTRICTION_RAM_SIZE = "750,1000,2000";
        public static final String DEFAULT_HARDWARERESTRICTION_RAM_SIZE_NEW = "1000,2000,6000";
        public static final float DEFAULT_HIGH_PHONE_FRICITION = 1.0f;
        public static final int DEFAULT_HOMEPAGE_FRIENDSHIP_THRESHOLD = 70;
        public static final String DEFAULT_HOME_PAGE_ALBUM_TITLE = "\u76f8\u518c";
        public static final String DEFAULT_HOST_MORE_POPUP_ORIGINAL = "{\"needAddItem\":\"1\"}";
        public static final String DEFAULT_IMAGE_BIG_URL_SEGMENT = "/b/";
        public static final String DEFAULT_IMAGE_CURRENT_URL_SEGMENT = "/c/";
        public static final int DEFAULT_IMAGE_JAR_PROGRESS_TRACER = 0;
        public static final int DEFAULT_IS_PRELOAD_PAY_H5_ENABLE = 1;
        public static final String DEFAULT_KAPU_HOST_FIREPOWER_GROWTH_URL = "https://h5.qzone.qq.com/v2/cmshow/growth/{uin}?_wv=16777219&_proxy=1";
        public static final String DEFAULT_KAPU_HOST_MESSAGE_URL = "https://h5.qzone.qq.com/v2/cmshow/saysetting/{uin}?_wv=16777219&_proxy=1";
        public static final int DEFAULT_KEY_HEAD_MENU = 1;
        public static final long DEFAULT_KEY_LOCATE_INTERVAL = 60000;
        public static final long DEFAULT_KEY_LOCATE_PERMISSION_INTERVAL = 172800000;
        public static final int DEFAULT_KEY_PLUS_DIFFERENCE = 1;
        public static final String DEFAULT_LABEL_TEXT = "\u5206\u7c7b";
        public static final int DEFAULT_LBS_SPECIAL_LOGIC_MAC_RETRY_COUNT = 2;
        public static final int DEFAULT_LBS_SPECIAL_LOGIC_ON = 1;
        public static final String DEFAULT_LIKELIST_PAGE_URL = "https://h5.qzone.qq.com/like/list/{unikey}/{uin}/likelist?_wv=2098179&hostuin={hostuin}&appid={appid}";
        public static final long DEFAULT_LIMITED_SCAN_RECOM_UPLOAD_TIME = 0;
        public static final String DEFAULT_LIVEPLUGIN_SOURL = "https://d3g.qq.com/sngapp/app/update/20171124202406_7451/res1_qzlive_yt_base.so";
        public static final int DEFAULT_LIVEPLUGIN_SOVersion = 5;
        public static final String DEFAULT_LIVEVIDEO_DULI_DOWNLOAD = "https://act.qzone.qq.com/meteor/ekko/prod/57512bc9fbd5ebd076552787/index.html?_wv=1";
        public static final int DEFAULT_LIVEVIDEO_FLOATLAYER_ENTRY_JMP_DULI = 1;
        public static final int DEFAULT_LIVEVIDEO_FLOATLAYER_ENTRY_JMP_DULI_OTH = 2;
        public static final int DEFAULT_LIVEVIDEO_FLOATLAYER_ENTRY_OFF = 0;
        public static final String DEFAULT_LIVEVIDEO_UGCPERMISSION_URL = "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&_proxy=1&qua={qua}&source=livingugc&_proxy=1";
        public static final int DEFAULT_LOCALPHOTO_CHECK_EXIF_MODE = 1;
        public static final int DEFAULT_LOCAL_ALBUM_FORBIDEN_GUIDE_MAX_CHECK_DAYS = 14;
        public static final int DEFAULT_LOCAL_ALBUM_GUIDE_BANNER_SHOW_SWITCH = 0;
        public static final int DEFAULT_LOCAL_ALBUM_GUIDE_EVENT_ENBALE = 1;
        public static final int DEFAULT_LOCAL_ALBUM_GUIDE_EVENT_SHOW_END_HOUR = 22;
        public static final int DEFAULT_LOCAL_ALBUM_GUIDE_EVENT_SHOW_START_HOUR = 19;
        public static final int DEFAULT_LOCAL_ALBUM_GUIDE_GROUP_INTERVAL_MINUTE = 60;
        public static final int DEFAULT_LOCAL_ALBUM_GUIDE_GROUP_VALID_DISTANCE = 1000;
        public static final int DEFAULT_LOCAL_ALBUM_GUIDE_MAX_CHECK_DAYS = 30;
        public static final int DEFAULT_LOCAL_ALBUM_GUIDE_TODAY_IN_LAST_YEAR_GROUP_SHOW_TIME_S = 86400;
        public static final int DEFAULT_LOCAL_ALBUM_GUID_EVENT_MIN_CNT = 3;
        public static final int DEFAULT_LOCAL_PHOTO_HEAD_REQUEST_QBOSS_DURATION = 72;
        public static final int DEFAULT_LOCAL_RECOMMEND_PHOTO_CHECK_INTERVAL_HOUR = 1;
        public static final int DEFAULT_LOCAL_RECOMMEND_PHOTO_GROUP_MIN_UNEXPOSURE_PHOTOS = 3;
        public static final int DEFAULT_LOCAL_RECOMMEND_WIFI_PHOTO_MAX_DAYS = 2;
        public static final int DEFAULT_LOCAL_RECOOMEND_IS_SHOW_SCENE_POINT = 1;
        public static final String DEFAULT_LOCATION_TEXT = "\u5730\u70b9";
        public static final int DEFAULT_LOVE_ALBUM_APPLY_FUNCTION_OPEN = 0;
        public static final int DEFAULT_LOVE_ALBUM_INVITE_FUNCTION_OPEN = 0;
        public static final float DEFAULT_LOW_PHONE_FRICITION = 3.0f;
        public static final int DEFAULT_MAX_DOWNLOADING_VIDEO_COUNT = 1;
        public static final int DEFAULT_MAX_HOURS_PHOTO_TO_CREATE_GIF = 48;
        public static final int DEFAULT_MAX_SPEED = 6000;
        public static final String DEFAULT_MEMORY_COVER_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190329163959_MjiOsvgXQa.png";
        public static final String DEFAULT_MEMORY_DEFAUL_TEXT = "\u4f60\u6ca1\u6709\u67e5\u770b\u6743\u9650\u54e6";
        public static final String DEFAULT_MEMORY_DEFAUL_TEXT_CONTENT = "\u4fdd\u7559\u5f7c\u6b64\u7684\u7a7a\u95f4\uff0c\u4e0d\u6253\u6270\u662f\u4f60\u7684\u6e29\u67d4";
        public static final String DEFAULT_MEMORY_DIVIMAGE_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190114215100_iHKJOP1Pr4.png";
        public static final float DEFAULT_MIDDLE_PHONE_FRICITION = 2.0f;
        public static final String DEFAULT_MINIAPP_FILE_STR = "wxfile://";
        public static final int DEFAULT_MINIAPP_MSF_TIMEOUT_VALUE = 10000;
        public static final String DEFAULT_MINIAPP_RMD_DOMAIN_WHITE_LIST = "https://www.urlshare.cn/";
        public static final String DEFAULT_MINIAPP_WIKI_SCENE_CONFIG_MAP = "{}";
        public static final int DEFAULT_MINIGAME_DOMAIN_NEED_CHECK_PORT = 0;
        public static final int DEFAULT_MINIGAME_KILL_ALL_GAMES_WHEN_DESTROY = 0;
        public static final int DEFAULT_MINIGAME_KILL_ALL_GAMES_WHEN_REUSE = 0;
        public static final int DEFAULT_MINIGAME_KILL_OTHER_GAMES_ON_START = 0;
        public static final int DEFAULT_MINIGAME_SHARE_RATE = 53;
        public static final String DEFAULT_MINIPROGRAM_VIDEO_CONTENT_TYPE = "application/octet-stream; charset=utf-8";
        public static final int DEFAULT_MINI_APP_ENABLE_INSTRUCTIONS = 0;
        public static final String DEFAULT_MINI_APP_IPV6ONLY_DOMAIN_BLACK_LIST = ".idqqimg.com,.qq.com";
        public static final String DEFAULT_MINI_APP_IPV6ONLY_DOMAIN_WHITE_LIST = ".huanle.qq.com";
        public static final String DEFAULT_MINI_APP_IPV6ONLY_FORWARDING_REFERER = "https://appservice.qq.com";
        public static final String DEFAULT_MINI_APP_IPV6ONLY_FORWARDING_URL = "https://proxy.gtimg.cn/tx_tls_gate=";
        public static final int DEFAULT_MINI_APP_IPV6ONLY_FORWARDING_WNSCONFIG_ENABLE = 0;
        public static final String DEFAULT_MINI_APP_IPV6ONLY_FORWARDING_WSS_URL = "wss://proxy.gtimg.cn/tx_tls_gate=";
        public static final int DEFAULT_MINI_ENABLE_DEX = 1;
        public static final int DEFAULT_MINI_ENABLE_HOT_RELOAD = 1;
        public static final int DEFAULT_MINI_ENABLE_LOG = 1;
        public static final int DEFAULT_MINI_ENABLE_OPENGLES3 = 1;
        public static final String DEFAULT_MINI_GAME_BACK_PRESS_HINT = "\u518d\u6309\u4e00\u6b21\u8fd4\u56de\u952e\u9000\u51fa\u8be5\u7a0b\u5e8f";
        public static final String DEFAULT_MINI_GAME_BACK_PRESS_HINT_LIST = "1108292102";
        public static final int DEFAULT_MINI_GAME_BANNER_AD_MIN_WIDTH = 300;
        public static final int DEFAULT_MINI_GAME_BLACK_DETECT_INTERVAL = 3000;
        public static final String DEFAULT_MINI_GAME_BLACK_LIST = "[GT-I9502]";
        public static final String DEFAULT_MINI_GAME_CACHE_FREE_DIALOG_CONTENT = "\u6e38\u620f\u5b58\u50a8\u5f02\u5e38,\u662f\u5426\u6e05\u7f13\u5b58\u540e\u91cd\u542f\u6e38\u620f\uff1f";
        public static final int DEFAULT_MINI_GAME_CODE_CACHE_ENABLE = 1;
        public static final int DEFAULT_MINI_GAME_DOWNLOADER_MODE = 2;
        public static final String DEFAULT_MINI_GAME_DOWNLOADER_PRE_CONNECT_HOST = "https://minigame.gtimg.cn/public/info/miniapp.txt";
        public static final int DEFAULT_MINI_GAME_ENABLE_DOWNLOADER_PRE_CONNECT = 1;
        public static final int DEFAULT_MINI_GAME_ENABLE_HTTP2 = 1;
        public static final String DEFAULT_MINI_GAME_ERROR_DIALOG_BLACK = "";
        public static final String DEFAULT_MINI_GAME_ERROR_DIALOG_CONTENT = "\u6e38\u620f\u5f02\u5e38\u505c\u6b62, \u662f\u5426\u9700\u8981\u91cd\u542f\u6e38\u620f?";
        public static final int DEFAULT_MINI_GAME_ERROR_DIALOG_ENABLE = 1;
        public static final int DEFAULT_MINI_GAME_FRAME_NO_CHANGE_LIMIT = 5;
        public static final String DEFAULT_MINI_GAME_GARY_RANGE = "0-100";
        public static final int DEFAULT_MINI_GAME_JS_ERROR_DETECT_INTERVAL = 5000;
        public static final String DEFAULT_MINI_GAME_LAUNCH_FAIL_DIALOG_CONTENT = "\u6e38\u620f\u52a0\u8f7d\u5f02\u5e38\uff0c\u662f\u5426\u6e05\u7f13\u5b58\u540e\u91cd\u542f\u6e38\u620f\uff1f";
        public static final int DEFAULT_MINI_GAME_MINI_SYS_VERSION = 18;
        public static final int DEFAULT_MINI_GAME_NO_PRESENT_DURATION_LIMIT = 5000;
        public static final int DEFAULT_MINI_GAME_NO_PRESENT_TOUCH_LIMIT = 3;
        public static final long DEFAULT_MINI_GAME_ONSHOW_REPORT_INTERVAL = 2000;
        public static final String DEFAULT_MINI_GAME_PAY_FOR_FRIEND_URL = "https://h5.qzone.qq.com/miniapp/act/friendPay?appid={appid}&prepayId={prepayId}&_proxy=1";
        public static final String DEFAULT_MINI_GAME_PAY_SHARE_IMG = "https://sola.gtimg.cn/aoi/sola/20200615194538_YYA1zqPM8t.png";
        public static final String DEFAULT_MINI_GAME_PAY_SHARE_TITLE = "\u4eb2\u7231\u7684\uff0c\u62dc\u6258\u4f60\u5e2e\u6211\u4ee3\u4ed8\u4e00\u7b14\u8ba2\u5355\uff5e";
        public static final int DEFAULT_MINI_GAME_PERSISTENT_DEBUG_VERSION_ENABLE = 1;
        public static final String DEFAULT_MINI_GAME_PRECONNECT_METHOD = "HEAD";
        public static final long DEFAULT_MINI_GAME_PRECONNECT_TIME_INTERVAL_SECOND = 43200;
        public static final int DEFAULT_MINI_GAME_PRELOAD_BASELIB_ENABLE = 1;
        public static final int DEFAULT_MINI_GAME_PRESENT_DETECT_INTERVAL = 1000;
        public static final String DEFAULT_MINI_GAME_PRE_CONNECT_BLACK_APPID_LIST = "1110244087";
        public static final int DEFAULT_MINI_GAME_PRE_CONNECT_NUM = 5;
        public static final int DEFAULT_MINI_GAME_PUBLIC_ACCOUNT_ARK_MSG_GRAY = 0;
        public static final String DEFAULT_MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_URL = "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list%3Fmode%3Dchengzaiye&_vt=3&via=2015_5_11&_sig=1248527088";
        public static final int DEFAULT_MINI_GAME_PUBLIC_ACCOUNT_MSG_LIST_COUNT = 4;
        public static final String DEFAULT_MINI_GAME_PUBLIC_ACCOUNT_WEB_URL = "https://h5.qzone.qq.com/miniapp/act/gamePublic";
        public static final int DEFAULT_MINI_GAME_RUNTIME_PRELOAD = 0;
        public static final int DEFAULT_MINI_GAME_RUNTIME_PRELOAD_ON_FIRST_FRAME = 1;
        public static final String DEFAULT_MINI_GAME_SHARE_IMG = "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png";
        public static final int DEFAULT_MINI_GAME_STORAGE_EXCEED_DIALOG_ENABLE = 0;
        public static final int DEFAULT_MINI_GAME_STORAGE_EXCEED_LIMIT = 3;
        public static final int DEFAULT_MINI_GAME_SUBPACK_RETRY_ON_COMPILE_COUNT = 1;
        public static final String DEFAULT_MINI_GAME_TRITON_BACKUP_URL = "https://d3g.qq.com/sngapp/app/update/20200608171442_7604/839triton_base_engine.zip|1.5.0.32.6c8a796|1591357374118";
        public static final int DEFAULT_MINI_NEWSDK_APP_ENABLE = 1;
        public static final int DEFAULT_MINI_NEWSDK_ENABLE = 1;
        public static final long DEFAULT_MINI_RECORD_DURATION_INTERVAL = 5000;
        public static final long DEFAULT_MINI_REPORT_DELAY_CHECK_DB = 1000;
        public static final long DEFAULT_MINI_REPORT_DELAY_WAITING = 2000;
        public static final long DEFAULT_MINI_SHOW_TIMEOUT = 45000;
        public static final String DEFAULT_MODEL_PHONE = "52";
        public static final String DEFAULT_MODEL_PHONE_MODEL = "";
        public static final int DEFAULT_MODEL_PHONE_SIZE = 5242880;
        public static final int DEFAULT_MODULE_JUMP_NATIVE = 1;
        public static final int DEFAULT_MULTI_ALBUM_APPLY_FUNCTION_OPEN = 1;
        public static final int DEFAULT_MULTI_ALBUM_INVITE_FUNCTION_OPEN = 1;
        public static final long DEFAULT_NEED_BACK_FEED_INTERVAL = 86400000;
        public static final String DEFAULT_NEED_GETPICMARKER = "1";
        public static final int DEFAULT_NEW_ENTRY_RED_DOT = 1;
        public static final long DEFAULT_OTHERENTITY_DELEATE_INTERVAL_TIME = 345600000;
        public static final int DEFAULT_PASSIVE_FEED_ALERT_BUBBLE = 1;
        public static final String DEFAULT_PASSIVE_FEED_TAB_NAME = "\u6d88\u606f";
        public static final String DEFAULT_PHOTO_ALBUM_PHOTO_NUM_TIPS = "\u5df2\u5c55\u793a\u5168\u90e8";
        public static final int DEFAULT_PHOTO_ALBUM_PHOTO_NUM_TIPS_FLAG = 1;
        public static final int DEFAULT_PHOTO_BUBBLE_SCROLL_SHOW_TIME = 2;
        public static final int DEFAULT_PHOTO_BUBBLE_SHOW_TIME = 10;
        public static final int DEFAULT_PHOTO_BUBBLE_TIME_RANGE = 30;
        public static final float DEFAULT_PHOTO_GIF_RATE_DIF = 0.0f;
        public static final int DEFAULT_PHOTO_GIF_VALID_CNT = 5;
        public static final int DEFAULT_PHOTO_GUIDE_SHOW = 7;
        public static final int DEFAULT_PHOTO_LIST_VISIBLE_STATISTIC = 1;
        public static final int DEFAULT_PHOTO_LIST_VISIBLE_TIME_LIMIT = 500;
        public static final int DEFAULT_PHOTO_TIME_RANGE = 6;
        public static final float DEFAULT_PICTURE_VIEWER_DOUBLE_TAP_SCALE = 2.0f;
        public static final float DEFAULT_PICTURE_VIEWER_MAX_SCALE = 8.0f;
        public static final int DEFAULT_PICTURE_VIEWER_NICK_MAX_LENGTH = 10;
        public static final int DEFAULT_PICTURE_VIEWER_PHOTO_LIST_LOADMORE_COUNT = 50;
        public static final String DEFAULT_PICTURE_VIEWER_PIC_INFO_URL = "https://h5.qzone.qq.com/qzone/imginfo/{uin}/{album_id}/{photo_id}";
        public static final int DEFAULT_PICTURE_VIEWER_SHOW_PITU_BUTTON = 0;
        public static final int DEFAULT_PICTURE_VIEWER_SHOW_SHARE_BUTTONS = 1;
        public static final int DEFAULT_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITHOUT_PAGENUM = 200;
        public static final int DEFAULT_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITH_PAGENUM = 144;
        public static final String DEFAULT_PLATO_SCHEMA = "mqqzone://arouse/plato";
        public static final String DEFAULT_PLATO_SHARE_URL = "plato.tswjs.org/share";
        public static final String DEFAULT_PORTRAIT_TEXT = "\u4eba\u7269";
        public static final int DEFAULT_PRELOAD_MAX_SIZE = 10485760;
        public static final int DEFAULT_PRE_DOWNLOAD_VIDEO = 0;
        public static final String DEFAULT_PROFILECARD_MINI_PLAYING_NAME = "\u6700\u8fd1\u5728\u73a9";
        public static final String DEFAULT_PROFILECARD_MINI_PLAYING_NAME_GUEST = "\u4e2a\u4e00\u8d77\u5728\u73a9\u7684\u5c0f\u6e38\u620f";
        public static final String DEFAULT_PROFILECARD_MINI_PLAYING_NAME_GUEST_DEFAULT = "\u4e00\u8d77\u5728\u73a9";
        public static final String DEFAULT_PUBLISH_QUEUE_SAFETY_STRIKE_CODE = "-4015,-4033";
        public static final String DEFAULT_PUBLISH_QUEUE_SAFETY_STRIKE_MESSAGE = "\u4f60\u7684\u5e10\u6237\u88ab\u7981\u6b62\u53d1\u8a00";
        public static final String DEFAULT_PUBLISH_SECRET_SHUOSHUO_H5_URL = "https://h5.qzone.qq.com/secret/add?_proxy=1&_wv=3";
        public static final String DEFAULT_QA_PARAMETER_REX = "qa=[0-9]+&";
        public static final int DEFAULT_QCIRCLE_EDIT_VIDEO_TIME_OUT = 60000;
        public static final int DEFAULT_QQ_CHECK_PHOTO_RED_RANGE = 24;
        public static final int DEFAULT_QQ_CHECK_PHOTO_TIME_RANGE = 1;
        public static final long DEFAULT_QUICK_CAMERA_ANIM_QBOSS_REQ_DELAY = 86400000;
        public static final int DEFAULT_QUN_SHOW_PICTURE_INTENT_LIMIT = 200;
        public static final int DEFAULT_QZONEPLATO_JUMP_NATIVE = 1;
        public static final long DEFAULT_QZONESETTINGS_MOOD_SEND_MINTIMES = 300;
        public static final String DEFAULT_QZONEVIDEO_REPORT = "video_play_source=12";
        public static final String DEFAULT_QZONEVIDEO_SCHEMA = "mqqzone://arouse/livevideo";
        public static final String DEFAULT_QZONEVIDEO_URL = "h5.qzone.qq.com/live/video/qzone/";
        public static final String DEFAULT_QZONE_FRIEND_SETTING_PRIVACY_SECURITY = "https://h5.qzone.qq.com/v2/setting/index?_wv=3&_proxy=1&targetPageKey=commonSetting";
        public static final int DEFAULT_QZONE_LOCATION_CACHE_SAMPLE_RATE = 1;
        public static final int DEFAULT_QZONE_LOCATION_SAMPLE_RATE = 1;
        public static final int DEFAULT_QZONE_PICTURE_LIMIT_WIDTH = 500;
        public static final int DEFAULT_QZONE_PICTURE_OPT_SCALE = 1;
        public static final int DEFAULT_QZONE_PICTURE_PIECE_LOAD = 1;
        public static final String DEFAULT_QZONE_PICUTRE_SETTING_PAGE = "https://h5.qzone.qq.com/image/setting/imageSetting?_wv=3&_proxy=1&uin={uin}";
        public static final String DEFAULT_QZONE_SEARCH_RESULT_URL = "https://h5.qzone.qq.com/platform/ugcsearchinshuoshuo/{hostuin}?_wv=3&_proxy=1&from={from}&_proxyByURL=1";
        public static final String DEFAULT_QZONE_SETTING_MAIN_PAGE = "https://h5.qzone.qq.com/qzone/setting?_wv=3&_proxy=1&uin={uin}";
        public static final boolean DEFAULT_QZONE_SHARE_HLS_VIDEO_TYPE_FIX = true;
        public static final String DEFAULT_QZONE_SHUOSHUO_DAILY_CALENDAR = "https://h5.qzone.qq.com/v2/shuoshuo-daily/calendar/{date}?_wv=16777216";
        public static final String DEFAULT_REDPOCKET_PAYLIST = "https://mqq.tenpay.com/mqq/hongbao/qz/detail.shtml?fid={feedsid}&_wv=2098179&_wvNb=d13d4b&_wvNt=FFFFFF&_wvSb=1&_bid=2280";
        public static final long DEFAULT_REFRESH_INTERVAL = 180000;
        public static final long DEFAULT_REFRESH_INTERVAL2 = 900000;
        public static final String DEFAULT_RES_FORBIDDEN_LIST = "zte m901c,zte g717c";
        public static final String DEFAULT_SEARCH_MOOD_TIPS_FIRST_LINE = "\u641c\u7d22\u529f\u80fd\u4ec5\u53ef\u67e5\u627e\u4e09\u4e2a\u6708\u5185\u52a8\u6001";
        public static final String DEFAULT_SEARCH_MOOD_TIPS_SECOND_LINE = "\u901a\u8fc7\u4e2a\u4eba\u4e3b\u9875\u65f6\u95f4\u8f74\u53ef\u67e5\u770b\u5168\u90e8\u52a8\u6001";
        public static final int DEFAULT_SECONDARY_PICTURE_VIEWER_SHOW_PIC_INFO = 1;
        public static final String DEFAULT_SECRET_FEED_DETAIL_H5_URL = "https://h5.qzone.qq.com/secret/detail/{cellid}/secret?_proxy=1&_wv=1";
        public static final String DEFAULT_SECRET_FEED_LIST_H5_URL = "https://h5.qzone.qq.com/secret/list/{hostuin}/secret?_proxy=1&_wv=3";
        public static final int DEFAULT_SHAREWX_MULTIPIC = 0;
        public static final int DEFAULT_SHARE_ALBUM_JOIN_TIME = 86400;
        public static final int DEFAULT_SHARE_BATCH_PHOTO_TO_MINIPROGRAM = 1;
        public static final String DEFAULT_SHARE_STRUCT_LONG_MESSAGE = "qzone.qq.com";
        public static final String DEFAULT_SHARE_WHITE_LIST = "100733645,1101218289,100497308,1103394134,1106611629,1105705811,1104466820";
        public static final String DEFAULT_SHARING_OWNERS_LIST_TITLE_BABY_ALBUM = "\u5bb6\u5ead\u6210\u5458";
        public static final String DEFAULT_SHARING_OWNERS_LIST_TITLE_REGULAR_ALBUM = "\u76f8\u518c\u6210\u5458";
        public static final int DEFAULT_SHOULD_SHARE_PARTNER_SHOW_ADD_ICON = 1;
        public static final int DEFAULT_SHOW_MAGIC_STICK = 1;
        public static final String DEFAULT_SHOW_NEW_ALBUM_SETTINGS = "0-0";
        public static final String DEFAULT_SHOW_OCR_BUTTON = "0-99";
        public static final int DEFAULT_SHOW_RECOMMEND_PAGE_ENTRY = 1;
        public static final int DEFAULT_SHOW_WEBPICTURE = 0;
        public static final String DEFAULT_SHUOSHUO_FEED_SHARE_DYNAMIC_URL = "https://h5.qzone.qq.com/dynamicAlbum/previewPhoto/{albumid}/{batchid}?_wv=3&_proxy=1&hostuin={hostuin}&albumType=feed&feedTime={feedTime}";
        public static final int DEFAULT_SHUOSHUO_UPLOAD_VIDEO_MAX_COUNT = 10;
        public static final int DEFAULT_SIGN_ENTRANCE_RED_DOT_EXPOSE_TIME = 86400;
        public static final int DEFAULT_SPECIALPUSH_HIDE = 0;
        public static final String DEFAULT_SR_PARAMETER_REX = "sr=[0-9]+&";
        public static final int DEFAULT_SUBPKG_PATH_INTERCEPT = 0;
        public static final float DEFAULT_SUPER_HIGH_PHONE_FRICITION = 0.75f;
        public static final int DEFAULT_SUPER_RESOLUTION_BENCHMARK_CPU_USAGE_THRESHOLD = 50;
        public static final int DEFAULT_SUPER_RESOLUTION_ENABLE_HIGH_SCALE = 1;
        public static final int DEFAULT_SUPER_RESOLUTION_ENABLE_PRE_INIT_LIBRARY = 0;
        public static final String DEFAULT_SUPER_RESOLUTION_GPU_MAX_SIZE = "512,911";
        public static final String DEFAULT_SUPER_RESOLUTION_GPU_RATIO_BOUNDARY = "0.66,0.33";
        public static final int DEFAULT_SUPER_RESOLUTION_MEMORY_THRESHOLD = 100;
        public static final String DEFAULT_SUPER_RESOLUTION_MODEL_CONFIG = "{\"configs\":[{\"id\":1, \"url\":\"https://d3g.qq.com/sngapp/app/update/20170721101107_7712/v60_1.5x_bin.jar\", \"md5\":\"f2667f45d56ca508f63327a9e2113a4c\", \"scale\":1.5, \"protoLength\":1064, \"modelLength\":10074, \"protoMd5\":\"14b0240d4139116774f9d3b6155b7c50\", \"modelMd5\":\"6b75eca2d44779e99fe7e9f564dce049\"},{\"id\":2, \"url\":\"https://d3g.qq.com/sngapp/app/update/20170721101137_7381/v60_2.0x_bin.jar\", \"md5\":\"87e2c001ecb0590e1882ef61446bfb15\", \"scale\":2.0, \"protoLength\":1064, \"modelLength\":10074, \"protoMd5\":\"1d436f51782e7c2ebdc3a5c5a85a4537\", \"modelMd5\":\"57c93630e3ac039294c132cbce592c47\"},{\"id\":3, \"url\":\"https://d3g.qq.com/sngapp/app/update/20170721101409_3753/v62_1.5x_bin.jar\", \"md5\":\"c6b726a07ebb7d8e253541c463eacfb3\", \"scale\":1.5, \"protoLength\":1064, \"modelLength\":8154, \"protoMd5\":\"f5e39cb0f697a164ae2c43067ef179fa\", \"modelMd5\":\"9b818d10ec7266c41b3578ff8f614f2e\"},{\"id\":4, \"url\":\"https://d3g.qq.com/sngapp/app/update/20170721101436_3520/v62_2.0x_bin.jar\", \"md5\":\"7bc0d12fa9884588c06a95778ac833fc\", \"scale\":2.0, \"protoLength\":1064, \"modelLength\":8154, \"protoMd5\":\"f5e39cb0f697a164ae2c43067ef179fa\", \"modelMd5\":\"b86b02f72bd1ecbdf68bcd4550e1f0a3\"},{\"id\":5, \"url\":\"https://d3g.qq.com/sngapp/app/update/20170721101459_6855/v67_1.5x_bin.jar\", \"md5\":\"e6469de6bcde1b19f64ed0071e94067b\", \"scale\":1.5, \"protoLength\":848, \"modelLength\":3678, \"protoMd5\":\"492cf1689e51effb6c6a012bcdc2f498\", \"modelMd5\":\"ccc4de60654d550d8223c7b2fadf4477\"},{\"id\":6, \"url\":\"https://d3g.qq.com/sngapp/app/update/20170721101511_3494/v67_2.0x_bin.jar\", \"md5\":\"8ee6826d4226cce5e492c72be877f91e\", \"scale\":2.0, \"protoLength\":848, \"modelLength\":3678, \"protoMd5\":\"492cf1689e51effb6c6a012bcdc2f498\", \"modelMd5\":\"1f8d662c3c9256fe251138f39a057e62\"}]}";
        public static final float DEFAULT_SUPER_RESOLUTION_SCALE_THRESHOLD = 2.0f;
        public static final int DEFAULT_SUPPORT_VIDEO_CHECKBOX = 1;
        public static final int DEFAULT_TAKE_PHOTO_USING_QQ_CAMERA = 1;
        public static final int DEFAULT_TRAVEL_ALBUM_APPLY_FUNCTION_OPEN = 0;
        public static final int DEFAULT_TRAVEL_ALBUM_INVITE_FUNCTION_OPEN = 1;
        public static final String DEFAULT_UGC_EMPTY_DEFAULT_PAGE_NIGHT_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        public static final String DEFAULT_UGC_EMPTY_DEFAULT_PAGE_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_UGC_EMPTY_NO_NETWORK_PAGE_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190329164139_M5hX693Wjo.png";
        public static final String DEFAULT_UGC_SHUOSHUO_LIST_EMPTY_NEW_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
        public static final String DEFAULT_UGC_SHUOSHUO_LIST_EMPTY_NIGHT_URL = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        public static final String DEFAULT_UGC_SHUOSHUO_LIST_EMPTY_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190329164016_N0Y2CuctLc.png";
        public static final String DEFAULT_UNPUBLISH_SHUO_SHUO_H5_URL = "https://h5.qzone.qq.com/timing/feeds/{hostuin}/{uin}?_proxy=1&_wv=1027&_wwv=4&_proxyByURL=1";
        public static final int DEFAULT_UPLOAD_VIDEO_MAX_COUNT = 50;
        public static final int DEFAULT_URL_ANALYSIS = 0;
        public static final int DEFAULT_USC_SCREEN_OFF_ENABLED = 1;
        public static final String DEFAULT_USER_HOME_SEARCH_SCHEME = "mqqapi://kuikly/open?src_type=internal&version=1&target=52&channel=2&page_name=qsearch_detail&source=1&hide_tab=1&tab_mask=8&user_source=5";
        public static final String DEFAULT_USE_ORIGINAL = "{\"useOriginal\":\"1\"}";
        public static final int DEFAULT_VIDEO_COMPRESS_SW_AVERAGE_SPEED = 75;
        public static final int DEFAULT_VIDEO_COMPRESS_TIMEOUT_RECORD = 300000;
        public static final int DEFAULT_VIDEO_COMPRESS_TIMEOUT_TRIM = 300000;
        public static final int DEFAULT_VIDEO_EXPOSE_REPORT_COUNT = 5;
        public static final int DEFAULT_VIDEO_FLOAT_CONTROLLER_TIMEOUT = 5000;
        public static final int DEFAULT_VIDEO_ILLEGAL_CACHE_DURATION = 600000;
        public static final int DEFAULT_VIDEO_LIST_BANNER_REQUEST_DURATION = 7;
        public static final int DEFAULT_VIDEO_LIST_BANNER_REQUEST_QBOSS = 1;
        public static final int DEFAULT_VIDEO_LIST_BANNER_VISIBLE = 1;
        public static final int DEFAULT_VIDEO_MAX_CACHE_SIZE_LIMIT = 536870912;
        public static final long DEFAULT_VISIT_GUEST_ALBUM_TIME = 1527782400;
        public static final int DEFAULT_WEISHI_VIDEO_LONGESTEDGE = 1280;
        public static final int DEFAULT_WEISHI_VIDEO_MAX_BITRATE = 3000000;
        public static final int DEFAUL_VIDEO_TRIM_MEDIUM_AVAIL_RAM = 629145600;
        public static final int DEFAUL_VIDEO_TRIM_MIN_AVAIL_RAM = 209715200;
        public static final int DEFAUL_VIDEO_TRIM_SUPERFAST_AVAIL_RAM = 419430400;
        public static final int DEFAUL_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM = 314572800;
        public static final int DEFUALT_KEY_PARANORAMAOPENCHECK = 1;
        public static final long DEFUALT_SUPER_RESOLUTION_BENCHMARK_EXPIRE_TIME = 1800000;
        public static final int DEFUALT_SUPER_RESOLUTION_MODEL_ID = 6;
        public static final String DEFUALT_UPLOAD_VIDEO_FILE_SIZE_LIMIT_FOR_NON_VIP = "104857600";
        public static final int DISABLE_SHOW_VIP_INFO = 0;
        public static final String DOWNLOAD_KP_DOMAIN_LIST = "m.qpic.cn,a[0-9].qpic.cn,b\\d+\\.photo\\.store\\.qq\\.com,a\\d+\\.photo\\.store\\.qq\\.com,.*d3g\\.qq\\.com,.*i.gtimg.cn,.*qzonestyle.gtimg.cn,.*qzs.qq.com,qlogo[0-9].store.qq.com,group.store.qq.com,pgdt.gtimg.cn,img[0-7].paipaiimg.com";
        public static final int ENABLE_C2C_AIO_IMAGE_SYNC_TO_QZONE = 1;
        public static final String GET_EMOTIONURL = "https://qzonestyle.gtimg.cn/qzone/em/$id@2x.gif#kp=1";
        public static final int GPS_CACHE_TIME = 300;
        public static final int GPS_LOCATION_NORMAL_TIME_OUT = 5;
        public static final int GPS_LOCATION_PRELOAD_TIME_OUT = 20;
        public static final int IGNORE_LOCAL_JUDGE_RECORD = -1;
        public static final int IGNORE_LOCAL_JUDGE_TRIM = -1;
        public static final int JUMP_QZONE_ENABLE = 1;
        public static final int LATEST_WEBAPP_IP_COUNT = 3;
        public static final int LATEST_WEBAPP_IP_RECORD_SECONDS = 60;
        public static final int LATEST_WEBAPP_TIMESTAMP_COUNT = 3;
        public static final int LBS_PRLOAD = 1;
        public static final int MAX_COMMENT_BUBBLE_COUNT = 40;
        public static final int MAX_UGC_COUNT = 2000;
        public static final int MAX_UGC_MULTI_SHARING_NUMBER = 99;
        public static final int MAX_UGC_SHARING_NUMBERS = 30;
        public static final int MAX_UGC_VISIBLE_LINE_COUNT = 7;
        public static final int MIN_CPU_RECORD = 1150;
        public static final int MIN_RAM_RECORD = 700;
        public static final int MIN_SDK_RECORD = 21;
        public static final int MIN_SDK_TRIM = 14;
        public static final int MIN_SDK_TRIM_HW = 18;
        public static final int MONITOR_AND_REPORT = 2;
        public static final int MONITOR_NOT_REPORT = 1;
        public static final float MOODLIST_BANNER_SHOW_RATIO = 0.0f;
        public static final int MOOD_MAX_PHOTO_SELECT_COUNT = 50;
        public static final int MOOD_RECENT_NEW_PHOTO_TIME = 43200;
        public static final int MOOD_RECENT_PHOTO_COUNT = 10;
        public static final int MOOD_RECENT_PHOTO_TIME = 10;
        public static final int MOOD_SCHEDULE_DELETE_VIDEO = 1;
        public static final int MOOD_SCHEDULE_PUBLISH_VIDEO = 1;
        public static final int MOOD_WEB_PICTURE_OPEN = 1;
        public static final String MSG_LIST_URL = "https://h5.qzone.qq.com/message/index/{uin}/msglist?manu={manu)&_wv=2098179&_proxy=1";
        public static final String NATIVE_HOOK_SDK = "https://d3g.qq.com/sngapp/app/update/20151010153701_9369/hooksdk.jar#865e3233cfb337c075bcd1d6390a5a34";
        public static final String NAVIGATORBAR_ATTRIBUTE = "reportValue&name&iconUrl&schema";
        public static final int NAVIGATORBAR_COUNT = 5;
        public static final String NAVIGATORBAR_ORDER = "2&1&6&3&7";
        public static final int NEED_LOCAL_BLACK_LIST = 1;
        public static final int NEED_SYNC_TO_WEISHI = 1;
        public static final int PERMMIT_DOWNLOAD_VIDEO = 1;
        public static final int PHOTOVIEW_LOADING_DELAY_TIME = 200;
        public static final int PHOTOVIEW_SHOWOPDELAY = 0;
        public static final int PHOTO_DOWNLOAD_KEEP_ALIVE = 0;
        public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_PROXY = 1;
        public static final int PHOTO_RESTRICT_BEGIN = 1170;
        public static final int PHOTO_RESTRICT_END = 1440;
        public static final int PHOTO_RESTRICT_FLAG = 0;
        public static final int PHOTO_TRAFFIC_THRESHOLD = 20480;
        public static final int PHOTO_UPLOAD_MAX_NUM = 99;
        public static final int PHOTO_UPLOAD_QUALITY = 0;
        public static final String PHOTO_UPLOAD_QUALITY_HIGH = "80,80,80";
        public static final String PHOTO_UPLOAD_QUALITY_HIGH_WEBP = "80,80,90";
        public static final String PHOTO_UPLOAD_QUALITY_LOW = "80,80,80";
        public static final String PHOTO_UPLOAD_QUALITY_LOW_WEBP = "75,75,75";
        public static final int PHOTO_UPLOAD_TIER_1_MAX_NUM = 500;
        public static final int PHOTO_UPLOAD_TIER_2_MAX_NUM = 200;
        public static final int PHOTO_UPLOAD_TIER_3_MAX_NUM = 99;
        public static final int PLUGIN_ERROR_HANDLE_COUNT = -1;
        public static final int PLUGIN_PERMISSION_ERROR_HANDLE = 1;
        public static final int POI_CACHE_DISTANCE = 1000;
        public static final int POI_CACHE_TIME = 7;
        public static final int PRELOAD_ACTIVEFEEDS = 1;
        public static final int PRELOAD_CUSTOM_RESOURCES_INTERVAL_SECONDS_DEFAULT = 28800;
        public static final int PRELOAD_FACADE = 1;
        public static final int PRELOAD_GROUPFEEDS = 1;
        public static final int PRELOAD_QZONE_PROCESS_ENABLE = 1;
        public static final int PRELOAD_QZONE_PROCESS_RAM_THRESHOLD = 1024;
        public static final int PUSHBANNER_ACTIVEMAXCOUN = 5;
        public static final int PUSHBANNER_DURATION = 7000;
        public static final int PUSH_DEDUPLICATION = 1;
        public static final int QBOSS_APPID_CUSTOM_RESOURCES_INFO_DEFAULT = 2661;
        public static final int QUOTE_MAX_NUM = 20;
        public static final String QZONECOVER_UPLOADQUALITY = "70,70,70";
        public static final String QZONECOVER_UPLOADRESOLUTION = "640*640,640*640,640*640";
        public static final int QZONESETTINGS_AIO_FEEDS_MAX_RETRY_COUNT = 2;
        public static final int QZONESETTINGS_AIO_FEEDS_MAX_UIN_NUM = 100;
        public static final int QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME = 604800;
        public static final int QZONESETTINGS_AIO_FEEDS_MIN_TIME = 900;
        public static final String QZONE_EVENT_TAG_PIC_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20170323194618_Xgy5reWQh0.png";
        public static final int QZONE_FEED_PRELOAD = 1;
        public static final String QZONE_GAMEBAR_URL = "https://h5.qzone.qq.com/h5plus/homeV2/index/alpha?_proxy=1&_wv=3&via=qqnavigation.2017";
        public static final int QZONE_GIF_DOWNLOAD_AND_PLAY_DEFAULT = 1;
        public static final int QZONE_GIF_DOWNLOAD_AND_PLAY_SDK_LEVEL_DEFAULT = 21;
        public static final int QZONE_HISTORY_EVENT_TAG_CACHE_NUM_DEFAULT = 5;
        public static final int QZONE_IMAGE_MANAGER_GIF_PRE_DOWNLOAD_DEFAULT = 0;
        public static final int QZONE_MOOD_ADD_EVENT_TAG_PAGE_DEFAULT = 1;
        public static final String QZONE_MOOD_ADD_EVENT_TAG_PAGE_H5_URL_DEFAULT = "https://h5.qzone.qq.com/eventTag/list/{hostuin}/eventTagList?_wv=1027&_proxy=1";
        public static final int QZONE_OFFLINE_CACHE_BUFFER_SIZE = 16384;
        public static final int QZONE_OFFLINE_CACHE_ENABLE_DEFAULT = 1;
        public static final int QZONE_RECOMMEND_EVENT_TAG_DESC_TRUNCATE_END_NUM_DEFAULT = 3;
        public static final long QZONE_VIDEO_LAYER_PASTER_VIDEO_ADV_REPLAY_TIME_STAMP = 300;
        public static final int RECENT_GIF_MAXSIZE = 20761804;
        public static final int RECENT_VIDEO_MAXDURATION = 10;
        public static final int RECENT_VIDEO_MAXSIZE = 1610612736;
        public static final String SECONDARY_STAR_VIP_MAIN_PAGE_URL_DEFAULT = "https://xing.qq.com/?aid={aid}&qua={qua}&_wv=1";
        public static final String SERVER_PORT_LIST = "443,80,8080,14000";
        public static final int SHOW_FEED_OPERATION_LAYER = 0;
        public static final int SUPPORTED_CPU_FAMILY_RECORD = 2;
        public static final int SUPPORTED_CPU_FAMILY_TRIM = 2;
        public static final int SUPPORT_RECORD = -1;
        public static final int SUPPORT_TRIM = -1;
        public static final int UPDATE_COUNT_INTERVAL_WHENCLICKFEEDTAB = 30;
        public static final int UPLOAD_ALBUM_MAX_PHOTO_COUNT = 10000;
        public static final int UPLOAD_CONNECT_TIMEOUT = 20;
        public static final int UPLOAD_DATA_TIMEOUT = 60;
        public static final int UPLOAD_LP_REPORT_NOW = 0;
        public static final int UPLOAD_LP_REPORT_SAMPLE = 0;
        public static final int UPLOAD_PICTURE_COMPRESS_QUALITY_LIMIT = 70;
        public static final String UPLOAD_PICTURE_COMPRESS_SIZE_LIMIT = "100,200";
        public static final int UPLOAD_TIMEOUT_RETRY_COUNT = 3;
        public static final int USERHOME_BAR_FAMOUS_ZONE_SHOW = 0;
        public static final String USERHOME_BAR_LOVER_ZONE_NAME = "\u60c5\u4fa3\u7a7a\u95f4";
        public static final int USERHOME_BAR_LOVER_ZONE_SHOW = 1;
        public static final String USERHOME_BAR_NAME = "\u597d\u53cb\u751f\u65e5";
        public static final int USERHOME_BAR_PERSONALIZE_COUNTID = 13;
        public static final String USERHOME_BAR_PERSONALIZE_NAME = "\u4e2a\u6027\u5316";
        public static final String USERHOME_BAR_PERSONALIZE_SHOW = "1";
        public static final String USERHOME_BAR_SHOW = "1";
        public static final String USERHOME_BAR_YELLOW_DIAMOND_NAME = "\u6211\u7684\u9ec4\u94bb";
        public static final String USERHOME_BAR_YELLOW_DIAMOND_SHOW = "0";
        public static final int USERHOME_BAR_musicbar_SHOW = 0;
        public static final String USERHOME_MESSAGE_BOARD_URL = "https://h5.qzone.qq.com/vpage2/bulletboard?uin={uin}&loginuin={loginuin}";
        public static final String VIDEO_LEVEL = "3.0";
        public static final String VIDEO_PRESET = "medium";
        public static final String VIDEO_PRESET_FOR_LOW_CPU = "veryfast";
        public static final String VIDEO_PROFILE = "high";
        public static final String VIDEO_TUNE = "ssim";
        public static final int WEATHER_CACHE_TIME = 300;

        public DefaultValue() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface QzoneConfigChangeListener {
        void onConfigChange();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        Boolean a(String str, String str2, boolean z16);

        String b(String str, String str2);
    }

    QzoneConfig() {
        init();
    }

    public static boolean checkWinkConfigEnableByUid(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        if (Integer.parseInt(str.substring(str.length() - 1)) >= getInstance().getConfig("qqcircle", str2, i3)) {
            return false;
        }
        return true;
    }

    public static boolean checkWinkEditOptimizeOpenByUid(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        if (Integer.parseInt(str.substring(str.length() - 1)) >= getInstance().getConfig("qqcircle", str2, i3)) {
            return false;
        }
        return true;
    }

    public static boolean enableCheckAEResMd5(String str) {
        return checkWinkEditOptimizeOpenByUid(str, SECONDARY_KEY_AERES_CHECK_MD5, 10);
    }

    public static boolean enableDirectIpQZoneConfig() {
        return getInstance().getConfig("QZoneSetting", SECONDARY_KEY_ENABLE_DIRECT_IP_CONFIG, false);
    }

    public static boolean enableDoNewSync() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_AERES_CHECK_MD5, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean enableFirstEditorFrame(String str) {
        return checkWinkEditOptimizeOpenByUid(str, SECONDARY_KEY_EDITOR_FIRST_FRAME, 10);
    }

    public static boolean enableOnlineAssetTab() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_ONLINE_VIDEO_PICKER_TAB_SWITCH, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean enablePreloadPlayer(String str) {
        return checkWinkEditOptimizeOpenByUid(str, SECONDARY_KEY_PRELOAD_PLAYER, 0);
    }

    public static boolean enableUsePrivacyField() {
        return getInstance().getConfig("QZoneSetting", SECONDARY_KEY_ENABLE_USE_PRIVACY_FIELD, false);
    }

    public static boolean enableUserPublishEmoji() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_SUPPORT_PUBLISH_EMOJI, true);
    }

    public static boolean enableWinkPublishGalleryMode() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_PUBLISH_USE_GALLERY_MODE, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean enableWinkSchemaFlatmapToIntent() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_SCHEMA_ENABLE_FLATMAP_TO_INTENT, false);
    }

    public static boolean forceCloseMagicStudio() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_MAGIC_STUDIO_SWITCH, 0) != 1) {
            return false;
        }
        return true;
    }

    public static String getAEAutoTemplateMemoryLimit() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_AUTO_TEMPLATE_MEMORY_LIMIT, DEFAULT_AE_AUTO_TEMPLATE_MEMORY_LIMIT);
    }

    public static String getAEEditorEditedMusicUrl(String str) {
        return getInstance().getConfig(MAIN_KEY_AEEDITOR, SECONDARY_QQCIRCLE_VIDEO_MUSIC_URL, str);
    }

    public static int getAEExportFrameRate() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_FRAME_RATE, 30);
    }

    public static int getAEHighBitRate() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_HIGH_BITRATE, 5);
    }

    public static int getAEHighSize() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_HIGH_SIZE, 1920);
    }

    public static int getAELowBitRate() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_LOW_BITRATE, 3);
    }

    public static int getAELowSize() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_LOW_SIZE, 960);
    }

    public static int getAEMiddleBitRate() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_MIDDLE_BITRATE, 4);
    }

    public static int getAEMiddleSize() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_MIDDLE_SIZE, 1280);
    }

    public static int getAEPicHighSize() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_PIC_HIGH_SIZE, 2560);
    }

    public static int getAEPicLowSize() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_PIC_LOW_SIZE, 1080);
    }

    public static int getAEPicMiddleSize() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_PIC_MIDDLE_SIZE, 1920);
    }

    public static String getAEPicTemPlateFilterBlackList() {
        return getInstance().getConfig("qqcircle", SECONDAER_KEY_AE_PICTEMPLATEFILTERBLACKLIST, "ONEPLUS A5000");
    }

    public static String getApplyAvatarVideoControl() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_AVATAR_VIDEO_CONTROl, "{\"count\": 3,\"day\": 7,\"hour\":2}");
    }

    public static String getApplySignVideoControl() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_SIGN_VIDEO_CONTROl, "{\"count\": 3,\"day\": 7,\"hour\":2}");
    }

    public static int getAudioSeekSwitch() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_AUDIO_SEEK_SWITCH, 0);
    }

    public static int getAutoImageCropSwitch() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_AUTO_CROP_IMAGE_SWITCH, 0);
    }

    public static String getBecomeNuanFriendToastText() {
        return getInstance().getConfig("QZoneSetting", SECONDARY_KEY_BECOME_NUAN_FRIEND_TOAST_TEXT, HardCodeUtil.qqStr(R.string.f21967672));
    }

    public static int getFFMPegDecodeDeviceLevel() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_FFMPEG_DECODE_LEVEL, 6);
    }

    public static int getFilamentPreviewMaxLoadingDuration() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_ZSHOW_FILAMENT_PREVIEW_LOADING_MAX_DURATION, 10000);
    }

    public static boolean getFlashCameraFirstFrameConfig() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_CAMERA_FIRST_FRAME, true);
    }

    public static int getHDModeDownToThreeEnable() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_HDMODE_DOWNTOTHREE_ENABLE, 100);
    }

    public static int getHighQualityEditDeviceLevel() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_HIGH_QUALITY_RENDER_LEVEL, 6);
    }

    public static QzoneConfig getInstance() {
        if (instance == null) {
            synchronized (QzoneConfig.class) {
                if (instance == null) {
                    instance = new QzoneConfig();
                }
            }
        }
        return instance;
    }

    public static String getLastUpdate() {
        String str = "";
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.f99596z3, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    str = cursor.getString(cursor.getColumnIndex("updatelog"));
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "getLastUpdate finally close error: ", QLog.getStackTraceString(e16));
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getLastUpdate error" + e17.getMessage(), e17);
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e18) {
                        QLog.e(TAG, 1, "getLastUpdate finally close error: ", QLog.getStackTraceString(e18));
                    }
                }
            }
            return str;
        } catch (Throwable th5) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e19) {
                    QLog.e(TAG, 1, "getLastUpdate finally close error: ", QLog.getStackTraceString(e19));
                }
            }
            throw th5;
        }
    }

    public static int getLocalPhotoScanFirstInterval() {
        return getInstance().getConfig("PhotoUpload", SECONDARY_ALBUM_PHOTO_SCAN_FIRST_INTEVAL, 7776000);
    }

    public static int getLocalPhotoScanMinInterval() {
        return getInstance().getConfig("PhotoUpload", SECONDARY_ALBUM_PHOTO_SCAN_TIME_INTERVAL, DefaultValue.QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME);
    }

    public static boolean getMaterialZipDeleteSwitch() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_MATERIAL_ZIP_DELELTE, 0) == 2) {
            return false;
        }
        return true;
    }

    public static int getMaxPhotoNumInRecentPhoto() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_MAX_PHOTO_NUM_IN_RECENT_PHOTO, 10000);
    }

    public static int getNextWinkNewCompressAPIEnable() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_NEXT_COMPRESS_NEW_API_ENABLE, 50);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static String getOneConfig(String str, String str2) {
        Cursor cursor;
        int columnIndex;
        String str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        ?? r06 = 0;
        if (str == null || TextUtils.getTrimmedLength(str) <= 0 || str2 == null || TextUtils.getTrimmedLength(str2) <= 0) {
            return null;
        }
        try {
            try {
                try {
                    cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.v3, null, "main_key=? and second_key=?", new String[]{str, str2}, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst() && (columnIndex = cursor.getColumnIndex("value")) >= 0) {
                                str3 = cursor.getString(columnIndex);
                            }
                        } catch (Exception e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, e, "getOneConfig error:");
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return str3;
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    cursor = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (r06 != 0) {
                        try {
                            r06.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e19) {
                e19.printStackTrace();
            }
            return str3;
        } catch (Throwable th6) {
            th = th6;
            r06 = str2;
        }
    }

    public static int getPreviewMaxIntermediateRenderSizeAbove2G() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_PREVIEWMAX_RENDERSIZE_ABOVE_2G, 2048);
    }

    public static int getPreviewMaxIntermediateRenderSizeBelow2G() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_AE_PREVIEWMAX_RENDERSIZE_BELOW_2G, 1024);
    }

    public static boolean getQFSJumpPhotoList() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_QQCIRCLE_NEW_STYLE_DEFAULT_JUMP_PHOTOLIST, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String getQPAdapterParam() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_COMPRESS_ADAPTER_QP_PARAM, DEFAULT_KEY_WINK_COMPRESS_ADAPTER_QP_PARAM);
    }

    public static ArrayList<String> getQQCircleOnlyShowBubbleUins() {
        return new ArrayList<>(Arrays.asList(getInstance().getConfig("qqcircle", SECONDARY_KEY_QQCIRCLE_CHAT_CLUSTER_UINS_ONLY_SHOW_BUBBLE, DEFAULT_QQCIRCLE_CHAT_CLUSTER_UINS_ONLY_SHOW_BUBBLE).split(",")));
    }

    public static boolean getQQCircleShowGuideOnLebaEntrance() {
        if (getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_NEW_GUIDE_ON_DYNAMIC_ENTRANCE, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean getQQCircleShowGuideOnLebaTab() {
        if (getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_NEW_GUIDE_ON_DYNAMIC_TAB, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean getQQCircleShowGuideOnMessageTab() {
        if (getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_NEW_GUIDE_ON_MESSAGE_ENTRANCE, 0) != 1) {
            return false;
        }
        return true;
    }

    public static String getQcircleTroopRedDotIconUrl() {
        return getInstance().getConfig("qqcircle", SECONDARY_QCIRCLE_GROUP_AIO_REDPOINT_ICON_URL, DEFAULT_QCIRCLE_GROUP_AIO_REDPOINT_ICON_URL);
    }

    public static int getQzoneAlbumExposeLimits() {
        int config = getInstance().getConfig("QZoneSetting", SECONDARY_ALBUM_RECOMM_EXPOSE_LIMITS, 10);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "getQzoneAlbumRecommRankCounts:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return config;
    }

    public static int getQzoneAlbumRecommMonthLimits() {
        int config = getInstance().getConfig("QZoneSetting", SECONDARY_ALBUM_RECOMM_MONTH_LIMITS, 3);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "getQzoneAlbumRecommMonthLimits:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return config;
    }

    public static boolean getQzoneAlbumRecommSwitch() {
        boolean config = getInstance().getConfig("QZoneSetting", SECONDARY_ALBUM_RECOMM_SWITCH, true);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "getQzoneAlbumRecommSwitch:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return config;
    }

    public static long getSaveMediaModelDuration() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_KILL_PROCESS_IN_EDITOR_DURATION, 2000);
    }

    public static boolean getSupportDeleteFeedReedit() {
        if (getInstance().getConfig("QZoneSetting", SECONDARY_KEY_SUPPORT_DELETE_FEED_REEDIT, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int getSupportReeditLifeCycle() {
        return getInstance().getConfig("QZoneSetting", SECONDARY_KEY_SUPPORT_REEDIT_LIFE_CYCLE, 300);
    }

    public static boolean getSupportWZShareToWink() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_SUPPORT_WZ_SHARE_TO_WINK, 1) == 1) {
            return true;
        }
        return false;
    }

    public static long getUploadRawVideoByte() {
        return getInstance().getConfig("QZoneSetting", SECONDARY_UPLOAD_BIG_VIDEO_BYTE, 1610612736);
    }

    public static int getUseQPAdapterEnable() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_COMPRESS_ADAPTER_QP_ENABLE, 5);
    }

    public static boolean getUseUploadSeepToExportEnable() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_UPLOADSPEED_TOEXPORT_ENABLE, true);
    }

    public static long getVideoMaxDurationSec() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_VIDEO_MAX_DURATION_SEC, 0);
    }

    public static int getVideoPlayOptimSwitch() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_VIDEO_PLAY_OPTIM_SWITCH, 1);
    }

    public static boolean getWinkBitRateTestEnable() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_BITRATE_ABTEST_ENABLE, true);
    }

    public static int getWinkBitRateTestEndNum() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_BITRATE_ABTEST_ENDNUM, 99);
    }

    public static String getWinkBubbleName(String str) {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_BUBBLE_NAME, str);
    }

    public static int getWinkCancelUploadShowCloseButton() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_SHOW_CANCEL_UPLOAD_BUTTON, 5);
    }

    public static String getWinkEditorEditedMusicUrl(String str) {
        return getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_WINK_VIDEO_MUSIC_URL, str);
    }

    public static float getWinkEditorFrameStickerThreshold() {
        return getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_WINK_FRAME_STICKER_THRESHOLD, 1.0f);
    }

    public static String getWinkEnhanceConfig() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_ENHANCE_CONFIG, SECONDARY_WINK_EDIT_ENHANCE_CONFIG_DEFAULT_URL);
    }

    public static boolean getWinkExportEnableH265ToH264() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_EXPORT_ENABLE_H265_TO_H264, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean getWinkExportEnableSoftEncoder() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_EXPORT_ENABLE_SOFTENCODER, true);
    }

    public static int getWinkHighVideoBitRateEnable() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_HIGH_VIDEO_BITRATE_ENABLE, 10);
    }

    public static String getWinkLightCacheConfigMax() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_LIGHT_CACHE_CONFIG_MAX, "");
    }

    public static String getWinkLightCacheConfigMin() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_LIGHT_CACHE_CONFIG_MIN, "");
    }

    public static int getWinkLightCacheConfigVersion() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_LIGHT_CACHE_CONFIG_VERSION, 0);
    }

    public static int getWinkNewCompressAPIEnable() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_COMPRESS_NEW_API_ENABLE, 0);
    }

    public static float getWinkPickSelectMaxRatio() {
        return getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_WINK_SELECT_MAX_RATIO, 2.5f);
    }

    public static float getWinkPickSelectMinRatio() {
        return getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_WINK_SELECT_MIN_RATIO, 0.375f);
    }

    public static boolean getWinkPreloadWebViewOnLowDevice() {
        return getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_WINK_PRELOADWEB_LOWDEVICE, true);
    }

    public static String getWinkPublishGalleryModeSchema() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_PUBLISH_GALLERY_MODE_SCHEMA, "mqqapi://qcircle/openqqpublish?target=1&input_tabs=a&picker_config=tabType@image,showOnlineAsset@0,showTopRecommend@0&hide_edit_become_video=1&up_source=24&edit_image_mode=1&return_scheme= &enable_gallery_mode=1");
    }

    public static String getWinkPublishHevcBlacklist() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_PUBLISH_HEVC_BLACKLIST, "");
    }

    public static int getWinkPublishHevcOsVersion() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_PUBLISH_HEVC_OS_VERSION, 29);
    }

    public static int getWinkPublishMaxUploadFileSize() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_PUBLISH_MAX_UPLOAD_FILE_SIZE, 1572864000);
    }

    public static String getWinkPublishServiceSampleId() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_PUBLISH_SERVICE_SAMPLE_ID, "14");
    }

    public static int getWinkTAVLogOpen() {
        return getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_WINK_TAVLOG_OPEN, 1);
    }

    public static String getWinkTemplateHideCategoryIconModels() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_TEMPLATE_HIDE_CATEGORY_ICON_MODELS, "M15;LG-H873");
    }

    public static int getWinkTemplateSampleMaxCount() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_TEMPLATE_RECOMMEND_SAMPLE_MAX_COUNT, 4);
    }

    public static float getWinkTemplateSampleQuality() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_TEMPLATE_RECOMMEND_SAMPLE_QUALITY, 0.7f);
    }

    public static int getWinkTemplateSampleShortSideMinValue() {
        return getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_TEMPLATE_RECOMMEND_SHORT_SIDE_MIN_VALUE, 256);
    }

    public static String getWinkThumbSpsConfig() {
        return getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_THUMB_SPS_CONFIG, DEFAULT_KEY_WINK_THUMB_SPS_CONFIG);
    }

    public static boolean getWinkTransitionSwitch() {
        int config = getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_WINK_TRANSITION_SWITCH, 1);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "getWinkTransitionsSwitch:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean guildUseQCirclePicLoader() {
        if (getInstance().getConfig("qqcircle", SECONDARY_GUILD_USE_QCIRCLE_PIC_LOADER, 1) == 1) {
            return true;
        }
        return false;
    }

    private void init() {
        initUnitedConfigProviders();
        registObserver();
        registBroadcast();
        this.mStringHelper = new k05.a();
    }

    private void initConfigUpdateObserver() {
        if (this.configUpdateObserver == null) {
            this.configUpdateObserver = new ContentObserver(null) { // from class: common.config.service.QzoneConfig.2
                @Override // android.database.ContentObserver
                public void onChange(final boolean z16) {
                    ThreadManagerV2.post(new Runnable() { // from class: common.config.service.QzoneConfig.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String lastUpdate = QzoneConfig.getLastUpdate();
                            if (QLog.isColorLevel()) {
                                QLog.d(QzoneConfig.TAG, 2, "QZoneConfigService onChange from:" + lastUpdate + " ,processName:" + MobileQQ.processName + " ,selfChange:" + z16);
                            }
                            if (lastUpdate == null || lastUpdate.equals(MobileQQ.processName)) {
                                QzoneConfig.this.updateConfig();
                            } else {
                                QzoneConfig.getInstance().clearConfigs();
                                QzoneConfig.getInstance().loadAllConfigs();
                            }
                        }
                    }, 5, null, false);
                }
            };
        }
    }

    private void initUnitedConfigProviders() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(QQCIRCLE_ENABLE_SWITCH_WNS_TO_UNITED_CONFIG, true)) {
            this.mUnitedConfigProviders.add(new common.config.service.a());
        }
    }

    public static boolean isBindPeakServiceEnable() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_PUBLISH_BIND_PEAKSERVICE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isCameraPauseSwitch() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_CAMERA_PAUSE_SWITCH, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isEnablePickGameMates() {
        boolean z16;
        if (getInstance().getConfig("QZoneSetting", SECONDARY_KEY_PICK_GAMEMATE, 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QZLog.isColorLevel()) {
            QZLog.e(TAG, 1, "isEnablePickGameMates:" + z16);
        }
        return z16;
    }

    public static boolean isFPSMonitorEnable() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_FPS_MONITOR_ENABLED, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFirstScreenCostMonitorEnable() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_FIRST_SCREEN_COST_MONITOR_ENABLED, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFreezeFrameWhileStickerTrackComputing() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_FREEZE_WHEN_COMPUTING_STICKER_TRACK, 1) == 1) {
            return true;
        }
        return false;
    }

    private boolean isHighFrequency(String str, String str2) {
        if (MAIN_GIF_SETTING.equalsIgnoreCase(str) || MAIN_KEY_QZONE_TEXTCELL_SETTING.equalsIgnoreCase(str) || SECONDARY_CLICKREPORT_COUNT.equalsIgnoreCase(str2) || SECONDARY_CLICKREPORT_INTERVAL.equalsIgnoreCase(str2) || "ipv6_proxy_enable".equalsIgnoreCase(str2) || SECONDARY_THREAD_REGULATED_ENABEL.equalsIgnoreCase(str2) || SECONDARY_SUPER_RESOLUTION_QA_PARAMETER_REX.equalsIgnoreCase(str2) || SECONDARY_IMAGE_BIG_URL_SEGMENT.equalsIgnoreCase(str2) || SECONDARY_IMAGE_JAR_PROGRESS_TRACER.equalsIgnoreCase(str2) || SECONDARY_EMOJI_SHOULD_NOT_BREAK.equalsIgnoreCase(str2) || SECONDARY_MEDIA_PROCESS_NO_PROGRESS_TIMEOUT_DUATION.equalsIgnoreCase(str2) || SECONDARY_UPLOAD_DATA_TIMEOUT.equalsIgnoreCase(str2) || SECONDARY_KEY_WEBVIEW_SECURE_ALL_BUSINESS.equalsIgnoreCase(str2) || SECONDARY_GET_EMOTIONURL.equalsIgnoreCase(str2) || SECONDARY_DOWNLOAD_DIRECT_IP_VIDEO.equalsIgnoreCase(str2) || SECONDARY_DOWNLOAD_BACKUP_IP_VIDEO.equalsIgnoreCase(str2) || SECONDARY_DOWNLOAD_DIRECT_IP.equalsIgnoreCase(str2) || SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP.equalsIgnoreCase(str2) || SECONDARY_DOWNLOAD_EXTRA_MASTER_IP.equalsIgnoreCase(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isLibtemplateInspirationAIPb() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_ENABLE_LIBTEMPLATE_INSPIRATIONAI_PB, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isMagicStudionEditorCheck(String str) {
        return checkWinkEditOptimizeOpenByUid(str, SECONDARY_QQCIRCLE_DISABLE_MAGIC_STUDIO_EDITOR_OPTIMIZATION, 10);
    }

    public static boolean isMemoryMonitorEnable() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_MEMORY_MONITOR_ENABLED, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isMomentNewUserGuideSwitchOpen() {
        if (getInstance().getConfig("QZoneSetting", SECONDARY_KEY_QZONE_MOMENT_NEW_USER_GUIDE_SWITCH, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isNeedSecureVerifyAllBusiness() {
        boolean z16;
        if (getInstance().getConfigSync(MAIN_KEY_WEBVIEW_SETTING, SECONDARY_KEY_WEBVIEW_SECURE_ALL_BUSINESS, 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QZLog.isColorLevel() && !z16) {
            QZLog.e(TAG, 1, "isNeedSecureVerifyAllBusiness:" + z16);
        }
        return z16;
    }

    public static boolean isNotShowFilamentAI() {
        if (getInstance().getConfig("qqcircle", SECONDARY_ZPLAN_FILAMENT_AI_AVATART_SHOW, 1) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotSkipMagicStudioSafeCheck() {
        if (getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_DISABLE_MAGIC_STUDIO_DOWNLOAD, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isOpenFFmpegDecode(int i3, String str) {
        if (i3 == -1 || getFFMPegDecodeDeviceLevel() > i3 || !checkWinkEditOptimizeOpenByUid(str, SECONDARY_WINK_EDIT_FFMPEG_DECODE, 0)) {
            return false;
        }
        return true;
    }

    public static boolean isOpenFastCompress(String str) {
        return checkWinkEditOptimizeOpenByUid(str, SECONDARY_WINK_EDIT_FAST_COMPRESS, 0);
    }

    public static boolean isOpenNonAccurateExtractFrame(String str) {
        return checkWinkEditOptimizeOpenByUid(str, SECONDARY_WINK_EDIT_NON_ACCURATE_EXTRACT_FRAME, 0);
    }

    public static boolean isPicTemplateSwitch(String str) {
        return checkWinkEditOptimizeOpenByUid(str, SECONDARY_KEY_PIC_TEMPLATE_QZONE_SWITCH, 10);
    }

    public static boolean isQQCircleShowAIOFeedEntrance() {
        int config = getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_AIO_FEED, 1);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "isQQCircleShowAIOFeedEntrance:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean isQQCircleShowHighQualityImagePreview() {
        int config = getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_SHOW_HIGH_QUALITY_IMAGE_PREVIEW, 1);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "isQQCircleShowHighQualityImagePreview:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean isQQCircleShowTroopUnreadRedDot() {
        int config = getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_SHOW_GROUP_AIO_REDPOINT, 1, false);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "isQQCircleShowTroopUnreadDialog:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean isQQCircleVideoMusicUseWNSUrl() {
        int config = getInstance().getConfig(MAIN_KEY_AEEDITOR, SECONDARY_QQCIRCLE_VIDEO_MUSIC_USE_WNS_URL, 0);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "isQQCircleShowHighQualityImagePreview:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config != 1) {
            return false;
        }
        return true;
    }

    public static boolean isQQWinkVideoMusicUseWNSUrl() {
        int config = getInstance().getConfig(MAIN_KEY_AEEDITOR, SECONDARY_QQCIRCLE_VIDEO_MUSIC_USE_WNS_URL, 0);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "isQQCircleShowHighQualityImagePreview:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config != 1) {
            return false;
        }
        return true;
    }

    public static boolean isQzoneCompressSwitch(String str) {
        return checkWinkEditOptimizeOpenByUid(str, SECONDARY_KEY_PIC_COMPRESS_QZONE_SWITCH, 10);
    }

    public static boolean isQzoneShowTroopUnreadRedDot() {
        int config = getInstance().getConfig("qqcircle", SECONDARY_QZONE_SHOW_GROUP_AIO_REDPOINT, 1);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "isQzoneShowTroopUnreadDialog:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean isQzoneTroopUnreadAllReport() {
        int config = getInstance().getConfig("qqcircle", SECONDARY_QZONE_GROUP_AIO_REDPOINT_REPORT_METHOD, 0);
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "isQzoneTroopUnreadAllReport:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config != 1) {
            return false;
        }
        return true;
    }

    public static boolean isRenderModelExport() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_RENDERMODEL_EXPORT_SWITCH, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isRenderSizeSyncOuputExport() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_EDIT_RENDERSIZE_SYNC_OUTPUT, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isShowWinkLiveEntrance() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_SHOW_WINK_LIVE_ENTRANCE, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isShowWinkTemplateLibrary() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_SHOW_WINK_TEMPLATE_LIBRARY, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isShowWinkZShow() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_SHOW_WINK_ZSHOW, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isTemplateCollUseMovieControllerDuration() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_TEMPLATE_COLL_DURATION, 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isUpdatePlayerForAndroidMWhenResume() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_UPDATE_PLAYER_WHEN_RESUME, 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isUseNewMusicOffsetDuration() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_MUSIC_OFFSET_DURATION, 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isUseNewReloadAssetSwitch() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_RELOAD_SWITCH, 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isUseNewSmartFilter() {
        if (getInstance().getConfig("qqcircle", SECONDARY_WINK_SMART_FILTER_DEFAULT, 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isUseNewTemplateLibMediaPickerLogic() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_USE_NEW_TEMPLATE_LIB_PICKER_LOGIC, 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isWinkEditorSupportOriginFrameRate() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_EXPORT_SUPPORT_ORIGIN_FRAMERATE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isWinkPublishEnableCompressHDR() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_PUBLISH_ENABLE_COMPRESS_HDR, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isWinkPublishEnableHevc() {
        if (getInstance().getConfig("qqcircle", SECONDARY_KEY_WINK_PUBLISH_ENABLE_HEVC, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isWinkPublishLimitVideoResolution() {
        if (getInstance().getConfig("qqcircle", SECONDARY_QQCIRCLE_WINK_LIMIT_VIDEO_RESOLUTION, 0) != 1) {
            return false;
        }
        return true;
    }

    private void registBroadcast() {
        if (BaseApplication.getContext() != null && BaseApplication.getContext().getContentResolver() != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
            intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            intentFilter.addAction(NewIntent.ACTION_LOGOUT);
            intentFilter.addAction(NewIntent.ACTION_LOGIN);
            MobileQQ.sMobileQQ.registerReceiver(new BroadcastReceiver() { // from class: common.config.service.QzoneConfig.3
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, final Intent intent) {
                    ThreadManagerV2.excute(new Runnable() { // from class: common.config.service.QzoneConfig.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!intent.getAction().equals(NewIntent.ACTION_ACCOUNT_KICKED) && !intent.getAction().equals(NewIntent.ACTION_FORCE_LOGOUT) && !intent.getAction().equals(NewIntent.ACTION_LOGOUT)) {
                                if (intent.getAction().equals(NewIntent.ACTION_ACCOUNT_CHANGED) || intent.getAction().equals(NewIntent.ACTION_LOGIN)) {
                                    QzoneConfig.getInstance().clearConfigs();
                                    QzoneConfig.getInstance().loadAllConfigs();
                                    return;
                                }
                                return;
                            }
                            QzoneConfig.getInstance().clearConfigs();
                        }
                    }, 16, null, true);
                }
            }, intentFilter);
        }
    }

    private void registObserver() {
        if (BaseApplication.getContext() != null && BaseApplication.getContext().getContentResolver() != null) {
            try {
                initConfigUpdateObserver();
                BaseApplication.getContext().getContentResolver().registerContentObserver(com.tencent.common.config.provider.d.f99596z3, true, this.configUpdateObserver);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "registObserver \u5f02\u5e38", e16);
                }
            }
        }
    }

    private void saveLogTime(String str, String str2) {
        this.mConfigLogMap.put(str + "_" + str2, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean shouldPreloadTravelGroup() {
        return getInstance().getConfig("QZoneSetting", SECONDARY_KEY_SHOULD_PRELOAD_TRAVEL_GROUP, false);
    }

    private boolean shouldPrintLog(boolean z16, String str, String str2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 24 && i3 != 25) {
            Long l3 = this.mConfigLogMap.get(str + "_" + str2);
            if (l3 == null) {
                l3 = 0L;
            }
            long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
            if (z16 && !isHighFrequency(str, str2) && currentTimeMillis > 1000) {
                return true;
            }
            return false;
        }
        if (z16 && !isHighFrequency(str, str2)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConfig() {
        getInstance().notifyConfigChange();
    }

    private static void updateToWnsConfigDB(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("main_key", str);
        contentValues.put("second_key", str2);
        contentValues.put("value", str3);
        String[] strArr = {str, str2};
        try {
            ContentResolver contentResolver = BaseApplication.getContext().getContentResolver();
            Uri uri = com.tencent.common.config.provider.d.v3;
            py3.b.e(contentResolver, uri, "main_key=? and second_key=? ", strArr);
            BaseApplication.getContext().getContentResolver().insert(uri, contentValues);
            QLog.d(TAG, 1, "[updateToWnsConfigDB] mainKey: " + str + " | secondKey: " + str2 + " | value: " + str3);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[updateToWnsConfigDB] error: ", th5);
        }
    }

    public static boolean useAigcOldApiSwitch() {
        if (getInstance().getConfig("qqcircle", SECONDARY_ENABLE_LONG_TIME_OUT_AIGC_INTERFACE, 0) != 0) {
            return false;
        }
        return true;
    }

    public synchronized void addListener(QzoneConfigChangeListener qzoneConfigChangeListener) {
        if (qzoneConfigChangeListener == null) {
            return;
        }
        Iterator<WeakReference<QzoneConfigChangeListener>> it = this.mCallback.iterator();
        while (it.hasNext()) {
            WeakReference<QzoneConfigChangeListener> next = it.next();
            if (next != null) {
                QzoneConfigChangeListener qzoneConfigChangeListener2 = next.get();
                if (qzoneConfigChangeListener2 == null) {
                    it.remove();
                } else if (qzoneConfigChangeListener.equals(qzoneConfigChangeListener2)) {
                    return;
                }
            }
        }
        this.mCallback.add(new WeakReference<>(qzoneConfigChangeListener));
    }

    public void clearConfigs() {
        this.configMap.clear();
        this.loadstatus = 0;
        this.isNewStylePublicAccountPage = null;
    }

    public void deleteConfigs(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (str != null && (concurrentHashMap = this.configMap.get(str)) != null && concurrentHashMap.size() > 0) {
            concurrentHashMap.clear();
        }
    }

    public String getConfig(String str, String str2) {
        return getConfig(true, str, str2);
    }

    public Object getConfigByObject(String str, String str2, Object obj) {
        if (obj instanceof String) {
            return getConfig(str, str2, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(getConfig(str, str2, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(getConfig(str, str2, ((Long) obj).longValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(getConfig(str, str2, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(getConfig(str, str2, ((Float) obj).floatValue()));
        }
        return null;
    }

    public String getConfigFromProvider(String str, String str2) {
        try {
            Iterator<a> it = this.mUnitedConfigProviders.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    return next.b(str, str2);
                }
            }
            return null;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "[getConfigFromProvider] error", th5);
                return null;
            }
            return null;
        }
    }

    public float getConfigSync(String str, String str2, float f16) {
        String configSync = getConfigSync(str, str2);
        if (configSync == null) {
            return f16;
        }
        try {
            return Float.valueOf(configSync).floatValue();
        } catch (Exception unused) {
            return f16;
        }
    }

    public Rect getGifDisplayConfig() {
        return new Rect(getConfig(MAIN_GIF_SETTING, SECONDARY_CROP_GIF_EDGELEFT, 1), getConfig(MAIN_GIF_SETTING, SECONDARY_CROP_GIF_EDGETOP, 1), getConfig(MAIN_GIF_SETTING, SECONDARY_CROP_GIF_EDGERIGHT, 1), getConfig(MAIN_GIF_SETTING, SECONDARY_CROP_GIF_EDGEBOTTOM, 2));
    }

    public Boolean getSwitchFromProvider(String str, String str2, boolean z16) {
        try {
            Iterator<a> it = this.mUnitedConfigProviders.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    return next.a(str, str2, z16);
                }
            }
            return null;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "[getSwitchFromProvider] error", th5);
                return null;
            }
            return null;
        }
    }

    public boolean isNewStylePublicAccountPage() {
        if (this.isNewStylePublicAccountPage == null) {
            this.isNewStylePublicAccountPage = Boolean.valueOf(QZoneConfigHelper.x());
        }
        return this.isNewStylePublicAccountPage.booleanValue();
    }

    public void loadAllConfigs() {
        if (Looper.getMainLooper().getThread().getId() != Thread.currentThread().getId()) {
            if (1 == this.loadstatus || 2 == this.loadstatus) {
                return;
            }
            QLog.d(TAG, 1, "loadAllConfigs :" + this.loadstatus);
            this.loadstatus = 1;
            try {
                if (loadAllConfigs(this.configMap)) {
                    this.loadstatus = 2;
                    updateConfig();
                } else {
                    this.loadstatus = 3;
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "loadAllConfigs \u5f02\u5e38", e16);
                }
                this.loadstatus = 3;
                return;
            }
        }
        throw new IllegalStateException("\u4e0d\u8981\u5728UI\u7ebf\u7a0b\u4e2d\u8c03\u7528\u6b64\u65b9\u6cd5");
    }

    public void notifyConfigChange() {
        QzoneConfigChangeListener qzoneConfigChangeListener;
        try {
            for (WeakReference weakReference : (WeakReference[]) this.mCallback.toArray(new WeakReference[this.mCallback.size()])) {
                if (weakReference != null && (qzoneConfigChangeListener = (QzoneConfigChangeListener) weakReference.get()) != null) {
                    qzoneConfigChangeListener.onConfigChange();
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "notifyConfigChange error", th5);
            }
        }
    }

    public void printWNSConfig(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            loadAllConfigs();
            if (TextUtils.isEmpty(str)) {
                QLog.i(PRINTCONFIG_TAG, 1, "\u6253\u5370\u5168\u90e8\u914d\u7f6e");
                for (String str3 : this.configMap.keySet()) {
                    QLog.i(PRINTCONFIG_TAG, 1, "mainKey = " + str3);
                    ConcurrentHashMap<String, String> concurrentHashMap = this.configMap.get(str3);
                    Set<String> keySet = concurrentHashMap.keySet();
                    QLog.i(PRINTCONFIG_TAG, 1, "\u5f53\u524d\u7684\u7684rawSet\u4e2a\u6570:" + keySet.size());
                    for (String str4 : keySet) {
                        QLog.i(PRINTCONFIG_TAG, 1, str4 + " = " + concurrentHashMap.get(str4));
                    }
                }
            } else {
                QLog.i(PRINTCONFIG_TAG, 1, "\u6253\u5370\u5bf9\u5e94mainkey:" + str + "\u7684\u914d\u7f6e");
                ConcurrentHashMap<String, String> concurrentHashMap2 = this.configMap.get(str);
                Set<String> keySet2 = concurrentHashMap2.keySet();
                QLog.i(PRINTCONFIG_TAG, 1, "\u5f53\u524d\u7684\u7684rawSet\u4e2a\u6570:" + keySet2.size());
                for (String str5 : keySet2) {
                    QLog.i(PRINTCONFIG_TAG, 1, str5 + " = " + concurrentHashMap2.get(str5));
                }
            }
        } else {
            QLog.i(PRINTCONFIG_TAG, 1, "\u6253\u5370\u5bf9\u5e94mainkey:" + str + ",\u5bf9\u5e94secondKey:" + str2 + "\u7684\u914d\u7f6e");
            String config = getConfig(str, str2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(" = ");
            sb5.append(config);
            QLog.i(PRINTCONFIG_TAG, 1, sb5.toString());
        }
        QLog.i(PRINTCONFIG_TAG, 1, "\u7ed3\u675f\u6253\u5370WNS\u914d\u7f6e");
    }

    public synchronized void removeListener(QzoneConfigChangeListener qzoneConfigChangeListener) {
        QzoneConfigChangeListener qzoneConfigChangeListener2;
        if (qzoneConfigChangeListener == null) {
            return;
        }
        Iterator<WeakReference<QzoneConfigChangeListener>> it = this.mCallback.iterator();
        while (it.hasNext()) {
            WeakReference<QzoneConfigChangeListener> next = it.next();
            if (next != null && ((qzoneConfigChangeListener2 = next.get()) == null || qzoneConfigChangeListener.equals(qzoneConfigChangeListener2))) {
                it.remove();
            }
        }
    }

    public void updateOneConfig(String str, String str2, String str3, boolean z16) {
        String lowerCase;
        String lowerCase2;
        if (str == null || str2 == null || str3 == null) {
            return;
        }
        QLog.e(TAG, 1, "mainKey :" + str + "  secondKey : " + str2 + "  value: " + str3);
        k05.a aVar = this.mStringHelper;
        if (aVar != null && aVar.a()) {
            lowerCase = this.mStringHelper.c(str);
            lowerCase2 = this.mStringHelper.c(str2);
        } else {
            lowerCase = str.toLowerCase();
            lowerCase2 = str2.toLowerCase();
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.configMap.get(lowerCase);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.configMap.put(lowerCase, concurrentHashMap);
        }
        concurrentHashMap.put(lowerCase2, str3);
        if (z16) {
            updateConfig();
        }
    }

    public void updateOneConfigAndDB(String str, String str2, String str3) {
        updateOneConfig(str, str2, str3, true);
        updateToWnsConfigDB(str, str2, str3);
    }

    public String getConfig(boolean z16, String str, String str2) {
        String lowerCase;
        String lowerCase2;
        if (str == null || str2 == null) {
            return null;
        }
        k05.a aVar = this.mStringHelper;
        if (aVar != null && aVar.a()) {
            lowerCase = this.mStringHelper.c(str);
            lowerCase2 = this.mStringHelper.c(str2);
        } else {
            lowerCase = str.toLowerCase();
            lowerCase2 = str2.toLowerCase();
        }
        String configFromProvider = getConfigFromProvider(lowerCase, lowerCase2);
        if (configFromProvider != null) {
            return configFromProvider;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.configMap.get(lowerCase);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.configMap.put(lowerCase, concurrentHashMap);
        }
        String str3 = concurrentHashMap.get(lowerCase2);
        if (str3 == null && 2 != this.loadstatus && 1 != this.loadstatus) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread, false).post(new Runnable() { // from class: common.config.service.QzoneConfig.1
                @Override // java.lang.Runnable
                public void run() {
                    QzoneConfig.this.loadAllConfigs();
                }
            });
            if (shouldPrintLog(z16, lowerCase, lowerCase2)) {
                saveLogTime(lowerCase, lowerCase2);
            }
        }
        try {
            if (shouldPrintLog(z16, lowerCase, lowerCase2)) {
                if (!TextUtils.isEmpty(str3) && !"null".equalsIgnoreCase(str3.trim())) {
                    QLog.i(TAG, 1, "key = " + lowerCase + " secondaryKey= " + lowerCase2 + " value= " + str3);
                }
                saveLogTime(lowerCase, lowerCase2);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5, new Object[0]);
            }
        }
        return str3;
    }

    public String getConfigSync(String str, String str2, String str3) {
        String configSync = getConfigSync(str, str2);
        return TextUtils.isEmpty(configSync) ? str3 : configSync;
    }

    public int getConfigSync(String str, String str2, int i3) {
        String configSync = getConfigSync(str, str2);
        if (configSync == null) {
            return i3;
        }
        try {
            return Integer.valueOf(configSync).intValue();
        } catch (Exception unused) {
            return i3;
        }
    }

    public long getConfigSync(String str, String str2, long j3) {
        String configSync = getConfigSync(str, str2);
        if (configSync == null) {
            return j3;
        }
        try {
            return Long.valueOf(configSync).longValue();
        } catch (Exception unused) {
            return j3;
        }
    }

    public String getConfigSync(String str, String str2) {
        String lowerCase;
        String lowerCase2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        k05.a aVar = this.mStringHelper;
        if (aVar != null && aVar.a()) {
            lowerCase = this.mStringHelper.c(str);
            lowerCase2 = this.mStringHelper.c(str2);
        } else {
            lowerCase = str.toLowerCase();
            lowerCase2 = str2.toLowerCase();
        }
        String configFromProvider = getConfigFromProvider(lowerCase, lowerCase2);
        if (configFromProvider != null) {
            return configFromProvider;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.configMap.get(lowerCase);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.configMap.put(lowerCase, concurrentHashMap);
        }
        String str3 = concurrentHashMap.get(lowerCase2);
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        String oneConfig = getOneConfig(lowerCase, lowerCase2);
        if (TextUtils.isEmpty(oneConfig)) {
            return oneConfig;
        }
        concurrentHashMap.put(lowerCase2, oneConfig);
        return oneConfig;
    }

    public void updateOneConfig(String str, String str2, String str3) {
        updateOneConfig(str, str2, str3, true);
    }

    public static boolean loadAllConfigs(Map<String, ConcurrentHashMap<String, String>> map) throws Exception {
        boolean z16 = true;
        Cursor cursor = null;
        try {
            try {
                map.clear();
                QLog.d(TAG, 1, "loadAllConfigs : clear all");
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.v3, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (string != null && string2 != null) {
                            String string3 = cursor.getString(2);
                            ConcurrentHashMap<String, String> concurrentHashMap = map.get(string);
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap<>();
                                map.put(string, concurrentHashMap);
                            }
                            concurrentHashMap.put(string2, string3);
                        }
                    }
                    QLog.d(TAG, 1, "loadAllConfigs : success");
                } else {
                    z16 = false;
                }
                return z16;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "loadAllConfigs error:", e16);
                }
                if (cursor == null) {
                    return false;
                }
                try {
                    cursor.close();
                    return false;
                } catch (Exception e17) {
                    if (!QLog.isColorLevel()) {
                        return false;
                    }
                    QLog.e(TAG, 2, "loadAllConfigs error:", e17);
                    return false;
                }
            }
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "loadAllConfigs error:", e18);
                    }
                }
            }
        }
    }

    public float getConfig(String str, String str2, float f16) {
        String config = getConfig(str, str2);
        if (config == null) {
            return f16;
        }
        try {
            return Float.valueOf(config).floatValue();
        } catch (Exception unused) {
            return f16;
        }
    }

    public boolean getConfig(String str, String str2, boolean z16) {
        Boolean switchFromProvider = getSwitchFromProvider(str, str2, z16);
        if (switchFromProvider != null) {
            return switchFromProvider.booleanValue();
        }
        String config = getConfig(str, str2);
        if (config == null) {
            return z16;
        }
        try {
            return Boolean.parseBoolean(config);
        } catch (Exception unused) {
            return z16;
        }
    }

    public String getConfig(String str, String str2, String str3) {
        String config = getConfig(str, str2);
        return TextUtils.isEmpty(config) ? str3 : config;
    }

    public String getConfig(String str, String str2, String str3, boolean z16) {
        String config = getConfig(z16, str, str2);
        return TextUtils.isEmpty(config) ? str3 : config;
    }

    public int getConfig(String str, String str2, int i3) {
        return getConfig(str, str2, i3, true);
    }

    public int getConfig(String str, String str2, int i3, boolean z16) {
        String config = getConfig(z16, str, str2);
        if (config == null) {
            return i3;
        }
        try {
            return Integer.valueOf(config).intValue();
        } catch (Exception unused) {
            return i3;
        }
    }

    public long getConfig(String str, String str2, long j3, boolean z16) {
        String config = getConfig(z16, str, str2);
        if (config == null) {
            return j3;
        }
        try {
            return Long.valueOf(config).longValue();
        } catch (Exception unused) {
            return j3;
        }
    }

    public long getConfig(String str, String str2, long j3) {
        String config = getConfig(str, str2);
        if (config == null) {
            return j3;
        }
        try {
            return Long.valueOf(config).longValue();
        } catch (Exception unused) {
            return j3;
        }
    }
}
