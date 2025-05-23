package com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.videocut.utils.VideoUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 (2\u00020\u0001:\u0004\n)\u0010*B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u001c\u0010\u0012\u001a\b\u0018\u00010\u000fR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/e;", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "l", "i", "", "timeUs", "a", "release", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/j;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/j;", "generatorSupplier", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageRunnable;", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageRunnable;", "runnable", "Lcom/tencent/tavcut/model/ClipSource;", "c", "Lcom/tencent/tavcut/model/ClipSource;", "clipSource", "Lhe4/a;", "d", "Lhe4/a;", "thumbProvider", "Lcom/tencent/tavcut/composition/model/component/Size;", "e", "Lcom/tencent/tavcut/composition/model/component/Size;", "size", "Ljava/util/concurrent/BlockingQueue;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper$b;", "f", "Ljava/util/concurrent/BlockingQueue;", "videoThumbTaskQueue", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/g;", "model", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/j;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/g;)V", "g", "ImageRunnable", "ReleaseRunnable", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ThumbnailGeneratorHelper implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j generatorSupplier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile ImageRunnable runnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ClipSource clipSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private he4.a thumbProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Size size;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BlockingQueue<b> videoThumbTaskQueue;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper$b;", "f", "", "g", "", "e", "release", tl.h.F, TencentLocation.RUN_MODE, "", "d", "I", "retryCount", "Z", "isPause", "isRelease", "isTimeOut", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class ImageRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int retryCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isPause;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isRelease;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean isTimeOut;

        public ImageRunnable() {
        }

        private final boolean e() {
            if (!this.isPause && !this.isRelease && !ThumbnailGeneratorHelper.this.videoThumbTaskQueue.isEmpty()) {
                return true;
            }
            return false;
        }

        private final b f() {
            b bVar;
            InterruptedException e16;
            Long l3 = null;
            try {
                bVar = (b) ThumbnailGeneratorHelper.this.videoThumbTaskQueue.poll(2000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e17) {
                bVar = null;
                e16 = e17;
            }
            try {
                Logger logger = Logger.f275870a;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.getStartTimeUs());
                }
                logger.f("VideoThumbImageGenerator", "run: startTime is " + l3);
            } catch (InterruptedException e18) {
                e16 = e18;
                Logger.f275870a.e("VideoThumbImageGenerator", e16);
                return bVar;
            }
            return bVar;
        }

        private final void g() {
            ThumbnailGeneratorHelper.this.runnable = null;
            ThumbnailGeneratorHelper.this.l();
            if (this.isRelease || this.isTimeOut) {
                ThumbnailGeneratorHelper.this.k();
            }
        }

        public final void h(boolean release) {
            this.isRelease = release;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x004a A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Bitmap bitmap;
            he4.a aVar;
            ThumbnailGeneratorHelper.this.j();
            while (true) {
                if (!e()) {
                    break;
                }
                b f16 = f();
                if (f16 != null) {
                    try {
                        aVar = ThumbnailGeneratorHelper.this.thumbProvider;
                    } catch (Throwable th5) {
                        Logger.f275870a.d("VideoThumbImageGenerator", "getThumbAtTime failed: " + th5.getMessage(), th5);
                    }
                    if (aVar != null) {
                        bitmap = aVar.getThumbAtTime(f16.getStartTimeUs());
                        if (bitmap == null) {
                            ThumbnailGeneratorHelper.this.generatorSupplier.getGeneratedListener().a(null, f16.getStartTimeUs(), bitmap);
                        } else {
                            try {
                                int i3 = this.retryCount;
                                if (i3 <= 3) {
                                    int i16 = i3 + 1;
                                    this.retryCount = i16;
                                    Logger.f275870a.f("VideoThumbImageGenerator", "run: retry is " + i16);
                                    ThumbnailGeneratorHelper.this.videoThumbTaskQueue.put(f16);
                                }
                            } catch (InterruptedException e16) {
                                Logger.f275870a.e("VideoThumbImageGenerator", e16);
                            }
                        }
                    }
                    bitmap = null;
                    if (bitmap == null) {
                    }
                } else {
                    this.isTimeOut = true;
                    break;
                }
            }
            g();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ReleaseRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper;)V", TencentLocation.RUN_MODE, "", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    private final class ReleaseRunnable implements Runnable {
        public ReleaseRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ThumbnailGeneratorHelper.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0007\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailGeneratorHelper$b;", "", "other", "", "c", "", "d", "J", "requestTimeMs", "e", tl.h.F, "()J", "startTimeUs", "<init>", "(JJ)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long requestTimeMs;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long startTimeUs;

        public b(long j3, long j16) {
            this.requestTimeMs = j3;
            this.startTimeUs = j16;
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull b other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return (int) (this.requestTimeMs - other.requestTimeMs);
        }

        /* renamed from: h, reason: from getter */
        public final long getStartTimeUs() {
            return this.startTimeUs;
        }
    }

    public ThumbnailGeneratorHelper(@NotNull j generatorSupplier, @NotNull ThumbAssetModel model) {
        ClipSource b16;
        Intrinsics.checkNotNullParameter(generatorSupplier, "generatorSupplier");
        Intrinsics.checkNotNullParameter(model, "model");
        this.generatorSupplier = generatorSupplier;
        int i3 = 0;
        this.size = new Size(i3, i3, null, 4, null);
        this.videoThumbTaskQueue = new PriorityBlockingQueue();
        if (model.getType() == 1) {
            b16 = od4.b.f422509e.m().a(model.getAssetPath(), new TimeRange(0L, model.getSourceTimeDurationUs(), null, 4, null));
        } else {
            b16 = od4.b.f422509e.m().b(model.getAssetPath(), new TimeRange(0L, model.getSourceTimeDurationUs(), null, 4, null));
        }
        this.clipSource = b16;
    }

    private final void i() {
        Integer num;
        Pair pair;
        Integer num2 = this.size.height;
        if (num2 != null && num2.intValue() == 0 && (num = this.size.width) != null && num.intValue() == 0) {
            Size size = new Size(Integer.valueOf(this.generatorSupplier.getThumbnailWidth()), Integer.valueOf(this.generatorSupplier.getThumbnailHeight()), null, 4, null);
            Pair<Integer, Integer> c16 = VideoUtils.f384231a.c(this.clipSource.path);
            int intValue = c16.component1().intValue();
            int intValue2 = c16.component2().intValue();
            if (intValue != 0 && intValue2 != 0) {
                float f16 = intValue / intValue2;
                if (f16 > 1.0f) {
                    float thumbnailWidth = this.generatorSupplier.getThumbnailWidth();
                    pair = TuplesKt.to(Float.valueOf(thumbnailWidth), Float.valueOf(thumbnailWidth * f16));
                } else {
                    float thumbnailWidth2 = this.generatorSupplier.getThumbnailWidth();
                    pair = TuplesKt.to(Float.valueOf(thumbnailWidth2 / f16), Float.valueOf(thumbnailWidth2));
                }
                size = new Size(Integer.valueOf((int) ((Number) pair.component2()).floatValue()), Integer.valueOf((int) ((Number) pair.component1()).floatValue()), null, 4, null);
            }
            this.size = size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (this.thumbProvider == null) {
            ClipSource clipSource = this.clipSource;
            i();
            this.thumbProvider = od4.b.f422509e.i(clipSource, this.size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        Logger.f275870a.f("VideoThumbImageGenerator", "releaseQueue:");
        this.videoThumbTaskQueue.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        he4.a aVar = this.thumbProvider;
        if (aVar != null) {
            aVar.release();
        }
        this.thumbProvider = null;
    }

    private final void m() {
        if (this.runnable != null) {
            Logger.f275870a.f("VideoThumbImageGenerator", "mRunnable is run");
        } else {
            this.runnable = new ImageRunnable();
            this.generatorSupplier.getGenerateHandler().postRunnable(this.runnable);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.e
    public void a(long timeUs) {
        Logger.f275870a.f("VideoThumbImageGenerator", "generateCoverByTime:" + timeUs);
        try {
            this.videoThumbTaskQueue.put(new b(System.currentTimeMillis(), timeUs));
        } catch (InterruptedException e16) {
            Logger.f275870a.e("VideoThumbImageGenerator", e16);
        }
        m();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.e
    public void release() {
        if (this.runnable != null) {
            ImageRunnable imageRunnable = this.runnable;
            if (imageRunnable != null) {
                imageRunnable.h(true);
                return;
            }
            return;
        }
        k();
        this.generatorSupplier.getGenerateHandler().postRunnable(new ReleaseRunnable());
    }
}
