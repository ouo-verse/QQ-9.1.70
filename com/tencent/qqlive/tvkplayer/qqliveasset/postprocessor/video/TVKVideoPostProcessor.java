package com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKColorBlindnessFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKDolbyVisionSoftRenderFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKSDREnhanceFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKVideoFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.TVKVideoFxType;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
import com.tencent.qqlive.tvkplayer.postprocess.api.ITVKVideoFxErrorListener;
import com.tencent.qqlive.tvkplayer.postprocess.api.ITVKVideoFxProcessorInternal;
import com.tencent.qqlive.tvkplayer.postprocess.api.TVKMonetCapability;
import com.tencent.qqlive.tvkplayer.postprocess.api.TVKPostProcessorFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKSurface;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface;
import com.tencent.thumbplayer.api.surface.TPSurface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes23.dex */
public class TVKVideoPostProcessor implements ITVKVideoFxProcessor, ITVKRenderSurface, ITVKRenderSurface.IVideoSurfaceCallback {
    private static final String TAG = "TVKVideoPostProcessor";
    private final Looper mCallbackLooper;
    private ITVKVideoFx mDVMAEffect;
    private final ITVKLogger mLogger;
    private ITVKVideoFx mSDREnhanceEffect;
    private ITVKVideoFx mSREffect;
    private final TVKQQLiveAssetPlayerContext mTVKQQLiveAssetPlayerContext;
    private final TVKThreadSwitchRenderSurfaceCallback mThreadSwitchRenderSurfaceCallback;
    private ITVKVideoFxProcessorInternal mVideoFxProcessorInternal;
    private boolean mIsPostProcessorConnected = false;
    private ITVKRenderSurface mOutputRenderSurface = null;

    @Nullable
    private TPSurface mInputTPSurface = null;
    private boolean mSDREnhanceEnabled = false;
    private boolean mDVMAEnabled = false;
    private boolean mBlindnessEnabled = false;
    private final List<ITVKRenderSurface.IVideoSurfaceCallback> mVideoSurfaceCallbackList = new CopyOnWriteArrayList();
    private final ITVKVideoViewBase.IVideoViewCallback mVideoViewCallback = new TVKVideoViewCallback();

    public TVKVideoPostProcessor(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Looper looper) {
        this.mTVKQQLiveAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mThreadSwitchRenderSurfaceCallback = new TVKThreadSwitchRenderSurfaceCallback(tVKQQLiveAssetPlayerContext, looper, this);
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, TAG);
        this.mCallbackLooper = looper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean activateInternalPostProcessor() {
        if (this.mVideoFxProcessorInternal != null) {
            return true;
        }
        ITVKVideoFxProcessorInternal createVideoFxProcessor = TVKPostProcessorFactory.createVideoFxProcessor(this.mCallbackLooper);
        this.mVideoFxProcessorInternal = createVideoFxProcessor;
        if (createVideoFxProcessor != null) {
            createVideoFxProcessor.setTVKPlayerLogTag(this.mTVKQQLiveAssetPlayerContext.getTag());
            return true;
        }
        return false;
    }

