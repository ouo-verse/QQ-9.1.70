package com.tencent.tavsticker.model;

import com.tencent.tavsticker.core.TAVStickerParser;
import org.libpag.PAGLayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TAVStickerLayerItem {
    protected int layerIndex;
    protected TAVStickerLayerInfo layerInfo;
    protected String layerName;
    protected int layerType;

    public TAVStickerLayerItem() {
        this.layerIndex = -1;
        this.layerName = "";
        this.layerType = 0;
        this.layerInfo = null;
    }

    public int getLayerIndex() {
        return this.layerIndex;
    }

    public TAVStickerLayerInfo getLayerInfo() {
        return this.layerInfo;
    }

    public String getLayerName() {
        return this.layerName;
    }

    public int getLayerType() {
        return this.layerType;
    }

    public void setLayerIndex(int i3) {
        this.layerIndex = i3;
    }

    public TAVStickerLayerItem(PAGLayer pAGLayer) {
        this.layerIndex = -1;
        this.layerName = "";
        this.layerType = 0;
        this.layerInfo = null;
        if (pAGLayer != null) {
            this.layerIndex = pAGLayer.editableIndex();
            this.layerName = pAGLayer.layerName();
            this.layerType = pAGLayer.layerType();
            this.layerInfo = TAVStickerParser.parsePagLayer(pAGLayer);
        }
    }
}
