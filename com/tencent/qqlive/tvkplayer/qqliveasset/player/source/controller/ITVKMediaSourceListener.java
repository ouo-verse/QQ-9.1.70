package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKMediaSourceListener {
    void onFailure(int i3, ITVKAsset iTVKAsset, @NonNull TVKError tVKError);

    void onSuccess(int i3, ITVKAsset iTVKAsset, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo);
}
