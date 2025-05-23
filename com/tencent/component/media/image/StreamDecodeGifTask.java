package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StreamDecodeGifTask extends DecodeImageTask {
    private long beginTime;
    ThreadPoolExecutor executorService;
    boolean isFirstCallback;
    private volatile int mBaseImageCount;
    private volatile int mControlLimitTimes;
    private volatile int mControlTimes;
    DecodeStreamTask mDecodetask;
    Future<?> mEndRes;
    EndCloseStreamTask mEndTask;
    private volatile boolean mNeedControl;
    Future<?> mProgressRes;
    protected List<Runnable> mResult;
    private StreamDecodeGifTask next;
    protected static ConcurrentHashMap<String, NewGifDrawable> mGifDrawableRecord = new ConcurrentHashMap<>();
    private static StreamDecodeGifTask sPool = null;
    private static final Object sPoolSync = new Object();
    private static int mObjectPoolSize = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class DecodeStreamTask implements Runnable {
        private ImageKey key;
        String path;
        String url;

        public DecodeStreamTask(ImageKey imageKey, String str, String str2) {
            this.key = imageKey;
            this.url = str;
            this.path = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!StreamDecodeGifTask.this.isCanceled()) {
                    StreamDecodeGifTask.this.decoding(this.key, this.url, this.path);
                }
            } catch (Throwable th5) {
                ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", "DecodeStreamTask error : " + th5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class EndCloseStreamTask implements Runnable {
        String filePath;
        private ImageKey key;
        String url;

        public EndCloseStreamTask(ImageKey imageKey, String str, String str2) {
            this.key = imageKey;
            this.url = str;
            this.filePath = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageLoader.Options options;
            if (StreamDecodeGifTask.this.isCanceled()) {
                return;
            }
            try {
                NewGifDrawable newGifDrawable = (NewGifDrawable) ImageManager.getInstance().getDrawbleFromCache(this.key);
                if (newGifDrawable != null) {
                    ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", " isEndDownload hashcode:" + this.key.hashCodeEx() + " filePath:" + this.filePath + " url:" + this.url);
                    ImageKey imageKey = this.key;
                    if (imageKey != null && (options = imageKey.options) != null) {
                        ImageProcessor imageProcessor = options.extraProcessor;
                        if (imageProcessor instanceof NewGifDrawableSpecifiedRegionProcessor) {
                            newGifDrawable = (NewGifDrawable) imageProcessor.doProcess(newGifDrawable);
                        }
                    }
                    newGifDrawable.isEndDownload();
                    newGifDrawable.changeFile(this.filePath);
                    ImageManager imageManager = ImageManager.getInstance();
                    ImageKey imageKey2 = this.key;
                    imageManager.putDrawableInMemoryCache(imageKey2, imageKey2.hashCodeEx(), (Image) null, newGifDrawable, this.key.options);
                    StreamDecodeGifTask streamDecodeGifTask = StreamDecodeGifTask.this;
                    ImageKey imageKey3 = this.key;
                    streamDecodeGifTask.setResult(8, newGifDrawable, null, imageKey3.urlKey, Integer.valueOf(imageKey3.hashCodeEx()), null, newGifDrawable);
                    ImageManagerEnv.getLogger().d("StreamDecodeGifTask-performance", "isEndDownload hashcode:" + this.key.hashCodeEx() + "\ncost time:" + (System.currentTimeMillis() - StreamDecodeGifTask.this.beginTime) + "\nwidth:" + newGifDrawable.getsWidth() + " height:" + newGifDrawable.getsHeight() + "\nframe count:" + newGifDrawable.getNumberOfFrames() + "\nlength:" + newGifDrawable.getAllocationByteCount() + "\nnetworkstate:" + ImageManagerEnv.g().getNetWorkState() + "\ncontrolsTime:" + StreamDecodeGifTask.this.mControlLimitTimes + "\nurl:" + this.url);
                    if (StreamDecodeGifTask.this.beginTime != 0) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        int currentTimeMillis = (int) (System.currentTimeMillis() - StreamDecodeGifTask.this.beginTime);
                        if (currentTimeMillis > 0) {
                            hashMap.put("g_costTime", String.valueOf(currentTimeMillis));
                            hashMap.put("g_width", String.valueOf(newGifDrawable.getsWidth()));
                            hashMap.put("g_height", String.valueOf(newGifDrawable.getsHeight()));
                            hashMap.put("g_frameCount", String.valueOf(newGifDrawable.getNumberOfFrames()));
                            hashMap.put("g_size", String.valueOf(newGifDrawable.getAllocationByteCount()));
                            hashMap.put("g_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
                            hashMap.put("g_controlsTime", String.valueOf(StreamDecodeGifTask.this.mControlLimitTimes));
                            ImageManagerEnv.g().reportImageTimeCostMTA(ImageManagerEnv.QZONE_GIF_PLAYING_REPORT, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "g_costTime", currentTimeMillis);
                            ImageManagerEnv.g().reportImageTimeCostMTA(ImageManagerEnv.QZONE_GIF_PLAYING_REPORT, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "g_frameCount", newGifDrawable.getNumberOfFrames());
                            ImageManagerEnv.g().reportImageTimeCostMTA(ImageManagerEnv.QZONE_GIF_PLAYING_REPORT, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "g_size", (int) newGifDrawable.getAllocationByteCount());
                            ImageManagerEnv.g().reportImageTimeCostMTA(ImageManagerEnv.QZONE_GIF_PLAYING_REPORT, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "g_controlsTime", StreamDecodeGifTask.this.mControlLimitTimes);
                            ImageManagerEnv.g().statisticCollectorReport(ImageManagerEnv.QZONE_GIF_PLAYING_REPORT, hashMap);
                            return;
                        }
                        return;
                    }
                    return;
                }
                StreamDecodeGifTask.this.startDecodeTask();
            } catch (Throwable th5) {
                ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", "EndCloseStreamTask error :" + th5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StreamDecodeGifTask(ImageTask imageTask) {
        super(imageTask);
        this.mResult = new ArrayList();
        this.isFirstCallback = true;
        this.mNeedControl = false;
        this.mControlTimes = 2;
        this.mControlLimitTimes = 3;
        this.mBaseImageCount = 1;
        this.beginTime = 0L;
        this.next = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decoding(ImageKey imageKey, String str, String str2) {
        ImageLoader.Options options;
        ImageProcessor imageProcessor;
        NewGifDrawable newGifDrawable = (NewGifDrawable) ImageManager.getInstance().getDrawbleFromCache(imageKey);
        if (newGifDrawable == null) {
            try {
                NewGifDecoder.Options options2 = new NewGifDecoder.Options();
                ImageLoader.Options options3 = imageKey.options;
                options2.inPreferHeight = options3.clipHeight;
                options2.inPreferWidth = options3.clipWidth;
                NewGifDrawable newGifDrawable2 = new NewGifDrawable(str2, 4, options2, imageKey.hashCodeEx());
                try {
                    newGifDrawable2.setUrl(imageKey.url);
                    newGifDrawable = newGifDrawable2;
                } catch (IOException e16) {
                    e = e16;
                    newGifDrawable = newGifDrawable2;
                    e.printStackTrace();
                    this.mBaseImageCount = newGifDrawable.getImageCount();
                    ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", "RESULT_ON_STREAM_APPLY_IMAGE newFile count:" + this.mBaseImageCount + " hashcode:" + imageKey.hashCodeEx() + " url:" + str);
                    setResult(15, newGifDrawable);
                    this.beginTime = System.currentTimeMillis();
                    ImageManagerEnv.getLogger().d("StreamDecodeGifTask-performance", "First time:" + System.currentTimeMillis() + " hashcode:" + imageKey.hashCodeEx() + " url:" + str);
                    if (imageKey != null) {
                        imageProcessor = options.extraProcessor;
                        if (imageProcessor instanceof NewGifDrawableSpecifiedRegionProcessor) {
                        }
                    }
                    ImageManager.getInstance().putDrawableInMemoryCache(imageKey, imageKey.hashCodeEx(), (Image) null, newGifDrawable, imageKey.options);
                }
            } catch (IOException e17) {
                e = e17;
            }
            this.mBaseImageCount = newGifDrawable.getImageCount();
            ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", "RESULT_ON_STREAM_APPLY_IMAGE newFile count:" + this.mBaseImageCount + " hashcode:" + imageKey.hashCodeEx() + " url:" + str);
            setResult(15, newGifDrawable);
            this.beginTime = System.currentTimeMillis();
            ImageManagerEnv.getLogger().d("StreamDecodeGifTask-performance", "First time:" + System.currentTimeMillis() + " hashcode:" + imageKey.hashCodeEx() + " url:" + str);
        } else if (this.mControlTimes != 0) {
            this.mControlTimes--;
        } else {
            newGifDrawable.updateFile(str2);
            if (newGifDrawable.getImageCount() > this.mBaseImageCount) {
                this.mControlTimes = this.mControlLimitTimes;
                ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", "updateFile mControlLimitTimes:" + this.mControlLimitTimes + " hashcode:" + imageKey.hashCodeEx() + " url:" + str);
            } else {
                this.mControlTimes = this.mControlLimitTimes;
                this.mControlLimitTimes *= 2;
                this.mControlTimes = this.mControlLimitTimes - this.mControlTimes;
            }
        }
        if (imageKey != null && (options = imageKey.options) != null) {
            imageProcessor = options.extraProcessor;
            if (imageProcessor instanceof NewGifDrawableSpecifiedRegionProcessor) {
                newGifDrawable = (NewGifDrawable) imageProcessor.doProcess(newGifDrawable);
            }
        }
        ImageManager.getInstance().putDrawableInMemoryCache(imageKey, imageKey.hashCodeEx(), (Image) null, newGifDrawable, imageKey.options);
    }

    public static StreamDecodeGifTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                StreamDecodeGifTask streamDecodeGifTask = sPool;
                if (streamDecodeGifTask != null) {
                    sPool = streamDecodeGifTask.next;
                    streamDecodeGifTask.next = null;
                    mObjectPoolSize--;
                    streamDecodeGifTask.setImageTask(imageTask);
                    return streamDecodeGifTask;
                }
            }
        }
        return new StreamDecodeGifTask(imageTask);
    }

    @Override // com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        this.executorService = new BaseThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        super.excuteTask();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
    public void onResult(int i3, Object... objArr) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 14) {
                    super.setResult(i3, objArr);
                    return;
                }
                String str = (String) objArr[0];
                String str2 = (String) objArr[1];
                if (!this.executorService.isShutdown()) {
                    if (this.executorService.getQueue().contains(this.mDecodetask)) {
                        ImageManagerEnv.getLogger().d("StreamDecodeGifTask", "onResult RESULT_ON_STREAM_PROGRESS | contains | hashcode:" + this.mImageKey.hashCodeEx());
                        return;
                    }
                    DecodeStreamTask decodeStreamTask = new DecodeStreamTask(this.mImageKey, str, str2);
                    this.mDecodetask = decodeStreamTask;
                    this.mProgressRes = this.executorService.submit(decodeStreamTask);
                    return;
                }
                return;
            }
            if (this.isFirstCallback) {
                ImageTaskBuilder.stampMap2.put(this.mImageKey.url, Long.valueOf(System.currentTimeMillis()));
                this.isFirstCallback = false;
            }
            super.setResult(i3, objArr);
            return;
        }
        String str3 = (String) objArr[0];
        String str4 = this.mImageKey.filePath;
        if (!this.executorService.isShutdown()) {
            if (this.executorService.getQueue().contains(this.mEndTask)) {
                ImageManagerEnv.getLogger().d("StreamDecodeGifTask", "onResult RESULT_ON_DONWNLOAD_SUCCEED contains | hashcode:" + this.mImageKey.hashCodeEx());
                return;
            }
            EndCloseStreamTask endCloseStreamTask = new EndCloseStreamTask(this.mImageKey, str3, str4);
            this.mEndTask = endCloseStreamTask;
            this.mEndRes = this.executorService.submit(endCloseStreamTask);
        }
        this.executorService.shutdown();
    }

    @Override // com.tencent.component.media.image.DecodeImageTask, com.tencent.component.media.image.ImageTask
    public void recycle() {
        if (!ImageTask.needRecycle) {
            return;
        }
        reset();
        ThreadPoolExecutor threadPoolExecutor = this.executorService;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            ImageManagerEnv.getLogger().d("StreamDecodeGifTask", "executorService shutdown");
            this.executorService.shutdown();
        }
        this.mDecodetask = null;
        this.mEndTask = null;
        synchronized (sPoolSync) {
            int i3 = mObjectPoolSize;
            if (i3 < 50) {
                this.next = sPool;
                sPool = this;
                mObjectPoolSize = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeRecord(String str) {
        DecodeStreamTask decodeStreamTask = this.mDecodetask;
        if (decodeStreamTask != null) {
            boolean remove = this.executorService.remove(decodeStreamTask);
            ImageManagerEnv.getLogger().d("StreamDecodeGifTask", "mDecodetask remove:" + remove);
        }
        Future<?> future = this.mProgressRes;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            } catch (ExecutionException e17) {
                e17.printStackTrace();
            }
        }
        EndCloseStreamTask endCloseStreamTask = this.mEndTask;
        if (endCloseStreamTask != null) {
            boolean remove2 = this.executorService.remove(endCloseStreamTask);
            ImageManagerEnv.getLogger().d("kaedelin", "mEndTask remove:" + remove2);
        }
        Future<?> future2 = this.mEndRes;
        if (future2 != null) {
            try {
                future2.get();
            } catch (InterruptedException e18) {
                e18.printStackTrace();
            } catch (ExecutionException e19) {
                e19.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StreamDecodeGifTask(ImageKey imageKey) {
        super(imageKey);
        this.mResult = new ArrayList();
        this.isFirstCallback = true;
        this.mNeedControl = false;
        this.mControlTimes = 2;
        this.mControlLimitTimes = 3;
        this.mBaseImageCount = 1;
        this.beginTime = 0L;
        this.next = null;
    }
}
