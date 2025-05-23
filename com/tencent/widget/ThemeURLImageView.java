package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.az;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThemeURLImageView extends URLImageView {
    static IPatchRedirector $redirector_;
    public static String CUR_THEMEID;
    boolean isSupportMaskView;
    Paint mPaint;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56413);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CUR_THEMEID = "1000";
        }
    }

    public ThemeURLImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.isSupportMaskView = true;
            init();
        }
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColorFilter(QQTheme.NIGHTMODE_COLORFILTER);
    }

    public static void setCurThemeId(String str) {
        CUR_THEMEID = str;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.isSupportMaskView && az.f()) {
            canvas.saveLayer(null, this.mPaint, 31);
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
            this.isSupportMaskView = z16;
        }
    }

    public ThemeURLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.isSupportMaskView = true;
            init();
        }
    }

    public ThemeURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.isSupportMaskView = true;
            init();
        }
    }
}
