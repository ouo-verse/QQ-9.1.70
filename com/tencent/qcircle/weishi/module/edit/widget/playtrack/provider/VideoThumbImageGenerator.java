package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.coremedia.CMTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoThumbImageGenerator extends BaseVideoThumbGenerator {
    private static final String TAG = "VideoThumbImageGenerator";
    private String mAssetId;
    private volatile ImageRunnable mRunnable;
    private BlockingQueue<ImageThumbTask> mVideoThumbTaskQueue = new PriorityBlockingQueue();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ImageRunnable implements Runnable {
        private boolean mIsPause;
        private boolean mIsRelease;

        ImageRunnable() {
            this.mIsPause = false;
            this.mIsRelease = false;
        }

        private boolean checkLoop() {
            if (!this.mIsPause && !this.mIsRelease && !VideoThumbImageGenerator.this.mVideoThumbTaskQueue.isEmpty()) {
                return true;
            }
            return false;
        }

        private void runnableFinish() {
            VideoThumbImageGenerator.this.mRunnable = null;
            if (this.mIsRelease) {
                VideoThumbImageGenerator.this.releaseQueue();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[EDGE_INSN: B:28:0x0072->B:29:0x0072 BREAK  A[LOOP:0: B:2:0x0003->B:17:0x0003], SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            ImageThumbTask imageThumbTask;
            while (checkLoop()) {
                try {
                    imageThumbTask = (ImageThumbTask) VideoThumbImageGenerator.this.mVideoThumbTaskQueue.take();
                    try {
                        Logger.i(VideoThumbImageGenerator.TAG, "run: startTime is " + imageThumbTask.startTime);
                    } catch (InterruptedException e16) {
                        e = e16;
                        Logger.e(VideoThumbImageGenerator.TAG, TencentLocation.RUN_MODE, e);
                        e.printStackTrace();
                        if (imageThumbTask != null) {
                        }
                    }
                } catch (InterruptedException e17) {
                    e = e17;
                    imageThumbTask = null;
                }
                if (imageThumbTask != null) {
                    break;
                }
                String str = VideoThumbImageGenerator.this.mAssetId;
                VideoThumbImageGenerator videoThumbImageGenerator = VideoThumbImageGenerator.this;
                Bitmap bitmapWithSize = BitmapUtil.getBitmapWithSize(str, (int) videoThumbImageGenerator.mCoverWidth, (int) videoThumbImageGenerator.mCoverHeight, true, true);
                if (bitmapWithSize != null) {
                    VideoThumbListener videoThumbListener = VideoThumbImageGenerator.this.mVideoThumbListener;
                    if (videoThumbListener != null) {
                        videoThumbListener.onThumbGenerated(null, imageThumbTask.startTime, bitmapWithSize);
                    }
                } else {
                    try {
                        VideoThumbImageGenerator.this.mVideoThumbTaskQueue.put(imageThumbTask);
                    } catch (InterruptedException e18) {
                        e18.printStackTrace();
                    }
                }
            }
            runnableFinish();
        }

        public void setPause(boolean z16) {
            this.mIsPause = z16;
        }

        public void setRelease(boolean z16) {
            this.mIsRelease = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ImageThumbTask implements Comparable<ImageThumbTask> {
        private long requestTimeMs;
        private CMTime startTime;

        ImageThumbTask(long j3, CMTime cMTime) {
            this.requestTimeMs = j3;
            this.startTime = cMTime;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull ImageThumbTask imageThumbTask) {
            return (int) (this.requestTimeMs - imageThumbTask.requestTimeMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseQueue() {
        Logger.i(TAG, "releaseQueue:");
        BlockingQueue<ImageThumbTask> blockingQueue = this.mVideoThumbTaskQueue;
        if (blockingQueue != null) {
            blockingQueue.clear();
        }
    }

    private void startGenerate() {
        if (this.mRunnable != null) {
            Logger.i(TAG, "mRunnable is run");
        } else {
            this.mRunnable = new ImageRunnable();
            this.mGenerateHandler.postRunnable(this.mRunnable);
        }
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbGenerator
    public void generateCoverByTime(CMTime cMTime) {
        Logger.i(TAG, "generateCoverByTime:" + cMTime.getTimeUs());
        try {
            this.mVideoThumbTaskQueue.put(new ImageThumbTask(System.currentTimeMillis(), cMTime));
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        startGenerate();
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbGenerator
    public void pause() {
        Logger.i(TAG, "pause:");
        if (this.mRunnable == null) {
            return;
        }
        this.mRunnable.setPause(true);
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbGenerator
    public void release() {
        if (this.mRunnable != null) {
            this.mRunnable.setRelease(true);
        } else {
            releaseQueue();
        }
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbGenerator
    public void resume() {
        Logger.i(TAG, "resume:");
        if (this.mVideoThumbTaskQueue.isEmpty()) {
            return;
        }
        startGenerate();
    }

    public void setAssetId(String str) {
        this.mAssetId = str;
    }
}
