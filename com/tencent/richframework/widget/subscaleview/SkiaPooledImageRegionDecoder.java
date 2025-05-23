package com.tencent.richframework.widget.subscaleview;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes25.dex */
public class SkiaPooledImageRegionDecoder implements ImageRegionDecoder {
    private static final String TAG = "SkiaPooledImageRegionDecoder";
    private static boolean debug = false;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    private DecoderPool decoderPool;
    private long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class DecoderPool {
        private final Semaphore available;
        private final Map<BitmapRegionDecoder, Boolean> decoders;

        DecoderPool() {
            this.available = new Semaphore(0, true);
            this.decoders = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void add(BitmapRegionDecoder bitmapRegionDecoder) {
            this.decoders.put(bitmapRegionDecoder, Boolean.FALSE);
            this.available.release();
        }

        private synchronized BitmapRegionDecoder getNextAvailable() {
            for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.decoders.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    entry.setValue(Boolean.TRUE);
                    return entry.getKey();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean isEmpty() {
            return this.decoders.isEmpty();
        }

        private synchronized boolean markAsUnused(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.decoders.entrySet()) {
                if (bitmapRegionDecoder == entry.getKey()) {
                    if (!entry.getValue().booleanValue()) {
                        return false;
                    }
                    entry.setValue(Boolean.FALSE);
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void recycle() {
            while (!this.decoders.isEmpty()) {
                BitmapRegionDecoder acquire = acquire();
                acquire.recycle();
                this.decoders.remove(acquire);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release(BitmapRegionDecoder bitmapRegionDecoder) {
            if (markAsUnused(bitmapRegionDecoder)) {
                this.available.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized int size() {
            return this.decoders.size();
        }
    }

    @Keep
    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(String str) {
        if (RFWLog.isColorLevel()) {
            RFWLog.d(TAG, RFWLog.DEV, str);
        }
    }

    private int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseDecoder() throws Exception {
        BitmapRegionDecoder bitmapRegionDecoder;
        Resources resourcesForApplication;
        int i3;
        String uri = this.uri.toString();
        long j3 = Long.MAX_VALUE;
        if (uri.startsWith("android.resource://")) {
            String authority = this.uri.getAuthority();
            if (this.context.getPackageName().equals(authority)) {
                resourcesForApplication = this.context.getResources();
            } else {
                resourcesForApplication = this.context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = this.uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i3 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i3 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                i3 = 0;
            }
            try {
                j3 = this.context.getResources().openRawResourceFd(i3).getLength();
            } catch (Exception unused2) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(i3), false);
        } else if (uri.startsWith("file:///android_asset/")) {
            String substring = uri.substring(22);
            try {
                j3 = this.context.getAssets().openFd(substring).getLength();
            } catch (Exception unused3) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getAssets().open(substring, 1), false);
        } else if (uri.startsWith("file://")) {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(uri.substring(7), false);
            try {
                File file = new File(uri);
                if (file.exists()) {
                    j3 = file.length();
                }
            } catch (Exception unused4) {
            }
            bitmapRegionDecoder = newInstance;
        } else {
            InputStream inputStream = null;
            try {
                ContentResolver contentResolver = this.context.getContentResolver();
                inputStream = contentResolver.openInputStream(this.uri);
                BitmapRegionDecoder newInstance2 = BitmapRegionDecoder.newInstance(inputStream, false);
                try {
                    AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.uri, "r");
                    if (openAssetFileDescriptor != null) {
                        j3 = openAssetFileDescriptor.getLength();
                    }
                } catch (Exception unused5) {
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e16) {
                        RFWLog.e(TAG, RFWLog.USR, e16);
                    }
                }
                bitmapRegionDecoder = newInstance2;
            } catch (Throwable th5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e17) {
                        RFWLog.e(TAG, RFWLog.USR, e17);
                    }
                }
                throw th5;
            }
        }
        this.fileLength = j3;
        this.imageDimensions.set(bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
        this.decoderLock.writeLock().lock();
        try {
            DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.add(bitmapRegionDecoder);
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    private boolean isLowMemory() {
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        }
        return true;
    }

    private void lazyInit() {
        if (this.lazyInited.compareAndSet(false, true) && this.fileLength < Long.MAX_VALUE) {
            debug("Starting lazy init of additional decoders");
            RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.richframework.widget.subscaleview.SkiaPooledImageRegionDecoder.1
                @Override // java.lang.Runnable
                public void run() {
                    while (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                        SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                        if (skiaPooledImageRegionDecoder.allowAdditionalDecoder(skiaPooledImageRegionDecoder.decoderPool.size(), SkiaPooledImageRegionDecoder.this.fileLength)) {
                            try {
                                if (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    SkiaPooledImageRegionDecoder.this.debug("Starting decoder");
                                    SkiaPooledImageRegionDecoder.this.initialiseDecoder();
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    SkiaPooledImageRegionDecoder.this.debug("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                                }
                            } catch (Exception e16) {
                                SkiaPooledImageRegionDecoder.this.debug("Failed to start decoder: " + e16.getMessage());
                            }
                        } else {
                            return;
                        }
                    }
                }
            });
        }
    }

    @Keep
    public static void setDebug(boolean z16) {
        debug = z16;
    }

    protected boolean allowAdditionalDecoder(int i3, long j3) {
        if (i3 >= 4) {
            debug("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j16 = i3 * j3;
        if (j16 > QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
            debug("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        }
        if (i3 >= getNumberOfCores()) {
            debug("No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")");
            return false;
        }
        if (isLowMemory()) {
            debug("No additional encoders allowed, memory is low");
            return false;
        }
        debug("Additional decoder allowed, current count is " + i3 + ", estimated native memory " + (j16 / 1048576) + "Mb");
        return true;
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageRegionDecoder
    @NonNull
    public Bitmap decodeRegion(@NonNull Rect rect, int i3) {
        debug("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.imageDimensions.x || rect.height() < this.imageDimensions.y) {
            lazyInit();
        }
        this.decoderLock.readLock().lock();
        try {
            DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                BitmapRegionDecoder acquire = decoderPool.acquire();
                if (acquire != null) {
                    try {
                        if (!acquire.isRecycled()) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = i3;
                            options.inPreferredConfig = this.bitmapConfig;
                            Bitmap decodeRegion = acquire.decodeRegion(rect, options);
                            if (decodeRegion != null) {
                                return decodeRegion;
                            }
                            throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                        }
                    } finally {
                        this.decoderPool.release(acquire);
                    }
                }
                if (acquire != null) {
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            this.decoderLock.readLock().unlock();
        }
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageRegionDecoder
    @NonNull
    public Point init(Context context, @NonNull Uri uri) throws Exception {
        this.context = context;
        this.uri = uri;
        initialiseDecoder();
        return this.imageDimensions;
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageRegionDecoder
    public synchronized boolean isReady() {
        boolean z16;
        DecoderPool decoderPool = this.decoderPool;
        if (decoderPool != null) {
            if (!decoderPool.isEmpty()) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.recycle();
                this.decoderPool = null;
                this.context = null;
                this.uri = null;
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    public SkiaPooledImageRegionDecoder(@Nullable Bitmap.Config config) {
        this.decoderPool = new DecoderPool();
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = Bitmap.Config.RGB_565;
        }
    }
}
