package com.qzone.util;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class t<E> {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<ArrayList<E>> f59841a = new SparseArray<>();

    public List<E> a(int i3) {
        return this.f59841a.get(i3);
    }

    public int b(int i3) {
        return this.f59841a.keyAt(i3);
    }

    public int c() {
        return this.f59841a.size();
    }

    public E d(int i3, E e16) {
        if (e16 == null) {
            return null;
        }
        List<E> a16 = a(i3);
        if (a16 == null) {
            a16 = new ArrayList<>();
            this.f59841a.put(i3, a16);
        }
        int indexOf = a16.indexOf(e16);
        E remove = indexOf != -1 ? a16.remove(indexOf) : null;
        a16.add(e16);
        return remove;
    }
}
