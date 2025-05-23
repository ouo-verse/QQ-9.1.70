package com.tencent.mobileqq.tofumsg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DrawCircleCornerImageView extends CornerImageView {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    int E;
    private Paint F;

    /* renamed from: m, reason: collision with root package name */
    int f293228m;

    public DrawCircleCornerImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView
    protected void c(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.F == null) {
            Paint paint = new Paint();
            this.F = paint;
            paint.setColor(this.D);
        }
        int save = canvas.save();
        try {
            canvas.drawCircle(this.f293228m, this.C, this.E, this.F);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            canvas.restoreToCount(save);
            throw th5;
        }
        canvas.restoreToCount(save);
    }

    public void setCircle(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f293228m = i3;
        this.C = i16;
        this.D = i18;
        this.E = i17;
        Paint paint = this.F;
        if (paint != null) {
            paint.setColor(i18);
        }
    }

    public DrawCircleCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public DrawCircleCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
