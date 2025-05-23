package com.tencent.qqlive.tvkplayer.qqliveasset.player;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;

/* loaded from: classes23.dex */
public interface ITVKQQLiveAssetPlayerSharedOperator {
    void preprocessWhenPlayerPrepared();

    void processCGIRequestSuccess(@NonNull TVKNetVideoInfo tVKNetVideoInfo);

    void processError(TVKError tVKError);

    void setupPlayerAndPrepareAsync(@NonNull ITPMediaAsset iTPMediaAsset, boolean z16);

    void stopAndResetPlayer();
}
