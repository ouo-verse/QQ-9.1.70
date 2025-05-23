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
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityQuery;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl;
import com.tencent.qqlive.tvkplayer.moduleupdate.api.TVKModuleUpdaterFactory;
import com.tencent.qqlive.tvkplayer.postprocess.api.TVKPostProcessorFactory;
import com.tencent.qqlive.tvkplayer.preload.TVKDownloadProxyUrlBuilder;
import com.tencent.qqlive.tvkplayer.preload.TVKPreloadMgr;
import com.tencent.qqlive.tvkplayer.richmedia.async.TVKRichMediaAsyncRequesterImpl;
import com.tencent.qqlive.tvkplayer.tools.auth.TVKAppKeyManager;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.videocapture.TVKVideoFrameCapture;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerCustomVideoSurface;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.qqlive.tvkplayer.vinfo.TVKBatchVinfoRequester;
import com.tencent.qqlive.tvkplayer.vinfo.TVKDownloadAssetRequester;
import com.tencent.qqlive.tvkplayer.vinfo.TVKQQLiveAssetRequester;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFactory;

/* loaded from: classes23.dex */
public class TVKMediaPlayerFactory implements ITVKProxyFactory {
    private static final String TAG = "TVKPlayer[TVKMediaPlayerFactory]";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f345785a = 0;
    private static final TVKMediaPlayerFactory sInstance = new TVKMediaPlayerFactory();

    TVKMediaPlayerFactory() {
    }

    public static ITVKProxyFactory getProxyFactoryInstance() {
        return sInstance;
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public <T extends ITVKAudioFx> T createAudioFx(TVKAudioEffectType tVKAudioEffectType) {
        return (T) TVKPostProcessorFactory.createAudioFx(tVKAudioEffectType);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKBatchVinfoRequester createBatchVinfoRequester() {
        if (!TVKAppKeyManager.isAuthorized()) {
            return null;
        }
        return new TVKBatchVinfoRequester(new TVKContext(TVKCommParams.getApplicationContext()));
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKCustomVideoSurface createCustomVideoSurface(Context context, Surface surface) {
        return new TVKPlayerCustomVideoSurface(context, surface);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKDownloadAssetRequester createDownloadAssetRequester() {
        if (!TVKAppKeyManager.isAuthorized()) {
            return null;
        }
        return new TVKDownloadAssetRequester(new TVKContext(TVKCommParams.getApplicationContext()));
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKDownloadProxyUrlBuilder createDownloadProxyUrlBuilder(@NonNull Context context) {
        if (!TVKAppKeyManager.isAuthorized()) {
            return null;
        }
        try {
            return new TVKDownloadProxyUrlBuilder();
        } catch (UnsupportedOperationException e16) {
            TVKLogUtil.e(TAG, e16, "[createDownloadProxyUrlBuilder] there is a exception: ");
            return null;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKMediaPlayer createMediaPlayer(Context context, ITVKDrawableContainer iTVKDrawableContainer) {
        return new TVKMultiMediaPlayerImpl(context, iTVKDrawableContainer, null);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKPreloadMgr createPreloadMgr(Context context) {
        if (!TVKAppKeyManager.isAuthorized()) {
            return null;
        }
        return TVKPreloadMgr.getInstance();
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKQQLiveAssetRequester createQQLiveAssetRequester() {
        if (!TVKAppKeyManager.isAuthorized()) {
            return null;
        }
        return new TVKQQLiveAssetRequester(new TVKContext(TVKCommParams.getApplicationContext()));
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    @Nullable
    public ITVKRichMediaAsyncRequester createRichMediaAsyncRequester(@NonNull Context context) {
        ITPRichMediaAsyncRequester createRichMediaASyncRequester = TPRichMediaFactory.createRichMediaASyncRequester();
        if (createRichMediaASyncRequester == null) {
            TVKLogUtil.w(TAG, "TPPlayerFactory.createRichMediaASyncRequester(context) return null, context=" + context);
            return null;
        }
        return new TVKRichMediaAsyncRequesterImpl(createRichMediaASyncRequester);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKVideoFrameCapture createVideoFrameCapture(Context context) {
        return new TVKVideoFrameCapture(new TVKContext(context));
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public <T extends ITVKVideoFx> T createVideoFx(TVKVideoFxType tVKVideoFxType) {
        return (T) TVKPostProcessorFactory.createVideoFx(tVKVideoFxType);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKVideoViewBase createVideoView(Context context) {
        return new TVKPlayerVideoView(context, false);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKVideoViewBase createVideoView_Scroll(Context context) {
        return new TVKPlayerVideoView(context, true);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKCapabilityQuery getCapabilityQuery() {
        return TVKCapabilityQuery.getInstance();
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKModuleUpdaterMgr getModuleUpdaterMgr(@NonNull Context context) {
        if (!TVKAppKeyManager.isAuthorized()) {
            return null;
        }
        return TVKModuleUpdaterFactory.getModuleUpdaterMgr(context);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKMediaPlayer createMediaPlayer(Context context, ITVKDrawableContainer iTVKDrawableContainer, Looper looper) {
        return new TVKMultiMediaPlayerImpl(context, iTVKDrawableContainer, looper);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory
    public ITVKVideoViewBase createVideoView(Context context, boolean z16, boolean z17) {
        return new TVKPlayerVideoView(context, false, z16, z17);
    }
}
