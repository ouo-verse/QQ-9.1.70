package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeImageViewOtherCatchRecycle extends ThemeImageView {
    public ThemeImageViewOtherCatchRecycle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ThemeImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("ThemeImageViewOtherCatchRecycle", 2, "onDraw() Canvas: trying to use a recycled bitmap");
            }
        }
    }
}
