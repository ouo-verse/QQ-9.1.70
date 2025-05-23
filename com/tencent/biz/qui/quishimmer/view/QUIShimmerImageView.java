package com.tencent.biz.qui.quishimmer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quishimmer.QUIShimmerController;
import com.tencent.biz.qui.quishimmer.QUIShimmerEntity;
import com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface;
import ud0.d;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class QUIShimmerImageView extends ImageView implements QUIShimmerInterface {
    private static final String TAG = "QUIShimmerImageView";
    QUIShimmerEntity shimmerEntity;

    public QUIShimmerImageView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.shimmerEntity == null) {
            d.g(TAG, d.f438811e, "onVisibilityChanged update faild because shimmerEntity is null");
            return;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.shimmerEntity.drawLightOnCanvas(canvas, iArr);
    }

    @Override // android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.shimmerEntity == null) {
            d.g(TAG, d.f438811e, "setBounds faild because shimmerEntity is null");
            return;
        }
        this.shimmerEntity.setBounds(getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "onVisibilityChanged update faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.onVisibilityChanged(view, i3);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void setBusinessTag(String str) {
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "set BusinessTag faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.setBusinessTag(str);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void setOnVisibilityChangeListener(QUIShimmerEntity.OnVisibilityChangeListener onVisibilityChangeListener) {
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "setOnVisibilityChangeListener faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.setOnVisibilityChangeListener(onVisibilityChangeListener);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void startShimming(QUIShimmerController qUIShimmerController) {
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "startShimming faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.startShimmer(qUIShimmerController);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void stopShimming(QUIShimmerController qUIShimmerController) {
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "stopShimming faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.stopShimmer(qUIShimmerController);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateColors(int i3, int i16, int i17, int i18) {
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "updateColors faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.updateColors(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateRepeatCount(int i3) {
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "updateRepeateCount faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.updateAnimatorRepeatCount(i3);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateXfermode(PorterDuff.Mode mode) {
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity != null) {
            qUIShimmerEntity.updateXfermode(mode);
        } else {
            d.g(TAG, d.f438811e, "updateXfermode shimmerEntity is null");
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (this.shimmerEntity == null) {
            return super.verifyDrawable(drawable);
        }
        if (!super.verifyDrawable(drawable) && !this.shimmerEntity.verifyDrawable(drawable)) {
            return false;
        }
        return true;
    }

    public QUIShimmerImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QUIShimmerImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.shimmerEntity = null;
        this.shimmerEntity = new QUIShimmerEntity(this, context, attributeSet);
    }
}
