package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.util.FloatUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.common.constants.RenderInfoParamsConst;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVSource;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoThumbVideoGenerator extends BaseVideoThumbGenerator {
    private static final float SCALE_SIZE = 1.0f;
    public static final String TAG = "VideoThumbVideoGenerator";
    protected TAVSourceImageGenerator mImageGenerator;
    private boolean mIsNeedDump;
    private volatile GeneratorRunnable mRunnable;
    private TAVSource mTavSource;
    private BlockingQueue<VideoThumbTask> mVideoThumbTaskQueue = new PriorityBlockingQueue();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class GeneratorRunnable implements Runnable {
        private static final long TIME_OUT_MS = 500;
        private boolean mIsTimeOut = false;
        private boolean mIsPause = false;
        private boolean mIsRelease = false;

        GeneratorRunnable() {
        }

        private boolean checkLoop() {
            if (VideoThumbVideoGenerator.this.mImageGenerator != null && !this.mIsPause && !this.mIsRelease) {
                return true;
            }
            return false;
        }

        private Bitmap getBitmap(CMTime cMTime) {
            Bitmap bitmap;
            Logger.i(VideoThumbVideoGenerator.TAG, "run: start generateThumbnailAtTimeSync");
            try {
                bitmap = VideoThumbVideoGenerator.this.mImageGenerator.generateThumbnailAtTimeSync(cMTime);
            } catch (Throwable th5) {
                if (th5 instanceof OutOfMemoryError) {
                    this.mIsRelease = true;
                    VideoThumbVideoGenerator.this.mGenerateHandler.runnableFailAndReleaseCache();
                }
                Logger.e(VideoThumbVideoGenerator.TAG, "getBitmap", th5);
                th5.printStackTrace();
                bitmap = null;
            }
            Logger.i(VideoThumbVideoGenerator.TAG, "run: end generateThumbnailAtTimeSync");
            return bitmap;
        }

        private void runnableFinish() {
            VideoThumbVideoGenerator.this.mRunnable = null;
            if (this.mIsRelease || this.mIsTimeOut) {
                VideoThumbVideoGenerator.this.releaseImageGenerator();
                VideoThumbVideoGenerator.this.releaseQueue();
            } else if (this.mIsPause) {
                VideoThumbVideoGenerator.this.releaseImageGenerator();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0028, code lost:
        
            r6.mIsTimeOut = true;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            VideoThumbListener videoThumbListener;
            if (!VideoThumbVideoGenerator.this.reInitImageGenerator()) {
                runnableFinish();
                return;
            }
            while (true) {
                if (!checkLoop()) {
                    break;
                }
                try {
                    VideoThumbTask videoThumbTask = (VideoThumbTask) VideoThumbVideoGenerator.this.mVideoThumbTaskQueue.poll(500L, TimeUnit.MILLISECONDS);
                    if (videoThumbTask == null) {
                        break;
                    }
                    Logger.i(VideoThumbVideoGenerator.TAG, "run: startTime is " + videoThumbTask.startTime);
                    Bitmap bitmap = getBitmap(videoThumbTask.startTime);
                    if (bitmap != null && (videoThumbListener = VideoThumbVideoGenerator.this.mVideoThumbListener) != null) {
                        videoThumbListener.onThumbGenerated(null, videoThumbTask.startTime, bitmap);
                    } else {
                        try {
                            VideoThumbVideoGenerator.this.mVideoThumbTaskQueue.put(videoThumbTask);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                } catch (InterruptedException unused) {
                    Logger.e(VideoThumbVideoGenerator.TAG, "time out");
                    this.mIsTimeOut = true;
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

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class ReleaseRunnable implements Runnable {
        ReleaseRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.i(VideoThumbVideoGenerator.TAG, "release success:" + Thread.currentThread().getName());
            VideoThumbVideoGenerator.this.releaseImageGenerator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class VideoThumbTask implements Comparable<VideoThumbTask> {
        private long requestTimeMs;
        private CMTime startTime;

        VideoThumbTask(long j3, CMTime cMTime) {
            this.requestTimeMs = j3;
            this.startTime = cMTime;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull VideoThumbTask videoThumbTask) {
            return (int) (videoThumbTask.requestTimeMs - this.requestTimeMs);
        }
    }

    private CGSize calculateRenderSize() {
        CGSize cGSize = new CGSize(this.mCoverWidth * 1.0f, this.mCoverHeight * 1.0f);
        if (!checkTavSourceIsNull(this.mTavSource) && !checkHeightAndWidth(this.mCoverHeight, this.mCoverWidth)) {
            CGSize m258clone = this.mTavSource.getVideoComposition().getRenderSize().m258clone();
            if (m258clone == null || checkHeightAndWidth(m258clone.height, m258clone.width)) {
                if (checkTavAsset(this.mTavSource)) {
                    return cGSize;
                }
                m258clone = this.mTavSource.getAsset().getNaturalSize().m258clone();
            }
            float f16 = m258clone.width / m258clone.height;
            if (f16 > 1.0f) {
                float f17 = this.mCoverHeight * 1.0f;
                m258clone.height = f17;
                m258clone.width = f17 * f16;
            } else {
                float f18 = this.mCoverWidth * 1.0f;
                m258clone.width = f18;
                m258clone.height = f18 / f16;
            }
            return m258clone;
        }
        return cGSize;
    }

    private boolean checkHeightAndWidth(float f16, float f17) {
        if (!FloatUtils.isEquals(f17, 0.0f) && !FloatUtils.isEquals(0.0f, f16)) {
            return false;
        }
        return true;
    }

    private boolean checkTavAsset(@NonNull TAVSource tAVSource) {
        if (tAVSource.getAsset() != null && tAVSource.getAsset().getNaturalSize() != null) {
            return false;
        }
        return true;
    }

    private boolean checkTavSourceIsNull(TAVSource tAVSource) {
        if (tAVSource != null && tAVSource.getVideoComposition() != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reInitImageGenerator() {
        if (this.mImageGenerator == null) {
            try {
                this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
                RenderContextParams renderContextParams = new RenderContextParams();
                renderContextParams.putParam("video_cover", RenderInfoParamsConst.Params.VIDEO_COVER_PARAM);
                this.mImageGenerator.getAssetImageGenerator().setRenderContextParams(renderContextParams);
                this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
                return true;
            } catch (Throwable th5) {
                if (th5 instanceof OutOfMemoryError) {
                    this.mGenerateHandler.runnableFailAndReleaseCache();
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseImageGenerator() {
        Logger.i(TAG, "releaseImageGenerator:");
        Logger.i(TAG, "releaseImageGenerator:" + Thread.currentThread().getName());
        TAVSourceImageGenerator tAVSourceImageGenerator = this.mImageGenerator;
        if (tAVSourceImageGenerator != null) {
            if (tAVSourceImageGenerator.getAssetImageGenerator() != null) {
                this.mImageGenerator.getAssetImageGenerator().release();
            }
            this.mImageGenerator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseQueue() {
        Logger.i(TAG, "releaseQueue:");
        BlockingQueue<VideoThumbTask> blockingQueue = this.mVideoThumbTaskQueue;
        if (blockingQueue != null) {
            blockingQueue.clear();
        }
    }

    private void startGenerate() {
        if (this.mRunnable != null) {
            Logger.i(TAG, "mRunnable is run");
        } else {
            this.mRunnable = new GeneratorRunnable();
            this.mGenerateHandler.postRunnable(this.mRunnable);
        }
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbGenerator
    public void generateCoverByTime(CMTime cMTime) {
        Logger.i(TAG, "generateCoverByTime:" + cMTime.getTimeUs());
        try {
            this.mVideoThumbTaskQueue.put(new VideoThumbTask(System.currentTimeMillis(), cMTime));
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        startGenerate();
    }

    public void init(TAVSource tAVSource) {
        Logger.i(TAG, "init");
        this.mTavSource = tAVSource;
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
        Logger.i(TAG, "release:");
        if (this.mRunnable != null) {
            this.mRunnable.setRelease(true);
            return;
        }
        Logger.i(TAG, "release threadName:" + Thread.currentThread().getName());
        releaseQueue();
        RunnableHandler runnableHandler = this.mGenerateHandler;
        if (runnableHandler != null) {
            runnableHandler.postRunnable(new ReleaseRunnable());
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
}
