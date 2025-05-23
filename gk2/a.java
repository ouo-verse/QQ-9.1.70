package gk2;

import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.RenderData;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.VolumeEffect;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\"\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "b", "", "a", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;)J", "durationInTimeline", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    public static final long a(@NotNull AudioModel audioModel) {
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        return ((float) audioModel.selectDuration) / audioModel.speed;
    }

    @NotNull
    public static final RenderData b(@NotNull AudioModel audioModel) {
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        ArrayList arrayList = new ArrayList();
        od4.b bVar = od4.b.f422509e;
        xd4.e n3 = bVar.n();
        InputSource f16 = bVar.q().f(audioModel.path, new TimeRange(audioModel.selectStartTime, audioModel.selectDuration, null, 4, null), audioModel.id);
        ArrayList arrayList2 = new ArrayList();
        long j3 = audioModel.fadeInDuration;
        Float valueOf = Float.valueOf(0.0f);
        Long valueOf2 = Long.valueOf(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
        if (j3 > 0) {
            arrayList2.add(new VolumeEffect(0L, valueOf2, Long.valueOf(j3), valueOf, Float.valueOf(audioModel.volume), null, null, 96, null));
        }
        long j16 = audioModel.fadeOutDuration;
        if (j16 > 0) {
            arrayList2.add(new VolumeEffect(valueOf2, 0L, Long.valueOf(j16), Float.valueOf(audioModel.volume), valueOf, null, null, 96, null));
        }
        for (AudioModel.VolumeEffect volumeEffect : audioModel.volumeEffects) {
            long j17 = volumeEffect.startOffsetUs;
            long j18 = volumeEffect.endOffsetUs;
            float f17 = volumeEffect.startVolume;
            float f18 = volumeEffect.endVolume;
            arrayList2.add(new VolumeEffect(Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(volumeEffect.durationUs), Float.valueOf(f17), Float.valueOf(f18), null, null, 96, null));
        }
        String str = f16.key;
        if (str == null) {
            str = "";
        }
        AudioSource copy$default = AudioSource.copy$default(n3.c(str, audioModel.volume, audioModel.speed), null, null, null, null, null, null, null, null, arrayList2, null, null, null, 3839, null);
        TimeOffset e16 = n3.e(audioModel.startTimeInTimeline, a(audioModel));
        arrayList.add(new IdentifyComponent(n3.m()));
        arrayList.add(new IdentifyComponent(e16));
        arrayList.add(new IdentifyComponent(copy$default));
        arrayList.add(new IdentifyComponent(n3.a(JsonUtils.KEY_BGM)));
        return new RenderData(od4.b.f422509e.p().a(JsonUtils.KEY_BGM, arrayList), f16, null, 4, null);
    }
}
