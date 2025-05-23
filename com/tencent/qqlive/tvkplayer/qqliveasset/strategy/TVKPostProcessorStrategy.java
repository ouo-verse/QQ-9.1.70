package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes23.dex */
public final class TVKPostProcessorStrategy {
    public static boolean isNeedConnectVideoProcessor(@NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam, @NonNull List<ITVKPlayerFeature> list) {
        boolean z16;
        if (tVKPlayerRuntimeParam.isDolbyVision() && TVKCapabilityMgr.getInstance().isSupportDolbyVisionSoftRender()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isSupportVideoProcessor = isSupportVideoProcessor(tVKPlayerRuntimeParam.getNetVideoInfo(), list);
        boolean isNeedSDREnhance = tVKPlayerRuntimeParam.isNeedSDREnhance();
        boolean isNeedSuperResolution = tVKPlayerRuntimeParam.isNeedSuperResolution();
        if (isSupportVideoProcessor && (isNeedSDREnhance || isNeedSuperResolution || z16)) {
            return true;
        }
        return false;
    }

    public static boolean isSupportVideoProcessor(@NonNull TVKNetVideoInfo tVKNetVideoInfo, @NonNull List<ITVKPlayerFeature> list) {
        if (TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.is_in_new_monet_blacklist)) {
            return false;
        }
        Iterator<ITVKPlayerFeature> it = list.iterator();
        while (it.hasNext()) {
            if (!TVKPlayerFeatureUtils.isSupportVideoPostProcess(it.next(), tVKNetVideoInfo)) {
                return false;
            }
        }
        return true;
    }
}