    private void callOnSurfaceChanged(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
        Iterator<ITVKRenderSurface.IVideoSurfaceCallback> it = this.mVideoSurfaceCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceChanged(iTVKRenderSurface, surface);
        }
    }

    private void callOnSurfaceCreated(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
        Iterator<ITVKRenderSurface.IVideoSurfaceCallback> it = this.mVideoSurfaceCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceCreated(iTVKRenderSurface, surface);
        }
    }

    private void callOnSurfaceDestroyed(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
        Iterator<ITVKRenderSurface.IVideoSurfaceCallback> it = this.mVideoSurfaceCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceDestroyed(iTVKRenderSurface, surface);
        }
    }

    private Surface getOutputSurface() {
        ITVKRenderSurface iTVKRenderSurface = this.mOutputRenderSurface;
        if (iTVKRenderSurface == null) {
            this.mLogger.info("OutputRenderSurface is null, getOutputSurface return null", new Object[0]);
            return null;
        }
        if (!iTVKRenderSurface.isSurfaceReady()) {
            this.mLogger.info("OutputRenderSurface is not ready, getOutputSurface return null", new Object[0]);
            return null;
        }
        return this.mOutputRenderSurface.getRenderSurface();
    }

    private void notifyVideoPostProcessInfoEvent() {
        TVKEventParams.VideoPostProcessInfoParam videoPostProcessInfoParam = new TVKEventParams.VideoPostProcessInfoParam();
        videoPostProcessInfoParam.videoPostProcessType = new ArrayList();
        if (isPostProcessorConnected()) {
            Iterator<ITVKVideoFx> it = this.mVideoFxProcessorInternal.currentFxs().iterator();
            while (it.hasNext()) {
                videoPostProcessInfoParam.videoPostProcessType.add(it.next().getEffectType());
            }
        }
        try {
            this.mTVKQQLiveAssetPlayerContext.getEventSender().sendEvent(TVKEventId.PLAYER_STATE_VIDEO_POST_PROCESS_INFO, 0, 0, "", videoPostProcessInfoParam);
        } catch (Exception e16) {
            this.mLogger.printException(e16);
        }
    }

    private void updateOutputSurface(@Nullable Surface surface) {
        if (!activateInternalPostProcessor()) {
            this.mLogger.warn("updateOutputSurface, post processor not available", new Object[0]);
            return;
        }
        this.mLogger.info("updateOutputSurface, surface=" + surface, new Object[0]);
        this.mVideoFxProcessorInternal.setOutputSurface(surface);
    }

    public void addDolbyVisionSoftRenderEffect() {
        if (!activateInternalPostProcessor()) {
            this.mLogger.error("post processor not available, can't add DolbyVisionSoftRender effect", new Object[0]);
            return;
        }
        if (this.mDVMAEffect == null) {
            this.mDVMAEffect = TVKPostProcessorFactory.createVideoFx(TVKVideoFxType.EFFECT_DOLBY_VISION_SOFT_RENDER);
        }
        if (!this.mDVMAEnabled) {
            addFxModel(this.mDVMAEffect);
        }
        this.mLogger.info("add DolbyVisionSoftRender(DVMA) effect success", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor
    public void addFxModel(ITVKVideoFx iTVKVideoFx) throws IllegalStateException {
        if (!activateInternalPostProcessor()) {
            this.mLogger.error("post processor is unavailable", new Object[0]);
            return;
        }
        if (iTVKVideoFx instanceof ITVKColorBlindnessFx) {
            this.mBlindnessEnabled = true;
        } else if (iTVKVideoFx instanceof ITVKSDREnhanceFx) {
            this.mSDREnhanceEnabled = true;
        } else if (iTVKVideoFx instanceof ITVKDolbyVisionSoftRenderFx) {
            this.mDVMAEnabled = true;
        }
        this.mVideoFxProcessorInternal.addFxModel(iTVKVideoFx);
        notifyVideoPostProcessInfoEvent();
    }

    public void addSDREnhanceEffect() {
        if (!activateInternalPostProcessor()) {
            this.mLogger.error("post processor not available, can't add SDREnhance effect", new Object[0]);
            return;
        }
        if (this.mSDREnhanceEffect == null) {
            this.mSDREnhanceEffect = TVKPostProcessorFactory.createVideoFx(TVKVideoFxType.EFFECT_SDR_ENHANCE);
        }
        addFxModel(this.mSDREnhanceEffect);
        this.mLogger.info("add SDREnhance effect success", new Object[0]);
    }

    public void addSuperResolutionEffect() {
        if (!activateInternalPostProcessor()) {
            this.mLogger.error("post processor not available, can't add superResolution effect", new Object[0]);
            return;
        }
        if (!TVKMonetCapability.isSuperResolutionSupported()) {
            this.mLogger.error("TVKCodecUtils.isSupportSuperResolution == false", new Object[0]);
            return;
        }
        if (this.mSREffect == null) {
            this.mSREffect = TVKPostProcessorFactory.createVideoFx(TVKVideoFxType.EFFECT_SUPER_RESOLUTION);
        }
        addFxModel(this.mSREffect);
        this.mLogger.info("add superResolution effect success", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void addVideoSurfaceCallBack(ITVKRenderSurface.IVideoSurfaceCallback iVideoSurfaceCallback) {
        if (iVideoSurfaceCallback != null && !this.mVideoSurfaceCallbackList.contains(iVideoSurfaceCallback)) {
            this.mVideoSurfaceCallbackList.add(iVideoSurfaceCallback);
        }
    }

    public boolean connectPostProcessor(int i3, int i16) {
        if (isPostProcessorConnected()) {
            this.mLogger.info("post processor already connected, return", new Object[0]);
            return true;
        }
        if (!activateInternalPostProcessor()) {
            this.mLogger.error("connectPostProcessor failed, post processor not available", new Object[0]);
            return false;
        }
        if (this.mVideoFxProcessorInternal.currentFxs().isEmpty()) {
            this.mLogger.info("No effects were added, no need to connect post processor", new Object[0]);
            return false;
        }
        SurfaceTexture inputSurfaceTexture = this.mVideoFxProcessorInternal.getInputSurfaceTexture();
        if (inputSurfaceTexture == null) {
            this.mLogger.error("connectPostProcessor failed, surfaceTexture is null", new Object[0]);
            return false;
        }
        this.mLogger.info("connectPostProcessor start", new Object[0]);
        inputSurfaceTexture.setDefaultBufferSize(i3, i16);
        this.mInputTPSurface = new TVKSurface(inputSurfaceTexture).getTPSurface();
        this.mVideoFxProcessorInternal.setOutputSurface(getOutputSurface());
        this.mVideoFxProcessorInternal.setTVKPlayerLogTag(this.mTVKQQLiveAssetPlayerContext.getTag());
        this.mIsPostProcessorConnected = true;
        callOnSurfaceChanged(this, this.mInputTPSurface);
        notifyVideoPostProcessInfoEvent();
        this.mLogger.info("connectPostProcessor success! playCore use TPSurface now", new Object[0]);
        return true;
    }

    public boolean disconnectPostProcessor() {
        if (!isPostProcessorConnected()) {
            this.mLogger.info("post processor already disconnected, return", new Object[0]);
            return true;
        }
        if (!this.mVideoFxProcessorInternal.currentFxs().isEmpty()) {
            this.mLogger.info("has other effect, no need deactivate", new Object[0]);
            return false;
        }
        notifyVideoPostProcessInfoEvent();
        this.mLogger.info("disconnectPostProcessor start", new Object[0]);
        reset();
        this.mIsPostProcessorConnected = false;
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public Surface getRenderSurface() {
        if (this.mIsPostProcessorConnected) {
            this.mLogger.info("post processor connected, return TPSurface", new Object[0]);
            return this.mInputTPSurface;
        }
        this.mLogger.info("post processor disconnected, return outputSurface", new Object[0]);
        return getOutputSurface();
    }

    public boolean isBlindnessEnabled() {
        return this.mBlindnessEnabled;
    }

    public boolean isPostProcessorConnected() {
        if (!activateInternalPostProcessor()) {
            return false;
        }
        return this.mIsPostProcessorConnected;
    }

    public boolean isSDREnhanceEnabled() {
        return this.mSDREnhanceEnabled;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public boolean isSurfaceReady() {
        boolean z16 = true;
        if (this.mIsPostProcessorConnected) {
            if (this.mInputTPSurface == null) {
                z16 = false;
            }
            this.mLogger.info("post processor connected, TPSurface is ready: " + z16, new Object[0]);
        } else {
            ITVKRenderSurface iTVKRenderSurface = this.mOutputRenderSurface;
            if (iTVKRenderSurface == null || !iTVKRenderSurface.isSurfaceReady()) {
                z16 = false;
            }
            this.mLogger.info("post processor disconnected, outputSurface is ready: " + z16, new Object[0]);
        }
        return z16;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
    public void onSurfaceChanged(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
        this.mLogger.info("renderSurface onSurfaceChanged", new Object[0]);
        if (this.mOutputRenderSurface != iTVKRenderSurface) {
            this.mLogger.warn("unexpected callback. Ignore it", new Object[0]);
            return;
        }
        updateOutputSurface(surface);
        if (!isPostProcessorConnected()) {
            callOnSurfaceChanged(iTVKRenderSurface, surface);
        } else {
            callOnSurfaceChanged(this, this.mInputTPSurface);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
    public void onSurfaceCreated(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
        this.mLogger.info("renderSurface onSurfaceCreated", new Object[0]);
        if (this.mOutputRenderSurface != iTVKRenderSurface) {
            this.mLogger.warn("unexpected callback. Ignore it", new Object[0]);
            return;
        }
        updateOutputSurface(surface);
        if (!isPostProcessorConnected()) {
            callOnSurfaceCreated(iTVKRenderSurface, surface);
        } else {
            callOnSurfaceCreated(this, this.mInputTPSurface);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
    public void onSurfaceDestroyed(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
        this.mLogger.info("renderSurface onSurfaceDestroyed", new Object[0]);
        if (this.mOutputRenderSurface != iTVKRenderSurface) {
            this.mLogger.warn("unexpected callback. Ignore it", new Object[0]);
            return;
        }
        updateOutputSurface(null);
        if (!isPostProcessorConnected()) {
            callOnSurfaceDestroyed(iTVKRenderSurface, surface);
        } else {
            callOnSurfaceDestroyed(this, this.mInputTPSurface);
        }
    }

    public void releaseProcessor() {
        if (activateInternalPostProcessor()) {
            this.mVideoFxProcessorInternal.destroy();
        }
        ITVKRenderSurface iTVKRenderSurface = this.mOutputRenderSurface;
        if (iTVKRenderSurface != null) {
            iTVKRenderSurface.removeVideoSurfaceCallBack(this.mThreadSwitchRenderSurfaceCallback);
        }
        ITVKRenderSurface iTVKRenderSurface2 = this.mOutputRenderSurface;
        if (iTVKRenderSurface2 instanceof ITVKVideoViewBase) {
            ((ITVKVideoViewBase) iTVKRenderSurface2).removeViewCallback(this.mVideoViewCallback);
        }
    }

    public void removeDolbyVisionSoftRenderEffect() {
        removeFx(this.mDVMAEffect);
        this.mDVMAEffect = null;
        this.mLogger.info("remove DolbyVisionSoftRender(DVMA) effect success", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor
    public void removeFx(ITVKVideoFx iTVKVideoFx) {
        if (!activateInternalPostProcessor()) {
            this.mLogger.error("post processor is unavailable", new Object[0]);
            return;
        }
        if (iTVKVideoFx instanceof ITVKColorBlindnessFx) {
            this.mBlindnessEnabled = false;
        } else if (iTVKVideoFx instanceof ITVKSDREnhanceFx) {
            this.mSDREnhanceEnabled = false;
        } else if (iTVKVideoFx instanceof ITVKDolbyVisionSoftRenderFx) {
            this.mDVMAEnabled = false;
        }
        this.mVideoFxProcessorInternal.removeFx(iTVKVideoFx);
        notifyVideoPostProcessInfoEvent();
    }

    public void removeSDREnhanceEffect() {
        removeFx(this.mSDREnhanceEffect);
        this.mLogger.info("remove SDREnhance effect success", new Object[0]);
    }

    public void removeSuperResolutionEffect() {
        removeFx(this.mSREffect);
        this.mLogger.info("remove superResolution effect success", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void removeVideoSurfaceCallBack(ITVKRenderSurface.IVideoSurfaceCallback iVideoSurfaceCallback) {
        this.mVideoSurfaceCallbackList.remove(iVideoSurfaceCallback);
    }

    public void reset() {
        this.mLogger.info("reset (dvma)", new Object[0]);
        this.mInputTPSurface = null;
        this.mSDREnhanceEnabled = false;
        this.mBlindnessEnabled = false;
        this.mDVMAEnabled = false;
        this.mIsPostProcessorConnected = false;
        if (activateInternalPostProcessor()) {
            this.mVideoFxProcessorInternal.destroy();
        }
        this.mDVMAEffect = null;
        callOnSurfaceChanged(this, getOutputSurface());
        this.mLogger.info("reset (dvma) done. disconnect post processor success! playCore use OutputSurface now", new Object[0]);
    }

    public void setErrorListener(@NonNull ITVKVideoFxErrorListener iTVKVideoFxErrorListener) {
        if (!activateInternalPostProcessor()) {
            return;
        }
        this.mVideoFxProcessorInternal.setErrorListener(iTVKVideoFxErrorListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void setFixedSize(int i3, int i16) {
        if (!activateInternalPostProcessor()) {
            this.mLogger.warn("setFixedSize, post processor not available", new Object[0]);
            return;
        }
        this.mLogger.info("setFixedSize", new Object[0]);
        if (this.mVideoFxProcessorInternal.getInputSurfaceTexture() != null) {
            this.mVideoFxProcessorInternal.getInputSurfaceTexture().setDefaultBufferSize(i3, i16);
        } else {
            this.mLogger.warn("setFixedSize, mVideoFxProcessorInternal.getRenderObject() == null", new Object[0]);
        }
    }

    public void setOutputRenderSurface(@Nullable ITVKRenderSurface iTVKRenderSurface) {
        ITVKRenderSurface iTVKRenderSurface2 = this.mOutputRenderSurface;
        if (iTVKRenderSurface2 != null) {
            iTVKRenderSurface2.removeVideoSurfaceCallBack(this.mThreadSwitchRenderSurfaceCallback);
        }
        ITVKRenderSurface iTVKRenderSurface3 = this.mOutputRenderSurface;
        if (iTVKRenderSurface3 instanceof ITVKVideoViewBase) {
            ((ITVKVideoViewBase) iTVKRenderSurface3).removeViewCallback(this.mVideoViewCallback);
        }
        if (iTVKRenderSurface != null) {
            iTVKRenderSurface.addVideoSurfaceCallBack(this.mThreadSwitchRenderSurfaceCallback);
        }
        this.mOutputRenderSurface = iTVKRenderSurface;
        updateOutputSurface(getOutputSurface());
        if (iTVKRenderSurface instanceof ITVKVideoViewBase) {
            ((ITVKVideoViewBase) iTVKRenderSurface).addViewCallback(this.mVideoViewCallback);
        }
    }

    /* loaded from: classes23.dex */
    public class TVKVideoViewCallback implements ITVKVideoViewBase.IVideoViewCallback {
        public TVKVideoViewCallback() {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceChanged(ITVKVideoViewBase iTVKVideoViewBase, Surface surface, int i3, int i16) {
            if (TVKVideoPostProcessor.this.activateInternalPostProcessor()) {
                TVKVideoPostProcessor.this.mVideoFxProcessorInternal.notifyOutputSurfaceSizeChanged(i3, i16);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceCreated(ITVKVideoViewBase iTVKVideoViewBase, Surface surface) {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceDestroyed(ITVKVideoViewBase iTVKVideoViewBase, Surface surface) {
        }
    }
}
