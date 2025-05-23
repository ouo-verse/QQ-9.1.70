package com.tencent.mobileqq.zplan.avatar.edit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\t\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/edit/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "outOfFrameAvatarPath", "b", "getNormalAvatarPath", "d", "(Ljava/lang/String;)V", "normalAvatarPath", "", "D", "()D", "maskRate", "I", "()I", "backgroundId", "e", "getBackgroundUrl", "backgroundUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;DILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.avatar.edit.j, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanAvatarUploadParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String outOfFrameAvatarPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String normalAvatarPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final double maskRate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int backgroundId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String backgroundUrl;

    public ZPlanAvatarUploadParam(@NotNull String outOfFrameAvatarPath, @NotNull String normalAvatarPath, double d16, int i3, @NotNull String backgroundUrl) {
        Intrinsics.checkNotNullParameter(outOfFrameAvatarPath, "outOfFrameAvatarPath");
        Intrinsics.checkNotNullParameter(normalAvatarPath, "normalAvatarPath");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        this.outOfFrameAvatarPath = outOfFrameAvatarPath;
        this.normalAvatarPath = normalAvatarPath;
        this.maskRate = d16;
        this.backgroundId = i3;
        this.backgroundUrl = backgroundUrl;
    }

    /* renamed from: a, reason: from getter */
    public final int getBackgroundId() {
        return this.backgroundId;
    }

    /* renamed from: b, reason: from getter */
    public final double getMaskRate() {
        return this.maskRate;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getOutOfFrameAvatarPath() {
        return this.outOfFrameAvatarPath;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.normalAvatarPath = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanAvatarUploadParam)) {
            return false;
        }
        ZPlanAvatarUploadParam zPlanAvatarUploadParam = (ZPlanAvatarUploadParam) other;
        if (Intrinsics.areEqual(this.outOfFrameAvatarPath, zPlanAvatarUploadParam.outOfFrameAvatarPath) && Intrinsics.areEqual(this.normalAvatarPath, zPlanAvatarUploadParam.normalAvatarPath) && Double.compare(this.maskRate, zPlanAvatarUploadParam.maskRate) == 0 && this.backgroundId == zPlanAvatarUploadParam.backgroundId && Intrinsics.areEqual(this.backgroundUrl, zPlanAvatarUploadParam.backgroundUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.outOfFrameAvatarPath.hashCode() * 31) + this.normalAvatarPath.hashCode()) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.maskRate)) * 31) + this.backgroundId) * 31) + this.backgroundUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZPlanAvatarUploadParam(outOfFrameAvatarPath=" + this.outOfFrameAvatarPath + ", normalAvatarPath=" + this.normalAvatarPath + ", maskRate=" + this.maskRate + ", backgroundId=" + this.backgroundId + ", backgroundUrl=" + this.backgroundUrl + ')';
    }
}
