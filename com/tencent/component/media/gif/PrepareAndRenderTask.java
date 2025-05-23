package com.tencent.component.media.gif;

import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class PrepareAndRenderTask extends RenderTask {
    private static final String TAG = "PrepareAndRenderTask";
    private Semaphore canPrepareCounts;
    private Semaphore canRenderCounts;
    private long invalidationDelay;
    private ScheduledThreadPoolExecutor mExecutor;
    private Runnable mRenderTask;
    ScheduledFuture<?> mSchedule;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrepareAndRenderTask(NewGifDrawable newGifDrawable) {
        super(newGifDrawable);
        this.invalidationDelay = 0L;
        this.canRenderCounts = new Semaphore(0);
        this.canPrepareCounts = new Semaphore(1);
        this.mRenderTask = new Runnable() { // from class: com.tencent.component.media.gif.PrepareAndRenderTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (!PrepareAndRenderTask.this.canRenderCounts.tryAcquire()) {
                    ImageManagerEnv.getLogger().w(PrepareAndRenderTask.TAG, "unRender false:no data to render,just return");
                    return;
                }
                NewGifDrawable newGifDrawable2 = PrepareAndRenderTask.this.mGifDrawable;
                newGifDrawable2.mIsRenderingTriggeredOnDraw = true;
                NewGifDecoder.GifFrame doRender = newGifDrawable2.mGifDecoder.doRender(newGifDrawable2.mBuffer);
                PrepareAndRenderTask prepareAndRenderTask = PrepareAndRenderTask.this;
                prepareAndRenderTask.mGifDrawable.mBuffer = doRender.image;
                prepareAndRenderTask.invalidationDelay = doRender.delay;
                PrepareAndRenderTask prepareAndRenderTask2 = PrepareAndRenderTask.this;
                prepareAndRenderTask2.mCurrentIndex = (prepareAndRenderTask2.mCurrentIndex + 1) % prepareAndRenderTask2.mGifDrawable.getNumberOfFrames();
                PrepareAndRenderTask.this.canPrepareCounts.release();
                if (PrepareAndRenderTask.this.invalidationDelay >= 0) {
                    NewGifDrawable newGifDrawable3 = PrepareAndRenderTask.this.mGifDrawable;
                    newGifDrawable3.mNextFrameRenderTime = 0L;
                    if (!newGifDrawable3.mListeners.isEmpty() && PrepareAndRenderTask.this.mGifDrawable.getCurrentFrameIndex() == PrepareAndRenderTask.this.mGifDrawable.getNumberOfFrames() - 1) {
                        PrepareAndRenderTask prepareAndRenderTask3 = PrepareAndRenderTask.this;
                        NewGifDrawable newGifDrawable4 = prepareAndRenderTask3.mGifDrawable;
                        newGifDrawable4.scheduleSelf(prepareAndRenderTask3.mNotifyListenersTask, newGifDrawable4.mNextFrameRenderTime);
                    }
                } else {
                    NewGifDrawable newGifDrawable5 = PrepareAndRenderTask.this.mGifDrawable;
                    newGifDrawable5.mNextFrameRenderTime = Long.MIN_VALUE;
                    newGifDrawable5.mIsRunning = false;
                    ImageManagerEnv.getLogger().w(PrepareAndRenderTask.TAG, "decode error: invalidationDelay=" + PrepareAndRenderTask.this.invalidationDelay);
                }
                if (PrepareAndRenderTask.this.mGifDrawable.isVisible() && !PrepareAndRenderTask.this.mGifDrawable.mInvalidationHandler.hasMessages(0) && PrepareAndRenderTask.this.mGifDrawable.getCallback() != null) {
                    PrepareAndRenderTask.this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                }
            }
        };
        this.mExecutor = newGifDrawable.mExecutor;
    }

    @Override // com.tencent.component.media.gif.RenderTask, com.tencent.component.media.gif.SafeRunnable
    public synchronized void doWork() {
        if (!this.canPrepareCounts.tryAcquire()) {
            ImageManagerEnv.getLogger().w(TAG, "unRender true,doRender");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mGifDrawable.mGifDecoder.prepareData();
        long currentTimeMillis2 = this.invalidationDelay - (System.currentTimeMillis() - currentTimeMillis);
        this.canRenderCounts.release();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.mExecutor;
        Runnable runnable = this.mRenderTask;
        if (currentTimeMillis2 <= 0) {
            currentTimeMillis2 = 0;
        }
        this.mSchedule = scheduledThreadPoolExecutor.schedule(runnable, currentTimeMillis2, TimeUnit.MILLISECONDS);
    }

    @Override // com.tencent.component.media.gif.RenderTask
    public long getFrameDelay() {
        return this.invalidationDelay;
    }

    @Override // com.tencent.component.media.gif.RenderTask
    public void waitFinish() {
        try {
            ImageManagerEnv.getLogger().w(TAG, "wait finish " + hashCode());
            ScheduledFuture<?> scheduledFuture = this.mSchedule;
            if (scheduledFuture != null) {
                scheduledFuture.get();
            }
        } catch (InterruptedException e16) {
            ImageManagerEnv.getLogger().w(TAG, "catch an exception: " + Log.getStackTraceString(e16));
        } catch (ExecutionException e17) {
            ImageManagerEnv.getLogger().w(TAG, "catch an exception: " + Log.getStackTraceString(e17));
        }
    }
}
