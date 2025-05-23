package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TriangleView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final int f181248f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f181249h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f181250i;

    /* renamed from: d, reason: collision with root package name */
    private int f181251d;

    /* renamed from: e, reason: collision with root package name */
    private int f181252e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f181248f = ViewUtils.dip2px(7.0f);
        f181249h = ViewUtils.dip2px(2.0f);
        f181250i = ViewUtils.dip2px(2.0f);
    }

    public TriangleView(Context context) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        canvas.drawColor(0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.f181252e);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.f181251d == 0) {
            path.moveTo(measuredWidth / 2, 0.0f);
            int i3 = f181248f;
            float f16 = measuredHeight;
            path.lineTo(r2 - i3, f16);
            path.lineTo(r2 + i3, f16);
        } else {
            float f17 = measuredWidth / 2;
            path.moveTo(f17, 0.0f);
            int i16 = f181248f;
            path.lineTo(r2 - i16, 0.0f);
            int i17 = f181249h;
            int i18 = f181250i;
            path.lineTo(r2 - i17, measuredHeight - i18);
            path.quadTo(f17, measuredHeight, i17 + r2, measuredHeight - i18);
            path.lineTo(r2 + i16, 0.0f);
        }
        path.close();
        canvas.drawPath(path, paint);
    }

    public void setDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f181251d = i3;
        }
    }

    public void setDrawColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f181252e = i3;
        }
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f181251d = 1;
            this.f181252e = Color.parseColor("#00CAFC");
        }
    }
}
