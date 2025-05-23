package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AsyncSquareImageView extends AsyncImageView {
    public AsyncSquareImageView(Context context) {
        super(context);
    }

    public AsyncSquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i16));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public AsyncSquareImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
