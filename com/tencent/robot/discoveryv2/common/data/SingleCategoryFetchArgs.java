package com.tencent.robot.discoveryv2.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/data/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uin", "b", "categoryId", "c", "categoryName", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "()Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "loadType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.discoveryv2.common.data.f, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SingleCategoryFetchArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String categoryId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String categoryName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SingleCategoryLoadType loadType;

    public SingleCategoryFetchArgs(@NotNull String uin, @NotNull String categoryId, @NotNull String categoryName, @NotNull SingleCategoryLoadType loadType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        this.uin = uin;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.loadType = loadType;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final SingleCategoryLoadType getLoadType() {
        return this.loadType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleCategoryFetchArgs)) {
            return false;
        }
        SingleCategoryFetchArgs singleCategoryFetchArgs = (SingleCategoryFetchArgs) other;
        if (Intrinsics.areEqual(this.uin, singleCategoryFetchArgs.uin) && Intrinsics.areEqual(this.categoryId, singleCategoryFetchArgs.categoryId) && Intrinsics.areEqual(this.categoryName, singleCategoryFetchArgs.categoryName) && this.loadType == singleCategoryFetchArgs.loadType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.uin.hashCode() * 31) + this.categoryId.hashCode()) * 31) + this.categoryName.hashCode()) * 31) + this.loadType.hashCode();
    }

    @NotNull
    public String toString() {
        return "SingleCategoryFetchArgs(uin=" + this.uin + ", categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", loadType=" + this.loadType + ")";
    }
}
