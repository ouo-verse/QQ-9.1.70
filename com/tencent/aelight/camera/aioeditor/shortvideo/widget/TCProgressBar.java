package com.tencent.aelight.camera.aioeditor.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class TCProgressBar extends View {
    public Bitmap C;
    public int D;
    Paint E;
    Rect F;
    TouchDelegate G;
    long H;
    float I;
    boolean J;
    int K;
    int L;
    int M;
    int N;
    int P;
    int Q;
    int R;
    int S;
    int T;
    Rect U;
    int V;
    a W;

    /* renamed from: a0, reason: collision with root package name */
    b f67625a0;

    /* renamed from: b0, reason: collision with root package name */
    d f67626b0;

    /* renamed from: c0, reason: collision with root package name */
    ArrayList<d> f67627c0;

    /* renamed from: d, reason: collision with root package name */
    public int f67628d;

    /* renamed from: d0, reason: collision with root package name */
    ArrayList<d> f67629d0;

    /* renamed from: e, reason: collision with root package name */
    public int f67630e;

    /* renamed from: e0, reason: collision with root package name */
    Handler f67631e0;

    /* renamed from: f, reason: collision with root package name */
    public int f67632f;

    /* renamed from: h, reason: collision with root package name */
    boolean f67633h;

    /* renamed from: i, reason: collision with root package name */
    int f67634i;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f67635m;

    /* loaded from: classes32.dex */
    class TimerRefresh implements Runnable {
        TimerRefresh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TCProgressBar tCProgressBar = TCProgressBar.this;
            if (tCProgressBar.f67628d == 3) {
                tCProgressBar.f67631e0.postDelayed(new TimerRefresh(), TCProgressBar.this.f67634i);
                TCProgressBar tCProgressBar2 = TCProgressBar.this;
                tCProgressBar2.W.f67650d = !r1.f67650d;
                tCProgressBar2.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends c {
        a() {
            super();
        }

        @Override // com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar.c
        void a(Canvas canvas) {
            TCProgressBar tCProgressBar = TCProgressBar.this;
            Rect rect = tCProgressBar.U;
            int i3 = this.f67647a;
            rect.left = i3;
            rect.right = i3 + this.f67648b;
            tCProgressBar.E.setColor(tCProgressBar.S);
            TCProgressBar tCProgressBar2 = TCProgressBar.this;
            canvas.drawRect(tCProgressBar2.U, tCProgressBar2.E);
            super.a(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        int f67647a;

        /* renamed from: b, reason: collision with root package name */
        int f67648b;

        /* renamed from: c, reason: collision with root package name */
        boolean f67649c = true;

        /* renamed from: d, reason: collision with root package name */
        boolean f67650d = true;

        /* renamed from: e, reason: collision with root package name */
        boolean f67651e = false;

        c() {
        }

        void a(Canvas canvas) {
            this.f67651e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d extends c {

        /* renamed from: g, reason: collision with root package name */
        boolean f67653g;

        /* renamed from: h, reason: collision with root package name */
        int f67654h;

        /* renamed from: i, reason: collision with root package name */
        int f67655i;

        /* renamed from: j, reason: collision with root package name */
        int f67656j;

        /* renamed from: k, reason: collision with root package name */
        boolean f67657k;

        /* renamed from: l, reason: collision with root package name */
        boolean f67658l;

        /* renamed from: m, reason: collision with root package name */
        boolean f67659m;

        /* renamed from: n, reason: collision with root package name */
        boolean f67660n;

        d(boolean z16) {
            super();
            this.f67659m = false;
            this.f67660n = false;
            this.f67658l = z16;
        }

        @Override // com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar.c
        void a(Canvas canvas) {
            int i3;
            if (this.f67658l) {
                TCProgressBar tCProgressBar = TCProgressBar.this;
                Rect rect = tCProgressBar.U;
                int i16 = this.f67647a;
                rect.left = i16;
                rect.right = i16 + this.f67648b;
                tCProgressBar.E.setColor(tCProgressBar.L);
                TCProgressBar tCProgressBar2 = TCProgressBar.this;
                canvas.drawRect(tCProgressBar2.U, tCProgressBar2.E);
                TCProgressBar tCProgressBar3 = TCProgressBar.this;
                tCProgressBar3.E.setColor(tCProgressBar3.M);
            } else {
                if (this.f67651e) {
                    i3 = this.f67648b;
                } else {
                    int i17 = this.f67648b;
                    TCProgressBar tCProgressBar4 = TCProgressBar.this;
                    int i18 = i17 - tCProgressBar4.R;
                    Rect rect2 = tCProgressBar4.U;
                    int i19 = this.f67647a;
                    rect2.left = i19 + i18;
                    rect2.right = i19 + i17;
                    tCProgressBar4.E.setColor(tCProgressBar4.Q);
                    TCProgressBar tCProgressBar5 = TCProgressBar.this;
                    canvas.drawRect(tCProgressBar5.U, tCProgressBar5.E);
                    i3 = i18;
                }
                boolean b16 = b(this.f67654h - 5);
                if (QLog.isColorLevel()) {
                    QLog.d("TCProgressBar", 2, "ProgressBlock:hasMorePart=" + this.f67653g + " bounds=" + b16);
                }
                if (this.f67653g && b16) {
                    TCProgressBar tCProgressBar6 = TCProgressBar.this;
                    Rect rect3 = tCProgressBar6.U;
                    rect3.left = this.f67647a;
                    rect3.right = this.f67654h;
                    tCProgressBar6.E.setColor(tCProgressBar6.N);
                    TCProgressBar tCProgressBar7 = TCProgressBar.this;
                    canvas.drawRect(tCProgressBar7.U, tCProgressBar7.E);
                    TCProgressBar tCProgressBar8 = TCProgressBar.this;
                    Rect rect4 = tCProgressBar8.U;
                    rect4.left = this.f67654h;
                    rect4.right = this.f67647a + i3;
                    tCProgressBar8.E.setColor(tCProgressBar8.P);
                    TCProgressBar tCProgressBar9 = TCProgressBar.this;
                    canvas.drawRect(tCProgressBar9.U, tCProgressBar9.E);
                } else {
                    TCProgressBar tCProgressBar10 = TCProgressBar.this;
                    Rect rect5 = tCProgressBar10.U;
                    int i26 = this.f67647a;
                    rect5.left = i26;
                    rect5.right = i26 + i3;
                    if (this.f67657k) {
                        tCProgressBar10.E.setColor(tCProgressBar10.P);
                    } else {
                        tCProgressBar10.E.setColor(tCProgressBar10.N);
                    }
                    TCProgressBar tCProgressBar11 = TCProgressBar.this;
                    canvas.drawRect(tCProgressBar11.U, tCProgressBar11.E);
                }
            }
            super.a(canvas);
        }

        boolean b(int i3) {
            int i16 = this.f67647a;
            return i3 > i16 && i3 < (i16 + this.f67648b) - TCProgressBar.this.R;
        }

        boolean c(int i3) {
            return i3 < this.f67647a || b(i3);
        }

        boolean d(int i3) {
            return i3 > this.f67647a + this.f67648b || b(i3);
        }
    }

    public TCProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67630e = 0;
        this.f67632f = 0;
        this.f67634i = 1000;
        this.F = new Rect(0, 0, 0, 0);
        this.G = new TouchDelegate(this.F, this);
        this.J = false;
        this.K = 0;
        this.L = 1310991405;
        this.M = -14408659;
        this.N = -16737062;
        this.P = SupportMenu.CATEGORY_MASK;
        this.Q = -15000805;
        this.R = ScreenUtil.dip2px(1.0f);
        this.S = -1;
        this.T = ScreenUtil.dip2px(5.0f);
        this.U = new Rect();
        this.V = 0;
        this.W = new a();
        this.f67625a0 = new b();
        this.f67626b0 = new d(true);
        this.f67627c0 = new ArrayList<>(10);
        this.f67629d0 = new ArrayList<>(10);
        this.f67631e0 = new Handler();
        this.E = new Paint();
        this.f67628d = 3;
        try {
            this.f67635m = BitmapFactory.decodeResource(context.getResources(), R.drawable.f7t);
            this.C = BitmapFactory.decodeResource(context.getResources(), R.drawable.f7s);
            this.D = this.f67635m.getWidth();
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            this.D = 100;
        }
        this.f67631e0.postDelayed(new TimerRefresh(), this.f67634i);
    }

    int a(int i3, int i16) {
        int i17 = this.f67630e;
        if (i3 == i17) {
            return i16;
        }
        int i18 = (i16 * i3) / i17;
        if (i18 <= 0) {
            return 1;
        }
        return i18;
    }

    void b() {
        int i3;
        int i16;
        int i17;
        int width = super.getWidth();
        int i18 = this.D - 3;
        int i19 = width - i18;
        int size = this.f67627c0.size();
        int i26 = 0;
        while (true) {
            i3 = size - 1;
            if (i26 >= i3) {
                break;
            }
            d dVar = this.f67627c0.get(i26);
            if (dVar.f67649c) {
                dVar.f67647a = a(dVar.f67656j - dVar.f67655i, i19);
                dVar.f67648b = a(dVar.f67655i, i19);
                dVar.f67653g = false;
            }
            i26++;
        }
        int size2 = this.f67629d0.size();
        for (int i27 = 0; i27 < size2; i27++) {
            d dVar2 = this.f67629d0.get(i27);
            if (dVar2.f67649c) {
                dVar2.f67647a = a(dVar2.f67656j - dVar2.f67655i, i19);
                dVar2.f67648b = a(dVar2.f67655i, i19);
                dVar2.f67653g = false;
            }
        }
        if (size > 0) {
            d dVar3 = this.f67627c0.get(i3);
            dVar3.f67651e = true;
            dVar3.f67653g = false;
            if (!dVar3.f67659m) {
                int i28 = this.f67632f;
                dVar3.f67656j = i28;
                dVar3.f67655i = i28 - this.V;
            }
            if (dVar3.f67649c) {
                dVar3.f67647a = a(dVar3.f67656j - dVar3.f67655i, i19);
                dVar3.f67648b = a(dVar3.f67655i, i19);
            }
        }
        if (size <= 0) {
            i17 = i19;
            i16 = 0;
        } else {
            d dVar4 = this.f67627c0.get(i3);
            i16 = dVar4.f67647a + dVar4.f67648b;
            i17 = i19 - i16;
        }
        a aVar = this.W;
        if (aVar.f67650d && aVar.f67649c) {
            aVar.f67647a = i16;
            aVar.f67648b = this.T;
        }
        int d16 = this.f67625a0.d();
        b bVar = this.f67625a0;
        if (bVar.f67650d && bVar.f67649c) {
            int i29 = this.D;
            bVar.f67648b = i29;
            if (bVar.f67643m) {
                bVar.f67647a = i16 - 3;
            } else if (size2 == 0 && d16 > i16) {
                bVar.f67647a = i16 - 3;
                bVar.f67637g = true;
                bVar.f67643m = true;
            }
            if (bVar.f67647a < 0 && bVar.f67643m) {
                bVar.f67647a = 0;
            }
            if (bVar.f67647a + i29 + 1 >= width) {
                bVar.f67647a = width - i29;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "layout:delete.requestLayout" + this.f67625a0.f67643m);
            }
            if (!this.f67625a0.f67643m) {
                size = this.f67627c0.size();
                if (size > 0) {
                    d dVar5 = this.f67627c0.get(size - 1);
                    dVar5.f67651e = false;
                    if (dVar5.b(d16)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TCProgressBar", 2, "layout:progress.checkBounds=true");
                        }
                        dVar5.f67654h = this.f67625a0.f67647a + 3;
                        dVar5.f67653g = true;
                    }
                }
                if (size2 > 0) {
                    d dVar6 = this.f67629d0.get(size2 - 1);
                    if (dVar6.b(d16)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TCProgressBar", 2, "layout:deletedList.checkBounds=true");
                        }
                        dVar6.f67654h = this.f67625a0.f67647a + 3;
                        dVar6.f67653g = true;
                    }
                }
            }
        }
        if (size > 0) {
            d dVar7 = this.f67627c0.get(size - 1);
            if (dVar7.f67660n) {
                dVar7.f67648b = i19 - dVar7.f67647a;
            }
        }
        if (size2 > 0) {
            d dVar8 = this.f67629d0.get(0);
            if (dVar8.f67660n) {
                dVar8.f67648b = width - dVar8.f67647a;
            }
            i16 = dVar8.f67647a + dVar8.f67648b;
            i17 = i19 - i16;
        }
        d dVar9 = this.f67626b0;
        if (dVar9.f67649c) {
            dVar9.f67647a = i16;
            dVar9.f67648b = i17;
            if (i17 <= 1) {
                dVar9.f67650d = false;
            } else {
                dVar9.f67650d = true;
                dVar9.f67648b = i17 + i18;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (super.isInEditMode()) {
            return;
        }
        int width = super.getWidth();
        int height = super.getHeight();
        int i3 = height / 7;
        int i16 = i3 * 3;
        b();
        this.f67625a0.f67645o = height;
        Rect rect = this.U;
        rect.left = 0;
        rect.right = width;
        rect.top = 0;
        rect.bottom = i16;
        this.E.setColor(0);
        canvas.drawRect(this.U, this.E);
        Rect rect2 = this.U;
        int i17 = i3 + i16;
        rect2.top = i17;
        rect2.bottom = height;
        this.E.setColor(0);
        canvas.drawRect(this.U, this.E);
        Rect rect3 = this.U;
        rect3.top = i16;
        rect3.bottom = i17;
        int size = this.f67627c0.size();
        for (int i18 = 0; i18 < size; i18++) {
            d dVar = this.f67627c0.get(i18);
            if (dVar.f67649c && dVar.f67650d) {
                dVar.a(canvas);
            }
        }
        int size2 = this.f67629d0.size();
        for (int i19 = 0; i19 < size2; i19++) {
            d dVar2 = this.f67629d0.get(i19);
            if (dVar2.f67649c && dVar2.f67650d) {
                dVar2.a(canvas);
            }
        }
        d dVar3 = this.f67626b0;
        if (dVar3.f67649c && dVar3.f67650d) {
            dVar3.a(canvas);
        }
        a aVar = this.W;
        if (aVar.f67649c && aVar.f67650d) {
            aVar.a(canvas);
        }
        b bVar = this.f67625a0;
        if (bVar.f67649c && bVar.f67650d) {
            bVar.a(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        Rect rect = this.F;
        if (i3 != rect.left || i16 != rect.top + 25 || i17 != rect.right || i18 != rect.bottom - 25) {
            rect.left = i3;
            rect.right = i17;
            rect.top = i16 - 25;
            rect.bottom = i18 + 25;
            ((View) getParent()).setTouchDelegate(this.G);
        }
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int size;
        if (!super.isEnabled()) {
            return false;
        }
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        if (action == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_DOWN count=" + pointerCount + " X=" + x16);
            }
            this.H = SystemClock.elapsedRealtime();
            this.I = motionEvent.getX();
            this.K = this.f67627c0.size();
            this.J = false;
            if (this.f67625a0.b(x16)) {
                this.f67625a0.f(motionEvent);
            }
        } else if (action == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP count=" + pointerCount + " X=" + x16);
            }
            b bVar = this.f67625a0;
            if (bVar.f67640j) {
                bVar.f(motionEvent);
                if (this.f67625a0.b(x16)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP[checkBounds:true] count=" + pointerCount + " X=" + x16);
                    }
                    if (SystemClock.elapsedRealtime() - this.H < 400 && Math.abs(motionEvent.getX() - this.I) < 25.0f && (size = this.f67627c0.size()) > 0) {
                        d remove = this.f67627c0.remove(size - 1);
                        remove.f67657k = true;
                        this.f67629d0.add(remove);
                        if (QLog.isColorLevel()) {
                            QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP progress:[size]=" + this.f67627c0.size() + " deletedList[size]=" + this.f67629d0.size());
                        }
                    }
                }
                if (this.f67629d0.size() > 0) {
                    this.f67625a0.f67637g = false;
                } else {
                    this.f67625a0.f67637g = true;
                }
                invalidate();
                if (QLog.isColorLevel()) {
                    QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.f67625a0.f67650d + "delete.changed=" + this.f67625a0.f67649c);
                }
                if (this.K - this.f67627c0.size() > 0) {
                    this.J = true;
                }
            }
        } else if (action == 2) {
            if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_MOVE count=" + pointerCount + " X=" + x16);
            }
            b bVar2 = this.f67625a0;
            if (bVar2.f67640j) {
                bVar2.f(motionEvent);
                if (this.f67625a0.e()) {
                    int d16 = this.f67625a0.d();
                    if (this.f67625a0.f67642l < 0) {
                        for (int size2 = this.f67627c0.size() - 1; size2 >= 0; size2--) {
                            d dVar = this.f67627c0.get(size2);
                            if (!dVar.c(d16)) {
                                break;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("TCProgressBar", 2, "onTouchEvent:checkDelBounds=true");
                            }
                            this.f67627c0.remove(size2);
                            dVar.f67657k = true;
                            this.f67629d0.add(dVar);
                        }
                    } else {
                        for (int size3 = this.f67629d0.size() - 1; size3 >= 0; size3--) {
                            d dVar2 = this.f67629d0.get(size3);
                            if (!dVar2.d(d16)) {
                                break;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("TCProgressBar", 2, "onTouchEvent:checkRecorverBounds=true");
                            }
                            this.f67629d0.remove(size3);
                            dVar2.f67657k = false;
                            this.f67627c0.add(dVar2);
                        }
                    }
                    invalidate();
                }
            }
        } else if (action == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_CANCEL count=" + pointerCount + " X=" + x16);
            }
            b bVar3 = this.f67625a0;
            if (bVar3.f67640j) {
                bVar3.f(motionEvent);
                invalidate();
                if (QLog.isColorLevel()) {
                    QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.f67625a0.f67650d + "delete.changed=" + this.f67625a0.f67649c);
                }
                if (this.K - this.f67627c0.size() > 0) {
                    this.J = true;
                }
            }
        }
        return true;
    }

    public void setMax(int i3, int i16) {
        this.f67630e = i16;
    }

    public void setProgress(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("TCProgressBar", 2, "setProgress, progress = " + i3 + ",isOver = " + z16);
        }
        if (z16) {
            this.f67632f = this.f67630e;
            this.f67633h = true;
        } else {
            this.f67633h = false;
            this.f67632f = i3;
        }
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b extends c {

        /* renamed from: g, reason: collision with root package name */
        boolean f67637g;

        /* renamed from: h, reason: collision with root package name */
        int f67638h;

        /* renamed from: i, reason: collision with root package name */
        float f67639i;

        /* renamed from: j, reason: collision with root package name */
        boolean f67640j;

        /* renamed from: k, reason: collision with root package name */
        int f67641k;

        /* renamed from: l, reason: collision with root package name */
        int f67642l;

        /* renamed from: m, reason: collision with root package name */
        boolean f67643m;

        /* renamed from: n, reason: collision with root package name */
        int f67644n;

        /* renamed from: o, reason: collision with root package name */
        int f67645o;

        b() {
            super();
            this.f67638h = -1;
            this.f67639i = 0.0f;
            this.f67640j = false;
            this.f67641k = 0;
            this.f67643m = true;
            this.f67644n = 0;
        }

        @Override // com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar.c
        void a(Canvas canvas) {
            TCProgressBar tCProgressBar = TCProgressBar.this;
            Rect rect = tCProgressBar.U;
            int i3 = this.f67647a;
            rect.left = i3;
            rect.right = i3 + this.f67648b;
            int i16 = rect.top;
            int i17 = rect.bottom;
            rect.top = 0;
            rect.bottom = this.f67645o;
            if (this.f67637g) {
                c(canvas, tCProgressBar.f67635m);
            } else {
                c(canvas, tCProgressBar.C);
            }
            Rect rect2 = TCProgressBar.this.U;
            rect2.top = i16;
            rect2.bottom = i17;
            super.a(canvas);
        }

        boolean b(float f16) {
            if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "checkBounds,x = " + f16 + ",x_coord = " + this.f67647a + ",x_coord + length = " + (this.f67647a + this.f67648b));
            }
            int i3 = this.f67647a;
            return f16 > ((float) (i3 + (-25))) && f16 < ((float) ((i3 + this.f67648b) + 25));
        }

        int d() {
            return this.f67647a + this.f67644n;
        }

        boolean e() {
            int i3 = this.f67642l;
            if (i3 < 0) {
                i3 = -i3;
            }
            return i3 > 1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        
            if (r5 != 3) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean f(MotionEvent motionEvent) {
            float x16 = motionEvent.getX();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.f67642l = (int) (x16 - this.f67639i);
                        this.f67638h = action;
                        this.f67639i = x16;
                        this.f67641k++;
                        this.f67643m = false;
                        if (e()) {
                            this.f67647a += this.f67642l;
                        }
                    }
                }
                this.f67640j = false;
                this.f67639i = 0.0f;
                this.f67643m = true;
            } else {
                this.f67640j = true;
                this.f67638h = action;
                this.f67639i = x16;
                this.f67641k = 0;
                this.f67637g = false;
            }
            return true;
        }

        void c(Canvas canvas, Bitmap bitmap) {
            if (bitmap == null) {
                TCProgressBar.this.E.setColor(-1);
                if (!this.f67637g) {
                    TCProgressBar.this.E.setColor(SupportMenu.CATEGORY_MASK);
                }
                TCProgressBar tCProgressBar = TCProgressBar.this;
                canvas.drawRect(tCProgressBar.U, tCProgressBar.E);
                return;
            }
            TCProgressBar.this.E.setFilterBitmap(true);
            TCProgressBar tCProgressBar2 = TCProgressBar.this;
            canvas.drawBitmap(bitmap, (Rect) null, tCProgressBar2.U, tCProgressBar2.E);
            TCProgressBar.this.E.setFilterBitmap(false);
        }
    }
}
