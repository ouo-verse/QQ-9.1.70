package com.tencent.component.media.image;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RecycleResourceTask extends ImageTask {
    private static double averageTime;
    private static int mObjectPoolSize;
    private static long requestNum;
    private static RecycleResourceTask sPool;
    private static final Object sPoolSync = new Object();
    private RecycleResourceTask next;
    private long startTime;

    static {
        clearAndInitSize();
    }

    RecycleResourceTask(ImageTask imageTask) {
        super(imageTask);
        this.startTime = 0L;
        this.next = null;
    }

    public static void clearAndInitSize() {
        synchronized (sPoolSync) {
            sPool = null;
            for (int i3 = 0; i3 < ImageTask.mInitAllocatedSize; i3++) {
                RecycleResourceTask recycleResourceTask = new RecycleResourceTask(null);
                recycleResourceTask.next = sPool;
                sPool = recycleResourceTask;
                mObjectPoolSize++;
            }
        }
    }

    public static RecycleResourceTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                RecycleResourceTask recycleResourceTask = sPool;
                if (recycleResourceTask != null) {
                    sPool = recycleResourceTask.next;
                    recycleResourceTask.next = null;
                    mObjectPoolSize--;
                    recycleResourceTask.setImageTask(imageTask);
                    return recycleResourceTask;
                }
            }
        }
        return new RecycleResourceTask(imageTask);
    }

    private void updateTime(long j3) {
        synchronized (RecycleResourceTask.class) {
            averageTime = ((requestNum * averageTime) + j3) / (r1 + 1);
            Log.i("ttt", "ImageTask averageTime: " + averageTime);
            requestNum = requestNum + 1;
        }
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        if (this.mNextTask != null) {
            ImageTaskTracer.addImageTaskLifeCycleRecord(this.mImageKey.hashCodeEx());
            ImageTaskManager.addImageTask(this);
            this.mNextTask.excuteTask();
        }
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageKey getImageKey() {
        return super.getImageKey();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageTask getNextTask() {
        return super.getNextTask();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageTask getPreviousTask() {
        return super.getPreviousTask();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ boolean isCanceled() {
        return super.isCanceled();
    }

    @Override // com.tencent.component.media.image.ImageTask
    protected void onResult(int i3, Object... objArr) {
        ImageTaskTracer.removeImageTaskLifeCycleRecord(this.mImageKey.hashCodeEx());
        Log.d("RecycleResourceTask", "onResult type:" + i3 + " hashcode:" + this.mImageKey.hashCodeEx() + " url:" + getImageKey().url);
        ImageTaskManager.removeImageTask(getImageKey());
        ImageTask imageTask = this.mNextTask;
        while (imageTask != null) {
            ImageTask nextTask = imageTask.getNextTask();
            imageTask.recycle();
            imageTask = nextTask;
        }
        recycle();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void recycle() {
        if (!ImageTask.needRecycle) {
            return;
        }
        reset();
        synchronized (sPoolSync) {
            int i3 = mObjectPoolSize;
            if (i3 < 50) {
                this.next = sPool;
                sPool = this;
                mObjectPoolSize = i3 + 1;
            }
        }
    }
}
