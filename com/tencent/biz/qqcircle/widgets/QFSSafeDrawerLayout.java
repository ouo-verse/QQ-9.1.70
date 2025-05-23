package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSafeDrawerLayout extends DrawerLayout {
    public QFSSafeDrawerLayout(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        try {
            setMeasuredDimension(i3, i16);
            super.onMeasure(i3, i16);
        } catch (Exception e16) {
            QLog.d("QFSSafeDrawerLayout", 1, "measure error:" + e16);
        }
    }

    public QFSSafeDrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSafeDrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
