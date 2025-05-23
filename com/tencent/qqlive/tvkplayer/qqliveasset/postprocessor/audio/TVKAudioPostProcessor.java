package com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.audio;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKAudioEffectInfo;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioPostProcessorListener;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;
import com.tencent.qqlive.tvkplayer.postprocess.api.ITVKTPAudioProcessorInternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKAudioEffectUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;

/* loaded from: classes23.dex */
public class TVKAudioPostProcessor implements ITVKAudioFxProcessor {
    private static final String TAG = "TVKAudioPostProcessor";

    @NonNull
    private final Handler mCallbackHandler;
    private boolean mIsTpProcessorConnected = false;
    private ITVKAudioPostProcessorListener mListener;

    @NonNull
    private final ITVKLogger mLogger;
    private final ITVKTPAudioProcessorInternal mTpAudioProcessor;

    public TVKAudioPostProcessor(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Looper looper, @Nullable Looper looper2) {
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, TAG);
        this.mTpAudioProcessor = (ITVKTPAudioProcessorInternal) new TVKTPAudioProcessorProxy(tVKQQLiveAssetPlayerContext, looper).getProxyInstance();
        this.mCallbackHandler = new Handler(looper2 == null ? Looper.getMainLooper() : looper2);
    }

    private void notifyEffectDisabledIfNeed() {
        final ITVKAudioFx currentEffect = this.mTpAudioProcessor.currentEffect();
        if (currentEffect == null) {
            return;
        }
        TVKAudioEffectInfo[] supportedAudioEffectInfo = this.mTpAudioProcessor.getSupportedAudioEffectInfo();
        boolean z16 = false;
        if (supportedAudioEffectInfo != null) {
            int length = supportedAudioEffectInfo.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (TVKAudioEffectUtils.convertToAudioEffectTypeByObject(currentEffect) == supportedAudioEffectInfo[i3].getEffectType()) {
                    z16 = true;
                    break;
                }
                i3++;
            }
        }
        if (!z16) {
            this.mTpAudioProcessor.removeEffect(currentEffect);
            final ITVKAudioPostProcessorListener iTVKAudioPostProcessorListener = this.mListener;
            if (iTVKAudioPostProcessorListener == null) {
                return;
            }
            this.mCallbackHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.audio.TVKAudioPostProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    iTVKAudioPostProcessorListener.onCurrentEffectDisable(currentEffect);
                }
            });
        }
    }

    private void notifySupportedAudioEffectInfoUpdate() {
        final ITVKAudioPostProcessorListener iTVKAudioPostProcessorListener = this.mListener;
        if (iTVKAudioPostProcessorListener == null) {
            return;
        }
        this.mCallbackHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.audio.TVKAudioPostProcessor.2
            @Override // java.lang.Runnable
            public void run() {
                iTVKAudioPostProcessorListener.onSupportedAudioEffectInfoUpdate();
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    public boolean addEffect(ITVKAudioFx iTVKAudioFx) {
        return this.mTpAudioProcessor.addEffect(iTVKAudioFx);
    }

    public void connectPostProcessor() {
        this.mLogger.info("connectPostProcessor", new Object[0]);
        this.mTpAudioProcessor.connect();
        this.mIsTpProcessorConnected = true;
    }

    public void disconnectPostProcessor() {
        this.mLogger.info("disconnectPostProcessor success", new Object[0]);
        this.mTpAudioProcessor.disconnect();
        this.mIsTpProcessorConnected = false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    public TVKAudioEffectInfo[] getSupportedAudioEffectInfo() {
        return this.mTpAudioProcessor.getSupportedAudioEffectInfo();
    }

    public boolean isPostProcessorConnected() {
        return this.mIsTpProcessorConnected;
    }

    public void onCGIRequestSuccess() {
        notifyEffectDisabledIfNeed();
        notifySupportedAudioEffectInfoUpdate();
    }

    public void onPlayerTypeChange(int i3) {
        if (i3 == 2) {
            this.mLogger.info("player to selfDev player, audio effect available", new Object[0]);
        } else {
            this.mLogger.info("player to system player, audio effect not available", new Object[0]);
        }
        notifyEffectDisabledIfNeed();
        notifySupportedAudioEffectInfoUpdate();
    }

    public void releaseProcessor() {
        this.mTpAudioProcessor.destroy();
        this.mCallbackHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    public void removeAllEffects() {
        this.mTpAudioProcessor.removeAllEffects();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    public void removeEffect(ITVKAudioFx iTVKAudioFx) {
        this.mTpAudioProcessor.removeEffect(iTVKAudioFx);
    }

    public void reset() {
        this.mTpAudioProcessor.reset();
        this.mIsTpProcessorConnected = false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    public void setListener(ITVKAudioPostProcessorListener iTVKAudioPostProcessorListener) {
        this.mListener = iTVKAudioPostProcessorListener;
    }
}
