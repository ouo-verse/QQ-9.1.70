package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TabThemeMaskView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final int f181237h;

    /* renamed from: i, reason: collision with root package name */
    public static ColorFilter f181238i;

    /* renamed from: d, reason: collision with root package name */
    Paint f181239d;

    /* renamed from: e, reason: collision with root package name */
    RectF f181240e;

    /* renamed from: f, reason: collision with root package name */
    private int f181241f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25430);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        int parseColor = Color.parseColor("#0A000000");
        f181237h = parseColor;
        f181238i = new PorterDuffColorFilter(parseColor, PorterDuff.Mode.SRC_ATOP);
    }

    public TabThemeMaskView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f181240e = new RectF();
        this.f181241f = f181237h;
        a();
    }

    public static boolean b() {
        if (!"1103".equals(ThemeUtil.curThemeId) && !"2920".equals(ThemeUtil.curThemeId)) {
            return false;
        }
        return true;
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Paint paint = new Paint();
        this.f181239d = paint;
        paint.setAntiAlias(true);
        this.f181239d.setColorFilter(f181238i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (b()) {
            this.f181240e.set(0.0f, 0.0f, getWidth(), getHeight());
            super.onDraw(canvas);
            this.f181239d.setColorFilter(null);
            this.f181239d.setColor(this.f181241f);
            canvas.drawRect(this.f181240e, this.f181239d);
            return;
        }
        super.onDraw(canvas);
    }

    public TabThemeMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f181240e = new RectF();
        this.f181241f = f181237h;
        a();
    }

    public TabThemeMaskView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f181240e = new RectF();
        this.f181241f = f181237h;
        a();
    }
}
