package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThemeTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static String f384698f;

    /* renamed from: d, reason: collision with root package name */
    Paint f384699d;

    /* renamed from: e, reason: collision with root package name */
    boolean f384700e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f384698f = "1000";
        }
    }

    public ThemeTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f384700e = true;
            a();
        }
    }

    private void a() {
        Paint paint = new Paint();
        this.f384699d = paint;
        paint.setAntiAlias(true);
        this.f384699d.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    }

    public static void setCurThemeId(String str) {
        f384698f = str;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.f384700e && ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)) {
            canvas.saveLayer(null, this.f384699d, 31);
            super.onDraw(canvas);
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    public void setSupportMaskView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f384700e = z16;
        }
    }

    public ThemeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f384700e = true;
            a();
        }
    }

    public ThemeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f384700e = true;
            a();
        }
    }
}
