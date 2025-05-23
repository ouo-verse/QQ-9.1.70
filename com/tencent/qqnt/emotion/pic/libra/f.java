package com.tencent.qqnt.emotion.pic.libra;

import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.libra.cache.BitmapPool;
import com.tencent.libra.cache.EngineResource;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.request.Option;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R8\u0010\u0015\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u00120\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/f;", "Lcom/tencent/libra/cache/ICache;", "Lcom/tencent/libra/decode/LibraRequestKey;", "key", "Lcom/tencent/libra/cache/EngineResource;", "getCache", "engineResource", "Lcom/tencent/libra/request/Option;", "option", "", "addToCache", "", "getCacheSize", "removeCache", "clearAll", "", "", "kotlin.jvm.PlatformType", "", "a", "Ljava/util/Set;", "mAllInjectCacheKey", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f implements ICache {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Set<String> mAllInjectCacheKey = Collections.synchronizedSet(new HashSet());

    @Override // com.tencent.libra.cache.ICache
    public void addToCache(@Nullable LibraRequestKey key, @Nullable EngineResource<?> engineResource, @Nullable Option option) {
        if (key != null && engineResource != null) {
            String libraRequestKey = key.toString();
            Intrinsics.checkNotNullExpressionValue(libraRequestKey, "key.toString()");
            this.mAllInjectCacheKey.add(libraRequestKey);
            ImageCacheHelper.f98636a.i(libraRequestKey, new com.tencent.mobileqq.pic.picloader.a(engineResource), Business.AIO);
        }
    }

    @Override // com.tencent.libra.cache.ICache
    public void clearAll() {
        Iterator<String> it = this.mAllInjectCacheKey.iterator();
        while (it.hasNext()) {
            ImageCacheHelper.f98636a.m(it.next());
        }
        this.mAllInjectCacheKey.clear();
    }

    @Override // com.tencent.libra.cache.ICache
    public /* synthetic */ BitmapPool getBitmapPool() {
        return com.tencent.libra.cache.d.a(this);
    }

    @Override // com.tencent.libra.cache.ICache
    @Nullable
    public EngineResource<?> getCache(@Nullable LibraRequestKey key) {
        Object g16 = ImageCacheHelper.f98636a.g(String.valueOf(key));
        if (g16 instanceof com.tencent.mobileqq.pic.picloader.a) {
            return ((com.tencent.mobileqq.pic.picloader.a) g16).a();
        }
        return null;
    }

    @Override // com.tencent.libra.cache.ICache
    public int getCacheSize() {
        return com.tencent.cache.core.manager.api.c.f98725d.f().getFirst().intValue();
    }

    @Override // com.tencent.libra.cache.ICache
    public void removeCache(@Nullable LibraRequestKey key) {
        if (key == null) {
            return;
        }
        String libraRequestKey = key.toString();
        Intrinsics.checkNotNullExpressionValue(libraRequestKey, "key.toString()");
        this.mAllInjectCacheKey.remove(libraRequestKey);
        ImageCacheHelper.f98636a.m(libraRequestKey);
    }
}
