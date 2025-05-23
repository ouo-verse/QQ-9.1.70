package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes24.dex */
public class TestPagerIndicator extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Paint f357074d;

    /* renamed from: e, reason: collision with root package name */
    private int f357075e;

    /* renamed from: f, reason: collision with root package name */
    private int f357076f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f357077h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f357078i;

    public TestPagerIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f357077h = new RectF();
        this.f357078i = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f357074d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f357075e = SupportMenu.CATEGORY_MASK;
        this.f357076f = -16711936;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        this.f357074d.setColor(this.f357075e);
        canvas.drawRect(this.f357077h, this.f357074d);
        this.f357074d.setColor(this.f357076f);
        canvas.drawRect(this.f357078i, this.f357074d);
    }

    public void setInnerRectColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f357076f = i3;
        }
    }

    public void setOutRectColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f357075e = i3;
        }
    }
}
