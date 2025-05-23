package com.tencent.mobileqq.qqpermission;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes17.dex */
public class QQPermissionConstants {
    static IPatchRedirector $redirector_;
    public static final Map<String, String> BUSINESS_MODULE_MAP;

    /* loaded from: classes17.dex */
    public static final class Business {
        static IPatchRedirector $redirector_;
        public static final Map<String, Integer> PERMISSION_SCENE_INTRODUCE;

        /* loaded from: classes17.dex */
        public static final class ID {
            static IPatchRedirector $redirector_ = null;
            public static final String DATALINE = "biz_src_sq_dataline";
            public static final String FACE_IDENTIFICATION = "biz_src_SQ_face_identification";
            public static final String GY_FLASH_SHOW_UNIT = "biz_src_SQ_flash_show_camera_unit";
            public static final String KANDIAN_PUBLISHER = "biz_src_sq_kandian_publisher";
            public static final String QLINK = "biz_src_sq_qlink";
            public static final String QQ_ADD_CONTACT_TROOP = "biz_src_add_contact";
            public static final String QQ_AIO_ALBUM = "biz_src_sq_aio_album";
            public static final String QQ_AIO_CAMERA = "biz_src_sq_aio_camera";
            public static final String QQ_AIO_STORAGE = "biz_src_sq_aio_storage";
            public static final String QQ_ALBUM = "biz_src_sq_album";
            public static final String QQ_ARK = "biz_src_ark";
            public static final String QQ_ASSISTANT = "biz_src_qq_assistant";
            public static final String QQ_AV = "biz_src_sq_av";
            public static final String QQ_AVGAME = "biz_src_sq_avgame";
            public static final String QQ_BUSINESS_BIG_SEARCH = "biz_src_condition_qq_big_search";
            public static final String QQ_BUSINESS_CARD = "biz_src_business_card";
            public static final String QQ_BUSINESS_FLOCK = "biz_src_flock";
            public static final String QQ_BUSINESS_GAME_CENTER = "biz_src_gamecenter";
            public static final String QQ_CHANNEL_AUDIO = "biz_src_qqchannel_audio";
            public static final String QQ_CHANNEL_CONTENT_SHARE = "biz_src_qqchannel_share";
            public static final String QQ_CHANNEL_FEED = "biz_src_qqchannel_feed";
            public static final String QQ_CHANNEL_KARAOKE = "biz_src_qqchannel_karaoke";
            public static final String QQ_CHANNEL_LIVE = "biz_src_qqchannel_live";
            public static final String QQ_CHANNEL_MAINFRAME = "biz_src_SQ_qqchannel_mainframe";
            public static final String QQ_CHANNEL_WORLD = "biz_src_qqchannel_world";
            public static final String QQ_CIRCLE_PUBLISH = "biz_src_qqcircle_wink_publish";
            public static final String QQ_CONDITION_SEARCH = "biz_src_condition_search";
            public static final String QQ_CONTACT_LOCATION = "biz_src_sq_contact_location";
            public static final String QQ_CONTACT_STORAGE = "biz_src_sq_contact_storage";
            public static final String QQ_EMOTICON = "biz_src_emoticon";
            public static final String QQ_FACE_2_FACE_ADD_CONTACT_LOCATION = "biz_src_sq_FACE_2_face_add_contact_location";
            public static final String QQ_FAV = "biz_src_sq_qfav";
            public static final String QQ_FILE = "biz_src_sq_qq_file";
            public static final String QQ_FRIEND_PROFILE_IMAGE = "biz_src_friend_profile_image";
            public static final String QQ_GAME_CENTER_CALENDAR = "biz_src_gamecenter_calendar";
            public static final String QQ_GAME_CENTER_VOICE = "biz_src_gamecenter_yungame_voice";
            public static final String QQ_HEALTH = "biz_src_qqsports";
            public static final String QQ_ID = "timi_qqid";
            public static final String QQ_INVITATION_WEBVIEW = "biz_src_invitation_webView_plugin";
            public static final String QQ_KANDIAN = "biz_src_sq_kandian";
            public static final String QQ_LABEL_SHARE_STORAGE = "biz_src_sq_label_share_storage";
            public static final String QQ_LIVE = "biz_src_qqlive_camera_record_android";
            public static final String QQ_LOCATION = "biz_src_sq_location";
            public static final String QQ_MAP = "biz_src_sq_map";
            public static final String QQ_MINIAPP_MYSITE = "biz_src_miniapp_mysite";
            public static final String QQ_MINIAPP_SAVE = "biz_src_miniapp_save";
            public static final String QQ_NEARBY = "biz_src_nearby";
            public static final String QQ_NEW_GUIDE = "biz_src_new_guide";
            public static final String QQ_OLYMPIC_TORCH = "biz_src_sq_olympic_torch";
            public static final String QQ_ONLINE_STATUS_SMART_STATUS_ID = "biz_src_SQ_onlineStatus_smart_status";
            public static final String QQ_ONLINE_STATUS_WEATHER_ID = "biz_src_SQ_onlineStatus_weather";
            public static final String QQ_OPENSDK_AUTH = "biz_src_opensdk_auth";
            public static final String QQ_PC_LOGIN = "biz_src_pc_login";
            public static final String QQ_PHONECONTACT = "biz_src_phonecontact";
            public static final String QQ_PLUGIN = "biz_src_plugin";
            public static final String QQ_PROFILE_CARD_CONTACT = "biz_src_sq_profile_card_contact";
            public static final String QQ_PUBLIC_ACCOUNT = "biz_src_sq_public_account";
            public static final String QQ_PUBLIC_MINI_PERMISSION_CAMERA = "biz_src_miniapp_camera";
            public static final String QQ_PUBLIC_MINI_PERMISSION_READ_EXTERNAL_STORAGE = "biz_src_miniapp_read_storage";
            public static final String QQ_PUBLIC_MINI_PERMISSION_RECORD_AUDIO = "biz_src_miniapp_record_audio";
            public static final String QQ_QAV = "biz_src_sq_qav";
            public static final String QQ_QCIRCLE = "biz_src_qcircle";
            public static final String QQ_QR_DISPLAY = "biz_src_qr";
            public static final String QQ_QWALLET = "biz_src_sq_qwallet";
            public static final String QQ_QZONE = "biz_src_qzone";
            public static final String QQ_REMINDER = "biz_src_sq_qq_reminder";
            public static final String QQ_RICH_MEDIA = "biz_src_rich_media";
            public static final String QQ_RICH_MEDIA_CAMERA = "biz_src_rich_media_camera";
            public static final String QQ_RICH_MEDIA_EDIT_PHOTO = "biz_src_rich_media_edit_photo";
            public static final String QQ_RICH_MEDIA_EDIT_VIDEO = "biz_src_rich_media_edit_video";
            public static final String QQ_RICH_MEDIA_RECORD_AUDIO = "biz_src_rich_media_record_audio";
            public static final String QQ_RICH_MEDIA_SAVE = "biz_src_rich_media_save";
            public static final String QQ_SCAN_AR = "biz_src_scan_ar";
            public static final String QQ_SCAN_OCR = "biz_src_scan_ocr";
            public static final String QQ_SCREENSHOT = "biz_src_SQ_screenshot";
            public static final String QQ_SHARE = "biz_src_sq_share";
            public static final String QQ_SIGN_TEXT_EDIT_LOCATION = "biz_src_sq_sign_text_edit_location";
            public static final String QQ_STRANGER = "biz_src_qqstranger";
            public static final String QQ_STRANGER_PARTY_ROOM = "qq_stranger_party_room";
            public static final String QQ_TROOP = "biz_src_sq_troop";
            public static final String QQ_TROOP_APP = "biz_src_sq_troop_app";
            public static final String QQ_TROOP_COMMON_COMPONENT = "biz_src_sq_troop_common";
            public static final String QQ_VOICE_ASSISTANT = "biz_src_sq_voice_assistant";
            public static final String QQ_WEATHER = "biz_src_weather";
            public static final String QQ_WEBVIEW = "biz_src_webview_media";
            public static final String QQ_ZPLAN = "biz_src_sq_zplan";
            public static final String QQ_ZPLAN_LIGHTAI = "biz_src_sq_zplan_lightai";
            public static final String SOGOU_EMOJI = "biz_src_sq_sogou_emoji";
            public static final String TBS_TOOL = "biz_src_sq_tbs_tool";
            public static final String TENCENT_DOCS_CAMERA = "biz_src_SQ_20220310";
            public static final String TENCENT_DOCS_VOICE = "biz_src_SQ_20220309";
            public static final String TEST = "id_test";
            public static final String ZPLAN_DETAIL = "biz_src_zplan_detail";
            public static final String ZPLAN_GAME = "biz_src_zplan_game";
            public static final String ZPLAN_PET_SHARE = "biz_src_sq_pet_photo_share_save_pic";
            public static final String ZPLAN_PREVIEW = "biz_src_zplan_preview";
            public static final String ZPLAN_SHARE = "biz_src_zplan_share";

