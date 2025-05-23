package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface h {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a implements h {
        private int C;
        private int D;
        private int E;
        private int F;
        private h K;

        /* renamed from: d, reason: collision with root package name */
        private View f60864d;

        /* renamed from: e, reason: collision with root package name */
        private Context f60865e;

        /* renamed from: f, reason: collision with root package name */
        private Drawable f60866f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f60867h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f60868i = false;

        /* renamed from: m, reason: collision with root package name */
        private int f60869m = 1;
        private int G = -1;
        private int H = -1;
        private boolean I = false;
        private boolean J = false;

        /* JADX WARN: Multi-variable type inference failed */
        public a(View view, AttributeSet attributeSet) {
            this.f60864d = view;
            this.f60865e = view.getContext();
            if (view instanceof h) {
                q((h) view);
            }
            TypedArray obtainStyledAttributes = this.f60865e.obtainStyledAttributes(attributeSet, R.styleable.Markable);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            boolean z16 = obtainStyledAttributes.getBoolean(6, false);
            boolean z17 = obtainStyledAttributes.getBoolean(7, false);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, -1);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            int i3 = obtainStyledAttributes.getInt(4, 1);
            o(drawable);
            u(z16);
            v(z17);
            t(dimensionPixelSize, dimensionPixelSize2);
            r(dimensionPixelOffset, dimensionPixelOffset2);
            s(i3);
            obtainStyledAttributes.recycle();
        }

        private int b() {
            return this.C + this.E;
        }

        private int c() {
            return this.D + this.F;
        }

        private int d() {
            int i3 = this.H;
            return i3 > 0 ? i3 : this.f60866f.getIntrinsicHeight();
        }

        private int g() {
            int i3 = this.G;
            return i3 > 0 ? i3 : this.f60866f.getIntrinsicWidth();
        }

        private boolean h() {
            return j() && this.f60866f != null;
        }

        private boolean i(MotionEvent motionEvent) {
            h();
            return false;
        }

        public void a(Canvas canvas) {
            if (this.I) {
                x();
                this.I = false;
            }
            if (h()) {
                int b16 = b();
                int c16 = c();
                if (b16 != 0 || c16 != 0) {
                    canvas.translate(b16, c16);
                }
                this.f60866f.draw(canvas);
            }
        }

        public boolean j() {
            return this.f60867h || (this.f60868i && this.f60864d.isSelected());
        }

        public boolean l(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (i(motionEvent)) {
                if (action == 0) {
                    this.J = true;
                    return true;
                }
                if (action == 1 && this.J) {
                    k();
                    this.J = false;
                    return true;
                }
            }
            if (action == 1 || action == 3) {
                this.J = false;
            }
            return false;
        }

        public void m(int i3) {
            o(this.f60865e.getResources().getDrawable(i3));
        }

        public void n(int i3, int i16) {
            p(this.f60865e.getResources().getDrawable(i3), i16);
        }

        public void o(Drawable drawable) {
            if (this.f60866f == drawable) {
                return;
            }
            this.f60866f = drawable;
            this.I = true;
            this.f60864d.invalidate();
        }

        public void p(Drawable drawable, int i3) {
            if (this.f60866f == drawable && this.f60869m == i3) {
                return;
            }
            this.f60866f = drawable;
            if (drawable == null) {
                return;
            }
            this.f60869m = i3;
            x();
        }

        protected void q(h hVar) {
            this.K = hVar;
        }

        public void r(int i3, int i16) {
            if (this.E == i3 && this.F == i16) {
                return;
            }
            this.E = i3;
            this.F = i16;
            this.f60864d.invalidate();
        }

        public void s(int i3) {
            if (this.f60869m == i3) {
                return;
            }
            this.f60869m = i3;
            this.I = true;
            this.f60864d.invalidate();
        }

        public void t(int i3, int i16) {
            if (this.G == i3 && this.H == i16) {
                return;
            }
            this.G = i3;
            this.H = i16;
            this.I = true;
            this.f60864d.invalidate();
        }

        public void u(boolean z16) {
            if (this.f60867h == z16) {
                return;
            }
            this.f60867h = z16;
            this.f60864d.invalidate();
        }

        public void v(boolean z16) {
            if (this.f60868i == z16) {
                return;
            }
            this.f60868i = z16;
            this.f60864d.invalidate();
        }

        public void x() {
            if (this.f60866f == null) {
                return;
            }
            int width = this.f60864d.getWidth();
            int height = this.f60864d.getHeight();
            int g16 = g();
            int d16 = d();
            this.C = e(width, g16, this.f60869m);
            this.D = f(height, d16, this.f60869m);
            this.f60866f.setBounds(0, 0, g16, d16);
        }

        private static int e(int i3, int i16, int i17) {
            if (i17 == 2) {
                return 0;
            }
            if (i17 == 3 || i17 == 4) {
                return i3 - i16;
            }
            if (i17 != 5) {
                return (i3 - i16) / 2;
            }
            return 0;
        }

        private static int f(int i3, int i16, int i17) {
            if (i17 == 2 || i17 == 3) {
                return 0;
            }
            return (i17 == 4 || i17 == 5) ? i3 - i16 : (i3 - i16) / 2;
        }

        private void k() {
        }

        public void w(b bVar) {
        }
    }
}
