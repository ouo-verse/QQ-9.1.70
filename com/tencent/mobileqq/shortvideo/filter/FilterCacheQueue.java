package com.tencent.mobileqq.shortvideo.filter;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public final class FilterCacheQueue {
    private ConcurrentHashMap<Integer, QQBaseFilter> mFilterList = new ConcurrentHashMap<>(15);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearAll() {
        this.mFilterList.clear();
    }

    int countFilter() {
        return this.mFilterList.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQBaseFilter getFilterByType(int i3) {
        QQBaseFilter qQBaseFilter = this.mFilterList.get(Integer.valueOf(i3));
        if (qQBaseFilter != null) {
            return qQBaseFilter;
        }
        throw new RuntimeException("getFilterByType failed type=" + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQBaseFilter getFilterByTypeWithCreate(int i3, QQFilterRenderManager qQFilterRenderManager) {
        QQBaseFilter qQBaseFilter = this.mFilterList.get(Integer.valueOf(i3));
        if (qQBaseFilter == null) {
            qQBaseFilter = FilterCreateFactory.createFilter(i3, qQFilterRenderManager);
            if (qQBaseFilter != null) {
                this.mFilterList.put(Integer.valueOf(i3), qQBaseFilter);
            } else {
                throw new RuntimeException("createFilter failed type=" + i3);
            }
        }
        return qQBaseFilter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<QQBaseFilter> getFilterList() {
        return this.mFilterList.values();
    }

    boolean hasFilter(int i3) {
        if (this.mFilterList.get(Integer.valueOf(i3)) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFilter(int i3) {
        this.mFilterList.remove(Integer.valueOf(i3));
    }
}
