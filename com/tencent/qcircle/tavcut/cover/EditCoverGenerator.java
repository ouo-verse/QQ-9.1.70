package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
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
public class EditCoverGenerator implements ICoverGenerator {
    private static final float SCALE_SIZE = 1.0f;
    public static final String TAG = "EditCoverGenerator";
    private CoverCache mCoverCache;
    private float mCoverHeight;
    private ConcurrentHashMap<Integer, CoverTask> mCoverTaskMap;
    private BlockingQueue<CoverTask> mCoverTaskQueue;
    private float mCoverWidth;
    private ExecutorService mExecutors;
    private List<CMTime> mGenerateTimeList;
    private TAVSourceImageGenerator mImageGenerator;
    private volatile boolean mPaused;
    private volatile boolean mReleased;
    private TAVSource mTavSource;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class CoverRunnable implements Runnable {
        CoverRunnable() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0080 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0111 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0003 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            CoverTask coverTask;
            Bitmap bitmap;
            int i3;
            int i16;
            int i17;
            int i18;
            while (true) {
                z16 = true;
                if (EditCoverGenerator.this.mCoverTaskQueue == null || EditCoverGenerator.this.mCoverTaskQueue.isEmpty() || EditCoverGenerator.this.mImageGenerator == null || EditCoverGenerator.this.mPaused || EditCoverGenerator.this.mReleased) {
                    break;
                }
                Bitmap bitmap2 = null;
                try {
                    coverTask = (CoverTask) EditCoverGenerator.this.mCoverTaskQueue.take();
                    try {
                        Logger.d(EditCoverGenerator.TAG, "run: index is " + coverTask.index);
                        Logger.d(EditCoverGenerator.TAG, "run: requestTimeMs is " + coverTask.requestTimeMs);
                    } catch (InterruptedException e16) {
                        e = e16;
                        Logger.d(EditCoverGenerator.TAG, "run:  CoverTaskQueue.take() InterruptedException");
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
                        if (EditCoverGenerator.this.mImageGenerator != null) {
                            Logger.d(EditCoverGenerator.TAG, "run: start generateThumbnailAtTimeSync");
                            bitmap = EditCoverGenerator.this.mImageGenerator.generateThumbnailAtTimeSync(coverTask.startTime);
                            try {
                                Logger.d(EditCoverGenerator.TAG, "run: end generateThumbnailAtTimeSync");
                            } catch (Exception e18) {
                                e = e18;
                                Logger.d(EditCoverGenerator.TAG, "run: generateThumbnailAtTimeSync Exception");
                                e.printStackTrace();
                                if (bitmap != null) {
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
                    if (bitmap != null) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        Matrix matrix = new Matrix();
                        matrix.postScale(1.0f, 1.0f);
                        int i19 = (int) ((width - (EditCoverGenerator.this.mCoverWidth * 1.0f)) / 2.0f);
                        int i26 = (int) ((height - (EditCoverGenerator.this.mCoverHeight * 1.0f)) / 2.0f);
                        int i27 = (int) (EditCoverGenerator.this.mCoverWidth * 1.0f);
                        int i28 = (int) (EditCoverGenerator.this.mCoverHeight * 1.0f);
                        if (i19 <= 0) {
                            i16 = width;
                            i3 = 0;
                        } else {
                            i3 = i19;
                            i16 = i27;
                        }
                        if (i26 <= 0) {
                            i18 = 0;
                            i17 = height;
                        } else {
                            i17 = i28;
                            i18 = i26;
                        }
                        bitmap2 = Bitmap.createBitmap(bitmap, i3, i18, i16, i17, matrix, false);
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                    if (bitmap2 == null) {
                        if (EditCoverGenerator.this.mCoverCache != null) {
                            EditCoverGenerator.this.mCoverCache.addCover(coverTask.index, bitmap2);
                        }
                        if (EditCoverGenerator.this.mCoverTaskMap != null) {
                            EditCoverGenerator.this.mCoverTaskMap.remove(Integer.valueOf(coverTask.index));
                        }
                    } else {
                        try {
                            EditCoverGenerator.this.mCoverTaskQueue.put(coverTask);
                        } catch (InterruptedException e26) {
                            e26.printStackTrace();
                        }
                    }
                }
            }
            if (EditCoverGenerator.this.mReleased) {
                EditCoverGenerator.this.realRelease();
                return;
            }
            if ((EditCoverGenerator.this.mCoverTaskMap == null || !EditCoverGenerator.this.mCoverTaskMap.isEmpty()) && !EditCoverGenerator.this.mPaused) {
                z16 = false;
            }
            if (z16) {
                EditCoverGenerator.this.releaseImageGenerator();
                EditCoverGenerator.this.releaseExecutors();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class CoverTask implements Comparable<CoverTask> {
        private boolean generating;
        private int index;
        private long requestTimeMs;
        private CMTime startTime;

        CoverTask(long j3, CMTime cMTime, int i3) {
            this.requestTimeMs = j3;
            this.startTime = cMTime;
            this.index = i3;
            EditCoverGenerator.this.mCoverTaskMap.put(Integer.valueOf(this.index), this);
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull CoverTask coverTask) {
            return (int) (this.requestTimeMs - coverTask.requestTimeMs);
        }
    }

    private CGSize calculateRenderSize() {
        CGSize cGSize = new CGSize(this.mCoverWidth * 1.0f, this.mCoverHeight * 1.0f);
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

    private void initParams() {
        List<CMTime> list = this.mGenerateTimeList;
        if (list != null && !list.isEmpty()) {
            this.mPaused = false;
            Logger.d(TAG, "initParams: generateTimeList is  " + this.mGenerateTimeList);
            TAVSourceImageGenerator tAVSourceImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
            this.mImageGenerator = tAVSourceImageGenerator;
            tAVSourceImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFit);
            this.mCoverTaskMap = new ConcurrentHashMap<>(16);
            this.mCoverTaskQueue = new PriorityBlockingQueue();
            for (int i3 = 0; i3 < this.mGenerateTimeList.size(); i3++) {
                CMTime cMTime = this.mGenerateTimeList.get(i3);
                if (cMTime != null) {
                    try {
                        this.mCoverTaskQueue.put(new CoverTask(System.currentTimeMillis() + i3, cMTime, i3));
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
            this.mExecutors = newSingleThreadExecutor;
            newSingleThreadExecutor.submit(new CoverRunnable());
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
        ConcurrentHashMap<Integer, CoverTask> concurrentHashMap = this.mCoverTaskMap;
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

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void generateCoverByIndex(int i3, CMTime cMTime) {
        ConcurrentHashMap<Integer, CoverTask> concurrentHashMap = this.mCoverTaskMap;
        if (concurrentHashMap == null) {
            return;
        }
        if (concurrentHashMap.containsKey(Integer.valueOf(i3)) && !this.mCoverTaskMap.get(Integer.valueOf(i3)).generating) {
            this.mCoverTaskMap.get(Integer.valueOf(i3)).startTime = cMTime;
            return;
        }
        CoverTask coverTask = new CoverTask(System.currentTimeMillis(), cMTime, i3);
        this.mCoverTaskMap.put(Integer.valueOf(i3), coverTask);
        try {
            this.mCoverTaskQueue.put(coverTask);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void init(TAVSource tAVSource, long j3, int i3, int i16, int i17) {
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void pause() {
        ConcurrentHashMap<Integer, CoverTask> concurrentHashMap = this.mCoverTaskMap;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            Logger.d(TAG, "pause: ");
            this.mPaused = true;
            ExecutorService executorService = this.mExecutors;
            if (executorService != null && !executorService.isShutdown()) {
                this.mExecutors.submit(new CoverRunnable());
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
    public void resume() {
        ConcurrentHashMap<Integer, CoverTask> concurrentHashMap = this.mCoverTaskMap;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            this.mPaused = false;
            Logger.d(TAG, "resume: ");
            if (this.mImageGenerator == null) {
                TAVSourceImageGenerator tAVSourceImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
                this.mImageGenerator = tAVSourceImageGenerator;
                tAVSourceImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.scaleToFit);
            }
            if (this.mExecutors == null) {
                this.mExecutors = ProxyExecutors.newSingleThreadExecutor();
            }
            this.mExecutors.submit(new CoverRunnable());
        }
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void setCoverCache(CoverCache coverCache) {
        this.mCoverCache = coverCache;
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void init(TAVSource tAVSource, List<CMTime> list, int i3, int i16) {
        this.mTavSource = tAVSource;
        this.mGenerateTimeList = list;
        this.mCoverWidth = i3;
        this.mCoverHeight = i16;
        initParams();
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void setRenderContextParamas(RenderContextParams renderContextParams) {
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void generateCoverByIndexRange(int i3, int i16) {
    }

    @Override // com.tencent.qcircle.tavcut.cover.ICoverGenerator
    public void generateCoverByTimeRange(long j3, long j16) {
    }
}
