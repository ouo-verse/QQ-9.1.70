package com.tencent.luggage.wxa.sq;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ScaleGestureDetector;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.sq.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.xweb.VideoJsCallback;
import com.tencent.xweb.WebView;
import com.tencent.xweb.extension.video.ClickableFrameLayout;
import com.tencent.xweb.extension.video.VideoStatusLayout;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements com.tencent.luggage.wxa.sq.a, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener {
    public TextView A;
    public TextView B;
    public com.tencent.luggage.wxa.sq.b C;
    public WebChromeClient.CustomViewCallback D;
    public GestureDetector E;
    public ScaleGestureDetector F;
    public boolean G;
    public long H;
    public double I;
    public double J;
    public double K;
    public boolean L;
    public int N;
    public int Q;
    public int R;
    public boolean S;
    public VideoJsCallback T;
    public AudioManager U;
    public int V;
    public double W;
    public float X;
    public float Y;

    /* renamed from: a, reason: collision with root package name */
    public Application f140592a;

    /* renamed from: a0, reason: collision with root package name */
    public Window f140593a0;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f140594b;

    /* renamed from: b0, reason: collision with root package name */
    public WindowManager.LayoutParams f140595b0;

    /* renamed from: c, reason: collision with root package name */
    public WebView f140596c;

    /* renamed from: c0, reason: collision with root package name */
    public String f140597c0;

    /* renamed from: d, reason: collision with root package name */
    public ViewGroup f140598d;

    /* renamed from: e, reason: collision with root package name */
    public q0 f140600e;

    /* renamed from: f, reason: collision with root package name */
    public FrameLayout f140602f;

    /* renamed from: f0, reason: collision with root package name */
    public OrientationEventListener f140603f0;

    /* renamed from: g, reason: collision with root package name */
    public View f140604g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f140605g0;

    /* renamed from: h, reason: collision with root package name */
    public ViewGroup f140606h;

    /* renamed from: h0, reason: collision with root package name */
    public Timer f140607h0;

    /* renamed from: i, reason: collision with root package name */
    public VideoStatusLayout f140608i;

    /* renamed from: j, reason: collision with root package name */
    public View f140610j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f140611j0;

    /* renamed from: k, reason: collision with root package name */
    public ProgressBar f140612k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f140614l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f140616m;

    /* renamed from: n, reason: collision with root package name */
    public ClickableFrameLayout f140618n;

    /* renamed from: n0, reason: collision with root package name */
    public Drawable f140619n0;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f140620o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f140622p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f140623p0;

    /* renamed from: q, reason: collision with root package name */
    public FrameLayout f140624q;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f140625q0;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f140626r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f140627r0;

    /* renamed from: s, reason: collision with root package name */
    public ImageView f140628s;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f140629s0;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f140630t;

    /* renamed from: t0, reason: collision with root package name */
    public int f140631t0;

    /* renamed from: u, reason: collision with root package name */
    public ImageView f140632u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f140633v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f140634w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f140635x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f140636y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f140637z;
    public double M = 1.0d;
    public int O = -3;
    public int P = -3;
    public float Z = 1.0f;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f140599d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f140601e0 = false;

    /* renamed from: i0, reason: collision with root package name */
    public int f140609i0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f140613k0 = new d0();

    /* renamed from: l0, reason: collision with root package name */
    public final q0.a f140615l0 = new e0();

    /* renamed from: m0, reason: collision with root package name */
    public final int f140617m0 = 200;

    /* renamed from: o0, reason: collision with root package name */
    public p0 f140621o0 = p0.None;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ar.n0.n();
            d.this.videoPlaybackRate(1.0d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f140639a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double f140640b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f140641c;

        public a0(double d16, double d17, boolean z16) {
            this.f140639a = d16;
            this.f140640b = d17;
            this.f140641c = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a((int) this.f140639a, (int) this.f140640b);
            if (this.f140641c) {
                d dVar = d.this;
                if (dVar.a(dVar.I)) {
                    x0.d("XWebNativeInterface", "onVideoEnterFullscreen, maybe live video");
                    d.this.f140610j.setVisibility(4);
                    d.this.f140633v.setVisibility(8);
                } else {
                    d.this.f140610j.setVisibility(0);
                }
                if (d.this.f140596c.isXWalkKernel()) {
                    d dVar2 = d.this;
                    if (dVar2.a(dVar2.f140604g) == null) {
                        d dVar3 = d.this;
                        if (dVar3.b(dVar3.f140604g) == null) {
                            x0.d("XWebNativeInterface", "onVideoEnterFullscreen, xwalk kernel and video view has no surface view or texture view");
                            d.this.f140602f.setBackgroundColor(0);
                            d.this.q();
                            return;
                        }
                    }
                }
                d.this.f140602f.setBackgroundColor(-16777216);
                d.this.f140600e.setBackgroundColor(0);
                d.this.q();
                return;
            }
            d.this.f140602f.setBackgroundColor(0);
            d.this.f140600e.setBackgroundColor(-16777216);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ar.n0.o();
            d.this.videoPlaybackRate(1.5d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b0 implements Runnable {
        public b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140606h != null) {
                d.this.f140606h.setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ar.n0.p();
            d.this.videoPlaybackRate(2.0d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f140646a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double f140647b;

        public c0(double d16, double d17) {
            this.f140646a = d16;
            this.f140647b = d17;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a((int) this.f140646a, (int) this.f140647b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sq.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC6727d implements View.OnClickListener {
        public ViewOnClickListenerC6727d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ar.n0.q();
            d.this.videoPlaybackRate(3.0d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements ValueCallback {
        public e() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.d("XWebNativeInterface", "evaluteJavascript, onReceiveValue:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e0 implements q0.a {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.d();
            }
        }

        public e0() {
        }

        @Override // com.tencent.luggage.wxa.sq.d.q0.a
        public void onWindowFocusChanged(boolean z16) {
            Activity w3;
            if (d.this.f140611j0 && z16 && (w3 = d.this.w()) != null) {
                x0.d("XWebNativeInterface", "window callback, onWindowFocusChanged hasFocus:" + z16 + ", mIsFullscreen:" + d.this.f140627r0 + ", focus element:" + w3.getCurrentFocus() + ", mCurrentOrientation:" + d.this.P + ", activity.getRequestedOrientation:" + w3.getRequestedOrientation());
                if (d.this.f140627r0) {
                    if (!d.this.h()) {
                        d.this.a((Runnable) new a());
                    }
                    if (d.this.P != -3 && d.this.P != w3.getRequestedOrientation()) {
                        d dVar = d.this;
                        dVar.b(dVar.P);
                    }
                }
                d.this.f140611j0 = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements ValueCallback {
        public f() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.b("XWebNativeInterface", "xwebToJS, videoPlay, result:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f0 extends OrientationEventListener {
        public f0(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            d.this.a(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements ValueCallback {
        public g() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.b("XWebNativeInterface", "xwebToJS, videoPause, result:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements ValueCallback {
        public h() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.b("XWebNativeInterface", "xwebToJS, videoChangeStatus, result:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h0 implements Runnable {
        public h0() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
        
            if (r0.b(r0.f140604g) != null) goto L8;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            if (d.this.f140596c.isXWalkKernel()) {
                d dVar = d.this;
                if (dVar.a(dVar.f140604g) == null) {
                    d dVar2 = d.this;
                }
                x0.d("XWebNativeInterface", "attach, xwalk kernel and video view has surface view or texture view");
                if (d.this.f140602f != null) {
                    d.this.f140602f.setBackgroundColor(-16777216);
                }
            }
            d.this.b(true);
            if (d.this.f140621o0 == p0.AttachingDetached) {
                d.this.f140621o0 = p0.Attached;
                d.this.c();
            } else {
                d.this.f140621o0 = p0.Attached;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements ValueCallback {
        public i() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.b("XWebNativeInterface", "xwebToJS, videoSeek, result:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i0 implements Runnable {
        public i0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140604g != null) {
                d.this.f140604g.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements ValueCallback {
        public j() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.b("XWebNativeInterface", "xwebToJS, videoPlaybackRate, result:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j0 implements View.OnClickListener {
        public j0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ar.n0.j();
            d.this.videoMute(!r2.L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.videoExitFullscreen();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k0 implements View.OnClickListener {
        public k0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ar.n0.k();
            d.this.i();
            d.this.r();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements ValueCallback {
        public l() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.b("XWebNativeInterface", "xwebToJS, videoMute, result:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l0 implements View.OnClickListener {
        public l0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.videoExitFullscreen();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements ValueCallback {
        public m() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.b("XWebNativeInterface", "xwebToJS, videoExitFullscreen, result:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m0 implements View.OnClickListener {
        public m0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.videoChangeStatus();
            d.this.t();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f140670a;

        public n(Runnable runnable) {
            this.f140670a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.f140605g0) {
                return;
            }
            this.f140670a.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n0 implements View.OnClickListener {
        public n0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ar.n0.l();
            d.this.videoPlaybackRate(0.5d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o extends TimerTask {
        public o() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.this.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o0 implements View.OnClickListener {
        public o0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ar.n0.m();
            d.this.videoPlaybackRate(0.75d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140606h != null) {
                d.this.f140606h.setVisibility(0);
                d.this.f140622p.setVisibility(0);
                d.this.f140620o.setVisibility(0);
                d.this.t();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum p0 {
        None,
        Attaching,
        Attached,
        Detaching,
        AttachingDetached,
        DetachingAttached
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140606h != null) {
                d.this.f140622p.setVisibility(4);
                d.this.f140620o.setVisibility(4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class q0 extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        public a f140684a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public interface a {
            void onWindowFocusChanged(boolean z16);
        }

        public q0(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onWindowFocusChanged(boolean z16) {
            super.onWindowFocusChanged(z16);
            a aVar = this.f140684a;
            if (aVar != null) {
                aVar.onWindowFocusChanged(z16);
            }
        }

        public void setWindowFocusChangedListener(a aVar) {
            this.f140684a = aVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140612k != null) {
                d.this.f140612k.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140612k != null) {
                d.this.f140612k.setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140624q != null) {
                d.this.f140624q.setVisibility(0);
            }
            d.this.o();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140624q != null) {
                d.this.f140624q.setVisibility(4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class v implements View.OnTouchListener {
        public v() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!d.this.G) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                d.this.N = 0;
            } else if (action != 5) {
                if (action == 6) {
                    d.this.N = 0;
                }
            } else if (motionEvent.getPointerCount() == 2) {
                d.this.N = 1;
            }
            if (motionEvent.getAction() == 1 && d.this.f140609i0 == 3) {
                d dVar = d.this;
                if (!dVar.a(dVar.I)) {
                    double d16 = (d.this.I * d.this.X) / 100.0d;
                    d.this.a(d16, true);
                    d.this.videoSeek(d16);
                    d.this.f140609i0 = 0;
                }
            }
            if (d.this.N == 1) {
                return d.this.F.onTouchEvent(motionEvent);
            }
            return d.this.E.onTouchEvent(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f140690a;

        public w(boolean z16) {
            this.f140690a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140632u != null) {
                if (this.f140690a) {
                    d.this.f140632u.setImageResource(R.drawable.ma8);
                    d.this.f140632u.setContentDescription(d.this.e().getString(R.string.f242797vj));
                } else {
                    d.this.f140632u.setImageResource(R.drawable.ma7);
                    d.this.f140632u.setContentDescription(d.this.e().getString(R.string.f242787vi));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class x implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f140692a;

        public x(boolean z16) {
            this.f140692a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f140628s != null) {
                if (this.f140692a) {
                    d.this.f140628s.setImageResource(R.drawable.m7e);
                    d.this.f140628s.setContentDescription(d.this.e().getString(R.string.f242767vg));
                } else {
                    d.this.f140628s.setImageResource(R.drawable.m7f);
                    d.this.f140628s.setContentDescription(d.this.e().getString(R.string.f242777vh));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class y implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f140694a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double f140695b;

        public y(boolean z16, double d16) {
            this.f140694a = z16;
            this.f140695b = d16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.C != null && this.f140694a && d.this.I != 0.0d) {
                d.this.C.a((float) ((this.f140695b * 100.0d) / d.this.I), false);
            }
            if (d.this.f140614l != null) {
                d.this.f140614l.setText(d.this.c(this.f140695b));
            }
            if (d.this.f140616m != null) {
                d.this.f140616m.setText(d.this.f());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class z implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f140697a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double[] f140698b;

        public z(double d16, double[] dArr) {
            this.f140697a = d16;
            this.f140698b = dArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.C != null) {
                d.this.C.a(this.f140697a, this.f140698b);
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        videoChangeStatus();
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f140609i0 = 0;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x010c, code lost:
    
        if (r3 < 0.0d) goto L50;
     */
    @Override // android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        float height;
        int width;
        if (motionEvent != null && motionEvent2 != null) {
            float x16 = motionEvent2.getX() - motionEvent.getX();
            float y16 = motionEvent2.getY() - motionEvent.getY();
            if (this.f140606h.getHeight() > this.f140606h.getWidth()) {
                height = this.f140606h.getWidth();
                width = this.f140606h.getHeight();
            } else {
                height = this.f140606h.getHeight();
                width = this.f140606h.getWidth();
            }
            float f18 = width;
            int i3 = this.f140609i0;
            float f19 = 1.0f;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3 && !a(this.I)) {
                            float x17 = motionEvent2.getX() - motionEvent.getX();
                            float a16 = this.C.a();
                            this.Y = a16;
                            if (x17 > 0.0f) {
                                float f26 = (int) (a16 + ((x17 / f18) * 100.0f));
                                this.X = f26;
                                if (f26 > 100.0f) {
                                    this.X = 100.0f;
                                }
                            } else {
                                float f27 = (int) (a16 + ((x17 / f18) * 100.0f));
                                this.X = f27;
                                if (f27 < 0.0f) {
                                    this.X = 0.0f;
                                }
                            }
                            this.f140608i.setVideoTimeProgress(b((this.I * this.X) / 100.0d));
                            this.f140608i.a();
                        }
                    } else {
                        float f28 = (((y16 * (-1.0f)) / height) * 1.2f) + this.Z;
                        if (f28 < 0.0f) {
                            f19 = 0.0f;
                        } else if (f28 <= 1.0f) {
                            f19 = f28;
                        }
                        WindowManager.LayoutParams layoutParams = this.f140595b0;
                        layoutParams.screenBrightness = f19;
                        this.f140593a0.setAttributes(layoutParams);
                        this.f140608i.setBrightProgress((int) (f19 * 100.0f));
                        this.f140608i.a();
                    }
                } else {
                    float f29 = y16 * (-1.0f);
                    double d16 = ((this.V * f29) / height) * 1.2f;
                    int i16 = (int) d16;
                    if (i16 == 0 && Math.abs(d16) > 0.20000000298023224d) {
                        if (f29 > 0.0f) {
                            i16 = 1;
                        } else if (f29 < 0.0f) {
                            i16 = -1;
                        }
                    }
                    double d17 = this.W + i16;
                    double d18 = this.V;
                    if (d17 <= d18) {
                        d18 = 0.0d;
                    }
                    d17 = d18;
                    this.U.setStreamVolume(3, (int) d17, 4);
                    this.f140608i.setVolumeProgress((int) ((d17 / Float.valueOf(this.V).floatValue()) * 100.0d));
                    this.f140608i.a();
                }
            } else {
                double ceil = Math.ceil(this.f140596c.getContext().getResources().getDisplayMetrics().density * 25.0f);
                if (Math.abs(x16) - Math.abs(y16) > 1.0f) {
                    double d19 = ceil * 2.0d;
                    if (motionEvent.getX() >= d19 && motionEvent.getX() <= this.f140606h.getWidth() - d19) {
                        this.f140609i0 = 3;
                    } else {
                        this.f140609i0 = 0;
                    }
                } else {
                    n();
                    double d26 = ceil * 2.0d;
                    if (motionEvent.getY() >= d26 && motionEvent.getY() <= this.f140606h.getHeight() - d26) {
                        if (motionEvent.getX() < this.f140606h.getWidth() / 2.0f) {
                            this.f140609i0 = 2;
                        } else {
                            this.f140609i0 = 1;
                        }
                    } else {
                        this.f140609i0 = 0;
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (m()) {
            j();
            return true;
        }
        u();
        v();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    @JavascriptInterface
    public void onSpecialVideoEnterFullscreen(int i3) {
        x0.d("XWebNativeInterface", "onSpecialVideoEnterFullscreen:" + i3);
        com.tencent.luggage.wxa.ar.n0.a(i3, this.f140596c.isXWalkKernel());
    }

    @JavascriptInterface
    public void onSpecialVideoHook(int i3) {
        x0.d("XWebNativeInterface", "onSpecialVideoHook:" + i3);
        com.tencent.luggage.wxa.ar.n0.b(i3, this.f140596c.isXWalkKernel());
    }

    @JavascriptInterface
    public boolean onVideoEmptied() {
        x0.d("XWebNativeInterface", "onVideoEmptied");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoEmptied();
            return true;
        }
        return false;
    }

    @JavascriptInterface
    public void onVideoEnded() {
        x0.d("XWebNativeInterface", "onVideoEnded");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoEnded();
        }
    }

    @JavascriptInterface
    public void onVideoEnterFullscreen(boolean z16, long j3, double d16, double d17, boolean z17, boolean z18, double d18, double d19, double[] dArr) {
        double d26;
        x0.d("XWebNativeInterface", "onVideoEnterFullscreen, isVideoTag:" + z16 + ",width:" + d16 + ",height:" + d17 + ",pause:" + z17 + ",seeking:" + z18 + ",currentTime:" + d18 + ",duration:" + d19 + ", accessibility:" + com.tencent.luggage.wxa.ar.c.a(e()).a());
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            d26 = d19;
            videoJsCallback.onVideoEnterFullscreen(z16, j3, d16, d17, z17, z18, d18, d19, dArr);
        } else {
            d26 = d19;
        }
        if (this.f140596c.isXWalkKernel()) {
            com.tencent.luggage.wxa.ar.n0.W();
        } else if (this.f140596c.isSysKernel()) {
            com.tencent.luggage.wxa.ar.n0.O();
        }
        if (z16) {
            if (this.f140596c.isXWalkKernel()) {
                com.tencent.luggage.wxa.ar.n0.X();
            } else if (this.f140596c.isSysKernel()) {
                com.tencent.luggage.wxa.ar.n0.P();
            }
            this.G = true;
        } else {
            this.G = false;
        }
        this.H = j3;
        this.I = d26;
        this.J = d16;
        this.K = d17;
        if (z18) {
            onVideoSeeking();
        } else {
            onVideoSeeked();
        }
        a((Runnable) new a0(d16, d17, z16));
        onVideoTimeUpdate(d18, d19, dArr);
        e(z17);
    }

    @JavascriptInterface
    public void onVideoError(int i3, String str) {
        x0.d("XWebNativeInterface", "onVideoError");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoError(i3, str);
        }
    }

    @JavascriptInterface
    public void onVideoExitFullscreen() {
        x0.d("XWebNativeInterface", "onVideoExitFullscreen");
        this.G = false;
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoExitFullscreen();
        }
        a((Runnable) new b0());
    }

    @JavascriptInterface
    public void onVideoPause() {
        x0.d("XWebNativeInterface", "onVideoPause");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoPause();
        }
        e(true);
    }

    @JavascriptInterface
    public void onVideoPlay() {
        x0.d("XWebNativeInterface", "onVideoPlay");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoPlay();
        }
        e(false);
    }

    @JavascriptInterface
    public void onVideoPlaying() {
        x0.d("XWebNativeInterface", "onVideoPlaying");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoPlaying();
        }
        k();
    }

    @JavascriptInterface
    public void onVideoRateChange(double d16) {
        x0.d("XWebNativeInterface", "onVideoRateChange, rate:" + d16);
        this.M = d16;
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoRateChange(d16);
        }
    }

    @JavascriptInterface
    public void onVideoSeeked() {
        x0.d("XWebNativeInterface", "onVideoSeeked");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoSeeked();
        }
        k();
    }

    @JavascriptInterface
    public void onVideoSeeking() {
        x0.d("XWebNativeInterface", "onVideoSeeking");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoSeeking();
        }
        s();
    }

    @JavascriptInterface
    public void onVideoSizeUpdate(double d16, double d17) {
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoSizeUpdate(d16, d17);
        }
        if (this.K != d17 || this.J != d16) {
            x0.d("XWebNativeInterface", "onVideoSizeUpdate width:" + d16 + ", height:" + d17);
            this.J = d16;
            this.K = d17;
            a((Runnable) new c0(d16, d17));
        }
    }

    @JavascriptInterface
    public void onVideoTimeUpdate(double d16, double d17, double[] dArr) {
        this.I = d17;
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoTimeUpdate(d16, d17, dArr);
        }
        a(d16, true);
        a(d17, dArr);
    }

    @JavascriptInterface
    public void onVideoVolumeChange(boolean z16) {
        x0.d("XWebNativeInterface", "onVideoVolumeChange, muted:" + z16);
        this.L = z16;
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoVolumeChange(z16);
        }
        d(this.L);
    }

    @JavascriptInterface
    public void onVideoWaiting() {
        x0.d("XWebNativeInterface", "onVideoWaiting");
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null) {
            videoJsCallback.onVideoWaiting();
        }
        s();
    }

    @Override // com.tencent.xweb.VideoControl
    public boolean supportSetRequestedOrientationCallback() {
        return true;
    }

    @Override // com.tencent.xweb.VideoControl
    public void videoChangeStatus() {
        x0.d("XWebNativeInterface", "xwebToJS, videoChangeStatus");
        this.f140596c.evaluateJavascript("xwebVideoBridge.xwebToJS_Video_Play();", new h());
    }

    @Override // com.tencent.xweb.VideoControl
    public void videoExitFullscreen() {
        x0.d("XWebNativeInterface", "xwebToJS, videoExitFullscreen");
        this.f140596c.evaluateJavascript("xwebVideoBridge.xwebToJS_Video_ExitFullscreen();", new m());
    }

    @Override // com.tencent.xweb.VideoControl
    public void videoMute(boolean z16) {
        x0.d("XWebNativeInterface", "xwebToJS, videoMute muted:" + z16);
        this.f140596c.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_MuteChange(%b);", Boolean.valueOf(z16)), new l());
    }

    @Override // com.tencent.xweb.VideoControl
    public void videoPause() {
        x0.d("XWebNativeInterface", "xwebToJS, videoPause");
        this.f140596c.evaluateJavascript("xwebVideoBridge.xwebToJS_Video_NewPause();", new g());
    }

    @Override // com.tencent.xweb.VideoControl
    public void videoPlay() {
        x0.d("XWebNativeInterface", "xwebToJS, videoPlay");
        this.f140596c.evaluateJavascript("xwebVideoBridge.xwebToJS_Video_NewPlay();", new f());
    }

    @Override // com.tencent.xweb.VideoControl
    public void videoPlaybackRate(double d16) {
        x0.d("XWebNativeInterface", "xwebToJS, videoPlaybackRate rate:" + d16);
        j();
        this.f140596c.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_RateChange(%f);", Double.valueOf(d16)), new j());
    }

    @Override // com.tencent.xweb.VideoControl
    public void videoSeek(double d16) {
        x0.d("XWebNativeInterface", "xwebToJS, videoSeek time:" + d16);
        this.f140596c.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", Double.valueOf(d16)), new i());
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g0 implements b.InterfaceC6726b {
        public g0() {
        }

        @Override // com.tencent.luggage.wxa.sq.b.InterfaceC6726b
        public void a() {
            d.this.u();
            d.this.q();
        }

        @Override // com.tencent.luggage.wxa.sq.b.InterfaceC6726b
        public void a(float f16, boolean z16) {
            if (z16) {
                double d16 = (d.this.I * f16) / 100.0d;
                d.this.a(d16, false);
                d.this.videoSeek(d16);
            }
            d.this.t();
        }
    }

    public final void d() {
        int descendantFocusability;
        int descendantFocusability2;
        if ((this.f140596c.getView() instanceof ViewGroup) && (descendantFocusability2 = ((ViewGroup) this.f140596c.getView()).getDescendantFocusability()) != 131072) {
            this.Q = descendantFocusability2;
            ((ViewGroup) this.f140596c.getView()).setDescendantFocusability(131072);
        }
        if ((this.f140596c.getWebViewUI() instanceof ViewGroup) && (descendantFocusability = ((ViewGroup) this.f140596c.getWebViewUI()).getDescendantFocusability()) != 131072) {
            this.R = descendantFocusability;
            ((ViewGroup) this.f140596c.getWebViewUI()).setDescendantFocusability(131072);
        }
        x0.d("XWebNativeInterface", "fixFocus, requestFocus return:" + this.f140596c.getView().requestFocus());
    }

    public final Context e() {
        return this.f140596c.getContext();
    }

    public final String f() {
        double d16 = this.I;
        return a(d16, d16);
    }

    public boolean g() {
        return this.f140627r0;
    }

    public final boolean h() {
        return this.f140596c.getView().hasFocus();
    }

    public void i() {
        a((Runnable) new q());
    }

    public final void j() {
        a((Runnable) new u());
    }

    public final void k() {
        a((Runnable) new s());
    }

    public void l() {
        if (this.f140605g0) {
            return;
        }
        q0 q0Var = new q0(e());
        this.f140600e = q0Var;
        q0Var.setId(R.id.f125797n1);
        FrameLayout frameLayout = new FrameLayout(e());
        this.f140602f = frameLayout;
        frameLayout.setId(R.id.f125787n0);
        GestureDetector gestureDetector = new GestureDetector(e(), this);
        this.E = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        this.F = new ScaleGestureDetector(e(), this);
        this.E.setIsLongpressEnabled(false);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(e()).inflate(R.layout.i8n, (ViewGroup) null);
        this.f140606h = viewGroup;
        viewGroup.setVisibility(8);
        this.f140622p = (LinearLayout) this.f140606h.findViewById(R.id.ydg);
        ImageView imageView = (ImageView) this.f140606h.findViewById(R.id.xhl);
        this.f140626r = imageView;
        imageView.setOnClickListener(new k());
        this.f140612k = (ProgressBar) this.f140606h.findViewById(R.id.f28460j0);
        this.f140608i = (VideoStatusLayout) this.f140606h.findViewById(R.id.ydf);
        ClickableFrameLayout clickableFrameLayout = (ClickableFrameLayout) this.f140606h.findViewById(R.id.yd_);
        this.f140618n = clickableFrameLayout;
        clickableFrameLayout.setGestureDetector(this.E);
        this.f140618n.setOnTouchListener(new v());
        this.f140620o = (LinearLayout) this.f140606h.findViewById(R.id.ydi);
        this.f140610j = this.f140606h.findViewById(R.id.ydc);
        this.f140614l = (TextView) this.f140606h.findViewById(R.id.f107196_r);
        this.f140616m = (TextView) this.f140606h.findViewById(R.id.f112136n4);
        com.tencent.luggage.wxa.sq.b bVar = new com.tencent.luggage.wxa.sq.b(this.f140606h.findViewById(R.id.f25930c6));
        this.C = bVar;
        bVar.a(new g0());
        ImageView imageView2 = (ImageView) this.f140606h.findViewById(R.id.xhs);
        this.f140628s = imageView2;
        if (this.f140599d0) {
            imageView2.setVisibility(0);
            this.f140628s.setOnClickListener(new j0());
        } else {
            imageView2.setVisibility(8);
        }
        TextView textView = (TextView) this.f140606h.findViewById(R.id.f95055dy);
        this.f140633v = textView;
        if (this.f140601e0) {
            textView.setVisibility(0);
            this.f140633v.setOnClickListener(new k0());
        } else {
            textView.setVisibility(8);
        }
        ImageView imageView3 = (ImageView) this.f140606h.findViewById(R.id.xhp);
        this.f140630t = imageView3;
        imageView3.setOnClickListener(new l0());
        ImageView imageView4 = (ImageView) this.f140606h.findViewById(R.id.xht);
        this.f140632u = imageView4;
        imageView4.setOnClickListener(new m0());
        FrameLayout frameLayout2 = (FrameLayout) this.f140606h.findViewById(R.id.ydd);
        this.f140624q = frameLayout2;
        TextView textView2 = (TextView) frameLayout2.findViewById(R.id.f95065dz);
        this.f140634w = textView2;
        textView2.setOnClickListener(new n0());
        TextView textView3 = (TextView) this.f140624q.findViewById(R.id.f95075e0);
        this.f140635x = textView3;
        textView3.setOnClickListener(new o0());
        TextView textView4 = (TextView) this.f140624q.findViewById(R.id.f95085e1);
        this.f140636y = textView4;
        textView4.setOnClickListener(new a());
        TextView textView5 = (TextView) this.f140624q.findViewById(R.id.f95095e2);
        this.f140637z = textView5;
        textView5.setOnClickListener(new b());
        TextView textView6 = (TextView) this.f140624q.findViewById(R.id.f95105e3);
        this.A = textView6;
        textView6.setOnClickListener(new c());
        TextView textView7 = (TextView) this.f140624q.findViewById(R.id.f95115e4);
        this.B = textView7;
        textView7.setOnClickListener(new ViewOnClickListenerC6727d());
        this.f140605g0 = true;
    }

    public final boolean m() {
        FrameLayout frameLayout = this.f140624q;
        return frameLayout != null && frameLayout.getVisibility() == 0;
    }

    public void n() {
        Activity w3;
        if (this.U == null) {
            this.U = (AudioManager) e().getSystemService("audio");
        }
        this.V = this.U.getStreamMaxVolume(3);
        this.W = SystemMethodProxy.getStreamVolume(this.U, 3);
        if (this.f140593a0 == null && (w3 = w()) != null) {
            this.f140593a0 = w3.getWindow();
        }
        Window window = this.f140593a0;
        if (window != null && this.f140595b0 == null) {
            this.f140595b0 = window.getAttributes();
        }
        WindowManager.LayoutParams layoutParams = this.f140595b0;
        if (layoutParams != null) {
            float f16 = layoutParams.screenBrightness;
            this.Z = f16;
            if (f16 == -1.0f) {
                try {
                    this.Z = (float) (Settings.System.getInt(e().getContentResolver(), "screen_brightness") / 256.0d);
                } catch (Settings.SettingNotFoundException e16) {
                    x0.a("XWebNativeInterface", "get brightness error", e16);
                }
            }
        }
    }

    public final void o() {
        this.f140634w.setTextColor(e().getColorStateList(R.color.f158034d15));
        this.f140635x.setTextColor(e().getColorStateList(R.color.f158034d15));
        this.f140636y.setTextColor(e().getColorStateList(R.color.f158034d15));
        this.f140637z.setTextColor(e().getColorStateList(R.color.f158034d15));
        this.A.setTextColor(e().getColorStateList(R.color.f158034d15));
        this.B.setTextColor(e().getColorStateList(R.color.f158034d15));
        double d16 = this.M;
        if (d16 == 0.5d) {
            this.f140634w.setTextColor(e().getColorStateList(R.color.f158029d10));
            return;
        }
        if (d16 == 0.75d) {
            this.f140635x.setTextColor(e().getColorStateList(R.color.f158029d10));
            return;
        }
        if (d16 == 1.0d) {
            this.f140636y.setTextColor(e().getColorStateList(R.color.f158029d10));
            return;
        }
        if (d16 == 1.5d) {
            this.f140637z.setTextColor(e().getColorStateList(R.color.f158029d10));
        } else if (d16 == 2.0d) {
            this.A.setTextColor(e().getColorStateList(R.color.f158029d10));
        } else if (d16 == 3.0d) {
            this.B.setTextColor(e().getColorStateList(R.color.f158029d10));
        }
    }

    public final void p() {
        x0.d("XWebNativeInterface", "resumeFocus");
        if ((this.f140596c.getView() instanceof ViewGroup) && this.Q != 0) {
            ((ViewGroup) this.f140596c.getView()).setDescendantFocusability(this.Q);
            this.Q = 0;
        }
        if (!(this.f140596c.getWebViewUI() instanceof ViewGroup) || this.R == 0) {
            return;
        }
        ((ViewGroup) this.f140596c.getView()).setDescendantFocusability(this.R);
        this.R = 0;
    }

    public void q() {
        a((Runnable) new p());
    }

    public final void r() {
        a((Runnable) new t());
    }

    public final void s() {
        a((Runnable) new r());
    }

    public void t() {
        u();
        if (com.tencent.luggage.wxa.ar.c.a(e()).a()) {
            return;
        }
        BaseTimer baseTimer = new BaseTimer();
        this.f140607h0 = baseTimer;
        baseTimer.schedule(new o(), 7000L);
    }

    public void u() {
        Timer timer = this.f140607h0;
        if (timer != null) {
            timer.cancel();
            this.f140607h0.purge();
            this.f140607h0 = null;
        }
    }

    public void v() {
        if (!com.tencent.luggage.wxa.ar.c.a(e()).a()) {
            if (this.f140622p.getVisibility() == 0) {
                i();
                return;
            } else {
                q();
                return;
            }
        }
        q();
    }

    public final Activity w() {
        Activity a16 = a(this.f140596c.getContext());
        if (a16 == null) {
            x0.c("XWebNativeInterface", "tryGetActivity but no Activity");
        }
        return a16;
    }

    public void x() {
        x0.d("XWebNativeInterface", "unRegisterActivityLifecycleCallback application:" + this.f140592a);
        Application application = this.f140592a;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.f140613k0);
            this.f140592a = null;
        }
    }

    public void y() {
        if (this.f140605g0) {
            this.f140605g0 = false;
            this.f140598d = null;
            this.f140600e = null;
            this.f140602f = null;
            GestureDetector gestureDetector = this.E;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener(null);
                this.E = null;
            }
            this.F = null;
            this.f140606h = null;
            this.C = null;
            this.f140610j = null;
            this.f140612k = null;
            this.f140614l = null;
            this.f140616m = null;
            this.f140608i = null;
            this.f140618n.setGestureDetector(null);
            this.f140618n.setOnTouchListener(null);
            this.f140618n = null;
            this.f140622p = null;
            this.f140620o = null;
            this.f140633v = null;
            this.f140634w = null;
            this.f140635x = null;
            this.f140636y = null;
            this.f140637z = null;
            this.A = null;
            this.B = null;
            this.f140624q = null;
            this.f140630t.setOnClickListener(null);
            this.f140630t = null;
            this.f140632u.setOnClickListener(null);
            this.f140632u = null;
            this.f140626r.setOnClickListener(null);
            this.f140626r = null;
            this.f140628s.setOnClickListener(null);
            this.f140628s = null;
            x0.d("XWebNativeInterface", "uninitView");
        }
    }

    public void z() {
        this.U = null;
        this.f140593a0 = null;
        this.f140595b0 = null;
    }

    public final String c(double d16) {
        return a(d16, this.I);
    }

    public void e(boolean z16) {
        a((Runnable) new w(z16));
    }

    public void c() {
        x0.d("XWebNativeInterface", "detach start");
        if (!g()) {
            x0.d("XWebNativeInterface", "detach, has exited fullscreen");
            return;
        }
        this.f140594b = null;
        z();
        OrientationEventListener orientationEventListener = this.f140603f0;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f140603f0 = null;
        }
        this.f140600e.setWindowFocusChangedListener(null);
        x();
        p0 p0Var = this.f140621o0;
        if (p0Var == p0.Attached) {
            this.f140621o0 = p0.Detaching;
        } else if (p0Var == p0.Attaching) {
            this.f140621o0 = p0.AttachingDetached;
            return;
        }
        if (this.f140619n0 != null) {
            this.f140596c.getView().setBackground(this.f140619n0);
            this.f140619n0 = null;
        } else {
            this.f140596c.getView().setBackground(new ColorDrawable(0));
        }
        if (this.f140596c.isXWalkKernel()) {
            this.f140600e.removeView(this.f140596c.getView());
            this.f140598d.addView(this.f140596c.getView(), 0);
        }
        View view = this.f140604g;
        if (view != null) {
            ViewParent parent = view.getParent();
            FrameLayout frameLayout = this.f140602f;
            if (parent == frameLayout) {
                frameLayout.removeView(this.f140604g);
            }
        }
        ViewParent parent2 = this.f140602f.getParent();
        q0 q0Var = this.f140600e;
        if (parent2 == q0Var) {
            q0Var.removeView(this.f140602f);
        }
        ViewParent parent3 = this.f140606h.getParent();
        q0 q0Var2 = this.f140600e;
        if (parent3 == q0Var2) {
            q0Var2.removeView(this.f140606h);
        }
        this.f140606h.setVisibility(8);
        int i3 = this.O;
        if (i3 != -3) {
            b(i3);
            this.O = -3;
        }
        b(false);
        if (this.f140600e.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f140600e.getParent()).removeView(this.f140600e);
        }
        if (this.f140621o0 == p0.DetachingAttached) {
            this.f140621o0 = p0.None;
            b();
        } else {
            this.f140621o0 = p0.None;
        }
        c(false);
        x0.d("XWebNativeInterface", "detach end");
    }

    @Override // com.tencent.luggage.wxa.sq.a
    public void b(Object obj) {
        try {
            new com.tencent.luggage.wxa.ar.g0(obj, "addJavascriptInterface", Object.class, String.class).a(this, "xwebToNative");
        } catch (Exception e16) {
            x0.a("XWebNativeInterface", "registerJavascriptInterface, error", e16);
        }
    }

    public final Activity a(Context context) {
        Context baseContext;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
            return null;
        }
        return a(baseContext);
    }

    public final void b(int i3) {
        Activity w3 = w();
        if (w3 == null) {
            x0.d("XWebNativeInterface", "setRequestedOrientation activity = null");
            return;
        }
        VideoJsCallback videoJsCallback = this.T;
        if (videoJsCallback != null && videoJsCallback.onSetRequestedOrientation(i3)) {
            x0.d("XWebNativeInterface", "setRequestedOrientation by wechat client");
        } else {
            w3.setRequestedOrientation(i3);
        }
    }

    public void d(boolean z16) {
        a((Runnable) new x(z16));
    }

    public void a(Activity activity, View view, View view2, Context context, String str) {
        this.f140596c = (WebView) view;
        this.f140597c0 = str;
    }

    public final String b(double d16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a(d16, this.I));
        sb5.append("/");
        double d17 = this.I;
        sb5.append(a(d17, d17));
        return sb5.toString();
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.f140599d0 = bundle.getBoolean("fullscreen_video_enable_mute", false);
            this.f140601e0 = bundle.getBoolean("fullscreen_video_enable_speed", false);
            x0.d("XWebNativeInterface", "initConfigs, before enableMute:" + this.f140599d0 + ", enableSpeed:" + this.f140601e0);
            String str = this.f140597c0;
            if (str != null && !str.contains("xwebVideoBridge.xwebToJS_Video_MuteChange")) {
                this.f140599d0 = false;
            }
            String str2 = this.f140597c0;
            if (str2 != null && !str2.contains("xwebVideoBridge.xwebToJS_Video_RateChange")) {
                this.f140601e0 = false;
            }
            x0.d("XWebNativeInterface", "initConfigs, after enableMute:" + this.f140599d0 + ", enableSpeed:" + this.f140601e0);
        }
    }

    public final TextureView b(View view) {
        if (view instanceof TextureView) {
            return (TextureView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            TextureView b16 = b(viewGroup.getChildAt(i3));
            if (b16 != null) {
                return b16;
            }
        }
        return null;
    }

    public void b() {
        SurfaceView a16;
        x0.d("XWebNativeInterface", "attach start");
        if (g()) {
            x0.d("XWebNativeInterface", "attach, has entered fullscreen");
            return;
        }
        Activity w3 = w();
        if (w3 == null) {
            x0.d("XWebNativeInterface", "attach, activity is null");
            return;
        }
        this.f140594b = new WeakReference(w3);
        OrientationEventListener orientationEventListener = this.f140603f0;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f140603f0 = null;
        }
        f0 f0Var = new f0(e().getApplicationContext(), 3);
        this.f140603f0 = f0Var;
        f0Var.enable();
        this.f140600e.setWindowFocusChangedListener(this.f140615l0);
        a(w3);
        n();
        p0 p0Var = this.f140621o0;
        if (p0Var == p0.None) {
            this.f140621o0 = p0.Attaching;
        } else if (p0Var == p0.Detaching) {
            this.f140621o0 = p0.DetachingAttached;
            return;
        }
        c(true);
        ((FrameLayout) w3.getWindow().getDecorView()).addView(this.f140600e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f140600e.setBackgroundColor(0);
        if (this.f140596c.isXWalkKernel()) {
            ViewGroup viewGroup = (ViewGroup) this.f140596c.getView().getParent();
            this.f140598d = viewGroup;
            viewGroup.removeView(this.f140596c.getView());
            this.f140600e.addView(this.f140596c.getView(), this.f140600e.getChildCount());
            this.f140602f.setBackgroundColor(0);
            a((Runnable) new h0());
        } else {
            b(true);
            this.f140621o0 = p0.Attached;
        }
        View view = this.f140604g;
        if (view != null) {
            this.f140602f.addView(view);
            this.f140602f.setBackgroundColor(0);
            q0 q0Var = this.f140600e;
            q0Var.addView(this.f140602f, q0Var.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
            if (this.f140596c.isSysKernel()) {
                this.f140604g.setVisibility(4);
            }
        }
        this.f140600e.addView(this.f140606h, new FrameLayout.LayoutParams(-1, -1, 17));
        if (this.f140596c.isSysKernel() && (a16 = a(this.f140604g)) != null) {
            a16.setZOrderMediaOverlay(true);
        }
        Drawable background = this.f140596c.getView().getBackground();
        this.f140619n0 = background;
        if (background != null) {
            this.f140619n0 = background.getConstantState().newDrawable().mutate();
        }
        this.f140596c.getView().setBackground(new ColorDrawable(-16777216));
        if (this.f140596c.isSysKernel()) {
            this.f140600e.postDelayed(new i0(), 200L);
        }
        x0.d("XWebNativeInterface", "attach end");
    }

    @Override // com.tencent.luggage.wxa.sq.a
    public void a(boolean z16, boolean z17) {
        if (this.f140596c == null || !z17 || this.f140597c0 == null) {
            return;
        }
        x0.d("XWebNativeInterface", "evaluteJavascript, isPageStart:" + z16);
        String str = this.f140597c0;
        if (z16) {
            str = com.tencent.luggage.wxa.sq.c.a(str);
        }
        this.f140596c.evaluateJavascript(str, new e());
    }

    @Override // com.tencent.luggage.wxa.sq.a
    public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        x0.d("XWebNativeInterface", "onShowCustomView");
        l();
        this.f140604g = view;
        this.D = customViewCallback;
        if (view != null || this.f140596c.isXWalkKernel()) {
            if (this.f140596c.isXWalkKernel()) {
                com.tencent.luggage.wxa.ar.n0.V();
            } else if (this.f140596c.isSysKernel()) {
                com.tencent.luggage.wxa.ar.n0.N();
            }
            b();
        }
        d();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // com.tencent.luggage.wxa.sq.a
    public void a() {
        x0.d("XWebNativeInterface", "onHideCustomView");
        p();
        c();
        y();
        this.f140604g = null;
        WebChromeClient.CustomViewCallback customViewCallback = this.D;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.D = null;
        }
    }

    public void c(boolean z16) {
        if (z16) {
            this.f140627r0 = true;
        } else {
            this.f140627r0 = false;
            this.G = false;
        }
    }

    @Override // com.tencent.luggage.wxa.sq.a
    public void a(boolean z16) {
        x0.d("XWebNativeInterface", "disableJsCallback:" + z16);
        this.S = z16;
    }

    @Override // com.tencent.luggage.wxa.sq.a
    public boolean a(Object obj) {
        x0.d("XWebNativeInterface", "setVideoJsCallback:" + obj);
        this.T = (VideoJsCallback) obj;
        return true;
    }

    public void a(int i3) {
        int i16;
        if (w() != null) {
            if (i3 >= 80 && i3 <= 100) {
                i16 = 8;
            } else if (i3 >= 260 && i3 <= 280) {
                i16 = 0;
            } else if (i3 >= 170 && i3 <= 190) {
                i16 = 9;
            } else if (i3 > 10 && i3 < 350) {
                return;
            } else {
                i16 = 1;
            }
            int i17 = this.P;
            if (i17 != i16) {
                if (i17 == 0 || i17 == 8) {
                    if (i16 == 0 || i16 == 8) {
                        x0.d("XWebNativeInterface", "onOrientationChanged, orientation:" + i3 + ", rotation:" + i16);
                        this.P = i16;
                        b(i16);
                        return;
                    }
                    return;
                }
                if (i17 == 1 || i17 == 9) {
                    if (i16 == 1 || i16 == 9) {
                        x0.d("XWebNativeInterface", "onOrientationChanged, orientation:" + i3 + ", rotation:" + i16);
                        this.P = i16;
                        b(i16);
                    }
                }
            }
        }
    }

    public void a(Runnable runnable) {
        if (this.S) {
            return;
        }
        n nVar = new n(runnable);
        Activity w3 = w();
        if (w3 != null) {
            w3.runOnUiThread(nVar);
        } else {
            this.f140596c.getView().post(nVar);
        }
    }

    public void a(double d16, boolean z16) {
        a((Runnable) new y(z16, d16));
    }

    public void a(double d16, double[] dArr) {
        a((Runnable) new z(d16, dArr));
    }

    public final String a(double d16, double d17) {
        String format = String.format(Locale.getDefault(), "%02d", Integer.valueOf((int) (d16 / 3600.0d)));
        int i3 = (int) (d16 % 3600.0d);
        String format2 = String.format(Locale.getDefault(), "%02d", Integer.valueOf(i3 / 60));
        String format3 = String.format(Locale.getDefault(), "%02d", Integer.valueOf(i3 % 60));
        return d17 > 3600.0d ? String.format(Locale.getDefault(), "%s:%s:%s", format, format2, format3) : String.format(Locale.getDefault(), "%s:%s", format2, format3);
    }

    public void b(boolean z16) {
        Activity w3 = w();
        if (w3 == null) {
            x0.d("XWebNativeInterface", "onActivityFullscreen, activity is null");
            return;
        }
        if (z16) {
            if ((w3.getWindow().getAttributes().flags & 2048) != 0) {
                this.f140625q0 = true;
                w3.getWindow().clearFlags(2048);
            } else {
                this.f140625q0 = false;
            }
            if ((w3.getWindow().getAttributes().flags & 1024) != 0) {
                this.f140623p0 = true;
            } else {
                this.f140623p0 = false;
                w3.getWindow().addFlags(1024);
            }
            if ((this.f140600e.getSystemUiVisibility() & 4096) != 0 && (this.f140600e.getSystemUiVisibility() & 4) != 0 && (this.f140600e.getSystemUiVisibility() & 2) != 0) {
                this.f140629s0 = true;
                return;
            }
            this.f140629s0 = false;
            this.f140631t0 = this.f140600e.getSystemUiVisibility();
            q0 q0Var = this.f140600e;
            q0Var.setSystemUiVisibility(q0Var.getSystemUiVisibility() | 4096 | 4 | 2);
            return;
        }
        if (this.f140625q0) {
            w3.getWindow().addFlags(2048);
        }
        if (!this.f140623p0) {
            w3.getWindow().clearFlags(1024);
        }
        if (this.f140629s0) {
            return;
        }
        this.f140600e.setSystemUiVisibility(this.f140631t0);
    }

    public final SurfaceView a(View view) {
        if (view instanceof SurfaceView) {
            return (SurfaceView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            SurfaceView a16 = a(viewGroup.getChildAt(i3));
            if (a16 != null) {
                return a16;
            }
        }
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d0 implements Application.ActivityLifecycleCallbacks {
        public d0() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == d.this.w() || (d.this.f140594b != null && d.this.f140594b.get() == activity)) {
                x0.d("XWebNativeInterface", "onActivityDestroyed");
                if (d.this.D != null) {
                    d.this.D.onCustomViewHidden();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity == d.this.w()) {
                x0.d("XWebNativeInterface", "onActivityPaused");
                d.this.f140611j0 = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity == d.this.w()) {
                x0.d("XWebNativeInterface", "onActivityResumed");
                d.this.f140611j0 = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (activity == d.this.w()) {
                x0.d("XWebNativeInterface", "onActivityStarted");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity == d.this.w()) {
                x0.d("XWebNativeInterface", "onActivityStopped");
                d.this.f140611j0 = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    public final void a(Activity activity) {
        if (activity != null) {
            Application application = activity.getApplication();
            this.f140592a = application;
            if (application != null) {
                application.registerActivityLifecycleCallbacks(this.f140613k0);
            }
        }
        x0.d("XWebNativeInterface", "registerActivityLifecycleCallback activity:" + activity + ", mApplication:" + this.f140592a);
    }

    public void a(int i3, int i16) {
        int i17;
        Activity w3 = w();
        if (w3 == null) {
            x0.d("XWebNativeInterface", "onVideoSizeChanged, activity is null");
            return;
        }
        if (i3 != 0 && i16 != 0) {
            if (this.O == -3) {
                this.O = w3.getRequestedOrientation();
            }
            if (i3 <= i16) {
                i17 = 1;
                b(1);
            } else {
                i17 = 0;
                b(0);
            }
            this.P = i17;
            x0.d("XWebNativeInterface", "onVideoSizeChanged, currentOrientation:" + i17);
            b(i17, i3, i16);
            return;
        }
        x0.d("XWebNativeInterface", "onVideoSizeChanged width == 0 || height == 0 return");
    }

    public final void b(int i3, int i16, int i17) {
        View view = this.f140604g;
        if (view != null) {
            view.setLayoutParams(a(i3, i16, i17));
        }
    }

    public final FrameLayout.LayoutParams a(int i3, int i16, int i17) {
        int max;
        int min;
        Display defaultDisplay = ((WindowManager) e().getSystemService("window")).getDefaultDisplay();
        Point point = new Point(0, 0);
        defaultDisplay.getSize(point);
        if (i3 == 0) {
            min = Math.max(point.x, point.y);
            max = Math.min(point.x, point.y);
        } else {
            max = Math.max(point.x, point.y);
            min = Math.min(point.x, point.y);
        }
        double d16 = (i16 * 1.0d) / i17;
        double d17 = min;
        double d18 = max;
        if (d16 >= (d17 * 1.0d) / d18) {
            max = (int) (d17 * (1.0d / d16));
        } else {
            min = (int) (d18 * d16);
        }
        return new FrameLayout.LayoutParams(min, max, 17);
    }

    public final boolean a(double d16) {
        return Double.isInfinite(d16) || d16 <= 0.0d;
    }
}
