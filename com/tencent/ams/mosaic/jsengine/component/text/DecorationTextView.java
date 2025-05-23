package com.tencent.ams.mosaic.jsengine.component.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class DecorationTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f71303d;

    /* renamed from: e, reason: collision with root package name */
    private int f71304e;

    /* renamed from: f, reason: collision with root package name */
    private float f71305f;

    /* renamed from: h, reason: collision with root package name */
    private float f71306h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f71307i;

    /* renamed from: m, reason: collision with root package name */
    private int f71308m;

    public DecorationTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            b(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private int a(Layout layout) {
        if (layout == null || layout.getLineCount() == 0) {
            return 0;
        }
        int lineBottom = layout.getLineBottom(layout.getLineCount() - 1) - layout.getLineTop(0);
        if (!c(80)) {
            return 0;
        }
        return getHeight() - lineBottom;
    }

    private void b(Context context) {
        Paint paint = new Paint();
        this.f71307i = paint;
        paint.setStrokeWidth(MosaicUtils.j(1.0f));
        this.f71307i.setColor(getTextColors().getDefaultColor());
        Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
        this.f71308m = Math.abs((fontMetricsInt.bottom - fontMetricsInt.ascent) - getLineHeight()) - (fontMetricsInt.bottom - fontMetricsInt.descent);
    }

    private boolean c(int i3) {
        if ((getGravity() & i3) == i3) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        try {
            super.onDraw(canvas);
            if (!TextUtils.isEmpty(getText()) && !TextUtils.isEmpty(this.f71303d)) {
                if (this.f71303d.equals("underline") || this.f71303d.equals(TextComponent.DecorationType.STRIKETHROUGH)) {
                    int lineCount = getLineCount();
                    Layout layout = getLayout();
                    int paddingTop = getPaddingTop();
                    int paddingLeft = getPaddingLeft();
                    int a16 = a(layout);
                    for (int i3 = 0; i3 < lineCount; i3++) {
                        float f16 = paddingLeft;
                        float lineLeft = layout.getLineLeft(i3) + f16;
                        float lineRight = layout.getLineRight(i3) + f16;
                        int lineBottom = ((layout.getLineBottom(i3) + a16) + paddingTop) - this.f71308m;
                        if (TextComponent.DecorationType.STRIKETHROUGH.equals(this.f71303d)) {
                            lineBottom -= layout.getLineBottom(i3) / 2;
                        }
                        float j3 = (int) (lineBottom + MosaicUtils.j(this.f71306h));
                        canvas.drawLine(lineLeft, j3, lineRight, j3, this.f71307i);
                    }
                }
            }
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("DecorationTextView", "text view draw error.", th5);
        }
    }

    public void setDecorationColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.f71304e = i3;
        this.f71307i.setColor(i3);
        invalidate();
    }

    public void setDecorationType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f71303d = str;
            invalidate();
        }
    }

    public void setDecorationWeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        float j3 = MosaicUtils.j(f16);
        this.f71305f = j3;
        this.f71307i.setStrokeWidth(j3);
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        super.setTextColor(i3);
        if (this.f71304e == 0) {
            this.f71307i.setColor(i3);
        }
        invalidate();
    }

    public void setTextDecorationPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.f71306h = MosaicUtils.j(f16);
        }
    }

    public DecorationTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            b(context);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public DecorationTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
