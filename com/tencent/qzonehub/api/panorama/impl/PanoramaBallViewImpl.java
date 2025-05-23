package com.tencent.qzonehub.api.panorama.impl;

import android.content.Context;
import android.view.View;
import com.tencent.qzonehub.api.panorama.IPanoramaBallView;
import cooperation.qzone.panorama.widget.PanoramaBallView;

/* loaded from: classes34.dex */
public class PanoramaBallViewImpl implements IPanoramaBallView {
    @Override // com.tencent.qzonehub.api.panorama.IPanoramaBallView
    public int getMoveDegreeX(View view) {
        return ((PanoramaBallView) view).getMoveDegreeX();
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaBallView
    public int getMoveDegreeY(View view) {
        return ((PanoramaBallView) view).getMoveDegreeY();
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaBallView
    public View getPanoramaBallView(Context context) {
        return new PanoramaBallView(context);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaBallView
    public void setDegreeChange(View view, int i3, int i16, int i17, float f16) {
        ((PanoramaBallView) view).setDegreeChange(i3, i16, i17, f16);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaBallView
    public void setModeType(View view, int i3) {
        ((PanoramaBallView) view).setModeType(i3);
    }
}
