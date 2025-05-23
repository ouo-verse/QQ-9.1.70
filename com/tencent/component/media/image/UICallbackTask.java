package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.utils.BaseHandler;

/* compiled from: P */
/* loaded from: classes5.dex */
public class UICallbackTask extends ImageTask {
    private UICallbackTask next;
    private static BaseHandler mMainHandler = new BaseHandler(Looper.getMainLooper());
    private static UICallbackTask sPool = null;
    private static final Object sPoolSync = new Object();
    private static int mObjectPoolSize = 0;

    static {
        clearAndInitSize();
    }

    UICallbackTask(ImageTask imageTask) {
        super(imageTask);
        this.next = null;
    }

    public static void clearAndInitSize() {
        synchronized (sPoolSync) {
            sPool = null;
            for (int i3 = 0; i3 < ImageTask.mInitAllocatedSize; i3++) {
                UICallbackTask uICallbackTask = new UICallbackTask(null);
                uICallbackTask.next = sPool;
                sPool = uICallbackTask;
                mObjectPoolSize++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCallbackUrl(ImageKey imageKey) {
        if (imageKey == null) {
            return null;
        }
        String str = imageKey.srUrl;
        if (str == null) {
            return imageKey.url;
        }
        return str;
    }

    public static UICallbackTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                UICallbackTask uICallbackTask = sPool;
                if (uICallbackTask != null) {
                    sPool = uICallbackTask.next;
                    uICallbackTask.next = null;
                    mObjectPoolSize--;
                    uICallbackTask.setImageTask(imageTask);
                    return uICallbackTask;
                }
            }
        }
        return new UICallbackTask(imageTask);
    }

