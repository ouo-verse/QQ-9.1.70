package com.tencent.mobileqq.wink.pubcover;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.RenderModelThumbnailProviderImpl;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.videocut.model.MediaClip;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00022\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0002\u001a\u00020\u0001H\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016JD\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0017J\u0006\u0010\u001d\u001a\u00020\u0007R\u0016\u0010\u001f\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/v;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "d", "", "e", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "listener", "", "b", "c", "", "timeMs", "", "tag", "", "assetPath", "Landroid/graphics/Bitmap;", "getBitmapByTime", "a", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "renderModel", "duration", "templateDir", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "renderNodes", "Lcom/tencent/videocut/model/MediaClip;", "mediaModels", "g", "f", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/o;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/o;", "singleCutProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl;", "doubleCutProvider", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class v implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.clipping.thumbnail.o singleCutProvider = com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RenderModelThumbnailProviderImpl doubleCutProvider = new RenderModelThumbnailProviderImpl();

    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d d() {
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d dVar;
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d dVar2 = this.thumbnailProvider;
        if (dVar2 != null) {
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnailProvider");
            } else {
                return dVar2;
            }
        } else {
            if (e()) {
                w53.b.f("WinkCoverThumbnailProvider", "in doubleCut mode");
                dVar = this.doubleCutProvider;
            } else {
                w53.b.f("WinkCoverThumbnailProvider", "not doubleCut mode");
                dVar = this.singleCutProvider;
            }
            this.thumbnailProvider = dVar;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnailProvider");
            } else {
                return dVar;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    @Nullable
    /* renamed from: a */
    public Bitmap getDefaultBitmap() {
        return d().getDefaultBitmap();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    public void b(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        d().b(listener);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    public void c(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        d().c(listener);
    }

    public abstract boolean e();

    public final void f() {
        this.doubleCutProvider.h();
    }

    public final void g(@NotNull LAKRenderModel renderModel, long duration, @NotNull String templateDir, @Nullable List<? extends BaseEffectNode> renderNodes, @Nullable List<? extends MediaClip> mediaModels) {
        Intrinsics.checkNotNullParameter(renderModel, "renderModel");
        Intrinsics.checkNotNullParameter(templateDir, "templateDir");
        if (!Intrinsics.areEqual(d(), this.doubleCutProvider)) {
            return;
        }
        this.doubleCutProvider.k(renderModel, duration, templateDir, renderNodes, mediaModels);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    @Nullable
    public Bitmap getBitmapByTime(long timeMs, @Nullable Object tag, @NotNull String assetPath) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        return d().getBitmapByTime(timeMs, tag, assetPath);
    }
}
