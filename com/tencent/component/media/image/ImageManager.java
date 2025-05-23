package com.tencent.component.media.image;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.component.media.IDownloader;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.IBitmapFactory;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.PoolParams;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.NinePatchRefDrawable;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.photogif.NewAnimationDrawable;
import com.tencent.component.media.photogif.PhotoGifDrawable;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.LruCache;
import com.tencent.component.media.utils.QZoneImageDecodeUtils;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageManager {
    private static final int DRAWABLE_CACHE_LOG_SIZE = 1048576;
    public static final byte FLAG_DOWNLOAD_ONLY = 3;
    public static final byte FLAG_GET_FROM_MEMORY = 0;
    public static final byte FLAG_GET_FROM_MEMORY_LOCAL = 1;
    public static final byte FLAG_GET_FROM_MEMORY_LOCAL_NETWORK = 2;
    public static final String IMAGE_DIR_NAME_NOCACHE = "nocache";
    public static final String IMAGE_DIR_NAME_SR = "image_sr";
    public static final String IMAGE_DIR_NAME_V1 = "image";
    public static final String IMAGE_DIR_NAME_V2 = "imageV2";
    private static final int IMAGE_HIT = 16;
    private static final int LOW_SIZE = 5242880;
    private static final String LRU_FILE_NAME = "imagelru.usetime";
    private static final int MIN_CACHE_SIZE = 8388608;
    private static final int MSG_CANCEL = 1;
    private static final int MSG_GET_NULL = 0;
    private static final int MSG_IMAGE_TASK_TRACER = 2;
    public static final String TAG = "ImageManager";
    public static volatile boolean hasScrolled = false;
    public static volatile boolean isInFriendFeed = false;
    private static boolean isMainProcess = true;
    private static final int localPhotoProcessCacheSize = 524288;
    private static volatile ImageManager mInstance = null;
    private static final int mainProcessCacheSize = 262144;
    private static final float remainSizeFactor = 0.8f;
    private static String sCachePath4SuperResolution = null;
    public static boolean sCloseNativeAndCache = false;
    public static final long timeInterval = 60000;
    private Looper dispatcherLoop;
    private int imageMemCacheSize;
    IBitmapFactory mBitmapFactory;
    ByteArrayPool mByteArrayPool;
    private Context mContext;
    private IDecoder mDecoder;
    private static final Object LOCK_mInstance = new Object();
    private static final Object LOCK_mImageGetNullOrCancelHandler = new Object();
    private static final Object LOCK_CacheMap = new Object();
    private static final AtomicInteger threadCount = new AtomicInteger(1);
    private static HashMap<String, Integer> mDecodeExceptionMap = new HashMap<>();
    private static int maxDecodeFailCount = -1;
    private static String mCachePath = null;
    private static String storeRootPath = "";
    private static HashMap<String, String> mSDCardName2PathMap = new HashMap<>();
    private static volatile boolean mHasLoadSDCardName = false;
    private static String maxAvailableSizePath = "";
    private static long maxAvailableSize = 0;
    private static Runnable getAllSDCardInfoRunnable = new Runnable() { // from class: com.tencent.component.media.image.ImageManager.8
        @Override // java.lang.Runnable
        public void run() {
            synchronized (ImageManager.mSDCardName2PathMap) {
                ImageManager.mSDCardName2PathMap.clear();
                String unused = ImageManager.maxAvailableSizePath = "";
                long unused2 = ImageManager.maxAvailableSize = 0L;
                ImageManager.updateStorage("/etc/vold.fstab");
                ImageManager.updateStorage("/etc/internal_sd.fstab");
                ImageManager.updateStorage("/etc/external_sd.fstab");
                for (String str : ImageManager.mSDCardName2PathMap.values()) {
                    try {
                        File file = new File(str);
                        if (file.exists() && file.canWrite() && ImageManager.isStorageReallyCanwrite(str)) {
                            StatFs statFs = new StatFs(str);
                            long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
                            if (availableBlocks > 0 && ImageManager.maxAvailableSize < availableBlocks) {
                                long unused3 = ImageManager.maxAvailableSize = availableBlocks;
                                String unused4 = ImageManager.maxAvailableSizePath = str;
                            }
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
            String unused5 = ImageManager.mCachePath = null;
            ImageManager.getCachePath(ImageManagerEnv.getAppContext());
        }
    };
    private static HashMap<String, Boolean> isStorageReallyCanwriteMap = new HashMap<>();
    private static boolean mIsRegisterSdcardReceiver = false;
    private static long MAX_SDCARD_SIZE_LIMIT = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT;
    private static long MAX_INNER_SIZE_LIMIT = 41943040;
    private static long maxCacheSize = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT;
    private static boolean isUseExternalStorage = true;
    private static FilenameFilter imageFilenameFilter = new FilenameFilter() { // from class: com.tencent.component.media.image.ImageManager.10
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !ImageManager.LRU_FILE_NAME.equals(str);
        }
    };
    private static Comparator<File> fileTimeComparator = new Comparator<File>() { // from class: com.tencent.component.media.image.ImageManager.11
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            String name = file.getName();
            Integer num = (Integer) ImageManager.mLruFilename2TimeMap.get(name);
            if (num == null) {
                num = Integer.valueOf((int) (file.lastModified() / 1000));
                ImageManager.mLruFilename2TimeMap.put(name, num);
            }
            String name2 = file2.getName();
            Integer num2 = (Integer) ImageManager.mLruFilename2TimeMap.get(name2);
            if (num2 == null) {
                num2 = Integer.valueOf((int) (file2.lastModified() / 1000));
                ImageManager.mLruFilename2TimeMap.put(name2, num2);
            }
            return Integer.compare(num2.intValue(), num.intValue());
        }
    };
    private static Executor mImageDecodeThreadPool = null;
    private static final Object LOCK_mImageDecodeThreadPool = new Object();
    private static volatile Executor mImageTaskThreadPool = null;
    private static final Object LOCK_mImageTaskThreadPool = new Object();
    private static volatile boolean mLoadAllImageFileFlag = false;
    private static ConcurrentHashMap<Integer, Integer> mFilename2FileLengthMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Integer> mLruFilename2TimeMap = new ConcurrentHashMap<>(50, 0.75f, 8);
    private static long mSaveLruFileTime = 0;
    private static final ConcurrentHashMap<String, Object> INVALIDATE_URLS = new ConcurrentHashMap<>();
    private IImageFileTracer imageFileTracer = null;
    private BaseHandler mImageGetNullOrCancelHandler = null;
    private LruCache<Integer, Drawable> mImageKeyHash2DrawableMap = null;
    private LruCache<Integer, Image> mImageKeyHash2ImageMap = null;
    private ConcurrentHashMap<Integer, String> mImageKeyHash2UrlMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, HashSet<Integer>> mUrlKey2AllImageKeyMap = new ConcurrentHashMap<>();
    private IDownloader mImageDownloader = null;
    private ConcurrentHashMap<Integer, HashSet<ImageKey>> mImageKeyHash2DecodeOrDownloadMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> mNoCacheUrlKeyAndCacheTimeMap = new ConcurrentHashMap<>();
    private volatile boolean mHasEntryNoCacheUrlKeyAndCacheTimeMap = false;
    private HashMap<Integer, HashSet<ImageKey>> mImageKeyHash2WaitDecodeMap = new HashMap<>();
    private ConcurrentHashMap<String, HashSet<Integer>> mUrlKey2DownloadImageKeyMap = new ConcurrentHashMap<>();
    private ThreadLocal<HashSet<Integer>> mIntegerHashSet = new ThreadLocal<HashSet<Integer>>() { // from class: com.tencent.component.media.image.ImageManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public HashSet<Integer> initialValue() {
            return new HashSet<>();
        }
    };
    private final BaseHandler mMainHandler = new BaseHandler(Looper.getMainLooper());
    private long checkStorageLowTime = 0;
    private boolean isStorageLow = false;
    private ConcurrentHashMap<Integer, Integer> mImageKey2SampleSizeMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ImageAttri> mImagePath2AttriMap = new ConcurrentHashMap<>();
    private final BroadcastReceiver MsdCardMountReceiver = new BroadcastReceiver() { // from class: com.tencent.component.media.image.ImageManager.9
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                String unused = ImageManager.mCachePath = null;
                ImageManager.isStorageReallyCanwriteMap.clear();
                boolean unused2 = ImageManager.mHasLoadSDCardName = false;
                ImageManager.mDecodeExceptionMap.clear();
                ImageManager.this.getAllSDCardInfo();
                ImageManager.getCachePath(context);
                ImageManager.this.imageGetNullOrCancelHandler().post(new Runnable() { // from class: com.tencent.component.media.image.ImageManager.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean unused3 = ImageManager.mLoadAllImageFileFlag = false;
                        ImageManager.this.mTotalFileSize = 0L;
                        ImageManager.this.mFilename2FileMap.clear();
                        ImageManager.mFilename2FileLengthMap.clear();
                        ImageManager.mLruFilename2TimeMap.clear();
                    }
                });
            }
        }
    };
    private ConcurrentHashMap<String, File> mFilename2FileMap = new ConcurrentHashMap<>();
    private volatile long mTotalFileSize = 0;
    private Runnable checkOldImageFileAndCleanRunnable = new Runnable() { // from class: com.tencent.component.media.image.ImageManager.13
        @Override // java.lang.Runnable
        public void run() {
            ImageManager.post(new Runnable() { // from class: com.tencent.component.media.image.ImageManager.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageManager.this.checkOldImageFileAndClean();
                }
            }, false);
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class DecodeTask implements Runnable {
        private ImageKey key;

        public DecodeTask(ImageKey imageKey) {
            this.key = imageKey;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ImageManager.this.handlerImageDecodeMessage(this.key);
            } catch (Throwable th5) {
                th5.printStackTrace();
                ImageManager.this.mImageKeyHash2DecodeOrDownloadMap.remove(Integer.valueOf(this.key.hashCodeEx()));
            }
            if (ImageManager.this.mHasEntryNoCacheUrlKeyAndCacheTimeMap && ImageManager.this.mNoCacheUrlKeyAndCacheTimeMap.containsKey(this.key.urlKey)) {
                File file = new File(this.key.filePath);
                if (file.exists()) {
                    boolean delete = file.delete();
                    ImageManagerLog.d(ImageManager.TAG, "ImageManager.DecodeTask, delete nocache file is: " + delete + ", url=" + this.key.url + ", file length=" + file.length());
                }
            }
            this.key = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class ImageAttri {
        public int srcWidth = 0;
        public int srcHeight = 0;
        public String mimeType = "";

        ImageAttri() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Job implements Runnable, Comparable<Job> {
        private boolean priorty;
        private Runnable runnable;

        public Job(Runnable runnable, boolean z16) {
            this.runnable = runnable;
            this.priorty = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.runnable;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Job job) {
            boolean z16 = job != null ? job.priorty : false;
            boolean z17 = this.priorty;
            if (z17 && z16) {
                return 0;
            }
            if (!z17 || z16) {
                return z16 ? -1 : 0;
            }
            return 1;
        }
    }

    ImageManager() {
        this.mDecoder = null;
        this.dispatcherLoop = null;
        int i3 = 0;
        this.mContext = null;
        this.imageMemCacheSize = 1;
        this.mContext = ImageManagerEnv.getAppContext();
        boolean closeNativeAndinBitmap = ImageManagerEnv.g().closeNativeAndinBitmap();
        sCloseNativeAndCache = closeNativeAndinBitmap;
        if (closeNativeAndinBitmap) {
            ImageManagerLog.d(TAG, "wns closeNativeAndCache");
        }
        if ("meizu".equalsIgnoreCase(Build.MANUFACTURER)) {
            sCloseNativeAndCache = true;
            ImageManagerLog.d(TAG, "isMeizu closeNativeAndCache");
        }
        Looper dispatcher = ImageManagerEnv.g().getDispatcher();
        this.dispatcherLoop = dispatcher;
        if (dispatcher == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Qzone_ImageManager_getnull_or_cancel");
            baseHandlerThread.start();
            this.dispatcherLoop = baseHandlerThread.getLooper();
        }
        int memoryClass = ((ActivityManager) this.mContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass();
        String processName = ImageManagerEnv.g().getProcessName(this.mContext);
        isMainProcess = ImageManagerEnv.g().isMainProcess(this.mContext);
        int i16 = 262144 * memoryClass;
        if (processName != null && processName.contains(":localphoto")) {
            i16 = memoryClass * 524288;
        }
        int minMemoryClassInArt = ImageManagerEnv.g().getMinMemoryClassInArt();
        if (memoryClass < minMemoryClassInArt) {
            sCloseNativeAndCache = true;
            ImageManagerLog.d(TAG, "minMemory closeNativeAndCache:" + memoryClass + ", minMem: " + minMemoryClassInArt);
        }
        int i17 = i16 - 307200;
        this.imageMemCacheSize = i17;
        float cacheMemRatio = ImageManagerEnv.g().getCacheMemRatio();
        cacheMemRatio = cacheMemRatio > 1.0f ? 1.0f : cacheMemRatio;
        this.imageMemCacheSize = (int) (this.imageMemCacheSize * cacheMemRatio);
        String str = TAG;
        ImageManagerLog.d(str, "imageMemCacheSize: " + this.imageMemCacheSize + " , drawableCacheRatio: " + cacheMemRatio + ",memoryclass:" + memoryClass);
        getDecodeThreadPool();
        ImageOptionSampleSize.setSize(memoryClass, i17);
        if (!sCloseNativeAndCache) {
            if (ImageDefaultConfig.isQzone(this.mContext)) {
                int i18 = this.imageMemCacheSize;
                i3 = (int) (i18 * 0.4d);
                this.imageMemCacheSize = (int) (i18 * 0.6d);
            } else if (ImageDefaultConfig.isPicture(this.mContext)) {
                int i19 = this.imageMemCacheSize;
                i3 = (int) (i19 * 0.6d);
                this.imageMemCacheSize = (int) (i19 * 0.4d);
            } else if (ImageDefaultConfig.isMobileQQ(this.mContext)) {
                int i26 = this.imageMemCacheSize;
                i3 = (int) (i26 * 0.3d);
                this.imageMemCacheSize = (int) (i26 * 0.5d);
            }
            ImageManagerLog.d(str, "ImageLoader----imageMemCacheSize = " + this.imageMemCacheSize);
            this.mByteArrayPool = new ByteArrayPool(new PoolParams() { // from class: com.tencent.component.media.image.ImageManager.2
                @Override // com.tencent.component.media.image.PoolParams
                public PoolParams.BucketParams getBucketParams(int i27) {
                    return new PoolParams.BucketParams(16384, ImageManagerEnv.g().getDecodeThreadNum(ImageManager.isMainProcess) + 2);
                }

                @Override // com.tencent.component.media.image.PoolParams
                public int getBucketPoolSize() {
                    return 1;
                }
            });
            ReuseBitmapCacheProxy reuseBitmapCacheProxy = new ReuseBitmapCacheProxy(new PoolParams() { // from class: com.tencent.component.media.image.ImageManager.3
                @Override // com.tencent.component.media.image.PoolParams
                public PoolParams.BucketParams getBucketParams(int i27) {
                    return ImageDefaultConfig.getArtBitmapBucketParams(ImageManager.this.mContext, i27);
                }

                @Override // com.tencent.component.media.image.PoolParams
                public int getBucketPoolSize() {
                    return ImageDefaultConfig.getArtBitmapPoolSize(ImageManager.this.mContext);
                }
            }, i3);
            this.mDecoder = new ArtDecoder(this.mByteArrayPool, reuseBitmapCacheProxy);
            this.mBitmapFactory = new IBitmapFactory.ArtBitmapFactory(this.mByteArrayPool, this.mDecoder);
            BitmapReference.setGlobalReleaser(reuseBitmapCacheProxy);
        }
        if (this.mDecoder == null) {
            this.mDecoder = new DefaultDecoder();
            this.mBitmapFactory = new IBitmapFactory.DefaultBitmapFactory(this.mDecoder);
        }
        ImageManagerLog.d(str, "ImageManager() mDecoder:" + this.mDecoder);
        registerSdCardMountReceiver();
        getAllSDCardInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkOldImageFileAndClean() {
        int i3;
        File file;
        File[] listFiles;
        if (!isMainProcess) {
            return;
        }
        if (mLoadAllImageFileFlag && this.mTotalFileSize < maxCacheSize) {
            return;
        }
        String cachePath = getCachePath(this.mContext);
        int i16 = 0;
        try {
            File file2 = new File(cachePath.replace(IMAGE_DIR_NAME_V2, "image"));
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles2 = file2.listFiles();
                if (listFiles2 != null && listFiles2.length > 0) {
                    for (File file3 : listFiles2) {
                        file3.delete();
                    }
                }
                file2.delete();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        ConcurrentHashMap<String, File> concurrentHashMap = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        try {
            file = new File(cachePath);
        } catch (Throwable th6) {
            th = th6;
            i3 = 0;
        }
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(imageFilenameFilter)) != null) {
            if (listFiles.length > 0) {
                i3 = 0;
                for (int i17 = 0; i17 < listFiles.length; i17++) {
                    try {
                        arrayList.add(listFiles[i17]);
                        String name = listFiles[i17].getName();
                        int parseInt = parseInt(name);
                        Integer num = mFilename2FileLengthMap.get(Integer.valueOf(parseInt));
                        if (num == null) {
                            num = Integer.valueOf((int) listFiles[i17].length());
                            mFilename2FileLengthMap.put(Integer.valueOf(parseInt), num);
                        }
                        i3 += num.intValue();
                        concurrentHashMap.put(name, listFiles[i17]);
                    } catch (Throwable th7) {
                        th = th7;
                        th.printStackTrace();
                        this.mTotalFileSize = i3;
                        this.mFilename2FileMap = concurrentHashMap;
                        mLoadAllImageFileFlag = true;
                        if (this.mTotalFileSize < maxCacheSize) {
                        }
                    }
                }
                this.mTotalFileSize = i3;
                this.mFilename2FileMap = concurrentHashMap;
                mLoadAllImageFileFlag = true;
                if (this.mTotalFileSize < maxCacheSize) {
                    return;
                }
                boolean contains = DeviceInfoMonitor.getModel().toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
                try {
                    long j3 = ((float) maxCacheSize) * 0.8f;
                    loadLruFileTime(mLruFilename2TimeMap);
                    Collections.sort(arrayList, fileTimeComparator);
                    for (int size = arrayList.size() - 1; size > 0; size--) {
                        File file4 = (File) arrayList.get(size);
                        String name2 = file4.getName();
                        Integer remove = mFilename2FileLengthMap.remove(Integer.valueOf(parseInt(name2)));
                        if (remove == null) {
                            remove = Integer.valueOf((int) file4.length());
                        }
                        this.mFilename2FileMap.remove(name2);
                        this.mTotalFileSize -= remove.intValue();
                        file4.delete();
                        mLruFilename2TimeMap.remove(name2);
                        if (contains) {
                            i16++;
                            if (i16 % 20 == 0) {
                                try {
                                    LockMethodProxy.sleep(100L);
                                } catch (Exception unused) {
                                }
                            }
                        }
                        if (this.mTotalFileSize < j3) {
                            break;
                        }
                    }
                    forceSaveLruFileTime(mLruFilename2TimeMap, true);
                    return;
                } catch (Throwable th8) {
                    th8.printStackTrace();
                    return;
                }
            }
        }
        i3 = 0;
        this.mTotalFileSize = i3;
        this.mFilename2FileMap = concurrentHashMap;
        mLoadAllImageFileFlag = true;
        if (this.mTotalFileSize < maxCacheSize) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSaveLruFileTime(ConcurrentHashMap<String, Integer> concurrentHashMap) {
        if (isMainProcess) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = mSaveLruFileTime;
            if (j3 == 0) {
                mSaveLruFileTime = currentTimeMillis;
                forceSaveLruFileTime(concurrentHashMap, false);
            } else if (currentTimeMillis - j3 > 60000) {
                mSaveLruFileTime = currentTimeMillis;
                forceSaveLruFileTime(concurrentHashMap, false);
            }
        }
    }

    private void clearAllImageFile() {
        File[] listFiles;
        this.mTotalFileSize = 0L;
        this.mFilename2FileMap.clear();
        mFilename2FileLengthMap.clear();
        mLruFilename2TimeMap.clear();
        DecodeImageTask.clearImageKey2SampleSizeMap();
        DecodeImageTask.clearImagePath2AttriMap();
        DecodeImageTask.clearImagePath2RotationMap();
        File file = new File(getCachePath(this.mContext));
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void evictAll() {
        if (!ImageManagerEnv.g().isMainProcess(this.mContext)) {
            getDrawableCache().evictAll();
        }
    }

    private void forceSaveLruFileTime(ConcurrentHashMap<String, Integer> concurrentHashMap, boolean z16) {
        boolean z17;
        if (concurrentHashMap.size() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(concurrentHashMap);
            concurrentHashMap.clear();
            String str = getCachePath(this.mContext) + LRU_FILE_NAME;
            if (!z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(str, z17);
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            for (String str2 : hashMap.keySet()) {
                                sb5.append(str2);
                                sb5.append("|");
                                sb5.append(hashMap.get(str2));
                                sb5.append("\r\n");
                            }
                            fileOutputStream2.write(sb5.toString().getBytes());
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (Exception e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
            } catch (IOException e19) {
                e19.printStackTrace();
            }
        }
    }

    private Drawable get(int i3) {
        try {
            if (!ImageManagerEnv.g().isQQProcess(this.mContext)) {
                return getDrawableCache().get(Integer.valueOf(i3));
            }
            Object obj = ImageManagerEnv.g().getQQImagecache().get(i3 + "");
            if (obj == null || !(obj instanceof Drawable)) {
                return null;
            }
            return (Drawable) obj;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAllSDCardInfo() {
        if (mHasLoadSDCardName) {
            return;
        }
        mHasLoadSDCardName = true;
        imageGetNullOrCancelHandler().postDelayed(new Runnable() { // from class: com.tencent.component.media.image.ImageManager.7
            @Override // java.lang.Runnable
            public void run() {
                ImageManager.post(ImageManager.getAllSDCardInfoRunnable, false);
            }
        }, 10000L);
    }

    @Public
    public static String getCachePath(Context context) {
        if (mCachePath == null) {
            synchronized (ImageManager.class) {
                if (mCachePath == null) {
                    mCachePath = getStorePath(context, IMAGE_DIR_NAME_V2, false, false);
                }
            }
        }
        return mCachePath;
    }

    private static String getCachePathNocache(Context context) {
        return getCachePath(context) + "nocache" + File.separator;
    }

    private static String getCachePathNocacheOrCreateIfInexistence(Context context) {
        String cachePathNocache = getCachePathNocache(context);
        File file = new File(cachePathNocache);
        if (!file.exists()) {
            file.mkdir();
        }
        return cachePathNocache;
    }

    @Public
    public static String getCachePathSR(Context context) {
        if (sCachePath4SuperResolution == null) {
            synchronized (ImageManager.class) {
                if (sCachePath4SuperResolution == null) {
                    sCachePath4SuperResolution = getStorePath(context, IMAGE_DIR_NAME_SR, false, false);
                }
            }
        }
        return sCachePath4SuperResolution;
    }

    private static Executor getDecodeThreadPool() {
        if (mImageDecodeThreadPool == null) {
            int decodeThreadNum = ImageManagerEnv.g().getDecodeThreadNum(isMainProcess);
            Executor executor = ImageManagerEnv.g().getExecutor();
            mImageDecodeThreadPool = executor;
            if (executor == null) {
                mImageDecodeThreadPool = ProxyExecutors.newFixedThreadPool(decodeThreadNum, new ThreadFactory() { // from class: com.tencent.component.media.image.ImageManager.12
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        return new BaseThread(runnable, "Qzone_ImageManager_decode_ThreadPool_" + ImageManager.threadCount.getAndIncrement());
                    }
                });
            }
        }
        return mImageDecodeThreadPool;
    }

    public static int getDrawableAllocSize(Drawable drawable) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (drawable == null) {
            return 0;
        }
        if (drawable instanceof DrawableContainer) {
            return getDrawableAllocSize(((DrawableContainer) drawable).getDrawable());
        }
        if (drawable instanceof PhotoGifDrawable) {
            return 0;
        }
        if (drawable instanceof NewGifDrawable) {
            return (int) ((NewGifDrawable) drawable).getAllocationByteCount();
        }
        if (drawable instanceof BitmapDrawable) {
            return BitmapUtils.getBitmapAllocSize(((BitmapDrawable) drawable).getBitmap());
        }
        if (drawable instanceof BitmapImageDrawable) {
            return ((BitmapImageDrawable) drawable).size();
        }
        if (drawable instanceof SliceBitmapDrawable) {
            return ((SliceBitmapDrawable) drawable).getByteCount();
        }
        if (drawable instanceof NewAnimationDrawable) {
            return ((NewAnimationDrawable) drawable).getByteCount();
        }
        if (drawable instanceof NinePatchRefDrawable) {
            BitmapReference bitmapRef = ((NinePatchRefDrawable) drawable).getBitmapRef();
            if (bitmapRef == null || (bitmap2 = bitmapRef.getBitmap()) == null) {
                return 0;
            }
            return BitmapUtils.getBitmapAllocSize(bitmap2);
        }
        if (drawable instanceof RegionDrawable) {
            BitmapReference bitmapRef2 = ((RegionDrawable) drawable).getBitmapRef();
            if (bitmapRef2 == null || (bitmap = bitmapRef2.getBitmap()) == null) {
                return 0;
            }
            return BitmapUtils.getBitmapAllocSize(bitmap);
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicHeight < 1) {
            intrinsicHeight = 1;
        }
        if (intrinsicWidth < 1) {
            intrinsicWidth = 1;
        }
        return intrinsicWidth * intrinsicHeight * 4;
    }

    private LruCache<Integer, Drawable> getDrawableCache() {
        if (this.mImageKeyHash2DrawableMap == null) {
            synchronized (LOCK_CacheMap) {
                if (this.mImageKeyHash2DrawableMap == null) {
                    this.mImageKeyHash2DrawableMap = new LruCache<Integer, Drawable>(this.imageMemCacheSize) { // from class: com.tencent.component.media.image.ImageManager.5
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.component.media.utils.LruCache
                        public void entryRemoved(boolean z16, Integer num, Drawable drawable, Drawable drawable2) {
                            if (num != null) {
                                ImageTaskTracer.addImageLruCacheEvictedRecord(num.intValue());
                                ImageManager.this.mImageKeyHash2UrlMap.remove(num);
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.component.media.utils.LruCache
                        public int sizeOf(Integer num, Drawable drawable) {
                            return ImageManager.getDrawableAllocSize(drawable);
                        }
                    };
                }
            }
        }
        return this.mImageKeyHash2DrawableMap;
    }

    public static String getErrorString(ImageKey imageKey, int i3) {
        if (imageKey != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ImageTaskConst.RESULT, ImageTaskConst.getImageTaskErrorDescription(i3));
                jSONObject.put(ImageTaskConst.FAIL_CODE, String.valueOf(i3));
                jSONObject.put("filePath", imageKey.filePath);
                jSONObject.put("url", imageKey.url);
                return jSONObject.toString();
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private LruCache<Integer, Image> getImageCache() {
        if (this.mImageKeyHash2ImageMap == null) {
            synchronized (LOCK_CacheMap) {
                if (this.mImageKeyHash2ImageMap == null) {
                    this.mImageKeyHash2ImageMap = new LruCache<Integer, Image>(this.imageMemCacheSize) { // from class: com.tencent.component.media.image.ImageManager.6
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.component.media.utils.LruCache
                        public void entryRemoved(boolean z16, Integer num, Image image, Image image2) {
                            if (num != null) {
                                ImageTaskTracer.addImageLruCacheEvictedRecord(num.intValue());
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.component.media.utils.LruCache
                        public int sizeOf(Integer num, Image image) {
                            return image.size();
                        }
                    };
                }
            }
        }
        return this.mImageKeyHash2ImageMap;
    }

    public static ImageManager getInstance(Context context) {
        return getInstance();
    }

    public static File getLocalFileByUrl(Context context, String str, String str2) {
        String cachePath;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            cachePath = getCachePath(context);
        } else {
            cachePath = getCachePath(context, str2);
        }
        File file = new File(cachePath + File.separator + String.valueOf(ImageKey.getUrlKey(str, false).hashCode()));
        SharpPUtils.deleteSharppCacheFileIfNessary(file, str);
        return file;
    }

    private String getNocacheFilePath(ImageKey imageKey, boolean z16) {
        if (z16) {
            return getCachePathNocacheOrCreateIfInexistence(this.mContext) + urlKey2FileName(imageKey.urlKey, true);
        }
        return getCachePathNocache(this.mContext) + urlKey2FileName(imageKey.urlKey, true);
    }

    public static String getStorePath(Context context, String str, boolean z16, boolean z17) {
        String str2 = "";
        try {
            String externalStorageState = Environment.getExternalStorageState();
            maxCacheSize = MAX_INNER_SIZE_LIMIT;
            isUseExternalStorage = false;
            if (!z16 && "mounted".equals(externalStorageState) && context.getExternalCacheDir().canWrite()) {
                storeRootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                str2 = ImageManagerEnv.g().getImageCacheDir(true);
                if (TextUtils.isEmpty(str2)) {
                    str2 = context.getExternalCacheDir() + File.separator + "qzone";
                }
                maxCacheSize = MAX_SDCARD_SIZE_LIMIT;
                isUseExternalStorage = true;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (!isUseExternalStorage) {
            storeRootPath = Environment.getDataDirectory().getAbsolutePath();
            str2 = ImageManagerEnv.g().getImageCacheDir(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getCacheDir().getAbsolutePath() + File.separator + "qzone";
            }
        }
        String str3 = File.separator;
        if (!str.startsWith(str3)) {
            str = str3 + str;
        }
        if (!str.endsWith(str3)) {
            str = str + str3;
        }
        File file = new File(str2 + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.endsWith(str3)) {
            return absolutePath + str3;
        }
        return absolutePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIamgeTracer(Message message) {
        Object obj = message.obj;
        if (obj instanceof ImageKey) {
            if (message.arg1 == 16) {
                ImageTaskTracer.traceImageGet((ImageKey) obj, true);
            } else {
                ImageTaskTracer.traceImageGet((ImageKey) obj, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleImageGetNull(Message message) {
        Object obj = message.obj;
        if (obj instanceof ImageKey) {
            ImageKey imageKey = (ImageKey) obj;
            imageKey.options = ImageLoader.Options.copy(imageKey.options);
            if (imageKey.flag == 0) {
                imageKey.recycle();
                return;
            }
            ImageTask buildImageTask = ImageTaskBuilder.buildImageTask(imageKey);
            ImageTaskTracer.removeImageMsgGetNullRecord(imageKey.hashCodeEx());
            if (buildImageTask != null) {
                buildImageTask.excuteTask();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerImageCancelMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof ImageKey) {
            ImageKey imageKey = (ImageKey) obj;
            imageKey.options = ImageLoader.Options.copy(imageKey.options);
            ImageTracer.cancel(imageKey.url);
            ImageTaskManager.cancelImageTask(imageKey);
            ImageTaskManager.getInstance().cancelDownload(imageKey.url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseHandler imageGetNullOrCancelHandler() {
        if (this.mImageGetNullOrCancelHandler == null) {
            synchronized (LOCK_mImageGetNullOrCancelHandler) {
                if (this.mImageGetNullOrCancelHandler == null) {
                    this.mImageGetNullOrCancelHandler = new BaseHandler(this.dispatcherLoop) { // from class: com.tencent.component.media.image.ImageManager.4
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i3 = message.what;
                            if (i3 == 0) {
                                ImageManager.this.handleImageGetNull(message);
                            } else if (i3 == 1) {
                                ImageManager.this.handlerImageCancelMessage(message);
                            } else if (i3 == 2) {
                                ImageManager.this.handleIamgeTracer(message);
                            }
                        }
                    };
                }
            }
        }
        return this.mImageGetNullOrCancelHandler;
    }

    public static void invalidateMemCache(String str) {
        if (!TextUtils.isEmpty(str)) {
            INVALIDATE_URLS.put(str, Boolean.TRUE);
        }
    }

    private boolean isAvailableStorageSizeLow() {
        try {
            StatFs statFs = new StatFs(storeRootPath);
            if (statFs.getAvailableBlocks() * statFs.getBlockSize() >= 5242880) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static boolean isNetworkUrl(String str) {
        return QZoneImageDecodeUtils.isNetworkUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isStorageReallyCanwrite(String str) {
        Boolean bool = isStorageReallyCanwriteMap.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        File file = new File(str + "/qz" + Thread.currentThread().getId());
        boolean z16 = false;
        try {
            if (file.exists()) {
                if (file.delete()) {
                    z16 = file.createNewFile();
                }
            } else {
                z16 = file.createNewFile();
            }
        } finally {
            try {
                file.delete();
                isStorageReallyCanwriteMap.put(str, Boolean.valueOf(z16));
                return z16;
            } finally {
            }
        }
        file.delete();
        isStorageReallyCanwriteMap.put(str, Boolean.valueOf(z16));
        return z16;
    }

    private void loadLruFileTime(ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            File file = new File(getCachePath(this.mContext) + LRU_FILE_NAME);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("|");
                        if (split != null && split.length == 2) {
                            String str = split[0];
                            int parseInt = Integer.parseInt(split[1]);
                            Integer num = concurrentHashMap.get(str);
                            if (num == null) {
                                concurrentHashMap.put(str, Integer.valueOf(parseInt));
                            } else if (parseInt > num.intValue()) {
                                concurrentHashMap.put(str, Integer.valueOf(parseInt));
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static void post(Runnable runnable, boolean z16) {
        getDecodeThreadPool().execute(new Job(runnable, z16));
    }

    private void put(int i3, Drawable drawable) {
        if (!ImageManagerEnv.g().isQQProcess(this.mContext)) {
            getDrawableCache().put(Integer.valueOf(i3), drawable);
            return;
        }
        ImageManagerEnv.g().getQQImagecache().put(i3 + "", drawable);
    }

    private void putImageKey(Map<Integer, HashSet<ImageKey>> map, int i3, ImageKey imageKey) {
        if (map != null && imageKey != null) {
            HashSet<ImageKey> hashSet = map.get(Integer.valueOf(i3));
            if (hashSet == null) {
                hashSet = new HashSet<>();
                map.put(Integer.valueOf(i3), hashSet);
            }
            hashSet.add(imageKey);
        }
    }

    private void putImageKeyList(Map<Integer, HashSet<ImageKey>> map, int i3, HashSet<ImageKey> hashSet) {
        if (map != null && hashSet != null) {
            HashSet<ImageKey> hashSet2 = map.get(Integer.valueOf(i3));
            if (hashSet2 == null) {
                hashSet2 = new HashSet<>();
                map.put(Integer.valueOf(i3), hashSet2);
            }
            hashSet2.addAll(hashSet);
        }
    }

    private void registerSdCardMountReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addDataScheme("file");
            this.mContext.registerReceiver(this.MsdCardMountReceiver, intentFilter);
            mIsRegisterSdcardReceiver = true;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void remove(int i3) {
        if (!ImageManagerEnv.g().isQQProcess(this.mContext)) {
            getDrawableCache().remove(Integer.valueOf(i3));
            return;
        }
        ImageManagerEnv.g().getQQImagecache().remove(i3 + "");
    }

    static boolean removeInvalidatedUrl(String str) {
        if (TextUtils.isEmpty(str) || INVALIDATE_URLS.remove(str) == null) {
            return false;
        }
        return true;
    }

    private void unregisterSdCardMountReceiver() {
        try {
            if (mIsRegisterSdcardReceiver) {
                this.mContext.unregisterReceiver(this.MsdCardMountReceiver);
                mIsRegisterSdcardReceiver = false;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void updateStorage(String str) {
        BufferedReader bufferedReader;
        Throwable th5;
        Exception e16;
        File file = new File(str);
        if (file.exists()) {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (readLine.startsWith("dev_")) {
                                    String[] split = readLine.split(" ");
                                    if (split.length >= 3) {
                                        String str2 = split[2];
                                        String str3 = split[1];
                                        if (new File(str2).exists()) {
                                            mSDCardName2PathMap.put(str3, str2);
                                        }
                                    }
                                }
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                throw th5;
                            }
                        } catch (Exception e18) {
                            e16 = e18;
                            e16.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return;
                        }
                    }
                    bufferedReader.close();
                    bufferedReader.close();
                } catch (Exception e19) {
                    bufferedReader = null;
                    e16 = e19;
                } catch (Throwable th7) {
                    bufferedReader = null;
                    th5 = th7;
                    if (bufferedReader != null) {
                    }
                    throw th5;
                }
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        }
    }

    public static String urlKey2FileName(String str, boolean z16) {
        if (z16) {
            return String.valueOf(str.hashCode());
        }
        if (str.startsWith("file://")) {
            return str.substring(7, str.length());
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canDownloadImage(ImageKey imageKey) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.checkStorageLowTime > 5000) {
            this.checkStorageLowTime = currentTimeMillis;
            boolean isAvailableStorageSizeLow = isAvailableStorageSizeLow();
            this.isStorageLow = isAvailableStorageSizeLow;
            if (isAvailableStorageSizeLow) {
                clearAllImageFile();
                boolean isAvailableStorageSizeLow2 = isAvailableStorageSizeLow();
                this.isStorageLow = isAvailableStorageSizeLow2;
                if (isAvailableStorageSizeLow2 && isUseExternalStorage) {
                    if (!TextUtils.isEmpty(maxAvailableSizePath)) {
                        mCachePath = getStorePath(this.mContext, IMAGE_DIR_NAME_V2, false, true);
                        imageKey.filePath = getCachePath(this.mContext) + urlKey2FileName(imageKey.urlKey, true);
                        clearAllImageFile();
                        boolean isAvailableStorageSizeLow3 = isAvailableStorageSizeLow();
                        this.isStorageLow = isAvailableStorageSizeLow3;
                        if (isAvailableStorageSizeLow3) {
                            mCachePath = getStorePath(this.mContext, IMAGE_DIR_NAME_V2, true, false);
                            imageKey.filePath = getCachePath(this.mContext) + urlKey2FileName(imageKey.urlKey, true);
                            clearAllImageFile();
                            this.isStorageLow = isAvailableStorageSizeLow();
                        }
                    } else {
                        mCachePath = getStorePath(this.mContext, IMAGE_DIR_NAME_V2, true, false);
                        imageKey.filePath = getCachePath(this.mContext) + urlKey2FileName(imageKey.urlKey, true);
                        clearAllImageFile();
                        this.isStorageLow = isAvailableStorageSizeLow();
                    }
                }
            }
            if (this.isStorageLow && isMainProcess) {
                ImageManagerEnv.g().showToast(0, this.mContext, "\u624b\u673a\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3\uff0c\u56fe\u7247\u65e0\u6cd5\u4e0b\u8f7d\u5c55\u793a\uff0c\u8bf7\u53ca\u65f6\u6e05\u7406\uff01", 17);
            }
        }
        return !this.isStorageLow;
    }

    public void cancel(String str, ImageLoader.ImageLoadListener imageLoadListener, ImageLoader.Options options) {
        if (str != null && str.length() != 0) {
            ImageKey obtain = ImageKey.obtain();
            obtain.setUrl(str);
            obtain.listener = imageLoadListener;
            obtain.options = ImageLoader.Options.copy(options);
            Message obtainMessage = imageGetNullOrCancelHandler().obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = obtain;
            imageGetNullOrCancelHandler().sendMessage(obtainMessage);
        }
    }

    public int capacity() {
        return this.imageMemCacheSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkBitmapDecodeFailCount(ImageKey imageKey) {
        if (imageKey.isNetworkUrl) {
            Integer num = mDecodeExceptionMap.get(imageKey.filePath);
            if (num != null) {
                if (maxDecodeFailCount == -1) {
                    int maxNumOfDecodingFailures = ImageManagerEnv.g().getMaxNumOfDecodingFailures();
                    maxDecodeFailCount = maxNumOfDecodingFailures;
                    if (maxNumOfDecodingFailures <= -1) {
                        maxDecodeFailCount = 3;
                        ImageManagerLog.w(TAG, "--maxDecodeFailCount<=-1,so set default value: 3.");
                    }
                }
                if (num.intValue() >= maxDecodeFailCount) {
                    removeImageFile(imageKey.url, null);
                    mDecodeExceptionMap.remove(imageKey.filePath);
                    return;
                } else {
                    mDecodeExceptionMap.put(imageKey.filePath, Integer.valueOf(num.intValue() + 1));
                    return;
                }
            }
            mDecodeExceptionMap.put(imageKey.filePath, 1);
        }
    }

    public void checkCleanImageLocalFile() {
        if (isMainProcess) {
            post(new Runnable() { // from class: com.tencent.component.media.image.ImageManager.14
                @Override // java.lang.Runnable
                public void run() {
                    ImageManager.this.checkSaveLruFileTime(ImageManager.mLruFilename2TimeMap);
                }
            }, false);
        }
        if (isMainProcess) {
            if (!mLoadAllImageFileFlag || (mLoadAllImageFileFlag && this.mTotalFileSize > maxCacheSize)) {
                imageGetNullOrCancelHandler().removeCallbacks(this.checkOldImageFileAndCleanRunnable);
                imageGetNullOrCancelHandler().postDelayed(this.checkOldImageFileAndCleanRunnable, 1000L);
            }
        }
    }

    public void clear(boolean z16) {
        evictAll();
        ImageKey.clearAndInitSize();
        if (z16) {
            clearAllImageFile();
        }
        this.mUrlKey2AllImageKeyMap.clear();
        this.mImageKeyHash2UrlMap.clear();
    }

    public void clearMemoryCache() {
        clear(false);
    }

    public BitmapReference getBitmap(int i3, int i16, Bitmap.Config config) {
        IBitmapFactory iBitmapFactory = this.mBitmapFactory;
        if (iBitmapFactory != null) {
            return iBitmapFactory.createBitmap(i3, i16, config);
        }
        return BitmapReference.getBitmapReference(Bitmap.createBitmap(i3, i16, config));
    }

    public IDecoder getDecoder() {
        return this.mDecoder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable getDrawbleFromCache(ImageKey imageKey) {
        Long l3;
        if (imageKey == null) {
            return null;
        }
        if (removeInvalidatedUrl(imageKey.url)) {
            clear(imageKey.url);
            return null;
        }
        Drawable drawable = get(imageKey.hashCodeEx());
        if (drawable != null && this.mHasEntryNoCacheUrlKeyAndCacheTimeMap && (l3 = this.mNoCacheUrlKeyAndCacheTimeMap.get(imageKey.urlKey)) != null) {
            String str = TAG;
            ImageManagerLog.w(str, "getDrawbleFromCache, use no-cache, url = " + imageKey.url + ", cache_time = " + l3);
            if (System.currentTimeMillis() - l3.longValue() >= ImageManagerEnv.g().getNoCacheImageExpiredTime() * 1000) {
                this.mNoCacheUrlKeyAndCacheTimeMap.remove(imageKey.urlKey);
                if (this.mNoCacheUrlKeyAndCacheTimeMap.size() == 0) {
                    this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = false;
                }
                clear(imageKey.url);
                ImageManagerLog.w(str, "getDrawbleFromCache, clear no-cache memory, url = " + imageKey.url);
                return null;
            }
            if (!TextUtils.isEmpty(imageKey.filePath)) {
                ImageManagerLog.d(str, "getDrawbleFromCache, use no-cache drawable, url=" + imageKey.url + ", file length=" + new File(imageKey.filePath).length());
            }
        }
        return drawable;
    }

    public Drawable getImage(String str, ImageLoader.ImageLoadListener imageLoadListener, ImageLoader.Options options, byte b16, ImageLoader.ImageDownloadListener imageDownloadListener) {
        if (str != null && str.length() != 0) {
            ImageKey obtain = ImageKey.obtain();
            obtain.setUrl(str);
            obtain.options = options;
            obtain.flag = b16;
            obtain.listener = imageLoadListener;
            obtain.needCallBackProcessPercent = options == null ? false : options.needCallBackProcessPercent;
            obtain.imglistener = imageDownloadListener;
            Drawable drawbleFromCache = getDrawbleFromCache(obtain);
            if (drawbleFromCache != null) {
                if (isInFriendFeed && options != null && !options.isPreDecode && hasScrolled && !options.disableHitRateReport) {
                    Message obtainMessage = imageGetNullOrCancelHandler().obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.obj = obtain;
                    obtainMessage.arg1 = 16;
                    imageGetNullOrCancelHandler().sendMessage(obtainMessage);
                }
                if (options == null || !options.isGifPlayWhileDownloading) {
                    obtain.recycle();
                }
                return drawbleFromCache;
            }
            if (isInFriendFeed && options != null && !options.isPreDecode && hasScrolled && !options.disableHitRateReport) {
                Message obtainMessage2 = imageGetNullOrCancelHandler().obtainMessage();
                obtainMessage2.what = 2;
                obtainMessage2.obj = obtain;
                obtainMessage2.arg1 = 0;
                imageGetNullOrCancelHandler().sendMessage(obtainMessage2);
            }
            ImageTaskTracer.addImageMsgGetNullRecord(obtain.hashCodeEx());
            Message obtainMessage3 = imageGetNullOrCancelHandler().obtainMessage();
            obtainMessage3.what = 0;
            obtainMessage3.obj = obtain;
            imageGetNullOrCancelHandler().sendMessage(obtainMessage3);
        }
        return null;
    }

    public Drawable getImageByUrlInMemory(String str) {
        if (str != null && str.length() != 0) {
            HashSet<Integer> hashSet = this.mUrlKey2AllImageKeyMap.get(ImageKey.getUrlKey(str, false));
            if (hashSet != null && hashSet.size() > 0) {
                Iterator<Integer> it = hashSet.iterator();
                while (it.hasNext()) {
                    Drawable drawable = get(it.next().intValue());
                    if (drawable != null) {
                        if (drawable instanceof NewGifDrawable) {
                            ((NewGifDrawable) drawable).setVisible(true, true);
                        }
                        return drawable;
                    }
                }
            }
        }
        return null;
    }

    public File getImageFile(String str, ImageLoader.Options options) {
        String cachePath;
        String str2;
        File file = null;
        if (isNetworkUrl(str)) {
            String urlKey2FileName = urlKey2FileName(ImageKey.getUrlKey(str, true), true);
            File file2 = this.mFilename2FileMap.get(urlKey2FileName);
            if (file2 == null) {
                if (options != null && (str2 = options.fileRootPath) != null && str2.length() > 0) {
                    cachePath = options.fileRootPath;
                } else {
                    if (mLoadAllImageFileFlag) {
                        return null;
                    }
                    cachePath = getCachePath(this.mContext);
                }
                File file3 = new File(cachePath + urlKey2FileName);
                if (file3.exists()) {
                    this.mFilename2FileMap.put(urlKey2FileName, file3);
                    this.mTotalFileSize += file3.length();
                    file = file3;
                }
            } else {
                file = file2;
            }
        }
        SharpPUtils.deleteSharppCacheFileIfNessary(file, str);
        SharpPUtils.checkNotSharppCacheFileIfNessary(file, str);
        return file;
    }

    public File getImageFileForSuperResolution(String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void imageKeyFilePathCheck(ImageKey imageKey) {
        String cachePath;
        String str;
        String str2 = imageKey.filePath;
        if (str2 == null || str2.length() == 0) {
            if (imageKey.isNetworkUrl) {
                String str3 = imageKey.urlKey;
                ImageLoader.Options options = imageKey.options;
                if (options != null && (str = options.fileRootPath) != null && str.length() > 0) {
                    cachePath = imageKey.options.fileRootPath;
                } else {
                    cachePath = getCachePath(this.mContext);
                }
                imageKey.filePath = cachePath + urlKey2FileName(str3, true);
            } else if (ImageManagerEnv.g().needCheckAvatar() && imageKey.isAvatarUrl()) {
                imageKey.filePath = ImageManagerEnv.g().getAvatarPath(imageKey.url);
            } else {
                imageKey.filePath = urlKey2FileName(imageKey.urlKey, false);
            }
        }
        if (!TextUtils.isEmpty(imageKey.filePath) && VideoThumbnail.isVideo(imageKey.filePath)) {
            String queryVideoThumbnailFilePath = VideoThumbnail.queryVideoThumbnailFilePath(ImageManagerEnv.getAppContext(), imageKey.filePath);
            if (!TextUtils.isEmpty(queryVideoThumbnailFilePath) && new File(queryVideoThumbnailFilePath).exists()) {
                imageKey.filePath = queryVideoThumbnailFilePath;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nocachedDeleteLocalFile(ImageKey imageKey) {
        if (this.mHasEntryNoCacheUrlKeyAndCacheTimeMap && this.mNoCacheUrlKeyAndCacheTimeMap.containsKey(imageKey.urlKey)) {
            File file = new File(imageKey.filePath);
            if (file.exists()) {
                boolean delete = file.delete();
                ImageManagerLog.w(TAG, "nocachedDeleteLocalFile, delete local file is: " + delete + ", url = " + imageKey.url + ", filePath=" + imageKey.filePath);
                if (delete) {
                    File file2 = new File(getNocacheFilePath(imageKey, false));
                    if (file2.exists()) {
                        file2.delete();
                        return;
                    }
                    return;
                }
            }
        }
        File file3 = new File(getNocacheFilePath(imageKey, false));
        if (file3.exists()) {
            File file4 = new File(imageKey.filePath);
            if (file4.exists()) {
                file4.delete();
            }
            file3.delete();
        }
    }

    public void notifyDownSuccess(ImageKey imageKey, String str, String str2) {
        onDownloadSucceed(imageKey, str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onDownloadSucceed(ImageKey imageKey, String str, String str2, boolean z16) {
        String urlKey = ImageKey.getUrlKey(str, false);
        ImageTracer.endDownlaod(str);
        if (imageKey != null && imageKey.flag == 3) {
            ProgressTracer.print(5, str);
        } else {
            ProgressTracer.print(2, str);
        }
        if (ImageManagerEnv.g().enableSocketMonitor()) {
            urlKey = ImageManagerEnv.g().removeSocketMonitorParam(urlKey);
        }
        if (z16) {
            this.mNoCacheUrlKeyAndCacheTimeMap.put(urlKey, Long.valueOf(System.currentTimeMillis()));
            this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = true;
            ImageManagerLog.w(TAG, "onDownloadSucceed,save no-cache info, url = " + str);
        }
        if (imageKey != null) {
            imageKeyFilePathCheck(imageKey);
            File file = new File(imageKey.filePath);
            if (file.exists()) {
                if (imageKey.isNetworkUrl && !z16) {
                    updateLruFile(imageKey);
                    String name = file.getName();
                    int length = (int) file.length();
                    this.mFilename2FileMap.put(name, file);
                    long j3 = length;
                    this.mTotalFileSize += j3;
                    mFilename2FileLengthMap.put(Integer.valueOf(parseInt(name)), Integer.valueOf(length));
                    ImageTracer.setImageLength(str, j3);
                }
                if (z16) {
                    File file2 = new File(getNocacheFilePath(imageKey, true));
                    if (!file2.exists()) {
                        try {
                            file2.createNewFile();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }
                return true;
            }
            if (imageKey.isAvatarUrl()) {
                imageKey.filePath = str2;
                return true;
            }
            if (!imageKey.filePath.startsWith("/data")) {
                mCachePath = getStorePath(this.mContext, IMAGE_DIR_NAME_V2, true, false);
                imageKey.filePath = getCachePath(this.mContext) + urlKey2FileName(imageKey.urlKey, true);
                File file3 = new File(imageKey.filePath);
                if (ImageManagerEnv.g().copyFiles(new File(str2), file3)) {
                    if (!z16) {
                        String name2 = file3.getName();
                        int length2 = (int) file3.length();
                        this.mFilename2FileMap.put(name2, file3);
                        long j16 = length2;
                        this.mTotalFileSize += j16;
                        mFilename2FileLengthMap.put(Integer.valueOf(parseInt(name2)), Integer.valueOf(length2));
                        ImageTracer.setImageLength(str, j16);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void onListViewIdle() {
        ImageTaskManager.getInstance().resumeDecodeImageTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putDrawableInMemoryCache(ImageKey imageKey, int i3, Image image, Drawable drawable, ImageLoader.Options options) {
        if (imageKey == null) {
            return;
        }
        putDrawableInMemoryCache(imageKey.urlKey, i3, image, drawable, options);
        this.mImageKeyHash2UrlMap.put(Integer.valueOf(i3), imageKey.url);
    }

    public void removeImageFile(String str, ImageLoader.Options options) {
        String cachePath;
        String str2;
        if (isNetworkUrl(str)) {
            String urlKey2FileName = urlKey2FileName(ImageKey.getUrlKey(str, true), true);
            File remove = this.mFilename2FileMap.remove(urlKey2FileName);
            mFilename2FileLengthMap.remove(Integer.valueOf(parseInt(urlKey2FileName)));
            if (remove == null) {
                if (options != null && (str2 = options.fileRootPath) != null && str2.length() > 0) {
                    cachePath = options.fileRootPath;
                } else {
                    cachePath = getCachePath(this.mContext);
                }
                remove = new File(cachePath + urlKey2FileName);
            }
            if (remove.exists()) {
                this.mTotalFileSize -= remove.length();
                remove.delete();
            }
        }
    }

    public void resizeCache(float f16) {
        String str = TAG;
        ImageManagerLog.i(str, "resize mImageKeyHash2DrawableMap");
        BitmapUtils.resize(this.mImageKeyHash2DrawableMap, f16, 8388608);
        ImageManagerLog.i(str, "resize mImageKeyHash2ImageMap");
        BitmapUtils.resize(this.mImageKeyHash2ImageMap, f16);
        ImageManagerLog.i(str, "clear ArtDecoder");
        IDecoder decoder = getDecoder();
        if (decoder instanceof ArtDecoder) {
            ((ArtDecoder) decoder).trimToSize(f16);
        }
    }

    public void setImageFileTracer(IImageFileTracer iImageFileTracer) {
        this.imageFileTracer = iImageFileTracer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void traceImageFile(boolean z16) {
        IImageFileTracer iImageFileTracer = this.imageFileTracer;
        if (iImageFileTracer != null) {
            iImageFileTracer.onImageFileDecode(z16);
        }
    }

    public void trimCacheToSize(float f16) {
        String str = TAG;
        ImageManagerLog.i(str, "clear mImageKeyHash2DrawableMap");
        BitmapUtils.trimToSize(this.mImageKeyHash2DrawableMap, f16, 8388608);
        ImageManagerLog.i(str, "clear mImageKeyHash2ImageMap");
        BitmapUtils.trimToSize(this.mImageKeyHash2ImageMap, f16);
        ImageManagerLog.i(str, "clear ArtDecoder");
        IDecoder decoder = getDecoder();
        if (decoder instanceof ArtDecoder) {
            ((ArtDecoder) decoder).trimToSize(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateLruFile(ImageKey imageKey) {
        if (imageKey != null && imageKey.isNetworkUrl) {
            imageKeyFilePathCheck(imageKey);
            mLruFilename2TimeMap.put(urlKey2FileName(imageKey.urlKey, true), Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        }
    }

    public static ImageManager getInstance() {
        if (mInstance == null) {
            synchronized (LOCK_mInstance) {
                if (mInstance == null) {
                    mInstance = new ImageManager();
                }
            }
        }
        return mInstance;
    }

    void putDrawableInMemoryCache(String str, int i3, Image image, Drawable drawable, ImageLoader.Options options) {
        if (options != null && !options.needCache) {
            ImageManagerLog.d(TAG, "options.needCache=false,needn't put into cache");
            return;
        }
        if (QZoneImageDecodeUtils.drawableComputable(drawable)) {
            put(i3, drawable);
        } else {
            ImageManagerLog.d("feilongzou", "drawable \u4e0d\u80fd\u7cbe\u786e\u8ba1\u7b97\u5927\u5c0f\uff0c\u4e0d\u80fd\u653e\u5165\u7f13\u5b58\u4e2d\uff1a" + drawable);
        }
        HashSet<Integer> hashSet = this.mUrlKey2AllImageKeyMap.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.mUrlKey2AllImageKeyMap.put(str, hashSet);
        }
        hashSet.add(Integer.valueOf(i3));
    }

    public void clear(String str, ImageLoader.Options options) {
        ImageKey obtain = ImageKey.obtain();
        obtain.setUrl(str);
        obtain.options = options;
        int hashCodeEx = obtain.hashCodeEx();
        remove(hashCodeEx);
        this.mImageKeyHash2UrlMap.remove(Integer.valueOf(hashCodeEx));
        obtain.recycle();
    }

    @Public
    public static String getCachePath(Context context, String str) {
        return getStorePath(context, str, false, false);
    }

    public void clear(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        HashSet<Integer> remove = this.mUrlKey2AllImageKeyMap.remove(ImageKey.getUrlKey(str, false));
        if (remove != null) {
            Iterator<Integer> it = remove.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                remove(intValue);
                this.mImageKeyHash2UrlMap.remove(Integer.valueOf(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerImageDecodeMessage(ImageKey imageKey) {
    }

    public Drawable getImage(ImageUrl imageUrl, ImageLoader.ImageLoadListener imageLoadListener, ImageLoader.Options options, byte b16, ImageLoader.ImageDownloadListener imageDownloadListener) {
        if (imageUrl == null) {
            return null;
        }
        ImageKey obtain = ImageKey.obtain();
        obtain.setUrl(imageUrl);
        obtain.options = options;
        obtain.flag = b16;
        obtain.listener = imageLoadListener;
        obtain.needCallBackProcessPercent = options == null ? false : options.needCallBackProcessPercent;
        obtain.imglistener = imageDownloadListener;
        Drawable drawbleFromCache = getDrawbleFromCache(obtain);
        if (drawbleFromCache != null) {
            if (isInFriendFeed && options != null && !options.isPreDecode && hasScrolled && !options.disableHitRateReport) {
                Message obtainMessage = imageGetNullOrCancelHandler().obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.obj = obtain;
                obtainMessage.arg1 = 16;
                imageGetNullOrCancelHandler().sendMessage(obtainMessage);
            }
            if (options == null || !options.isGifPlayWhileDownloading) {
                obtain.recycle();
            }
            return drawbleFromCache;
        }
        if (isInFriendFeed && options != null && !options.isPreDecode && hasScrolled && !options.disableHitRateReport) {
            Message obtainMessage2 = imageGetNullOrCancelHandler().obtainMessage();
            obtainMessage2.what = 2;
            obtainMessage2.obj = obtain;
            obtainMessage2.arg1 = 0;
            imageGetNullOrCancelHandler().sendMessage(obtainMessage2);
        }
        ImageTaskTracer.addImageMsgGetNullRecord(obtain.hashCodeEx());
        Message obtainMessage3 = imageGetNullOrCancelHandler().obtainMessage();
        obtainMessage3.what = 0;
        obtainMessage3.obj = obtain;
        imageGetNullOrCancelHandler().sendMessage(obtainMessage3);
        return null;
    }
}
