package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ImageViewCatchRecycle extends ImageView {
    public ImageViewCatchRecycle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageViewCatchRecycle", 2, "onDraw() Canvas: trying to use a recycled bitmap");
            }
        }
    }
}
