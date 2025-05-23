package com.tencent.tavcut.render.builder.light;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.tavcut.render.audio.voicechanger.VoiceChanger;
import com.tencent.tavcut.render.builder.light.LightRenderChainManager;
import com.tencent.tavcut.rendermodel.VoiceEnum;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/tavcut/render/builder/light/d;", "", "Lorg/light/MovieController;", "movieController", "", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", DownloadInfo.spKey_Config, "", "f", "a", "Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;", "Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;", "c", "()Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;", "e", "(Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;)V", "voiceChanger", "b", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "()Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "d", "(Lcom/tencent/tavcut/rendermodel/VoiceEnum;)V", "currentVoice", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VoiceChanger voiceChanger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VoiceEnum currentVoice;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/tavcut/render/builder/light/d$a", "Lorg/light/IExternalAudioProcessor;", "", "type", "Lorg/light/AudioFrame;", AIInput.KEY_FRAME, "process", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class a implements IExternalAudioProcessor {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f374386b;

        a(List list) {
            this.f374386b = list;
        }

        @Override // org.light.IExternalAudioProcessor
        @NotNull
        public AudioFrame process(@NotNull String type, @NotNull AudioFrame frame) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(type, "type");
            Intrinsics.checkParameterIsNotNull(frame, "frame");
            Iterator it = this.f374386b.iterator();
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
                if (voiceEnum != d.this.getCurrentVoice()) {
                    VoiceChanger voiceChanger = d.this.getVoiceChanger();
                    if (voiceChanger != null) {
                        voiceChanger.a();
                    }
                    d.this.e(new VoiceChanger(44100, voiceEnum.getVoiceKind(), voiceEnum.getEnvironment()));
                    d.this.d(voiceEnum);
                }
                VoiceChanger voiceChanger2 = d.this.getVoiceChanger();
                if (voiceChanger2 != null) {
                    short[] sArr = new short[frame.data.remaining() / 2];
                    frame.data.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                    byte[] c16 = voiceChanger2.c(sArr);
                    if (c16 != null) {
                        frame.data.put(c16);
                    }
                }
            }
            return frame;
        }
    }

    public final void a(@Nullable MovieController movieController) {
        LightRenderChainManager.Companion companion = LightRenderChainManager.INSTANCE;
        companion.c().remove(movieController);
        if (companion.c().isEmpty()) {
            if (movieController != null) {
                movieController.setExternalAudioProcessor(null);
            }
            VoiceChanger voiceChanger = this.voiceChanger;
            if (voiceChanger != null) {
                voiceChanger.a();
            }
        }
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final VoiceEnum getCurrentVoice() {
        return this.currentVoice;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final VoiceChanger getVoiceChanger() {
        return this.voiceChanger;
    }

    public final void d(@Nullable VoiceEnum voiceEnum) {
        this.currentVoice = voiceEnum;
    }

    public final void e(@Nullable VoiceChanger voiceChanger) {
        this.voiceChanger = voiceChanger;
    }

    public final void f(@Nullable MovieController movieController, @Nullable List<? extends VoiceEnum> config) {
        boolean z16;
        if (com.tencent.videocut.utils.a.f384232a.b(od4.b.f422509e.o())) {
            return;
        }
        List<? extends VoiceEnum> list = config;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            a(movieController);
            return;
        }
        HashMap<String, IExternalAudioProcessor> hashMap = new HashMap<>();
        a aVar = new a(config);
        for (VoiceEnum voiceEnum : config) {
            hashMap.put(voiceEnum.name(), aVar);
            if (this.currentVoice == null) {
                this.currentVoice = voiceEnum;
                this.voiceChanger = new VoiceChanger(44100, voiceEnum.getVoiceKind(), voiceEnum.getEnvironment());
            }
        }
        if (movieController != null) {
            LightRenderChainManager.INSTANCE.c().add(movieController);
            movieController.setExternalAudioProcessor(hashMap);
        }
    }
}
