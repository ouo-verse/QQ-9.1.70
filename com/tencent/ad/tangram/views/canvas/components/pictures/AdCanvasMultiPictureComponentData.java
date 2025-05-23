package com.tencent.ad.tangram.views.canvas.components.pictures;

import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentData;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class AdCanvasMultiPictureComponentData extends AdCanvasComponentData {
    public int floatingBarBackgroundColor;
    public int floatingBarTextColor;
    public ArrayList<AdCanvasPictureComponentData> imageList;

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
        return super.isValid();
    }
}
