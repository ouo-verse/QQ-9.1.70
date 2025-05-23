package com.tencent.qqlive.tvkplayer.bridge;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.ITVKCapabilityQuery;
import com.tencent.qqlive.tvkplayer.api.ITVKDownloadAssetRequester;
import com.tencent.qqlive.tvkplayer.api.ITVKDownloadProxyUrlBuilder;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr;
import com.tencent.qqlive.tvkplayer.api.ITVKQQLiveAssetRequester;
import com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture;
import com.tencent.qqlive.tvkplayer.api.batchvinfo.ITVKBatchVinfoRequester;
import com.tencent.qqlive.tvkplayer.api.moduleupdate.ITVKModuleUpdaterMgr;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.TVKAudioEffectType;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKVideoFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.TVKVideoFxType;
import com.tencent.qqlive.tvkplayer.api.render.ITVKCustomVideoSurface;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester;

/* loaded from: classes23.dex */
public interface ITVKProxyFactory {
    @Nullable
    <T extends ITVKAudioFx> T createAudioFx(TVKAudioEffectType tVKAudioEffectType);

    @Nullable
    ITVKBatchVinfoRequester createBatchVinfoRequester();

    ITVKCustomVideoSurface createCustomVideoSurface(Context context, Surface surface);

    @Nullable
    ITVKDownloadAssetRequester createDownloadAssetRequester();

    @Nullable
    ITVKDownloadProxyUrlBuilder createDownloadProxyUrlBuilder(@NonNull Context context);

    ITVKMediaPlayer createMediaPlayer(Context context, ITVKDrawableContainer iTVKDrawableContainer);

    ITVKMediaPlayer createMediaPlayer(Context context, ITVKDrawableContainer iTVKDrawableContainer, Looper looper);

    @Nullable
    ITVKPreloadMgr createPreloadMgr(Context context);

    @Nullable
    ITVKQQLiveAssetRequester createQQLiveAssetRequester();

    @Nullable
    ITVKRichMediaAsyncRequester createRichMediaAsyncRequester(@NonNull Context context);

    ITVKVideoFrameCapture createVideoFrameCapture(Context context);

    @Nullable
    <T extends ITVKVideoFx> T createVideoFx(TVKVideoFxType tVKVideoFxType);

    ITVKVideoViewBase createVideoView(Context context);

    ITVKVideoViewBase createVideoView(Context context, boolean z16, boolean z17);

    ITVKVideoViewBase createVideoView_Scroll(Context context);

    ITVKCapabilityQuery getCapabilityQuery();

    @Nullable
    ITVKModuleUpdaterMgr getModuleUpdaterMgr(@NonNull Context context);
}
