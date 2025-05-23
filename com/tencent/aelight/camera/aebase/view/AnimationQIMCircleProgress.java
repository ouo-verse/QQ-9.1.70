package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.flashshow.util.v;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.aelight.camera.ae.view.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.QIMCircleProgress;

/* loaded from: classes32.dex */
public class AnimationQIMCircleProgress extends QIMCircleProgress {
    private b C;
    Paint D;
    private RectF E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;

    /* renamed from: d, reason: collision with root package name */
    private float f66040d;

    /* renamed from: e, reason: collision with root package name */
    private int f66041e;

    /* renamed from: f, reason: collision with root package name */
    private int f66042f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f66043h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f66044i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f66045m;

    public AnimationQIMCircleProgress(Context context) {
        super(context);
        this.f66040d = 1.0f;
        this.f66043h = false;
        this.f66044i = false;
        this.f66045m = false;
        this.C = null;
        this.H = true;
    }

    public void a(boolean z16, b bVar) {
        this.f66045m = z16;
        this.C = bVar;
        if (z16) {
            setBackgroundResource(bVar.f65907d);
            setCenterCircleColor(0);
            setProgressOffset(BaseAIOUtils.f(2.5f, getResources()));
            setProgressColor(this.C.f65912i);
        } else {
            setBackgroundResource(R.drawable.iyn);
            setCenterCircleColor(-1);
        }
        invalidate();
    }

    public void b(boolean z16) {
        this.f66044i = z16;
        if (z16) {
            if (this.I) {
                setBackgroundResource(R.drawable.ito);
                setCenterCircleColor(getResources().getColor(R.color.f9068n));
            } else {
                setBackgroundResource(R.drawable.hki);
                setCenterCircleColor(getResources().getColor(R.color.f9138u));
            }
        } else {
            setBackgroundResource(R.drawable.iyn);
            setCenterCircleColor(-1);
        }
        invalidate();
    }

    protected void c(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f66042f * this.mCenterScale, this.mPaintWhite);
    }

    @Override // com.tencent.widget.QIMCircleProgress
    public void changeMode(int i3) {
        b bVar;
        if (this.f66045m && (bVar = this.C) != null) {
            setBackgroundResource(bVar.f65907d);
        } else if (this.f66044i) {
            if (this.I) {
                setBackgroundResource(R.drawable.ito);
                setCenterCircleColor(getResources().getColor(R.color.f9068n));
            } else {
                setBackgroundResource(R.drawable.hki);
                setCenterCircleColor(getResources().getColor(R.color.f9138u));
            }
        } else if (i3 != 1 && this.f66043h) {
            setBackgroundDrawable(null);
        } else {
            setBackgroundResource(R.drawable.iyn);
        }
        super.changeMode(i3);
    }

    protected void d(Canvas canvas) {
        this.E.set((getWidth() - this.F) / 2, (getHeight() - this.F) / 2, r0 + r2, r1 + r2);
        RectF rectF = this.E;
        int i3 = this.G;
        canvas.drawRoundRect(rectF, i3, i3, this.mPaintWhite);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.QIMCircleProgress
    public void drawCenterCircle(Canvas canvas) {
        if (this.H) {
            if (!this.f66043h) {
                if (this.mMode == 3) {
                    d(canvas);
                    return;
                } else {
                    c(canvas);
                    return;
                }
            }
            int i3 = this.mMode;
            if (i3 == 1) {
                c(canvas);
                return;
            }
            if (i3 == 3) {
                d(canvas);
            }
            e(canvas);
        }
    }

    protected void e(Canvas canvas) {
        int a16 = v.a(getContext(), 3.0f);
        Color.parseColor(GameCenterVideoViewController.GRAY_MASK);
        int i3 = this.mWidth;
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(a16);
        this.D.setColor(-1);
        canvas.drawCircle(i3 / 2, i3 / 2, (i3 / 2) - (a16 / 2), this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.QIMCircleProgress
    public void init() {
        super.init();
        this.I = i.b();
        Paint paint = new Paint();
        this.D = paint;
        paint.setAntiAlias(true);
        this.mPaintWhite.setStyle(Paint.Style.FILL);
        setBackgroundResource(R.drawable.iyn);
        this.F = ViewUtils.dip2px(30.0f);
        this.G = ViewUtils.dip2px(6.0f);
        this.E = new RectF();
    }

    @Override // com.tencent.widget.QIMCircleProgress
    public void setCenterView() {
        super.setCenterView();
        this.f66041e = ViewUtils.dip2px(3.0f);
        this.f66042f = ViewUtils.dip2px(14.0f);
    }

    public void setDrawCenterCircle(boolean z16) {
        if (this.H != z16) {
            this.H = z16;
            invalidate();
        }
    }

    public void setIldeStyle(boolean z16) {
        this.f66043h = z16;
        if (z16) {
            setBackgroundDrawable(null);
        } else {
            setBackgroundResource(R.drawable.iyn);
        }
        invalidate();
    }

    public AnimationQIMCircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f66040d = 1.0f;
        this.f66043h = false;
        this.f66044i = false;
        this.f66045m = false;
        this.C = null;
        this.H = true;
    }
}
