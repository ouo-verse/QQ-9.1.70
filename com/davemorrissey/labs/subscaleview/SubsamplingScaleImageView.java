package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
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
import android.media.ExifInterface;
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
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;
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
/* loaded from: classes2.dex */
public class SubsamplingScaleImageView extends View {
    private static final String R0 = "SubsamplingScaleImageView";
    private static final List<Integer> S0 = Arrays.asList(0, 90, 180, 270, -1);
    private static final List<Integer> T0 = Arrays.asList(1, 2, 3);
    private static final List<Integer> U0 = Arrays.asList(2, 1);
    private static final List<Integer> V0 = Arrays.asList(1, 2, 3);
    private static final List<Integer> W0 = Arrays.asList(2, 1, 3, 4);
    private static Bitmap.Config X0;
    private PointF A0;
    private PointF B0;
    private boolean C;
    private d C0;
    private int D;
    private boolean D0;
    private float E;
    private boolean E0;
    private float F;
    private View.OnLongClickListener F0;
    private int G;
    private final Handler G0;
    private int H;
    private Paint H0;
    private int I;
    private Paint I0;
    private int J;
    private Paint J0;
    private int K;
    private Paint K0;
    private Executor L;
    private j L0;
    private boolean M;
    private Matrix M0;
    private boolean N;
    private RectF N0;
    private final float[] O0;
    private boolean P;
    private final float[] P0;
    private boolean Q;
    private final float Q0;
    private float R;
    private int S;
    private int T;
    private float U;
    private float V;
    private PointF W;

    /* renamed from: a0, reason: collision with root package name */
    private PointF f32481a0;

    /* renamed from: b0, reason: collision with root package name */
    private PointF f32482b0;

    /* renamed from: c0, reason: collision with root package name */
    private Float f32483c0;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f32484d;

    /* renamed from: d0, reason: collision with root package name */
    private PointF f32485d0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32486e;

    /* renamed from: e0, reason: collision with root package name */
    private PointF f32487e0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f32488f;

    /* renamed from: f0, reason: collision with root package name */
    private int f32489f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f32490g0;

    /* renamed from: h, reason: collision with root package name */
    private Uri f32491h;

    /* renamed from: h0, reason: collision with root package name */
    private int f32492h0;

    /* renamed from: i, reason: collision with root package name */
    private int f32493i;

    /* renamed from: i0, reason: collision with root package name */
    private Rect f32494i0;

    /* renamed from: j0, reason: collision with root package name */
    private Rect f32495j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f32496k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f32497l0;

    /* renamed from: m, reason: collision with root package name */
    private Map<Integer, List<k>> f32498m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f32499m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f32500n0;

    /* renamed from: o0, reason: collision with root package name */
    private GestureDetector f32501o0;

    /* renamed from: p0, reason: collision with root package name */
    private GestureDetector f32502p0;

    /* renamed from: q0, reason: collision with root package name */
    private com.davemorrissey.labs.subscaleview.decoder.d f32503q0;

    /* renamed from: r0, reason: collision with root package name */
    private final ReadWriteLock f32504r0;

    /* renamed from: s0, reason: collision with root package name */
    private com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.c> f32505s0;

    /* renamed from: t0, reason: collision with root package name */
    private com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.d> f32506t0;

    /* renamed from: u0, reason: collision with root package name */
    private PointF f32507u0;

    /* renamed from: v0, reason: collision with root package name */
    private float f32508v0;

    /* renamed from: w0, reason: collision with root package name */
    private final float f32509w0;

    /* renamed from: x0, reason: collision with root package name */
    private float f32510x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f32511y0;

