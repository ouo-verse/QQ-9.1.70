package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.du;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.smtt.sdk.TbsConfig;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StatisticCollector {
    static IPatchRedirector $redirector_ = null;
    public static final String ADD_FRIEND_SOURCE = "addFriendSource";
    public static final String AE_CAMERA_ARK_VIDEO_UPLOAD_STATISTIC_TAG = "ae_camera_ark_video_upload_statistic_tag";
    public static final String AIO_EMOTICON_MONITOR = "AIOEmoticonMonitor";
    public static final String ALBUM_QUERY_MEDIA = "album_query_media";
    public static final String ALL_C2C_PTT_UPLOAD_STATISTIC_TAG = "actAllC2CPttUp";
    private static final String APP_STATISTIC_TAG = "AndroidQQUseApp";
    public static final String AVIF_PIC_DOWNLOAD_STATISTIC_TAG = "actAvifPicDownload";
    public static final String AVIF_REQ_SUPPORT_STATISTIC_TAG = "actAvifReqSupport";
    public static final String BASE_DYNAMIC_AVATAR_UPLOAD_STATISTIC_TAG = "actBaseDynamicAvatarUpload";
    public static final String BDH_SWITCH_CHNL = "actSwitchChnl";
    public static final String BUSINESS_CARD_PIC_UPLOAD_STATISTIC_TAG = "actBusinessCardPicUpload";
    public static final String C2B_UPLOAD_FILE_TAG = "C2BUploadFile";
    public static final String C2C_PICDOWN_STATISTIC_TAG = "actC2CPicDownloadV1";
    public static final String C2C_PICUP_STATISTIC_TAG = "actC2CPicUploadV1";
    public static final String C2C_PICUP_STATISTIC_TAG_V2 = "actC2CPicUploadV2";
    public static final String C2C_PTT_UPLOAD_STATISTIC_TAG = "actC2CPttUpload";
    public static final String C2C_PUSHTALK_PTT_DOWNLOAD_STATISTIC_TAG = "actC2CPttDownload";
    public static final String C2C_SHORTVIDEO_DOWNLOAD_THUMB = "actShortVideoDownloadThumb";
    public static final String C2C_SHORTVIDEO_DOWNLOAD_VIDEO = "actShortVideoDownloadVideo";
    public static final String C2C_SHORTVIDEO_UPLOAD = "actShortVideoUpload";
    public static final String C2C_SHORTVIDEO_UPLOAD_BDH = "actShortVideoUploadBDH";
    public static final String C2C_SMAILLPICDOWN_STATISTIC_TAG = "actC2CPicSmallDownV1";
    public static final String C2C_STREAM_PTT_DOWN_STATISTIC_TAG = "actC2CStreamPttDownload";
    public static final String C2C_STREAM_PTT_UP_STATISTIC_TAG = "actC2CStreamPttUpload";
    public static final String C2C_TXT_STATISTIC_TAG = "actSendC2CProcess";
    public static final String CALL_PITU_CAMERA = "call_pitu_camera";
    public static final String CALL_QZONE_FRIENDFEED = "callqzonefromfriendfeed";
    public static final String CALL_QZONE_PUSH = "callqzonefrompushv2";
    public static final String CALL_REQUEST_FOCUS = "sv_call_request_focus";
    public static final String CALL_WEISHI_FROM_QZONE = "callweishifromfriendfeed";
    public static final String CAMERA2_SUPPORT_LEVEL = "acCamera2Support";
    public static final String CAMERA_START_TIME_COST = "cameraStartTimeCost";
    public static final String CAPTURE_CUSTOM_HUMMING_DISTANCE = "sv_capture_custom_humming_distance";
    public static final String CAPTURE_CUSTOM_MISMATCH = "sv_capture_custom_mismatch";
    public static final String CAPTURE_PHOTO_SEND = "sv_capture_photo_send";
    public static final String CMSHOW_3D_FACE_UPLOAD = "cmshow3DFace";
    public static final String CUSTOM_PHOTO_SEND = "sv_custom_photo_send";
    private static final String DAILY_USE_TAG = "mqq_dailyUse";
    public static final String DANMAKU_REQUEST_MONITOR = "DanmakuRequestMonitor";
    private static final long DAY = 86400000;
    public static final String DBFIX_DEVICE_INFO_REPORT = "dbfixDeviceInfoReport";
    public static final String DBFIX_INTEGRITY_CHECK_INFO_REPORT = "dbfixIntegrityCheckInfoReport";
    public static final String DB_OP_RESULT = "DatabaseOperatorResult_";
    public static final String DEFAULT_OBSERVER_COST = "actDefaultObserverCost";
    private static final String DEFAULT_SAMPLE = "250|5|5|1|50|5|5|25|25|25|5|10|10";
    private static final String DEVICE_STATISTIC_TAG = "End_Info";
    public static final String DG_PKSHARE_PIC_HIT = "DGPKSharePicHit";
    public static final String DISCUSSION_PIC_DOWNLOAD_STATISTIC_TAG = "actDiscussPicDown";
    public static final String DISCUSSION_PIC_UPLOAD_STATISTIC_TAG = "actDiscussPicUpload";
    public static final String DISCUSSION_PIC_UPLOAD_STATISTIC_TAG_V2 = "actDiscussPicUploadV2";
    public static final String DISCUSSION_PTT_DOWNLOAD_STATISTIC_TAG = "actDisscusPttDown";
    public static final String DISCUSSION_PTT_UPLOAD_STATISTIC_TAG = "actDisscusPttUp";
    public static final String DISCUSSION_SMALLPIC_DOWNLOAD_STATISTIC_TAG = "actDiscussPicSmallDown";
    public static final String DISCUSSION_TXT_STATISTIC_TAG = "actSendDiscussProcess";
    public static final String DYNAMIC_ADJUSTMENT_ON_DESTROY = "dynamic_adjustment_on_destroy";
    public static final String DYNAMIC_ADJUSTMENT_ON_TRIGGERING = "dynamic_adjustment_on_triggering";
    public static final String EMOTICON_OPERATE_MONITOR = "EmoticonOperateMonitor";
    public static final String EMOTION_SOUND_DOWNLOAD = "NewAudioEmoticonVoiceDownload";
    public static final String EMOTION_SOUND_PLAY = "NewAudioEmoticonVoicePlay";
    public static final String EMO_SEARCH_CATCH_USE_MONITOR = "emo_search_catch_use_monitor";
    public static final String EMO_SEARCH_MONITOR = "emo_search_monitor";
    public static final String ENTER_SHORTVIDEO = "sv_enter_shortvideo";
    public static final String ENTER_SYSTEM_CAMERA = "sv_enter_system_camera";
    public static final String EVENT_CAMERA_NUM_LESS_TWO = "event_camera_num_less_two";
    public static final String EVENT_NULL_EVENT_NAME_MONITOR = "nullEventNameMonitor";
    public static final String EXTEND_FRIEND_SOUND_UPLOAD_TAG = "actExtendFriendSoundUpload";
    public static final String FACEREGISTER_PIC_MSG_UPLOAD_STATISTIC_TAG = "facePicUploadProcess";
    private static final String FBG_STATISTIC_TAG = "AndroidQQRunTime";
    public static final String FORWARD_VIDEO_BROKEN = "actForwardVideoBroken";
    public static final String FRESH_NEWS_PIC_UPLOAD_STATISTIC_TAG = "actFreshNewsPicUpload";
    public static final String FRIENDLIST_FAILED_DETAIL = "QQFriendListReqFailedStatistics";
    public static final String FRIENDLIST_RESULT = "QQFriendListReqGetEvent";
    public static final String FRIEND_AVATAR_UPLOAD_STATISTICS_TAG = "actFriendAvatarUpload";
    public static final String FRIEND_SQLITE_OPERATE = "actFriendSqliteOpt";
    public static final String GAMECENTER_STRATEGY_UPLOAD_STATISTIC_TAG = "gamecenterStrategyUpload";
    public static final String GROUP_SHORTVIDEO_DOWNLOAD_THUMB = "actShortVideoDiscussgroupDownloadThumb";
    public static final String GROUP_SHORTVIDEO_DOWNLOAD_VIDEO = "actShortVideoDiscussgroupDownloadVideo";
    public static final String GROUP_SHORTVIDEO_REDIRECT = "actShortVideoRedirect";
    public static final String GROUP_SHORTVIDEO_UPLOAD = "actShortVideoDiscussgroupUpload";
    public static final String GROUP_SHORTVIDEO_UPLOAD_BDH = "actShortVideoDiscussgroupUploadBDH";
    public static final String H5_UPLOAD_PIC_HIT = "h5UploadPicHit";
    public static boolean HASMODIFY = false;
    public static final String HONG_BAO_STAR_PHOTO_UPLOAD_STATISTIC_TAG = "actHongbaoStarPhotoUpload";
    public static final String HTTPS_DOWNLOAD_FAILED = "actHttpsDownloadFail";
    public static final String HTTPS_SNI_SUPPORT = "actHttpsSniSupport";
    public static final String ICON_CLICK_LAUNCH_TO_UNREAD_REFRESH = "launchFromIconClickToUnreadRefresh";
    public static final String ILLEGAL_GRAYTIP_ID = "illegalGraytipId";
    public static final String IMG_PROVIDERSERVICE_GET_TOPACTIVITY = "ImageProviderService_getTopActivity_event";
    public static final long INIT_DELAY_TIME = 3000;
    public static final String INNER_DNS_BAD_IP = "actDnsBadIp";
    public static final String INNER_DNS_REQ = "actDnsReq";
    public static final String KANDIAN_UGC_PIC_UPLOAD_TAG = "KandianUGCPicUpload";
    public static final String KANDIAN_UGC_VIDEO_UPLOAD_TAG = "KandianUGCVideoUpload";
    public static final String KEY_STACK = "stack";
    public static final String KEY_TRIGGER_TIME = "trigger_time";
    public static final String KEY_VERSION_PATCHLIB_LOAD = "version_patchlib_load";
    public static final String LTEXT_AUTO_PULL_RESULT = "ltextAutoPullResult";
    public static final String LTEXT_EMPTY_RESID = "ltextEmptyResid";
    public static final String LTEXT_MANUAL_PULL_RESULT = "ltextManualPullResult";
    public static final String LTEXT_NEW_RECEIVE_RESULT = "ltextNewReceiveResult";
    public static final String LTEXT_NEW_SEND_RESULT = "ltextNewSendResult";
    public static final String LTEXT_OLD_RECEIVE_RESULT = "ltextOldReceiveResult";
    public static final String LTEXT_OLD_SEND_RESULT = "ltextOldSendResult";
    public static final String MESSAGE_EVENT = "actMessageEvent";
    public static final String MINI_APP_ARK_SHARE_PICTURE_UPLOAD = "miniAppArkShareUploadPicHit";
    public static final String MINI_APP_USER_LOG_UPLOAD = "miniAppUserLog";
    public static final String MIX_MSG_CLIENT_AUTO_PULL_REPORT_TAG = "MixedMsgClientAutoPull";
    public static final String MIX_MSG_CLIENT_MANU_PULL_REPORT_TAG = "MixedMsgClientManualPull";
    public static final String MIX_MSG_FORWARD_REPORT_TAG = "MixedMsgForward";
    public static final String MIX_MSG_RECEIVED_REPORT_TAG = "MixedMsgReceived";
    public static final String MODEL_COMPATIBILITY = "sv_model_compatibility";
    public static final String MSG_CACHE_ERROR_SCENE = "msgCacheErrorScene";
    public static final String MSG_CACHE_STRATEGY_TAG = "msg_cache_strategy_tag";
    public static final String MSG_CACHE_STRATEGY_TAG_DEBUG = "msg_cache_strategy_tag_debug";
    public static final String MSG_CACHE_STRATEGY_TAG_GRAY = "msg_cache_strategy_tag_gray";
    public static final String MSG_NOTIFICATION_STATS_TAG = "msgNotificationStatsTag";
    public static final String MSG_SEND_COST_PER_PHASE = "msgSendCostPerPhase";
    public static final String MULTIMSG_DOWNLOAD_STATISTIC_TAG = "actMultiMsgDownload";
    public static final String MULTIMSG_UPLOAD_STATISTIC_TAG = "actMultiMsgUpload";
    public static final String MULTI_MSG_NICK_TIMEOUT = "multiMsgNickTimeOut";
    public static final String MULTI_MSG_NICK_TIMEOUT_REAL = "multiMsgNickTimeoutR";
    public static final String MULTI_MSG_RECEIVE = "multiMsgReceive";
    public static final String MULTI_MSG_SEND = "multiMsgSend";
    public static final String NEARBY_DYNAMIC_AVATAR_UPLOAD_STATISTIC_TAG = "actNearbyDynamicAvatarUpload";
    public static final String NEARBY_PEOPLE_PIC_DOWNLOAD_STATISTIC_TAG = "actNearbyPeoplePicDownload";
    public static final String NEARBY_PEOPLE_PIC_UPLOAD_STATISTIC_TAG = "actNearbyPeoplePicUpload";
    public static final String NEARBY_PIC_BROWSER_STATISTIC_TAG = "actNearbyPicBrowser";
    public static boolean NEEDCOUNTTRANS = false;
    public static final String NETCHANGE_NOTIFY_WAIT_QUEUE = "netchangeNotifyWaitQueue";
    public static final String ON_AUTO_FOCUS = "sv_on_auto_focus";
    public static final String PAJASDK_PIC_MSG_UPLOAD_STATISTIC_TAG = "PAJSSDKPicUploadProcess";
    public static final String PA_IIMAGE_COLLECTION_IMAGE_HIT = "eventPAAlbumCacheHitStatics";
    public static final String PA_IIMAGE_COLLECTION_IMAGE_TIME = "eventPAAlbumPreDownPhotoTime";
    public static final String PA_IIMAGE_COLLECTION_PROTO_HIT = "eventPAAlbumRequestAlbumHitStatics";
    public static final String PA_IIMAGE_COLLECTION_PROTO_TIME = "eventPAAlbumRequestAlbumTime";
    public static final String PA_LONGMSG_DOWNLOAD = "actLongMessageDownload";
    public static final String PA_LONGMSG_TIME_DOWNLOAD = "actLongMessageTimeDownload";
    public static final String PA_LONGMSG_TIME_SSO = "actLongMessageTimeSSO";
    public static final String PA_OLD_LONGMSG_DOWNLOAD = "actOldLongMessageDownload";
    public static final String PA_OLD_LONGMSG_TIME_DOWNLOAD = "actOldLongMessageTimeDownload";
    public static final String PA_OLD_LONGMSG_TIME_SSO = "actOldLongMessageTimeSSO";
    public static final String PERSONALITY_LABEL_PHOTO_UPLOAD_STATISTIC_TAG = "actPersonalityLabelPhotoUpload";
    public static final String PHOTO_SEND_FROM_ALBUM = "sv_photo_send_from_album";
    public static final String PHOTO_SEND_FROM_ALBUM_IN_MINUTE = "photo_send_from_album_in_minute";
    public static final String PHOTO_SEND_FROM_SHORTVIDEO = "photo_send_from_shortvideo";
    public static final String PHOTO_SHORT_FROM_SHORTVIDEO = "photo_shot_from_shortvideo";
    public static final String PHOTO_TAKEN_BY_CAPTURE = "sv_photo_taken_by_capture";
    public static final String PHOTO_TAKEN_BY_CUSTOM = "sv_photo_taken_by_custom";
    public static final String PIC_DOWNLOADV2_CARD_PICTURE = "actPicDownloadV2.Card.Picture";
    public static final String PIC_SHARE_TO_WX_UPLOAD = "actPicShareToWXUpload";
    public static final String PIC_UPLOADV2_CARD_PICTRUE = "actPicUploadV2.Card.Picture";
    public static final String PLUGIN_GETUNREAD_TAG = "actPluginUnread";
    public static final String POKE_STRENGTH_NULL_POINT = "pokeStrengthNullPoint";
    public static final String PREDICTION_DATA = "actPredictionData";
    private static final String PREF_STATISTICS_NEXT_REPORT_TIME = "next_reportTime";
    public static final String PROFILE_COVER_PIC_UPLOAD_STATISTIC_TAG = "actProfileCoverPicUpload";
    public static final String PROFILE_INTRO_PTT_DOWNLOAD_TAG = "actIntroPttDownload";
    public static final String PROFILE_INTRO_PTT_UPLOAD_TAG = "actIntroPttUpload";
    public static final String PTT_DOWNLOAD_STREAM_2_OFFLINE_STATISTIC_TAG = "actPttDownloadStream2Offline";
    public static final String PTT_LONG_PRESS_FATE_STATISTIC_TAG = "actPttLongPressFate2";
    public static final String PTT_NO_RANGE_FAILED_TAG = "actPttNoRangeFailed";
    public static final String PTT_PLAY_BLUETOOTH_STATISTIC_TAG = "actPttPlayBluetooth";
    public static final String PTT_PROCESS_FRAME_COST_TAG = "actPttProcessFrameCost";
    public static final String PTT_SHOW_DOWNLOADING_STATISTIC_TAG = "actPttShowDownloading";
    public static final String PTT_SLICE_TO_TEXT = "pttSliceToText";
    public static final String PTT_SO_UPDATE_STATISTIC_TAG = "actPttSoUpdate";
    public static final String PTT_STT_FRIST_SHOW_TIME_COST = "PttSttFristShowTimeCost";
    public static final String PTT_STT_PART_TIME_INTERVAL = "PttShardSttReveivePartTimeInterval";
    public static final String PTT_STT_RESULT_ERROR = "PttSttResultError";
    public static final String PTT_STT_RESULT_MONITOR = "PttSttResultMonitor";
    public static final String PTT_USER_WAITING_STATISTIC_TAG = "actPttUserWaiting";
    public static final String PTV_GUIDE_TAG = "ptvGuideReportTag";
    public static final String PTV_TEACH_GUIDE_TAG = "ptvTeachGuideReportTag";
    public static final String QQCOMIC_PIC_UPLOAD_STATISTIC_TAG = "actQqComicPicUpload";
    public static final String QQLS_REPORT_TAG = "qqlsReprotTag";
    public static final String QQLS_SETTING_REPORT_TAG = "qqlsSettingReprotTag";
    public static final String QQ_FILTER_DOWNLOAD = "acQQFilterDownload";
    public static final String QQ_FILTER_USER_INFO = "acQQFilterDownloadCount";
    public static final String QQ_FILTER_VIEW = "acQQfilterView";
    public static final String QQ_VOICE_SEARCH = "QQVoiceSearch";
    public static final String QTROOP_AVATAR_UPLOAD_STATISTIC_TAG = "actQTroopAvatarUpload";
    public static final String QTROOP_COVER_PHOTO_UPLOAD_STATISTIC_TAG = "actQTroopCoverPhotoUpload";
    public static final String QWALLET_VOICE_HB_REPORT_TAG = "qwalletVoiceHb";
    public static final String QZONE_APP_START_TO_CLICK_ENTRY = "AppStartToClcikEntry";
    public static final String QZONE_AROUSE_THIRDAPP = "qzonearousethirdapp";
    public static final String QZONE_CHOOSE_PHOTO_BACK_TO_MOOD = "qzoneChoosePhotoBackToMood";
    public static final String QZONE_CHOOSE_PHOTO_CAMERA_TAG = "qzoneChoosePhotoCamera";
    public static final String QZONE_CLICK_ENTREY_TO_APP_START = "clickEntryToAppStart";
    public static final String QZONE_CONFIGDB_ERROR = "qzoneconfigdberror";
    public static final String QZONE_CPU_MEMINFO = "updateCpuandMemInfo";
    public static final String QZONE_DB_ENCRYPT_ERROR = "qzonedbencrypt";
    public static final String QZONE_EXTEND_STARTUP_COST_COLD_FIRST = "QzoneExtendStartupCost_Cold_First";
    public static final String QZONE_EXTEND_STARTUP_COST_COLD_NORMAL = "QzoneExtendStartupCost_Cold_Normal";
    public static final String QZONE_EXTEND_STARTUP_COST_WARM_FIRST = "QzoneExtendStartupCost_Warm_First";
    public static final String QZONE_EXTEND_STARTUP_COST_WARM_NORMAL = "QzoneExtendStartupCost_Warm_Normal";
    public static final String QZONE_EXTEND_START_UP_TIME_REPORT_TAG = "qzoneExtendStartUpCost";
    public static final String QZONE_GETUNREAD_TAG = "actQzoneUnread";
    public static final String QZONE_LIVE_DOWNLOADSO_REPORT = "actQZLiveDownloadSoReport";
    public static final String QZONE_MOOD_SCHEDULE_DELETE_VIDEO_TAG = "qzoneMoodScheduleDeleteVideo";
    public static final String QZONE_NETWORKED_MODULE_DOWNLOAD_RES_REPORT_TAG = "qzoneModuleDowndloadRes";
    public static final String QZONE_NETWORKED_MODULE_LOAD_RES_REPORT_TAG = "qzoneModuleLoadRes";
    public static final String QZONE_ODEX_CHECK_ACTION = "qzoneOdexCheck";
    public static final String QZONE_PLUGIN_PATCH = "actQzonePluginPatch";
    public static final String QZONE_PUSH_DATA_REPORT = "actQZPushDataReport";
    public static final String QZONE_PUSH_STATE = "qzonepushstate";
    public static final String QZONE_RECOVERSY_TAG = "qzoneRecovery";
    public static final String QZONE_RESOURCE_PRELOAD_TIME_TAG = "qzoneResourePreload";
    public static final String QZONE_SHARE_TIMECOST = "qzonesharetimecost";
    public static final String QZONE_SMART_REPORT = "qzonesmartreport";
    public static final String QZONE_SOURCE_DATA_REPORT = "actQZSourceDataReport";
    public static final String QZONE_STARTUP_COST_COLD_FIRST = "QzoneStartupCost_Cold_First";
    public static final String QZONE_STARTUP_COST_COLD_NORMAL = "QzoneStartupCost_Cold_Normal";
    public static final String QZONE_STARTUP_COST_WARM_FIRST = "QzoneStartupCost_Warm_First";
    public static final String QZONE_STARTUP_COST_WARM_NORMAL = "QzoneStartupCost_Warm_Normal";
    public static final String QZONE_START_UP_TIME_REPORT_TAG = "qzoneStartUpCost";
    public static final String QZONE_UNREAD_DATA_REPORT = "actQZUnreadDataReport";
    public static final String QZONE_UPLOAD_REPORT_TRY_AGAIN = "qzoneUploadReportTryAgain";
    public static final String QZONE_VIDEO_TAB_BANNER_TAG = "qzoneVideoTabBanner";
    public static final String READINJOY_ARTICLE_OPEN = "actReadInJoyArticleOpen";
    public static final String READINJOY_BIU_COAST_TIME = "actMultiBiuResult";
    public static final String READINJOY_FLING_LTOR = "actReadInJoyFlingLToR";
    public static final String READINJOY_IP_CONNECT = "actReadInJoyIpConnect";
    public static final String READINJOY_RELEASE_WEB_SERVICE = "actReadInJoyReleaseWebService";
    public static final String READINJOY_SHORTEN_URL = "actReadInJoyShortenUrl";
    public static final String READINJOY_TOOL_PRELOAD = "actReadInJoyToolPreload";
    public static final String READINJOY_UGC_PICTURE = "actReadInJoyUGCPicture";
    public static final String READINJOY_UGC_VIDEO = "actReadInJoyUGCVideo";
    public static final String REG_FAIL_CODE = "prxyRegFailCode";
    public static final String REG_LOOKUP_CODER_NULL = "prxyLookupCoderNull";
    public static final String REG_NEED_PULL_GROUP = "prxyRegNeedPullGroup";
    public static final String REG_REGISTER_B = "prxyRegisterB";
    public static final String REG_REGISTER_M = "prxyRegisterM";
    public static final String REG_REGISTER_T = "prxyRegisterT";
    public static final String REPORT_TAG_SP_ABNORMAL = "evSpError";
    public static final String REVOKE_MSG_ERROR_TAG = "revokeMsgErrorTag";
    public static final String RICH_TEXT_ILLEGAL_WORD_DECT_TIME = "RichTextIllegalWordTime";
    public static final String SCENES_REC_EMO_MONITOR = "scenes_rec_emo_monitor";
    public static final String SCRIBBLE_UPLOAD_STATIC_TAG = "scribble_upload";
    public static final String SDK_DOWNLOAD_HIJACKED = "actSDKDownloadHijacked";
    public static final String SDK_PREDOWNLOAD = "actSDKPredownload";
    public static final String SEND_MSG_TOO_LARGE_ERROR_TAG = "sendMsgTooLargeErrorTag";
    public static final String SEND_PHOTO_IDLE_COST = "actSendPhotoIdleCost";
    public static final String SEND_QUALITY_PIC_LIMIT = "sendQualityPicLimit";
    public static final String SET_PHOTO_CLIP_SIZE = "actSetPhotoClipSize";
    public static final String SET_PREVIEW_SIZE_WAY = "actSetPreviewSizeWay";
    public static final String SHOOT_PHOTO_CLIP = "actShootPhotoClip";
    public static final String SHORTVIDEO_FORWARD = "actShortVideoForward";
    public static final String SHORTVIDEO_FORWARD_BDH = "actShortVideoForwardBDH";
    public static final String SHORTVIDEO_PLAY = "actShortVideoPlay";
    public static final String SHORT_VIDEO_PTU_SO_DOWNLOAD = "actShortVideoPtuSoDownload";
    public static final String SHORT_VIDEO_SO_DOWNLOAD = "actShortVideoSoDownload";
    public static final String SNAPCHAT_PIC_UPLOAD_STATISTIC_TAG = "actSnapChatPicUpload";
    public static final String SQLITE_DATABASE_CORRUPT = "actSqliteDatabaseCorrupt";
    public static final String SQLITE_OPERATE_COST = "actSqliteOptCost";
    public static final String SQLITE_OPERATE_DETAIL_COST = "actSqliteOptDetailCost";
    public static final String SQL_COST_TAG = "SQLCost";
    public static final int SQL_SAMPLE_AIO = 1;
    public static final int SQL_SAMPLE_DELETE = 6;
    public static final int SQL_SAMPLE_FRIEND_DELETE = 10;
    public static final int SQL_SAMPLE_FRIEND_INSERT = 8;
    public static final int SQL_SAMPLE_FRIEND_QUERY = 7;
    public static final int SQL_SAMPLE_FRIEND_TRANS = 11;
    public static final int SQL_SAMPLE_FRIEND_UPDATE = 9;
    public static final int SQL_SAMPLE_INSERT = 4;
    public static final int SQL_SAMPLE_MAIN_THREAD = 2;
    public static final int SQL_SAMPLE_TRANS = 0;
    public static final int SQL_SAMPLE_TROOP_QUERY = 12;
    public static final int SQL_SAMPLE_UPDATE = 5;
    public static final int SQL_SAMPLE_WAL_SWITCH = 3;
    public static final int STACK_DEPTH = 5;
    public static final String STATISTIC_KEY_FOR_UPLOAD_PIC = "PicStatisticsManagerUploadPic";
    public static final String STORY_PIC_UPLOAD_STATISTIC_TAG = "actStoryPicUpload";
    public static final String STORY_VIDEO_UPLOAD_STATISTIC_TAG = "actStoryVideoUpload";
    public static final String STREAM_VIDEO_PLAY = "actStreamingVideoPlay";
    public static final String STUDY_ROOM_PIC_UPLOAD_TAG = "studyRoomPicUpload";
    public static final String SUCCESS_RATE_FOR_IMAX_CLICK_EXPORSURE = "imaxClickExporsureSucessRate";
    public static final String SUCCESS_RATE_FOR_IMAX_EXPORSURE = "imaxExporsureSucessRate";
    public static final String SUCCESS_RATE_FOR_POKE_EFFECT = "pokeEffectSucessRate";
    public static final String SYSTEM_PHOTO_SEND = "sv_system_photo_send";
    public static final String TAG = "StatisticCollector";
    public static final String TAG_LAUNCH_TIME = "actLoginT";
    public static final String TAG_MEMORY = "actMemory";
    public static final String TAG_QQ_INIT_TIME = "actQQInit";
    public static final String TAG_QZONE_PRELOAD_FINISHED = "qzonePreloadFinished";
    public static final String TAG_SYNC_MESSAGE_FIRST = "actSyncMsgFirst";
    public static final String TAG_SYNC_MESSAGE_SECOND = "actSyncMsgSecond";
    public static final String TROOP_MEMBER_SEARCH_BUILD_INDEX_COST = "tMSearchBuiltIndexCost";
    public static final String TROOP_MEMBER_SEARCH_UPDATE_REQ = "tMSearchUpdateReq";
    public static final String TROOP_PIC_DOWNLOAD_STATISTIC_TAG = "actGroupPicDownloadV1";
    public static final String TROOP_PIC_UPLOAD_STATISTIC_TAG = "actGroupPicUploadV1";
    public static final String TROOP_PIC_UPLOAD_STATISTIC_TAG_V2 = "actGroupPicUploadV2";
    public static final String TROOP_PTT_DOWNLOAD_STATISTIC_TAG = "actGrpPttDown";
    public static final String TROOP_PTT_UPLOAD_STATISTIC_TAG = "actGrpPttUp";
    public static final String TROOP_SENDGRPTMP_STATISTIC_TAG = "dim.actSendGrpTmpMsg";
    public static final String TROOP_SMAILLPIC_DOWNLOAD_STATISTIC_TAG = "actGroupPicSmallDownV1";
    public static final String TROOP_TXT_STATISTIC_TAG = "actSendGroupProcess";
    public static final String VIDEO_MESSAGE_TIME = "actVideoMessageTime";
    public static final String WECHAT_NS_LOAD_FAIL = "actWechatNsLoadFail";
    public static final String WPA_MSG_UPLOAD_STATISTIC_TAG = "dim.actSendWpaMsg";
    private static boolean bReportingDailyUser = false;
    static Context ctx = null;
    private static final Random random;
    private static volatile StatisticCollector self = null;
    private static final int timezoneMillDelta = 28800000;
    private ProductInfo[] appReports;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface DeviceInfo {
        public static final String APPID_TAG = "param_ProductVersion";
        public static final String AVAILMEMORY_TAG = "param_availmemory";
        public static final String AVAILROM_TAG = "param_availrom";
        public static final String AVAILSD_TAG = "param_availsd";
        public static final String CAMERA_TAG = "param_Camera";
        public static final String CPU_TAG = "param_CPU";
        public static final String IMEI_TAG = "param_IMEI";
        public static final String IMSI_TAG = "param_IMSI";
        public static final String MANUFACTOR_TAG = "param_manu";
        public static final String MODEL_TAG = "param_MODEL";
        public static final String NET_TAG = "param_NetworkType";
        public static final String OSVERSION_TAG = "param_OS";
        public static final String RESOLUTION_TAG = "param_Resolution";
        public static final String ROM_TAG = "param_ROM";
        public static final String TOTALMEMORY_TAG = "param_totalmemory";
        public static final String TOTALROM_TAG = "param_totalrom";
        public static final String TOTALSD_TAG = "param_totalsd";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class EmptyStatisticCollector extends StatisticCollector {
        static IPatchRedirector $redirector_;

        protected EmptyStatisticCollector(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class ProductInfo {
        static IPatchRedirector $redirector_;
        public String packageName;
        public String reportKeyWord;

        ProductInfo(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.packageName = str;
                this.reportKeyWord = str2;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class ReportContext {
        static IPatchRedirector $redirector_;
        public int mainthreadTag;
        public int optcountTag;
        public int optmsgcountTag;
        public long optonecostTag;
        public String optsceneTag;
        public long opttotalcostTag;
        public String opttypeTag;

        public ReportContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mainthreadTag = 0;
            this.opttypeTag = "";
            this.opttotalcostTag = 0L;
            this.optcountTag = 0;
            this.optmsgcountTag = 0;
            this.optonecostTag = 0L;
            this.optsceneTag = "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class ReportTag {
        static IPatchRedirector $redirector_ = null;
        public static final String TAG_FAIL_CODE = "param_FailCode";

        public ReportTag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class SqliteOptCostInfo {
        static IPatchRedirector $redirector_ = null;
        public static final String BUS_TAG = "param_bustag";
        public static final String MAINTHREAD_TAG = "param_IsMainThread";
        public static final String OPTCOUNT_TAG = "param_OptCount";
        public static final String OPTMSGCOUNT_TAG = "param_OptMsgCount";
        public static final String OPTONECOST_TAG = "param_OptOneCost";
        public static final String OPTSCENE_TAG = "param_OptScene";
        public static final String OPTTOTALCOST_TAG = "param_OptTotalCost";
        public static final String OPTTYPE_TAG = "param_OptType";
        public static final String TAG_IN_TRANS = "param_intrans";
        public static final String WALSWITCH_TAG = "param_WalSwitch";

        public SqliteOptCostInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StatisticCollector.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36443);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
            return;
        }
        bReportingDailyUser = false;
        HASMODIFY = false;
        NEEDCOUNTTRANS = false;
        random = new Random();
    }

    StatisticCollector(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Long.valueOf(j3));
            return;
        }
        this.appReports = new ProductInfo[]{new ProductInfo(TbsConfig.APP_QB, "qqBrowser"), new ProductInfo(SDKConst.SELF_PACKAGENAME, "qqMarket"), new ProductInfo("com.tencent.qqgame", "qqGame"), new ProductInfo(QZoneHelper.PACKAGENAME_QQMUSIC, "qqMusic"), new ProductInfo("com.tencent.news", "qqNews"), new ProductInfo("com.qq.reader", "qqReader"), new ProductInfo("com.tencent.qqlive", "qqVideo"), new ProductInfo("com.tencent.wblog", "qqMicroblog"), new ProductInfo("com.tencent.qqphonebook", "qqPhonebook")};
        ctx = context;
        QQBeaconReport.start();
    }

    public static void fillFailCode(Map<String, String> map, int i3) {
        map.put("param_FailCode", String.valueOf(i3));
    }

    private String findKeywordFromPackageName(String str) {
        if (str == null) {
            return null;
        }
        int i3 = 0;
        while (true) {
            ProductInfo[] productInfoArr = this.appReports;
            if (i3 >= productInfoArr.length) {
                return null;
            }
            if (str.toLowerCase().contains(productInfoArr[i3].packageName)) {
                return this.appReports[i3].reportKeyWord;
            }
            i3++;
        }
    }

    private static Map<String, String> getDeviceStatistics() {
        HashMap hashMap = new HashMap(16);
        hashMap.put(DeviceInfo.MODEL_TAG, ah.s());
        hashMap.put(DeviceInfo.MANUFACTOR_TAG, ah.D());
        hashMap.put(DeviceInfo.OSVERSION_TAG, ah.t());
        hashMap.put(DeviceInfo.RESOLUTION_TAG, MsfSdkUtils.getResolutionString(ctx));
        hashMap.put(DeviceInfo.IMEI_TAG, "");
        hashMap.put(DeviceInfo.IMSI_TAG, "");
        hashMap.put(DeviceInfo.NET_TAG, "" + NetworkUtil.getNetworkType(ctx));
        hashMap.put(DeviceInfo.APPID_TAG, "" + AppSetting.f());
        hashMap.put(DeviceInfo.CPU_TAG, ah.o());
        hashMap.put(DeviceInfo.TOTALMEMORY_TAG, MsfSdkUtils.getTotalMemory());
        hashMap.put(DeviceInfo.AVAILMEMORY_TAG, String.valueOf(ah.X() / 1024) + "kB");
        long[] T = ah.T();
        hashMap.put(DeviceInfo.TOTALROM_TAG, String.valueOf(T[0]) + "MB");
        hashMap.put(DeviceInfo.AVAILROM_TAG, String.valueOf(T[1]) + "MB");
        long[] U = ah.U();
        hashMap.put(DeviceInfo.TOTALSD_TAG, String.valueOf(U[0]) + "MB");
        hashMap.put(DeviceInfo.AVAILSD_TAG, String.valueOf(U[1]) + "MB");
        hashMap.put(DeviceInfo.CAMERA_TAG, "" + ah.h());
        return hashMap;
    }

    public static StatisticCollector getInstance(Context context) {
        return getInstance(context, 3000L);
    }

    public static int getQzonePatchTag() {
        aa1.a a16 = com.tencent.mobileqq.bridge.a.a();
        if (a16 == null) {
            return 0;
        }
        return a16.getInt(KEY_VERSION_PATCHLIB_LOAD, 0);
    }

    public static boolean getSqliteSwitchBySample(int i3) {
        if (i3 != 3) {
            return false;
        }
        return ((ICommonFunctionPublishConfigService) QRoute.api(ICommonFunctionPublishConfigService.class)).isWalEnable();
    }

    private boolean isMultimediaEvent(String str) {
        aa1.b d16 = com.tencent.mobileqq.bridge.a.d();
        if (d16 != null && d16.a(str)) {
            return true;
        }
        return false;
    }

    public static void report(String str) {
        getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, 0L, 0L, null, null);
    }

    private void reportNullEventNameError(String str, Throwable th5) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("stack", du.a(th5, 5));
            hashMap.put(KEY_TRIGGER_TIME, String.valueOf(System.currentTimeMillis()));
            QQBeaconReport.report(str, EVENT_NULL_EVENT_NAME_MONITOR, hashMap);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[reportNullEventNameError] throw exception ", e16);
        }
    }

    public static void setQzonePatchTag(int i3) {
        aa1.a a16 = com.tencent.mobileqq.bridge.a.a();
        if (a16 != null) {
            a16.putInt(KEY_VERSION_PATCHLIB_LOAD, i3);
        }
        if (i3 > 0) {
            QLog.i("PatchLibLoader", 1, "setQzonePatchTag" + i3);
        }
    }

    public static boolean sqlite3Optimizereport() {
        AppSetting.f99551k.startsWith("7.1.");
        return false;
    }

    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            collectPerformance("", str, str2, z16, j3, j16, hashMap, str3, false, false);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3);
        }
    }

    @Deprecated
    public void reportActionCount(AppRuntime appRuntime, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appRuntime, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), str4, str5, str6, str7, str8);
            return;
        }
        if (appRuntime == null || str == null || str2 == null || str3 == null) {
            return;
        }
        String str9 = str4 == null ? "0" : str4;
        String str10 = str5 == null ? "" : str5;
        String str11 = str6 == null ? "" : str6;
        String str12 = str7 == null ? "" : str7;
        String str13 = str8 != null ? str8 : "";
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(appRuntime.getAccount());
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str2);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i16);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str9);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str10);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str11);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str12);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str13);
        sb5.append(QbAddrData.DATA_SPLITER);
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
        newIntent.putExtra("sendType", 2);
        newIntent.putExtra("tag", "CliOper");
        newIntent.putExtra("content", sb5.toString());
        appRuntime.startServlet(newIntent);
    }

    @Deprecated
    public void reportActionCountCliOper(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, appRuntime, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (appRuntime == null || str == null || str3 == null || str4 == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(str);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str2);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str4);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i16);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i17);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(QbAddrData.DATA_SPLITER);
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
        newIntent.putExtra("sendType", 2);
        newIntent.putExtra("tag", "CliOper");
        newIntent.putExtra("content", sb5.toString());
        appRuntime.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "tag=CliOper,content=" + sb5.toString());
        }
    }

    @Deprecated
    public void reportActionCountMsgOper(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
        newIntent.putExtra("sendType", 2);
        newIntent.putExtra("tag", "MsgOper");
        newIntent.putExtra("content", str);
        appRuntime.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "tag=MsgOper,content=" + str);
        }
    }

    @Deprecated
    public void reportActionCountPCliOper(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, appRuntime, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (appRuntime != null && str != null && str4 != null && str5 != null) {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append(str3);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append("");
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str4);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str5);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(i3);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(i16);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(i17);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str2);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(QbAddrData.DATA_SPLITER);
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
            newIntent.putExtra("sendType", 2);
            newIntent.putExtra("tag", "P_CliOper");
            newIntent.putExtra("content", sb5.toString());
            appRuntime.startServlet(newIntent);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "tag=P_CliOper,content=" + sb5.toString());
            }
        }
    }

    @Deprecated
    public void reportActionCountRes(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, String str8) {
        String str9;
        String str10;
        String str11;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, appRuntime, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str5, str6, str7, str8);
            return;
        }
        if (appRuntime != null && str != null && str3 != null && str4 != null) {
            String str12 = "";
            if (str5 == null) {
                str9 = "";
            } else {
                str9 = str5;
            }
            if (str6 == null) {
                str10 = "";
            } else {
                str10 = str6;
            }
            if (str7 == null) {
                str11 = "";
            } else {
                str11 = str7;
            }
            if (str8 != null) {
                str12 = str8;
            }
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append(str);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str2);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str3);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str4);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(i3);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(i16);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(i17);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str9);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str10);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str11);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str12);
            sb5.append(QbAddrData.DATA_SPLITER);
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
            newIntent.putExtra("sendType", 2);
            newIntent.putExtra("tag", "CliOper");
            newIntent.putExtra("content", sb5.toString());
            appRuntime.startServlet(newIntent);
        }
    }

    public void reportButtonClick(AppRuntime appRuntime, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, appRuntime, str, str2, Integer.valueOf(i3));
        } else {
            reportToAds(appRuntime, str2, i3);
        }
    }

    @Deprecated
    public void reportCustomSet(AppRuntime appRuntime, String str, Map<String, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, appRuntime, str, map);
            return;
        }
        if (appRuntime != null && str != null && map != null) {
            StringBuilder sb5 = new StringBuilder(128);
            Set<String> keySet = map.keySet();
            ArrayList arrayList = new ArrayList(map.size());
            for (String str2 : keySet) {
                sb5.append(str2);
                sb5.append("|");
                sb5.append(map.get(str2));
                sb5.append("|");
                arrayList.add(sb5.toString());
                sb5.delete(0, sb5.length());
            }
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
            newIntent.putExtra("sendType", 6);
            newIntent.putExtra("tag", "custom_set");
            newIntent.putExtra("content", arrayList);
            appRuntime.startServlet(newIntent);
        }
    }

    public void reportDailyUser(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime);
            return;
        }
        if (!bReportingDailyUser && appRuntime != null && appRuntime.isLogin()) {
            SharedPreferences sharedPreferences = ctx.getSharedPreferences("mobileQQ", 0);
            long j3 = sharedPreferences.getLong("next_reportTime_" + appRuntime.getAccount(), 0L);
            long serverTimeMillis = (NetConnInfoCenter.getServerTimeMillis() + MiniBoxNoticeInfo.HOUR_8) / 86400000;
            if (serverTimeMillis >= j3) {
                bReportingDailyUser = true;
                sharedPreferences.edit().putLong("next_reportTime_" + appRuntime.getAccount(), 1 + serverTimeMillis).commit();
                NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
                newIntent.putExtra("sendType", 2);
                newIntent.putExtra("tag", DAILY_USE_TAG);
                newIntent.putExtra("content", "");
                appRuntime.startServlet(newIntent);
                if (QLog.isColorLevel()) {
                    QLog.d("QQInitHandler", 2, "Report Daily Use,Next Report Day:" + serverTimeMillis + 1);
                }
                bReportingDailyUser = false;
            }
        }
    }

    public void reportDeviceStatistic(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        Map<String, String> deviceStatistics = getDeviceStatistics();
        if (str != null && deviceStatistics != null) {
            for (String str2 : deviceStatistics.keySet()) {
                if (deviceStatistics.get(str2) == null) {
                    deviceStatistics.put(str2, "");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "report End_Info:" + deviceStatistics.toString());
            }
            RdmReq rdmReq = new RdmReq();
            rdmReq.eventName = DEVICE_STATISTIC_TAG;
            rdmReq.elapse = -1L;
            rdmReq.size = 0L;
            rdmReq.isSucceed = true;
            rdmReq.isRealTime = true;
            rdmReq.isMerge = false;
            rdmReq.params = deviceStatistics;
            try {
                ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
                rdmReportMsg.setAppId(AppSetting.f());
                rdmReportMsg.setTimeout(30000L);
                MsfServiceSdk.get().sendMsg(rdmReportMsg);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Deprecated
    public void reportOnOff(AppRuntime appRuntime, String str, Map<String, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, appRuntime, str, map);
            return;
        }
        if (appRuntime != null && str != null && map != null) {
            StringBuilder sb5 = new StringBuilder(128);
            Set<String> keySet = map.keySet();
            ArrayList arrayList = new ArrayList(map.size());
            for (String str2 : keySet) {
                sb5.append(str2);
                sb5.append("|");
                sb5.append(map.get(str2));
                sb5.append("|");
                arrayList.add(sb5.toString());
                sb5.delete(0, sb5.length());
            }
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
            newIntent.putExtra("sendType", 6);
            newIntent.putExtra("tag", "on_off");
            newIntent.putExtra("content", arrayList);
            appRuntime.startServlet(newIntent);
        }
    }

    public void reportToAds(AppRuntime appRuntime, String str, int i3, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, appRuntime, str, Integer.valueOf(i3), str2, str3, str4);
            return;
        }
        if (appRuntime == null || str == null) {
            return;
        }
        String str5 = str + "|" + str2 + "|" + str3 + "|" + i3 + "|" + str4;
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
        newIntent.putExtra("sendType", 2);
        newIntent.putExtra("tag", "appPlug");
        newIntent.putExtra("content", str5);
        appRuntime.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d("reportToAds", 2, str5);
        }
    }

    @Deprecated
    public void reportToPCliOper(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        if (appRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
        newIntent.putExtra("sendType", 2);
        newIntent.putExtra("tag", "P_CliOper");
        newIntent.putExtra("content", str);
        appRuntime.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "tag=P_CliOper,content=" + str);
        }
    }

    public void setContact(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        try {
            QQBeaconReport.setUserId(str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static StatisticCollector getInstance(Context context, long j3) {
        aa1.b d16 = com.tencent.mobileqq.bridge.a.d();
        if (self == null) {
            synchronized (StatisticCollector.class) {
                if (self == null) {
                    if (d16 != null && d16.b()) {
                        self = new StatisticCollector(MobileQQ.sMobileQQ, j3);
                    } else {
                        self = new EmptyStatisticCollector(MobileQQ.sMobileQQ);
                    }
                }
            }
        }
        if (self != null) {
            synchronized (StatisticCollector.class) {
                if (d16 != null) {
                    if (d16.b() && (self instanceof EmptyStatisticCollector)) {
                        self = new StatisticCollector(MobileQQ.sMobileQQ, j3);
                    }
                }
            }
        }
        return self;
    }

    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            collectPerformance("", str, str2, z16, j3, j16, hashMap, str3, z17, false);
        } else {
            iPatchRedirector.redirect((short) 6, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3, Boolean.valueOf(z17));
        }
    }

    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            collectPerformance("", str, str2, z16, j3, j16, hashMap, str3, z17, z18);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3, Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    public void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            collectPerformance(str, str2, str3, z16, j3, j16, hashMap, str4, false, false);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str4);
        }
    }

    protected StatisticCollector(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.appReports = new ProductInfo[]{new ProductInfo(TbsConfig.APP_QB, "qqBrowser"), new ProductInfo(SDKConst.SELF_PACKAGENAME, "qqMarket"), new ProductInfo("com.tencent.qqgame", "qqGame"), new ProductInfo(QZoneHelper.PACKAGENAME_QQMUSIC, "qqMusic"), new ProductInfo("com.tencent.news", "qqNews"), new ProductInfo("com.qq.reader", "qqReader"), new ProductInfo("com.tencent.qqlive", "qqVideo"), new ProductInfo("com.tencent.wblog", "qqMicroblog"), new ProductInfo("com.tencent.qqphonebook", "qqPhonebook")};
            ctx = context;
        }
    }

    public void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            collectPerformance(str, str2, str3, z16, j3, j16, hashMap, str4, z17, false);
        } else {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str4, Boolean.valueOf(z17));
        }
    }

    public void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4, boolean z17, boolean z18) {
        HashMap<String, String> hashMap2 = hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap2, str4, Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        aa1.b d16 = com.tencent.mobileqq.bridge.a.d();
        if (d16 == null || d16.b()) {
            if (str3 == null) {
                Throwable th5 = new Throwable();
                reportNullEventNameError(str2, th5);
                QLog.d(TAG, 1, "report with null eventName", th5);
                return;
            }
            if (hashMap2 == null) {
                hashMap2 = new HashMap<>();
            } else {
                HashSet<String> hashSet = new HashSet();
                hashSet.addAll(hashMap.keySet());
                for (String str5 : hashSet) {
                    if (hashMap2.get(str5) == null) {
                        hashMap2.put(str5, "");
                    }
                }
            }
            hashMap2.put(DeviceInfo.APPID_TAG, "" + AppSetting.f());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "event report: " + str3 + " " + z16 + " time:" + j3 + " size:" + j16);
            }
            if (z16 && (!hashMap2.containsKey("param_FailCode") || "".equals(hashMap2.get("param_FailCode")))) {
                hashMap2.put("param_FailCode", String.valueOf(0));
            }
            RdmReq rdmReq = new RdmReq();
            rdmReq.eventName = str3;
            rdmReq.elapse = j3;
            rdmReq.size = j16;
            rdmReq.isSucceed = z16;
            rdmReq.isRealTime = z17;
            rdmReq.appKey = str;
            rdmReq.isImmediatelyUpload = z18;
            if (isMultimediaEvent(str3)) {
                rdmReq.isMerge = false;
                rdmReq.isRealTime = true;
            }
            rdmReq.params = hashMap2;
            try {
                ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
                rdmReportMsg.setAppId(AppSetting.f());
                rdmReportMsg.setTimeout(30000L);
                ThreadManagerV2.post(new Runnable(rdmReportMsg) { // from class: com.tencent.mobileqq.statistics.StatisticCollector.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ToServiceMsg f289931d;

                    {
                        this.f289931d = rdmReportMsg;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StatisticCollector.this, (Object) rdmReportMsg);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            MsfServiceSdk.get().sendMsg(this.f289931d);
                        }
                    }
                }, 5, null, true);
            } catch (Exception unused) {
            }
        }
    }

    public void reportToAds(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, appRuntime, str, Integer.valueOf(i3));
        } else {
            if (appRuntime == null || str == null) {
                return;
            }
            reportToAds(appRuntime, str, i3, "", "", "");
        }
    }

    public void reportToAds(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) appRuntime, (Object) str);
        } else {
            if (appRuntime == null || str == null) {
                return;
            }
            reportToAds(appRuntime, str, 1, "", "", "");
        }
    }

    public void reportToAds(AppRuntime appRuntime, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, appRuntime, str, str2);
        } else {
            if (appRuntime == null || str == null) {
                return;
            }
            reportToAds(appRuntime, str, 1, "", "", str2);
        }
    }

    @Deprecated
    public void reportActionCountCliOper(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, appRuntime, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (appRuntime == null || str == null || str3 == null || str4 == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(str);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str2);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str4);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i16);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i17);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i18);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(QbAddrData.DATA_SPLITER);
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
        newIntent.putExtra("sendType", 2);
        newIntent.putExtra("tag", "CliOper");
        newIntent.putExtra("content", sb5.toString());
        appRuntime.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "tag=CliOper,content=" + sb5.toString());
        }
    }

    @Deprecated
    public void reportActionCount(AppRuntime appRuntime, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, appRuntime, str, str2, Integer.valueOf(i3));
            return;
        }
        if (appRuntime == null || str == null || str2 == null) {
            return;
        }
        String str3 = str2 + "|" + i3;
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
        newIntent.putExtra("sendType", 2);
        newIntent.putExtra("tag", "mqq_tab");
        newIntent.putExtra("content", str3);
        appRuntime.startServlet(newIntent);
    }

    @Deprecated
    public void reportActionCount(AppRuntime appRuntime, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, appRuntime, str, str2, str3);
            return;
        }
        if (appRuntime == null || str == null || str2 == null) {
            return;
        }
        String str4 = str2 + "|" + str3;
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
        newIntent.putExtra("sendType", 2);
        newIntent.putExtra("tag", "mqq_tab");
        newIntent.putExtra("content", str4);
        appRuntime.startServlet(newIntent);
    }
}
