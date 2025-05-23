package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzonePatchApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final String LIVE_PLUGIN_ID = "qzone_live_video_plugin_hack.apk";
    public static final String MM_REPORT = "qz_patch";
    public static final String PATCH_DIR = "patchs";
    public static final String QZONE_LIVE_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzonelive";
    public static final String QZONE_VIDEO_VERTICAL_LAYER_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzone";
    public static final String QZONE_WEISHI_FEEDS_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzonelive";
    public static final String SP_LENGTH = "p_len";
    public static final String TAG;
    public static final String VERTICAL_VIDEO_LAYER_PLUGIN_ID = "qzone_vertical_video_plugin.apk";
    public static final String VERTICAL_VIDEO_PLUGIN_NAME = "QZoneVerticalVideo";
    public static final String WEISHI_FEEDS_PLUGIN_ID = "qzone_weishi_feeds_plugin.apk";
    public static final String WEISHI_FEEDS_PLUGIN_NAME = "QZoneWeishiFeedsVideo";

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(23701), (Class<?>) IQzonePatchApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            TAG = IQzonePatchApi.class.getName();
        }
    }

    String getLoadQZoneLivePluginId();

    void getPatchList();

    void triggerQQDownloadPtuFilter();
}
