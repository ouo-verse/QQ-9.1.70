package com.tencent.mobileqq.tritonaudio.webaudio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J\u001e\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u000fJ\u0016\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u000fJ\b\u0010*\u001a\u0004\u0018\u00010+J&\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020\u000fJ\u0016\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000fJ\u000e\u00104\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000fJ\u000e\u00105\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020\"J\u0010\u00107\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u00010\rJ\u0006\u00109\u001a\u00020\"J\u000e\u0010:\u001a\u00020\"2\u0006\u0010(\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManagerV2;", "", "logDelegate", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "(Lcom/tencent/mobileqq/triton/utils/LogDelegate;)V", "audioTrack", "Landroid/media/AudioTrack;", JoinPoint.SYNCHRONIZATION_LOCK, "", "getLogDelegate", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "setLogDelegate", "mArgument", "Lcom/tencent/mobileqq/triton/script/Argument;", "mAudioChannel", "", "mAudioFormat", "mAudioId", "mBufferId", "mBufferSize", "mInputChannelNum", "mInterval", "", "mOutputChannelNum", "mSampleRate", "onAudioProcessRunnable", "Ljava/lang/Runnable;", "sId", "Ljava/util/concurrent/atomic/AtomicInteger;", "getSId", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setSId", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "closeAudioContext", "", "combineChannelData", "lpLeftData", "lpRightData", c.E, "copyToChannel", "buffer", "channelId", "createAudioContext", "Lorg/json/JSONObject;", WebAudioPlugin.API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR, WebAudioPlugin.AUDIO_ID, "bufferSize", "inputChannelNum", "outputChannelNum", "getBufferId", "getChannelData", "bufferId", "initAudioConfig", "initAudioTrack", "resumeAudioContext", "startAudioProcess", "argument", "suspendAudioContext", "writeBuffer", "Companion", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class WebAudioManagerV2 {
    private static final String TAG = "WebAudioManagerV2";
    private AudioTrack audioTrack;

    @Nullable
    private LogDelegate logDelegate;
    private Argument mArgument;
    private int mBufferSize;
    private int mInputChannelNum;
    private long mInterval;
    private int mOutputChannelNum;
    private Runnable onAudioProcessRunnable;
    private int mSampleRate = 48000;
    private int mAudioFormat = 3;
    private int mAudioChannel = 12;
    private int mBufferId = 1;
    private int mAudioId = -1;
    private final byte[] lock = {0};

    @NotNull
    private AtomicInteger sId = new AtomicInteger();

    public WebAudioManagerV2(@Nullable LogDelegate logDelegate) {
        this.logDelegate = logDelegate;
    }

    public final void closeAudioContext() {
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
        }
    }

    @NotNull
    public final byte[] combineChannelData(@NotNull byte[] lpLeftData, @NotNull byte[] lpRightData, int len) {
        IntProgression step;
        Intrinsics.checkParameterIsNotNull(lpLeftData, "lpLeftData");
        Intrinsics.checkParameterIsNotNull(lpRightData, "lpRightData");
        byte[] bArr = new byte[len];
        step = RangesKt___RangesKt.step(new IntRange(0, (len / 2) - 2), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                int i3 = first * 2;
                bArr[i3] = lpLeftData[first];
                int i16 = first + 1;
                bArr[i3 + 1] = lpLeftData[i16];
                bArr[i3 + 2] = lpRightData[first];
                bArr[i3 + 3] = lpRightData[i16];
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        return bArr;
    }

    public final void copyToChannel(@NotNull final byte[] buffer, int channelId) {
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        TritonAudioThreadPool.getAudioThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManagerV2$copyToChannel$1
            @Override // java.lang.Runnable
            public final void run() {
                byte[] bArr;
                AudioTrack audioTrack;
                bArr = WebAudioManagerV2.this.lock;
                synchronized (bArr) {
                    audioTrack = WebAudioManagerV2.this.audioTrack;
                    if (audioTrack != null) {
                        byte[] bArr2 = buffer;
                        audioTrack.write(bArr2, 0, bArr2.length);
                    }
                }
            }
        });
    }

    @Nullable
    public final JSONObject createAudioContext() {
        int incrementAndGet = this.sId.incrementAndGet();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WebAudioPlugin.AUDIO_ID, incrementAndGet);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return jSONObject;
    }

    public final void createWebAudioScriptProcessor(int audioId, int bufferSize, int inputChannelNum, int outputChannelNum) {
        this.mAudioId = audioId;
        this.mInputChannelNum = inputChannelNum;
        this.mOutputChannelNum = outputChannelNum;
        this.mBufferSize = outputChannelNum * bufferSize;
        initAudioTrack(bufferSize);
    }

    public final int getBufferId() {
        int i3 = this.mBufferId;
        if (i3 == Integer.MAX_VALUE) {
            this.mBufferId = 0;
            return 0;
        }
        this.mBufferId = i3 + 1;
        return i3;
    }

    @NotNull
    public final byte[] getChannelData(int bufferId, int channelId) {
        return new byte[this.mBufferSize / this.mOutputChannelNum];
    }

    @Nullable
    public final LogDelegate getLogDelegate() {
        return this.logDelegate;
    }

    @NotNull
    public final AtomicInteger getSId() {
        return this.sId;
    }

    public final void initAudioConfig(int outputChannelNum) {
        int i3;
        if (outputChannelNum == 2) {
            this.mAudioChannel = 12;
        } else if (outputChannelNum == 1) {
            this.mAudioChannel = 4;
        }
        if (this.mAudioChannel == 3) {
            i3 = 8;
        } else {
            i3 = 16;
        }
        this.mInterval = (this.mBufferSize / (((i3 * this.mSampleRate) * this.mOutputChannelNum) / 8)) * 1000;
    }

    public final void initAudioTrack(int bufferSize) {
        initAudioConfig(this.mOutputChannelNum);
        this.audioTrack = new ReportAudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setSampleRate(this.mSampleRate).setEncoding(this.mAudioFormat).setChannelMask(this.mAudioChannel).build(), bufferSize, 1, 0);
    }

    public final void resumeAudioContext() {
        Argument argument;
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null && (argument = this.mArgument) != null) {
            audioTrack.flush();
            audioTrack.play();
            startAudioProcess(argument);
        }
    }

    public final void setLogDelegate(@Nullable LogDelegate logDelegate) {
        this.logDelegate = logDelegate;
    }

    public final void setSId(@NotNull AtomicInteger atomicInteger) {
        Intrinsics.checkParameterIsNotNull(atomicInteger, "<set-?>");
        this.sId = atomicInteger;
    }

    public final void startAudioProcess(@Nullable final Argument argument) {
        this.mArgument = argument;
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                audioTrack.play();
            } else {
                return;
            }
        }
        this.onAudioProcessRunnable = new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManagerV2$startAudioProcess$2
            @Override // java.lang.Runnable
            public void run() {
                AudioTrack audioTrack2;
                int i3;
                int i16;
                audioTrack2 = WebAudioManagerV2.this.audioTrack;
                if (audioTrack2 != null && audioTrack2.getPlayState() == 3) {
                    int bufferId = WebAudioManagerV2.this.getBufferId();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("bufferId", bufferId);
                        i3 = WebAudioManagerV2.this.mInputChannelNum;
                        jSONObject.put("inputChannelNum", i3);
                        i16 = WebAudioManagerV2.this.mOutputChannelNum;
                        jSONObject.put("outputChannelNum", i16);
                    } catch (JSONException e16) {
                        LogDelegate logDelegate = WebAudioManagerV2.this.getLogDelegate();
                        if (logDelegate != null) {
                            LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, "WebAudioManagerV2", "onAudioProcessRunnable " + e16.getMessage(), null, 8, null);
                        }
                    }
                    Argument argument2 = argument;
                    if (argument2 != null) {
                        argument2.subscribe(WebAudioPlugin.API_ON_WEB_AUDIO_SCRIPT_PROCESSOR, jSONObject.toString());
                    }
                    TritonAudioThreadPool.getAudioThreadPool().schedule(this, 80L, TimeUnit.MILLISECONDS);
                }
            }
        };
        TritonAudioThreadPool.getAudioThreadPool().execute(this.onAudioProcessRunnable);
    }

    public final void suspendAudioContext() {
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.pause();
            audioTrack.flush();
        }
    }

    public final void writeBuffer(@NotNull final byte[] buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        int i3 = this.mOutputChannelNum;
        int length = buffer.length / i3;
        byte[] bArr = new byte[length];
        for (int i16 = 0; i16 < length; i16++) {
            bArr[i16] = buffer[i16];
        }
        int length2 = buffer.length / i3;
        byte[] bArr2 = new byte[length2];
        for (int i17 = 0; i17 < length2; i17++) {
            bArr2[i17] = buffer[(buffer.length / i3) + i17];
        }
        final byte[] combineChannelData = combineChannelData(bArr, bArr2, buffer.length);
        TritonAudioThreadPool.getAudioThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManagerV2$writeBuffer$1
            @Override // java.lang.Runnable
            public final void run() {
                byte[] bArr3;
                AudioTrack audioTrack;
                bArr3 = WebAudioManagerV2.this.lock;
                synchronized (bArr3) {
                    audioTrack = WebAudioManagerV2.this.audioTrack;
                    if (audioTrack != null) {
                        audioTrack.write(combineChannelData, 0, buffer.length);
                    }
                }
            }
        });
    }
}
