package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FocusIndicatorView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final ScaleAnimation f368792a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f368793b;

    /* renamed from: c, reason: collision with root package name */
    private final int f368794c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f368795d;

    public FocusIndicatorView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        int i3 = this.f368794c / 2;
        Rect rect = this.f368795d;
        rect.left = i3;
        rect.top = i3;
        rect.right = getWidth() - i3;
        this.f368795d.bottom = getHeight() - i3;
        canvas.drawRect(this.f368795d, this.f368793b);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f368795d = new Rect();
        int i16 = (int) ((getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        this.f368794c = i16;
        Paint paint = new Paint();
        this.f368793b = paint;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(i16);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.f368792a = scaleAnimation;
        scaleAnimation.setDuration(200L);
    }
}
