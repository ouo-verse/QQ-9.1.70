package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/* loaded from: classes20.dex */
public class ProfileCardScrollImageView extends ImageView {
    private int C;
    private boolean D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private int f315970d;

    /* renamed from: e, reason: collision with root package name */
    private int f315971e;

    /* renamed from: f, reason: collision with root package name */
    private int f315972f;

    /* renamed from: h, reason: collision with root package name */
    private long f315973h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f315974i;

    /* renamed from: m, reason: collision with root package name */
    private DecelerateInterpolator f315975m;

    public ProfileCardScrollImageView(Context context) {
        super(context);
        this.f315970d = 1500;
        this.f315971e = 0;
        this.f315972f = 0;
        this.f315974i = false;
        this.C = 3;
        this.D = false;
        this.E = false;
        a();
    }

    private void a() {
        if (this.f315975m == null) {
            this.f315975m = new DecelerateInterpolator(1.0f);
        }
    }

    public void b() {
        this.C = 3;
        invalidate();
    }

    public void c(int i3) {
        this.f315972f = i3;
        this.C = 0;
        this.E = false;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f315974i) {
            super.onDraw(canvas);
            return;
        }
        int i3 = this.C;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        canvas.save();
                        canvas.translate(0.0f, 0.0f);
                        super.onDraw(canvas);
                        canvas.restore();
                    }
                } else {
                    super.onDraw(canvas);
                }
            } else {
                if (this.f315973h >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f315973h)) / this.f315970d;
                    if (uptimeMillis >= 1.0f) {
                        if (!this.D) {
                            this.D = true;
                            this.f315973h = SystemClock.uptimeMillis();
                        } else {
                            this.E = true;
                        }
                    } else {
                        float min = Math.min(uptimeMillis, 1.0f);
                        if (!this.D) {
                            this.f315971e = (int) (this.f315972f * this.f315975m.getInterpolation(min));
                        } else {
                            int i16 = this.f315972f;
                            this.f315971e = i16 - ((int) (i16 * this.f315975m.getInterpolation(min)));
                        }
                    }
                    if (this.E) {
                        this.C = 4;
                    }
                }
                canvas.save();
                canvas.translate(0.0f, this.f315971e);
                super.onDraw(canvas);
                canvas.restore();
                if (this.E) {
                    invalidate();
                }
            }
        } else {
            this.f315971e = 0;
            this.f315973h = SystemClock.uptimeMillis();
            this.C = 1;
            this.D = false;
            super.onDraw(canvas);
        }
        if (!this.E) {
            invalidate();
        }
    }

    public void setIsScroll(boolean z16) {
        this.f315974i = z16;
    }

    public void setScrollDuration(int i3) {
        this.f315970d = i3;
    }

    public ProfileCardScrollImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315970d = 1500;
        this.f315971e = 0;
        this.f315972f = 0;
        this.f315974i = false;
        this.C = 3;
        this.D = false;
        this.E = false;
        a();
    }

    public ProfileCardScrollImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315970d = 1500;
        this.f315971e = 0;
        this.f315972f = 0;
        this.f315974i = false;
        this.C = 3;
        this.D = false;
        this.E = false;
        a();
    }
}
