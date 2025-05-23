package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WsStickerRenderContext extends TAVStickerRenderContext implements IBlurStickerRenderContext {
    protected List<TAVSticker> blurStickers = Collections.synchronizedList(new ArrayList());

    private boolean isBlurSticker(TAVSticker tAVSticker) {
        if (tAVSticker != null && tAVSticker.getExtraBundle() != null && TAVStickerExKt.getExtraStickerType(tAVSticker) != null && TAVStickerExKt.getExtraStickerType(tAVSticker).equals("blur")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public void checkStickerList() {
        super.checkStickerList();
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

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public void loadSticker(TAVSticker tAVSticker, boolean z16) {
        if (isBlurSticker(tAVSticker) && !this.blurStickers.contains(tAVSticker)) {
            this.blurStickers.add(tAVSticker);
        }
        super.loadSticker(tAVSticker, z16);
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public void removeAllStickers() {
        this.blurStickers.clear();
        super.removeAllStickers();
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public boolean removeSticker(TAVSticker tAVSticker) {
        if (this.blurStickers.contains(tAVSticker)) {
            this.blurStickers.remove(tAVSticker);
        }
        return super.removeSticker(tAVSticker);
    }

    public void setLayerIndex(int i3) {
        this.stickerLayerIndex = i3;
    }

    public void setRenderContextSource(ITAVRenderContextDataSource iTAVRenderContextDataSource) {
        this.renderContextDataSource = iTAVRenderContextDataSource;
    }

    public void setStickerList(List<TAVSticker> list) {
        this.stickers = list;
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
