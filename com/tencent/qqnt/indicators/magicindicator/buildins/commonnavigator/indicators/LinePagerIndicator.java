package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.indicators.magicindicator.buildins.a;
import com.tencent.theme.SkinnableView;
import java.util.Collections;
import java.util.List;

/* loaded from: classes24.dex */
public class LinePagerIndicator extends View implements SkinnableView {
    static IPatchRedirector $redirector_;
    private float C;
    private float D;
    private Paint E;
    private List<Integer> F;
    private RectF G;

    /* renamed from: d, reason: collision with root package name */
    private int f357068d;

    /* renamed from: e, reason: collision with root package name */
    private Interpolator f357069e;

    /* renamed from: f, reason: collision with root package name */
    private Interpolator f357070f;

    /* renamed from: h, reason: collision with root package name */
    private float f357071h;

    /* renamed from: i, reason: collision with root package name */
    private float f357072i;

    /* renamed from: m, reason: collision with root package name */
    private float f357073m;

    public LinePagerIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f357069e = new LinearInterpolator();
        this.f357070f = new LinearInterpolator();
        this.G = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.E = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f357072i = a.a(context, 2.0d);
        this.C = a.a(context, 10.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        RectF rectF = this.G;
        float f16 = this.D;
        canvas.drawRoundRect(rectF, f16, f16, this.E);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        setColors(getResources().getColorStateList(R.color.qui_common_brand_standard, null));
        invalidate();
        QLog.d("HistoryPager", 1, "HistoryPager onThemeChanged invalidate");
    }

    public void setColors(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) colorStateList);
        } else {
            this.F = Collections.singletonList(Integer.valueOf(colorStateList.getDefaultColor()));
        }
    }

    public void setEndInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) interpolator);
            return;
        }
        this.f357070f = interpolator;
        if (interpolator == null) {
            this.f357070f = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        } else {
            this.f357072i = f16;
        }
    }

    public void setLineWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else {
            this.C = f16;
        }
    }

    public void setMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        if (i3 != 2 && i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("mode " + i3 + " not supported.");
        }
        this.f357068d = i3;
    }

    public void setRoundRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.D = f16;
        }
    }

    public void setStartInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) interpolator);
            return;
        }
        this.f357069e = interpolator;
        if (interpolator == null) {
            this.f357069e = new LinearInterpolator();
        }
    }

    public void setXOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.f357073m = f16;
        }
    }

    public void setYOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.f357071h = f16;
        }
    }
}
