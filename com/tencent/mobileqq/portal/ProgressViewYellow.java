package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.preload.s;
import com.tencent.mobileqq.utils.ViewUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProgressViewYellow extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private long f259332d;

    /* renamed from: e, reason: collision with root package name */
    private long f259333e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f259334f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f259335h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f259336i;

    public ProgressViewYellow(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f259332d = 10000L;
        this.f259333e = 0L;
        this.f259336i = null;
        a();
    }

    private void a() {
        this.f259334f = new Rect();
        this.f259335h = new RectF();
        try {
            this.f259336i = s.a("spring_shua_progress_bg_frame.png").h(null, -1, ViewUtils.dpToPx(275.0f), ViewUtils.dpToPx(23.0f));
        } catch (OutOfMemoryError e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(601, e16, new String[0]);
            }
        }
    }

    public void b(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.f259332d = j16;
        this.f259333e = j16 - j3;
        postInvalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        long j3 = this.f259333e;
        if (j3 < this.f259332d && j3 >= 0 && (bitmap = this.f259336i) != null) {
            this.f259334f.set(0, 0, (int) ((bitmap.getWidth() * this.f259333e) / this.f259332d), this.f259336i.getHeight());
            this.f259335h.set(0.0f, 0.0f, (int) ((width * this.f259333e) / this.f259332d), height);
            canvas.drawBitmap(this.f259336i, this.f259334f, this.f259335h, (Paint) null);
        }
    }

    public ProgressViewYellow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f259332d = 10000L;
        this.f259333e = 0L;
        this.f259336i = null;
        a();
    }

    public ProgressViewYellow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f259332d = 10000L;
        this.f259333e = 0L;
        this.f259336i = null;
        a();
    }
}
