package com.tencent.qqnt.widget.badgeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends ValueAnimator {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private c[][] f363050d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<QBadgeView> f363051e;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            QBadgeView qBadgeView = (QBadgeView) b.this.f363051e.get();
            if (qBadgeView != null && qBadgeView.isShown()) {
                qBadgeView.invalidate();
            } else {
                b.this.cancel();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.widget.badgeview.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C9707b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        C9707b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            QBadgeView qBadgeView = (QBadgeView) b.this.f363051e.get();
            if (qBadgeView != null) {
                qBadgeView.r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Random f363054a;

        /* renamed from: b, reason: collision with root package name */
        float f363055b;

        /* renamed from: c, reason: collision with root package name */
        float f363056c;

        /* renamed from: d, reason: collision with root package name */
        float f363057d;

        /* renamed from: e, reason: collision with root package name */
        int f363058e;

        /* renamed from: f, reason: collision with root package name */
        int f363059f;

        /* renamed from: g, reason: collision with root package name */
        Paint f363060g;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                return;
            }
            Paint paint = new Paint();
            this.f363060g = paint;
            paint.setAntiAlias(true);
            this.f363060g.setStyle(Paint.Style.FILL);
            this.f363054a = new Random();
        }

        public void a(float f16, Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), canvas);
                return;
            }
            this.f363060g.setColor(this.f363058e);
            this.f363055b += this.f363054a.nextInt(this.f363059f) * 0.1f * (this.f363054a.nextFloat() - 0.5f);
            float nextInt = this.f363056c + (this.f363054a.nextInt(this.f363059f) * 0.1f * (this.f363054a.nextFloat() - 0.5f));
            this.f363056c = nextInt;
            float f17 = this.f363055b;
            float f18 = this.f363057d;
            canvas.drawCircle(f17, nextInt, f18 - (f16 * f18), this.f363060g);
        }
    }

    public b(Bitmap bitmap, PointF pointF, QBadgeView qBadgeView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bitmap, pointF, qBadgeView);
            return;
        }
        this.f363051e = new WeakReference<>(qBadgeView);
        setFloatValues(0.0f, 1.0f);
        setDuration(500L);
        this.f363050d = c(bitmap, pointF);
        addUpdateListener(new a());
        addListener(new C9707b());
    }

    private c[][] c(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(width, height) / 6.0f;
        float width2 = pointF.x - (bitmap.getWidth() / 2.0f);
        float height2 = pointF.y - (bitmap.getHeight() / 2.0f);
        c[][] cVarArr = (c[][]) Array.newInstance((Class<?>) c.class, (int) (height / min), (int) (width / min));
        for (int i3 = 0; i3 < cVarArr.length; i3++) {
            for (int i16 = 0; i16 < cVarArr[i3].length; i16++) {
                c cVar = new c();
                float f16 = i16 * min;
                float f17 = i3 * min;
                cVar.f363058e = bitmap.getPixel((int) f16, (int) f17);
                cVar.f363055b = f16 + width2;
                cVar.f363056c = f17 + height2;
                cVar.f363057d = min;
                cVar.f363059f = Math.max(width, height);
                cVarArr[i3][i16] = cVar;
            }
        }
        bitmap.recycle();
        return cVarArr;
    }

    public void b(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        for (int i3 = 0; i3 < this.f363050d.length; i3++) {
            int i16 = 0;
            while (true) {
                c[] cVarArr = this.f363050d[i3];
                if (i16 < cVarArr.length) {
                    cVarArr[i16].a(Float.parseFloat(getAnimatedValue().toString()), canvas);
                    i16++;
                }
            }
        }
    }
}
