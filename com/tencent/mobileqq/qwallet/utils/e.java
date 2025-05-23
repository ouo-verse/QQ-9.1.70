package com.tencent.mobileqq.qwallet.utils;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/e;", "", "anything", "", "a", "", "tag", "b", "Landroid/util/LruCache;", "", "Landroid/util/LruCache;", "tagCache", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f279259a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, Long> tagCache = new LruCache<>(5);

    e() {
    }

    public final boolean a(@NotNull Object anything) {
        Intrinsics.checkNotNullParameter(anything, "anything");
        return b(String.valueOf(anything.hashCode()));
    }

    public final boolean b(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        long currentTimeMillis = System.currentTimeMillis();
        LruCache<String, Long> lruCache = tagCache;
        Long l3 = lruCache.get(tag);
        if (l3 == null) {
            lruCache.put(tag, Long.valueOf(currentTimeMillis));
            return false;
        }
        if (Math.abs(currentTimeMillis - l3.longValue()) >= 500) {
            lruCache.put(tag, Long.valueOf(currentTimeMillis));
            return false;
        }
        return true;
    }
}
