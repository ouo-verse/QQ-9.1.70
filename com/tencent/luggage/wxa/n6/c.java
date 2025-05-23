package com.tencent.luggage.wxa.n6;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.luggage.widget.decoder.SkiaImageDecoder;
import com.tencent.luggage.widget.decoder.SkiaImageRegionDecoder;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends View {
    public static final String J0 = "c";
    public static final List K0 = Arrays.asList(0, 90, 180, 270, -1);
    public static final List L0 = Arrays.asList(1, 2, 3);
    public static final List M0 = Arrays.asList(2, 1);
    public static final List N0 = Arrays.asList(1, 2, 3);
    public static final List O0 = Arrays.asList(2, 1, 3, 4);
    public static Bitmap.Config P0;
    public Paint A0;
    public Paint B0;
    public int C;
    public Paint C0;
    public int D;
    public j D0;
    public Executor E;
    public Matrix E0;
    public boolean F;
    public RectF F0;
    public boolean G;
    public final float[] G0;
    public boolean H;
    public final float[] H0;
    public boolean I;
    public final float I0;
    public float J;
    public int K;
    public int L;
    public float M;
    public float N;
    public PointF O;
    public PointF P;
    public PointF Q;
    public Float R;
    public PointF S;
    public PointF T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f135466a;

    /* renamed from: a0, reason: collision with root package name */
    public Rect f135467a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f135468b;

    /* renamed from: b0, reason: collision with root package name */
    public Rect f135469b0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f135470c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f135471c0;

    /* renamed from: d, reason: collision with root package name */
    public Uri f135472d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f135473d0;

    /* renamed from: e, reason: collision with root package name */
    public int f135474e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f135475e0;

    /* renamed from: f, reason: collision with root package name */
    public Map f135476f;

    /* renamed from: f0, reason: collision with root package name */
    public int f135477f0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f135478g;

    /* renamed from: g0, reason: collision with root package name */
    public GestureDetector f135479g0;

    /* renamed from: h, reason: collision with root package name */
    public int f135480h;

    /* renamed from: h0, reason: collision with root package name */
    public GestureDetector f135481h0;

    /* renamed from: i, reason: collision with root package name */
    public float f135482i;

    /* renamed from: i0, reason: collision with root package name */
    public com.tencent.luggage.wxa.o6.d f135483i0;

    /* renamed from: j, reason: collision with root package name */
    public float f135484j;

    /* renamed from: j0, reason: collision with root package name */
    public final ReadWriteLock f135485j0;

    /* renamed from: k, reason: collision with root package name */
    public int f135486k;

    /* renamed from: k0, reason: collision with root package name */
    public com.tencent.luggage.wxa.o6.b f135487k0;

    /* renamed from: l, reason: collision with root package name */
    public int f135488l;

    /* renamed from: l0, reason: collision with root package name */
    public com.tencent.luggage.wxa.o6.b f135489l0;

    /* renamed from: m, reason: collision with root package name */
    public int f135490m;

    /* renamed from: m0, reason: collision with root package name */
    public PointF f135491m0;

    /* renamed from: n0, reason: collision with root package name */
    public float f135492n0;

    /* renamed from: o0, reason: collision with root package name */
    public final float f135493o0;

    /* renamed from: p0, reason: collision with root package name */
    public float f135494p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f135495q0;

    /* renamed from: r0, reason: collision with root package name */
    public PointF f135496r0;

    /* renamed from: s0, reason: collision with root package name */
    public PointF f135497s0;

    /* renamed from: t0, reason: collision with root package name */
    public PointF f135498t0;

    /* renamed from: u0, reason: collision with root package name */
    public d f135499u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f135500v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f135501w0;

    /* renamed from: x0, reason: collision with root package name */
    public View.OnLongClickListener f135502x0;

    /* renamed from: y0, reason: collision with root package name */
    public final Handler f135503y0;

    /* renamed from: z0, reason: collision with root package name */
    public Paint f135504z0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && c.this.f135502x0 != null) {
                c.this.f135477f0 = 0;
                c cVar = c.this;
                c.super.setOnLongClickListener(cVar.f135502x0);
                c.this.performLongClick();
                c.super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f135506a;

        public b(Context context) {
            this.f135506a = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.H && c.this.f135500v0 && c.this.O != null) {
                c.this.setGestureDetector(this.f135506a);
                if (c.this.I) {
                    c.this.f135491m0 = new PointF(motionEvent.getX(), motionEvent.getY());
                    c.this.P = new PointF(c.this.O.x, c.this.O.y);
                    c cVar = c.this;
                    cVar.N = cVar.M;
                    c.this.f135475e0 = true;
                    c.this.f135471c0 = true;
                    c.this.f135494p0 = -1.0f;
                    c cVar2 = c.this;
                    cVar2.f135497s0 = cVar2.b(cVar2.f135491m0);
                    c.this.f135498t0 = new PointF(motionEvent.getX(), motionEvent.getY());
                    c.this.f135496r0 = new PointF(c.this.f135497s0.x, c.this.f135497s0.y);
                    c.this.f135495q0 = false;
                    return false;
                }
                c cVar3 = c.this;
                cVar3.a(cVar3.b(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (c.this.G && c.this.f135500v0 && c.this.O != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f16) > 500.0f || Math.abs(f17) > 500.0f) && !c.this.f135471c0))) {
                PointF pointF = new PointF(c.this.O.x + (f16 * 0.25f), c.this.O.y + (f17 * 0.25f));
                new e(c.this, new PointF(((c.this.getWidth() / 2) - pointF.x) / c.this.M, ((c.this.getHeight() / 2) - pointF.y) / c.this.M), (a) null).a(1).b(false).b(3).a();
                return true;
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            c.this.performClick();
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n6.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6503c extends GestureDetector.SimpleOnGestureListener {
        public C6503c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            c.this.performClick();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public float f135509a;

        /* renamed from: b, reason: collision with root package name */
        public float f135510b;

        /* renamed from: c, reason: collision with root package name */
        public PointF f135511c;

        /* renamed from: d, reason: collision with root package name */
        public PointF f135512d;

        /* renamed from: e, reason: collision with root package name */
        public PointF f135513e;

        /* renamed from: f, reason: collision with root package name */
        public PointF f135514f;

        /* renamed from: g, reason: collision with root package name */
        public PointF f135515g;

        /* renamed from: h, reason: collision with root package name */
        public long f135516h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f135517i;

        /* renamed from: j, reason: collision with root package name */
        public int f135518j;

        /* renamed from: k, reason: collision with root package name */
        public int f135519k;

        /* renamed from: l, reason: collision with root package name */
        public long f135520l;

        public d() {
            this.f135516h = 500L;
            this.f135517i = true;
            this.f135518j = 2;
            this.f135519k = 1;
            this.f135520l = System.currentTimeMillis();
        }

        public static /* synthetic */ g b(d dVar) {
            dVar.getClass();
            return null;
        }

        public static /* synthetic */ g a(d dVar, g gVar) {
            dVar.getClass();
            return gVar;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        public final float f135521a;

        /* renamed from: b, reason: collision with root package name */
        public final PointF f135522b;

        /* renamed from: c, reason: collision with root package name */
        public final PointF f135523c;

        /* renamed from: d, reason: collision with root package name */
        public long f135524d;

        /* renamed from: e, reason: collision with root package name */
        public int f135525e;

        /* renamed from: f, reason: collision with root package name */
        public int f135526f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f135527g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f135528h;

        public /* synthetic */ e(c cVar, float f16, PointF pointF, PointF pointF2, a aVar) {
            this(f16, pointF, pointF2);
        }

        public final e b(boolean z16) {
            this.f135528h = z16;
            return this;
        }

        public /* synthetic */ e(c cVar, float f16, PointF pointF, a aVar) {
            this(f16, pointF);
        }

        public final e b(int i3) {
            this.f135526f = i3;
            return this;
        }

        public /* synthetic */ e(c cVar, PointF pointF, a aVar) {
            this(pointF);
        }

        public e a(long j3) {
            this.f135524d = j3;
            return this;
        }

        public e(PointF pointF) {
            this.f135524d = 500L;
            this.f135525e = 2;
            this.f135526f = 1;
            this.f135527g = true;
            this.f135528h = true;
            this.f135521a = c.this.M;
            this.f135522b = pointF;
            this.f135523c = null;
        }

        public e a(boolean z16) {
            this.f135527g = z16;
            return this;
        }

        public e a(int i3) {
            if (c.M0.contains(Integer.valueOf(i3))) {
                this.f135525e = i3;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i3);
        }

        public void a() {
            PointF pointF;
            if (c.this.f135499u0 != null) {
                d.b(c.this.f135499u0);
            }
            int paddingLeft = c.this.getPaddingLeft() + (((c.this.getWidth() - c.this.getPaddingRight()) - c.this.getPaddingLeft()) / 2);
            int paddingTop = c.this.getPaddingTop() + (((c.this.getHeight() - c.this.getPaddingBottom()) - c.this.getPaddingTop()) / 2);
            float b16 = c.this.b(this.f135521a);
            if (this.f135528h) {
                c cVar = c.this;
                PointF pointF2 = this.f135522b;
                pointF = cVar.a(pointF2.x, pointF2.y, b16, new PointF());
            } else {
                pointF = this.f135522b;
            }
            a aVar = null;
            c.this.f135499u0 = new d(aVar);
            c.this.f135499u0.f135509a = c.this.M;
            c.this.f135499u0.f135510b = b16;
            c.this.f135499u0.f135520l = System.currentTimeMillis();
            c.this.f135499u0.f135513e = pointF;
            c.this.f135499u0.f135511c = c.this.getCenter();
            c.this.f135499u0.f135512d = pointF;
            c.this.f135499u0.f135514f = c.this.a(pointF);
            c.this.f135499u0.f135515g = new PointF(paddingLeft, paddingTop);
            c.this.f135499u0.f135516h = this.f135524d;
            c.this.f135499u0.f135517i = this.f135527g;
            c.this.f135499u0.f135518j = this.f135525e;
            c.this.f135499u0.f135519k = this.f135526f;
            c.this.f135499u0.f135520l = System.currentTimeMillis();
            d.a(c.this.f135499u0, (g) null);
            PointF pointF3 = this.f135523c;
            if (pointF3 != null) {
                float f16 = pointF3.x - (c.this.f135499u0.f135511c.x * b16);
                float f17 = this.f135523c.y - (c.this.f135499u0.f135511c.y * b16);
                j jVar = new j(b16, new PointF(f16, f17), aVar);
                c.this.a(true, jVar);
                c.this.f135499u0.f135515g = new PointF(this.f135523c.x + (jVar.f135538b.x - f16), this.f135523c.y + (jVar.f135538b.y - f17));
            }
            c.this.invalidate();
        }

        public e(float f16, PointF pointF) {
            this.f135524d = 500L;
            this.f135525e = 2;
            this.f135526f = 1;
            this.f135527g = true;
            this.f135528h = true;
            this.f135521a = f16;
            this.f135522b = pointF;
            this.f135523c = null;
        }

        public e(float f16, PointF pointF, PointF pointF2) {
            this.f135524d = 500L;
            this.f135525e = 2;
            this.f135526f = 1;
            this.f135527g = true;
            this.f135528h = true;
            this.f135521a = f16;
            this.f135522b = pointF;
            this.f135523c = pointF2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface h {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface i {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public float f135537a;

        /* renamed from: b, reason: collision with root package name */
        public final PointF f135538b;

        public /* synthetic */ j(float f16, PointF pointF, a aVar) {
            this(f16, pointF);
        }

        public j(float f16, PointF pointF) {
            this.f135537a = f16;
            this.f135538b = pointF;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public Rect f135539a;

        /* renamed from: b, reason: collision with root package name */
        public int f135540b;

        /* renamed from: c, reason: collision with root package name */
        public Bitmap f135541c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f135542d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f135543e;

        /* renamed from: f, reason: collision with root package name */
        public Rect f135544f;

        /* renamed from: g, reason: collision with root package name */
        public Rect f135545g;

        public k() {
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f135480h = 0;
        this.f135482i = 2.0f;
        this.f135484j = h();
        this.f135486k = -1;
        this.f135488l = 1;
        this.f135490m = 1;
        this.C = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.E = AsyncTask.THREAD_POOL_EXECUTOR;
        this.F = true;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = 1.0f;
        this.K = 1;
        this.L = 500;
        this.f135485j0 = new ReentrantReadWriteLock(true);
        this.f135487k0 = new com.tencent.luggage.wxa.o6.a(SkiaImageDecoder.class);
        this.f135489l0 = new com.tencent.luggage.wxa.o6.a(SkiaImageRegionDecoder.class);
        this.G0 = new float[8];
        this.H0 = new float[8];
        this.I0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.f135503y0 = new Handler(new a());
        this.f135493o0 = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return P0;
    }

    @AnyThread
    private int getRequiredRotation() {
        int i3 = this.f135480h;
        if (i3 == -1) {
            return this.W;
        }
        return i3;
    }

    public static /* synthetic */ h h(c cVar) {
        cVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        this.f135479g0 = new GestureDetector(context, new b(context));
        this.f135481h0 = new GestureDetector(context, new C6503c());
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        P0 = config;
    }

    public final float a(long j3, float f16, float f17, long j16) {
        float f18;
        float f19 = ((float) j3) / (((float) j16) / 2.0f);
        if (f19 < 1.0f) {
            f18 = (f17 / 2.0f) * f19;
        } else {
            float f26 = f19 - 1.0f;
            f18 = (-f17) / 2.0f;
            f19 = (f26 * (f26 - 2.0f)) - 1.0f;
        }
        return (f18 * f19) + f16;
    }

    public final float b(long j3, float f16, float f17, long j16) {
        float f18 = ((float) j3) / ((float) j16);
        return ((-f17) * f18 * (f18 - 2.0f)) + f16;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    @Nullable
    public final PointF getCenter() {
        return a(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.f135482i;
    }

    public final float getMinScale() {
        return h();
    }

    public final int getOrientation() {
        return this.f135480h;
    }

    public final int getSHeight() {
        return this.V;
    }

    public final int getSWidth() {
        return this.U;
    }

    public final float getScale() {
        return this.M;
    }

    @Nullable
    public Uri getSourceUri() {
        return this.f135472d;
    }

    @Nullable
    public final com.tencent.luggage.wxa.n6.b getState() {
        if (this.O != null && this.U > 0 && this.V > 0) {
            return new com.tencent.luggage.wxa.n6.b(getScale(), getCenter(), getOrientation());
        }
        return null;
    }

    public void i() {
    }

    public void j() {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        float f16;
        int i16;
        int i17;
        int i18;
        super.onDraw(canvas);
        e();
        if (this.U == 0 || this.V == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.f135476f == null && this.f135483i0 != null) {
            a(a(canvas));
        }
        if (d()) {
            l();
            d dVar = this.f135499u0;
            if (dVar != null && dVar.f135514f != null) {
                float f17 = this.M;
                if (this.Q == null) {
                    this.Q = new PointF(0.0f, 0.0f);
                }
                this.Q.set(this.O);
                long currentTimeMillis = System.currentTimeMillis() - this.f135499u0.f135520l;
                boolean z16 = currentTimeMillis > this.f135499u0.f135516h;
                long min = Math.min(currentTimeMillis, this.f135499u0.f135516h);
                this.M = a(this.f135499u0.f135518j, min, this.f135499u0.f135509a, this.f135499u0.f135510b - this.f135499u0.f135509a, this.f135499u0.f135516h);
                float a16 = a(this.f135499u0.f135518j, min, this.f135499u0.f135514f.x, this.f135499u0.f135515g.x - this.f135499u0.f135514f.x, this.f135499u0.f135516h);
                float a17 = a(this.f135499u0.f135518j, min, this.f135499u0.f135514f.y, this.f135499u0.f135515g.y - this.f135499u0.f135514f.y, this.f135499u0.f135516h);
                this.O.x -= c(this.f135499u0.f135512d.x) - a16;
                this.O.y -= d(this.f135499u0.f135512d.y) - a17;
                a(z16 || this.f135499u0.f135509a == this.f135499u0.f135510b);
                a(f17, this.Q, this.f135499u0.f135519k);
                b(z16);
                if (z16) {
                    d.b(this.f135499u0);
                    this.f135499u0 = null;
                }
                invalidate();
            }
            int i19 = 180;
            char c16 = '#';
            char c17 = 15;
            int i26 = 5;
            if (this.f135476f != null && f()) {
                int min2 = Math.min(this.f135474e, a(this.M));
                boolean z17 = false;
                for (Map.Entry entry : this.f135476f.entrySet()) {
                    if (((Integer) entry.getKey()).intValue() == min2) {
                        for (k kVar : (List) entry.getValue()) {
                            if (kVar.f135543e && (kVar.f135542d || kVar.f135541c == null)) {
                                z17 = true;
                            }
                        }
                    }
                }
                for (Map.Entry entry2 : this.f135476f.entrySet()) {
                    if (((Integer) entry2.getKey()).intValue() == min2 || z17) {
                        for (k kVar2 : (List) entry2.getValue()) {
                            b(kVar2.f135539a, kVar2.f135544f);
                            if (kVar2.f135542d || kVar2.f135541c == null) {
                                i16 = i26;
                                i17 = min2;
                                i18 = i19;
                                if (kVar2.f135542d && this.f135478g) {
                                    canvas.drawText("LOADING", kVar2.f135544f.left + a(i16), kVar2.f135544f.top + a(35), this.A0);
                                }
                            } else {
                                if (this.C0 != null) {
                                    canvas.drawRect(kVar2.f135544f, this.C0);
                                }
                                if (this.E0 == null) {
                                    this.E0 = new Matrix();
                                }
                                this.E0.reset();
                                i16 = i26;
                                i17 = min2;
                                i18 = i19;
                                a(this.G0, 0.0f, 0.0f, kVar2.f135541c.getWidth(), 0.0f, kVar2.f135541c.getWidth(), kVar2.f135541c.getHeight(), 0.0f, kVar2.f135541c.getHeight());
                                if (getRequiredRotation() == 0) {
                                    a(this.H0, kVar2.f135544f.left, kVar2.f135544f.top, kVar2.f135544f.right, kVar2.f135544f.top, kVar2.f135544f.right, kVar2.f135544f.bottom, kVar2.f135544f.left, kVar2.f135544f.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    a(this.H0, kVar2.f135544f.right, kVar2.f135544f.top, kVar2.f135544f.right, kVar2.f135544f.bottom, kVar2.f135544f.left, kVar2.f135544f.bottom, kVar2.f135544f.left, kVar2.f135544f.top);
                                } else if (getRequiredRotation() == i18) {
                                    a(this.H0, kVar2.f135544f.right, kVar2.f135544f.bottom, kVar2.f135544f.left, kVar2.f135544f.bottom, kVar2.f135544f.left, kVar2.f135544f.top, kVar2.f135544f.right, kVar2.f135544f.top);
                                } else if (getRequiredRotation() == 270) {
                                    a(this.H0, kVar2.f135544f.left, kVar2.f135544f.bottom, kVar2.f135544f.left, kVar2.f135544f.top, kVar2.f135544f.right, kVar2.f135544f.top, kVar2.f135544f.right, kVar2.f135544f.bottom);
                                }
                                this.E0.setPolyToPoly(this.G0, 0, this.H0, 0, 4);
                                canvas.drawBitmap(kVar2.f135541c, this.E0, this.f135504z0);
                                if (this.f135478g) {
                                    canvas.drawRect(kVar2.f135544f, this.B0);
                                }
                            }
                            if (kVar2.f135543e && this.f135478g) {
                                canvas.drawText("ISS " + kVar2.f135540b + " RECT " + kVar2.f135539a.top + "," + kVar2.f135539a.left + "," + kVar2.f135539a.bottom + "," + kVar2.f135539a.right, kVar2.f135544f.left + a(i16), kVar2.f135544f.top + a(15), this.A0);
                            }
                            i19 = i18;
                            i26 = i16;
                            min2 = i17;
                            c17 = 15;
                            c16 = '#';
                        }
                    }
                }
                i3 = i26;
            } else {
                i3 = 5;
                Bitmap bitmap = this.f135466a;
                if (bitmap != null && !bitmap.isRecycled()) {
                    float f18 = this.M;
                    if (this.f135468b) {
                        f18 *= this.U / this.f135466a.getWidth();
                        f16 = this.M * (this.V / this.f135466a.getHeight());
                    } else {
                        f16 = f18;
                    }
                    if (this.E0 == null) {
                        this.E0 = new Matrix();
                    }
                    this.E0.reset();
                    this.E0.postScale(f18, f16);
                    this.E0.postRotate(getRequiredRotation());
                    Matrix matrix = this.E0;
                    PointF pointF = this.O;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.E0;
                        float f19 = this.M;
                        matrix2.postTranslate(this.U * f19, f19 * this.V);
                    } else if (getRequiredRotation() == 90) {
                        this.E0.postTranslate(this.M * this.V, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.E0.postTranslate(0.0f, this.M * this.U);
                    }
                    if (this.C0 != null) {
                        if (this.F0 == null) {
                            this.F0 = new RectF();
                        }
                        this.F0.set(0.0f, 0.0f, this.f135468b ? this.f135466a.getWidth() : this.U, this.f135468b ? this.f135466a.getHeight() : this.V);
                        this.E0.mapRect(this.F0);
                        canvas.drawRect(this.F0, this.C0);
                    }
                    canvas.drawBitmap(this.f135466a, this.E0, this.f135504z0);
                }
            }
            if (this.f135478g) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Scale: ");
                Locale locale = Locale.ENGLISH;
                sb5.append(String.format(locale, "%.2f", Float.valueOf(this.M)));
                sb5.append(" (");
                sb5.append(String.format(locale, "%.2f", Float.valueOf(h())));
                sb5.append(" - ");
                sb5.append(String.format(locale, "%.2f", Float.valueOf(this.f135482i)));
                sb5.append(")");
                canvas.drawText(sb5.toString(), a(i3), a(15), this.A0);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.O.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(this.O.y)), a(i3), a(30), this.A0);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(center.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(center.y)), a(i3), a(45), this.A0);
                d dVar2 = this.f135499u0;
                if (dVar2 != null) {
                    PointF a18 = a(dVar2.f135511c);
                    PointF a19 = a(this.f135499u0.f135513e);
                    PointF a26 = a(this.f135499u0.f135512d);
                    canvas.drawCircle(a18.x, a18.y, a(10), this.B0);
                    this.B0.setColor(SupportMenu.CATEGORY_MASK);
                    canvas.drawCircle(a19.x, a19.y, a(20), this.B0);
                    this.B0.setColor(-16776961);
                    canvas.drawCircle(a26.x, a26.y, a(25), this.B0);
                    this.B0.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, a(30), this.B0);
                }
                if (this.f135491m0 != null) {
                    this.B0.setColor(SupportMenu.CATEGORY_MASK);
                    PointF pointF2 = this.f135491m0;
                    canvas.drawCircle(pointF2.x, pointF2.y, a(20), this.B0);
                }
                if (this.f135497s0 != null) {
                    this.B0.setColor(-16776961);
                    canvas.drawCircle(c(this.f135497s0.x), d(this.f135497s0.y), a(35), this.B0);
                }
                if (this.f135498t0 != null && this.f135475e0) {
                    this.B0.setColor(-16711681);
                    PointF pointF3 = this.f135498t0;
                    canvas.drawCircle(pointF3.x, pointF3.y, a(30), this.B0);
                }
                this.B0.setColor(-65281);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        boolean z16;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        boolean z17 = true;
        if (mode != 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (mode2 == 1073741824) {
            z17 = false;
        }
        if (this.U > 0 && this.V > 0) {
            if (z16 && z17) {
                size = n();
                size2 = m();
            } else if (z17) {
                size2 = (int) ((m() / n()) * size);
            } else if (z16) {
                size = (int) ((n() / m()) * size2);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        a("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i3), Integer.valueOf(i16));
        PointF center = getCenter();
        if (this.f135500v0 && center != null) {
            this.f135499u0 = null;
            this.R = Float.valueOf(this.M);
            this.S = center;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        d dVar = this.f135499u0;
        if (dVar != null && !dVar.f135517i) {
            c(true);
            return true;
        }
        d dVar2 = this.f135499u0;
        if (dVar2 != null) {
            d.b(dVar2);
        }
        this.f135499u0 = null;
        if (this.O == null) {
            GestureDetector gestureDetector2 = this.f135481h0;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.f135475e0 && ((gestureDetector = this.f135479g0) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.f135471c0 = false;
            this.f135473d0 = false;
            this.f135477f0 = 0;
            return true;
        }
        if (this.P == null) {
            this.P = new PointF(0.0f, 0.0f);
        }
        if (this.Q == null) {
            this.Q = new PointF(0.0f, 0.0f);
        }
        if (this.f135491m0 == null) {
            this.f135491m0 = new PointF(0.0f, 0.0f);
        }
        float f16 = this.M;
        this.Q.set(this.O);
        boolean a16 = a(motionEvent);
        a(f16, this.Q, 2);
        if (a16 || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public final void setBitmapDecoderClass(@NonNull Class<? extends com.tencent.luggage.wxa.o6.c> cls) {
        if (cls != null) {
            this.f135487k0 = new com.tencent.luggage.wxa.o6.a(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(@NonNull com.tencent.luggage.wxa.o6.b bVar) {
        if (bVar != null) {
            this.f135487k0 = bVar;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z16) {
        this.f135478g = z16;
    }

    public final void setDoubleTapZoomDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setDoubleTapZoomDuration(int i3) {
        this.L = Math.max(0, i3);
    }

    public final void setDoubleTapZoomScale(float f16) {
        this.J = f16;
    }

    public final void setDoubleTapZoomStyle(int i3) {
        if (L0.contains(Integer.valueOf(i3))) {
            this.K = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i3);
    }

    public void setEagerLoadingEnabled(boolean z16) {
        this.F = z16;
    }

    public void setExecutor(@NonNull Executor executor) {
        if (executor != null) {
            this.E = executor;
            return;
        }
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(@NonNull com.tencent.luggage.wxa.n6.a aVar) {
        a(aVar, (com.tencent.luggage.wxa.n6.a) null, (com.tencent.luggage.wxa.n6.b) null);
    }

    public final void setMaxScale(float f16) {
        this.f135482i = f16;
    }

    public void setMaxTileSize(int i3) {
        this.C = i3;
        this.D = i3;
    }

    public final void setMaximumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinScale(float f16) {
        this.f135484j = f16;
    }

    public final void setMinimumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinimumScaleType(int i3) {
        if (O0.contains(Integer.valueOf(i3))) {
            this.f135490m = i3;
            if (g()) {
                a(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i3);
    }

    public void setMinimumTileDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f135486k = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i3);
        if (g()) {
            d(false);
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f135502x0 = onLongClickListener;
    }

    public final void setOrientation(int i3) {
        if (K0.contains(Integer.valueOf(i3))) {
            this.f135480h = i3;
            d(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i3);
    }

    public final void setPanEnabled(boolean z16) {
        PointF pointF;
        this.G = z16;
        if (!z16 && (pointF = this.O) != null) {
            pointF.x = (getWidth() / 2) - (this.M * (n() / 2));
            this.O.y = (getHeight() / 2) - (this.M * (m() / 2));
            if (g()) {
                b(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i3) {
        if (N0.contains(Integer.valueOf(i3))) {
            this.f135488l = i3;
            if (g()) {
                a(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i3);
    }

    public final void setQuickScaleEnabled(boolean z16) {
        this.I = z16;
    }

    public final void setRegionDecoderClass(@NonNull Class<? extends com.tencent.luggage.wxa.o6.d> cls) {
        if (cls != null) {
            this.f135489l0 = new com.tencent.luggage.wxa.o6.a(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(@NonNull com.tencent.luggage.wxa.o6.b bVar) {
        if (bVar != null) {
            this.f135489l0 = bVar;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setTileBackgroundColor(int i3) {
        if (Color.alpha(i3) == 0) {
            this.C0 = null;
        } else {
            Paint paint = new Paint();
            this.C0 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.C0.setColor(i3);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z16) {
        this.H = z16;
    }

    public final void a(float f16, PointF pointF, int i3) {
    }

    public final boolean f() {
        boolean z16 = true;
        if (this.f135466a != null && !this.f135468b) {
            return true;
        }
        Map map = this.f135476f;
        if (map == null) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == this.f135474e) {
                for (k kVar : (List) entry.getValue()) {
                    if (kVar.f135542d || kVar.f135541c == null) {
                        z16 = false;
                    }
                }
            }
        }
        return z16;
    }

    public final boolean g() {
        return this.f135500v0;
    }

    public final float h() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i3 = this.f135490m;
        if (i3 != 2 && i3 != 4) {
            if (i3 == 3) {
                float f16 = this.f135484j;
                if (f16 > 0.0f) {
                    return f16;
                }
            }
            return Math.min((getWidth() - paddingLeft) / n(), (getHeight() - paddingBottom) / m());
        }
        return Math.max((getWidth() - paddingLeft) / n(), (getHeight() - paddingBottom) / m());
    }

    public final synchronized void k() {
        Bitmap bitmap;
        a("onTileLoaded", new Object[0]);
        d();
        c();
        if (f() && (bitmap = this.f135466a) != null) {
            if (!this.f135470c) {
                bitmap.recycle();
            }
            this.f135466a = null;
            this.f135468b = false;
            this.f135470c = false;
        }
        invalidate();
    }

    public final void l() {
        Float f16;
        if (getWidth() == 0 || getHeight() == 0 || this.U <= 0 || this.V <= 0) {
            return;
        }
        if (this.S != null && (f16 = this.R) != null) {
            this.M = f16.floatValue();
            if (this.O == null) {
                this.O = new PointF();
            }
            this.O.x = (getWidth() / 2) - (this.M * this.S.x);
            this.O.y = (getHeight() / 2) - (this.M * this.S.y);
            this.S = null;
            this.R = null;
            a(true);
            b(true);
        }
        a(false);
    }

    public final int m() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.V;
        }
        return this.U;
    }

    public final int n() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.U;
        }
        return this.V;
    }

    public final void d(boolean z16) {
        a("reset newImage=" + z16, new Object[0]);
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = Float.valueOf(0.0f);
        this.S = null;
        this.T = null;
        this.f135471c0 = false;
        this.f135473d0 = false;
        this.f135475e0 = false;
        this.f135477f0 = 0;
        this.f135474e = 0;
        this.f135491m0 = null;
        this.f135492n0 = 0.0f;
        this.f135494p0 = 0.0f;
        this.f135495q0 = false;
        this.f135497s0 = null;
        this.f135496r0 = null;
        this.f135498t0 = null;
        this.f135499u0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        if (z16) {
            this.f135472d = null;
            this.f135485j0.writeLock().lock();
            try {
                com.tencent.luggage.wxa.o6.d dVar = this.f135483i0;
                if (dVar != null) {
                    dVar.recycle();
                    this.f135483i0 = null;
                }
                this.f135485j0.writeLock().unlock();
                Bitmap bitmap = this.f135466a;
                if (bitmap != null && !this.f135470c) {
                    bitmap.recycle();
                }
                this.U = 0;
                this.V = 0;
                this.W = 0;
                this.f135467a0 = null;
                this.f135469b0 = null;
                this.f135500v0 = false;
                this.f135501w0 = false;
                this.f135466a = null;
                this.f135468b = false;
                this.f135470c = false;
            } catch (Throwable th5) {
                this.f135485j0.writeLock().unlock();
                throw th5;
            }
        }
        Map map = this.f135476f;
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (k kVar : (List) ((Map.Entry) it.next()).getValue()) {
                    kVar.f135543e = false;
                    if (kVar.f135541c != null) {
                        kVar.f135541c.recycle();
                        kVar.f135541c = null;
                    }
                }
            }
            this.f135476f = null;
        }
        setGestureDetector(getContext());
    }

    public final void e() {
        if (this.f135504z0 == null) {
            Paint paint = new Paint();
            this.f135504z0 = paint;
            paint.setAntiAlias(true);
            this.f135504z0.setFilterBitmap(true);
            this.f135504z0.setDither(true);
        }
        if ((this.A0 == null || this.B0 == null) && this.f135478g) {
            Paint paint2 = new Paint();
            this.A0 = paint2;
            paint2.setTextSize(a(12));
            this.A0.setColor(-65281);
            this.A0.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.B0 = paint3;
            paint3.setColor(-65281);
            this.B0.setStyle(Paint.Style.STROKE);
            this.B0.setStrokeWidth(a(1));
        }
    }

    public final void c(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    public final boolean c() {
        boolean f16 = f();
        if (!this.f135501w0 && f16) {
            l();
            this.f135501w0 = true;
            i();
        }
        return f16;
    }

    public final void b(boolean z16) {
        if (this.f135483i0 == null || this.f135476f == null) {
            return;
        }
        int min = Math.min(this.f135474e, a(this.M));
        Iterator it = this.f135476f.entrySet().iterator();
        while (it.hasNext()) {
            for (k kVar : (List) ((Map.Entry) it.next()).getValue()) {
                if (kVar.f135540b < min || (kVar.f135540b > min && kVar.f135540b != this.f135474e)) {
                    kVar.f135543e = false;
                    if (kVar.f135541c != null) {
                        kVar.f135541c.recycle();
                        kVar.f135541c = null;
                    }
                }
                if (kVar.f135540b != min) {
                    if (kVar.f135540b == this.f135474e) {
                        kVar.f135543e = true;
                    }
                } else if (!a(kVar)) {
                    if (kVar.f135540b != this.f135474e) {
                        kVar.f135543e = false;
                        if (kVar.f135541c != null) {
                            kVar.f135541c.recycle();
                            kVar.f135541c = null;
                        }
                    }
                } else {
                    kVar.f135543e = true;
                    if (!kVar.f135542d && kVar.f135541c == null && z16) {
                        a(new l(this, this.f135483i0, kVar));
                    }
                }
            }
        }
    }

    public final float f(float f16) {
        PointF pointF = this.O;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 - pointF.y) / this.M;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f135530a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f135531b;

        /* renamed from: c, reason: collision with root package name */
        public final WeakReference f135532c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri f135533d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f135534e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f135535f;

        /* renamed from: g, reason: collision with root package name */
        public Exception f135536g;

        public f(c cVar, Context context, com.tencent.luggage.wxa.o6.b bVar, Uri uri, boolean z16) {
            this.f135530a = new WeakReference(cVar);
            this.f135531b = new WeakReference(context);
            this.f135532c = new WeakReference(bVar);
            this.f135533d = uri;
            this.f135534e = z16;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.f135533d.toString();
                Context context = (Context) this.f135531b.get();
                com.tencent.luggage.wxa.o6.b bVar = (com.tencent.luggage.wxa.o6.b) this.f135532c.get();
                c cVar = (c) this.f135530a.get();
                if (context == null || bVar == null || cVar == null) {
                    return null;
                }
                cVar.a("BitmapLoadTask.doInBackground", new Object[0]);
                this.f135535f = ((com.tencent.luggage.wxa.o6.c) bVar.make()).decode(context, this.f135533d);
                return Integer.valueOf(cVar.a(context, uri));
            } catch (Exception e16) {
                Log.e(c.J0, "Failed to load bitmap", e16);
                this.f135536g = e16;
                return null;
            } catch (OutOfMemoryError e17) {
                Log.e(c.J0, "Failed to load bitmap - OutOfMemoryError", e17);
                this.f135536g = new RuntimeException(e17);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            c cVar = (c) this.f135530a.get();
            if (cVar != null) {
                Bitmap bitmap = this.f135535f;
                if (bitmap != null && num != null) {
                    if (this.f135534e) {
                        cVar.a(bitmap);
                        return;
                    } else {
                        cVar.a(bitmap, num.intValue(), false);
                        return;
                    }
                }
                if (this.f135536g != null) {
                    c.h(cVar);
                }
            }
        }
    }

    public final float c(float f16) {
        PointF pointF = this.O;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 * this.M) + pointF.x;
    }

    public final float e(float f16) {
        PointF pointF = this.O;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 - pointF.x) / this.M;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class m extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f135550a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f135551b;

        /* renamed from: c, reason: collision with root package name */
        public final WeakReference f135552c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri f135553d;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.luggage.wxa.o6.d f135554e;

        /* renamed from: f, reason: collision with root package name */
        public Exception f135555f;

        public m(c cVar, Context context, com.tencent.luggage.wxa.o6.b bVar, Uri uri) {
            this.f135550a = new WeakReference(cVar);
            this.f135551b = new WeakReference(context);
            this.f135552c = new WeakReference(bVar);
            this.f135553d = uri;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.f135553d.toString();
                Context context = (Context) this.f135551b.get();
                com.tencent.luggage.wxa.o6.b bVar = (com.tencent.luggage.wxa.o6.b) this.f135552c.get();
                c cVar = (c) this.f135550a.get();
                if (context == null || bVar == null || cVar == null) {
                    return null;
                }
                cVar.a("TilesInitTask.doInBackground", new Object[0]);
                com.tencent.luggage.wxa.o6.d dVar = (com.tencent.luggage.wxa.o6.d) bVar.make();
                this.f135554e = dVar;
                Point init = dVar.init(context, this.f135553d);
                int i3 = init.x;
                int i16 = init.y;
                int a16 = cVar.a(context, uri);
                if (cVar.f135467a0 != null) {
                    cVar.f135467a0.left = Math.max(0, cVar.f135467a0.left);
                    cVar.f135467a0.top = Math.max(0, cVar.f135467a0.top);
                    cVar.f135467a0.right = Math.min(i3, cVar.f135467a0.right);
                    cVar.f135467a0.bottom = Math.min(i16, cVar.f135467a0.bottom);
                    i3 = cVar.f135467a0.width();
                    i16 = cVar.f135467a0.height();
                }
                return new int[]{i3, i16, a16};
            } catch (Exception e16) {
                Log.e(c.J0, "Failed to initialise bitmap decoder", e16);
                this.f135555f = e16;
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(int[] iArr) {
            c cVar = (c) this.f135550a.get();
            if (cVar != null) {
                com.tencent.luggage.wxa.o6.d dVar = this.f135554e;
                if (dVar != null && iArr != null && iArr.length == 3) {
                    cVar.a(dVar, iArr[0], iArr[1], iArr[2]);
                } else if (this.f135555f != null) {
                    c.h(cVar);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class l extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f135546a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f135547b;

        /* renamed from: c, reason: collision with root package name */
        public final WeakReference f135548c;

        /* renamed from: d, reason: collision with root package name */
        public Exception f135549d;

        public l(c cVar, com.tencent.luggage.wxa.o6.d dVar, k kVar) {
            this.f135546a = new WeakReference(cVar);
            this.f135547b = new WeakReference(dVar);
            this.f135548c = new WeakReference(kVar);
            kVar.f135542d = true;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            try {
                c cVar = (c) this.f135546a.get();
                com.tencent.luggage.wxa.o6.d dVar = (com.tencent.luggage.wxa.o6.d) this.f135547b.get();
                k kVar = (k) this.f135548c.get();
                if (dVar == null || kVar == null || cVar == null || !dVar.isReady() || !kVar.f135543e) {
                    if (kVar == null) {
                        return null;
                    }
                    kVar.f135542d = false;
                    return null;
                }
                cVar.a("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", kVar.f135539a, Integer.valueOf(kVar.f135540b));
                cVar.f135485j0.readLock().lock();
                try {
                    if (!dVar.isReady()) {
                        kVar.f135542d = false;
                        cVar.f135485j0.readLock().unlock();
                        return null;
                    }
                    cVar.a(kVar.f135539a, kVar.f135545g);
                    if (cVar.f135467a0 != null) {
                        kVar.f135545g.offset(cVar.f135467a0.left, cVar.f135467a0.top);
                    }
                    return dVar.decodeRegion(kVar.f135545g, kVar.f135540b);
                } finally {
                    cVar.f135485j0.readLock().unlock();
                }
            } catch (Exception e16) {
                Log.e(c.J0, "Failed to decode tile", e16);
                this.f135549d = e16;
                return null;
            } catch (OutOfMemoryError e17) {
                Log.e(c.J0, "Failed to decode tile - OutOfMemoryError", e17);
                this.f135549d = new RuntimeException(e17);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            c cVar = (c) this.f135546a.get();
            k kVar = (k) this.f135548c.get();
            if (cVar == null || kVar == null) {
                return;
            }
            if (bitmap != null) {
                kVar.f135541c = bitmap;
                kVar.f135542d = false;
                cVar.k();
            } else if (this.f135549d != null) {
                c.h(cVar);
            }
        }
    }

    public final void a(com.tencent.luggage.wxa.n6.a aVar, com.tencent.luggage.wxa.n6.a aVar2, com.tencent.luggage.wxa.n6.b bVar) {
        if (aVar != null) {
            d(true);
            if (bVar != null) {
                a(bVar);
            }
            if (aVar2 != null) {
                if (aVar.a() == null) {
                    if (aVar.e() > 0 && aVar.c() > 0) {
                        this.U = aVar.e();
                        this.V = aVar.c();
                        this.f135469b0 = aVar2.d();
                        if (aVar2.a() != null) {
                            this.f135470c = aVar2.h();
                            a(aVar2.a());
                        } else {
                            Uri g16 = aVar2.g();
                            if (g16 == null && aVar2.b() != null) {
                                g16 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar2.b());
                            }
                            a(new f(this, getContext(), this.f135487k0, g16, true));
                        }
                    } else {
                        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                }
            }
            if (aVar.a() != null && aVar.d() != null) {
                a(Bitmap.createBitmap(aVar.a(), aVar.d().left, aVar.d().top, aVar.d().width(), aVar.d().height()), 0, false);
                return;
            }
            if (aVar.a() != null) {
                a(aVar.a(), 0, aVar.h());
                return;
            }
            this.f135467a0 = aVar.d();
            Uri g17 = aVar.g();
            this.f135472d = g17;
            if (g17 == null && aVar.b() != null) {
                this.f135472d = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar.b());
            }
            if (!aVar.f() && this.f135467a0 == null) {
                a(new f(this, getContext(), this.f135487k0, this.f135472d, false));
                return;
            } else {
                a(new m(this, getContext(), this.f135489l0, this.f135472d));
                return;
            }
        }
        throw new NullPointerException("imageSource must not be null");
    }

    public c(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Point point) {
        int i3 = 0;
        int i16 = 1;
        a("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.f135476f = new LinkedHashMap();
        int i17 = this.f135474e;
        int i18 = 1;
        int i19 = 1;
        while (true) {
            int n3 = n() / i18;
            int m3 = m() / i19;
            int i26 = n3 / i17;
            int i27 = m3 / i17;
            while (true) {
                if (i26 + i18 + i16 > point.x || (i26 > getWidth() * 1.25d && i17 < this.f135474e)) {
                    i18++;
                    n3 = n() / i18;
                    i26 = n3 / i17;
                    i16 = i16;
                    i3 = i3;
                }
            }
            while (true) {
                if (i27 + i19 + i16 > point.y || (i27 > getHeight() * 1.25d && i17 < this.f135474e)) {
                    i19++;
                    m3 = m() / i19;
                    i27 = m3 / i17;
                    i16 = i16;
                    i3 = i3;
                }
            }
            ArrayList arrayList = new ArrayList(i18 * i19);
            int i28 = i3;
            while (i28 < i18) {
                int i29 = i3;
                while (i29 < i19) {
                    k kVar = new k(null);
                    kVar.f135540b = i17;
                    kVar.f135543e = i17 == this.f135474e ? i16 : i3;
                    kVar.f135539a = new Rect(i28 * n3, i29 * m3, i28 == i18 + (-1) ? n() : (i28 + 1) * n3, i29 == i19 + (-1) ? m() : (i29 + 1) * m3);
                    kVar.f135544f = new Rect(0, 0, 0, 0);
                    kVar.f135545g = new Rect(kVar.f135539a);
                    arrayList.add(kVar);
                    i29++;
                    i3 = 0;
                    i16 = 1;
                }
                i28++;
                i16 = 1;
            }
            int i36 = i3;
            this.f135476f.put(Integer.valueOf(i17), arrayList);
            if (i17 == 1) {
                return;
            }
            i17 /= 2;
            i16 = 1;
            i3 = i36;
        }
    }

    public void setOnImageEventListener(h hVar) {
    }

    public void setOnStateChangedListener(i iVar) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r1 != 262) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f135477f0 > 0) {
                        if (pointerCount >= 2) {
                            float a16 = a(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                            float x16 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                            float y16 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                            if (this.H) {
                                PointF pointF = this.f135491m0;
                                if (a(pointF.x, x16, pointF.y, y16) > 5.0f || Math.abs(a16 - this.f135492n0) > 5.0f || this.f135473d0) {
                                    this.f135471c0 = true;
                                    this.f135473d0 = true;
                                    double d16 = this.M;
                                    float min = Math.min(this.f135482i, (a16 / this.f135492n0) * this.N);
                                    this.M = min;
                                    if (min <= h()) {
                                        this.f135492n0 = a16;
                                        this.N = h();
                                        this.f135491m0.set(x16, y16);
                                        this.P.set(this.O);
                                    } else if (this.G) {
                                        PointF pointF2 = this.f135491m0;
                                        float f16 = pointF2.x;
                                        PointF pointF3 = this.P;
                                        float f17 = f16 - pointF3.x;
                                        float f18 = pointF2.y - pointF3.y;
                                        float f19 = this.M / this.N;
                                        float f26 = f17 * f19;
                                        float f27 = f18 * f19;
                                        PointF pointF4 = this.O;
                                        pointF4.x = x16 - f26;
                                        pointF4.y = y16 - f27;
                                        if ((m() * d16 < getHeight() && this.M * m() >= getHeight()) || (d16 * n() < getWidth() && this.M * n() >= getWidth())) {
                                            a(true);
                                            this.f135491m0.set(x16, y16);
                                            this.P.set(this.O);
                                            this.N = this.M;
                                            this.f135492n0 = a16;
                                        }
                                    } else if (this.T != null) {
                                        this.O.x = (getWidth() / 2) - (this.M * this.T.x);
                                        this.O.y = (getHeight() / 2) - (this.M * this.T.y);
                                    } else {
                                        this.O.x = (getWidth() / 2) - (this.M * (n() / 2));
                                        this.O.y = (getHeight() / 2) - (this.M * (m() / 2));
                                    }
                                    a(true);
                                    b(this.F);
                                    z17 = true;
                                }
                            }
                        } else {
                            if (this.f135475e0) {
                                float abs = (Math.abs(this.f135498t0.y - motionEvent.getY()) * 2.0f) + this.f135493o0;
                                if (this.f135494p0 == -1.0f) {
                                    this.f135494p0 = abs;
                                }
                                float y17 = motionEvent.getY();
                                PointF pointF5 = this.f135496r0;
                                boolean z18 = y17 > pointF5.y;
                                pointF5.set(0.0f, motionEvent.getY());
                                float abs2 = Math.abs(1.0f - (abs / this.f135494p0)) * 0.5f;
                                if (abs2 > 0.03f || this.f135495q0) {
                                    this.f135495q0 = true;
                                    float f28 = this.f135494p0 > 0.0f ? z18 ? 1.0f + abs2 : 1.0f - abs2 : 1.0f;
                                    double d17 = this.M;
                                    float max = Math.max(h(), Math.min(this.f135482i, this.M * f28));
                                    this.M = max;
                                    if (this.G) {
                                        PointF pointF6 = this.f135491m0;
                                        float f29 = pointF6.x;
                                        PointF pointF7 = this.P;
                                        float f36 = f29 - pointF7.x;
                                        float f37 = pointF6.y;
                                        float f38 = f37 - pointF7.y;
                                        float f39 = max / this.N;
                                        float f46 = f36 * f39;
                                        float f47 = f38 * f39;
                                        PointF pointF8 = this.O;
                                        pointF8.x = f29 - f46;
                                        pointF8.y = f37 - f47;
                                        if ((m() * d17 < getHeight() && this.M * m() >= getHeight()) || (d17 * n() < getWidth() && this.M * n() >= getWidth())) {
                                            a(true);
                                            this.f135491m0.set(a(this.f135497s0));
                                            this.P.set(this.O);
                                            this.N = this.M;
                                            abs = 0.0f;
                                        }
                                    } else if (this.T != null) {
                                        this.O.x = (getWidth() / 2) - (this.M * this.T.x);
                                        this.O.y = (getHeight() / 2) - (this.M * this.T.y);
                                    } else {
                                        this.O.x = (getWidth() / 2) - (this.M * (n() / 2));
                                        this.O.y = (getHeight() / 2) - (this.M * (m() / 2));
                                    }
                                }
                                this.f135494p0 = abs;
                                a(true);
                                b(this.F);
                            } else if (!this.f135471c0) {
                                float abs3 = Math.abs(motionEvent.getX() - this.f135491m0.x);
                                float abs4 = Math.abs(motionEvent.getY() - this.f135491m0.y);
                                float f48 = this.I0 * 5.0f;
                                if (abs3 > f48 || abs4 > f48 || this.f135473d0) {
                                    this.O.x = this.P.x + (motionEvent.getX() - this.f135491m0.x);
                                    this.O.y = this.P.y + (motionEvent.getY() - this.f135491m0.y);
                                    PointF pointF9 = this.O;
                                    float f49 = pointF9.x;
                                    float f56 = pointF9.y;
                                    a(true);
                                    PointF pointF10 = this.O;
                                    boolean z19 = f49 != pointF10.x;
                                    float f57 = pointF10.y;
                                    boolean z26 = f56 != f57;
                                    boolean z27 = z19 && abs3 > abs4 && !this.f135473d0;
                                    boolean z28 = z26 && abs4 > abs3 && !this.f135473d0;
                                    boolean z29 = f56 == f57 && abs4 > 3.0f * f48;
                                    if (!z27 && !z28 && (!z19 || !z26 || z29 || this.f135473d0)) {
                                        this.f135473d0 = true;
                                    } else if (abs3 > f48 || abs4 > f48) {
                                        this.f135477f0 = 0;
                                        this.f135503y0.removeMessages(1);
                                        c(false);
                                    }
                                    if (!this.G) {
                                        PointF pointF11 = this.O;
                                        PointF pointF12 = this.P;
                                        pointF11.x = pointF12.x;
                                        pointF11.y = pointF12.y;
                                        c(false);
                                    }
                                    b(this.F);
                                }
                            }
                            z17 = true;
                        }
                        if (z17) {
                            this.f135503y0.removeMessages(1);
                            invalidate();
                            return true;
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                } else if (action != 5) {
                    if (action != 6) {
                        if (action != 261) {
                        }
                    }
                }
                return false;
            }
            this.f135503y0.removeMessages(1);
            if (this.f135475e0) {
                this.f135475e0 = false;
                if (!this.f135495q0) {
                    a(this.f135497s0, this.f135491m0);
                }
            }
            if (this.f135477f0 <= 0 || !((z16 = this.f135471c0) || this.f135473d0)) {
                if (pointerCount == 1) {
                    this.f135471c0 = false;
                    this.f135473d0 = false;
                    this.f135477f0 = 0;
                }
                return true;
            }
            if (z16 && pointerCount == 2) {
                this.f135473d0 = true;
                PointF pointF13 = this.P;
                PointF pointF14 = this.O;
                pointF13.set(pointF14.x, pointF14.y);
                if (motionEvent.getActionIndex() == 1) {
                    this.f135491m0.set(motionEvent.getX(0), motionEvent.getY(0));
                } else {
                    this.f135491m0.set(motionEvent.getX(1), motionEvent.getY(1));
                }
            }
            if (pointerCount < 3) {
                this.f135471c0 = false;
            }
            if (pointerCount < 2) {
                this.f135473d0 = false;
                this.f135477f0 = 0;
            }
            b(true);
            return true;
        }
        this.f135499u0 = null;
        c(true);
        this.f135477f0 = Math.max(this.f135477f0, pointerCount);
        if (pointerCount >= 2) {
            if (this.H) {
                float a17 = a(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                this.N = this.M;
                this.f135492n0 = a17;
                PointF pointF15 = this.P;
                PointF pointF16 = this.O;
                pointF15.set(pointF16.x, pointF16.y);
                this.f135491m0.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
            } else {
                this.f135477f0 = 0;
            }
            this.f135503y0.removeMessages(1);
        } else if (!this.f135475e0) {
            PointF pointF17 = this.P;
            PointF pointF18 = this.O;
            pointF17.set(pointF18.x, pointF18.y);
            this.f135491m0.set(motionEvent.getX(), motionEvent.getY());
            this.f135503y0.sendEmptyMessageDelayed(1, 600L);
        }
        return true;
    }

    public final PointF b(PointF pointF) {
        return b(pointF.x, pointF.y, new PointF());
    }

    public final PointF b(float f16, float f17, PointF pointF) {
        if (this.O == null) {
            return null;
        }
        pointF.set(e(f16), f(f17));
        return pointF;
    }

    public final boolean d() {
        boolean z16 = getWidth() > 0 && getHeight() > 0 && this.U > 0 && this.V > 0 && (this.f135466a != null || f());
        if (!this.f135500v0 && z16) {
            l();
            this.f135500v0 = true;
            j();
        }
        return z16;
    }

    public final void b(Rect rect, Rect rect2) {
        rect2.set((int) c(rect.left), (int) d(rect.top), (int) c(rect.right), (int) d(rect.bottom));
    }

    public final float d(float f16) {
        PointF pointF = this.O;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 * this.M) + pointF.y;
    }

    public final float b(float f16) {
        return Math.min(this.f135482i, Math.max(h(), f16));
    }

    public final void a(PointF pointF, PointF pointF2) {
        if (!this.G) {
            PointF pointF3 = this.T;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = n() / 2;
                pointF.y = m() / 2;
            }
        }
        float min = Math.min(this.f135482i, this.J);
        float f16 = this.M;
        boolean z16 = ((double) f16) <= ((double) min) * 0.9d || f16 == this.f135484j;
        if (!z16) {
            min = h();
        }
        float f17 = min;
        int i3 = this.K;
        if (i3 == 3) {
            a(f17, pointF);
        } else if (i3 == 2 || !z16 || !this.G) {
            new e(this, f17, pointF, (a) null).a(false).a(this.L).b(4).a();
        } else if (i3 == 1) {
            new e(this, f17, pointF, pointF2, null).a(false).a(this.L).b(4).a();
        }
        invalidate();
    }

    public final void a(float[] fArr, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29) {
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[2] = f18;
        fArr[3] = f19;
        fArr[4] = f26;
        fArr[5] = f27;
        fArr[6] = f28;
        fArr[7] = f29;
    }

    public final synchronized void a(Point point) {
        a("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        j jVar = new j(0.0f, new PointF(0.0f, 0.0f), null);
        this.D0 = jVar;
        a(true, jVar);
        int a16 = a(this.D0.f135537a);
        this.f135474e = a16;
        if (a16 > 1) {
            this.f135474e = a16 / 2;
        }
        if (this.f135474e == 1 && this.f135467a0 == null && n() < point.x && m() < point.y) {
            this.f135483i0.recycle();
            this.f135483i0 = null;
            a(new f(this, getContext(), this.f135487k0, this.f135472d, false));
        } else {
            b(point);
            Iterator it = ((List) this.f135476f.get(Integer.valueOf(this.f135474e))).iterator();
            while (it.hasNext()) {
                a(new l(this, this.f135483i0, (k) it.next()));
            }
            b(true);
        }
    }

    public final boolean a(k kVar) {
        return e(0.0f) <= ((float) kVar.f135539a.right) && ((float) kVar.f135539a.left) <= e((float) getWidth()) && f(0.0f) <= ((float) kVar.f135539a.bottom) && ((float) kVar.f135539a.top) <= f((float) getHeight());
    }

    public final int a(float f16) {
        int round;
        if (this.f135486k > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f16 *= this.f135486k / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int n3 = (int) (n() * f16);
        int m3 = (int) (m() * f16);
        if (n3 == 0 || m3 == 0) {
            return 32;
        }
        int i3 = 1;
        if (m() > m3 || n() > n3) {
            round = Math.round(m() / m3);
            int round2 = Math.round(n() / n3);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        while (true) {
            int i16 = i3 * 2;
            if (i16 >= round) {
                return i3;
            }
            i3 = i16;
        }
    }

    public final void a(boolean z16, j jVar) {
        float max;
        int max2;
        float max3;
        if (this.f135488l == 2 && g()) {
            z16 = false;
        }
        PointF pointF = jVar.f135538b;
        float b16 = b(jVar.f135537a);
        float n3 = n() * b16;
        float m3 = m() * b16;
        if (this.f135488l == 3 && g()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - n3);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - m3);
        } else if (z16) {
            pointF.x = Math.max(pointF.x, getWidth() - n3);
            pointF.y = Math.max(pointF.y, getHeight() - m3);
        } else {
            pointF.x = Math.max(pointF.x, -n3);
            pointF.y = Math.max(pointF.y, -m3);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        float paddingTop = (getPaddingTop() > 0 || getPaddingBottom() > 0) ? getPaddingTop() / (getPaddingTop() + getPaddingBottom()) : 0.5f;
        if (this.f135488l == 3 && g()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else {
            if (z16) {
                max = Math.max(0.0f, (getWidth() - n3) * paddingLeft);
                max3 = Math.max(0.0f, (getHeight() - m3) * paddingTop);
                pointF.x = Math.min(pointF.x, max);
                pointF.y = Math.min(pointF.y, max3);
                jVar.f135537a = b16;
            }
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        max3 = max2;
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max3);
        jVar.f135537a = b16;
    }

    public final void a(boolean z16) {
        boolean z17;
        float f16 = 0.0f;
        if (this.O == null) {
            this.O = new PointF(0.0f, 0.0f);
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.D0 == null) {
            this.D0 = new j(f16, new PointF(0.0f, 0.0f), null);
        }
        this.D0.f135537a = this.M;
        this.D0.f135538b.set(this.O);
        a(z16, this.D0);
        this.M = this.D0.f135537a;
        this.O.set(this.D0.f135538b);
        if (!z17 || this.f135490m == 4) {
            return;
        }
        this.O.set(a(n() / 2, m() / 2, this.M));
    }

    public final synchronized void a(com.tencent.luggage.wxa.o6.d dVar, int i3, int i16, int i17) {
        int i18;
        int i19;
        int i26;
        a("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(this.f135480h));
        int i27 = this.U;
        if (i27 > 0 && (i26 = this.V) > 0 && (i27 != i3 || i26 != i16)) {
            d(false);
            Bitmap bitmap = this.f135466a;
            if (bitmap != null) {
                if (!this.f135470c) {
                    bitmap.recycle();
                }
                this.f135466a = null;
                this.f135468b = false;
                this.f135470c = false;
            }
        }
        this.f135483i0 = dVar;
        this.U = i3;
        this.V = i16;
        this.W = i17;
        d();
        if (!c() && (i18 = this.C) > 0 && i18 != Integer.MAX_VALUE && (i19 = this.D) > 0 && i19 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            a(new Point(this.C, this.D));
        }
        invalidate();
        requestLayout();
    }

    public final synchronized void a(Bitmap bitmap) {
        a("onPreviewLoaded", new Object[0]);
        if (this.f135466a == null && !this.f135501w0) {
            Rect rect = this.f135469b0;
            if (rect != null) {
                this.f135466a = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.f135469b0.height());
            } else {
                this.f135466a = bitmap;
            }
            this.f135468b = true;
            if (d()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    public final synchronized void a(Bitmap bitmap, int i3, boolean z16) {
        a("onImageLoaded", new Object[0]);
        int i16 = this.U;
        if (i16 > 0 && this.V > 0 && (i16 != bitmap.getWidth() || this.V != bitmap.getHeight())) {
            d(false);
        }
        Bitmap bitmap2 = this.f135466a;
        if (bitmap2 != null && !this.f135470c) {
            bitmap2.recycle();
        }
        Bitmap bitmap3 = this.f135466a;
        this.f135468b = false;
        this.f135470c = z16;
        this.f135466a = bitmap;
        this.U = bitmap.getWidth();
        this.V = bitmap.getHeight();
        this.W = i3;
        boolean d16 = d();
        boolean c16 = c();
        if (d16 || c16) {
            invalidate();
            requestLayout();
        }
    }

    public final int a(Context context, String str) {
        int i3 = 0;
        if (str.startsWith("content")) {
            Cursor cursor = null;
            try {
                try {
                    cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse(str), new String[]{"orientation"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        int i16 = cursor.getInt(0);
                        if (!K0.contains(Integer.valueOf(i16)) || i16 == -1) {
                            Log.w(J0, "Unsupported orientation: " + i16);
                        } else {
                            i3 = i16;
                        }
                    }
                    if (cursor == null) {
                        return i3;
                    }
                } catch (Exception unused) {
                    Log.w(J0, "Could not get orientation of image from media store");
                    if (cursor == null) {
                        return 0;
                    }
                }
                cursor.close();
                return i3;
            } catch (Throwable th5) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th5;
            }
        }
        if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
            if (attributeInt != 1 && attributeInt != 0) {
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 8) {
                    return 270;
                }
                Log.w(J0, "Unsupported EXIF orientation: " + attributeInt);
                return 0;
            }
            return 0;
        } catch (Exception unused2) {
            Log.w(J0, "Could not get EXIF orientation of image");
            return 0;
        }
    }

    public final void a(AsyncTask asyncTask) {
        asyncTask.executeOnExecutor(this.E, new Void[0]);
    }

    public final void a(com.tencent.luggage.wxa.n6.b bVar) {
        if (bVar == null || !K0.contains(Integer.valueOf(bVar.b()))) {
            return;
        }
        this.f135480h = bVar.b();
        this.R = Float.valueOf(bVar.c());
        this.S = bVar.a();
        invalidate();
    }

    public final Point a(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.C), Math.min(canvas.getMaximumBitmapHeight(), this.D));
    }

    public final void a(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            int i3 = rect.top;
            int i16 = this.V;
            rect2.set(i3, i16 - rect.right, rect.bottom, i16 - rect.left);
        } else {
            if (getRequiredRotation() == 180) {
                int i17 = this.U;
                int i18 = i17 - rect.right;
                int i19 = this.V;
                rect2.set(i18, i19 - rect.bottom, i17 - rect.left, i19 - rect.top);
                return;
            }
            int i26 = this.U;
            rect2.set(i26 - rect.bottom, rect.left, i26 - rect.top, rect.right);
        }
    }

    public final float a(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f17;
        float f27 = f18 - f19;
        return (float) Math.sqrt((f26 * f26) + (f27 * f27));
    }

    public final PointF a(float f16, float f17) {
        return b(f16, f17, new PointF());
    }

    public final PointF a(PointF pointF) {
        return a(pointF.x, pointF.y, new PointF());
    }

    public final PointF a(float f16, float f17, PointF pointF) {
        if (this.O == null) {
            return null;
        }
        pointF.set(c(f16), d(f17));
        return pointF;
    }

    public final PointF a(float f16, float f17, float f18) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.D0 == null) {
            this.D0 = new j(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.D0.f135537a = f18;
        this.D0.f135538b.set(paddingLeft - (f16 * f18), paddingTop - (f17 * f18));
        a(true, this.D0);
        return this.D0.f135538b;
    }

    public final PointF a(float f16, float f17, float f18, PointF pointF) {
        PointF a16 = a(f16, f17, f18);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - a16.x) / f18, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - a16.y) / f18);
        return pointF;
    }

    public final float a(int i3, long j3, float f16, float f17, long j16) {
        if (i3 == 1) {
            return b(j3, f16, f17, j16);
        }
        if (i3 == 2) {
            return a(j3, f16, f17, j16);
        }
        throw new IllegalStateException("Unexpected easing type: " + i3);
    }

    public final void a(String str, Object... objArr) {
        if (this.f135478g) {
            Log.d(J0, String.format(str, objArr));
        }
    }

    public final int a(int i3) {
        return (int) (this.I0 * i3);
    }

    public final void a(float f16, PointF pointF) {
        this.f135499u0 = null;
        this.R = Float.valueOf(f16);
        this.S = pointF;
        this.T = pointF;
        invalidate();
    }
}
