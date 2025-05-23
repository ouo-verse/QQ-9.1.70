package com.tencent.rfw.barrage.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.rfw.barrage.core.impl.ClickBarrageRunnableImpl;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import tz3.i;
import uz3.b;
import vz3.h;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements View.OnTouchListener, b.a {

    /* renamed from: d0, reason: collision with root package name */
    private static int f365037d0 = 11;
    private final c C;
    private final f D;
    private final e E;
    private final vz3.c F;
    private final vz3.a G;
    private long H;
    protected i L;
    protected final com.tencent.rfw.barrage.core.a Q;
    private final View R;
    protected volatile sz3.a U;
    private sz3.c X;
    private sz3.e Y;
    private sz3.b Z;

    /* renamed from: a0, reason: collision with root package name */
    private sz3.d f365038a0;

    /* renamed from: h, reason: collision with root package name */
    private Handler f365044h;

    /* renamed from: i, reason: collision with root package name */
    private uz3.b f365045i;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.rfw.barrage.core.b f365046m;

    /* renamed from: d, reason: collision with root package name */
    private volatile AtomicBoolean f365041d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private volatile AtomicBoolean f365042e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private volatile AtomicBoolean f365043f = new AtomicBoolean(false);
    protected volatile AtomicBoolean I = new AtomicBoolean(false);
    private long J = 0;
    private long K = 0;
    protected final Queue<h> M = new LinkedBlockingDeque();
    private final List<com.tencent.rfw.barrage.data.a> N = new ArrayList();
    private Set<Integer> P = new CopyOnWriteArraySet();
    private long S = 16;
    private final AtomicBoolean T = new AtomicBoolean(false);
    private boolean W = false;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f365039b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f365040c0 = false;
    private final b V = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<d> f365047d;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            d dVar = this.f365047d.get();
            if (dVar != null) {
                switch (message.what) {
                    case 1:
                        dVar.O(message);
                        dVar.M();
                        break;
                    case 2:
                        dVar.M();
                        break;
                    case 3:
                        dVar.I();
                        break;
                    case 4:
                        dVar.P();
                        break;
                    case 5:
                        dVar.N(message);
                        break;
                    case 6:
                        dVar.J();
                        break;
                    case 7:
                        dVar.F();
                        break;
                    case 8:
                        dVar.K();
                        break;
                    case 9:
                        dVar.E();
                        break;
                    case 10:
                        dVar.w();
                        break;
                    case 11:
                        dVar.L(message);
                        dVar.M();
                        break;
                    case 12:
                        dVar.C();
                        break;
                }
                return false;
            }
            return false;
        }

        b(d dVar) {
            this.f365047d = new WeakReference<>(dVar);
        }
    }

    public d(View view, i iVar) {
        this.L = iVar;
        this.R = view;
        w();
        vz3.c cVar = new vz3.c();
        this.F = cVar;
        vz3.a aVar = new vz3.a();
        this.G = aVar;
        f fVar = new f();
        this.D = fVar;
        this.E = new e(iVar);
        RFWBarrageComparator rFWBarrageComparator = new RFWBarrageComparator();
        this.f365046m = new com.tencent.rfw.barrage.core.b(cVar, rFWBarrageComparator);
        this.Q = iVar.d(iVar, fVar, rFWBarrageComparator, cVar, aVar);
        this.C = new c(iVar);
        R(view.getContext());
    }

    private int B(Context context) {
        Display[] displays = ((DisplayManager) context.getSystemService("display")).getDisplays();
        if (displays != null && displays.length > 0) {
            return (int) displays[0].getRefreshRate();
        }
        return 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        wz3.b.a("RFWBarrageManager", "[handleClear] handle clear message, hash code: " + hashCode());
        com.tencent.rfw.barrage.core.a aVar = this.Q;
        if (aVar != null) {
            aVar.c();
        }
        i iVar = this.L;
        if (iVar != null) {
            iVar.b();
        }
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar != null) {
            bVar.c();
        }
        Set<Integer> set = this.P;
        if (set != null) {
            set.clear();
        }
        u();
        sz3.b bVar2 = this.Z;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    private void D() {
        wz3.b.f("RFWBarrageManager", "[handleClearDrawingCache] handle clear drawing cache, hash code: " + hashCode());
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.tencent.rfw.barrage.data.a k3;
        if (this.M == null) {
            wz3.b.a("RFWBarrageManager", "[handleClick] touch points should not be null.");
            return;
        }
        if (this.Q == null) {
            wz3.b.a("RFWBarrageManager", "[handleClick] r2l window should not be null.");
            return;
        }
        while (!this.M.isEmpty()) {
            h poll = this.M.poll();
            if (poll != null && (k3 = this.Q.k(poll)) != null) {
                if (wz3.g.b()) {
                    wz3.b.h("RFWBarrageManager", "[handleClick] point: " + poll + " | currentTime:" + z());
                }
                wz3.c.a().b(new ClickBarrageRunnableImpl(this, poll, k3));
            }
        }
        if (wz3.g.b()) {
            wz3.b.h("RFWBarrageManager", "[handleClick] message click.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        wz3.b.f("RFWBarrageManager", "[handleConfigChanged] reload config start.");
        com.tencent.rfw.barrage.core.a aVar = this.Q;
        if (aVar != null) {
            aVar.m();
        }
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar != null) {
            bVar.g();
        }
        wz3.b.f("RFWBarrageManager", "[handleConfigChanged] reload config end.");
    }

    private void H0() {
        this.F.b(A());
        this.G.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        long a16;
        wz3.b.a("RFWBarrageManager", "[handlePause] handle pause message, hash code: " + hashCode());
        m0();
        this.f365042e.set(false);
        if (this.L.n()) {
            a16 = this.F.a();
        } else {
            a16 = this.G.a();
        }
        this.H = a16;
    }

    private void I0() {
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar == null) {
            wz3.b.c("RFWBarrageManager", "[uploadBarrage] barrage data source should not be null.");
            return;
        }
        List<com.tencent.rfw.barrage.data.a> d16 = bVar.d();
        if (d16 == null) {
            wz3.b.c("RFWBarrageManager", "[uploadBarrage] drawing barrage list should not be null.");
            return;
        }
        Iterator<com.tencent.rfw.barrage.data.a> it = d16.iterator();
        while (it.hasNext()) {
            com.tencent.rfw.barrage.data.a next = it.next();
            it.remove();
            if (next.Y(this.F.a()) && !next.N()) {
                this.N.add(next);
            } else {
                vz3.a aVar = this.G;
                if (aVar != null) {
                    next.u0(aVar.a());
                }
                next.v0(new rz3.a(this));
                com.tencent.rfw.barrage.core.a aVar2 = this.Q;
                if (aVar2 != null) {
                    aVar2.a(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        wz3.b.a("RFWBarrageManager", "[handleQuit] handle quit message start, hash code: " + hashCode());
        this.f365041d.set(true);
        i iVar = this.L;
        if (iVar != null) {
            iVar.b();
        }
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar != null) {
            bVar.c();
        }
        Set<Integer> set = this.P;
        if (set != null) {
            set.clear();
        }
        f fVar = this.D;
        if (fVar != null) {
            fVar.a();
        }
        wz3.b.a("RFWBarrageManager", "[handleQuit] handle quit message end, hash code: " + hashCode());
    }

    private void J0(Looper looper) {
        Thread thread;
        try {
            int i3 = f365037d0 + 1;
            if (this.f365040c0) {
                thread = Looper.getMainLooper().getThread();
            } else {
                thread = looper.getThread();
            }
            thread.join(i3);
        } catch (Throwable th5) {
            wz3.b.d("RFWBarrageManager", "[waitSubThreadDrawFinish] error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(Message message) {
        O(message);
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        vz3.a aVar;
        wz3.b.b("RFWBarrageManager", "[handleResume] handle barrage resume, hash code: ", Integer.valueOf(hashCode()));
        if (!this.f365042e.get() && (aVar = this.G) != null) {
            aVar.f();
        }
        this.f365041d.set(false);
        this.f365042e.set(true);
        q0();
        sz3.d dVar = this.f365038a0;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Message message) {
        wz3.b.b("RFWBarrageManager", "[handleStart] handle barrage start, hash code: ", Integer.valueOf(hashCode()));
        this.f365041d.set(false);
        this.I.set(true);
        Object obj = message.obj;
        if (obj != null) {
            this.H = ((Long) obj).longValue();
        } else {
            this.H = 0L;
        }
        Set<Integer> set = this.P;
        if (set != null) {
            set.clear();
        }
        vz3.a aVar = this.G;
        if (aVar != null) {
            aVar.f();
            this.G.c();
        }
    }

    private void R(Context context) {
        int i3;
        try {
            i3 = B(context);
        } catch (Throwable th5) {
            RFWLog.e("RFWBarrageManager", RFWLog.USR, "[initSubThreadJoinInterval] error: ", th5);
            i3 = 60;
        }
        this.S = 1000 / i3;
    }

    private boolean T() {
        Looper looper;
        boolean z16;
        Handler handler = this.f365044h;
        Thread thread = null;
        if (handler == null) {
            looper = null;
        } else {
            looper = handler.getLooper();
        }
        if (looper != null) {
            thread = looper.getThread();
        }
        if (thread != null && thread.isAlive()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f365039b0 != z16) {
            wz3.b.a("RFWBarrageManager", "[isDrawThreadValid] current message handler alive: " + this.f365039b0 + " | hashCode: " + hashCode());
            this.f365039b0 = z16;
        }
        return z16;
    }

    private boolean U() {
        if (Z()) {
            if (T() && this.f365044h != null) {
                return true;
            }
            return false;
        }
        if (this.f365044h != null) {
            return true;
        }
        return false;
    }

    private boolean Y(Looper looper) {
        if (looper != null && looper.getThread() != Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    private boolean Z() {
        if (Build.VERSION.SDK_INT > 23 && !this.T.get()) {
            return true;
        }
        return false;
    }

    private void a0() {
        this.Q.j();
    }

    private void c0(List<com.tencent.rfw.barrage.data.a> list) {
        if (this.U == null) {
            return;
        }
        this.U.c(list);
    }

    private void d0() {
        sz3.c cVar = this.X;
        if (cVar == null) {
            wz3.b.a("RFWBarrageManager", "[notifyRestartSuccess] restart listener should not be null");
        } else {
            cVar.a();
        }
    }

    private void e0() {
        if (this.U == null) {
            return;
        }
        this.U.a();
    }

    private void h0() {
        wz3.b.a("RFWBarrageManager", "[quit] send quit message, hash code: " + hashCode());
        this.f365041d.set(true);
        Message obtain = Message.obtain();
        obtain.what = 6;
        w0(obtain);
    }

    private void i0(List<com.tencent.rfw.barrage.data.a> list) {
        if (list == null) {
            return;
        }
        for (com.tencent.rfw.barrage.data.a aVar : list) {
            uz3.f e16 = this.L.e(aVar);
            if (aVar.N()) {
                return;
            }
            if (e16 != null) {
                e16.g(aVar);
            }
            c cVar = this.C;
            if (cVar != null) {
                cVar.c(aVar);
            }
        }
    }

    private void j0() {
        List<com.tencent.rfw.barrage.data.a> list;
        com.tencent.rfw.barrage.core.a aVar = this.Q;
        if (aVar != null) {
            list = aVar.h();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            for (com.tencent.rfw.barrage.data.a aVar2 : list) {
                if (!aVar2.N()) {
                    aVar2.Z();
                    Bitmap m3 = aVar2.m();
                    if (m3 != null) {
                        aVar2.n0(null);
                        aVar2.f();
                        this.D.c(m3);
                        this.N.add(aVar2);
                    }
                }
            }
        }
        com.tencent.rfw.barrage.core.a aVar3 = this.Q;
        if (aVar3 != null) {
            aVar3.b();
        }
        c0(this.N);
        i0(this.N);
        this.N.clear();
    }

    private void l0() {
        List<uz3.f> f16;
        i iVar = this.L;
        if (iVar == null || (f16 = iVar.f()) == null) {
            return;
        }
        Iterator<uz3.f> it = f16.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void m0() {
        Handler handler = this.f365044h;
        if (handler != null) {
            handler.removeMessages(4);
        }
    }

    private void q() {
        int e16;
        int size = this.P.size();
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar == null) {
            e16 = 0;
        } else {
            e16 = bVar.e();
        }
        if (size <= 0 && e16 <= 0) {
            e0();
        }
    }

    private void q0() {
        wz3.b.a("RFWBarrageManager", "[resumeUpdateMessage] resume update message, hash code: " + hashCode());
        if (V()) {
            v0(4);
        }
    }

    private void r() {
        int k3;
        Object valueOf;
        if (!Z()) {
            this.f365044h = new Handler(Looper.getMainLooper(), this.V);
            return;
        }
        if (!T() || this.f365044h == null) {
            try {
                Handler handler = this.f365044h;
                if (handler != null && handler.getLooper() != Looper.getMainLooper()) {
                    RFWThreadManager.getInstance().releaseHandler(this.f365044h);
                }
                i iVar = this.L;
                if (iVar == null) {
                    k3 = -10;
                } else {
                    k3 = iVar.k();
                }
                this.f365044h = RFWThreadManager.createNewThreadHandler("BARRAGE_MESSAGE_THREAD", k3, this.V);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[checkedThreadAlive] draw handler: ");
                Handler handler2 = this.f365044h;
                if (handler2 == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(handler2.hashCode());
                }
                sb5.append(valueOf);
                sb5.append(" | manager hashCode: ");
                sb5.append(hashCode());
                wz3.b.a("RFWBarrageManager", sb5.toString());
            } catch (Throwable th5) {
                wz3.b.e("RFWBarrageManager", th5);
            }
        }
    }

    private void r0(Canvas canvas) {
        if (canvas == null || this.f365045i == null) {
            return;
        }
        try {
            if (wz3.g.b()) {
                wz3.b.h("RFWBarrageManager", "[safeUnlockCanvas] unlock start.");
            }
            if (this.f365043f.get()) {
                this.f365045i.unlockCanvasAndPost(canvas);
            } else {
                this.f365045i.unlock();
            }
            if (wz3.g.b()) {
                wz3.b.h("RFWBarrageManager", "[safeUnlockCanvas] unlock end.");
            }
        } catch (Throwable th5) {
            wz3.b.d("RFWBarrageManager", "unlockCanvas exception " + canvas.hashCode(), th5);
        }
    }

    private void t() {
        if (this.f365044h == null) {
            return;
        }
        wz3.b.a("RFWBarrageManager", "[clearAllStartMsg] clear all start msg, manager: " + hashCode());
        this.f365044h.removeMessages(1);
        this.f365044h.removeMessages(11);
        this.f365044h.removeMessages(2);
        this.f365044h.removeMessages(4);
    }

    private void v() {
        Handler handler = this.f365044h;
        if (handler == null) {
            return;
        }
        handler.removeMessages(4);
    }

    private void v0(int i3) {
        if (this.f365044h != null && U()) {
            this.f365044h.removeMessages(i3);
            this.f365044h.sendEmptyMessage(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        int hashCode;
        v();
        View view = this.R;
        if (view == null) {
            wz3.b.b("RFWBarrageManager", "[handlerCreateBarrageView] current base barrage view should not is null, hash code: ", Integer.valueOf(hashCode()));
            return;
        }
        uz3.b a16 = uz3.e.a(view);
        this.f365045i = a16;
        if (a16 == null) {
            wz3.b.b("RFWBarrageManager", "[createBarrageView] create barrage view should not is null, hash code: ", Integer.valueOf(hashCode()));
            return;
        }
        if (a16 == null) {
            hashCode = -1;
        } else {
            hashCode = a16.hashCode();
        }
        wz3.b.b("RFWBarrageManager", "[createBarrageView] create barrage view, barrage: ", Integer.valueOf(hashCode), " | manager: ", Integer.valueOf(hashCode()));
        this.f365045i.b(this);
        this.f365045i.setOnTouchListener(this);
    }

    private void x() {
        wz3.b.a("RFWBarrageManager", "[destroy] barrage logger destroy...");
        Handler handler = this.f365044h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void x0(int i3, long j3) {
        if (this.f365044h != null && U()) {
            this.f365044h.removeMessages(i3);
            this.f365044h.sendEmptyMessageDelayed(i3, j3);
        }
    }

    private void y(boolean z16) {
        Canvas canvas;
        Object valueOf;
        uz3.b bVar = this.f365045i;
        if (bVar == null) {
            return;
        }
        try {
            canvas = bVar.lockCanvas();
        } catch (Throwable th5) {
            th = th5;
            canvas = null;
        }
        try {
        } catch (Throwable th6) {
            th = th6;
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[draw] exception ");
                if (canvas == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(canvas.hashCode());
                }
                sb5.append(valueOf);
                wz3.b.d("RFWBarrageManager", sb5.toString(), th);
            } finally {
                r0(canvas);
            }
        }
        if (!W() && !z16) {
            return;
        }
        if (canvas != null) {
            wz3.f.a(canvas);
            this.Q.d(canvas, this.F.a());
        }
    }

    public long A() {
        i iVar = this.L;
        if (iVar == null) {
            return 0L;
        }
        long j3 = iVar.j();
        if (this.J == j3) {
            return this.J + (z() - this.K);
        }
        this.K = z();
        return j3;
    }

    public void A0(boolean z16) {
        this.T.set(z16);
    }

    public void B0(sz3.b bVar) {
        this.Z = bVar;
    }

    public void C0(sz3.d dVar) {
        this.f365038a0 = dVar;
    }

    public void D0(sz3.e eVar) {
        this.Y = eVar;
    }

    public void F0(sz3.c cVar) {
        this.X = cVar;
    }

    public void G(com.tencent.rfw.barrage.data.a aVar) {
        int hashCode;
        int e16;
        if (aVar == null) {
            hashCode = -1;
        } else {
            hashCode = aVar.hashCode();
        }
        if (hashCode != -1) {
            this.P.remove(Integer.valueOf(hashCode));
        }
        int size = this.P.size();
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar == null) {
            e16 = 0;
        } else {
            e16 = bVar.e();
        }
        wz3.b.i("RFWBarrageManager", "[handleLeftDrawEnd] barrage: ", Integer.valueOf(hashCode), " | screenShowCount: ", Integer.valueOf(size), " | queueCount: ", Integer.valueOf(e16));
        q();
    }

    protected void G0(boolean z16) {
        synchronized (d.class) {
            H0();
            if (this.I.get()) {
                this.Q.c();
                this.I.set(false);
            }
            try {
                I0();
                a0();
                y(z16);
                j0();
            } catch (Throwable th5) {
                wz3.b.d("RFWBarrageManager", th5.toString(), th5);
            }
        }
    }

    public void H(com.tencent.rfw.barrage.data.a aVar) {
        int hashCode;
        int e16;
        if (aVar == null) {
            hashCode = -1;
        } else {
            hashCode = aVar.hashCode();
        }
        if (hashCode != -1) {
            this.P.add(Integer.valueOf(hashCode));
        }
        int size = this.P.size();
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar == null) {
            e16 = 0;
        } else {
            e16 = bVar.e();
        }
        wz3.b.i("RFWBarrageManager", "[handleLeftDrawStart] barrage: ", Integer.valueOf(hashCode), " | screenShowCount: ", Integer.valueOf(size), " | queueCount: ", Integer.valueOf(e16));
    }

    protected synchronized void K() {
        wz3.b.a("RFWBarrageManager", "[handleRelease] handle release message, hash code: " + hashCode());
        D();
        v();
        x();
        C();
        e eVar = this.E;
        if (eVar != null) {
            eVar.d();
        }
        Set<Integer> set = this.P;
        if (set != null) {
            set.clear();
        }
        uz3.b bVar = this.f365045i;
        if (bVar != null) {
            bVar.destroy();
        }
        Handler handler = this.f365044h;
        if (handler != null && handler.getLooper() != Looper.getMainLooper()) {
            RFWThreadManager.getInstance().releaseHandler(this.f365044h);
        }
    }

    protected void N(Message message) {
        if (message == null) {
            return;
        }
        if (!X()) {
            wz3.b.a("RFWBarrageManager", "[handleSeek] current state is illegality, not seek.hash code: " + hashCode() + " | msg value: " + message.obj);
            return;
        }
        wz3.b.a("RFWBarrageManager", "[handleSeek] handle seek message, hash code: " + hashCode() + " | msg value: " + message.obj);
        Object obj = message.obj;
        if (obj != null) {
            this.H = ((Long) obj).longValue();
            vz3.a aVar = this.G;
            if (aVar != null) {
                aVar.c();
                this.G.d(this.H);
                this.G.f();
            }
            G0(true);
        }
        sz3.e eVar = this.Y;
        if (eVar != null) {
            eVar.a();
        }
    }

    protected void P() {
        m0();
        if (W()) {
            long z16 = z();
            G0(false);
            x0(4, (f365037d0 + z16) - z());
        }
    }

    public void Q(com.tencent.rfw.barrage.data.a aVar) {
        int hashCode;
        int e16;
        if (aVar == null) {
            hashCode = -1;
        } else {
            hashCode = aVar.hashCode();
        }
        if (hashCode != -1) {
            this.P.remove(Integer.valueOf(hashCode));
        }
        int size = this.P.size();
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar == null) {
            e16 = 0;
        } else {
            e16 = bVar.e();
        }
        wz3.b.i("RFWBarrageManager", "[handlerLeftDrawDelete] barrage: ", Integer.valueOf(hashCode), " | screenShowCount: ", Integer.valueOf(size), " | queueCount: ", Integer.valueOf(e16));
        q();
    }

    protected boolean S(vz3.e eVar) {
        boolean z16;
        boolean X = X();
        if (eVar.f443790a != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        wz3.b.b("RFWBarrageManager", "[isClickValid] isStartedAndBarrageViewCreated: " + X, " |isNotRegionInvalid: " + z16 + " | hashCode: " + hashCode());
        if (X && z16) {
            return true;
        }
        return false;
    }

    public boolean V() {
        if (!this.f365041d.get() && this.f365042e.get()) {
            return true;
        }
        return false;
    }

    public boolean W() {
        if (this.f365043f.get() && !this.f365041d.get() && this.f365042e.get()) {
            return true;
        }
        return false;
    }

    public boolean X() {
        if (this.f365043f.get() && !this.f365041d.get() && U()) {
            return true;
        }
        return false;
    }

    @Override // uz3.b.a
    public void a() {
        wz3.b.f("RFWBarrageManager", "[onBarrageViewChanged] barrage view change, hashcode: " + hashCode());
        v();
        this.f365043f.set(true);
        q0();
    }

    @Override // uz3.b.a
    public void b() {
        Handler handler;
        Looper looper;
        wz3.b.f("RFWBarrageManager", "[onBarrageViewDestroyed] barrage view start destroyed, hashcode: " + hashCode());
        this.f365043f.set(false);
        try {
            handler = this.f365044h;
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (handler == null || (looper = handler.getLooper()) == null) {
            return;
        }
        if (Y(looper)) {
            J0(looper);
        }
        wz3.b.a("RFWBarrageManager", "[onBarrageViewDestroyed] barrage view end destroyed, hashcode: " + hashCode());
    }

    public void b0() {
        wz3.b.a("RFWBarrageManager", "[notifyConfigChanged] notify config change, hash code: " + hashCode());
        r();
        Message obtain = Message.obtain();
        obtain.what = 7;
        w0(obtain);
    }

    @Override // uz3.b.a
    public void c() {
        wz3.b.f("RFWBarrageManager", "[onBarrageViewCreated] barrage view create, hashcode: " + hashCode());
    }

    public void f0() {
        wz3.b.f("RFWBarrageManager", "[pause] send pause message, hashCode: " + hashCode());
        Message obtain = Message.obtain();
        obtain.what = 3;
        w0(obtain);
    }

    public void g0(h hVar, com.tencent.rfw.barrage.data.a aVar) {
        if (this.U == null) {
            return;
        }
        if (aVar == null) {
            this.U.b(false);
            return;
        }
        hVar.c(aVar.i(), aVar.j());
        vz3.e a06 = aVar.a0(hVar);
        if (S(a06)) {
            this.U.b(true);
            if (a06.f443791b) {
                this.Q.g(aVar);
            }
            this.U.d(aVar, hVar, a06);
            return;
        }
        this.U.b(false);
    }

    public void k0() {
        wz3.b.a("RFWBarrageManager", "[release] send release message, quited: " + this.f365041d.get() + " | hash code: " + hashCode());
        t();
        if (!this.f365041d.get()) {
            h0();
        }
        Message obtain = Message.obtain();
        obtain.what = 8;
        w0(obtain);
        l0();
        this.U = null;
    }

    public void m(Point point, int i3) {
        int i16;
        int i17;
        uz3.b bVar = this.f365045i;
        if (bVar == null) {
            if (point == null) {
                i16 = 0;
            } else {
                i16 = point.x;
            }
            if (point == null) {
                i17 = 0;
            } else {
                i17 = point.y;
            }
            wz3.b.b("RFWBarrageManager", "[addClickPoint] add click point x: ", Integer.valueOf(i16), " | y: ", Integer.valueOf(i17));
            return;
        }
        point.y = (int) (point.y - bVar.a());
        this.M.add(new h(this.G.a(), point, i3));
        Message obtain = Message.obtain();
        obtain.what = 9;
        w0(obtain);
    }

    public void n(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null || this.f365046m == null) {
            return;
        }
        wz3.b.h("RFWBarrageManager", "[addSingleLast] barrage: " + aVar.toString());
        this.f365046m.a(aVar);
    }

    public void n0(long j3, sz3.c cVar) {
        wz3.b.a("RFWBarrageManager", "[restart] start time: " + j3);
        this.X = cVar;
        r();
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = Long.valueOf(j3);
        w0(obtain);
    }

    public void o(com.tencent.rfw.barrage.data.a aVar) {
        e eVar = this.E;
        if (eVar == null) {
            return;
        }
        eVar.b(aVar);
    }

    public void o0() {
        wz3.b.a("RFWBarrageManager", "[resume] send resume message, hashCode: " + hashCode());
        r();
        Message obtain = Message.obtain();
        obtain.what = 2;
        w0(obtain);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        long a16;
        if (i.l().n() && (motionEvent.getAction() & 255) == 0) {
            Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            vz3.a aVar = this.G;
            if (aVar == null) {
                a16 = 0;
            } else {
                a16 = aVar.a();
            }
            h hVar = new h(a16, point, 0);
            com.tencent.rfw.barrage.core.a aVar2 = this.Q;
            if (aVar2 != null && aVar2.k(hVar) != null) {
                m(point, 0);
                return true;
            }
        }
        return false;
    }

    public void p(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null || this.f365046m == null) {
            return;
        }
        wz3.b.a("RFWBarrageManager", "[addSingleNow] barrage: " + aVar.toString());
        this.f365046m.b(aVar);
    }

    public void p0(sz3.d dVar) {
        this.f365038a0 = dVar;
        o0();
    }

    public void s(sz3.b bVar) {
        wz3.b.a("RFWBarrageManager", "[clear] current execute clear action, hashCode: " + hashCode());
        Message obtain = Message.obtain();
        obtain.what = 12;
        w0(obtain);
        this.Z = bVar;
    }

    public void s0(long j3) {
        wz3.b.b("RFWBarrageManager", "[seek] send seek pos time: " + j3, " message, hashCode: " + hashCode());
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = Long.valueOf(j3);
        w0(obtain);
    }

    public void u() {
        com.tencent.rfw.barrage.core.b bVar = this.f365046m;
        if (bVar != null) {
            bVar.c();
        }
        Set<Integer> set = this.P;
        if (set != null) {
            set.clear();
        }
    }

    public void u0(long j3, sz3.e eVar) {
        this.Y = eVar;
        s0(j3);
    }

    protected void w0(Message message) {
        if (this.f365044h != null && U()) {
            this.f365044h.sendMessage(message);
        }
    }

    public void y0(sz3.a aVar) {
        this.U = aVar;
    }

    public long z() {
        return SystemClock.uptimeMillis();
    }

    public void z0(boolean z16) {
        this.f365040c0 = z16;
    }

    public void E0(sz3.f fVar) {
    }
}
