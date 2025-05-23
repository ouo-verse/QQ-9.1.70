package ge4;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import ee4.b;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0007\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lge4/a;", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "", "getIdentifier", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "createAudioProcessor", "Lorg/light/AudioOutput;", "a", "Lorg/light/AudioOutput;", "audioReader", "Lorg/light/LightEngine;", "lightEngine", "<init>", "(Lorg/light/LightEngine;)V", "b", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a implements TAVAudioProcessorNode {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AudioOutput audioReader;

    public a(@NotNull LightEngine lightEngine) {
        Intrinsics.checkParameterIsNotNull(lightEngine, "lightEngine");
        AudioOutput audioOutput = lightEngine.audioOutput();
        Intrinsics.checkExpressionValueIsNotNull(audioOutput, "lightEngine.audioOutput()");
        this.audioReader = audioOutput;
    }

    @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
    @NotNull
    public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor() {
        return new C10372a(this.audioReader);
    }

    @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
    @NotNull
    public String getIdentifier() {
        return "LightAudioNode";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lge4/a$a;", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "Lcom/tencent/tav/coremedia/CMTime;", "time", "Ljava/nio/ByteBuffer;", "pcmBuffer", "Lcom/tencent/tav/decoder/AudioInfo;", "audioInfo", "processAudioPCM", "", "seekTo", "release", "Lcom/tencent/tav/decoder/AudioMixer;", "a", "Lcom/tencent/tav/decoder/AudioMixer;", "getAudioMixer", "()Lcom/tencent/tav/decoder/AudioMixer;", "audioMixer", "Lorg/light/AudioOutput;", "b", "Lorg/light/AudioOutput;", "getAudioReader", "()Lorg/light/AudioOutput;", "audioReader", "<init>", "(Lorg/light/AudioOutput;)V", "c", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: ge4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private static final class C10372a implements TAVAudioProcessorNode.TAVAudioProcessorEffect {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AudioMixer audioMixer;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AudioOutput audioReader;

        public C10372a(@NotNull AudioOutput audioReader) {
            Intrinsics.checkParameterIsNotNull(audioReader, "audioReader");
            this.audioReader = audioReader;
            this.audioMixer = new AudioMixer();
        }

        @Override // com.tencent.tav.core.AudioTapProcessor
        @NotNull
        public ByteBuffer processAudioPCM(@Nullable CMTime time, @Nullable ByteBuffer pcmBuffer, @Nullable AudioInfo audioInfo) {
            Long l3;
            ByteBuffer byteBuffer;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("processAudioPCM current Time: ");
            ByteBuffer byteBuffer2 = null;
            if (time != null) {
                l3 = Long.valueOf(time.getTimeUs());
            } else {
                l3 = null;
            }
            sb5.append(l3);
            b.a("LightAudioNode", sb5.toString());
            AudioFrame copyNextSample = this.audioReader.copyNextSample();
            if (copyNextSample != null) {
                byteBuffer = copyNextSample.data;
            } else {
                byteBuffer = null;
            }
            if (byteBuffer != null) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            }
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
