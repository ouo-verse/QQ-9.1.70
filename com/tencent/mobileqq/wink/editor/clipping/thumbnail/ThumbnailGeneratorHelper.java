package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.cover.ICoverProvider;
import com.tencent.tavcut.core.render.thumb.IThumbProvider;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.LAKCutSession;
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
import org.light.lightAssetKit.LightAssetUtils;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 C2\u00020\u0001:\u0004\u000eD\rEB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0018\u00010\u0018R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/f;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "p", "l", "", "timeUs", "Landroid/graphics/Bitmap;", "b", "a", "release", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/m;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/m;", "generatorSupplier", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "model", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageRunnable;", "c", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageRunnable;", "runnable", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "d", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipSource", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "e", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "thumbProvider", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "f", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "coverProvider", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "g", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "getRenderModel", "()Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;)V", "renderModel", "", tl.h.F, "Z", "getUseCoverProvider", "()Z", "t", "(Z)V", "useCoverProvider", "Lorg/light/lightAssetKit/components/Size;", "i", "Lorg/light/lightAssetKit/components/Size;", "size", "Ljava/util/concurrent/BlockingQueue;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$b;", "j", "Ljava/util/concurrent/BlockingQueue;", "videoThumbTaskQueue", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/m;Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;)V", "k", "ImageRunnable", "ReleaseRunnable", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ThumbnailGeneratorHelper implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m generatorSupplier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ThumbAssetModel model;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile ImageRunnable runnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ClipSource clipSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IThumbProvider thumbProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ICoverProvider coverProvider;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LAKRenderModel renderModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean useCoverProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Size size;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BlockingQueue<b> videoThumbTaskQueue;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$b;", "f", "", "g", "", "e", "release", tl.h.F, TencentLocation.RUN_MODE, "", "d", "I", "retryCount", "Z", "isPause", "isRelease", "isTimeOut", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
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
            if (com.tencent.mobileqq.wink.l.g() && !this.isPause && !this.isRelease && !ThumbnailGeneratorHelper.this.videoThumbTaskQueue.isEmpty()) {
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
                if (bVar != null) {
                    try {
                        l3 = Long.valueOf(bVar.getStartTimeUs());
                    } catch (InterruptedException e17) {
                        e16 = e17;
                        w53.b.e("VideoThumbImageGenerator", e16);
                        return bVar;
                    }
                }
                QLog.i("VideoThumbImageGenerator", 4, "run: startTime is " + l3);
            } catch (InterruptedException e18) {
                bVar = null;
                e16 = e18;
            }
            return bVar;
        }

        private final void g() {
            ThumbnailGeneratorHelper.this.runnable = null;
            ThumbnailGeneratorHelper.this.r();
            if (this.isRelease || this.isTimeOut) {
                ThumbnailGeneratorHelper.this.p();
                ThumbnailGeneratorHelper.this.q();
            }
        }

        public final void h(boolean release) {
            this.isRelease = release;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0080 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Bitmap bitmap;
            Bitmap bitmap2;
            ThumbnailGeneratorHelper.this.o();
            while (true) {
                if (!e()) {
                    break;
                }
                b f16 = f();
                if (f16 == null) {
                    this.isTimeOut = true;
                    break;
                }
                try {
                    if (ThumbnailGeneratorHelper.this.coverProvider != null) {
                        ICoverProvider iCoverProvider = ThumbnailGeneratorHelper.this.coverProvider;
                        if (iCoverProvider != null) {
                            bitmap2 = iCoverProvider.getCoverAtTime(f16.getStartTimeUs() / 1000);
                        } else {
                            bitmap2 = null;
                        }
                        try {
                            QLog.i("VideoThumbImageGenerator", 4, "guwen cover bitmap = " + bitmap2);
                        } catch (Exception e16) {
                            bitmap = bitmap2;
                            e = e16;
                            QLog.e("VideoThumbImageGenerator", 1, e, new Object[0]);
                            bitmap2 = bitmap;
                            if (bitmap2 != null) {
                            }
                        } catch (OutOfMemoryError e17) {
                            bitmap = bitmap2;
                            e = e17;
                            QLog.e("VideoThumbImageGenerator", 1, e, new Object[0]);
                            bitmap2 = bitmap;
                            if (bitmap2 != null) {
                            }
                        }
                    } else {
                        IThumbProvider iThumbProvider = ThumbnailGeneratorHelper.this.thumbProvider;
                        if (iThumbProvider != null) {
                            bitmap2 = iThumbProvider.getThumbAtTime(f16.getStartTimeUs());
                        } else {
                            bitmap2 = null;
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    bitmap = null;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    bitmap = null;
                }
                if (bitmap2 != null) {
                    ThumbnailGeneratorHelper.this.generatorSupplier.getGeneratedListener().a(null, f16.getStartTimeUs(), bitmap2);
                } else {
                    try {
                        int i3 = this.retryCount;
                        if (i3 <= 3) {
                            int i16 = i3 + 1;
                            this.retryCount = i16;
                            QLog.i("VideoThumbImageGenerator", 4, "run: retry is " + i16);
                            ThumbnailGeneratorHelper.this.videoThumbTaskQueue.put(f16);
                        }
                    } catch (InterruptedException e26) {
                        w53.b.e("VideoThumbImageGenerator", e26);
                    }
                }
            }
            g();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ReleaseRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper;)V", TencentLocation.RUN_MODE, "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    private final class ReleaseRunnable implements Runnable {
        public ReleaseRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ThumbnailGeneratorHelper.this.r();
            ThumbnailGeneratorHelper.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0007\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$b;", "", "other", "", "c", "", "d", "J", "requestTimeMs", "e", tl.h.F, "()J", "startTimeUs", "<init>", "(JJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
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
            return (int) (this.startTimeUs - other.startTimeUs);
        }

        /* renamed from: h, reason: from getter */
        public final long getStartTimeUs() {
            return this.startTimeUs;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$c", "Lcom/tencent/tavcut/core/operator/b;", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends com.tencent.tavcut.core.operator.b {
        c() {
        }

        @Override // com.tencent.tavcut.core.operator.b, com.tencent.tavcut.core.operator.c
        /* renamed from: b */
        public boolean getF318735b() {
            return false;
        }
    }

    public ThumbnailGeneratorHelper(@NotNull m generatorSupplier, @NotNull ThumbAssetModel model) {
        ClipSource b16;
        Intrinsics.checkNotNullParameter(generatorSupplier, "generatorSupplier");
        Intrinsics.checkNotNullParameter(model, "model");
        this.generatorSupplier = generatorSupplier;
        this.model = model;
        this.size = new Size(0, 0);
        this.videoThumbTaskQueue = new PriorityBlockingQueue();
        if (model.getType() == 1) {
            b16 = rd4.c.f431135f.n().a(model.getAssetPath(), new TimeRange(0L, model.getSourceTimeDurationUs()));
        } else {
            b16 = rd4.c.f431135f.n().b(model.getAssetPath(), new TimeRange(0L, model.getSourceTimeDurationUs()));
        }
        this.clipSource = b16;
    }

    private final void l() {
        Pair pair;
        Size size = this.size;
        if (size.height == 0 && size.width == 0) {
            Size size2 = new Size(this.generatorSupplier.getThumbnailWidth(), this.generatorSupplier.getThumbnailHeight());
            Pair<Integer, Integer> c16 = VideoUtils.f384231a.c(this.clipSource.getPath());
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
                size2 = new Size((int) ((Number) pair.component2()).floatValue(), (int) ((Number) pair.component1()).floatValue());
            }
            this.size = size2;
        }
    }

    private final void m() {
        LAKRenderModel lAKRenderModel = this.renderModel;
        if (lAKRenderModel != null) {
            ICutSession createLAKCutSession = LAKCutSession.INSTANCE.createLAKCutSession();
            createLAKCutSession.getIClipSourceOperator().h(new c());
            createLAKCutSession.setRenderModel(lAKRenderModel);
            String w3 = WinkExportUtils.w();
            Intrinsics.checkNotNullExpressionValue(w3, "getDefaultTemplateDir()");
            createLAKCutSession.setTemplateDir(w3);
            createLAKCutSession.updateRenderSize(this.size, 0.0f);
            createLAKCutSession.flushWithoutDelay();
            LAKRenderModel allInputSourceRenderModel = createLAKCutSession.getAllInputSourceRenderModel();
            if (allInputSourceRenderModel != null) {
                allInputSourceRenderModel.setJsonData(LightAssetUtils.getAssetJsonString(createLAKCutSession.getLightAsset()));
                w53.b.f("VideoThumbImageGenerator", "jsonString = " + allInputSourceRenderModel.getJsonData());
                rd4.c cVar = rd4.c.f431135f;
                Size size = this.size;
                String w16 = WinkExportUtils.w();
                Intrinsics.checkNotNullExpressionValue(w16, "getDefaultTemplateDir()");
                this.coverProvider = rd4.c.e(cVar, allInputSourceRenderModel, size, w16, null, null, 16, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        l();
        Size size = this.size;
        w53.b.f("VideoThumbImageGenerator", "initThumbGenerator:" + size.height + ", " + size.width + ", useCoverProvider = " + this.useCoverProvider);
        if (this.useCoverProvider) {
            if (this.coverProvider == null) {
                m();
            }
        } else if (this.thumbProvider == null) {
            this.thumbProvider = rd4.c.f431135f.i(this.clipSource, this.size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        QLog.i("VideoThumbImageGenerator", 4, "releaseCoverGenerator");
        ICoverProvider iCoverProvider = this.coverProvider;
        if (iCoverProvider != null) {
            iCoverProvider.release();
        }
        this.coverProvider = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        QLog.i("VideoThumbImageGenerator", 4, "releaseQueue:");
        this.videoThumbTaskQueue.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        IThumbProvider iThumbProvider = this.thumbProvider;
        if (iThumbProvider != null) {
            iThumbProvider.release();
        }
        this.thumbProvider = null;
    }

    private final void u() {
        if (this.runnable != null) {
            QLog.i("VideoThumbImageGenerator", 4, "mRunnable is run");
        } else {
            this.runnable = new ImageRunnable();
            this.generatorSupplier.getGenerateHandler().postRunnable(this.runnable);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.f
    public void a(long timeUs) {
        QLog.i("VideoThumbImageGenerator", 4, "generateCoverByTime:" + timeUs);
        try {
            this.videoThumbTaskQueue.put(new b(System.currentTimeMillis(), timeUs));
        } catch (InterruptedException e16) {
            w53.b.e("VideoThumbImageGenerator", e16);
        }
        u();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.f
    @Nullable
    public Bitmap b(long timeUs) {
        return null;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final ThumbAssetModel getModel() {
        return this.model;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.f
    public void release() {
        if (this.runnable != null) {
            ImageRunnable imageRunnable = this.runnable;
            if (imageRunnable != null) {
                imageRunnable.h(true);
                return;
            }
            return;
        }
        q();
        this.generatorSupplier.getGenerateHandler().postRunnable(new ReleaseRunnable());
    }

    public final void s(@Nullable LAKRenderModel lAKRenderModel) {
        this.renderModel = lAKRenderModel;
    }

    public final void t(boolean z16) {
        this.useCoverProvider = z16;
    }
}
