package com.tencent.mobileqq.qqlive.utils;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfig;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;

/* compiled from: P */
/* loaded from: classes17.dex */
public class r {
    static IPatchRedirector $redirector_;

    public static TRTCVideoQualityParams a(Context context, boolean z16, boolean z17) {
        return d(context, 0, z16, z17, 0.3f);
    }

    public static TRTCVideoQualityParams b(Context context) {
        return a(context, true, true);
    }

    public static TRTCVideoQualityParams c(Context context) {
        return f(context, true, true);
    }

    private static TRTCVideoQualityParams d(Context context, int i3, boolean z16, boolean z17, float f16) {
        int bitRate;
        int g16 = g(context);
        LiveMediaConfig liveMediaConfigCache = LiveMediaConfigManager.INSTANCE.getLiveMediaConfigCache(i3, e(g16));
        if (z16) {
            bitRate = liveMediaConfigCache.getMinBitRate();
        } else {
            bitRate = liveMediaConfigCache.getBitRate();
        }
        return new TRTCVideoQualityParams.Builder().setVideoResolution(g16).setVideoFps(liveMediaConfigCache.getFps()).setVideoBitRate(bitRate).setMinVideoBitRate((int) (f16 * bitRate)).setVideoResolutionMode(z17 ? 1 : 0).setEnableAdjustRes(false).build();
    }

    private static ResolutionLevelType e(int i3) {
        if (i3 != 3) {
            if (i3 != 4) {
                return ResolutionLevelType.HD;
            }
            return ResolutionLevelType.BluRay;
        }
        return ResolutionLevelType.UHD;
    }

    public static TRTCVideoQualityParams f(Context context, boolean z16, boolean z17) {
        return d(context, 1, z16, z17, 0.7f);
    }

    private static int g(Context context) {
        if (context == null) {
            return 3;
        }
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        if (i3 >= 1080) {
            return 4;
        }
        if (i3 >= 720) {
            return 3;
        }
        return 2;
    }
}
