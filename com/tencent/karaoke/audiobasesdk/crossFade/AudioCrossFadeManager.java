package com.tencent.karaoke.audiobasesdk.crossFade;

import com.tencent.component.utils.LogUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0016\u0018\u0000 12\u00020\u0001:\u000201B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J>\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ,\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u000bJ\u0016\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003J\u0016\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003J\u0016\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\u0016\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u00062"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/crossFade/AudioCrossFadeManager;", "", "sampleRate", "", WadlProxyConsts.CHANNEL, "(II)V", "audioCrossFadeUtils", "Lcom/tencent/karaoke/audiobasesdk/crossFade/AudioCrossFadeUtils;", "getChannel", "()I", "inited", "", "released", "getSampleRate", "GetFirstPcmWeight", "", "GetSecondPcmWeight", "getErrorCode", "init", "", "processConcat", "inBuffer1", "", "inBufferLen1", "inBuffer2", "inBufLen2", "outBuffer", "outBufLen", "", "processFadeIn", "inBuffer", "inBufferLen", "release", "resetConcat", "setConcatLen", "buffLen1", "buffLen2", "setConcatMs", "startDurationMs", "endDurationMs", "setFadeInMs", "startMs", "ms", "setFastFadeInMode", "flag", "setSeekFadeInMs", "currentMs", "totalMs", "Builder", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class AudioCrossFadeManager {
    private static volatile boolean isSoLoaded;
    private final AudioCrossFadeUtils audioCrossFadeUtils;
    private final int channel;
    private volatile boolean inited;
    private volatile boolean released;
    private final int sampleRate;
    private static final String TAG = TAG;
    private static final String TAG = TAG;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/crossFade/AudioCrossFadeManager$Builder;", "", "()V", WadlProxyConsts.CHANNEL, "", "getChannel", "()I", "setChannel", "(I)V", "sampleRate", "getSampleRate", "setSampleRate", "build", "Lcom/tencent/karaoke/audiobasesdk/crossFade/AudioCrossFadeManager;", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Builder {
        private int channel = -1;
        private int sampleRate = -1;

        @Nullable
        public final AudioCrossFadeManager build() {
            LogUtil.i(AudioCrossFadeManager.TAG, " build channel (" + this.channel + "), sampleRate(" + this.sampleRate + ')');
            if (this.channel == -1 || this.sampleRate == -1) {
                LogUtil.e(AudioCrossFadeManager.TAG, "must set channel (" + this.channel + ") and sampleRate(" + this.sampleRate + ')');
                throw new Throwable("must set channel (" + this.channel + ") and sampleRate(" + this.sampleRate + ')');
            }
            try {
                if (!AudioCrossFadeManager.isSoLoaded) {
                    AudioCrossFadeManager.isSoLoaded = AudiobaseContext.loadLibrary();
                    LogUtil.i(AudioCrossFadeManager.TAG, "Builder load result : " + AudioCrossFadeManager.isSoLoaded + TokenParser.SP);
                }
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (!AudioCrossFadeManager.isSoLoaded) {
                    return null;
                }
                return new AudioCrossFadeManager(this.sampleRate, this.channel, defaultConstructorMarker);
            } catch (Exception e16) {
                LogUtil.e(AudioCrossFadeManager.TAG, "loadlibrary error: " + e16.getMessage());
                throw new Throwable("loadlibrary error error(" + e16.getMessage());
            }
        }

        public final int getChannel() {
            return this.channel;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public final void setChannel(int i3) {
            this.channel = i3;
        }

        public final void setSampleRate(int i3) {
            this.sampleRate = i3;
        }
    }

    AudioCrossFadeManager(int i3, int i16) {
        this.sampleRate = i3;
        this.channel = i16;
        this.audioCrossFadeUtils = new AudioCrossFadeUtils();
    }

    public final float GetFirstPcmWeight() {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return -1.0f;
        }
        return this.audioCrossFadeUtils.GetFirstPcmWeight();
    }

    public final float GetSecondPcmWeight() {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return -1.0f;
        }
        return this.audioCrossFadeUtils.GetSecondPcmWeight();
    }

    public final int getChannel() {
        return this.channel;
    }

    public final int getErrorCode() {
        Integer num;
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return -1;
        }
        AudioCrossFadeUtils audioCrossFadeUtils = this.audioCrossFadeUtils;
        if (audioCrossFadeUtils != null) {
            num = Integer.valueOf(audioCrossFadeUtils.GetLastError());
        } else {
            num = null;
        }
        return num.intValue();
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final void init() {
        if (this.inited) {
            return;
        }
        this.inited = this.audioCrossFadeUtils.init(this.sampleRate, this.channel);
        LogUtil.i(TAG, "init : " + this.inited);
    }

    public final boolean processConcat(@Nullable byte[] inBuffer1, int inBufferLen1, @Nullable byte[] inBuffer2, int inBufLen2, @Nullable byte[] outBuffer, @Nullable int[] outBufLen) {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.audioCrossFadeUtils.ProcessConcat(inBuffer1, inBufferLen1, inBuffer2, inBufLen2, outBuffer, outBufLen);
    }

    public final boolean processFadeIn(@Nullable byte[] inBuffer, int inBufferLen, @Nullable byte[] outBuffer, @Nullable int[] outBufLen) {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.audioCrossFadeUtils.ProcessFadeIn(inBuffer, inBufferLen, outBuffer, outBufLen);
    }

    public final void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.inited = false;
        this.audioCrossFadeUtils.uninit();
    }

    public final boolean resetConcat() {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.audioCrossFadeUtils.resetConcat();
    }

    public final boolean setConcatLen(int buffLen1, int buffLen2) {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.audioCrossFadeUtils.SetConcatLen(buffLen1, buffLen2);
    }

    public final boolean setConcatMs(int startDurationMs, int endDurationMs) {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.audioCrossFadeUtils.SetConcatMs(startDurationMs, endDurationMs);
    }

    public final boolean setFadeInMs(int startMs, int ms5) {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.audioCrossFadeUtils.SetFadeInMs(startMs, ms5);
    }

    public final boolean setFastFadeInMode(boolean flag) {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.audioCrossFadeUtils.SetFastFadeInMode(flag);
    }

    public final boolean setSeekFadeInMs(int currentMs, int totalMs) {
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.audioCrossFadeUtils.SetSeekFadeInMs(currentMs, totalMs);
    }

    public /* synthetic */ AudioCrossFadeManager(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16);
    }
}
