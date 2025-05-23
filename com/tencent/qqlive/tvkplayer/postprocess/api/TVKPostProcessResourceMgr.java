package com.tencent.qqlive.tvkplayer.postprocess.api;

import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* loaded from: classes23.dex */
public class TVKPostProcessResourceMgr {
    private static final String CLASS_NAME = "com.tencent.qqlive.tvkplayer.postprocess.monet.postprocessresource.TVKPostProcessResourceManager";
    private static final String TAG = "TVKPostProcessResourceMgr";

    public static void updateResourceAsyncWithDelay(long j3) {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_post_process_resource_update) {
            return;
        }
        try {
            Class<?> cls = Class.forName(CLASS_NAME);
            cls.getMethod("updateResourceAsyncWithDelay", Long.TYPE).invoke(cls.cast(cls.getMethod("getInstance", new Class[0]).invoke(cls, new Object[0])), Long.valueOf(j3));
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "reflect updateResourceAsyncWithDelay failed:" + th5.toString());
        }
    }
}
