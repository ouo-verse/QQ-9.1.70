package com.tencent.qqlive.tvkplayer.qqliveasset.feature;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureExtraParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveAntiScreenShotFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveChaCha20DrmFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveDlnaHevcFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveDolbyAudioFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveFlvFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveHdrVividFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveHevcFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveHlsFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveLogoFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLivePlayBackFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLivePreviewPlayFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveRtmpFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveVvcFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveWidevineDrmFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodAdaptiveDefinitionFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodAntiScreenShotFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodAudioAAC5Point1Feature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodAudioEffectFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodAudioVividFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodAv1Feature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodAvs3Feature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodChaCha20DrmFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodChinaDrm20Feature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodChinaDrmFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodDarkLogoFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodDefaultFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodDlnaHevcFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodDolbyAudioFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodDolbyVisionFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodEmbeddedAdDotFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHdr10Feature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHdrEnhanceFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHdrFeatureParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHdrVividFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHevcFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHighFpsFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodLogoFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodM3u8MultiLayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodM3u8TagFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodMediaLabVRFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodMultiAudioTrackFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodPcdnFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodPluginAdFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodPreviewPlayFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodQuickPlayFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodRichMediaFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodSimulatedLiveFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodSubtitleFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodUhdHighFpsHdrVividFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodUnitendDrmFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodVkeyExpireFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodVvcFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodVvcTvmsrMutualExeclusionFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodWidevineDrmFeature;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKFeatureFactory {
    public static TVKFeatureParamGroup createFeatureParamGroup(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        return createFeatureParamGroup(tVKPlayerInputParam, tVKPlayerRuntimeParam, new TVKPlayerFeatureExtraParam.Builder().isFirstRequestForThisPlay(false).build());
    }

    public static TVKFeatureParamGroup createFeatureParamGroupForBatchVinfo(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        long skipStartPositionMs = tVKPlayerVideoInfo.getSkipStartPositionMs();
        long j3 = skipStartPositionMs / 1000;
        TVKFeatureParamGroup tVKFeatureParamGroup = new TVKFeatureParamGroup();
        tVKFeatureParamGroup.addFeatureParam(new TVKVodDolbyVisionFeature.TVKVodDolbyVisionFeatureParam(j3));
        tVKFeatureParamGroup.addFeatureParam(new TVKVodMultiAudioTrackFeature.TVKAudioTrackFeatureParam(tVKPlayerVideoInfo.getConfigMapValue("track", ""), j3));
        tVKFeatureParamGroup.addFeatureParam(new TVKVodHdrFeatureParam(true));
        tVKFeatureParamGroup.addFeatureParam(new TVKVodPluginAdFeature.TVKVodPluginAdFeatureParam(null, false, false));
        tVKFeatureParamGroup.addFeatureParam(new TVKVodPreviewPlayFeature.TVKVodPreviewPlayParam(skipStartPositionMs));
        tVKFeatureParamGroup.addFeatureParam(new TVKVodEmbeddedAdDotFeature.TVKVodEmbeddedAdDotFeatureParam(true));
        return tVKFeatureParamGroup;
    }

    public static TVKFeatureParamGroup createFeatureParamGroupForDlna() {
        TVKFeatureParamGroup tVKFeatureParamGroup = new TVKFeatureParamGroup();
        tVKFeatureParamGroup.addFeatureParam(new TVKVodPluginAdFeature.TVKVodPluginAdFeatureParam(null, false, true));
        return tVKFeatureParamGroup;
    }

    public static TVKFeatureParamGroup createFeatureParamGroupForPreload(@Nullable ITVKPreloadMgr.PreloadParam preloadParam) {
        TVKFeatureParamGroup tVKFeatureParamGroup = new TVKFeatureParamGroup();
        if (preloadParam == null) {
            return tVKFeatureParamGroup;
        }
        tVKFeatureParamGroup.addFeatureParam(new TVKVodHdrFeatureParam(preloadParam.isUseSurfaceView()));
        tVKFeatureParamGroup.addFeatureParam(new TVKVodPreviewPlayFeature.TVKVodPreviewPlayParam(preloadParam.getStartPositionMs()));
        return tVKFeatureParamGroup;
    }

    public static List<ITVKFeatureBase> createLiveFeatureList(@NonNull TVKContext tVKContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKLiveWidevineDrmFeature(tVKContext));
        arrayList.add(new TVKLiveChaCha20DrmFeature(tVKContext));
        arrayList.add(new TVKLiveDolbyAudioFeature(tVKContext));
        arrayList.add(new TVKLivePreviewPlayFeature(tVKContext));
        arrayList.add(new TVKLivePlayBackFeature(tVKContext));
        arrayList.add(new TVKLiveHevcFeature(tVKContext));
        arrayList.add(new TVKLiveLogoFeature(tVKContext));
        arrayList.add(new TVKLiveHlsFeature(tVKContext));
        arrayList.add(new TVKLiveFlvFeature(tVKContext));
        arrayList.add(new TVKLiveRtmpFeature(tVKContext));
        arrayList.add(new TVKLiveAntiScreenShotFeature(tVKContext));
        arrayList.add(new TVKLiveHdrVividFeature(tVKContext));
        arrayList.add(new TVKLiveVvcFeature(tVKContext));
        return arrayList;
    }

    public static List<ITVKFeatureBase> createLiveFeatureListForDlna(@NonNull TVKContext tVKContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKLivePreviewPlayFeature(tVKContext));
        arrayList.add(new TVKLivePlayBackFeature(tVKContext));
        arrayList.add(new TVKLiveHlsFeature(tVKContext));
        arrayList.add(new TVKLiveDlnaHevcFeature(tVKContext));
        return arrayList;
    }

    public static List<ITVKFeatureBase> createVodFeatureList(@NonNull TVKContext tVKContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKVodDefaultFeature(tVKContext));
        arrayList.add(new TVKVodChinaDrmFeature(tVKContext));
        arrayList.add(new TVKVodWidevineDrmFeature(tVKContext));
        arrayList.add(new TVKVodChinaDrm20Feature(tVKContext));
        arrayList.add(new TVKVodChaCha20DrmFeature(tVKContext));
        arrayList.add(new TVKVodUnitendDrmFeature(tVKContext));
        arrayList.add(new TVKVodHdrVividFeature(tVKContext));
        arrayList.add(new TVKVodHdr10Feature(tVKContext));
        arrayList.add(new TVKVodHdrEnhanceFeature(tVKContext));
        arrayList.add(new TVKVodDolbyVisionFeature(tVKContext));
        arrayList.add(new TVKVodDolbyAudioFeature(tVKContext));
        arrayList.add(new TVKVodAudioVividFeature(tVKContext));
        arrayList.add(new TVKVodAudioAAC5Point1Feature(tVKContext));
        arrayList.add(new TVKVodMultiAudioTrackFeature(tVKContext));
        arrayList.add(new TVKVodM3u8MultiLayerFeature(tVKContext));
        arrayList.add(new TVKVodM3u8TagFeature(tVKContext));
        arrayList.add(new TVKVodPcdnFeature(tVKContext));
        arrayList.add(new TVKVodLogoFeature(tVKContext));
        arrayList.add(new TVKVodSubtitleFeature(tVKContext));
        arrayList.add(new TVKVodAdaptiveDefinitionFeature(tVKContext));
        arrayList.add(new TVKVodAntiScreenShotFeature(tVKContext));
        arrayList.add(new TVKVodEmbeddedAdDotFeature(tVKContext));
        arrayList.add(new TVKVodQuickPlayFeature(tVKContext));
        arrayList.add(new TVKVodPreviewPlayFeature(tVKContext));
        arrayList.add(new TVKVodPluginAdFeature(tVKContext));
        arrayList.add(new TVKVodSimulatedLiveFeature(tVKContext));
        arrayList.add(new TVKVodRichMediaFeature(tVKContext));
        arrayList.add(new TVKVodVkeyExpireFeature(tVKContext));
        arrayList.add(new TVKVodAvs3Feature(tVKContext));
        arrayList.add(new TVKVodHevcFeature(tVKContext));
        arrayList.add(new TVKVodVvcFeature(tVKContext));
        arrayList.add(new TVKVodAv1Feature(tVKContext));
        arrayList.add(new TVKVodHighFpsFeature(tVKContext));
        arrayList.add(new TVKVodMediaLabVRFeature(tVKContext));
        arrayList.add(new TVKVodAudioEffectFeature(tVKContext));
        arrayList.add(new TVKVodUhdHighFpsHdrVividFeature(tVKContext));
        arrayList.add(new TVKVodDarkLogoFeature(tVKContext));
        arrayList.add(new TVKVodVvcTvmsrMutualExeclusionFeature(tVKContext));
        return arrayList;
    }

    public static List<ITVKFeatureBase> createVodFeatureListForDlna(@NonNull TVKContext tVKContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKVodDefaultFeature(tVKContext));
        arrayList.add(new TVKVodEmbeddedAdDotFeature(tVKContext));
        arrayList.add(new TVKVodQuickPlayFeature(tVKContext));
        arrayList.add(new TVKVodPreviewPlayFeature(tVKContext));
        arrayList.add(new TVKVodPluginAdFeature(tVKContext));
        arrayList.add(new TVKVodDlnaHevcFeature(tVKContext));
        return arrayList;
    }

    public static List<ITVKFeatureBase> createVodFeatureListForOfflineDownload(@NonNull TVKContext tVKContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKVodDefaultFeature(tVKContext));
        arrayList.add(new TVKVodChaCha20DrmFeature(tVKContext));
        arrayList.add(new TVKVodUnitendDrmFeature(tVKContext));
        arrayList.add(new TVKVodHdrVividFeature(tVKContext));
        arrayList.add(new TVKVodHdr10Feature(tVKContext));
        arrayList.add(new TVKVodHdrEnhanceFeature(tVKContext));
        arrayList.add(new TVKVodDolbyVisionFeature(tVKContext));
        arrayList.add(new TVKVodDolbyAudioFeature(tVKContext));
        arrayList.add(new TVKVodAudioVividFeature(tVKContext));
        arrayList.add(new TVKVodAudioAAC5Point1Feature(tVKContext));
        arrayList.add(new TVKVodMultiAudioTrackFeature(tVKContext));
        arrayList.add(new TVKVodM3u8MultiLayerFeature(tVKContext));
        arrayList.add(new TVKVodM3u8TagFeature(tVKContext));
        arrayList.add(new TVKVodPcdnFeature(tVKContext));
        arrayList.add(new TVKVodLogoFeature(tVKContext));
        arrayList.add(new TVKVodSubtitleFeature(tVKContext));
        arrayList.add(new TVKVodAntiScreenShotFeature(tVKContext));
        arrayList.add(new TVKVodEmbeddedAdDotFeature(tVKContext));
        arrayList.add(new TVKVodQuickPlayFeature(tVKContext));
        arrayList.add(new TVKVodPreviewPlayFeature(tVKContext));
        arrayList.add(new TVKVodRichMediaFeature(tVKContext));
        arrayList.add(new TVKVodVkeyExpireFeature(tVKContext));
        arrayList.add(new TVKVodAvs3Feature(tVKContext));
        arrayList.add(new TVKVodHevcFeature(tVKContext));
        arrayList.add(new TVKVodVvcFeature(tVKContext));
        arrayList.add(new TVKVodAv1Feature(tVKContext));
        arrayList.add(new TVKVodHighFpsFeature(tVKContext));
        arrayList.add(new TVKVodAudioEffectFeature(tVKContext));
        arrayList.add(new TVKVodUhdHighFpsHdrVividFeature(tVKContext));
        arrayList.add(new TVKVodDarkLogoFeature(tVKContext));
        arrayList.add(new TVKVodVvcTvmsrMutualExeclusionFeature(tVKContext));
        return arrayList;
    }

    private static String generateSimulatedLiveChid(TVKPlayerInputParam tVKPlayerInputParam, TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        ITVKAsset asset = tVKPlayerInputParam.getPlayerVideoInfo().getAsset();
        if (!(asset instanceof TVKOnlineSimulatedLiveAsset)) {
            return "";
        }
        String chid = ((TVKOnlineSimulatedLiveAsset) asset).getChid();
        TVKNetVideoInfo netVideoInfo = tVKPlayerRuntimeParam.getNetVideoInfo();
        if (netVideoInfo instanceof TVKVodVideoInfo) {
            String chid2 = ((TVKVodVideoInfo) netVideoInfo).getSimulatedLiveInfo().getChid();
            if (!TextUtils.isEmpty(chid2)) {
                return chid2;
            }
            return chid;
        }
        return chid;
    }

    public static TVKFeatureParamGroup createFeatureParamGroup(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam, @NonNull TVKPlayerFeatureExtraParam tVKPlayerFeatureExtraParam) {
        if (tVKPlayerInputParam.getPlayerVideoInfo() == null) {
            return new TVKFeatureParamGroup();
        }
        long lastPositionMs = tVKPlayerRuntimeParam.getLastPositionMs() / 1000;
        TVKFeatureParamGroup tVKFeatureParamGroup = new TVKFeatureParamGroup();
        if (TVKAssetUtils.isLiveAsset(tVKPlayerRuntimeParam.getTVKAsset())) {
            tVKFeatureParamGroup.addFeatureParam(new TVKLivePlayBackFeature.TVKLivePlayBackFeatureParam(tVKPlayerInputParam.getLiveBackPlayTimeSec()));
        } else if (TVKAssetUtils.isVodAsset(tVKPlayerRuntimeParam.getTVKAsset())) {
            tVKFeatureParamGroup.addFeatureParam(new TVKVodDolbyVisionFeature.TVKVodDolbyVisionFeatureParam(lastPositionMs));
            tVKFeatureParamGroup.addFeatureParam(new TVKVodMultiAudioTrackFeature.TVKAudioTrackFeatureParam(tVKPlayerInputParam.getCurAudioTrack(), lastPositionMs));
            tVKFeatureParamGroup.addFeatureParam(new TVKVodHdrFeatureParam(tVKPlayerInputParam.getDrawableContainer()));
            tVKFeatureParamGroup.addFeatureParam(new TVKVodPluginAdFeature.TVKVodPluginAdFeatureParam((TVKVodVideoInfo) tVKPlayerRuntimeParam.getNetVideoInfo(), tVKPlayerFeatureExtraParam.isFirstRequestForThisPlay(), false));
            tVKFeatureParamGroup.addFeatureParam(new TVKVodPreviewPlayFeature.TVKVodPreviewPlayParam(tVKPlayerRuntimeParam.getStartPositionMs()));
            tVKFeatureParamGroup.addFeatureParam(new TVKVodEmbeddedAdDotFeature.TVKVodEmbeddedAdDotFeatureParam(tVKPlayerFeatureExtraParam.isFirstRequestForThisPlay()));
            if (tVKPlayerRuntimeParam.getNetVideoInfo() != null) {
                tVKFeatureParamGroup.addFeatureParam(new TVKVodSubtitleFeature.TVKSubtitleTrackFeatureParam(tVKPlayerInputParam.getCurSubtitleTrack()));
            }
            if (tVKPlayerFeatureExtraParam.getAssetExpireRequestMap() != null) {
                tVKFeatureParamGroup.addFeatureParam(new TVKVodVkeyExpireFeature.TVKVkeyExpireFeatureParam(tVKPlayerFeatureExtraParam.getAssetExpireRequestMap()));
            }
            tVKFeatureParamGroup.addFeatureParam(new TVKVodSimulatedLiveFeature.TVKSimulatedLiveFeatureParam(generateSimulatedLiveChid(tVKPlayerInputParam, tVKPlayerRuntimeParam)));
        }
        return tVKFeatureParamGroup;
    }
}
