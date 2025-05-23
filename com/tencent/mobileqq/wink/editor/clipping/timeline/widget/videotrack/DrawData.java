package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\r\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "selectStatus", "b", "Z", "c", "()Z", "isShowDurationText", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/g;", "Ljava/util/List;", "()Ljava/util/List;", "tagList", "<init>", "(IZLjava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class DrawData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectStatus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isShowDurationText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<TagData> tagList;

    public DrawData() {
        this(0, false, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getSelectStatus() {
        return this.selectStatus;
    }

    @NotNull
    public final List<TagData> b() {
        return this.tagList;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsShowDurationText() {
        return this.isShowDurationText;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawData)) {
            return false;
        }
        DrawData drawData = (DrawData) other;
        if (this.selectStatus == drawData.selectStatus && this.isShowDurationText == drawData.isShowDurationText && Intrinsics.areEqual(this.tagList, drawData.tagList)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.selectStatus * 31;
        boolean z16 = this.isShowDurationText;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((i3 + i16) * 31) + this.tagList.hashCode();
    }

    @NotNull
    public String toString() {
        return "DrawData(selectStatus=" + this.selectStatus + ", isShowDurationText=" + this.isShowDurationText + ", tagList=" + this.tagList + ")";
    }

    public DrawData(int i3, boolean z16, @NotNull List<TagData> tagList) {
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        this.selectStatus = i3;
        this.isShowDurationText = z16;
        this.tagList = tagList;
    }

    public /* synthetic */ DrawData(int i3, boolean z16, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
