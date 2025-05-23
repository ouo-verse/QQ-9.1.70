package com.tencent.mobileqq.guild.live.danmu;

import android.text.Layout;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/live/danmu/LiveDanmakuRender$cache$1", "Ljava/util/LinkedHashMap;", "", "Landroid/text/Layout;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class LiveDanmakuRender$cache$1 extends LinkedHashMap<Long, Layout> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveDanmakuRender$cache$1() {
        super(5);
    }

    public /* bridge */ boolean containsKey(Long l3) {
        return super.containsKey((Object) l3);
    }

    public /* bridge */ boolean containsValue(Layout layout) {
        return super.containsValue((Object) layout);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<Long, Layout>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Layout get(Long l3) {
        return (Layout) super.get((Object) l3);
    }

    public /* bridge */ Set<Map.Entry<Long, Layout>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<Long> getKeys() {
        return super.keySet();
    }

    public /* bridge */ Layout getOrDefault(Long l3, Layout layout) {
        return (Layout) super.getOrDefault((Object) l3, (Long) layout);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Layout> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Long> keySet() {
        return getKeys();
    }

    public /* bridge */ Layout remove(Long l3) {
        return (Layout) super.remove((Object) l3);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(@Nullable Map.Entry<Long, Layout> eldest) {
        if (size() > 25) {
            return true;
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Layout> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof Long) {
            return containsKey((Long) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Layout) {
            return containsValue((Layout) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Layout get(Object obj) {
        if (obj instanceof Long) {
            return get((Long) obj);
        }
        return null;
    }

    public final /* bridge */ Layout getOrDefault(Object obj, Layout layout) {
        return !(obj instanceof Long) ? layout : getOrDefault((Long) obj, layout);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Layout remove(Object obj) {
        if (obj instanceof Long) {
            return remove((Long) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof Long) {
            return get((Long) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof Long) ? obj2 : getOrDefault((Long) obj, (Layout) obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof Long) {
            return remove((Long) obj);
        }
        return null;
    }

    public /* bridge */ boolean remove(Long l3, Layout layout) {
        return super.remove((Object) l3, (Object) layout);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof Long) && (obj2 instanceof Layout)) {
            return remove((Long) obj, (Layout) obj2);
        }
        return false;
    }
}
