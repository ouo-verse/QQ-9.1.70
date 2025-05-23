package com.tencent.ad.tangram.views.canvas.framework;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.ImageLoadParams;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentData;
import com.tencent.ad.tangram.views.canvas.components.pictures.AdCanvasMultiPictureComponentData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class AdCanvasPageData implements Serializable {
    private static final String TAG = "AdCanvasPageData";
    public String arkApp;
    public String arkView;
    public int backgroundColor;
    public List<AdCanvasComponentData> components;

    @Nullable
    private AdCanvasComponentData firstImageComponent;
    public int floatingBarBackgroundColor;
    public int floatingBarTextColor;

    /* renamed from: id, reason: collision with root package name */
    public String f61344id;

    @Nullable
    public ImageLoadParams imageLoadParams;
    public boolean isFloatingBarStyleSetted = false;
    public boolean hasFixedButtonData = false;
    public boolean hasMultiPictureData = false;

    @Nullable
    public AdCanvasComponentData getComponent(int i3) {
        if (isValid() && i3 >= 0 && i3 <= getSize()) {
            return this.components.get(i3);
        }
        AdLog.e(TAG, "getComponent error");
        return null;
    }

    @Nullable
    public AdCanvasComponentData getPageFirstImageComponentData() {
        ArrayList<AdCanvasPictureComponentData> arrayList;
        AdCanvasComponentData adCanvasComponentData = this.firstImageComponent;
        if (adCanvasComponentData != null) {
            return adCanvasComponentData;
        }
        for (int i3 = 0; i3 < this.components.size(); i3++) {
            AdCanvasComponentData component = getComponent(i3);
            if ((component instanceof AdCanvasMultiPictureComponentData) && (arrayList = ((AdCanvasMultiPictureComponentData) component).imageList) != null) {
                AdCanvasPictureComponentData adCanvasPictureComponentData = arrayList.get(0);
                this.firstImageComponent = adCanvasPictureComponentData;
                return adCanvasPictureComponentData;
            }
        }
        return null;
    }

    public int getSize() {
        if (isValid()) {
            return this.components.size();
        }
        return 0;
    }

    public int getToLoadIdSize() {
        int i3 = 0;
        if (isValid()) {
            Iterator<AdCanvasComponentData> it = this.components.iterator();
            while (it.hasNext()) {
                i3 += it.next().getToLoadIdSize();
            }
        }
        return i3;
    }

    public boolean isValid() {
        if (this.components != null) {
            return true;
        }
        return false;
    }
}
