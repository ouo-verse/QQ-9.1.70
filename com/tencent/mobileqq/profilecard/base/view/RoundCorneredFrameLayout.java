package com.tencent.mobileqq.profilecard.base.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RoundCorneredFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;
    public int radius;

    @TargetApi(11)
    public RoundCorneredFrameLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.radius = 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        Path path = new Path();
        path.moveTo(0.0f, this.radius);
        int i3 = this.radius;
        path.arcTo(new RectF(0.0f, 0.0f, i3 * 2, i3 * 2), -180.0f, 90.0f);
        path.lineTo(width - this.radius, 0.0f);
        int i16 = this.radius;
        float f16 = width;
        path.arcTo(new RectF(width - (i16 * 2), 0.0f, f16, i16 * 2), -90.0f, 90.0f);
        path.lineTo(f16, height - this.radius);
        int i17 = this.radius;
        float f17 = height;
        path.arcTo(new RectF(width - (i17 * 2), height - (i17 * 2), f16, f17), 0.0f, 90.0f);
        path.lineTo(this.radius, f17);
        int i18 = this.radius;
        path.arcTo(new RectF(0.0f, height - (i18 * 2), i18 * 2, f17), 90.0f, 90.0f);
        path.lineTo(0.0f, this.radius);
        path.close();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
    }

    @TargetApi(11)
    public RoundCorneredFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.radius = 0;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
