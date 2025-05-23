package ke4;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.render.builder.light.c;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.ClipAsset;
import org.light.ClipInfo;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TimeRange;
import org.light.VideoOutputConfig;
import tl.h;
import zd4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0010B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ:\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u001c\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J(\u0010\u001d\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005H\u0002J\u0016\u0010 \u001a\u00020\u001e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\u0016\u0010!\u001a\u00020\u001e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\u0016\u0010\"\u001a\u00020\u001e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J(\u0010%\u001a\u00020\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J&\u0010(\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J+\u0010*\u001a\u00020\u001e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u00a2\u0006\u0004\b*\u0010+J(\u00100\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010/\u001a\u00020\u001eJ\u001d\u00102\u001a\u00020\u001e2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b2\u00103\u00a8\u00066"}, d2 = {"Lke4/a;", "", "", "Lorg/light/ClipPlaceHolder;", "clipPlaceHolders", "", "Lke4/a$a;", "p", "([Lorg/light/ClipPlaceHolder;)Ljava/util/List;", "Lcom/tencent/tavcut/model/ClipSource;", "clips", "lightSegments", "", "musicVolume", "", "duration", "b", "e", "segment", "", "", "a", "clip", "mLightSegments", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "movieClips", "r", "videoRes", "c", h.F, "", "o", "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "remainClips", "mNeedCycleFill", "f", "mediaClip", "d", "i", SegmentKeeper.KEY_SEGMENT_LIST, "l", "([Lorg/light/ClipPlaceHolder;Ljava/util/List;)Z", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "filledClipAssets", "modifyClipsDuration", "g", "clipHolders", DomainData.DOMAIN_NAME, "([Lorg/light/ClipPlaceHolder;)Z", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f412272a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lke4/a$a;", "", "Lke4/a$b;", "a", "Lke4/a$b;", "()Lke4/a$b;", "d", "(Lke4/a$b;)V", "timeRange", "", "b", "J", "getMinDuration", "()J", "c", "(J)V", "minDuration", "", "Lcom/tencent/tavcut/model/ClipSource;", "Ljava/util/List;", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "videoResourceModels", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: ke4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10653a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long minDuration;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private b timeRange = new b(0, 0, 3, null);

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<ClipSource> videoResourceModels = new ArrayList();

        @NotNull
        /* renamed from: a, reason: from getter */
        public final b getTimeRange() {
            return this.timeRange;
        }

        @NotNull
        public final List<ClipSource> b() {
            return this.videoResourceModels;
        }

        public final void c(long j3) {
            this.minDuration = j3;
        }

        public final void d(@NotNull b bVar) {
            Intrinsics.checkParameterIsNotNull(bVar, "<set-?>");
            this.timeRange = bVar;
        }

        public final void e(@NotNull List<ClipSource> list) {
            Intrinsics.checkParameterIsNotNull(list, "<set-?>");
            this.videoResourceModels = list;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lke4/a$b;", "", "", "a", "J", "getStart", "()J", "start", "b", "duration", "<init>", "(JJ)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long start;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long duration;

        public b(long j3, long j16) {
            this.start = j3;
            this.duration = j16;
        }

        /* renamed from: a, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        public /* synthetic */ b(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16);
        }
    }

    a() {
    }

    private final void a(C10653a segment, float musicVolume, List<ClipSource> clips) {
        for (ClipSource clipSource : segment.b()) {
            ClipSource.ClipType clipType = clipSource.type;
            if (clipType == ClipSource.ClipType.VIDEO) {
                h(clipSource, musicVolume, clips);
            } else if (clipType == ClipSource.ClipType.PHOTO) {
                c(clipSource, clips);
            }
        }
    }

    private final List<ClipSource> b(List<ClipSource> clips, List<C10653a> lightSegments, float musicVolume, long duration) {
        List<ClipSource> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) clips);
        boolean o16 = o(mutableList);
        if (o16 && lightSegments.size() > 1) {
            mutableList = q(mutableList.get(0), lightSegments);
        } else if (k(mutableList) && mutableList.size() < lightSegments.size() && !o16) {
            mutableList = r(mutableList, lightSegments, duration);
        }
        boolean m3 = m(mutableList);
        for (C10653a c10653a : lightSegments) {
            if (mutableList.isEmpty()) {
                break;
            }
            f(c10653a, mutableList, m3);
        }
        return e(lightSegments, musicVolume);
    }

    private final void c(ClipSource videoRes, List<ClipSource> clips) {
        if (videoRes == null) {
            return;
        }
        clips.add(new ClipSource(videoRes.sourceId, videoRes.path, ClipSource.ClipType.PHOTO, videoRes.duration, null, null, null, null, null, null, null, null, 4080, null));
    }

    private final void d(ClipSource mediaClip, C10653a segment) {
        segment.b().add(ClipSource.copy$default(mediaClip, null, null, null, segment.getTimeRange().getDuration(), null, null, null, null, null, null, null, null, 4087, null));
    }

    private final List<ClipSource> e(List<C10653a> lightSegments, float musicVolume) {
        ArrayList arrayList = new ArrayList();
        Iterator<C10653a> it = lightSegments.iterator();
        while (it.hasNext()) {
            a(it.next(), musicVolume, arrayList);
        }
        return arrayList;
    }

    private final boolean f(C10653a segment, List<ClipSource> remainClips, boolean mNeedCycleFill) {
        ClipSource remove;
        if (segment == null || remainClips.isEmpty()) {
            return false;
        }
        if (mNeedCycleFill) {
            remove = remainClips.remove(0);
            remainClips.add(ClipSource.copy$default(remove, null, null, null, 0L, null, null, null, null, null, null, null, null, 4095, null));
        } else {
            remove = remainClips.remove(0);
        }
        ClipSource.ClipType clipType = remove.type;
        if (clipType != null) {
            int i3 = ke4.b.f412278a[clipType.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    i(remove, segment, remainClips);
                }
            } else {
                d(remove, segment);
            }
        }
        return true;
    }

    private final void h(ClipSource videoRes, float musicVolume, List<ClipSource> clips) {
        if (videoRes == null) {
            return;
        }
        ClipSource.ClipType clipType = ClipSource.ClipType.VIDEO;
        clips.add(new ClipSource(videoRes.sourceId, videoRes.path, clipType, videoRes.duration, videoRes.speed, videoRes.volume, videoRes.startOffset, null, null, null, null, null, Utf8.MASK_2BYTES, null));
    }

    private final void i(ClipSource mediaClip, C10653a segment, List<ClipSource> remainClips) {
        boolean z16;
        long j3;
        long j16;
        ArrayList arrayList = new ArrayList();
        long duration = segment.getTimeRange().getDuration();
        ClipSource clipSource = mediaClip;
        while (duration > 0) {
            long j17 = clipSource.duration;
            ClipSource.ClipType clipType = clipSource.type;
            if (arrayList.isEmpty() && clipType == ClipSource.ClipType.VIDEO && j17 > duration) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                long j18 = (j17 - duration) / 2;
                Long l3 = clipSource.startOffset;
                if (l3 != null) {
                    j16 = l3.longValue();
                } else {
                    j16 = 0;
                }
                j3 = j17;
                clipSource = ClipSource.copy$default(clipSource, null, null, null, duration, null, null, Long.valueOf(j16 + j18), null, null, null, null, null, InnerShareData.SUB_SCENE_ARK_INVITE_API, null);
            } else {
                j3 = j17;
                if (clipType == ClipSource.ClipType.PHOTO) {
                    clipSource = ClipSource.copy$default(clipSource, null, null, null, duration, null, null, 0L, null, null, null, null, null, InnerShareData.SUB_SCENE_ARK_INVITE_API, null);
                    j3 = duration;
                }
                ClipSource clipSource2 = clipSource;
                if (duration < j3) {
                    clipSource = ClipSource.copy$default(clipSource2, null, null, null, duration, null, null, clipSource2.startOffset, null, null, null, null, null, InnerShareData.SUB_SCENE_ARK_INVITE_API, null);
                } else {
                    clipSource = clipSource2;
                }
            }
            arrayList.add(clipSource);
            duration -= j3;
            if (duration > 0) {
                if (remainClips.size() == 0) {
                    break;
                } else {
                    clipSource = remainClips.remove(0);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((ClipSource) it.next());
        }
        segment.e(arrayList2);
    }

    private final boolean j(List<ClipSource> clips) {
        boolean z16;
        if (clips.isEmpty()) {
            return false;
        }
        List<ClipSource> list = clips;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ClipSource) it.next()).type == ClipSource.ClipType.PHOTO) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean k(List<ClipSource> movieClips) {
        boolean z16;
        if (movieClips.isEmpty()) {
            return false;
        }
        List<ClipSource> list = movieClips;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ClipSource) it.next()).type == ClipSource.ClipType.VIDEO) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean l(ClipPlaceHolder[] clipPlaceHolders, List<C10653a> segments) {
        Object lastOrNull;
        long j3;
        Object lastOrNull2;
        List<ClipSource> b16;
        if (segments.size() >= clipPlaceHolders.length) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) segments);
            C10653a c10653a = (C10653a) lastOrNull;
            long j16 = 0;
            if (c10653a != null && (b16 = c10653a.b()) != null) {
                Iterator<T> it = b16.iterator();
                j3 = 0;
                while (it.hasNext()) {
                    j3 += ((ClipSource) it.next()).duration;
                }
            } else {
                j3 = 0;
            }
            lastOrNull2 = ArraysKt___ArraysKt.lastOrNull(clipPlaceHolders);
            ClipPlaceHolder clipPlaceHolder = (ClipPlaceHolder) lastOrNull2;
            if (clipPlaceHolder != null) {
                j16 = clipPlaceHolder.contentDuration;
            }
            if (j3 < j16) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean m(List<ClipSource> clips) {
        return j(clips);
    }

    private final boolean o(List<ClipSource> clips) {
        if (clips == null || clips.size() != 1 || clips.get(0).type != ClipSource.ClipType.VIDEO) {
            return false;
        }
        return true;
    }

    private final List<C10653a> p(ClipPlaceHolder[] clipPlaceHolders) {
        List<C10653a> emptyList;
        boolean z16;
        if (clipPlaceHolders != null) {
            if (clipPlaceHolders.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ArrayList arrayList = new ArrayList();
                for (ClipPlaceHolder clipPlaceHolder : clipPlaceHolders) {
                    C10653a c10653a = new C10653a();
                    c10653a.d(new b(0L, clipPlaceHolder.contentDuration));
                    c10653a.c(clipPlaceHolder.contentDuration);
                    arrayList.add(c10653a);
                }
                return arrayList;
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    private final List<ClipSource> q(ClipSource clip, List<C10653a> mLightSegments) {
        long j3;
        ArrayList arrayList = new ArrayList();
        Iterator<C10653a> it = mLightSegments.iterator();
        ClipSource clipSource = clip;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C10653a next = it.next();
            if (next != null) {
                if (next.getTimeRange().getDuration() >= clipSource.duration) {
                    arrayList.add(clipSource);
                    break;
                }
                ClipSource clipSource2 = clipSource;
                ClipSource copy$default = ClipSource.copy$default(clipSource, null, null, null, next.getTimeRange().getDuration(), null, null, clipSource.startOffset, null, null, null, null, null, InnerShareData.SUB_SCENE_ARK_INVITE_API, null);
                arrayList.add(copy$default);
                long j16 = clipSource2.duration - copy$default.duration;
                Long l3 = copy$default.startOffset;
                if (l3 != null) {
                    j3 = l3.longValue();
                } else {
                    j3 = 0;
                }
                clipSource = ClipSource.copy$default(clipSource2, null, null, null, j16, null, null, Long.valueOf(j3 + copy$default.duration), null, null, null, null, null, InnerShareData.SUB_SCENE_ARK_INVITE_API, null);
            }
        }
        return arrayList;
    }

    private final List<ClipSource> r(List<ClipSource> movieClips, List<C10653a> lightSegments, long duration) {
        int i3;
        long j3;
        long j16;
        ArrayList<ClipSource> arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        long j17 = 0;
        if (duration <= 0) {
            return arrayList;
        }
        if (movieClips == null) {
            Intrinsics.throwNpe();
        }
        Iterator<ClipSource> it = movieClips.iterator();
        long j18 = 0;
        while (it.hasNext()) {
            ClipSource next = it.next();
            if (next != null) {
                long j19 = next.duration;
                if (j19 != 0) {
                    j18 += j19;
                }
            }
            it.remove();
        }
        if (j18 <= 0) {
            return arrayList;
        }
        for (ClipSource clipSource : movieClips) {
            long j26 = clipSource.duration;
            long j27 = (j26 * duration) / j18;
            if (j26 >= j27) {
                j26 = j27;
            }
            String str = clipSource.path;
            if (str == null) {
                str = "";
            }
            concurrentHashMap.put(str, Long.valueOf(j26));
        }
        int size = lightSegments.size();
        int i16 = 0;
        int i17 = 0;
        while (i17 < size && !movieClips.isEmpty()) {
            long duration2 = lightSegments.get(i17).getTimeRange().getDuration();
            while (duration2 > j17 && (!movieClips.isEmpty())) {
                ClipSource remove = movieClips.remove(i16);
                long j28 = remove.duration;
                long j29 = j17;
                for (ClipSource clipSource2 : arrayList) {
                    if (TextUtils.equals(clipSource2.path, remove.path)) {
                        j29 += clipSource2.duration;
                    }
                }
                Object obj = concurrentHashMap.get(remove.path);
                if (obj == null) {
                    Intrinsics.throwNpe();
                }
                if (j29 <= ((Number) obj).longValue()) {
                    j17 = 0;
                    if (j28 > 0) {
                        if (j29 != 0 && j28 < duration2) {
                            j17 = 0;
                        } else {
                            if (j28 > duration2) {
                                j3 = duration2;
                            } else {
                                j3 = j28;
                            }
                            arrayList.add(ClipSource.copy$default(remove, null, null, null, j3, null, null, null, null, null, null, null, null, 4087, null));
                            long j36 = j28 - duration2;
                            j17 = 0;
                            if (j36 > 0) {
                                Long l3 = remove.startOffset;
                                if (l3 != null) {
                                    j16 = l3.longValue();
                                } else {
                                    j16 = 0;
                                }
                                ClipSource copy$default = ClipSource.copy$default(remove, null, null, null, j36, null, null, Long.valueOf(j16 + duration2), null, null, null, null, null, InnerShareData.SUB_SCENE_ARK_INVITE_API, null);
                                i3 = 0;
                                movieClips.add(0, copy$default);
                            } else {
                                i3 = 0;
                            }
                            duration2 -= j28;
                            i16 = i3;
                        }
                    }
                } else {
                    j17 = 0;
                }
                i3 = 0;
                i16 = i3;
            }
            i17++;
            i16 = i16;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ce  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RenderModel g(@Nullable RenderModel renderModel, @NotNull List<ClipSource> filledClipAssets, boolean modifyClipsDuration) {
        String str;
        List<ClipSource> list;
        long j3;
        List<ClipSource> list2;
        RenderModel copy;
        int collectionSizeOrDefault;
        Object last;
        Object last2;
        long j16;
        List emptyList;
        RenderModel copy2;
        Intrinsics.checkParameterIsNotNull(filledClipAssets, "filledClipAssets");
        if (renderModel == null) {
            return null;
        }
        renderModel.getMaxDuration();
        try {
            TemplateParser templateParser = TemplateParser.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            copy2 = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : null, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : emptyList, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : 0L, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
            str = templateParser.dumpJson(copy2);
        } catch (IllegalStateException e16) {
            ee4.b.b("TemplateSegmentHelper", "parse renderModel json error: " + e16.getMessage());
            try {
                str = od4.b.f422509e.v();
            } catch (IllegalStateException e17) {
                ee4.b.b("TemplateSegmentHelper", "parse renderModel json error: " + e17.getMessage());
                str = "";
            }
        }
        LightAsset LoadFromString = LightAsset.LoadFromString("/", str, 0);
        VideoOutputConfig videoOutputConfig = new VideoOutputConfig(30.0f, renderModel.getSeekTolerance());
        AudioOutputConfig audioOutputConfig = new AudioOutputConfig();
        RendererConfig rendererConfig = new RendererConfig(e.f452395c.a());
        c cVar = c.f374382c;
        od4.b bVar = od4.b.f422509e;
        if (cVar.a(bVar.o(), bVar.r(), bVar.l(), bVar.k()) != 0) {
            ee4.b.a("TemplateSegmentHelper", "\u9274\u6743\u5931\u8d25");
            return null;
        }
        LightEngine make = LightEngine.make(videoOutputConfig, audioOutputConfig, rendererConfig);
        MovieController movieController = make.setAssetForMovie(LoadFromString);
        Intrinsics.checkExpressionValueIsNotNull(movieController, "movieController");
        boolean n3 = n(movieController.getClipPlaceHolders());
        List<C10653a> p16 = p(movieController.getClipPlaceHolders());
        if (!n3) {
            list = b(filledClipAssets, p16, 0.0f, movieController.duration());
        } else {
            list = filledClipAssets;
        }
        Object[] array = com.tencent.tavcut.render.builder.light.a.a(list).toArray(new ClipAsset[0]);
        if (array != null) {
            ClipAsset[] clipAssetArr = (ClipAsset[]) array;
            ee4.b.a("TemplateSegmentHelper", "setClipAssets clipAssets size: " + clipAssetArr.length);
            movieController.setClipAssets(clipAssetArr, renderModel.getPainting().pagPath, modifyClipsDuration);
            long duration = movieController.duration();
            if (!n3) {
                ClipPlaceHolder[] clipPlaceHolders = movieController.getClipPlaceHolders();
                Intrinsics.checkExpressionValueIsNotNull(clipPlaceHolders, "movieController.clipPlaceHolders");
                if (!l(clipPlaceHolders, p16)) {
                    ClipInfo[][] clipInfos = movieController.getClipInfos();
                    Intrinsics.checkExpressionValueIsNotNull(clipInfos, "movieController.clipInfos");
                    last = ArraysKt___ArraysKt.last(clipInfos);
                    Intrinsics.checkExpressionValueIsNotNull(last, "movieController.clipInfos.last()");
                    last2 = ArraysKt___ArraysKt.last((Object[]) last);
                    ClipInfo clipInfo = (ClipInfo) last2;
                    if (clipInfo != null) {
                        TimeRange timeRange = clipInfo.targetTimeRange;
                        j16 = timeRange.startTime + timeRange.duration;
                    } else {
                        j16 = -1;
                    }
                    j3 = j16;
                    if (!n3) {
                        List<ClipSource> list3 = list;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        int i3 = 0;
                        for (Object obj : list3) {
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            ClipSource clipSource = (ClipSource) obj;
                            ClipInfo[] clipInfoArr = movieController.getClipInfos()[i3];
                            Intrinsics.checkExpressionValueIsNotNull(clipInfoArr, "movieController.clipInfos[index]");
                            long j17 = 0;
                            for (ClipInfo clipInfo2 : clipInfoArr) {
                                j17 += clipInfo2.sourceTimeRange.duration;
                            }
                            arrayList.add(ClipSource.copy$default(clipSource, null, null, null, j17, null, null, null, null, null, null, null, null, 4087, null));
                            i3 = i16;
                        }
                        list2 = arrayList;
                    } else {
                        list2 = list;
                    }
                    movieController.resetAsset();
                    make.release();
                    copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : null, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : list2, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : j3, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
                    return copy;
                }
            }
            j3 = duration;
            if (!n3) {
            }
            movieController.resetAsset();
            make.release();
            copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : null, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : list2, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : j3, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
            return copy;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final boolean n(@Nullable ClipPlaceHolder[] clipHolders) {
        boolean z16;
        if (clipHolders != null) {
            if (clipHolders.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (ClipPlaceHolder clipPlaceHolder : clipHolders) {
                    if (clipPlaceHolder.contentDuration != 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
