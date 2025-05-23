package com.tencent.mobileqq.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class UnderlineTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Rect f292662d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f292663e;

    /* renamed from: f, reason: collision with root package name */
    private float f292664f;

    public UnderlineTextView(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(Context context, AttributeSet attributeSet, int i3) {
        float f16 = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.A6, i3, 0);
        int color = obtainStyledAttributes.getColor(jj2.b.B6, SupportMenu.CATEGORY_MASK);
        this.f292664f = obtainStyledAttributes.getDimension(jj2.b.C6, f16 * 2.0f);
        obtainStyledAttributes.recycle();
        this.f292662d = new Rect();
        Paint paint = new Paint();
        this.f292663e = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f292663e.setColor(color);
        this.f292663e.setStrokeWidth(this.f292664f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i3 = 0; i3 < lineCount; i3++) {
            try {
                int lineBounds = getLineBounds(i3, this.f292662d);
                int lineStart = layout.getLineStart(i3);
                int lineEnd = layout.getLineEnd(i3);
                float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
                float f16 = lineBounds;
                canvas.drawLine(primaryHorizontal + getPaddingLeft(), this.f292664f + f16 + 15.0f, layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal) + getPaddingLeft(), f16 + this.f292664f + 15.0f, this.f292663e);
            } catch (Exception e16) {
                QLog.e("UnderlineTextView", 1, "" + e16);
                return;
            }
        }
    }

    public void setUnderLineColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f292663e.setColor(i3);
            invalidate();
        }
    }

    public void setUnderlineWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.f292664f = f16;
            invalidate();
        }
    }

    public UnderlineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public UnderlineTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a(context, attributeSet, i3);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
