package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QqViewFlipper extends ViewFlipper {
    public QqViewFlipper(Context context) {
        super(context);
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException unused) {
            stopFlipping();
        }
    }

    public QqViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
