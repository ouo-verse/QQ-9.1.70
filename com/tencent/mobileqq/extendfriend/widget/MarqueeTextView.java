package com.tencent.mobileqq.extendfriend.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes12.dex */
public class MarqueeTextView extends TextView {
    static IPatchRedirector $redirector_;
    private static final int E;
    private int C;
    private Handler D;

    /* renamed from: d, reason: collision with root package name */
    private Scroller f205574d;

    /* renamed from: e, reason: collision with root package name */
    private int f205575e;

    /* renamed from: f, reason: collision with root package name */
    private int f205576f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f205577h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f205578i;

    /* renamed from: m, reason: collision with root package name */
    private int f205579m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            E = ViewUtils.dpToPx(8.0f);
        }
    }

    public MarqueeTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int c() {
        TextPaint paint = getPaint();
        Rect rect = new Rect();
        String charSequence = getText().toString();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return rect.width();
    }

    private void d(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MarqueeTextView);
        this.f205575e = obtainStyledAttributes.getInt(R.styleable.MarqueeTextView_scroll_interval, 10000);
        this.f205579m = obtainStyledAttributes.getInt(R.styleable.MarqueeTextView_scroll_mode, 100);
        this.C = obtainStyledAttributes.getInt(R.styleable.MarqueeTextView_scroll_first_delay, 1000);
        obtainStyledAttributes.recycle();
        setSingleLine();
        setEllipsize(null);
    }

    @Override // android.widget.TextView, android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.computeScroll();
        Scroller scroller = this.f205574d;
        if (scroller != null && scroller.isFinished() && !this.f205577h) {
            if (this.f205579m == 101) {
                f();
                return;
            }
            this.f205577h = true;
            this.f205576f = 0;
            this.f205578i = false;
            e();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!this.f205577h) {
            return;
        }
        setHorizontallyScrolling(true);
        if (this.f205574d == null) {
            Scroller scroller = new Scroller(getContext(), new LinearInterpolator());
            this.f205574d = scroller;
            setScroller(scroller);
        }
        int c16 = ((c() / 2) - this.f205576f) + E;
        int intValue = Double.valueOf(this.f205575e * c16 * 1.0d).intValue();
        if (this.f205578i) {
            this.f205574d.startScroll(0, 0, c16, 0, intValue);
            invalidate();
            this.f205577h = false;
        } else {
            f();
            this.D.removeCallbacksAndMessages(null);
            this.D.postDelayed(new Runnable(c16, intValue) { // from class: com.tencent.mobileqq.extendfriend.widget.MarqueeTextView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f205580d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f205581e;

                {
                    this.f205580d = c16;
                    this.f205581e = intValue;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MarqueeTextView.this, Integer.valueOf(c16), Integer.valueOf(intValue));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MarqueeTextView.this.f205574d.startScroll(0, 0, this.f205580d, 0, this.f205581e);
                    MarqueeTextView.this.invalidate();
                    MarqueeTextView.this.f205577h = false;
                }
            }, this.C);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Scroller scroller = this.f205574d;
        if (scroller == null) {
            return;
        }
        this.f205577h = true;
        scroller.startScroll(0, 0, 0, 0, 0);
    }

    @Override // android.view.View
    public boolean isFocused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z16, int i3, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), rect);
        } else if (z16) {
            super.onFocusChanged(z16, i3, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else if (z16) {
            super.onWindowFocusChanged(z16);
        }
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f205576f = 0;
        this.f205577h = true;
        this.f205578i = true;
        this.D = new Handler(Looper.getMainLooper());
        d(context, attributeSet, i3);
    }
}
