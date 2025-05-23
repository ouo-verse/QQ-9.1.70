package com.qzone.preview.photodanmaku.core;

import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuManager;
import com.qzone.preview.photodanmaku.entity.AbsDanmaku;
import com.qzone.preview.photodanmaku.entity.d;
import com.qzone.preview.photodanmaku.entity.e;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes39.dex */
public class PhotoDanmakuDataSource {
    private static final String TAG = "PhotoDanmakuDataSource";
    private final BlockingQueue<AbsDanmaku> mDanmakuFirstTmpQueue;
    private final BlockingQueue<AbsDanmaku> mDanmakuLastTmpQueue;
    private final d<AbsDanmaku> mDanmakuSortedQueue;
    private final List<AbsDanmaku> mDrawingDanmakuList;
    private final AtomicBoolean mIsUsingSortedQueue;
    private final e mSortingPhotoDanmaku;
    private final com.qzone.preview.photodanmaku.entity.b mTimer;

    public PhotoDanmakuDataSource(com.qzone.preview.photodanmaku.entity.b bVar, PhotoDanmakuConfig photoDanmakuConfig, PhotoDanmakuManager.a aVar) {
        this.mTimer = bVar;
        e eVar = new e(photoDanmakuConfig, new com.qzone.preview.photodanmaku.entity.a(1L), bVar);
        this.mSortingPhotoDanmaku = eVar;
        eVar.setTimer(bVar);
        this.mDanmakuSortedQueue = new d<>(aVar);
        this.mDrawingDanmakuList = new LinkedList();
        this.mDanmakuFirstTmpQueue = new LinkedBlockingQueue();
        this.mDanmakuLastTmpQueue = new LinkedBlockingQueue();
        this.mIsUsingSortedQueue = new AtomicBoolean(false);
    }

    public void addFirst(AbsDanmaku absDanmaku) {
        this.mDanmakuFirstTmpQueue.add(absDanmaku);
    }

    public void addLast(AbsDanmaku absDanmaku) {
        this.mDanmakuLastTmpQueue.add(absDanmaku);
    }

    public void addLastAll(List<AbsDanmaku> list) {
        this.mDanmakuLastTmpQueue.addAll(list);
    }

    public void addNow(AbsDanmaku absDanmaku) {
        absDanmaku.setTime(this.mTimer.a());
        this.mDanmakuFirstTmpQueue.add(absDanmaku);
    }

    public void clear() {
        while (!this.mIsUsingSortedQueue.compareAndSet(false, true)) {
            Thread.yield();
        }
        this.mDanmakuSortedQueue.c();
        this.mDanmakuLastTmpQueue.clear();
        this.mDanmakuFirstTmpQueue.clear();
        while (!this.mIsUsingSortedQueue.compareAndSet(true, false)) {
            Thread.yield();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<AbsDanmaku> getDrawingDanmakuList() {
        return this.mDrawingDanmakuList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update() {
        while (!this.mIsUsingSortedQueue.compareAndSet(false, true)) {
            Thread.yield();
        }
        while (!this.mDanmakuFirstTmpQueue.isEmpty()) {
            this.mDanmakuSortedQueue.a(this.mDanmakuFirstTmpQueue.remove());
        }
        while (!this.mDanmakuLastTmpQueue.isEmpty()) {
            this.mDanmakuSortedQueue.b(this.mDanmakuLastTmpQueue.remove());
        }
        this.mSortingPhotoDanmaku.setTime(this.mTimer.a());
        this.mDanmakuSortedQueue.d(this.mSortingPhotoDanmaku, this.mDrawingDanmakuList);
        while (!this.mIsUsingSortedQueue.compareAndSet(true, false)) {
            Thread.yield();
        }
    }
}
