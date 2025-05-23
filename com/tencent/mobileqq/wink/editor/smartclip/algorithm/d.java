package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicTimePoint;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n73.AutoClipResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0010B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J$\u0010\u0018\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/d;", "", "", "currentPointIndex", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "pointList", "", "minLimitTime", "minLimitStep", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/d$a;", "c", "currentIndex", "d", "durationList", "", "b", "Lcom/tencent/videocut/model/MediaClip;", "clips", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "musicInfo", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "fixedClipConfig", "Ln73/a;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/d$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "pointIndex", "", "J", "()J", "duration", "<init>", "(IJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.smartclip.algorithm.d$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ClipDurationResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pointIndex;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long duration;

        public ClipDurationResult(int i3, long j3) {
            this.pointIndex = i3;
            this.duration = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: b, reason: from getter */
        public final int getPointIndex() {
            return this.pointIndex;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClipDurationResult)) {
                return false;
            }
            ClipDurationResult clipDurationResult = (ClipDurationResult) other;
            if (this.pointIndex == clipDurationResult.pointIndex && this.duration == clipDurationResult.duration) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.pointIndex * 31) + androidx.fragment.app.a.a(this.duration);
        }

        @NotNull
        public String toString() {
            return "ClipDurationResult(pointIndex=" + this.pointIndex + ", duration=" + this.duration + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/d$b;", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "musicInfo", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint$MusicTimePointType;", "pointTypes", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "c", "points", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "fixedClipConfig", "", "f", "Lcom/tencent/videocut/model/MediaClip;", "clips", "Ln73/a;", "d", "e", "", "CLIP_MAX_LIMIT_TIME_US", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.smartclip.algorithm.d$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<MusicTimePoint> c(MusicInfo musicInfo, List<? extends MusicTimePoint.MusicTimePointType> pointTypes) {
            boolean z16;
            Object obj;
            boolean z17;
            List<MusicTimePoint> c16 = musicInfo.c();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : c16) {
                MusicTimePoint musicTimePoint = (MusicTimePoint) obj2;
                Iterator<T> it = pointTypes.iterator();
                while (true) {
                    z16 = true;
                    if (it.hasNext()) {
                        obj = it.next();
                        if (musicTimePoint.getType() == ((MusicTimePoint.MusicTimePointType) obj)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj == null || musicTimePoint.getTimeInMillis() <= musicInfo.getSelectedStartInMillis() || musicTimePoint.getTimeInMillis() > musicInfo.getSelectedStartInMillis() + musicInfo.getSelectedDurationInMillis()) {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj2);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f(List<MusicTimePoint> points, TemplateFixedClipConfig fixedClipConfig) {
            if (!fixedClipConfig.getUseInternalRhythm()) {
                w53.b.c("FixedAutoClipAlgorithm", "useInternalRhythm is false.");
                return false;
            }
            if (points.isEmpty()) {
                w53.b.c("FixedAutoClipAlgorithm", "available points is empty.");
                return false;
            }
            if (fixedClipConfig.getMinFreezePointInterval() > 10000000) {
                w53.b.c("FixedAutoClipAlgorithm", "minFreezePointInterval(" + fixedClipConfig.getMinFreezePointInterval() + ") too large.");
                return false;
            }
            if (fixedClipConfig.getHeadProtectDuration() > 10000000) {
                w53.b.c("FixedAutoClipAlgorithm", "headProtectDuration(" + fixedClipConfig.getHeadProtectDuration() + ") too large.");
                return false;
            }
            return true;
        }

        @NotNull
        public final AutoClipResult d(@NotNull List<? extends MediaClip> clips) {
            Intrinsics.checkNotNullParameter(clips, "clips");
            return new AutoClipResult(false, "\u8be5\u97f3\u4e50\u65e0\u5361\u70b9\u4fe1\u606f\uff0c\u97f3\u4e50\u5361\u70b9\u5173\u95ed", clips);
        }

        public final boolean e(@NotNull MusicInfo musicInfo, @NotNull TemplateFixedClipConfig fixedClipConfig) {
            Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
            Intrinsics.checkNotNullParameter(fixedClipConfig, "fixedClipConfig");
            if (!f(c(musicInfo, fixedClipConfig.e()), fixedClipConfig)) {
                w53.b.c("FixedAutoClipAlgorithm", "pre check not success.");
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    private final boolean b(List<Long> durationList) {
        Iterator<T> it = durationList.iterator();
        while (it.hasNext()) {
            if (((Number) it.next()).longValue() > 10000000) {
                return false;
            }
        }
        return true;
    }

    private final ClipDurationResult c(int currentPointIndex, List<MusicTimePoint> pointList, long minLimitTime, int minLimitStep) {
        long timeInMillis;
        int i3 = 0;
        long j3 = 0;
        while (true) {
            if (i3 > minLimitStep && j3 >= minLimitTime) {
                return new ClipDurationResult(currentPointIndex, j3);
            }
            int d16 = d(currentPointIndex, pointList);
            i3++;
            if (d16 <= currentPointIndex) {
                timeInMillis = pointList.get(d16).getTimeInMillis();
            } else {
                timeInMillis = pointList.get(d16).getTimeInMillis() - pointList.get(currentPointIndex).getTimeInMillis();
            }
            j3 += timeInMillis * 1000;
            currentPointIndex = d16;
        }
    }

    private final int d(int currentIndex, List<MusicTimePoint> pointList) {
        return (currentIndex + 1) % pointList.size();
    }

    @NotNull
    public final AutoClipResult a(@NotNull List<? extends MediaClip> clips, @NotNull MusicInfo musicInfo, @NotNull TemplateFixedClipConfig fixedClipConfig) {
        List<MusicTimePoint> mutableList;
        int collectionSizeOrDefault;
        int i3;
        long max;
        MediaType mediaType;
        int videoCropSpace;
        Intrinsics.checkNotNullParameter(clips, "clips");
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        Intrinsics.checkNotNullParameter(fixedClipConfig, "fixedClipConfig");
        Companion companion = INSTANCE;
        List c16 = companion.c(musicInfo, fixedClipConfig.e());
        if (!companion.f(c16, fixedClipConfig)) {
            w53.b.c("FixedAutoClipAlgorithm", "pre check not success.");
            return companion.d(clips);
        }
        w53.b.f("FixedAutoClipAlgorithm", "FixedAutoClip start calc, fixedClipConfig = " + fixedClipConfig);
        ArrayList arrayList = new ArrayList();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) c16);
        boolean z16 = false;
        mutableList.add(0, new MusicTimePoint(MusicTimePoint.MusicTimePointType.BEAT_TYPE_OTHER, musicInfo.getSelectedStartInMillis()));
        Iterator<T> it = clips.iterator();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i18 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaClip mediaClip = (MediaClip) next;
            if (i16 != 0) {
                z17 = z16;
            }
            if (z17) {
                i3 = i18;
                max = Math.max(fixedClipConfig.getMinFreezePointInterval(), Math.max(fixedClipConfig.getHeadProtectDuration(), 0L));
            } else {
                i3 = i18;
                max = Math.max(fixedClipConfig.getMinFreezePointInterval(), 0L);
            }
            long j3 = max;
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                mediaType = resourceModel.type;
            } else {
                mediaType = null;
            }
            if (mediaType == MediaType.IMAGE) {
                videoCropSpace = fixedClipConfig.getImageCropSpace();
            } else {
                videoCropSpace = fixedClipConfig.getVideoCropSpace();
            }
            ClipDurationResult c17 = c(i17, mutableList, j3, videoCropSpace);
            i17 = c17.getPointIndex();
            arrayList.add(Long.valueOf(c17.getDuration() / 1000));
            i16 = i3;
            z16 = false;
        }
        if (!b(arrayList)) {
            w53.b.c("FixedAutoClipAlgorithm", "result check not success. resultList = " + arrayList);
            return INSTANCE.d(clips);
        }
        w53.b.f("FixedAutoClipAlgorithm", "FixedAutoClip calc result = " + arrayList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        int i19 = 0;
        for (Object obj : arrayList) {
            int i26 = i19 + 1;
            if (i19 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList2.add(com.tencent.mobileqq.wink.editor.smartclip.c.h(clips.get(i19), ((Number) obj).longValue() * 1000));
            i19 = i26;
        }
        return new AutoClipResult(true, "", arrayList2);
    }
}
