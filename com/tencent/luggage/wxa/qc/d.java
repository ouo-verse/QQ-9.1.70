package com.tencent.luggage.wxa.qc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.SparseIntArray;
import androidx.collection.ArraySet;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends com.tencent.luggage.wxa.qc.g {
    public static final AtomicInteger Q = new AtomicInteger(0);
    public final com.tencent.luggage.wxa.wn.b[] C;
    public final com.tencent.luggage.wxa.wn.b[] D;
    public final String E;
    public final com.tencent.luggage.wxa.ic.g F;
    public final AtomicBoolean G;
    public final AtomicBoolean H;
    public final AtomicBoolean I;
    public final AtomicReference J;
    public final AtomicReference K;
    public final Queue L;
    public final AtomicBoolean M;
    public volatile com.tencent.luggage.wxa.wn.b N;
    public final Runnable O;
    public final l P;

    /* renamed from: f, reason: collision with root package name */
    public final r f138616f;

    /* renamed from: g, reason: collision with root package name */
    public final m f138617g;

    /* renamed from: h, reason: collision with root package name */
    public final s f138618h;

    /* renamed from: i, reason: collision with root package name */
    public final t f138619i;

    /* renamed from: j, reason: collision with root package name */
    public final p f138620j;

    /* renamed from: k, reason: collision with root package name */
    public final q f138621k;

    /* renamed from: l, reason: collision with root package name */
    public final o f138622l;

    /* renamed from: m, reason: collision with root package name */
    public final n f138623m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.qc.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6641a implements MessageQueue.IdleHandler {
            public C6641a() {
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                Looper.myLooper().quit();
                return false;
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.myQueue().addIdleHandler(new C6641a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f138626a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f138627b;

        static {
            int[] iArr = new int[k.values().length];
            f138627b = iArr;
            try {
                iArr[k.TO_BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f138627b[k.TO_SUSPEND_FROM_BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f138627b[k.TO_FOREGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f138627b[k.ON_BACKGROUND_AUDIO_RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f138627b[k.AWAKE_IN_BACKGROUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f138627b[k.ON_START_BACKGROUND_BLUETOOTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f138627b[k.ON_SYSTEM_SCREEN_OFF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f138627b[k.ON_SYSTEM_SCREEN_ON.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f138627b[k.CHECK_PROCESS_IMPORTANCE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f138627b[k.ON_RESET_TO_TOP_OF_STACK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f138627b[k.ON_CONTAINER_ACTIVITY_STOPPED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f138627b[k.ON_DETACH_FROM_STACK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f138627b[k.ON_BACKGROUND_KEEP_FLAGS_CLEARED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f138627b[k.ON_SUSPEND_TIMEOUT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr2 = new int[com.tencent.luggage.wxa.qc.b.values().length];
            f138626a = iArr2;
            try {
                iArr2[com.tencent.luggage.wxa.qc.b.FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f138626a[com.tencent.luggage.wxa.qc.b.SUSPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f138626a[com.tencent.luggage.wxa.qc.b.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f138626a[com.tencent.luggage.wxa.qc.b.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (com.tencent.luggage.wxa.wn.b bVar : d.this.C) {
                d.this.a(bVar);
            }
            for (com.tencent.luggage.wxa.wn.b bVar2 : d.this.D) {
                d.this.a(bVar2);
            }
            d dVar = d.this;
            dVar.a((com.tencent.luggage.wxa.wn.b) dVar.f138616f);
            d dVar2 = d.this;
            dVar2.b((com.tencent.luggage.wxa.wn.b) dVar2.f138616f);
            d.super.a(true);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qc.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6642d implements Runnable {
        public RunnableC6642d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.I.set(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.super.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends com.tencent.luggage.wxa.qc.i {
        public f(long j3, com.tencent.luggage.wxa.qc.b bVar) {
            super(j3, bVar);
        }

        @Override // com.tencent.luggage.wxa.qc.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.qc.b b() {
            return d.this.b(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g extends com.tencent.luggage.wxa.qc.i {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.qc.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.wn.a b() {
            return d.super.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h extends com.tencent.luggage.wxa.qc.i {
        public h(long j3, Boolean bool) {
            super(j3, bool);
        }

        @Override // com.tencent.luggage.wxa.qc.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b() {
            boolean z16;
            if (d.this.d() == d.this.f138617g) {
                return Boolean.valueOf(d.this.f138617g.k());
            }
            Handler f16 = d.this.f();
            if (f16 != null && f16.hasMessages(k.ON_BACKGROUND_AUDIO_RESUMED.b())) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i extends com.tencent.luggage.wxa.qc.i {
        public i(long j3, Boolean bool) {
            super(j3, bool);
        }

        @Override // com.tencent.luggage.wxa.qc.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b() {
            boolean z16;
            com.tencent.luggage.wxa.wn.a d16 = d.this.d();
            if ((d16 instanceof s) && !(d16 instanceof t)) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public abstract class j extends com.tencent.luggage.wxa.qc.f {
        public j(com.tencent.luggage.wxa.qc.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = b.f138627b[k.a(message.what).ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4 && i3 != 5 && i3 != 6) {
                        return super.a(message);
                    }
                    d dVar = d.this;
                    dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138617g);
                    return true;
                }
                d dVar2 = d.this;
                dVar2.b((com.tencent.luggage.wxa.qc.f) dVar2.f138616f);
                return true;
            }
            d dVar3 = d.this;
            dVar3.b((com.tencent.luggage.wxa.qc.f) dVar3.f138618h);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum k {
        NONE(0),
        TO_BACKGROUND(1),
        TO_FOREGROUND(3),
        TO_SUSPEND_FROM_BACKGROUND(4),
        AWAKE_IN_BACKGROUND(5),
        CHECK_PROCESS_IMPORTANCE(6),
        ON_SYSTEM_SCREEN_OFF(10),
        ON_SUSPEND_TIMEOUT(11),
        ON_DETACH_FROM_STACK(12),
        ON_STOP_BACKGROUND_LOCATION_LISTENING(13),
        ON_STOP_BACKGROUND_LIVE_VOIP(14),
        ON_STOP_AUDIO_BACKGROUND_PLAY(15),
        ON_STOP_BACKGROUND_VOIP_1v1(16),
        ON_STOP_BACKGROUND_BLUETOOTH(17),
        ON_CONTAINER_FORCED_MOVE_TO_BACK(18),
        ON_START_BACKGROUND_BLUETOOTH(19),
        ON_RESET_TO_TOP_OF_STACK(20),
        ON_CONTAINER_ACTIVITY_STOPPED(21),
        ON_SYSTEM_SCREEN_ON(22),
        ON_BACKGROUND_AUDIO_RESUMED(23),
        ON_BACKGROUND_AUDIO_PREEMPTED(24),
        ON_BACKGROUND_AUDIO_STOPPED(25),
        ON_STOP_BACKGROUND_AI(26),
        ON_BACKGROUND_KEEP_FLAGS_CLEARED(100),
        AWAKE_MSG_QUEUE(1000);


        /* renamed from: a, reason: collision with root package name */
        public final int f138648a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray(values().length);
            for (k kVar : values()) {
                if (sparseIntArray.indexOfKey(kVar.f138648a) >= 0) {
                    com.tencent.luggage.wxa.er.a.a(String.format(Locale.ENGLISH, "duplicated defined intValue in %s", kVar.name()));
                } else {
                    sparseIntArray.put(kVar.f138648a, 1);
                }
            }
        }

        k(int i3) {
            this.f138648a = i3;
        }

        public int b() {
            return this.f138648a;
        }

        public static k a(int i3) {
            for (k kVar : values()) {
                if (kVar.b() == i3) {
                    return kVar;
                }
            }
            return NONE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class l {

        /* renamed from: a, reason: collision with root package name */
        public final String f138649a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f138650b;

        /* renamed from: c, reason: collision with root package name */
        public final Set f138651c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null && l.this.f138649a.equals(intent.getAction())) {
                    w.d(d.this.E, "onReceive(%s)", l.this.f138649a);
                    d.this.a(k.ON_SYSTEM_SCREEN_ON);
                }
            }
        }

        public l() {
            this.f138649a = !com.tencent.luggage.wxa.qc.c.f138606e ? IECScreenReceiver.ACTION_SCREEN_ON : "android.intent.action.USER_PRESENT";
            this.f138650b = new a();
            this.f138651c = new ArraySet();
        }

        public void b(com.tencent.luggage.wxa.wn.b bVar) {
            if (this.f138651c.remove(bVar) && this.f138651c.isEmpty()) {
                a();
            }
        }

        public void a(com.tencent.luggage.wxa.wn.b bVar) {
            if (this.f138651c.add(bVar) && this.f138651c.size() == 1) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(this.f138649a);
                z.c().registerReceiver(this.f138650b, intentFilter);
            }
        }

        public /* synthetic */ l(d dVar, c cVar) {
            this();
        }

        public void a() {
            try {
                z.c().unregisterReceiver(this.f138650b);
            } catch (Exception unused) {
            } finally {
                this.f138651c.clear();
            }
        }
    }

    public d(com.tencent.luggage.wxa.ic.g gVar) {
        super(String.format(Locale.ENGLISH, "Luggage.AppRunningStateMachine[%s][%d]", gVar.getAppId(), Integer.valueOf(Q.incrementAndGet())), Looper.getMainLooper());
        this.G = new AtomicBoolean(false);
        this.H = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.I = atomicBoolean;
        this.J = new AtomicReference(null);
        this.K = new AtomicReference(null);
        this.L = new LinkedBlockingQueue();
        this.M = new AtomicBoolean(false);
        this.N = null;
        this.O = new RunnableC6642d();
        this.P = new l(this, null);
        this.E = h();
        this.F = gVar;
        super.a(false);
        o oVar = new o(this);
        this.f138622l = oVar;
        n nVar = new n(this);
        this.f138623m = nVar;
        p pVar = new p(this);
        this.f138620j = pVar;
        q qVar = new q(this);
        this.f138621k = qVar;
        m mVar = new m(this, gVar);
        this.f138617g = mVar;
        this.f138616f = new r(this);
        s sVar = new s(this);
        this.f138618h = sVar;
        t tVar = new t(this);
        this.f138619i = tVar;
        this.C = new com.tencent.luggage.wxa.wn.b[]{oVar, nVar, pVar, qVar, mVar};
        this.D = new com.tencent.luggage.wxa.wn.b[]{sVar, tVar};
        c cVar = new c();
        if (Looper.myLooper() == f().getLooper()) {
            cVar.run();
        } else {
            atomicBoolean.set(true);
            f().post(cVar);
        }
    }

    public abstract void a(com.tencent.luggage.wxa.qc.b bVar);

    public abstract void u();

    public boolean x() {
        Handler f16 = f();
        if (f16 == null) {
            return false;
        }
        return ((Boolean) new i(1000L, Boolean.FALSE).a(new b0(f16.getLooper()))).booleanValue();
    }

    public void y() {
        if (!this.G.get()) {
            w.a(this.E, new Throwable(), "Illegal internal state, stop() called before start()", new Object[0]);
            return;
        }
        this.H.set(true);
        if (r()) {
            w.b(this.E, "stop() called, but still isInConstruction");
            k();
        } else {
            l();
        }
        a(com.tencent.luggage.wxa.qc.b.DESTROYED);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class n extends com.tencent.luggage.wxa.qc.f {
        public n(com.tencent.luggage.wxa.qc.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            d.this.P.a(this);
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void b() {
            super.b();
            d.this.P.b(this);
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return "|BackgroundKeepNoChange";
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = b.f138627b[k.a(message.what).ordinal()];
            if (i3 == 3) {
                d dVar = d.this;
                dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138616f);
                return true;
            }
            if (i3 != 8) {
                return super.a(message);
            }
            d dVar2 = d.this;
            dVar2.b((com.tencent.luggage.wxa.qc.f) dVar2.f138617g);
            return true;
        }
    }

    @Override // com.tencent.luggage.wxa.wn.c
    public void e(Message message) {
        a(" - unhandledMessage: msg.what=%d, msg.obj=%s", Integer.valueOf(message.what), message.obj);
        this.I.set(false);
    }

    @Override // com.tencent.luggage.wxa.wn.c
    public void j() {
        super.j();
        this.H.set(true);
        this.P.a();
        if (f().getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
            f().post(new a());
        }
    }

    @Override // com.tencent.luggage.wxa.wn.c
    public void m() {
        if (this.H.get()) {
            return;
        }
        this.G.set(true);
        if (Looper.myLooper() == f().getLooper()) {
            super.m();
        } else {
            f().post(new e());
        }
    }

    public boolean o() {
        int i3 = b.f138626a[p().ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 != 4) {
            return false;
        }
        return ((Boolean) new h(1000L, Boolean.FALSE).a(new b0(f().getLooper()))).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.luggage.wxa.qc.b p() {
        String str;
        boolean z16;
        Handler f16 = f();
        if (f16 == null) {
            w.a(this.E, "getRunningStateExport, NULL handler, return DESTROYED");
            return com.tencent.luggage.wxa.qc.b.DESTROYED;
        }
        if (f16.hasMessages(-1)) {
            w.a(this.E, "getRunningStateExport, has SM_QUIT_CMD, return DESTROYED");
            return com.tencent.luggage.wxa.qc.b.DESTROYED;
        }
        if (this.H.get()) {
            w.a(this.E, "getRunningStateExport, mStopped=true, return DESTROYED");
            return com.tencent.luggage.wxa.qc.b.DESTROYED;
        }
        if (r()) {
            return com.tencent.luggage.wxa.qc.b.FOREGROUND;
        }
        if (this.I.get() && Looper.myLooper() != f16.getLooper()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                str = "query from main-looper";
            } else if (this.M.get()) {
                str = "skip flag marked true by outer";
            } else {
                str = null;
                z16 = false;
                if (!z16) {
                    com.tencent.luggage.wxa.wn.b bVar = (com.tencent.luggage.wxa.wn.b) this.K.get();
                    boolean z17 = this.H.get();
                    w.d(this.E, "getRunningStateExport, pending change in sm-looper(%d) but %s, cached-state=%s, stopped=%b", Long.valueOf(f16.getLooper().getThread().getId()), str, bVar, Boolean.valueOf(z17));
                    if (bVar != null) {
                        return b((com.tencent.luggage.wxa.wn.a) bVar);
                    }
                    return z17 ? com.tencent.luggage.wxa.qc.b.DESTROYED : com.tencent.luggage.wxa.qc.b.FOREGROUND;
                }
                f fVar = new f(500L, null);
                w.a(this.E, "getRunningStateExport, await");
                this.L.add(fVar);
                com.tencent.luggage.wxa.qc.b bVar2 = (com.tencent.luggage.wxa.qc.b) fVar.a(new b0(f16.getLooper()));
                this.L.remove(fVar);
                if (bVar2 == null) {
                    w.a(this.E, "getRunningStateExport, await timeout");
                    return b(false);
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        return b(true);
    }

    public final boolean q() {
        Message c16 = c();
        if (c16 != null) {
            k kVar = k.AWAKE_IN_BACKGROUND;
            if (kVar.b() == c16.what) {
                return true;
            }
            if (c16.obj instanceof Message) {
                int b16 = kVar.b();
                Message message = (Message) c16.obj;
                if (b16 == message.what) {
                    message.recycle();
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean r() {
        Handler f16 = f();
        if (f16 == null) {
            return false;
        }
        return f16.hasMessages(-2);
    }

    public boolean s() {
        return this.H.get();
    }

    public void t() {
        LinkedList linkedList = new LinkedList(this.L);
        this.L.clear();
        while (!linkedList.isEmpty()) {
            ((com.tencent.luggage.wxa.qc.i) linkedList.poll()).a();
        }
    }

    public final void v() {
        com.tencent.luggage.wxa.ic.l h06 = this.F.h0();
        if (h06 != null) {
            h06.Y();
        }
    }

    public final void w() {
        com.tencent.luggage.wxa.ic.l h06 = this.F.h0();
        if (h06 != null) {
            h06.a0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class r extends com.tencent.luggage.wxa.qc.f {
        public r(com.tencent.luggage.wxa.qc.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            if (b.f138627b[k.a(message.what).ordinal()] != 1) {
                return super.a(message);
            }
            d dVar = d.this;
            dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138617g);
            return true;
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void b() {
            super.b();
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return "|Foreground";
        }

        @Override // com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            d.this.f().removeMessages(k.ON_SUSPEND_TIMEOUT.b());
            d.this.f().removeMessages(k.TO_SUSPEND_FROM_BACKGROUND.b());
            d.this.w();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class t extends s {
        public t(com.tencent.luggage.wxa.qc.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.qc.d.s, com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            d.this.f().removeMessages(k.ON_SUSPEND_TIMEOUT.b());
            d.this.P.a(this);
        }

        @Override // com.tencent.luggage.wxa.qc.d.s, com.tencent.luggage.wxa.wn.b
        public void b() {
            super.b();
            d.this.P.b(this);
        }

        @Override // com.tencent.luggage.wxa.qc.d.s, com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return "|StateSuspendKeepAlive";
        }

        @Override // com.tencent.luggage.wxa.qc.d.s, com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = b.f138627b[k.a(message.what).ordinal()];
            if (i3 == 8) {
                d dVar = d.this;
                dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138618h);
                return true;
            }
            if (i3 != 9) {
                if (i3 != 14) {
                    return super.a(message);
                }
                d.this.p("ignore ON_SUSPEND_TIMEOUT");
            }
            return true;
        }
    }

    public void c(boolean z16) {
        this.M.set(z16);
    }

    public final com.tencent.luggage.wxa.qc.b b(boolean z16) {
        com.tencent.luggage.wxa.wn.a d16;
        if (this.H.get()) {
            w.a(this.E, "getRunningStateExportImpl, mStopped=true, return DESTROYED");
            return com.tencent.luggage.wxa.qc.b.DESTROYED;
        }
        com.tencent.luggage.wxa.wn.b bVar = (com.tencent.luggage.wxa.wn.b) this.J.get();
        if (bVar != null) {
            return b((com.tencent.luggage.wxa.wn.a) bVar);
        }
        com.tencent.luggage.wxa.wn.b bVar2 = (com.tencent.luggage.wxa.wn.b) this.K.get();
        if (bVar2 != null) {
            return b((com.tencent.luggage.wxa.wn.a) bVar2);
        }
        if (!z16) {
            return b((com.tencent.luggage.wxa.wn.a) this.N);
        }
        if (Thread.currentThread().getId() != f().getLooper().getThread().getId()) {
            g gVar = new g();
            w.a(this.E, "getRunningStateExportImpl, await");
            d16 = (com.tencent.luggage.wxa.wn.a) gVar.a(new b0(f().getLooper()));
        } else {
            d16 = super.d();
        }
        return b(d16);
    }

    @Override // com.tencent.luggage.wxa.wn.c
    public boolean c(Message message) {
        return message.what != k.AWAKE_MSG_QUEUE.b();
    }

    @Override // com.tencent.luggage.wxa.qc.g
    public void a(com.tencent.luggage.wxa.qc.f fVar) {
        this.J.set(null);
        this.K.set(fVar);
        Message c16 = c();
        if (c16 != null && c16.what == -2) {
            this.N = fVar;
            return;
        }
        com.tencent.luggage.wxa.wn.b bVar = this.N;
        this.N = fVar;
        if (bVar != null) {
            com.tencent.luggage.wxa.qc.b b16 = b((com.tencent.luggage.wxa.wn.a) bVar);
            com.tencent.luggage.wxa.qc.b b17 = b((com.tencent.luggage.wxa.wn.a) fVar);
            if (b16 == b17) {
                return;
            }
            a(b17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class q extends j {
        public q(com.tencent.luggage.wxa.qc.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            Message obtain = Message.obtain(d.this.f());
            obtain.what = k.TO_SUSPEND_FROM_BACKGROUND.b();
            long j3 = com.tencent.luggage.wxa.qc.c.f138609h;
            d.this.n("enter with lifespanMillis:" + j3);
            if (j3 > 0) {
                d.this.a(obtain, j3);
            } else {
                d.this.d(obtain);
            }
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void b() {
            super.b();
            d.this.f().removeMessages(k.TO_SUSPEND_FROM_BACKGROUND.b());
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return "|StateBackgroundTemporaryPostHomePressed";
        }

        @Override // com.tencent.luggage.wxa.qc.d.j, com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = b.f138627b[k.a(message.what).ordinal()];
            if (i3 != 2) {
                switch (i3) {
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    default:
                        return super.a(message);
                }
            }
            d dVar = d.this;
            dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138619i);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s extends com.tencent.luggage.wxa.qc.f {
        public s(com.tencent.luggage.wxa.qc.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            w.d(d.this.E, "invokeEnterMethods: %s appId:%s, lifespanAfterSuspend:%d, stopped:%b", getName(), d.this.F.getAppId(), Integer.valueOf(d.this.F.j0().f125965k), Boolean.valueOf(d.this.s()));
            if (d.this.s()) {
                return;
            }
            d.this.f().sendEmptyMessageDelayed(k.ON_SUSPEND_TIMEOUT.b(), d.this.F.j0().f125965k * 1000);
            d.this.v();
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void b() {
            super.b();
            d.this.f().removeMessages(k.ON_SUSPEND_TIMEOUT.b());
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return "|Suspend";
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = b.f138627b[k.a(message.what).ordinal()];
            if (i3 == 3) {
                d dVar = d.this;
                dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138616f);
                return true;
            }
            if (i3 == 4 || i3 == 5) {
                d dVar2 = d.this;
                dVar2.b((com.tencent.luggage.wxa.qc.f) dVar2.f138617g);
                d.this.w();
                return true;
            }
            if (i3 == 14) {
                w.d(d.this.E, "processMessage: %s, ON_SUSPEND_TIMEOUT, appId:%s", getName(), d.this.F.getAppId());
                d.this.u();
                return true;
            }
            return super.a(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class p extends j {
        public p(com.tencent.luggage.wxa.qc.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            d.this.P.a(this);
            Message obtain = Message.obtain(d.this.f());
            obtain.what = k.TO_SUSPEND_FROM_BACKGROUND.b();
            long j3 = com.tencent.luggage.wxa.qc.c.f138607f;
            d.this.n("enter with lifespanMillis:" + j3);
            if (j3 > 0) {
                d.this.a(obtain, j3);
            } else {
                d.this.d(obtain);
            }
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void b() {
            super.b();
            d.this.f().removeMessages(k.TO_SUSPEND_FROM_BACKGROUND.b());
            d.this.P.b(this);
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return "|StateBackgroundTemporaryDuringScreenOff";
        }

        @Override // com.tencent.luggage.wxa.qc.d.j, com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = b.f138627b[k.a(message.what).ordinal()];
            if (i3 == 2) {
                d dVar = d.this;
                dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138619i);
                return true;
            }
            if (i3 != 8) {
                if (i3 != 9) {
                    return super.a(message);
                }
                return true;
            }
            d dVar2 = d.this;
            dVar2.b((com.tencent.luggage.wxa.qc.f) dVar2.f138617g);
            return true;
        }
    }

    public void a(k kVar) {
        a(kVar, (Object) null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class o extends j {

        /* renamed from: c, reason: collision with root package name */
        public boolean f138657c;

        public o(com.tencent.luggage.wxa.qc.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.qc.d.j, com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = b.f138627b[k.a(message.what).ordinal()];
            if (i3 == 2) {
                if (d.this.F.Y().d()) {
                    w.d(d.this.E, "%s process TO_SUSPEND_FROM_BACKGROUND, transfer to onSuspendTimeout directly due to HeadlessPage, appId:%s", getName(), d.this.F.getAppId());
                    d.this.u();
                    return true;
                }
                if (com.tencent.luggage.wxa.qc.c.f138606e && this.f138657c) {
                    d dVar = d.this;
                    dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138619i);
                } else {
                    d dVar2 = d.this;
                    dVar2.b((com.tencent.luggage.wxa.qc.f) dVar2.f138618h);
                }
                return true;
            }
            if (i3 != 7) {
                if (i3 != 8) {
                    return super.a(message);
                }
                d();
                return true;
            }
            c();
            d.this.n(String.format(Locale.ENGLISH, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF, no suicide?:%b", Boolean.valueOf(com.tencent.luggage.wxa.qc.c.f138606e)));
            w.d(d.this.E, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
            if (com.tencent.luggage.wxa.qc.c.f138606e) {
                d dVar3 = d.this;
                dVar3.b((com.tencent.luggage.wxa.qc.f) dVar3.f138620j);
            } else {
                d dVar4 = d.this;
                dVar4.b((com.tencent.luggage.wxa.qc.f) dVar4.f138623m);
            }
            return true;
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void b() {
            super.b();
            d.this.f().removeMessages(k.TO_SUSPEND_FROM_BACKGROUND.b());
            d();
        }

        public final void c() {
            this.f138657c = true;
            d.this.P.a(this);
        }

        public final void d() {
            this.f138657c = false;
            d.this.P.b(this);
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return "|BackgroundTemporary";
        }

        @Override // com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            if (d.this.s()) {
                w.b(d.this.E, "invokeEnterMethods: %s, sm stopped", getName());
                return;
            }
            if (d.this.F.j0() == null) {
                w.b(d.this.E, "invokeEnterMethods: %s, NULL sysConfig, transitionTo StateSuspend", getName());
                d dVar = d.this;
                dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138618h);
            } else {
                if (d.this.F.j0().f125964j == Integer.MAX_VALUE) {
                    return;
                }
                boolean q16 = d.this.q();
                w.d(d.this.E, "invokeEnterMethods %s, awakenInBackground:%b", getName(), Boolean.valueOf(q16));
                Message obtain = Message.obtain(d.this.f());
                obtain.what = k.TO_SUSPEND_FROM_BACKGROUND.b();
                Bundle bundle = new Bundle(1);
                bundle.putBoolean("awakenInBackground", q16);
                obtain.obj = bundle;
                d.this.f().sendMessageDelayed(obtain, d.this.F.j0().f125964j * 1000);
            }
        }
    }

    public void a(k kVar, Object obj) {
        if (f() == null) {
            w.h(this.E, "executeOrPostMessage with cmd[%s], null handler", kVar.name());
            return;
        }
        f().removeCallbacks(this.O);
        if (kVar == k.ON_BACKGROUND_AUDIO_STOPPED || kVar == k.ON_BACKGROUND_AUDIO_PREEMPTED) {
            f().removeMessages(k.ON_BACKGROUND_AUDIO_RESUMED.b());
        }
        this.I.set(true);
        if (Looper.myLooper() != f().getLooper() || c() == null || c().what == -2 || n()) {
            super.d(a(kVar.f138648a, obj));
            f().post(this.O);
        } else {
            f().dispatchMessage(a(kVar.f138648a, obj));
            this.O.run();
        }
    }

    public final com.tencent.luggage.wxa.qc.b b(com.tencent.luggage.wxa.wn.a aVar) {
        if (!ArrayUtils.contains(this.C, aVar) && !(aVar instanceof j)) {
            if (ArrayUtils.contains(this.D, aVar)) {
                return com.tencent.luggage.wxa.qc.b.SUSPEND;
            }
            if (aVar == this.f138616f) {
                return com.tencent.luggage.wxa.qc.b.FOREGROUND;
            }
            if (com.tencent.luggage.wxa.tn.e.f141559a) {
                com.tencent.luggage.wxa.er.a.a(String.format(Locale.ENGLISH, "Unrecognised state %s, call @smoothieli to fix this", aVar));
            }
            return com.tencent.luggage.wxa.qc.b.FOREGROUND;
        }
        return com.tencent.luggage.wxa.qc.b.BACKGROUND;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class m extends com.tencent.luggage.wxa.qc.e {

        /* renamed from: d, reason: collision with root package name */
        public boolean f138654d;

        public m(com.tencent.luggage.wxa.qc.g gVar, com.tencent.luggage.wxa.ic.g gVar2) {
            super(gVar, gVar2);
        }

        @Override // com.tencent.luggage.wxa.qc.e, com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = b.f138627b[k.a(message.what).ordinal()];
            if (i3 == 3) {
                d dVar = d.this;
                dVar.b((com.tencent.luggage.wxa.qc.f) dVar.f138616f);
                return true;
            }
            if (i3 == 7) {
                this.f138654d = true;
                d.this.P.a(this);
                if (l() > 0) {
                    w.d("MicroMsg.MultipleConditionBackgroundState", "Background process ON_SYSTEM_SCREEN_OFF, stay still, keepFlags %d", Integer.valueOf(l()));
                    return true;
                }
                if (com.tencent.luggage.wxa.qc.c.f138606e) {
                    d dVar2 = d.this;
                    dVar2.b((com.tencent.luggage.wxa.qc.f) dVar2.f138620j);
                } else {
                    w.d("MicroMsg.MultipleConditionBackgroundState", "Background process ON_SYSTEM_SCREEN_OFF");
                    d dVar3 = d.this;
                    dVar3.b((com.tencent.luggage.wxa.qc.f) dVar3.f138623m);
                }
                return true;
            }
            if (i3 != 8) {
                switch (i3) {
                    case 11:
                        m();
                        return true;
                    case 12:
                        n();
                        return true;
                    case 13:
                        if (!this.f138654d || !com.tencent.luggage.wxa.qc.c.f138606e) {
                            if (com.tencent.luggage.wxa.ic.e.d(d.this.F.getAppId()) == e.d.HOME_PRESSED && com.tencent.luggage.wxa.qc.e.a(d.this.F) && com.tencent.luggage.wxa.qc.c.f138608g) {
                                d dVar4 = d.this;
                                dVar4.b((com.tencent.luggage.wxa.qc.f) dVar4.f138621k);
                            } else {
                                d dVar5 = d.this;
                                dVar5.b((com.tencent.luggage.wxa.qc.f) dVar5.f138622l);
                            }
                        } else {
                            d dVar6 = d.this;
                            dVar6.b((com.tencent.luggage.wxa.qc.f) dVar6.f138620j);
                        }
                        return true;
                    default:
                        return super.a(message);
                }
            }
            this.f138654d = false;
            d.this.P.b(this);
            return true;
        }

        @Override // com.tencent.luggage.wxa.qc.e, com.tencent.luggage.wxa.wn.b
        public void b() {
            this.f138654d = false;
            d.this.P.b(this);
            super.b();
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return "|Background";
        }

        @Override // com.tencent.luggage.wxa.qc.e
        public void o() {
            Message message;
            int i3;
            if (d.this.c() != null) {
                message = Message.obtain(d.this.f());
                message.copyFrom(d.this.c());
            } else {
                message = null;
            }
            Object[] objArr = new Object[3];
            objArr[0] = getName();
            if (message == null) {
                i3 = -1;
            } else {
                i3 = message.what;
            }
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Boolean.valueOf(this.f138654d);
            w.d("MicroMsg.MultipleConditionBackgroundState", "onKeepFlagsCleared %s, currentMsg.what:%d, mIsSystemScreenOff:%b", objArr);
            if (this.f138654d) {
                d.this.a(k.ON_SYSTEM_SCREEN_OFF);
            } else {
                d.this.a(k.ON_BACKGROUND_KEEP_FLAGS_CLEARED, message);
            }
        }

        @Override // com.tencent.luggage.wxa.qc.e, com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
        public void a() {
            this.f138654d = false;
            super.a();
        }
    }

    public final void b(com.tencent.luggage.wxa.qc.f fVar) {
        this.I.set(false);
        this.J.set(fVar);
        this.K.set(null);
        super.a((com.tencent.luggage.wxa.wn.a) fVar);
    }
}
