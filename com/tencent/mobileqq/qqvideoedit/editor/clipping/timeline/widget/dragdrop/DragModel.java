package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u0015\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;", "a", "Ljava/lang/Class;", "()Ljava/lang/Class;", "clazz", "", "b", "J", "e", "()J", "startTime", "c", "endTime", "d", "minDistance", "I", "f", "()I", TAVOneClickFilmStickerEffect.TRACK_INDEX, "Ljava/lang/String;", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/Class;JJJILjava/lang/String;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.h, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class DragModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Class<? extends o> clazz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long endTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long minDistance;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int trackIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    public DragModel(@NotNull Class<? extends o> clazz, long j3, long j16, long j17, int i3, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(id5, "id");
        this.clazz = clazz;
        this.startTime = j3;
        this.endTime = j16;
        this.minDistance = j17;
        this.trackIndex = i3;
        this.id = id5;
    }

    @NotNull
    public final Class<? extends o> a() {
        return this.clazz;
    }

    /* renamed from: b, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final long getMinDistance() {
        return this.minDistance;
    }

    /* renamed from: e, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DragModel)) {
            return false;
        }
        DragModel dragModel = (DragModel) other;
        if (Intrinsics.areEqual(this.clazz, dragModel.clazz) && this.startTime == dragModel.startTime && this.endTime == dragModel.endTime && this.minDistance == dragModel.minDistance && this.trackIndex == dragModel.trackIndex && Intrinsics.areEqual(this.id, dragModel.id)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getTrackIndex() {
        return this.trackIndex;
    }

    public int hashCode() {
        return (((((((((this.clazz.hashCode() * 31) + androidx.fragment.app.a.a(this.startTime)) * 31) + androidx.fragment.app.a.a(this.endTime)) * 31) + androidx.fragment.app.a.a(this.minDistance)) * 31) + this.trackIndex) * 31) + this.id.hashCode();
    }

    @NotNull
    public String toString() {
        return "DragModel(clazz=" + this.clazz + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", minDistance=" + this.minDistance + ", trackIndex=" + this.trackIndex + ", id=" + this.id + ")";
    }

    public /* synthetic */ DragModel(Class cls, long j3, long j16, long j17, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? 0L : j16, (i16 & 8) != 0 ? 0L : j17, (i16 & 16) != 0 ? -1 : i3, str);
    }
}
