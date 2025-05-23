package com.tencent.qqmini.sdk.launcher.core.proxy;

import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: classes23.dex */
public interface ThirdPartyMiniPageProxy {
    public static final String ACTION_HIPPY_LOAD_SUCCESS = "mini_hippy_load_success";
    public static final String ACTION_UPDATE_APP_INFO = "mini_hippy_update_app_info";
    public static final String KEY_HIPPY_BUNDLE = "bundle_name";
    public static final String KEY_HIPPY_DOMAIN = "hippy_domain";
    public static final String KEY_HIPPY_URL = "hippy_url";
    public static final String KEY_KUIKLY_PARAM = "kuikly_param";
    public static final String KEY_SHARE_PIC_URL = "sharePicUrl";
    public static final String KEY_SHARE_QUERY = "shareQuery";
    public static final String KEY_SHARE_TEXT = "shareText";
    public static final String TAG_HIPPY_NAVIGATION = "mini_hippy_navigation";

    Map<String, String> getShareParam(@Nullable String str, int i3);

    boolean needRestart(@Nullable String str, int i3);

    boolean needShareToQQ(@Nullable String str, int i3);

    boolean needShareToQZone(@Nullable String str, int i3);
}
