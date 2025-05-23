package com.tencent.mobileqq.kandian.base.image;

import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.BitmapCache;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptLinkedBlockingDeque;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ImageManager implements IImageManager {
    private static ImageManager sIns;
    IBitmapCache mBitmapCache;
    ThreadPoolExecutor mExcutor;
    public static final String TAG_PREFIX = "zimage.";
    public static final String TAG = TAG_PREFIX + ImageManager.class.getSimpleName();
    ConcurrentHashMap<b, RunningJob> mRunningJobs = new ConcurrentHashMap<>();
    CopyOnWriteArrayList<b> mExecutingJobs = new CopyOnWriteArrayList<>();
    AtomicBoolean mIsPaused = new AtomicBoolean(false);
    ConcurrentHashMap<b, RunningJob> mPendingjobs = new ConcurrentHashMap<>();
    private ConcurrentHashMap<b, Boolean> mFinishedPreloadJobs = new ConcurrentHashMap<>();

    ImageManager() {
        if (MobileQQ.sProcessId == 1) {
            try {
                ImageCacheHelper.f98636a.d(Priority.Low);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[ImageManager] e = " + e16);
            }
        }
        this.mBitmapCache = new BitmapCache();
        ThreadPoolParams threadPoolParams = new ThreadPoolParams();
        threadPoolParams.poolThreadName = "image-manager";
        threadPoolParams.corePoolsize = 4;
        threadPoolParams.maxPooolSize = 8;
        threadPoolParams.priority = 3;
        if (RIJImageOptConfig.INSTANCE.isLifoOn()) {
            threadPoolParams.queue = new RIJImageOptLinkedBlockingDeque(128);
        }
        this.mExcutor = (ThreadPoolExecutor) ThreadManagerV2.newFreeThreadPool(threadPoolParams);
    }

    public static ImageManager get() {
        if (sIns == null) {
            synchronized (ImageManager.class) {
                if (sIns == null) {
                    sIns = new ImageManager();
                }
            }
        }
        return sIns;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public synchronized void cancelRequest(b bVar, String str) {
        RunningJob remove = this.mRunningJobs.remove(bVar);
        if (remove != null) {
            remove.cancel();
            this.mExcutor.remove(remove);
        } else {
            RunningJob remove2 = this.mPendingjobs.remove(bVar);
            if (remove2 != null) {
                remove2.cancel();
            }
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public synchronized void clean() {
        if (QLog.isColorLevel()) {
            com.tencent.mobileqq.kandian.base.image.imageloader.c.e(TAG, "clean");
        }
        this.mBitmapCache.clean();
        Iterator<Map.Entry<b, RunningJob>> it = this.mRunningJobs.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel();
        }
        this.mRunningJobs.clear();
    }

    public CopyOnWriteArrayList<b> getExecutingJobs() {
        return this.mExecutingJobs;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public synchronized void loadImage(final b bVar, k52.a aVar) {
        if (bVar != null) {
            if (bVar.f239004a != null) {
                k52.b bitmap = this.mBitmapCache.getBitmap(bVar);
                if (bitmap != null) {
                    if (QLog.isColorLevel()) {
                        com.tencent.mobileqq.kandian.base.image.imageloader.c.e(TAG, "loadImage request:" + bVar + ", cache bitmap exist! callback:" + aVar);
                    }
                    RIJImageOptReport.e(1, bVar);
                    if (aVar != null) {
                        aVar.a(bVar, bitmap.clone());
                    }
                    bitmap.close();
                    RIJImageOptReport.f(6, bVar);
                    return;
                }
                if (bVar.f239008e && this.mFinishedPreloadJobs.containsKey(bVar)) {
                    RIJImageOptReport.f(6, bVar);
                    return;
                }
                RunningJob runningJob = this.mRunningJobs.get(bVar);
                if (runningJob == null && this.mIsPaused.get()) {
                    runningJob = this.mPendingjobs.get(bVar);
                }
                if (runningJob != null) {
                    if (QLog.isColorLevel()) {
                        com.tencent.mobileqq.kandian.base.image.imageloader.c.f(TAG, "loadImage request:" + bVar + " already exist", true);
                    }
                    runningJob.c(aVar);
                    bVar.f239020q = 0;
                    RIJImageOptReport.f(6, bVar);
                } else {
                    final RunningJob runningJob2 = new RunningJob(this, bVar);
                    runningJob2.c(aVar);
                    if (this.mIsPaused.get() && AbsDownloader.getFile(bVar.f239004a.toString()) == null) {
                        this.mPendingjobs.put(bVar, runningJob2);
                        if (QLog.isColorLevel()) {
                            com.tencent.mobileqq.kandian.base.image.imageloader.c.f(TAG, "loadImage request:" + bVar + " add to pending queue", true);
                        }
                    } else {
                        this.mRunningJobs.put(bVar, runningJob2);
                        RIJImageOptReport.f(2, bVar);
                        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.ImageManager.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RIJImageOptReport.f(3, bVar);
                                ImageManager.this.mExcutor.execute(runningJob2);
                            }
                        }, 10, null, true);
                    }
                }
                return;
            }
        }
        RIJImageOptReport.f(6, bVar);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public void pauseDownload() {
        if (this.mIsPaused.get()) {
            return;
        }
        if (QLog.isColorLevel()) {
            com.tencent.mobileqq.kandian.base.image.imageloader.c.f(TAG, "pause", true);
        }
        this.mIsPaused.set(true);
    }

    public void putExecuteJob(b bVar) {
        this.mExecutingJobs.add(bVar);
    }

    public void removeExecuteJob(b bVar) {
        this.mExecutingJobs.remove(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeJob(b bVar) {
        if (bVar.f239008e) {
            this.mFinishedPreloadJobs.put(bVar, Boolean.TRUE);
        }
        this.mRunningJobs.remove(bVar);
        this.mPendingjobs.remove(bVar);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public void resume() {
        if (this.mIsPaused.get()) {
            if (QLog.isColorLevel()) {
                com.tencent.mobileqq.kandian.base.image.imageloader.c.f(TAG, "resume", true);
            }
            this.mIsPaused.set(false);
            synchronized (this) {
                for (Map.Entry<b, RunningJob> entry : this.mPendingjobs.entrySet()) {
                    this.mRunningJobs.put(entry.getKey(), entry.getValue());
                    this.mExcutor.execute(entry.getValue());
                }
                this.mPendingjobs.clear();
            }
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public boolean isLocalFileExist(URL url) {
        return (url == null || AbsDownloader.getFile(url.toString()) == null) ? false : true;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public k52.b getBitmap(b bVar) {
        if (bVar == null) {
            return null;
        }
        return this.mBitmapCache.getBitmap(bVar);
    }
}
