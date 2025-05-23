package com.tencent.luggage.wxa.s3;

import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.n3.h0;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {

    /* renamed from: h, reason: collision with root package name */
    public static final f0 f140035h = f0.c("WxaIlinkManager_MMKV", 2);

    /* renamed from: i, reason: collision with root package name */
    public static ArrayList f140036i;

    /* renamed from: b, reason: collision with root package name */
    public t f140038b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f140039c;

    /* renamed from: e, reason: collision with root package name */
    public List f140041e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f140037a = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    public boolean f140040d = false;

    /* renamed from: f, reason: collision with root package name */
    public final ReentrantLock f140042f = new ReentrantLock();

    /* renamed from: g, reason: collision with root package name */
    public final MutableStateFlow f140043g = StateFlowKt.MutableStateFlow(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void onAllResourceNeedRecreate();

        void onUploadLogComplete(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        DEVICE_MODE,
        APP_MODE
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum c {
        DEFAULT,
        DEVICE_ID_MIS_MATCH,
        DISABLE,
        COMMON,
        MIGRATE,
        UNKNOWN
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum d {
        SUCCESS,
        INVALID_PARAMS,
        SIGNATURE_ERROR_0,
        SIGNATURE_ERROR_1,
        DEVICE_IS_NOT_REGISTERED,
        TIME_OUT,
        SIGNATURE_DECODING_BASE64_FAILED,
        UNKNOWN,
        KICK_OUT,
        DEVICE_CHANGED,
        CREATE_TDI_SESSION_FAILED,
        ACTIVATED,
        START_ILINK_PROCESS_FAILED
    }

    public static void a(d dVar, g gVar) {
        synchronized (h.class) {
            if (f140036i == null) {
                return;
            }
            Iterator it = new ArrayList(f140036i).iterator();
            if (it.hasNext()) {
                com.tencent.luggage.wxa.k0.d.a(it.next());
                throw null;
            }
        }
    }

    public static h i() {
        return h0.f135186q;
    }

    public abstract t a(String str);

    public abstract void a();

    public abstract void a(com.tencent.luggage.wxa.s3.d dVar);

    public abstract void a(b bVar, int i3);

    public abstract void a(CountDownLatch countDownLatch, g gVar, AtomicReference atomicReference);

    public d b(g gVar) {
        d c16 = c(gVar);
        this.f140043g.setValue(c16);
        a(c16, gVar);
        return c16;
    }

    public abstract boolean b();

    public d c(g gVar) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            this.f140042f.lock();
            d dVar = d.SUCCESS;
            AtomicReference atomicReference = new AtomicReference(dVar);
            try {
                w.d("WMPF.WxaIlinkManager", "loginDevice: deviceInfo=[%s]", gVar);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } finally {
                this.f140042f.unlock();
            }
            if (gVar != null && gVar.n()) {
                if (a(gVar)) {
                    return d.DEVICE_CHANGED;
                }
                if (l()) {
                    w.d("WMPF.WxaIlinkManager", "loginDevice: activated, just return success");
                    return dVar;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                a(countDownLatch, gVar, atomicReference);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (!countDownLatch.await(25L, TimeUnit.SECONDS)) {
                    boolean b16 = b();
                    w.h("WMPF.WxaIlinkManager", "loginDevice: wait timeout existed=%b", Boolean.valueOf(b16));
                    atomicReference.set(b16 ? d.TIME_OUT : d.START_ILINK_PROCESS_FAILED);
                    a();
                    return b16 ? d.TIME_OUT : d.START_ILINK_PROCESS_FAILED;
                }
                w.d("WMPF.WxaIlinkManager", "activate cost %dms", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                d dVar2 = (d) atomicReference.get();
                w.d("WMPF.WxaIlinkManager", "loginDevice: ret=[%s]", dVar2.name());
                if (dVar2 == dVar && !b(gVar.g())) {
                    dVar2 = d.CREATE_TDI_SESSION_FAILED;
                }
                if (dVar2 == dVar) {
                    this.f140040d = true;
                    a(gVar, h(), e(), f());
                }
                return (d) atomicReference.get();
            }
            return d.INVALID_PARAMS;
        }
        throw new IllegalStateException("Must invoke in work thread");
    }

    public void d() {
        String g16 = g();
        if (w0.c(g16)) {
            w.f("WMPF.WxaIlinkManager", "clearKvCommon ilinkFilePath is null or empty");
            return;
        }
        String str = g16 + File.separator + "kvcomm";
        w.d("WMPF.WxaIlinkManager", "clearKvCommon kvCommonPath:%s isOk:%b", str, Boolean.valueOf(x.b(str)));
    }

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract long h();

    public t j() {
        t tVar;
        synchronized (this.f140037a) {
            tVar = this.f140038b;
        }
        return tVar;
    }

    public g k() {
        return (g) f140035h.a("MMKV_KEY_DEVICE_INFO", g.class, (Parcelable) null);
    }

    public abstract boolean l();

    public abstract void m();

    public void b(a aVar) {
        synchronized (h.class) {
            ArrayList arrayList = this.f140039c;
            if (arrayList == null) {
                return;
            }
            arrayList.remove(aVar);
        }
    }

    public final boolean b(String str) {
        synchronized (this.f140037a) {
            t tVar = this.f140038b;
            boolean z16 = true;
            if (tVar != null && tVar.o().equals(str)) {
                return true;
            }
            t a16 = a(str);
            if (a16 != null) {
                this.f140038b = a16;
                a16.a(com.tencent.luggage.wxa.gn.a.f126799c, com.tencent.luggage.wxa.gn.a.f126800d, com.tencent.luggage.wxa.gn.a.a(), com.tencent.luggage.wxa.gn.a.b(), z.j().getConfiguration().locale.getLanguage());
            }
            if (a16 == null) {
                z16 = false;
            }
            return z16;
        }
    }

    public void a(a aVar) {
        synchronized (h.class) {
            if (this.f140039c == null) {
                this.f140039c = new ArrayList();
            }
            this.f140039c.add(aVar);
        }
    }

    public void a(Function1 function1) {
        synchronized (h.class) {
            if (this.f140039c == null) {
                return;
            }
            for (a aVar : new LinkedList(this.f140039c)) {
                w.a("WMPF.WxaIlinkManager", "notifyCallback callback@%d", Integer.valueOf(aVar.hashCode()));
                function1.invoke(aVar);
            }
        }
    }

    public int b(int i3) {
        return i3 != -1 ? i3 != 1 ? 0 : 1 : com.tencent.luggage.wxa.tn.e.f141559a ? 1 : 0;
    }

    public void a(g gVar, long j3, String str, String str2) {
        f0 f0Var = f140035h;
        if (f0Var.contains("MMKV_KEY_DEVICE_INFO")) {
            return;
        }
        gVar.a(j3);
        gVar.b(str);
        gVar.c(str2);
        f0Var.a("MMKV_KEY_DEVICE_INFO", (Parcelable) gVar);
        w.d("WMPF.WxaIlinkManager", "save info:" + gVar);
    }

    public boolean a(g gVar) {
        g k3 = k();
        if (k3 == null || !k3.n() || gVar.equals(k3)) {
            return false;
        }
        w.d("WMPF.WxaIlinkManager", "device info mismatch current=[%s] requested=[%s]", k3, gVar);
        Log.i("WMPF.WxaIlinkManager", String.format("device info mismatch current=[%s] requested=[%s]", k3, gVar));
        return true;
    }

    public d a(int i3) {
        if (i3 == 0) {
            return d.SUCCESS;
        }
        if (i3 == -1) {
            return d.INVALID_PARAMS;
        }
        if (i3 == -3) {
            return d.SIGNATURE_ERROR_0;
        }
        if (i3 == -5) {
            return d.SIGNATURE_ERROR_1;
        }
        if (i3 == -17) {
            return d.DEVICE_IS_NOT_REGISTERED;
        }
        if (i3 == -13) {
            return d.KICK_OUT;
        }
        if (i3 == 303) {
            return d.TIME_OUT;
        }
        if (i3 == 302) {
            return d.SIGNATURE_DECODING_BASE64_FAILED;
        }
        return d.UNKNOWN;
    }

    public synchronized void c(int i3) {
        List list = this.f140041e;
        if (list != null && !list.isEmpty()) {
            if (i3 == 0) {
                c cVar = c.DEFAULT;
            } else if (i3 == 1) {
                c cVar2 = c.DEFAULT;
            } else if (i3 == 2) {
                c cVar3 = c.DEFAULT;
            } else if (i3 == 3) {
                c cVar4 = c.DEFAULT;
            } else if (i3 == 4) {
                c cVar5 = c.DEFAULT;
            } else {
                c cVar6 = c.DEFAULT;
            }
            if (this.f140041e.size() <= 0) {
                return;
            }
            com.tencent.luggage.wxa.k0.d.a(this.f140041e.get(0));
            throw null;
        }
    }

    public void c() {
        w.d("WMPF.WxaIlinkManager", "cleanup stack:%s", Log.getStackTraceString(new Throwable()));
        synchronized (this.f140037a) {
            t tVar = this.f140038b;
            if (tVar != null) {
                tVar.f();
            }
            this.f140038b = null;
        }
    }
}
