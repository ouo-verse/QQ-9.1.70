package com.tencent.kuikly.core.render.android.expand.module;

import android.util.LruCache;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\tR0\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006j\u0002`\u00070\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/i;", "", "", "name", "", "maxSize", "Landroid/util/LruCache;", "Lcom/tencent/kuikly/core/render/android/expand/module/KRMemoryCache;", "a", "", "d", "c", "", "Ljava/util/Map;", "lruCacheMap", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final i f118055b = new i();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, LruCache<String, Object>> lruCacheMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/kuikly/core/render/android/expand/module/KRLRUCacheContainer$getCache$1$1", "Landroid/util/LruCache;", "", "", "key", "value", "", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a extends LruCache<String, Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f118056a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f118057b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i3, String str, int i16) {
            super(i3);
            this.f118056a = str;
            this.f118057b = i16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(@Nullable String key, @Nullable Object value) {
            if (value instanceof String) {
                return ((String) value).length();
            }
            if (value instanceof byte[]) {
                return ((byte[]) value).length;
            }
            return super.sizeOf(key, value);
        }
    }

    i() {
    }

    public static /* synthetic */ LruCache b(i iVar, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 10485760;
        }
        return iVar.a(str, i3);
    }

    @NotNull
    public final LruCache<String, Object> a(@NotNull String name, int maxSize) {
        LruCache<String, Object> lruCache;
        Intrinsics.checkNotNullParameter(name, "name");
        Map<String, LruCache<String, Object>> map = lruCacheMap;
        synchronized (map) {
            lruCache = map.get(name);
            if (lruCache == null) {
                lruCache = new a(maxSize, name, maxSize);
                map.put(name, lruCache);
            }
        }
        return lruCache;
    }

    public final void c() {
        Map<String, LruCache<String, Object>> map = lruCacheMap;
        synchronized (map) {
            map.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void d(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Map<String, LruCache<String, Object>> map = lruCacheMap;
        synchronized (map) {
            map.remove(name);
        }
    }
}
