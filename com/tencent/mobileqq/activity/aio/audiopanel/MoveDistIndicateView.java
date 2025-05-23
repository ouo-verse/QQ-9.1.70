package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MoveDistIndicateView extends ImageView implements com.tencent.mvp.c {
    private Bitmap C;
    private Matrix D;
    private Rect E;
    private int F;
    private int G;
    private k H;

    /* renamed from: d, reason: collision with root package name */
    private boolean f178280d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f178281e;

    /* renamed from: f, reason: collision with root package name */
    public int f178282f;

    /* renamed from: h, reason: collision with root package name */
    public int f178283h;

    /* renamed from: i, reason: collision with root package name */
    private int f178284i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f178285m;

    public MoveDistIndicateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new Matrix();
        this.E = new Rect();
        this.F = 0;
        this.G = 0;
        g(context);
    }

    private void g(Context context) {
        Paint paint = new Paint();
        this.f178281e = paint;
        paint.setAntiAlias(true);
        this.f178282f = ViewUtils.dip2px(29.0f);
        this.f178283h = ViewUtils.dip2px(42.0f);
        this.G = ViewUtils.dip2px(10.0f);
        this.f178284i = this.f178282f;
        if (QLog.isDevelopLevel()) {
            QLog.d("MoveDistIndicateView", 4, "init(), mRaidusMin:" + this.f178282f + ",mRaidusMax:" + this.f178283h);
        }
    }

    @Override // com.tencent.mvp.c
    public com.tencent.mvp.b getPresenter() {
        return this.H;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f178280d) {
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i3 = width / 2;
        int i16 = height / 2;
        int saveCount = canvas.getSaveCount();
        canvas.save();
        int i17 = this.f178284i;
        int i18 = this.f178282f;
        if (i17 > this.G + i18) {
            if (this.C != null) {
                float f16 = this.f178283h / i18;
                this.D.reset();
                int width2 = this.C.getWidth();
                int height2 = this.C.getHeight();
                this.D.setScale(f16, f16);
                this.D.postTranslate((width - (width2 * f16)) / 2.0f, (height - (height2 * f16)) / 2.0f);
                this.E.set(0, 0, width2, height2);
                canvas.concat(this.D);
                canvas.drawBitmap(this.C, (Rect) null, this.E, (Paint) null);
            } else {
                if (this.F == 1) {
                    this.f178281e.setColor(getResources().getColor(R.color.skin_press_after_enter_left));
                } else {
                    this.f178281e.setColor(getResources().getColor(R.color.skin_press_after_enter_right));
                }
                this.f178281e.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f178281e.setStrokeWidth(1.0f);
                canvas.drawCircle(i3, i16, this.f178284i, this.f178281e);
            }
        } else if (i17 > i18) {
            this.f178281e.setColor(getResources().getColor(R.color.skin_before_enter));
            this.f178281e.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f178281e.setStrokeWidth(1.0f);
            canvas.drawCircle(i3, i16, this.f178282f, this.f178281e);
        } else if (this.f178285m != null) {
            float f17 = i17 / i18;
            this.D.reset();
            int width3 = this.f178285m.getWidth();
            int height3 = this.f178285m.getHeight();
            float f18 = ((width - (width3 * f17)) * 0.5f) + 0.5f;
            float f19 = ((height - (height3 * f17)) * 0.5f) + 0.5f;
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "dx is:" + f18 + ",dy is:" + f19);
            }
            this.D.setScale(f17, f17);
            this.D.postTranslate(f18, f19);
            this.E.set(0, 0, width3, height3);
            canvas.concat(this.D);
            canvas.drawBitmap(this.f178285m, (Rect) null, this.E, (Paint) null);
        } else {
            k kVar = this.H;
            if (kVar != null && kVar.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
                this.f178281e.setColor(-16711423);
            } else {
                this.f178281e.setColor(-1);
            }
            this.f178281e.setStyle(Paint.Style.FILL);
            this.f178281e.setStrokeWidth(1.0f);
            canvas.drawCircle(i3, i16, this.f178284i, this.f178281e);
        }
        canvas.restoreToCount(saveCount);
        super.onDraw(canvas);
    }

    public void setAfterBitmap(Bitmap bitmap) {
        this.C = bitmap;
    }

    public void setDisableCustomDraw(boolean z16) {
        this.f178280d = z16;
    }

    public void setLevel(int i3) {
        int i16 = this.f178282f;
        int i17 = (((this.f178283h - i16) * i3) / 100) + i16;
        this.f178284i = i17;
        if (i17 > i16 + this.G) {
            setPressed(true);
        } else {
            setPressed(false);
        }
        invalidate();
    }

    public void setPresenter(com.tencent.mvp.b bVar) {
        if (bVar != null && (bVar instanceof k)) {
            this.H = (k) bVar;
        }
        if (bVar == null) {
            this.H = null;
        }
    }

    public void setScaleBitmap(Bitmap bitmap) {
        this.f178285m = bitmap;
    }

    public void setType(int i3) {
        this.F = i3;
    }
}
