package com.tencent.mobileqq.vas.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/r;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "", "b", "J", "()J", WadlProxyConsts.CREATE_TIME, "<init>", "(Ljava/lang/String;J)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.api.impl.r, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class RequestWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long createTime;

    public RequestWrapper(@NotNull String content, long j3) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.createTime = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestWrapper)) {
            return false;
        }
        RequestWrapper requestWrapper = (RequestWrapper) other;
        if (Intrinsics.areEqual(this.content, requestWrapper.content) && this.createTime == requestWrapper.createTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + androidx.fragment.app.a.a(this.createTime);
    }

    @NotNull
    public String toString() {
        return "RequestWrapper(content=" + this.content + ", createTime=" + this.createTime + ")";
    }

    public /* synthetic */ RequestWrapper(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? System.currentTimeMillis() : j3);
    }
}
