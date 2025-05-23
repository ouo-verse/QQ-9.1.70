package com.tencent.mobileqq.qqecommerce.base.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.support.v4.util.AsyncLruCache;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00013\u0018\u0000 \u00152\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b@\u0010AJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0002J\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J(\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010$\u001a\u00020\tH\u0016J(\u0010%\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016JK\u0010-\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072'\u0010,\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\t0&j\u0002`+H\u0016R\u0014\u00100\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001d\u0010;\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010/R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010>\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/image/ECImageLoader;", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;", "", "key", "path", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "options", "Lcom/tencent/image/URLDrawable;", h.F, "o", "", "reqWidth", "reqHeight", "Landroid/graphics/Bitmap;", "g", "e", "realWidth", "realHeight", "f", "l", MimeHelper.IMAGE_SUBTYPE_BITMAP, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "Lcom/tencent/common/app/BaseApplicationImpl;", "uniqueName", "Ljava/io/File;", "k", "Lcom/jakewharton/disklrucache/DiskLruCache;", "p", "cleanCache", "load", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "fetchDrawable", "a", "I", "maxMemory", "b", "DISK_CACHE_SIZE", "com/tencent/mobileqq/qqecommerce/base/image/ECImageLoader$lruCache$1", "c", "Lcom/tencent/mobileqq/qqecommerce/base/image/ECImageLoader$lruCache$1;", "lruCache", "d", "Lkotlin/Lazy;", "j", "()Lcom/jakewharton/disklrucache/DiskLruCache;", "diskCache", "coreThread", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "threadPool", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECImageLoader implements IECImageLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxMemory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int DISK_CACHE_SIZE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ECImageLoader$lruCache$1 lruCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy diskCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int coreThread;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ThreadPoolExecutor threadPool;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/image/ECImageLoader$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Drawable, Unit> f262410d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f262411e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f262412f;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Drawable, Unit> function1, Context context, String str) {
            this.f262410d = function1;
            this.f262411e = context;
            this.f262412f = str;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState state, Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state.isFinish()) {
                if (option.getAnimatable() != null) {
                    Function1<Drawable, Unit> function1 = this.f262410d;
                    Object animatable = option.getAnimatable();
                    function1.invoke(animatable instanceof Drawable ? (Drawable) animatable : null);
                } else {
                    if (option.getResultBitMap() != null) {
                        this.f262410d.invoke(new BitmapDrawable(this.f262411e.getResources(), option.getResultBitMap()));
                        return;
                    }
                    QLog.e("ECImageLoader", 1, "fetchDrawable failed:" + this.f262412f + ", state:" + state);
                    this.f262410d.invoke(null);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.mobileqq.qqecommerce.base.image.ECImageLoader$lruCache$1] */
    public ECImageLoader() {
        Lazy lazy;
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        this.maxMemory = maxMemory;
        this.DISK_CACHE_SIZE = 52428800;
        final int i3 = maxMemory / 8;
        this.lruCache = new AsyncLruCache<String, Bitmap>(i3) { // from class: com.tencent.mobileqq.qqecommerce.base.image.ECImageLoader$lruCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.support.v4.util.AsyncLruCache
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String key, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                return bitmap.getByteCount() / 1024;
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DiskLruCache>() { // from class: com.tencent.mobileqq.qqecommerce.base.image.ECImageLoader$diskCache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DiskLruCache invoke() {
                DiskLruCache p16;
                p16 = ECImageLoader.this.p();
                return p16;
            }
        });
        this.diskCache = lazy;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.coreThread = availableProcessors;
        this.threadPool = new BaseThreadPoolExecutor(availableProcessors, availableProcessors * 2, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(50));
    }

    private final int e(String path, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        if (options.outMimeType == null) {
            return -1;
        }
        return f(options.outWidth, options.outHeight, reqWidth, reqHeight);
    }

    private final Bitmap g(String path, int reqWidth, int reqHeight) {
        int e16 = e(path, reqWidth, reqHeight);
        if (e16 == -1) {
            Bitmap l3 = l(path);
            if (l3 == null) {
                return null;
            }
            int f16 = f(l3.getWidth(), l3.getHeight(), reqWidth, reqHeight);
            return Bitmap.createScaledBitmap(l3, l3.getWidth() / f16, l3.getHeight() / f16, true);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = e16;
        return BitmapFactory.decodeFile(path, options);
    }

    private final URLDrawable h(String path, Context context, IECImageLoader.ImageLoaderOption options) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (options != null) {
            if (options.getNeedResize()) {
                obtain.mRequestWidth = options.getWidthPx();
                obtain.mRequestHeight = options.getHeightPx();
            }
            obtain.mGifRoundCorner = options.getRadiusPx();
        }
        obtain.mUseMemoryCache = true;
        obtain.mFailedDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        try {
            obtain.mLoadingDrawable = context.getDrawable(R.drawable.ew6);
        } catch (Exception unused) {
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        obtain.mDecodeFileStrategy = 2;
        URLDrawable drawable = URLDrawable.getDrawable(path, obtain);
        drawable.setTargetDensity(context.getResources().getDisplayMetrics().densityDpi);
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        return drawable;
    }

    private final Bitmap i(String key) {
        DiskLruCache j3 = j();
        DiskLruCache.Snapshot snapshot = j3 != null ? j3.get(key) : null;
        if (snapshot != null) {
            return BitmapFactory.decodeStream(snapshot.getInputStream(0));
        }
        return null;
    }

    private final DiskLruCache j() {
        return (DiskLruCache) this.diskCache.getValue();
    }

    private final File k(BaseApplicationImpl context, String uniqueName) {
        File externalCacheDir;
        if (!Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            externalCacheDir = context.getCacheDir();
        } else {
            externalCacheDir = context.getExternalCacheDir();
        }
        File file = new File(externalCacheDir, uniqueName);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private final Bitmap l(String path) {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(path);
                bitmap = mediaMetadataRetriever.getFrameAtTime();
            } catch (Exception e16) {
                QLog.e("ECImageLoader", 1, "MediaMetadataRetriever.setDataSource. path=" + path + ", e=" + e16);
                mediaMetadataRetriever.release();
                bitmap = null;
            }
            return bitmap;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private final void m(final String key, final String path, final ImageView imageView, final IECImageLoader.ImageLoaderOption option) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.base.image.b
            @Override // java.lang.Runnable
            public final void run() {
                ECImageLoader.n(IECImageLoader.ImageLoaderOption.this, imageView, this, key, path);
            }
        };
        Intrinsics.checkNotNullExpressionValue(this.threadPool.getQueue(), "threadPool.queue");
        if (!r9.isEmpty()) {
            try {
                BlockingQueue<Runnable> queue = this.threadPool.getQueue();
                Intrinsics.checkNotNull(queue, "null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<@[FlexibleNullability] java.lang.Runnable?>");
                ((LinkedBlockingDeque) queue).addFirst(runnable);
                return;
            } catch (Exception unused) {
                BlockingQueue<Runnable> queue2 = this.threadPool.getQueue();
                Intrinsics.checkNotNull(queue2, "null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<@[FlexibleNullability] java.lang.Runnable?>");
                ((LinkedBlockingDeque) queue2).removeLast();
                BlockingQueue<Runnable> queue3 = this.threadPool.getQueue();
                Intrinsics.checkNotNull(queue3, "null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<@[FlexibleNullability] java.lang.Runnable?>");
                ((LinkedBlockingDeque) queue3).addFirst(runnable);
                return;
            }
        }
        this.threadPool.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r8v4, types: [T, android.graphics.Bitmap] */
    public static final void n(final IECImageLoader.ImageLoaderOption option, final ImageView imageView, final ECImageLoader this$0, final String key, String path) {
        int width;
        int height;
        Intrinsics.checkNotNullParameter(option, "$option");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(path, "$path");
        if (option.getWidthPx() > 0) {
            width = option.getWidthPx();
        } else {
            width = imageView.getWidth();
        }
        if (option.getHeightPx() > 0) {
            height = option.getHeightPx();
        } else {
            height = imageView.getHeight();
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? i3 = this$0.i(key);
        objectRef.element = i3;
        if (i3 == 0) {
            objectRef.element = this$0.g(path, width, height);
        }
        T t16 = objectRef.element;
        if (t16 != 0) {
            this$0.q(key, (Bitmap) t16);
            ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.image.ECImageLoader$loadImageFromFile$runnable$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ECImageLoader$lruCache$1 eCImageLoader$lruCache$1;
                    eCImageLoader$lruCache$1 = ECImageLoader.this.lruCache;
                    eCImageLoader$lruCache$1.put(key, objectRef.element);
                    if (Intrinsics.areEqual(imageView.getTag(), key)) {
                        imageView.setImageBitmap(objectRef.element);
                    }
                }
            });
        } else {
            QLog.e("ECImageLoader", 1, "loadImageFromFile error. bitmap is null.");
            ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.image.ECImageLoader$loadImageFromFile$runnable$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (Intrinsics.areEqual(imageView.getTag(), key)) {
                        imageView.setImageDrawable(option.getErrorDrawable());
                    }
                }
            });
        }
    }

    private final void o(String path, ImageView imageView, IECImageLoader.ImageLoaderOption options) {
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
        imageView.setImageDrawable(h(path, context, options));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiskLruCache p() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null) {
            return null;
        }
        try {
            return DiskLruCache.open(k(application, MimeHelper.IMAGE_SUBTYPE_BITMAP), 1, 1, this.DISK_CACHE_SIZE);
        } catch (Throwable th5) {
            QLog.e("ECImageLoader", 1, "openDiskCache exception e:" + th5);
            return null;
        }
    }

    private final void q(final String key, final Bitmap bitmap) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.base.image.c
            @Override // java.lang.Runnable
            public final void run() {
                ECImageLoader.r(ECImageLoader.this, key, bitmap);
            }
        };
        Intrinsics.checkNotNullExpressionValue(this.threadPool.getQueue(), "threadPool.queue");
        if (!r2.isEmpty()) {
            if (this.threadPool.getQueue().remainingCapacity() > 10) {
                try {
                    this.threadPool.getQueue().add(runnable);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        this.threadPool.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ECImageLoader this$0, String key, Bitmap bitmap) {
        DiskLruCache.Editor edit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        DiskLruCache j3 = this$0.j();
        if (j3 != null && (edit = j3.edit(key)) != null) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, edit.newOutputStream(0));
            edit.commit();
        }
        DiskLruCache j16 = this$0.j();
        if (j16 != null) {
            j16.flush();
        }
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECImageLoader
    public void fetchDrawable(Context context, String path, IECImageLoader.ImageLoaderOption option, Function1<? super Drawable, Unit> callback) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(path.length() == 0)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "https://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(path, "http://", false, 2, null);
                if (!startsWith$default2) {
                    if (!new File(path).exists()) {
                        callback.invoke(option != null ? option.getErrorDrawable() : null);
                        return;
                    }
                    int widthPx = option != null ? option.getWidthPx() : 0;
                    int heightPx = option != null ? option.getHeightPx() : 0;
                    String b16 = com.tencent.securitysdk.utils.c.b(path + "_" + widthPx + "_" + heightPx);
                    Intrinsics.checkNotNullExpressionValue(b16, "toMD5(\"${path}_${reqWidth}_${reqHeight}\")");
                    String lowerCase = b16.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    Bitmap bitmap = get(lowerCase);
                    if (bitmap == null) {
                        bitmap = g(path, widthPx, heightPx);
                    }
                    if (bitmap == null) {
                        callback.invoke(option != null ? option.getErrorDrawable() : null);
                        return;
                    } else {
                        callback.invoke(new BitmapDrawable(context.getResources(), bitmap));
                        return;
                    }
                }
            }
            URLDrawable h16 = h(path, context, option);
            if (h16.getStatus() == 1) {
                callback.invoke(h16);
                return;
            }
            Option url = Option.obtain().setUrl(path);
            if (option != null) {
                url.setRequestWidth(option.getWidthPx());
                url.setRequestHeight(option.getHeightPx());
                if (option.getDisallowHardwareDecode()) {
                    url.disableHardwareDecode();
                }
            }
            LifecycleOwner a16 = nf2.b.a(context);
            if (a16 != null) {
                url.setLifecycleOwner(a16);
            }
            QCircleFeedPicLoader.g().loadImage(url, new b(callback, context, path));
            return;
        }
        callback.invoke(option != null ? option.getErrorDrawable() : null);
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECImageLoader
    public void load(Context context, String path, ImageView imageView, IECImageLoader.ImageLoaderOption option) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(option, "option");
        if (!(path.length() == 0)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "https://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(path, "http://", false, 2, null);
                if (!startsWith$default2) {
                    if (!new File(path).exists()) {
                        imageView.setImageDrawable(option.getErrorDrawable());
                        return;
                    }
                    String b16 = com.tencent.securitysdk.utils.c.b(path + "_" + option.getWidthPx() + "_" + option.getHeightPx());
                    Intrinsics.checkNotNullExpressionValue(b16, "toMD5(\"${path}_${option.\u2026hPx}_${option.heightPx}\")");
                    String lowerCase = b16.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    Bitmap bitmap = get(lowerCase);
                    if (bitmap == null) {
                        imageView.setTag(lowerCase);
                        imageView.setImageDrawable(option.getLoadingDrawable());
                        m(lowerCase, path, imageView, option);
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                    return;
                }
            }
            o(path, imageView, option);
            return;
        }
        imageView.setImageDrawable(option.getErrorDrawable());
    }

    private final int f(int realWidth, int realHeight, int reqWidth, int reqHeight) {
        int i3 = 1;
        if (reqWidth <= 0 || realHeight <= 0) {
            return 1;
        }
        while (true) {
            if (realHeight / i3 <= reqHeight && realWidth / i3 <= reqWidth) {
                return i3;
            }
            i3 *= 2;
        }
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECImageLoader
    public void cleanCache() {
    }
}
