package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RedDotRadioButton extends RadioButton {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f302394d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f302395e;

    /* renamed from: f, reason: collision with root package name */
    private float f302396f;

    /* renamed from: h, reason: collision with root package name */
    private int f302397h;

    public RedDotRadioButton(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f302395e && (drawable = this.f302394d) != null) {
            drawable.setState(getDrawableState());
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            float desiredWidth = Layout.getDesiredWidth(getText(), getPaint());
            float f16 = fontMetrics.descent - fontMetrics.ascent;
            int width = getWidth();
            int height = getHeight();
            int ceil = (int) Math.ceil(((width / 2) + (desiredWidth / 2.0f)) - (this.f302396f * 2.0f));
            int ceil2 = (int) Math.ceil((((height / 2) - (f16 / 2.0f)) - this.f302397h) + (this.f302396f * 4.0f));
            if (QLog.isColorLevel()) {
                QLog.i(RedDotRadioButton.class.getSimpleName(), 2, "reddot y:" + ceil2);
            }
            if (ceil2 < 0) {
                ceil2 = 0;
            }
            Drawable drawable2 = this.f302394d;
            int i3 = this.f302397h;
            drawable2.setBounds(ceil, ceil2, ceil + i3, i3 + ceil2);
            this.f302394d.draw(canvas);
        }
    }

    public RedDotRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302394d = null;
        this.f302395e = false;
        this.f302396f = getResources().getDisplayMetrics().density;
        this.f302397h = (int) ((r4 * 9.0f) + 0.5d);
    }

    public RedDotRadioButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302394d = null;
        this.f302395e = false;
        this.f302396f = getResources().getDisplayMetrics().density;
        this.f302397h = (int) ((r5 * 9.0f) + 0.5d);
    }
}
