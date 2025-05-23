package com.tencent.tavcut.core.render.builder.light;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.tavcut.core.render.audio.voicechanger.VoiceChanger;
import com.tencent.tavcut.core.render.builder.light.LightRenderChainManager;
import com.tencent.tavcut.core.render.builder.light.model.type.VoiceEnum;
import com.tencent.videocut.utils.a;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioFrame;
import org.light.IExternalAudioProcessor;
import org.light.MovieController;
import rd4.c;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J \u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/VoiceChangerWrapper;", "", "()V", "currentVoice", "Lcom/tencent/tavcut/core/render/builder/light/model/type/VoiceEnum;", "getCurrentVoice", "()Lcom/tencent/tavcut/core/render/builder/light/model/type/VoiceEnum;", "setCurrentVoice", "(Lcom/tencent/tavcut/core/render/builder/light/model/type/VoiceEnum;)V", "voiceChanger", "Lcom/tencent/tavcut/core/render/audio/voicechanger/VoiceChanger;", "getVoiceChanger", "()Lcom/tencent/tavcut/core/render/audio/voicechanger/VoiceChanger;", "setVoiceChanger", "(Lcom/tencent/tavcut/core/render/audio/voicechanger/VoiceChanger;)V", "clearVoiceChangers", "", "movieController", "Lorg/light/MovieController;", "setVoiceChangerConfig", DownloadInfo.spKey_Config, "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class VoiceChangerWrapper {

    @Nullable
    private VoiceEnum currentVoice;

    @Nullable
    private VoiceChanger voiceChanger;

    public final void clearVoiceChangers(@Nullable MovieController movieController) {
        LightRenderChainManager.Companion companion = LightRenderChainManager.INSTANCE;
        companion.getVoiceProcessorRef().remove(movieController);
        if (companion.getVoiceProcessorRef().isEmpty()) {
            if (movieController != null) {
                movieController.setExternalAudioProcessor(null);
            }
            VoiceChanger voiceChanger = this.voiceChanger;
            if (voiceChanger != null) {
                voiceChanger.release();
            }
        }
    }

    @Nullable
    public final VoiceEnum getCurrentVoice() {
        return this.currentVoice;
    }

    @Nullable
    public final VoiceChanger getVoiceChanger() {
        return this.voiceChanger;
    }

    public final void setCurrentVoice(@Nullable VoiceEnum voiceEnum) {
        this.currentVoice = voiceEnum;
    }

    public final void setVoiceChanger(@Nullable VoiceChanger voiceChanger) {
        this.voiceChanger = voiceChanger;
    }

    public final void setVoiceChangerConfig(@Nullable MovieController movieController, @Nullable final List<? extends VoiceEnum> config) {
        boolean z16;
        if (a.f384232a.b(c.f431135f.p())) {
            return;
        }
        List<? extends VoiceEnum> list = config;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            clearVoiceChangers(movieController);
            return;
        }
        HashMap<String, IExternalAudioProcessor> hashMap = new HashMap<>();
        IExternalAudioProcessor iExternalAudioProcessor = new IExternalAudioProcessor() { // from class: com.tencent.tavcut.core.render.builder.light.VoiceChangerWrapper$setVoiceChangerConfig$processor$1
            @Override // org.light.IExternalAudioProcessor
            @NotNull
            public AudioFrame process(@NotNull String type, @NotNull AudioFrame frame) {
                Object obj;
                Intrinsics.checkParameterIsNotNull(type, "type");
                Intrinsics.checkParameterIsNotNull(frame, "frame");
                Iterator it = config.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((VoiceEnum) obj).name(), type)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                VoiceEnum voiceEnum = (VoiceEnum) obj;
                if (voiceEnum != null) {
                    if (voiceEnum != VoiceChangerWrapper.this.getCurrentVoice()) {
                        VoiceChanger voiceChanger = VoiceChangerWrapper.this.getVoiceChanger();
                        if (voiceChanger != null) {
                            voiceChanger.release();
                        }
                        VoiceChangerWrapper.this.setVoiceChanger(new VoiceChanger(44100, voiceEnum.getVoiceKind(), voiceEnum.getEnvironment()));
                        VoiceChangerWrapper.this.setCurrentVoice(voiceEnum);
                    }
                    VoiceChanger voiceChanger2 = VoiceChangerWrapper.this.getVoiceChanger();
                    if (voiceChanger2 != null) {
                        short[] sArr = new short[frame.data.remaining() / 2];
                        frame.data.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                        byte[] writeVoiceFrames = voiceChanger2.writeVoiceFrames(sArr);
                        if (writeVoiceFrames != null) {
                            frame.data.put(writeVoiceFrames);
                        }
                    }
                }
                return frame;
            }
        };
        for (VoiceEnum voiceEnum : config) {
            hashMap.put(voiceEnum.name(), iExternalAudioProcessor);
            if (this.currentVoice == null) {
                this.currentVoice = voiceEnum;
                this.voiceChanger = new VoiceChanger(44100, voiceEnum.getVoiceKind(), voiceEnum.getEnvironment());
            }
        }
        if (movieController != null) {
            LightRenderChainManager.INSTANCE.getVoiceProcessorRef().add(movieController);
            movieController.setExternalAudioProcessor(hashMap);
        }
    }
}
