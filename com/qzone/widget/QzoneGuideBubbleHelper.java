package com.qzone.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.animation.rebound.SimpleSpringListener;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringSystem;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;

/* compiled from: P */
@Deprecated
/* loaded from: classes37.dex */
public class QzoneGuideBubbleHelper {

    /* renamed from: e, reason: collision with root package name */
    private static volatile QzoneGuideBubbleHelper f60559e;

    /* renamed from: a, reason: collision with root package name */
    private QzoneBubblePopWindow f60560a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f60561b = new Handler();

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f60562c = null;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f60563d = new Runnable() { // from class: com.qzone.widget.QzoneGuideBubbleHelper.1
        @Override // java.lang.Runnable
        public void run() {
            QzoneGuideBubbleHelper.this.f();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnTouchListener f60576d;

        c(View.OnTouchListener onTouchListener) {
            this.f60576d = onTouchListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            View.OnTouchListener onTouchListener = this.f60576d;
            if (onTouchListener != null) {
                onTouchListener.onTouch(view, motionEvent);
            }
            QzoneGuideBubbleHelper.this.f();
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f60578a;

        /* renamed from: b, reason: collision with root package name */
        public int f60579b;

        /* renamed from: c, reason: collision with root package name */
        public int f60580c;

        /* renamed from: d, reason: collision with root package name */
        public int f60581d;

        /* renamed from: e, reason: collision with root package name */
        public String f60582e;

        /* renamed from: f, reason: collision with root package name */
        public Drawable f60583f;

        public void a(String str) {
            this.f60582e = str;
        }
    }

    public static QzoneGuideBubbleHelper g() {
        if (f60559e == null) {
            synchronized (QzoneGuideBubbleHelper.class) {
                if (f60559e == null) {
                    f60559e = new QzoneGuideBubbleHelper();
                }
            }
        }
        return f60559e;
    }

    public void f() {
        if (this.f60560a != null) {
            this.f60561b.removeCallbacks(this.f60563d);
            try {
                this.f60560a.dismiss();
                this.f60560a = null;
            } catch (Exception unused) {
            }
        }
    }

    public void i(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, int i17, boolean z16, boolean z17, int i18, d dVar, int i19, boolean z18, float f17, View.OnTouchListener onTouchListener) {
        f();
        if (activity == null || view == null || i3 < 0 || i3 > 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f60562c = new WeakReference<>(activity);
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int[] d18 = d(view, relativeLayout, str, f16, i17, i3, d16, d17, i16, z17, dVar, i19, z18, onTouchListener, true);
        if (d18 == null) {
            return;
        }
        try {
            QzoneBubblePopWindow qzoneBubblePopWindow = this.f60560a;
            int i26 = d18[0] - i19;
            int i27 = d18[1];
            int i28 = i18;
            if (i3 == 0) {
                i28 = -i28;
            }
            qzoneBubblePopWindow.showAtLocation(view, 0, i26, i27 + i28);
            this.f60560a.a(activity, f17);
            int i29 = d18[2];
            int i36 = d18[3];
            Spring createSpring = SpringSystem.create().createSpring();
            createSpring.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(d16, d17)).addListener(new a(relativeLayout, z16, i29, i36, j3));
            createSpring.setEndValue(1.0d);
        } catch (Exception unused) {
        }
    }

    public void q(Activity activity, View view, String str, int i3, float f16, int i16, double d16, double d17, long j3, int i17, boolean z16, boolean z17, int i18, d dVar, int i19, boolean z18, float f17, View.OnTouchListener onTouchListener, boolean z19, boolean z26, boolean z27) {
        QzoneGuideBubbleHelper qzoneGuideBubbleHelper;
        f();
        if (activity == null || view == null || i3 < 0 || i3 > 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f60562c = new WeakReference<>(activity);
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int[] d18 = d(view, relativeLayout, str, f16, i16, i3, d16, d17, i17, z17, dVar, i19, z18, onTouchListener, true);
        if (d18 == null) {
            return;
        }
        try {
            if (z19) {
                qzoneGuideBubbleHelper = this;
                QzoneBubblePopWindow qzoneBubblePopWindow = qzoneGuideBubbleHelper.f60560a;
                int i26 = d18[0] - i19;
                int i27 = d18[1];
                int i28 = i18;
                if (i3 == 0) {
                    i28 = -i28;
                }
                qzoneBubblePopWindow.showAtLocation(view, 0, i26, i27 + i28);
            } else {
                qzoneGuideBubbleHelper = this;
                int i29 = i18;
                QzoneBubblePopWindow qzoneBubblePopWindow2 = qzoneGuideBubbleHelper.f60560a;
                int i36 = d18[0];
                int i37 = d18[1];
                if (i3 == 0) {
                    i29 = -i29;
                }
                qzoneBubblePopWindow2.showAtLocation(view, 0, i36, i37 + i29);
            }
            qzoneGuideBubbleHelper.f60560a.a(activity, f17);
            int i38 = d18[2];
            int i39 = d18[3];
            if (z27) {
                Spring createSpring = SpringSystem.create().createSpring();
                createSpring.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(d16, d17)).addListener(new b(relativeLayout, z16, i38, i39, j3));
                createSpring.setEndValue(1.0d);
            } else if (j3 > 0) {
                qzoneGuideBubbleHelper.f60561b.postDelayed(qzoneGuideBubbleHelper.f60563d, j3);
            }
        } catch (Exception unused) {
        }
    }

    public static ShapeDrawable e(float f16, float f17, int i3) {
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        for (int i16 = 0; i16 < 8; i16++) {
            fArr[i16] = f16 + f17;
            fArr2[i16] = f16;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(f17, f17, f17, f17), fArr2));
        shapeDrawable.getPaint().setColor(i3);
        return shapeDrawable;
    }

    private static Rect h(View view) {
        if (view == null) {
            return new Rect();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect = new Rect();
        int i3 = iArr[0];
        rect.left = i3;
        int i16 = iArr[1];
        rect.top = i16;
        rect.right = i3 + measuredWidth;
        rect.bottom = i16 + measuredHeight;
        return rect;
    }

    private int[] d(View view, ViewGroup viewGroup, String str, float f16, int i3, int i16, double d16, double d17, int i17, boolean z16, d dVar, int i18, boolean z17, View.OnTouchListener onTouchListener, boolean z18) {
        QzoneBubblePopWindow qzoneBubblePopWindow;
        WeakReference<Context> weakReference;
        if (this.f60560a == null && (weakReference = this.f60562c) != null && weakReference.get() != null) {
            QzoneBubblePopWindow qzoneBubblePopWindow2 = new QzoneBubblePopWindow(this.f60562c.get());
            this.f60560a = qzoneBubblePopWindow2;
            qzoneBubblePopWindow2.setWidth(-2);
            this.f60560a.setHeight(-2);
            this.f60560a.setTouchable(z16);
            if (z16) {
                viewGroup.setOnTouchListener(new c(onTouchListener));
            }
            this.f60560a.setOutsideTouchable(z16);
            this.f60560a.setBackgroundDrawable(new ColorDrawable(0));
        }
        int[] c16 = c(viewGroup, view, str, f16, i3, i16, i17, dVar, i18, z17, true);
        if (c16 != null && (qzoneBubblePopWindow = this.f60560a) != null) {
            qzoneBubblePopWindow.setContentView(viewGroup);
            this.f60560a.update();
        }
        return c16;
    }

    private int[] c(ViewGroup viewGroup, View view, String str, float f16, int i3, int i16, int i17, d dVar, int i18, boolean z16, boolean z17) {
        int i19;
        int i26;
        int i27;
        WeakReference<Context> weakReference = this.f60562c;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        Rect h16 = h(view);
        if (h16.left <= 0 && h16.right <= 0 && h16.top <= 0 && h16.bottom <= 0) {
            return null;
        }
        TextView textView = new TextView(this.f60562c.get());
        textView.setId(R.id.hjb);
        textView.setTextColor(i3);
        textView.setTextSize(f16);
        textView.setText(str);
        int dimensionPixelSize = this.f60562c.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.apq);
        if (dVar != null) {
            Drawable drawable = dVar.f60583f;
            if (drawable == null) {
                drawable = this.f60562c.get().getResources().getDrawable(dVar.f60578a);
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, dVar.f60579b, dVar.f60580c);
                textView.setCompoundDrawables(drawable, null, null, null);
                textView.setCompoundDrawablePadding(dVar.f60581d);
            }
        }
        if (z16) {
            i19 = this.f60562c.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.aps);
            i26 = this.f60562c.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.apr);
        } else {
            i19 = 0;
            i26 = 0;
        }
        textView.setPadding(i26, i19, i26, i19);
        textView.setGravity(17);
        int dimensionPixelSize2 = this.f60562c.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.apt);
        if (!z17) {
            ar.t(textView, e(0.0f, 0.0f, i17));
        } else {
            ar.t(textView, e(dimensionPixelSize2, 0.0f, i17));
        }
        View triangleView = new TriangleView(this.f60562c.get(), i16, i17);
        triangleView.setId(R.id.hj_);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int dimensionPixelSize3 = this.f60562c.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.app);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize3, this.f60562c.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.apo));
        if (i16 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams2.addRule(3, R.id.hjb);
            layoutParams2.leftMargin = i18;
        } else if (i16 == 1) {
            layoutParams.addRule(14);
            layoutParams.addRule(3, R.id.hj_);
            layoutParams2.leftMargin = i18;
        }
        viewGroup.addView(textView, layoutParams);
        viewGroup.addView(triangleView, layoutParams2);
        viewGroup.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        int i28 = h16.left;
        int i29 = (i28 + ((h16.right - i28) / 2)) - (measuredWidth / 2);
        if (i16 == 0) {
            i27 = (h16.top - measuredHeight) - dimensionPixelSize;
        } else {
            i27 = h16.bottom + dimensionPixelSize;
            measuredHeight = 0;
        }
        int o16 = pl.a.f426446a.o(BaseApplicationImpl.getApplication());
        int e16 = ar.e(12.0f);
        if (i29 < e16) {
            i29 = e16;
        } else {
            int i36 = (o16 - measuredWidth) - e16;
            if (i29 > i36) {
                i29 = i36;
            }
        }
        int i37 = h16.left;
        int i38 = (i37 - i29) + (((h16.right - i37) - dimensionPixelSize3) / 2);
        if (i38 >= dimensionPixelSize2) {
            int i39 = measuredWidth - dimensionPixelSize2;
            dimensionPixelSize2 = i38 + dimensionPixelSize3 > i39 ? i39 - dimensionPixelSize3 : i38;
        }
        com.tencent.mobileqq.businessCard.helpers.b.g(triangleView, dimensionPixelSize2);
        return new int[]{i29, i27, dimensionPixelSize2, measuredHeight};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends SimpleSpringListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f60564a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f60565b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f60566c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f60567d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f60568e;

        a(RelativeLayout relativeLayout, boolean z16, int i3, int i16, long j3) {
            this.f60564a = relativeLayout;
            this.f60565b = z16;
            this.f60566c = i3;
            this.f60567d = i16;
            this.f60568e = j3;
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringActivate(Spring spring) {
            this.f60564a.setVisibility(0);
            if (this.f60565b) {
                com.tencent.mobileqq.businessCard.helpers.b.b(this.f60564a, this.f60566c);
                com.tencent.mobileqq.businessCard.helpers.b.c(this.f60564a, this.f60567d);
            }
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringEndStateChange(Spring spring) {
            if (this.f60568e > 0) {
                QzoneGuideBubbleHelper.this.f60561b.postDelayed(QzoneGuideBubbleHelper.this.f60563d, this.f60568e);
            }
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            float currentValue = (float) spring.getCurrentValue();
            com.tencent.mobileqq.businessCard.helpers.b.d(this.f60564a, currentValue);
            com.tencent.mobileqq.businessCard.helpers.b.e(this.f60564a, currentValue);
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringAtRest(Spring spring) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends SimpleSpringListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f60570a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f60571b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f60572c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f60573d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f60574e;

        b(RelativeLayout relativeLayout, boolean z16, int i3, int i16, long j3) {
            this.f60570a = relativeLayout;
            this.f60571b = z16;
            this.f60572c = i3;
            this.f60573d = i16;
            this.f60574e = j3;
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringActivate(Spring spring) {
            this.f60570a.setVisibility(0);
            if (this.f60571b) {
                com.tencent.mobileqq.businessCard.helpers.b.b(this.f60570a, this.f60572c);
                com.tencent.mobileqq.businessCard.helpers.b.c(this.f60570a, this.f60573d);
            }
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringEndStateChange(Spring spring) {
            if (this.f60574e > 0) {
                QzoneGuideBubbleHelper.this.f60561b.postDelayed(QzoneGuideBubbleHelper.this.f60563d, this.f60574e);
            }
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            float currentValue = (float) spring.getCurrentValue();
            com.tencent.mobileqq.businessCard.helpers.b.d(this.f60570a, currentValue);
            com.tencent.mobileqq.businessCard.helpers.b.e(this.f60570a, currentValue);
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringAtRest(Spring spring) {
        }
    }

    public void j(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, boolean z16, boolean z17) {
        k(activity, view, str, i3, f16, d16, d17, j3, i16, z16, z17, 0);
    }

    public void k(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, boolean z16, boolean z17, int i17) {
        l(activity, view, str, i3, f16, d16, d17, j3, i16, z16, z17, i17, null);
    }

    public void l(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, boolean z16, boolean z17, int i17, d dVar) {
        m(activity, view, str, i3, f16, d16, d17, j3, i16, z16, z17, 0, dVar, 0);
    }

    public void m(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, boolean z16, boolean z17, int i17, d dVar, int i18) {
        n(activity, view, str, i3, f16, d16, d17, j3, i16, z16, z17, i17, dVar, i18, true, 1.0f, null);
    }

    public void n(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, boolean z16, boolean z17, int i17, d dVar, int i18, boolean z18, float f17, View.OnTouchListener onTouchListener) {
        i(activity, view, str, i3, f16, d16, d17, j3, i16, -1, z16, z17, i17, dVar, i18, z18, f17, onTouchListener);
    }

    public void o(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, boolean z16, boolean z17, int i17, d dVar, int i18, boolean z18, float f17, View.OnTouchListener onTouchListener, boolean z19, int i19, boolean z26) {
        p(activity, view, str, i3, f16, i19, d16, d17, j3, i16, z16, z17, i17, dVar, i18, z18, f17, onTouchListener, z19, true);
    }

    public void p(Activity activity, View view, String str, int i3, float f16, int i16, double d16, double d17, long j3, int i17, boolean z16, boolean z17, int i18, d dVar, int i19, boolean z18, float f17, View.OnTouchListener onTouchListener, boolean z19, boolean z26) {
        q(activity, view, str, i3, f16, i16, d16, d17, j3, i17, z16, z17, i18, dVar, i19, z18, f17, onTouchListener, z19, z26, true);
    }
}
