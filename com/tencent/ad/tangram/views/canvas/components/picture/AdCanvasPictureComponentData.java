package com.tencent.ad.tangram.views.canvas.components.picture;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.pictures.HotArea;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AdCanvasPictureComponentData extends AdCanvasComponentData {
    public String actionUrl;
    public int floatingBarBackgroundColor;
    public int floatingBarTextColor;
    public String gaussianUrl;

    @Nullable
    public ArrayList<HotArea> hotAreaList;
    public String imageId;
    public String url;
    public int width = 0;
    public int height = 0;
    public boolean isLoadFirst = true;
    public volatile boolean needFirstImageReport = false;
    public boolean enableRoundRectBackground = false;
    public int borderWidth = 0;
    public int radius = 0;
    public String borderColor = "#E3E3E3";

    public boolean isHotAreaValild() {
        ArrayList<HotArea> arrayList = this.hotAreaList;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public boolean isValid() {
        if (super.isValid() && this.width > 0 && this.height > 0 && !TextUtils.isEmpty(this.url)) {
            return true;
        }
        return false;
    }
}