    /* renamed from: z0, reason: collision with root package name */
    private PointF f32512z0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && SubsamplingScaleImageView.this.F0 != null) {
                SubsamplingScaleImageView.this.f32500n0 = 0;
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.F0);
                SubsamplingScaleImageView.this.performLongClick();
                SubsamplingScaleImageView.super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f32514d;

        public b(Context context) {
            this.f32514d = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SubsamplingScaleImageView.this.P && SubsamplingScaleImageView.this.D0 && SubsamplingScaleImageView.this.W != null) {
                SubsamplingScaleImageView.this.G0(this.f32514d);
                if (SubsamplingScaleImageView.this.Q) {
                    SubsamplingScaleImageView.this.f32507u0 = new PointF(motionEvent.getX(), motionEvent.getY());
                    SubsamplingScaleImageView.this.f32481a0 = new PointF(SubsamplingScaleImageView.this.W.x, SubsamplingScaleImageView.this.W.y);
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView.V = subsamplingScaleImageView.U;
                    SubsamplingScaleImageView.this.f32499m0 = true;
                    SubsamplingScaleImageView.this.f32496k0 = true;
                    SubsamplingScaleImageView.this.f32510x0 = -1.0f;
                    SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView2.A0 = subsamplingScaleImageView2.R0(subsamplingScaleImageView2.f32507u0);
                    SubsamplingScaleImageView.this.B0 = new PointF(motionEvent.getX(), motionEvent.getY());
                    SubsamplingScaleImageView.this.f32512z0 = new PointF(SubsamplingScaleImageView.this.A0.x, SubsamplingScaleImageView.this.A0.y);
                    SubsamplingScaleImageView.this.f32511y0 = false;
                    return false;
                }
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.W(subsamplingScaleImageView3.R0(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (SubsamplingScaleImageView.this.N && SubsamplingScaleImageView.this.D0 && SubsamplingScaleImageView.this.W != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f16) > 500.0f || Math.abs(f17) > 500.0f) && !SubsamplingScaleImageView.this.f32496k0))) {
                PointF pointF = new PointF(SubsamplingScaleImageView.this.W.x + (f16 * 0.25f), SubsamplingScaleImageView.this.W.y + (f17 * 0.25f));
                new e(SubsamplingScaleImageView.this, new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.U, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.U), (a) null).e(1).h(false).g(3).c();
                return true;
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SubsamplingScaleImageView.this.performClick();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SubsamplingScaleImageView.this.performClick();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final float f32529a;

        /* renamed from: b, reason: collision with root package name */
        private final PointF f32530b;

        /* renamed from: c, reason: collision with root package name */
        private final PointF f32531c;

        /* renamed from: d, reason: collision with root package name */
        private long f32532d;

        /* renamed from: e, reason: collision with root package name */
        private int f32533e;

        /* renamed from: f, reason: collision with root package name */
        private int f32534f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f32535g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f32536h;

        public /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, float f16, PointF pointF, PointF pointF2, a aVar) {
            this(f16, pointF, pointF2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public e g(int i3) {
            this.f32534f = i3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public e h(boolean z16) {
            this.f32536h = z16;
            return this;
        }

        public void c() {
            PointF pointF;
            if (SubsamplingScaleImageView.this.C0 != null) {
                d.c(SubsamplingScaleImageView.this.C0);
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float o06 = SubsamplingScaleImageView.this.o0(this.f32529a);
            if (this.f32536h) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.f32530b;
                pointF = subsamplingScaleImageView.n0(pointF2.x, pointF2.y, o06, new PointF());
            } else {
                pointF = this.f32530b;
            }
            a aVar = null;
            SubsamplingScaleImageView.this.C0 = new d(aVar);
            SubsamplingScaleImageView.this.C0.f32517a = SubsamplingScaleImageView.this.U;
            SubsamplingScaleImageView.this.C0.f32518b = o06;
            SubsamplingScaleImageView.this.C0.f32528l = System.currentTimeMillis();
            SubsamplingScaleImageView.this.C0.f32521e = pointF;
            SubsamplingScaleImageView.this.C0.f32519c = SubsamplingScaleImageView.this.e0();
            SubsamplingScaleImageView.this.C0.f32520d = pointF;
            SubsamplingScaleImageView.this.C0.f32522f = SubsamplingScaleImageView.this.J0(pointF);
            SubsamplingScaleImageView.this.C0.f32523g = new PointF(paddingLeft, paddingTop);
            SubsamplingScaleImageView.this.C0.f32524h = this.f32532d;
            SubsamplingScaleImageView.this.C0.f32525i = this.f32535g;
            SubsamplingScaleImageView.this.C0.f32526j = this.f32533e;
            SubsamplingScaleImageView.this.C0.f32527k = this.f32534f;
            SubsamplingScaleImageView.this.C0.f32528l = System.currentTimeMillis();
            d.d(SubsamplingScaleImageView.this.C0, null);
            PointF pointF3 = this.f32531c;
            if (pointF3 != null) {
                float f16 = pointF3.x - (SubsamplingScaleImageView.this.C0.f32519c.x * o06);
                float f17 = this.f32531c.y - (SubsamplingScaleImageView.this.C0.f32519c.y * o06);
                j jVar = new j(o06, new PointF(f16, f17), aVar);
                SubsamplingScaleImageView.this.d0(true, jVar);
                SubsamplingScaleImageView.this.C0.f32523g = new PointF(this.f32531c.x + (jVar.f32546b.x - f16), this.f32531c.y + (jVar.f32546b.y - f17));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        @NonNull
        public e d(long j3) {
            this.f32532d = j3;
            return this;
        }

        @NonNull
        public e e(int i3) {
            if (SubsamplingScaleImageView.U0.contains(Integer.valueOf(i3))) {
                this.f32533e = i3;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i3);
        }

        @NonNull
        public e f(boolean z16) {
            this.f32535g = z16;
            return this;
        }

        public /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, float f16, PointF pointF, a aVar) {
            this(f16, pointF);
        }

        public /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, a aVar) {
            this(pointF);
        }

        e(PointF pointF) {
            this.f32532d = 500L;
            this.f32533e = 2;
            this.f32534f = 1;
            this.f32535g = true;
            this.f32536h = true;
            this.f32529a = SubsamplingScaleImageView.this.U;
            this.f32530b = pointF;
            this.f32531c = null;
        }

        e(float f16, PointF pointF) {
            this.f32532d = 500L;
            this.f32533e = 2;
            this.f32534f = 1;
            this.f32535g = true;
            this.f32536h = true;
            this.f32529a = f16;
            this.f32530b = pointF;
            this.f32531c = null;
        }

        e(float f16, PointF pointF, PointF pointF2) {
            this.f32532d = 500L;
            this.f32533e = 2;
            this.f32534f = 1;
            this.f32535g = true;
            this.f32536h = true;
            this.f32529a = f16;
            this.f32530b = pointF;
            this.f32531c = pointF2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class f extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<SubsamplingScaleImageView> f32538a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<Context> f32539b;

        /* renamed from: c, reason: collision with root package name */
        private final WeakReference<com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.c>> f32540c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f32541d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f32542e;

        /* renamed from: f, reason: collision with root package name */
        private Bitmap f32543f;

        /* renamed from: g, reason: collision with root package name */
        private Exception f32544g;

        public f(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.c> bVar, Uri uri, boolean z16) {
            this.f32538a = new WeakReference<>(subsamplingScaleImageView);
            this.f32539b = new WeakReference<>(context);
            this.f32540c = new WeakReference<>(bVar);
            this.f32541d = uri;
            this.f32542e = z16;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.f32541d.toString();
                Context context = this.f32539b.get();
                com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.c> bVar = this.f32540c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.f32538a.get();
                if (context != null && bVar != null && subsamplingScaleImageView != null) {
                    subsamplingScaleImageView.U("BitmapLoadTask.doInBackground", new Object[0]);
                    this.f32543f = bVar.make().decode(context, this.f32541d);
                    return Integer.valueOf(subsamplingScaleImageView.f0(context, uri));
                }
                return null;
            } catch (Exception e16) {
                Log.e(SubsamplingScaleImageView.R0, "Failed to load bitmap", e16);
                this.f32544g = e16;
                return null;
            } catch (OutOfMemoryError e17) {
                Log.e(SubsamplingScaleImageView.R0, "Failed to load bitmap - OutOfMemoryError", e17);
                this.f32544g = new RuntimeException(e17);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f32538a.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.f32543f;
                if (bitmap != null && num != null) {
                    if (this.f32542e) {
                        subsamplingScaleImageView.s0(bitmap);
                        return;
                    } else {
                        subsamplingScaleImageView.r0(bitmap, num.intValue(), false);
                        return;
                    }
                }
                if (this.f32544g != null) {
                    SubsamplingScaleImageView.z(subsamplingScaleImageView);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface g {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface h {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface i {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private float f32545a;

        /* renamed from: b, reason: collision with root package name */
        private final PointF f32546b;

        public /* synthetic */ j(float f16, PointF pointF, a aVar) {
            this(f16, pointF);
        }

        j(float f16, PointF pointF) {
            this.f32545a = f16;
            this.f32546b = pointF;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private Rect f32547a;

        /* renamed from: b, reason: collision with root package name */
        private int f32548b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap f32549c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f32550d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f32551e;

        /* renamed from: f, reason: collision with root package name */
        private Rect f32552f;

        /* renamed from: g, reason: collision with root package name */
        private Rect f32553g;

        k() {
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class l extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<SubsamplingScaleImageView> f32554a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<com.davemorrissey.labs.subscaleview.decoder.d> f32555b;

        /* renamed from: c, reason: collision with root package name */
        private final WeakReference<k> f32556c;

        /* renamed from: d, reason: collision with root package name */
        private Exception f32557d;

        public l(SubsamplingScaleImageView subsamplingScaleImageView, com.davemorrissey.labs.subscaleview.decoder.d dVar, k kVar) {
            this.f32554a = new WeakReference<>(subsamplingScaleImageView);
            this.f32555b = new WeakReference<>(dVar);
            this.f32556c = new WeakReference<>(kVar);
            kVar.f32550d = true;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.f32554a.get();
                com.davemorrissey.labs.subscaleview.decoder.d dVar = this.f32555b.get();
                k kVar = this.f32556c.get();
                if (dVar != null && kVar != null && subsamplingScaleImageView != null && dVar.isReady() && kVar.f32551e) {
                    subsamplingScaleImageView.U("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", kVar.f32547a, Integer.valueOf(kVar.f32548b));
                    subsamplingScaleImageView.f32504r0.readLock().lock();
                    try {
                        if (dVar.isReady()) {
                            subsamplingScaleImageView.b0(kVar.f32547a, kVar.f32553g);
                            if (subsamplingScaleImageView.f32494i0 != null) {
                                kVar.f32553g.offset(subsamplingScaleImageView.f32494i0.left, subsamplingScaleImageView.f32494i0.top);
                            }
                            return dVar.decodeRegion(kVar.f32553g, kVar.f32548b);
                        }
                        kVar.f32550d = false;
                        subsamplingScaleImageView.f32504r0.readLock().unlock();
                        return null;
                    } finally {
                        subsamplingScaleImageView.f32504r0.readLock().unlock();
                    }
                }
                if (kVar != null) {
                    kVar.f32550d = false;
                    return null;
                }
                return null;
            } catch (Exception e16) {
                Log.e(SubsamplingScaleImageView.R0, "Failed to decode tile", e16);
                this.f32557d = e16;
                return null;
            } catch (OutOfMemoryError e17) {
                Log.e(SubsamplingScaleImageView.R0, "Failed to decode tile - OutOfMemoryError", e17);
                this.f32557d = new RuntimeException(e17);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f32554a.get();
            k kVar = this.f32556c.get();
            if (subsamplingScaleImageView != null && kVar != null) {
                if (bitmap != null) {
                    kVar.f32549c = bitmap;
                    kVar.f32550d = false;
                    subsamplingScaleImageView.u0();
                } else if (this.f32557d != null) {
                    SubsamplingScaleImageView.z(subsamplingScaleImageView);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class m extends AsyncTask<Void, Void, int[]> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<SubsamplingScaleImageView> f32558a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<Context> f32559b;

        /* renamed from: c, reason: collision with root package name */
        private final WeakReference<com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.d>> f32560c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f32561d;

        /* renamed from: e, reason: collision with root package name */
        private com.davemorrissey.labs.subscaleview.decoder.d f32562e;

        /* renamed from: f, reason: collision with root package name */
        private Exception f32563f;

        public m(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.d> bVar, Uri uri) {
            this.f32558a = new WeakReference<>(subsamplingScaleImageView);
            this.f32559b = new WeakReference<>(context);
            this.f32560c = new WeakReference<>(bVar);
            this.f32561d = uri;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.f32561d.toString();
                Context context = this.f32559b.get();
                com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.d> bVar = this.f32560c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.f32558a.get();
                if (context != null && bVar != null && subsamplingScaleImageView != null) {
                    subsamplingScaleImageView.U("TilesInitTask.doInBackground", new Object[0]);
                    com.davemorrissey.labs.subscaleview.decoder.d make = bVar.make();
                    this.f32562e = make;
                    Point init = make.init(context, this.f32561d);
                    int i3 = init.x;
                    int i16 = init.y;
                    int f06 = subsamplingScaleImageView.f0(context, uri);
                    if (subsamplingScaleImageView.f32494i0 != null) {
                        subsamplingScaleImageView.f32494i0.left = Math.max(0, subsamplingScaleImageView.f32494i0.left);
                        subsamplingScaleImageView.f32494i0.top = Math.max(0, subsamplingScaleImageView.f32494i0.top);
                        subsamplingScaleImageView.f32494i0.right = Math.min(i3, subsamplingScaleImageView.f32494i0.right);
                        subsamplingScaleImageView.f32494i0.bottom = Math.min(i16, subsamplingScaleImageView.f32494i0.bottom);
                        i3 = subsamplingScaleImageView.f32494i0.width();
                        i16 = subsamplingScaleImageView.f32494i0.height();
                    }
                    return new int[]{i3, i16, f06};
                }
                return null;
            } catch (Exception e16) {
                Log.e(SubsamplingScaleImageView.R0, "Failed to initialise bitmap decoder", e16);
                this.f32563f = e16;
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f32558a.get();
            if (subsamplingScaleImageView != null) {
                com.davemorrissey.labs.subscaleview.decoder.d dVar = this.f32562e;
                if (dVar != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.v0(dVar, iArr[0], iArr[1], iArr[2]);
                } else if (this.f32563f != null) {
                    SubsamplingScaleImageView.z(subsamplingScaleImageView);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.D = 0;
        this.E = 2.0f;
        this.F = p0();
        this.G = -1;
        this.H = 1;
        this.I = 1;
        this.J = Integer.MAX_VALUE;
        this.K = Integer.MAX_VALUE;
        this.L = AsyncTask.THREAD_POOL_EXECUTOR;
        this.M = true;
        this.N = true;
        this.P = true;
        this.Q = true;
        this.R = 1.0f;
        this.S = 1;
        this.T = 500;
        this.f32504r0 = new ReentrantReadWriteLock(true);
        this.f32505s0 = new com.davemorrissey.labs.subscaleview.decoder.a(SkiaImageDecoder.class);
        this.f32506t0 = new com.davemorrissey.labs.subscaleview.decoder.a(SkiaImageRegionDecoder.class);
        this.O0 = new float[8];
        this.P0 = new float[8];
        this.Q0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        G0(context);
        this.G0 = new Handler(new a());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            int i3 = R.styleable.SubsamplingScaleImageView_assetName;
            if (obtainStyledAttributes.hasValue(i3) && (string = obtainStyledAttributes.getString(i3)) != null && string.length() > 0) {
                setImage(o0.a.a(string).l());
            }
            int i16 = R.styleable.SubsamplingScaleImageView_src;
            if (obtainStyledAttributes.hasValue(i16) && (resourceId = obtainStyledAttributes.getResourceId(i16, 0)) > 0) {
                setImage(o0.a.j(resourceId).l());
            }
            int i17 = R.styleable.SubsamplingScaleImageView_panEnabled;
            if (obtainStyledAttributes.hasValue(i17)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(i17, true));
            }
            int i18 = R.styleable.SubsamplingScaleImageView_zoomEnabled;
            if (obtainStyledAttributes.hasValue(i18)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(i18, true));
            }
            int i19 = R.styleable.SubsamplingScaleImageView_quickScaleEnabled;
            if (obtainStyledAttributes.hasValue(i19)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(i19, true));
            }
            int i26 = R.styleable.SubsamplingScaleImageView_tileBackgroundColor;
            if (obtainStyledAttributes.hasValue(i26)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(i26, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.f32509w0 = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private void A0(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void B0(boolean z16) {
        U("reset newImage=" + z16, new Object[0]);
        this.U = 0.0f;
        this.V = 0.0f;
        this.W = null;
        this.f32481a0 = null;
        this.f32482b0 = null;
        this.f32483c0 = Float.valueOf(0.0f);
        this.f32485d0 = null;
        this.f32487e0 = null;
        this.f32496k0 = false;
        this.f32497l0 = false;
        this.f32499m0 = false;
        this.f32500n0 = 0;
        this.f32493i = 0;
        this.f32507u0 = null;
        this.f32508v0 = 0.0f;
        this.f32510x0 = 0.0f;
        this.f32511y0 = false;
        this.A0 = null;
        this.f32512z0 = null;
        this.B0 = null;
        this.C0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        if (z16) {
            this.f32491h = null;
            this.f32504r0.writeLock().lock();
            try {
                com.davemorrissey.labs.subscaleview.decoder.d dVar = this.f32503q0;
                if (dVar != null) {
                    dVar.recycle();
                    this.f32503q0 = null;
                }
                this.f32504r0.writeLock().unlock();
                Bitmap bitmap = this.f32484d;
                if (bitmap != null && !this.f32488f) {
                    bitmap.recycle();
                }
                if (this.f32484d != null) {
                    boolean z17 = this.f32488f;
                }
                this.f32489f0 = 0;
                this.f32490g0 = 0;
                this.f32492h0 = 0;
                this.f32494i0 = null;
                this.f32495j0 = null;
                this.D0 = false;
                this.E0 = false;
                this.f32484d = null;
                this.f32486e = false;
                this.f32488f = false;
            } catch (Throwable th5) {
                this.f32504r0.writeLock().unlock();
                throw th5;
            }
        }
        Map<Integer, List<k>> map = this.f32498m;
        if (map != null) {
            Iterator<Map.Entry<Integer, List<k>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (k kVar : it.next().getValue()) {
                    kVar.f32551e = false;
                    if (kVar.f32549c != null) {
                        kVar.f32549c.recycle();
                        kVar.f32549c = null;
                    }
                }
            }
            this.f32498m = null;
        }
        G0(getContext());
    }

    private void C0(ImageViewState imageViewState) {
        if (imageViewState != null && S0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.D = imageViewState.getOrientation();
            this.f32483c0 = Float.valueOf(imageViewState.getScale());
            this.f32485d0 = imageViewState.getCenter();
            invalidate();
        }
    }

    private int D0() {
        int i06 = i0();
        if (i06 != 90 && i06 != 270) {
            return this.f32490g0;
        }
        return this.f32489f0;
    }

    private int E0() {
        int i06 = i0();
        if (i06 != 90 && i06 != 270) {
            return this.f32489f0;
        }
        return this.f32490g0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(Context context) {
        this.f32501o0 = new GestureDetector(context, new b(context));
        this.f32502p0 = new GestureDetector(context, new c());
    }

    private void H0(float[] fArr, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29) {
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[2] = f18;
        fArr[3] = f19;
        fArr[4] = f26;
        fArr[5] = f27;
        fArr[6] = f28;
        fArr[7] = f29;
    }

    private void K0(@NonNull Rect rect, @NonNull Rect rect2) {
        rect2.set((int) L0(rect.left), (int) M0(rect.top), (int) L0(rect.right), (int) M0(rect.bottom));
    }

    private float L0(float f16) {
        PointF pointF = this.W;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 * this.U) + pointF.x;
    }

    private float M0(float f16) {
        PointF pointF = this.W;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 * this.U) + pointF.y;
    }

    private boolean N0(k kVar) {
        float S02 = S0(0.0f);
        float S03 = S0(getWidth());
        float T02 = T0(0.0f);
        float T03 = T0(getHeight());
        if (S02 <= kVar.f32547a.right && kVar.f32547a.left <= S03 && T02 <= kVar.f32547a.bottom && kVar.f32547a.top <= T03) {
            return true;
        }
        return false;
    }

    @NonNull
    private PointF O0(float f16, float f17, float f18) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.L0 == null) {
            this.L0 = new j(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.L0.f32545a = f18;
        this.L0.f32546b.set(paddingLeft - (f16 * f18), paddingTop - (f17 * f18));
        d0(true, this.L0);
        return this.L0.f32546b;
    }

    private int Q(float f16) {
        int round;
        if (this.G > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f16 *= this.G / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int E0 = (int) (E0() * f16);
        int D0 = (int) (D0() * f16);
        if (E0 != 0 && D0 != 0) {
            int i3 = 1;
            if (D0() <= D0 && E0() <= E0) {
                round = 1;
            } else {
                round = Math.round(D0() / D0);
                int round2 = Math.round(E0() / E0);
                if (round >= round2) {
                    round = round2;
                }
            }
            while (true) {
                int i16 = i3 * 2;
                if (i16 < round) {
                    i3 = i16;
                } else {
                    return i3;
                }
            }
        } else {
            return 32;
        }
    }

    private boolean R() {
        boolean l06 = l0();
        if (!this.E0 && l06) {
            x0();
            this.E0 = true;
            q0();
        }
        return l06;
    }

    private boolean S() {
        boolean z16;
        if (getWidth() > 0 && getHeight() > 0 && this.f32489f0 > 0 && this.f32490g0 > 0 && (this.f32484d != null || l0())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.D0 && z16) {
            x0();
            this.D0 = true;
            t0();
        }
        return z16;
    }

    private float S0(float f16) {
        PointF pointF = this.W;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 - pointF.x) / this.U;
    }

    private void T() {
        if (this.H0 == null) {
            Paint paint = new Paint();
            this.H0 = paint;
            paint.setAntiAlias(true);
            this.H0.setFilterBitmap(true);
            this.H0.setDither(true);
        }
        if ((this.I0 == null || this.J0 == null) && this.C) {
            Paint paint2 = new Paint();
            this.I0 = paint2;
            paint2.setTextSize(y0(12));
            this.I0.setColor(-65281);
            this.I0.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.J0 = paint3;
            paint3.setColor(-65281);
            this.J0.setStyle(Paint.Style.STROKE);
            this.J0.setStrokeWidth(y0(1));
        }
    }

    private float T0(float f16) {
        PointF pointF = this.W;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 - pointF.y) / this.U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void U(String str, Object... objArr) {
        if (this.C) {
            Log.d(R0, String.format(str, objArr));
        }
    }

    private float V(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f17;
        float f27 = f18 - f19;
        return (float) Math.sqrt((f26 * f26) + (f27 * f27));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(PointF pointF, PointF pointF2) {
        boolean z16;
        if (!this.N) {
            PointF pointF3 = this.f32487e0;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = E0() / 2;
                pointF.y = D0() / 2;
            }
        }
        float min = Math.min(this.E, this.R);
        float f16 = this.U;
        if (f16 > min * 0.9d && f16 != this.F) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            min = p0();
        }
        float f17 = min;
        int i3 = this.S;
        if (i3 == 3) {
            setScaleAndCenter(f17, pointF);
        } else if (i3 != 2 && z16 && this.N) {
            if (i3 == 1) {
                new e(this, f17, pointF, pointF2, null).f(false).d(this.T).g(4).c();
            }
        } else {
            new e(this, f17, pointF, (a) null).f(false).d(this.T).g(4).c();
        }
        invalidate();
    }

    private float X(int i3, long j3, float f16, float f17, long j16) {
        if (i3 != 1) {
            if (i3 == 2) {
                return Y(j3, f16, f17, j16);
            }
            throw new IllegalStateException("Unexpected easing type: " + i3);
        }
        return Z(j3, f16, f17, j16);
    }

    private float Y(long j3, float f16, float f17, long j16) {
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

    private float Z(long j3, float f16, float f17, long j16) {
        float f18 = ((float) j3) / ((float) j16);
        return ((-f17) * f18 * (f18 - 2.0f)) + f16;
    }

    private void a0(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.L, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void b0(Rect rect, Rect rect2) {
        if (i0() == 0) {
            rect2.set(rect);
            return;
        }
        if (i0() == 90) {
            int i3 = rect.top;
            int i16 = this.f32490g0;
            rect2.set(i3, i16 - rect.right, rect.bottom, i16 - rect.left);
        } else {
            if (i0() == 180) {
                int i17 = this.f32489f0;
                int i18 = i17 - rect.right;
                int i19 = this.f32490g0;
                rect2.set(i18, i19 - rect.bottom, i17 - rect.left, i19 - rect.top);
                return;
            }
            int i26 = this.f32489f0;
            rect2.set(i26 - rect.bottom, rect.left, i26 - rect.top, rect.right);
        }
    }

    private void c0(boolean z16) {
        boolean z17;
        float f16 = 0.0f;
        if (this.W == null) {
            this.W = new PointF(0.0f, 0.0f);
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.L0 == null) {
            this.L0 = new j(f16, new PointF(0.0f, 0.0f), null);
        }
        this.L0.f32545a = this.U;
        this.L0.f32546b.set(this.W);
        d0(z16, this.L0);
        this.U = this.L0.f32545a;
        this.W.set(this.L0.f32546b);
        if (z17 && this.I != 4) {
            this.W.set(O0(E0() / 2, D0() / 2, this.U));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(boolean z16, j jVar) {
        float paddingLeft;
        float max;
        int max2;
        float max3;
        if (this.H == 2 && m0()) {
            z16 = false;
        }
        PointF pointF = jVar.f32546b;
        float o06 = o0(jVar.f32545a);
        float E0 = E0() * o06;
        float D0 = D0() * o06;
        if (this.H == 3 && m0()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - E0);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - D0);
        } else if (z16) {
            pointF.x = Math.max(pointF.x, getWidth() - E0);
            pointF.y = Math.max(pointF.y, getHeight() - D0);
        } else {
            pointF.x = Math.max(pointF.x, -E0);
            pointF.y = Math.max(pointF.y, -D0);
        }
        float f16 = 0.5f;
        if (getPaddingLeft() <= 0 && getPaddingRight() <= 0) {
            paddingLeft = 0.5f;
        } else {
            paddingLeft = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
        }
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f16 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
        }
        if (this.H == 3 && m0()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else {
            if (z16) {
                max = Math.max(0.0f, (getWidth() - E0) * paddingLeft);
                max3 = Math.max(0.0f, (getHeight() - D0) * f16);
                pointF.x = Math.min(pointF.x, max);
                pointF.y = Math.min(pointF.y, max3);
                jVar.f32545a = o06;
            }
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        max3 = max2;
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max3);
        jVar.f32545a = o06;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public int f0(Context context, String str) {
        int i3 = 0;
        if (str.startsWith("content")) {
            Cursor cursor = null;
            try {
                try {
                    cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse(str), new String[]{"orientation"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        int i16 = cursor.getInt(0);
                        if (S0.contains(Integer.valueOf(i16)) && i16 != -1) {
                            i3 = i16;
                        } else {
                            Log.w(R0, "Unsupported orientation: " + i16);
                        }
                    }
                    if (cursor == null) {
                        return i3;
                    }
                } catch (Exception unused) {
                    Log.w(R0, "Could not get orientation of image from media store");
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
                Log.w(R0, "Unsupported EXIF orientation: " + attributeInt);
                return 0;
            }
            return 0;
        } catch (Exception unused2) {
            Log.w(R0, "Could not get EXIF orientation of image");
            return 0;
        }
    }

    @NonNull
    private Point g0(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.J), Math.min(canvas.getMaximumBitmapHeight(), this.K));
    }

    public static Bitmap.Config h0() {
        return X0;
    }

    @AnyThread
    private int i0() {
        int i3 = this.D;
        if (i3 == -1) {
            return this.f32492h0;
        }
        return i3;
    }

    private synchronized void j0(@NonNull Point point) {
        U("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        j jVar = new j(0.0f, new PointF(0.0f, 0.0f), null);
        this.L0 = jVar;
        d0(true, jVar);
        int Q = Q(this.L0.f32545a);
        this.f32493i = Q;
        if (Q > 1) {
            this.f32493i = Q / 2;
        }
        if (this.f32493i == 1 && this.f32494i0 == null && E0() < point.x && D0() < point.y) {
            this.f32503q0.recycle();
            this.f32503q0 = null;
            a0(new f(this, getContext(), this.f32505s0, this.f32491h, false));
        } else {
            k0(point);
            Iterator<k> it = this.f32498m.get(Integer.valueOf(this.f32493i)).iterator();
            while (it.hasNext()) {
                a0(new l(this, this.f32503q0, it.next()));
            }
            z0(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k0(Point point) {
        boolean z16;
        int i3;
        int i16;
        int i17 = 0;
        int i18 = 1;
        U("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.f32498m = new LinkedHashMap();
        int i19 = this.f32493i;
        int i26 = 1;
        int i27 = 1;
        while (true) {
            int E0 = E0() / i26;
            int D0 = D0() / i27;
            int i28 = E0 / i19;
            int i29 = D0 / i19;
            while (true) {
                if (i28 + i26 + i18 > point.x || (i28 > getWidth() * 1.25d && i19 < this.f32493i)) {
                    i26++;
                    E0 = E0() / i26;
                    i28 = E0 / i19;
                    i18 = i18;
                    i17 = i17;
                }
            }
            while (true) {
                if (i29 + i27 + i18 > point.y || (i29 > getHeight() * 1.25d && i19 < this.f32493i)) {
                    i27++;
                    D0 = D0() / i27;
                    i29 = D0 / i19;
                    i18 = i18;
                    i17 = i17;
                }
            }
            ArrayList arrayList = new ArrayList(i26 * i27);
            int i36 = i17;
            while (i36 < i26) {
                int i37 = i17;
                while (i37 < i27) {
                    k kVar = new k(null);
                    kVar.f32548b = i19;
                    if (i19 == this.f32493i) {
                        z16 = i18;
                    } else {
                        z16 = i17;
                    }
                    kVar.f32551e = z16;
                    int i38 = i36 * E0;
                    int i39 = i37 * D0;
                    if (i36 == i26 - 1) {
                        i3 = E0();
                    } else {
                        i3 = (i36 + 1) * E0;
                    }
                    if (i37 == i27 - 1) {
                        i16 = D0();
                    } else {
                        i16 = (i37 + 1) * D0;
                    }
                    kVar.f32547a = new Rect(i38, i39, i3, i16);
                    kVar.f32552f = new Rect(0, 0, 0, 0);
                    kVar.f32553g = new Rect(kVar.f32547a);
                    arrayList.add(kVar);
                    i37++;
                    i17 = 0;
                    i18 = 1;
                }
                i36++;
                i18 = 1;
            }
            int i46 = i17;
            this.f32498m.put(Integer.valueOf(i19), arrayList);
            if (i19 == 1) {
                return;
            }
            i19 /= 2;
            i18 = 1;
            i17 = i46;
        }
    }

    private boolean l0() {
        boolean z16 = true;
        if (this.f32484d != null && !this.f32486e) {
            return true;
        }
        Map<Integer, List<k>> map = this.f32498m;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<k>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.f32493i) {
                for (k kVar : entry.getValue()) {
                    if (kVar.f32550d || kVar.f32549c == null) {
                        z16 = false;
                    }
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public PointF n0(float f16, float f17, float f18, @NonNull PointF pointF) {
        PointF O0 = O0(f16, f17, f18);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - O0.x) / f18, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - O0.y) / f18);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o0(float f16) {
        return Math.min(this.E, Math.max(p0(), f16));
    }

    private float p0() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i3 = this.I;
        if (i3 != 2 && i3 != 4) {
            if (i3 == 3) {
                float f16 = this.F;
                if (f16 > 0.0f) {
                    return f16;
                }
            }
            return Math.min((getWidth() - paddingLeft) / E0(), (getHeight() - paddingBottom) / D0());
        }
        return Math.max((getWidth() - paddingLeft) / E0(), (getHeight() - paddingBottom) / D0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r0(Bitmap bitmap, int i3, boolean z16) {
        U("onImageLoaded", new Object[0]);
        int i16 = this.f32489f0;
        if (i16 > 0 && this.f32490g0 > 0 && (i16 != bitmap.getWidth() || this.f32490g0 != bitmap.getHeight())) {
            B0(false);
        }
        Bitmap bitmap2 = this.f32484d;
        if (bitmap2 != null && !this.f32488f) {
            bitmap2.recycle();
        }
        if (this.f32484d != null) {
            boolean z17 = this.f32488f;
        }
        this.f32486e = false;
        this.f32488f = z16;
        this.f32484d = bitmap;
        this.f32489f0 = bitmap.getWidth();
        this.f32490g0 = bitmap.getHeight();
        this.f32492h0 = i3;
        boolean S = S();
        boolean R = R();
        if (S || R) {
            invalidate();
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s0(Bitmap bitmap) {
        U("onPreviewLoaded", new Object[0]);
        if (this.f32484d == null && !this.E0) {
            Rect rect = this.f32495j0;
            if (rect != null) {
                this.f32484d = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.f32495j0.height());
            } else {
                this.f32484d = bitmap;
            }
            this.f32486e = true;
            if (S()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        X0 = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u0() {
        Bitmap bitmap;
        U("onTileLoaded", new Object[0]);
        S();
        R();
        if (l0() && (bitmap = this.f32484d) != null) {
            if (!this.f32488f) {
                bitmap.recycle();
            }
            this.f32484d = null;
            this.f32486e = false;
            this.f32488f = false;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v0(com.davemorrissey.labs.subscaleview.decoder.d dVar, int i3, int i16, int i17) {
        int i18;
        int i19;
        int i26;
        U("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(this.D));
        int i27 = this.f32489f0;
        if (i27 > 0 && (i26 = this.f32490g0) > 0 && (i27 != i3 || i26 != i16)) {
            B0(false);
            Bitmap bitmap = this.f32484d;
            if (bitmap != null) {
                if (!this.f32488f) {
                    bitmap.recycle();
                }
                this.f32484d = null;
                this.f32486e = false;
                this.f32488f = false;
            }
        }
        this.f32503q0 = dVar;
        this.f32489f0 = i3;
        this.f32490g0 = i16;
        this.f32492h0 = i17;
        S();
        if (!R() && (i18 = this.J) > 0 && i18 != Integer.MAX_VALUE && (i19 = this.K) > 0 && i19 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            j0(new Point(this.J, this.K));
        }
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r1 != 262) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean w0(@NonNull MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 5) {
                        if (action != 6) {
                            if (action != 261) {
                            }
                        }
                    }
                } else {
                    if (this.f32500n0 > 0) {
                        if (pointerCount >= 2) {
                            float V = V(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                            float x16 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                            float y16 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                            if (this.P) {
                                PointF pointF = this.f32507u0;
                                if (V(pointF.x, x16, pointF.y, y16) > 5.0f || Math.abs(V - this.f32508v0) > 5.0f || this.f32497l0) {
                                    this.f32496k0 = true;
                                    this.f32497l0 = true;
                                    double d16 = this.U;
                                    float min = Math.min(this.E, (V / this.f32508v0) * this.V);
                                    this.U = min;
                                    if (min <= p0()) {
                                        this.f32508v0 = V;
                                        this.V = p0();
                                        this.f32507u0.set(x16, y16);
                                        this.f32481a0.set(this.W);
                                    } else if (this.N) {
                                        PointF pointF2 = this.f32507u0;
                                        float f16 = pointF2.x;
                                        PointF pointF3 = this.f32481a0;
                                        float f17 = f16 - pointF3.x;
                                        float f18 = pointF2.y - pointF3.y;
                                        float f19 = this.U / this.V;
                                        float f26 = f17 * f19;
                                        float f27 = f18 * f19;
                                        PointF pointF4 = this.W;
                                        pointF4.x = x16 - f26;
                                        pointF4.y = y16 - f27;
                                        if ((D0() * d16 < getHeight() && this.U * D0() >= getHeight()) || (d16 * E0() < getWidth() && this.U * E0() >= getWidth())) {
                                            c0(true);
                                            this.f32507u0.set(x16, y16);
                                            this.f32481a0.set(this.W);
                                            this.V = this.U;
                                            this.f32508v0 = V;
                                        }
                                    } else if (this.f32487e0 != null) {
                                        this.W.x = (getWidth() / 2) - (this.U * this.f32487e0.x);
                                        this.W.y = (getHeight() / 2) - (this.U * this.f32487e0.y);
                                    } else {
                                        this.W.x = (getWidth() / 2) - (this.U * (E0() / 2));
                                        this.W.y = (getHeight() / 2) - (this.U * (D0() / 2));
                                    }
                                    c0(true);
                                    z0(this.M);
                                    z17 = true;
                                }
                            }
                        } else {
                            if (this.f32499m0) {
                                float abs = (Math.abs(this.B0.y - motionEvent.getY()) * 2.0f) + this.f32509w0;
                                if (this.f32510x0 == -1.0f) {
                                    this.f32510x0 = abs;
                                }
                                float y17 = motionEvent.getY();
                                PointF pointF5 = this.f32512z0;
                                if (y17 > pointF5.y) {
                                    z29 = true;
                                } else {
                                    z29 = false;
                                }
                                pointF5.set(0.0f, motionEvent.getY());
                                float f28 = 1.0f;
                                float abs2 = Math.abs(1.0f - (abs / this.f32510x0)) * 0.5f;
                                if (abs2 > 0.03f || this.f32511y0) {
                                    this.f32511y0 = true;
                                    if (this.f32510x0 > 0.0f) {
                                        if (z29) {
                                            f28 = 1.0f + abs2;
                                        } else {
                                            f28 = 1.0f - abs2;
                                        }
                                    }
                                    double d17 = this.U;
                                    float max = Math.max(p0(), Math.min(this.E, this.U * f28));
                                    this.U = max;
                                    if (this.N) {
                                        PointF pointF6 = this.f32507u0;
                                        float f29 = pointF6.x;
                                        PointF pointF7 = this.f32481a0;
                                        float f36 = f29 - pointF7.x;
                                        float f37 = pointF6.y;
                                        float f38 = f37 - pointF7.y;
                                        float f39 = max / this.V;
                                        float f46 = f36 * f39;
                                        float f47 = f38 * f39;
                                        PointF pointF8 = this.W;
                                        pointF8.x = f29 - f46;
                                        pointF8.y = f37 - f47;
                                        if ((D0() * d17 < getHeight() && this.U * D0() >= getHeight()) || (d17 * E0() < getWidth() && this.U * E0() >= getWidth())) {
                                            c0(true);
                                            this.f32507u0.set(J0(this.A0));
                                            this.f32481a0.set(this.W);
                                            this.V = this.U;
                                            abs = 0.0f;
                                        }
                                    } else if (this.f32487e0 != null) {
                                        this.W.x = (getWidth() / 2) - (this.U * this.f32487e0.x);
                                        this.W.y = (getHeight() / 2) - (this.U * this.f32487e0.y);
                                    } else {
                                        this.W.x = (getWidth() / 2) - (this.U * (E0() / 2));
                                        this.W.y = (getHeight() / 2) - (this.U * (D0() / 2));
                                    }
                                }
                                this.f32510x0 = abs;
                                c0(true);
                                z0(this.M);
                            } else if (!this.f32496k0) {
                                float abs3 = Math.abs(motionEvent.getX() - this.f32507u0.x);
                                float abs4 = Math.abs(motionEvent.getY() - this.f32507u0.y);
                                float f48 = this.Q0 * 5.0f;
                                if (abs3 > f48 || abs4 > f48 || this.f32497l0) {
                                    this.W.x = this.f32481a0.x + (motionEvent.getX() - this.f32507u0.x);
                                    this.W.y = this.f32481a0.y + (motionEvent.getY() - this.f32507u0.y);
                                    PointF pointF9 = this.W;
                                    float f49 = pointF9.x;
                                    float f56 = pointF9.y;
                                    c0(true);
                                    PointF pointF10 = this.W;
                                    if (f49 != pointF10.x) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    float f57 = pointF10.y;
                                    if (f56 != f57) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (z18 && abs3 > abs4 && !this.f32497l0) {
                                        z26 = true;
                                    } else {
                                        z26 = false;
                                    }
                                    if (z19 && abs4 > abs3 && !this.f32497l0) {
                                        z27 = true;
                                    } else {
                                        z27 = false;
                                    }
                                    if (f56 == f57 && abs4 > 3.0f * f48) {
                                        z28 = true;
                                    } else {
                                        z28 = false;
                                    }
                                    if (!z26 && !z27 && (!z18 || !z19 || z28 || this.f32497l0)) {
                                        this.f32497l0 = true;
                                    } else if (abs3 > f48 || abs4 > f48) {
                                        this.f32500n0 = 0;
                                        this.G0.removeMessages(1);
                                        A0(false);
                                    }
                                    if (!this.N) {
                                        PointF pointF11 = this.W;
                                        PointF pointF12 = this.f32481a0;
                                        pointF11.x = pointF12.x;
                                        pointF11.y = pointF12.y;
                                        A0(false);
                                    }
                                    z0(this.M);
                                }
                            }
                            z17 = true;
                        }
                        if (z17) {
                            this.G0.removeMessages(1);
                            invalidate();
                            return true;
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                }
                return false;
            }
            this.G0.removeMessages(1);
            if (this.f32499m0) {
                this.f32499m0 = false;
                if (!this.f32511y0) {
                    W(this.A0, this.f32507u0);
                }
            }
            if (this.f32500n0 > 0 && ((z16 = this.f32496k0) || this.f32497l0)) {
                if (z16 && pointerCount == 2) {
                    this.f32497l0 = true;
                    PointF pointF13 = this.f32481a0;
                    PointF pointF14 = this.W;
                    pointF13.set(pointF14.x, pointF14.y);
                    if (motionEvent.getActionIndex() == 1) {
                        this.f32507u0.set(motionEvent.getX(0), motionEvent.getY(0));
                    } else {
                        this.f32507u0.set(motionEvent.getX(1), motionEvent.getY(1));
                    }
                }
                if (pointerCount < 3) {
                    this.f32496k0 = false;
                }
                if (pointerCount < 2) {
                    this.f32497l0 = false;
                    this.f32500n0 = 0;
                }
                z0(true);
                return true;
            }
            if (pointerCount == 1) {
                this.f32496k0 = false;
                this.f32497l0 = false;
                this.f32500n0 = 0;
            }
            return true;
        }
        this.C0 = null;
        A0(true);
        this.f32500n0 = Math.max(this.f32500n0, pointerCount);
        if (pointerCount >= 2) {
            if (this.P) {
                float V2 = V(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                this.V = this.U;
                this.f32508v0 = V2;
                PointF pointF15 = this.f32481a0;
                PointF pointF16 = this.W;
                pointF15.set(pointF16.x, pointF16.y);
                this.f32507u0.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
            } else {
                this.f32500n0 = 0;
            }
            this.G0.removeMessages(1);
        } else if (!this.f32499m0) {
            PointF pointF17 = this.f32481a0;
            PointF pointF18 = this.W;
            pointF17.set(pointF18.x, pointF18.y);
            this.f32507u0.set(motionEvent.getX(), motionEvent.getY());
            this.G0.sendEmptyMessageDelayed(1, 600L);
        }
        return true;
    }

    private void x0() {
        Float f16;
        if (getWidth() != 0 && getHeight() != 0 && this.f32489f0 > 0 && this.f32490g0 > 0) {
            if (this.f32485d0 != null && (f16 = this.f32483c0) != null) {
                this.U = f16.floatValue();
                if (this.W == null) {
                    this.W = new PointF();
                }
                this.W.x = (getWidth() / 2) - (this.U * this.f32485d0.x);
                this.W.y = (getHeight() / 2) - (this.U * this.f32485d0.y);
                this.f32485d0 = null;
                this.f32483c0 = null;
                c0(true);
                z0(true);
            }
            c0(false);
        }
    }

    private int y0(int i3) {
        return (int) (this.Q0 * i3);
    }

    public static /* synthetic */ h z(SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.getClass();
        return null;
    }

    private void z0(boolean z16) {
        if (this.f32503q0 != null && this.f32498m != null) {
            int min = Math.min(this.f32493i, Q(this.U));
            Iterator<Map.Entry<Integer, List<k>>> it = this.f32498m.entrySet().iterator();
            while (it.hasNext()) {
                for (k kVar : it.next().getValue()) {
                    if (kVar.f32548b < min || (kVar.f32548b > min && kVar.f32548b != this.f32493i)) {
                        kVar.f32551e = false;
                        if (kVar.f32549c != null) {
                            kVar.f32549c.recycle();
                            kVar.f32549c = null;
                        }
                    }
                    if (kVar.f32548b == min) {
                        if (N0(kVar)) {
                            kVar.f32551e = true;
                            if (!kVar.f32550d && kVar.f32549c == null && z16) {
                                a0(new l(this, this.f32503q0, kVar));
                            }
                        } else if (kVar.f32548b != this.f32493i) {
                            kVar.f32551e = false;
                            if (kVar.f32549c != null) {
                                kVar.f32549c.recycle();
                                kVar.f32549c = null;
                            }
                        }
                    } else if (kVar.f32548b == this.f32493i) {
                        kVar.f32551e = true;
                    }
                }
            }
        }
    }

    @Nullable
    public final PointF I0(float f16, float f17, @NonNull PointF pointF) {
        if (this.W == null) {
            return null;
        }
        pointF.set(L0(f16), M0(f17));
        return pointF;
    }

    @Nullable
    public final PointF J0(PointF pointF) {
        return I0(pointF.x, pointF.y, new PointF());
    }

    @Nullable
    public final PointF P0(float f16, float f17) {
        return Q0(f16, f17, new PointF());
    }

    @Nullable
    public final PointF Q0(float f16, float f17, @NonNull PointF pointF) {
        if (this.W == null) {
            return null;
        }
        pointF.set(S0(f16), T0(f17));
        return pointF;
    }

    @Nullable
    public final PointF R0(PointF pointF) {
        return Q0(pointF.x, pointF.y, new PointF());
    }

    @Nullable
    public final PointF e0() {
        return P0(getWidth() / 2, getHeight() / 2);
    }

    public final boolean m0() {
        return this.D0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        float f16;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        boolean z16;
        boolean z17;
        super.onDraw(canvas);
        T();
        if (this.f32489f0 != 0 && this.f32490g0 != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.f32498m == null && this.f32503q0 != null) {
                j0(g0(canvas));
            }
            if (!S()) {
                return;
            }
            x0();
            d dVar = this.C0;
            if (dVar != null && dVar.f32522f != null) {
                float f17 = this.U;
                if (this.f32482b0 == null) {
                    this.f32482b0 = new PointF(0.0f, 0.0f);
                }
                this.f32482b0.set(this.W);
                long currentTimeMillis = System.currentTimeMillis() - this.C0.f32528l;
                if (currentTimeMillis > this.C0.f32524h) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                long min = Math.min(currentTimeMillis, this.C0.f32524h);
                this.U = X(this.C0.f32526j, min, this.C0.f32517a, this.C0.f32518b - this.C0.f32517a, this.C0.f32524h);
                float X = X(this.C0.f32526j, min, this.C0.f32522f.x, this.C0.f32523g.x - this.C0.f32522f.x, this.C0.f32524h);
                float X2 = X(this.C0.f32526j, min, this.C0.f32522f.y, this.C0.f32523g.y - this.C0.f32522f.y, this.C0.f32524h);
                this.W.x -= L0(this.C0.f32520d.x) - X;
                this.W.y -= M0(this.C0.f32520d.y) - X2;
                if (!z16 && this.C0.f32517a != this.C0.f32518b) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                c0(z17);
                F0(f17, this.f32482b0, this.C0.f32527k);
                z0(z16);
                if (z16) {
                    d.c(this.C0);
                    this.C0 = null;
                }
                invalidate();
            }
            int i27 = 180;
            char c16 = '#';
            char c17 = 15;
            int i28 = 5;
            if (this.f32498m != null && l0()) {
                int min2 = Math.min(this.f32493i, Q(this.U));
                boolean z18 = false;
                for (Map.Entry<Integer, List<k>> entry : this.f32498m.entrySet()) {
                    if (entry.getKey().intValue() == min2) {
                        for (k kVar : entry.getValue()) {
                            if (kVar.f32551e && (kVar.f32550d || kVar.f32549c == null)) {
                                z18 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<k>> entry2 : this.f32498m.entrySet()) {
                    if (entry2.getKey().intValue() == min2 || z18) {
                        for (k kVar2 : entry2.getValue()) {
                            K0(kVar2.f32547a, kVar2.f32552f);
                            if (!kVar2.f32550d && kVar2.f32549c != null) {
                                if (this.K0 != null) {
                                    canvas.drawRect(kVar2.f32552f, this.K0);
                                }
                                if (this.M0 == null) {
                                    this.M0 = new Matrix();
                                }
                                this.M0.reset();
                                i18 = i28;
                                i19 = min2;
                                i26 = i27;
                                H0(this.O0, 0.0f, 0.0f, kVar2.f32549c.getWidth(), 0.0f, kVar2.f32549c.getWidth(), kVar2.f32549c.getHeight(), 0.0f, kVar2.f32549c.getHeight());
                                if (i0() == 0) {
                                    H0(this.P0, kVar2.f32552f.left, kVar2.f32552f.top, kVar2.f32552f.right, kVar2.f32552f.top, kVar2.f32552f.right, kVar2.f32552f.bottom, kVar2.f32552f.left, kVar2.f32552f.bottom);
                                } else if (i0() == 90) {
                                    H0(this.P0, kVar2.f32552f.right, kVar2.f32552f.top, kVar2.f32552f.right, kVar2.f32552f.bottom, kVar2.f32552f.left, kVar2.f32552f.bottom, kVar2.f32552f.left, kVar2.f32552f.top);
                                } else if (i0() == i26) {
                                    H0(this.P0, kVar2.f32552f.right, kVar2.f32552f.bottom, kVar2.f32552f.left, kVar2.f32552f.bottom, kVar2.f32552f.left, kVar2.f32552f.top, kVar2.f32552f.right, kVar2.f32552f.top);
                                } else if (i0() == 270) {
                                    H0(this.P0, kVar2.f32552f.left, kVar2.f32552f.bottom, kVar2.f32552f.left, kVar2.f32552f.top, kVar2.f32552f.right, kVar2.f32552f.top, kVar2.f32552f.right, kVar2.f32552f.bottom);
                                }
                                this.M0.setPolyToPoly(this.O0, 0, this.P0, 0, 4);
                                canvas.drawBitmap(kVar2.f32549c, this.M0, this.H0);
                                if (this.C) {
                                    canvas.drawRect(kVar2.f32552f, this.J0);
                                }
                            } else {
                                i18 = i28;
                                i19 = min2;
                                i26 = i27;
                                if (kVar2.f32550d && this.C) {
                                    canvas.drawText("LOADING", kVar2.f32552f.left + y0(i18), kVar2.f32552f.top + y0(35), this.I0);
                                }
                            }
                            if (kVar2.f32551e && this.C) {
                                canvas.drawText("ISS " + kVar2.f32548b + " RECT " + kVar2.f32547a.top + "," + kVar2.f32547a.left + "," + kVar2.f32547a.bottom + "," + kVar2.f32547a.right, kVar2.f32552f.left + y0(i18), kVar2.f32552f.top + y0(15), this.I0);
                            }
                            i27 = i26;
                            i28 = i18;
                            min2 = i19;
                            c17 = 15;
                            c16 = '#';
                        }
                    }
                }
                i3 = i28;
            } else {
                i3 = 5;
                Bitmap bitmap = this.f32484d;
                if (bitmap != null && !bitmap.isRecycled()) {
                    float f18 = this.U;
                    if (this.f32486e) {
                        f18 *= this.f32489f0 / this.f32484d.getWidth();
                        f16 = this.U * (this.f32490g0 / this.f32484d.getHeight());
                    } else {
                        f16 = f18;
                    }
                    if (this.M0 == null) {
                        this.M0 = new Matrix();
                    }
                    this.M0.reset();
                    this.M0.postScale(f18, f16);
                    this.M0.postRotate(i0());
                    Matrix matrix = this.M0;
                    PointF pointF = this.W;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (i0() == 180) {
                        Matrix matrix2 = this.M0;
                        float f19 = this.U;
                        matrix2.postTranslate(this.f32489f0 * f19, f19 * this.f32490g0);
                    } else if (i0() == 90) {
                        this.M0.postTranslate(this.U * this.f32490g0, 0.0f);
                    } else if (i0() == 270) {
                        this.M0.postTranslate(0.0f, this.U * this.f32489f0);
                    }
                    if (this.K0 != null) {
                        if (this.N0 == null) {
                            this.N0 = new RectF();
                        }
                        RectF rectF = this.N0;
                        if (this.f32486e) {
                            i16 = this.f32484d.getWidth();
                        } else {
                            i16 = this.f32489f0;
                        }
                        float f26 = i16;
                        if (this.f32486e) {
                            i17 = this.f32484d.getHeight();
                        } else {
                            i17 = this.f32490g0;
                        }
                        rectF.set(0.0f, 0.0f, f26, i17);
                        this.M0.mapRect(this.N0);
                        canvas.drawRect(this.N0, this.K0);
                    }
                    canvas.drawBitmap(this.f32484d, this.M0, this.H0);
                }
            }
            if (this.C) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Scale: ");
                Locale locale = Locale.ENGLISH;
                sb5.append(String.format(locale, "%.2f", Float.valueOf(this.U)));
                sb5.append(" (");
                sb5.append(String.format(locale, "%.2f", Float.valueOf(p0())));
                sb5.append(" - ");
                sb5.append(String.format(locale, "%.2f", Float.valueOf(this.E)));
                sb5.append(")");
                canvas.drawText(sb5.toString(), y0(i3), y0(15), this.I0);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.W.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(this.W.y)), y0(i3), y0(30), this.I0);
                PointF e06 = e0();
                canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(e06.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(e06.y)), y0(i3), y0(45), this.I0);
                d dVar2 = this.C0;
                if (dVar2 != null) {
                    PointF J0 = J0(dVar2.f32519c);
                    PointF J02 = J0(this.C0.f32521e);
                    PointF J03 = J0(this.C0.f32520d);
                    canvas.drawCircle(J0.x, J0.y, y0(10), this.J0);
                    this.J0.setColor(SupportMenu.CATEGORY_MASK);
                    canvas.drawCircle(J02.x, J02.y, y0(20), this.J0);
                    this.J0.setColor(-16776961);
                    canvas.drawCircle(J03.x, J03.y, y0(25), this.J0);
                    this.J0.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, y0(30), this.J0);
                }
                if (this.f32507u0 != null) {
                    this.J0.setColor(SupportMenu.CATEGORY_MASK);
                    PointF pointF2 = this.f32507u0;
                    canvas.drawCircle(pointF2.x, pointF2.y, y0(20), this.J0);
                }
                if (this.A0 != null) {
                    this.J0.setColor(-16776961);
                    canvas.drawCircle(L0(this.A0.x), M0(this.A0.y), y0(35), this.J0);
                }
                if (this.B0 != null && this.f32499m0) {
                    this.J0.setColor(-16711681);
                    PointF pointF3 = this.B0;
                    canvas.drawCircle(pointF3.x, pointF3.y, y0(30), this.J0);
                }
                this.J0.setColor(-65281);
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
        if (this.f32489f0 > 0 && this.f32490g0 > 0) {
            if (z16 && z17) {
                size = E0();
                size2 = D0();
            } else if (z17) {
                size2 = (int) ((D0() / E0()) * size);
            } else if (z16) {
                size = (int) ((E0() / D0()) * size2);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        U("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i3), Integer.valueOf(i16));
        PointF e06 = e0();
        if (this.D0 && e06 != null) {
            this.C0 = null;
            this.f32483c0 = Float.valueOf(this.U);
            this.f32485d0 = e06;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        d dVar = this.C0;
        if (dVar != null && !dVar.f32525i) {
            A0(true);
            return true;
        }
        d dVar2 = this.C0;
        if (dVar2 != null) {
            d.c(dVar2);
        }
        this.C0 = null;
        if (this.W == null) {
            GestureDetector gestureDetector2 = this.f32502p0;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.f32499m0 && ((gestureDetector = this.f32501o0) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.f32496k0 = false;
            this.f32497l0 = false;
            this.f32500n0 = 0;
            return true;
        }
        if (this.f32481a0 == null) {
            this.f32481a0 = new PointF(0.0f, 0.0f);
        }
        if (this.f32482b0 == null) {
            this.f32482b0 = new PointF(0.0f, 0.0f);
        }
        if (this.f32507u0 == null) {
            this.f32507u0 = new PointF(0.0f, 0.0f);
        }
        float f16 = this.U;
        this.f32482b0.set(this.W);
        boolean w06 = w0(motionEvent);
        F0(f16, this.f32482b0, 2);
        if (w06 || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public final void setBitmapDecoderClass(@NonNull Class<? extends com.davemorrissey.labs.subscaleview.decoder.c> cls) {
        if (cls != null) {
            this.f32505s0 = new com.davemorrissey.labs.subscaleview.decoder.a(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(@NonNull com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.c> bVar) {
        if (bVar != null) {
            this.f32505s0 = bVar;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z16) {
        this.C = z16;
    }

    public final void setDoubleTapZoomDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setDoubleTapZoomDuration(int i3) {
        this.T = Math.max(0, i3);
    }

    public final void setDoubleTapZoomScale(float f16) {
        this.R = f16;
    }

    public final void setDoubleTapZoomStyle(int i3) {
        if (T0.contains(Integer.valueOf(i3))) {
            this.S = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i3);
    }

    public void setEagerLoadingEnabled(boolean z16) {
        this.M = z16;
    }

    public void setExecutor(@NonNull Executor executor) {
        if (executor != null) {
            this.L = executor;
            return;
        }
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(@NonNull o0.a aVar) {
        setImage(aVar, null, null);
    }

    public final void setMaxScale(float f16) {
        this.E = f16;
    }

    public void setMaxTileSize(int i3) {
        this.J = i3;
        this.K = i3;
    }

    public final void setMaximumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinScale(float f16) {
        this.F = f16;
    }

    public final void setMinimumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinimumScaleType(int i3) {
        if (W0.contains(Integer.valueOf(i3))) {
            this.I = i3;
            if (m0()) {
                c0(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i3);
    }

    public void setMinimumTileDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.G = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i3);
        if (m0()) {
            B0(false);
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.F0 = onLongClickListener;
    }

    public final void setOrientation(int i3) {
        if (S0.contains(Integer.valueOf(i3))) {
            this.D = i3;
            B0(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i3);
    }

    public final void setPanEnabled(boolean z16) {
        PointF pointF;
        this.N = z16;
        if (!z16 && (pointF = this.W) != null) {
            pointF.x = (getWidth() / 2) - (this.U * (E0() / 2));
            this.W.y = (getHeight() / 2) - (this.U * (D0() / 2));
            if (m0()) {
                z0(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i3) {
        if (V0.contains(Integer.valueOf(i3))) {
            this.H = i3;
            if (m0()) {
                c0(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i3);
    }

    public final void setQuickScaleEnabled(boolean z16) {
        this.Q = z16;
    }

    public final void setRegionDecoderClass(@NonNull Class<? extends com.davemorrissey.labs.subscaleview.decoder.d> cls) {
        if (cls != null) {
            this.f32506t0 = new com.davemorrissey.labs.subscaleview.decoder.a(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(@NonNull com.davemorrissey.labs.subscaleview.decoder.b<? extends com.davemorrissey.labs.subscaleview.decoder.d> bVar) {
        if (bVar != null) {
            this.f32506t0 = bVar;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f16, @Nullable PointF pointF) {
        this.C0 = null;
        this.f32483c0 = Float.valueOf(f16);
        this.f32485d0 = pointF;
        this.f32487e0 = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i3) {
        if (Color.alpha(i3) == 0) {
            this.K0 = null;
        } else {
            Paint paint = new Paint();
            this.K0 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.K0.setColor(i3);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z16) {
        this.P = z16;
    }

    public final void setImage(@NonNull o0.a aVar, ImageViewState imageViewState) {
        setImage(aVar, null, imageViewState);
    }

    public final void setImage(@NonNull o0.a aVar, o0.a aVar2) {
        setImage(aVar, aVar2, null);
    }

    public void setMaxTileSize(int i3, int i16) {
        this.J = i3;
        this.K = i16;
    }

    public final void setImage(@NonNull o0.a aVar, o0.a aVar2, ImageViewState imageViewState) {
        if (aVar != null) {
            B0(true);
            if (imageViewState != null) {
                C0(imageViewState);
            }
            if (aVar2 != null) {
                if (aVar.b() == null) {
                    if (aVar.f() > 0 && aVar.d() > 0) {
                        this.f32489f0 = aVar.f();
                        this.f32490g0 = aVar.d();
                        this.f32495j0 = aVar2.e();
                        if (aVar2.b() != null) {
                            this.f32488f = aVar2.i();
                            s0(aVar2.b());
                        } else {
                            Uri h16 = aVar2.h();
                            if (h16 == null && aVar2.c() != null) {
                                h16 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar2.c());
                            }
                            a0(new f(this, getContext(), this.f32505s0, h16, true));
                        }
                    } else {
                        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                }
            }
            if (aVar.b() != null && aVar.e() != null) {
                r0(Bitmap.createBitmap(aVar.b(), aVar.e().left, aVar.e().top, aVar.e().width(), aVar.e().height()), 0, false);
                return;
            }
            if (aVar.b() != null) {
                r0(aVar.b(), 0, aVar.i());
                return;
            }
            this.f32494i0 = aVar.e();
            Uri h17 = aVar.h();
            this.f32491h = h17;
            if (h17 == null && aVar.c() != null) {
                this.f32491h = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar.c());
            }
            if (!aVar.g() && this.f32494i0 == null) {
                a0(new f(this, getContext(), this.f32505s0, this.f32491h, false));
                return;
            } else {
                a0(new m(this, getContext(), this.f32506t0, this.f32491h));
                return;
            }
        }
        throw new NullPointerException("imageSource must not be null");
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private float f32517a;

        /* renamed from: b, reason: collision with root package name */
        private float f32518b;

        /* renamed from: c, reason: collision with root package name */
        private PointF f32519c;

        /* renamed from: d, reason: collision with root package name */
        private PointF f32520d;

        /* renamed from: e, reason: collision with root package name */
        private PointF f32521e;

        /* renamed from: f, reason: collision with root package name */
        private PointF f32522f;

        /* renamed from: g, reason: collision with root package name */
        private PointF f32523g;

        /* renamed from: h, reason: collision with root package name */
        private long f32524h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f32525i;

        /* renamed from: j, reason: collision with root package name */
        private int f32526j;

        /* renamed from: k, reason: collision with root package name */
        private int f32527k;

        /* renamed from: l, reason: collision with root package name */
        private long f32528l;

        d() {
            this.f32524h = 500L;
            this.f32525i = true;
            this.f32526j = 2;
            this.f32527k = 1;
            this.f32528l = System.currentTimeMillis();
        }

        public static /* synthetic */ g c(d dVar) {
            dVar.getClass();
            return null;
        }

        public static /* synthetic */ g d(d dVar, g gVar) {
            dVar.getClass();
            return gVar;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public void q0() {
    }

    public void t0() {
    }

    public void setOnImageEventListener(h hVar) {
    }

    public void setOnStateChangedListener(i iVar) {
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    private void F0(float f16, PointF pointF, int i3) {
    }
}
