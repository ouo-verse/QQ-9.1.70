package com.tencent.luggage.wxa.dh;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.mg.n;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f124247a;

    /* renamed from: b, reason: collision with root package name */
    public View f124248b;

    /* renamed from: d, reason: collision with root package name */
    public GestureDetector f124250d;

    /* renamed from: e, reason: collision with root package name */
    public d f124251e;

    /* renamed from: f, reason: collision with root package name */
    public float f124252f;

    /* renamed from: c, reason: collision with root package name */
    public c f124249c = c.None;

    /* renamed from: g, reason: collision with root package name */
    public int f124253g = 0;

    /* renamed from: h, reason: collision with root package name */
    public float f124254h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f124255i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f124256j = 0;

    /* renamed from: k, reason: collision with root package name */
    public Runnable f124257k = new RunnableC6140a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.dh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6140a implements Runnable {
        public RunnableC6140a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f124251e.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            a.this.f124248b.removeCallbacks(a.this.f124257k);
            a.this.f124251e.c();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (motionEvent != null && motionEvent2 != null) {
                if (a.this.f124249c == c.None) {
                    if (Math.abs(f16) > Math.abs(f17)) {
                        a.this.f124249c = c.FastBackwardOrForward;
                    } else if (motionEvent.getX() < a.this.f124248b.getMeasuredWidth() / 2) {
                        a.this.f124249c = c.Brightness;
                    } else {
                        a.this.f124249c = c.Volume;
                    }
                }
                return a.this.a(motionEvent, motionEvent2, motionEvent2.getX() - motionEvent.getX(), motionEvent2.getY() - motionEvent.getY());
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            a.this.f124248b.postDelayed(a.this.f124257k, 200L);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum c {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a();

        void a(float f16);

        void a(int i3, float f16);

        int b(int i3, float f16);

        void b(float f16);

        boolean b();

        void c();

        void c(float f16);

        void d(float f16);

        boolean d();

        void e();

        boolean f();

        boolean g();

        int getCurrentPosition();
    }

    public a(Context context, View view, d dVar) {
        this.f124252f = 0.0f;
        this.f124247a = context;
        this.f124251e = dVar;
        this.f124248b = view;
        a();
        this.f124252f = n.a(context);
    }

    public void b() {
        this.f124255i = -1;
        this.f124256j = 0;
        this.f124254h = 0.0f;
    }

    public final void c() {
        this.f124249c = c.None;
    }

    public final void d() {
        this.f124253g = SystemMethodProxy.getStreamVolume((AudioManager) this.f124247a.getSystemService("audio"), 3);
        this.f124252f = n.a(this.f124247a);
    }

    public final boolean c(float f16) {
        if (!this.f124251e.g()) {
            return false;
        }
        float f17 = f16 * (-1.0f);
        AudioManager audioManager = (AudioManager) this.f124247a.getSystemService("audio");
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f18 = streamMaxVolume;
        float measuredHeight = (f17 / this.f124248b.getMeasuredHeight()) * f18 * 1.2f;
        int i3 = (int) measuredHeight;
        if (i3 == 0 && Math.abs(measuredHeight) > 0.2f) {
            if (f17 > 0.0f) {
                i3 = 1;
            } else if (f17 < 0.0f) {
                i3 = -1;
            }
        }
        int i16 = this.f124253g + i3;
        if (i16 < 0) {
            streamMaxVolume = 0;
        } else if (i16 < streamMaxVolume) {
            streamMaxVolume = i16;
        }
        com.tencent.luggage.wxa.s9.a.a(audioManager, 3, streamMaxVolume, 0);
        this.f124251e.d(streamMaxVolume / f18);
        return true;
    }

    public void a(MotionEvent motionEvent) {
        if (!this.f124251e.d()) {
            c();
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f124254h = motionEvent.getRawX();
            d();
        }
        this.f124250d.onTouchEvent(motionEvent);
        if (actionMasked == 1 || actionMasked == 3) {
            c cVar = this.f124249c;
            if (cVar == c.FastBackwardOrForward) {
                this.f124251e.a(this.f124256j, motionEvent.getRawX() - this.f124254h);
                this.f124255i = -1;
                this.f124256j = 0;
                this.f124254h = 0.0f;
            } else if (cVar == c.Volume) {
                this.f124251e.a(this.f124253g / ((AudioManager) this.f124247a.getSystemService("audio")).getStreamMaxVolume(3));
            } else if (cVar == c.Brightness) {
                this.f124251e.c(this.f124252f);
            }
            c();
        }
    }

    public final boolean b(float f16) {
        if (!this.f124251e.b()) {
            return false;
        }
        if (this.f124255i == -1) {
            this.f124251e.e();
            this.f124255i = this.f124251e.getCurrentPosition();
        }
        this.f124256j = this.f124251e.b(this.f124255i, f16);
        return true;
    }

    public final void a() {
        this.f124250d = new GestureDetector(this.f124247a, new b());
    }

    public final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        c cVar = this.f124249c;
        if (cVar == c.FastBackwardOrForward) {
            return b(f16);
        }
        if (cVar == c.Brightness) {
            return a(f17);
        }
        if (cVar == c.Volume) {
            return c(f17);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r0 > 1.0f) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(float f16) {
        if (!this.f124251e.f()) {
            return false;
        }
        float measuredHeight = this.f124252f + (((f16 * (-1.0f)) / this.f124248b.getMeasuredHeight()) * 1.2f);
        float f17 = measuredHeight >= 0.0f ? 1.0f : 0.0f;
        measuredHeight = f17;
        n.a(this.f124247a, measuredHeight);
        this.f124251e.b(measuredHeight);
        return true;
    }
}
