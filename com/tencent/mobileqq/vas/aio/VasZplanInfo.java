package com.tencent.mobileqq.vas.aio;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "backgroundIconUrl", "I", "c", "()I", "defaultInterval", "aioInterval", "<init>", "(Ljava/lang/String;II)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.aio.k, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasZplanInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String backgroundIconUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int defaultInterval;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int aioInterval;

    public VasZplanInfo() {
        this(null, 0, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getAioInterval() {
        return this.aioInterval;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBackgroundIconUrl() {
        return this.backgroundIconUrl;
    }

    /* renamed from: c, reason: from getter */
    public final int getDefaultInterval() {
        return this.defaultInterval;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasZplanInfo)) {
            return false;
        }
        VasZplanInfo vasZplanInfo = (VasZplanInfo) other;
        if (Intrinsics.areEqual(this.backgroundIconUrl, vasZplanInfo.backgroundIconUrl) && this.defaultInterval == vasZplanInfo.defaultInterval && this.aioInterval == vasZplanInfo.aioInterval) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.backgroundIconUrl.hashCode() * 31) + this.defaultInterval) * 31) + this.aioInterval;
    }

    @NotNull
    public String toString() {
        return "VasZplanInfo(backgroundIconUrl=" + this.backgroundIconUrl + ", defaultInterval=" + this.defaultInterval + ", aioInterval=" + this.aioInterval + ')';
    }

    public VasZplanInfo(@NotNull String backgroundIconUrl, int i3, int i16) {
        Intrinsics.checkNotNullParameter(backgroundIconUrl, "backgroundIconUrl");
        this.backgroundIconUrl = backgroundIconUrl;
        this.defaultInterval = i3;
        this.aioInterval = i16;
    }

    public /* synthetic */ VasZplanInfo(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? 30 : i3, (i17 & 4) != 0 ? 600 : i16);
    }
}
