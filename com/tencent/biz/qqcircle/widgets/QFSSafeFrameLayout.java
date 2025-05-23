package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSafeFrameLayout extends FrameLayout {
    public QFSSafeFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        try {
            setMeasuredDimension(i3, i16);
            super.onMeasure(i3, i16);
        } catch (Exception e16) {
            QLog.d("QFSSafeFrameLayout", 1, "measure error:" + e16);
        }
    }

    public QFSSafeFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSafeFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