            public ID() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* loaded from: classes17.dex */
        public static final class SCENE {
            static IPatchRedirector $redirector_ = null;
            public static final String ADD_CONTACT_TROOP_LOCATION = "add_contact_troop_location";
            public static final String AIO_PANEL_TAKE_PHOTO = "aio_panel_take_photo";
            public static final String AIO_SAVE_PIC = "aio_save_pic";
            public static final String ARK_GET_LOCATION = "ark_get_location";
            public static final String AR_SCAN_CLOUD_LOCATION = "ar_scan_cloud_location";
            public static final String AR_SCAN_VIDEO_RECORD = "ar_scan_video_record";
            public static final String ASSISTANT_GUIDER = "assistant_guider";
            public static final String AVATAR_CAMERA = "qqvip_avatar_camera";
            public static final String AVATAR_PTOTO = "qqvip_avatar_photo";
            public static final String AVGAME_DOWNLOAD_RESULT = "avgame_download_result";
            public static final String AVGAME_ENTER_AUDIO_ROOM = "avgame_enter_audio_room";
            public static final String AVGAME_OPEN_CAMERA = "avgame_open_camera";
            public static final String BUSINESS_CARD_CONTACTS = "business_card_contacts";
            public static final String BUSINESS_CARD_GET_LOCATION = "business_card_get_location";
            public static final String BUSINESS_CARD_PHOTO = "business_card_photo";
            public static final String CAMERA = "camera";
            public static final String CARD_CAMERA = "qqvip_card_camera";
            public static final String CHANNEL_FEED_SHARE_SAVE = "channel_feed_share_save";
            public static final String CHAT_PIE_GET_LOCATION = "chat_pie_get_location";
            public static final String CIRCLE_EDITOR_WATERMARK = "circle_editor_watermark";
            public static final String CIRCLE_PUBLISH_HOME_PAGE_TEST_B = "circle_publish_home_page_test_B";
            public static final String CIRCLE_PUBLISH_PICKER = "circle_publish_picker";
            public static final String CIRCLE_PUBLISH_TEMPLATE = "circle_publish_template";
            public static final String CIRCLE_PUBLISH_UPLOAD = "circle_publish_upload";
            public static final String COMPANY_QQ_ADD_CONTACT = "company_qq_add_contact";
            public static final String CONDITION_SEARCH_LOCATION = "condition_search_location";
            public static final String CONTACTS_DEVICE = "contacts_device";
            public static final String CONTACTS_SMART_DEVICE_CLICK = "contacts_smart_device_click";
            public static final String COVER = "qqvip_cover";
            public static final String DATALINE = "dataline";
            public static final String DATALINE_EXPORT_PHOTO = "dataline_export_photo";
            public static final String DRAWER_WEATHER = "drawer_weather";
            public static final String EMOTICON_FAV_COLLECTION = "emoticon_fav_collection";
            public static final String EMOTICON_SAVE = "emoticon_save";
            public static final String EMOTICON_SHARE_CARD = "emoticon_share_card";
            public static final String ENTER_AUDIO_ROOM = "enter_audio_room";
            public static final String FACE_2_FACE_ADD_CONTACT = "face_2_face_add_contact";
            public static final String FACE_IDENTIFICATION_GUIDE = "face_identification_guide";
            public static final String FACE_IDENTIFICATION_JSAPI = "face_identification_jsapi";
            public static final String FLOCK_GET_LOCATION = "flock_get_location";
            public static final String FLOCK_MEDIA_PICKER = "flock_media_picker";
            public static final String FLOCK_SAVE_MEDIA_TO_ALBUM = "flock_save_media_to_album";
            public static final String FRIEND_FPROFILE_IMAGE = "friend_profile_image";
            public static final String GAME_CENTER_CALENDAR_REMIND = "gamecenter_cal_reminder";
            public static final String GAME_CENTER_SCENE = "gamecenter_media_save";
            public static final String GAME_CENTER_YUNGAME_VOICE = "gamecenter_yungame_voice";
            public static final String GET_WEATHER_INFO = "get_weather_info";
            public static final String GY_FLASH_SHOW_UNIT = "flash_show_camera_unit";
            public static final String HEALTH_COMMUNITY = "health_community";
            public static final String HEALTH_RUN = "health_run";
            public static final String HERMES_SAVE_MEDIA_TO_ALBUM = "hermes_save_media_to_album";
            public static final String JSB_CAMERA = "jsb_call_camera";
            public static final String JS_BRIDGE_GET_LOCATION = "js_bridge_get_location";
            public static final String KANDIAN_DILAY = "kandian_daily";
            public static final String KANDIAN_PUBLISHER_H5 = "kandian_publisher_h5";
            public static final String KANDIAN_SHARE_SAVE_IMAGE = "kandian_share_save_image";
            public static final String MAIL_PLUGIN_DIAL = "mail_plugin_dial";
            public static final String MAIL_PLUGIN_SEND_SMS = "mail_plugin_send_sms";
            public static final String MAIL_PLUGIN_WRITE_CONTACT = "mail_plugin_write_contact";
            public static final String MAP_SHOW_ENTRY = "map_show_entry";
            public static final String MINIBOX_APP_CAMERA = "minibox_app_camera";
            public static final String MINIBOX_APP_LOCATION = "minibox_app_location";
            public static final String MINIBOX_APP_READ_EXTERNAL = "minibox_app_read_external";
            public static final String MINIBOX_APP_RECORD_AUDIO = "minibox_app_record_audio";
            public static final String MINIBOX_APP_WRITE_EXTERNAL = "minibox_app_write_external";
            public static final String MOVE_TO_MAP_LOCATION = "move_to_map_location";
            public static final String NEARBY_ENTER_HOME_PAGE = "nearby_enter_home_page";
            public static final String NEARBY_GAME_WERE_WOLF = "nearby_game_were_wolf";
            public static final String NEARBY_NOW_LIVE = "nearby_now_live";
            public static final String NEARBY_PUBLISH_MOMENT = "nearby_publish_moment";
            public static final String NEARBY_SECURE_VERIFY = "nearby_secure_verify";
            public static final String NEW_GUIDE_GET_RECOMMEND = "new_guide_get_commend";
            public static final String NEW_GUIDE_GET_UP_LOAD_CONTACTS = "new_guide_upload_contacts";
            public static final String NEW_GUIDE_SET_AVATAR = "new_guide_set_avater";
            public static final String OCR_SCAN_CAMERA = "ocr_scan_camera";
            public static final String OPENSDK_CREATE_VIRTUAL_ACCOUNT = "opensdk_create_virtual_account";
            public static final String OPEN_AIO_ALBUM = "open_aio_album";
            public static final String OPEN_AIO_MINI_PHOTO_SELECTOR = "open_aio_mini_photo_selector";
            public static final String OPEN_ALBUM = "open_album";
            public static final String OPEN_CAMERA = "open_camera";
            public static final String PHONECONTACT_OPEN_PAGE = "phonecontact_open_page";
            public static final String PICK_LOCATION = "pick_localtion";
            public static final String PLUGIN = "scene_plugin";
            public static final String PROFILE_CARD = "qqvip_profilecard";
            public static final String PROFILE_CARD_EDIT_GET_CURRENT_LOCATION = "profile_card_get_location";
            public static final String PROFILE_CARD_EDIT_PICK_AVATAR_PHOTO = "profile_card_pick_photo";
            public static final String PROFILE_CARD_EDIT_PICK_COVER_PHOTO = "profile_card_take_cover_photo";
            public static final String PROFILE_CARD_EDIT_TAKE_AVATAR_PHOTO = "profile_card_take_photo";
            public static final String QCIRCLE_FACE_TO_FACE_FOLLOW = "QCIRCLE_FACE_TO_FACE_FOLLOW";
            public static final String QCIRCLE_FEED_READ_CONTACT = "qcircle_feed_read_contact";
            public static final String QCIRCLE_MATERIAL_GUILD = "qcircle_material_guide";
            public static final String QCIRCLE_MIX_FEED = "qcircle_mix_feed";
            public static final String QCIRCLE_NEARBY = "qcircle_nearby";
            public static final String QCIRCLE_PUBLISH_FEED = "qcircle_publish_feed";
            public static final String QCIRCLE_QSTORE_PACK_ADDRESS_INPUT = "qstore_pack_address_input";
            public static final String QCIRCLE_SHARE_SAVE = "qcircle_share_save";
            public static final String QFAV_EDIT_PANEL_AUDIO = "qfav_edit_panel_audio";
            public static final String QFAV_EDIT_TAKE_PHOTO = "qfav_edit_take_photo";
            public static final String QFAV_NEW_AUDIO_FAV = "qfav_new_audio_fav";
            public static final String QFAV_NEW_LOCATION_FAV = "qfav_new_location_fav";
            public static final String QFAV_NEW_PHOTO_FAV = "qfav_new_photo_fav";
            public static final String QFAV_SAVE_FAV = "qfav_save_fav";
            public static final String QLINK = "qlink";
            public static final String QLINK_RECV = "qlink_recv";
            public static final String QLINK_SEND = "qlink_send";
            public static final String QQCHANEL_AVATAR_EDIT_CAMERA = "qqchanel_avatar_edit_camera";
            public static final String QQCHANEL_AVATAR_SAVE_ALBUM = "qqchanel_avatar_save_album";
            public static final String QQCHANEL_GUILD_AVATAR = "qqchanel_guild_avatar";
            public static final String QQCHANEL_PROFILE_LOCATION = "qqchanel_profile_location";
            public static final String QQCHANEL_QRCODE_SAVE_ALBUM = "qqchanel_qrcode_save_album";
            public static final String QQCHANNEL_CONTENT_SHARE_SAVE_ALBUM = "qqchannel_share_content_save_album";
            public static final String QQID_SCENE_RECOGNITION = "qqid_scene_recognition";
            public static final String QQ_AR_OLYMPIC_TORCH = "ar_olympic_torch";
            public static final String QQ_AV_AVATAR_2D = "qq_av_avatar2d";
            public static final String QQ_AV_ROOM = "qq_av_room";
            public static final String QQ_EXPAND_FRIEND_PROFILE_RECORD_AUDIO = "qq_expand_friend_profile_record_audio";
            public static final String QQ_FILE_AIO_FILE_DOWNLOAD = "qq_file_aio_file_download";
            public static final String QQ_FILE_AIO_FILE_PANEL = "qq_file_aio_file_panel";
            public static final String QQ_FILE_DRAG_FILE = "qq_file_drag_file";
            public static final String QQ_FILE_MY_FILE_LOCAL_FILE = "qq_file_my_file_local_file";
            public static final String QQ_FILE_MY_FILE_SAVE = "qq_file_my_file_save";
            public static final String QQ_FILE_TROOP_FILE_LIST = "qq_file_troop_file_list";
            public static final String QQ_INVITATION_WEBVIEW_STAGE = "invitation_webView_plugin_stage";
            public static final String QQ_LIVE_GAME = "qq_live_game";
            public static final String QQ_MINIAPP_SAVA_VIDEO = "save_video_to_album";
            public static final String QQ_ONLINE_STATUS_SMART_STATUS_SCENE = "onlineStatus_smartStatus";
            public static final String QQ_ONLINE_STATUS_WEATHER_SCENE = "onlineStatus_weather";
            public static final String QQ_PC_LOGIN_GOTO_FILE = "qq_pc_login_goto_file";
            public static final String QQ_QAV = "qq_qav";
            public static final String QQ_QAV_SHARE_SCREEN = "qq_share_screen";
            public static final String QQ_QZONE_ALBUM_LOCAL_TAB_SELECT_READ_MEDIA = "qzone_album_local_tab_select_read_media";
            public static final String QQ_QZONE_FACE_SCAN_CAMERA = "qzone_face_scan_camera";
            public static final String QQ_QZONE_FEED_GUIDE_UPLOAD_ALBUM = "qzone_feed_guide_upload_album";
            public static final String QQ_QZONE_HEADER_LOCATION_WIDGET = "qzone_header_location_widget";
            public static final String QQ_QZONE_JS_DOWNLOAD_FILE = "qzone_js_download_file";
            public static final String QQ_QZONE_JS_OPEN_CAMERA = "qzone_js_open_camera";
            public static final String QQ_QZONE_JS_SELECT_PHOTO = "qzone_js_select_photo";
            public static final String QQ_QZONE_PIC_COMMENT_OPEN_MEDIA = "qzone_pic_comment_open_media";
            public static final String QQ_QZONE_PUBLISH_VOICE_MOOD = "qzone_publish_voice_mood";
            public static final String QQ_QZONE_SAVE_MEDIA_TO_ALBUM = "qzone_save_media_to_album";
            public static final String QQ_QZONE_SELECT_LOCATION = "qzone_select_location";
            public static final String QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA = "qzone_shuoshuo_album_open_media";
            public static final String QQ_QZONE_SHUOSHUO_ALBUM_READ_MEDIA = "qzone_shuoshuo_album_read_media";
            public static final String QQ_QZONE_VIDEO_EDIT_READ_MEDIA = "qzone_video_edit_read_media";
            public static final String QQ_STRANGER_FLUTTER_PAGE = "matchfriend_flutter_page";
            public static final String QQ_STRANGER_PARTY_ROOM_AUDIO = "qq_stranger_party_room_audio";
            public static final String QQ_STRANGER_PUBLISH = "qqstranger_publish";
            public static final String QQ_TIMI_GAME_TOGETHER_PLAY = "qq_timi_game_together_play";
            public static final String QQ_TROOP_COMMON = "qq_troop_common";
            public static final String QQ_TROOP_FACE_TO_FACE_CREATE = "qq_troop_face_to_face_create";
            public static final String QQ_TROOP_HOMEWORK = "qq_troop_homework";
            public static final String QQ_TROOP_HOMEWORK_CLOCK = "qq_troop_homework_clock";
            public static final String QQ_TROOP_HOMEWORK_NOTICE = "qq_troop_homework_notice";
            public static final String QQ_TROOP_HOMEWORK_NOTICE_RECORD_AUDIO = "qq_troop_homework_notice_record_audio";
            public static final String QQ_TROOP_HOMEWORK_RECORD_AUDIO = "qq_troop_homework_record_audio";
            public static final String QQ_TROOP_INFO = "qq_troop_info";
            public static final String QQ_TROOP_INVITE_TEAM = "qq_troop_invite_team";
            public static final String QQ_TROOP_PHOTO = "qq_troop_photo";
            public static final String QQ_VIP = "qq_vip";
            public static final String QQ_ZPLAN_LIGHTAI_CAPTURE = "zplan_lightai_capture";
            public static final String QQ_ZPLAN_LIGHTAI_INTRODUCTION = "zplan_lightai_introduction";
            public static final String QR_DISPLAY = "qr_display";
            public static final String QWALLET_ID_VERIFY_LOCATION = "qwallet_id_verify_location";
            public static final String QWALLET_JS_BRIDGE_GET_CONTACTS = "qwallet_js_bridge_get_contacts";
            public static final String QWALLET_SAVE_HB_CODE = "qwallet_save_hb_code";
            public static final String QWALLET_SAVE_PAY_CODE = "qwallet_save_pay_code";
            public static final String QWALLET_START_VOICE_RECORD = "qwallet_start_voice_record";
            public static final String READ_AND_WRITE_CALENDAR = "read_and_write_calendar";
            public static final String READ_EXTERNAL_STORAGE = "read_external_storage";
            public static final String RECORD_AUDIO = "record_audio";
            public static final String REFRESH_RECOMMEND_LIST = "refresh_recommend_list";
            public static final String RICH_MEDIA_AIO_CAMERA = "rich_media_aio_camera";
            public static final String RICH_MEDIA_AIO_RECORD_AUDIO_PANEL = "rich_media_aio_record_audio_panel";
            public static final String RICH_MEDIA_AIO_SAVE_PIC = "rich_media_aio_save_pic";
            public static final String RICH_MEDIA_AIO_SAVE_VIDEO = "rich_media_aio_save_video";
            public static final String RICH_MEDIA_BLUETOOTH_CONNECT = "rich_media_bluetooth_connect";
            public static final String RICH_MEDIA_COMMON_RECORD_AUDIO = "rich_media_common_record_audio";
            public static final String RICH_MEDIA_EDIT_PHOTO = "rich_media_edit_photo";
            public static final String RICH_MEDIA_EDIT_VIDEO = "rich_media_edit_video";
            public static final String SAVE_PIC_TO_ALBUM = "save_to_album";
            public static final String SAVE_QR_PIC = "save_qr_pic";
            public static final String SAVE_SCREENSHOT = "save_scrrenshot";
            public static final String SCENE_BIG_SEARCH = "qq_network_search";
            public static final String SEND_SOGOU_EMOJI = "send_sogou_emoji";
            public static final String SHARE_LOCATION = "share_location";
            public static final String SHARE_PICK_LOCATION = "pick_location";
            public static final String SHARE_SAVE_PIC = "share_save_pic";
            public static final String START_LOC_SELECTION = "start_loc_selection";
            public static final String TAKE_PHOTO_USE_SAME_STYLE = "take_photo_use_same_style";
            public static final String TAKE_VIDEO_USE_SAME_STYLE = "take_video_use_same_style";
            public static final String TBS_TOOL = "tbs_tool";
            public static final String TENCENT_DOCS_INPUT_VOICE = "tencent_docs_input_voice";
            public static final String TENCENT_DOCS_USE_CAMERA = "tencent_docs_use_camera";
            public static final String TEST = "scene_test";
            public static final String VIDEO_EDITOR_SAVE_PIC = "video_editor_save_pic";
            public static final String VOICE_ASSISTANT_SETTING_SWITCH = "voice_assistant_setting_switch";
            public static final String WEATHER_H5 = "weather_h5";
            public static final String WEATHER_WEEK = "weather_week";
            public static final String WEBVIEW_LOCATION = "qq_webview_location";
            public static final String WEBVIEW_MEDIA = "qq_webview_media";
            public static final String WEBVIEW_SENSOR = "qq_webview_sensor";
            public static final String WEBVIEW_USERMEDIA = "qq_webview_usermedia";
            public static final String ZPLAN_AUDIO_CALL = "zplan_audio_call";
            public static final String ZPLAN_DETAIL_GALLERY = "zplan_detail_gallery";
            public static final String ZPLAN_GAME = "zplan_game";
            public static final String ZPLAN_PET_SAVE_PIC = "pet_photo_share_save_pic";
            public static final String ZPLAN_SHARE = "zplan_share";

