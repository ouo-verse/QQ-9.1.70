package com.tencent.qqnt.aio.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MutliSeletedBottomLine extends View {
    static IPatchRedirector $redirector_;
    private boolean C;
    private int D;
    private Paint E;

    /* renamed from: d, reason: collision with root package name */
    private final float f352434d;

    /* renamed from: e, reason: collision with root package name */
    private final float f352435e;

    /* renamed from: f, reason: collision with root package name */
    private final float f352436f;

    /* renamed from: h, reason: collision with root package name */
    private final float f352437h;

    /* renamed from: i, reason: collision with root package name */
    private float f352438i;

    /* renamed from: m, reason: collision with root package name */
    private float f352439m;

    public MutliSeletedBottomLine(Context context, int i3, boolean z16) {
        this(context, i3, x.c(context, 29.0f), z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Boolean.valueOf(z16));
    }

    @Override // android.view.View
    @SuppressLint({"ResourceAsColor"})
    protected void onDraw(Canvas canvas) {
        float f16;
        double d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (com.tencent.qqnt.aio.utils.multiForward.a.f352306a.b()) {
            this.E.setColor(getContext().getColor(R.color.qui_common_brand_standard));
        } else {
            this.E.setColor(getContext().getColor(R.color.alu));
        }
        this.E.setAntiAlias(true);
        if (!this.C) {
            f16 = 0.2f;
        } else {
            f16 = 1.0f;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.D) {
                if (!this.C) {
                    d16 = f16 + ((i3 / r2) * 0.8d);
                } else {
                    d16 = f16 - ((i3 / r2) * 0.8d);
                }
                this.E.setAlpha((int) (((float) d16) * 255.0f));
                canvas.drawCircle((i3 * 8.0f) + 2.0f, this.f352439m / 2.0f, 2.0f, this.E);
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            setMeasuredDimension((int) this.f352438i, getMeasuredHeight());
        }
    }

    public MutliSeletedBottomLine(Context context, int i3, int i16, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.f352434d = 0.2f;
        this.f352435e = 1.0f;
        this.f352436f = 2.0f;
        this.f352437h = 6.0f;
        this.f352438i = 0.0f;
        this.f352439m = 29.0f;
        this.C = false;
        this.E = new Paint();
        float f16 = i3;
        this.f352438i = f16;
        this.f352439m = i16;
        this.C = z16;
        this.D = (int) (f16 / 8.0f);
    }
}
