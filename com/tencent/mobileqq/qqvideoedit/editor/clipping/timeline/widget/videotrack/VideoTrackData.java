package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/o;", "", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "a", "b", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "c", "()Ljava/util/List;", "videoTrackModelList", "getTransitionModelList", "transitionModelList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.o, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class VideoTrackData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<ClipModel> videoTrackModelList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Object> transitionModelList;

    public VideoTrackData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<ClipModel> a() {
        return this.videoTrackModelList;
    }

    @NotNull
    public final List<Object> b() {
        return this.transitionModelList;
    }

    @NotNull
    public final List<ClipModel> c() {
        return this.videoTrackModelList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoTrackData)) {
            return false;
        }
        VideoTrackData videoTrackData = (VideoTrackData) other;
        if (Intrinsics.areEqual(this.videoTrackModelList, videoTrackData.videoTrackModelList) && Intrinsics.areEqual(this.transitionModelList, videoTrackData.transitionModelList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.videoTrackModelList.hashCode() * 31) + this.transitionModelList.hashCode();
    }

    @NotNull
    public String toString() {
        return "VideoTrackData(videoTrackModelList=" + this.videoTrackModelList + ", transitionModelList=" + this.transitionModelList + ")";
    }

    public VideoTrackData(@NotNull List<ClipModel> videoTrackModelList, @NotNull List<Object> transitionModelList) {
        Intrinsics.checkNotNullParameter(videoTrackModelList, "videoTrackModelList");
        Intrinsics.checkNotNullParameter(transitionModelList, "transitionModelList");
        this.videoTrackModelList = videoTrackModelList;
        this.transitionModelList = transitionModelList;
    }

    public /* synthetic */ VideoTrackData(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }
}
