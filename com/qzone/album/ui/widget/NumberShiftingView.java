package com.qzone.album.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NumberShiftingView extends View implements View.OnClickListener {
    private float C;
    private float D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private Typeface J;
    private int K;
    private int L;
    private int M;
    private String N;
    private int P;
    private int Q;
    private ValueAnimator R;
    private boolean S;
    private int T;
    private String U;
    private String V;
    private ArrayList<c> W;

    /* renamed from: a0, reason: collision with root package name */
    private ArrayList<c> f44204a0;

    /* renamed from: b0, reason: collision with root package name */
    private ArrayList<c> f44205b0;

    /* renamed from: c0, reason: collision with root package name */
    private ArrayList<Integer> f44206c0;

    /* renamed from: d, reason: collision with root package name */
    private Paint f44207d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f44208d0;

    /* renamed from: e, reason: collision with root package name */
    private Paint f44209e;

    /* renamed from: e0, reason: collision with root package name */
    private Rect f44210e0;

    /* renamed from: f, reason: collision with root package name */
    private int f44211f;

    /* renamed from: h, reason: collision with root package name */
    private int f44212h;

    /* renamed from: i, reason: collision with root package name */
    private float f44213i;

    /* renamed from: m, reason: collision with root package name */
    private float f44214m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NumberShiftingView.this.z(Integer.valueOf(valueAnimator.getAnimatedValue().toString()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f44216d;

        b(int i3) {
            this.f44216d = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            NumberShiftingView.this.v(this.f44216d);
            NumberShiftingView.this.S = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            NumberShiftingView.this.S = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float f44218a;

        /* renamed from: b, reason: collision with root package name */
        public float f44219b;

        /* renamed from: c, reason: collision with root package name */
        public String f44220c;

        /* renamed from: d, reason: collision with root package name */
        public int f44221d;

        /* renamed from: e, reason: collision with root package name */
        boolean f44222e;
    }

    public NumberShiftingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44211f = -1;
        this.f44212h = -1;
        this.f44213i = -1.0f;
        this.f44214m = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = false;
        this.F = -1;
        this.G = -1;
        this.H = 32;
        this.I = -16777216;
        this.J = Typeface.DEFAULT;
        this.K = 550;
        this.L = 200;
        this.M = 10000;
        this.N = "w+";
        this.P = 1;
        this.Q = 0;
        this.S = false;
        this.V = null;
        this.f44208d0 = false;
        n();
    }

    private void d() {
        int i3;
        if (this.f44211f == -1 || (i3 = this.f44212h) == -1 || this.f44214m == -1.0f) {
            this.D = -1.0f;
            return;
        }
        if (this.D != -1.0f) {
            return;
        }
        float f16 = this.C;
        if (f16 != -1.0f) {
            this.D = ((f16 * 3.0f) - i3) + 5.0f;
        } else {
            this.D = -1.0f;
        }
    }

    private void e() {
        if (this.f44211f != -1 && this.f44212h != -1) {
            Paint paint = this.f44207d;
            String str = this.U;
            paint.getTextBounds(str, 0, str.length(), this.f44210e0);
            Rect rect = this.f44210e0;
            this.f44214m = rect.height();
            this.C = ((this.f44212h / 2.0f) + (this.f44210e0.height() / 2.0f)) - rect.bottom;
            return;
        }
        this.C = -1.0f;
    }

    private void g() {
        int i3;
        int i16 = this.M;
        if (i16 == 0 || (i3 = this.T) == 0) {
            return;
        }
        this.f44208d0 = i3 / i16 > 0;
    }

    private ArrayList<c> i() {
        ArrayList<c> arrayList = new ArrayList<>();
        int i3 = this.M;
        if (i3 == 0) {
            return arrayList;
        }
        if (this.f44208d0) {
            String str = String.valueOf(this.T / i3) + this.N;
            c cVar = new c();
            cVar.f44221d = 255;
            cVar.f44220c = str;
            cVar.f44218a = 0.0f;
            cVar.f44219b = 0.0f;
            cVar.f44222e = false;
            this.U = str;
            arrayList.add(cVar);
        } else {
            String valueOf = String.valueOf(this.T);
            if (valueOf != null && !valueOf.equals("") && valueOf.length() > 0) {
                this.U = valueOf;
                for (int i16 = 0; i16 < valueOf.length(); i16++) {
                    c cVar2 = new c();
                    cVar2.f44220c = String.valueOf(valueOf.charAt(i16));
                    cVar2.f44221d = 255;
                    cVar2.f44218a = 0.0f;
                    cVar2.f44219b = 0.0f;
                    cVar2.f44222e = false;
                    arrayList.add(cVar2);
                }
            }
        }
        return arrayList;
    }

    private void n() {
        Paint paint = new Paint(1);
        this.f44209e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f44209e.setTextAlign(Paint.Align.CENTER);
        this.f44209e.setAlpha(0);
        this.f44209e.setTextSize(this.H);
        Paint paint2 = new Paint(1);
        this.f44207d = paint2;
        paint2.setAlpha(255);
        this.f44207d.setStyle(Paint.Style.FILL);
        this.f44207d.setTextAlign(Paint.Align.CENTER);
        this.f44207d.setTextSize(this.H);
        this.f44210e0 = new Rect();
    }

    private void p() {
        String str;
        ArrayList<c> arrayList;
        float f16;
        if (this.f44207d == null || (str = this.U) == null || str.equals("") || (arrayList = this.W) == null || arrayList.size() == 0 || this.f44210e0 == null) {
            return;
        }
        this.f44211f = getWidth();
        this.f44212h = getHeight();
        e();
        if (this.C == -1.0f) {
            return;
        }
        if (!this.f44208d0) {
            float[] f17 = f();
            if (f17 != null && f17.length == 2) {
                float f18 = f17[0];
                float f19 = f17[1];
                for (int i3 = 0; i3 < this.W.size(); i3++) {
                    c cVar = this.W.get(i3);
                    cVar.f44218a = (i3 * f18) + f19;
                    cVar.f44219b = this.C;
                }
            }
        } else {
            c cVar2 = this.W.get(0);
            float measureText = this.f44207d.measureText(cVar2.f44220c);
            cVar2.f44219b = this.C;
            int i16 = this.Q;
            if (i16 == 1) {
                f16 = this.f44211f / 2;
            } else {
                f16 = i16 == 0 ? measureText / 2.0f : this.f44211f - (measureText / 2.0f);
            }
            cVar2.f44218a = f16;
        }
        this.E = true;
    }

    private int q(int i3) {
        String str;
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i16 = this.G;
        if (i16 == Integer.MIN_VALUE) {
            Paint paint = this.f44207d;
            if (paint != null && this.f44210e0 != null && (str = this.U) != null) {
                paint.getTextBounds(str, 0, str.length(), this.f44210e0);
                suggestedMinimumHeight = this.f44210e0.height() * 3;
                if (suggestedMinimumHeight > i3) {
                    return i3;
                }
            }
        } else {
            if (i16 == 1073741824) {
                return i3;
            }
            int i17 = this.f44212h;
            if (i17 > 0) {
                return i17;
            }
        }
        return suggestedMinimumHeight;
    }

    private int r(int i3) {
        float measureText;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int i16 = this.F;
        if (i16 != Integer.MIN_VALUE) {
            if (i16 == 1073741824) {
                return i3;
            }
            int i17 = this.f44211f;
            if (i17 > 0) {
                return i17;
            }
        } else if (this.f44207d != null && this.f44210e0 != null && this.U != null) {
            String str = this.V;
            if (str != null && str.length() > this.U.length()) {
                measureText = this.f44207d.measureText(this.V);
            } else {
                measureText = this.f44207d.measureText(this.U);
            }
            suggestedMinimumWidth = (int) measureText;
            if (suggestedMinimumWidth > i3) {
                return i3;
            }
        }
        return suggestedMinimumWidth;
    }

    private boolean s(float f16, int i3) {
        ArrayList<c> arrayList;
        if (this.W == null || this.f44206c0 == null || (arrayList = this.f44204a0) == null || arrayList.size() == 0 || this.W.size() == 0 || this.f44206c0.size() == 0 || this.C == -1.0f) {
            return false;
        }
        for (int i16 = 0; i16 < this.f44206c0.size(); i16++) {
            c cVar = this.f44204a0.get(this.f44206c0.get(i16).intValue());
            long j3 = this.L * i16;
            int i17 = this.K;
            long j16 = i17 + j3;
            long j17 = i3;
            if (j3 > j17) {
                return true;
            }
            if (j16 >= j17) {
                float f17 = ((float) (j17 - j3)) / i17;
                cVar.f44219b = this.C - (f16 * f17);
                cVar.f44221d = 255 - ((int) (f17 * 255.0f));
            }
        }
        return true;
    }

    private boolean t(float f16, long j3) {
        ArrayList<c> arrayList = this.f44205b0;
        if (arrayList == null || arrayList.size() == 0 || this.D == -1.0f) {
            return false;
        }
        for (int i3 = 0; i3 < this.f44205b0.size(); i3++) {
            c cVar = this.f44205b0.get(i3);
            long j16 = this.L * i3;
            int i16 = this.K;
            long j17 = i16 + j16;
            if (j16 > j3) {
                return true;
            }
            if (j17 >= j3) {
                float f17 = ((float) (j3 - j16)) / i16;
                float f18 = this.D - (f16 * f17);
                cVar.f44219b = f18;
                float f19 = this.C;
                if (f18 - f19 <= 3.0f) {
                    cVar.f44219b = f19;
                }
                cVar.f44221d = (int) (f17 * 255.0f);
            }
        }
        return true;
    }

    private void u() {
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3) {
        ArrayList<c> arrayList;
        this.T = i3;
        this.U = String.valueOf(i3);
        this.V = null;
        if (this.f44204a0 == null || this.f44205b0 == null || this.f44206c0 == null || this.C == -1.0f || this.f44213i == -1.0f || (arrayList = this.W) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.P == 0) {
            w();
        } else {
            x();
        }
        this.f44204a0.clear();
        this.f44205b0.clear();
        this.f44206c0.clear();
        invalidate();
    }

    private void x() {
        c cVar;
        int size = this.f44205b0.size() - this.f44206c0.size();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f44205b0.size(); i3++) {
            if (i3 >= size) {
                cVar = this.f44204a0.get(this.f44206c0.get(i3 - size).intValue());
            } else {
                cVar = new c();
                cVar.f44218a = this.W.get(r5.size() - 1).f44218a + (this.f44213i * (size - i3));
                arrayList.add(0, cVar);
            }
            cVar.f44222e = false;
            cVar.f44221d = 255;
            cVar.f44219b = this.C;
            cVar.f44220c = this.f44205b0.get(i3).f44220c;
        }
        this.W.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i3) {
        ArrayList<c> arrayList;
        ArrayList<c> arrayList2;
        if (this.C == -1.0f || this.D == -1.0f || (arrayList = this.W) == null || arrayList.size() == 0 || (arrayList2 = this.f44205b0) == null || arrayList2.size() == 0) {
            return;
        }
        float f16 = this.D - this.C;
        boolean s16 = s(f16, i3);
        boolean t16 = t(f16, i3);
        if (s16 || t16) {
            invalidate();
        }
    }

    public String m() {
        return this.U;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = getTag();
        if (tag != null && (tag instanceof String)) {
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ArrayList<c> arrayList;
        super.onDraw(canvas);
        if (!this.E) {
            p();
        }
        if (this.f44209e == null || this.f44207d == null || (arrayList = this.W) == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c> it = this.W.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f44222e) {
                this.f44209e.setAlpha(next.f44221d);
                canvas.drawText(next.f44220c, next.f44218a, next.f44219b, this.f44209e);
            } else {
                canvas.drawText(next.f44220c, next.f44218a, next.f44219b, this.f44207d);
            }
        }
        ArrayList<c> arrayList2 = this.f44205b0;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        Iterator<c> it5 = this.f44205b0.iterator();
        while (it5.hasNext()) {
            c next2 = it5.next();
            this.f44209e.setAlpha(next2.f44221d);
            canvas.drawText(next2.f44220c, next2.f44218a, next2.f44219b, this.f44209e);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        this.F = View.MeasureSpec.getMode(i3);
        this.G = View.MeasureSpec.getMode(i16);
        setMeasuredDimension(r(View.MeasureSpec.getSize(i3)), q(View.MeasureSpec.getSize(i16)));
    }

    public void setmAnimationDelay(int i3) {
        this.L = i3;
    }

    public void setmAnimationDuration(int i3) {
        this.K = i3;
    }

    public void setmShresholdText(String str) {
        this.N = str;
    }

    public void setmTextColor(int i3) {
        this.I = i3;
        Paint paint = this.f44209e;
        if (paint == null || this.f44207d == null) {
            return;
        }
        paint.setColor(i3);
        this.f44207d.setColor(i3);
    }

    public void setmTextSize(int i3) {
        this.H = i3;
        Paint paint = this.f44209e;
        if (paint != null && this.f44207d != null) {
            float f16 = i3;
            paint.setTextSize(f16);
            this.f44207d.setTextSize(f16);
        }
        setOnClickListener(this);
    }

    public void setmTypeface(Typeface typeface) {
        this.J = typeface;
    }

    public void y(int i3) {
        ArrayList<c> arrayList;
        if (!this.S && C(i3) && (arrayList = this.f44205b0) != null && arrayList.size() > 0) {
            o(((this.f44205b0.size() - 1) * this.L) + this.K, i3);
            this.R.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float[] f() {
        float f16;
        float f17;
        float f18;
        float[] fArr = new float[2];
        if (this.f44211f == -1 || this.f44212h == -1) {
            return null;
        }
        float measureText = this.f44207d.measureText(this.U) / this.U.length();
        this.f44213i = measureText;
        fArr[0] = measureText;
        float measureText2 = this.f44207d.measureText(this.U);
        int i3 = this.Q;
        if (i3 == 1) {
            f16 = (this.f44211f / 2.0f) - (measureText2 / 2.0f);
            f17 = this.f44213i;
        } else {
            if (i3 == 0) {
                f18 = (this.f44213i / 2.0f) + 0.0f;
                if (f18 >= 0.0f) {
                    fArr[1] = 0.0f;
                } else {
                    fArr[1] = f18;
                }
                return fArr;
            }
            f16 = this.f44211f - measureText2;
            f17 = this.f44213i;
        }
        f18 = f16 + (f17 / 2.0f);
        if (f18 >= 0.0f) {
        }
        return fArr;
    }

    private void o(int i3, int i16) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
        this.R = ofInt;
        ofInt.setTarget(this);
        this.R.setDuration(i3);
        this.R.addUpdateListener(new a());
        this.R.addListener(new b(i16));
    }

    public void B() {
        this.Q = 0;
        this.P = 1;
    }

    private void w() {
        c cVar;
        for (int i3 = 0; i3 < this.f44205b0.size(); i3++) {
            if (i3 < this.f44206c0.size()) {
                cVar = this.f44204a0.get(this.f44206c0.get(i3).intValue());
            } else {
                cVar = new c();
                cVar.f44218a = this.W.get(0).f44218a - this.f44213i;
                this.W.add(0, cVar);
            }
            cVar.f44222e = false;
            cVar.f44221d = 255;
            cVar.f44219b = this.C;
            cVar.f44220c = this.f44205b0.get(i3).f44220c;
        }
    }

    private boolean C(int i3) {
        int i16;
        String str;
        if (i3 >= 0 && i3 != (i16 = this.T)) {
            int i17 = this.M;
            if (!(i17 != 0 && i3 / i17 > 0) && i3 >= i16 && (String.valueOf(i3).length() <= String.valueOf(this.T).length() || this.Q != 1)) {
                ArrayList<c> arrayList = this.W;
                if (arrayList != null && arrayList.size() >= 1 && this.f44207d != null && (str = this.U) != null && !str.equals("") && this.f44210e0 != null) {
                    this.V = String.valueOf(i3);
                    if (this.f44204a0 == null) {
                        this.f44204a0 = new ArrayList<>();
                    }
                    this.f44204a0.clear();
                    for (int size = this.W.size() - 1; size >= 0; size--) {
                        this.f44204a0.add(this.W.get(size));
                    }
                    if (this.f44204a0.size() > 0) {
                        String valueOf = String.valueOf(i3);
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (int length = valueOf.length() - 1; length >= 0; length--) {
                            arrayList2.add(String.valueOf(valueOf.charAt(length)));
                        }
                        this.f44205b0 = j(this.f44204a0, arrayList2);
                        u();
                        return true;
                    }
                }
                return false;
            }
            this.E = false;
            A(i3);
        }
        return false;
    }

    public void A(int i3) {
        if (i3 < 0) {
            return;
        }
        this.T = i3;
        g();
        this.W = i();
        u();
        this.E = false;
        invalidate();
    }

    private ArrayList<c> k(ArrayList<c> arrayList, ArrayList<String> arrayList2) {
        ArrayList<String> arrayList3;
        boolean z16;
        c cVar;
        c cVar2;
        ArrayList<c> arrayList4 = new ArrayList<>();
        int size = arrayList.size() - 1;
        c cVar3 = arrayList.get(arrayList.size() - 1);
        if (arrayList2.size() < arrayList.size()) {
            return null;
        }
        ArrayList<Integer> arrayList5 = this.f44206c0;
        if (arrayList5 != null) {
            arrayList5.clear();
        } else {
            this.f44206c0 = new ArrayList<>();
        }
        boolean z17 = false;
        int i3 = 0;
        while (i3 < arrayList2.size()) {
            if (i3 > size) {
                arrayList3 = arrayList2;
                z16 = true;
                cVar = cVar3;
            } else {
                arrayList3 = arrayList2;
                z16 = z17;
                cVar = arrayList.get(i3);
            }
            String str = arrayList3.get(i3);
            String str2 = cVar.f44220c;
            if (z16) {
                cVar2 = h(true, i3 - size, this.D, cVar, str);
            } else if (str.equals(str2)) {
                cVar2 = null;
            } else {
                cVar2 = h(false, 0, this.D, cVar, str);
                cVar.f44222e = true;
                this.f44206c0.add(Integer.valueOf(i3));
            }
            if (cVar2 != null) {
                arrayList4.add(cVar2);
            }
            i3++;
            z17 = z16;
        }
        return arrayList4;
    }

    private ArrayList<c> l(ArrayList<c> arrayList, ArrayList<String> arrayList2) {
        ArrayList<String> arrayList3;
        c cVar;
        boolean z16;
        c cVar2;
        if (arrayList2.size() < arrayList.size()) {
            return null;
        }
        ArrayList<c> arrayList4 = new ArrayList<>();
        int size = arrayList2.size() - arrayList.size();
        c cVar3 = arrayList.get(0);
        ArrayList<Integer> arrayList5 = this.f44206c0;
        if (arrayList5 != null) {
            arrayList5.clear();
        } else {
            this.f44206c0 = new ArrayList<>();
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (i3 < size) {
                arrayList3 = arrayList2;
                z16 = false;
                cVar = cVar3;
            } else {
                arrayList3 = arrayList2;
                cVar = arrayList.get(i3 - size);
                z16 = true;
            }
            String str = arrayList3.get(i3);
            String str2 = cVar.f44220c;
            if (!z16) {
                cVar2 = h(true, size - i3, this.D, cVar, str);
            } else if (str.equals(str2)) {
                cVar2 = null;
            } else {
                cVar2 = h(false, 0, this.D, cVar, str);
                cVar.f44222e = true;
                this.f44206c0.add(Integer.valueOf(i3 - size));
            }
            if (cVar2 != null) {
                arrayList4.add(cVar2);
            }
        }
        return arrayList4;
    }

    public void setmCountShreshold(int i3) {
        if (i3 == 0) {
            this.M = 10000;
        } else {
            this.M = i3;
        }
    }

    private ArrayList<c> j(ArrayList<c> arrayList, ArrayList<String> arrayList2) {
        if (arrayList == null || arrayList2 == null || arrayList.size() <= 0 || arrayList2.size() <= 0) {
            return null;
        }
        d();
        float f16 = this.D;
        if (f16 == -1.0f) {
            return null;
        }
        if (f16 < 0.0f && f16 != -1.0f) {
            int i3 = this.f44212h;
            if (i3 == -1) {
                return null;
            }
            this.D = i3;
        }
        if (this.P == 0) {
            return k(arrayList, arrayList2);
        }
        return l(arrayList, arrayList2);
    }

    private c h(boolean z16, int i3, float f16, c cVar, String str) {
        float f17;
        if (cVar == null || f16 < 0.0f) {
            return null;
        }
        c cVar2 = new c();
        cVar2.f44219b = f16;
        cVar2.f44221d = 0;
        cVar2.f44220c = str;
        cVar2.f44222e = true;
        if (z16 && i3 > 0) {
            float f18 = this.f44213i;
            if (f18 == -1.0f) {
                return null;
            }
            if (this.P == 0) {
                f17 = cVar.f44218a - (i3 * f18);
            } else {
                f17 = cVar.f44218a + (i3 * f18);
            }
            cVar2.f44218a = f17;
            return cVar2;
        }
        cVar2.f44218a = cVar.f44218a;
        return cVar2;
    }

    public NumberShiftingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f44211f = -1;
        this.f44212h = -1;
        this.f44213i = -1.0f;
        this.f44214m = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = false;
        this.F = -1;
        this.G = -1;
        this.H = 32;
        this.I = -16777216;
        this.J = Typeface.DEFAULT;
        this.K = 550;
        this.L = 200;
        this.M = 10000;
        this.N = "w+";
        this.P = 1;
        this.Q = 0;
        this.S = false;
        this.V = null;
        this.f44208d0 = false;
        n();
    }
}
