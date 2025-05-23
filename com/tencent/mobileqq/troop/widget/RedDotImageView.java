package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RedDotImageView extends ImageView {
    static IPatchRedirector $redirector_;
    protected Drawable C;
    protected int D;
    protected Paint E;
    protected int F;
    private int G;
    protected float H;
    private float I;

    /* renamed from: d, reason: collision with root package name */
    private int f302384d;

    /* renamed from: e, reason: collision with root package name */
    private int f302385e;

    /* renamed from: f, reason: collision with root package name */
    private int f302386f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f302387h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f302388i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f302389m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.widget.RedDotImageView$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f302390d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f302391e;
        final /* synthetic */ RedDotImageView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MobileQQ application = this.f302390d.getApplication();
            boolean Z = ea.Z(application, this.f302390d.getCurrentAccountUin(), ea.q(application), this.f302391e);
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, this.f302391e + " show redDot: " + Z);
            }
            this.this$0.b(Z);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.widget.RedDotImageView$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f302392d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f302393e;
        final /* synthetic */ RedDotImageView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MobileQQ application = this.f302392d.getApplication();
            int q16 = ea.q(application);
            if (ea.Z(application, this.f302392d.getCurrentAccountUin(), q16, this.f302393e)) {
                ea.M2(application, this.f302392d.getCurrentAccountUin(), q16, this.f302393e);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent", 2, this.f302393e + " close redDot");
                }
            }
        }
    }

    public RedDotImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f302388i;
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (this.f302388i != z16) {
            this.f302388i = z16;
            if (z16 && this.f302387h == null) {
                this.f302387h = getResources().getDrawable(R.drawable.skin_tips_dot);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, " showRedDot() : " + this.F + ",isShownBorder" + this.f302389m + "\uff0cthis = " + this);
            }
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        double ceil;
        Drawable drawable2;
        int i3;
        int i16;
        double ceil2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (QLog.isColorLevel() && toString().contains("qq_aio_panel_image")) {
            QLog.d("Q.recent", 2, " onDraw() : " + this.F + ",isShownBorder" + this.f302389m + "\uff0cthis = " + this);
        }
        if (this.f302388i && (drawable2 = this.f302387h) != null) {
            drawable2.setState(getDrawableState());
            int i17 = this.f302384d;
            if (i17 == 0) {
                i3 = (int) Math.ceil(((getWidth() * 0.5d) + (this.I * this.f302385e)) - (this.f302387h.getIntrinsicWidth() * 0.5d));
                ceil2 = Math.ceil(((getHeight() * 0.5d) - (this.I * this.f302386f)) - (this.f302387h.getIntrinsicHeight() * 0.5d));
            } else if (i17 == 1) {
                i3 = (int) Math.ceil((getWidth() + (this.I * this.f302385e)) - (this.f302387h.getIntrinsicWidth() * 0.5d));
                ceil2 = Math.ceil(((-this.I) * this.f302386f) - (this.f302387h.getIntrinsicHeight() * 0.5d));
            } else {
                i3 = 0;
                i16 = 0;
                Drawable drawable3 = this.f302387h;
                drawable3.setBounds(i3, i16, drawable3.getIntrinsicWidth() + i3, this.f302387h.getIntrinsicHeight() + i16);
                this.f302387h.draw(canvas);
            }
            i16 = (int) ceil2;
            Drawable drawable32 = this.f302387h;
            drawable32.setBounds(i3, i16, drawable32.getIntrinsicWidth() + i3, this.f302387h.getIntrinsicHeight() + i16);
            this.f302387h.draw(canvas);
        }
        if (this.F > 0 && (drawable = this.C) != null) {
            drawable.setState(getDrawableState());
            if (getWidth() > this.D * 2) {
                ceil = Math.ceil(r0 / 2);
            } else {
                ceil = Math.ceil((r0 - r5) - this.G);
            }
            int i18 = (int) ceil;
            Drawable drawable4 = this.C;
            int i19 = this.D;
            drawable4.setBounds(i18, 0, i18 + i19, i19);
            this.C.draw(canvas);
            int ceil3 = (int) Math.ceil(this.E.measureText(String.valueOf(this.F)));
            String valueOf = String.valueOf(this.F);
            double d16 = i18;
            int i26 = this.D;
            canvas.drawText(valueOf, (int) (d16 + ((i26 - ceil3) * 0.5d)), (int) (i26 - (this.H * 0.5d)), this.E);
        }
    }

    public void setRedDotBase(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else if (this.f302384d != i3) {
            this.f302384d = i3;
            postInvalidate();
        }
    }

    public void setRedDotDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else if (drawable != null) {
            this.f302387h = drawable;
        }
    }

    public void setReddotXOffsetDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (i3 != this.f302385e) {
            this.f302385e = i3;
            postInvalidate();
        }
    }

    public void setReddotYOffsetDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else if (i3 != this.f302386f) {
            this.f302386f = i3;
            postInvalidate();
        }
    }

    public void setShowBorder(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f302389m = z16;
        }
    }

    public void setUnreadNumber(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, " setUnreadNumber() : " + i3 + ",isShownBorder" + this.f302389m + "\uff0cthis = " + this);
        }
        if (i3 > 0 && this.C == null) {
            float f16 = this.I;
            this.D = (int) (20.0f * f16);
            this.G = (int) (f16 * 6.0f);
            Paint paint = new Paint();
            this.E = paint;
            paint.setAntiAlias(true);
            this.E.setColor(getResources().getColor(R.color.qui_button_text_primary_default));
            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
                this.E.setColor(-1509949441);
            }
            this.E.setStyle(Paint.Style.FILL);
            this.E.setTextSize(this.I * 12.0f);
            Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
            this.E.getFontMetrics(fontMetrics);
            this.H = Math.abs(fontMetrics.ascent);
            this.C = getResources().getDrawable(R.drawable.qui_common_check_box_with_text_checked_white_border);
        }
        this.F = i3;
        postInvalidate();
    }

    public RedDotImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302384d = 0;
        this.f302385e = 13;
        this.f302386f = 13;
        this.f302387h = null;
        this.f302388i = false;
        this.f302389m = false;
        this.C = null;
        this.D = 0;
        this.E = null;
        this.F = 0;
        this.G = 0;
        this.H = 0.0f;
        this.I = getResources().getDisplayMetrics().density;
    }

    public RedDotImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302384d = 0;
        this.f302385e = 13;
        this.f302386f = 13;
        this.f302387h = null;
        this.f302388i = false;
        this.f302389m = false;
        this.C = null;
        this.D = 0;
        this.E = null;
        this.F = 0;
        this.G = 0;
        this.H = 0.0f;
        this.I = getResources().getDisplayMetrics().density;
    }
}
