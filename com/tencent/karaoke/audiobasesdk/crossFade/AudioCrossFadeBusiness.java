package com.tencent.karaoke.audiobasesdk.crossFade;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.crossFade.AudioCrossFadeManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0015J>\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ,\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\"\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010#\u001a\u00020\u0015J\u0006\u0010$\u001a\u00020\u0017J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bJ\u0016\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bJ\u0016\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bJ\u000e\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0017J\u0016\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f\u00a8\u00063"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/crossFade/AudioCrossFadeBusiness;", "", "()V", "TAG", "", "audioCrossFadeManager", "Lcom/tencent/karaoke/audiobasesdk/crossFade/AudioCrossFadeManager;", "pcmChannel", "", "getPcmChannel", "()I", "setPcmChannel", "(I)V", "pcmSampleRate", "getPcmSampleRate", "setPcmSampleRate", "getFirstWeight", "", "getLastErrorCode", "getSecondWeight", "prepare", "", "processConcat", "", "inBuffer1", "", "inBufferLen1", "inBuffer2", "inBufLen2", "outBuffer", "outBufLen", "", "processFadeIn", "inBuffer", "inBufferLen", "release", "resetConcat", "setConcatLen", "buffLen1", "buffLen2", "setConcatMs", "startDurationMs", "endDurationMs", "setFadeInMs", "startMs", "ms", "setFastFadeInMode", "flag", "setSetSeekFade", "curMs", "totalMs", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class AudioCrossFadeBusiness {
    private AudioCrossFadeManager audioCrossFadeManager;
    private final String TAG = "AudioCrossFadeBusiness";
    private int pcmChannel = -1;
    private int pcmSampleRate = -1;

    public final float getFirstWeight() {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.GetFirstPcmWeight();
        }
        return -1.0f;
    }

    public final int getLastErrorCode() {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.getErrorCode();
        }
        return -1;
    }

    public final int getPcmChannel() {
        return this.pcmChannel;
    }

    public final int getPcmSampleRate() {
        return this.pcmSampleRate;
    }

    public final float getSecondWeight() {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.GetSecondPcmWeight();
        }
        return -1.0f;
    }

    public final void prepare() {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            audioCrossFadeManager.release();
        }
        AudioCrossFadeManager.Builder builder = new AudioCrossFadeManager.Builder();
        builder.setChannel(this.pcmChannel);
        builder.setSampleRate(this.pcmSampleRate);
        AudioCrossFadeManager build = builder.build();
        if (build != null) {
            build.init();
        } else {
            build = null;
        }
        this.audioCrossFadeManager = build;
        LogUtil.i(this.TAG, "prepare pcmChannel:" + this.pcmChannel + ", pcmSampleRate:" + this.pcmSampleRate);
    }

    public final boolean processConcat(@Nullable byte[] inBuffer1, int inBufferLen1, @Nullable byte[] inBuffer2, int inBufLen2, @Nullable byte[] outBuffer, @Nullable int[] outBufLen) {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.processConcat(inBuffer1, inBufferLen1, inBuffer2, inBufLen2, outBuffer, outBufLen);
        }
        return false;
    }

    public final boolean processFadeIn(@Nullable byte[] inBuffer, int inBufferLen, @Nullable byte[] outBuffer, @Nullable int[] outBufLen) {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.processFadeIn(inBuffer, inBufferLen, outBuffer, outBufLen);
        }
        return false;
    }

    public final void release() {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            audioCrossFadeManager.release();
        }
    }

    public final boolean resetConcat() {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.resetConcat();
        }
        return false;
    }

    public final boolean setConcatLen(int buffLen1, int buffLen2) {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.setConcatLen(buffLen1, buffLen2);
        }
        return false;
    }

    public final boolean setConcatMs(int startDurationMs, int endDurationMs) {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.setConcatMs(startDurationMs, endDurationMs);
        }
        return false;
    }

    public final boolean setFadeInMs(int startMs, int ms5) {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.setFadeInMs(startMs, ms5);
        }
        return false;
    }

    public final boolean setFastFadeInMode(boolean flag) {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.setFastFadeInMode(flag);
        }
        return false;
    }

    public final void setPcmChannel(int i3) {
        this.pcmChannel = i3;
    }

    public final void setPcmSampleRate(int i3) {
        this.pcmSampleRate = i3;
    }

    public final boolean setSetSeekFade(int curMs, int totalMs) {
        AudioCrossFadeManager audioCrossFadeManager = this.audioCrossFadeManager;
        if (audioCrossFadeManager != null) {
            return audioCrossFadeManager.setSeekFadeInMs(curMs, totalMs);
        }
        return false;
    }
}
