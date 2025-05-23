package com.tencent.mobileqq.guild.picload;

import android.os.Handler;
import com.tencent.libra.cache.BitmapPool;
import com.tencent.libra.cache.EngineResource;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.request.Option;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0019\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\u0013\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/picload/CountLimitCache;", "Lcom/tencent/libra/cache/ICache;", "", "getCacheSize", "Lcom/tencent/libra/decode/LibraRequestKey;", "key", "Lcom/tencent/libra/cache/EngineResource;", "resource", "Lcom/tencent/libra/request/Option;", "option", "", "addToCache", "clearAll", "removeCache", "getCache", "a", "Lcom/tencent/libra/cache/ICache;", "g", "()Lcom/tencent/libra/cache/ICache;", "cache", "b", "I", "i", "()I", "max", "com/tencent/mobileqq/guild/picload/CountLimitCache$cacheShadow$1", "c", "Lcom/tencent/mobileqq/guild/picload/CountLimitCache$cacheShadow$1;", "cacheShadow", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "d", "Landroid/os/Handler;", "serialThreadHandler", "<init>", "(Lcom/tencent/libra/cache/ICache;I)V", "qqguild-picload-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class CountLimitCache implements ICache {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICache cache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int max;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CountLimitCache$cacheShadow$1 cacheShadow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Handler serialThreadHandler;

    public CountLimitCache(@NotNull ICache cache, int i3) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.cache = cache;
        this.max = i3;
        this.cacheShadow = new CountLimitCache$cacheShadow$1(this);
        this.serialThreadHandler = RFWThreadManager.getInstance().getSerialThreadHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CountLimitCache this$0, LibraRequestKey libraRequestKey, EngineResource engineResource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cacheShadow.put(libraRequestKey, new WeakReference(engineResource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(CountLimitCache this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cacheShadow.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(CountLimitCache this$0, LibraRequestKey libraRequestKey) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cacheShadow.get((Object) libraRequestKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(CountLimitCache this$0, LibraRequestKey libraRequestKey) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TypeIntrinsics.asMutableMap(this$0.cacheShadow).remove(libraRequestKey);
    }

    @Override // com.tencent.libra.cache.ICache
    public void addToCache(@Nullable final LibraRequestKey key, @Nullable final EngineResource<?> resource, @Nullable Option option) {
        if (key == null) {
            return;
        }
        this.cache.addToCache(key, resource, option);
        this.serialThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.picload.d
            @Override // java.lang.Runnable
            public final void run() {
                CountLimitCache.e(CountLimitCache.this, key, resource);
            }
        });
    }

    @Override // com.tencent.libra.cache.ICache
    public void clearAll() {
        this.cache.clearAll();
        this.serialThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.picload.c
            @Override // java.lang.Runnable
            public final void run() {
                CountLimitCache.f(CountLimitCache.this);
            }
        });
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final ICache getCache() {
        return this.cache;
    }

    @Override // com.tencent.libra.cache.ICache
    public /* synthetic */ BitmapPool getBitmapPool() {
        return com.tencent.libra.cache.d.a(this);
    }

    @Override // com.tencent.libra.cache.ICache
    @Nullable
    public EngineResource<?> getCache(@Nullable final LibraRequestKey key) {
        if (key == null) {
            return null;
        }
        EngineResource<?> cache = this.cache.getCache(key);
        this.serialThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.picload.a
            @Override // java.lang.Runnable
            public final void run() {
                CountLimitCache.h(CountLimitCache.this, key);
            }
        });
        return cache;
    }

    @Override // com.tencent.libra.cache.ICache
    public int getCacheSize() {
        return this.cache.getCacheSize();
    }

    /* renamed from: i, reason: from getter */
    public final int getMax() {
        return this.max;
    }

    @Override // com.tencent.libra.cache.ICache
    public void removeCache(@Nullable final LibraRequestKey key) {
        this.cache.removeCache(key);
        this.serialThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.picload.b
            @Override // java.lang.Runnable
            public final void run() {
                CountLimitCache.j(CountLimitCache.this, key);
            }
        });
    }
}
