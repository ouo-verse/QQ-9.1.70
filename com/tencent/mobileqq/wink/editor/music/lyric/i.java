package com.tencent.mobileqq.wink.editor.music.lyric;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

/* compiled from: P */
/* loaded from: classes21.dex */
public class i {
    private static final int G = ViewUtils.dip2px(2.0f);
    private static final int H = ViewUtils.dip2px(4.0f);
    private int A;
    private int B;
    private Bitmap C;

    /* renamed from: a, reason: collision with root package name */
    private float f320885a;

    /* renamed from: b, reason: collision with root package name */
    private float f320886b;

    /* renamed from: c, reason: collision with root package name */
    private float f320887c;

    /* renamed from: d, reason: collision with root package name */
    private float f320888d;

    /* renamed from: e, reason: collision with root package name */
    private c f320889e;

    /* renamed from: f, reason: collision with root package name */
    private int f320890f;

    /* renamed from: g, reason: collision with root package name */
    private int f320891g;

    /* renamed from: h, reason: collision with root package name */
    private int f320892h;

    /* renamed from: i, reason: collision with root package name */
    private int f320893i;

    /* renamed from: j, reason: collision with root package name */
    private int f320894j;

    /* renamed from: k, reason: collision with root package name */
    private int f320895k;

    /* renamed from: l, reason: collision with root package name */
    private int f320896l;

    /* renamed from: m, reason: collision with root package name */
    private int f320897m;

    /* renamed from: n, reason: collision with root package name */
    private int f320898n;

    /* renamed from: o, reason: collision with root package name */
    private int f320899o;

    /* renamed from: p, reason: collision with root package name */
    private int f320900p;

    /* renamed from: r, reason: collision with root package name */
    private GestureDetector f320902r;

    /* renamed from: s, reason: collision with root package name */
    private b f320903s;

    /* renamed from: v, reason: collision with root package name */
    private int f320906v;

    /* renamed from: w, reason: collision with root package name */
    private int f320907w;

    /* renamed from: x, reason: collision with root package name */
    private int f320908x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f320909y;

    /* renamed from: z, reason: collision with root package name */
    private int f320910z;

    /* renamed from: q, reason: collision with root package name */
    private Paint f320901q = new Paint();

    /* renamed from: t, reason: collision with root package name */
    private Paint f320904t = new Paint();

    /* renamed from: u, reason: collision with root package name */
    private Paint f320905u = new Paint();
    private boolean D = false;
    private int E = 0;
    private GestureDetector.OnGestureListener F = new a();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void C(int i3, int i16);

        void G();

        void s();
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        Context a();

        Context b();

