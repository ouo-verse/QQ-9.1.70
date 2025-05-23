package com.tencent.mobileqq.qui.shimmerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qui.quishimmer.QUIShimmerController;
import com.tencent.biz.qui.quishimmer.QUIShimmerEntity;
import com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import ud0.d;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QUIShimmerUrlImageView extends URLImageView implements QUIShimmerInterface {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QUIShimmerImageView";
    QUIShimmerEntity shimmerEntity;

    public QUIShimmerUrlImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.shimmerEntity = null;
            this.shimmerEntity = new QUIShimmerEntity(this, context, attributeSet);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.shimmerEntity == null) {
            d.g(TAG, d.f438811e, "setBounds faild because shimmerEntity is null");
        } else {
            this.shimmerEntity.setBounds(getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "setBusinessTag faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.setBusinessTag(str);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void setOnVisibilityChangeListener(QUIShimmerEntity.OnVisibilityChangeListener onVisibilityChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onVisibilityChangeListener);
            return;
        }
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "setOnVisibilityChangeListener faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.setOnVisibilityChangeListener(onVisibilityChangeListener);
        }
    }

    public void startShimming(QUIShimmerController qUIShimmerController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qUIShimmerController);
            return;
        }
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "startShimming faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.startShimmer(qUIShimmerController);
        }
    }

    public void stopShimming(QUIShimmerController qUIShimmerController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qUIShimmerController);
            return;
        }
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "stopShimming faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.stopShimmer(qUIShimmerController);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateColors(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "updateColors faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.updateColors(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity == null) {
            d.g(TAG, d.f438811e, "updateRepeateCount faild because shimmerEntity is null");
        } else {
            qUIShimmerEntity.updateAnimatorRepeatCount(i3);
        }
    }

    @Override // com.tencent.biz.qui.quishimmer.coreinterface.QUIShimmerInterface
    public void updateXfermode(PorterDuff.Mode mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) mode);
            return;
        }
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity != null) {
            qUIShimmerEntity.updateXfermode(mode);
        } else {
            d.g(TAG, d.f438811e, "updateXfermode shimmerEntity is null");
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable)).booleanValue();
        }
        if (this.shimmerEntity == null) {
            return super.verifyDrawable(drawable);
        }
        if (!super.verifyDrawable(drawable) && !this.shimmerEntity.verifyDrawable(drawable)) {
            return false;
        }
        return true;
    }

    public QUIShimmerUrlImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUIShimmerUrlImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }
}
