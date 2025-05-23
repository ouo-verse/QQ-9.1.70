package com.tencent.mobileqq.search.tux;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\u0005\u001a\u00020\u0000J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/tux/i;", "", "other", "", "equals", "a", "", "toString", "", "hashCode", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "keyword", "b", "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String keyword;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String traceId;

    public i(@Nullable String str, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.keyword = str;
        this.traceId = traceId;
    }

    @NotNull
    public final i a() {
        return new i(this.keyword, this.traceId);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof i) && Intrinsics.areEqual(this.traceId, ((i) other).traceId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        String str = this.keyword;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return (hashCode * 31) + this.traceId.hashCode();
    }

    @NotNull
    public String toString() {
        return this.traceId;
    }
}
