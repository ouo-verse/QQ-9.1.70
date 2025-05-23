package com.tencent.tavcut.core.render.audio.wave;

import com.tencent.tavcut.core.render.log.TavLogger;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0016J\b\u0010!\u001a\u00020\u001aH\u0002R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/wave/AudioWaveDataCalculator;", "Lcom/tencent/tavcut/core/render/audio/wave/IAudioWaveDataCalculator;", "sampleRate", "", "channelCount", "encodingPcmBit", "perSecondSample", "(IIII)V", "getChannelCount", "()I", "getEncodingPcmBit", "filterLength", "getPerSecondSample", "sampleCount", "getSampleRate", "sumSample", "", "waveFormData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioPcmToWaveData", "", "pcmByteBuffer", "Ljava/nio/ByteBuffer;", "decimateByteSample", "", "input", "decimateFloatSample", "Ljava/nio/FloatBuffer;", "decimateShortSample", "Ljava/nio/ShortBuffer;", "getWaveDataList", "putData", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class AudioWaveDataCalculator implements IAudioWaveDataCalculator {
    private static final String TAG = "WaveDataCalculator";
    private final int channelCount;
    private final int encodingPcmBit;
    private int filterLength;
    private final int perSecondSample;
    private int sampleCount;
    private final int sampleRate;
    private double sumSample;
    private final ArrayList<Float> waveFormData = new ArrayList<>();

    public AudioWaveDataCalculator(int i3, int i16, int i17, int i18) {
        this.sampleRate = i3;
        this.channelCount = i16;
        this.encodingPcmBit = i17;
        this.perSecondSample = i18;
        this.filterLength = -1;
        this.filterLength = (i3 * i16) / i18;
    }

    private final void decimateByteSample(ByteBuffer input) {
        while (input.hasRemaining()) {
            this.sumSample += Math.abs((int) input.get());
            putData();
        }
    }

    private final void decimateFloatSample(FloatBuffer input) {
        while (input.hasRemaining()) {
            this.sumSample += Math.abs(input.get());
            putData();
        }
    }

    private final void decimateShortSample(ShortBuffer input) {
        while (input.hasRemaining()) {
            this.sumSample += Math.abs((int) input.get());
            putData();
        }
    }

    private final void putData() {
        double d16;
        double d17;
        int i3;
        int i16 = this.sampleCount + 1;
        this.sampleCount = i16;
        if (i16 >= this.filterLength) {
            int i17 = this.encodingPcmBit;
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 4) {
                        d16 = this.sumSample;
                    } else {
                        d16 = this.sumSample;
                        d17 = i16 * Float.MAX_VALUE;
                        this.waveFormData.add(Float.valueOf(Math.abs((float) (d16 / d17))));
                        this.sampleCount = 0;
                        this.sumSample = 0.0d;
                    }
                } else {
                    d16 = this.sumSample;
                    i3 = i16 * 127;
                    d17 = i3;
                    this.waveFormData.add(Float.valueOf(Math.abs((float) (d16 / d17))));
                    this.sampleCount = 0;
                    this.sumSample = 0.0d;
                }
            } else {
                d16 = this.sumSample;
            }
            i3 = i16 * 32767;
            d17 = i3;
            this.waveFormData.add(Float.valueOf(Math.abs((float) (d16 / d17))));
            this.sampleCount = 0;
            this.sumSample = 0.0d;
        }
    }

    @Override // com.tencent.tavcut.core.render.audio.wave.IAudioWaveDataCalculator
    @NotNull
    public List<Float> audioPcmToWaveData(@NotNull ByteBuffer pcmByteBuffer) {
        Intrinsics.checkParameterIsNotNull(pcmByteBuffer, "pcmByteBuffer");
        int i3 = this.encodingPcmBit;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    TavLogger.e(TAG, "not support bitWidth  = " + this.encodingPcmBit + TokenParser.SP);
                } else {
                    FloatBuffer asFloatBuffer = pcmByteBuffer.asFloatBuffer();
                    Intrinsics.checkExpressionValueIsNotNull(asFloatBuffer, "pcmByteBuffer.asFloatBuffer()");
                    decimateFloatSample(asFloatBuffer);
                }
            } else {
                decimateByteSample(pcmByteBuffer);
            }
        } else {
            ShortBuffer asShortBuffer = pcmByteBuffer.asShortBuffer();
            Intrinsics.checkExpressionValueIsNotNull(asShortBuffer, "pcmByteBuffer.asShortBuffer()");
            decimateShortSample(asShortBuffer);
        }
        return this.waveFormData;
    }

    public final int getChannelCount() {
        return this.channelCount;
    }

    public final int getEncodingPcmBit() {
        return this.encodingPcmBit;
    }

    public final int getPerSecondSample() {
        return this.perSecondSample;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    @Override // com.tencent.tavcut.core.render.audio.wave.IAudioWaveDataCalculator
    @NotNull
    public List<Float> getWaveDataList() {
        return this.waveFormData;
    }
}
