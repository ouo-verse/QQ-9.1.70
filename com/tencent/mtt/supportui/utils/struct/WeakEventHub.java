package com.tencent.mtt.supportui.utils.struct;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class WeakEventHub<T> {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<WeakReference<T>> f337739a = new ArrayList<>();

    public Iterable<T> getNotifyListeners() {
        ArrayList arrayList = new ArrayList(this.f337739a.size());
        synchronized (this.f337739a) {
            Iterator<WeakReference<T>> it = this.f337739a.iterator();
            while (it.hasNext()) {
                WeakReference<T> next = it.next();
                if (next != null) {
                    T t16 = next.get();
                    if (t16 == null) {
                        it.remove();
                    } else {
                        arrayList.add(t16);
                    }
                }
            }
        }
        return arrayList;
    }

    public void registerListener(T t16) {
        if (t16 == null) {
            return;
        }
        synchronized (this.f337739a) {
            Iterator<WeakReference<T>> it = this.f337739a.iterator();
            while (it.hasNext()) {
                T t17 = it.next().get();
                if (t17 == null) {
                    it.remove();
                } else if (t17 == t16) {
                    return;
                }
            }
            this.f337739a.add(new WeakReference<>(t16));
        }
    }

    public int size() {
        return this.f337739a.size();
    }

    public void unregisterListener(T t16) {
        T t17;
        synchronized (this.f337739a) {
            if (t16 != null) {
                Iterator<WeakReference<T>> it = this.f337739a.iterator();
                while (it.hasNext()) {
                    WeakReference<T> next = it.next();
                    if (next != null && ((t17 = next.get()) == null || t17 == t16)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
