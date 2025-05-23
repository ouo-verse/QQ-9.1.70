package com.tencent.tavcut.core.render;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.render.rendernode.ImageParams;
import com.tencent.tavcut.core.render.rendernode.NodeOrderUtils;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ud4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0000\u00a2\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0017\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0000\u00a2\u0006\u0002\b\u0019J\u0017\u0010\u001a\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u00a2\u0006\u0002\b\u001bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/tavcut/core/render/EffectDispatcher;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "()V", "dispatcherFilter", "Lcom/tencent/tavcut/core/render/EffectDispatcher$DispatcherFilter;", "effectDispatchListener", "Lcom/tencent/tavcut/core/render/EffectDispatcher$EffectDispatchListener;", "getEffectDispatchListener", "()Lcom/tencent/tavcut/core/render/EffectDispatcher$EffectDispatchListener;", "setEffectDispatchListener", "(Lcom/tencent/tavcut/core/render/EffectDispatcher$EffectDispatchListener;)V", "effectNodes", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "renderTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "addNode", "", "effectNode", "addNode$lib_tavcut_debug", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "removeNode", "removeNode$lib_tavcut_debug", "setRenderTimeRange", "setRenderTimeRange$lib_tavcut_debug", "Companion", "DispatcherFilter", "EffectDispatchListener", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class EffectDispatcher implements TAVVideoMixEffect {
    private static final int INVALID_NODE_INDEX = -1;
    private static final String TAG = "tavCut-EffectDispatcher";
    private DispatcherFilter dispatcherFilter;

    @Nullable
    private EffectDispatchListener effectDispatchListener;
    private final CopyOnWriteArrayList<BaseEffectNode> effectNodes = new CopyOnWriteArrayList<>();
    private CMTimeRange renderTimeRange;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/tavcut/core/render/EffectDispatcher$EffectDispatchListener;", "", "onAfterApply", "", "onBeforeApply", "releaseAfterAllNode", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public interface EffectDispatchListener {
        void onAfterApply();

        void onBeforeApply();

        void releaseAfterAllNode();
    }

    public final void addNode$lib_tavcut_debug(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        if (!this.effectNodes.contains(effectNode)) {
            if (effectNode.getNodeIndex() == -1) {
                HashMap<String, Integer> defaultOrderConfig = NodeOrderUtils.INSTANCE.getDefaultOrderConfig();
                if (defaultOrderConfig.get(effectNode.getClass().getSimpleName()) != null) {
                    Integer num = defaultOrderConfig.get(effectNode.getClass().getSimpleName());
                    if (num == null) {
                        Intrinsics.throwNpe();
                    }
                    effectNode.setNodeIndex(num.intValue());
                }
            }
            if (effectNode.getNodeIndex() == -1) {
                TavLogger.e(TAG, "\u5f53\u524d\u8282\u70b9\u6ca1\u6709\u8bbe\u7f6e\u6e32\u67d3\u987a\u5e8f\u7684index\uff0c\u9ed8\u8ba4\u914d\u7f6e\u4e2d\u4e5f\u6ca1\u6709\u914d\u7f6e\u5f53\u524d\u8282\u70b9\u987a\u5e8f\uff0c\u4e0d\u4f1a\u52a0\u5165\u6e32\u67d3\u94fe\u4e2d\uff0c\u8bf7\u68c0\u67e5EffectNodeOrderUtils\u4e2d\u914d\u7f6e\uff01\uff01\u8282\u70b9EffectId\uff1a" + effectNode.getEffectId());
                return;
            }
            this.effectNodes.add(effectNode);
        }
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    @NotNull
    public TAVVideoMixEffect.Filter createFilter() {
        DispatcherFilter dispatcherFilter = this.dispatcherFilter;
        if (dispatcherFilter == null) {
            dispatcherFilter = new DispatcherFilter(this.effectNodes, this.effectDispatchListener);
        }
        this.dispatcherFilter = dispatcherFilter;
        return dispatcherFilter;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    @Nullable
    public String effectId() {
        return "tavCut-EffectDispatcher@" + Integer.toHexString(hashCode());
    }

    @Nullable
    public final EffectDispatchListener getEffectDispatchListener() {
        return this.effectDispatchListener;
    }

    public final void removeNode$lib_tavcut_debug(@Nullable BaseEffectNode effectNode) {
        this.effectNodes.remove(effectNode);
    }

    public final void setEffectDispatchListener(@Nullable EffectDispatchListener effectDispatchListener) {
        this.effectDispatchListener = effectDispatchListener;
    }

    public final void setRenderTimeRange$lib_tavcut_debug(@Nullable CMTimeRange renderTimeRange) {
        this.renderTimeRange = renderTimeRange;
        DispatcherFilter dispatcherFilter = this.dispatcherFilter;
        if (dispatcherFilter != null) {
            dispatcherFilter.setRenderTimeRange$lib_tavcut_debug(renderTimeRange);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u001bH\u0016J\u0017\u0010#\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000\u00a2\u0006\u0002\b$R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/tavcut/core/render/EffectDispatcher$DispatcherFilter;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectNodes", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "effectDispatchListener", "Lcom/tencent/tavcut/core/render/EffectDispatcher$EffectDispatchListener;", "(Ljava/util/List;Lcom/tencent/tavcut/core/render/EffectDispatcher$EffectDispatchListener;)V", "backImage", "Lcom/tencent/tavkit/ciimage/CIImage;", "imageParams", "Lcom/tencent/tavcut/core/render/rendernode/ImageParams;", "mFilters", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode$Filter;", "renderTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "showCanvas", "", "apply", QQWinkConstants.TAB_EFFECT, "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "imageCollection", "Lcom/tencent/tavkit/composition/video/ImageCollection;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "checkFillInRenderSize", "", "imagePair", "Lcom/tencent/tavkit/composition/video/ImageCollection$TrackImagePair;", "sourceImage", "checkRenderTime", "defaultApply", "initBackColorImage", "release", "setRenderTimeRange", "setRenderTimeRange$lib_tavcut_debug", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class DispatcherFilter implements TAVVideoMixEffect.Filter {
        private CIImage backImage;
        private final EffectDispatchListener effectDispatchListener;
        private final ImageParams imageParams;
        private List<BaseEffectNode.Filter> mFilters;
        private CMTimeRange renderTimeRange;
        private boolean showCanvas;

        public DispatcherFilter(@NotNull List<? extends BaseEffectNode> effectNodes, @Nullable EffectDispatchListener effectDispatchListener) {
            Intrinsics.checkParameterIsNotNull(effectNodes, "effectNodes");
            this.effectDispatchListener = effectDispatchListener;
            this.imageParams = new ImageParams();
            this.mFilters = new ArrayList();
            ArrayList arrayList = new ArrayList(effectNodes);
            if (!arrayList.isEmpty()) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator<BaseEffectNode>() { // from class: com.tencent.tavcut.core.render.EffectDispatcher.DispatcherFilter.1
                    @Override // java.util.Comparator
                    public final int compare(@NotNull BaseEffectNode o16, @NotNull BaseEffectNode o26) {
                        Intrinsics.checkParameterIsNotNull(o16, "o1");
                        Intrinsics.checkParameterIsNotNull(o26, "o2");
                        if (o16.getNodeIndex() < o26.getNodeIndex()) {
                            return -1;
                        }
                        return o16.getNodeIndex() > o26.getNodeIndex() ? 1 : 0;
                    }
                });
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mFilters.add(((BaseEffectNode) it.next()).createFilter());
            }
        }

        private final void checkFillInRenderSize(RenderInfo renderInfo, ImageCollection.TrackImagePair imagePair, CIImage sourceImage) {
            if (!(imagePair.getTrack() instanceof TAVClip)) {
                return;
            }
            TAVVideoCompositionTrack track = imagePair.getTrack();
            if (track != null) {
                TAVVideoConfiguration config = ((TAVClip) track).getVideoConfiguration();
                if (config.frameEnable()) {
                    return;
                }
                CGRect cGRect = new CGRect(new PointF(0.0f, 0.0f), renderInfo.getRenderSize());
                Intrinsics.checkExpressionValueIsNotNull(config, "config");
                sourceImage.applyFillInFrame(cGRect, config.getContentMode());
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavkit.composition.TAVClip");
        }

        private final RenderInfo checkRenderTime(RenderInfo renderInfo) {
            CMTime cMTime;
            CMTimeRange cMTimeRange = this.renderTimeRange;
            if (cMTimeRange != null) {
                if (renderInfo.getTime().bigThan(cMTimeRange.getEnd())) {
                    cMTime = cMTimeRange.getEnd();
                } else {
                    cMTime = null;
                }
                if (renderInfo.getTime().smallThan(cMTimeRange.getStart())) {
                    cMTime = cMTimeRange.getStart();
                }
                if (cMTime != null) {
                    return new RenderInfo(cMTime, renderInfo.getRenderSize(), renderInfo.getCiContext());
                }
            }
            return renderInfo;
        }

        private final CIImage defaultApply(ImageCollection imageCollection, RenderInfo renderInfo) {
            CIImage cIImage = new CIImage(renderInfo.getRenderSize());
            for (ImageCollection.TrackImagePair trackImage : imageCollection.getVideoChannelImages()) {
                Intrinsics.checkExpressionValueIsNotNull(trackImage, "trackImage");
                CIImage image = trackImage.getImage();
                Intrinsics.checkExpressionValueIsNotNull(image, "trackImage.image");
                checkFillInRenderSize(renderInfo, trackImage, image);
                image.imageByCompositingOverImage(cIImage);
            }
            for (ImageCollection.TrackImagePair overlay : imageCollection.getOverlayImages()) {
                Intrinsics.checkExpressionValueIsNotNull(overlay, "overlay");
                CIImage image2 = overlay.getImage();
                Intrinsics.checkExpressionValueIsNotNull(image2, "overlay.image");
                checkFillInRenderSize(renderInfo, overlay, image2);
                image2.imageByCompositingOverImage(cIImage);
            }
            return cIImage;
        }

        private final void initBackColorImage(RenderInfo renderInfo) {
            CGSize cGSize;
            CIImage cIImage = this.backImage;
            if (cIImage != null) {
                if (cIImage != null) {
                    cGSize = cIImage.getSize();
                } else {
                    cGSize = null;
                }
                if (!(!Intrinsics.areEqual(cGSize, renderInfo.getRenderSize()))) {
                    return;
                }
            }
            ColorDrawable colorDrawable = new ColorDrawable(-16711936);
            Bitmap createBitmap = Bitmap.createBitmap(renderInfo.getRenderWidth(), renderInfo.getRenderHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            colorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            colorDrawable.draw(canvas);
            this.backImage = new CIImage(createBitmap);
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
        @NotNull
        public CIImage apply(@NotNull TAVVideoMixEffect effect, @NotNull ImageCollection imageCollection, @NotNull RenderInfo renderInfo) {
            Intrinsics.checkParameterIsNotNull(effect, "effect");
            Intrinsics.checkParameterIsNotNull(imageCollection, "imageCollection");
            Intrinsics.checkParameterIsNotNull(renderInfo, "renderInfo");
            a.f438857c.b(EffectDispatcher.TAG, EffectDispatcher.TAG);
            this.imageParams.getVideoChannelImages().clear();
            for (ImageCollection.TrackImagePair trackImagePair : imageCollection.getVideoChannelImages()) {
                List<ImageParams.ImageTrackPair> videoChannelImages = this.imageParams.getVideoChannelImages();
                Intrinsics.checkExpressionValueIsNotNull(trackImagePair, "trackImagePair");
                CIImage image = trackImagePair.getImage();
                Intrinsics.checkExpressionValueIsNotNull(image, "trackImagePair.image");
                videoChannelImages.add(new ImageParams.ImageTrackPair(image, trackImagePair.getTrack()));
            }
            RenderInfo checkRenderTime = checkRenderTime(renderInfo);
            EffectDispatchListener effectDispatchListener = this.effectDispatchListener;
            if (effectDispatchListener != null) {
                effectDispatchListener.onBeforeApply();
            }
            for (BaseEffectNode.Filter filter : this.mFilters) {
                if (filter.isNeedApply(checkRenderTime)) {
                    filter.apply(this.imageParams, checkRenderTime);
                }
            }
            if (this.showCanvas) {
                initBackColorImage(checkRenderTime);
                ImageParams.ImageTrackPair imageTrackPair = this.imageParams.getVideoChannelImages().get(0);
                CIImage imageByCompositingOverImage = this.imageParams.getVideoChannelImages().get(0).getImage().imageByCompositingOverImage(this.backImage);
                Intrinsics.checkExpressionValueIsNotNull(imageByCompositingOverImage, "imageParams.videoChannel\u2026itingOverImage(backImage)");
                imageTrackPair.setImage(imageByCompositingOverImage);
            }
            EffectDispatchListener effectDispatchListener2 = this.effectDispatchListener;
            if (effectDispatchListener2 != null) {
                effectDispatchListener2.onAfterApply();
            }
            a.f438857c.a(EffectDispatcher.TAG);
            if (this.imageParams.getVideoChannelImages().size() > 0) {
                return this.imageParams.getVideoChannelImages().get(0).getImage();
            }
            return defaultApply(imageCollection, checkRenderTime);
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            Iterator<T> it = this.mFilters.iterator();
            while (it.hasNext()) {
                ((BaseEffectNode.Filter) it.next()).release();
            }
            EffectDispatchListener effectDispatchListener = this.effectDispatchListener;
            if (effectDispatchListener != null) {
                effectDispatchListener.releaseAfterAllNode();
            }
        }

        public final void setRenderTimeRange$lib_tavcut_debug(@Nullable CMTimeRange renderTimeRange) {
            this.renderTimeRange = renderTimeRange;
        }

        public /* synthetic */ DispatcherFilter(List list, EffectDispatchListener effectDispatchListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i3 & 2) != 0 ? null : effectDispatchListener);
        }
    }
}
