package com.tencent.could.huiyansdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommonAuthBackView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f100336a;

    /* renamed from: b, reason: collision with root package name */
    public Point f100337b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f100338c;

    public CommonAuthBackView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f100337b = new Point();
        this.f100338c = new Paint();
        this.f100338c.setPathEffect(new DashPathEffect(new float[]{CommonUtils.dpToPx(this, 1.5f), CommonUtils.dpToPx(this, 25.0f)}, CommonUtils.dpToPx(this, 0.0f)));
        this.f100338c.setColor(getResources().getColor(R.color.cwr));
        this.f100338c.setStyle(Paint.Style.STROKE);
        this.f100338c.setStrokeWidth(CommonUtils.dpToPx(this, 6.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        Point point = this.f100337b;
        canvas.drawCircle(point.x, point.y, this.f100336a, this.f100338c);
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        Point point = this.f100337b;
        int i17 = size >> 1;
        point.x = i17;
        int i18 = size2 >> 1;
        point.y = i18;
        if (i17 > i18) {
            i17 = i18;
        }
        this.f100336a = i17;
        this.f100336a = i17 - CommonUtils.dpToPx(this, 5.0f);
        setMeasuredDimension(size, size2);
    }

    public CommonAuthBackView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CommonAuthBackView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
