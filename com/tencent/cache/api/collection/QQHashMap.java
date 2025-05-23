package com.tencent.cache.api.collection;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.cache.api.Business;
import com.tencent.cache.core.collection.base.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQHashMap<K, V> extends HashMap<K, V> implements com.tencent.cache.core.collection.base.b {
    static IPatchRedirector $redirector_;
    private final com.tencent.cache.core.collection.collector.c<K, V> collector;

    public QQHashMap(Business business, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) business, (Object) str);
        } else {
            this.collector = new com.tencent.cache.core.collection.collector.c<>(business.name(), str, -1);
            register(business, str);
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.tencent.cache.api.b
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.clear();
            this.collector.g(true);
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
        V v3 = (V) super.get(obj);
        this.collector.j(v3);
        return v3;
    }

    @Override // com.tencent.cache.core.collection.base.b
    @JvmDefault
    @NotNull
    public d getCacheInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (d) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return getCollector().c();
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    @Nullable
    public /* bridge */ /* synthetic */ com.tencent.cache.api.c getCacheListener() {
        return com.tencent.cache.core.collection.base.a.a(this);
    }

    @Override // com.tencent.cache.core.collection.base.b
    @NonNull
    public com.tencent.cache.core.collection.base.c getCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.cache.core.collection.base.c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.collector;
    }

    @Override // com.tencent.cache.core.collection.base.b
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return size();
    }

    @Override // com.tencent.cache.core.collection.base.b
    public String getItemType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (isEmpty()) {
            return GlobalUtil.DEF_STRING;
        }
        V value = entrySet().iterator().next().getValue();
        if (value == null) {
            return "null";
        }
        return value.getClass().getName();
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    public long getMemorySize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return getCacheInfo().f98708g;
    }

    @Override // com.tencent.cache.core.collection.base.b
    @JvmDefault
    @NotNull
    public /* bridge */ /* synthetic */ com.tencent.cache.core.manager.report.b getMonitorInfo() {
        return com.tencent.cache.core.collection.base.a.b(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3, (Object) v3);
        }
        V v16 = (V) super.put(k3, v3);
        this.collector.i(k3, v3, v16);
        return v16;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(@NonNull Map<? extends K, ? extends V> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) map);
            return;
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            this.collector.i(entry.getKey(), entry.getValue(), get(entry.getKey()));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.Map
    @androidx.annotation.Nullable
    public V putIfAbsent(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (V) iPatchRedirector.redirect((short) 5, (Object) this, (Object) k3, (Object) v3);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            V v16 = (V) super.putIfAbsent(k3, v3);
            if (v16 != null) {
                this.collector.i(k3, v3, v16);
            }
            return v16;
        }
        return null;
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    public /* bridge */ /* synthetic */ void register(@NotNull Business business, @NotNull String str) {
        com.tencent.cache.api.a.a(this, business, str);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V) iPatchRedirector.redirect((short) 7, (Object) this, obj);
        }
        V v3 = (V) super.remove(obj);
        this.collector.e(v3);
        return v3;
    }

    @Override // java.util.HashMap, java.util.Map
    @androidx.annotation.Nullable
    public V replace(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (V) iPatchRedirector.redirect((short) 9, (Object) this, (Object) k3, (Object) v3);
        }
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        V v16 = (V) super.replace(k3, v3);
        this.collector.i(k3, v3, v16);
        return v16;
    }

    @JvmDefault
    public /* bridge */ /* synthetic */ void setCacheListener(@NotNull com.tencent.cache.api.c cVar) {
        com.tencent.cache.core.collection.base.a.c(this, cVar);
    }

    @Override // com.tencent.cache.api.b
    public long trimMemory(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, j3)).longValue();
        }
        return this.collector.b(this, j3, true);
    }

    public QQHashMap(Business business, String str, int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, business, str, Integer.valueOf(i3));
        } else {
            this.collector = new com.tencent.cache.core.collection.collector.c<>(business.name(), str, i3);
            register(business, str);
        }
    }

    @Override // java.util.HashMap, java.util.Map
    public boolean remove(@androidx.annotation.Nullable Object obj, @androidx.annotation.Nullable Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, obj, obj2)).booleanValue();
        }
        boolean remove = super.remove(obj, obj2);
        if (remove) {
            this.collector.e(obj2);
        }
        return remove;
    }

    @Override // java.util.HashMap, java.util.Map
    public boolean replace(K k3, @androidx.annotation.Nullable V v3, V v16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, k3, v3, v16)).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        boolean replace = super.replace(k3, v3, v16);
        if (replace) {
            this.collector.i(k3, v16, v3);
        }
        return replace;
    }
}
