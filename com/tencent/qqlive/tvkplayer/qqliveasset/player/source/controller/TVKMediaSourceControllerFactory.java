package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKMediaSourceControllerFactory {
    private static final String TAG = "TVKMediaSourceControllerFactory";

    @Nullable
    public static ITVKMediaSourceController createMediaSourceController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @Nullable Looper looper, @NonNull ITVKMediaSourceListener iTVKMediaSourceListener) {
        TVKPlayerVideoInfo playerVideoInfo = tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo();
        ITVKAsset tVKAsset = tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset();
        if (playerVideoInfo == null) {
            TVKLogUtil.e(TAG, "createMediaSourceController, playerVideoInfo == null return");
            return null;
        }
        if (tVKAsset == null) {
            TVKLogUtil.e(TAG, "createMediaSourceController, asset == null return");
            return null;
        }
        TVKHookMediaSourceListener tVKHookMediaSourceListener = new TVKHookMediaSourceListener(iTVKMediaSourceListener, tVKQQLiveAssetPlayerContext.getAssetPlayerListener());
        if (TVKAssetUtils.isVodAsset(tVKAsset)) {
            return createVodMediaSourceController(tVKQQLiveAssetPlayerContext, looper, tVKHookMediaSourceListener);
        }
        if (TVKAssetUtils.isLiveAsset(tVKAsset)) {
            return new TVKLiveMediaSourceController(tVKQQLiveAssetPlayerContext, looper, tVKHookMediaSourceListener);
        }
        TVKLogUtil.e(TAG, "createMediaSourceController, unhandled asset:" + tVKAsset);
        return null;
    }

    private static ITVKMediaSourceController createVodMediaSourceController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @Nullable Looper looper, @NonNull ITVKMediaSourceListener iTVKMediaSourceListener) {
        if (tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset().getAssetType() == 65536) {
            return new TVKXmlAssetVodMediaSourceController(tVKQQLiveAssetPlayerContext, looper, iTVKMediaSourceListener);
        }
        return new TVKVidAssetVodMediaSourceController(tVKQQLiveAssetPlayerContext, looper, iTVKMediaSourceListener);
    }
}
