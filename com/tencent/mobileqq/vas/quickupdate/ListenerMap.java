package com.tencent.mobileqq.vas.quickupdate;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ListenerMap<E> {
    private HashMap<String, CopyOnWriteArrayList<E>> map = new HashMap<>();

    public synchronized void add(String str, E e16) {
        CopyOnWriteArrayList<E> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.map.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(e16);
    }

    public synchronized List<E> get(String str) {
        CopyOnWriteArrayList<E> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null) {
            return Collections.emptyList();
        }
        return copyOnWriteArrayList;
    }

    public synchronized List<E> remove(String str) {
        CopyOnWriteArrayList<E> remove = this.map.remove(str);
        if (remove == null) {
            return Collections.emptyList();
        }
        return remove;
    }

    public synchronized void removeListener(String str, Object obj, boolean z16) {
        CopyOnWriteArrayList<E> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList != null) {
            if (z16) {
                Iterator<E> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    E next = it.next();
                    Object obj2 = ((WeakReference) next).get();
                    if (obj2 == null || obj2 == obj) {
                        copyOnWriteArrayList.remove(next);
                    }
                }
            } else {
                copyOnWriteArrayList.remove(obj);
            }
        }
    }
}
