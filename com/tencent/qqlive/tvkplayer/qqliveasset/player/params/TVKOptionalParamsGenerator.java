package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes23.dex */
public final class TVKOptionalParamsGenerator {
    private static final List<ITVKOptionalParamBuilder> sOptionalParamBuilderList;

    static {
        ArrayList arrayList = new ArrayList();
        sOptionalParamBuilderList = arrayList;
        arrayList.add(new TVKOPVideoDecoderBuilder());
        arrayList.add(new TVKOPSkipStartEndPositionBuilder());
        arrayList.add(new TVKOPAccurateSeekBuilder());
        arrayList.add(new TVKOPDropFrameBuilder());
        arrayList.add(new TVKOPDownloadProxyBuilder());
        arrayList.add(new TVKOPResetDecoderBuilder());
        arrayList.add(new TVKOPVideoCaptureBuilder());
        arrayList.add(new TVKOPHlsTagCallbackBuilder());
        arrayList.add(new TVKOPBufferConfigBuilder());
        arrayList.add(new TVKOPReduceLiveLatencyBuilder());
        arrayList.add(new TVKOPAudioLatencyLimitBuilder());
        arrayList.add(new TVKOPThreadPriorityBuilder());
        arrayList.add(new TVKOPReleaseMediaCodecBuilder());
        arrayList.add(new TVKOPBufferStrategyBuilder());
        arrayList.add(new TVKOPSubtitleConfigBuilder());
        arrayList.add(new TVKOPSelectDemuxerBuilder());
        arrayList.add(new TVKOPCustomizedSeiBuilder());
        arrayList.add(new TVKOPDolbyVisionDVMAConfigBuilder());
        arrayList.add(new TVKOPDrmConfigBuilder());
        arrayList.add(new TVKOPAudioAVSyncStrategyBuilder());
        arrayList.add(new TVKOPSwitchDataSourceConfigBuilder());
        arrayList.add(new TVKOPAudioTrackConfigBuilder());
        arrayList.add(new TVKOPCdnUrlRetryWhenConnectDownloadProxyRefusedConfigBuilder());
        arrayList.add(new TVKOPRenderPausedFrameBuilder());
        arrayList.add(new TVKOPMediaLabVRConfigBuilder());
        arrayList.add(new TVKOPSecurityConfigBuilder());
        arrayList.add(new TVKOPAudioFrameCallbackBuilder());
        arrayList.add(new TVKOPFlvDemuxerConfigBuilder());
        arrayList.add(new TVKOPDemuxerConfigBuilder());
        arrayList.add(new TVKOPPlayerReuseBuilder());
        arrayList.add(new TVKOPRendererUnlimitedRetryBuilder());
        arrayList.add(new TVKOPSpatialAudioRenderingBuilder());
        arrayList.add(new TVKOPAvs3AudioDecoderConfigBuilder());
        arrayList.add(new TVKOPAudioRendererChannelLayoutConversionBuilder());
        arrayList.add(new TVKOPHdrConfigBuilder());
        arrayList.add(new TVKOPMaxFramerateForDecoderFrameDropStrategyBuilder());
        arrayList.add(new TVKOPMediaCodecParamsBuilder());
        arrayList.add(new TVKOPBufferingBuilder());
        arrayList.add(new TVKOPSurfaceBufferSizeBuilder());
    }

    public static List<TPOptionalParam<?>> generateOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        Iterator<ITVKOptionalParamBuilder> it = sOptionalParamBuilderList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().buildOptionalParamList(tVKQQLiveAssetPlayerContext, z16));
        }
        return arrayList;
    }
}
