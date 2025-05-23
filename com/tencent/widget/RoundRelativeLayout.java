package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.av.utils.api.IUIToolsTempApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RoundRelativeLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private float f384661d;

    /* renamed from: e, reason: collision with root package name */
    private Path f384662e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f384663f;

    public RoundRelativeLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f384661d = 16.0f;
            b(context, null);
        }
    }

    private void c() {
        Path path = this.f384662e;
        RectF rectF = this.f384663f;
        float f16 = this.f384661d;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        QLog.i(com.tencent.state.view.RoundRelativeLayout.TAG, 2, "roundLayoutRadius " + this.f384661d);
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.f384661d = ((IUIToolsTempApi) QRoute.api(IUIToolsTempApi.class)).dp2px(getContext(), i3);
        setWillNotDraw(false);
        this.f384662e = new Path();
        this.f384663f = new RectF();
    }

    public void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384661d = ((IUIToolsTempApi) QRoute.api(IUIToolsTempApi.class)).dp2px(getContext(), 16.0f);
        setWillNotDraw(false);
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.round_rect_corner_image)) != null) {
            this.f384661d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.round_rect_corner_image_round_rect_radius, 0);
            obtainStyledAttributes.recycle();
        }
        this.f384662e = new Path();
        this.f384663f = new RectF();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (this.f384661d > 0.0f && this.f384662e != null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f384662e);
        }
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        RectF rectF = this.f384663f;
        if (rectF == null) {
            return;
        }
        rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        c();
    }

    public void setRoundLayoutRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        this.f384661d = f16;
        c();
        postInvalidate();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f384661d = 16.0f;
            b(context, attributeSet);
        }
    }
}
