package com.tencent.mobileqq.matchfriend.reborn.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.qui.quishimmer.QUIShimmerController;
import com.tencent.biz.qui.quishimmer.QUIShimmerEntity;
import com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ShimmerLinearLayout extends LinearLayout implements QUIShimmerInterface {

    /* renamed from: d, reason: collision with root package name */
    QUIShimmerEntity f245508d;

    public ShimmerLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f245508d == null) {
            QLog.i("ShimmerLinearLayout", 1, "onVisibilityChanged update faild because shimmerEntity is null");
            return;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.f245508d.drawLightOnCanvas(canvas, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f245508d == null) {
            QLog.i("ShimmerLinearLayout", 1, "setBounds faild because shimmerEntity is null");
            return;
        }
        this.f245508d.setBounds(getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        QUIShimmerEntity qUIShimmerEntity = this.f245508d;
        if (qUIShimmerEntity == null) {
            QLog.i("ShimmerLinearLayout", 1, "onVisibilityChanged update faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.onVisibilityChanged(view, i3);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void setBusinessTag(String str) {
        QUIShimmerEntity qUIShimmerEntity = this.f245508d;
        if (qUIShimmerEntity == null) {
            QLog.i("ShimmerLinearLayout", 1, "setBusinessTag faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.setBusinessTag(str);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void setOnVisibilityChangeListener(QUIShimmerEntity.OnVisibilityChangeListener onVisibilityChangeListener) {
        QUIShimmerEntity qUIShimmerEntity = this.f245508d;
        if (qUIShimmerEntity == null) {
            QLog.i("ShimmerLinearLayout", 1, "setOnVisibilityChangeListener faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.setOnVisibilityChangeListener(onVisibilityChangeListener);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void startShimming(QUIShimmerController qUIShimmerController) {
        QUIShimmerEntity qUIShimmerEntity = this.f245508d;
        if (qUIShimmerEntity == null) {
            QLog.i("ShimmerLinearLayout", 1, "startShimming faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.startShimmer(qUIShimmerController);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void stopShimming(QUIShimmerController qUIShimmerController) {
        QUIShimmerEntity qUIShimmerEntity = this.f245508d;
        if (qUIShimmerEntity == null) {
            QLog.i("ShimmerLinearLayout", 1, "stopShimming faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.stopShimmer(qUIShimmerController);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateColors(int i3, int i16, int i17, int i18) {
        QUIShimmerEntity qUIShimmerEntity = this.f245508d;
        if (qUIShimmerEntity == null) {
            QLog.i("ShimmerLinearLayout", 1, "updateColors faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.updateColors(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateRepeatCount(int i3) {
        QUIShimmerEntity qUIShimmerEntity = this.f245508d;
        if (qUIShimmerEntity == null) {
            QLog.i("ShimmerLinearLayout", 1, "updateRepeateCount faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.updateAnimatorRepeatCount(i3);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateXfermode(PorterDuff.Mode mode) {
        QUIShimmerEntity qUIShimmerEntity = this.f245508d;
        if (qUIShimmerEntity != null) {
            qUIShimmerEntity.updateXfermode(mode);
        } else {
            QLog.i("ShimmerLinearLayout", 1, "updateXfermode shimmerEntity is null");
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (this.f245508d == null) {
            return super.verifyDrawable(drawable);
        }
        return super.verifyDrawable(drawable) || this.f245508d.verifyDrawable(drawable);
    }

    public ShimmerLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f245508d = null;
        this.f245508d = new QUIShimmerEntity(this, context, attributeSet);
    }
}
