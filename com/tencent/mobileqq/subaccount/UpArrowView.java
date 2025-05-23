package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.x;
import com.tencent.theme.SkinnableView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class UpArrowView extends View implements SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    Paint f291052d;

    /* renamed from: e, reason: collision with root package name */
    int f291053e;

    /* renamed from: f, reason: collision with root package name */
    int f291054f;

    /* renamed from: h, reason: collision with root package name */
    int f291055h;

    public UpArrowView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f291052d = new Paint();
            a();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f291053e = Color.argb(255, 255, 255, 255);
        setDuplicateParentStateEnabled(true);
        this.f291054f = getResources().getColor(R.color.qui_common_border_light);
        int color = getResources().getColor(R.color.qui_common_fill_light_primary);
        if (this.f291053e != color) {
            this.f291053e = color;
            this.f291055h = Color.argb(Color.alpha(color) / 2, Color.red(color), Color.green(color), Color.blue(color));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (!isSelected() && !isPressed()) {
            this.f291052d.setColor(this.f291053e);
        } else {
            this.f291052d.setColor(this.f291055h);
        }
        this.f291052d.setAntiAlias(true);
        this.f291052d.setStyle(Paint.Style.FILL);
        int width = getWidth();
        int height = getHeight();
        Path path = new Path();
        float f16 = height;
        path.moveTo(0.0f, f16);
        path.lineTo(width / 2, 0.0f);
        float f17 = width;
        path.lineTo(f17, f16);
        path.close();
        canvas.drawPath(path, this.f291052d);
        this.f291052d.setStyle(Paint.Style.STROKE);
        this.f291052d.setStrokeWidth(x.a(2.0f));
        this.f291052d.setColor(this.f291054f);
        float f18 = f17 / 2.0f;
        canvas.drawLine(0.0f, f16, f18, 0.0f, this.f291052d);
        canvas.drawLine(f18, 0.0f, f17, f16, this.f291052d);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f291054f = getResources().getColor(R.color.qui_common_border_light);
        int color = getResources().getColor(R.color.qui_common_fill_light_primary);
        if (this.f291053e != color) {
            this.f291053e = color;
            this.f291055h = Color.argb(Color.alpha(color) / 2, Color.red(color), Color.green(color), Color.blue(color));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            super.setPressed(z16);
            invalidate();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            super.setSelected(z16);
            invalidate();
        }
    }

    public UpArrowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f291052d = new Paint();
            a();
        }
    }

    public UpArrowView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f291052d = new Paint();
            a();
        }
    }
}
