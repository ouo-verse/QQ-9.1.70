package com.tencent.mobileqq.filemanageraux.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TriangleView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    Paint f209698d;

    /* renamed from: e, reason: collision with root package name */
    Path f209699e;

    /* renamed from: f, reason: collision with root package name */
    Paint f209700f;

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        Paint paint = new Paint();
        this.f209698d = paint;
        paint.setColor(-1);
        this.f209699e = new Path();
        Paint paint2 = new Paint();
        this.f209700f = paint2;
        paint2.setColor(-2170912);
        this.f209700f.setStrokeWidth(2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int i3 = (measuredHeight * 2) + 150;
        float f16 = measuredHeight + 150;
        this.f209699e.moveTo(f16, 0.0f);
        float f17 = 150;
        float f18 = measuredHeight;
        this.f209699e.lineTo(f17, f18);
        float f19 = i3;
        this.f209699e.lineTo(f19, f18);
        this.f209699e.close();
        canvas.drawPath(this.f209699e, this.f209698d);
        this.f209700f.setStrokeWidth(1.0f);
        canvas.drawLine(f16, 0.0f, f17, f18, this.f209700f);
        canvas.drawLine(f16, 0.0f, f19, f18, this.f209700f);
        this.f209700f.setStrokeWidth(2.0f);
        canvas.drawLine(0.0f, f18, f17, f18, this.f209700f);
        canvas.drawLine(f19, f18, getMeasuredWidth(), f18, this.f209700f);
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f209698d.setColor(i3);
        }
    }
}
