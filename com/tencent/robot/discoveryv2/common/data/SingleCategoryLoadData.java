package com.tencent.robot.discoveryv2.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "categoryId", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "b", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "()Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "loadState", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "c", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "()Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "loadType", "<init>", "(Ljava/lang/String;Lcom/tencent/robot/discoveryv2/common/data/LoadState;Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.discoveryv2.common.data.g, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SingleCategoryLoadData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String categoryId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LoadState loadState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SingleCategoryLoadType loadType;

    public SingleCategoryLoadData(@NotNull String categoryId, @NotNull LoadState loadState, @NotNull SingleCategoryLoadType loadType) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        this.categoryId = categoryId;
        this.loadState = loadState;
        this.loadType = loadType;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final LoadState getLoadState() {
        return this.loadState;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final SingleCategoryLoadType getLoadType() {
        return this.loadType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleCategoryLoadData)) {
            return false;
        }
        SingleCategoryLoadData singleCategoryLoadData = (SingleCategoryLoadData) other;
        if (Intrinsics.areEqual(this.categoryId, singleCategoryLoadData.categoryId) && this.loadState == singleCategoryLoadData.loadState && this.loadType == singleCategoryLoadData.loadType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.categoryId.hashCode() * 31) + this.loadState.hashCode()) * 31) + this.loadType.hashCode();
    }

    @NotNull
    public String toString() {
        return "SingleCategoryLoadData(categoryId=" + this.categoryId + ", loadState=" + this.loadState + ", loadType=" + this.loadType + ")";
    }
}
