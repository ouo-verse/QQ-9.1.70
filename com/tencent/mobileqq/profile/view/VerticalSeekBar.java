package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class VerticalSeekBar extends View {
    static IPatchRedirector $redirector_;
    float C;
    boolean D;
    int E;
    int F;
    SeekBar.OnSeekBarChangeListener G;
    long H;

    /* renamed from: d, reason: collision with root package name */
    Paint f260489d;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f260490e;

    /* renamed from: f, reason: collision with root package name */
    int f260491f;

    /* renamed from: h, reason: collision with root package name */
    Rect f260492h;

    /* renamed from: i, reason: collision with root package name */
    int f260493i;

    /* renamed from: m, reason: collision with root package name */
    int f260494m;

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.E = 100;
        this.F = 0;
        a();
    }

    void a() {
        Resources resources = super.getResources();
        Paint paint = new Paint();
        this.f260489d = paint;
        paint.setAntiAlias(true);
        this.f260489d.setColor(-1);
        this.f260489d.setStrokeWidth(2.0f);
        this.f260489d.setStyle(Paint.Style.STROKE);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 320;
        options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        try {
            this.f260490e = BitmapFactory.decodeResource(resources, R.drawable.fsu, options);
        } catch (OutOfMemoryError unused) {
            QLog.e("VerticalSeekBar", 1, "thumb picture decode failed");
        }
        this.f260492h = new Rect();
        this.f260493i = x.c(getContext(), 5.0f);
        this.f260494m = x.c(getContext(), 30.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.f260491f <= 0) {
            this.f260491f = (int) (((measuredHeight - this.f260490e.getHeight()) / this.E) * this.F);
        }
        float f18 = measuredWidth / 2;
        int height = this.f260491f + this.f260490e.getHeight();
        int i3 = this.f260493i;
        float f19 = height + i3;
        int i16 = this.f260491f;
        if (i16 < i3) {
            f16 = 0.0f;
        } else {
            f16 = i16 - i3;
        }
        canvas.drawLine(f18, 0.0f, f18, f16, this.f260489d);
        int width = (measuredWidth - this.f260490e.getWidth()) / 2;
        this.f260492h.set(width, this.f260491f, this.f260490e.getWidth() + width, this.f260491f + this.f260490e.getHeight());
        canvas.drawBitmap(this.f260490e, (Rect) null, this.f260492h, this.f260489d);
        float f26 = measuredHeight;
        if (f19 > f26) {
            f17 = f26;
        } else {
            f17 = f19;
        }
        canvas.drawLine(f18, f17, f18, f26, this.f260489d);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth < this.f260490e.getWidth()) {
            measuredWidth = this.f260490e.getWidth();
        }
        if (measuredHeight < this.f260490e.getHeight()) {
            measuredHeight = this.f260490e.getHeight();
        }
        int i17 = this.f260494m;
        if (measuredWidth < i17) {
            measuredWidth = i17;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            float f16 = 0.0f;
            if (action != 1) {
                if (action == 2 && this.D) {
                    float y16 = motionEvent.getY() - this.C;
                    float measuredHeight = getMeasuredHeight() - this.f260490e.getHeight();
                    int i3 = this.f260491f;
                    if (i3 + y16 <= measuredHeight && i3 + y16 >= 0.0f) {
                        int i16 = (int) (i3 + y16);
                        this.f260491f = i16;
                        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = this.G;
                        if (onSeekBarChangeListener2 != null) {
                            int i17 = (int) ((i16 / measuredHeight) * this.E);
                            this.F = i17;
                            onSeekBarChangeListener2.onProgressChanged(null, i17, false);
                        }
                    }
                    this.C = motionEvent.getY();
                    invalidate();
                }
            } else {
                if (this.D && (onSeekBarChangeListener = this.G) != null) {
                    onSeekBarChangeListener.onStopTrackingTouch(null);
                }
                this.D = false;
                if (System.currentTimeMillis() - this.H < 100) {
                    float measuredHeight2 = getMeasuredHeight() - this.f260490e.getHeight();
                    float y17 = motionEvent.getY() - (this.f260490e.getHeight() / 2);
                    if (y17 > measuredHeight2) {
                        y17 = measuredHeight2;
                    }
                    if (y17 >= 0.0f) {
                        f16 = y17;
                    }
                    int i18 = (int) f16;
                    this.f260491f = i18;
                    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener3 = this.G;
                    if (onSeekBarChangeListener3 != null) {
                        int i19 = (int) ((i18 / measuredHeight2) * this.E);
                        this.F = i19;
                        onSeekBarChangeListener3.onProgressChanged(null, i19, false);
                    }
                    invalidate();
                }
            }
        } else {
            float y18 = motionEvent.getY();
            this.C = y18;
            int i26 = this.f260491f;
            if (y18 > i26 - this.f260493i && y18 < i26 + this.f260490e.getHeight() + this.f260493i) {
                this.D = true;
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener4 = this.G;
                if (onSeekBarChangeListener4 != null) {
                    onSeekBarChangeListener4.onStartTrackingTouch(null);
                }
            }
            this.H = System.currentTimeMillis();
        }
        return true;
    }

    public void setMaxProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onSeekBarChangeListener);
        } else {
            this.G = onSeekBarChangeListener;
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (i3 >= 0 && i3 <= this.E) {
            this.F = i3;
            if (getMeasuredHeight() >= 0) {
                this.f260491f = (int) (((getMeasuredHeight() - this.f260490e.getHeight()) / this.E) * this.F);
            }
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.G;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(null, i3, true);
            }
        }
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = 100;
        this.F = 0;
        a();
    }

    public VerticalSeekBar(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.E = 100;
        this.F = 0;
        a();
    }
}
