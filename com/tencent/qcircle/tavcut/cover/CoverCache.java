package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CoverCache {
    private static final int MAX_SIZE = 64;
    private static final String TAG = "CoverCache";
    private CoverListener mCoverListener;
    private ConcurrentHashMap<Integer, Bitmap> mCoverMap = new ConcurrentHashMap<>(16);
    private ConcurrentHashMap<Integer, Bitmap> mProgressCoverMap = new ConcurrentHashMap<>(16);

    public void addCover(int i3, Bitmap bitmap) {
        if (this.mCoverMap == null) {
            return;
        }
        Log.i(TAG, "addCover: " + i3);
        this.mCoverMap.putIfAbsent(Integer.valueOf(i3), bitmap);
        CoverListener coverListener = this.mCoverListener;
        if (coverListener != null) {
            coverListener.onCover(i3, bitmap);
        }
    }

    public int getCacheSize() {
        int i3;
        ConcurrentHashMap<Integer, Bitmap> concurrentHashMap = this.mCoverMap;
        if (concurrentHashMap != null) {
            i3 = concurrentHashMap.size();
        } else {
            i3 = 0;
        }
        Log.i(TAG, "getCacheSize: " + i3);
        return i3;
    }

    public Bitmap getCover(int i3) {
        ConcurrentHashMap<Integer, Bitmap> concurrentHashMap = this.mCoverMap;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(Integer.valueOf(i3));
        }
        return null;
    }

    public Bitmap getCoverByTime(long j3) {
        ConcurrentHashMap<Integer, Bitmap> concurrentHashMap = this.mProgressCoverMap;
        if (concurrentHashMap != null && concurrentHashMap.get(Long.valueOf(j3)) != null) {
            return this.mProgressCoverMap.get(Long.valueOf(j3));
        }
        return null;
    }

    public synchronized void release() {
        Log.i(TAG, "release: ");
        ConcurrentHashMap<Integer, Bitmap> concurrentHashMap = this.mCoverMap;
        if (concurrentHashMap != null) {
            for (Bitmap bitmap : concurrentHashMap.values()) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.mCoverMap.clear();
            this.mCoverMap = null;
        }
        this.mCoverListener = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setClipCoverListener(CoverListener coverListener) {
        this.mCoverListener = coverListener;
    }
}
