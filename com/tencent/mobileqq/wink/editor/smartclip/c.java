package com.tencent.mobileqq.wink.editor.smartclip;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV2;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.ClipRes;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicInfo;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicTimePoint;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.TemplateFixedClipConfig;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.TemplateMusicInfoParseResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import n73.AutoClipResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.TemplateConfig;
import org.light.lightAssetKit.LightAssetDataContext;
import qqcircle.QQCircleSmartMatchMusic$EffectPoint;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;
import qqcircle.QQCircleSmartMatchMusic$StuckPointData;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\b\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a$\u0010\t\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\n0\u0000\u001a\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0000H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u0016\u0010\u0019\u001a\u00020\u00182\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\rH\u0002\u001a\n\u0010\u001c\u001a\u00020\n*\u00020\u0001\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u0000*\u00020\u001d\u001a\u0012\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010\u001f\u001a\u0010\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020#\u001a\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&\u00a8\u0006)"}, d2 = {"", "Lcom/tencent/videocut/model/MediaClip;", "clips", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "musicInfo", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "fixedClipConfig", "Ln73/a;", "c", "d", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/ClipRes;", "", "e", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "beats", "f", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint$MusicTimePointType;", "type", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "originClip", "targetDuration", tl.h.F, "", "i", "beat", "b", "o", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "p", "", "templatePath", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/h;", DomainData.DOMAIN_NAME, "Lorg/light/lightAssetKit/LightAssetDataContext;", "lightAssetDataContext", "k", "Lorg/light/LightAsset;", "lightAsset", "l", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321504a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f321505b;

        static {
            int[] iArr = new int[MusicTimePoint.MusicTimePointType.values().length];
            try {
                iArr[MusicTimePoint.MusicTimePointType.BEAT_TYPE_HIGHLIGHT_VAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicTimePoint.MusicTimePointType.BEAT_TYPE_FAST_RHYTHM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MusicTimePoint.MusicTimePointType.BEAT_TYPE_OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f321504a = iArr;
            int[] iArr2 = new int[MediaType.values().length];
            try {
                iArr2[MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MediaType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f321505b = iArr2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((MusicTimePoint) t16).getTimeInMillis()), Long.valueOf(((MusicTimePoint) t17).getTimeInMillis()));
            return compareValues;
        }
    }

    private static final boolean b(MusicTimePoint musicTimePoint) {
        MusicTimePoint.MusicTimePointType type = musicTimePoint.getType();
        if (MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM != type && MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM != type && MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH != type) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final AutoClipResult c(@NotNull List<? extends MediaClip> clips, @NotNull MusicInfo musicInfo, @Nullable TemplateFixedClipConfig templateFixedClipConfig) {
        boolean z16;
        boolean z17;
        int collectionSizeOrDefault;
        long j3;
        long coerceAtLeast;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        Intrinsics.checkNotNullParameter(clips, "clips");
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        if (templateFixedClipConfig != null && templateFixedClipConfig.getUseInternalRhythm()) {
            return d(clips, musicInfo, templateFixedClipConfig);
        }
        long selectedStartInMillis = musicInfo.getSelectedStartInMillis();
        long selectedDurationInMillis = musicInfo.getSelectedDurationInMillis();
        int size = clips.size();
        QLog.i("WinkAutoClipHelper", 1, "adjustClipAccordingMusicBeat---clip n=" + size + ", offset=" + selectedStartInMillis + ", duration=" + selectedDurationInMillis);
        if (size > 0 && selectedDurationInMillis > 0) {
            long j16 = 1000;
            long minTotalDuration = (templateFixedClipConfig != null ? templateFixedClipConfig.getMinTotalDuration() : 0L) / j16;
            QLog.i("WinkAutoClipHelper", 1, "adjust clip, configMinTotalDuration=" + minTotalDuration);
            if (i(clips)) {
                if (size == 1) {
                    List<? extends MediaClip> list = clips;
                    collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault3);
                    for (MediaClip mediaClip : list) {
                        long j17 = minTotalDuration > 0 ? minTotalDuration : 10000000L;
                        ResourceModel resourceModel = mediaClip.resource;
                        arrayList.add(MediaClip.copy$default(mediaClip, resourceModel != null ? ResourceModel.copy$default(resourceModel, null, null, Long.valueOf(j17), null, null, null, Long.valueOf(j17), null, null, null, null, null, null, null, null, null, null, 131003, null) : null, null, null, null, null, null, null, 126, null));
                    }
                    return new AutoClipResult(true, "", arrayList);
                }
                if (minTotalDuration <= 0 && (size == 2 || size == 3)) {
                    List<? extends MediaClip> list2 = clips;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    for (MediaClip mediaClip2 : list2) {
                        ResourceModel resourceModel2 = mediaClip2.resource;
                        arrayList2.add(MediaClip.copy$default(mediaClip2, resourceModel2 != null ? ResourceModel.copy$default(resourceModel2, null, null, 2500000L, null, null, null, 2500000L, null, null, null, null, null, null, null, null, null, null, 131003, null) : null, null, null, null, null, null, null, 126, null));
                    }
                    return new AutoClipResult(true, "", arrayList2);
                }
            }
            int size2 = musicInfo.c().size();
            List<MusicTimePoint> c16 = musicInfo.c();
            int i3 = 0;
            if (!(c16 instanceof Collection) || !c16.isEmpty()) {
                Iterator<T> it = c16.iterator();
                while (it.hasNext()) {
                    if (((MusicTimePoint) it.next()).getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            QLog.i("WinkAutoClipHelper", 1, "adjust clip, beats origin count=" + size2 + ", paragraph beat exists=" + z16);
            List<MusicTimePoint> m3 = m(musicInfo);
            int size3 = m3.size();
            List<MusicTimePoint> list3 = m3;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it5 = list3.iterator();
                while (it5.hasNext()) {
                    if (((MusicTimePoint) it5.next()).getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            QLog.i("WinkAutoClipHelper", 1, "adjust clip, beats after handled count=" + size3 + ", paragraph beat exists=" + z17);
            if (m3.isEmpty()) {
                return new AutoClipResult(true, "", clips);
            }
            List<? extends MediaClip> list4 = clips;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it6 = list4.iterator();
            while (it6.hasNext()) {
                arrayList3.add(o((MediaClip) it6.next()));
            }
            AutoClipAlgorithmV2 autoClipAlgorithmV2 = new AutoClipAlgorithmV2();
            QLog.i("WinkAutoClipHelper", 1, "the selected algorithm is " + autoClipAlgorithmV2);
            long e16 = e(arrayList3);
            QLog.i("WinkAutoClipHelper", 1, "calculate total duration=" + e16);
            long b16 = autoClipAlgorithmV2.b(m3, selectedDurationInMillis, e16, arrayList3.size());
            QLog.i("WinkAutoClipHelper", 1, "adjust clip, targetDuration=" + b16);
            if (minTotalDuration <= 0 || b16 >= minTotalDuration) {
                j3 = b16;
            } else {
                QLog.i("WinkAutoClipHelper", 1, "adjust clip, fit minTotalDuration, targetDuration=" + minTotalDuration);
                j3 = minTotalDuration;
            }
            long[] a16 = autoClipAlgorithmV2.a(j3, size, m3, selectedDurationInMillis);
            QLog.i("WinkAutoClipHelper", 1, "adjust clip, timeClips=" + Arrays.toString(a16));
            if (a16 == null) {
                return new AutoClipResult(true, "", clips);
            }
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList(a16.length);
            for (long j18 : a16) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j18, 1000L);
                arrayList5.add(Long.valueOf(coerceAtLeast));
            }
            Iterator it7 = arrayList5.iterator();
            while (true) {
                int i16 = i3;
                if (it7.hasNext()) {
                    Object next = it7.next();
                    i3 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    arrayList4.add(h(clips.get(i16), ((Number) next).longValue() * j16));
                } else {
                    return new AutoClipResult(true, "", arrayList4);
                }
            }
        } else {
            return new AutoClipResult(true, "", clips);
        }
    }

    @NotNull
    public static final AutoClipResult d(@NotNull List<? extends MediaClip> clips, @NotNull MusicInfo musicInfo, @NotNull TemplateFixedClipConfig fixedClipConfig) {
        Intrinsics.checkNotNullParameter(clips, "clips");
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        Intrinsics.checkNotNullParameter(fixedClipConfig, "fixedClipConfig");
        if (!fixedClipConfig.getUseInternalRhythm()) {
            return com.tencent.mobileqq.wink.editor.smartclip.algorithm.d.INSTANCE.d(clips);
        }
        return new com.tencent.mobileqq.wink.editor.smartclip.algorithm.d().a(clips, musicInfo, fixedClipConfig);
    }

    public static final long e(@NotNull List<ClipRes> clips) {
        Intrinsics.checkNotNullParameter(clips, "clips");
        long j3 = 0;
        for (ClipRes clipRes : clips) {
            j3 += clipRes.getType() == ClipRes.ClipResType.PHOTO ? 2500 : clipRes.getDurationInMillis();
        }
        return j3;
    }

    private static final List<MusicTimePoint> f(List<MusicTimePoint> list) {
        List sortedWith;
        List list2;
        Object lastOrNull;
        long j3;
        Object lastOrNull2;
        long j16;
        int lastIndex;
        Object lastOrNull3;
        Object lastOrNull4;
        MusicTimePoint.MusicTimePointType musicTimePointType;
        Object lastOrNull5;
        int lastIndex2;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: com.tencent.mobileqq.wink.editor.smartclip.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int g16;
                g16 = c.g((MusicTimePoint) obj, (MusicTimePoint) obj2);
                return g16;
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = sortedWith.iterator();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            long j17 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MusicTimePoint musicTimePoint = (MusicTimePoint) next;
            MusicTimePoint.MusicTimePointType type = musicTimePoint.getType();
            MusicTimePoint.MusicTimePointType musicTimePointType2 = MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM;
            if (type != musicTimePointType2) {
                if (!arrayList.isEmpty()) {
                    lastOrNull4 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
                    MusicTimePoint musicTimePoint2 = (MusicTimePoint) lastOrNull4;
                    if (musicTimePoint2 != null) {
                        musicTimePointType = musicTimePoint2.getType();
                    } else {
                        musicTimePointType = null;
                    }
                    if (musicTimePointType == musicTimePointType2) {
                        long timeInMillis = musicTimePoint.getTimeInMillis();
                        lastOrNull5 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
                        MusicTimePoint musicTimePoint3 = (MusicTimePoint) lastOrNull5;
                        if (musicTimePoint3 != null) {
                            j17 = musicTimePoint3.getTimeInMillis();
                        }
                        if (Math.abs(timeInMillis - j17) < 1000) {
                            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                            arrayList.remove(lastIndex2);
                        }
                    }
                }
                arrayList.add(musicTimePoint);
            } else {
                long timeInMillis2 = musicTimePoint.getTimeInMillis();
                lastOrNull3 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
                MusicTimePoint musicTimePoint4 = (MusicTimePoint) lastOrNull3;
                if (musicTimePoint4 != null) {
                    j17 = musicTimePoint4.getTimeInMillis();
                }
                if (Math.abs(timeInMillis2 - j17) >= 1000) {
                    arrayList.add(musicTimePoint);
                }
            }
            i16 = i17;
        }
        list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        arrayList.clear();
        for (Object obj : list2) {
            int i18 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MusicTimePoint musicTimePoint5 = (MusicTimePoint) obj;
            if (musicTimePoint5.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH) {
                while (!arrayList.isEmpty()) {
                    long timeInMillis3 = musicTimePoint5.getTimeInMillis();
                    lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
                    MusicTimePoint musicTimePoint6 = (MusicTimePoint) lastOrNull2;
                    if (musicTimePoint6 != null) {
                        j16 = musicTimePoint6.getTimeInMillis();
                    } else {
                        j16 = 0;
                    }
                    if (Math.abs(timeInMillis3 - j16) >= 1000) {
                        break;
                    }
                    lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                    arrayList.remove(lastIndex);
                }
                arrayList.add(musicTimePoint5);
            } else {
                long timeInMillis4 = musicTimePoint5.getTimeInMillis();
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
                MusicTimePoint musicTimePoint7 = (MusicTimePoint) lastOrNull;
                if (musicTimePoint7 != null) {
                    j3 = musicTimePoint7.getTimeInMillis();
                } else {
                    j3 = 0;
                }
                if (Math.abs(timeInMillis4 - j3) >= 1000) {
                    arrayList.add(musicTimePoint5);
                }
            }
            i3 = i18;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(MusicTimePoint musicTimePoint, MusicTimePoint musicTimePoint2) {
        if (musicTimePoint.getTimeInMillis() != musicTimePoint2.getTimeInMillis()) {
            return Intrinsics.compare(musicTimePoint.getTimeInMillis(), musicTimePoint2.getTimeInMillis());
        }
        if (musicTimePoint.getType() == musicTimePoint2.getType()) {
            return 0;
        }
        return Intrinsics.compare(j(musicTimePoint.getType()), j(musicTimePoint2.getType()));
    }

    @NotNull
    public static final MediaClip h(@NotNull MediaClip originClip, long j3) {
        MediaType mediaType;
        long j16;
        boolean z16;
        Intrinsics.checkNotNullParameter(originClip, "originClip");
        ResourceModel resourceModel = originClip.resource;
        ResourceModel resourceModel2 = null;
        if (resourceModel != null) {
            mediaType = resourceModel.type;
        } else {
            mediaType = null;
        }
        if (mediaType == MediaType.VIDEO) {
            long j17 = resourceModel.sourceDuration;
            if (j3 > j17) {
                j16 = j17;
            } else {
                j16 = j3;
            }
            ResourceModel copy$default = ResourceModel.copy$default(resourceModel, null, null, Long.valueOf(j3), null, null, null, Long.valueOf(j16), null, null, null, null, null, null, null, null, null, null, 131003, null);
            if (j3 != j16) {
                z16 = true;
            } else {
                z16 = false;
            }
            return MediaClip.copy$default(originClip, com.tencent.mobileqq.wink.editor.clipping.a.a(copy$default, z16), null, null, null, null, null, null, 126, null);
        }
        if (resourceModel != null) {
            resourceModel2 = ResourceModel.copy$default(resourceModel, null, null, Long.valueOf(j3), null, null, null, Long.valueOf(j3), null, null, null, null, null, null, null, null, null, null, 131003, null);
        }
        return MediaClip.copy$default(originClip, resourceModel2, null, null, null, null, null, null, 126, null);
    }

    private static final boolean i(List<? extends MediaClip> list) {
        MediaType mediaType;
        boolean z16;
        List<? extends MediaClip> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                mediaType = resourceModel.type;
            } else {
                mediaType = null;
            }
            if (mediaType == MediaType.IMAGE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    private static final int j(MusicTimePoint.MusicTimePointType musicTimePointType) {
        switch (a.f321504a[musicTimePointType.ordinal()]) {
            case 1:
                return 5;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
                return 1;
            case 6:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public static final MusicInfo k(@NotNull LightAssetDataContext lightAssetDataContext) {
        int collectionSizeOrDefault;
        Object obj;
        JsonObject jsonObject;
        long j3;
        Collection emptyList;
        Collection emptyList2;
        Collection emptyList3;
        Collection emptyList4;
        Collection emptyList5;
        JsonArray asJsonArray;
        int collectionSizeOrDefault2;
        JsonArray asJsonArray2;
        int collectionSizeOrDefault3;
        JsonArray asJsonArray3;
        int collectionSizeOrDefault4;
        JsonArray asJsonArray4;
        int collectionSizeOrDefault5;
        JsonArray asJsonArray5;
        int collectionSizeOrDefault6;
        Intrinsics.checkNotNullParameter(lightAssetDataContext, "lightAssetDataContext");
        Set<Map.Entry<String, JsonElement>> entrySet = lightAssetDataContext.getInputSources().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "lightAssetDataContext.inputSources.entrySet()");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((JsonElement) ((Map.Entry) it.next()).getValue()).getAsJsonObject());
        }
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                if (Intrinsics.areEqual(((JsonObject) obj).get("type").getAsString(), "AudioClipData")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        JsonObject jsonObject2 = (JsonObject) obj;
        if (jsonObject2 != null) {
            jsonObject = jsonObject2.getAsJsonObject();
        } else {
            jsonObject = null;
        }
        if (jsonObject == null) {
            return null;
        }
        JsonObject asJsonObject = jsonObject.get(LinkReportConstant$GlobalKey.EVENTS).getAsJsonObject();
        JsonObject asJsonObject2 = jsonObject.get("timeRange").getAsJsonObject();
        JsonElement jsonElement = asJsonObject2.get("startTime");
        long j16 = 0;
        if (jsonElement != null) {
            j3 = jsonElement.getAsLong();
        } else {
            j3 = 0;
        }
        JsonElement jsonElement2 = asJsonObject2.get("duration");
        if (jsonElement2 != null) {
            j16 = jsonElement2.getAsLong();
        }
        JsonElement jsonElement3 = asJsonObject.get(TAVRhythmAutomaticTemplate.DrumTrail);
        if (jsonElement3 == null || (asJsonArray5 = jsonElement3.getAsJsonArray()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            collectionSizeOrDefault6 = CollectionsKt__IterablesKt.collectionSizeOrDefault(asJsonArray5, 10);
            emptyList = new ArrayList(collectionSizeOrDefault6);
            Iterator<JsonElement> it6 = asJsonArray5.iterator();
            while (it6.hasNext()) {
                emptyList.add(Long.valueOf(it6.next().getAsLong()));
            }
        }
        JsonElement jsonElement4 = asJsonObject.get(TAVRhythmAutomaticTemplate.SlowRhythmTrail);
        if (jsonElement4 == null || (asJsonArray4 = jsonElement4.getAsJsonArray()) == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            collectionSizeOrDefault5 = CollectionsKt__IterablesKt.collectionSizeOrDefault(asJsonArray4, 10);
            emptyList2 = new ArrayList(collectionSizeOrDefault5);
            Iterator<JsonElement> it7 = asJsonArray4.iterator();
            while (it7.hasNext()) {
                emptyList2.add(Long.valueOf(it7.next().getAsLong()));
            }
        }
        JsonElement jsonElement5 = asJsonObject.get("ParagraphTrail");
        if (jsonElement5 == null || (asJsonArray3 = jsonElement5.getAsJsonArray()) == null) {
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(asJsonArray3, 10);
            emptyList3 = new ArrayList(collectionSizeOrDefault4);
            Iterator<JsonElement> it8 = asJsonArray3.iterator();
            while (it8.hasNext()) {
                emptyList3.add(Long.valueOf(it8.next().getAsLong()));
            }
        }
        JsonElement jsonElement6 = asJsonObject.get(TAVRhythmAutomaticTemplate.FastRhythmTrail);
        if (jsonElement6 == null || (asJsonArray2 = jsonElement6.getAsJsonArray()) == null) {
            emptyList4 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(asJsonArray2, 10);
            emptyList4 = new ArrayList(collectionSizeOrDefault3);
            Iterator<JsonElement> it9 = asJsonArray2.iterator();
            while (it9.hasNext()) {
                emptyList4.add(Long.valueOf(it9.next().getAsLong()));
            }
        }
        JsonElement jsonElement7 = asJsonObject.get(TAVRhythmAutomaticTemplate.HighlightValueTrail);
        if (jsonElement7 == null || (asJsonArray = jsonElement7.getAsJsonArray()) == null) {
            emptyList5 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(asJsonArray, 10);
            emptyList5 = new ArrayList(collectionSizeOrDefault2);
            Iterator<JsonElement> it10 = asJsonArray.iterator();
            while (it10.hasNext()) {
                emptyList5.add(Long.valueOf(it10.next().getAsLong()));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it11 = emptyList.iterator();
        while (it11.hasNext()) {
            arrayList2.add(new MusicTimePoint(MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM, ((Number) it11.next()).longValue() / 1000));
            j16 = j16;
        }
        long j17 = j16;
        Iterator it12 = emptyList2.iterator();
        while (it12.hasNext()) {
            arrayList2.add(new MusicTimePoint(MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM, ((Number) it12.next()).longValue() / 1000));
        }
        Iterator it13 = emptyList3.iterator();
        while (it13.hasNext()) {
            arrayList2.add(new MusicTimePoint(MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH, ((Number) it13.next()).longValue() / 1000));
        }
        Iterator it14 = emptyList4.iterator();
        while (it14.hasNext()) {
            arrayList2.add(new MusicTimePoint(MusicTimePoint.MusicTimePointType.BEAT_TYPE_FAST_RHYTHM, ((Number) it14.next()).longValue() / 1000));
        }
        Iterator it15 = emptyList5.iterator();
        while (it15.hasNext()) {
            arrayList2.add(new MusicTimePoint(MusicTimePoint.MusicTimePointType.BEAT_TYPE_HIGHLIGHT_VAL, ((Number) it15.next()).longValue() / 1000));
        }
        long j18 = 1000;
        return new MusicInfo(j3 / j18, j17 / j18, arrayList2);
    }

    @NotNull
    public static final TemplateFixedClipConfig l(@NotNull LightAsset lightAsset) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtLeast3;
        int coerceAtLeast4;
        int coerceAtLeast5;
        List emptyList;
        MusicTimePoint.MusicTimePointType musicTimePointType;
        Intrinsics.checkNotNullParameter(lightAsset, "lightAsset");
        TemplateConfig movieConfig = lightAsset.getMovieConfig();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(movieConfig.imageCropSpace, 0);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(movieConfig.videoCropSpace, 0);
        coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast(movieConfig.minFreezePointInterval, 0);
        coerceAtLeast4 = RangesKt___RangesKt.coerceAtLeast(movieConfig.headProtectDuration, 0);
        coerceAtLeast5 = RangesKt___RangesKt.coerceAtLeast(movieConfig.minTotalDuration, 0);
        boolean z16 = movieConfig.useInternalRhythm;
        String[] strArr = movieConfig.cropEvents;
        if (strArr == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (str != null) {
                    switch (str.hashCode()) {
                        case -1870542368:
                            if (str.equals(TAVRhythmAutomaticTemplate.DrumTrail)) {
                                musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM;
                                break;
                            }
                            break;
                        case -1704423735:
                            if (str.equals(TAVRhythmAutomaticTemplate.HighlightValueTrail)) {
                                musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_HIGHLIGHT_VAL;
                                break;
                            }
                            break;
                        case -1142061521:
                            if (str.equals(TAVRhythmAutomaticTemplate.SlowRhythmTrail)) {
                                musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM;
                                break;
                            }
                            break;
                        case 439918836:
                            if (str.equals(TAVRhythmAutomaticTemplate.FastRhythmTrail)) {
                                musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_FAST_RHYTHM;
                                break;
                            }
                            break;
                        case 1410775384:
                            if (str.equals("ParagraphTrail")) {
                                musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH;
                                break;
                            }
                            break;
                    }
                }
                musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_OTHER;
                arrayList.add(musicTimePointType);
            }
            emptyList = arrayList;
        }
        return new TemplateFixedClipConfig(z16, emptyList, coerceAtLeast3, coerceAtLeast, coerceAtLeast2, coerceAtLeast4, coerceAtLeast5);
    }

    @NotNull
    public static final List<MusicTimePoint> m(@NotNull MusicInfo musicInfo) {
        List distinct;
        List mutableList;
        List<MusicTimePoint> mutableList2;
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        long selectedStartInMillis = musicInfo.getSelectedStartInMillis();
        long selectedDurationInMillis = musicInfo.getSelectedDurationInMillis();
        ArrayList arrayList = new ArrayList();
        for (MusicTimePoint musicTimePoint : musicInfo.c()) {
            if (b(musicTimePoint) && musicTimePoint.getTimeInMillis() >= selectedStartInMillis && musicTimePoint.getTimeInMillis() <= selectedStartInMillis + selectedDurationInMillis) {
                arrayList.add(MusicTimePoint.b(musicTimePoint, null, musicTimePoint.getTimeInMillis() - selectedStartInMillis, 1, null));
            }
        }
        QLog.i("WinkAutoClipHelper", 1, "adjust clip, beats after removing out of time range count=" + arrayList.size());
        distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) distinct);
        QLog.i("WinkAutoClipHelper", 1, "adjust clip, beats after removing duplicated count=" + mutableList.size());
        if (mutableList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, new b());
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) f(mutableList));
        QLog.i("WinkAutoClipHelper", 1, "adjust clip, beats after removing too closed count=" + mutableList2.size());
        return mutableList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final TemplateMusicInfoParseResult n(@Nullable String str) {
        boolean z16;
        LightAssetDataContext d16;
        MusicInfo k3;
        boolean isBlank;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                try {
                    w53.b.f("WinkAutoClipHelper", "templatePath = " + str);
                    com.tencent.videocut.render.utils.b bVar = com.tencent.videocut.render.utils.b.f384205a;
                    LightAsset c16 = bVar.c(str);
                    if (c16 == null || (d16 = bVar.d(str)) == null || (k3 = k(d16)) == null) {
                        return null;
                    }
                    return new TemplateMusicInfoParseResult(k3, l(c16));
                } catch (Exception unused) {
                    return null;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @NotNull
    public static final ClipRes o(@NotNull MediaClip mediaClip) {
        MediaType mediaType;
        int i3;
        ClipRes.ClipResType clipResType;
        long j3;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null) {
            mediaType = resourceModel.type;
        } else {
            mediaType = null;
        }
        if (mediaType == null) {
            i3 = -1;
        } else {
            i3 = a.f321505b[mediaType.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                clipResType = ClipRes.ClipResType.UNKNOWN;
            } else {
                clipResType = ClipRes.ClipResType.PHOTO;
            }
        } else {
            clipResType = ClipRes.ClipResType.VIDEO;
        }
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null) {
            j3 = resourceModel2.sourceDuration / 1000;
        } else {
            j3 = 0;
        }
        return new ClipRes(clipResType, j3);
    }

    @NotNull
    public static final List<MusicTimePoint> p(@NotNull QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo) {
        MusicTimePoint.MusicTimePointType musicTimePointType;
        Intrinsics.checkNotNullParameter(qQCircleSmartMatchMusic$MusicStuckPointInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<QQCircleSmartMatchMusic$StuckPointData> it = qQCircleSmartMatchMusic$MusicStuckPointInfo.allData.get().iterator();
        while (it.hasNext()) {
            Iterator<QQCircleSmartMatchMusic$EffectPoint> it5 = it.next().effectPoints.get().iterator();
            while (it5.hasNext()) {
                String str = it5.next().get().type.get();
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -197774825) {
                        if (hashCode != 1410775384) {
                            if (hashCode == 1653389499 && str.equals(TAVRhythmAutomaticTemplate.PuckingDrum)) {
                                musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM;
                            }
                        } else if (str.equals("ParagraphTrail")) {
                            musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH;
                        }
                    } else if (str.equals("SlowRhythm")) {
                        musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM;
                    }
                    arrayList.add(new MusicTimePoint(musicTimePointType, r2.time.get()));
                }
                musicTimePointType = MusicTimePoint.MusicTimePointType.BEAT_TYPE_OTHER;
                arrayList.add(new MusicTimePoint(musicTimePointType, r2.time.get()));
            }
        }
        return arrayList;
    }
}
