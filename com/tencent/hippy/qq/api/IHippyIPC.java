package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyIPC extends QRouteApi {
    public static final String ACTION_GET_MAIN_STATE = "action_get_main_state";
    public static final String ACTION_IS_CLEARING_HIPPY_CACHE = "action_is_clear_hippy_cache";
    public static final String ACTION_PRELOAD_HIPPY = "action_preload_hippy";
    public static final String ACTION_REMOVE_PRELOADED_HIPPY = "action_remove_preloaded_hippy";
    public static final String BUNDLE_HIPPY_INFO = "hippy_info";
    public static final String KEY_CURRENT_MAIN_STATE = "current_main_state";
    public static final String KEY_IS_CLEAR_HIPPY_CACHE = "is_clear_hippy_cache";
    public static final String KEY_IS_PRELOAD_AD_HIPPY = "is_preload_ad_hippy";
    public static final String KEY_IS_PRELOAD_HIPPY = "is_preload_hippy";
    public static final String KEY_IS_REMOVE_PRELOADED_HIPPY = "is_remove_preloaded_hippy";
    public static final String KEY_PRELOAD_AD_ID = "preload_ad_id";
    public static final String KEY_PRELOAD_AD_TYPD = "preload_ad_type";
    public static final String KEY_SHOW_TAB_NAME = "show_tab_name";
    public static final String NAME = "module_hippy";

    QIPCModule getIPCModule();
}
