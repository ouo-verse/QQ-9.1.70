package com.tencent.state.service;

import android.app.ActivityManager;
import android.content.Context;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/state/service/ImageService;", "", "()V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ImageService {
    private static final int CACHE_SIZE_DEFAULT = 1;
    private static final int CACHE_SIZE_MULTIPLE = 16;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_IMAGE_HEIGHT_MEMORY_CACHE = 800;
    private static final int MAX_IMAGE_WIDTH_MEMORY_CACHE = 480;
    private static final int ONE_MB = 1048576;
    private static final String TAG = "ImageService";
    private static final DisplayImageOptions defaultOptions;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/service/ImageService$Companion;", "", "()V", "CACHE_SIZE_DEFAULT", "", "CACHE_SIZE_MULTIPLE", "MAX_IMAGE_HEIGHT_MEMORY_CACHE", "MAX_IMAGE_WIDTH_MEMORY_CACHE", "ONE_MB", "TAG", "", "defaultOptions", "Lcom/nostra13/universalimageloader/core/DisplayImageOptions;", "getDefaultOptions", "()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;", "destroy", "", "getLoader", "Lcom/nostra13/universalimageloader/core/ImageLoader;", "getUniqueImageOptions", LayoutAttrDefine.CLICK_URI, "initImageLoader", "context", "Landroid/content/Context;", "isLargeHeap", "", "removeMemoryCache", "imageAware", "Lcom/nostra13/universalimageloader/core/imageaware/ImageAware;", "targetSize", "Lcom/nostra13/universalimageloader/core/assist/ImageSize;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        private final boolean isLargeHeap(Context context) {
            return (context.getApplicationInfo().flags & 1048576) != 0;
        }

        public final void destroy() {
            ImageLoader imageLoader = ImageLoader.getInstance();
            Intrinsics.checkNotNullExpressionValue(imageLoader, "ImageLoader.getInstance()");
            if (imageLoader.isInited()) {
                ImageLoader.getInstance().clearMemoryCache();
            }
            ImageLoader.getInstance().destroy();
        }

        public final DisplayImageOptions getDefaultOptions() {
            return ImageService.defaultOptions;
        }

        public final ImageLoader getLoader() {
            ImageLoader imageLoader = ImageLoader.getInstance();
            Intrinsics.checkNotNullExpressionValue(imageLoader, "ImageLoader.getInstance()");
            if (imageLoader.isInited()) {
                return ImageLoader.getInstance();
            }
            return null;
        }

        public final DisplayImageOptions getUniqueImageOptions(String r36) {
            Intrinsics.checkNotNullParameter(r36, "uri");
            DisplayImageOptions build = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).displayer(new UniqueImageDisplayer(r36)).build();
            Intrinsics.checkNotNullExpressionValue(build, "DisplayImageOptions.Buil\u2026\n                .build()");
            return build;
        }

        public final void initImageLoader(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ImageLoader imageLoader = ImageLoader.getInstance();
            Intrinsics.checkNotNullExpressionValue(imageLoader, "ImageLoader.getInstance()");
            if (imageLoader.isInited()) {
                return;
            }
            Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (systemService != null) {
                ActivityManager activityManager = (ActivityManager) systemService;
                int memoryClass = activityManager.getMemoryClass();
                if (isLargeHeap(context)) {
                    memoryClass = activityManager.getLargeMemoryClass();
                }
                int i3 = (memoryClass * 1048576) / 8;
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), ImageService.TAG, "uil memory cache is 16M", null, 4, null);
                if (i3 > 16777216) {
                    i3 = 16777216;
                }
                ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(context).memoryCacheExtraOptions(480, 800).threadPoolSize(3).threadPriority(3).tasksProcessingOrder(QueueProcessingType.LIFO).diskCache(SquareBase.INSTANCE.getAvatarDiskCache()).imageDownloader(new SquareImageDownloader(context)).defaultDisplayImageOptions(getDefaultOptions()).memoryCache(new LruMemoryCache(i3)).build());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }

        public final void removeMemoryCache(String r56, ImageAware imageAware, ImageSize targetSize) {
            MemoryCache memoryCache;
            Collection<String> keys;
            boolean startsWith$default;
            MemoryCache memoryCache2;
            Intrinsics.checkNotNullParameter(r56, "uri");
            Intrinsics.checkNotNullParameter(imageAware, "imageAware");
            ImageLoader loader = getLoader();
            if (loader == null || (memoryCache = loader.getMemoryCache()) == null || (keys = memoryCache.keys()) == null) {
                return;
            }
            for (String it : keys) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, r56, false, 2, null);
                if (startsWith$default && (memoryCache2 = loader.getMemoryCache()) != null) {
                    memoryCache2.remove(it);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void removeMemoryCache$default(Companion companion, String str, ImageAware imageAware, ImageSize imageSize, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                imageSize = null;
            }
            companion.removeMemoryCache(str, imageAware, imageSize);
        }
    }

    static {
        DisplayImageOptions build = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "DisplayImageOptions.Buil\u2026rue)\n            .build()");
        defaultOptions = build;
    }
}
