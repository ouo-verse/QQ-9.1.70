package com.tencent.qcircle.tavcut.timeline;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.cover.CoverCache;
import com.tencent.qcircle.tavcut.cover.ICoverGenerator;
import com.tencent.qcircle.tavcut.util.FloatUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TimelineCoverGenerator implements ICoverGenerator {
    private static final float SCALE_SIZE = 4.0f;
    public static final String TAG = "TimelineCoverGenerator";
    protected CoverCache mCoverCache;
    protected float mCoverHeight;
    protected ConcurrentHashMap<Long, CoverTask> mCoverTaskMap;
    protected BlockingQueue<CoverTask> mCoverTaskQueue;
    protected float mCoverWidth;
    protected ExecutorService mExecutors;
    protected TAVSourceImageGenerator mImageGenerator;
    protected int mItemCount;
    protected long mItemDurationMs;
    protected float mLastCoverWidth;
    protected volatile boolean mReleased;
    private RenderContextParams mRenderContextParams;
    protected TAVSource mTavSource;
    protected long mTotalDurationMs;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class CoverRunnable implements Runnable {
        public CoverRunnable() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0005 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            CoverTask coverTask;
            Bitmap bitmap;
            Bitmap bitmap2;
            int i3;
            int i16;
            while (true) {
                BlockingQueue<CoverTask> blockingQueue = TimelineCoverGenerator.this.mCoverTaskQueue;
                if (blockingQueue != null && !blockingQueue.isEmpty()) {
                    TimelineCoverGenerator timelineCoverGenerator = TimelineCoverGenerator.this;
                    if (timelineCoverGenerator.mImageGenerator == null || timelineCoverGenerator.mReleased) {
                        break;
                    }
                    try {
                        coverTask = TimelineCoverGenerator.this.mCoverTaskQueue.take();
                        try {
                            Logger.d(TimelineCoverGenerator.TAG, "run: index is " + coverTask.index);
                            Logger.d(TimelineCoverGenerator.TAG, "run: requestTimeMs is " + coverTask.requestTimeMs);
                        } catch (InterruptedException e16) {
                            e = e16;
                            Logger.d(TimelineCoverGenerator.TAG, "run:  CoverTaskQueue.take() InterruptedException");
                            e.printStackTrace();
                            if (coverTask == null) {
                            }
                        }
                    } catch (InterruptedException e17) {
                        e = e17;
                        coverTask = null;
                    }
                    if (coverTask == null) {
                        coverTask.generating = true;
                        try {
                            if (TimelineCoverGenerator.this.mImageGenerator != null) {
                                Logger.d(TimelineCoverGenerator.TAG, "run: start generateThumbnailAtTimeSync");
                                bitmap = TimelineCoverGenerator.this.mImageGenerator.generateThumbnailAtTimeSync(new CMTime(((float) coverTask.startTimeMs) / 1000.0f));
                                try {
                                    Logger.d(TimelineCoverGenerator.TAG, "run: end generateThumbnailAtTimeSync");
                                } catch (Exception e18) {
                                    e = e18;
                                    Logger.d(TimelineCoverGenerator.TAG, "run: generateThumbnailAtTimeSync Exception");
                                    e.printStackTrace();
                                    if (bitmap == null) {
                                    }
                                    if (bitmap2 == null) {
                                    }
                                }
                            } else {
                                bitmap = null;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            bitmap = null;
                        }
                        if (bitmap == null) {
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Matrix matrix = new Matrix();
                            matrix.postScale(0.25f, 0.25f);
                            TimelineCoverGenerator timelineCoverGenerator2 = TimelineCoverGenerator.this;
                            float f16 = timelineCoverGenerator2.mCoverWidth;
                            int i17 = (int) ((width - (f16 * 4.0f)) / 2.0f);
                            float f17 = timelineCoverGenerator2.mCoverHeight;
                            int i18 = (int) ((height - (f17 * 4.0f)) / 2.0f);
                            int i19 = (int) (f16 * 4.0f);
                            int i26 = (int) (f17 * 4.0f);
                            if (i17 <= 0) {
                                i17 = 0;
                                i19 = width;
                            }
                            if (i18 <= 0) {
                                i16 = 0;
                                i3 = height;
                            } else {
                                i3 = i26;
                                i16 = i18;
                            }
                            bitmap2 = Bitmap.createBitmap(bitmap, i17, i16, i19, i3, matrix, false);
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                        } else {
                            bitmap2 = null;
                        }
                        if (bitmap2 == null) {
                            int i27 = coverTask.index;
                            TimelineCoverGenerator timelineCoverGenerator3 = TimelineCoverGenerator.this;
                            if (i27 == timelineCoverGenerator3.mItemCount - 1 && !FloatUtils.isEquals(timelineCoverGenerator3.mLastCoverWidth, timelineCoverGenerator3.mCoverWidth)) {
                                TimelineCoverGenerator timelineCoverGenerator4 = TimelineCoverGenerator.this;
                                Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, (int) (((timelineCoverGenerator4.mLastCoverWidth * 1.0f) / timelineCoverGenerator4.mCoverWidth) * bitmap2.getWidth()), bitmap2.getHeight());
                                if (!bitmap2.isRecycled()) {
                                    bitmap2.recycle();
                                }
                                bitmap2 = createBitmap;
                            }
                            CoverCache coverCache = TimelineCoverGenerator.this.mCoverCache;
                            if (coverCache != null) {
                                coverCache.addCover(coverTask.index, bitmap2);
                            }
                            ConcurrentHashMap<Long, CoverTask> concurrentHashMap = TimelineCoverGenerator.this.mCoverTaskMap;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.remove(Long.valueOf(coverTask.startTimeMs));
                            }
                            CoverCache coverCache2 = TimelineCoverGenerator.this.mCoverCache;
                            if (coverCache2 != null) {
                                int cacheSize = coverCache2.getCacheSize();
                                TimelineCoverGenerator timelineCoverGenerator5 = TimelineCoverGenerator.this;
                                if (cacheSize == timelineCoverGenerator5.mItemCount) {
                                    timelineCoverGenerator5.mImageGenerator.getAssetImageGenerator().release();
                                    TimelineCoverGenerator.this.mImageGenerator = null;
                                }
                            }
                        } else {
                            try {
                                TimelineCoverGenerator.this.mCoverTaskQueue.put(coverTask);
                            } catch (InterruptedException e26) {
                                e26.printStackTrace();
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            ConcurrentHashMap<Long, CoverTask> concurrentHashMap2 = TimelineCoverGenerator.this.mCoverTaskMap;
            if (concurrentHashMap2 != null && concurrentHashMap2.isEmpty()) {
                TimelineCoverGenerator.this.releaseImageGenerator();
                TimelineCoverGenerator.this.releaseExecutors();
            }
            if (TimelineCoverGenerator.this.mReleased) {
                TimelineCoverGenerator.this.realRelease();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class CoverTask implements Comparable<CoverTask> {
        private boolean generating;
        private int index;
        private long requestTimeMs;
        private long startTimeMs;

        public CoverTask(long j3, int i3) {
            this.requestTimeMs = j3;
            long j16 = i3 * TimelineCoverGenerator.this.mItemDurationMs;
            this.startTimeMs = j16;
            this.index = i3;
            ConcurrentHashMap<Long, CoverTask> concurrentHashMap = TimelineCoverGenerator.this.mCoverTaskMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(Long.valueOf(j16), this);
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull CoverTask coverTask) {
            return this.requestTimeMs > coverTask.requestTimeMs ? -1 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realRelease() {
        Logger.d(TAG, "realRelease: ");
        releaseImageGenerator();
        releaseCache();
        releaseQueue();
        releaseExecutors();
    }

    private void releaseCache() {
        Logger.d(TAG, "releaseCache: ");
        CoverCache coverCache = this.mCoverCache;
        if (coverCache != null) {
            coverCache.release();
            this.mCoverCache = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseExecutors() {
        Logger.d(TAG, "releaseExecutors: ");
        ExecutorService executorService = this.mExecutors;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mExecutors = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseImageGenerator() {
        Logger.d(TAG, "releaseImageGenerator: ");
        TAVSourceImageGenerator tAVSourceImageGenerator = this.mImageGenerator;
        if (tAVSourceImageGenerator != null) {
            if (tAVSourceImageGenerator.getAssetImageGenerator() != null) {
                this.mImageGenerator.getAssetImageGenerator().release();
            }
            this.mImageGenerator = null;
        }
    }

    private void releaseQueue() {
        Logger.d(TAG, "releaseQueue: ");
        ConcurrentHashMap<Long, CoverTask> concurrentHashMap = this.mCoverTaskMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.mCoverTaskMap = null;
        }
        BlockingQueue<CoverTask> blockingQueue = this.mCoverTaskQueue;
        if (blockingQueue != null) {
            blockingQueue.clear();
            this.mCoverTaskQueue = null;
        }
    }

    protected CGSize calculateRenderSize() {
        CGSize cGSize = new CGSize(this.mCoverWidth * 4.0f, this.mCoverHeight * 4.0f);
        TAVSource tAVSource = this.mTavSource;
        if (tAVSource != null && tAVSource.getVideoComposition() != null && !FloatUtils.isEquals(this.mCoverWidth, 0.0f) && !FloatUtils.isEquals(this.mCoverHeight, 0.0f)) {
            CGSize m258clone = this.mTavSource.getVideoComposition().getRenderSize().m258clone();
            if (m258clone == null || FloatUtils.isEquals(m258clone.width, 0.0f) || FloatUtils.isEquals(m258clone.height, 0.0f)) {
                if (this.mTavSource.getAsset() != null && this.mTavSource.getAsset().getNaturalSize() != null) {
                    m258clone = this.mTavSource.getAsset().getNaturalSize().m258clone();
                }
            }
            float f16 = m258clone.width / m258clone.height;
            if (f16 > 1.0f) {
                float f17 = this.mCoverHeight * 4.0f;
                m258clone.height = f17;
                m258clone.width = f17 * f16;
            } else {
                float f18 = this.mCoverWidth * 4.0f;
                m258clone.width = f18;
                m258clone.height = f18 / f16;
            }
            return m258clone;
        }
        return cGSize;
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void generateCoverByIndexRange(int i3, int i16) {
        if (this.mCoverTaskQueue == null) {
            Logger.e(TAG, "CoverTaskQueue is null maybe TimelineCoverGenerator was released");
            return;
        }
        for (int i17 = i16; i17 > i3 - 1; i17--) {
            CoverCache coverCache = this.mCoverCache;
            if (coverCache == null || coverCache.getCover(i17) == null) {
                long j3 = i17;
                long j16 = this.mItemDurationMs * j3;
                ConcurrentHashMap<Long, CoverTask> concurrentHashMap = this.mCoverTaskMap;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(j16))) {
                    CoverTask coverTask = this.mCoverTaskMap.get(Long.valueOf(j16));
                    if (!coverTask.generating) {
                        this.mCoverTaskQueue.remove(coverTask);
                        coverTask.requestTimeMs = (System.currentTimeMillis() + i16) - j3;
                        this.mCoverTaskMap.put(Long.valueOf(j16), coverTask);
                        try {
                            this.mCoverTaskQueue.put(coverTask);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                } else {
                    try {
                        this.mCoverTaskQueue.put(new CoverTask((System.currentTimeMillis() + i16) - j3, i17));
                    } catch (InterruptedException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void generateCoverByTimeRange(long j3, long j16) {
        long j17 = this.mItemDurationMs;
        generateCoverByIndexRange((int) (j3 / j17), (int) (j16 / j17));
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void init(TAVSource tAVSource, List<CMTime> list, int i3, int i16) {
    }

    protected void initParams() {
        try {
            this.mTotalDurationMs = this.mTavSource.getAsset().getDuration().getTimeUs() / 1000;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        long j3 = this.mItemDurationMs;
        if (j3 != 0) {
            long j16 = this.mTotalDurationMs;
            if (j16 != 0) {
                float f16 = (((float) (j16 - ((this.mItemCount - 1) * j3))) * 1.0f) / ((float) j3);
                float f17 = this.mCoverWidth;
                float f18 = f16 * f17;
                this.mLastCoverWidth = f18;
                if (f18 > f17) {
                    this.mLastCoverWidth = f17;
                }
                Logger.d(TAG, "initParams: mItemDurationMs is  " + this.mItemDurationMs);
                Logger.d(TAG, "initParams: mItemCount is  " + this.mItemCount);
                Logger.d(TAG, "initParams: mTotalDurationMs is  " + this.mTotalDurationMs);
                Logger.d(TAG, "initParams: mCoverWidth is " + this.mCoverWidth);
                Logger.d(TAG, "initParams: mLastCoverWidth is " + this.mLastCoverWidth);
                TAVSourceImageGenerator tAVSourceImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
                this.mImageGenerator = tAVSourceImageGenerator;
                tAVSourceImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.scaleToFit);
                this.mImageGenerator.getAssetImageGenerator().setRenderContextParams(this.mRenderContextParams);
                this.mCoverTaskMap = new ConcurrentHashMap<>(16);
                this.mCoverTaskQueue = new PriorityBlockingQueue();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mItemCount) {
                        CoverTask coverTask = new CoverTask(r2 - i3, i3);
                        Logger.d(TAG, "initParams: task.index is " + coverTask.index);
                        try {
                            this.mCoverTaskQueue.put(coverTask);
                        } catch (InterruptedException e17) {
                            e17.printStackTrace();
                        }
                        i3++;
                    } else {
                        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
                        this.mExecutors = newSingleThreadExecutor;
                        newSingleThreadExecutor.submit(new CoverRunnable());
                        return;
                    }
                }
            }
        }
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void release() {
        Logger.d(TAG, "release: ");
        this.mReleased = true;
        ExecutorService executorService = this.mExecutors;
        if (executorService != null && !executorService.isShutdown()) {
            this.mExecutors.submit(new CoverRunnable());
        } else {
            releaseQueue();
            releaseCache();
        }
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void setCoverCache(CoverCache coverCache) {
        this.mCoverCache = coverCache;
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void setRenderContextParamas(RenderContextParams renderContextParams) {
        this.mRenderContextParams = renderContextParams;
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void init(TAVSource tAVSource, long j3, int i3, int i16, int i17) {
        this.mTavSource = tAVSource;
        this.mItemDurationMs = j3;
        this.mItemCount = i3;
        this.mCoverWidth = i16;
        this.mCoverHeight = i17;
        initParams();
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void pause() {
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void resume() {
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void generateCoverByIndex(int i3, CMTime cMTime) {
    }
}
