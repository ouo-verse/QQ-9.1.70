package com.tencent.mobileqq.wink.editor.effect;

import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import com.tencent.videocut.model.SpecialEffectModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J \u0010\u000e\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\r\u001a\u00020\u0002H&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH&J\b\u0010\u0011\u001a\u00020\u0006H&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H&R\u001c\u0010\u0019\u001a\u00020\u00148&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/a;", "", "", "b", "getDurationUs", "positionUs", "", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "play", "pause", "", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", JsonUtils.KEY_EFFECTS, "targetTime", "c", "Lcom/tencent/videocut/model/SpecialEffectModel;", "a", "destroy", "endUs", "d", "", "getLoop", "()Z", "setLoop", "(Z)V", "loop", "getFrameDuration", "()J", "frameDuration", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.editor.effect.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9024a {
        public static /* synthetic */ void a(a aVar, List list, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = -1;
                }
                aVar.c(list, j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyEffect");
        }
    }

    @NotNull
    List<SpecialEffectModel> a();

    long b();

    void c(@NotNull List<EffectStatusManager.AppliedEffect> effects, long targetTime);

    void d(long endUs);

    void destroy();

    long getDurationUs();

    long getFrameDuration();

    void pause();

    void play();

    void seek(long positionUs);

    void setLoop(boolean z16);
}