    private void onImageCanceled(final ImageKey imageKey) {
        boolean z16;
        if (imageKey == null) {
            return;
        }
        ProgressTracer.print(1003, getCallbackUrl(imageKey));
        ImageLoader.ImageDownloadListener imageDownloadListener = imageKey.imglistener;
        if (imageDownloadListener != null) {
            imageDownloadListener.onDownloadCanceled(getCallbackUrl(imageKey));
        }
        ImageLoader.ImageLoadListener imageLoadListener = imageKey.listener;
        if (imageLoadListener != null) {
            ImageLoader.Options options = imageKey.options;
            if (options == null) {
                z16 = false;
            } else {
                z16 = options.useMainThread;
            }
            if (z16) {
                mMainHandler.post(new Runnable() { // from class: com.tencent.component.media.image.UICallbackTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageKey imageKey2 = imageKey;
                        imageKey2.listener.onImageCanceled(UICallbackTask.this.getCallbackUrl(imageKey2), imageKey.options);
                    }
                });
            } else {
                imageLoadListener.onImageCanceled(getCallbackUrl(imageKey), imageKey.options);
            }
        }
    }

    private void onImageFailed(final ImageKey imageKey) {
        boolean z16;
        if (imageKey == null) {
            return;
        }
        ImageLoader.ImageDownloadListener imageDownloadListener = imageKey.imglistener;
        if (imageDownloadListener != null) {
            imageDownloadListener.onDownloadFailed(getCallbackUrl(imageKey));
        }
        ImageLoader.ImageLoadListener imageLoadListener = imageKey.listener;
        if (imageLoadListener != null) {
            ImageLoader.Options options = imageKey.options;
            if (options == null) {
                z16 = false;
            } else {
                z16 = options.useMainThread;
            }
            if (z16) {
                mMainHandler.post(new Runnable() { // from class: com.tencent.component.media.image.UICallbackTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageKey imageKey2 = imageKey;
                        imageKey2.listener.onImageFailed(UICallbackTask.this.getCallbackUrl(imageKey2), imageKey.options);
                    }
                });
            } else {
                imageLoadListener.onImageFailed(getCallbackUrl(imageKey), imageKey.options);
            }
        }
    }

    private void onImageLoaded(final ImageKey imageKey, final Drawable drawable) {
        boolean z16;
        if (imageKey == null) {
            return;
        }
        ImageLoader.ImageDownloadListener imageDownloadListener = imageKey.imglistener;
        if (imageDownloadListener != null) {
            imageDownloadListener.onDownloadSucceed(getCallbackUrl(imageKey));
        }
        ImageLoader.ImageLoadListener imageLoadListener = imageKey.listener;
        if (imageLoadListener != null) {
            ImageLoader.Options options = imageKey.options;
            if (options == null) {
                z16 = false;
            } else {
                z16 = options.useMainThread;
            }
            if (z16) {
                mMainHandler.post(new Runnable() { // from class: com.tencent.component.media.image.UICallbackTask.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageKey imageKey2 = imageKey;
                        imageKey2.listener.onImageLoaded(UICallbackTask.this.getCallbackUrl(imageKey2), drawable, imageKey.options);
                    }
                });
            } else {
                imageLoadListener.onImageLoaded(getCallbackUrl(imageKey), drawable, imageKey.options);
                ProgressTracer.printI(Long.valueOf(System.currentTimeMillis()), ProgressTracer.SEPARATOR, 6, ProgressTracer.SEPARATOR, getCallbackUrl(imageKey), ProgressTracer.SEPARATOR, Integer.valueOf(imageKey.listener.hashCode()));
            }
        }
    }

    private void onImageProgress(final ImageKey imageKey, long j3, final float f16) {
        boolean z16;
        if (imageKey != null && imageKey.needCallBackProcessPercent) {
            ImageLoader.ImageDownloadListener imageDownloadListener = imageKey.imglistener;
            if (imageDownloadListener != null) {
                imageDownloadListener.onDownloadProgress(getCallbackUrl(imageKey), j3, f16);
            }
            ImageLoader.ImageLoadListener imageLoadListener = imageKey.listener;
            if (imageLoadListener != null) {
                ImageLoader.Options options = imageKey.options;
                if (options != null) {
                    options.totalSize = j3;
                }
                if (options == null) {
                    z16 = false;
                } else {
                    z16 = options.useMainThread;
                }
                if (z16) {
                    mMainHandler.post(new Runnable() { // from class: com.tencent.component.media.image.UICallbackTask.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageKey imageKey2 = imageKey;
                            imageKey2.listener.onImageProgress(UICallbackTask.this.getCallbackUrl(imageKey2), f16, imageKey.options);
                        }
                    });
                } else {
                    imageLoadListener.onImageProgress(getCallbackUrl(imageKey), f16, imageKey.options);
                }
            }
        }
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        ImageTask imageTask = this.mNextTask;
        if (imageTask != null) {
            imageTask.excuteTask();
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
        switch (i3) {
            case 0:
                onImageCanceled(this.mImageKey);
                break;
            case 1:
                onImageFailed(this.mImageKey);
                break;
            case 2:
            case 11:
            case 12:
                onImageLoaded(this.mImageKey, null);
                break;
            case 3:
                onImageProgress(this.mImageKey, ((Long) objArr[1]).longValue(), ((Float) objArr[2]).floatValue());
                break;
            case 4:
                onImageFailed(this.mImageKey);
                break;
            case 5:
                onImageCanceled(this.mImageKey);
                break;
            case 6:
                onImageLoaded(this.mImageKey, (Drawable) objArr[0]);
                break;
            case 7:
                onImageProgress(this.mImageKey, ((Long) objArr[1]).longValue(), ((Float) objArr[2]).floatValue());
                break;
            case 13:
                onImageCanceled(this.mImageKey);
                break;
            case 15:
                onImageLoaded(this.mImageKey, (Drawable) objArr[0]);
                break;
        }
        if (i3 != 3 && i3 != 7 && i3 != 14 && i3 != 15) {
            setResult(i3, objArr);
        }
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
