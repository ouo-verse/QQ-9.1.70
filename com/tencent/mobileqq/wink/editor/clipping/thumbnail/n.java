package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.cover.ICoverProvider;
import com.tencent.tavcut.core.render.thumb.IThumbProvider;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.videocut.utils.VideoUtils;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0017J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u000f\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/n;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/f;", "", "e", "d", "g", "f", "c", "", "timeUs", "Landroid/graphics/Bitmap;", "b", "a", "release", "Lorg/light/lightAssetKit/components/Size;", "Lorg/light/lightAssetKit/components/Size;", "renderSize", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "getModel", "()Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "model", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipSource", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "thumbProvider", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "coverProvider", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "getRenderModel", "()Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", tl.h.F, "(Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;)V", "renderModel", "", "Z", "getUseCoverProvider", "()Z", "i", "(Z)V", "useCoverProvider", "size", "<init>", "(Lorg/light/lightAssetKit/components/Size;Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class n implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Size renderSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ThumbAssetModel model;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ClipSource clipSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IThumbProvider thumbProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ICoverProvider coverProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LAKRenderModel renderModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean useCoverProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Size size;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/thumbnail/n$b", "Lcom/tencent/tavcut/core/operator/b;", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.tavcut.core.operator.b {
        b() {
        }

        @Override // com.tencent.tavcut.core.operator.b, com.tencent.tavcut.core.operator.c
        /* renamed from: b */
        public boolean getF318735b() {
            return false;
        }
    }

    public n(@NotNull Size renderSize, @NotNull ThumbAssetModel model) {
        ClipSource b16;
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        Intrinsics.checkNotNullParameter(model, "model");
        this.renderSize = renderSize;
        this.model = model;
        this.size = new Size(0, 0);
        if (model.getType() == 1) {
            b16 = rd4.c.f431135f.n().a(model.getAssetPath(), new TimeRange(0L, model.getSourceTimeDurationUs()));
        } else {
            b16 = rd4.c.f431135f.n().b(model.getAssetPath(), new TimeRange(0L, model.getSourceTimeDurationUs()));
        }
        this.clipSource = b16;
    }

    private final void c() {
        Pair pair;
        Size size = this.size;
        if (size.height == 0 && size.width == 0) {
            Size size2 = this.renderSize;
            Pair<Integer, Integer> c16 = VideoUtils.f384231a.c(this.clipSource.getPath());
            int intValue = c16.component1().intValue();
            int intValue2 = c16.component2().intValue();
            if (intValue != 0 && intValue2 != 0) {
                float f16 = intValue / intValue2;
                if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_optimize_auto_music_2")) {
                    if (f16 > 1.0f) {
                        float f17 = this.renderSize.height;
                        pair = TuplesKt.to(Float.valueOf(f17), Float.valueOf(f17 * f16));
                    } else {
                        float f18 = this.renderSize.width;
                        pair = TuplesKt.to(Float.valueOf(f18 / f16), Float.valueOf(f18));
                    }
                } else if (f16 > 1.0f) {
                    float f19 = this.renderSize.height;
                    pair = TuplesKt.to(Float.valueOf(f19), Float.valueOf(f19 * f16));
                } else {
                    float f26 = this.renderSize.width;
                    pair = TuplesKt.to(Float.valueOf(f26 / f16), Float.valueOf(f26));
                }
                size2 = new Size((int) ((Number) pair.component2()).floatValue(), (int) ((Number) pair.component1()).floatValue());
            }
            this.size = size2;
        }
    }

    private final void d() {
        LAKRenderModel lAKRenderModel = this.renderModel;
        if (lAKRenderModel != null) {
            ICutSession createLAKCutSession = LAKCutSession.INSTANCE.createLAKCutSession();
            createLAKCutSession.getIClipSourceOperator().h(new b());
            createLAKCutSession.setRenderModel(lAKRenderModel);
            String w3 = WinkExportUtils.w();
            Intrinsics.checkNotNullExpressionValue(w3, "getDefaultTemplateDir()");
            createLAKCutSession.setTemplateDir(w3);
            createLAKCutSession.updateRenderSize(this.size, 0.0f);
            createLAKCutSession.flushWithoutDelay();
            LAKRenderModel allInputSourceRenderModel = createLAKCutSession.getAllInputSourceRenderModel();
            if (allInputSourceRenderModel != null) {
                allInputSourceRenderModel.setJsonData(LightAssetUtils.getAssetJsonString(createLAKCutSession.getLightAsset()));
                w53.b.f("ThumbnailGeneratorSyncHelper", "jsonString = " + allInputSourceRenderModel.getJsonData());
                rd4.c cVar = rd4.c.f431135f;
                Size size = this.size;
                String w16 = WinkExportUtils.w();
                Intrinsics.checkNotNullExpressionValue(w16, "getDefaultTemplateDir()");
                this.coverProvider = rd4.c.e(cVar, allInputSourceRenderModel, size, w16, null, null, 16, null);
            }
        }
    }

    private final void e() {
        Size size = this.size;
        w53.b.f("ThumbnailGeneratorSyncHelper", "initThumbGenerator:" + size.height + ", " + size.width + ", useCoverProvider = " + this.useCoverProvider);
        if (this.useCoverProvider) {
            if (this.coverProvider == null) {
                c();
                d();
                return;
            }
            return;
        }
        if (this.thumbProvider == null) {
            c();
            this.thumbProvider = rd4.c.f431135f.i(this.clipSource, this.size);
        }
    }

    private final void f() {
        QLog.i("ThumbnailGeneratorSyncHelper", 4, "releaseCoverGenerator");
        ICoverProvider iCoverProvider = this.coverProvider;
        if (iCoverProvider != null) {
            iCoverProvider.release();
        }
        this.coverProvider = null;
    }

    private final void g() {
        IThumbProvider iThumbProvider = this.thumbProvider;
        if (iThumbProvider != null) {
            iThumbProvider.release();
        }
        this.thumbProvider = null;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.f
    @WorkerThread
    @Nullable
    public Bitmap b(long timeUs) {
        Bitmap bitmap;
        QLog.i("ThumbnailGeneratorSyncHelper", 4, "generateCoverByTime:" + timeUs);
        e();
        Bitmap bitmap2 = null;
        try {
            ICoverProvider iCoverProvider = this.coverProvider;
            if (iCoverProvider != null) {
                if (iCoverProvider != null) {
                    bitmap = iCoverProvider.getCoverAtTime(timeUs / 1000);
                } else {
                    bitmap = null;
                }
                QLog.i("ThumbnailGeneratorSyncHelper", 4, "cover bitmap = " + bitmap);
                return bitmap;
            }
            IThumbProvider iThumbProvider = this.thumbProvider;
            if (iThumbProvider != null) {
                bitmap2 = iThumbProvider.getThumbAtTime(timeUs);
            }
            return bitmap2;
        } catch (Exception e16) {
            QLog.e("ThumbnailGeneratorSyncHelper", 1, e16, new Object[0]);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e("ThumbnailGeneratorSyncHelper", 1, e17, new Object[0]);
            return null;
        }
    }

    public final void h(@Nullable LAKRenderModel lAKRenderModel) {
        this.renderModel = lAKRenderModel;
    }

    public final void i(boolean z16) {
        this.useCoverProvider = z16;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.f
    public void release() {
        QLog.i("ThumbnailGeneratorSyncHelper", 4, "release");
        g();
        f();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.f
    public void a(long timeUs) {
    }
}
