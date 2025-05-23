package com.tencent.component.media.image;

import com.tencent.component.media.utils.ImageManagerLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CancelStreamDecodeGifTask extends StreamDecodeGifTask {
    private static int mObjectPoolSize;
    private static CancelStreamDecodeGifTask sPool;
    private static final Object sPoolSync = new Object();
    private CancelStreamDecodeGifTask next;

    static {
        clearAndInitSize();
    }

    CancelStreamDecodeGifTask(ImageTask imageTask) {
        super(imageTask);
        this.next = null;
    }

    public static void clearAndInitSize() {
        synchronized (sPoolSync) {
            sPool = null;
            for (int i3 = 0; i3 < ImageTask.mInitAllocatedSize; i3++) {
                CancelStreamDecodeGifTask cancelStreamDecodeGifTask = new CancelStreamDecodeGifTask((ImageKey) null);
                cancelStreamDecodeGifTask.next = sPool;
                sPool = cancelStreamDecodeGifTask;
                mObjectPoolSize++;
            }
        }
    }

    public static CancelStreamDecodeGifTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                CancelStreamDecodeGifTask cancelStreamDecodeGifTask = sPool;
                if (cancelStreamDecodeGifTask != null) {
                    sPool = cancelStreamDecodeGifTask.next;
                    cancelStreamDecodeGifTask.next = null;
                    mObjectPoolSize--;
                    cancelStreamDecodeGifTask.setImageTask(imageTask);
                    return cancelStreamDecodeGifTask;
                }
            }
        }
        return new CancelStreamDecodeGifTask(imageTask);
    }

    @Override // com.tencent.component.media.image.StreamDecodeGifTask, com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        if (!isCanceled()) {
            super.excuteTask();
        } else {
            setResult(13, new Object[0]);
        }
    }

    @Override // com.tencent.component.media.image.StreamDecodeGifTask, com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
    protected void onResult(int i3, Object... objArr) {
        if (i3 == 13) {
            setResult(13, new Object[0]);
            return;
        }
        if (!isCanceled()) {
            super.onResult(i3, objArr);
            return;
        }
        removeRecord((String) objArr[0]);
        if (this.mImageKey != null) {
            ImageManagerLog.d("CancelStreamDecodeGifTask", "onResult type:" + i3 + " hashcode:" + this.mImageKey.hashCodeEx());
        }
        setResult(13, new Object[0]);
    }

    @Override // com.tencent.component.media.image.StreamDecodeGifTask, com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
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

    CancelStreamDecodeGifTask(ImageKey imageKey) {
        super(imageKey);
        this.next = null;
    }

    public static CancelStreamDecodeGifTask obtain(ImageKey imageKey) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                CancelStreamDecodeGifTask cancelStreamDecodeGifTask = sPool;
                if (cancelStreamDecodeGifTask != null) {
                    sPool = cancelStreamDecodeGifTask.next;
                    cancelStreamDecodeGifTask.next = null;
                    mObjectPoolSize--;
                    cancelStreamDecodeGifTask.setImageKey(imageKey);
                    return cancelStreamDecodeGifTask;
                }
            }
        }
        return new CancelStreamDecodeGifTask(imageKey);
    }
}
