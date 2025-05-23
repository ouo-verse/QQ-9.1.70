package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.PointF;
import android.util.Log;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.autotemplate.filter.GaosiBlurFilter;
import com.tencent.autotemplate.filter.ScaleTextureFilter;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00019B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u000bH\u0007JP\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0007JX\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0007J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J(\u0010-\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020,H\u0002J\"\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\bH\u0007J\b\u00106\u001a\u000202H\u0007J\u0018\u00107\u001a\u0002022\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0006H\u0007J$\u00108\u001a\u0002022\u0006\u00103\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007R\u008a\u0001\u0010\u0003\u001a~\u0012\u0004\u0012\u00020\u0005\u00124\u00122\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0004j\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007`\t0\u0004j>\u0012\u0004\u0012\u00020\u0005\u00124\u00122\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0004j\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007`\t`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8F@BX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00108F@BX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006:"}, d2 = {"Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSOverLayBlurManager;", "", "()V", "observersOfContext", "Ljava/util/HashMap;", "Lcom/tencent/tavsticker/core/TAVStickerRenderContext;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSOverLayBlurManager$SourceImageObserver;", "Lkotlin/collections/HashMap;", "<set-?>", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "renderInfo", "renderInfo$annotations", "getRenderInfo", "()Lcom/tencent/tavkit/composition/video/RenderInfo;", "Lcom/tencent/tavkit/ciimage/CIImage;", "sourceCIImage", "sourceCIImage$annotations", "getSourceCIImage", "()Lcom/tencent/tavkit/ciimage/CIImage;", "getBlurRect", "Lcom/tencent/tav/coremedia/CGRect;", BasicAnimation.KeyPath.ROTATION, "", "sticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "realBlurCiImage", "info", "getBlurredTextureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "holderTextureInfo", "blurRadius", "blurScale", "", "horizontalBlurFilter", "Lcom/tencent/autotemplate/filter/GaosiBlurFilter;", "verticalBlurFilter", "scaleSmallTextureFilter", "Lcom/tencent/autotemplate/filter/ScaleTextureFilter;", "scaleBigTextureFilter", "renderWidth", "renderHeight", "getTavTextureInfo", "Lcom/tencent/taveffect/core/TAVTextureInfo;", "getTextureInfo", "rendererWidth", "rendererHeight", "textureAfterBlur", "registerSourceImageObserver", "", "stickerContext", "uniqId", "observer", "release", "unregisterSourceImageObserver", "updateSourceCIImage", "SourceImageObserver", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class WSOverLayBlurManager {
    public static final WSOverLayBlurManager INSTANCE = new WSOverLayBlurManager();
    private static final HashMap<TAVStickerRenderContext, HashMap<String, WeakReference<SourceImageObserver>>> observersOfContext = new HashMap<>();

    @Nullable
    private static RenderInfo renderInfo;

    @Nullable
    private static CIImage sourceCIImage;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSOverLayBlurManager$SourceImageObserver;", "", "onSourceImageUpdated", "", "sourceImage", "Lcom/tencent/tavkit/ciimage/CIImage;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public interface SourceImageObserver {
        void onSourceImageUpdated(@Nullable CIImage sourceImage, @Nullable RenderInfo renderInfo);
    }

    WSOverLayBlurManager() {
    }

    @JvmStatic
    @NotNull
    public static final CGRect getBlurRect(int rotation, @NotNull TAVSticker sticker, @Nullable CIImage realBlurCiImage, @NotNull RenderInfo info) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float f28;
        Intrinsics.checkParameterIsNotNull(sticker, "sticker");
        Intrinsics.checkParameterIsNotNull(info, "info");
        PointF[] computeRectanglePoints = TAVStickerUtil.computeRectanglePoints(WsStickerUtil.getRatioChangeMatrix(sticker, (int) info.getRenderSize().width, (int) info.getRenderSize().height), sticker.getWidth(), sticker.getHeight());
        CGRect cGRect = new CGRect();
        CGSize cGSize = cGRect.size;
        if (rotation == 1) {
            f16 = computeRectanglePoints[1].x;
            f17 = computeRectanglePoints[0].x;
        } else {
            f16 = computeRectanglePoints[3].y;
            f17 = computeRectanglePoints[0].y;
        }
        cGSize.height = f16 - f17;
        if (rotation == 1) {
            f18 = computeRectanglePoints[3].y;
            f19 = computeRectanglePoints[0].y;
        } else {
            f18 = computeRectanglePoints[1].x;
            f19 = computeRectanglePoints[0].x;
        }
        cGSize.width = f18 - f19;
        PointF pointF = cGRect.origin;
        if (rotation == 1) {
            f26 = (info.getRenderSize().height - computeRectanglePoints[1].y) - cGRect.size.width;
        } else {
            f26 = computeRectanglePoints[0].x;
        }
        pointF.x = f26;
        PointF pointF2 = cGRect.origin;
        if (rotation == 1) {
            f27 = info.getRenderSize().width;
            f28 = computeRectanglePoints[1].x;
        } else {
            f27 = info.getRenderSize().height - computeRectanglePoints[1].y;
            f28 = cGRect.size.height;
        }
        pointF2.y = f27 - f28;
        return cGRect;
    }

    @JvmStatic
    @NotNull
    public static final synchronized TextureInfo getBlurredTextureInfo(@NotNull TextureInfo holderTextureInfo, @NotNull RenderInfo renderInfo2, int rotation, int blurRadius, float blurScale, @NotNull GaosiBlurFilter horizontalBlurFilter, @NotNull GaosiBlurFilter verticalBlurFilter, @NotNull ScaleTextureFilter scaleSmallTextureFilter, @NotNull ScaleTextureFilter scaleBigTextureFilter) {
        TextureInfo textureInfo;
        synchronized (WSOverLayBlurManager.class) {
            Intrinsics.checkParameterIsNotNull(holderTextureInfo, "holderTextureInfo");
            Intrinsics.checkParameterIsNotNull(renderInfo2, "renderInfo");
            Intrinsics.checkParameterIsNotNull(horizontalBlurFilter, "horizontalBlurFilter");
            Intrinsics.checkParameterIsNotNull(verticalBlurFilter, "verticalBlurFilter");
            Intrinsics.checkParameterIsNotNull(scaleSmallTextureFilter, "scaleSmallTextureFilter");
            Intrinsics.checkParameterIsNotNull(scaleBigTextureFilter, "scaleBigTextureFilter");
            int renderWidth = rotation == 0 ? renderInfo2.getRenderWidth() : renderInfo2.getRenderHeight();
            int renderHeight = rotation == 0 ? renderInfo2.getRenderHeight() : renderInfo2.getRenderWidth();
            horizontalBlurFilter.setRadius(blurRadius);
            verticalBlurFilter.setRadius(blurRadius);
            WSOverLayBlurManager wSOverLayBlurManager = INSTANCE;
            TAVTextureInfo tavTextureInfo = wSOverLayBlurManager.getTavTextureInfo(holderTextureInfo);
            double d16 = blurScale;
            int floor = (int) Math.floor(holderTextureInfo.width * d16);
            int floor2 = (int) Math.floor(holderTextureInfo.height * d16);
            horizontalBlurFilter.setRendererWidth(floor);
            horizontalBlurFilter.setRendererHeight(floor2);
            verticalBlurFilter.setRendererWidth(floor);
            verticalBlurFilter.setRendererHeight(floor2);
            scaleSmallTextureFilter.setRendererWidth(floor);
            scaleSmallTextureFilter.setRendererHeight(floor2);
            scaleBigTextureFilter.setRendererWidth(renderWidth);
            scaleBigTextureFilter.setRendererHeight(renderHeight);
            scaleSmallTextureFilter.scale(blurScale, 0.0f, 0.0f);
            TAVTextureInfo applyFilter = verticalBlurFilter.applyFilter(horizontalBlurFilter.applyFilter(scaleSmallTextureFilter.applyFilter(tavTextureInfo)));
            scaleBigTextureFilter.scale(Math.max((renderHeight * 1.0f) / floor2, (renderWidth * 1.0f) / floor), 0.0f, 0.0f);
            TAVTextureInfo textureAfterBlur = scaleBigTextureFilter.applyFilter(applyFilter);
            Intrinsics.checkExpressionValueIsNotNull(textureAfterBlur, "textureAfterBlur");
            textureInfo = wSOverLayBlurManager.getTextureInfo(holderTextureInfo, renderWidth, renderHeight, textureAfterBlur);
        }
        return textureInfo;
    }

    @Nullable
    public static final synchronized RenderInfo getRenderInfo() {
        RenderInfo renderInfo2;
        synchronized (WSOverLayBlurManager.class) {
            renderInfo2 = renderInfo;
        }
        return renderInfo2;
    }

    @Nullable
    public static final synchronized CIImage getSourceCIImage() {
        CIImage cIImage;
        synchronized (WSOverLayBlurManager.class) {
            cIImage = sourceCIImage;
        }
        return cIImage;
    }

    private final TAVTextureInfo getTavTextureInfo(TextureInfo holderTextureInfo) {
        if (holderTextureInfo.getTextureMatrix() != null) {
            float[] fArr = new float[9];
            holderTextureInfo.getTextureMatrix().getValues(fArr);
            return new TAVTextureInfo(holderTextureInfo.textureID, holderTextureInfo.textureType, holderTextureInfo.width, holderTextureInfo.height, fArr, holderTextureInfo.preferRotation);
        }
        return new TAVTextureInfo(holderTextureInfo.textureID, holderTextureInfo.textureType, holderTextureInfo.width, holderTextureInfo.height, null, holderTextureInfo.preferRotation);
    }

    private final TextureInfo getTextureInfo(TextureInfo holderTextureInfo, int rendererWidth, int rendererHeight, TAVTextureInfo textureAfterBlur) {
        return new TextureInfo(textureAfterBlur.textureID, textureAfterBlur.textureType, rendererWidth, rendererHeight, holderTextureInfo.getTextureMatrix(), holderTextureInfo.preferRotation);
    }

    @JvmStatic
    public static final void registerSourceImageObserver(@NotNull TAVStickerRenderContext stickerContext, @NotNull String uniqId, @Nullable SourceImageObserver observer) {
        Intrinsics.checkParameterIsNotNull(stickerContext, "stickerContext");
        Intrinsics.checkParameterIsNotNull(uniqId, "uniqId");
        if (observer != null) {
            Log.d("genglin", "register: " + observer.hashCode());
            HashMap<TAVStickerRenderContext, HashMap<String, WeakReference<SourceImageObserver>>> hashMap = observersOfContext;
            if (!hashMap.containsKey(stickerContext)) {
                hashMap.put(stickerContext, new HashMap<>());
            }
            HashMap<String, WeakReference<SourceImageObserver>> hashMap2 = hashMap.get(stickerContext);
            if (hashMap2 != null && !hashMap2.containsKey(uniqId)) {
                WeakReference<SourceImageObserver> weakReference = new WeakReference<>(observer);
                HashMap<String, WeakReference<SourceImageObserver>> hashMap3 = hashMap.get(stickerContext);
                if (hashMap3 != null) {
                    hashMap3.put(uniqId, weakReference);
                }
            }
        }
    }

    @JvmStatic
    public static final void release() {
        CIImage cIImage = sourceCIImage;
        if (cIImage != null) {
            cIImage.release();
        }
        if (renderInfo != null) {
            renderInfo = null;
        }
    }

    @JvmStatic
    public static final void unregisterSourceImageObserver(@NotNull TAVStickerRenderContext stickerContext, @NotNull String uniqId) {
        Integer num;
        Intrinsics.checkParameterIsNotNull(stickerContext, "stickerContext");
        Intrinsics.checkParameterIsNotNull(uniqId, "uniqId");
        Log.d("genglin", "unregister: " + uniqId);
        HashMap<TAVStickerRenderContext, HashMap<String, WeakReference<SourceImageObserver>>> hashMap = observersOfContext;
        HashMap<String, WeakReference<SourceImageObserver>> hashMap2 = hashMap.get(stickerContext);
        if (hashMap2 != null) {
            hashMap2.remove(uniqId);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unregisterSourceImageObserver: size = ");
        HashMap<String, WeakReference<SourceImageObserver>> hashMap3 = hashMap.get(stickerContext);
        if (hashMap3 != null) {
            num = Integer.valueOf(hashMap3.size());
        } else {
            num = null;
        }
        sb5.append(num);
        Log.d("genglin", sb5.toString());
    }

    @JvmStatic
    public static final synchronized void updateSourceCIImage(@NotNull TAVStickerRenderContext stickerContext, @Nullable CIImage sourceCIImage2, @Nullable RenderInfo renderInfo2) {
        SourceImageObserver sourceImageObserver;
        synchronized (WSOverLayBlurManager.class) {
            Intrinsics.checkParameterIsNotNull(stickerContext, "stickerContext");
            sourceCIImage = sourceCIImage2;
            renderInfo = renderInfo2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateSourceCIImage: thread = ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            Log.d("sticker_size", sb5.toString());
            HashMap<String, WeakReference<SourceImageObserver>> hashMap = observersOfContext.get(stickerContext);
            if (hashMap != null) {
                Iterator<Map.Entry<String, WeakReference<SourceImageObserver>>> it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    WeakReference<SourceImageObserver> value = it.next().getValue();
                    if (value != null && (sourceImageObserver = value.get()) != null) {
                        sourceImageObserver.onSourceImageUpdated(sourceCIImage2, renderInfo2);
                    }
                }
            }
        }
    }

    @JvmStatic
    public static /* synthetic */ void renderInfo$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void sourceCIImage$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final synchronized TextureInfo getBlurredTextureInfo(@NotNull TextureInfo holderTextureInfo, int renderWidth, int renderHeight, int rotation, int blurRadius, float blurScale, @NotNull GaosiBlurFilter horizontalBlurFilter, @NotNull GaosiBlurFilter verticalBlurFilter, @NotNull ScaleTextureFilter scaleSmallTextureFilter, @NotNull ScaleTextureFilter scaleBigTextureFilter) {
        TextureInfo textureInfo;
        synchronized (WSOverLayBlurManager.class) {
            Intrinsics.checkParameterIsNotNull(holderTextureInfo, "holderTextureInfo");
            Intrinsics.checkParameterIsNotNull(horizontalBlurFilter, "horizontalBlurFilter");
            Intrinsics.checkParameterIsNotNull(verticalBlurFilter, "verticalBlurFilter");
            Intrinsics.checkParameterIsNotNull(scaleSmallTextureFilter, "scaleSmallTextureFilter");
            Intrinsics.checkParameterIsNotNull(scaleBigTextureFilter, "scaleBigTextureFilter");
            int i3 = rotation == 0 ? renderWidth : renderHeight;
            if (rotation == 0) {
                renderWidth = renderHeight;
            }
            horizontalBlurFilter.setRadius(blurRadius);
            verticalBlurFilter.setRadius(blurRadius);
            WSOverLayBlurManager wSOverLayBlurManager = INSTANCE;
            TAVTextureInfo tavTextureInfo = wSOverLayBlurManager.getTavTextureInfo(holderTextureInfo);
            double d16 = blurScale;
            int floor = (int) Math.floor(holderTextureInfo.width * d16);
            int floor2 = (int) Math.floor(holderTextureInfo.height * d16);
            horizontalBlurFilter.setRendererWidth(floor);
            horizontalBlurFilter.setRendererHeight(floor2);
            verticalBlurFilter.setRendererWidth(floor);
            verticalBlurFilter.setRendererHeight(floor2);
            scaleSmallTextureFilter.setRendererWidth(floor);
            scaleSmallTextureFilter.setRendererHeight(floor2);
            scaleBigTextureFilter.setRendererWidth(i3);
            scaleBigTextureFilter.setRendererHeight(renderWidth);
            scaleSmallTextureFilter.scale(blurScale, 0.0f, 0.0f);
            TAVTextureInfo textureAfterBlur = verticalBlurFilter.applyFilter(horizontalBlurFilter.applyFilter(scaleSmallTextureFilter.applyFilter(tavTextureInfo)));
            Intrinsics.checkExpressionValueIsNotNull(textureAfterBlur, "textureAfterBlur");
            textureInfo = wSOverLayBlurManager.getTextureInfo(holderTextureInfo, i3, renderWidth, textureAfterBlur);
        }
        return textureInfo;
    }
}
