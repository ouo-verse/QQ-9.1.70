package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a\"\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00060\u0005H\u0000\u001a8\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\r\"\b\b\u0000\u0010\u000b*\u00020\n*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002\u001a@\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\fj\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000`\r\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001H\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/google/gson/JsonElement;", "", "", "globalJsonKeyToNamingMapping", "f", "", "Lkotlin/Pair;", "Ljava/lang/Class;", "Lcom/google/gson/JsonDeserializer;", "d", "", "T", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "K", "V", "g", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    @NotNull
    public static final List<Pair<Class<?>, JsonDeserializer<?>>> d() {
        int collectionSizeOrDefault;
        Set<Class<? extends Object>> keySet = b.f221028d.b().keySet();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            arrayList.add(TuplesKt.to(cls, new BaseGProDeserializer(cls, null, null, 6, null)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> HashMap<String, String> e(Class<T> cls) {
        Map<String, String> map = b.f221028d.b().get(cls);
        if (map == null) {
            return new HashMap<>();
        }
        return g(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonElement f(JsonElement jsonElement, Map<String, String> map) {
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            for (String str : map.keySet()) {
                if (asJsonObject.has(str)) {
                    asJsonObject.add(map.get(str), asJsonObject.remove(str));
                }
            }
        }
        return jsonElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> HashMap<V, K> g(Map<K, ? extends V> map) {
        HashMap<V, K> hashMap = new HashMap<>(map.size());
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            hashMap.put(entry.getValue(), entry.getKey());
        }
        return hashMap;
    }
}
