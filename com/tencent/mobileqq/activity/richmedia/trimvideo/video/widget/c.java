package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements a.InterfaceC7204a {
    public static final boolean C = true;

    /* renamed from: a, reason: collision with root package name */
    private float f185974a;

    /* renamed from: b, reason: collision with root package name */
    private float f185975b;

    /* renamed from: c, reason: collision with root package name */
    private float f185976c;

    /* renamed from: d, reason: collision with root package name */
    private float f185977d;

    /* renamed from: e, reason: collision with root package name */
    private float f185978e;

    /* renamed from: f, reason: collision with root package name */
    private int f185979f;

    /* renamed from: g, reason: collision with root package name */
    private int f185980g;

    /* renamed from: h, reason: collision with root package name */
    private final int f185981h;

    /* renamed from: i, reason: collision with root package name */
    private int f185982i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.b f185983j;

    /* renamed from: k, reason: collision with root package name */
    private InterfaceC7205c f185984k;

    /* renamed from: l, reason: collision with root package name */
    private float f185985l;

    /* renamed from: m, reason: collision with root package name */
    private float f185986m;

    /* renamed from: o, reason: collision with root package name */
    private float f185988o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a f185989p;

    /* renamed from: q, reason: collision with root package name */
    private d f185990q;

    /* renamed from: r, reason: collision with root package name */
    private Scroller f185991r;

    /* renamed from: s, reason: collision with root package name */
    private GestureDetector f185992s;

    /* renamed from: u, reason: collision with root package name */
    private Canvas f185994u;

    /* renamed from: v, reason: collision with root package name */
    private Bitmap f185995v;

    /* renamed from: y, reason: collision with root package name */
    private Rect f185998y;

    /* renamed from: z, reason: collision with root package name */
    private Rect f185999z;

    /* renamed from: t, reason: collision with root package name */
    private GestureDetector.OnGestureListener f185993t = new a();

    /* renamed from: w, reason: collision with root package name */
    private Paint f185996w = new Paint();

    /* renamed from: x, reason: collision with root package name */
    private Paint f185997x = new Paint();
    private Rect A = new Rect();
    private float[] B = {0.33f, 0.5f, 0.11f, 0.0f, -50.0f, 0.33f, 0.5f, 0.11f, 0.0f, -50.0f, 0.33f, 0.5f, 0.11f, 0.0f, -50.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: n, reason: collision with root package name */
    private float f185987n = 0.0f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f186001a;

        /* renamed from: b, reason: collision with root package name */
        public int f186002b;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC7205c {
        void b(float f16, float f17, float f18);
    }

    public c(com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.b bVar, String str, int i3, int i16, float f16, float f17, int i17, float f18, int i18) {
        this.f185983j = bVar;
        this.f185975b = f16;
        this.f185976c = f17;
        this.f185982i = i16;
        this.f185988o = i17;
        float f19 = ((i3 * 1.0f) / i18) * f16;
        this.f185985l = f19;
        float f26 = i16 * f16;
        this.f185986m = Math.max(f19 - f26, 0.0f);
        if (QLog.isColorLevel()) {
            QLog.d("FramesProcessor", 2, "mTotalRange=" + this.f185985l + ", mMaxMovedDistance=" + this.f185986m);
        }
        this.f185977d = 0.0f;
        this.f185995v = Bitmap.createBitmap(i17, (int) this.f185976c, Bitmap.Config.RGB_565);
        this.f185994u = new Canvas(this.f185995v);
        this.f185997x.setColorFilter(new ColorMatrixColorFilter(this.B));
        this.f185974a = f18;
        this.f185998y = new Rect(0, 0, (int) f18, (int) this.f185976c);
        this.f185999z = new Rect((int) (f18 + Math.min(f19, f26)), 0, i17, (int) this.f185976c);
        this.f185991r = new Scroller(this.f185983j.getContext());
        this.f185992s = new GestureDetector(this.f185983j.getContext(), this.f185993t);
        this.f185989p = new com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a(this);
        int ceil = (int) Math.ceil((r7 * 1.0f) / this.f185975b);
        this.f185980g = ceil;
        int min = Math.min(ceil, i16);
        this.f185980g = min;
        this.f185981h = min;
        this.f185979f = 0;
        if (C) {
            this.f185990q = new VideoFramesRetriever(str, f16);
        } else {
            this.f185990q = new VideoFramesFetcher();
        }
        this.f185990q.a(i18, i3, this.f185989p);
        this.f185990q.b(this.f185979f, this.f185980g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a aVar = this.f185989p;
        if (aVar != null && !aVar.d()) {
            int i3 = (int) (this.f185977d / this.f185975b);
            this.f185979f = Math.max(i3, 0);
            int i16 = this.f185981h;
            if (i16 >= 6) {
                this.f185980g = Math.min(i16 + i3, this.f185982i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        InterfaceC7205c interfaceC7205c;
        this.f185994u.drawColor(-16777216);
        if (this.f185991r.computeScrollOffset()) {
            float currX = this.f185991r.getCurrX();
            this.f185977d = currX;
            float f16 = this.f185987n;
            if (currX < f16) {
                this.f185977d = f16;
                this.f185991r.forceFinished(true);
            }
            float f17 = this.f185977d;
            float f18 = this.f185986m;
            if (f17 > f18) {
                this.f185977d = f18;
                this.f185991r.forceFinished(true);
            }
            q();
            com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.b bVar = this.f185983j;
            if (bVar != null) {
                bVar.invalidate();
            }
        } else {
            this.f185990q.b(this.f185979f, this.f185980g);
        }
        float f19 = this.f185977d;
        float f26 = f19 - this.f185978e;
        this.f185978e = f19;
        if (!u(f26, 0.0f) && (interfaceC7205c = this.f185984k) != null) {
            float f27 = this.f185977d;
            interfaceC7205c.b(f27, -f27, this.f185985l - f27);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(float f16, float f17) {
        if (Math.abs(f16 - f17) == 0.0f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a.InterfaceC7204a
    public void onChanged() {
        this.f185983j.postInvalidate();
    }

    public void s() {
        this.f185984k = null;
        d dVar = this.f185990q;
        if (dVar != null) {
            dVar.release();
        }
        com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a aVar = this.f185989p;
        if (aVar != null) {
            aVar.b();
        }
        this.f185989p = null;
    }

    public void t(Canvas canvas) {
        if (this.f185989p == null) {
            return;
        }
        r();
        int max = Math.max(this.f185979f - 1, 0);
        float f16 = max * this.f185975b;
        this.f185994u.translate((f16 - this.f185977d) + this.f185974a, 0.0f);
        int min = Math.min(this.f185980g + 3, this.f185982i);
        int i3 = (int) this.f185975b;
        while (max < min) {
            b c16 = this.f185989p.c(max);
            if (c16 != null) {
                i3 = (int) Math.min(this.f185985l - f16, this.f185975b);
                this.A.set(0, 0, i3, (int) this.f185976c);
                Canvas canvas2 = this.f185994u;
                Bitmap bitmap = c16.f186001a;
                Rect rect = this.A;
                canvas2.drawBitmap(bitmap, rect, rect, this.f185996w);
            }
            float f17 = i3;
            this.f185994u.translate(f17, 0.0f);
            f16 += f17;
            max++;
        }
        this.f185994u.translate(((-f16) + this.f185977d) - this.f185974a, 0.0f);
        canvas.drawBitmap(this.f185995v, 0.0f, 0.0f, this.f185996w);
        Bitmap bitmap2 = this.f185995v;
        Rect rect2 = this.f185998y;
        canvas.drawBitmap(bitmap2, rect2, rect2, this.f185997x);
        Bitmap bitmap3 = this.f185995v;
        Rect rect3 = this.f185999z;
        canvas.drawBitmap(bitmap3, rect3, rect3, this.f185997x);
    }

    public boolean v() {
        return !u(this.f185977d, 0.0f);
    }

    public void w(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f185992s;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public void x(int i3) {
        Rect rect = this.f185998y;
        this.f185987n += rect.right - i3;
        rect.right = i3;
        this.f185983j.invalidate();
    }

    public void y(InterfaceC7205c interfaceC7205c) {
        this.f185984k = interfaceC7205c;
        if (interfaceC7205c != null) {
            float f16 = this.f185977d;
            interfaceC7205c.b(f16, -f16, this.f185985l - f16);
        }
    }

    public void z(int i3) {
        Rect rect = this.f185999z;
        this.f185986m += rect.left - i3;
        rect.left = i3;
        this.f185983j.invalidate();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements GestureDetector.OnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.f185991r.forceFinished(true);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            synchronized (c.this) {
                c.this.f185991r.fling((int) c.this.f185977d, 0, (int) (-f16), 0, (int) c.this.f185987n, (int) c.this.f185986m, 0, 0);
            }
            c.this.r();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            synchronized (c.this) {
                c.this.f185977d += f16;
            }
            if (c.this.f185977d < c.this.f185987n) {
                c cVar = c.this;
                cVar.f185977d = cVar.f185987n;
            }
            if (c.this.f185977d > c.this.f185986m) {
                c cVar2 = c.this;
                cVar2.f185977d = cVar2.f185986m;
            }
            float f18 = c.this.f185977d - c.this.f185978e;
            c cVar3 = c.this;
            cVar3.f185978e = cVar3.f185977d;
            if (!c.this.u(f18, 0.0f)) {
                c.this.q();
                if (c.this.f185990q != null) {
                    c.this.f185990q.b(c.this.f185979f, c.this.f185980g);
                }
                if (c.this.f185983j != null) {
                    c.this.f185983j.invalidate();
                }
                if (c.this.f185984k != null) {
                    c.this.f185984k.b(c.this.f185977d, -c.this.f185977d, c.this.f185985l - c.this.f185977d);
                }
                return true;
            }
            return true;
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
