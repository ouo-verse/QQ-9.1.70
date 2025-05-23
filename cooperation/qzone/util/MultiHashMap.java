package cooperation.qzone.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MultiHashMap<K, V> extends HashMap<K, HashSet<V>> {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface Matcher<V> {
        boolean match(V v3, V v16);
    }

    public boolean add(K k3, V v3) {
        if (v3 == null) {
            return false;
        }
        HashSet hashSet = (HashSet) get(k3);
        if (hashSet == null) {
            hashSet = new HashSet();
            put(k3, hashSet);
        }
        return hashSet.add(v3);
    }

    public boolean contains(K k3, V v3) {
        HashSet hashSet;
        if (v3 == null || (hashSet = (HashSet) get(k3)) == null || !hashSet.contains(v3)) {
            return false;
        }
        return true;
    }

    public final synchronized Collection<K> get(K k3, Matcher<K> matcher) {
        if (k3 != null) {
            if (matcher != null) {
                Set<K> keySet = keySet();
                if (keySet != null && keySet.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (K k16 : keySet) {
                        if (matcher.match(k3, k16)) {
                            arrayList.add(k16);
                        }
                    }
                    return arrayList;
                }
                return null;
            }
            throw new NullPointerException("keyMatcher == null");
        }
        throw new NullPointerException("key == null");
    }

    public int sizeOf(K k3) {
        Collection collection = (Collection) get(k3);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }
}
