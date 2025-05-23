package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.ProgressButton;

/* loaded from: classes4.dex */
public class AdProgressButton extends ProgressButton {
    public AdProgressButton(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.ProgressButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        getPaddingLeft();
        getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        getWidth();
        if (this.f316003f == 0.0f) {
            this.f316003f = getWidth() / this.f316005i;
        }
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.f316003f * this.f316004h, height), 5.0f, 5.0f, this.f316001d);
        super.onDraw(canvas);
    }

    public AdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
