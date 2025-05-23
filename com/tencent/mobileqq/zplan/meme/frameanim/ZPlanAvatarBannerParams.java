package com.tencent.mobileqq.zplan.meme.frameanim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;", "b", "Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;", "getStrategyId", "()Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;", "strategyId", "I", "()I", "businessId", "d", "scene", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;II)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.meme.frameanim.i, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanAvatarBannerParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final StrategyId strategyId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int scene;

    public ZPlanAvatarBannerParams(@NotNull String uin, @NotNull StrategyId strategyId, int i3, int i16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(strategyId, "strategyId");
        this.uin = uin;
        this.strategyId = strategyId;
        this.businessId = i3;
        this.scene = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getBusinessId() {
        return this.businessId;
    }

    /* renamed from: b, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanAvatarBannerParams)) {
            return false;
        }
        ZPlanAvatarBannerParams zPlanAvatarBannerParams = (ZPlanAvatarBannerParams) other;
        if (Intrinsics.areEqual(this.uin, zPlanAvatarBannerParams.uin) && this.strategyId == zPlanAvatarBannerParams.strategyId && this.businessId == zPlanAvatarBannerParams.businessId && this.scene == zPlanAvatarBannerParams.scene) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.uin.hashCode() * 31) + this.strategyId.hashCode()) * 31) + this.businessId) * 31) + this.scene;
    }

    @NotNull
    public String toString() {
        return "ZPlanAvatarBannerParams(uin=" + this.uin + ", strategyId=" + this.strategyId + ", businessId=" + this.businessId + ", scene=" + this.scene + ')';
    }
}
