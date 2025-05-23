package com.tencent.mobileqq.nearbypro.part.guide;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/guide/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "mGuideTitle", "b", "mGuideDesc", "mGuideImageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.part.guide.a, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class GuideConfigItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String mGuideTitle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String mGuideDesc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String mGuideImageUrl;

    public GuideConfigItem(@NotNull String mGuideTitle, @NotNull String mGuideDesc, @NotNull String mGuideImageUrl) {
        Intrinsics.checkNotNullParameter(mGuideTitle, "mGuideTitle");
        Intrinsics.checkNotNullParameter(mGuideDesc, "mGuideDesc");
        Intrinsics.checkNotNullParameter(mGuideImageUrl, "mGuideImageUrl");
        this.mGuideTitle = mGuideTitle;
        this.mGuideDesc = mGuideDesc;
        this.mGuideImageUrl = mGuideImageUrl;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMGuideDesc() {
        return this.mGuideDesc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMGuideImageUrl() {
        return this.mGuideImageUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMGuideTitle() {
        return this.mGuideTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuideConfigItem)) {
            return false;
        }
        GuideConfigItem guideConfigItem = (GuideConfigItem) other;
        if (Intrinsics.areEqual(this.mGuideTitle, guideConfigItem.mGuideTitle) && Intrinsics.areEqual(this.mGuideDesc, guideConfigItem.mGuideDesc) && Intrinsics.areEqual(this.mGuideImageUrl, guideConfigItem.mGuideImageUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.mGuideTitle.hashCode() * 31) + this.mGuideDesc.hashCode()) * 31) + this.mGuideImageUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuideConfigItem(mGuideTitle=" + this.mGuideTitle + ", mGuideDesc=" + this.mGuideDesc + ", mGuideImageUrl=" + this.mGuideImageUrl + ")";
    }
}
