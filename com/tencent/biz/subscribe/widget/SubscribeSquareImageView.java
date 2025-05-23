package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SquareImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeSquareImageView extends SquareImageView {
    private static int H;
    private int G;

    public SubscribeSquareImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.SquareImageView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.C.set(0.0f, 0.0f, getMeasuredWidth(), this.G);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.SquareImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (H == 0) {
            H = ViewUtils.getScreenWidth();
        }
        int dip2px = ViewUtils.dip2px(10.0f) * 2;
        this.G = (int) (((((H - dip2px) / 2) - ViewUtils.dip2px(10.0f)) * 1.0f) / 0.7d);
        setMeasuredDimension(getMeasuredWidth(), this.G);
    }

    public SubscribeSquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SubscribeSquareImageView(Context context) {
        super(context);
    }
}
