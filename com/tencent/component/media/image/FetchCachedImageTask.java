package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FetchCachedImageTask extends ImageTask {
    private static int mObjectPoolSize;
    private static FetchCachedImageTask sPool;
    private static final Object sPoolSync = new Object();
    private FetchCachedImageTask next;

    static {
        clearAndInitSize();
    }

    FetchCachedImageTask(ImageTask imageTask) {
        super(imageTask);
        this.next = null;
    }

    public static void clearAndInitSize() {
        synchronized (sPoolSync) {
            sPool = null;
            for (int i3 = 0; i3 < ImageTask.mInitAllocatedSize; i3++) {
                FetchCachedImageTask fetchCachedImageTask = new FetchCachedImageTask(null);
                fetchCachedImageTask.next = sPool;
                sPool = fetchCachedImageTask;
                mObjectPoolSize++;
            }
        }
    }

    public static FetchCachedImageTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                FetchCachedImageTask fetchCachedImageTask = sPool;
                if (fetchCachedImageTask != null) {
                    sPool = fetchCachedImageTask.next;
                    fetchCachedImageTask.next = null;
                    mObjectPoolSize--;
                    fetchCachedImageTask.setImageTask(imageTask);
                    return fetchCachedImageTask;
                }
            }
        }
        return new FetchCachedImageTask(imageTask);
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        ImageLoader.Options options;
        Drawable drawbleFromCache = ImageManager.getInstance().getDrawbleFromCache(this.mImageKey);
        if (drawbleFromCache != null) {
            setResult(6, drawbleFromCache, null);
            return;
        }
        ImageTask imageTask = this.mNextTask;
        if (imageTask != null) {
            imageTask.excuteTask();
            return;
        }
        ImageKey imageKey = this.mImageKey;
        if (imageKey != null && (options = imageKey.options) != null) {
            options.errCode = ImageManager.getErrorString(imageKey, 600);
        }
        setResult(4, new Object[0]);
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
        if (i3 != 3) {
            if (i3 != 11) {
                if (i3 != 8) {
                    if (i3 != 9) {
                        setResult(i3, objArr);
                        return;
                    } else {
                        setResult(4, new Object[0]);
                        return;
                    }
                }
                setResult(6, (Drawable) objArr[0], (BitmapReference) objArr[1]);
                return;
            }
            setResult(6, (Drawable) objArr[0], null);
            return;
        }
        setResult(7, (String) objArr[0], Long.valueOf(((Long) objArr[1]).longValue()), Float.valueOf(((Float) objArr[2]).floatValue()));
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
