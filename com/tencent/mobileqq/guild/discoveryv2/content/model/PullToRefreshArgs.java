package com.tencent.mobileqq.guild.discoveryv2.content.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/PullToRefreshType;", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/PullToRefreshType;", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/model/PullToRefreshType;", "pullToRefreshType", "b", "Ljava/lang/String;", "getCallSource", "()Ljava/lang/String;", "callSource", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/model/PullToRefreshType;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.i, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class PullToRefreshArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PullToRefreshType pullToRefreshType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String callSource;

    public PullToRefreshArgs(@NotNull PullToRefreshType pullToRefreshType, @NotNull String callSource) {
        Intrinsics.checkNotNullParameter(pullToRefreshType, "pullToRefreshType");
        Intrinsics.checkNotNullParameter(callSource, "callSource");
        this.pullToRefreshType = pullToRefreshType;
        this.callSource = callSource;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final PullToRefreshType getPullToRefreshType() {
        return this.pullToRefreshType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PullToRefreshArgs)) {
            return false;
        }
        PullToRefreshArgs pullToRefreshArgs = (PullToRefreshArgs) other;
        if (this.pullToRefreshType == pullToRefreshArgs.pullToRefreshType && Intrinsics.areEqual(this.callSource, pullToRefreshArgs.callSource)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.pullToRefreshType.hashCode() * 31) + this.callSource.hashCode();
    }

    @NotNull
    public String toString() {
        return "PullToRefreshArgs(pullToRefreshType=" + this.pullToRefreshType + ", callSource=" + this.callSource + ")";
    }
}
