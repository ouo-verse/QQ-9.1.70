package com.tencent.tavcut.core.render.rendernode.audio;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioFrame;
import org.light.AudioOutput;
import org.light.LightEngine;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/audio/LightAudioNode;", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "lightEngine", "Lorg/light/LightEngine;", "(Lorg/light/LightEngine;)V", "audioReader", "Lorg/light/AudioOutput;", "createAudioProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "getIdentifier", "", "AudioProcessorNode", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightAudioNode implements TAVAudioProcessorNode {
    private static final String TAG = "LightAudioNode";
    private final AudioOutput audioReader;

    public LightAudioNode(@NotNull LightEngine lightEngine) {
        Intrinsics.checkParameterIsNotNull(lightEngine, "lightEngine");
        AudioOutput audioOutput = lightEngine.audioOutput();
        Intrinsics.checkExpressionValueIsNotNull(audioOutput, "lightEngine.audioOutput()");
        this.audioReader = audioOutput;
    }

    @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
    @NotNull
    public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor() {
        return new AudioProcessorNode(this.audioReader);
    }

    @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
    @NotNull
    public String getIdentifier() {
        return TAG;
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/audio/LightAudioNode$AudioProcessorNode;", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "audioReader", "Lorg/light/AudioOutput;", "(Lorg/light/AudioOutput;)V", "audioMixer", "Lcom/tencent/tav/decoder/AudioMixer;", "getAudioMixer", "()Lcom/tencent/tav/decoder/AudioMixer;", "getAudioReader", "()Lorg/light/AudioOutput;", "processAudioPCM", "Ljava/nio/ByteBuffer;", "time", "Lcom/tencent/tav/coremedia/CMTime;", "pcmBuffer", "audioInfo", "Lcom/tencent/tav/decoder/AudioInfo;", "release", "", "seekTo", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    private static final class AudioProcessorNode implements TAVAudioProcessorNode.TAVAudioProcessorEffect {
        private static final float DEFAULT_PITCH = 1.0f;
        private static final float DEFAULT_SPEED = 1.0f;
        private static final float DEFAULT_VOLUME = 1.0f;

        @NotNull
        private final AudioMixer audioMixer;

        @NotNull
        private final AudioOutput audioReader;

        public AudioProcessorNode(@NotNull AudioOutput audioReader) {
            Intrinsics.checkParameterIsNotNull(audioReader, "audioReader");
            this.audioReader = audioReader;
            this.audioMixer = new AudioMixer();
        }

        @NotNull
        public final AudioMixer getAudioMixer() {
            return this.audioMixer;
        }

        @NotNull
        public final AudioOutput getAudioReader() {
            return this.audioReader;
        }

        @Override // com.tencent.tav.core.AudioTapProcessor
        @NotNull
        public ByteBuffer processAudioPCM(@Nullable CMTime time, @Nullable ByteBuffer pcmBuffer, @Nullable AudioInfo audioInfo) {
            Long l3;
            ByteBuffer byteBuffer;
            Long l16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("processAudioPCM current Time: ");
            ByteBuffer byteBuffer2 = null;
            if (time != null) {
                l3 = Long.valueOf(time.getTimeUs());
            } else {
                l3 = null;
            }
            sb5.append(l3);
            TavLogger.d(LightAudioNode.TAG, sb5.toString());
            AudioFrame copyNextSample = this.audioReader.copyNextSample();
            if (copyNextSample != null) {
                byteBuffer = copyNextSample.data;
            } else {
                byteBuffer = null;
            }
            if (byteBuffer != null) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("processAudioPCM sdk time : ");
            if (copyNextSample != null) {
                l16 = Long.valueOf(copyNextSample.pts);
            } else {
                l16 = null;
            }
            sb6.append(l16);
            TavLogger.d(LightAudioNode.TAG, sb6.toString());
            AudioMixer audioMixer = this.audioMixer;
            if (audioMixer != null) {
                byteBuffer2 = audioMixer.processBytes(byteBuffer, 1.0f, 1.0f, 1.0f);
            }
            Intrinsics.checkExpressionValueIsNotNull(byteBuffer2, "audioMixer?.processBytes\u2026FAULT_PITCH\n            )");
            return byteBuffer2;
        }

        @Override // com.tencent.tav.core.AudioTapProcessor
        public void release() {
            AudioMixer audioMixer = this.audioMixer;
            if (audioMixer != null) {
                audioMixer.release();
            }
            AudioOutput audioOutput = this.audioReader;
            if (audioOutput != null) {
                audioOutput.release();
            }
        }

        @Override // com.tencent.tav.core.AudioTapProcessor
        public void seekTo(@Nullable CMTime time) {
        }
    }
}
