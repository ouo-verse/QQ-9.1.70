package kotlin.reflect.jvm.internal.pcollections;

import com.tencent.tmassistantbase.util.GlobalUtil;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class HashPMap<K, V> {
    private static final HashPMap<Object, Object> EMPTY = new HashPMap<>(IntTreePMap.empty(), 0);
    private final IntTreePMap<ConsPStack<MapEntry<K, V>>> intMap;
    private final int size;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i3 != 1) {
            objArr[1] = GlobalUtil.DEF_STRING;
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap, int i3) {
        this.intMap = intTreePMap;
        this.size = i3;
    }

    @NotNull
    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<K, V> hashPMap = (HashPMap<K, V>) EMPTY;
        if (hashPMap == null) {
            $$$reportNull$$$0(0);
        }
        return hashPMap;
    }

    private ConsPStack<MapEntry<K, V>> getEntries(int i3) {
        ConsPStack<MapEntry<K, V>> consPStack = this.intMap.get(i3);
        if (consPStack == null) {
            return ConsPStack.empty();
        }
        return consPStack;
    }

    private static <K, V> int keyIndexIn(ConsPStack<MapEntry<K, V>> consPStack, Object obj) {
        int i3 = 0;
        while (consPStack != null && consPStack.size() > 0) {
            if (consPStack.first.key.equals(obj)) {
                return i3;
            }
            consPStack = consPStack.rest;
            i3++;
        }
        return -1;
    }

    public boolean containsKey(Object obj) {
        if (keyIndexIn(getEntries(obj.hashCode()), obj) != -1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object obj) {
        for (ConsPStack entries = getEntries(obj.hashCode()); entries != null && entries.size() > 0; entries = entries.rest) {
            MapEntry mapEntry = (MapEntry) entries.first;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
        }
        return null;
    }

    @NotNull
    public HashPMap<K, V> minus(Object obj) {
        ConsPStack<MapEntry<K, V>> entries = getEntries(obj.hashCode());
        int keyIndexIn = keyIndexIn(entries, obj);
        if (keyIndexIn == -1) {
            return this;
        }
        ConsPStack<MapEntry<K, V>> minus = entries.minus(keyIndexIn);
        if (minus.size() == 0) {
            return new HashPMap<>(this.intMap.minus(obj.hashCode()), this.size - 1);
        }
        return new HashPMap<>(this.intMap.plus(obj.hashCode(), minus), this.size - 1);
    }

    @NotNull
    public HashPMap<K, V> plus(K k3, V v3) {
        ConsPStack<MapEntry<K, V>> entries = getEntries(k3.hashCode());
        int size = entries.size();
        int keyIndexIn = keyIndexIn(entries, k3);
        if (keyIndexIn != -1) {
            entries = entries.minus(keyIndexIn);
        }
        ConsPStack<MapEntry<K, V>> plus = entries.plus(new MapEntry<>(k3, v3));
        return new HashPMap<>(this.intMap.plus(k3.hashCode(), plus), (this.size - size) + plus.size());
    }

    public int size() {
        return this.size;
    }
}
