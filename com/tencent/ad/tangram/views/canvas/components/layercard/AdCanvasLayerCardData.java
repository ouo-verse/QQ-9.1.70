package com.tencent.ad.tangram.views.canvas.components.layercard;

import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;
import com.tencent.ad.tangram.views.canvas.components.imagescarousel.AdCanvasImagesCarouselComponentData;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AdCanvasLayerCardData extends AdCanvasComponentData {
    public AdCanvasAppBtnComponentData adCanvasAppBtnComponentData;
    public AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData;
    public String appDesc;
    public String appName;
    public long downloadCount;
    public int height;
    public int logoHeight;
    public String logoUrl;
    public int logoWidth;
    public int starCount;
    public int width;

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public int getToLoadIdSize() {
        int i3 = 0;
        if (!isValid()) {
            return 0;
        }
        if (this.adCanvasImagesCarouselComponentData != null) {
            i3 = 0 + this.adCanvasAppBtnComponentData.getToLoadIdSize();
        }
        AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = this.adCanvasAppBtnComponentData;
        if (adCanvasAppBtnComponentData != null) {
            return i3 + adCanvasAppBtnComponentData.getToLoadIdSize();
        }
        return i3;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public boolean isValid() {
        return super.isValid();
    }
}
