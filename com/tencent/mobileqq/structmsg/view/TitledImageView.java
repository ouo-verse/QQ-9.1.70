package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TitledImageView extends AnyScaleTypeImageView {
    static IPatchRedirector $redirector_;
    private CharSequence E;
    private TextPaint F;
    private int G;
    private int H;
    private int I;
    private int J;
    private Path K;
    private Layout L;
    private TransformationMethod M;

    public TitledImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = null;
        TextPaint textPaint = new TextPaint();
        this.F = textPaint;
        this.G = -16777216;
        this.H = -1;
        this.I = 10;
        this.J = 10;
        this.K = null;
        this.L = null;
        textPaint.setAntiAlias(true);
        this.M = SingleLineTransformationMethod.getInstance();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(this.E)) {
            this.F.setColor(this.G);
            this.F.setStyle(Paint.Style.FILL_AND_STROKE);
            float measuredHeight = (getMeasuredHeight() - this.F.getTextSize()) - (this.I * 2);
            canvas.save();
            canvas.clipRect(0.0f, measuredHeight, getMeasuredWidth(), getMeasuredHeight());
            Path path = this.K;
            if (path != null) {
                canvas.drawPath(path, this.F);
            }
            int i3 = this.I;
            canvas.translate(0.0f + i3, measuredHeight + i3);
            this.F.setColor(this.H);
            Layout layout = this.L;
            if (layout != null) {
                layout.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        if (measuredHeight >= 1 && measuredWidth >= 1 && z16) {
            this.K = new Path();
            float textSize = (measuredHeight - (this.I * 2)) - this.F.getTextSize();
            float f16 = measuredWidth;
            float f17 = measuredHeight;
            this.K.moveTo(0.0f, textSize);
            this.K.lineTo(f16, textSize);
            this.K.lineTo(f16, f17 - this.J);
            int i19 = this.J;
            this.K.arcTo(new RectF(f16 - (i19 * 2), f17 - (i19 * 2), f16, f17), 0.0f, 90.0f, false);
            this.K.lineTo(this.J + 0.0f, f17);
            int i26 = this.J;
            this.K.arcTo(new RectF(0.0f, f17 - (i26 * 2), (i26 * 2) + 0.0f, f17), 90.0f, 90.0f, true);
            this.K.lineTo(0.0f, textSize);
            this.K.close();
            CharSequence charSequence = this.E;
            if (charSequence != null) {
                this.L = new DynamicLayout(this.E, this.M.getTransformation(charSequence, this), this.F, (int) Layout.getDesiredWidth(this.E, this.F), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.5f, false, TextUtils.TruncateAt.END, (int) (f16 - (this.I * 2)));
            }
        }
    }

    public void setTextBackground(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    @Override // com.tencent.mobileqq.widget.URLTextImageView
    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }

    public void setTextPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.I = i3;
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.F.setTextSize(f16);
        }
    }

    public void setTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) charSequence);
        } else if (this.E instanceof QQText) {
            this.E = charSequence;
        } else {
            this.E = new QQText(charSequence, 1, 16);
        }
    }

    public void settextBgRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.J = i3;
        }
    }

    public TitledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = null;
        TextPaint textPaint = new TextPaint();
        this.F = textPaint;
        this.G = -16777216;
        this.H = -1;
        this.I = 10;
        this.J = 10;
        this.K = null;
        this.L = null;
        textPaint.setAntiAlias(true);
        this.M = SingleLineTransformationMethod.getInstance();
    }

    public TitledImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.E = null;
        TextPaint textPaint = new TextPaint();
        this.F = textPaint;
        this.G = -16777216;
        this.H = -1;
        this.I = 10;
        this.J = 10;
        this.K = null;
        this.L = null;
        textPaint.setAntiAlias(true);
        this.M = SingleLineTransformationMethod.getInstance();
    }
}
