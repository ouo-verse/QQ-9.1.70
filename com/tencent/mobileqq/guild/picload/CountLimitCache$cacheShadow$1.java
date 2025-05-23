package com.tencent.mobileqq.guild.picload;

import com.tencent.libra.cache.EngineResource;
import com.tencent.libra.decode.LibraRequestKey;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u000022\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00030\u0001j\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003`\u0005J(\u0010\u0006\u001a\u00020\u00072\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0018\u00010\tH\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/picload/CountLimitCache$cacheShadow$1", "Ljava/util/LinkedHashMap;", "Lcom/tencent/libra/decode/LibraRequestKey;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/libra/cache/EngineResource;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "qqguild-picload-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class CountLimitCache$cacheShadow$1 extends LinkedHashMap<LibraRequestKey, WeakReference<EngineResource<?>>> {
    final /* synthetic */ CountLimitCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CountLimitCache$cacheShadow$1(CountLimitCache countLimitCache) {
        this.this$0 = countLimitCache;
    }

    public /* bridge */ boolean containsKey(LibraRequestKey libraRequestKey) {
        return super.containsKey((Object) libraRequestKey);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof WeakReference) {
            return containsValue((WeakReference<EngineResource<?>>) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<LibraRequestKey, WeakReference<EngineResource<?>>>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof LibraRequestKey) {
            return get((LibraRequestKey) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<LibraRequestKey, WeakReference<EngineResource<?>>>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<LibraRequestKey> getKeys() {
        return super.keySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof LibraRequestKey) ? obj2 : getOrDefault((LibraRequestKey) obj, (WeakReference<EngineResource<?>>) obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<WeakReference<EngineResource<?>>> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<LibraRequestKey> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof LibraRequestKey) {
            return remove((LibraRequestKey) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(@Nullable Map.Entry<LibraRequestKey, WeakReference<EngineResource<?>>> eldest) {
        if (eldest == null) {
            return true;
        }
        if (size() <= this.this$0.getMax()) {
            return false;
        }
        Iterator<Map.Entry<LibraRequestKey, WeakReference<EngineResource<?>>>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<LibraRequestKey, WeakReference<EngineResource<?>>> next = it.next();
            if (next.getValue().get() == null) {
                it.remove();
                this.this$0.getCache().removeCache(next.getKey());
            }
        }
        if (size() <= this.this$0.getMax()) {
            return false;
        }
        this.this$0.getCache().removeCache(eldest.getKey());
        return true;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<WeakReference<EngineResource<?>>> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof LibraRequestKey) {
            return containsKey((LibraRequestKey) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(WeakReference<EngineResource<?>> weakReference) {
        return super.containsValue((Object) weakReference);
    }

    public /* bridge */ WeakReference<EngineResource<?>> get(LibraRequestKey libraRequestKey) {
        return (WeakReference) super.get((Object) libraRequestKey);
    }

    public /* bridge */ WeakReference<EngineResource<?>> getOrDefault(LibraRequestKey libraRequestKey, WeakReference<EngineResource<?>> weakReference) {
        return (WeakReference) super.getOrDefault((Object) libraRequestKey, (LibraRequestKey) weakReference);
    }

    public /* bridge */ WeakReference<EngineResource<?>> remove(LibraRequestKey libraRequestKey) {
        return (WeakReference) super.remove((Object) libraRequestKey);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ WeakReference<EngineResource<?>> get(Object obj) {
        if (obj instanceof LibraRequestKey) {
            return get((LibraRequestKey) obj);
        }
        return null;
    }

    public final /* bridge */ WeakReference getOrDefault(Object obj, WeakReference weakReference) {
        return !(obj instanceof LibraRequestKey) ? weakReference : getOrDefault((LibraRequestKey) obj, (WeakReference<EngineResource<?>>) weakReference);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ WeakReference<EngineResource<?>> remove(Object obj) {
        if (obj instanceof LibraRequestKey) {
            return remove((LibraRequestKey) obj);
        }
        return null;
    }

    public /* bridge */ boolean remove(LibraRequestKey libraRequestKey, WeakReference<EngineResource<?>> weakReference) {
        return super.remove((Object) libraRequestKey, (Object) weakReference);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof LibraRequestKey) && (obj2 instanceof WeakReference)) {
            return remove((LibraRequestKey) obj, (WeakReference<EngineResource<?>>) obj2);
        }
        return false;
    }
}
