package com.tencent.qqnt.audio.view.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MoveDistIndicateView extends AppCompatImageView {
    static IPatchRedirector $redirector_;
    private Paint C;
    public int D;
    public int E;
    private int F;
    private Bitmap G;
    private Bitmap H;
    private Matrix I;
    private Rect J;
    private int K;
    private int L;

    /* renamed from: m, reason: collision with root package name */
    private boolean f352638m;

    public MoveDistIndicateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.I = new Matrix();
        this.J = new Rect();
        this.K = 0;
        this.L = 0;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.C = paint;
        paint.setAntiAlias(true);
        this.D = l(29.0f);
        this.E = l(42.0f);
        this.L = l(10.0f);
        this.F = this.D;
        if (QLog.isDevelopLevel()) {
            QLog.d("MoveDistIndicateView", 4, "init(), mRaidusMin:" + this.D + ",mRaidusMax:" + this.E);
        }
    }

    public static int l(float f16) {
        return (int) ((f16 * BaseApplication.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (this.f352638m) {
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i3 = width / 2;
        int i16 = height / 2;
        int saveCount = canvas.getSaveCount();
        canvas.save();
        int i17 = this.F;
        int i18 = this.D;
        if (i17 > this.L + i18) {
            if (this.H != null) {
                float f16 = this.E / i18;
                this.I.reset();
                int width2 = this.H.getWidth();
                int height2 = this.H.getHeight();
                this.I.setScale(f16, f16);
                this.I.postTranslate((width - (width2 * f16)) / 2.0f, (height - (height2 * f16)) / 2.0f);
                this.J.set(0, 0, width2, height2);
                canvas.concat(this.I);
                canvas.drawBitmap(this.H, (Rect) null, this.J, (Paint) null);
            } else {
                if (this.K == 1) {
                    this.C.setColor(getResources().getColor(R.color.skin_press_after_enter_left));
                } else {
                    this.C.setColor(getResources().getColor(R.color.skin_press_after_enter_right));
                }
                this.C.setStyle(Paint.Style.FILL_AND_STROKE);
                this.C.setStrokeWidth(1.0f);
                canvas.drawCircle(i3, i16, this.F, this.C);
            }
        } else if (i17 > i18) {
            this.C.setColor(getResources().getColor(R.color.skin_before_enter));
            this.C.setStyle(Paint.Style.FILL_AND_STROKE);
            this.C.setStrokeWidth(1.0f);
            canvas.drawCircle(i3, i16, this.D, this.C);
        } else if (this.G != null) {
            float f17 = i17 / i18;
            this.I.reset();
            int width3 = this.G.getWidth();
            int height3 = this.G.getHeight();
            float f18 = ((width - (width3 * f17)) * 0.5f) + 0.5f;
            float f19 = ((height - (height3 * f17)) * 0.5f) + 0.5f;
            if (QLog.isColorLevel()) {
                QLog.d("MoveDistIndicateView", 2, "dx is:" + f18 + ",dy is:" + f19);
            }
            this.I.setScale(f17, f17);
            this.I.postTranslate(f18, f19);
            this.J.set(0, 0, width3, height3);
            canvas.concat(this.I);
            canvas.drawBitmap(this.G, (Rect) null, this.J, (Paint) null);
        } else {
            this.C.setColor(-1);
            this.C.setStyle(Paint.Style.FILL);
            this.C.setStrokeWidth(1.0f);
            canvas.drawCircle(i3, i16, this.F, this.C);
        }
        canvas.restoreToCount(saveCount);
        super.onDraw(canvas);
    }

    public void setAfterBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
        } else {
            this.H = bitmap;
        }
    }

    public void setDisableCustomDraw(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f352638m = z16;
        }
    }

    public void setLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        int i16 = this.D;
        this.F = i16 + (((this.E - i16) * i3) / 100);
        if (QLog.isDevelopLevel()) {
            QLog.d("MoveDistIndicateView", 4, "setLevel(), max=" + this.E + " min=" + this.D + " mRadius=" + this.F + " type=" + this.K + " level=" + i3);
        }
        if (this.F > this.D + this.L) {
            setPressed(true);
        } else {
            setPressed(false);
        }
        invalidate();
    }

    public void setScaleBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        } else {
            this.G = bitmap;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.K = i3;
        }
    }
}
