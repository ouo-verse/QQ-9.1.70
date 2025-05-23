package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberListSlideItem extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected Scroller f302458d;

    /* renamed from: e, reason: collision with root package name */
    protected View f302459e;

    /* renamed from: f, reason: collision with root package name */
    protected View f302460f;

    /* renamed from: h, reason: collision with root package name */
    protected int f302461h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f302462i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f302463m;

    public TroopMemberListSlideItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302461h = 0;
        this.f302462i = false;
        this.f302463m = false;
        a(context);
    }

    protected void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.f302458d = new Scroller(context);
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            if (getScrollX() > 0) {
                return;
            }
            if (z16) {
                this.f302458d.startScroll(0, 0, this.f302461h, 0);
            } else {
                scrollTo(this.f302461h, 0);
            }
            invalidate();
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        if (getScrollX() == 0) {
            return;
        }
        if (z16) {
            Scroller scroller = this.f302458d;
            int i3 = this.f302461h;
            scroller.startScroll(i3, 0, -i3, 0);
        } else {
            scrollTo(0, 0);
        }
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.f302458d.computeScrollOffset()) {
            scrollTo(this.f302458d.getCurrX(), 0);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onFinishInflate();
        this.f302459e = getChildAt(0);
        this.f302460f = getChildAt(1);
        ViewGroup.LayoutParams layoutParams = this.f302459e.getLayoutParams();
        if (layoutParams != null && layoutParams.width == -1) {
            this.f302462i = true;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int measuredWidth = this.f302459e.getMeasuredWidth();
        if (this.f302462i) {
            measuredWidth = getMeasuredWidth();
        }
        View view = this.f302459e;
        view.layout(0, 0, measuredWidth, view.getMeasuredHeight());
        View view2 = this.f302460f;
        view2.layout(measuredWidth, 0, view2.getMeasuredWidth() + measuredWidth, this.f302460f.getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            this.f302461h = this.f302460f.getMeasuredWidth();
        }
    }

    public void setSlideEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        this.f302463m = z16;
        if (z16) {
            setClickable(true);
        } else {
            setClickable(false);
        }
    }

    public TroopMemberListSlideItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302461h = 0;
        this.f302462i = false;
        this.f302463m = false;
        a(context);
    }
}
