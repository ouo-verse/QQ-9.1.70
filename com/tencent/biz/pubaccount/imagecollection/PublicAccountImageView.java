package com.tencent.biz.pubaccount.imagecollection;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class PublicAccountImageView extends URLImageView {
    Handler C;
    float D;
    float E;
    boolean F;
    boolean G;
    float[] H;

    /* renamed from: d, reason: collision with root package name */
    private GestureDetector f79715d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f79716e;

    /* renamed from: f, reason: collision with root package name */
    private float f79717f;

    /* renamed from: h, reason: collision with root package name */
    private float f79718h;

    /* renamed from: i, reason: collision with root package name */
    private float f79719i;

    /* renamed from: m, reason: collision with root package name */
    Context f79720m;

    /* loaded from: classes32.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: d, reason: collision with root package name */
        private final b f79721d;

        public a(b bVar) {
            this.f79721d = bVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            PublicAccountImageView.this.j();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PublicAccountImageView.this.j();
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* loaded from: classes32.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        private float f79724e;

        /* renamed from: h, reason: collision with root package name */
        boolean f79726h;

        /* renamed from: i, reason: collision with root package name */
        boolean f79727i;

        /* renamed from: d, reason: collision with root package name */
        private int f79723d = 0;

        /* renamed from: f, reason: collision with root package name */
        private Matrix f79725f = new Matrix();

        /* renamed from: m, reason: collision with root package name */
        boolean f79728m = false;
        private PointF C = new PointF();

        public b() {
        }

        private float b(float[] fArr, float f16) {
            float width = PublicAccountImageView.this.getWidth();
            float f17 = PublicAccountImageView.this.f79717f * fArr[0];
            PublicAccountImageView publicAccountImageView = PublicAccountImageView.this;
            if (f17 / publicAccountImageView.H[0] < width) {
                return 0.0f;
            }
            float f18 = fArr[2];
            if (f18 + f16 > 0.0f) {
                return -f18;
            }
            float f19 = f18 + f16;
            float f26 = publicAccountImageView.f79717f * fArr[0];
            PublicAccountImageView publicAccountImageView2 = PublicAccountImageView.this;
            return f19 < (-((f26 / publicAccountImageView2.H[0]) - width)) ? (-(((publicAccountImageView2.f79717f * fArr[0]) / PublicAccountImageView.this.H[0]) - width)) - fArr[2] : f16;
        }

        private float c(float[] fArr, float f16) {
            float height = PublicAccountImageView.this.getHeight();
            float f17 = PublicAccountImageView.this.f79718h * fArr[4];
            PublicAccountImageView publicAccountImageView = PublicAccountImageView.this;
            if (f17 / publicAccountImageView.H[4] < height) {
                return 0.0f;
            }
            float f18 = fArr[5];
            if (f18 + f16 > 0.0f) {
                return -f18;
            }
            float f19 = f18 + f16;
            float f26 = publicAccountImageView.f79718h * fArr[4];
            PublicAccountImageView publicAccountImageView2 = PublicAccountImageView.this;
            return f19 < (-((f26 / publicAccountImageView2.H[4]) - height)) ? (-(((publicAccountImageView2.f79718h * fArr[4]) / PublicAccountImageView.this.H[4]) - height)) - fArr[5] : f16;
        }

        private void f() {
            PublicAccountImageView publicAccountImageView = PublicAccountImageView.this;
            float f16 = publicAccountImageView.E / publicAccountImageView.D;
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageView", 2, "back scale is" + f16);
            }
            this.f79725f.postScale(f16, f16, PublicAccountImageView.this.getWidth() / 2, PublicAccountImageView.this.getHeight() / 2);
            PublicAccountImageView.this.setImageMatrix(this.f79725f);
        }

        private void g() {
            if (PublicAccountImageView.this.getScaleType() != ImageView.ScaleType.CENTER) {
                PublicAccountImageView.this.setScaleType(ImageView.ScaleType.MATRIX);
            } else {
                this.f79723d = 3;
            }
        }

        private void i() {
            if (d()) {
                this.f79725f.set(PublicAccountImageView.this.f79716e);
                PublicAccountImageView.this.setImageMatrix(this.f79725f);
                PublicAccountImageView.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }

        private void k(MotionEvent motionEvent) {
            if (motionEvent.getPointerCount() < 2) {
                return;
            }
            float e16 = e(motionEvent);
            if (e16 > 10.0f) {
                float f16 = e16 / this.f79724e;
                this.f79724e = e16;
                PublicAccountImageView publicAccountImageView = PublicAccountImageView.this;
                publicAccountImageView.F = false;
                publicAccountImageView.G = false;
                this.f79725f.set(publicAccountImageView.getImageMatrix());
                float[] fArr = new float[9];
                this.f79725f.getValues(fArr);
                float f17 = fArr[0];
                float f18 = PublicAccountImageView.this.f79719i;
                PublicAccountImageView publicAccountImageView2 = PublicAccountImageView.this;
                if (f17 > f18 * publicAccountImageView2.D) {
                    publicAccountImageView2.F = true;
                    f16 = 1.0f;
                } else if (fArr[0] < publicAccountImageView2.f79719i) {
                    PublicAccountImageView.this.G = true;
                }
                this.f79725f.postScale(f16, f16, PublicAccountImageView.this.getWidth() / 2, PublicAccountImageView.this.getHeight() / 2);
                if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountImageView", 2, "the current scale is" + f16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountImageView", 2, "scale of x is" + fArr[0]);
                }
                PublicAccountImageView.this.setImageMatrix(this.f79725f);
            }
        }

        private void l() {
            PublicAccountImageView.h(PublicAccountImageView.this);
        }

        private void m() {
            PublicAccountImageView.h(PublicAccountImageView.this);
        }

        public void j(MotionEvent motionEvent) {
            if (h()) {
                float x16 = motionEvent.getX() - this.C.x;
                float y16 = motionEvent.getY() - this.C.y;
                if (Math.sqrt((x16 * x16) + (y16 * y16)) > 10.0d) {
                    this.C.set(motionEvent.getX(), motionEvent.getY());
                    this.f79725f.set(PublicAccountImageView.this.getImageMatrix());
                    float[] fArr = new float[9];
                    this.f79725f.getValues(fArr);
                    this.f79725f.postTranslate(b(fArr, x16), c(fArr, y16));
                    PublicAccountImageView.this.setImageMatrix(this.f79725f);
                    return;
                }
                return;
            }
            m();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f79723d = 1;
                this.C.set(motionEvent.getX(), motionEvent.getY());
                g();
                l();
                a();
            } else if (actionMasked == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountImageView", 2, "the current state is action up");
                }
                PublicAccountImageView publicAccountImageView = PublicAccountImageView.this;
                if (publicAccountImageView.F) {
                    f();
                    PublicAccountImageView.this.F = false;
                } else if (publicAccountImageView.G) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PublicAccountImageView", 2, "back to init matrix");
                    }
                    PublicAccountImageView publicAccountImageView2 = PublicAccountImageView.this;
                    publicAccountImageView2.setImageMatrix(publicAccountImageView2.f79716e);
                    PublicAccountImageView.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            } else if (actionMasked == 2) {
                int i3 = this.f79723d;
                if (i3 == 2) {
                    k(motionEvent);
                } else if (i3 == 1) {
                    j(motionEvent);
                } else {
                    m();
                }
            } else if (actionMasked == 3) {
                i();
            } else if (actionMasked == 5) {
                if (this.f79723d == 3) {
                    return true;
                }
                this.f79723d = 2;
                this.f79724e = e(motionEvent);
            }
            return PublicAccountImageView.this.f79715d.onTouchEvent(motionEvent);
        }

        private void a() {
            this.f79726h = true;
            this.f79727i = true;
            this.f79728m = true;
            float[] fArr = new float[9];
            PublicAccountImageView.this.getImageMatrix().getValues(fArr);
            if (fArr[2] >= 0.0f) {
                this.f79727i = false;
            }
            if ((PublicAccountImageView.this.f79717f * fArr[0]) + fArr[2] <= PublicAccountImageView.this.getWidth()) {
                this.f79726h = false;
            }
        }

        private float e(MotionEvent motionEvent) {
            float x16 = motionEvent.getX(1) - motionEvent.getX(0);
            float y16 = motionEvent.getY(1) - motionEvent.getY(0);
            return (float) Math.sqrt((x16 * x16) + (y16 * y16));
        }

        private boolean d() {
            float[] fArr = new float[9];
            PublicAccountImageView.this.getImageMatrix().getValues(fArr);
            return fArr[0] < PublicAccountImageView.this.f79719i;
        }

        private boolean h() {
            float[] fArr = new float[9];
            PublicAccountImageView.this.getImageMatrix().getValues(fArr);
            return fArr[0] != PublicAccountImageView.this.f79719i;
        }
    }

    /* loaded from: classes32.dex */
    public interface c {
    }

    public PublicAccountImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f79716e = new Matrix();
        this.F = false;
        this.G = false;
        this.H = new float[9];
        this.f79720m = context;
        b bVar = new b();
        setOnTouchListener(bVar);
        this.f79715d = new GestureDetector(getContext(), new a(bVar));
        setBackgroundColor(-16777216);
        setScaleType(ImageView.ScaleType.MATRIX);
        k();
    }

    static /* bridge */ /* synthetic */ c h(PublicAccountImageView publicAccountImageView) {
        publicAccountImageView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (PublicAccountImageCollectionMainActivityImpl.doubleTapFlag) {
            this.C.sendEmptyMessage(2);
        } else {
            this.C.sendEmptyMessage(1);
        }
    }

    private void k() {
        float[] fArr = new float[9];
        this.f79716e.getValues(fArr);
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageView", 2, "image height is" + this.f79718h);
            QLog.d("PublicAccountImageView", 2, "image width is" + this.f79717f);
        }
        this.f79719i = fArr[0];
        this.D = 5.5f;
        this.E = 5.0f;
    }

    public PublicAccountImageView(Context context, Handler handler, Matrix matrix, int i3, int i16, int i17) {
        super(context, null);
        this.f79716e = new Matrix();
        this.F = false;
        this.G = false;
        this.H = new float[9];
        this.f79720m = context;
        b bVar = new b();
        setOnTouchListener(bVar);
        this.f79715d = new GestureDetector(getContext(), new a(bVar));
        setBackgroundColor(-16777216);
        if (i3 == 1) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            setScaleType(ImageView.ScaleType.MATRIX);
        }
        this.f79716e.set(matrix);
        this.f79716e.getValues(this.H);
        this.C = handler;
        this.f79718h = i17;
        this.f79717f = i16;
        k();
    }
}
