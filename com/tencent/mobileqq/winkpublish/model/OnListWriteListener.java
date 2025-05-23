package com.tencent.mobileqq.winkpublish.model;

import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface OnListWriteListener<E> {
    void add(int i3, E e16);

    void add(E e16);

    void addAll(int i3, Collection<? extends E> collection);

    void addAll(Collection<? extends E> collection);

    void clear();

    void remove(int i3);

    void remove(Object obj);

    void set(int i3, E e16);

    void setDoListWriteInterface(DoListWriteInterface<E> doListWriteInterface);
}
