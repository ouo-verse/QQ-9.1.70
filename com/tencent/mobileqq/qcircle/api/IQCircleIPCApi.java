package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleIPCApi extends QRouteApi {
    public static final String ACTION_ADD_EXPORT_TASK = "action_add_export_task";
    public static final String ACTION_ADD_PUBLISH_TASK = "action_add_publish_task";
    public static final String ACTION_DOWNLOAD_WINK_NEW_ALBUM_RES = "action_download_wink_new_album_res";
    public static final String ACTION_DOWNLOAD_WINK_NEW_ALBUM_TEXT_RES = "action_download_wink_new_album_text_res";
    public static final String ACTION_FOLLOW_PUBLISH_ACCOUNT = "action_follow_qcircle_server_publish_account";
    public static final String ACTION_GET_AVATAR = "action_get_avatar";
    public static final String ACTION_GET_FRIENDS = "action_get_friends";
    public static final String ACTION_GET_HEAD_BITMAP = "action_get_head_bitmap";
    public static final String ACTION_GET_WINK_NEW_ALBUM_RES = "action_get_wink_new_album_res";
    public static final String ACTION_GET_WINK_NEW_ALBUM_TEXT_RES = "action_get_wink_new_album_text_res";
    public static final String ACTION_OPEN_QCIRCLE_FOR_QZONE = "action_open_qcircle_for_qzone";
    public static final String ACTION_PRELOAD_HIPPY_JS_BUNDLE = "action_preload_hippy_js_bundle";
    public static final String ACTION_READ_GALLERY_RED_POINT_INFO = "action_read_gallery_red_point_info";
    public static final String ACTION_SCHEMA_JUMP_TO_EC_PAGE = "action_schema_jump_to_ec_page";
    public static final String ACTION_SETUP_QCIRCLE_BOTTOM_TAB_MODE = "action_setup_qcircle_bottom_tab_mode";
    public static final String ACTION_SET_WINK_EXPORT_SCENES_FOR_QZONE = "action_set_wink_export_scenes_for_qzone";
    public static final String BUNDLE_KEY_AVATAR_BYTES_DATA = "bundle_key_avatar_bytes_data";
    public static final String BUNDLE_KEY_AVATAR_REQUEST = "bundle_key_avatar_request";
    public static final String BUNDLE_KEY_AVATAR_RESPONSE = "bundle_key_avatar_response";
    public static final String BUNDLE_KEY_HIPPY_JS_BUNDLE_NAME = "bundle_key_hippy_js_bundle_name";
    public static final String BUNDLE_KEY_IMAGE_BITMAP = "bundle_key_image_bitmap";
    public static final String BUNDLE_KEY_PUBLISH_ACCOUNT_ACTION_TYPE = "bundle_key_publish_account_action_type";
    public static final String BUNDLE_KEY_PUBLISH_ACCOUNT_IS_FOLLOW = "bundle_key_publish_account_is_follow";
    public static final String BUNDLE_KEY_SCHEMA_TO_EC_PAGE = "bundle_key_schema_to_qq_ecommerce";
    public static final String BUNDLE_KEY_TARGET_HEAD_TYPE = "bundle_key_target_head_type";
    public static final String BUNDLE_KEY_TARGET_UIN = "bundle_key_target_uin";
    public static final String BUNDLE_VALUE_PUBLISH_ACCOUNT_ACTION_TYPE_CHECK_IS_FOLLOW = "bundle_value_publish_account_action_type_check_is_follow";
    public static final String BUNDLE_VALUE_PUBLISH_ACCOUNT_ACTION_TYPE_DO_FOLLOW = "bundle_value_publish_account_action_type_do_follow";
    public static final String BUNDLE_VALUE_PUBLISH_ACCOUNT_FOLLOWED = "1";
    public static final String BUNDLE_VALUE_PUBLISH_ACCOUNT_UNFOLLOWED = "0";
    public static final String MODULE_NAME = "qCircleIpcModule";
    public static final String QCIRCLE_SEVER_PUBLISH_ACCOUNT_UIN = "982686153";

    QIPCModule getIPCModule();
}
