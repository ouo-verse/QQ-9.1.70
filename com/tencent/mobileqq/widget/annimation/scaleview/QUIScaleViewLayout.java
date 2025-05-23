package com.tencent.mobileqq.widget.annimation.scaleview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUIScaleViewLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f316657d;

    /* renamed from: e, reason: collision with root package name */
    private a f316658e;

    public QUIScaleViewLayout(@NonNull Context context) {
        this(context, null);
    }

    public QUIScaleViewLayout d(int i3, int i16) {
        this.f316658e.b(i3, i16);
        return this;
    }

    public void e(Animation.AnimationListener animationListener) {
        this.f316658e.f(animationListener);
    }

    public void setToScale(float f16, float f17) {
        this.f316658e.d(1.0f, f16, 1.0f, f17);
    }

    public QUIScaleViewLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QUIScaleViewLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316658e = new a();
        post(new Runnable() { // from class: com.tencent.mobileqq.widget.annimation.scaleview.QUIScaleViewLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (QUIScaleViewLayout.this.getChildCount() == 0) {
                    return;
                }
                QUIScaleViewLayout qUIScaleViewLayout = QUIScaleViewLayout.this;
                qUIScaleViewLayout.f316657d = qUIScaleViewLayout.getChildAt(0);
                QUIScaleViewLayout.this.f316658e.e(QUIScaleViewLayout.this.f316657d).d(1.0f, 1.1f, 1.0f, 1.1f).c(1);
            }
        });
    }
}
