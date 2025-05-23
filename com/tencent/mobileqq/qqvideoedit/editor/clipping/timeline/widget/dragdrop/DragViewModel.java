package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004JY\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u00c6\u0001J\t\u0010\u001c\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010$\u001a\u0004\b,\u0010&R\u0017\u0010\u0018\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b(\u0010.R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u00101\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", "", "", "position", "", "isStart", "", "i", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;", "dragModel", "j", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;)Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", tl.h.F, "time", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/a;", "g", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;", "clazz", "startPosition", "endPosition", "minDistance", TAVOneClickFilmStickerEffect.TRACK_INDEX, "", "id", "Lrj2/a;", "scaleCalculator", "a", "toString", "hashCode", "other", "equals", "Ljava/lang/Class;", "getClazz", "()Ljava/lang/Class;", "b", "I", "e", "()I", "c", "d", "J", "getMinDistance", "()J", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "Lrj2/a;", "getScaleCalculator", "()Lrj2/a;", "<init>", "(Ljava/lang/Class;IIJILjava/lang/String;Lrj2/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.k, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class DragViewModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Class<? extends o> clazz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int startPosition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int endPosition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long minDistance;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int trackIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final rj2.a scaleCalculator;

    public DragViewModel(@NotNull Class<? extends o> clazz, int i3, int i16, long j3, int i17, @NotNull String id5, @Nullable rj2.a aVar) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(id5, "id");
        this.clazz = clazz;
        this.startPosition = i3;
        this.endPosition = i16;
        this.minDistance = j3;
        this.trackIndex = i17;
        this.id = id5;
        this.scaleCalculator = aVar;
    }

    public static /* synthetic */ DragViewModel b(DragViewModel dragViewModel, Class cls, int i3, int i16, long j3, int i17, String str, rj2.a aVar, int i18, Object obj) {
        Class cls2;
        int i19;
        int i26;
        long j16;
        int i27;
        String str2;
        rj2.a aVar2;
        if ((i18 & 1) != 0) {
            cls2 = dragViewModel.clazz;
        } else {
            cls2 = cls;
        }
        if ((i18 & 2) != 0) {
            i19 = dragViewModel.startPosition;
        } else {
            i19 = i3;
        }
        if ((i18 & 4) != 0) {
            i26 = dragViewModel.endPosition;
        } else {
            i26 = i16;
        }
        if ((i18 & 8) != 0) {
            j16 = dragViewModel.minDistance;
        } else {
            j16 = j3;
        }
        if ((i18 & 16) != 0) {
            i27 = dragViewModel.trackIndex;
        } else {
            i27 = i17;
        }
        if ((i18 & 32) != 0) {
            str2 = dragViewModel.id;
        } else {
            str2 = str;
        }
        if ((i18 & 64) != 0) {
            aVar2 = dragViewModel.scaleCalculator;
        } else {
            aVar2 = aVar;
        }
        return dragViewModel.a(cls2, i19, i26, j16, i27, str2, aVar2);
    }

    private final long i(int position, boolean isStart) {
        Object obj;
        AttractPoint attractPoint = null;
        if (isStart) {
            Pair a16 = i.a();
            if (a16 != null) {
                obj = a16.getFirst();
                attractPoint = (AttractPoint) obj;
            }
        } else {
            Pair a17 = i.a();
            if (a17 != null) {
                obj = a17.getSecond();
                attractPoint = (AttractPoint) obj;
            }
        }
        if (attractPoint != null && position == attractPoint.getPx() && attractPoint.getTime() > 0) {
            return attractPoint.getTime();
        }
        rj2.a aVar = this.scaleCalculator;
        if (aVar == null) {
            return 0L;
        }
        return aVar.t(position);
    }

    @NotNull
    public final DragViewModel a(@NotNull Class<? extends o> clazz, int startPosition, int endPosition, long minDistance, int trackIndex, @NotNull String id5, @Nullable rj2.a scaleCalculator) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(id5, "id");
        return new DragViewModel(clazz, startPosition, endPosition, minDistance, trackIndex, id5, scaleCalculator);
    }

    /* renamed from: c, reason: from getter */
    public final int getEndPosition() {
        return this.endPosition;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final int getStartPosition() {
        return this.startPosition;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DragViewModel)) {
            return false;
        }
        DragViewModel dragViewModel = (DragViewModel) other;
        if (Intrinsics.areEqual(this.clazz, dragViewModel.clazz) && this.startPosition == dragViewModel.startPosition && this.endPosition == dragViewModel.endPosition && this.minDistance == dragViewModel.minDistance && this.trackIndex == dragViewModel.trackIndex && Intrinsics.areEqual(this.id, dragViewModel.id) && Intrinsics.areEqual(this.scaleCalculator, dragViewModel.scaleCalculator)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getTrackIndex() {
        return this.trackIndex;
    }

    @NotNull
    public final AttractPoint g(long time, boolean isStart) {
        int i3;
        if (isStart) {
            i3 = this.startPosition;
        } else {
            i3 = this.endPosition;
        }
        return new AttractPoint(time, i3, this.id, isStart);
    }

    @NotNull
    public final DragModel h() {
        DragModel dragModel = new DragModel(this.clazz, i(this.startPosition, true), i(this.endPosition, false), this.minDistance, this.trackIndex, this.id);
        i.b(null);
        return dragModel;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.clazz.hashCode() * 31) + this.startPosition) * 31) + this.endPosition) * 31) + androidx.fragment.app.a.a(this.minDistance)) * 31) + this.trackIndex) * 31) + this.id.hashCode()) * 31;
        rj2.a aVar = this.scaleCalculator;
        if (aVar == null) {
            hashCode = 0;
        } else {
            hashCode = aVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public final DragViewModel j(@NotNull DragModel dragModel) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(dragModel, "dragModel");
        Class<? extends o> a16 = dragModel.a();
        String id5 = dragModel.getId();
        rj2.a aVar = this.scaleCalculator;
        if (aVar != null) {
            i3 = aVar.u(dragModel.getStartTime());
        } else {
            i3 = 0;
        }
        rj2.a aVar2 = this.scaleCalculator;
        if (aVar2 != null) {
            i16 = aVar2.u(dragModel.getEndTime());
        } else {
            i16 = 0;
        }
        return b(this, a16, i3, i16, dragModel.getMinDistance(), dragModel.getTrackIndex(), id5, null, 64, null);
    }

    @NotNull
    public String toString() {
        return "DragViewModel(clazz=" + this.clazz + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + ", minDistance=" + this.minDistance + ", trackIndex=" + this.trackIndex + ", id=" + this.id + ", scaleCalculator=" + this.scaleCalculator + ")";
    }

    public /* synthetic */ DragViewModel(Class cls, int i3, int i16, long j3, int i17, String str, rj2.a aVar, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i18 & 2) != 0 ? 0 : i3, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? 0L : j3, (i18 & 16) != 0 ? -1 : i17, str, (i18 & 64) != 0 ? null : aVar);
    }
}
