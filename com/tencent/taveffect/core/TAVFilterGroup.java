package com.tencent.taveffect.core;

import android.graphics.Matrix;
import com.tencent.taveffect.effects.LookupFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVFilterGroup extends TAVBaseFilter {
    private LinkedList<TAVBaseFilter> filterLinkedList;
    private TAVRendererFilter rendererFilter;
    private TextureMatrixFilter textureMatrixFilter;

    public TAVFilterGroup() {
        this(false);
    }

    private synchronized TAVTextureInfo applyTexture(int i3, TAVTextureInfo tAVTextureInfo) {
        if (i3 >= this.filterLinkedList.size()) {
            return tAVTextureInfo;
        }
        TAVBaseFilter tAVBaseFilter = this.filterLinkedList.get(i3);
        if (tAVBaseFilter != null) {
            tAVTextureInfo = tAVBaseFilter.applyFilter(tAVTextureInfo);
        }
        return applyTexture(i3 + 1, tAVTextureInfo);
    }

    private void updateTimeRange(TAVBaseFilter tAVBaseFilter) {
        TAVTimeRange timeRange = tAVBaseFilter.getTimeRange();
        if (timeRange == null) {
            return;
        }
        ListIterator<TAVBaseFilter> listIterator = this.filterLinkedList.listIterator();
        while (listIterator.hasNext()) {
            TAVBaseFilter next = listIterator.next();
            if (next != tAVBaseFilter && !(next instanceof LookupFilter)) {
                TAVTimeRange timeRange2 = next.getTimeRange();
                if (timeRange2 != null && timeRange2.duration() > 0) {
                    if (timeRange.start() > timeRange2.end() && timeRange.start() <= timeRange2.end() + 10000) {
                        timeRange.update(timeRange2.end(), timeRange.end() - timeRange2.end());
                    }
                    if (timeRange.end() < timeRange2.start() && timeRange.end() >= timeRange2.start() - 10000) {
                        timeRange.update(timeRange.start(), timeRange2.start() - timeRange.start());
                    }
                    if (timeRange.start() > timeRange2.start() && timeRange.start() < timeRange2.end() && timeRange.end() >= timeRange2.end()) {
                        timeRange2.update(timeRange2.start(), timeRange.start() - timeRange2.start());
                    } else if (timeRange.end() > timeRange2.start() && timeRange.end() < timeRange2.end() && timeRange.start() <= timeRange2.start()) {
                        timeRange2.update(timeRange.end(), timeRange2.end() - timeRange.end());
                    } else if (timeRange.start() > timeRange2.start() && timeRange.end() < timeRange2.end()) {
                        TAVBaseFilter mo93clone = next.mo93clone();
                        mo93clone.getTimeRange().update(timeRange2.start(), timeRange.start() - timeRange2.start());
                        listIterator.add(mo93clone);
                        timeRange2.update(timeRange.end(), timeRange2.end() - timeRange.start());
                    } else if (timeRange.start() <= timeRange2.start() && timeRange.end() >= timeRange2.end()) {
                        timeRange2.update(timeRange2.start(), 0L);
                    }
                } else {
                    next.release();
                    listIterator.remove();
                }
            }
        }
    }

    public synchronized void add(TAVBaseFilter tAVBaseFilter) {
        if (tAVBaseFilter == null) {
            return;
        }
        if (this.filterLinkedList.contains(tAVBaseFilter)) {
            return;
        }
        this.filterLinkedList.add(tAVBaseFilter);
    }

    public synchronized void addAll(List<TAVBaseFilter> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                this.filterLinkedList.addAll(list);
            }
        }
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    public TAVTextureInfo applyFilter(TAVTextureInfo tAVTextureInfo) {
        TextureMatrixFilter textureMatrixFilter = this.textureMatrixFilter;
        if (textureMatrixFilter != null) {
            tAVTextureInfo = textureMatrixFilter.applyFilter(tAVTextureInfo);
        }
        TAVTextureInfo applyTexture = applyTexture(0, tAVTextureInfo);
        TAVRendererFilter tAVRendererFilter = this.rendererFilter;
        if (tAVRendererFilter != null) {
            return tAVRendererFilter.applyFilter(applyTexture);
        }
        return applyTexture;
    }

    public synchronized boolean contains(TAVBaseFilter tAVBaseFilter) {
        return this.filterLinkedList.contains(tAVBaseFilter);
    }

    public TAVBaseFilter getByFilterId(long j3) {
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null && next.f374470id == j3) {
                return next;
            }
        }
        return null;
    }

    public TAVBaseFilter getByTimeRange(TAVTimeRange tAVTimeRange) {
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null && next.getTimeRange().equals(tAVTimeRange)) {
                return next;
            }
        }
        return null;
    }

    public synchronized List<TAVBaseFilter> getCloneFilterGroup() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                arrayList.add(next.mo93clone());
            }
        }
        return arrayList;
    }

    public synchronized List<TAVBaseFilter> getFilterGroup() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public synchronized boolean hasRender() {
        boolean z16;
        if (this.rendererFilter != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    @Override // com.tencent.taveffect.core.TAVTextureProcessor
    public synchronized void release() {
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                next.release();
            }
        }
        TextureMatrixFilter textureMatrixFilter = this.textureMatrixFilter;
        if (textureMatrixFilter != null) {
            textureMatrixFilter.release();
        }
        TAVRendererFilter tAVRendererFilter = this.rendererFilter;
        if (tAVRendererFilter != null) {
            tAVRendererFilter.release();
        }
    }

    public synchronized void releaseFilterGroup() {
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                next.release();
            }
        }
        this.filterLinkedList.clear();
    }

    public synchronized void remove(TAVBaseFilter tAVBaseFilter) {
        if (this.filterLinkedList.remove(tAVBaseFilter)) {
            tAVBaseFilter.release();
        }
    }

    public synchronized void removeLast() {
        if (this.filterLinkedList.size() > 0) {
            this.filterLinkedList.removeLast();
        }
    }

    public synchronized void reset() {
        this.filterLinkedList.clear();
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    public synchronized void setOverlay(boolean z16) {
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                next.setOverlay(z16);
            }
        }
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    public void setParams(Matrix matrix, Matrix matrix2, TAVRectangle tAVRectangle, float f16) {
        TextureMatrixFilter textureMatrixFilter = this.textureMatrixFilter;
        if (textureMatrixFilter != null) {
            textureMatrixFilter.setParams(matrix, matrix2, tAVRectangle, f16);
        }
        TAVRendererFilter tAVRendererFilter = this.rendererFilter;
        if (tAVRendererFilter != null) {
            tAVRendererFilter.setParams(matrix, matrix2, tAVRectangle, f16);
        }
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            it.next().setParams(matrix, matrix2, tAVRectangle, f16);
        }
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    public synchronized void setRendererHeight(int i3) {
        TextureMatrixFilter textureMatrixFilter = this.textureMatrixFilter;
        if (textureMatrixFilter != null) {
            textureMatrixFilter.setRendererHeight(i3);
        }
        TAVRendererFilter tAVRendererFilter = this.rendererFilter;
        if (tAVRendererFilter != null) {
            tAVRendererFilter.setRendererHeight(i3);
        }
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                next.setRendererHeight(i3);
            }
        }
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    public synchronized void setRendererWidth(int i3) {
        TextureMatrixFilter textureMatrixFilter = this.textureMatrixFilter;
        if (textureMatrixFilter != null) {
            textureMatrixFilter.setRendererWidth(i3);
        }
        TAVRendererFilter tAVRendererFilter = this.rendererFilter;
        if (tAVRendererFilter != null) {
            tAVRendererFilter.setRendererWidth(i3);
        }
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                next.setRendererWidth(i3);
            }
        }
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    public synchronized void setTimeRange(TAVTimeRange tAVTimeRange) {
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                next.setTimeRange(tAVTimeRange);
            }
        }
    }

    public synchronized int size() {
        return this.filterLinkedList.size();
    }

    public synchronized void update(TAVBaseFilter tAVBaseFilter) {
        int indexOf = this.filterLinkedList.indexOf(tAVBaseFilter);
        if (indexOf != -1) {
            this.filterLinkedList.set(indexOf, tAVBaseFilter);
            updateTimeRange(tAVBaseFilter);
        }
    }

    public TAVFilterGroup(boolean z16) {
        this.filterLinkedList = new LinkedList<>();
        this.textureMatrixFilter = new TextureMatrixFilter();
        if (z16) {
            this.rendererFilter = new TAVRendererFilter();
        }
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    /* renamed from: clone */
    public TAVFilterGroup mo93clone() {
        TAVFilterGroup tAVFilterGroup = new TAVFilterGroup();
        TextureMatrixFilter textureMatrixFilter = this.textureMatrixFilter;
        if (textureMatrixFilter != null) {
            tAVFilterGroup.textureMatrixFilter = textureMatrixFilter.mo93clone();
        }
        TAVRendererFilter tAVRendererFilter = this.rendererFilter;
        if (tAVRendererFilter != null) {
            tAVFilterGroup.rendererFilter = tAVRendererFilter.mo93clone();
        }
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next != null) {
                tAVFilterGroup.add(next.mo93clone());
            }
        }
        return tAVFilterGroup;
    }

    public synchronized void remove(Class<? extends TAVBaseFilter> cls) {
        Iterator<TAVBaseFilter> it = this.filterLinkedList.iterator();
        while (it.hasNext()) {
            TAVBaseFilter next = it.next();
            if (next.getClass() == cls) {
                it.remove();
                next.release();
            }
        }
    }

    @Override // com.tencent.taveffect.core.TAVTextureProcessor
    public TAVTextureInfo applyNewTexture(TAVTextureInfo tAVTextureInfo) {
        return tAVTextureInfo;
    }
}
