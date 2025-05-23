package com.tencent.mobileqq.vas.pendant.drawable.interfaces;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes20.dex */
public interface IDiyPendantDrawable extends Invalidatable {

    /* loaded from: classes20.dex */
    public interface Sticker {
        void draw(Canvas canvas, Paint paint);
    }

    String getUinAndDiyId();

    void setPendantDiy(String str);
}
