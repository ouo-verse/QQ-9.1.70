package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "setFrom", "(I)V", "from", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarReporter;", "b", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarReporter;", "()Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarReporter;", "reporter", "", "c", "Ljava/util/Map;", "getReqCacheMap", "()Ljava/util/Map;", "reqCacheMap", "<init>", "(ILcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarReporter;Ljava/util/Map;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.onlinestatus.view.withAvatar.l, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class OnlineStatusLikeWithAvatarExtParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int from;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final OnlineStatusLikeWithAvatarReporter reporter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, Boolean> reqCacheMap;

    public OnlineStatusLikeWithAvatarExtParam(int i3, @Nullable OnlineStatusLikeWithAvatarReporter onlineStatusLikeWithAvatarReporter, @NotNull Map<String, Boolean> reqCacheMap) {
        Intrinsics.checkNotNullParameter(reqCacheMap, "reqCacheMap");
        this.from = i3;
        this.reporter = onlineStatusLikeWithAvatarReporter;
        this.reqCacheMap = reqCacheMap;
    }

    /* renamed from: a, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final OnlineStatusLikeWithAvatarReporter getReporter() {
        return this.reporter;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineStatusLikeWithAvatarExtParam)) {
            return false;
        }
        OnlineStatusLikeWithAvatarExtParam onlineStatusLikeWithAvatarExtParam = (OnlineStatusLikeWithAvatarExtParam) other;
        if (this.from == onlineStatusLikeWithAvatarExtParam.from && Intrinsics.areEqual(this.reporter, onlineStatusLikeWithAvatarExtParam.reporter) && Intrinsics.areEqual(this.reqCacheMap, onlineStatusLikeWithAvatarExtParam.reqCacheMap)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.from * 31;
        OnlineStatusLikeWithAvatarReporter onlineStatusLikeWithAvatarReporter = this.reporter;
        if (onlineStatusLikeWithAvatarReporter == null) {
            hashCode = 0;
        } else {
            hashCode = onlineStatusLikeWithAvatarReporter.hashCode();
        }
        return ((i3 + hashCode) * 31) + this.reqCacheMap.hashCode();
    }

    @NotNull
    public String toString() {
        return "OnlineStatusLikeWithAvatarExtParam(from=" + this.from + ", reporter=" + this.reporter + ", reqCacheMap=" + this.reqCacheMap + ")";
    }

    public /* synthetic */ OnlineStatusLikeWithAvatarExtParam(int i3, OnlineStatusLikeWithAvatarReporter onlineStatusLikeWithAvatarReporter, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : onlineStatusLikeWithAvatarReporter, (i16 & 4) != 0 ? new LinkedHashMap() : map);
    }
}
