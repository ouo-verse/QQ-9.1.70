package com.tencent.qcircle.weseevideo.composition;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.ads.data.AdParam;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFramePAGItem;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameVisibleRegion;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGLayer;
import org.libpag.PAGRenderer;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J \u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010'\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002J \u0010/\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010'\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u00060"}, d2 = {"Lcom/tencent/qcircle/weseevideo/composition/TAVAutomaticTransRenderContext;", "Lcom/tencent/autotemplate/TAVAutomaticRenderContext;", "mediaModel", "Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "(Lcom/tencent/qcircle/weseevideo/model/MediaModel;)V", "TAG", "", "imgInScrPoints", "", "Landroid/graphics/PointF;", "getImgInScrPoints", "()Ljava/util/List;", "setImgInScrPoints", "(Ljava/util/List;)V", "getMediaModel", "()Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "pagFillMode", "", "getPagFillMode", "()I", "setPagFillMode", "(I)V", AdParam.SCREENSIZE, "Lcom/tencent/tav/coremedia/CGSize;", "getScreenSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setScreenSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "getScreenRect", "Landroid/graphics/RectF;", "renderStickerChainWithTexture", "Lcom/tencent/tav/coremedia/CMSampleBuffer;", "presentationTimeMs", "", "sourceImages", "", "Lcom/tencent/tavsticker/model/TAVSourceImage;", "replaceLayerAndTrans", "", "source", "layer", "Lorg/libpag/PAGLayer;", "replaceLayerColor", "renderer", "Lorg/libpag/PAGRenderer;", "sticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "replaceLayerPhoto", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class TAVAutomaticTransRenderContext extends TAVAutomaticRenderContext {
    private final String TAG;

    @NotNull
    private List<? extends PointF> imgInScrPoints;

    @NotNull
    private final MediaModel mediaModel;
    private int pagFillMode;

    @NotNull
    private CGSize screenSize;

    public TAVAutomaticTransRenderContext(@NotNull MediaModel mediaModel) {
        List<? extends PointF> emptyList;
        Intrinsics.checkParameterIsNotNull(mediaModel, "mediaModel");
        this.mediaModel = mediaModel;
        this.TAG = "TAVAutomaticTransRenderContext";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.imgInScrPoints = emptyList;
        this.screenSize = new CGSize();
    }

    private final RectF getScreenRect() {
        CGSize cGSize = this.screenSize;
        return new RectF(0.0f, 0.0f, cGSize.width, cGSize.height);
    }

    private final void replaceLayerAndTrans(TAVSourceImage source, PAGLayer layer) {
        int i3;
        List asList;
        List chunked;
        int collectionSizeOrDefault;
        boolean z16;
        Object obj;
        boolean z17;
        boolean z18;
        float f16 = 0.0f;
        RectF rectF = new RectF(0.0f, 0.0f, source.getPagImage().width(), source.getPagImage().height());
        RectF screenRect = getScreenRect();
        RectF bounds = layer.getBounds();
        RectF bounds2 = layer.getBounds();
        AutomaticMediaTemplateModel automaticMediaTemplateModel = this.mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
        Intrinsics.checkExpressionValueIsNotNull(automaticMediaTemplateModel, "mediaModel.mediaTemplate\u2026tomaticMediaTemplateModel");
        AEFrameModel aEFrameModel = automaticMediaTemplateModel.getAEFrameModel();
        if (aEFrameModel != null) {
            ArrayList<AEFramePAGItem> pagItems = aEFrameModel.getPagItems();
            if (pagItems != null && !pagItems.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Iterator<T> it = aEFrameModel.getPagItems().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        AEFramePAGItem aEFramePAGItem = (AEFramePAGItem) obj;
                        if (aEFrameModel.getSelectedPAGName().length() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17 && !Intrinsics.areEqual(aEFrameModel.getSelectedPAGName(), aEFramePAGItem.getPagName())) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (z18) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                AEFramePAGItem aEFramePAGItem2 = (AEFramePAGItem) obj;
                if (aEFramePAGItem2 != null) {
                    AEFrameVisibleRegion visibleRegion = aEFramePAGItem2.getVisibleRegion();
                    float width = visibleRegion.getWidth() * layer.getBounds().width();
                    float height = visibleRegion.getHeight() * layer.getBounds().height();
                    float offsetX = layer.getBounds().left + (visibleRegion.getOffsetX() * layer.getBounds().width());
                    float offsetY = layer.getBounds().top + (visibleRegion.getOffsetY() * layer.getBounds().height());
                    RectF rectF2 = new RectF(offsetX, offsetY, width + offsetX, height + offsetY);
                    f16 = visibleRegion.getRotation();
                    bounds2 = rectF2;
                }
            }
            i3 = aEFrameModel.getImageFillMode();
        } else {
            i3 = 0;
        }
        float f17 = rectF.left;
        float f18 = rectF.top;
        float f19 = rectF.right;
        float f26 = rectF.bottom;
        float[] fArr = {f17, f18, f19, f18, f19, f26, f17, f26};
        Matrix matrix = new Matrix();
        float f27 = 2;
        matrix.setRotate(f16, rectF.width() / f27, rectF.height() / f27);
        Matrix matrix2 = new Matrix();
        if (i3 != 0) {
            if (i3 != 1) {
                matrix2.setRectToRect(rectF, bounds2, Matrix.ScaleToFit.CENTER);
            } else {
                Matrix matrix3 = new Matrix();
                matrix3.setRectToRect(bounds2, rectF, Matrix.ScaleToFit.CENTER);
                matrix3.invert(matrix2);
            }
        } else {
            matrix2.setRectToRect(rectF, bounds2, Matrix.ScaleToFit.CENTER);
        }
        RectF rectF3 = new RectF();
        matrix2.mapRect(rectF3, rectF);
        Matrix matrix4 = new Matrix();
        if (this.pagFillMode == 1) {
            matrix4.setRectToRect(rectF3, screenRect, Matrix.ScaleToFit.CENTER);
        } else {
            matrix4.setRectToRect(bounds, screenRect, Matrix.ScaleToFit.CENTER);
        }
        Matrix matrix5 = new Matrix();
        RectF rectF4 = new RectF();
        matrix4.mapRect(rectF4, rectF3);
        matrix5.setRectToRect(rectF3, rectF4, Matrix.ScaleToFit.FILL);
        Matrix matrix6 = new Matrix();
        matrix5.invert(matrix6);
        Matrix matrix7 = new Matrix();
        float[] fArr2 = new float[8];
        matrix7.set(matrix2);
        matrix7.preConcat(matrix);
        matrix7.postConcat(matrix5);
        matrix7.postConcat(this.mediaModel.getMediaEffectModel().getGestureModel().getGMatrix());
        matrix7.mapPoints(fArr2, fArr);
        asList = ArraysKt___ArraysJvmKt.asList(fArr2);
        chunked = CollectionsKt___CollectionsKt.chunked(asList, 2);
        List<List> list = chunked;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (List list2 : list) {
            arrayList.add(new PointF(((Number) list2.get(0)).floatValue(), ((Number) list2.get(1)).floatValue()));
        }
        this.imgInScrPoints = arrayList;
        matrix7.postConcat(matrix6);
        source.setMatrix(matrix7);
    }

    private final void replaceLayerColor(PAGRenderer renderer, TAVSourceImage source, TAVSticker sticker) {
        String str;
        Integer num;
        boolean z16;
        ArrayList<TAVStickerSolidItem> stickerSolidItems;
        AutomaticMediaTemplateModel automaticMediaTemplateModel = this.mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
        Intrinsics.checkExpressionValueIsNotNull(automaticMediaTemplateModel, "mediaModel.mediaTemplate\u2026tomaticMediaTemplateModel");
        AEFrameModel aEFrameModel = automaticMediaTemplateModel.getAEFrameModel();
        Object obj = null;
        if (aEFrameModel != null) {
            str = aEFrameModel.getFrameColorLayerName();
        } else {
            str = null;
        }
        AutomaticMediaTemplateModel automaticMediaTemplateModel2 = this.mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
        Intrinsics.checkExpressionValueIsNotNull(automaticMediaTemplateModel2, "mediaModel.mediaTemplate\u2026tomaticMediaTemplateModel");
        AEFrameModel aEFrameModel2 = automaticMediaTemplateModel2.getAEFrameModel();
        if (aEFrameModel2 != null) {
            num = Integer.valueOf(aEFrameModel2.getFrameColor());
        } else {
            num = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && num != null && (stickerSolidItems = sticker.getStickerSolidItems()) != null) {
            Iterator<T> it = stickerSolidItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                TAVStickerSolidItem solidItem = (TAVStickerSolidItem) next;
                Intrinsics.checkExpressionValueIsNotNull(solidItem, "solidItem");
                if (Intrinsics.areEqual(solidItem.getLayerName(), str)) {
                    obj = next;
                    break;
                }
            }
            TAVStickerSolidItem tAVStickerSolidItem = (TAVStickerSolidItem) obj;
            if (tAVStickerSolidItem != null && tAVStickerSolidItem.getColor() != num.intValue()) {
                tAVStickerSolidItem.setColor(num.intValue());
                sticker.updateLayerColor();
            }
        }
    }

    private final void replaceLayerPhoto(PAGRenderer renderer, TAVSourceImage source, TAVSticker sticker) {
        String str;
        PAGLayer pAGLayer;
        boolean z16;
        AutomaticMediaTemplateModel automaticMediaTemplateModel = this.mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
        Intrinsics.checkExpressionValueIsNotNull(automaticMediaTemplateModel, "mediaModel.mediaTemplate\u2026tomaticMediaTemplateModel");
        AEFrameModel aEFrameModel = automaticMediaTemplateModel.getAEFrameModel();
        if (aEFrameModel == null || (str = aEFrameModel.getImageLayerName()) == null) {
            str = "mid_photo";
        }
        PAGLayer[] layersByName = renderer.getRootComposition().getLayersByName(str);
        boolean z17 = true;
        if (layersByName != null) {
            if (layersByName.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = false;
            }
        }
        RectF rectF = null;
        if (!z17) {
            pAGLayer = layersByName[0];
        } else {
            pAGLayer = null;
        }
        if (pAGLayer == null) {
            pAGLayer = renderer.getRootComposition().getLayerAt(source.getIndex());
            Unit unit = Unit.INSTANCE;
        }
        String str2 = this.TAG;
        if (pAGLayer != null) {
            rectF = pAGLayer.getBounds();
        }
        Logger.e(str2, String.valueOf(rectF));
        if (pAGLayer != null) {
            source.setIndex(pAGLayer.editableIndex());
            replaceLayerAndTrans(source, pAGLayer);
        }
    }

    @NotNull
    public final List<PointF> getImgInScrPoints() {
        return this.imgInScrPoints;
    }

    @NotNull
    public final MediaModel getMediaModel() {
        return this.mediaModel;
    }

    public final int getPagFillMode() {
        return this.pagFillMode;
    }

    @NotNull
    public final CGSize getScreenSize() {
        return this.screenSize;
    }

    @Override // com.tencent.autotemplate.TAVAutomaticRenderContext
    @NotNull
    public CMSampleBuffer renderStickerChainWithTexture(long presentationTimeMs, @NotNull List<TAVSourceImage> sourceImages) {
        Intrinsics.checkParameterIsNotNull(sourceImages, "sourceImages");
        for (TAVSourceImage tAVSourceImage : sourceImages) {
            List<TAVSticker> stickers = this.stickers;
            Intrinsics.checkExpressionValueIsNotNull(stickers, "stickers");
            for (TAVSticker sticker : stickers) {
                PAGRenderer pAGRenderer = new PAGRenderer();
                Intrinsics.checkExpressionValueIsNotNull(sticker, "sticker");
                pAGRenderer.setFile(sticker.getPagFile());
                replaceLayerColor(pAGRenderer, tAVSourceImage, sticker);
                replaceLayerPhoto(pAGRenderer, tAVSourceImage, sticker);
            }
        }
        CMSampleBuffer renderStickerChainWithTexture = super.renderStickerChainWithTexture(presentationTimeMs, sourceImages);
        Intrinsics.checkExpressionValueIsNotNull(renderStickerChainWithTexture, "super.renderStickerChain\u2026tionTimeMs, sourceImages)");
        return renderStickerChainWithTexture;
    }

    public final void setImgInScrPoints(@NotNull List<? extends PointF> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.imgInScrPoints = list;
    }

    public final void setPagFillMode(int i3) {
        this.pagFillMode = i3;
    }

    public final void setScreenSize(@NotNull CGSize cGSize) {
        Intrinsics.checkParameterIsNotNull(cGSize, "<set-?>");
        this.screenSize = cGSize;
    }
}
