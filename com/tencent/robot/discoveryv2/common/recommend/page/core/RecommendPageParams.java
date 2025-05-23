package com.tencent.robot.discoveryv2.common.recommend.page.core;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/page/core/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uin", "b", "categoryId", "c", "categoryName", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.discoveryv2.common.recommend.page.core.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RecommendPageParams {

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
    private final LifecycleOwner lifecycleOwner;

    public RecommendPageParams(@NotNull String uin, @NotNull String categoryId, @NotNull String categoryName, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.uin = uin;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.lifecycleOwner = lifecycleOwner;
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
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
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
        if (!(other instanceof RecommendPageParams)) {
            return false;
        }
        RecommendPageParams recommendPageParams = (RecommendPageParams) other;
        if (Intrinsics.areEqual(this.uin, recommendPageParams.uin) && Intrinsics.areEqual(this.categoryId, recommendPageParams.categoryId) && Intrinsics.areEqual(this.categoryName, recommendPageParams.categoryName) && Intrinsics.areEqual(this.lifecycleOwner, recommendPageParams.lifecycleOwner)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.uin.hashCode() * 31) + this.categoryId.hashCode()) * 31) + this.categoryName.hashCode()) * 31) + this.lifecycleOwner.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecommendPageParams(uin=" + this.uin + ", categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", lifecycleOwner=" + this.lifecycleOwner + ")";
    }
}
