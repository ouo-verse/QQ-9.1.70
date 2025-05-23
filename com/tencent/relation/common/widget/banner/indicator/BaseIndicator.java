package com.tencent.relation.common.widget.banner.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BaseIndicator extends View implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected IndicatorConfig f364829d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f364830e;

    /* renamed from: f, reason: collision with root package name */
    protected float f364831f;

    public BaseIndicator(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.relation.common.widget.banner.indicator.a
    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f364829d.o(i3);
        this.f364829d.l(i16);
        requestLayout();
    }

    @Override // com.tencent.relation.common.widget.banner.indicator.a
    @NonNull
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f364829d.j()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int b16 = this.f364829d.b();
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 == 2) {
                        layoutParams.gravity = 8388693;
                    }
                } else {
                    layoutParams.gravity = 81;
                }
            } else {
                layoutParams.gravity = 8388691;
            }
            layoutParams.leftMargin = this.f364829d.e().f364847a;
            layoutParams.rightMargin = this.f364829d.e().f364849c;
            layoutParams.topMargin = this.f364829d.e().f364848b;
            layoutParams.bottomMargin = this.f364829d.e().f364850d;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // com.tencent.relation.common.widget.banner.indicator.a
    public IndicatorConfig c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f364829d;
    }

    @Override // qz3.b
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
    }

    @Override // qz3.b
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        } else {
            this.f364831f = f16;
            invalidate();
        }
    }

    @Override // qz3.b
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f364829d.l(i3);
            invalidate();
        }
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f364829d = new IndicatorConfig();
        Paint paint = new Paint();
        this.f364830e = paint;
        paint.setAntiAlias(true);
        this.f364830e.setColor(0);
        this.f364830e.setColor(this.f364829d.f());
    }
}
