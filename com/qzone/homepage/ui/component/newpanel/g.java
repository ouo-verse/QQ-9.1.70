package com.qzone.homepage.ui.component.newpanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface g {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a implements g {
        private Matrix C;
        private int I;
        private int J;
        private int K;
        private int L;
        private g S;

        /* renamed from: d, reason: collision with root package name */
        private View f47779d;

        /* renamed from: e, reason: collision with root package name */
        private Context f47780e;

        /* renamed from: f, reason: collision with root package name */
        private Drawable f47781f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f47782h;

        /* renamed from: i, reason: collision with root package name */
        private int f47783i;

        /* renamed from: m, reason: collision with root package name */
        private Matrix f47784m = new Matrix();
        private RectF D = new RectF();
        private RectF E = new RectF();
        private boolean F = false;
        private boolean G = false;
        private int H = 1;
        private int M = -1;
        private int N = -1;
        private int P = 0;
        private boolean Q = false;
        private boolean R = false;

        /* JADX WARN: Multi-variable type inference failed */
        public a(View view, AttributeSet attributeSet) {
            this.f47779d = view;
            this.f47780e = view.getContext();
            if (view instanceof g) {
                p((g) view);
            }
            TypedArray obtainStyledAttributes = this.f47780e.obtainStyledAttributes(attributeSet, R.styleable.Markable);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            boolean z16 = obtainStyledAttributes.getBoolean(6, false);
            boolean z17 = obtainStyledAttributes.getBoolean(7, false);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, -1);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            int i3 = obtainStyledAttributes.getInt(4, 1);
            int i16 = obtainStyledAttributes.getInt(5, 0);
            o(drawable);
            v(z16);
            w(z17);
            u(dimensionPixelSize, dimensionPixelSize2);
            r(dimensionPixelOffset, dimensionPixelOffset2);
            s(i3);
            t(i16);
            obtainStyledAttributes.recycle();
        }

        private int b() {
            return this.I + this.K;
        }

        private int c() {
            return this.J + this.L;
        }

        private int d() {
            int i3 = this.N;
            if (i3 > 0) {
                return i3;
            }
            Drawable drawable = this.f47781f;
            if (drawable == null) {
                return 0;
            }
            return drawable.getIntrinsicHeight();
        }

        private int g() {
            int i3 = this.M;
            if (i3 > 0) {
                return i3;
            }
            Drawable drawable = this.f47781f;
            if (drawable == null) {
                return 0;
            }
            return drawable.getIntrinsicWidth();
        }

        private boolean h() {
            return j() && this.f47781f != null;
        }

        private boolean i(MotionEvent motionEvent) {
            h();
            return false;
        }

        private void y() {
            Drawable drawable;
            float f16;
            float f17;
            if (this.f47779d == null || (drawable = this.f47781f) == null) {
                return;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.f47781f.getIntrinsicHeight();
            int g16 = g();
            int d16 = d();
            if (g16 <= 0 || d16 <= 0 || g16 > this.f47779d.getWidth() || d16 > this.f47779d.getHeight()) {
                g16 = this.f47779d.getWidth();
                d16 = this.f47779d.getHeight();
            }
            boolean z16 = (intrinsicWidth < 0 || g16 == intrinsicWidth) && (intrinsicHeight < 0 || d16 == intrinsicHeight);
            if (intrinsicWidth > 0 && intrinsicHeight > 0 && 7 != this.P) {
                this.f47781f.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                int i3 = this.P;
                if (8 == i3) {
                    if (this.f47784m.isIdentity()) {
                        this.C = null;
                        return;
                    } else {
                        this.C = this.f47784m;
                        return;
                    }
                }
                if (z16) {
                    this.C = null;
                    return;
                }
                if (1 == i3) {
                    Matrix matrix = this.f47784m;
                    this.C = matrix;
                    matrix.setTranslate((int) (((g16 - intrinsicWidth) * 0.5f) + 0.5f), (int) (((d16 - intrinsicHeight) * 0.5f) + 0.5f));
                    return;
                }
                float f18 = 0.0f;
                if (2 != i3) {
                    if (3 == i3) {
                        this.C = this.f47784m;
                        float min = (intrinsicWidth > g16 || intrinsicHeight > d16) ? Math.min(g16 / intrinsicWidth, d16 / intrinsicHeight) : 1.0f;
                        this.C.setScale(min, min);
                        this.C.postTranslate((int) (((g16 - (intrinsicWidth * min)) * 0.5f) + 0.5f), (int) (((d16 - (intrinsicHeight * min)) * 0.5f) + 0.5f));
                        return;
                    }
                    this.D.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                    this.E.set(0.0f, 0.0f, g16, d16);
                    Matrix matrix2 = this.f47784m;
                    this.C = matrix2;
                    matrix2.setRectToRect(this.D, this.E, m(this.P));
                    return;
                }
                Matrix matrix3 = this.f47784m;
                this.C = matrix3;
                if (intrinsicWidth * d16 > g16 * intrinsicHeight) {
                    f17 = d16 / intrinsicHeight;
                    float f19 = (g16 - (intrinsicWidth * f17)) * 0.5f;
                    f16 = 0.0f;
                    f18 = f19;
                } else {
                    float f26 = g16 / intrinsicWidth;
                    f16 = (d16 - (intrinsicHeight * f26)) * 0.5f;
                    f17 = f26;
                }
                matrix3.setScale(f17, f17);
                this.C.postTranslate((int) (f18 + 0.5f), (int) (f16 + 0.5f));
                return;
            }
            this.f47781f.setBounds(0, 0, g16, d16);
            this.C = null;
        }

        public void a(Canvas canvas) {
            if (this.Q) {
                z();
                this.Q = false;
            }
            if (h()) {
                int saveCount = canvas.getSaveCount();
                canvas.save();
                int b16 = b();
                int c16 = c();
                if (b16 != 0 || c16 != 0) {
                    canvas.translate(b16, c16);
                }
                Matrix matrix = this.C;
                if (matrix != null) {
                    canvas.concat(matrix);
                }
                if (this.f47782h) {
                    canvas.save();
                    canvas.translate(0.0f, ar.e(20.0f) - this.f47783i);
                    this.f47781f.draw(canvas);
                    canvas.restore();
                } else {
                    this.f47781f.draw(canvas);
                }
                canvas.restoreToCount(saveCount);
            }
        }

        public boolean j() {
            return this.F || (this.G && this.f47779d.isSelected());
        }

        public boolean l(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (i(motionEvent)) {
                if (action == 0) {
                    this.R = true;
                    return true;
                }
                if (action == 1 && this.R) {
                    k();
                    this.R = false;
                    return true;
                }
            }
            if (action == 1 || action == 3) {
                this.R = false;
            }
            return false;
        }

        public void n(int i3) {
            o(this.f47780e.getResources().getDrawable(i3));
        }

        public void o(Drawable drawable) {
            if (this.f47781f == drawable) {
                return;
            }
            this.f47781f = drawable;
            this.Q = true;
            this.f47779d.invalidate();
        }

        protected void p(g gVar) {
            this.S = gVar;
        }

        public void r(int i3, int i16) {
            if (this.K == i3 && this.L == i16) {
                return;
            }
            this.K = i3;
            this.L = i16;
            this.f47779d.invalidate();
        }

        public void s(int i3) {
            if (this.H == i3) {
                return;
            }
            this.H = i3;
            this.Q = true;
            this.f47779d.invalidate();
        }

        public void t(int i3) {
            if (this.P == i3 || i3 < 1 || i3 > 8) {
                return;
            }
            this.P = i3;
            this.Q = true;
            this.f47779d.invalidate();
        }

        public void u(int i3, int i16) {
            if (this.M == i3 && this.N == i16) {
                return;
            }
            this.M = i3;
            this.N = i16;
            this.Q = true;
            this.f47779d.invalidate();
        }

        public void v(boolean z16) {
            if (this.F == z16) {
                return;
            }
            this.F = z16;
            this.f47779d.invalidate();
        }

        public void w(boolean z16) {
            if (this.G == z16) {
                return;
            }
            this.G = z16;
            this.f47779d.invalidate();
        }

        public void z() {
            if (this.f47781f == null) {
                return;
            }
            int width = this.f47779d.getWidth();
            int height = this.f47779d.getHeight();
            int g16 = g();
            int d16 = d();
            if ((g16 > width || d16 > height) && this.P != 0) {
                this.I = 0;
                this.J = 0;
            } else {
                this.I = e(width, g16, this.H);
                this.J = f(height, d16, this.H);
            }
            if (this.P == 0) {
                this.f47781f.setBounds(0, 0, g16, d16);
            } else {
                y();
            }
        }

        public void q(Matrix matrix) {
            if (matrix != null && matrix.isIdentity()) {
                matrix = null;
            }
            if ((matrix != null || this.f47784m.isIdentity()) && (matrix == null || this.f47784m.equals(matrix))) {
                return;
            }
            this.f47784m.set(matrix);
            this.Q = true;
            this.f47779d.invalidate();
        }

        private Matrix.ScaleToFit m(int i3) {
            if (i3 == 4) {
                return Matrix.ScaleToFit.CENTER;
            }
            if (i3 == 5) {
                return Matrix.ScaleToFit.START;
            }
            if (i3 != 6) {
                return Matrix.ScaleToFit.CENTER;
            }
            return Matrix.ScaleToFit.END;
        }

        private static int e(int i3, int i16, int i17) {
            if (i17 == 2) {
                return 0;
            }
            if (i17 != 3 && i17 != 4) {
                if (i17 == 5) {
                    return 0;
                }
                if (i17 != 6) {
                    return (i3 - i16) / 2;
                }
            }
            return i3 - i16;
        }

        private static int f(int i3, int i16, int i17) {
            if (i17 == 2 || i17 == 3) {
                return 0;
            }
            if (i17 == 4 || i17 == 5) {
                return i3 - i16;
            }
            if (i17 != 6) {
                return (i3 - i16) / 2;
            }
            return (i3 - i16) / 2;
        }

        public void k() {
        }

        public void x(b bVar) {
        }
    }
}
