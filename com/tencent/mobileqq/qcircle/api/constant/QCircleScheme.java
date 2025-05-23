package com.tencent.mobileqq.qcircle.api.constant;

import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleScheme {
    public static final String AIO_SCHEMA_PREFIX = "mqqapi://qcircle/openAio?";
    public static final String CHAT_SEQ_LIST = "chat_seq_list";
    public static final String KEY_MAIN_ENTRANCE = "xsj_main_entrance";
    public static final String KEY_SCHEME = "key_scheme";
    public static final String Q_CIRCLE_ACTION_OPEN_AGGREGATION = "openAggregation";
    public static final String Q_CIRCLE_ACTION_OPEN_AIO = "openAio";
    public static final String Q_CIRCLE_ACTION_OPEN_ALBUM = "openalbum";
    public static final String Q_CIRCLE_ACTION_OPEN_ALBUM_LAYER = "openalbumlayer";
    public static final String Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL = "opendetail";
    public static final String Q_CIRCLE_ACTION_OPEN_CIRCLE_MAIN_PAGE = "openmainpage";
    public static final String Q_CIRCLE_ACTION_OPEN_CIRCLE_SHARE_CONTENT_DETAIL = "opensharedetail";
    public static final String Q_CIRCLE_ACTION_OPEN_CIRCLE_SHARE_MAIN_PAGE = "opensharemainpage";
    public static final String Q_CIRCLE_ACTION_OPEN_CIRCLE_TAG_PAGE = "opentag";
    public static final String Q_CIRCLE_ACTION_OPEN_CIRCLE_WEBVIEW = "openwebview";
    public static final String Q_CIRCLE_ACTION_OPEN_COLLECT_BOX_DETAIL = "openfavorites";
    public static final String Q_CIRCLE_ACTION_OPEN_DEBUG = "opendebug";
    public static final String Q_CIRCLE_ACTION_OPEN_DRAFT = "openpublishdraft";
    public static final String Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE = "openfolder";
    public static final String Q_CIRCLE_ACTION_OPEN_GALLERY_DETAIL = "opengallerydetail";
    public static final String Q_CIRCLE_ACTION_OPEN_GALLERY_MAIN_PAGE = "opengallerymainpage";
    public static final String Q_CIRCLE_ACTION_OPEN_HALF_SCREEN_WEB = "openhalfscreenweb";
    public static final String Q_CIRCLE_ACTION_OPEN_HOT_COMMENTS_COLLECTION = "opencollectiondetail";
    public static final String Q_CIRCLE_ACTION_OPEN_MAKE_RED_PACKET = "openmakeredpacket";
    public static final String Q_CIRCLE_ACTION_OPEN_MESSAGE_BOX_PAGE = "openmessagelist";
    public static final String Q_CIRCLE_ACTION_OPEN_MESSAGE_PAGE = "opennoticelist";
    public static final String Q_CIRCLE_ACTION_OPEN_MESSAGE_SECOND_PAGE = "opennoticesecondlist";
    public static final String Q_CIRCLE_ACTION_OPEN_MUSIC_AGGREGATION = "openflowaggregation";
    public static final String Q_CIRCLE_ACTION_OPEN_PERSONAL_COVER_FEED_PAGE = "openpersonalcoverfeedpage";
    public static final String Q_CIRCLE_ACTION_OPEN_PERSONAL_QQ_GROUP_PAGE = "openpersonalqqgrouppage";
    public static final String Q_CIRCLE_ACTION_OPEN_POLYMERIZE = "openpolymerize";
    public static final String Q_CIRCLE_ACTION_OPEN_POLYMERIZE_DETAIL = "openpolymerizedetail";
    public static final String Q_CIRCLE_ACTION_OPEN_PRIVACY_SETTING = "openPrivacySetting";
    public static final String Q_CIRCLE_ACTION_OPEN_PYMK_PAGE = "openpymk";
    public static final String Q_CIRCLE_ACTION_OPEN_QQPUBLISH = "openqqpublish";
    public static final String Q_CIRCLE_ACTION_OPEN_QQ_GROUP_DETAIL = "openGroupDetail";
    public static final String Q_CIRCLE_ACTION_OPEN_RECENT_WATCH_PAGE = "openrecentwatch";
    public static final String Q_CIRCLE_ACTION_OPEN_RECOMMEND_USERS = "openrecommenduserlist";
    public static final String Q_CIRCLE_ACTION_OPEN_SEARCH = "opencirclesearch";
    public static final String Q_CIRCLE_ACTION_OPEN_SELF_CHECK = "openselfcheck";
    public static final String Q_CIRCLE_ACTION_OPEN_SETTING = "opensetting";
    public static final String Q_CIRCLE_ACTION_OPEN_TVIDEO_PUBLIC_ACCOUNT = "opentvideopublicaccount";
    public static final String Q_CIRCLE_ACTION_OPEN_UNIFIEDTAGFLOW = "openunifiedtagflow";
    public static final String Q_CIRCLE_ACTION_OPEN_WATCH_LATER = "openwatchlater";
    public static final String Q_CIRCLE_ACTION_QUICK_SHARE = "quickshare";
    public static final String Q_CIRCLE_ACTION_SHARE = "share";
    public static final String Q_CIRCLE_FACE_FOLLOW = "facefollow";
    public static final String Q_CIRCLE_FROM_AIO = "qq_aio";
    public static final String Q_CIRCLE_FROM_PUSH = "push";
    public static final String Q_CIRCLE_PROTOCOL_ROOTPATH = "qcircle";
    public static final String Q_CIRCLE_SCHEME_PREFIX = "mqqapi://qcircle/";
    public static final String Q_CIRCLE_WATERFALL = "openWaterfall";
    public static final String Q_CIRCLR_ACTION_MINIAPP = "miniapp";
    public static final String XSJ_SUB_ENTRANCE = "xsj_sub_entrance";

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class AttrAio {
        public static final String HALFSCREEN = "halfscreen";
        public static final String SH_MSG_SEQ = "shMsgSeq";
        public static final String TYPE = "type";
        public static final String UIN = "uin";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class AttrDetail {
        public static final String CRERTE_TIME = "createtime";
        public static final String ENABLE_REFRESH = "enable_refresh";
        public static final String FEED_ID = "feedid";
        public static final String FEED_INFO = "feedInfo";
        public static final String HAS_RED_DOT = "has_red_dot";
        public static final String QCIRCLE_IMMERSIVE_AUTO_REFRESH = "qcircle_immersive_auto_refresh";
        public static final String QCIRCLE_IMMERSIVE_REQUEST_SPECIFIC_FEED = "qcircle_immersive_request_specific_feed";
        public static final String SHOULD_REUSE_EXISTED_PAGE = "should_reuse_existed_page";
        public static final String SOURCE_TYPE = "sourcetype";
        public static final String TAG_NAME = "tagname";
        public static final String UIN = "uin";
        public static final String VIDEO_INFO = "videoInfo";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class AttrGallery {
        public static final String FROM = "from";
        public static final String JUMP_TO_GALLERY_PUBLISH_PAGE = QzoneConfig.getWinkPublishGalleryModeSchema();
        public static final String SCENE = "scene";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class AttrMainPage {
        public static final String KEY_PYMK_TRANSFER = "transdata";
        public static final String KEY_PYMK_TYPE = "type";
        public static final String UIN = "uin";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class AttrPolymerize {
        public static final String FEED_TAG_PAGE_FROM_TYPE = "feedtagpagefromtype";
        public static final String FEED_TAG_PAGE_FROM_WINK_TEMPLATE_COLL_BANNER = "100";
        public static final String FEED_TAG_PAGE_FROM_WINK_TEMPLATE_COLL_CARD = "101";
        public static final String LON = "lon";
        public static final String SOURCE_TYPE = "sourcetype";
        public static final String TAG_ID = "tagid";
        public static final String TAG_NAME = "tagname";
        public static final String XSJ_OPERATION_ACTIVITY_ID = "xsj_operation_activity_id";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class AttrQQGroupDetail {
        public static final String AUTH_SIG = "auth_sig";
        public static final String FEED = "feed";
        public static final String FROM = "from";
        public static final String PERSONAL = "personal";
        public static final String UIN = "uin";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class AttrQQPublish {
        public static final String ACTIVITY_MATERIAL_ID = "activity_material_id";
        public static final String ACTIVITY_MATERIAL_TYPE = "activity_material_type";
        public static final String ADVERTISE_BIZ_ID = "biz_id";
        public static final String ADVERTISE_JOB_ID = "advertise_job_id";
        public static final String ADVERTISE_JOB_TITLE = "advertise_job_title";
        public static final String ADVERTISE_JOB_TYPE = "job_type";
        public static final String AD_ID = "adId";
        public static final String ARK_SHARE_AUTHOR = "ark_share_author";
        public static final String ARK_SHARE_TYPE = "ark_share_type";
        public static final String BROADCAST_WINK_DYNAMIC_AVATAR_FINISH = "wink_dynamic_avatar_finish_action";
        public static final String BUSINESS_AIO = "aiopreview-0001";
        public static final String BUSINESS_AIO_MESSAGE_SEQ = "business_aio_message_seq";
        public static final String BUSINESS_DISPLAY_NAME = "business_display_name";
        public static final String BUSINESS_EMPTY_PAGE_TEXT = "empty_page_text";
        public static final String BUSINESS_GUILD = "guild-0001";
        public static final String BUSINESS_MINI_GAME = "minigame-0001";
        public static final String BUSINESS_MINI_SPARK = "miniapp-spark-0001";
        public static final String BUSINESS_QQ_MINI_GAME = "qq_minigame";
        public static final String BUSINESS_RETURN_SCHEME = "return_scheme";
        public static final String BUSINESS_SPECIFIC_EDIT_MODE = "edit_image_mode";
        public static final String BUSINESS_TASK_ID = "taskid";
        public static final String BUSINESS_TASK_ID_DEFAULT = "others";
        public static final String BUSINESS_TASK_ID_QQ_ROBOT_BANNER = "qqrobot-0003";
        public static final String BUSINESS_TASK_ID_QQ_ROBOT_IMAGE = "qqrobot-0002";
        public static final String BUSINESS_TASK_ID_QQ_ROBOT_PREFIX = "qqrobot";
        public static final String BUSINESS_TASK_ID_QQ_ROBOT_SUGGEST = "qqrobot-0004";
        public static final String BUSINESS_TASK_ID_QQ_ROBOT_TABLE = "qqrobot-0001";
        public static final String BUSINESS_TASK_NAME = "taskname";
        public static final String BUSINESS_TASK_SHOW_BACK_DIALOG = "exit_dialog";
        public static final String BUSINESS_TRANS_ID = "business_trans_id";
        public static final String BUSINESS_TROOP = "qqtroop-0001";
        public static final String BUSINESS_USER_DATA = "user_data";
        public static final String BUSINESS_ZPLAN = "zplan-0001";
        public static final String CHALLENGE_NUMS = "challenge_nums";
        public static final String CHALLENGE_TAG = "challenge_tag";
        public static final String COMMENT_DRAFT_ID = "comment_draft_id";
        public static final String COMPOSE_PAGE_BUTTON_TITLE = "compose_page_button_title";
        public static final String CONTENT = "content";
        public static final String DATONG_REPORT_ELEMENT_PARAMS = "datong_report_element_params";
        public static final String DEFAULT_IMAGE_MODE = "1";
        public static final String DEFAULT_POSTER = "defaultposter";
        public static final String DEFAULT_VIDEO_MODE = "0";
        public static final String DISABLE_BEAUTY = "disable_beauty";
        public static final String DISABLE_MOTION = "disable_motion";
        public static final String EDITOR_DIRECT_PUBLISH_TYPE = "direct_publish_type";
        public static final String EDITOR_DIRECT_PUBLISH_TYPE_0 = "0";
        public static final String EDITOR_DIRECT_PUBLISH_TYPE_2 = "2";
        public static final String EDITOR_DIRECT_PUBLISH_TYPE_3 = "3";
        public static final String EDITOR_TOOLBAR_ITEM = "editor_toolbar_item";
        public static final String ENABLE_GALLERY_MODE = "enable_gallery_mode";
        public static final String ENTER_FEED_ID = "enter_feed_id";
        public static final String FEED_ABSTRACT_CREATETIME = "feed_abstract_createtime";
        public static final String FEED_ABSTRACT_ID = "feed_abstract_id";
        public static final String FEED_ABSTRACT_POSTER_ID = "feed_abstract_poster_id";
        public static final String FILTER = "filter";
        public static final String FROM_ENTRANCE = "dynamic_avatar_from_entrance";
        public static final String FROM_ENTRANCE_ACTIONSHEET = "2";
        public static final String FROM_ENTRANCE_AVATAR_DETAIL = "3";
        public static final String FROM_ENTRANCE_DEFAULT = "1";
        public static final String FROM_ENTRANCE_ORIGIN_VIDEO = "4";
        public static final String FROM_PAGE = "frompage";
        public static final String HIDE_EDIT_FROM_PHOTO = "hide_edit_become_photo";
        public static final String HIDE_EDIT_FROM_VIDEO = "hide_edit_become_video";
        public static final String HIDE_OTHER_CATE = "hide_other_cate";
        public static final String HIDE_PLAYER_UNTIL_TEMPLATE_FINISH = "hide_player_until_template_finish";
        public static final String HIDE_PUBLISH_PERMISSION = "hide_publish_permission";
        public static final String INNER_JUMP = "inner_jump";
        public static final String INNER_JUMP_VALUE_TRUE = "1";
        public static final String INPUT_TABS = "input_tabs";
        public static final String INPUT_TAB_CAMERA = "c";
        public static final String INPUT_TAB_IMAGE_PICKER = "a";
        public static final String INPUT_TAB_LIVE = "l";
        public static final String INPUT_TAB_MAGIC_STUDIO = "m";
        public static final String INPUT_TAB_QZONE_TEXT_TAB = "q";
        public static final String INPUT_TAB_TEMPLATE_LIB = "t";
        public static final String INPUT_TAB_TEXT = "u";
        public static final String INPUT_TAB_WANGZHE_REPORT = "w";
        public static final String INPUT_TAB_ZSHOW = "z";
        public static final String IS_FROM_RED_ENVELOPE = "is_from_red_envelope";
        public static final String IS_TEAM_LEADER = "is_team_leader";
        public static final String KEY_ATTRS = "key_attrs";
        public static final String KEY_TEMPLATE_ASSET = "key_template_asset";
        public static final String LABEL_FOR_QQ = "label_for_qq";
        public static final String LIB_TEMPLATE = "libtemplate";
        public static final String LIB_TEMPLATE_MEMORY_ID = "lib_template_memory_id";
        public static final String LIB_TEMPLATE_V2 = "libTemplate";
        public static final String MEDIAPATH = "mediapath";
        public static final String MEMORY_ALBUM_ID = "memory_album_id";
        public static final String MEMORY_ALBUM_TITLE = "memory_album_title";
        public static final String METERIAL = "meterial";
        public static final String MINI_APP_ID = "mini_app_id";
        public static final String MINI_GAME_ID = "mini_game_id";
        public static final String MUSIC = "music";
        public static final String MUSIC_AUTHOR_UID = "music_author_uid";
        public static final String MUSIC_BANNER_BUBBLE_TIPS = "music_banner_bubble_tips";
        public static final String MUSIC_COMPLETE = "music_complete";
        public static final String MUSIC_LOADING_TITLE = "music_loading_text";
        public static final String MUSIC_SCENE = "music_scene";
        public static final String NEED_USER_INFO = "need_user_info";
        public static final String NO_LICENSE_TIPS = "no_license_tips";
        public static final String OPENPERSONALCOVERFEEDPAGE_AVATAR_FROM = "dynamic_avatar";
        public static final String ORIGINAL_MUSIC_EXTEND_STRING = "original_music_extend_string";
        public static final String OUTPUT_POINT = "wink_output_point";
        public static final String OUTPUT_ROUTE_PATH = "wink_output_route";
        public static final String PICKER_ALBUM_ID = "album_id";
        public static final String PICKER_CONFIG = "picker_config";
        public static final String PICKER_CONFIG_TAB_TYPE = "tabType";
        public static final String PICKER_QZONE_ALBUM = "qzonealbum";
        public static final String PICK_TEMPLATE_BACK_EDIT_LOCAL_PATH = "local_template_path";
        public static final String PICK_TEMPLATE_ID = "lib_template_id";
        public static final String PICK_TEMPLATE_MEDIA_HOLDER_COUNT = "pick_template_media_holder_count";
        public static final String PICK_TEMPLATE_MEDIA_HOLDER_TIME_SLOT = "template_holder_slot";
        public static final String PUBLISH_CONTENT_PREFIX = "publish_content_prefix";
        public static final String PUBLISH_PAGE_BUTTON_TITLE = "compose_page_button_title";
        public static final String PUBLISH_SCHEMA_PREFIX = "mqqapi://qcircle/openqqpublish?";
        public static final String PUBLISH_TASKID = "publish_taskid";
        public static final String PUBLISH_TRANS_TAG = "publish_trans_tag";
        public static final String QZONE_ALBUM_ENABLE_AUTO_TEMPLATE = "enable_auto_template";
        public static final String QZONE_ALBUM_ENABLE_EDIT = "enable_edit";
        public static final String QZONE_ALBUM_IMAGE_PICKER_TITLE = "image_picker_title";
        public static final String QZONE_ALBUM_MAX_SELECTION_COUNT = "max_selection_count";
        public static final String QZONE_ALBUM_MEDIA_TYPE = "picker_media_type";
        public static final String QZONE_ALBUM_REQUEST_CODE = "picker_request_code";
        public static final String REVITALIZE = "revitalize";
        public static final String SCROLL_TO_TEMPLATE_LIST = "scroll_to_template_list";
        public static final String SELECT_PAGE_BANNER_ICON = "select_page_banner_icon";
        public static final String SELECT_PAGE_BANNER_TIP = "select_page_banner_tip";
        public static final String SELECT_TAB = "select_tab";
        public static final String SHARE_PREVIEW_TYPE_LABEL = "2";
        public static final String SHARE_PREVIEW_TYPE_PHOTO_WALL = "0";
        public static final String SHOULD_OPEN_SCHOOL = "should_open_school";
        public static final String SHOW_PUBLISH_EXIT_DIALOG = "show_publish_exit_dialog";
        public static final String SOURCE = "source";
        public static final String STICKER = "sticker";
        public static final String ST_POST_COMMENT_ID = "st_post_comment_id";
        public static final String ST_POST_POST_TYPE = "st_post_post_type";
        public static final String ST_POST_REPLY_ID = "st_post_reply_id";
        public static final String SUB_TAB_SOURCE_TYPE = "sub_tab_source_type";
        public static final String SUPER_QQ_SHOW_IS_DRESS_OUTFIT = "embedinoutfit";
        public static final String SYNC_PUBLISH = "should_publish_incompose";
        public static final String TAG = "tag";
        public static final String TARGET = "target";
        public static final String TARGET_AI_AVATAR_MAIN = "24";
        public static final String TARGET_AI_AVATAR_RESULT = "25";
        public static final String TARGET_CAMERA = "0";
        public static final String TARGET_DYNAMIC_AVATAR = "1001";
        public static final String TARGET_IMAGEPICKER = "1";
        public static final String TARGET_MAGIC_STUDIO = "15";
        public static final String TARGET_MEMORY_ALBUM = "16";
        public static final String TARGET_MULTI_CAMERA = "1002";
        public static final String TARGET_PUBLISHPAGE = "4";
        public static final String TARGET_QCIRCLE_COMMENT = "1003";
        public static final String TARGET_QZONE_AI_ELIMINATE_MAIN_PAGE = "23";
        public static final String TARGET_QZONE_IMAGE_PICKER = "21";
        public static final String TARGET_QZONE_IMAGE_TEMPLATE_PICKER = "19";
        public static final String TARGET_QZONE_IMAGE_TEMPLATE_PREVIEW = "20";
        public static final String TARGET_QZONE_LOCAL_PHOTO_RECOMMEND = "22";
        public static final String TARGET_TEMPLATE_LIBRARY = "2";
        public static final String TARGET_TEMPLATE_LIB_PREVIEW = "5";
        public static final String TARGET_TEMPLATE_LIB_SELECT = "6";
        public static final String TARGET_TEMPLATE_PREVIEW = "12";
        public static final String TARGET_TEXT_VIDEO = "9";
        public static final String TARGET_WANGZHE_REPORT = "14";
        public static final String TARGET_WINKEDIT = "3";
        public static final String TARGET_WINKEDIT_2 = "7";
        public static final String TARGET_ZSHOW = "8";
        public static final String TEMPLATE = "template";
        public static final String TEMPLATE_PREVIEW_TYPE = "share_preview_type";
        public static final String TIANSHU_ACTIVITY_ITEM_VALUE = "tianshu_activity_item_value";
        public static final String TOPIC = "topic";
        public static final String UP_SOURCE = "up_source";
        public static final String VALUE_FALSE = "0";
        public static final String VALUE_TRUE = "1";
        public static final int VALUE_TRUE_INT = 1;
        public static final String VIDEO_COMMENT = "videocomment";
        public static final String WAIT_UNTIL_RES_READY = "wait_until_res_ready";
        public static final String WANGZHE_REPORT_URL = "wangzhe_report_url";
        public static final String XSJ_OPERATION_ACTIVITY_ID = "xsj_operation_activity_id";
        public static final String ZPLAN_SAMESTYLE_ID = "zplan_samestyle_id";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class AttrRedPacket {
        public static final String RED_ENVELOPE_ENTRANCE = "red_envelope_entrance";
        public static final String RED_PACKET_PREVIEW_FEED_CREATE_TIME = "red_packet_preview_feed_create_time";
        public static final String RED_PACKET_PREVIEW_FEED_ID = "red_packet_preview_feed_id";
        public static final String RED_PACKET_PREVIEW_FEED_POSTER_ID = "red_packet_preview_feed_poster_id";
        public static final String RED_PACKET_PREVIEW_LOCAL_COVER_PATH = "red_packet_preview_local_cover_path";
        public static final String RED_PACKET_PREVIEW_LOCAL_VIDEO_PATH = "red_packet_preview_local_video_path";
        public static final String RED_PACKET_PUBLISH_ROUTE = "/wink/output/qcircle/red_pocket";
    }

    public static boolean isFolderSchema(String str) {
        if (str != null && str.contains(Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE)) {
            return true;
        }
        return false;
    }

    public static boolean isPolymerizeSchema(String str) {
        if (str != null && (str.contains(Q_CIRCLE_ACTION_OPEN_CIRCLE_TAG_PAGE) || str.contains(Q_CIRCLE_ACTION_OPEN_POLYMERIZE))) {
            return true;
        }
        return false;
    }
}
