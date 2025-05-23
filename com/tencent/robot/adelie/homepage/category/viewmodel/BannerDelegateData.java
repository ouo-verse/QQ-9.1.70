package com.tencent.robot.adelie.homepage.category.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/b;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lt14/b;", "b", "Lt14/b;", "()Lt14/b;", "bannerConfig", "Lt14/f;", "c", "Lt14/f;", "()Lt14/f;", "robotGuideInfo", "<init>", "(Lt14/b;Lt14/f;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.category.viewmodel.b, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class BannerDelegateData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final t14.b bannerConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final t14.f robotGuideInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDelegateData(@NotNull t14.b bannerConfig, @Nullable t14.f fVar) {
        super(RecommendCardType.BANNER);
        Intrinsics.checkNotNullParameter(bannerConfig, "bannerConfig");
        this.bannerConfig = bannerConfig;
        this.robotGuideInfo = fVar;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final t14.b getBannerConfig() {
        return this.bannerConfig;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final t14.f getRobotGuideInfo() {
        return this.robotGuideInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannerDelegateData)) {
            return false;
        }
        BannerDelegateData bannerDelegateData = (BannerDelegateData) other;
        if (Intrinsics.areEqual(this.bannerConfig, bannerDelegateData.bannerConfig) && Intrinsics.areEqual(this.robotGuideInfo, bannerDelegateData.robotGuideInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.bannerConfig.hashCode() * 31;
        t14.f fVar = this.robotGuideInfo;
        if (fVar == null) {
            hashCode = 0;
        } else {
            hashCode = fVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "BannerDelegateData(bannerConfig=" + this.bannerConfig + ", robotGuideInfo=" + this.robotGuideInfo + ")";
    }
}
