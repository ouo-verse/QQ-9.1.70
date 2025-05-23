package com.tencent.mobileqq.vas.mask;

import com.tencent.mobileqq.vas.mask.VasMaskUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/mask/VasMaskUtils$specialAvatarMap$1", "Ljava/util/LinkedHashMap;", "", "Lcom/tencent/mobileqq/vas/mask/VasMaskUtils$a;", "Lkotlin/collections/LinkedHashMap;", "", "eldest", "", "removeEldestEntry", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasMaskUtils$specialAvatarMap$1 extends LinkedHashMap<String, VasMaskUtils.a> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(VasMaskUtils.a aVar) {
        return super.containsValue((Object) aVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, VasMaskUtils.a>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ VasMaskUtils.a get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<String, VasMaskUtils.a>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ VasMaskUtils.a getOrDefault(Object obj, VasMaskUtils.a aVar) {
        return !(obj instanceof String) ? aVar : getOrDefault((String) obj, aVar);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<VasMaskUtils.a> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ VasMaskUtils.a remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(@Nullable Map.Entry<String, VasMaskUtils.a> eldest) {
        if (size() > 50) {
            return true;
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<VasMaskUtils.a> values() {
        return getValues();
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof VasMaskUtils.a) {
            return containsValue((VasMaskUtils.a) obj);
        }
        return false;
    }

    public /* bridge */ VasMaskUtils.a get(String str) {
        return (VasMaskUtils.a) super.get((Object) str);
    }

    public /* bridge */ VasMaskUtils.a getOrDefault(String str, VasMaskUtils.a aVar) {
        return (VasMaskUtils.a) super.getOrDefault((Object) str, (String) aVar);
    }

    public /* bridge */ VasMaskUtils.a remove(String str) {
        return (VasMaskUtils.a) super.remove((Object) str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (VasMaskUtils.a) obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof VasMaskUtils.a)) {
            return remove((String) obj, (VasMaskUtils.a) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, VasMaskUtils.a aVar) {
        return super.remove((Object) str, (Object) aVar);
    }
}
