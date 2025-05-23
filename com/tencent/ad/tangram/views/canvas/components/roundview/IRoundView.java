package com.tencent.ad.tangram.views.canvas.components.roundview;

import android.graphics.Canvas;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IRoundView {
    void dispatchDraw(Canvas canvas);

    void onLayout(boolean z16, int i3, int i16, int i17, int i18);

    void setBorderColor(int i3);

    void setBorderWidth(float f16);

    void setRadius(float f16);
}
