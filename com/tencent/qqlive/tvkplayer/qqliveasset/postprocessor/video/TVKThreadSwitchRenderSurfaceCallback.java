package com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKSurfaceDestroyedInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKElapsedTimeStatistics;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKSynchronousHandler;
import com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKThreadSwitchRenderSurfaceCallback implements ITVKRenderSurface.IVideoSurfaceCallback {
    private static final String MODULE_NAME = "TVKThreadSwitchRenderSurfaceCallback";
    private static final Object PLACEHOLDER = new Object();
    private static final long THREAD_SWITCH_TIME_OUT_MS = 500;

    @NonNull
    private final Handler mCallbackHandler;

    @NonNull
    private final ITVKLogger mLogger;

    @NonNull
    private final ITVKRenderSurface.IVideoSurfaceCallback mRenderSurfaceCallback;

    @NonNull
    private final TVKQQLiveAssetPlayerContext mTVKQQLiveAssetPlayerContext;

    @NonNull
    private final TVKElapsedTimeStatistics mTimeStatistics = new TVKElapsedTimeStatistics();
    private final Map<Runnable, Object> mPendingTasks = new ConcurrentHashMap();

    public TVKThreadSwitchRenderSurfaceCallback(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Looper looper, @NonNull ITVKRenderSurface.IVideoSurfaceCallback iVideoSurfaceCallback) {
        this.mTVKQQLiveAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, MODULE_NAME);
        this.mCallbackHandler = new Handler(looper);
        this.mRenderSurfaceCallback = iVideoSurfaceCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSurfaceDestroyed$0(ITVKRenderSurface iTVKRenderSurface, Surface surface, TVKSurfaceDestroyedInfo tVKSurfaceDestroyedInfo) {
        this.mLogger.info("onSurfaceDestroyed after thread switch", new Object[0]);
        this.mRenderSurfaceCallback.onSurfaceDestroyed(iTVKRenderSurface, surface);
        notifySurfaceDestroyedAsync(tVKSurfaceDestroyedInfo);
    }

    private void notifySurfaceDestroyedAsync(@Nullable TVKSurfaceDestroyedInfo tVKSurfaceDestroyedInfo) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener;
        if (tVKSurfaceDestroyedInfo == null || (assetPlayerListener = this.mTVKQQLiveAssetPlayerContext.getAssetPlayerListener()) == null) {
            return;
        }
        assetPlayerListener.onInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_SURFACE_DESTROYED_ASYNC_RESOURCE_RELEASED, 0L, 0L, tVKSurfaceDestroyedInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
    public void onSurfaceChanged(final ITVKRenderSurface iTVKRenderSurface, final Surface surface) {
        String str;
        this.mLogger.info("onSurfaceChanged before thread switch", new Object[0]);
        try {
            Runnable runnable = new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video.TVKThreadSwitchRenderSurfaceCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    TVKThreadSwitchRenderSurfaceCallback.this.mLogger.info("onSurfaceChanged after thread switch", new Object[0]);
                    TVKThreadSwitchRenderSurfaceCallback.this.mPendingTasks.remove(this);
                    if (TVKMediaPlayerConfig.PlayerConfig.enable_verbose_surface_callback_log) {
                        TVKThreadSwitchRenderSurfaceCallback.this.mLogger.info("pending task removed: " + this, new Object[0]);
                    }
                    TVKThreadSwitchRenderSurfaceCallback.this.mRenderSurfaceCallback.onSurfaceChanged(iTVKRenderSurface, surface);
                }
            };
            this.mPendingTasks.put(runnable, PLACEHOLDER);
            if (TVKMediaPlayerConfig.PlayerConfig.enable_verbose_surface_callback_log) {
                this.mLogger.info("pending task added: " + runnable, new Object[0]);
            }
            this.mTimeStatistics.point();
            boolean postAtQueueFrontAndWait = TVKSynchronousHandler.postAtQueueFrontAndWait(this.mCallbackHandler, runnable, 500L);
            ITVKLogger iTVKLogger = this.mLogger;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onSurfaceChanged cost=");
            sb5.append(this.mTimeStatistics.costTimeMsFromLastPoint());
            sb5.append(" running timeout?");
            if (postAtQueueFrontAndWait) {
                str = "NO";
            } else {
                str = "YES";
            }
            sb5.append(str);
            iTVKLogger.info(sb5.toString(), new Object[0]);
        } catch (IllegalArgumentException e16) {
            this.mLogger.printException(e16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
    public void onSurfaceCreated(final ITVKRenderSurface iTVKRenderSurface, final Surface surface) {
        this.mLogger.info("onSurfaceCreated before thread switch", new Object[0]);
        Runnable runnable = new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video.TVKThreadSwitchRenderSurfaceCallback.1
            @Override // java.lang.Runnable
            public void run() {
                TVKThreadSwitchRenderSurfaceCallback.this.mLogger.info("onSurfaceCreated after thread switch", new Object[0]);
                TVKThreadSwitchRenderSurfaceCallback.this.mPendingTasks.remove(this);
                if (TVKMediaPlayerConfig.PlayerConfig.enable_verbose_surface_callback_log) {
                    TVKThreadSwitchRenderSurfaceCallback.this.mLogger.info("pending task removed: " + this, new Object[0]);
                }
                TVKThreadSwitchRenderSurfaceCallback.this.mRenderSurfaceCallback.onSurfaceCreated(iTVKRenderSurface, surface);
            }
        };
        this.mPendingTasks.put(runnable, PLACEHOLDER);
        if (TVKMediaPlayerConfig.PlayerConfig.enable_verbose_surface_callback_log) {
            this.mLogger.info("pending task added: " + runnable, new Object[0]);
        }
        this.mCallbackHandler.post(runnable);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
    public void onSurfaceDestroyed(final ITVKRenderSurface iTVKRenderSurface, final Surface surface) {
        this.mLogger.info("onSurfaceDestroyed before thread switch", new Object[0]);
        try {
            if (TVKMediaPlayerConfig.PlayerConfig.enable_verbose_surface_callback_log) {
                this.mLogger.info("removing pending tasks: " + this.mPendingTasks.keySet(), new Object[0]);
            }
            Iterator<Runnable> it = this.mPendingTasks.keySet().iterator();
            while (it.hasNext()) {
                this.mCallbackHandler.removeCallbacks(it.next());
            }
            this.mPendingTasks.clear();
            final TVKSurfaceDestroyedInfo generateSurfaceDestroyedInfo = TVKSurfaceDestroyedCostOptimizeHelper.generateSurfaceDestroyedInfo(iTVKRenderSurface, surface);
            Runnable runnable = new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video.a
                @Override // java.lang.Runnable
                public final void run() {
                    TVKThreadSwitchRenderSurfaceCallback.this.lambda$onSurfaceDestroyed$0(iTVKRenderSurface, surface, generateSurfaceDestroyedInfo);
                }
            };
            this.mTimeStatistics.point();
            if (!TVKSurfaceDestroyedCostOptimizeHelper.isSurfaceDestroyedAsyncForTextureView(iTVKRenderSurface) && !TVKSurfaceDestroyedCostOptimizeHelper.isSurfaceDestroyedAsyncForSurfaceView(iTVKRenderSurface)) {
                TVKSynchronousHandler.postAtQueueFrontAndWait(this.mCallbackHandler, runnable, 500L);
                this.mLogger.info("onSurfaceDestroyed cost=" + this.mTimeStatistics.costTimeMsFromLastPoint(), new Object[0]);
            }
            this.mCallbackHandler.postAtFrontOfQueue(runnable);
            this.mLogger.info("onSurfaceDestroyed cost=" + this.mTimeStatistics.costTimeMsFromLastPoint(), new Object[0]);
        } catch (IllegalArgumentException e16) {
            this.mLogger.printException(e16);
        }
    }
}
