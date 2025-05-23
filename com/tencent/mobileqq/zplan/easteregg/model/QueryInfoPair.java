package com.tencent.mobileqq.zplan.easteregg.model;

import com.tencent.mobileqq.zplan.easteregg.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/model/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "a", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "getParam", "()Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "param", "Lcom/tencent/mobileqq/zplan/easteregg/t;", "b", "Lcom/tencent/mobileqq/zplan/easteregg/t;", "()Lcom/tencent/mobileqq/zplan/easteregg/t;", "listener", "<init>", "(Lcom/tencent/mobileqq/zplan/easteregg/model/d;Lcom/tencent/mobileqq/zplan/easteregg/t;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.easteregg.model.g, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class QueryInfoPair {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final d param;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final t listener;

    public QueryInfoPair(@NotNull d param, @Nullable t tVar) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.listener = tVar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final t getListener() {
        return this.listener;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryInfoPair)) {
            return false;
        }
        QueryInfoPair queryInfoPair = (QueryInfoPair) other;
        if (Intrinsics.areEqual(this.param, queryInfoPair.param) && Intrinsics.areEqual(this.listener, queryInfoPair.listener)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.param.hashCode() * 31;
        t tVar = this.listener;
        if (tVar == null) {
            hashCode = 0;
        } else {
            hashCode = tVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "QueryInfoPair(param=" + this.param + ", listener=" + this.listener + ')';
    }
}
