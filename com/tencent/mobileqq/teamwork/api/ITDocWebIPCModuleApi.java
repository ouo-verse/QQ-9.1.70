package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITDocWebIPCModuleApi extends QRouteApi {
    public static final String ACTION_DRIVE_UPLOAD = "url_key_drive_upload";
    public static final String ACTION_FIND = "action_find";
    public static final String ACTION_FIND_CANCEL = "action_find_cancel";
    public static final String ACTION_GET_FIND_STATE = "action_get_find_state";
    public static final String ACTION_GET_OUTLINE = "action_get_outline";
    public static final String ACTION_GET_PAGE_MODE = "action_get_page_mode";
    public static final String ACTION_NOTIFY_OPEN_FILE_RESULT = "action_notify_open_file_result";
    public static final String ACTION_OPEN_PERFORMANCE_DATA = "action_open_performance_data";
    public static final String ACTION_REFRESH_VIEW = "action_refresh_view";
    public static final String ACTION_REPLACE = "action_replace";
    public static final String ACTION_SCROLL_TO = "action_scroll_to";
    public static final String ACTION_SEND_JS_API = "action_send_js_api";
    public static final String ACTION_SET_PAGE_MODE = "action_set_page_mode";
    public static final String ACTION_SET_PAGE_SIZE = "action_set_page_size";
    public static final String IPC_MODULE_TDOC_WEB_CLIENT_NAME = "TDocWebIPCClient";
    public static final String IPC_MODULE_TDOC_WEB_SERVER_NAME = "TDocWebIPCServer";
    public static final String KEY_FIND_OFFSET = "key_find_offset";
    public static final String KEY_FIND_STATE = "key_find_state";
    public static final String KEY_JS_API_ARGS = "key_js_api_args";
    public static final String KEY_JS_API_METHOD = "key_js_api_method";
    public static final String KEY_JS_API_NAME_SPACE = "key_js_api_name_space";
    public static final String KEY_OUTLINE_ITEMS = "key_outline_items";
    public static final String KEY_PAGE_MODE = "key_page_mode";
    public static final String KEY_PARAGTAPH_NODE = "key_paragraph_node";
    public static final String KEY_PERFORMANCE_DATA = "key_performance_data";
    public static final String KEY_RECT = "key_rect";
    public static final String KEY_REPLACE_ALL = "key_replace_all";
    public static final String KEY_UPLOAD_REQUEST = "key_upload_request";

    QIPCModule getServerIPCModule();
}
