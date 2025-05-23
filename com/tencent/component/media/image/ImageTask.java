package com.tencent.component.media.image;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class ImageTask {
    protected static final int MAX_OBJECT_POOL_SIZE = 50;
    protected static final int RESULT_ON_DECODE_GIF_STREAM_SUCCEED = 17;
    protected static final int RESULT_ON_DECODE_IMAGE_FAILED = 9;
    protected static final int RESULT_ON_DECODE_IMAGE_SUCCEED = 8;
    protected static final int RESULT_ON_DONWNLOAD_CANCELED = 0;
    protected static final int RESULT_ON_DONWNLOAD_FAILED = 1;
    protected static final int RESULT_ON_DONWNLOAD_PROGRESS = 3;
    protected static final int RESULT_ON_DONWNLOAD_SUCCEED = 2;
    protected static final int RESULT_ON_IMAGE_CANCELED = 5;
    protected static final int RESULT_ON_IMAGE_FAILED = 4;
    protected static final int RESULT_ON_IMAGE_LOADED = 6;
    protected static final int RESULT_ON_IMAGE_PROGRESS = 7;
    protected static final int RESULT_ON_STREAM_APPLY_IMAGE = 15;
    protected static final int RESULT_ON_STREAM_END = 16;
    protected static final int RESULT_ON_STREAM_PROGRESS = 14;
    protected static final int RESULT_ON_TASK_CANCELED = 13;
    protected static final int RESULT_ON_TRY_GET_FILE_SUCCEED = 12;
    protected static final int RESULT_ON_TRY_GET_MEMORY_SUCCEED = 11;
    protected static int mInitAllocatedSize = 25;
    protected static boolean needRecycle = true;
    protected ImageKey mImageKey;
    protected ImageTask mNextTask;
    protected ImageTask mPreviousTask;
    protected ImageTaskAttribute mTaskAttribute;

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageTask(ImageTask imageTask) {
        this.mNextTask = null;
        this.mPreviousTask = null;
        this.mImageKey = null;
        this.mTaskAttribute = null;
        if (imageTask != null) {
            this.mNextTask = imageTask;
            this.mImageKey = imageTask.mImageKey;
            this.mTaskAttribute = imageTask.mTaskAttribute;
            this.mPreviousTask = null;
            imageTask.mPreviousTask = this;
        }
    }

    public void cancel() {
        ImageTaskAttribute imageTaskAttribute = this.mTaskAttribute;
        if (imageTaskAttribute != null) {
            imageTaskAttribute.isCanceled = true;
        }
    }

    public abstract void excuteTask();

    public ImageKey getImageKey() {
        return this.mImageKey;
    }

    public ImageTask getNextTask() {
        return this.mNextTask;
    }

    public ImageTask getPreviousTask() {
        return this.mPreviousTask;
    }

    public boolean isCanceled() {
        ImageTaskAttribute imageTaskAttribute = this.mTaskAttribute;
        if (imageTaskAttribute != null) {
            return imageTaskAttribute.isCanceled;
        }
        return true;
    }

    protected abstract void onResult(int i3, Object... objArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset() {
        this.mNextTask = null;
        this.mPreviousTask = null;
        this.mImageKey = null;
        this.mTaskAttribute = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setImageKey(ImageKey imageKey) {
        this.mNextTask = null;
        this.mImageKey = imageKey;
        this.mTaskAttribute = new ImageTaskAttribute();
        this.mPreviousTask = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setImageTask(ImageTask imageTask) {
        this.mNextTask = imageTask;
        this.mImageKey = imageTask.mImageKey;
        this.mTaskAttribute = imageTask.mTaskAttribute;
        this.mPreviousTask = null;
        imageTask.mPreviousTask = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setResult(int i3, Object... objArr) {
        ImageTask imageTask = this.mPreviousTask;
        if (imageTask != null) {
            imageTask.onResult(i3, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageTask(ImageKey imageKey) {
        this.mNextTask = null;
        this.mPreviousTask = null;
        this.mImageKey = null;
        this.mTaskAttribute = null;
        if (imageKey != null) {
            this.mNextTask = null;
            this.mImageKey = imageKey;
            this.mTaskAttribute = new ImageTaskAttribute();
            this.mPreviousTask = null;
        }
    }

    public void recycle() {
    }
}
