package com.tencent.mobileqq.poke;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import mqq.app.MobileQQ;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes16.dex */
public class ClickedWaveView extends ImageView {
    static IPatchRedirector $redirector_;
    static final int D;
    static final int E;
    MovingRadiusRunnable C;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f258941d;

    /* renamed from: e, reason: collision with root package name */
    int f258942e;

    /* renamed from: f, reason: collision with root package name */
    int f258943f;

    /* renamed from: h, reason: collision with root package name */
    Scroller f258944h;

    /* renamed from: i, reason: collision with root package name */
    Drawable f258945i;

    /* renamed from: m, reason: collision with root package name */
    a f258946m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class MovingRadiusRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        MovingRadiusRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClickedWaveView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (ClickedWaveView.this.f258944h.computeScrollOffset() || ClickedWaveView.this.f258943f > 0) {
                ClickedWaveView clickedWaveView = ClickedWaveView.this;
                clickedWaveView.f258942e = clickedWaveView.f258944h.getCurrX();
                ClickedWaveView clickedWaveView2 = ClickedWaveView.this;
                int i3 = clickedWaveView2.f258943f;
                if (i3 > 0) {
                    clickedWaveView2.f258943f = i3 - 3;
                }
                if (clickedWaveView2.f258943f < 0) {
                    clickedWaveView2.f258943f = 0;
                }
                clickedWaveView2.postInvalidate();
                ClickedWaveView.this.postDelayed(this, 20L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void G();

        void a(Bundle bundle);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52090);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            D = x.c(MobileQQ.sMobileQQ, 0.01f);
            E = x.c(MobileQQ.sMobileQQ, 60.0f);
        }
    }

    public ClickedWaveView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f258942e = 20;
        this.f258943f = 0;
        this.f258944h = null;
        this.f258945i = null;
        this.f258946m = null;
        this.C = new MovingRadiusRunnable();
        this.f258944h = new Scroller(context, new DecelerateInterpolator());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        Paint paint = new Paint();
        paint.setARGB(this.f258943f, 0, 0, 0);
        if (this.f258942e > width) {
            this.f258942e = width;
        }
        canvas.drawCircle(width, height, this.f258942e, paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                setImageDrawable(this.f258945i);
                Drawable drawable = this.f258945i;
                if (drawable != null && (drawable instanceof CustomFrameAnimationDrawable)) {
                    ((CustomFrameAnimationDrawable) drawable).n();
                }
                if (motionEvent.getAction() == 1 && (aVar = this.f258946m) != null) {
                    aVar.a(this.f258941d);
                }
            }
            return onTouchEvent;
        }
        a aVar2 = this.f258946m;
        if (aVar2 != null) {
            aVar2.G();
        }
        Object obj = this.f258945i;
        if (obj != null && (obj instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable) obj).unscheduleSelf((Runnable) obj);
        }
        Scroller scroller = this.f258944h;
        int i3 = D;
        scroller.startScroll(i3, 0, E, 0, 900);
        this.f258942e = i3;
        this.f258943f = 30;
        f.p(this, this.f258941d.getInt("type"), this.f258941d.getInt("id"));
        postDelayed(this.C, 20L);
        return true;
    }

    public void setCustomDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            this.f258945i = drawable;
        }
    }

    public void setExtraInfo(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        } else {
            this.f258941d = bundle;
        }
    }

    public void setOnTouchReceive(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.f258946m = aVar;
        }
    }

    public ClickedWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f258942e = 20;
        this.f258943f = 0;
        this.f258944h = null;
        this.f258945i = null;
        this.f258946m = null;
        this.C = new MovingRadiusRunnable();
        this.f258944h = new Scroller(context, new DecelerateInterpolator());
    }

    public ClickedWaveView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f258942e = 20;
        this.f258943f = 0;
        this.f258944h = null;
        this.f258945i = null;
        this.f258946m = null;
        this.C = new MovingRadiusRunnable();
        this.f258944h = new Scroller(context, new DecelerateInterpolator());
    }
}
