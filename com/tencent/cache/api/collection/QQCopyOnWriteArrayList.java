package com.tencent.cache.api.collection;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.cache.api.Business;
import com.tencent.cache.core.collection.base.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQCopyOnWriteArrayList<V> extends CopyOnWriteArrayList<V> implements com.tencent.cache.core.collection.base.b {
    static IPatchRedirector $redirector_;
    private final com.tencent.cache.core.collection.collector.a<V> collector;

    public QQCopyOnWriteArrayList(Business business, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) business, (Object) str);
        } else {
            this.collector = new com.tencent.cache.core.collection.collector.a<>(business.name(), str);
            register(business, str);
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public void add(int i3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) v3);
        } else {
            this.collector.f(null, v3);
            super.add(i3, v3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public boolean addAll(int i3, @NonNull Collection<? extends V> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) collection)).booleanValue();
        }
        this.collector.i(collection);
        return super.addAll(i3, collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CopyOnWriteArrayList
    public int addAllAbsent(@NonNull Collection<? extends V> c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) c16)).intValue();
        }
        com.tencent.cache.core.collection.collector.a<V> aVar = this.collector;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(this, "list");
        for (Object obj : c16) {
            if (!contains(obj)) {
                aVar.f(null, obj);
            }
        }
        return super.addAllAbsent(c16);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList
    public boolean addIfAbsent(V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3)).booleanValue();
        }
        boolean addIfAbsent = super.addIfAbsent(v3);
        if (addIfAbsent) {
            this.collector.f(null, v3);
        }
        return addIfAbsent;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection, com.tencent.cache.api.b, java.util.AbstractMap, java.util.Map
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.collector.g(true);
            super.clear();
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public V get(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (V) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        V v3 = (V) super.get(i3);
        this.collector.m(v3);
        return v3;
    }

    @Override // com.tencent.cache.core.collection.base.b
    @JvmDefault
    @NotNull
    public d getCacheInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (d) iPatchRedirector.redirect((short) 21, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.cache.core.collection.base.c) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.collector;
    }

    @Override // com.tencent.cache.core.collection.base.b
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return size();
    }

    @Override // com.tencent.cache.core.collection.base.b
    public String getItemType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (isEmpty()) {
            return GlobalUtil.DEF_STRING;
        }
        V v3 = get(0);
        if (v3 == null) {
            return "null";
        }
        return v3.getClass().getName();
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    public long getMemorySize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this)).longValue();
        }
        return getCacheInfo().f98708g;
    }

    @Override // com.tencent.cache.core.collection.base.b
    @JvmDefault
    @NotNull
    public /* bridge */ /* synthetic */ com.tencent.cache.core.manager.report.b getMonitorInfo() {
        return com.tencent.cache.core.collection.base.a.b(this);
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    public /* bridge */ /* synthetic */ void register(@NotNull Business business, @NotNull String str) {
        com.tencent.cache.api.a.a(this, business, str);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public V remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (V) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        V v3 = (V) super.remove(i3);
        this.collector.e(v3);
        return v3;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) collection)).booleanValue();
        }
        this.collector.j(collection, this);
        return super.removeAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.Collection
    @RequiresApi(api = 24)
    public boolean removeIf(@NonNull Predicate<? super V> predicate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) predicate)).booleanValue();
        }
        if (this.collector.k(predicate, this)) {
            return super.removeIf(predicate);
        }
        return false;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) collection)).booleanValue();
        }
        this.collector.l(collection, this);
        return super.retainAll(collection);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public V set(int i3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) v3);
        }
        V v16 = (V) super.set(i3, v3);
        this.collector.f(v16, v3);
        return v16;
    }

    @JvmDefault
    public /* bridge */ /* synthetic */ void setCacheListener(@NotNull com.tencent.cache.api.c cVar) {
        com.tencent.cache.core.collection.base.a.c(this, cVar);
    }

    @Override // com.tencent.cache.api.b
    public long trimMemory(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this, j3)).longValue();
        }
        return this.collector.b(this, j3, true);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean add(V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3)).booleanValue();
        }
        this.collector.f(null, v3);
        return super.add(v3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends V> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) collection)).booleanValue();
        }
        this.collector.i(collection);
        return super.addAll(collection);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean remove(@androidx.annotation.Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, obj)).booleanValue();
        }
        boolean remove = super.remove(obj);
        if (obj != null && remove) {
            this.collector.e(obj);
        }
        return remove;
    }
}