        void c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, String str, String str2, int i3, int i16, int i17, boolean z16, int i18, int i19) {
        this.A = 0;
        this.B = 0;
        this.f320889e = cVar;
        this.f320909y = z16;
        this.f320891g = i16;
        if (i16 == 0) {
            this.f320891g = 60000;
        }
        this.f320890f = i3;
        if (i3 < this.f320891g) {
            this.f320891g = i3;
        }
        this.f320893i = i17;
        this.f320894j = ViewUtils.dip2px(7.0f);
        this.f320895k = ViewUtils.dip2px(3.0f);
        int dip2px = ViewUtils.dip2px(2.0f);
        this.f320896l = dip2px;
        this.f320897m = dip2px / 2;
        this.f320899o = i18;
        this.f320892h = i19;
        int i26 = i17 * 2;
        int i27 = i18 - i26;
        this.f320910z = i27;
        int i28 = this.f320890f;
        int i29 = this.f320891g;
        if (i28 <= i29) {
            this.f320898n = i18;
        } else {
            this.f320898n = ((int) (((i28 * 1.0f) / i29) * i27)) + i26;
        }
        int i36 = this.f320893i;
        this.f320906v = i36;
        this.f320907w = this.f320898n - i36;
        float f16 = (1000.0f / i29) * i27;
        this.f320887c = 0.0f;
        if (i28 < i29) {
            this.f320886b = (((i28 * 1.0f) / i29) * i27) - f16;
        } else {
            this.f320886b = (r15 - i26) - i27;
        }
        if (!this.f320909y) {
            this.A = i36;
            this.B = ViewUtils.dip2px(9.0f);
        }
        this.f320902r = new GestureDetector(this.f320889e.a(), this.F);
        this.f320901q.setAntiAlias(true);
        this.f320904t.setAntiAlias(true);
        this.f320905u.setAntiAlias(true);
        this.f320905u.setFilterBitmap(true);
        this.f320905u.setDither(true);
        int i37 = this.f320890f;
        int i38 = this.f320891g;
        if (i37 < i38) {
            this.f320900p = (int) (((((i37 * 1.0f) / i38) * this.f320910z) + i26) / H);
        } else {
            this.f320900p = (int) ((this.f320898n * 1.0f) / H);
        }
        if (this.f320900p > 10000) {
            ms.a.i("WinkMusicWaveScrollProcessor", "WinkMusicWaveScrollProcessor() called with: parent = [" + cVar + "], audioPath = [" + str2 + "], audioDuration = [" + i3 + "], perScreenDuration = [" + i16 + "], padding = [" + i17 + "], isFromLibrary = [" + z16 + "], width = [" + i18 + "], height = [" + i19 + "] lineCount=" + this.f320900p);
        }
        h.a(str, str2, this.f320900p);
    }

    private void r() {
        if (this.C == null) {
            this.C = BitmapUtils.decodeSampledBitmapFromResource(this.f320889e.a().getResources(), R.drawable.oek, 16, 118);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Canvas canvas, boolean z16) {
        int i3;
        Paint paint;
        if (canvas == null) {
            ms.a.f("WinkMusicWaveScrollProcessor", "draw:canvas is null.");
            return;
        }
        canvas.save();
        int color = this.f320889e.b().getResources().getColor(R.color.f156921fa);
        int color2 = this.f320889e.b().getResources().getColor(R.color.ber);
        int color3 = this.f320889e.b().getResources().getColor(R.color.abm);
        if (!z16) {
            color2 = color;
        }
        if (!this.f320909y && (paint = this.f320904t) != null) {
            paint.setStyle(Paint.Style.FILL);
            this.f320904t.setColor(this.f320889e.b().getResources().getColor(R.color.bfg));
            int i16 = this.f320893i;
            int i17 = this.f320897m;
            canvas.drawRect(new RectF(i16 - i17, this.f320894j, (this.f320899o - i16) + i17, this.f320892h - r9), this.f320904t);
        }
        int i18 = this.f320899o;
        int i19 = this.f320893i;
        float f16 = i19 + 0.0f;
        float f17 = i18 - i19;
        int i26 = H;
        int i27 = i18 / i26;
        int ceil = (int) Math.ceil((this.f320906v * 1.0d) / i26);
        int max = Math.max(Math.min(((int) this.f320885a) / i26, this.f320900p), ceil);
        int min = Math.min(i27 + max, this.f320900p);
        RectF rectF = new RectF(0.0f, 0.0f, G, this.f320892h);
        while (max < min) {
            if (!this.f320909y) {
                double c16 = h.c(max - ceil);
                i3 = ceil;
                int i28 = (int) (c16 * (r14 - (this.f320894j * 4)));
                float f18 = (this.f320892h - i28) / 2;
                rectF.top = f18;
                rectF.bottom = f18 + i28;
            } else {
                i3 = ceil;
                double c17 = h.c(max - i3);
                int i29 = this.f320892h;
                int i36 = (int) (c17 * i29);
                float f19 = (i29 - i36) / 2;
                rectF.top = f19;
                rectF.bottom = f19 + i36;
            }
            float f26 = this.f320885a;
            if (rectF.right + f26 >= this.f320906v) {
                float f27 = rectF.left;
                if (f26 + f27 <= this.f320907w) {
                    if (f27 >= f16 && f27 <= f17) {
                        if (this.f320909y) {
                            if (f27 < this.f320908x - f26) {
                                this.f320901q.setColor(color3);
                            } else {
                                this.f320901q.setColor(color2);
                            }
                        } else if (f27 < this.E) {
                            this.f320901q.setColor(color3);
                        } else {
                            this.f320901q.setColor(color2);
                        }
                    } else {
                        this.f320901q.setColor(color);
                    }
                    canvas.drawRect(rectF, this.f320901q);
                }
            }
            float f28 = rectF.left;
            int i37 = H;
            rectF.left = f28 + i37;
            rectF.right += i37;
            max++;
            ceil = i3;
        }
        if (!this.f320909y && this.f320904t != null) {
            r();
            Rect rect = new Rect(0, 0, this.C.getWidth(), this.C.getHeight());
            int i38 = this.A;
            int i39 = this.B;
            canvas.drawBitmap(this.C, rect, new RectF(i38 - (i39 / 2), 0.0f, i38 + (i39 / 2), this.f320892h), this.f320905u);
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        float f16 = (this.f320885a * 1.0f) / this.f320910z;
        int i3 = this.f320891g;
        int i16 = ((int) (f16 * i3)) + i3;
        int i17 = this.f320890f;
        if (i16 <= i17) {
            return i16;
        }
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f320893i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        int i3 = (int) (((this.f320885a * 1.0f) / this.f320910z) * this.f320891g);
        int i16 = this.f320890f;
        if (i3 > i16) {
            return i16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f320892h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f320899o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q(float f16, float f17) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            b bVar = this.f320903s;
            if (bVar != null) {
                bVar.G();
                return;
            }
            return;
        }
        GestureDetector gestureDetector = this.f320902r;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i3) {
        this.f320885a = ((i3 * 1.0f) / this.f320891g) * this.f320910z;
        c cVar = this.f320889e;
        if (cVar != null) {
            cVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i3, int i16) {
        float f16 = (i3 * 1.0f) / i16;
        int i17 = this.f320898n;
        this.f320908x = ((int) (f16 * (i17 - (r0 * 2)))) + this.f320893i;
        c cVar = this.f320889e;
        if (cVar != null) {
            cVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i3) {
        int i16 = this.f320893i;
        if (i3 >= i16 && i3 <= this.f320899o - i16) {
            this.A = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(boolean z16) {
        this.D = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(b bVar) {
        this.f320903s = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i3) {
        this.E = i3;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements GestureDetector.OnGestureListener {
        a() {
        }

        private boolean a(float f16, float f17) {
            if (Math.abs(f16 - f17) == 0.0f) {
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (i.this.f320903s != null) {
                i.this.f320903s.s();
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            synchronized (i.this) {
                float f18 = i.this.f320885a + f16;
                if (f18 < i.this.f320887c) {
                    f18 = i.this.f320887c;
                }
                if (f18 > i.this.f320886b) {
                    f18 = i.this.f320886b;
                }
                i.this.f320885a = f18;
                float f19 = i.this.f320885a - i.this.f320888d;
                i iVar = i.this;
                iVar.f320888d = iVar.f320885a;
                if (a(f19, 0.0f)) {
                    return true;
                }
                if (i.this.f320903s != null) {
                    i.this.f320903s.C(i.this.n(), i.this.j());
                }
                if (i.this.f320889e != null) {
                    i.this.f320889e.c();
                }
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }
    }
}
