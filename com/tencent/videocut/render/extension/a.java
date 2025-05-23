package com.tencent.videocut.render.extension;

import android.text.TextUtils;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.tavcut.core.render.builder.light.model.Event;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.render.l;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.components.TimeRange;
import org.light.lightAssetKit.components.VolumeEffect;
import org.light.lightAssetKit.enums.AudioSourceType;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\f\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0000\u001a\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000f\u001a \u0010\u0018\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u0017\u001a\u00020\u0016\"\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001a\" \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001e\"(\u0010%\u001a\u00020\u001d*\u00020\u00002\u0006\u0010 \u001a\u00020\u001d8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\"\u0015\u0010(\u001a\u00020\u0016*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006)"}, d2 = {"Lcom/tencent/videocut/model/AudioModel;", "Lcom/tencent/videocut/render/l;", "k", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "d", "Lorg/light/lightAssetKit/components/TimeOffset;", tl.h.F, "Lorg/light/lightAssetKit/components/AudioSource;", "b", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "Lorg/light/lightAssetKit/enums/AudioSourceType;", "type", "", "a", "", "stickerId", "g", "stickerTTSId", "f", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "", "duration", "j", "", "Z", "isUseNewMusicOffsetDuration", "", "", "Ljava/util/Map;", "loopCountMap", "value", "e", "(Lcom/tencent/videocut/model/AudioModel;)I", "i", "(Lcom/tencent/videocut/model/AudioModel;I)V", "loopCount", "c", "(Lcom/tencent/videocut/model/AudioModel;)J", "durationInTimeline", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f384135a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<AudioModel, Integer> f384136b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f384135a = QzoneConfig.isUseNewMusicOffsetDuration();
            f384136b = new LinkedHashMap();
        }
    }

    @NotNull
    public static final List<Entity> a(@Nullable Entity entity, @NotNull AudioSourceType type) {
        String str;
        Intrinsics.checkNotNullParameter(type, "type");
        ArrayList arrayList = new ArrayList();
        for (Entity entity2 : WinkVideoTavCut.INSTANCE.f(entity, "AudioSource")) {
            Collection<Component> components = entity2.getComponents();
            Intrinsics.checkNotNullExpressionValue(components, "audioEntity.components");
            for (Component component : components) {
                if (component != null) {
                    str = component.type();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "AudioSource")) {
                    Intrinsics.checkNotNull(component, "null cannot be cast to non-null type org.light.lightAssetKit.components.AudioSource");
                    if (((AudioSource) component).getAudioSourceType() == type) {
                        arrayList.add(entity2);
                    }
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public static final AudioSource b(@NotNull AudioModel audioModel) {
        AudioSource c16;
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        ArrayList<VolumeEffect> arrayList = new ArrayList<>();
        if (audioModel.fadeInDuration > 0) {
            VolumeEffect volumeEffect = new VolumeEffect();
            volumeEffect.startOffset = 0L;
            volumeEffect.endOffset = Long.MIN_VALUE;
            volumeEffect.start = 0.0f;
            volumeEffect.end = audioModel.volume;
            volumeEffect.duration = audioModel.fadeInDuration;
            arrayList.add(volumeEffect);
        }
        if (audioModel.fadeOutDuration > 0) {
            VolumeEffect volumeEffect2 = new VolumeEffect();
            volumeEffect2.startOffset = Long.MIN_VALUE;
            volumeEffect2.endOffset = 0L;
            volumeEffect2.start = audioModel.volume;
            volumeEffect2.end = 0.0f;
            volumeEffect2.duration = audioModel.fadeOutDuration;
            arrayList.add(volumeEffect2);
        }
        for (AudioModel.VolumeEffect volumeEffect3 : audioModel.volumeEffects) {
            VolumeEffect volumeEffect4 = new VolumeEffect();
            volumeEffect4.startOffset = volumeEffect3.startOffsetUs;
            volumeEffect4.endOffset = volumeEffect3.endOffsetUs;
            volumeEffect4.start = volumeEffect3.startVolume;
            volumeEffect4.end = volumeEffect3.endVolume;
            volumeEffect4.duration = volumeEffect3.durationUs;
            arrayList.add(volumeEffect4);
        }
        if (audioModel.type == AudioModel.Type.TTS) {
            c16 = rd4.c.f431135f.o().h(audioModel.id, audioModel.volume, audioModel.speed, AudioSourceType.TTS);
        } else {
            c16 = rd4.c.f431135f.o().c(audioModel.id, audioModel.volume, audioModel.speed);
        }
        c16.setVolumeEffects(arrayList);
        return c16;
    }

    public static final long c(@NotNull AudioModel audioModel) {
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        return ((float) audioModel.selectDuration) / audioModel.speed;
    }

    @NotNull
    public static final InputSource d(@NotNull AudioModel audioModel) {
        Event event;
        InputSource copy;
        Long l3;
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        td4.g r16 = rd4.c.f431135f.r();
        String str = audioModel.id;
        String str2 = audioModel.path;
        long j3 = audioModel.selectStartTime;
        InputSource h16 = r16.h(str2, new TimeRange(j3, audioModel.sourceDuration - j3), str);
        AudioModel.Event event2 = audioModel.event;
        Long l16 = null;
        if (event2 != null) {
            event = event2.toCutEvent();
        } else {
            event = null;
        }
        copy = h16.copy((r24 & 1) != 0 ? h16.key : null, (r24 & 2) != 0 ? h16.type : null, (r24 & 4) != 0 ? h16.path : null, (r24 & 8) != 0 ? h16.label : null, (r24 & 16) != 0 ? h16.timeRange : null, (r24 & 32) != 0 ? h16.loopCount : null, (r24 & 64) != 0 ? h16.events : event, (r24 & 128) != 0 ? h16.inputKey : null, (r24 & 256) != 0 ? h16.timeStretchMode : null, (r24 & 512) != 0 ? h16.clipRect : null, (r24 & 1024) != 0 ? h16.postEffectOptions : null);
        String str3 = audioModel.path;
        TimeRange timeRange = copy.getTimeRange();
        if (timeRange != null) {
            l3 = Long.valueOf(timeRange.startTime);
        } else {
            l3 = null;
        }
        TimeRange timeRange2 = copy.getTimeRange();
        if (timeRange2 != null) {
            l16 = Long.valueOf(timeRange2.duration);
        }
        w53.b.f("AudioModel", str3 + " timeRange:(" + l3 + ", " + l16 + ")");
        return copy;
    }

    public static final int e(@NotNull AudioModel audioModel) {
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        Integer num = f384136b.get(audioModel);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Nullable
    public static final String f(@NotNull String stickerTTSId) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(stickerTTSId, "stickerTTSId");
        if (!TextUtils.isEmpty(stickerTTSId)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(stickerTTSId, "TTS_", false, 2, null);
            if (!startsWith$default) {
                return null;
            }
            String substring = stickerTTSId.substring(4, stickerTTSId.length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return null;
    }

    @Nullable
    public static final String g(@NotNull String stickerId) {
        Intrinsics.checkNotNullParameter(stickerId, "stickerId");
        if (!TextUtils.isEmpty(stickerId)) {
            return "TTS_" + stickerId;
        }
        return null;
    }

    @NotNull
    public static final TimeOffset h(@NotNull AudioModel audioModel) {
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        if (!f384135a && audioModel.type != AudioModel.Type.MUSIC) {
            return rd4.c.f431135f.o().e(audioModel.startTimeInTimeline, c(audioModel));
        }
        int e16 = e(audioModel);
        TimeOffset timeOffset = new TimeOffset();
        timeOffset.setStartOffset(audioModel.startTimeInTimeline);
        timeOffset.setLoopCount(e16);
        timeOffset.setDuration(audioModel.sourceDuration - audioModel.selectStartTime);
        timeOffset.setEndOffset(audioModel.selectDuration);
        w53.b.f("AudioModel", "audioModelLoopCount:" + e16 + " timeOffset:" + timeOffset);
        return timeOffset;
    }

    public static final void i(@NotNull AudioModel audioModel, int i3) {
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        f384136b.put(audioModel, Integer.valueOf(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final AudioModel j(@NotNull AudioModel audioModel, @NotNull List<? extends MediaClip> mediaClips, long j3) {
        Object first;
        long j16;
        Object last;
        long j17;
        AudioModel copy;
        Object last2;
        Object last3;
        Object first2;
        Long l3;
        Object first3;
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) mediaClips);
        Long l16 = null;
        if (e.r((MediaClip) first) == MediaClipUseType.OPENING) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) mediaClips);
            ResourceModel resourceModel = ((MediaClip) first2).resource;
            if (resourceModel != null) {
                l3 = Long.valueOf(resourceModel.scaleDuration);
            } else {
                l3 = null;
            }
            if (l3 != null) {
                first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) mediaClips);
                ResourceModel resourceModel2 = ((MediaClip) first3).resource;
                Intrinsics.checkNotNull(resourceModel2);
                j16 = resourceModel2.scaleDuration;
                long j18 = j16;
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) mediaClips);
                if (e.r((MediaClip) last) == MediaClipUseType.ENDING) {
                    last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) mediaClips);
                    ResourceModel resourceModel3 = ((MediaClip) last2).resource;
                    if (resourceModel3 != null) {
                        l16 = Long.valueOf(resourceModel3.scaleDuration);
                    }
                    if (l16 != null) {
                        last3 = CollectionsKt___CollectionsKt.last((List<? extends Object>) mediaClips);
                        ResourceModel resourceModel4 = ((MediaClip) last3).resource;
                        Intrinsics.checkNotNull(resourceModel4);
                        j17 = j3 - resourceModel4.scaleDuration;
                        copy = audioModel.copy((r37 & 1) != 0 ? audioModel.id : null, (r37 & 2) != 0 ? audioModel.path : null, (r37 & 4) != 0 ? Long.valueOf(audioModel.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(audioModel.sourceDuration) : null, (r37 & 16) != 0 ? Long.valueOf(audioModel.startTimeInTimeline) : Long.valueOf(j18), (r37 & 32) != 0 ? Float.valueOf(audioModel.volume) : null, (r37 & 64) != 0 ? Float.valueOf(audioModel.speed) : null, (r37 & 128) != 0 ? audioModel.volumeEffects : null, (r37 & 256) != 0 ? audioModel.name : null, (r37 & 512) != 0 ? audioModel.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(audioModel.selectStartTime) : null, (r37 & 2048) != 0 ? Long.valueOf(audioModel.selectDuration) : Long.valueOf(j17), (r37 & 4096) != 0 ? Long.valueOf(audioModel.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(audioModel.fadeOutDuration) : null, (r37 & 16384) != 0 ? audioModel.lyricInfo : null, (r37 & 32768) != 0 ? audioModel.type : null, (r37 & 65536) != 0 ? audioModel.waveSampleData : null, (r37 & 131072) != 0 ? audioModel.event : null, (r37 & 262144) != 0 ? audioModel.unknownFields() : null);
                        return copy;
                    }
                }
                j17 = j3;
                copy = audioModel.copy((r37 & 1) != 0 ? audioModel.id : null, (r37 & 2) != 0 ? audioModel.path : null, (r37 & 4) != 0 ? Long.valueOf(audioModel.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(audioModel.sourceDuration) : null, (r37 & 16) != 0 ? Long.valueOf(audioModel.startTimeInTimeline) : Long.valueOf(j18), (r37 & 32) != 0 ? Float.valueOf(audioModel.volume) : null, (r37 & 64) != 0 ? Float.valueOf(audioModel.speed) : null, (r37 & 128) != 0 ? audioModel.volumeEffects : null, (r37 & 256) != 0 ? audioModel.name : null, (r37 & 512) != 0 ? audioModel.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(audioModel.selectStartTime) : null, (r37 & 2048) != 0 ? Long.valueOf(audioModel.selectDuration) : Long.valueOf(j17), (r37 & 4096) != 0 ? Long.valueOf(audioModel.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(audioModel.fadeOutDuration) : null, (r37 & 16384) != 0 ? audioModel.lyricInfo : null, (r37 & 32768) != 0 ? audioModel.type : null, (r37 & 65536) != 0 ? audioModel.waveSampleData : null, (r37 & 131072) != 0 ? audioModel.event : null, (r37 & 262144) != 0 ? audioModel.unknownFields() : null);
                return copy;
            }
        }
        j16 = 0;
        long j182 = j16;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) mediaClips);
        if (e.r((MediaClip) last) == MediaClipUseType.ENDING) {
        }
        j17 = j3;
        copy = audioModel.copy((r37 & 1) != 0 ? audioModel.id : null, (r37 & 2) != 0 ? audioModel.path : null, (r37 & 4) != 0 ? Long.valueOf(audioModel.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(audioModel.sourceDuration) : null, (r37 & 16) != 0 ? Long.valueOf(audioModel.startTimeInTimeline) : Long.valueOf(j182), (r37 & 32) != 0 ? Float.valueOf(audioModel.volume) : null, (r37 & 64) != 0 ? Float.valueOf(audioModel.speed) : null, (r37 & 128) != 0 ? audioModel.volumeEffects : null, (r37 & 256) != 0 ? audioModel.name : null, (r37 & 512) != 0 ? audioModel.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(audioModel.selectStartTime) : null, (r37 & 2048) != 0 ? Long.valueOf(audioModel.selectDuration) : Long.valueOf(j17), (r37 & 4096) != 0 ? Long.valueOf(audioModel.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(audioModel.fadeOutDuration) : null, (r37 & 16384) != 0 ? audioModel.lyricInfo : null, (r37 & 32768) != 0 ? audioModel.type : null, (r37 & 65536) != 0 ? audioModel.waveSampleData : null, (r37 & 131072) != 0 ? audioModel.event : null, (r37 & 262144) != 0 ? audioModel.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final l k(@NotNull AudioModel audioModel) {
        List<? extends Component> listOf;
        Intrinsics.checkNotNullParameter(audioModel, "<this>");
        InputSource d16 = d(audioModel);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Component[]{h(audioModel), b(audioModel)});
        return new l(rd4.c.f431135f.q().a(JsonUtils.KEY_BGM, listOf), d16, null, 4, null);
    }
}
