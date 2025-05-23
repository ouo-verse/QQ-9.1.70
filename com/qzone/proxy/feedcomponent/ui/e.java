package com.qzone.proxy.feedcomponent.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.SystemClock;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: m, reason: collision with root package name */
    public static final float f50826m = FeedGlobalEnv.g().getScreenWidth() / 720.0f;

    /* renamed from: d, reason: collision with root package name */
    Paint f50830d;

    /* renamed from: e, reason: collision with root package name */
    float f50831e;

    /* renamed from: f, reason: collision with root package name */
    int f50832f;

    /* renamed from: g, reason: collision with root package name */
    double f50833g;

    /* renamed from: h, reason: collision with root package name */
    float f50834h;

    /* renamed from: i, reason: collision with root package name */
    float f50835i;

    /* renamed from: k, reason: collision with root package name */
    int f50837k;

    /* renamed from: l, reason: collision with root package name */
    int f50838l;

    /* renamed from: a, reason: collision with root package name */
    final int f50827a = 16000000;

    /* renamed from: b, reason: collision with root package name */
    CopyOnWriteArrayList<k> f50828b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    ArrayList<k> f50829c = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    a f50836j = new a();

    public e() {
        e();
        this.f50831e = 10.0f;
        this.f50832f = 1;
        this.f50833g = 3.141592653589793d / ((1000 / 1) / 2);
        this.f50834h = 0.2f;
        this.f50835i = 0.28f;
    }

    public void b(Canvas canvas, Matrix matrix) {
        Bitmap b16;
        SystemClock.uptimeMillis();
        Iterator<k> it = this.f50828b.iterator();
        if (this.f50828b.size() >= 60) {
            this.f50830d.setDither(false);
        } else {
            this.f50830d.setDither(true);
        }
        while (it.hasNext()) {
            k next = it.next();
            if (next.f50862k > 10 && (b16 = next.b()) != null) {
                matrix.reset();
                this.f50830d.setAlpha(next.f50862k);
                this.f50837k = b16.getWidth();
                this.f50838l = b16.getHeight();
                Point point = next.f50855d;
                matrix.postTranslate(point.x - (this.f50837k / 2), point.y - (r3 / 2));
                float f16 = next.f50861j;
                float f17 = f50826m;
                Point point2 = next.f50855d;
                matrix.postScale(f16 * f17, f16 * f17, point2.x, point2.y);
                canvas.drawBitmap(b16, matrix, this.f50830d);
            }
        }
    }

    public int c() {
        return this.f50828b.size();
    }

    public a d() {
        return this.f50836j;
    }

    void e() {
        Paint paint = new Paint();
        this.f50830d = paint;
        paint.setAntiAlias(true);
        this.f50830d.setDither(true);
        this.f50830d.setFilterBitmap(true);
        this.f50830d.setStyle(Paint.Style.FILL);
    }

    public void f() {
        this.f50829c.clear();
        Iterator<k> it = this.f50828b.iterator();
        while (it.hasNext()) {
            this.f50829c.add(it.next());
        }
        this.f50828b.clear();
        Iterator<k> it5 = this.f50829c.iterator();
        while (it5.hasNext()) {
            k.a(it5.next());
        }
        this.f50829c.clear();
    }

    public boolean g() {
        this.f50829c.clear();
        Iterator<k> it = this.f50828b.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if (next.f50854c < SystemClock.uptimeMillis()) {
                this.f50829c.add(next);
            }
        }
        if (this.f50829c.size() > 0) {
            this.f50828b.removeAll(this.f50829c);
        }
        Iterator<k> it5 = this.f50829c.iterator();
        while (it5.hasNext()) {
            k.a(it5.next());
        }
        this.f50829c.clear();
        return this.f50828b.size() == 0;
    }

    public void i() {
        long uptimeMillis = SystemClock.uptimeMillis();
        Iterator<k> it = this.f50828b.iterator();
        while (it.hasNext()) {
            h(it.next(), uptimeMillis);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: f, reason: collision with root package name */
        int f50844f;

        /* renamed from: g, reason: collision with root package name */
        int f50845g;

        /* renamed from: h, reason: collision with root package name */
        int f50846h;

        /* renamed from: i, reason: collision with root package name */
        int f50847i;

        /* renamed from: b, reason: collision with root package name */
        int f50840b = 1;

        /* renamed from: c, reason: collision with root package name */
        int f50841c = 1;

        /* renamed from: d, reason: collision with root package name */
        int f50842d = 1560;

        /* renamed from: e, reason: collision with root package name */
        int f50843e = 0;

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<Point[]> f50839a = new ArrayList<>();

        /* renamed from: j, reason: collision with root package name */
        Random f50848j = new Random(System.currentTimeMillis());

        a() {
            f();
        }

        public void a(int i3, int i16) {
            if (this.f50840b <= 0 || this.f50841c <= 0) {
                return;
            }
            int i17 = (i3 - this.f50844f) - this.f50845g;
            if (i17 > 0) {
                i3 = Math.min(i17, i3);
            }
            int i18 = (i16 - this.f50847i) - this.f50846h;
            if (i17 > 0) {
                i16 = Math.min(i18, i16);
            }
            float f16 = (i3 * 1.0f) / this.f50840b;
            float f17 = (i16 * 1.0f) / this.f50841c;
            Iterator<Point[]> it = this.f50839a.iterator();
            while (it.hasNext()) {
                for (Point point : it.next()) {
                    point.x = (int) (((point.x + 0) * f16) + this.f50844f);
                    point.y = (int) ((point.y * f17) + this.f50846h);
                }
            }
            this.f50840b = i3;
            this.f50841c = i16;
        }

        public void c(Point point, float f16, int i3) {
            Point[] d16 = d(i3);
            if (d16 == null || d16.length < 4) {
                return;
            }
            b(point, f16, d16[0], d16[1], d16[2], d16[3]);
        }

        public int e() {
            int i3 = this.f50843e;
            if (i3 <= 0) {
                return this.f50842d;
            }
            return this.f50842d + this.f50848j.nextInt(i3 + 1);
        }

        public int g() {
            ArrayList<Point[]> arrayList = this.f50839a;
            if (arrayList == null || arrayList.size() == 0) {
                return -1;
            }
            return this.f50848j.nextInt(this.f50839a.size());
        }

        public void h(int i3) {
            this.f50847i = i3;
        }

        public void i(int i3) {
            this.f50844f = i3;
        }

        public void j(int i3) {
            this.f50845g = i3;
        }

        public void k(int i3) {
            this.f50846h = i3;
        }

        Point[] d(int i3) {
            if (i3 <= 0 && i3 >= this.f50839a.size()) {
                return this.f50839a.get(0);
            }
            return this.f50839a.get(i3);
        }

        void f() {
            int i3;
            this.f50839a.clear();
            this.f50840b = 208;
            this.f50841c = 702;
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(258, 482), new Point(-8, 322), new Point(18, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(158, 442), new Point(-82, 322), new Point(58, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(238, 442), new Point(-8, 322), new Point(58, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(238, 442), new Point(-8, 322), new Point(118, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(278, 442), new Point(-62, 322), new Point(58, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(-62, 442), new Point(208, 322), new Point(150, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(218, 442), new Point(-62, 322), new Point(38, 12)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(-62, 442), new Point(218, 322), new Point(126, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(-42, 442), new Point(188, 302), new Point(98, 18)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(-2, 442), new Point(158, FilterEnum.MIC_PTU_BAIXI), new Point(58, 20)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(58, 442), new Point(178, FilterEnum.MIC_PTU_BAIXI), new Point(118, 22)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(58, 442), new Point(178, FilterEnum.MIC_PTU_BAIXI), new Point(126, 22)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(98, 362), new Point(198, FilterEnum.MIC_PTU_BAIXI), new Point(122, 22)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(58, 442), new Point(258, 262), new Point(152, 22)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(38, 442), new Point(218, 262), new Point(158, 16)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(38, 442), new Point(138, 262), new Point(98, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(138, 262), new Point(38, 442), new Point(74, 2)});
            this.f50839a.add(new Point[]{new Point(104, 702), new Point(88, 442), new Point(108, 262), new Point(98, 2)});
            int i16 = this.f50840b / 2;
            ArrayList arrayList = new ArrayList(this.f50839a.size());
            Iterator<Point[]> it = this.f50839a.iterator();
            while (it.hasNext()) {
                Point[] next = it.next();
                Point[] pointArr = new Point[next.length];
                for (int i17 = 0; i17 < next.length; i17++) {
                    Point point = next[i17];
                    if (i17 == 0) {
                        i3 = point.x;
                    } else {
                        int i18 = point.x;
                        i3 = i18 + ((i16 - i18) * 2);
                    }
                    pointArr[i17] = new Point(i3, point.y);
                }
                arrayList.add(pointArr);
            }
            this.f50839a.addAll(arrayList);
            com.qzone.proxy.feedcomponent.b.a("LikeParticleManager", "=initPointsArray==mCachedBezierPointsArray size:" + this.f50839a.size());
        }

        public static void b(Point point, float f16, Point point2, Point point3, Point point4, Point point5) {
            float f17 = 1.0f - f16;
            float f18 = f16 * f16;
            float f19 = f17 * f17;
            float f26 = f19 * f17;
            float f27 = f18 * f16;
            float f28 = (point2.x * f26) + (point3.x * 3 * f16 * f19) + (point4.x * 3 * f18 * f17) + (point5.x * f27);
            point.x = (int) f28;
            point.y = (int) ((point2.y * f26) + (point3.y * 3 * f16 * f19) + (point4.y * 3 * f18 * f17) + (point5.y * f27));
        }
    }

    public void a(k kVar) {
        if (kVar != null) {
            long j3 = kVar.f50852a;
            kVar.f50857f = (this.f50834h * ((float) kVar.f50853b)) + j3;
            h(kVar, j3);
            this.f50828b.add(kVar);
        }
    }

    public void h(k kVar, long j3) {
        if (kVar == null) {
            return;
        }
        kVar.f50858g = j3;
        long j16 = kVar.f50852a;
        if (j3 <= j16) {
            return;
        }
        float f16 = ((float) (j3 - j16)) / (((float) kVar.f50853b) * 1.0f);
        kVar.f50859h = f16;
        if (f16 <= 0.0f) {
            kVar.f50859h = 0.0f;
            com.qzone.proxy.feedcomponent.b.a("LikeParticleManager", "updateParticle<0" + kVar.toString());
        } else if (f16 > 1.0f) {
            kVar.f50859h = 1.0f;
            com.qzone.proxy.feedcomponent.b.a("LikeParticleManager", "updateParticle>0" + kVar.toString());
        }
        float f17 = kVar.f50859h;
        if (f17 >= 0.0f && f17 <= 0.2f) {
            float f18 = f17 / 0.2f;
            float f19 = f18 * f18 * 1.25f;
            kVar.f50861j = f19;
            int i3 = (int) (f19 * 255.0f);
            kVar.f50862k = i3;
            if (i3 > 255) {
                kVar.f50862k = 255;
            }
        } else if (f17 >= 0.2f && f17 <= 0.28f) {
            float f26 = f17 / 0.2f;
            kVar.f50861j = 1.25f - ((f26 * f26) * 0.25f);
            kVar.f50862k = 255;
        } else if (f17 >= 0.28f && f17 <= 0.7f) {
            kVar.f50861j = 1.0f;
            kVar.f50862k = 255;
        } else if (f17 >= 0.7f && f17 <= 1.0f) {
            kVar.f50862k = (int) ((1.0f - ((f17 - 0.7f) / 0.3f)) * 255.0f);
            kVar.f50861j = 1.0f;
        } else {
            kVar.f50862k = 255;
            kVar.f50861j = 1.0f;
        }
        if (f17 >= 0.0f && f17 <= 0.28f) {
            kVar.f50859h = (f17 * 0.33f) / 0.28f;
        } else {
            kVar.f50859h = (((f17 - 0.28f) / 0.72f) * 0.67f) + 0.33f;
        }
        this.f50836j.c(kVar.f50855d, kVar.f50859h, kVar.f50856e);
    }
}
