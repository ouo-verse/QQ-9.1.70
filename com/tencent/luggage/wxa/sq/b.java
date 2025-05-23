package com.tencent.luggage.wxa.sq;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC6726b f140582a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f140583b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f140584c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f140585d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f140586e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f140587f;

    /* renamed from: g, reason: collision with root package name */
    public float f140588g;

    /* renamed from: h, reason: collision with root package name */
    public float f140589h;

    /* renamed from: i, reason: collision with root package name */
    public float f140590i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.f140587f = false;
                b.this.f140588g = motionEvent.getX();
                if (b.this.f140582a != null) {
                    b.this.f140582a.a();
                }
            } else if (motionEvent.getAction() == 2) {
                float width = b.this.f140583b.getWidth() + (motionEvent.getX() - b.this.f140588g);
                if (width < 0.0f) {
                    width = 0.0f;
                } else if (width > b.this.f140584c.getWidth()) {
                    width = b.this.f140584c.getWidth();
                }
                b.this.f140589h = (width * 100.0f) / r4.f140584c.getWidth();
                b bVar = b.this;
                bVar.a(bVar.f140589h, true);
                if (b.this.f140582a != null) {
                    b.this.f140582a.a();
                }
                b.this.f140587f = true;
            } else {
                if (b.this.f140587f && b.this.f140582a != null) {
                    b.this.f140582a.a(b.this.f140589h, true);
                }
                b.this.f140587f = false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sq.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6726b {
        void a();

        void a(float f16, boolean z16);
    }

    public b(View view) {
        this.f140583b = (ImageView) view.findViewById(R.id.f25900c3);
        this.f140585d = (ImageView) view.findViewById(R.id.f25910c4);
        this.f140584c = (ImageView) view.findViewById(R.id.f25890c2);
        ImageView imageView = (ImageView) view.findViewById(R.id.f25920c5);
        this.f140586e = imageView;
        imageView.setOnTouchListener(new a());
    }

    public void a(InterfaceC6726b interfaceC6726b) {
        this.f140582a = interfaceC6726b;
    }

    public float a() {
        return this.f140590i;
    }

    public void a(float f16, boolean z16) {
        if ((this.f140587f && !z16) || this.f140586e == null || this.f140584c.getWidth() == 0) {
            return;
        }
        if (f16 < 0.0f) {
            f16 = 0.0f;
        } else if (f16 > 100.0f) {
            f16 = 100.0f;
        }
        this.f140590i = f16;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f140583b.getLayoutParams();
        layoutParams.width = (int) ((f16 / 100.0f) * this.f140584c.getWidth());
        this.f140583b.setLayoutParams(layoutParams);
        this.f140583b.requestLayout();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f140586e.getLayoutParams();
        layoutParams2.leftMargin = a(f16);
        this.f140586e.setLayoutParams(layoutParams2);
        this.f140586e.requestLayout();
    }

    public int a(float f16) {
        int width = this.f140584c.getWidth();
        if (f16 <= 0.0f) {
            return 0;
        }
        if (f16 >= 100.0f) {
            return width - (((this.f140586e.getWidth() - this.f140586e.getPaddingLeft()) - this.f140586e.getPaddingRight()) / 2);
        }
        return (int) ((f16 / 100.0f) * (width - (((this.f140586e.getWidth() - this.f140586e.getPaddingLeft()) - this.f140586e.getPaddingRight()) / 2)));
    }

    public void a(double d16, double[] dArr) {
        double d17 = 0.0d;
        for (int i3 = 0; i3 < dArr.length; i3 += 2) {
            int i16 = i3 + 1;
            if (dArr.length > i16) {
                double d18 = (dArr[i3] / d16) * 100.0d;
                double d19 = this.f140590i;
                if (d18 <= d19) {
                    double d26 = (dArr[i16] / d16) * 100.0d;
                    if (d26 > d19) {
                        d17 = d26;
                    }
                }
            }
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f140585d.getLayoutParams();
        layoutParams.width = (int) ((d17 / 100.0d) * this.f140584c.getWidth());
        this.f140585d.setLayoutParams(layoutParams);
        this.f140585d.requestLayout();
    }
}
