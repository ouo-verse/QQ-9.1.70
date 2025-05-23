package com.tencent.mobileqq.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QUICustomGradientBubbleView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private static final int I;
    private static final int J;
    private static final int K;
    private int C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    LinearGradient H;

    /* renamed from: d, reason: collision with root package name */
    private Path f213832d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f213833e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f213834f;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f213835h;

    /* renamed from: i, reason: collision with root package name */
    private float f213836i;

    /* renamed from: m, reason: collision with root package name */
    private int f213837m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51324);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        I = Color.parseColor("#FBEA87");
        J = Color.parseColor("#C062F3");
        K = Color.parseColor("#33ADFF");
    }

    public QUICustomGradientBubbleView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f213833e = new Paint();
        this.f213834f = new Paint();
        this.f213835h = new Paint();
        setWillNotDraw(false);
        e();
    }

    private void a() {
        int i3 = this.C;
        if (i3 != 1 && i3 != 0) {
            if (i3 == 3 || i3 == 2) {
                d();
            }
        } else {
            c();
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{I, J, K}, (float[]) null, Shader.TileMode.CLAMP);
        this.H = linearGradient;
        this.f213833e.setShader(linearGradient);
    }

    private void b() {
        if (this.f213832d == null) {
            this.f213832d = new Path();
        }
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        Path path = new Path();
        float f16 = this.f213836i;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        this.f213832d.op(path, Path.Op.UNION);
    }

    private void c() {
        int paddingTop;
        int i3;
        if (this.f213832d == null) {
            this.f213832d = new Path();
        }
        int paddingLeft = getPaddingLeft() + this.f213837m + this.D;
        double sqrt = Math.sqrt(2.0d);
        float f16 = (float) ((r3 / 3.0f) / sqrt);
        float f17 = this.f213837m - f16;
        if (this.C == 0) {
            paddingTop = getHeight() - getPaddingBottom();
        } else {
            paddingTop = getPaddingTop();
        }
        int i16 = this.C;
        if (i16 != 0) {
            f17 = -f17;
        }
        if (i16 == 0) {
            i3 = this.f213837m;
        } else {
            i3 = -this.f213837m;
        }
        float f18 = paddingTop;
        this.f213832d.moveTo(paddingLeft - this.f213837m, f18);
        float f19 = paddingLeft;
        float f26 = f17 + f18;
        this.f213832d.lineTo(f19 - f16, f26);
        this.f213832d.quadTo(f19, i3 + f18, f16 + f19, f26);
        this.f213832d.lineTo(paddingLeft + this.f213837m, f18);
    }

    private void d() {
        int paddingLeft;
        int i3;
        if (this.f213832d == null) {
            this.f213832d = new Path();
        }
        int paddingTop = getPaddingTop() + this.f213837m + this.E;
        double sqrt = Math.sqrt(2.0d);
        float f16 = (float) ((r3 / 3.0f) / sqrt);
        float f17 = this.f213837m - f16;
        if (this.C == 2) {
            paddingLeft = getWidth() - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int i16 = this.C;
        if (i16 != 2) {
            f17 = -f17;
        }
        if (i16 == 2) {
            i3 = this.f213837m;
        } else {
            i3 = -this.f213837m;
        }
        float f18 = paddingLeft;
        this.f213832d.moveTo(f18, this.f213837m + paddingTop);
        float f19 = f17 + f18;
        float f26 = paddingTop;
        this.f213832d.lineTo(f19, f26 + f16);
        this.f213832d.quadTo(i3 + f18, f26, f19, f26 - f16);
        this.f213832d.lineTo(f18, paddingTop - this.f213837m);
    }

    private void e() {
        h();
        this.f213836i = x.c(getContext(), 4.0f);
        this.f213837m = x.c(getContext(), 6.0f);
    }

    private Path f() {
        Path path = this.f213832d;
        if (path != null) {
            return path;
        }
        this.f213832d = new Path();
        a();
        b();
        this.f213832d.close();
        return this.f213832d;
    }

    private void h() {
        this.f213833e.setStyle(Paint.Style.STROKE);
        this.f213833e.setColor(0);
        this.f213833e.setStrokeWidth(x.c(getContext(), 1.0f));
        this.f213835h.setStyle(Paint.Style.FILL);
        this.f213835h.setColor(getResources().getColor(R.color.qui_common_bg_top_light));
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f213837m * 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        canvas.drawPath(f(), this.f213833e);
        if (this.G) {
            canvas.drawPath(f(), this.f213834f);
        }
        canvas.drawPath(f(), this.f213835h);
    }

    public void setArrowOffsetX(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            if (this.D == i3) {
                return;
            }
            this.D = i3;
        }
    }

    public void setArrowOffsetY(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            if (this.E == i3) {
                return;
            }
            this.E = i3;
        }
    }

    public void setArrowPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.C = i3;
        }
    }

    public void setBubbleColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            if (i3 == this.F) {
                return;
            }
            this.F = i3;
            this.f213833e.setColor(i3);
        }
    }

    public void setEnableBound(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        this.G = z16;
        if (z16) {
            this.f213834f.setStyle(Paint.Style.STROKE);
            this.f213834f.setStrokeWidth(2.0f);
            this.f213834f.setColor(ie0.a.f().g(getContext(), R.color.ala, 1000));
        }
    }

    public void setEnableShadow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else if (z16) {
            this.f213833e.setShadowLayer(12.0f, 0.0f, 4.0f, ie0.a.f().g(getContext(), R.color.f157952an2, 1000));
        } else {
            this.f213833e.clearShadowLayer();
        }
    }

    public QUICustomGradientBubbleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f213833e = new Paint();
        this.f213834f = new Paint();
        this.f213835h = new Paint();
        setWillNotDraw(false);
        e();
    }
}
