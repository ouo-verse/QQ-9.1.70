package com.tencent.weiyun.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MultiHashMap<K, V> extends HashMap<K, HashSet<V>> {
    static IPatchRedirector $redirector_;

    public MultiHashMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean add(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) k3, (Object) v3)).booleanValue();
        }
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

    @Override // java.util.HashMap, java.util.Map
    public boolean remove(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) k3, (Object) v3)).booleanValue();
        }
        boolean z16 = true;
        if (v3 == null) {
            if (remove(k3) != null) {
                return true;
            }
            return false;
        }
        Collection collection = (Collection) get(k3);
        if (collection == null || !collection.remove(v3)) {
            z16 = false;
        }
        if (collection != null && collection.isEmpty()) {
            remove(k3);
        }
        return z16;
    }

    public int sizeOf(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3)).intValue();
        }
        Collection collection = (Collection) get(k3);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }
}
