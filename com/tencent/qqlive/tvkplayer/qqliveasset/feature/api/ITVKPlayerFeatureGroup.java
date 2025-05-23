package com.tencent.qqlive.tvkplayer.qqliveasset.feature.api;

import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import java.util.List;

/* loaded from: classes23.dex */
public interface ITVKPlayerFeatureGroup extends ITVKFeatureGroup {
    List<ITVKPlayerFeature> getLivePlayerAndDecoderChooseFeatureList();

    List<ITVKPlayerFeature> getLivePlayerFeatureList();

    List<ITVKPlayerFeature> getLiveRetryFeatureList();

    List<ITVKPlayerFeature> getVodPlayerAndDecoderChooseFeatureList();

    List<ITVKPlayerFeature> getVodPlayerFeatureList();

    List<ITVKPlayerFeature> getVodRetryFeatureList();

    void reset();
}
