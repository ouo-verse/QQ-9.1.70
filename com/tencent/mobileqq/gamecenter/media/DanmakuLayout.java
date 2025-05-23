package com.tencent.mobileqq.gamecenter.media;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.util.Pools;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DanmakuLayout extends ViewGroup {
    private long C;
    private int D;
    private Pools.Pool<a> E;
    private Runnable F;

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.mobileqq.gamecenter.media.a> f212165d;

    /* renamed from: e, reason: collision with root package name */
    private c[] f212166e;

    /* renamed from: f, reason: collision with root package name */
    private float f212167f;

    /* renamed from: h, reason: collision with root package name */
    private int f212168h;

    /* renamed from: i, reason: collision with root package name */
    private int f212169i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.media.b f212170m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        com.tencent.mobileqq.gamecenter.media.a f212171a;

        /* renamed from: d, reason: collision with root package name */
        float f212174d;

        /* renamed from: e, reason: collision with root package name */
        int f212175e;

        /* renamed from: f, reason: collision with root package name */
        float f212176f;

        /* renamed from: g, reason: collision with root package name */
        long f212177g;

        /* renamed from: k, reason: collision with root package name */
        TextView f212181k;

        /* renamed from: b, reason: collision with root package name */
        long f212172b = -1;

        /* renamed from: c, reason: collision with root package name */
        boolean f212173c = true;

        /* renamed from: h, reason: collision with root package name */
        int f212178h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f212179i = 0;

        /* renamed from: j, reason: collision with root package name */
        float f212180j = 0.0f;

        a() {
            TextView textView = new TextView(DanmakuLayout.this.getContext());
            this.f212181k = textView;
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }

        private long b(float f16) {
            if (f16 < 40.0f) {
                return 4000L;
            }
            if (f16 <= 50.0f) {
                return 4500L;
            }
            if (f16 <= 130.0f) {
                return 5000L;
            }
            return 6000L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (this.f212176f == 0.0f) {
                this.f212181k.setText(new QQText(this.f212171a.f212194a, 3, 16, -1));
                this.f212181k.measure(0, 0);
                this.f212178h = this.f212181k.getMeasuredWidth();
                this.f212179i = this.f212181k.getMeasuredHeight();
                this.f212180j = this.f212178h + DanmakuLayout.this.D;
                double d16 = this.f212171a.f212197d;
                if (d16 == 0.0d) {
                    this.f212177g = b(this.f212178h);
                } else {
                    this.f212177g = (long) (d16 * 1000.0d);
                }
                this.f212176f = this.f212180j / ((float) this.f212177g);
            }
        }

        void d() {
            this.f212171a = null;
            this.f212172b = -1L;
            this.f212173c = false;
            this.f212174d = 0.0f;
            this.f212175e = 0;
            this.f212176f = 0.0f;
            this.f212177g = 0L;
            this.f212178h = 0;
            this.f212179i = 0;
            this.f212180j = 0.0f;
            this.f212181k.setText("");
            this.f212181k.setBackgroundDrawable(null);
            if (this.f212181k.getParent() != null) {
                DanmakuLayout.this.removeView(this.f212181k);
            }
            DanmakuLayout.this.E.release(this);
        }

        void e(com.tencent.mobileqq.gamecenter.media.a aVar) {
            this.f212171a = aVar;
            this.f212181k.setTextSize(0, DanmakuLayout.this.f212167f);
            int i3 = this.f212171a.f212199f;
            if (i3 != 0) {
                this.f212181k.setBackgroundColor(i3);
            }
            this.f212181k.setTextColor(this.f212171a.f212198e);
        }

        boolean f(long j3, int i3) {
            float f16;
            boolean z16;
            if (this.f212172b == -1) {
                this.f212172b = j3;
            }
            c();
            long j16 = this.f212177g;
            if (j16 != 0) {
                f16 = ((float) (j3 - this.f212172b)) / ((float) j16);
            } else if (j3 < this.f212172b) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            if (f16 >= 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f212173c = !z16;
            this.f212174d = this.f212180j * Math.max(Math.min(f16, 1.0f), 0.0f);
            int i16 = (int) (DanmakuLayout.this.D - this.f212174d);
            this.f212175e = i16;
            this.f212181k.layout(i16, i3, this.f212178h + i16, this.f212179i + i3);
            return this.f212173c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public abstract class b {

        /* renamed from: a, reason: collision with root package name */
        int f212183a;

        /* renamed from: b, reason: collision with root package name */
        int f212184b;

        /* renamed from: c, reason: collision with root package name */
        int f212185c;

        /* renamed from: d, reason: collision with root package name */
        int f212186d;

        b() {
        }

        void a(int i3, int i16, int i17, int i18) {
            this.f212183a = i3;
            this.f212184b = i16;
            this.f212185c = i17;
            this.f212186d = i18;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends b {

        /* renamed from: f, reason: collision with root package name */
        private List<a> f212188f;

        c() {
            super();
            this.f212188f = new ArrayList();
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x004e, code lost:
        
            if (((r0.f212174d - r0.f212178h) / (r2 - r3)) <= (((r10.f212189g.D + r0.f212178h) - r0.f212174d) / r0.f212176f)) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean b(a aVar) {
            boolean z16 = true;
            if (d()) {
                List<a> list = this.f212188f;
                a aVar2 = list.get(list.size() - 1);
                if (aVar2.f212174d > aVar2.f212178h + 40 + (Math.random() * 40.0d)) {
                    aVar.c();
                    float f16 = aVar.f212176f;
                    float f17 = aVar2.f212176f;
                    if (f16 >= f17) {
                    }
                }
                z16 = false;
            }
            if (z16) {
                this.f212188f.add(aVar);
                if (aVar.f212181k.getParent() == null) {
                    DanmakuLayout.this.addView(aVar.f212181k);
                }
            }
            return z16;
        }

        boolean c() {
            boolean z16;
            if (this.f212188f.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Iterator<a> it = this.f212188f.iterator();
                while (it.hasNext()) {
                    it.next().d();
                    it.remove();
                }
            }
            return z16;
        }

        boolean d() {
            if (this.f212188f.size() > 0) {
                return true;
            }
            return false;
        }

        void e(long j3) {
            if (this.f212188f.size() > 0) {
                Iterator<a> it = this.f212188f.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (!next.f(j3, this.f212184b)) {
                        next.d();
                        it.remove();
                    }
                }
            }
        }
    }

    public DanmakuLayout(Context context) {
        super(context);
        this.f212165d = new LinkedList();
        this.f212167f = 50.0f;
        this.f212168h = 9;
        this.E = new Pools.SimplePool(20);
        this.F = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.media.DanmakuLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuLayout.this.o() && DanmakuLayout.this.f212170m != null) {
                    long time = DanmakuLayout.this.f212170m.getTime();
                    if (DanmakuLayout.this.f212165d.size() > 0) {
                        boolean z16 = false;
                        com.tencent.mobileqq.gamecenter.media.a aVar = (com.tencent.mobileqq.gamecenter.media.a) DanmakuLayout.this.f212165d.get(0);
                        long j3 = aVar.f212196c;
                        if (j3 <= time) {
                            a p16 = DanmakuLayout.this.p();
                            p16.e(aVar);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= DanmakuLayout.this.f212166e.length) {
                                    break;
                                }
                                if (DanmakuLayout.this.f212166e[i3].b(p16)) {
                                    DanmakuLayout.this.f212165d.remove(0);
                                    DanmakuLayout.this.invalidate();
                                    z16 = true;
                                    break;
                                }
                                i3++;
                            }
                            if (!z16) {
                                p16.d();
                            }
                            if (DanmakuLayout.this.f212165d.size() > 0) {
                                DanmakuLayout danmakuLayout = DanmakuLayout.this;
                                danmakuLayout.n(danmakuLayout.C);
                                return;
                            }
                            return;
                        }
                        DanmakuLayout.this.n(Math.max(j3 - time, DanmakuLayout.this.C));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j3) {
        if (removeCallbacks(this.F)) {
            postDelayed(this.F, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        if (this.f212166e != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a p() {
        a acquire = this.E.acquire();
        if (acquire == null) {
            return new a();
        }
        return acquire;
    }

    private void q() {
        m();
        this.D = (getWidth() - getPaddingLeft()) - getPaddingRight();
        a p16 = p();
        p16.e(new com.tencent.mobileqq.gamecenter.media.a("", 0.0d));
        p16.c();
        this.f212169i = p16.f212179i;
        p16.d();
        this.f212166e = new c[((getHeight() - getPaddingTop()) - getPaddingBottom()) / (this.f212169i + this.f212168h)];
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i3 = 0;
        while (true) {
            c[] cVarArr = this.f212166e;
            if (i3 < cVarArr.length) {
                cVarArr[i3] = new c();
                this.f212166e[i3].a(paddingLeft, paddingTop, getWidth() - getPaddingRight(), this.f212169i + paddingTop);
                paddingTop += this.f212169i + this.f212168h;
                i3++;
            } else {
                invalidate();
                n(0L);
                return;
            }
        }
    }

    private boolean r() {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i3 = 0;
        boolean z16 = false;
        while (true) {
            c[] cVarArr = this.f212166e;
            if (i3 < cVarArr.length) {
                c cVar = cVarArr[i3];
                if (cVar.d()) {
                    this.f212166e[i3].e(uptimeMillis);
                    z16 |= cVar.d();
                }
                i3++;
            } else {
                return z16;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!o()) {
            return;
        }
        boolean r16 = r();
        super.dispatchDraw(canvas);
        if (r16) {
            invalidate();
        }
    }

    public void k(com.tencent.mobileqq.gamecenter.media.a... aVarArr) {
        if (aVarArr == null) {
            return;
        }
        for (com.tencent.mobileqq.gamecenter.media.a aVar : aVarArr) {
            int i3 = 0;
            while (i3 < this.f212165d.size() && aVar.f212196c >= this.f212165d.get(i3).f212196c) {
                i3++;
            }
            this.f212165d.add(i3, aVar);
        }
        n(this.C);
    }

    public void l() {
        removeCallbacks(this.F);
        this.f212165d.clear();
    }

    public void m() {
        if (o()) {
            int i3 = 0;
            boolean z16 = false;
            while (true) {
                c[] cVarArr = this.f212166e;
                if (i3 >= cVarArr.length) {
                    break;
                }
                z16 |= cVarArr[i3].c();
                i3++;
            }
            if (z16) {
                invalidate();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.F);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        q();
    }

    public void setLineSpacing(int i3) {
        boolean z16;
        if (i3 < 0) {
            return;
        }
        if (this.f212168h != i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f212168h = i3;
        if (z16 && o()) {
            q();
        }
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        boolean z16;
        if (i16 == getPaddingTop() && i18 == getPaddingBottom()) {
            z16 = false;
        } else {
            z16 = true;
        }
        super.setPadding(i3, i16, i17, i18);
        if (z16 && o()) {
            q();
        }
    }

    public void setShown(boolean z16) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    public void setTextSize(float f16) {
        boolean z16;
        if (f16 <= 0.0f) {
            return;
        }
        if (this.f212167f != f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f212167f = f16;
        if (z16 && o()) {
            q();
        }
    }

    public void setTimeSupplier(com.tencent.mobileqq.gamecenter.media.b bVar, long j3) {
        if (bVar != null) {
            this.f212170m = bVar;
            this.C = j3;
            return;
        }
        throw new NullPointerException("timeSupplier must not be null");
    }

    public DanmakuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f212165d = new LinkedList();
        this.f212167f = 50.0f;
        this.f212168h = 9;
        this.E = new Pools.SimplePool(20);
        this.F = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.media.DanmakuLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuLayout.this.o() && DanmakuLayout.this.f212170m != null) {
                    long time = DanmakuLayout.this.f212170m.getTime();
                    if (DanmakuLayout.this.f212165d.size() > 0) {
                        boolean z16 = false;
                        com.tencent.mobileqq.gamecenter.media.a aVar = (com.tencent.mobileqq.gamecenter.media.a) DanmakuLayout.this.f212165d.get(0);
                        long j3 = aVar.f212196c;
                        if (j3 <= time) {
                            a p16 = DanmakuLayout.this.p();
                            p16.e(aVar);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= DanmakuLayout.this.f212166e.length) {
                                    break;
                                }
                                if (DanmakuLayout.this.f212166e[i3].b(p16)) {
                                    DanmakuLayout.this.f212165d.remove(0);
                                    DanmakuLayout.this.invalidate();
                                    z16 = true;
                                    break;
                                }
                                i3++;
                            }
                            if (!z16) {
                                p16.d();
                            }
                            if (DanmakuLayout.this.f212165d.size() > 0) {
                                DanmakuLayout danmakuLayout = DanmakuLayout.this;
                                danmakuLayout.n(danmakuLayout.C);
                                return;
                            }
                            return;
                        }
                        DanmakuLayout.this.n(Math.max(j3 - time, DanmakuLayout.this.C));
                    }
                }
            }
        };
    }

    public DanmakuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f212165d = new LinkedList();
        this.f212167f = 50.0f;
        this.f212168h = 9;
        this.E = new Pools.SimplePool(20);
        this.F = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.media.DanmakuLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuLayout.this.o() && DanmakuLayout.this.f212170m != null) {
                    long time = DanmakuLayout.this.f212170m.getTime();
                    if (DanmakuLayout.this.f212165d.size() > 0) {
                        boolean z16 = false;
                        com.tencent.mobileqq.gamecenter.media.a aVar = (com.tencent.mobileqq.gamecenter.media.a) DanmakuLayout.this.f212165d.get(0);
                        long j3 = aVar.f212196c;
                        if (j3 <= time) {
                            a p16 = DanmakuLayout.this.p();
                            p16.e(aVar);
                            int i36 = 0;
                            while (true) {
                                if (i36 >= DanmakuLayout.this.f212166e.length) {
                                    break;
                                }
                                if (DanmakuLayout.this.f212166e[i36].b(p16)) {
                                    DanmakuLayout.this.f212165d.remove(0);
                                    DanmakuLayout.this.invalidate();
                                    z16 = true;
                                    break;
                                }
                                i36++;
                            }
                            if (!z16) {
                                p16.d();
                            }
                            if (DanmakuLayout.this.f212165d.size() > 0) {
                                DanmakuLayout danmakuLayout = DanmakuLayout.this;
                                danmakuLayout.n(danmakuLayout.C);
                                return;
                            }
                            return;
                        }
                        DanmakuLayout.this.n(Math.max(j3 - time, DanmakuLayout.this.C));
                    }
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
