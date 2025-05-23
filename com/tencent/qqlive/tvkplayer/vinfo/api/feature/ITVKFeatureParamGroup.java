package com.tencent.qqlive.tvkplayer.vinfo.api.feature;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;

/* loaded from: classes23.dex */
public interface ITVKFeatureParamGroup {
    void addFeatureParam(@NonNull ITVKFeatureBase.ITVKFeatureParam iTVKFeatureParam);

    <T extends ITVKFeatureBase.ITVKFeatureParam> T getFeatureParamByClass(@NonNull Class<T> cls);

    void removeAllFeatureParam();
}
