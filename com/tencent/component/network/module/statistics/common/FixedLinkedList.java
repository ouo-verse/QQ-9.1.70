package com.tencent.component.network.module.statistics.common;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FixedLinkedList<V> extends LinkedList<V> {
    private final int mCapacity;
    private final boolean mTrimHead;

    public FixedLinkedList(int i3) {
        this(i3, true);
    }

    private void ensureCapacity() {
        while (this.mCapacity > 0 && size() > this.mCapacity) {
            if (this.mTrimHead) {
                removeFirst();
            } else {
                removeLast();
            }
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(V v3) {
        if (v3 == null) {
            return false;
        }
        boolean add = super.add(v3);
        ensureCapacity();
        return add;
    }

    public FixedLinkedList(int i3, boolean z16) {
        this.mCapacity = i3;
        this.mTrimHead = z16;
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int i3, V v3) {
        if (v3 == null) {
            return;
        }
        super.add(i3, v3);
        ensureCapacity();
    }
}
