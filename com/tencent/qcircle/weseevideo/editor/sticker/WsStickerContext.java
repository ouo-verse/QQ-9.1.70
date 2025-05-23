package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.graphics.PointF;
import com.tencent.qcircle.weseevideo.composition.effectnode.WsStickerUtil;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WsStickerContext extends TAVStickerContext implements IBlurStickerRenderContext {
    protected List<TAVSticker> blurStickers;

    public WsStickerContext(Context context) {
        super(context);
        this.blurStickers = Collections.synchronizedList(new ArrayList());
    }

    public static boolean isBlurSticker(TAVSticker tAVSticker) {
        if (tAVSticker != null && tAVSticker.getExtraBundle() != null && TAVStickerExKt.getExtraStickerType(tAVSticker) != null && TAVStickerExKt.getExtraStickerType(tAVSticker).equals("blur")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public TAVStickerRenderContext copy() {
        WsStickerRenderContext wsStickerRenderContext = new WsStickerRenderContext();
        wsStickerRenderContext.checkStickerList();
        List<TAVSticker> list = this.stickers;
        if (list != null) {
            wsStickerRenderContext.setStickerList(list);
        }
        wsStickerRenderContext.setRenderSize(this.renderSize);
        wsStickerRenderContext.setLayerIndex(this.stickerLayerIndex);
        wsStickerRenderContext.setRenderContextSource(this.renderContextDataSource);
        wsStickerRenderContext.setStickerRenderQuality(this.quality);
        wsStickerRenderContext.blurStickers = this.blurStickers;
        checkChildContexts();
        this.childContexts.add(wsStickerRenderContext);
        return wsStickerRenderContext;
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.IBlurStickerRenderContext
    public List<TAVSticker> getBlurStickers() {
        return this.blurStickers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public boolean isTouchOnTavSticker(TAVSticker tAVSticker, float f16, float f17) {
        PointF[] computeRectanglePoints;
        if (tAVSticker == null || !TAVStickerUtil.isValidCGSize(this.renderSize)) {
            return false;
        }
        if ("blur".equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
            CGSize cGSize = this.renderSize;
            computeRectanglePoints = WsStickerUtil.computeRectanglePointsForBlurSticker(WsStickerUtil.getRatioChangeMatrix(tAVSticker, (int) cGSize.width, (int) cGSize.height), tAVSticker.getWidth(), tAVSticker.getHeight());
        } else {
            CGSize cGSize2 = this.renderSize;
            computeRectanglePoints = WsStickerUtil.computeRectanglePoints(TAVStickerUtil.getMatrix(tAVSticker, (int) cGSize2.width, (int) cGSize2.height), tAVSticker.getWidth(), tAVSticker.getHeight());
        }
        if (!TAVStickerUtil.inQuadrangle(computeRectanglePoints[0], computeRectanglePoints[1], computeRectanglePoints[2], computeRectanglePoints[3], new PointF(f16, f17))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContext, com.tencent.tavsticker.core.TAVStickerRenderContext
    public void loadSticker(TAVSticker tAVSticker, boolean z16) {
        if (isBlurSticker(tAVSticker) && !this.blurStickers.contains(tAVSticker)) {
            this.blurStickers.add(tAVSticker);
        }
        super.loadSticker(tAVSticker, z16);
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContext, com.tencent.tavsticker.core.TAVStickerRenderContext
    public void removeAllStickers() {
        this.blurStickers.clear();
        super.removeAllStickers();
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContext, com.tencent.tavsticker.core.TAVStickerRenderContext
    public boolean removeSticker(TAVSticker tAVSticker) {
        if (this.blurStickers.contains(tAVSticker)) {
            this.blurStickers.remove(tAVSticker);
        }
        return super.removeSticker(tAVSticker);
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.IBlurStickerRenderContext
    public boolean shouldRenderBlurSticker() {
        List<TAVSticker> list = this.blurStickers;
        if (list != null && list.size() != 0) {
            Iterator<TAVSticker> it = this.blurStickers.iterator();
            while (it.hasNext()) {
                if (it.next().getMode() == TAVStickerMode.INACTIVE) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    protected boolean shouldRenderSticker(TAVSticker tAVSticker, long j3) {
        boolean containsTime;
        if (tAVSticker == null) {
            return false;
        }
        ITAVRenderContextDataSource iTAVRenderContextDataSource = this.renderContextDataSource;
        if (iTAVRenderContextDataSource != null) {
            return iTAVRenderContextDataSource.shouldRenderSticker(tAVSticker, j3);
        }
        CMTimeRange timeRange = tAVSticker.getTimeRange();
        if (timeRange == null) {
            containsTime = true;
        } else {
            containsTime = timeRange.containsTime(new CMTime(j3, 1000));
        }
        if ((isBlurSticker(tAVSticker) && tAVSticker.getMode() == TAVStickerMode.INACTIVE) || !containsTime || TAVStickerMode.INACTIVE != tAVSticker.getMode()) {
            return false;
        }
        return true;
    }
}
