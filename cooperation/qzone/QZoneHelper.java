package cooperation.qzone;

import NS_MOBILE_QQ.RES_ITEM_COVER;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.taf.jce.JceInputStream;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.hitrate.b;
import com.tencent.mobileqq.model.c;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.t;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ec;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.g;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQZoneHelperProxy;
import com.tencent.qzonehub.api.IQZonePageApi;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import com.tencent.qzonehub.api.IQzoneReq;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.util.URLUtil;
import com.tencent.util.pm.PackageUtil;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZoneNumberUtil;
import cooperation.qzone.util.TimeCostTrace;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import vy3.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneHelper {
    public static final String ACTION_CANCEL_QZONE_ALVIE = "com.qzone.intent.action.CANCEL_QZONE_ALIVE";
    public static final String ACTION_LAUNCH_PUBLISH_QUEUE = "com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE";
    public static final String ACTION_PRELOAD_FRIEND_FEEDS = "com.qzone.intent.action.PRELOAD_FRIEND_FEEDS";
    public static final String ACTION_PRELOAD_NOTHING = "com.qzone.intent.action.PRELOAD_NOTHING";
    public static final String ACTION_PRELOAD_QCIRCLE_PUBLISH = "com.qzone.intent.action.PRELOAD_QCIRCLE_PUBLISH";
    public static final String ACTION_PRELOAD_QUN_ALBUM_FEEDS = "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS";
    public static final String ACTION_PRELOAD_USER_HOME = "com.qzone.intent.action.PRELOAD_USER_HOME";
    public static final String ACTION_SHORT_CUT = "intent.start.shortcut.guide";
    public static final String ACTION_SHOW_FOLLOW_ACTION_SHEET = "showFollowActionSheet";
    public static final String ACTION_UNREAD_COUNT = "com.tencent.qq.unreadcount";
    public static final String ACTION_UPDATE_IS_SPEICAL_FOLLOW = "updateIsSpecialFollow";
    public static final String BROADCAST_RECEIVER_PERMISSION = "com.qzone.permissionsetting.business.QZonePermissionReciver";
    public static final String BROADCAST_SYNC_QUN_UNREAD_MESSAGE = "com.tencent.qq.syncQunMsg";
    public static final String CIPHERTEXT = "ciphertext";
    private static final String CLS_QZONEAPPINTERFACE = "com.qzone.app.QZoneAppInterface";
    private static final String CLS_QZONEPICTURE_APPINTERFACE = "com.qzone.preview.QZonePictureAppInterface";
    public static final String CMD_PREFIX_PUBLIC = "SQQzoneSvc.";
    public static final String COMMON_UPLOAD = "com.qzone.reborn.base.QZoneCommonUploadActivity";
    public static final String COVER_PHOTO_WALL = "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity";
    public static final String COVER_STORE = "com.qzone.cover.ui.activity.QZoneCoverStoreActivity";
    public static final String DETAIL = "com.qzone.detail.ui.activity.QzoneDetailActivity";
    public static final String FAMOUS_SPACE_ACTION_URL_CONFIG_NAME = "QzoneFamousSpaceSp";
    public static final String FAMOUS_SPACE_CANCEL_FOLLOW_ACTION = "FamouseSpaceCancelFollowAction";
    public static final String FAMOUS_SPACE_JS_CALL_NATIVE_ACTION = "JsCallNativeAction";
    public static final String FRIEND_FEED = "com.qzone.feed.ui.activity.QZoneFriendFeedActivity";
    public static final String FRIEND_FEEDX = "com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity";
    public static final String FRIEND_FEED_PRO = "com.qzone.reborn.feedpro.activity.QzoneFriendFeedProActivity";
    public static final String FROM_USER_HOME = "com.qzone.homepage.from_user_home";
    public static final String GALLERY_VIEWER = "com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity";
    public static final String HOME_PAGE_SPACE_JS_CALL_REFLUSH_NAVIGATION_BAR = "JsCallReflushNavigationBar";
    public static final String INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI = "key_select_poi";
    public static final String INTENT_ACTION_CREATE_ALBUM_SHORTCUT = "com.qzone.album.CreateAlbumShortcutSucceedReceiver";
    public static final String INTENT_ENTRY_TYPE = "qzone_entry";
    public static final String INTENT_EXTINFO = "extinfo";
    public static final String INTENT_EXTINFO_JUMP_TO_DYNAMIC_SETTING = "jump_to_dynamic_setting";
    public static final String INTENT_FAMOUS_SPACE_WEBVIEW_URL = "famous_space_webview_url";
    public static final String INTENT_GO_FIRST_FEED = "go_first_feed";
    public static final String INTENT_HOME_PAGE_AUTO_SHOW_TIME_LINE = "autoShowTimeLine";
    public static final String INTENT_PICTURE_BOOT_SERVICE = "com.qzone.preview.service.PictureProcessBootService";
    public static final String INTENT_QZONE_BOOT_SERVICE = "com.qzone.preview.service.PictureService";
    public static final String INTENT_QZONE_PUBLISHQUEUE_SERVICE = "com.qzone.publish.business.publishqueue.PublishQueueService";
    public static final String INTENT_QZONE_VIDEO_SERVICE = "com.qzone.video.service.QzoneVideoPluginService";
    public static final String INTENT_REDPOCKET = "redpocket";
    public static final String INTENT_SHOW_FAMOUS_SPACE_ACTIVITY_PAGE_TYPE = "famous_space_page_type";
    public static final String INTENT_UIN = "qqid";
    public static final String IS_FROM_MINI_APP = "is_from_mini_app";
    public static final String KEY_CAN_SET_LAYOUT_INFLATER_FACTORY = "key_can_set_layoutInfalter_factory";
    public static final String KEY_FAMOUS_SPACE_CONCERN = "isconcern";
    public static final String KEY_FAMOUS_SPACE_NAVIGATION_BAR_INFO = "navigationBar";
    public static final String KEY_FAMOUS_SPACE_UIN = "uin";
    public static final String KEY_FROM_H5_COVER_USER_HOME = "key_from_h5_cover_user_home";
    public static final String KEY_FROM_NATIVE_USER_HOME = "key_from_native_user_home";
    public static final String KEY_HAS_TALK = "key_has_talk";
    public static final String KEY_HIDE_QZONE_ICON = "k_hide_qzone_icon";
    public static final String KEY_IS_KEEP_ALIVE = "key_is_keep_alive";
    private static final String KEY_IS_QZONE_PUBLIC = "isQzonePublic";
    public static final String KEY_JUMP_FROM = "key_jump_from";
    public static final String KEY_MODAL = "k_modal";
    public static final String KEY_NEARBY_PROFILE = "key_nearby_profile";
    public static final String KEY_NEARBY_QZONE_TO_AIO = "key_nearby_qzone_to_aio";
    public static final String KEY_NICKNAME = "nickName";
    public static final String KEY_NOT_SHOW_SPECIAL_TOAST = "noSpecialCareToast";
    public static final String KEY_QZONE_NICKNAME = "nickname";
    public static final String KEY_QZONE_SID = "sid";
    public static final String KEY_QZONE_UIN = "qzone_uin";
    public static final String KEY_QZONE_VIP_OPEN_BACK_NEED_CHECK_VIPINFO = "key_qzone_vip_open_back_need_check_vipinfo";
    public static final String KEY_UIN = "uin";
    public static final String MOOD_SELECT_LOCATION = "com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation";
    public static final String NEARBY_QZONE_TO_AIO = "nearby_qzone_to_aio";
    public static final String OPEN_VIP = "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity";
    public static final String PACKAGENAME_QQMUSIC = "com.tencent.qqmusic";
    public static final String PAGE_BROWSER = "com.qzone.cover.ui.activity.QZoneBrowserActivity";
    public static final String PAGE_DIALOG = "com.qzone.common.activities.QzoneDialogActivity";
    public static final String PAGE_DYNAMIC_VIDEO_EDIT = "com.qzone.album.ui.activity.QzDynamicVideoEditActivity";
    public static final String PAGE_ENCOURAGE_ADV = "com.qzone.preview.QZoneEncourageAdvActivity";
    public static final String PAGE_FLASH_NICK_NAME_SETTING = "com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting";
    public static final String PAGE_MOOD_LIST = "com.qzone.homepage.ui.activity.QzoneMoodListActivity";
    public static final String PAGE_MY_FEED = "com.qzone.feed.ui.activity.QZoneMyFeedActivity";
    public static final String PAGE_SPECIAL_ACTIVE_FEED = "com.qzone.feed.ui.activity.QZoneSpecialActiveFeedsActivity";
    public static final String PAGE_VIDEO_VIEW = "com.qzone.video.activity.VideoViewActivity";
    public static final int PERFORMANCE_LEVEL_HIGH = 3;
    public static final int PERFORMANCE_LEVEL_LOW = 1;
    public static final int PERFORMANCE_LEVEL_MIDDLE = 2;
    public static final int PERFORMANCE_LEVEL_SUPER_HIGH = 4;
    public static final String PERMISSION_SETTING = "com.qzone.setting.QZoneSettingManager";
    public static final String PERSONAL_ALBUM = "com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity";
    public static final String PERSONAL_ALBUM_SELECT = "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity";
    public static final String PERSONAL_PHOTO_LIST = "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity";
    public static final String PICTURE_VIEWER_FRAGMENT = "com.qzone.reborn.layer.part.QZonePictureViewerFragment";
    public static final String PUBLISH_BOX = "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity";
    public static final String PUBLISH_QUEUE = "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity";
    public static final String QQ_PUBLIC_ACCOUNT_PUBLISH_PAGE = "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity";
    public static final String QZONE_ALBUM_SHORTCUT_ACTION_TYPE = "isGoCreateAlbumShortcut";
    public static final int QZONE_ALBUM_SHORTCUT_ACTION_TYPE_CREATE = 1;
    public static final int QZONE_ALBUM_SHORTCUT_ACTION_TYPE_UPDATE = 2;
    public static final int QZONE_ALBUM_SHORTCUT_ACTION_TYPE_UPDATE_WITH_REDPOT = 3;
    public static final String QZONE_ALBUM_SHORTCUT_CREATE_FAILED = "AlbumCreateShortcutFailed";
    public static final String QZONE_CATEGORY_ALBUM_ACTIVITY = "com.qzone.album.business.albumlist.activity.QzonePhotoCategoryDetailsActivity";
    public static final String QZONE_FEEDACTIONPANELACTIVITY = "com.qzone.common.activities.FeedActionPanelActivity";
    public static final String QZONE_KEY_PUBLISH_MOOD_CAMERA_FLAG = "qzone_key_publish_mood_camera_flag";
    public static final String QZONE_PRELOAD_FROM_ALBUM_SELECT = "album_select";
    public static final String QZONE_PRELOAD_FROM_FEEDX = "feedx";
    public static final String QZONE_PRELOAD_FROM_FRIEND_PROFILE = "FriendProfileCardActivity";
    public static final String QZONE_PRELOAD_FROM_LEBA_CLICK = "Leba";
    public static final String QZONE_PRELOAD_FROM_LEBA_REDDOT = "MainAssistObserver";
    public static final String QZONE_PRELOAD_FROM_QQ_PUBLIC_ACCOUNT = "QQPublicAccount";
    public static final String QZONE_PRELOAD_FROM_QZoneDistributedAppCtrl = "QZoneDistributedAppCtrl";
    public static final String QZONE_PROCESS_NAME = "com.tencent.mobileqq:qzone";
    public static final String QZONE_SINGLE_PERMISSION_M_INTENT_UIN = "qqid";
    public static final String QZONE_TRANSLUCENT_ACTIVITY = "com.qzone.misc.web.QZoneTranslucentActivity";
    public static final String QZONE_TRANSLUCENT_ACTIVITY2 = "com.qzone.misc.web.QZoneTranslucentActivity2";
    public static final String QZONE_VIDEO_TRIM = "com.qzone.video.activity.TrimVideoActivity";
    public static final String QZONE_VIP_OPENSUCCESS_CALLBACK = "requestQzoneOpenVip";
    public static final String QZONE_VIP_OPENSUCCESS_CALLBACK_URL = "pay://requestQzoneOpenVip";
    public static final String QZONE_VIP_OPEN_SUCC_STR = "qzone_vip_open_succ_str";
    public static final String QZ_COVER_FROM_UserSummary = "usersummary";
    public static final String SCHEME_OPEN_HOME_PAGE = "mqzone://arouse/homepage";
    public static final String SECONDARY_AIO_QZDETAIL = "aio2qzonedetail";
    public static final String SHORT_CUT_FROM_QZONE_PHOTO_LIST = "shortcutFromQZonePhotolist";
    public static final String SINGLE_PERMISSION_SETTING = "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity";
    public static final String TAG = "QZoneHelper";
    public static final String UPLOAD_PHOTO = "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity";
    public static final String USER_HOME = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
    public static final String VIDEO_COVER_PREVIEW_ACTVITY = "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity";
    public static final String bNEEDCALLBACK = "bNeedCallBack";
    public static int sQZoneHCCode;
    public static final String STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW = HardCodeUtil.qqStr(R.string.rx_);
    public static boolean comboqzProtectEnable = false;
    private static boolean gIsBestPerformanceDevice = false;
    private static boolean gIsInitPerformanceDeviceState = false;
    private static volatile int g_playGifParformanceLevel = 0;
    private static volatile int g_listScrollParformanceLevel = 0;
    private static volatile String g_floatBlacklist = null;
    private static volatile boolean g_isInFloatBlacklist = false;
    private static volatile String g_particleEffectBlacklist = null;
    private static volatile boolean g_isInParticleEffectBlacklist = false;
    private static volatile String g_particleEffectBestPerformBlacklist = null;
    private static volatile boolean g_isInParticleEffectBestPerformBlacklist = false;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class Constants {
        public static final String ACTION_SEND_MOOD_FINISH = "sendMoodFinish";
        public static final String DETAIL_EPBAG_TAG = "detail_epbag_tag";
        public static final int ENABLE_VIDEO_EDIT = 1;
        public static final int ENTRY_FEOM_FRIEND_PROFILE = 5;
        public static final int ENTRY_FROM_NEARBY = 6;
        public static final int ENTRY_FROM_PERSONALIZE_H5 = 256;
        public static final int ENTRY_FROM_STORY_CAPTURE = 7;
        public static final String INTENT_ACTION_FORWARD_PHOTO_FROM_AIO_TO_QZONE = "com.tencent.intent.QZONE_QUOTE_FROM_AIO";
        public static final String INTENT_ACTION_PUBLISH_QR_CODE = "com.tencent.intent.QZONE_PUBLISH_QR_CODE";
        public static final String INTENT_ACTION_QZONE_OPEN_SHARE = "com.tencent.intent.QZONE_OPEN_SHARE";
        public static final String INTENT_ACTION_QZONE_OPEN_VIP = "com.tencent.intent.QZONE_OPEN_VIP";
        public static final String INTENT_ACTION_RESHIP_FROM_QUN_AIO_TO_QUN = "com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN";
        public static final String KEY_ALBUM_COVER = "UploadPhoto.key_album_cover";
        public static final String KEY_ALBUM_ID = "UploadPhoto.key_album_id";
        public static final String KEY_ALBUM_NAME = "UploadPhoto.key_album_name";
        public static final String KEY_ALBUM_OWNER_UID = "UploadPhoto.key_album_owner_uin";
        public static final String KEY_BIG_PHOTO_FILEIDS = "key_big_photo_fileids";
        public static final String KEY_BIG_PHOTO_FILE_ID = "key_big_photo_file_id";
        public static final String KEY_BIG_PHOTO_UUID = "key_big_photo_uuid";
        public static final String KEY_BIG_PHOTO_UUIDS = "key_big_photo_uuids";
        public static final String KEY_DESC = "key_desc";
        public static final String KEY_DETAIL_EPBAG = "key_detail_epbag";
        public static final String KEY_ERROR_MSG = "key_error_msg";
        public static final String KEY_FILE_PATH = "key_file_path";
        public static final String KEY_FROM_ALBUM_SHORTCUT = "UploadPhoto.key_from_album_shortcut";
        public static final String KEY_IS_EMBED_IN_TAB_ACTIVITY = "isEmbedInTabActivity";
        public static final String KEY_IS_FILTER_VIDEO = "key_is_filter_video";
        public static final String KEY_IS_FROM_MAKE_BLOG = "key_is_from_make_blog";
        public static final String KEY_LAST_CLOSE_TROOP_QCIRCLE_MSG_TIME = "key_last_close_troop_qcircle_msg_time";
        public static final String KEY_LAST_REQUEST_AIO_FEEDS_TIME = "key_last_req_aio_feeds_time";
        public static final String KEY_LAST_REQUEST_AIO_QCIRCLE_FEEDS_TIME = "key_last_req_aio_qcircle_feeds_time";
        public static final String KEY_LAST_REQUEST_AIO_STORY_FEED_TIME = "key_last_req_aio_story_feed_time";
        public static final String KEY_LAST_REQUEST_TROOP_QCIRCLE_MSG_TIME = "key_last_request_troop_qcircle_msg_time";
        public static final String KEY_LAST_STORY_FEED_CREATE_TIME = "key_last_story_feed_create_time_for_aio";
        public static final String KEY_LAUNCH_TIME = "launch_time";
        public static final String KEY_MSG_TIME = "key_msg_time";
        public static final String KEY_MSG_TIMES = "key_msg_times";
        public static final String KEY_NEED_LOAD_PHOTO_FROM_INTENT = "key_need_load_photo_from_intent";
        public static final String KEY_PHOTO_EVENT_TYPE = "key_photo_event_type";
        public static final String KEY_PROTECT_ENABLE = "comboqz_protect_enable";
        public static final String KEY_PUBLISH_COME_FROM = "key_publish_come_from";
        public static final String KEY_PUBLISH_SUB_COME_FROM = "key_publish_sub_come_from";
        public static final String KEY_QUA = "comboqz_qua";
        public static final String KEY_QUN_CODE = "key_qun_code";
        public static final String KEY_QUN_ID = "key_qun_id";
        public static final String KEY_QUN_NAME = "ken_qun_name";
        public static final String KEY_QUN_PHOTO_DATA_HAS_CHANGED = "ken_qun_photo_data_has_changed";
        public static final String KEY_QUOTE_SRC_TYPE = "key_quote_src_type";
        public static final String KEY_QZAPP_VERCODE = "qzapp_vercode";
        public static final String KEY_QZH5_URL = "qzh5_url";
        public static final String KEY_REFER = "refer";
        public static final String KEY_REQUEST_TROOP_QCIRCLE_MSG_ATTACHE_DATA = "key_request_troop_qcircle_msg_attache_data";
        public static final String KEY_REQUEST_TROOP_QCIRCLE_MSG_TIME_INTERVAL = "key_request_troop_qcircle_msg_time_interval";
        public static final String KEY_RETURN_CODE = "key_return_code";
        public static final String KEY_SAFE_MODE_TIP = "qz_safe_mode_no_tip";
        public static final String KEY_SOURCE_FROM = "key_source_from";
        public static final String KEY_SP_QZONE_CRASH_TIME = "key_sp_qzone_crash_time";
        public static final String KEY_SP_QZONE_ISFOREGROUND = "key_sp_qzone_isforeground";
        public static final String KEY_SRC_UIN = "key_photo_src_uin";
        public static final String KEY_STATE_TYPE_SRC = "QZoneUploadPhotoActivity.key_state_type_src";
        public static final String KEY_THUMB_FILE_PATH = "key_thumb_file_path";
        public static final String KEY_THUMB_FILE_PATHS = "key_thumb_file_paths";
        public static final String KEY_TITLE = "key_title";
        public static final String KEY_TITLE_NAME = "key_title_name";
        public static final String KEY_TRACE_ID = "key_trace_id";
        public static final String KEY_TROOP_ALBUM_REFER = "mqqChat";
        public static final String KEY_TYPE_QUEUE = "key_type_queue";
        public static final int MSF_CODE_BASE = 300000;
        public static final long NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT = 20971520;
        public static final String PARA_CALL_MENU_TYPE = "para_call_menu_type";
        public static final int QUOTE_SRC_TYPE_FRIENDAIO = 1;
        public static final int QUOTE_SRC_TYPE_QUNAIO = 2;
        public static final int QZONE_APP_DEFAULT_SUPPORT_VERSIONCODE = 84;
        public static final String QZONE_APP_SCHEME = "mqzone://arouse/activefeed?source=qq&version=1";
        public static final String QZONE_H5_INFOCENTER_URL = "https://m.qzone.com/infocenter";
        public static final String QZONE_SP_NAME_IN_QQ = "qzone_sp_in_qq";
        public static final int STATE_TYPE_NORMAL = 0;
        public static final int STATE_TYPE_QUN = 1;
        public static final int STATE_TYPE_QUN_PHOTO_LIST = 2;
        public static final int STATE_TYPE_QUN_RESHIP = 3;
        public static final int STATE_TYPE_QUN_RESHIP_PHOTO_LIST = 4;
        public static final long SUPPORT_MIX_MUSIC_DEFAULT = 524288000;
        public static final int TYPE_QUEUE_PUBACCOUNT = 2;
        public static final int TYPE_QUEUE_QCIRCLE = 3;
        public static final int TYPE_QUEUE_QZONE = 1;
        public static final int TYPE_QUN_UPLOAD_LOCAL_ALBUM_RECENT_PHOTO = 6;
        public static final int TYPE_QUN_UPLOAD_NO_SELECT_PHOTO = 7;
        public static final int TYPE_QUN_UPLOAD_PERSONAL_ALBUM_RECENT_PHOTO = 5;
        public static final int TYPE_QUN_UPLOAD_RESHIP_PHOTO = 4;
        public static final int TYPE_QUN_UPLOAD_SELECT_PHOTO = 1;
        public static final int TYPE_QUN_UPLOAD_SELECT_PHOTO_WITH_IMAGE_PATH = 8;
        public static final int TYPE_QUN_UPLOAD_TAKE_PHOTO = 2;
        public static final int TYPE_QUN_UPLOAD_TAKE_PHOTO_BY_ZEBRA = 3;
        public static final String UGC_PERMIT_SETTING_PAGE = "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1";
        public static final String URL_QUN_ALBUM = "https://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}?_wv=3&_proxy=1";
        public static final String URL_QUN_ALBUM_DEATAIL = "https://h5.qzone.qq.com/groupphoto/inqq/detail/{QQ_URL}?_wv=3&_proxy=1";
        public static final String URL_QUN_ALBUM_PHOTO = "https://h5.qzone.qq.com/groupphoto/inqq/photo/{QUN_ID}/{ALBUM_ID}?_wv=3&_proxy=1";
        public static final String URL_QUN_ALBUM_SELECT_URL = "https://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}/select?_wv=3&_proxy=1";
        public static final String URL_QUN_FEED = "https://h5.qzone.qq.com/groupphoto/inqq/recent/{QUN_ID}/groupphoto?_wv=3&_proxy=1";
        public static final String URL_QUN_PASSIVE_FEED = "https://h5.qzone.qq.com/groupphoto/inqq/relatedme/{QUN_ID}/{UIN}?_wv=3&_proxy=1";
        public static final int VALUE_PUBLISH_DEFAULT_SUB_COME_FROM = -1;
        public static final int VALUE_PUBLISH_FROM_ALBUM_LOCAL_RECOMMEND = 1;
        public static final int VALUE_PUBLISH_FROM_OTHER = 0;
        public static final int VALUE_PUBLISH_FROM_PICKER_AI_ELIMAINTE_POSITION = 4;
        public static final int VALUE_PUBLISH_FROM_PICKER_RECOMMEND_POSITION = 3;

        public Constants() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class Params {
        public static final int UPLOAD_PERSONAL_SIGN_SUBTYPE = 3;
        public static final int UPLOAD_QZONE_SUBTYPE = 2;

        public Params() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class PhotoEventType {
        public static final int PHOTO_EVENT_FROM_ALBUM = 2;
        public static final int PHOTO_EVENT_GIF_FROM_BANNER = 1;
        public static final int PHOTO_EVENT_PHOTOGROUP_FROM_BANNER = 0;

        public PhotoEventType() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QZoneAlbumConstants {
        public static final int ALBUM_TYPE_VIDEO_ALBUM = 10;
        public static final String CANCELED_FROM_CHOOSE_LOCAL_PHOTO = "isCanceledFromChooseLocalPhoto";
        public static final int DEFAULT_MAX = -1;
        public static final int ENTER_MODEL_MULTIPLE = 1;
        public static final int ENTER_MODEL_SINGLE = 2;
        public static final int ENTER_MODEL_VIEW = 0;
        public static final String GUIDE_REFER_FLAG = "feedguideflag";
        public static final String HAS_SELECT_SIZE = "has_select_size";
        public static final String INPUT_MAX = "_input_max";
        public static final String KEY_ACCEPT_ALBUM_ANONYMITY = "key_accept_album_anonymity";
        public static final String KEY_ALBUM_COVER = "UploadPhoto.key_album_cover";
        public static final String KEY_ALBUM_ID = "UploadPhoto.key_album_id";
        public static final String KEY_ALBUM_NAME = "UploadPhoto.key_album_name";
        public static final String KEY_ALBUM_OWNER_UIN = "key_album_owner_uin";
        public static final String KEY_ALBUM_UIN = "QZoneTroopAlbumListActivity.key_album_uin";
        public static final String KEY_ALBUM_UPDATE_COMMENT_LIST_COUNT = "key_album_comment_list_count";
        public static final String KEY_ALBUM_UPLOAD_IMMEDIATELY = "key_album_upload_immediately";
        public static final String KEY_CAN_NEW_ALBUM = "key_can_new_album";
        public static final String KEY_COVER_SELECTED_IMG_PATH = "key_cover_selected_img_path";
        public static final String KEY_CURINDEX = "curindex";
        public static final String KEY_DENY_SELECT_TIPS = "key_deny_delect_tips";
        public static final String KEY_DOWNLOAD_REPORT_KEY = "download_report_key";
        public static final String KEY_ENTER_MODEL = "key_personal_album_enter_model";
        public static final String KEY_FROM_TYPE = "key_from_type";
        public static final String KEY_LAST_UPLOAD_TIME = "key_last_upload_time";
        public static final String KEY_LEFT_TAB_TITLE = "key_left_tab_title";
        public static final String KEY_LIKE_INFO = "like_info";
        public static final String KEY_MODE = "mode";
        public static final String KEY_NEED_CHECK_CACHE = "key_need_check_cache";
        public static final String KEY_NEED_CLEAR_CACHE = "need_clear_cache";
        public static final String KEY_NEED_DOWNLOAD_REPORT = "need_download_report";
        public static final String KEY_NEED_SHOW_ALBUM_RECENT_PHOTO = "key_need_show_album_recent_photo";
        public static final String KEY_PASS_RESULT_BY_BUNDLE = "key_pass_result_by_bundle";
        public static final String KEY_PHOTO_PARAM = "photo_param";
        public static final String KEY_PICTURE_LIST = "picturelist";
        public static final String KEY_PRIV = "key_priv";
        public static final String KEY_QUALITY = "key_quality";
        public static final String KEY_RIGHT_TAB_TITLE = "key_rihgt_tab_title";
        public static final String KEY_SELECTED_ALBUMINFO = "key_selected_albuminfo";
        public static final String KEY_SELECTED_ALBUMINFO_ALBUM_ANONYMITY = "key_selected_albuminfo.anonymity";
        public static final String KEY_SELECTED_ALBUMINFO_ALBUM_COVER = "key_selected_albuminfo.cover";
        public static final String KEY_SELECTED_ALBUMINFO_ALBUM_ID = "key_selected_albuminfo.id";
        public static final String KEY_SELECTED_ALBUMINFO_ALBUM_NAME = "key_selected_albuminfo.name";
        public static final String KEY_SELECTED_ALBUMINFO_ALBUM_PERMISSION = "key_selected_albuminfo.permission";
        public static final String KEY_SELECTED_ALBUMINFO_ALBUM_TYPE = "key_selected_albuminfo.type";
        public static final String KEY_SELECTED_TAB = "key_selected_tab";
        public static final String KEY_SOURCE = "key_source";
        public static final String KEY_STATE_TYPE_SRC = "QZoneTroopAlbumListActivity.key_state_type_src";
        public static final String KEY_TIME_RECORD = "key_time_record";
        public static final String KEY_TROOP_ALBUM_IS_FROM_QQ = "QZoneTroopAlbumListActivity.key_troop_album_is_from_qq";
        public static final int MODE_LOCAL_RECENT_PHOTO = 7;
        public static final int MODE_MULTI_PIC = 0;
        public static final int MODE_PHOTO_WALL = 6;
        public static final int MODE_QUN_ALBUM = 4;
        public static final int MODE_QUN_FEED = 5;
        public static final int MODE_QZONE_FEED = 2;
        public static final int MODE_QZONE_PHOTOLIST = 3;
        public static final int MODE_QZONE_QUN_PHOTOLIST = 13;
        public static final int MODE_QZONE_RECENT_ALBUM = 1;
        public static final String QZ_ALBUM_SORT_TYPE = "QZ_ALBUM_SORT_TYPE";
        public static final String QZ_ALBUM_THEME = "QZ_ALBUM_THEME";
        public static final int SEND_TO_H5 = 1;
        public static final int TAB_ALUBM_LIST = 0;
        public static final int TAB_ALUBM_RECENT = 1;
        public static final String VALUE_SOURCE_FROM_XIAOWO = "value_source_from_xiaowo";

        public QZoneAlbumConstants() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QZoneAppConstants {
        public static final int JUMP_TO_DETAIL_FROM_QQ_AIO = 1;
        public static final int JUMP_TO_DETAIL_FROM_QQ_AIO_NEW = 2;
        public static final int JUMP_TO_DETAIL_FROM_QQ_SEARCH = 0;
        public static final String JUMP_TO_DETAIL_FROM_QQ_WHAT = "jumpToDetailFromQQWhat";
        public static final String KEY_HAS_REDTOUCH = "key_redTouch";
        public static final String KEY_QZOEN_FEEDS_DIGITAL_REDDOT = "had_digital_reddot";
        public static final String KEY_QZOEN_FEEDS_INDEX = "qzone_feeds_index";
        public static final String KEY_QZOEN_FEEDS_KEY = "qzone_feeds_key";
        public static final String KEY_QZOEN_FEEDS_TIME = "qzone_feeds_time";
        public static final String KEY_REFER = "refer";
        public static final String KEY_UPLOAD_ENTRANCE = "key_upload_entrance";
        public static final int QZONE_BUSSINESS_ID = 1000027;
        public static final String REFER_ACTIVE_FEED = "getActiveFeeds";
        public static final String REFER_FEED_GUIDE = "feedguide";
        public static final String REFER_GROUP_PROFILE = "group_profile";
        public static final String REFER_MAIN_PAGE = "getMainPage";
        public static final String REFER_MSG_NOTIFICATION = "msg_notification";
        public static final String REFER_PASSIVE_FEED = "getPassiveFeeds";
        public static final String REFER_PASSIVE_FEED_GUIDE = "getActiveFeeds_tmp_Guide";
        public static final String REFER_PHOTO_LIST = "getPhotoList";
        public static final String REFER_PHOTO_PREVIEW = "getPhotoListEx";
        public static final String REFER_PUSH_BANNER = "push_banner";
        public static final String REFER_QQ_ACTIVE_FEED = "mqqActiveTab";
        public static final String REFER_QQ_AVATAR = "mqqAvatar";
        public static final String REFER_QQ_CHAT = "mqqChat";
        public static final String REFER_QQ_CHAT_QZONE_NEWEST_FEED = "mqqChat.QzoneCard";
        public static final String REFER_QQ_NEARBY = "mqqNearby";
        public static final String REFER_QQ_QUANZI = "mqqQuanzi";
        public static final String REFER_QQ_QUN_SPACE = "mqqQunSpace";
        public static final String REFER_QQ_SETTING = "mqqSetting";
        public static final String REFER_QQ_SET_PROFILE = "mqqSetProfile";
        public static final String REFER_SCHEME_ACTIVE_FEED = "schemeActiveFeeds";

        public QZoneAppConstants() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QZoneConfig {
        public static final String MAIN_KEY_PHOTO_SVRLIST = "PhotoSvrList";
        public static final String MAIN_KEY_PHOTO_UPLOAD = "PhotoUpload";

        public QZoneConfig() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QZoneCoverConstants {
        public static final String ACTION_COVER_IMG_CROP_END = "action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end";
        public static final String ACTION_SET_COVER_SUCCESS = "action.com.qzone.cover.set_cover_success";
        public static final String CONFIG_PARAM_COVER_SET_JIGSAW = "cover_setjigsaw";
        private static final String COVER_PREVIEW_URL = "https://h5.qzone.qq.com/bgstore/detail/{coverid}?_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}";
        public static final String COVER_STORE_ACTIVITY_FULL_NAME = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
        private static final String COVER_STORE_URL = "https://h5.qzone.qq.com/bgcover/index?_wv=2098179&qua={qua}";
        public static final int FROME_COVER_FEED = 4;
        public static final int FROME_FEED = 1;
        public static final int FROME_FEED_BANNER = 5;
        public static final int FROME_FEED_FRIEND = 9;
        public static final int FROME_FEED_SELF = 8;
        public static final int FROME_PROFILE_CARD = 3;
        public static final int FROME_PROFILE_CARD_BANNER = 7;
        public static final int FROME_USERHOME = 2;
        public static final int FROME_USERHOME_BANNER = 6;
        public static final String INTENT_PARAM_CURRENT_COVER = "current_cover";
        public static final String INTENT_PARAM_DIRECT_SELECTPHOTO = "direct_select_photo";
        public static final String INTENT_PARAM_FROM = "key_from";
        public static final String INTENT_PARAM_JIGSAW_OPEN = "jigsaw_open";
        public static final String INTENT_PARAM_PHOTOWALL_MODE = "photowall_mode";
        public static final String INTENT_PARAM_PHOTOWALL_UPDATED = "photowall_updated";
        public static final String INTENT_PARAM_SET_SOURCE = "set_source";
        public static final String INTENT_PARAM_SHOW_WIDGET_SET = "showWidgetSet";
        public static final String INTENT_PARAM_UIN = "cover_uin";
        public static final String KEY_HIGH_RESOLUTION = "HigeResolutionCover";
        public static final String KEY_LOW_RESOLUTION = "LowResolutionCover";
        private static final String MUSIC_COVER_PREVIEW_URL = "https://h5.qzone.qq.com/musicCover/preview?id={coverid}&_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1";
        private static final String PHOTO_WALL_URL = "https://h5.qzone.qq.com/bgstore/photoWall?_wv=2098179&uin={uin}&hostUin={hostUin}&from={from}&page=1&qua={qua}&router=photoWall";
        public static final String PRELOAD_COVER_UIN = "preload_cover_uin";
        public static final String PRELOAD_COVER_URL = "preload_cover_url";
        public static final int REQUEST_CODE_COVER_VIDEO_PRIVIEW = 10;
        public static final int REQUEST_CODE_CUSTOM_LOCAL = 2;
        public static final int REQUEST_CODE_CUSTOM_QZONE = 3;
        public static final int REQUEST_CODE_OPEN_VIP = 4;
        public static final int REQUEST_CODE_PHOTOWALL = 1;
        public static final int REQUEST_CODE_SET_COVER = 7;
        public static final int REQUEST_CODE_SET_LOCAL_COVER = 8;
        public static final int REQUEST_CODE_SET_NAVI_DECO = 9;
        public static final int REQUEST_CODE_WIDGET_ENABLE = 6;
        public static final int REQUEST_CODE_WIDGET_ID = 5;
        public static final int SET_SOURCE_PROFILECARD = 1;
        public static final int SET_SOURCE_QZONE = 0;
        public static final int SYNC_FLAG_BOTH = 1;

        public static String getCoverPreviewUrl(String str, String str2, String str3, String str4, String str5) {
            return QzoneConfig.getInstance().getConfig("H5Url", "CoverPreview", "https://h5.qzone.qq.com/bgstore/detail/{coverid}?_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}").replace("{qua}", QUA.getQUA3()).replace("{pb}", "").replace("{from}", str).replace("{page}", str2).replace("{coverid}", str3).replace("{uin}", str4).replace("{hostUin}", str5);
        }

        public static String getCoverStoreUrl(String str, String str2, String str3, String str4) {
            return QzoneConfig.getInstance().getConfig("H5Url", "CoverStore", COVER_STORE_URL).replace("{uin}", str3).replace("{hostUin}", str4).replace("{qua}", QUA.getQUA3()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", str).replace("{page}", str2);
        }

        public static String getMusicCoverPreviewUrl(String str, String str2, String str3, String str4, String str5) {
            return QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MUSIC_COVER_PREVIEW, MUSIC_COVER_PREVIEW_URL).replace("{qua}", QUA.getQUA3()).replace("{pb}", "").replace("{from}", str).replace("{page}", str2).replace("{coverid}", str3).replace("{uin}", str4).replace("{hostUin}", str5);
        }

        public static String getPhotoWallUrl(String str, String str2, String str3, boolean z16) {
            return QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_PHOTO_WALL_URL, PHOTO_WALL_URL).replace("{uin}", str).replace("{hostUin}", str2).replace("{qua}", QUA.getQUA3()).replace("{isPhotoWall}", "" + (z16 ? 1 : 0)).replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", str3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QZoneFamousSpaceHomeConstants {
        public static final String ACTION_URL = "https://h5.qzone.qq.com/vpage/cover/{uin}/vpage-index?screenWidth={screenWidth}&qua={qua}&_proxy=1&_wv=1029&bottom={bottom}";
        public static final String FAMOUS_SPACE_HOME_URL_PREFIX = "https://mp.qzone.qq.com/u/";

        public static String getFamousSpaceHomeActionUrl() {
            return LocalMultiProcConfig.getString(QZoneHelper.FAMOUS_SPACE_ACTION_URL_CONFIG_NAME, UserInfo.getInstance().qzone_uin, ACTION_URL);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QZonePersonalAlbumContants {
        public static final int ALBUM_FROM_UGC_TAB = 1;
        public static final int ANSWER_PAGE_CONGENT_FLAG_ERROR = 1;
        public static final int ANSWER_PAGE_CONGENT_FLAG_NORMAL = 0;
        public static final int ENTER_MODEL_MULTIPLE = 1;
        public static final int ENTER_MODEL_SEARCH_RESULT = 4;
        public static final int ENTER_MODEL_SINGLE = 2;
        public static final int ENTER_MODEL_SINGLE_SHARING_OWNER = 3;
        public static final int ENTER_MODEL_VIEW = 0;
        public static final String KEY_ALBUM_ANONYMITY = "key_album_anonymity";
        public static final String KEY_ALBUM_BUIS_PARAM = "key_album_buis_param";
        public static final String KEY_ALBUM_FACE_NICKNAME = "key_album_face_nickname";
        public static final String KEY_ALBUM_FACE_UIN = "key_album_face_uin";
        public static final String KEY_ALBUM_FACE_URL = "key_album_face_url";
        public static final String KEY_ALBUM_FROM = "key_album_from";
        public static final String KEY_ALBUM_FROM_SPACE = "key_album_from_space";
        public static final String KEY_ALBUM_ID = "key_album_id";
        public static final String KEY_ALBUM_NAME = "key_album_name";
        public static final String KEY_ALBUM_OWNER_UIN = "key_album_owner_uin";
        public static final String KEY_ALBUM_QUESTION = "key_album_qustion";
        public static final String KEY_ALBUM_REFER = "key_album_refer";
        public static final String KEY_ALBUM_SEARCH_FILTER = "key_album_search_filter";
        public static final String KEY_ANSWER_PAGE_CONGENT_FLAG = "key_answer_page_content_flag";
        public static final String KEY_ANSWER_PAGE_ERROR_MSG = "key_answer_page_error_msg";
        public static final String KEY_DEFAULT_ALBUM_ID = "key_default_album_id";
        public static final String KEY_ENTER_MODEL = "key_personal_album_enter_model";
        public static final String KEY_FROM_UPLOAD = "key_from_upload";
        public static final String KEY_FROM_WX = "key_from_wx";
        public static final String KEY_GET_SHARER_PHOTO_LIST = "key_get_sharer_photo_list";
        public static final String KEY_GET_SHARER_PHOTO_LIST_COUNT = "key_get_sharer_photo_list_count";
        public static final String KEY_GET_SHARER_PHOTO_LIST_NICK = "key_get_sharer_photo_list_nick";
        public static final String KEY_GET_SHARER_PHOTO_LIST_UIN = "key_get_sharer_photo_list_uin";
        public static final String KEY_INVITE_KEY = "key_invite_key";
        public static final String KEY_IS_INDIVIDUAL_ALBUM = "key_is_individual_album";
        public static final String KEY_IS_PUBLIC = "key_is_public";
        public static final String KEY_IS_SELECT_VIDEO = "key_personal_album_is_select_video";
        public static final String KEY_IS_SORTING_MODEL = "key_album_is_sorting_model";
        public static final String KEY_JUMP_ALBUM_ID = "key_jump_album_id";
        public static final String KEY_JUMP_PHOTOLIST_BEGIN_TIME = "key_jump_photolist_begin_time";
        public static final String KEY_JUMP_PHOTOLIST_END_TIME = "key_jump_photolist_end_time";
        public static final String KEY_LAST_UPLOAD_TIME = "key_last_upload_time";
        public static final String KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG = "key_multiple_model_need_download_img";
        public static final String KEY_NEED_CHANGE_TO_JPG = "key_need_change_to_jpg";
        public static final String KEY_PHOTO_SORT_TYPE = "key_photo_sort_type";
        public static final String KEY_PRIV = "key_priv";
        public static final String KEY_SINGLE_MODEL_NO_NEED_BIG_IMG = "key_single_model_no_need_big_img";
        public static final String KEY_SORTING_MODEL_BUSI_PARAM = "key_album_sorting_model_busi_param";
        public static final String KEY_TIP_TEXT = "key_tip_text";
        public static final String KEY_TITLE = "key_title";
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QZoneReeditConstants {
        public static final String KEY_IS_JUMP_REEDIT_PUBLISH_FLOW = "key_is_jump_reedit_publish_flow";

        public static boolean isReeditPublishFlow(Intent intent) {
            if (intent == null) {
                return false;
            }
            return intent.getBooleanExtra(KEY_IS_JUMP_REEDIT_PUBLISH_FLOW, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QZoneUploadPhotoConstants {
        public static final String DEFAULT_UPLOAD_SR_BY_OPR = "photorepair";
        public static final String KEY_BEGIN_SEND_SHOW_TOAST = "key_begin_send_show_toast";
        public static final String KEY_REPAIR_SR_TASK_ID = "key_sr_task_id";
        public static final String KEY_REPAIR_SR_URL = "key_sr_url";
        public static final String KEY_TYPE = "photoactivity_key_type";
        public static final String KEY_UPLOAD_ALBUM_ID = "UploadPhoto.key_album_id";
        public static final String KEY_UPLOAD_ALBUM_NAME = "UploadPhoto.key_album_name";
        public static final String KEY_UPLOAD_IMAGES = "PhotoConst.PHOTO_PATHS";
        public static final String KEY_UPLOAD_IMAGES_ALBUM_ID = "key_upload_album_id";
        public static final String KEY_UPLOAD_IMAGES_CLIENT_KEY = "key_upload_client_key";
        public static final String KEY_UPLOAD_REPAIR_SR_TASK_ID = "key_upload_sr_task_id";
        public static final String KEY_UPLOAD_REPAIR_SR_URL = "key_upload_sr_url";
        public static final String KEY_UPLOAD_SR_BY_OPR = "key_upload_sr_by_opr";
        public static final int MSG_UPLOAD_CONNECT = 998;
        public static final int MSG_UPLOAD_DISCONNECT = 999;
        public static final int MSG_UPLOAD_FAIL = 1003;
        public static final int MSG_UPLOAD_FINISH = 1000;
        public static final int MSG_UPLOAD_IMAGE_INFO = 1002;
        public static final int MSG_UPLOAD_NO_TASK_RUN = 1004;
        public static final int MSG_UPLOAD_PROGRESS = 1001;
        public static final int MSG_UPLOAD_TASK_REMOVED = 1005;

        public QZoneUploadPhotoConstants() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QZoneVideoConstants {
        public static final int REQUEST_CODE_INSTALL_VIDEO_PLUGIN = 10008;
        public static final int REQUEST_CODE_START_VIDEO_PLUGIN = 10009;

        public QZoneVideoConstants() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QzoneAlbumFacadeCateConstants {
        public static final String KEY_ITEM_ID = "key_item_id";
        public static final String KEY_ITEM_TYPE = "key_item_type";
        public static final String KEY_THUMB_URL = "key_thumb_url";
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QzoneFeedActionPanelConstants {
        public static final String AUTOSAVE_STORAGE_KEY = "autoSaveStorageKey";
        public static final String EXTRA_BUNDLE_PRIV_KEY = "extra_key_bundle_priv_key";
        public static final String EXTRA_INPUT_MAX_LEN = "inputmax";
        public static final String EXTRA_INTENT_KEY = "extraIntentKey";
        public static final String EXTRA_INTENT_KEY_PARCELABLE = "extraIntentKeyParcelable";
        public static final String EXTRA_KEY_CACHE_UNIKEY = "extraCacheKey";
        public static final String EXTRA_KEY_COMMENT_ID = "extraCommentID";
        public static final String EXTRA_KEY_CONTENT_INTENT = "contentIntentKey";
        public static final String EXTRA_KEY_CONTENT_INTENT_VIDEO_EDIT_EMO = "contentIntentKeyForVideoEditWithEmo";
        public static final String EXTRA_KEY_FONT_FORMAT_TYPE = "extra_key_font_format_type";
        public static final String EXTRA_KEY_FONT_ID = "extra_key_font_id";
        public static final String EXTRA_KEY_FONT_URL = "extra_key_font_url";
        public static final String EXTRA_KEY_FORWARDANDCOMMENT = "extraForwardAndComment";
        public static final String EXTRA_KEY_IMAGELIST_CONTENT_INTENT = "imageListContentIntentKey";
        public static final String EXTRA_KEY_IS_QUN = "extraIsQun";
        public static final String EXTRA_KEY_IS_SHARE = "is_share";
        public static final String EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR = "extraIsSystemTransparentBar";
        public static final String EXTRA_KEY_IS_TOPIC = "is_topic";
        public static final String EXTRA_KEY_IS_TOPIC_SYNC_QZONE = "extraIsTopicSyncQzone";
        public static final String EXTRA_KEY_PRIVATE_COMMENT = "extraPrivateComment";
        public static final String EXTRA_KEY_PRIV_DATA = "extra_key_bundle_priv";
        public static final String EXTRA_KEY_QUN_ID = "extraIsQunID";
        public static final String EXTRA_KEY_QUN_NAME = "extraQunName";
        public static final String EXTRA_KEY_REFER_ACTIVITY = "extraReferActivity";
        public static final String EXTRA_KEY_REPLY_ID = "extraReplyID";
        public static final String EXTRA_KEY_REQUEST_CODE = "extraRequestCode";
        public static final String EXTRA_KEY_SET_TIMER_DELETE = "set_timer_delete";
        public static final String EXTRA_KEY_SHOW_PICCOMMENT = "showPicComment";
        public static final String EXTRA_KEY_SUPER_FONT_ID = "extra_key_super_font_id";
        public static final String EXTRA_KEY_SUPER_FONT_INFO = "extra_key_super_font_info";
        public static final String EXTRA_KEY_VIDEO_EDIT_MODE = "video_edit_mode";
        public static final String EXTRA_SENDBTN_TEXT = "sendbtntext";
        public static final String FEED_TEXT_AUTOFILL_INTENT_KEY = "feedTextAutoFillKey";
        public static final String FEED_TEXT_HINT_INTENT_KEY = "feedTextHintKey";
        public static final String KEY_AT_CLICK_HIDE_KEYBOARD = "key_at_click_hide_keyboard";
        public static final String KEY_IS_LONG_CLICK = "extraIsLongClick";
        public static final String KEY_SPARKLE_WORD_ID = "SPARKLE_WORD_ID";
        public static final String KEY_SPARKLE_WORD_JSON = "sparkle_json";
        public static final String NEEDTRANSEMOJ = "needtransemoj";
        public static final String SHOW_AT_ICON = "showaticon";
        public static final String SHOW_EMOTION_ICON = "showemotionicon";
        public static final String SHOW_FONT_ICON = "showfonticon";
        public static final String SHOW_KEY_ICON = "showkeyicon";
        public static final String SHOW_SUPER_FONT = "show_super_font";
        public static final String SHOW_XUANQU = "showxuantuicon";

        public QzoneFeedActionPanelConstants() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QzoneJsRequestCodeConstants {
        public static final int REQUEST_CODE_FEDDACTION = 2;
        public static final int REQUEST_CODE_MSG_DETAIL = 3;
        public static final byte REQUEST_CODE_OPEN_CAMERA = 20;
        public static final byte REQUEST_CODE_OPEN_IMAGE_PICKER = 21;
        public static final int REQUEST_CODE_PUBLISH_MOOD = 5;
        public static final byte REQUEST_CODE_REFRESH_FEEDS = 22;
        public static final int REQUEST_CODE_UPLOADPHOTO = 1;
        public static final int REQUEST_CODE_VIDEO_RECOMMEND = 4;
        public static final int REQUEST_CODE_WRITE_MOOD = 6;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QzonePhotoCategoryConstants {
        public static final String CATEGORY_BUSI_TYPE = "categoryBusiType";
        public static final String CATEGORY_ID = "categoryId";

        public QzonePhotoCategoryConstants() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QzoneSharePrefrenceConstants {
        public static final String KEY_EVENTTAG_MODIFYPRIV_COUNT = "key_eventtag_modifypriv_count";
        public static final String KEY_EVENTTAG_MODIFYPRIV_DATE = "key_eventtag_modifypriv_date";
        public static final String KEY_PHOTO_GUIDE_ENTER_QZONE_DATE = "key_photo_guide_enter_qzone_date";
        public static final String KEY_PHOTO_GUIDE_FIRST_PHOTO = "key_photo_guide_first_photo";
        public static final String KEY_PHOTO_GUIDE_HAS_RED_DATE = "key_photo_guide_has_red_date";
        public static final String KEY_PHOTO_GUIDE_IS_RED = "key_photo_guide_is_red";
        public static final String KEY_PHOTO_GUIDE_LAST_CHECK = "key_photo_guide_last_check";
        public static final String KEY_VIDEO_PLAY_ON_WIFI = "key_video_play_on_wifi";

        public QzoneSharePrefrenceConstants() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface StartActivity {
        void onStart(boolean z16, boolean z17);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Statics {
        public static final String EVENTKEY_GPS_INFO = "gpsComplement";
        public static final String KEY_GPS_CAPTURE_PIC = "gpsCapturePic";
        public static final String KEY_GPS_COMPLEMENT_BY_DB = "gpsComplementByDB";
        public static final String KEY_GPS_COMPLEMENT_BY_EXIF = "gpsComplementByExif";
        public static final String KEY_GPS_COMPLEMENT_BY_LOCAL = "gpsComplementByLocal";
        public static final String KEY_GPS_COMPLEMENT_TYPE = "gpsComplementType";
        public static final String KEY_GPS_PIC_EDIT = "gpsPicEdit";
        public static final String KEY_GPS_SWITCH = "gpsSwitch";
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class UserInfo {
        private static UserInfo userInfo;
        public String qzone_uin = null;
        public String nickname = null;

        UserInfo() {
        }

        public static UserInfo getInstance() {
            if (userInfo == null) {
                userInfo = new UserInfo();
            }
            userInfo.qzone_uin = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
            UserInfo userInfo2 = userInfo;
            userInfo2.nickname = null;
            return userInfo2;
        }
    }

    public static void addQZoneStatis(Intent intent, int i3) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).addQZoneStatis(intent, i3);
    }

    public static final void addSource(Intent intent) {
        if (intent != null) {
            intent.putExtra("big_brother_source_key", "biz_src_jc_qzone");
        }
    }

    public static void bindQzonePublishQueueService(AppRuntime appRuntime, ServiceConnection serviceConnection) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).bindQzonePublishQueueService(appRuntime, serviceConnection);
    }

    public static void bindQzoneVideoService(Context context, String str, ServiceConnection serviceConnection) {
        ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).bindService(context, str, serviceConnection);
    }

    public static boolean canGifPlaySwitch() {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_GIF_SETTING, QzoneConfig.SECONDARY_FEED_GIF_PLAY_SWITCH, 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean checkPackageInstalled(Context context, String str) {
        return PackageUtil.isPackageInstalled(context, str);
    }

    public static boolean checkQzoneEntranceProtectEnable() {
        boolean bool = LocalMultiProcConfig.getBool(Constants.KEY_PROTECT_ENABLE, false);
        comboqzProtectEnable = bool;
        if (bool) {
            if (!QUA.getQUA3().equals(LocalMultiProcConfig.getString(Constants.KEY_QUA, ""))) {
                LocalMultiProcConfig.putBool(Constants.KEY_PROTECT_ENABLE, false);
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QzoneEntranceProtectEnable:" + comboqzProtectEnable);
        }
        return comboqzProtectEnable;
    }

    public static void clearCache(AppRuntime appRuntime, boolean z16) {
        if (appRuntime == null) {
            return;
        }
        MobileQQ application = appRuntime.getApplication();
        String account = appRuntime.getAccount();
        BaseApplication.getContext().stopService(getPictureBootServiceIntent(BaseApplication.getContext()));
        Utils.N(BaseApplication.getContext(), "com.tencent.mobileqq:picture");
        BaseApplication.getContext().stopService(getQzoneBootServiceIntent(BaseApplication.getContext()));
        Utils.N(BaseApplication.getContext(), "com.tencent.mobileqq:qzone");
        Utils.N(BaseApplication.getContext(), "com.tencent.mobileqq:qzonevideo");
        CacheManager.clearFileCache(application);
        if (!TextUtils.isEmpty(account)) {
            application.deleteDatabase(SecurityUtil.c(account));
            LocalMultiProcConfig.putInt(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX + account, "WidgetID", -1);
        }
        application.deleteDatabase(SecurityUtil.c("0"));
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).cleanAllQZconfig();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(application.getFilesDir().getParent());
        String str = File.separator;
        sb5.append(str);
        sb5.append("shared_prefs");
        String sb6 = sb5.toString();
        if (!TextUtils.isEmpty(sb6)) {
            deleteFile(sb6 + str + "qz_predownload_config.xml");
            deleteFile(sb6 + str + "QZ_Per_Config.xml");
            deleteFile(sb6 + str + "QZONE_UNREAD.xml");
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + str + "tencent" + str + "MobileQQ" + str + "trace");
        if (sDKPrivatePath != null) {
            deleteFile(sDKPrivatePath);
        }
        if (z16) {
            ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).deleteAllH5Data(appRuntime);
        }
    }

    public static void clearFeedsCache(Context context, String str) {
        if (context == null) {
            return;
        }
        BaseApplication.getContext().stopService(getPictureBootServiceIntent(BaseApplication.getContext()));
        Utils.N(BaseApplication.getContext(), "com.tencent.mobileqq:picture");
        BaseApplication.getContext().stopService(getQzoneBootServiceIntent(BaseApplication.getContext()));
        Utils.N(BaseApplication.getContext(), "com.tencent.mobileqq:qzone");
        Utils.N(BaseApplication.getContext(), "com.tencent.mobileqq:qzonevideo");
        if (!TextUtils.isEmpty(str)) {
            context.deleteDatabase(SecurityUtil.c(str));
        }
    }

    public static void createAlbumShortCut(final AppRuntime appRuntime, final String str, final String str2, final Bitmap bitmap, final long j3) {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.QZoneHelper.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QZoneHelper.createAlbumShortcutWithBmp(bitmap, appRuntime, str, j3, str2);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e(QZoneHelper.TAG, 2, "createAlbumShortCut error! exception e = " + e16.getMessage());
                    ToastUtil.a().b(R.string.f170347o5);
                }
            }
        }, 2, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createAlbumShortcutWithBmp(Bitmap bitmap, @NonNull AppRuntime appRuntime, String str, long j3, String str2) throws InterruptedException {
        boolean isRequestPinShortcutSupported;
        IntentSender intentSender;
        if (bitmap == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "createAlbumShortcutWithBmp end, iconBmp is null");
                return;
            }
            return;
        }
        boolean z16 = false;
        if (Build.VERSION.SDK_INT < 26) {
            if (ec.k(appRuntime.getApp(), new String[]{str})) {
                ToastUtil.a().b(R.string.f170328mh);
                return;
            }
            ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).createShortcut(appRuntime, getShortcutIntent(appRuntime, str, j3), str2, bitmap);
            LockMethodProxy.sleep(1000L);
            if (ec.k(appRuntime.getApplication(), new String[]{str})) {
                ToastUtil.a().b(R.string.aez);
                return;
            } else {
                onCreateShortcutFailed(appRuntime);
                return;
            }
        }
        BaseApplication app = appRuntime.getApp();
        ShortcutManager shortcutManager = (ShortcutManager) app.getSystemService("shortcut");
        if (!isShortcutCreated_O(str, shortcutManager)) {
            isRequestPinShortcutSupported = shortcutManager.isRequestPinShortcutSupported();
            if (isRequestPinShortcutSupported) {
                ShortcutInfo albumShortcutInfo = getAlbumShortcutInfo(app, bitmap, str, j3, str2, CommonConstant.ACTION.HWID_SCHEME_URL);
                Intent intent = new Intent(INTENT_ACTION_CREATE_ALBUM_SHORTCUT);
                intent.putExtra("UploadPhoto.key_album_id", str);
                PendingIntent broadcast = PendingIntent.getBroadcast(app, 0, intent, 167772160);
                if (broadcast != null) {
                    intentSender = broadcast.getIntentSender();
                } else {
                    intentSender = null;
                }
                z16 = shortcutManager.requestPinShortcut(albumShortcutInfo, intentSender);
            }
            if (!z16) {
                onCreateShortcutFailed(appRuntime);
                return;
            }
            return;
        }
        ToastUtil.a().b(R.string.f170328mh);
    }

    public static AppRuntime createQZoneAppInterface(Context context, String str) {
        PerfTracer.traceStart(PerfTracer.RUNTIME_LOAD_RUNTIME);
        if (context == null || str == null) {
            return null;
        }
        try {
            try {
                try {
                    QLog.e(QZLog.TO_DEVICE_TAG, 1, "*createQZoneAppInterface  begin");
                    Object newInstance = Class.forName(CLS_QZONEAPPINTERFACE).newInstance();
                    if (newInstance != null && (newInstance instanceof AppRuntime)) {
                        QLog.e(QZLog.TO_DEVICE_TAG, 1, "*createQZoneAppInterface  suscees");
                        return (AppRuntime) newInstance;
                    }
                } catch (ClassNotFoundException e16) {
                    QLog.e(TAG, 1, "createQZoneAppInterface", e16);
                } catch (IllegalAccessException e17) {
                    QLog.e(TAG, 1, "createQZoneAppInterface", e17);
                } catch (InstantiationException e18) {
                    QLog.e(TAG, 1, "createQZoneAppInterface", e18);
                }
            } catch (IllegalArgumentException e19) {
                QLog.e(TAG, 1, "createQZoneAppInterface", e19);
            } catch (Exception e26) {
                QLog.e(TAG, 1, "createQZoneAppInterface", e26);
            }
            return null;
        } finally {
            PerfTracer.traceEnd(PerfTracer.RUNTIME_LOAD_RUNTIME);
        }
    }

    public static SurfaceView createQZoneFloatObjectView(Context context, String str) {
        try {
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (isInFloatItemBlacklist()) {
            ToastUtil.a().f(STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW, 1);
            return null;
        }
        Class<?> cls = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
        Object newInstance = cls.getDeclaredConstructor(Context.class).newInstance(context);
        cls.getMethod("initObjects", String.class, Boolean.TYPE).invoke(newInstance, str, Boolean.TRUE);
        if (newInstance != null && (newInstance instanceof SurfaceView)) {
            return (SurfaceView) newInstance;
        }
        return null;
    }

    public static AppRuntime createQZoneMainRuntime(Context context, String str) {
        return ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).createQZoneMainRuntime(context, str);
    }

    public static AppRuntime createQZonePictureAppInterface(Context context, String str) {
        PerfTracer.traceStart(PerfTracer.RUNTIME_LOAD_RUNTIME);
        if (context == null || str == null) {
            return null;
        }
        try {
            try {
                Object newInstance = Class.forName(CLS_QZONEPICTURE_APPINTERFACE).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance != null && (newInstance instanceof AppRuntime)) {
                    return (AppRuntime) newInstance;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return null;
        } finally {
            PerfTracer.traceEnd(PerfTracer.RUNTIME_LOAD_RUNTIME);
        }
    }

    public static boolean deleteFile(String str) {
        boolean z16 = false;
        if (str != null && str.length() > 0) {
            try {
                z16 = deleteFile(new File(str));
                if (z16) {
                    tryDelMediaStore(str);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Tools.delete", 2, "" + e16.getMessage());
                }
            }
        }
        return z16;
    }

    private static void deleteShortcut(Intent intent, @NonNull AppRuntime appRuntime, String str, Bitmap bitmap) {
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", bitmap);
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        appRuntime.getApp().sendOrderedBroadcast(intent2, null);
    }

    public static boolean disableAioStoryFeedReq() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_HIDE_AIO_STORY_FEED, 1) == 1) {
            return true;
        }
        return false;
    }

    private static boolean disablePreloadQZoneProcess(boolean z16, String str) {
        if (!z16 && (ACTION_PRELOAD_FRIEND_FEEDS.equals(str) || ACTION_PRELOAD_USER_HOME.equals(str))) {
            return true;
        }
        return false;
    }

    public static boolean enableLayoutInflaterFactory() {
        if (QzoneConfig.getInstance().getConfigSync("QZoneSetting", QzoneConfig.SECONDARY_KEY_CAN_SET_LAYOUT_INFLATER_FACTORY, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean enableQZoneContextBox(AppRuntime appRuntime) {
        try {
            return ((c) appRuntime.getManager(((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQzoneManagerInQQManagerFactory())).U1();
        } catch (Throwable th5) {
            QZLog.e("enableQZoneContextBox", 2, th5, new Object[0]);
            return false;
        }
    }

    public static void forwardFromQQSettingToPersonalAlbum(Activity activity, UserInfo userInfo, Long l3, int i3, boolean z16, int i16) {
        forwardToPersonalAlbum(activity, userInfo, l3, i3, z16, i16, 5);
    }

    public static void forwardFromSearchToFriendFeed(Activity activity, String str, Intent intent, int i3) {
        QZoneLoginReportHelper.setLoginFromSearch(intent);
        forwardToFriendFeed(activity, str, intent, i3);
    }

    public static void forwardFromSearchToPersonalAlbum(Activity activity, UserInfo userInfo, Long l3, int i3, boolean z16, int i16) {
        forwardToPersonalAlbum(activity, userInfo, l3, i3, z16, i16, 12);
    }

    public static void forwardH5QZone(String str, Context context) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).forwardH5QZone(str, context);
    }

    public static void forwardMiniToTroopUploadPhoto(Activity activity, String str, int i3, int i16, long j3, String str2, String str3, String str4, int i17, int i18) {
        UserInfo userInfo = UserInfo.getInstance();
        userInfo.qzone_uin = str;
        Intent qZoneUploadPhotoActivityIntent = getQZoneUploadPhotoActivityIntent(null, i3, String.valueOf(j3), str2, str3, str4, "mqqChat");
        qZoneUploadPhotoActivityIntent.putExtra(QZoneUploadPhotoConstants.KEY_TYPE, i16);
        qZoneUploadPhotoActivityIntent.putExtra(IS_FROM_MINI_APP, true);
        qZoneUploadPhotoActivityIntent.putExtra("up_way", i18);
        qZoneUploadPhotoActivityIntent.setFlags(402653184);
        setUserInfoToIntent(qZoneUploadPhotoActivityIntent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(qZoneUploadPhotoActivityIntent, UPLOAD_PHOTO);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, qZoneUploadPhotoActivityIntent, i17);
    }

    public static void forwardOpenQzoneVip2(Activity activity, UserInfo userInfo, String str, long j3, String str2, int i3, String str3, boolean z16) {
        Intent intent = new Intent(Constants.INTENT_ACTION_QZONE_OPEN_VIP);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, OPEN_VIP);
        intent.putExtra("aid", str);
        intent.putExtra("provide_uin", j3);
        intent.putExtra("success_tips", str3);
        intent.putExtra("direct_go", !z16);
        intent.putExtra("need_loading_dialog", true);
        intent.putExtra("key_open_qzone_vip_dialog_title", str2);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToBrowser(Activity activity, String str, int i3, Bundle bundle, String str2) {
        byte[] bytes;
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("url", str);
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        qQBrowserActivityIntent.putExtra("injectrecommend", true);
        qQBrowserActivityIntent.setData(Uri.parse(str));
        if (TextUtils.isEmpty(str2)) {
            bytes = null;
        } else {
            bytes = str2.getBytes();
        }
        if (bytes != null) {
            qQBrowserActivityIntent.putExtra("post_data", bytes);
        }
        if (bundle != null) {
            qQBrowserActivityIntent.putExtras(bundle);
        }
        addSource(qQBrowserActivityIntent);
        activity.startActivityForResult(qQBrowserActivityIntent, i3);
    }

    public static void forwardToCategoryAlbum(Activity activity, String str, int i3, String str2, int i16) {
        if (!TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            intent.putExtra(QzonePhotoCategoryConstants.CATEGORY_BUSI_TYPE, i3);
            intent.putExtra("categoryId", str2);
            ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QZONE_CATEGORY_ALBUM_ACTIVITY);
            ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, str, intent, i16);
            return;
        }
        QLog.e(TAG, 1, "forwardToCategoryAlbum fail type = " + i3 + " id=" + str2);
    }

    public static void forwardToCoverPhotoWall(Activity activity, UserInfo userInfo, CoverCacheData coverCacheData, String str, int i3) {
        String photoWallUrl = QZoneCoverConstants.getPhotoWallUrl(userInfo.qzone_uin, str, QZ_COVER_FROM_UserSummary, true);
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("url", photoWallUrl);
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(photoWallUrl));
        addSource(qQBrowserActivityIntent);
        activity.startActivityForResult(qQBrowserActivityIntent, i3);
    }

    public static void forwardToDetail(Activity activity, String str, long j3, String str2) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.putExtra("qzone.isFavorBlog", !TextUtils.isEmpty(str2) && str2.contains("blog"));
        intent.putExtra("qzone.cellid", str);
        intent.putExtra("qzone.sourceFrom", true);
        intent.putExtra("qzone.favorOwner", j3);
        QZoneLoginReportHelper.setLoginFromMyFav(intent);
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchDetailPage(activity, intent.getExtras());
    }

    public static void forwardToFeedActionPanel(Activity activity, UserInfo userInfo, int i3, String str, String str2, String str3, String str4, int i16, boolean z16, int i17, int i18, int i19, int i26, int i27, String str5, int i28, int i29, boolean z17, String str6, boolean z18, Bundle bundle) {
        int i36 = i26 == 0 ? -1 : i16;
        Intent feedActionPanel = getFeedActionPanel(activity, str, str2, str3, str4, (i26 == 1 && i36 == 1) ? i36 == 1 ? 1 : 0 : i36, 0, null, i3, "", false);
        setUserInfoToIntent(feedActionPanel, userInfo);
        feedActionPanel.putExtra("showaticon", i17);
        feedActionPanel.putExtra("showemotionicon", i18);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.SHOW_XUANQU, i19);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.NEEDTRANSEMOJ, 1);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_SENDBTN_TEXT, str5);
        feedActionPanel.putExtra("inputmax", i28);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SHARE, z16);
        if (i29 != 0) {
            feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_IS_QUN, true);
            feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_ID, String.valueOf(i29));
        }
        if (!TextUtils.isEmpty(str6)) {
            feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, str6);
        }
        feedActionPanel.putExtra("is_live_mode", z18);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(feedActionPanel, QZONE_FEEDACTIONPANELACTIVITY);
        if (bundle != null) {
            feedActionPanel.putExtra("disableAutoClose", bundle.getBoolean("disableAutoClose"));
            feedActionPanel.putExtra("catchHeightChange", bundle.getBoolean("catchHeightChange"));
            feedActionPanel.putExtra("catchClosePanel", bundle.getBoolean("catchClosePanel"));
            feedActionPanel.putExtra("input_text_allow_empty", bundle.getBoolean("input_text_allow_empty"));
            feedActionPanel.putExtra("isFromDIY", bundle.getBoolean("isFromDIY"));
            feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, bundle.getInt(QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1));
        }
        feedActionPanel.putExtra("extra_key_from_scene", 4);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, feedActionPanel, i3, null, z17);
    }

    public static void forwardToFriendFeed(Activity activity, String str, Intent intent, int i3) {
        forwardToFriendFeed(activity, str, intent, (String) null, i3);
    }

    public static void forwardToGroupAlbum(Activity activity, UserInfo userInfo, String str, String str2, String str3, String str4, long j3, int i3) {
        Intent intent = new Intent(Constants.INTENT_ACTION_RESHIP_FROM_QUN_AIO_TO_QUN);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, UPLOAD_PHOTO);
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 6);
        intent.putExtra(Constants.KEY_QUN_ID, str);
        intent.putExtra(Constants.KEY_QUN_CODE, str2);
        intent.putExtra(Constants.KEY_THUMB_FILE_PATH, str3);
        intent.putExtra(Constants.KEY_BIG_PHOTO_UUID, str4);
        intent.putExtra(Constants.KEY_MSG_TIME, j3);
        intent.putExtra("refer", "mqqChat");
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToMoodSelectLocation(Activity activity, UserInfo userInfo, int i3, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, MOOD_SELECT_LOCATION);
        intent.putExtra(KEY_MODAL, true);
        intent.putExtra(KEY_HIDE_QZONE_ICON, true);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToPermissionSetting(Activity activity, UserInfo userInfo, int i3) {
        String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_SETTING_MAIN_PAGE, QzoneConfig.DefaultValue.DEFAULT_QZONE_SETTING_MAIN_PAGE).replace("{uin}", String.valueOf(userInfo.qzone_uin)).replace("{host_uin}", userInfo.qzone_uin).replace("{UIN}", String.valueOf(userInfo.qzone_uin)).replace("{HOST_UIN}", userInfo.qzone_uin);
        if (!URLUtil.getArguments(replace).containsKey("_wv")) {
            URLUtil.addParameter(replace, "_wv", "5");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "jump qzone setting URL:" + replace);
        }
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("url", replace);
        qQBrowserActivityIntent.putExtra("isFromQQ", true);
        qQBrowserActivityIntent.putExtra("fromQZone", false);
        qQBrowserActivityIntent.putExtra("injectrecommend", true);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        qQBrowserActivityIntent.addFlags(268435456);
        addSource(qQBrowserActivityIntent);
        activity.startActivity(qQBrowserActivityIntent);
    }

    public static void forwardToPersonalAlbum(Activity activity, UserInfo userInfo, Long l3, int i3, boolean z16, int i16, int i17) {
        LocalMultiProcConfig.putBool(QzoneSharePrefrenceConstants.KEY_PHOTO_GUIDE_IS_RED, z16);
        if (((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).isOpenQZAlbumx()) {
            Intent intent = new Intent();
            QZoneLoginReportHelper.handleLoginToMyAlbum(intent, i17);
            ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZAlbumxMainPage(activity, userInfo.qzone_uin, intent.getExtras(), QZoneAppConstants.REFER_QQ_SETTING);
            return;
        }
        Intent qzonePersonalAlbumActivityIntent = getQzonePersonalAlbumActivityIntent(activity, l3, i3);
        setUserInfoToIntent(qzonePersonalAlbumActivityIntent, userInfo);
        qzonePersonalAlbumActivityIntent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 3);
        qzonePersonalAlbumActivityIntent.putExtra(QZoneAlbumConstants.KEY_NEED_SHOW_ALBUM_RECENT_PHOTO, true);
        qzonePersonalAlbumActivityIntent.putExtra("refer", QZoneAppConstants.REFER_QQ_SETTING);
        qzonePersonalAlbumActivityIntent.putExtra(QZoneAppConstants.KEY_HAS_REDTOUCH, z16);
        QZoneLoginReportHelper.handleLoginToMyAlbum(qzonePersonalAlbumActivityIntent, i17);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, qzonePersonalAlbumActivityIntent, i16);
    }

    public static void forwardToPersonalAlbumPhotoList(Activity activity, UserInfo userInfo, BaseBusinessAlbumInfo baseBusinessAlbumInfo, int i3) {
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, getAlbumPhotoListIntent(userInfo, baseBusinessAlbumInfo), i3);
    }

    public static void forwardToPersonalAlbumPhotoListFromShortcut(Activity activity, UserInfo userInfo, BaseBusinessAlbumInfo baseBusinessAlbumInfo, int i3) {
        Intent albumPhotoListIntent = getAlbumPhotoListIntent(userInfo, baseBusinessAlbumInfo);
        albumPhotoListIntent.putExtra(Constants.KEY_FROM_ALBUM_SHORTCUT, true);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, albumPhotoListIntent, i3);
    }

    public static void forwardToPersonalAlbumPhotoListV2(Activity activity, UserInfo userInfo, BaseBusinessAlbumInfo baseBusinessAlbumInfo, int i3, String str) {
        Intent albumPhotoListIntent = getAlbumPhotoListIntent(userInfo, baseBusinessAlbumInfo);
        albumPhotoListIntent.putExtra("mqqflag", 1);
        albumPhotoListIntent.putExtra("cell_operation.qq_url", str);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, albumPhotoListIntent, i3);
    }

    public static void forwardToPersonalAlbumSelect(Activity activity, UserInfo userInfo, Bundle bundle, int i3) {
        Intent qzoneActivityIntentForName = getQzoneActivityIntentForName(userInfo, PERSONAL_ALBUM_SELECT);
        qzoneActivityIntentForName.putExtras(bundle);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, qzoneActivityIntentForName, i3);
    }

    public static void forwardToPersonalAlbumVideoList(Activity activity, UserInfo userInfo, BaseBusinessAlbumInfo baseBusinessAlbumInfo, int i3, String str) {
        Intent intent = new Intent();
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, PERSONAL_PHOTO_LIST);
        intent.putExtra(QZonePersonalAlbumContants.KEY_ALBUM_ID, baseBusinessAlbumInfo.mAlbumId);
        intent.putExtra(QZonePersonalAlbumContants.KEY_ALBUM_NAME, baseBusinessAlbumInfo.mTitle);
        intent.putExtra("key_album_owner_uin", baseBusinessAlbumInfo.mUin);
        intent.putExtra("key_last_upload_time", baseBusinessAlbumInfo.mLastUploadTime);
        intent.putExtra("key_priv", baseBusinessAlbumInfo.mPrivacy);
        intent.putExtra(QZonePersonalAlbumContants.KEY_IS_INDIVIDUAL_ALBUM, baseBusinessAlbumInfo.isIndividualityAlbum);
        intent.putExtra(QZonePersonalAlbumContants.KEY_ALBUM_ANONYMITY, baseBusinessAlbumInfo.mAnonymity);
        intent.putExtra(QZoneAlbumConstants.QZ_ALBUM_THEME, baseBusinessAlbumInfo.mAlbumType);
        intent.putExtra("key_personal_album_enter_model", 2);
        intent.putExtra(QZonePersonalAlbumContants.KEY_ALBUM_REFER, str);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToPersonalPhotoList(Activity activity, UserInfo userInfo, Bundle bundle, int i3) {
        Intent qzoneActivityIntentForName = getQzoneActivityIntentForName(userInfo, PERSONAL_PHOTO_LIST);
        qzoneActivityIntentForName.putExtras(bundle);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, qzoneActivityIntentForName, i3);
    }

    public static void forwardToPictureSetting(Context context, UserInfo userInfo) {
        String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_PICUTRE_SETTING_PAGE, QzoneConfig.DefaultValue.DEFAULT_QZONE_PICUTRE_SETTING_PAGE).replace("{uin}", String.valueOf(userInfo.qzone_uin)).replace("{host_uin}", userInfo.qzone_uin).replace("{UIN}", String.valueOf(userInfo.qzone_uin)).replace("{HOST_UIN}", userInfo.qzone_uin);
        if (!URLUtil.getArguments(replace).containsKey("_wv")) {
            URLUtil.addParameter(replace, "_wv", "5");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "jump qzone setting URL:" + replace);
        }
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(context);
        qQBrowserActivityIntent.putExtra("url", replace);
        qQBrowserActivityIntent.putExtra("isFromQQ", true);
        qQBrowserActivityIntent.putExtra("fromQZone", false);
        qQBrowserActivityIntent.putExtra("injectrecommend", true);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        qQBrowserActivityIntent.addFlags(268435456);
        addSource(qQBrowserActivityIntent);
        context.startActivity(qQBrowserActivityIntent);
    }

    public static void forwardToPictureViewer(Activity activity, UserInfo userInfo, Bundle bundle, int i3) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData(RemoteHandleConst.CMD_CANCEL_KILL_PICTURE_PROCESS, null, false);
        Intent qzoneActivityIntentForName = getQzoneActivityIntentForName(userInfo, GALLERY_VIEWER);
        qzoneActivityIntentForName.putExtra("public_fragment_class", PICTURE_VIEWER_FRAGMENT);
        qzoneActivityIntentForName.putExtras(bundle);
        qzoneActivityIntentForName.putExtra("fromQZone", false);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, qzoneActivityIntentForName, i3, null, false);
    }

    public static void forwardToPictureViewerForQzone(Activity activity, UserInfo userInfo, Bundle bundle, int i3) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData(RemoteHandleConst.CMD_CANCEL_KILL_PICTURE_PROCESS, null, false);
        QLog.i(TAG, 1, "launch main process layer");
        Intent qzoneActivityIntentForName = getQzoneActivityIntentForName(userInfo, GALLERY_VIEWER);
        qzoneActivityIntentForName.putExtra("public_fragment_class", PICTURE_VIEWER_FRAGMENT);
        qzoneActivityIntentForName.putExtras(bundle);
        qzoneActivityIntentForName.putExtra("fromQZone", true);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, qzoneActivityIntentForName, i3, null, false);
    }

    public static void forwardToPreviewLocalView(Activity activity, UserInfo userInfo, int i3, String str, long j3, long j16) {
        Intent intent = new Intent();
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, PAGE_VIDEO_VIEW);
        intent.putExtra("video_type", i3);
        intent.putExtra("video_source_path", str);
        intent.putExtra("start_time", j3);
        intent.putExtra("end_time", j16);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, 0);
    }

    public static void forwardToPublishBox(Context context, Bundle bundle, int i3) {
        Intent intent = new Intent();
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
        intent.putExtra("fromQZone", false);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(context, "0", intent, i3, null, false);
    }

    public static void forwardToPublishMood(Activity activity, UserInfo userInfo, String str, String str2, String str3, int i3) {
        forwardToPublishMood(activity, userInfo, str, str2, str3, "", null, i3);
    }

    public static void forwardToPublishMoodWithExtBundle(Activity activity, UserInfo userInfo, String str, String str2, String str3, Bundle bundle, int i3) {
        forwardToPublishMood(activity, userInfo, str, str2, str3, "", bundle, i3);
    }

    public static void forwardToPublishQueue(Context context, UserInfo userInfo, int i3) {
        forwardToPublishQueue(context, userInfo, null, i3);
    }

    public static void forwardToQQPublicAccountPublishPage(Activity activity, Intent intent, int i3) {
        AppRuntime waitAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
        if (waitAppRuntime != null) {
            String valueOf = String.valueOf(waitAppRuntime.getLongAccountUin());
            if (intent == null) {
                intent = new Intent();
            }
            ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QQ_PUBLIC_ACCOUNT_PUBLISH_PAGE);
            ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, valueOf, intent, i3);
        }
    }

    public static void forwardToQZoneFlashNickNameSetting(Activity activity, String str) {
        Intent intent = new Intent();
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, PAGE_FLASH_NICK_NAME_SETTING);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, str, intent, 0);
    }

    public static boolean forwardToQZoneFriendFeedActivity(Context context, Intent intent, boolean z16) {
        return ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).forwardToQZoneFriendFeedActivity(context, intent, z16);
    }

    public static void forwardToQunAlbumDetail(Activity activity, UserInfo userInfo, String str, String str2, int i3) {
        String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_DETAIL_URL, Constants.URL_QUN_ALBUM_DEATAIL).replace("{QQ_URL}", URLEncoder.encode(str));
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("url", replace);
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        qQBrowserActivityIntent.putExtra("injectrecommend", true);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        activity.startActivityForResult(qQBrowserActivityIntent, i3);
    }

    public static void forwardToQunAlbumList(Activity activity, UserInfo userInfo, String str, String str2, int i3, int i16, String str3) {
        String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_URL, Constants.URL_QUN_ALBUM).replace("{QUN_ID}", str);
        if (!TextUtils.isEmpty(str3)) {
            replace = replace + "&source=" + str3;
        }
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "forwardToQunAlbumList:" + replace);
        }
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        qQBrowserActivityIntent.putExtra("url", replace);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        addSource(qQBrowserActivityIntent);
        activity.startActivityForResult(qQBrowserActivityIntent, i16);
    }

    public static void forwardToQunAlbumListSelect(Activity activity, UserInfo userInfo, String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_SELECT_URL, Constants.URL_QUN_ALBUM_SELECT_URL).replace("{QUN_ID}", str);
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("url", replace);
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        addSource(qQBrowserActivityIntent);
        activity.startActivityForResult(qQBrowserActivityIntent, i3);
    }

    public static void forwardToQunFeed(Activity activity, UserInfo userInfo, String str, String str2, boolean z16, int i3) {
        String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_FEED_URL, Constants.URL_QUN_FEED).replace("{QUN_ID}", str);
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("url", replace);
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        qQBrowserActivityIntent.putExtra("injectrecommend", true);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        if (QZoneLoginReportHelper.needAddLoginFromQunAlbum(qQBrowserActivityIntent, i3)) {
            QZoneLoginReportHelper.reportLoginFromQunAlbum();
        }
        activity.startActivityForResult(qQBrowserActivityIntent, i3);
    }

    public static void forwardToQunPassiveFeed(Activity activity, UserInfo userInfo, String str, int i3) {
        String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_PASSIVE_FEED_URL, Constants.URL_QUN_PASSIVE_FEED).replace("{QUN_ID}", str).replace("{UIN}", userInfo.qzone_uin);
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("url", replace);
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        qQBrowserActivityIntent.putExtra("injectrecommend", true);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        if (QZoneLoginReportHelper.needAddLoginFromQunAlbum(qQBrowserActivityIntent, i3)) {
            QZoneLoginReportHelper.reportLoginFromQunAlbum();
        }
        activity.startActivityForResult(qQBrowserActivityIntent, i3);
    }

    public static void forwardToQzDynamicEditVideoActivity(Activity activity, UserInfo userInfo, Bundle bundle, int i3) {
        Intent intent = new Intent();
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, PAGE_DYNAMIC_VIDEO_EDIT);
        intent.putExtras(bundle);
        intent.putExtra(PeakConstants.EXTRA_IS_FROM_P2V_EDIT, true);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3, null, false);
    }

    public static void forwardToQzoneAlbum(Activity activity, UserInfo userInfo, boolean z16, String str, String str2, int i3, String str3, String str4, long j3, long j16, int i16) {
        Intent intent = new Intent(Constants.INTENT_ACTION_FORWARD_PHOTO_FROM_AIO_TO_QZONE);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, UPLOAD_PHOTO);
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 6);
        if (z16) {
            intent.putExtra(Constants.KEY_QUN_ID, str);
            intent.putExtra(Constants.KEY_QUN_CODE, str2);
            intent.putExtra(Constants.KEY_BIG_PHOTO_FILE_ID, j16);
        }
        intent.putExtra(Constants.KEY_QUOTE_SRC_TYPE, i3);
        intent.putExtra(Constants.KEY_THUMB_FILE_PATH, str3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str3);
        intent.putExtra("images", arrayList);
        intent.putExtra(Constants.KEY_BIG_PHOTO_UUID, str4);
        intent.putExtra(Constants.KEY_MSG_TIME, j3);
        intent.putExtra("refer", "mqqChat");
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i16);
    }

    public static void forwardToQzoneBrowser(Activity activity, UserInfo userInfo, String str, int i3, Bundle bundle, String str2) {
        byte[] bytes;
        Intent intent = new Intent();
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, PAGE_BROWSER);
        intent.putExtra("url", str);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(str));
        if (TextUtils.isEmpty(str2)) {
            bytes = null;
        } else {
            bytes = str2.getBytes();
        }
        if (bytes != null) {
            intent.putExtra("post_data", bytes);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToQzoneTransluentActivity(Activity activity, UserInfo userInfo, Intent intent) {
        forwardToQzoneTransluentActivity(activity, userInfo, intent, -1);
    }

    public static void forwardToQzoneVideoCaptureNew(Activity activity, Bundle bundle, int i3) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).forwardToQzoneVideoCaptureNew(activity, bundle, i3);
    }

    public static void forwardToQzoneVideoTrim(Activity activity, UserInfo userInfo, String str, long j3, int i3, int i16, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("need_select_video", true);
        intent.putExtra("file_send_path", str);
        intent.putExtra(PeakConstants.VIDEO_SIZE, j3);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, i16);
        if (activity.getIntent() != null) {
            intent.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, activity.getIntent().getBooleanExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, false));
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("refer", str2);
        }
        intent.putExtra(PeakConstants.VIDEO_REFER, str3);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QZONE_VIDEO_TRIM);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToSharedFeedDetail(Activity activity, UserInfo userInfo, String str, String str2, int i3) {
        Intent intent = new Intent();
        intent.putExtra("mqqflag", 1);
        intent.putExtra("cell_operation.qq_url", str);
        intent.putExtra("refer", str2);
        if (QZoneLoginReportHelper.needAddLoginFromAIOFeedShare(intent, str2)) {
            QZoneLoginReportHelper.setLoginFromAIOFeedShare(intent);
        }
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchDetailPage(activity, intent.getExtras());
    }

    public static void forwardToShuoshuoDailyCalendar(Activity activity, UserInfo userInfo, int i3) {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_6, Locale.getDefault()).format(new Date());
        String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_SHUOSHUO_DAILY_CALENDAR, QzoneConfig.DefaultValue.DEFAULT_QZONE_SHUOSHUO_DAILY_CALENDAR).replace("{date}", format).replace("{DATE}", format);
        if (!URLUtil.getArguments(replace).containsKey("_wv")) {
            URLUtil.addParameter(replace, "_wv", "1027");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "jump qzone ShuoshuoDailyCalendar URL:" + replace);
        }
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("url", replace);
        qQBrowserActivityIntent.putExtra("isFromQQ", false);
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        qQBrowserActivityIntent.putExtra("injectrecommend", true);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        qQBrowserActivityIntent.addFlags(268435456);
        addSource(qQBrowserActivityIntent);
        activity.startActivity(qQBrowserActivityIntent);
    }

    public static void forwardToSinglePermissionSetting(Activity activity, UserInfo userInfo, long j3, int i3) {
        Intent intent = new Intent();
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, SINGLE_PERMISSION_SETTING);
        intent.putExtra("qqid", j3);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToTroopAlbumViewPhoto(Activity activity, UserInfo userInfo, String str, String str2, String str3, String str4, int i3) {
        String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_PHOTO_URL, Constants.URL_QUN_ALBUM_PHOTO).replace("{QUN_ID}", str).replace("{ALBUM_ID}", str2);
        Intent qQBrowserActivityIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(activity);
        qQBrowserActivityIntent.putExtra("fromQZone", true);
        qQBrowserActivityIntent.putExtra("url", replace);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(qQBrowserActivityIntent);
        qQBrowserActivityIntent.setData(Uri.parse(replace));
        addSource(qQBrowserActivityIntent);
        activity.startActivityForResult(qQBrowserActivityIntent, i3);
    }

    public static void forwardToTroopUploadPhoto(Activity activity, String str, int i3, int i16, long j3, String str2, String str3, String str4, int i17, int i18) {
        UserInfo userInfo = UserInfo.getInstance();
        userInfo.qzone_uin = str;
        Intent qZoneUploadPhotoActivityIntent = getQZoneUploadPhotoActivityIntent(null, i3, String.valueOf(j3), str2, str3, str4, "mqqChat");
        qZoneUploadPhotoActivityIntent.putExtra(QZoneUploadPhotoConstants.KEY_TYPE, i16);
        qZoneUploadPhotoActivityIntent.putExtra("up_way", i18);
        qZoneUploadPhotoActivityIntent.setFlags(67108864);
        setUserInfoToIntent(qZoneUploadPhotoActivityIntent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(qZoneUploadPhotoActivityIntent, UPLOAD_PHOTO);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, qZoneUploadPhotoActivityIntent, i17);
    }

    public static void forwardToUploadPhoto(Activity activity, String str, int i3, int i16, ArrayList<String> arrayList, String str2, int i17) {
        UserInfo userInfo = UserInfo.getInstance();
        userInfo.qzone_uin = str;
        Intent qZoneUploadPhotoActivityIntent = getQZoneUploadPhotoActivityIntent(null, i3, null, null, null, null, "mqqChat");
        qZoneUploadPhotoActivityIntent.putExtra(QZoneUploadPhotoConstants.KEY_TYPE, i16);
        qZoneUploadPhotoActivityIntent.putStringArrayListExtra("images", arrayList);
        qZoneUploadPhotoActivityIntent.putExtra(QZoneUploadPhotoConstants.KEY_BEGIN_SEND_SHOW_TOAST, str2);
        qZoneUploadPhotoActivityIntent.setFlags(67108864);
        setUserInfoToIntent(qZoneUploadPhotoActivityIntent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(qZoneUploadPhotoActivityIntent, UPLOAD_PHOTO);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, qZoneUploadPhotoActivityIntent, i17);
    }

    public static void forwardToUserHome(Context context, UserInfo userInfo, String str, int i3, int i16, int i17, b bVar, byte[] bArr, boolean z16) {
        boolean parseAndSetQzoneCoverInfoToIntent = parseAndSetQzoneCoverInfoToIntent(bArr);
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchUserHome(context, QZoneNumberUtil.safeParseLong(str, 0L), parseAndSetQzoneCoverInfoToIntent, i17 == 5 ? 2 : 0);
    }

    public static void forwardToVideoEditActionPanel(Activity activity, UserInfo userInfo, int i3, String str, String str2, String str3, String str4, int i16, int i17, int i18, int i19, int i26, int i27, String str5, int i28, Bundle bundle, boolean z16, boolean z17, int i29, int i36, boolean z18) {
        forwardToVideoEditActionPanel(activity, userInfo, i3, str, str2, str3, str4, i16, i17, i18, i19, i26, i27, str5, i28, bundle, z16, z17, i29, i36, z18, null);
    }

    public static void forwardToWriteMood(Activity activity, String str, int i3) {
        forwardToWriteMood(activity, str, null, null, null, null, i3, null);
    }

    @NonNull
    private static Intent getAlbumPhotoListIntent(UserInfo userInfo, BaseBusinessAlbumInfo baseBusinessAlbumInfo) {
        Intent intent = new Intent();
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, PERSONAL_PHOTO_LIST);
        intent.putExtra(QZonePersonalAlbumContants.KEY_ALBUM_ID, baseBusinessAlbumInfo.mAlbumId);
        intent.putExtra(QZonePersonalAlbumContants.KEY_PHOTO_SORT_TYPE, baseBusinessAlbumInfo.sortType);
        intent.putExtra(QZonePersonalAlbumContants.KEY_ALBUM_NAME, baseBusinessAlbumInfo.mTitle);
        intent.putExtra("key_album_owner_uin", baseBusinessAlbumInfo.mUin);
        intent.putExtra("key_last_upload_time", baseBusinessAlbumInfo.mLastUploadTime);
        intent.putExtra("key_priv", baseBusinessAlbumInfo.mPrivacy);
        intent.putExtra(QZonePersonalAlbumContants.KEY_IS_INDIVIDUAL_ALBUM, baseBusinessAlbumInfo.isIndividualityAlbum);
        intent.putExtra("key_personal_album_enter_model", 0);
        return intent;
    }

    @NonNull
    @RequiresApi(api = 26)
    private static ShortcutInfo getAlbumShortcutInfo(Context context, Bitmap bitmap, String str, long j3, String str2, String str3) {
        ShortcutInfo.Builder icon;
        ShortcutInfo.Builder shortLabel;
        ShortcutInfo.Builder intent;
        ShortcutInfo build;
        Intent shortcutIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getShortcutIntent(context);
        shortcutIntent.setAction(str3);
        shortcutIntent.putExtra("from", SHORT_CUT_FROM_QZONE_PHOTO_LIST);
        shortcutIntent.putExtra("UploadPhoto.key_album_id", str);
        shortcutIntent.putExtra(Constants.KEY_ALBUM_OWNER_UID, j3);
        shortcutIntent.setFlags(337641472);
        icon = new ShortcutInfo.Builder(context, str).setIcon(Icon.createWithBitmap(bitmap));
        shortLabel = icon.setShortLabel(str2);
        intent = shortLabel.setIntent(shortcutIntent);
        build = intent.build();
        return build;
    }

    public static int getDevicePerformanceLevel() {
        if (g_playGifParformanceLevel != 0) {
            return g_playGifParformanceLevel;
        }
        int i3 = 3;
        if (!((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(3, 2)) {
            i3 = 1;
            if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 1)) {
                i3 = 2;
            }
        }
        g_playGifParformanceLevel = i3;
        QLog.d(TAG, 2, "[jinqianli-performance] current mem level is " + ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getCurrentMemLevel() + ", current cpu level is " + ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getCurrentCpuLevel() + ", play gif parformance level is " + g_playGifParformanceLevel);
        return i3;
    }

    public static int getDevicePerformanceLevelInfo() {
        if (g_listScrollParformanceLevel != 0) {
            return g_listScrollParformanceLevel;
        }
        int i3 = 3;
        if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).equalHardwareRestriction(3, 3)) {
            i3 = 4;
        } else if (!((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).equalHardwareRestriction(2, 2)) {
            i3 = 1;
            if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).equalHardwareRestriction(1, 1)) {
                i3 = 2;
            }
        }
        g_listScrollParformanceLevel = i3;
        QLog.d(TAG, 2, "[jinqianli-performance] current mem level is " + ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getCurrentMemLevel() + ", current cpu level is " + ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getCurrentCpuLevel() + ", play gif parformance level is " + g_playGifParformanceLevel);
        return i3;
    }

    public static Intent getFeedActionPanel(Context context, String str, String str2, String str3, String str4, int i3, Serializable serializable, Parcelable parcelable, int i16, String str5, boolean z16) {
        Intent intent = new Intent();
        intent.putExtra(QzoneFeedActionPanelConstants.AUTOSAVE_STORAGE_KEY, str5);
        intent.putExtra("extraRequestCode", i16);
        intent.putExtra(QzoneFeedActionPanelConstants.SHOW_KEY_ICON, i3);
        if (str3 != null) {
            intent.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_COMMENT_ID, str3);
        }
        if (str4 != null) {
            intent.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_REPLY_ID, str4);
        }
        if (serializable != null) {
            intent.putExtra("extraIntentKey", serializable);
        }
        if (str2 != null) {
            intent.putExtra(QzoneFeedActionPanelConstants.FEED_TEXT_AUTOFILL_INTENT_KEY, str2);
        }
        if (parcelable != null) {
            intent.putExtra("extraIntentKeyParcelable", parcelable);
        }
        if (str != null) {
            intent.putExtra(QzoneFeedActionPanelConstants.FEED_TEXT_HINT_INTENT_KEY, str);
        }
        intent.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 1);
        return intent;
    }

    public static IUploadConfig.UploadImageSize getImageTargetSize(Context context, int i3, int i16, int i17, boolean z16) {
        try {
            Class<?> cls = Class.forName("com.qzone.misc.network.uploader.QZoneImageSizeStrategy");
            Class<?> cls2 = Integer.TYPE;
            return (IUploadConfig.UploadImageSize) cls.getMethod("getTargetSize", cls2, cls2, cls2, Boolean.TYPE).invoke(null, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static long getLongAccountUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getLongAccountUin();
        }
        return 0L;
    }

    private static Intent getPictureBootServiceIntent(BaseApplication baseApplication) {
        Intent intent = new Intent();
        intent.setClassName(baseApplication, "com.qzone.preview.service.PictureProcessBootService");
        return intent;
    }

    public static Intent getPublishQueueServiceIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.qzone.publish.business.publishqueue.PublishQueueService");
        return intent;
    }

    public static String getQUA() {
        return QUA.getQUA3();
    }

    private static Intent getQZoneUploadPhotoActivityIntent(String str, int i3, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = new Intent(str);
        intent.putExtra(Constants.KEY_STATE_TYPE_SRC, i3);
        intent.putExtra(Constants.KEY_QUN_ID, str2);
        intent.putExtra(Constants.KEY_QUN_NAME, str3);
        intent.putExtra("UploadPhoto.key_album_id", str4);
        intent.putExtra("UploadPhoto.key_album_name", str5);
        intent.putExtra(Constants.KEY_NEED_LOAD_PHOTO_FROM_INTENT, false);
        intent.putExtra("refer", str6);
        intent.putExtra("IsBack", true);
        return intent;
    }

    public static Intent getQZoneVideoDownloadActivityIntent(Context context) {
        return ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQZoneVideoDownloadActivityIntent(context);
    }

    public static Intent getQzoneActivityIntentForName(UserInfo userInfo, String str) {
        Intent intent = new Intent();
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, str);
        return intent;
    }

    public static Intent getQzoneBootServiceIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.qzone.preview.service.PictureService");
        return intent;
    }

    @Deprecated
    public static Intent getQzoneFriendFeedActivity(Context context) {
        Intent intent = new Intent();
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, FRIEND_FEED);
        return intent;
    }

    private static Intent getQzonePersonalAlbumActivityIntent(Context context, Long l3, int i3) {
        Intent intent = new Intent();
        intent.putExtra(QZoneAlbumConstants.KEY_LEFT_TAB_TITLE, context.getString(R.string.gaz));
        intent.putExtra(QZoneAlbumConstants.KEY_RIGHT_TAB_TITLE, context.getString(R.string.gcb));
        intent.putExtra("key_album_owner_uin", l3);
        intent.putExtra(QZoneAlbumConstants.KEY_SELECTED_TAB, i3);
        putTimeRecord(intent);
        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).fetchAndSaveLocalPhotoRecommendTabExperimentValue();
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, PERSONAL_ALBUM);
        return intent;
    }

    public static QIPCModule getQzoneVideoSoDownloadModule() {
        return ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getQzoneVideoSoDownloadModule();
    }

    public static int getSceneIdByActivityName(String str) {
        str.hashCode();
        if (!str.equals(FRIEND_FEED)) {
            return -1;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static Intent getShortcutIntent(@NonNull AppRuntime appRuntime, String str, long j3) {
        Intent shortcutIntent = ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getShortcutIntent(appRuntime.getApp());
        shortcutIntent.setAction(ACTION_SHORT_CUT);
        shortcutIntent.putExtra("from", SHORT_CUT_FROM_QZONE_PHOTO_LIST);
        shortcutIntent.putExtra("UploadPhoto.key_album_id", str);
        shortcutIntent.putExtra(Constants.KEY_ALBUM_OWNER_UID, j3);
        shortcutIntent.putExtra(Constants.KEY_FROM_ALBUM_SHORTCUT, true);
        shortcutIntent.addCategory("android.intent.category.LAUNCHER");
        shortcutIntent.setFlags(337641472);
        return shortcutIntent;
    }

    public static boolean getSimpleQZoneUISwitch() {
        return ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).getSimpleQZoneUISwitch();
    }

    public static int getUpdateCountIntervalWhenClickFeedTab() {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_UPDATE_COUNT_INTERVAL_WHENCLICKFEEDTAB, 30) * 1000;
        if (QLog.isColorLevel()) {
            QLog.d("QZoneHelper.UndealCount", 2, "getUpdateCountIntervalWhenClickFeedTab:" + config);
        }
        return config;
    }

    public static int getVideoCanCompressLimitMs() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SHORT_VIDEO_DURATION_THRESHOLD, 90000);
    }

    public static long getVideoCanUploadLimitMs() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SHORT_VIDEO_CAN_UPLOAD_DURATION_THRESHOLD, 600000);
    }

    public static long getVideoCanUploadSize() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SHORT_VIDEO_CAN_UPLOAD_SIZE_THRESHOLD, 1610612736L);
    }

    public static int getVideoCoverLimitMs() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHORT_VIDEO_DURATION_THRESHOLD, 60000);
    }

    public static void goQZoneAlbumPhotoList(Activity activity, String str, long j3, String str2) {
        UserInfo userInfo = UserInfo.getInstance();
        userInfo.qzone_uin = str2;
        BaseBusinessAlbumInfo baseBusinessAlbumInfo = new BaseBusinessAlbumInfo();
        baseBusinessAlbumInfo.mAlbumId = str;
        baseBusinessAlbumInfo.mUin = j3;
        baseBusinessAlbumInfo.mAlbumType = 0;
        baseBusinessAlbumInfo.isIndividualityAlbum = true;
        forwardToPersonalAlbumPhotoListFromShortcut(activity, userInfo, baseBusinessAlbumInfo, -1);
    }

    public static boolean hideAioFeeds() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_HIDE_AIO_FEEDS, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean hideQzoneStatusInConverstation() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_HIDE_QZONE_STATUS_IN_CONVERSATION, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isBestPerformanceDevice() {
        if (!gIsInitPerformanceDeviceState) {
            gIsBestPerformanceDevice = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1);
            gIsInitPerformanceDeviceState = true;
        }
        return gIsBestPerformanceDevice;
    }

    private static boolean isBuildModelInList(String str) {
        try {
            String model = DeviceInfoMonitor.getModel();
            if (model != null && model.length() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "buildModel is '" + model + "'");
                }
                if (str != null && str.length() != 0) {
                    if (("," + str + ",").contains("," + model + ",")) {
                        QLog.i(TAG, 1, "\u547d\u4e2d\u7981\u6b62\u9ed1\u540d\u5355\u7b56\u7565");
                        return true;
                    }
                }
                return false;
            }
            QLog.i(TAG, 1, "buildModel is empty,not show float items.\u547d\u4e2d\u7981\u6b62\u7b56\u7565");
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static boolean isFirstEnterFriendFeed() {
        return LocalMultiProcConfig.getBool(LocalMultiProcConfig.Constants.KEY_FIRST_ENTER_FRIEND_FEED, true);
    }

    public static boolean isInFloatItemBlacklist() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FLOAT_MODEL_BLACKLIST, QzoneConfig.FLOAT_MODEL_BLACKLIST_DEFAULT_VALUE);
        if (config == null) {
            return false;
        }
        if (!config.equals(g_floatBlacklist)) {
            g_isInFloatBlacklist = false;
            g_floatBlacklist = config;
        }
        return g_isInFloatBlacklist;
    }

    public static boolean isInParticleEffectBestPerformBlacklist() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PARTICLE_EFFECT_BEST_PERFORM_BLACKLIST, "");
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        if (!config.equals(g_particleEffectBestPerformBlacklist)) {
            g_isInParticleEffectBestPerformBlacklist = isBuildModelInList(config);
            g_particleEffectBestPerformBlacklist = config;
        }
        return g_isInParticleEffectBestPerformBlacklist;
    }

    public static boolean isInParticleEffectBlacklist() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PARTICLE_EFFECT_BLACKLIST, "", false);
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        if (!config.equals(g_particleEffectBlacklist)) {
            g_isInParticleEffectBlacklist = isBuildModelInList(config);
            g_particleEffectBlacklist = config;
        }
        return g_isInParticleEffectBlacklist;
    }

    public static boolean isInQzoneFacadeDynamicBlackList() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_FACADE_DYNAMIC_BLACK_LIST, QzoneConfig.QZONE_FACADE_DYNAMIC_DEFAULT_BLACK_LIST);
        if (config == null) {
            return false;
        }
        return isBuildModelInList(config);
    }

    public static boolean isInQzoneShowBreezeBlackList() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SHOW_BREEZE_BLACK_LIST, "");
        if (config == null) {
            return false;
        }
        return isBuildModelInList(config);
    }

    private static boolean isPreload2QTADisable() {
        if (new File(Environment.getExternalStorageDirectory().getPath(), "disable_preload").exists()) {
            return true;
        }
        return false;
    }

    public static boolean isQZonePage(String str) {
        return ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).isQZonePage(str);
    }

    public static boolean isShortcutCreated(String str, @NonNull Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return ec.k(context, new String[]{str});
        }
        return isShortcutCreated_O(str, (ShortcutManager) context.getSystemService(ShortcutManager.class));
    }

    @RequiresApi(api = 25)
    public static boolean isShortcutCreated_O(String str, ShortcutManager shortcutManager) {
        List pinnedShortcuts;
        String id5;
        if (shortcutManager == null) {
            return false;
        }
        pinnedShortcuts = shortcutManager.getPinnedShortcuts();
        Iterator it = pinnedShortcuts.iterator();
        while (it.hasNext()) {
            id5 = ((ShortcutInfo) it.next()).getId();
            if (str.equals(id5)) {
                return true;
            }
        }
        return false;
    }

    public static void killQZoneProcess() {
        QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "killQZoneProcess: " + Log.getStackTraceString(new Throwable()));
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).killQZoneProcess();
    }

    public static void launchGroupAlbumGalleryLayer(Activity activity, UserInfo userInfo, Bundle bundle, int i3) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).launchQZoneGroupAlbumGalleryLayer(activity, userInfo, bundle, i3);
    }

    public static void launchQZone(Activity activity, String str, Intent intent, int i3) {
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, str, intent, i3);
    }

    public static void launchQZoneEncourageAdvActivity(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("gdt_adv_activity_factory_info", str);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, PAGE_ENCOURAGE_ADV);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), intent, -1);
    }

    public static void launchVideoCoverPreviewActivity(Activity activity, int i3, String str, boolean z16, String str2, String str3, int i16, int i17, long j3, long j16, long j17, long j18, int i18, Bundle bundle, String str4, String str5, String str6, String str7) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(PeakConstants.IS_VIDEO_SELECTED, true);
        intent.putExtra(PeakConstants.VIDEO_TYPE, i3);
        intent.putExtra(PeakConstants.QZONE_ALBUM_VIDEO_ID, str == null ? "" : str);
        intent.putExtra("file_send_path", str2);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_PATH, str3);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, i17);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, i16);
        intent.putExtra(PeakConstants.VIDEO_NEED_PROCESS, z16);
        intent.putExtra("start_time", j16);
        intent.putExtra("end_time", j17);
        intent.putExtra(PeakConstants.VIDEO_TOTAL_DURATION, j3);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, j17 - j16);
        intent.putExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, i18);
        intent.putExtra(PeakConstants.VIDEO_SIZE, j18);
        intent.putExtra("COVER_STRING_TYPE", str7);
        if (bundle != null) {
            intent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, bundle);
        }
        intent.putExtra(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, str4);
        if (!TextUtils.isEmpty(str5)) {
            intent.putExtra("refer", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            intent.putExtra(PeakConstants.VIDEO_REFER, str6);
        }
        String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, VIDEO_COVER_PREVIEW_ACTVITY);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, account, intent, -1);
    }

    private static void onCreateShortcutFailed(@NonNull AppRuntime appRuntime) {
        Intent intent = new Intent(INTENT_ACTION_CREATE_ALBUM_SHORTCUT);
        intent.putExtra(QZONE_ALBUM_SHORTCUT_CREATE_FAILED, true);
        appRuntime.getApp().sendBroadcast(intent);
    }

    public static void onMQzoneSchema(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("cmd", "Schema");
        intent.putExtra(QZoneDTLoginReporter.SCHEMA, str);
        forwardToQzoneTransluentActivity((Activity) context, UserInfo.getInstance(), intent);
    }

    private static boolean parseAndSetQzoneCoverInfoToIntent(byte[] bArr) {
        int i3;
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        JceInputStream jceInputStream = new JceInputStream(bArr);
        RES_ITEM_COVER res_item_cover = new RES_ITEM_COVER();
        res_item_cover.readFrom(jceInputStream);
        String str = res_item_cover.strJumpQzone;
        if (!TextUtils.isEmpty(str) && str.startsWith(SCHEME_OPEN_HOME_PAGE)) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("actiontype");
            String queryParameter2 = parse.getQueryParameter(AlbumCacheData.ACTIONURL);
            String queryParameter3 = parse.getQueryParameter("uin");
            if (!TextUtils.isEmpty(queryParameter2)) {
                try {
                    URLDecoder.decode(queryParameter2, "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    QZLog.e(TAG, "parseAndSetQzoneCoverInfoToIntent", e16);
                    return false;
                }
            }
            try {
                i3 = Integer.parseInt(queryParameter);
                Long.parseLong(queryParameter3);
            } catch (NumberFormatException e17) {
                QZLog.e(TAG, "parseAndSetQzoneCoverInfoToIntent", e17);
                return false;
            }
        } else {
            i3 = 0;
        }
        if (i3 != 35) {
            return false;
        }
        return true;
    }

    public static void preloadInFriendProfileCard(final AppRuntime appRuntime, final b bVar) {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.QZoneHelper.5
            @Override // java.lang.Runnable
            public void run() {
                int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_QZONE_PROCESS_ENABLE, 1);
                if (QLog.isColorLevel()) {
                    QLog.d(QZoneHelper.TAG, 2, "preloadInFriendProfileCard enable:" + config);
                }
                if (config == 1) {
                    long c16 = m.c() / 1048576;
                    int config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_QZONE_PROCESS_RAM_THRESHOLD, 1024);
                    if (QLog.isColorLevel()) {
                        QLog.d(QZoneHelper.TAG, 2, "preloadInFriendProfileCard totalMemSize:" + c16 + ",threshold:" + config2);
                    }
                    if (c16 >= config2) {
                        QZoneHelper.preloadQzone(AppRuntime.this, QZoneHelper.QZONE_PRELOAD_FROM_FRIEND_PROFILE, bVar, false);
                    }
                }
            }
        }, 8, null, false);
    }

    public static void preloadQZoneForHaboReport(AppRuntime appRuntime, String str, int i3, String str2, int i16, long j3) {
        AccManager.createStatistic(str, i3, str2, i16);
    }

    public static void preloadQzone(AppRuntime appRuntime, String str) {
        preloadQzone(appRuntime, str, null, false);
    }

    public static void prepareForQQPublicAccountPublishPage() {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.QZoneHelper.6
            @Override // java.lang.Runnable
            public void run() {
                AppRuntime waitAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
                if (waitAppRuntime instanceof AppRuntime) {
                    QZoneHelper.preloadQzone(waitAppRuntime, QZoneHelper.QZONE_PRELOAD_FROM_QQ_PUBLIC_ACCOUNT);
                }
            }
        }, 5, null, false);
    }

    public static void publishPictureMoodSilently(String str, ArrayList<String> arrayList, String str2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("param.content", str);
        bundle.putStringArrayList(RemoteHandleConst.PARAM_IMAGES, arrayList);
        bundle.putString("param.source", str2);
        bundle.putInt(RemoteHandleConst.PARAM_SUBTYPE, i3);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData(RemoteHandleConst.CMD_PUBLISH_MOOD, bundle, false);
    }

    public static void putTimeRecord(Intent intent) {
        intent.putExtra(QZoneAlbumConstants.KEY_TIME_RECORD, System.currentTimeMillis());
    }

    public static void reportIfIsFromQZone(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("mobile.qzone.qq.com")) {
            QZoneLoginReportHelper.reportLoginFromMQQSearchH5();
        }
    }

    public static void resumeQZoneFloatObjectView(Context context, Object obj) {
        if (context != null && obj != null) {
            try {
                Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView").getMethod("start", new Class[0]).invoke(obj, new Object[0]);
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    public static void saveQzonePermission(boolean z16, long j3) {
        LocalMultiProcConfig.putInt4Uin(KEY_IS_QZONE_PUBLIC, z16 ? 1 : 0, j3);
    }

    public static void saveSelectedAlbumInfo(String str, String str2, String str3, String str4) {
        String d16 = g.d(str + "_" + str2 + "_album_id");
        String d17 = g.d(str + "_" + str2 + "_album_title");
        LocalMultiProcConfig.putString(d16, str3);
        LocalMultiProcConfig.putString(d17, str4);
    }

    public static void sendBroadcastQunMsgUnreadCount(Context context, int i3) {
        Intent intent = new Intent(BROADCAST_SYNC_QUN_UNREAD_MESSAGE);
        Bundle bundle = new Bundle();
        bundle.putInt(ACTION_UNREAD_COUNT, i3);
        intent.putExtras(bundle);
        context.sendBroadcast(intent);
    }

    public static void setUserInfoToIntent(Intent intent, UserInfo userInfo) {
        intent.putExtra("qzone_uin", userInfo.qzone_uin);
        intent.putExtra("nickname", userInfo.nickname);
    }

    public static boolean showAioQCircleFeeds() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", QzoneConfig.SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_AIO_FEED, 1) == 1) {
            return true;
        }
        return false;
    }

    public static void showQzoneVipOriginalVideoDialog(Activity activity, DialogInterface.OnClickListener onClickListener) {
        DialogUtil.createCustomDialog(activity, 230).setMessage(R.string.gow).setPositiveButton(R.string.gd5, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.QZoneHelper.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }).setNegativeButton(R.string.hkb, onClickListener).show();
    }

    public static void showQzoneVipOriginalVideoDialogForUpload(Activity activity, DialogInterface.OnClickListener onClickListener) {
        DialogUtil.createCustomDialog(activity, 230).setMessage(R.string.vq8).setPositiveButton(R.string.hkb, onClickListener).setNegativeButton(R.string.gd5, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.QZoneHelper.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    public static void startTranslucentBrowserActivityForResult(Context context, String str, int i3, Bundle bundle, String str2) {
        startTranslucentBrowserActivityForResult(context, str, i3, bundle, str2, true, true);
    }

    public static void stopQZoneFloatObjectView(Context context, Object obj) {
        if (context != null && obj != null) {
            try {
                Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView").getMethod("stop", new Class[0]).invoke(obj, new Object[0]);
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    public static void stopQzonePublishQueueService(Context context) {
        if (context == null) {
            return;
        }
        context.stopService(getPublishQueueServiceIntent(context));
    }

    public static void tryDelMediaStore(String str) {
        try {
            py3.b.e(BaseApplication.getContext().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{str});
        } catch (Exception unused) {
        }
    }

    public static void updateAlbumShortCut(@NonNull final AppRuntime appRuntime, final String str, final String str2, final Bitmap bitmap, final long j3) {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.QZoneHelper.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Build.VERSION.SDK_INT < 26) {
                        QZoneHelper.updateShortcut(QZoneHelper.getShortcutIntent(AppRuntime.this, str, j3), AppRuntime.this, str, str2, bitmap);
                    } else {
                        QZoneHelper.updateShortcut_O(bitmap, AppRuntime.this, str, j3, str2);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e(QZoneHelper.TAG, 2, "updateAlbumShortCut error! exception e = " + e16.getMessage());
                }
            }
        }, 2, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateShortcut(Intent intent, @NonNull AppRuntime appRuntime, String str, String str2, Bitmap bitmap) throws InterruptedException {
        if (!ec.k(appRuntime.getApp(), new String[]{str})) {
            return;
        }
        deleteShortcut(intent, appRuntime, str2, bitmap);
        LockMethodProxy.sleep(1000L);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).createShortcut(appRuntime, intent, str2, bitmap);
        LockMethodProxy.sleep(1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static void updateShortcut_O(Bitmap bitmap, @NonNull AppRuntime appRuntime, String str, long j3, String str2) {
        BaseApplication app = appRuntime.getApp();
        ShortcutManager shortcutManager = (ShortcutManager) app.getSystemService(ShortcutManager.class);
        if (isShortcutCreated_O(str, shortcutManager)) {
            shortcutManager.updateShortcuts(Arrays.asList(getAlbumShortcutInfo(app, bitmap, str, j3, str2, "update")));
        }
    }

    public static final void addSource(ActivityURIRequest activityURIRequest) {
        if (activityURIRequest != null) {
            activityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_qzone");
        }
    }

    public static void forwardToFriendFeed(Activity activity, String str, Intent intent, String str2, int i3) {
        QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 4, "forwardToFriendFeed click");
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 1);
        if (str2 != null) {
            intent.putExtra("key_push_trans_channel", str2);
        }
        if (forwardToQZoneFriendFeedActivity(activity, intent, true)) {
            return;
        }
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, str, intent, i3);
    }

    public static void forwardToPublishMood(Activity activity, UserInfo userInfo, String str, String str2, String str3, String str4, Bundle bundle, int i3) {
        Intent intent = new Intent(Constants.INTENT_ACTION_PUBLISH_QR_CODE);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 5);
        intent.putExtra(Constants.KEY_FILE_PATH, str);
        intent.putExtra("key_title", str2);
        intent.putExtra("key_desc", str3);
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra("adId", str4);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToPublishQueue(Context context, UserInfo userInfo, Intent intent, int i3) {
        if (intent == null) {
            intent = new Intent();
        }
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(context, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToQzoneTransluentActivity(Context context, UserInfo userInfo, Intent intent) {
        forwardToQzoneTransluentActivity(context, userInfo, intent, -1);
    }

    public static void forwardToQzoneVideoCaptureNew(AppRuntime appRuntime, Activity activity, UserInfo userInfo, int i3, boolean z16, boolean z17, String str, String str2, boolean z18, boolean z19, String str3, boolean z26, String str4, String str5, boolean z27, boolean z28, boolean z29, boolean z36, String str6, boolean z37, boolean z38, boolean z39, int i16, boolean z46, Bundle bundle) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).forwardToQzoneVideoCaptureNew(appRuntime, activity, userInfo, i3, z16, z17, str, str2, z18, z19, str3, z26, str4, str5, z27, z28, z29, z36, str6, z37, z38, z39, i16, z46, bundle);
    }

    public static void forwardToVideoEditActionPanel(Activity activity, UserInfo userInfo, int i3, String str, String str2, String str3, String str4, int i16, int i17, int i18, int i19, int i26, int i27, String str5, int i28, Bundle bundle, boolean z16, boolean z17, int i29, int i36, boolean z18, Bundle bundle2) {
        Intent feedActionPanel = getFeedActionPanel(activity, str, str2, str3, str4, i26 == 0 ? -1 : i16, 0, null, i3, "", false);
        setUserInfoToIntent(feedActionPanel, userInfo);
        feedActionPanel.putExtra("showaticon", i17);
        feedActionPanel.putExtra("showemotionicon", i18);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.SHOW_XUANQU, i19);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.SHOW_FONT_ICON, 1);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.SHOW_SUPER_FONT, false);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.NEEDTRANSEMOJ, z18 ? 1 : 0);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_SENDBTN_TEXT, str5);
        feedActionPanel.putExtra("inputmax", i28);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_PRIV_DATA, bundle);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_VIDEO_EDIT_MODE, true);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC, z16);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC_SYNC_QZONE, z17);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, i29);
        feedActionPanel.putExtra(QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, i36);
        if (bundle2 != null) {
            feedActionPanel.putExtras(bundle2);
        }
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(feedActionPanel, QZONE_FEEDACTIONPANELACTIVITY);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, feedActionPanel, i3, null, true);
    }

    public static void forwardToWriteMood(Activity activity, String str, String str2, ArrayList<String> arrayList, ArrayList<ResultRecord> arrayList2, PublishEventTag publishEventTag, int i3, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("qzone_uin", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("summary", str2);
        }
        ArrayList<String> arrayList3 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    arrayList3.add(next);
                }
                if (arrayList3.size() >= 9) {
                    break;
                }
            }
        }
        if (arrayList3.size() > 0) {
            intent.putStringArrayListExtra("images", arrayList3);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            intent.putParcelableArrayListExtra(QZoneShareManager.QZONE_SHARE_AT_FRIEND, arrayList2);
        }
        if (publishEventTag != null) {
            intent.putExtra(QZoneShareManager.QZONE_SHARE_EVENT_TAG, publishEventTag);
        }
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, str, intent, i3);
    }

    public static boolean isQZonePage(Context context) {
        return ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).isQZonePage(context);
    }

    public static void preloadQzone(AppRuntime appRuntime, String str, b bVar, boolean z16) {
        preloadQzone(appRuntime, str, bVar, z16, false);
    }

    public static void startTranslucentBrowserActivityForResult(Context context, String str, int i3, Bundle bundle, String str2, boolean z16, boolean z17) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).startTranslucentBrowserActivityForResult(context, str, i3, bundle, str2, z16, z17);
    }

    public static final void addSource(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("big_brother_source_key", "biz_src_jc_qzone");
        }
    }

    public static void forwardToQzoneTransluentActivity(Activity activity, UserInfo userInfo, Intent intent, int i3, boolean z16) {
        setUserInfoToIntent(intent, userInfo);
        if (i3 >= 0) {
            intent.putExtra(bNEEDCALLBACK, true);
        } else {
            intent.putExtra(bNEEDCALLBACK, false);
        }
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QZONE_TRANSLUCENT_ACTIVITY);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3, null, z16);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:10|(1:12)(2:61|(1:63)(12:64|(1:66)|14|15|(2:19|(2:27|28)(1:26))|29|30|31|(1:33)(1:56)|34|35|(2:37|38)(3:39|40|(2:42|43)(2:44|(2:50|51)(2:48|49)))))|13|14|15|(5:17|19|(0)|27|28)|29|30|31|(0)(0)|34|35|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x018e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x018f, code lost:
    
        com.tencent.qphone.base.util.QLog.e(cooperation.qzone.util.TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone intent error: " + r0);
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0122, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0123, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014f A[Catch: Exception -> 0x018e, TryCatch #0 {Exception -> 0x018e, blocks: (B:31:0x0143, B:33:0x014f, B:34:0x015c, B:56:0x0156), top: B:30:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0156 A[Catch: Exception -> 0x018e, TryCatch #0 {Exception -> 0x018e, blocks: (B:31:0x0143, B:33:0x014f, B:34:0x015c, B:56:0x0156), top: B:30:0x0143 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void preloadQzone(AppRuntime appRuntime, String str, b bVar, boolean z16, boolean z17) {
        String str2;
        String str3;
        SharedPreferences sharedPreferences;
        long j3;
        ((IQzoneReq) QRoute.api(IQzoneReq.class)).sendPublicAccountPushReq();
        if (appRuntime != null && !checkQzoneEntranceProtectEnable()) {
            if (!com.tencent.mobileqq.perf.process.foregroud.b.f257916a.c(str, "com.tencent.mobileqq:qzone")) {
                QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone disabled: checkPreloadProcess false");
                return;
            }
            if (QZONE_PRELOAD_FROM_LEBA_REDDOT.equals(str)) {
                str2 = QZONE_PRELOAD_FROM_FRIEND_PROFILE;
                ReportController.o(appRuntime, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
                t.a().f("actQZLoadHitRateRed", true);
            } else {
                str2 = QZONE_PRELOAD_FROM_FRIEND_PROFILE;
                if (QZONE_PRELOAD_FROM_LEBA_CLICK.equals(str)) {
                    ReportController.o(appRuntime, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
                    t.a().f("actQZLoadHitRateLeba", true);
                } else {
                    str3 = str2;
                    if (str3.equals(str)) {
                        t.a().f("actQZLoadHitRateProfile", true);
                    }
                    sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("CrashControl_com.tencent.mobileqq:qzone", 4);
                    if (sharedPreferences != null && !sharedPreferences.getBoolean("allowpreload", true)) {
                        j3 = sharedPreferences.getLong(AEEditorConstants.VIDEO_CLIP_START_TIME, 0L);
                        int i3 = sharedPreferences.getInt("controlwindow", 86400);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (j3 <= 0 && i3 > 0 && currentTimeMillis > j3 && currentTimeMillis - j3 > i3 * 1000) {
                            sharedPreferences.edit().putBoolean("allowpreload", true).commit();
                        } else {
                            QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone is not allowed as crash frequently.");
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(appRuntime.getCurrentAccountUin(), "actNoPreloadQzone", true, 0L, 0L, null, "");
                            return;
                        }
                    }
                    QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone from: " + str);
                    Intent qzoneBootServiceIntent = getQzoneBootServiceIntent(BaseApplication.getContext());
                    qzoneBootServiceIntent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
                    if (!str3.equals(str)) {
                        qzoneBootServiceIntent.setAction(ACTION_PRELOAD_USER_HOME);
                    } else {
                        qzoneBootServiceIntent.setAction(ACTION_PRELOAD_FRIEND_FEEDS);
                    }
                    qzoneBootServiceIntent.putExtra("cpuNum", ah.n());
                    qzoneBootServiceIntent.putExtra(KEY_CAN_SET_LAYOUT_INFLATER_FACTORY, enableLayoutInflaterFactory());
                    qzoneBootServiceIntent.putExtra(KEY_IS_KEEP_ALIVE, z16);
                    QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone start: " + str);
                    if (!a.f443735d) {
                        QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone error: sDisablePreloadProcess");
                        a.f443744m = System.currentTimeMillis();
                        return;
                    }
                    try {
                        if (disablePreloadQZoneProcess(z17, qzoneBootServiceIntent.getAction())) {
                            ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).preloadQzoneResource(qzoneBootServiceIntent);
                            QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "feedx, just preloadQzoneResourse");
                            QLog.e(TAG, 1, "preloadQzone, isAllowInit is true");
                            return;
                        } else if (appRuntime.getApp() != null && com.tencent.mobileqq.cooperation.a.e(appRuntime.getApp(), appRuntime.getApp().getPackageName())) {
                            appRuntime.getApp().startService(qzoneBootServiceIntent);
                            return;
                        } else {
                            QLog.e(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone error: app is in background");
                            return;
                        }
                    } catch (Exception e16) {
                        QLog.e(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "can not start qzone service in background", e16);
                        return;
                    }
                }
            }
            str3 = str2;
            sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("CrashControl_com.tencent.mobileqq:qzone", 4);
            if (sharedPreferences != null) {
                j3 = sharedPreferences.getLong(AEEditorConstants.VIDEO_CLIP_START_TIME, 0L);
                int i36 = sharedPreferences.getInt("controlwindow", 86400);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (j3 <= 0) {
                }
                QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone is not allowed as crash frequently.");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(appRuntime.getCurrentAccountUin(), "actNoPreloadQzone", true, 0L, 0L, null, "");
                return;
            }
            QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone from: " + str);
            Intent qzoneBootServiceIntent2 = getQzoneBootServiceIntent(BaseApplication.getContext());
            qzoneBootServiceIntent2.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
            if (!str3.equals(str)) {
            }
            qzoneBootServiceIntent2.putExtra("cpuNum", ah.n());
            qzoneBootServiceIntent2.putExtra(KEY_CAN_SET_LAYOUT_INFLATER_FACTORY, enableLayoutInflaterFactory());
            qzoneBootServiceIntent2.putExtra(KEY_IS_KEEP_ALIVE, z16);
            QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone start: " + str);
            if (!a.f443735d) {
            }
        } else {
            QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone disabled: qzoneEntranceProtectEnable");
        }
    }

    public static void forwardToUserHome(Context context, UserInfo userInfo, String str, int i3, int i16, int i17) {
        forwardToUserHome(context, userInfo, str, i3, i16, i17, null, null, false);
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        return file.delete();
    }

    public static void forwardToFriendFeed(Activity activity, UserInfo userInfo, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener) {
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3, onDismissListener, true);
    }

    public static void publishPictureMoodSilently(String str, ArrayList<String> arrayList, int i3, LbsDataV2.PoiInfo poiInfo, String str2, String str3, ArrayList<String> arrayList2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str4, int i16) {
        Bundle bundle = new Bundle();
        bundle.putString("param.content", str);
        bundle.putStringArrayList(RemoteHandleConst.PARAM_IMAGES, arrayList);
        bundle.putSerializable(RemoteHandleConst.PARAM_EXTEND_INFO, hashMap2);
        if (!TextUtils.isEmpty(str3)) {
            try {
                bundle.putInt("param.priv", Integer.parseInt(str3));
            } catch (Exception e16) {
                QZLog.e(TAG, "publishPictureMoodSilently... exception:", e16);
                bundle.putInt("param.priv", 1);
            }
        }
        bundle.putStringArrayList("param.privList", arrayList2);
        bundle.putParcelable(RemoteHandleConst.PARAM_POI_INFO, poiInfo);
        bundle.putInt(RemoteHandleConst.PARAM_SYNCWEIBO, i3);
        bundle.putSerializable(RemoteHandleConst.PARAM_STOREEXTENDINFO, hashMap);
        bundle.putString("param.source", str4);
        bundle.putInt(RemoteHandleConst.PARAM_SUBTYPE, i16);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData(RemoteHandleConst.CMD_PUBLISH_MIXMOOD, bundle, false);
    }

    public static void forwardToMoodSelectLocation(Context context, String str, int i3, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, MOOD_SELECT_LOCATION);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(context, str, intent, i3);
    }

    public static void forwardToQzoneTransluentActivity(Context context, UserInfo userInfo, Intent intent, int i3) {
        setUserInfoToIntent(intent, userInfo);
        if (i3 >= 0) {
            intent.putExtra(bNEEDCALLBACK, true);
        } else {
            intent.putExtra(bNEEDCALLBACK, false);
        }
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QZONE_TRANSLUCENT_ACTIVITY);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(context, userInfo.qzone_uin, intent, i3);
    }

    @Deprecated
    public static void forwardToDetail(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("mqqflag", 1);
        bundle.putString("cell_operation.qq_url", str);
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchDetailPage(activity, bundle);
    }

    public static void forwardToGroupAlbum(Activity activity, UserInfo userInfo, String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Long> arrayList3, int i3, String str3, String str4) {
        Intent intent = new Intent(Constants.INTENT_ACTION_RESHIP_FROM_QUN_AIO_TO_QUN);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, UPLOAD_PHOTO);
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 6);
        intent.putExtra(Constants.KEY_QUN_ID, str);
        intent.putExtra(Constants.KEY_QUN_CODE, str2);
        intent.putExtra(Constants.KEY_THUMB_FILE_PATHS, arrayList);
        intent.putExtra(Constants.KEY_BIG_PHOTO_UUIDS, arrayList2);
        intent.putExtra(Constants.KEY_MSG_TIMES, arrayList3);
        intent.setFlags(402653184);
        intent.putExtra("refer", "mqqChat");
        if (str3 != null) {
            intent.putExtra("UploadPhoto.key_album_id", str3);
        }
        if (str4 != null) {
            intent.putExtra("UploadPhoto.key_album_name", str4);
        }
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToPublishMood(Activity activity, UserInfo userInfo, Intent intent, int i3) {
        Intent intent2 = new Intent(intent);
        setUserInfoToIntent(intent2, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent2, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent2, i3);
    }

    public static void forwardToDetail(Context context, String str, String str2, String str3, String str4, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Exception e16) {
                QLog.w(TAG, 2, "forwardToDetail error", e16);
                return;
            }
        }
        long parseLong = Long.parseLong(str);
        int parseInt = Integer.parseInt(str2);
        bundle.putLong("targetuin", parseLong);
        bundle.putInt("appid", parseInt);
        bundle.putString("subid", str4);
        bundle.putString(s4.c.CELLID, str3);
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchDetailPage(context, bundle);
    }

    public static void forwardToPublishMood(Activity activity, Bundle bundle, UserInfo userInfo, String str, String str2, String str3, int i3) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 5);
        intent.putExtra(Constants.KEY_FILE_PATH, str);
        intent.putExtra("key_title", str2);
        intent.putExtra("key_desc", str3);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void forwardToQzoneAlbum(Activity activity, UserInfo userInfo, boolean z16, String str, String str2, int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Long> arrayList3, ArrayList<Long> arrayList4, int i16) {
        Intent intent = new Intent(Constants.INTENT_ACTION_FORWARD_PHOTO_FROM_AIO_TO_QZONE);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, UPLOAD_PHOTO);
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 6);
        if (z16) {
            intent.putExtra(Constants.KEY_QUN_ID, str);
            intent.putExtra(Constants.KEY_QUN_CODE, str2);
            intent.putExtra(Constants.KEY_BIG_PHOTO_FILEIDS, arrayList4);
        }
        intent.putExtra(Constants.KEY_QUOTE_SRC_TYPE, i3);
        intent.putExtra(Constants.KEY_THUMB_FILE_PATHS, arrayList);
        intent.putExtra("images", arrayList);
        intent.putExtra(Constants.KEY_BIG_PHOTO_UUIDS, arrayList2);
        intent.putExtra(Constants.KEY_MSG_TIMES, arrayList3);
        intent.putExtra("refer", "mqqChat");
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i16);
    }

    public static void forwardToWriteMood(Activity activity, AppRuntime appRuntime, Intent intent, int i3, boolean z16) {
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).forwardToWriteMood(activity, appRuntime, intent, i3, z16);
    }

    public static void publishPictureMoodSilently(String str, ArrayList<String> arrayList, String str2) {
        if (ShortVideoConstants.SOURCE_FROM_QUICK_SHOOT.equals(str2)) {
            str2 = "value.sourceFromQqQuickShoot";
        } else if (ShortVideoConstants.FORWARD_SOURCE_TO_QZONE.equals(str2)) {
            str2 = RemoteHandleConst.VALUE_SOURCE_FROM_PERSONAL_SIGN;
        }
        publishPictureMoodSilently(str, arrayList, str2, 2);
    }

    public static void publishPictureMoodSilently(String str, ArrayList<String> arrayList, int i3, ArrayList<String> arrayList2, int i16, int i17, String str2, boolean z16, boolean z17, int i18, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("param.content", str);
        bundle.putStringArrayList(RemoteHandleConst.PARAM_IMAGES, arrayList);
        bundle.putInt("param.priv", i3);
        bundle.putStringArrayList("param.privList", arrayList2);
        bundle.putInt(QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, i16);
        bundle.putInt(QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, i17);
        bundle.putString(QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, str2);
        bundle.putInt(QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, i18);
        bundle.putString(QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO, str3);
        bundle.putBoolean(QzoneFeedActionPanelConstants.EXTRA_KEY_SET_TIMER_DELETE, z16);
        bundle.putBoolean(RemoteHandleConst.PARAM_IS_SYNC_VIDEO_TO_QQSTORY, z17);
        ((IQZoneHelperProxy) QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData(RemoteHandleConst.CMD_PUBLISH_MOOD_FOR_ALL, bundle, false);
    }

    public static void forwardToPublishMood(Activity activity, UserInfo userInfo, String str, int i3) {
        Intent intent = new Intent(Constants.INTENT_ACTION_QZONE_OPEN_SHARE);
        setUserInfoToIntent(intent, userInfo);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 5);
        intent.putExtra(Constants.KEY_FILE_PATH, str);
        intent.putExtra("key_title", HardCodeUtil.qqStr(R.string.rx9));
        intent.putExtra("key_desc", "");
        intent.putExtra("key_need_save_draft", false);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, userInfo.qzone_uin, intent, i3);
    }

    public static void openWebSecurityVerify(Intent intent) {
    }

    public static void preloadQzone(BaseApplication baseApplication, String str, String str2) {
        if (baseApplication == null || checkQzoneEntranceProtectEnable()) {
            return;
        }
        QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadQzone from: " + str2);
        Intent qzoneBootServiceIntent = getQzoneBootServiceIntent(BaseApplication.getContext());
        try {
            qzoneBootServiceIntent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
            if (QZONE_PRELOAD_FROM_ALBUM_SELECT.equals(str2)) {
                qzoneBootServiceIntent.setAction(ACTION_PRELOAD_NOTHING);
            } else if (QZONE_PRELOAD_FROM_FRIEND_PROFILE.equals(str2)) {
                qzoneBootServiceIntent.setAction(ACTION_PRELOAD_USER_HOME);
            } else {
                qzoneBootServiceIntent.setAction(ACTION_PRELOAD_FRIEND_FEEDS);
            }
            qzoneBootServiceIntent.putExtra("cpuNum", ah.n());
            qzoneBootServiceIntent.putExtra(KEY_CAN_SET_LAYOUT_INFLATER_FACTORY, enableLayoutInflaterFactory());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (a.f443735d) {
            if (QLog.isColorLevel()) {
                QLog.d("Perf", 2, "disable preload qzone process");
            }
            a.f443744m = System.currentTimeMillis();
        } else if (baseApplication != null) {
            baseApplication.startService(qzoneBootServiceIntent);
        }
    }
}
