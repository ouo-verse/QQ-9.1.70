package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKMediaSourceController {
    public static final int REQUEST_ID_NO_REQUEST = -1;

    void cancelRequest(int i3);

    int requestNetVideoInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, @NonNull ITVKFeatureGroup iTVKFeatureGroup, @Nullable ITVKFeatureParamGroup iTVKFeatureParamGroup);
}
