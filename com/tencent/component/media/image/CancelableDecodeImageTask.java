package com.tencent.component.media.image;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CancelableDecodeImageTask extends DecodeImageTask {
    private static int mObjectPoolSize;
    private static CancelableDecodeImageTask sPool;
    private static final Object sPoolSync = new Object();
    private CancelableDecodeImageTask next;

    static {
        clearAndInitSize();
    }

    CancelableDecodeImageTask(ImageTask imageTask) {
        super(imageTask);
        this.next = null;
    }

    public static void clearAndInitSize() {
        synchronized (sPoolSync) {
            sPool = null;
            for (int i3 = 0; i3 < ImageTask.mInitAllocatedSize; i3++) {
                CancelableDecodeImageTask cancelableDecodeImageTask = new CancelableDecodeImageTask((ImageKey) null);
                cancelableDecodeImageTask.next = sPool;
                sPool = cancelableDecodeImageTask;
                mObjectPoolSize++;
            }
        }
    }

    public static CancelableDecodeImageTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                CancelableDecodeImageTask cancelableDecodeImageTask = sPool;
                if (cancelableDecodeImageTask != null) {
                    sPool = cancelableDecodeImageTask.next;
                    cancelableDecodeImageTask.next = null;
                    mObjectPoolSize--;
                    cancelableDecodeImageTask.setImageTask(imageTask);
                    return cancelableDecodeImageTask;
                }
            }
        }
        return new CancelableDecodeImageTask(imageTask);
    }

    @Override // com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        if (!isCanceled()) {
            super.excuteTask();
        } else {
            setResult(13, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
    public void onResult(int i3, Object... objArr) {
        if (i3 == 13) {
            setResult(13, new Object[0]);
        } else {
            super.onResult(i3, objArr);
        }
    }

    @Override // com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
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

    @Override // com.tencent.component.media.image.DecodeImageTask
    public void startDecodeTask() {
        if (!isCanceled()) {
            super.startDecodeTask();
        } else {
            setResult(13, new Object[0]);
        }
    }

    CancelableDecodeImageTask(ImageKey imageKey) {
        super(imageKey);
        this.next = null;
    }

    public static CancelableDecodeImageTask obtain(ImageKey imageKey) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                CancelableDecodeImageTask cancelableDecodeImageTask = sPool;
                if (cancelableDecodeImageTask != null) {
                    sPool = cancelableDecodeImageTask.next;
                    cancelableDecodeImageTask.next = null;
                    mObjectPoolSize--;
                    cancelableDecodeImageTask.setImageKey(imageKey);
                    return cancelableDecodeImageTask;
                }
            }
        }
        return new CancelableDecodeImageTask(imageKey);
    }
}
