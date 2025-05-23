package com.tencent.mobileqq.nearbypro.land;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqp4/a;", "a", "Lqp4/a;", "()Lqp4/a;", "c", "(Lqp4/a;)V", "areaInfo", "Lcom/tencent/mobileqq/nearbypro/land/LandMode;", "b", "Lcom/tencent/mobileqq/nearbypro/land/LandMode;", "()Lcom/tencent/mobileqq/nearbypro/land/LandMode;", "d", "(Lcom/tencent/mobileqq/nearbypro/land/LandMode;)V", "mode", "<init>", "(Lqp4/a;Lcom/tencent/mobileqq/nearbypro/land/LandMode;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.land.h, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class AreaParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private qp4.a areaInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private LandMode mode;

    public AreaParam(@NotNull qp4.a areaInfo, @NotNull LandMode mode) {
        Intrinsics.checkNotNullParameter(areaInfo, "areaInfo");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.areaInfo = areaInfo;
        this.mode = mode;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final qp4.a getAreaInfo() {
        return this.areaInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final LandMode getMode() {
        return this.mode;
    }

    public final void c(@NotNull qp4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.areaInfo = aVar;
    }

    public final void d(@NotNull LandMode landMode) {
        Intrinsics.checkNotNullParameter(landMode, "<set-?>");
        this.mode = landMode;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AreaParam)) {
            return false;
        }
        AreaParam areaParam = (AreaParam) other;
        if (Intrinsics.areEqual(this.areaInfo, areaParam.areaInfo) && this.mode == areaParam.mode) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.areaInfo.hashCode() * 31) + this.mode.hashCode();
    }

    @NotNull
    public String toString() {
        return "AreaParam(areaInfo=" + this.areaInfo + ", mode=" + this.mode + ")";
    }
}
