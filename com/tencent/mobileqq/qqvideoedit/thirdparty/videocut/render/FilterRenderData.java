package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "index", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "()Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "filterModel", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "parentId", "<init>", "(ILcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;Ljava/lang/String;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.h, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class FilterRenderData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final FilterModel filterModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String parentId;

    public FilterRenderData(int i3, @NotNull FilterModel filterModel, @NotNull String parentId) {
        Intrinsics.checkNotNullParameter(filterModel, "filterModel");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        this.index = i3;
        this.filterModel = filterModel;
        this.parentId = parentId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final FilterModel getFilterModel() {
        return this.filterModel;
    }

    /* renamed from: b, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getParentId() {
        return this.parentId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterRenderData)) {
            return false;
        }
        FilterRenderData filterRenderData = (FilterRenderData) other;
        if (this.index == filterRenderData.index && Intrinsics.areEqual(this.filterModel, filterRenderData.filterModel) && Intrinsics.areEqual(this.parentId, filterRenderData.parentId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.index * 31) + this.filterModel.hashCode()) * 31) + this.parentId.hashCode();
    }

    @NotNull
    public String toString() {
        return "FilterRenderData(index=" + this.index + ", filterModel=" + this.filterModel + ", parentId=" + this.parentId + ")";
    }

    public /* synthetic */ FilterRenderData(int i3, FilterModel filterModel, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, filterModel, (i16 & 4) != 0 ? "" : str);
    }
}
