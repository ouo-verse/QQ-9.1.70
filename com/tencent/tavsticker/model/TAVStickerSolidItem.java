package com.tencent.tavsticker.model;

import org.libpag.PAGSolidLayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerSolidItem extends TAVStickerLayerItem {
    private int color;

    public TAVStickerSolidItem(PAGSolidLayer pAGSolidLayer) {
        super(pAGSolidLayer);
        if (pAGSolidLayer != null) {
            this.color = pAGSolidLayer.solidColor();
        }
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i3) {
        this.color = i3;
    }
}
