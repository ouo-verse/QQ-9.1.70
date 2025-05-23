package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProgressViewRed extends TimeDownTextView {
    static IPatchRedirector $redirector_;
    private Drawable P;
    private Drawable Q;
    private int R;
    private long S;
    private long T;

    public ProgressViewRed(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.S = 10000L;
        this.T = 0L;
        a();
    }

    private void a() {
        this.f259353d.setColor(-1);
        this.Q = new ColorDrawable(Color.parseColor("#FFD049"));
        this.P = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#FFD049"), Color.parseColor("#FE6A32")});
    }

    public void b(long j3, long j16, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), charSequence);
            return;
        }
        this.S = j16;
        this.T = j16 - j3;
        setText(charSequence);
    }

    @Override // com.tencent.mobileqq.portal.TimeDownTextView, android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        if (this.R == 0) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.Q.setBounds(0, 0, width, height);
        this.Q.draw(canvas);
        long j3 = this.T;
        int i3 = (int) ((width * j3) / this.S);
        if (j3 > 0) {
            this.P.setBounds(0, 0, i3, height);
            this.P.draw(canvas);
        }
        super.draw(canvas);
    }

    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.Q.setAlpha(i3);
        this.P.setAlpha(i3);
        setTextColor(Color.argb(i3, 255, 255, 255));
        this.R = i3;
    }

    public void setDrawables(Drawable drawable, Drawable drawable2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, (Object) drawable2);
        } else if (drawable != null && drawable2 != null) {
            this.P = drawable;
            this.Q = drawable2;
        }
    }

    public ProgressViewRed(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.S = 10000L;
        this.T = 0L;
        a();
    }
}
