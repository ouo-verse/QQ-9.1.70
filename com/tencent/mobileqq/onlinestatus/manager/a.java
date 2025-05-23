package com.tencent.mobileqq.onlinestatus.manager;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusShareInfo$ShareInfoItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/manager/a;", "", "", "key", "Ltencent/im/onlinestatus/OnlineStatusShareInfo$ShareInfoItem;", "a", "info", "", "c", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mCache", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, OnlineStatusShareInfo$ShareInfoItem> mCache = new ConcurrentHashMap<>();

    @Nullable
    public final OnlineStatusShareInfo$ShareInfoItem a(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mCache.get(key);
    }

    public final boolean b(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mCache.containsKey(key);
    }

    public final void c(@NotNull String key, @Nullable OnlineStatusShareInfo$ShareInfoItem info) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.mCache.put(key, info);
    }
}
