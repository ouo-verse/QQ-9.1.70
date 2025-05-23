package com.tencent.libra;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.core.util.Supplier;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.cache.ActiveResources;
import com.tencent.libra.cache.BitmapPool;
import com.tencent.libra.cache.BitmapResource;
import com.tencent.libra.cache.EngineResource;
import com.tencent.libra.cache.GroupKeyCache;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.cache.Key;
import com.tencent.libra.cache.RFWDefaultLruCacheImpl;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.libra.util.LibraLogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraCacheManager implements EngineResource.ResourceListener {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraCacheManager");
    private final ActiveResources mActiveResources;
    private final byte[] mCacheLock = new byte[1];
    private final GroupKeyCache mGroupKeyCache;
    private ICache mMemoryCache;

    public LibraCacheManager(ICache iCache, boolean z16) {
        int i3;
        this.mMemoryCache = iCache;
        if (iCache == null) {
            this.mMemoryCache = new RFWDefaultLruCacheImpl();
        }
        int cacheSize = this.mMemoryCache.getCacheSize();
        if (cacheSize == 0) {
            i3 = 0;
        } else {
            i3 = cacheSize / 1048576;
        }
        RFWLog.d(TAG, RFWLog.USR, "[initCache] cache size: " + i3 + "M");
        ActiveResources activeResources = new ActiveResources(z16);
        this.mActiveResources = activeResources;
        activeResources.setListener(this);
        this.mGroupKeyCache = new GroupKeyCache();
    }

    private EngineResource<?> findExplicitResource(List<EngineResource<?>> list, int i3, int i16) {
        int i17;
        EngineResource<?> engineResource = null;
        int i18 = Integer.MAX_VALUE;
        for (EngineResource<?> engineResource2 : list) {
            Bitmap bitmap = (Bitmap) engineResource2.get();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float abs = Math.abs(((width * 1.0f) / height) - ((i3 * 1.0f) / i16));
            if (width <= i3 && height <= i16 && abs <= 0.1d && (i17 = i3 - width) < i18) {
                engineResource = engineResource2;
                i18 = i17;
            }
        }
        return engineResource;
    }

    private EngineResource<?> findHighestResource(List<EngineResource<?>> list, int i3, int i16) {
        EngineResource<?> engineResource = null;
        int i17 = Integer.MIN_VALUE;
        for (EngineResource<?> engineResource2 : list) {
            Bitmap bitmap = (Bitmap) engineResource2.get();
            int width = bitmap.getWidth() * bitmap.getHeight();
            if (width > i17) {
                engineResource = engineResource2;
                i17 = width;
            }
        }
        return engineResource;
    }

    private <T> T handleRunOnSyncOrNot(Supplier<T> supplier) {
        T t16;
        if (LibraConfigUtil.INSTANCE.enablePicLoaderCacheNotUseSync()) {
            return supplier.get();
        }
        synchronized (this.mCacheLock) {
            t16 = supplier.get();
        }
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EngineResource lambda$addToCache$2(Object obj, LibraRequestKey libraRequestKey, Option option, LibraGroupKey libraGroupKey) {
        EngineResource<?> engineResource;
        if (obj instanceof Bitmap) {
            engineResource = new EngineResource<>(BitmapResource.obtain((Bitmap) obj, getBitmapPool()), true, true, libraRequestKey, this);
        } else if (obj instanceof BitmapDrawable) {
            engineResource = new EngineResource<>(BitmapResource.obtain(((BitmapDrawable) obj).getBitmap(), getBitmapPool()), true, true, libraRequestKey, this);
        } else {
            if ((obj instanceof Drawable) && option.isEnablePicLoaderDrawableCache()) {
                Drawable drawable = (Drawable) obj;
                if (drawable.getConstantState() != null) {
                    engineResource = new EngineResource<>(com.tencent.libra.cache.f.b(drawable), true, false, libraRequestKey, this);
                }
            }
            engineResource = null;
        }
        if (engineResource == null) {
            return null;
        }
        com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
        aVar.x(engineResource.getExtraData(), option);
        this.mActiveResources.activate(libraRequestKey, engineResource);
        if (aVar.d(option)) {
            this.mMemoryCache.addToCache(libraRequestKey, engineResource, option);
            this.mGroupKeyCache.addCache(libraGroupKey, libraRequestKey);
        }
        return engineResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EngineResource lambda$getCache$0(LibraRequestKey libraRequestKey) {
        EngineResource<?> engineResource = this.mActiveResources.get(libraRequestKey);
        if (engineResource != null) {
            return engineResource;
        }
        try {
            EngineResource<?> cache = this.mMemoryCache.getCache(libraRequestKey);
            if (cache != null) {
                this.mActiveResources.activate(libraRequestKey, cache);
            }
            return cache;
        } catch (ArrayIndexOutOfBoundsException | IllegalStateException e16) {
            RFWLog.e(TAG, RFWLog.USR, "getCache , e = " + e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EngineResource lambda$getCacheFromGroupKey$1(Option option) {
        Set<GroupKeyCache.RequestKeyWeakReference> cache;
        EngineResource<?> cache2;
        LibraGroupKey groupKey = option.getGroupKey();
        if (groupKey == null || groupKey.getCacheStrategy() == LibraGroupKey.CacheStrategy.ONLY_SAVE || (cache = this.mGroupKeyCache.getCache(groupKey)) == null) {
            return null;
        }
        if (LibraConfigUtil.INSTANCE.enablePicLoaderCacheNotUseSync()) {
            cache = new CopyOnWriteArraySet(cache);
        }
        ArrayList arrayList = new ArrayList();
        for (GroupKeyCache.RequestKeyWeakReference requestKeyWeakReference : cache) {
            if (requestKeyWeakReference != null && requestKeyWeakReference.get() != null && (cache2 = getCache(requestKeyWeakReference.get())) != null && (cache2.get() instanceof Bitmap) && !((Bitmap) cache2.get()).isRecycled()) {
                arrayList.add(cache2);
            }
        }
        if (groupKey.getCacheStrategy() == LibraGroupKey.CacheStrategy.HIGHEST) {
            return findHighestResource(arrayList, option.getRequestWidth(), option.getRequestHeight());
        }
        if (groupKey.getCacheStrategy() == LibraGroupKey.CacheStrategy.EXPLICIT) {
            return findExplicitResource(arrayList, option.getRequestWidth(), option.getRequestHeight());
        }
        RFWLog.fatal(TAG, RFWLog.USR, new IllegalArgumentException("[getCacheFromGroupKey] cacheStrategy invalid cacheStrategy=" + groupKey.getCacheStrategy() + " ,option=" + option));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$releaseCache$4() {
        this.mActiveResources.clearAll();
        this.mMemoryCache.clearAll();
        this.mGroupKeyCache.clearAll();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$removeLruCache$3(LibraRequestKey libraRequestKey, LibraGroupKey libraGroupKey) {
        try {
            this.mMemoryCache.removeCache(libraRequestKey);
            this.mGroupKeyCache.removeCache(libraGroupKey, libraRequestKey);
            return null;
        } catch (ArrayIndexOutOfBoundsException | IllegalStateException e16) {
            RFWLog.e(TAG, RFWLog.USR, "removeCache , e = " + e16.getMessage());
            return null;
        }
    }

    public void addLruCache(LibraRequestKey libraRequestKey, EngineResource engineResource) {
        try {
            this.mMemoryCache.addToCache(libraRequestKey, engineResource, null);
        } catch (ArrayIndexOutOfBoundsException | IllegalStateException e16) {
            RFWLog.e(TAG, RFWLog.USR, "addToCache , e = " + e16.getMessage());
        }
    }

    public EngineResource<?> addToCache(final LibraRequestKey libraRequestKey, final LibraGroupKey libraGroupKey, final Object obj, final Option option) {
        return (EngineResource) handleRunOnSyncOrNot(new Supplier() { // from class: com.tencent.libra.e
            @Override // androidx.core.util.Supplier
            public final Object get() {
                EngineResource lambda$addToCache$2;
                lambda$addToCache$2 = LibraCacheManager.this.lambda$addToCache$2(obj, libraRequestKey, option, libraGroupKey);
                return lambda$addToCache$2;
            }
        });
    }

    @Nullable
    public BitmapPool getBitmapPool() {
        ICache iCache = this.mMemoryCache;
        if (iCache != null) {
            return iCache.getBitmapPool();
        }
        return null;
    }

    public EngineResource<?> getCache(final LibraRequestKey libraRequestKey) {
        return (EngineResource) handleRunOnSyncOrNot(new Supplier() { // from class: com.tencent.libra.c
            @Override // androidx.core.util.Supplier
            public final Object get() {
                EngineResource lambda$getCache$0;
                lambda$getCache$0 = LibraCacheManager.this.lambda$getCache$0(libraRequestKey);
                return lambda$getCache$0;
            }
        });
    }

    public EngineResource<?> getCacheFromGroupKey(final Option option) {
        return (EngineResource) handleRunOnSyncOrNot(new Supplier() { // from class: com.tencent.libra.f
            @Override // androidx.core.util.Supplier
            public final Object get() {
                EngineResource lambda$getCacheFromGroupKey$1;
                lambda$getCacheFromGroupKey$1 = LibraCacheManager.this.lambda$getCacheFromGroupKey$1(option);
                return lambda$getCacheFromGroupKey$1;
            }
        });
    }

    @Override // com.tencent.libra.cache.EngineResource.ResourceListener
    public void onResourceReleased(Key key, EngineResource<?> engineResource) {
        this.mActiveResources.deactivate(key);
    }

    public void releaseCache() {
        handleRunOnSyncOrNot(new Supplier() { // from class: com.tencent.libra.g
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Object lambda$releaseCache$4;
                lambda$releaseCache$4 = LibraCacheManager.this.lambda$releaseCache$4();
                return lambda$releaseCache$4;
            }
        });
    }

    public void removeLruCache(final LibraRequestKey libraRequestKey, final LibraGroupKey libraGroupKey) {
        handleRunOnSyncOrNot(new Supplier() { // from class: com.tencent.libra.d
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Object lambda$removeLruCache$3;
                lambda$removeLruCache$3 = LibraCacheManager.this.lambda$removeLruCache$3(libraRequestKey, libraGroupKey);
                return lambda$removeLruCache$3;
            }
        });
    }
}
