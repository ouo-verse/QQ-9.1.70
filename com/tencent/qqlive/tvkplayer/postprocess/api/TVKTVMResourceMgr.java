package com.tencent.qqlive.tvkplayer.postprocess.api;

import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKTVMResourceMgr {
    private static final String TAG = "TVKTVMResourceMgr";

    public static void updateResourceAsyncWithDelay(long j3) {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_tvm_super_resolution) {
            return;
        }
        try {
            Class<?> cls = Class.forName("com.tencent.qqlive.tvkplayer.postprocess.monet.tvmsrupdate.TVKTVMResourceUpdater");
            cls.getMethod("updateResourceAsyncWithDelay", Long.TYPE).invoke(cls.cast(cls.getMethod("getInstance", new Class[0]).invoke(cls, new Object[0])), Long.valueOf(j3));
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "reflect prepareResourceAsync failed:" + th5.toString());
        }
    }
}
