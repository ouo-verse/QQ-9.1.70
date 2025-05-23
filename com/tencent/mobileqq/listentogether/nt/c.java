package com.tencent.mobileqq.listentogether.nt;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/listentogether/nt/c;", "", "", "id", "Lcom/tencent/mobileqq/listentogether/nt/ListenTogetherHelper;", "helper", "", "a", "b", "d", "", "isHide", "f", "c", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Lmqq/util/WeakReference;", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "panelIsHideCache", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f241083a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, WeakReference<ListenTogetherHelper>> cache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Boolean> panelIsHideCache = new ConcurrentHashMap<>();

    c() {
    }

    public final void a(String id5, ListenTogetherHelper helper) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(helper, "helper");
        cache.put(id5, new WeakReference<>(helper));
    }

    public final void b(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        ConcurrentHashMap<String, WeakReference<ListenTogetherHelper>> concurrentHashMap = cache;
        if (concurrentHashMap.containsKey(id5)) {
            concurrentHashMap.remove(id5);
        }
    }

    public final void c(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        ConcurrentHashMap<String, Boolean> concurrentHashMap = panelIsHideCache;
        if (concurrentHashMap.containsKey(id5)) {
            concurrentHashMap.remove(id5);
        }
    }

    public final ListenTogetherHelper d(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        WeakReference<ListenTogetherHelper> weakReference = cache.get(id5);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean e(String id5) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(id5, "id");
        ConcurrentHashMap<String, Boolean> concurrentHashMap = panelIsHideCache;
        if (concurrentHashMap.containsKey(id5) && (bool = concurrentHashMap.get(id5)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void f(String id5, boolean isHide) {
        Intrinsics.checkNotNullParameter(id5, "id");
        panelIsHideCache.put(id5, Boolean.valueOf(isHide));
    }
}
