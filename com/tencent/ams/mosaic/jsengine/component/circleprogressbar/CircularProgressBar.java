package com.tencent.ams.mosaic.jsengine.component.circleprogressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class CircularProgressBar extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Paint f70976d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f70977e;

    /* renamed from: f, reason: collision with root package name */
    private float f70978f;

    /* renamed from: h, reason: collision with root package name */
    private float f70979h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f70980i;

    public CircularProgressBar(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f70978f = 0.0f;
            a();
        }
    }

    private void a() {
        this.f70979h = MosaicUtils.j(4.0f);
        Paint paint = new Paint();
        this.f70976d = paint;
        paint.setAntiAlias(true);
        this.f70976d.setStyle(Paint.Style.STROKE);
        this.f70976d.setStrokeWidth(this.f70979h);
        this.f70976d.setColor(-7829368);
        this.f70976d.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f70977e = paint2;
        paint2.setAntiAlias(true);
        this.f70977e.setStyle(Paint.Style.STROKE);
        this.f70977e.setStrokeWidth(this.f70979h);
        this.f70977e.setColor(-1);
        this.f70977e.setStrokeCap(Paint.Cap.ROUND);
        this.f70980i = new RectF();
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        float f16 = this.f70979h;
        this.f70980i.set(paddingLeft + (f16 / 2.0f), paddingTop + (f16 / 2.0f), (width - paddingRight) - (f16 / 2.0f), (height - paddingBottom) - (f16 / 2.0f));
        canvas.drawArc(this.f70980i, 0.0f, 360.0f, false, this.f70976d);
        canvas.drawArc(this.f70980i, -90.0f, this.f70978f * 360.0f, false, this.f70977e);
    }

    public void setBarBackground(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f70976d.setColor(i3);
        }
    }

    public void setBarForeground(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f70977e.setColor(i3);
        }
    }

    public void setBarWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        this.f70979h = f16;
        this.f70976d.setStrokeWidth(f16);
        this.f70977e.setStrokeWidth(f16);
    }

    public void setProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.f70978f = f16;
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.circleprogressbar.a
                @Override // java.lang.Runnable
                public final void run() {
                    CircularProgressBar.this.invalidate();
                }
            });
        }
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f70978f = 0.0f;
            a();
        }
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f70978f = 0.0f;
            a();
        }
    }
}
