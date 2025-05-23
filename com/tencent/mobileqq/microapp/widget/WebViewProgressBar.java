package com.tencent.mobileqq.microapp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.microapp.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class WebViewProgressBar extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f246097a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f246098b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f246099c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.microapp.a.c f246100d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f246101e;

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        com.tencent.mobileqq.microapp.a.c cVar = this.f246100d;
        if (cVar != null && cVar.i() != 6) {
            if (this.f246101e != null && this.f246097a != null) {
                int j3 = (int) this.f246100d.j();
                if (j3 < this.f246097a.getIntrinsicWidth()) {
                    i18 = j3 - this.f246097a.getIntrinsicWidth();
                    i17 = this.f246097a.getIntrinsicWidth();
                } else {
                    i17 = j3;
                    i18 = 0;
                }
                int i19 = i17 + i18;
                if (i19 > 0) {
                    this.f246101e.setBounds(0, 0, getWidth(), getHeight());
                    this.f246101e.draw(canvas);
                    Drawable drawable = this.f246098b;
                    if (drawable != null) {
                        drawable.setBounds(0, 0, getWidth(), getHeight());
                        this.f246098b.draw(canvas);
                    }
                }
                this.f246097a.setBounds(i18, 0, i19, getHeight());
                this.f246097a.draw(canvas);
                return;
            }
            if (this.f246098b == null) {
                this.f246098b = getContext().getResources().getDrawable(R.drawable.e);
            }
            this.f246098b.setBounds(0, 0, getWidth(), getHeight());
            this.f246098b.draw(canvas);
            if (this.f246097a == null) {
                this.f246097a = getContext().getResources().getDrawable(R.drawable.f);
            }
            int j16 = (int) this.f246100d.j();
            if (this.f246099c) {
                this.f246097a.setAlpha(this.f246100d.k());
            }
            if (j16 < this.f246097a.getIntrinsicWidth()) {
                i16 = j16 - this.f246097a.getIntrinsicWidth();
                i3 = this.f246097a.getIntrinsicWidth();
            } else {
                i3 = j16;
                i16 = 0;
            }
            this.f246097a.setBounds(i16, 0, i3 + i16, getHeight());
            this.f246097a.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f246100d != null) {
            getWidth();
        }
    }
}
