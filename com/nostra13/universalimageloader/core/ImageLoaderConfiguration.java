package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ImageLoaderConfiguration {
    final boolean customExecutor;
    final boolean customExecutorForCachedImages;
    final ImageDecoder decoder;
    final DisplayImageOptions defaultDisplayImageOptions;
    final DiskCache diskCache;
    final ImageDownloader downloader;
    final int maxImageHeightForDiskCache;
    final int maxImageHeightForMemoryCache;
    final int maxImageWidthForDiskCache;
    final int maxImageWidthForMemoryCache;
    final MemoryCache memoryCache;
    final ImageDownloader networkDeniedDownloader;
    final BitmapProcessor processorForDiskCache;
    final Resources resources;
    final ImageDownloader slowNetworkDownloader;
    final Executor taskExecutor;
    final Executor taskExecutorForCachedImages;
    final QueueProcessingType tasksProcessingType;
    final int threadPoolSize;
    final int threadPriority;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.nostra13.universalimageloader.core.ImageLoaderConfiguration$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 3;
        private static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
        private static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
        private static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        private static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
        private Context context;
        private ImageDecoder decoder;
        private int maxImageWidthForMemoryCache = 0;
        private int maxImageHeightForMemoryCache = 0;
        private int maxImageWidthForDiskCache = 0;
        private int maxImageHeightForDiskCache = 0;
        private BitmapProcessor processorForDiskCache = null;
        private Executor taskExecutor = null;
        private Executor taskExecutorForCachedImages = null;
        private boolean customExecutor = false;
        private boolean customExecutorForCachedImages = false;
        private int threadPoolSize = 3;
        private int threadPriority = 3;
        private boolean denyCacheImageMultipleSizesInMemory = false;
        private QueueProcessingType tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
        private int memoryCacheSize = 0;
        private long diskCacheSize = 0;
        private int diskCacheFileCount = 0;
        private MemoryCache memoryCache = null;
        private DiskCache diskCache = null;
        private FileNameGenerator diskCacheFileNameGenerator = null;
        private ImageDownloader downloader = null;
        private DisplayImageOptions defaultDisplayImageOptions = null;
        private boolean writeLogs = false;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.taskExecutor == null) {
                this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutor = true;
            }
            if (this.taskExecutorForCachedImages == null) {
                this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutorForCachedImages = true;
            }
            if (this.diskCache == null) {
                if (this.diskCacheFileNameGenerator == null) {
                    this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
                }
                this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount);
            }
            if (this.memoryCache == null) {
                this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.context, this.memoryCacheSize);
            }
            if (this.denyCacheImageMultipleSizesInMemory) {
                this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
            }
            if (this.downloader == null) {
                this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
            }
            if (this.decoder == null) {
                this.decoder = DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
            }
        }

        public ImageLoaderConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayImageOptions) {
            this.defaultDisplayImageOptions = displayImageOptions;
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory() {
            this.denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        @Deprecated
        public Builder discCache(DiskCache diskCache) {
            return diskCache(diskCache);
        }

        @Deprecated
        public Builder discCacheExtraOptions(int i3, int i16, BitmapProcessor bitmapProcessor) {
            return diskCacheExtraOptions(i3, i16, bitmapProcessor);
        }

        @Deprecated
        public Builder discCacheFileCount(int i3) {
            return diskCacheFileCount(i3);
        }

        @Deprecated
        public Builder discCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            return diskCacheFileNameGenerator(fileNameGenerator);
        }

        @Deprecated
        public Builder discCacheSize(int i3) {
            return diskCacheSize(i3);
        }

        public Builder diskCache(DiskCache diskCache) {
            if (this.diskCacheSize > 0 || this.diskCacheFileCount > 0) {
                L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
            }
            if (this.diskCacheFileNameGenerator != null) {
                L.w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCache = diskCache;
            return this;
        }

        public Builder diskCacheExtraOptions(int i3, int i16, BitmapProcessor bitmapProcessor) {
            this.maxImageWidthForDiskCache = i3;
            this.maxImageHeightForDiskCache = i16;
            this.processorForDiskCache = bitmapProcessor;
            return this;
        }

        public Builder diskCacheFileCount(int i3) {
            if (i3 > 0) {
                if (this.diskCache != null) {
                    L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                this.diskCacheFileCount = i3;
                return this;
            }
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }

        public Builder diskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            if (this.diskCache != null) {
                L.w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCacheFileNameGenerator = fileNameGenerator;
            return this;
        }

        public Builder diskCacheSize(int i3) {
            if (i3 > 0) {
                if (this.diskCache != null) {
                    L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                this.diskCacheSize = i3;
                return this;
            }
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }

        public Builder imageDecoder(ImageDecoder imageDecoder) {
            this.decoder = imageDecoder;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imageDownloader) {
            this.downloader = imageDownloader;
            return this;
        }

        public Builder memoryCache(MemoryCache memoryCache) {
            if (this.memoryCacheSize != 0) {
                L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCache = memoryCache;
            return this;
        }

        public Builder memoryCacheExtraOptions(int i3, int i16) {
            this.maxImageWidthForMemoryCache = i3;
            this.maxImageHeightForMemoryCache = i16;
            return this;
        }

        public Builder memoryCacheSize(int i3) {
            if (i3 > 0) {
                if (this.memoryCache != null) {
                    L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                }
                this.memoryCacheSize = i3;
                return this;
            }
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }

        public Builder memoryCacheSizePercentage(int i3) {
            if (i3 > 0 && i3 < 100) {
                if (this.memoryCache != null) {
                    L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                }
                this.memoryCacheSize = (int) (((float) Runtime.getRuntime().maxMemory()) * (i3 / 100.0f));
                return this;
            }
            throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
        }

        public Builder taskExecutor(Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutor = executor;
            return this;
        }

        public Builder taskExecutorForCachedImages(Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutorForCachedImages = executor;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueProcessingType) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.tasksProcessingType = queueProcessingType;
            return this;
        }

        public Builder threadPoolSize(int i3) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.threadPoolSize = i3;
            return this;
        }

        public Builder threadPriority(int i3) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            if (i3 < 1) {
                this.threadPriority = 1;
            } else if (i3 > 10) {
                this.threadPriority = 10;
            } else {
                this.threadPriority = i3;
            }
            return this;
        }

        public Builder writeDebugLogs() {
            this.writeLogs = true;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class NetworkDeniedImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public NetworkDeniedImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) throws IOException {
            int i3 = AnonymousClass1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i3 != 1 && i3 != 2) {
                return this.wrappedDownloader.getStream(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class SlowNetworkImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public SlowNetworkImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) throws IOException {
            InputStream stream = this.wrappedDownloader.getStream(str, obj);
            int i3 = AnonymousClass1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i3 != 1 && i3 != 2) {
                return stream;
            }
            return new FlushedInputStream(stream);
        }
    }

    /* synthetic */ ImageLoaderConfiguration(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static ImageLoaderConfiguration createDefault(Context context) {
        return new Builder(context).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageSize getMaxImageSize() {
        DisplayMetrics displayMetrics = this.resources.getDisplayMetrics();
        int i3 = this.maxImageWidthForMemoryCache;
        if (i3 <= 0) {
            i3 = displayMetrics.widthPixels;
        }
        int i16 = this.maxImageHeightForMemoryCache;
        if (i16 <= 0) {
            i16 = displayMetrics.heightPixels;
        }
        return new ImageSize(i3, i16);
    }

    ImageLoaderConfiguration(Builder builder) {
        this.resources = builder.context.getResources();
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiskCache = builder.maxImageWidthForDiskCache;
        this.maxImageHeightForDiskCache = builder.maxImageHeightForDiskCache;
        this.processorForDiskCache = builder.processorForDiskCache;
        this.taskExecutor = builder.taskExecutor;
        this.taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
        this.threadPoolSize = builder.threadPoolSize;
        this.threadPriority = builder.threadPriority;
        this.tasksProcessingType = builder.tasksProcessingType;
        this.diskCache = builder.diskCache;
        this.memoryCache = builder.memoryCache;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        ImageDownloader imageDownloader = builder.downloader;
        this.downloader = imageDownloader;
        this.decoder = builder.decoder;
        this.customExecutor = builder.customExecutor;
        this.customExecutorForCachedImages = builder.customExecutorForCachedImages;
        this.networkDeniedDownloader = new NetworkDeniedImageDownloader(imageDownloader);
        this.slowNetworkDownloader = new SlowNetworkImageDownloader(imageDownloader);
        L.writeDebugLogs(builder.writeLogs);
    }
}
