package com.tencent.ad.tangram.views.canvas.components.imagescarousel;

import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasImagesCarouselComponentData extends AdCanvasComponentData {
    public int height;
    public String imageBorderColor;
    public int imageBorderWidth;
    public int imageHeight;
    public ArrayList<AdCanvasPictureComponentData> imageList;
    public int imageRadius;
    public int imageWidth;
    public int marginBottom;
    public int marginLeft;
    public int marginRight;
    public int marginTop;
    public int width;
    public int displaySpeed = 2;
    public int pageLimit = 2;
    public int pageMargin = 0;
    public boolean enableImageRoundRectBackground = false;

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public int getToLoadIdSize() {
        ArrayList<AdCanvasPictureComponentData> arrayList;
        if (!isValid() || (arrayList = this.imageList) == null) {
            return 0;
        }
        return 0 + arrayList.size();
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public boolean isValid() {
        if (super.isValid() && this.imageWidth > 0 && this.imageHeight > 0) {
            return true;
        }
        return false;
    }
}
