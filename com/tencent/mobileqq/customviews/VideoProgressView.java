package com.tencent.mobileqq.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.bs;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.RefreshProgressRunnable;

/* loaded from: classes10.dex */
public class VideoProgressView extends MessageProgressView {
    static IPatchRedirector $redirector_;
    private float L0;
    private boolean M0;

    public VideoProgressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.L0 = 0.0f;
            this.M0 = true;
        }
    }

    @Override // com.tencent.mobileqq.widget.MessageProgressView, android.view.View
    @TargetApi(11)
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        int i3 = this.f315822e;
        if (i3 == 1) {
            r();
            d(canvas);
            if (s()) {
                f(canvas, this.L0);
            } else {
                e(canvas);
            }
            String str = this.f315827h;
            if (str != null) {
                i(canvas, str);
            } else {
                h(canvas);
            }
            c(canvas);
            m(canvas);
            return;
        }
        if (i3 == 2) {
            r();
            k(canvas);
        } else if (i3 == 3) {
            r();
            j(canvas, this.D0);
        }
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.M0;
    }

    public void setVideoCompressPercent(String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Float.valueOf(f16));
            return;
        }
        if (f16 >= 0.0f && f16 <= 1.0f) {
            this.L0 = f16;
            if (f16 < 1.0f) {
                z16 = true;
            }
            this.M0 = z16;
        }
        if (this.f315822e == 1) {
            RefreshProgressRunnable b16 = bs.c().b(str);
            if (b16 == null) {
                RefreshProgressRunnable refreshProgressRunnable = new RefreshProgressRunnable(this, str, this.f315824f);
                bs.c().a(str, refreshProgressRunnable);
                ViewCompat.postOnAnimation(this, refreshProgressRunnable);
                return;
            }
            b16.a(this, this.f315824f);
        }
    }

    public void setVideoCompressStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.M0 = z16;
        }
    }

    public VideoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.L0 = 0.0f;
            this.M0 = true;
        }
    }

    public VideoProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.L0 = 0.0f;
            this.M0 = true;
        }
    }
}
