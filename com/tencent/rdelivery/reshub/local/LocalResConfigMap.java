package com.tencent.rdelivery.reshub.local;

import com.tencent.rdelivery.reshub.api.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/reshub/local/LocalResConfigMap;", "Ljava/util/HashMap;", "", "Ljz3/e;", "Lkotlin/collections/HashMap;", "Lcom/tencent/rdelivery/reshub/api/g;", "res", "", "hasRes", "tryDelRes", "resId", "delRes", "", "delAllRes", "TAG", "Ljava/lang/String;", "name", "getName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class LocalResConfigMap extends HashMap<String, jz3.e> {
    private final String TAG;

    @NotNull
    private final String name;

    public LocalResConfigMap(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.name = name;
        this.TAG = "LocalResConfigMap-" + name;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof jz3.e) {
            return containsValue((jz3.e) obj);
        }
        return false;
    }

    public final void delAllRes() {
        List<String> list;
        Set<String> keys = keySet();
        Intrinsics.checkExpressionValueIsNotNull(keys, "keys");
        list = CollectionsKt___CollectionsKt.toList(keys);
        for (String it : list) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            delRes(it);
        }
    }

    public final boolean delRes(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        jz3.e eVar = (jz3.e) get((Object) resId);
        if (eVar != null) {
            Intrinsics.checkExpressionValueIsNotNull(eVar, "get(resId) ?: return false");
            String str = eVar.H;
            Intrinsics.checkExpressionValueIsNotNull(str, "resConfig.originLocal");
            jz3.b.f(str);
            String str2 = eVar.G;
            Intrinsics.checkExpressionValueIsNotNull(str2, "resConfig.local");
            jz3.b.f(str2);
            remove((Object) resId);
            jz3.d.e(this.TAG, "Delete Local(" + this.name + ") Res: " + resId + " Version: " + eVar.f411261b);
            return true;
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, jz3.e>> entrySet() {
        return getEntries();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return obj != null ? obj instanceof String : true ? getOrDefault((String) obj, (jz3.e) obj2) : obj2;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    public final boolean hasRes(@NotNull g res) {
        Intrinsics.checkParameterIsNotNull(res, "res");
        jz3.e eVar = (jz3.e) get((Object) res.getResId());
        if (eVar == null || eVar.f411261b != res.getVersion()) {
            return false;
        }
        return true;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public final boolean tryDelRes(@NotNull g res) {
        Intrinsics.checkParameterIsNotNull(res, "res");
        if (hasRes(res)) {
            return delRes(res.getResId());
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<jz3.e> values() {
        return getValues();
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    public /* bridge */ boolean containsValue(jz3.e eVar) {
        return super.containsValue((Object) eVar);
    }

    public /* bridge */ jz3.e get(String str) {
        return (jz3.e) super.get((Object) str);
    }

    public /* bridge */ jz3.e getOrDefault(String str, jz3.e eVar) {
        return (jz3.e) super.getOrDefault((Object) str, (String) eVar);
    }

    public /* bridge */ jz3.e remove(String str) {
        return (jz3.e) super.remove((Object) str);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (!(obj != null ? obj instanceof String : true)) {
            return false;
        }
        if (obj2 != null ? obj2 instanceof jz3.e : true) {
            return remove((String) obj, (jz3.e) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, jz3.e eVar) {
        return super.remove((Object) str, (Object) eVar);
    }
}
