package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TencentMapGestureListenerList implements TencentMapGestureListener {
    private ArrayList<TencentMapGestureListener> mListeners = new ArrayList<>();

    public synchronized void addListener(TencentMapGestureListener tencentMapGestureListener) {
        if (tencentMapGestureListener != null) {
            if (!this.mListeners.contains(tencentMapGestureListener)) {
                this.mListeners.add(tencentMapGestureListener);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onDoubleTap(float f16, float f17) {
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onDoubleTap(f16, f17);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onDown(float f16, float f17) {
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onDown(f16, f17);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onFling(float f16, float f17) {
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onFling(f16, f17);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onLongPress(float f16, float f17) {
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onLongPress(f16, f17);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized void onMapStable() {
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onMapStable();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onScroll(float f16, float f17) {
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onScroll(f16, f17);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onSingleTap(float f16, float f17) {
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onSingleTap(f16, f17);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onUp(float f16, float f17) {
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onUp(f16, f17);
        }
        return false;
    }

    public synchronized void removeListener(TencentMapGestureListener tencentMapGestureListener) {
        this.mListeners.remove(tencentMapGestureListener);
    }
}