            public SCENE() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31937);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                PERMISSION_SCENE_INTRODUCE = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.qqpermission.QQPermissionConstants.Business.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_BIG_SEARCH, SCENE.SCENE_BIG_SEARCH, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f201524v1));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP, SCENE.QQ_TROOP_INFO, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16302220));
                        put(PermissionUtil.getHashKey(ID.QQ_ZPLAN, SCENE.VIDEO_EDITOR_SAVE_PIC, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zi7));
                        put(PermissionUtil.getHashKey(ID.QQ_ASSISTANT, SCENE.ASSISTANT_GUIDER, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z79));
                        put(PermissionUtil.getHashKey(ID.QQ_ONLINE_STATUS_WEATHER_ID, SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1629721v));
                        put(PermissionUtil.getHashKey(ID.QQ_RICH_MEDIA_EDIT_PHOTO, SCENE.RICH_MEDIA_EDIT_PHOTO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229086vh));
                        put(PermissionUtil.getHashKey(ID.QQ_RICH_MEDIA_EDIT_VIDEO, SCENE.RICH_MEDIA_EDIT_VIDEO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229096vi));
                        put(PermissionUtil.getHashKey(ID.QQ_RICH_MEDIA, SCENE.RICH_MEDIA_BLUETOOTH_CONNECT, Permission.BLUE_TOOTH_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.zfi));
                        put(PermissionUtil.getHashKey(ID.QQ_EMOTICON, SCENE.EMOTICON_FAV_COLLECTION, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228716uh));
                        put(PermissionUtil.getHashKey(ID.QQ_ARK, SCENE.ARK_GET_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1630121z));
                        put(PermissionUtil.getHashKey(ID.QQ_AIO_CAMERA, SCENE.TAKE_VIDEO_USE_SAME_STYLE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229176vq));
                        put(PermissionUtil.getHashKey(ID.QQ_AIO_CAMERA, SCENE.TAKE_PHOTO_USE_SAME_STYLE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229166vp));
                        put(PermissionUtil.getHashKey(ID.QQ_LOCATION, SCENE.SHARE_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633322u));
                        put(PermissionUtil.getHashKey(ID.QQ_LOCATION, SCENE.SHARE_PICK_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633222t));
                        put(PermissionUtil.getHashKey(ID.QQ_MAP, SCENE.MAP_SHOW_ENTRY, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633422v));
                        put(PermissionUtil.getHashKey(ID.QQ_QAV, SCENE.QQ_QAV, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhx));
                        put(PermissionUtil.getHashKey(ID.QQ_QAV, SCENE.QQ_QAV, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7m));
                        put(PermissionUtil.getHashKey(ID.QQ_QAV, SCENE.QQ_QAV_SHARE_SCREEN, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7n));
                        put(PermissionUtil.getHashKey(ID.QQ_QAV, SCENE.QQ_QAV, Permission.BLUE_TOOTH_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.zfj));
                        put(PermissionUtil.getHashKey(ID.QQ_RICH_MEDIA_RECORD_AUDIO, SCENE.RICH_MEDIA_AIO_RECORD_AUDIO_PANEL, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7h));
                        put(PermissionUtil.getHashKey(ID.QQ_AIO_ALBUM, SCENE.OPEN_AIO_ALBUM, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229146vn));
                        put(PermissionUtil.getHashKey(ID.SOGOU_EMOJI, SCENE.SEND_SOGOU_EMOJI, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229366w9));
                        put(PermissionUtil.getHashKey(ID.QQ_RICH_MEDIA_SAVE, SCENE.RICH_MEDIA_AIO_SAVE_PIC, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229106vj));
                        put(PermissionUtil.getHashKey(ID.QQ_RICH_MEDIA_SAVE, SCENE.RICH_MEDIA_AIO_SAVE_VIDEO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229116vk));
                        put(PermissionUtil.getHashKey(ID.QQ_ALBUM, SCENE.OPEN_ALBUM, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229196vs));
                        put(PermissionUtil.getHashKey(ID.QQ_VOICE_ASSISTANT, SCENE.VOICE_ASSISTANT_SETTING_SWITCH, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7r));
                        put(PermissionUtil.getHashKey(ID.QQ_AIO_CAMERA, SCENE.AIO_PANEL_TAKE_PHOTO, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhp));
                        put(PermissionUtil.getHashKey(ID.QQ_SCREENSHOT, SCENE.SAVE_SCREENSHOT, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228526tz));
                        put(PermissionUtil.getHashKey(ID.QQ_SHARE, SCENE.SHARE_SAVE_PIC, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229356w8));
                        put(PermissionUtil.getHashKey(ID.QLINK, SCENE.QLINK_SEND, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633822z));
                        put(PermissionUtil.getHashKey(ID.QLINK, SCENE.QLINK_RECV, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhz));
                        put(PermissionUtil.getHashKey(ID.QLINK, "qlink", Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229276w0));
                        put(PermissionUtil.getHashKey(ID.QLINK, "qlink", "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633722y));
                        put(PermissionUtil.getHashKey(ID.QLINK, "qlink", Permission.BLUE_TOOTH_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.zfk));
                        put(PermissionUtil.getHashKey(ID.TBS_TOOL, SCENE.TBS_TOOL, Permission.READ_EXTERNAL_STORAGE), Integer.valueOf(com.tencent.mobileqq.R.string.f230546zf));
                        put(PermissionUtil.getHashKey(ID.DATALINE, "dataline", Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229226vv));
                        put(PermissionUtil.getHashKey(ID.DATALINE, "dataline", "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zht));
                        put(PermissionUtil.getHashKey(ID.DATALINE, SCENE.DATALINE_EXPORT_PHOTO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229236vw));
                        put(PermissionUtil.getHashKey(ID.QQ_FILE, SCENE.QQ_FILE_MY_FILE_LOCAL_FILE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229306w3));
                        put(PermissionUtil.getHashKey(ID.QQ_FILE, SCENE.QQ_FILE_MY_FILE_SAVE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229316w4));
                        put(PermissionUtil.getHashKey(ID.QQ_FILE, SCENE.QQ_FILE_AIO_FILE_PANEL, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229296w2));
                        put(PermissionUtil.getHashKey(ID.QQ_FILE, SCENE.QQ_FILE_TROOP_FILE_LIST, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229326w5));
                        put(PermissionUtil.getHashKey(ID.QQ_CHANNEL_AUDIO, SCENE.ENTER_AUDIO_ROOM, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7a));
                        put(PermissionUtil.getHashKey(ID.QQ_CHANNEL_MAINFRAME, SCENE.QQCHANEL_PROFILE_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1629821w));
                        put(PermissionUtil.getHashKey(ID.QQ_CHANNEL_MAINFRAME, SCENE.QQCHANEL_AVATAR_EDIT_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zh8));
                        put(PermissionUtil.getHashKey(ID.QQ_CHANNEL_MAINFRAME, SCENE.QQCHANEL_AVATAR_SAVE_ALBUM, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228496tw));
                        put(PermissionUtil.getHashKey(ID.QQ_CHANNEL_FEED, SCENE.CHANNEL_FEED_SHARE_SAVE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228936v3));
                        put(PermissionUtil.getHashKey(ID.QQ_CHANNEL_LIVE, SCENE.ENTER_AUDIO_ROOM, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhj));
                        put(PermissionUtil.getHashKey(ID.QQ_CHANNEL_MAINFRAME, SCENE.QQCHANEL_QRCODE_SAVE_ALBUM, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228506tx));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP, SCENE.QQ_TROOP_PHOTO, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.f170670zi4));
                        put(PermissionUtil.getHashKey(ID.FACE_IDENTIFICATION, SCENE.FACE_IDENTIFICATION_GUIDE, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zh6));
                        put(PermissionUtil.getHashKey(ID.FACE_IDENTIFICATION, SCENE.FACE_IDENTIFICATION_JSAPI, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zh5));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.PROFILE_CARD_EDIT_GET_CURRENT_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16304222));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.PROFILE_CARD_EDIT_TAKE_AVATAR_PHOTO, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zha));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.PROFILE_CARD_EDIT_PICK_AVATAR_PHOTO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228556u2));
                        put(PermissionUtil.getHashKey(ID.QQ_QWALLET, SCENE.QWALLET_SAVE_PAY_CODE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229346w7));
                        put(PermissionUtil.getHashKey(ID.QQ_QWALLET, SCENE.QWALLET_SAVE_HB_CODE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229336w6));
                        put(PermissionUtil.getHashKey(ID.QQ_OPENSDK_AUTH, SCENE.OPENSDK_CREATE_VIRTUAL_ACCOUNT, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhi));
                        put(PermissionUtil.getHashKey(ID.QQ_QWALLET, SCENE.QWALLET_START_VOICE_RECORD, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7q));
                        put(PermissionUtil.getHashKey(ID.GY_FLASH_SHOW_UNIT, SCENE.GY_FLASH_SHOW_UNIT, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zh7));
                        put(PermissionUtil.getHashKey(ID.GY_FLASH_SHOW_UNIT, SCENE.GY_FLASH_SHOW_UNIT, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1629621u));
                        put(PermissionUtil.getHashKey(ID.GY_FLASH_SHOW_UNIT, SCENE.GY_FLASH_SHOW_UNIT, Permission.FINAL_LOCATION_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f1629621u));
                        put(PermissionUtil.getHashKey(ID.QQ_RICH_MEDIA_CAMERA, SCENE.RICH_MEDIA_AIO_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.yt9));
                        put(PermissionUtil.getHashKey(ID.QQ_WEATHER, SCENE.DRAWER_WEATHER, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16342233));
                        put(PermissionUtil.getHashKey(ID.QQ_WEATHER, SCENE.WEATHER_H5, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16343234));
                        put(PermissionUtil.getHashKey(ID.QQ_WEATHER, SCENE.WEATHER_WEEK, Permission.CALENDAR_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f170658zh3));
                        put(PermissionUtil.getHashKey(ID.QQ_NEARBY, SCENE.NEARBY_ENTER_HOME_PAGE, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1631922g));
                        put(PermissionUtil.getHashKey(ID.QQ_NEARBY, SCENE.NEARBY_PUBLISH_MOMENT, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhg));
                        put(PermissionUtil.getHashKey(ID.QQ_STRANGER, SCENE.QQ_STRANGER_FLUTTER_PAGE, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7m));
                        put(PermissionUtil.getHashKey(ID.QQ_STRANGER, SCENE.QQ_STRANGER_FLUTTER_PAGE, Permission.BLUE_TOOTH_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f201534v2));
                        put(PermissionUtil.getHashKey(ID.QQ_STRANGER, SCENE.QQ_STRANGER_PUBLISH, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228966v6));
                        put(PermissionUtil.getHashKey(ID.QQ_PHONECONTACT, SCENE.PHONECONTACT_OPEN_PAGE, "contacts"), Integer.valueOf(com.tencent.mobileqq.R.string.znv));
                        put(PermissionUtil.getHashKey(ID.QQ_CIRCLE_PUBLISH, SCENE.CIRCLE_PUBLISH_PICKER, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228946v4));
                        put(PermissionUtil.getHashKey(ID.QQ_CIRCLE_PUBLISH, SCENE.CIRCLE_PUBLISH_UPLOAD, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632522m));
                        put(PermissionUtil.getHashKey(ID.QQ_LIVE, SCENE.QQ_LIVE_GAME, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhl));
                        put(PermissionUtil.getHashKey(ID.QQ_LIVE, SCENE.QQ_LIVE_GAME, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7b));
                        put(PermissionUtil.getHashKey(ID.QQ_LIVE, SCENE.QQ_LIVE_GAME, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7b));
                        put(PermissionUtil.getHashKey(ID.QQ_LIVE, SCENE.QQ_TIMI_GAME_TOGETHER_PLAY, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.z7c));
                        put(PermissionUtil.getHashKey(ID.QQ_LIVE, SCENE.QQ_LIVE_GAME, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228956v5));
                        put(PermissionUtil.getHashKey(ID.QQ_CIRCLE_PUBLISH, SCENE.CIRCLE_PUBLISH_PICKER, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhk));
                        put(PermissionUtil.getHashKey(ID.QQ_PUBLIC_ACCOUNT, SCENE.JS_BRIDGE_GET_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633622x));
                        put(PermissionUtil.getHashKey(ID.QQ_PUBLIC_ACCOUNT, SCENE.JS_BRIDGE_GET_LOCATION, Permission.FINAL_LOCATION_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f1633622x));
                        put(PermissionUtil.getHashKey(ID.TENCENT_DOCS_VOICE, SCENE.TENCENT_DOCS_INPUT_VOICE, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z6o));
                        put(PermissionUtil.getHashKey(ID.TENCENT_DOCS_CAMERA, SCENE.TENCENT_DOCS_USE_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.f170663zh4));
                        put(PermissionUtil.getHashKey(ID.QQ_PUBLIC_MINI_PERMISSION_READ_EXTERNAL_STORAGE, SCENE.READ_EXTERNAL_STORAGE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228776un));
                        put(PermissionUtil.getHashKey(ID.QQ_ZPLAN_LIGHTAI, SCENE.QQ_ZPLAN_LIGHTAI_CAPTURE, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zi5));
                        put(PermissionUtil.getHashKey(ID.QQ_ZPLAN_LIGHTAI, SCENE.QQ_ZPLAN_LIGHTAI_CAPTURE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229436wf));
                        put(PermissionUtil.getHashKey(ID.QQ_ZPLAN_LIGHTAI, SCENE.QQ_ZPLAN_LIGHTAI_INTRODUCTION, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zi6));
                        put(PermissionUtil.getHashKey(ID.ZPLAN_SHARE, SCENE.ZPLAN_SHARE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229456wh));
                        put(PermissionUtil.getHashKey(ID.ZPLAN_GAME, SCENE.ZPLAN_GAME, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7y));
                        put(PermissionUtil.getHashKey(ID.ZPLAN_GAME, SCENE.ZPLAN_AUDIO_CALL, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7y));
                        put(PermissionUtil.getHashKey(ID.ZPLAN_DETAIL, SCENE.ZPLAN_DETAIL_GALLERY, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229446wg));
                        put(PermissionUtil.getHashKey(ID.KANDIAN_PUBLISHER, SCENE.OPEN_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhv));
                        put(PermissionUtil.getHashKey(ID.KANDIAN_PUBLISHER, SCENE.SHARE_PICK_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633122s));
                        put(PermissionUtil.getHashKey(ID.KANDIAN_PUBLISHER, SCENE.KANDIAN_PUBLISHER_H5, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhu));
                        put(PermissionUtil.getHashKey(ID.QQ_HEALTH, SCENE.HEALTH_COMMUNITY, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhm));
                        put(PermissionUtil.getHashKey(ID.QQ_HEALTH, SCENE.HEALTH_COMMUNITY, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632722o));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_APP, SCENE.QQ_TROOP_HOMEWORK, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.f170666zi0));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_APP, SCENE.QQ_TROOP_HOMEWORK, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229376w_));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_APP, SCENE.QQ_TROOP_HOMEWORK_NOTICE, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.f170668zi2));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_APP, SCENE.QQ_TROOP_HOMEWORK_NOTICE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229396wb));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_APP, SCENE.QQ_TROOP_INVITE_TEAM, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.f170669zi3));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_APP, SCENE.QQ_TROOP_INVITE_TEAM, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229406wc));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_APP, SCENE.QQ_TROOP_HOMEWORK_CLOCK, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.f170667zi1));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_APP, SCENE.QQ_TROOP_HOMEWORK_CLOCK, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229386wa));
                        put(PermissionUtil.getHashKey(ID.QQ_AVGAME, SCENE.AVGAME_ENTER_AUDIO_ROOM, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7l));
                        put(PermissionUtil.getHashKey(ID.QQ_AVGAME, SCENE.AVGAME_OPEN_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhs));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP, SCENE.QQ_TROOP_FACE_TO_FACE_CREATE, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16340231));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.PROFILE_CARD_EDIT_PICK_COVER_PHOTO, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zh_));
                        put(PermissionUtil.getHashKey(ID.QQ_FAV, SCENE.QFAV_SAVE_FAV, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229266vz));
                        put(PermissionUtil.getHashKey(ID.QQ_FAV, SCENE.QFAV_EDIT_PANEL_AUDIO, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7p));
                        put(PermissionUtil.getHashKey(ID.QQ_FAV, SCENE.QFAV_EDIT_TAKE_PHOTO, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhy));
                        put(PermissionUtil.getHashKey(ID.QQ_WEBVIEW, SCENE.WEBVIEW_SENSOR, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7w));
                        put(PermissionUtil.getHashKey(ID.QQ_QR_DISPLAY, SCENE.QR_DISPLAY, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228986v8));
                        put(PermissionUtil.getHashKey(ID.QQ_NEW_GUIDE, SCENE.NEW_GUIDE_SET_AVATAR, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhh));
                        put(PermissionUtil.getHashKey(ID.QQ_NEW_GUIDE, SCENE.NEW_GUIDE_GET_UP_LOAD_CONTACTS, "contacts"), Integer.valueOf(com.tencent.mobileqq.R.string.znu));
                        put(PermissionUtil.getHashKey(ID.QQ_NEW_GUIDE, SCENE.NEW_GUIDE_GET_RECOMMEND, "contacts"), Integer.valueOf(com.tencent.mobileqq.R.string.znt));
                        put(PermissionUtil.getHashKey(ID.QQ_WEBVIEW, SCENE.WEBVIEW_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16344235));
                        put(PermissionUtil.getHashKey(ID.QQ_WEBVIEW, SCENE.WEBVIEW_USERMEDIA, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7x));
                        put(PermissionUtil.getHashKey(ID.QQ_WEBVIEW, SCENE.WEBVIEW_USERMEDIA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zi9));
                        put(PermissionUtil.getHashKey(ID.QQ_SCAN_AR, SCENE.AR_SCAN_CLOUD_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632822p));
                        put(PermissionUtil.getHashKey(ID.QQ_SCAN_AR, SCENE.AR_SCAN_VIDEO_RECORD, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7i));
                        put(PermissionUtil.getHashKey(ID.QQ_SCAN_AR, SCENE.AR_SCAN_VIDEO_RECORD, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229126vl));
                        put(PermissionUtil.getHashKey(ID.QQ_AV, SCENE.QQ_AV_ROOM, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhr));
                        put(PermissionUtil.getHashKey(ID.QQ_AV, SCENE.QQ_AV_ROOM, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7k));
                        put(PermissionUtil.getHashKey(ID.QQ_AV, SCENE.QQ_AV_ROOM, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229206vt));
                        put(PermissionUtil.getHashKey(ID.QQ_AV, SCENE.QQ_AV_AVATAR_2D, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhq));
                        put(PermissionUtil.getHashKey(ID.QQ_AV, SCENE.QQ_AV_ROOM, Permission.BLUE_TOOTH_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f201534v2));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_SELECT_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16341232));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_PUBLISH_VOICE_MOOD, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.z7s));
                        put(PermissionUtil.getHashKey(ID.QQ_SCREENSHOT, SCENE.SAVE_SCREENSHOT, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228516ty));
                        put(PermissionUtil.getHashKey(ID.QQ_FRIEND_PROFILE_IMAGE, SCENE.FRIEND_FPROFILE_IMAGE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228746uk));
                        put(PermissionUtil.getHashKey(ID.QQ_ADD_CONTACT_TROOP, SCENE.ADD_CONTACT_TROOP_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1629921x));
                        put(PermissionUtil.getHashKey(ID.QQ_CONTACT_LOCATION, SCENE.REFRESH_RECOMMEND_LIST, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633022r));
                        put(PermissionUtil.getHashKey(ID.QQ_FACE_2_FACE_ADD_CONTACT_LOCATION, SCENE.FACE_2_FACE_ADD_CONTACT, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632922q));
                        put(PermissionUtil.getHashKey(ID.QQ_AIO_STORAGE, SCENE.AIO_SAVE_PIC, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229186vr));
                        put(PermissionUtil.getHashKey(ID.QQ_PUBLIC_ACCOUNT, SCENE.CHAT_PIE_GET_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1633522w));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.AVATAR_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhb));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.AVATAR_PTOTO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228566u3));
                        put(PermissionUtil.getHashKey(ID.QQ_PROFILE_CARD_CONTACT, SCENE.COMPANY_QQ_ADD_CONTACT, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.znw));
                        put(PermissionUtil.getHashKey(ID.QQ_SCAN_OCR, SCENE.OCR_SCAN_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zho));
                        put(PermissionUtil.getHashKey(ID.QQ_QWALLET, SCENE.QWALLET_JS_BRIDGE_GET_CONTACTS, "contacts"), Integer.valueOf(com.tencent.mobileqq.R.string.znx));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.COVER, "contacts"), Integer.valueOf(com.tencent.mobileqq.R.string.zhd));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.CARD_CAMERA, "contacts"), Integer.valueOf(com.tencent.mobileqq.R.string.zhc));
                        put(PermissionUtil.getHashKey(ID.QQ_LABEL_SHARE_STORAGE, SCENE.SAVE_QR_PIC, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229256vy));
                        put(PermissionUtil.getHashKey(ID.QQ_SIGN_TEXT_EDIT_LOCATION, SCENE.START_LOC_SELECTION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16339230));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP_COMMON_COMPONENT, SCENE.QQ_TROOP_COMMON, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229416wd));
                        put(PermissionUtil.getHashKey(ID.QQ_TROOP, SCENE.QQ_TROOP_PHOTO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229426we));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.BUSINESS_CARD_GET_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16303221));
                        put(PermissionUtil.getHashKey(ID.QQ_CONDITION_SEARCH, SCENE.CONDITION_SEARCH_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16305223));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.BUSINESS_CARD_PHOTO, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zh9));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_CARD, SCENE.BUSINESS_CARD_PHOTO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228546u1));
                        put(PermissionUtil.getHashKey(ID.QQ_OLYMPIC_TORCH, SCENE.QQ_AR_OLYMPIC_TORCH, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhw));
                        put(PermissionUtil.getHashKey(ID.QQ_WEBVIEW, SCENE.WEBVIEW_MEDIA, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.zi8));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.QCIRCLE_PUBLISH_FEED, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228886uy));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.QCIRCLE_MATERIAL_GUILD, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228876ux));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.QCIRCLE_NEARBY, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632222j));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.QCIRCLE_FACE_TO_FACE_FOLLOW, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632022h));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.QCIRCLE_MIX_FEED, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632122i));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.QCIRCLE_FEED_READ_CONTACT, "contacts"), Integer.valueOf(com.tencent.mobileqq.R.string.znq));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.QCIRCLE_QSTORE_PACK_ADDRESS_INPUT, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632322k));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.QCIRCLE_SHARE_SAVE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228896uz));
                        put(PermissionUtil.getHashKey(ID.QQ_QCIRCLE, SCENE.CIRCLE_EDITOR_WATERMARK, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f1632422l));
                        put(PermissionUtil.getHashKey(ID.QQ_AIO_CAMERA, SCENE.OPEN_AIO_MINI_PHOTO_SELECTOR, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229156vo));
                        put(PermissionUtil.getHashKey(ID.KANDIAN_PUBLISHER, SCENE.KANDIAN_SHARE_SAVE_IMAGE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229246vx));
                        put(PermissionUtil.getHashKey(ID.QQ_PC_LOGIN, SCENE.QQ_PC_LOGIN_GOTO_FILE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228846uu));
                        put(PermissionUtil.getHashKey(ID.QQ_MINIAPP_SAVE, SCENE.QQ_MINIAPP_SAVA_VIDEO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228796up));
                        put(PermissionUtil.getHashKey(ID.QQ_AVGAME, SCENE.AVGAME_DOWNLOAD_RESULT, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229216vu));
                        put(PermissionUtil.getHashKey(ID.QQ_FILE, SCENE.QQ_FILE_AIO_FILE_DOWNLOAD, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229286w1));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_PIC_COMMENT_OPEN_MEDIA, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229036vc));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_JS_OPEN_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhn));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_JS_OPEN_CAMERA, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229016va));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_JS_DOWNLOAD_FILE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229006v_));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_JS_SELECT_PHOTO, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229026vb));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_ALBUM_LOCAL_TAB_SELECT_READ_MEDIA, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228996v9));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229056ve));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_SHUOSHUO_ALBUM_READ_MEDIA, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229066vf));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229046vd));
                        put(PermissionUtil.getHashKey(ID.ZPLAN_PET_SHARE, SCENE.ZPLAN_PET_SAVE_PIC, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f243007w4));
                        put(PermissionUtil.getHashKey(ID.QQ_QZONE, SCENE.QQ_QZONE_VIDEO_EDIT_READ_MEDIA, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f229076vg));
                        put(PermissionUtil.getHashKey(ID.QQ_MINIAPP_SAVE, SCENE.MINIBOX_APP_WRITE_EXTERNAL, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228786uo));
                        put(PermissionUtil.getHashKey(ID.QQ_PUBLIC_MINI_PERMISSION_READ_EXTERNAL_STORAGE, SCENE.MINIBOX_APP_READ_EXTERNAL, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228766um));
                        put(PermissionUtil.getHashKey(ID.QQ_MINIAPP_MYSITE, SCENE.MINIBOX_APP_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16308226));
                        put(PermissionUtil.getHashKey(ID.QQ_PUBLIC_MINI_PERMISSION_CAMERA, SCENE.MINIBOX_APP_CAMERA, "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhe));
                        put(PermissionUtil.getHashKey(ID.QQ_PUBLIC_MINI_PERMISSION_RECORD_AUDIO, SCENE.MINIBOX_APP_RECORD_AUDIO, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f170481z72));
                        put(PermissionUtil.getHashKey(ID.QQ_STRANGER_PARTY_ROOM, SCENE.QQ_STRANGER_PARTY_ROOM_AUDIO, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.z7_));
                        put(PermissionUtil.getHashKey(ID.QQ_GAME_CENTER_CALENDAR, SCENE.GAME_CENTER_CALENDAR_REMIND, Permission.CALENDAR_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.zgz));
                        put(PermissionUtil.getHashKey(ID.QQ_GAME_CENTER_VOICE, SCENE.GAME_CENTER_YUNGAME_VOICE, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f170479z71));
                        put(PermissionUtil.getHashKey(ID.QQ_REMINDER, SCENE.READ_AND_WRITE_CALENDAR, Permission.AUIDO_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f170656zh1));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_GAME_CENTER, SCENE.GAME_CENTER_SCENE, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228756ul));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_FLOCK, SCENE.FLOCK_SAVE_MEDIA_TO_ALBUM, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228736uj));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_FLOCK, SCENE.FLOCK_GET_LOCATION, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16306224));
                        put(PermissionUtil.getHashKey(ID.QQ_BUSINESS_FLOCK, SCENE.FLOCK_MEDIA_PICKER, Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228726ui));
                    }
                };
            }
        }

        public Business() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes17.dex */
    public static final class Module {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final Map<String, Integer> f274294a;

        /* renamed from: b, reason: collision with root package name */
        public static final Map<String, Integer> f274295b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31949);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f274294a = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.qqpermission.QQPermissionConstants.Module.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        put(Business.ID.TEST, Integer.valueOf(com.tencent.mobileqq.R.string.f202494xn));
                        put("facetoface_biz_src_sq_qlink", Integer.valueOf(com.tencent.mobileqq.R.string.f202444xi));
                        put("biz_src_qqweather", Integer.valueOf(com.tencent.mobileqq.R.string.f202474xl));
                        put("biz_src_qqsport", Integer.valueOf(com.tencent.mobileqq.R.string.f202464xk));
                        put("qq_big_search", Integer.valueOf(com.tencent.mobileqq.R.string.f202454xj));
                        put(Business.SCENE.TBS_TOOL, Integer.valueOf(com.tencent.mobileqq.R.string.f202484xm));
                    }
                };
                f274295b = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.qqpermission.QQPermissionConstants.Module.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        put(PermissionUtil.getHashKey(Business.ID.TEST, "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16310228));
                        put(PermissionUtil.getHashKey("facetoface_biz_src_sq_qlink", "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16309227));
                        put(PermissionUtil.getHashKey("facetoface_biz_src_sq_qlink", "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhf));
                        put(PermissionUtil.getHashKey("facetoface_biz_src_sq_qlink", Permission.STORAGE_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f228806uq));
                        put(PermissionUtil.getHashKey("biz_src_qqweather", "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f16342233));
                        put(PermissionUtil.getHashKey("biz_src_qqweather", Permission.CALENDAR_GROUP), Integer.valueOf(com.tencent.mobileqq.R.string.f170658zh3));
                        put(PermissionUtil.getHashKey("biz_src_qqsport", "camera"), Integer.valueOf(com.tencent.mobileqq.R.string.zhm));
                        put(PermissionUtil.getHashKey("biz_src_qqsport", "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f1632722o));
                        put(PermissionUtil.getHashKey("biz_src_qqsport", Permission.ACTIVITY_RECOGNITION), Integer.valueOf(com.tencent.mobileqq.R.string.f201554v4));
                        put(PermissionUtil.getHashKey("qq_big_search", "location"), Integer.valueOf(com.tencent.mobileqq.R.string.f201524v1));
                        put(PermissionUtil.getHashKey(Business.SCENE.TBS_TOOL, Permission.READ_EXTERNAL_STORAGE), Integer.valueOf(com.tencent.mobileqq.R.string.f230546zf));
                    }
                };
            }
        }
    }

    /* loaded from: classes17.dex */
    public static final class Permission {
        static IPatchRedirector $redirector_ = null;
        public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
        public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
        public static final String ACCESS_MEDIA_LOCATION = "android.permission.ACCESS_MEDIA_LOCATION";
        public static final String ACTIVITY_RECOGNITION = "android.permission.ACTIVITY_RECOGNITION";
        public static final String ACTIVITY_RECOGNITION_GROUP = "activity_recognition";
        public static final String AUIDO_GROUP = "record";
        public static final String BLUETOOTH_ADVERTISE = "android.permission.BLUETOOTH_ADVERTISE";
        public static final String BLUETOOTH_CONNECT = "android.permission.BLUETOOTH_CONNECT";
        public static final String BLUETOOTH_SCAN = "android.permission.BLUETOOTH_SCAN";
        public static final String BLUE_TOOTH_GROUP = "bluetooth";
        public static final String CALENDAR_GROUP = "calendar";
        public static final String CALL_PHONE = "android.permission.CALL_PHONE";
        public static final String CAMERA = "android.permission.CAMERA";
        public static final String CAMERA_GROUP = "camera";
        public static final String CONTACTS_GROUP = "contacts";
        public static final String FINAL_LOCATION_GROUP = "final_location";
        public static final String GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
        public static final String GET_INSTALLED_APPS = "com.android.permission.GET_INSTALLED_APPS";
        public static final String GET_INSTALLED_APPS_GROUP = "installed_apps";
        public static final String[] GROUP_BLUETOOTH;
        public static final String[] GROUP_LOCATION;
        public static final String[] GROUP_STORAGE;
        public static final String LOCATION_GROUP = "location";
        public static final Map<String, String> PERMISSION_GROUP;
        public static final Map<String, Integer> PERMISSION_INTRODUCE;
        public static final String PERMISSION_NOTIFICATION = "qq.permission.notification";
        public static final Map<String, Integer> PERMISSION_TITLE;
        public static final Map<String, String> PMONITOR_PERMISSION_GROUP;
        public static final String READ_CONTACTS = "android.permission.READ_CONTACTS";
        public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
        public static final String READ_SMS = "android.permission.READ_SMS";
        public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
        public static final String SEND_SMS = "android.permission.SEND_SMS";
        public static final String STORAGE_GROUP = "storage";
        public static final String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
        public static final String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";
        public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31962);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            GROUP_LOCATION = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
            GROUP_STORAGE = new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};
            GROUP_BLUETOOTH = new String[]{BLUETOOTH_SCAN, BLUETOOTH_ADVERTISE, BLUETOOTH_CONNECT};
            PERMISSION_GROUP = new HashMap<String, String>() { // from class: com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put("android.permission.ACCESS_COARSE_LOCATION", "location");
                    if (AppSetting.m() >= 31) {
                        put("android.permission.ACCESS_FINE_LOCATION", Permission.FINAL_LOCATION_GROUP);
                    } else {
                        put("android.permission.ACCESS_FINE_LOCATION", "location");
                    }
                    put(Permission.READ_CONTACTS, "contacts");
                    put(Permission.WRITE_CONTACTS, "contacts");
                    put(Permission.READ_EXTERNAL_STORAGE, Permission.STORAGE_GROUP);
                    put(Permission.WRITE_EXTERNAL_STORAGE, Permission.STORAGE_GROUP);
                    put(Permission.CAMERA, "camera");
                    put(Permission.RECORD_AUDIO, Permission.AUIDO_GROUP);
                    put(Permission.ACTIVITY_RECOGNITION, Permission.ACTIVITY_RECOGNITION_GROUP);
                    put(Permission.WRITE_CALENDAR, Permission.CALENDAR_GROUP);
                    put(Permission.GET_INSTALLED_APPS, Permission.GET_INSTALLED_APPS_GROUP);
                    put(Permission.BLUETOOTH_SCAN, Permission.BLUE_TOOTH_GROUP);
                    put(Permission.BLUETOOTH_ADVERTISE, Permission.BLUE_TOOTH_GROUP);
                    put(Permission.BLUETOOTH_CONNECT, Permission.BLUE_TOOTH_GROUP);
                }
            };
            PERMISSION_INTRODUCE = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(com.tencent.mobileqq.R.string.f202404xe));
                    put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(com.tencent.mobileqq.R.string.f202404xe));
                    put(Permission.READ_CONTACTS, Integer.valueOf(com.tencent.mobileqq.R.string.f202354x_));
                    put(Permission.WRITE_CONTACTS, Integer.valueOf(com.tencent.mobileqq.R.string.f202354x_));
                    put(Permission.READ_EXTERNAL_STORAGE, Integer.valueOf(com.tencent.mobileqq.R.string.f202914ys));
                    put(Permission.WRITE_EXTERNAL_STORAGE, Integer.valueOf(com.tencent.mobileqq.R.string.f202914ys));
                    put(Permission.CAMERA, Integer.valueOf(com.tencent.mobileqq.R.string.f202334x8));
                    put(Permission.RECORD_AUDIO, Integer.valueOf(com.tencent.mobileqq.R.string.f202424xg));
                    put(Permission.ACTIVITY_RECOGNITION, Integer.valueOf(com.tencent.mobileqq.R.string.f201554v4));
                    put(Permission.WRITE_CALENDAR, Integer.valueOf(com.tencent.mobileqq.R.string.f202314x6));
                    put(Permission.GET_INSTALLED_APPS, Integer.valueOf(com.tencent.mobileqq.R.string.f202384xc));
                    put(Permission.BLUETOOTH_SCAN, Integer.valueOf(com.tencent.mobileqq.R.string.f201534v2));
                    put(Permission.BLUETOOTH_ADVERTISE, Integer.valueOf(com.tencent.mobileqq.R.string.f201534v2));
                    put(Permission.BLUETOOTH_CONNECT, Integer.valueOf(com.tencent.mobileqq.R.string.f201534v2));
                }
            };
            PERMISSION_TITLE = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(com.tencent.mobileqq.R.string.f202414xf));
                    if (AppSetting.m() >= 31) {
                        put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(com.tencent.mobileqq.R.string.f202374xb));
                    } else {
                        put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(com.tencent.mobileqq.R.string.f202414xf));
                    }
                    put(Permission.READ_CONTACTS, Integer.valueOf(com.tencent.mobileqq.R.string.f202364xa));
                    put(Permission.WRITE_CONTACTS, Integer.valueOf(com.tencent.mobileqq.R.string.f202364xa));
                    put(Permission.READ_EXTERNAL_STORAGE, Integer.valueOf(com.tencent.mobileqq.R.string.f202924yt));
                    put(Permission.WRITE_EXTERNAL_STORAGE, Integer.valueOf(com.tencent.mobileqq.R.string.f202924yt));
                    put(Permission.CAMERA, Integer.valueOf(com.tencent.mobileqq.R.string.f202344x9));
                    put(Permission.RECORD_AUDIO, Integer.valueOf(com.tencent.mobileqq.R.string.f202434xh));
                    put(Permission.ACTIVITY_RECOGNITION, Integer.valueOf(com.tencent.mobileqq.R.string.f201564v5));
                    put(Permission.WRITE_CALENDAR, Integer.valueOf(com.tencent.mobileqq.R.string.f201574v6));
                    put(Permission.GET_INSTALLED_APPS, Integer.valueOf(com.tencent.mobileqq.R.string.f202394xd));
                    put(Permission.BLUETOOTH_SCAN, Integer.valueOf(com.tencent.mobileqq.R.string.f201544v3));
                    put(Permission.BLUETOOTH_ADVERTISE, Integer.valueOf(com.tencent.mobileqq.R.string.f201544v3));
                    put(Permission.BLUETOOTH_CONNECT, Integer.valueOf(com.tencent.mobileqq.R.string.f201544v3));
                }
            };
            PMONITOR_PERMISSION_GROUP = new HashMap<String, String>() { // from class: com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put("location", "perm_location");
                    put("contacts", "readContact");
                    put(Permission.STORAGE_GROUP, Permission.STORAGE_GROUP);
                    put("camera", "camera");
                    put(Permission.AUIDO_GROUP, "microphone");
                    put(Permission.ACTIVITY_RECOGNITION_GROUP, "motion");
                    put(Permission.CALENDAR_GROUP, Permission.CALENDAR_GROUP);
                }
            };
        }

        public Permission() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            BUSINESS_MODULE_MAP = new HashMap<String, String>() { // from class: com.tencent.mobileqq.qqpermission.QQPermissionConstants.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put(Business.ID.TEST, Business.ID.TEST);
                    put(Business.ID.QLINK, "facetoface_biz_src_sq_qlink");
                    put(Business.ID.QQ_HEALTH, "biz_src_qqsport");
                    put(Business.ID.QQ_WEATHER, "biz_src_qqweather");
                    put(Business.ID.QQ_BUSINESS_BIG_SEARCH, "qq_big_search");
                    put(Business.ID.TBS_TOOL, Business.SCENE.TBS_TOOL);
                }
            };
        }
    }

    public QQPermissionConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
