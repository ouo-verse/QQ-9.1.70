package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThemeRecentDynamicAvatarView extends RecentDynamicAvatarView {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name */
    public static String f384695c0;

    /* renamed from: a0, reason: collision with root package name */
    Paint f384696a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f384697b0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f384695c0 = "1000";
        }
    }

    public ThemeRecentDynamicAvatarView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f384697b0 = true;
            init();
        }
    }

    private void init() {
        Paint paint = new Paint();
        this.f384696a0 = paint;
        paint.setAntiAlias(true);
        this.f384696a0.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    }

    public static void setCurThemeId(String str) {
        f384695c0 = str;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.f384697b0 && ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)) {
            canvas.saveLayer(null, this.f384696a0, 31);
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
            this.f384697b0 = z16;
        }
    }

    public ThemeRecentDynamicAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f384697b0 = true;
            init();
        }
    }

    public ThemeRecentDynamicAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f384697b0 = true;
            init();
        }
    }
}
