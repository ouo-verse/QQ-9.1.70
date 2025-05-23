package com.tencent.mobileqq.widget.qus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUSHalfScreenImmersiveFloatingView extends QUSBaseHalfScreenFloatingView {

    /* renamed from: s0, reason: collision with root package name */
    private boolean f317248s0;

    /* renamed from: t0, reason: collision with root package name */
    private float f317249t0;

    public QUSHalfScreenImmersiveFloatingView(@NonNull Context context) {
        super(context);
        this.f317249t0 = getContext().getResources().getDisplayMetrics().density * 8.0f;
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    protected void B() {
        this.P = new FrameLayout(getContext());
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    protected void C(@Nullable AttributeSet attributeSet, int i3) {
        this.N = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.N.setBackgroundResource(R.drawable.jja);
        layoutParams.gravity = 48;
        g(attributeSet, i3, layoutParams);
    }

    public void setCornerRadius(float f16) {
        if (this.f317249t0 == f16) {
            return;
        }
        this.f317249t0 = f16;
    }

    public void setNotSupportRoundCorner(boolean z16) {
        this.f317248s0 = z16;
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void setQUSDragFloatController(d dVar) {
        super.setQUSDragFloatController(dVar);
        this.P.bringChildToFront(this.N);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public View y(View view) {
        if (this.f317221k0 != null && this.P != null) {
            if (this.f317248s0) {
                QLog.i("QUSHalfScreenImmersiveFloatingView", 1, "not support round corner");
                return view;
            }
            FloatingRoundCorneredLayout floatingRoundCorneredLayout = new FloatingRoundCorneredLayout(getContext());
            floatingRoundCorneredLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            floatingRoundCorneredLayout.setCornerRadius(this.f317249t0);
            floatingRoundCorneredLayout.addView(view);
            return floatingRoundCorneredLayout;
        }
        return view;
    }

    public QUSHalfScreenImmersiveFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f317249t0 = getContext().getResources().getDisplayMetrics().density * 8.0f;
    }

    public QUSHalfScreenImmersiveFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f317249t0 = getContext().getResources().getDisplayMetrics().density * 8.0f;
    }
}
