package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    static IPatchRedirector $redirector_ = null;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final long serialVersionUID = 1;
    private final int maxCapacity;

    public LRULinkedHashMap(int i3) {
        super(i3, 0.75f, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.maxCapacity = i3;
        }
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entry)).booleanValue();
        }
        if (size() > this.maxCapacity) {
            return true;
        }
        return false;
    }
}
