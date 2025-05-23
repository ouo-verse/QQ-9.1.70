package com.tencent.mobileqq.widget.qus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUSHalfScreenFloatingView extends QUSBaseHalfScreenFloatingView {
    public QUSHalfScreenFloatingView(@NonNull Context context) {
        super(context, null);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    protected void B() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.P = linearLayout;
        linearLayout.setOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void C(@Nullable AttributeSet attributeSet, int i3) {
        this.N = new FrameLayout(getContext());
        g(attributeSet, i3, new FrameLayout.LayoutParams(-1, -2));
    }

    public void setHeadViewBg(int i3) {
        FrameLayout frameLayout = this.N;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(i3);
        }
    }

    public QUSHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public QUSHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public View y(View view) {
        return view;
    }
}
