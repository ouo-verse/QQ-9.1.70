package com.tencent.mobileqq.ar.arengine;

import android.graphics.PointF;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class y extends ab {

    /* renamed from: b, reason: collision with root package name */
    public long f198294b = 0;

    /* renamed from: c, reason: collision with root package name */
    public c f198295c = new c();

    /* renamed from: d, reason: collision with root package name */
    public b f198296d = new b();

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public float f198297a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f198298b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f198299c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public boolean f198300d = true;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f198301a = -2;

        /* renamed from: b, reason: collision with root package name */
        public int f198302b = -2;

        /* renamed from: c, reason: collision with root package name */
        public a f198303c = new a();

        /* renamed from: d, reason: collision with root package name */
        public PointF[] f198304d = new PointF[1000];

        /* renamed from: e, reason: collision with root package name */
        public int f198305e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f198306f = 0;

        /* renamed from: g, reason: collision with root package name */
        public PointF[] f198307g = new PointF[1000];

        /* renamed from: h, reason: collision with root package name */
        public int[] f198308h = new int[1000];

        /* renamed from: i, reason: collision with root package name */
        public int f198309i = 80;

        /* renamed from: j, reason: collision with root package name */
        public int f198310j = 8;

        /* renamed from: k, reason: collision with root package name */
        public int f198311k = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f198312l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f198313m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f198314n = 0;

        public void a() {
            this.f198301a = -2;
            this.f198302b = -2;
            a aVar = this.f198303c;
            aVar.f198298b = 0.0f;
            aVar.f198299c = 0.0f;
            aVar.f198297a = 0.0f;
            this.f198305e = 0;
            this.f198306f = 0;
            this.f198310j = 10;
            this.f198311k = 0;
            this.f198312l = 0;
            this.f198313m = 0;
            this.f198314n = 0;
        }

        public String toString() {
            return "ARCircleResult{, state = " + this.f198301a + ", lastState = " + this.f198302b + ", pointCnt = " + this.f198305e + ", lastPointCnt = " + this.f198306f + ", genIdx = " + this.f198311k + ", gesturePointCnt = " + this.f198312l + ", stillPointCnt = " + this.f198313m + ", goodPointCnt = " + this.f198314n + ", circle(r,x,y,c) = (" + ((int) this.f198303c.f198297a) + "," + ((int) this.f198303c.f198298b) + "," + ((int) this.f198303c.f198299c) + "," + this.f198303c.f198300d + ")}";
        }
    }

    public y() {
        a();
    }

    public void a() {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
        this.f197989a = 4096L;
        this.f198294b = 0L;
        this.f198295c.a();
        this.f198296d.a();
    }

    @Override // com.tencent.mobileqq.ar.arengine.ab
    public String toString() {
        return "ARLocalGestureCircleRecogResult{recogType = " + this.f197989a + ", frameIdx = " + this.f198294b + ", gestureResult = " + this.f198295c + ", circleResult = " + this.f198296d + '}';
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f198315a;

        /* renamed from: b, reason: collision with root package name */
        public int f198316b;

        /* renamed from: c, reason: collision with root package name */
        public String f198317c;

        /* renamed from: d, reason: collision with root package name */
        public PointF[] f198318d;

        /* renamed from: e, reason: collision with root package name */
        public int f198319e;

        /* renamed from: f, reason: collision with root package name */
        public int f198320f;

        /* renamed from: g, reason: collision with root package name */
        public int f198321g;

        public c(int i3) {
            this.f198315a = false;
            this.f198316b = -1;
            this.f198317c = "";
            this.f198318d = null;
            this.f198319e = 0;
            this.f198320f = 0;
            this.f198321g = -1;
            this.f198318d = new PointF[i3];
            a();
        }

        public void a() {
            this.f198315a = false;
            this.f198316b = -1;
            this.f198317c = "";
            this.f198319e = 0;
            this.f198320f = 0;
            this.f198321g = -1;
        }

        public String toString() {
            String str;
            if (this.f198319e > 0) {
                str = "(" + ((int) this.f198318d[this.f198319e - 1].x) + "," + ((int) this.f198318d[this.f198319e - 1].y) + ")";
            } else {
                str = "(-1,-1)";
            }
            return "ARGestureResult{, state = " + this.f198316b + ", type = " + this.f198317c + ", pointCnt = " + this.f198319e + ", newPoint(x,y) = " + str + ", mode = " + this.f198321g + '}';
        }

        public c() {
            this.f198315a = false;
            this.f198316b = -1;
            this.f198317c = "";
            this.f198319e = 0;
            this.f198320f = 0;
            this.f198321g = -1;
            this.f198318d = new PointF[1000];
            a();
        }
    }
}
