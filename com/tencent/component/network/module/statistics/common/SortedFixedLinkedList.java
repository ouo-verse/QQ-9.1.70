package com.tencent.component.network.module.statistics.common;

import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SortedFixedLinkedList<V> extends FixedLinkedList<V> {
    private final Comparator<V> mComparator;

    public SortedFixedLinkedList(int i3, Comparator<V> comparator) {
        super(i3);
        this.mComparator = comparator;
    }

    @Override // com.tencent.component.network.module.statistics.common.FixedLinkedList, java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(V v3) {
        int i3 = 0;
        if (v3 == null) {
            return false;
        }
        if (this.mComparator == null) {
            return super.add(v3);
        }
        int size = size();
        while (i3 < size) {
            V v16 = get(i3);
            if (v16 != null && this.mComparator.compare(v3, v16) <= 0) {
                break;
            }
            i3++;
        }
        super.add(i3, v3);
        return true;
    }

    public SortedFixedLinkedList(int i3, Comparator<V> comparator, boolean z16) {
        super(i3, z16);
        this.mComparator = comparator;
    }

    @Override // com.tencent.component.network.module.statistics.common.FixedLinkedList, java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int i3, V v3) {
        if (v3 == null) {
            return;
        }
        if (this.mComparator == null) {
            super.add(i3, v3);
        } else {
            add(v3);
        }
    }
}
