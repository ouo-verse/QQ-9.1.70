package com.tencent.qqlive.module.videoreport.reportdata;

import com.tencent.qqlive.module.videoreport.data.DataEntity;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: classes22.dex */
public class PathData {
    private WeakReference<Object> mPageRef;
    private final Deque<DataEntity> mPathPackages = new ArrayDeque();

    public void addFirst(DataEntity dataEntity) {
        this.mPathPackages.addFirst(dataEntity);
    }

    public void addLast(DataEntity dataEntity) {
        this.mPathPackages.addLast(dataEntity);
    }

    public PathData copy() {
        PathData pathData = new PathData();
        pathData.mPageRef = this.mPageRef;
        Iterator<DataEntity> it = this.mPathPackages.iterator();
        while (it.hasNext()) {
            pathData.mPathPackages.addLast(it.next());
        }
        return pathData;
    }

    public Iterator<DataEntity> descendingIterator() {
        return this.mPathPackages.descendingIterator();
    }

    public Object getPage() {
        WeakReference<Object> weakReference = this.mPageRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.mPathPackages.isEmpty();
    }

    public Iterator<DataEntity> iterator() {
        return this.mPathPackages.iterator();
    }

    public void removeFirst() {
        if (!this.mPathPackages.isEmpty()) {
            this.mPathPackages.removeFirst();
        }
    }

    public void setPage(Object obj) {
        this.mPageRef = new WeakReference<>(obj);
    }

    public int size() {
        return this.mPathPackages.size();
    }
}
