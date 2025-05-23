package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BorderURLImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected int f302285d;

    /* renamed from: e, reason: collision with root package name */
    protected int f302286e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f302287f;

    /* renamed from: h, reason: collision with root package name */
    protected Rect f302288h;

    public BorderURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302286e = -1;
        this.f302287f = new Paint();
        this.f302288h = new Rect();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f302285d <= 0) {
            return;
        }
        canvas.getClipBounds(this.f302288h);
        this.f302287f.setColor(this.f302286e);
        this.f302287f.setStyle(Paint.Style.STROKE);
        this.f302287f.setStrokeWidth(this.f302285d);
        canvas.drawRect(this.f302288h, this.f302287f);
    }

    public void setBorderColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f302286e = i3;
        }
    }

    public void setBorderWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f302285d = i3;
        }
    }

    public BorderURLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302286e = -1;
        this.f302287f = new Paint();
        this.f302288h = new Rect();
    }

    public BorderURLImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f302286e = -1;
        this.f302287f = new Paint();
        this.f302288h = new Rect();
    }
}
