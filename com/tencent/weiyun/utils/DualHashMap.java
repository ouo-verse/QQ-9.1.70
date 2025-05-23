package com.tencent.weiyun.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DualHashMap<K, V> {
    static IPatchRedirector $redirector_;
    private final HashMap<K, V> key2Value;
    private final HashMap<V, K> value2Key;

    public DualHashMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.key2Value = new HashMap<>();
            this.value2Key = new HashMap<>();
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.key2Value.clear();
            this.value2Key.clear();
        }
    }

    public boolean containsKey(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) k3)).booleanValue();
        }
        return this.key2Value.containsKey(k3);
    }

    public boolean containsValue(V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3)).booleanValue();
        }
        return this.value2Key.containsKey(v3);
    }

    public V getByKey(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this, (Object) k3);
        }
        return this.key2Value.get(k3);
    }

    public K getByValue(V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (K) iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        }
        return this.value2Key.get(v3);
    }

    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.key2Value.isEmpty();
    }

    public Collection<K> keys() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Collection) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.value2Key.values();
    }

    public void put(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) k3, (Object) v3);
        } else {
            if (k3 != null && v3 != null) {
                this.key2Value.put(k3, v3);
                this.value2Key.put(v3, k3);
                return;
            }
            throw new IllegalArgumentException("The param key and value should be no-null.");
        }
    }

    public V removeByKey(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V) iPatchRedirector.redirect((short) 7, (Object) this, (Object) k3);
        }
        V remove = this.key2Value.remove(k3);
        if (remove != null) {
            this.value2Key.remove(remove);
        }
        return remove;
    }

    public K removeByValue(V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (K) iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3);
        }
        K remove = this.value2Key.remove(v3);
        if (remove != null) {
            this.key2Value.remove(remove);
        }
        return remove;
    }

    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.key2Value.size();
    }

    public Collection<V> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Collection) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.key2Value.values();
    }
}
