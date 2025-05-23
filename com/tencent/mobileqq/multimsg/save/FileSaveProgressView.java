package com.tencent.mobileqq.multimsg.save;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes15.dex */
public class FileSaveProgressView extends TextView {
    static IPatchRedirector $redirector_;
    private String C;
    private StringBuffer D;

    /* renamed from: d, reason: collision with root package name */
    private Paint f251655d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f251656e;

    /* renamed from: f, reason: collision with root package name */
    private int f251657f;

    /* renamed from: h, reason: collision with root package name */
    private int f251658h;

    /* renamed from: i, reason: collision with root package name */
    private int f251659i;

    /* renamed from: m, reason: collision with root package name */
    private int f251660m;

    public FileSaveProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f251656e = new RectF();
        this.f251657f = 0;
        this.f251658h = -1;
        this.f251659i = -16725252;
        this.f251660m = 5;
        this.C = "0%";
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint();
        this.f251655d = paint;
        paint.setAntiAlias(true);
        setText(this.C);
        this.D = new StringBuffer(this.C);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int saveCount = canvas.getSaveCount();
        canvas.save();
        int i3 = this.f251658h;
        if (i3 > 0) {
            f16 = i3;
        } else {
            f16 = 2.5f;
        }
        this.f251656e.set(f16, f16, width - f16, height - f16);
        this.f251655d.setStyle(Paint.Style.STROKE);
        this.f251655d.setStrokeWidth(this.f251660m);
        this.f251655d.setColor(this.f251659i);
        canvas.drawArc(this.f251656e, 270.0f, (this.f251657f * 360) / 100, false, this.f251655d);
        canvas.restoreToCount(saveCount);
        super.onDraw(canvas);
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 < 0) {
            this.f251657f = 0;
            return;
        }
        if (i3 > 100) {
            this.f251657f = 100;
            return;
        }
        if (i3 < this.f251657f) {
            if (QLog.isColorLevel()) {
                QLog.d("FileSaveProgressView", 2, "progress < currentProgress, so return;");
                return;
            }
            return;
        }
        this.f251657f = i3;
        StringBuffer stringBuffer = this.D;
        stringBuffer.delete(0, stringBuffer.length());
        StringBuffer stringBuffer2 = this.D;
        stringBuffer2.append(i3);
        stringBuffer2.append("%");
        String stringBuffer3 = stringBuffer2.toString();
        this.C = stringBuffer3;
        setText(stringBuffer3);
        invalidate();
    }

    public void setRingColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f251659i = i3;
        }
    }

    public void setRingWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f251660m = i3;
        }
    }

    public void setStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f251658h = i3;
        }
    }

    public FileSaveProgressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.f251656e = new RectF();
        this.f251657f = 0;
        this.f251658h = -1;
        this.f251659i = -16725252;
        this.f251660m = 5;
        this.C = "0%";
        a(context);
    }
}
