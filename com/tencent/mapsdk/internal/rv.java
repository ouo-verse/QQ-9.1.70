package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttRequest;
import com.tencent.mapsdk.core.components.protocol.jce.user.user_login_t;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.tk;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rv extends BaseThread {

    /* renamed from: b, reason: collision with root package name */
    public static final String f150138b = "UTF-8";

    /* renamed from: h, reason: collision with root package name */
    private static final String f150139h = "rttserverex";

    /* renamed from: i, reason: collision with root package name */
    private static final String f150140i = "getRtt";

    /* renamed from: j, reason: collision with root package name */
    private static final String f150141j = "info";

    /* renamed from: k, reason: collision with root package name */
    private static final String f150142k = "req";

    /* renamed from: l, reason: collision with root package name */
    private static final int f150143l = 30000;

    /* renamed from: a, reason: collision with root package name */
    public List<rt> f150144a;

    /* renamed from: c, reason: collision with root package name */
    private ne f150145c;

    /* renamed from: d, reason: collision with root package name */
    private lu f150146d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f150147e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f150148f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f150149g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f150150a;

        /* renamed from: b, reason: collision with root package name */
        public int f150151b;

        a() {
        }

        /* synthetic */ a(rv rvVar, byte b16) {
            this();
        }
    }

    public rv(ne neVar, lu luVar) {
        this.f150145c = null;
        this.f150146d = null;
        setName("tms-traffic-refresh");
        this.f150145c = neVar;
        this.f150146d = luVar;
        this.f150144a = new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f3 A[Catch: all -> 0x0165, TryCatch #1 {all -> 0x0165, blocks: (B:6:0x0006, B:7:0x000a, B:11:0x0067, B:15:0x0134, B:17:0x0137, B:25:0x00f3, B:26:0x0073, B:28:0x0082, B:31:0x0086, B:33:0x0094, B:35:0x00c6, B:37:0x00cf, B:39:0x00de, B:43:0x0164, B:9:0x000b, B:10:0x0066), top: B:5:0x0006, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int d() {
        RttRequest rttRequest;
        ne neVar = this.f150145c;
        if (neVar == null) {
            return 0;
        }
        try {
            synchronized (neVar.f149396i.f150523m) {
                ae aeVar = this.f150145c.f149398k;
                int i3 = aeVar.A.f151253b.f151291q;
                Rect q16 = aeVar.q();
                a a16 = a(q16.left / 1000000.0f, q16.bottom / 1000000.0f);
                a a17 = a(q16.right / 1000000.0f, q16.top / 1000000.0f);
                tk tkVar = this.f150145c.f149396i;
                tkVar.b(new tk.AnonymousClass13(i3, Math.min(a16.f150150a, a17.f150150a), Math.min(a16.f150151b, a17.f150151b), Math.max(a17.f150150a, a16.f150150a), Math.max(a17.f150151b, a16.f150151b)));
            }
            ne neVar2 = this.f150145c;
            byte[] bArr = null;
            if (neVar2 != null) {
                if (neVar2 != null) {
                    tk tkVar2 = neVar2.f149396i;
                    ru[] ruVarArr = (ru[]) tkVar2.a(new tk.AnonymousClass35(), (tk.AnonymousClass35) null);
                    if (ruVarArr != null && ruVarArr.length != 0) {
                        rttRequest = new RttRequest();
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        for (ru ruVar : ruVarArr) {
                            arrayList.add(Integer.valueOf(ruVar.f150132d));
                            arrayList.add(Integer.valueOf(ruVar.f150131c));
                            arrayList.add(Integer.valueOf(ruVar.f150134f));
                            arrayList.add(Integer.valueOf(ruVar.f150133e));
                            arrayList.add(Integer.valueOf(ruVar.f150135g));
                        }
                        ArrayList<Long> arrayList2 = new ArrayList<>();
                        for (ru ruVar2 : ruVarArr) {
                            arrayList2.add(Long.valueOf(ruVar2.f150137i));
                        }
                        rttRequest.crcs = arrayList2;
                        ru ruVar3 = ruVarArr[0];
                        rttRequest.type = ruVar3.f150136h;
                        rttRequest.bounds = arrayList;
                        rttRequest.zip = (short) 1;
                        rttRequest.zoom = (short) ruVar3.f150129a;
                        if (rttRequest == null) {
                            lu luVar = this.f150146d;
                            user_login_t user_login_tVar = new user_login_t();
                            user_login_tVar.f147625pf = "android_sdk";
                            user_login_tVar.is_login = false;
                            user_login_tVar.channel = ho.m();
                            user_login_tVar.imei = ho.d();
                            f fVar = new f();
                            fVar.c(f150139h);
                            fVar.d(f150140i);
                            fVar.a("info", (String) user_login_tVar);
                            fVar.a("req", (String) rttRequest);
                            bArr = luVar.a(fVar.f());
                        }
                    }
                }
                rttRequest = null;
                if (rttRequest == null) {
                }
            }
            if (bArr != null && bArr.length > 0) {
                tk tkVar3 = this.f150145c.f149396i;
                ((Integer) tkVar3.a((CallbackRunnable<tk.AnonymousClass180>) new tk.AnonymousClass180(bArr, bArr.length), (tk.AnonymousClass180) (-1))).intValue();
                LogUtil.a(this.f150145c.N).c(lb.a.f149160g, "refreshTrafficData length > 0");
                return bArr.length;
            }
        } catch (Throwable th5) {
            LogUtil.c("refreshTrafficData error", th5);
            LogUtil.a(this.f150145c.N).e(lb.a.f149160g, "refreshTrafficData error", th5);
        }
        LogUtil.a(this.f150145c.N).b(lb.a.f149160g, "refreshTrafficData length 0!");
        return 0;
    }

    private void e() {
        ae aeVar = this.f150145c.f149398k;
        int i3 = aeVar.A.f151253b.f151291q;
        Rect q16 = aeVar.q();
        double d16 = q16.left / 1000000.0f;
        double d17 = q16.bottom / 1000000.0f;
        a a16 = a(d16, d17);
        a a17 = a(q16.right / 1000000.0f, q16.top / 1000000.0f);
        tk tkVar = this.f150145c.f149396i;
        tkVar.b(new tk.AnonymousClass13(i3, Math.min(a16.f150150a, a17.f150150a), Math.min(a16.f150151b, a17.f150151b), Math.max(a17.f150150a, a16.f150150a), Math.max(a17.f150151b, a16.f150151b)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x008b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] f() {
        RttRequest rttRequest;
        ne neVar = this.f150145c;
        if (neVar == null) {
            return null;
        }
        if (neVar != null) {
            tk tkVar = neVar.f149396i;
            ru[] ruVarArr = (ru[]) tkVar.a(new tk.AnonymousClass35(), (tk.AnonymousClass35) null);
            if (ruVarArr != null && ruVarArr.length != 0) {
                rttRequest = new RttRequest();
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (ru ruVar : ruVarArr) {
                    arrayList.add(Integer.valueOf(ruVar.f150132d));
                    arrayList.add(Integer.valueOf(ruVar.f150131c));
                    arrayList.add(Integer.valueOf(ruVar.f150134f));
                    arrayList.add(Integer.valueOf(ruVar.f150133e));
                    arrayList.add(Integer.valueOf(ruVar.f150135g));
                }
                ArrayList<Long> arrayList2 = new ArrayList<>();
                for (ru ruVar2 : ruVarArr) {
                    arrayList2.add(Long.valueOf(ruVar2.f150137i));
                }
                rttRequest.crcs = arrayList2;
                ru ruVar3 = ruVarArr[0];
                rttRequest.type = ruVar3.f150136h;
                rttRequest.bounds = arrayList;
                rttRequest.zip = (short) 1;
                rttRequest.zoom = (short) ruVar3.f150129a;
                if (rttRequest != null) {
                    return null;
                }
                lu luVar = this.f150146d;
                user_login_t user_login_tVar = new user_login_t();
                user_login_tVar.f147625pf = "android_sdk";
                user_login_tVar.is_login = false;
                user_login_tVar.channel = ho.m();
                user_login_tVar.imei = ho.d();
                f fVar = new f();
                fVar.c(f150139h);
                fVar.d(f150140i);
                fVar.a("info", (String) user_login_tVar);
                fVar.a("req", (String) rttRequest);
                return luVar.a(fVar.f());
            }
        }
        rttRequest = null;
        if (rttRequest != null) {
        }
    }

    private RttRequest g() {
        ne neVar = this.f150145c;
        RttRequest rttRequest = null;
        if (neVar == null) {
            return null;
        }
        tk tkVar = neVar.f149396i;
        ru[] ruVarArr = (ru[]) tkVar.a(new tk.AnonymousClass35(), (tk.AnonymousClass35) null);
        if (ruVarArr != null && ruVarArr.length != 0) {
            rttRequest = new RttRequest();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (ru ruVar : ruVarArr) {
                arrayList.add(Integer.valueOf(ruVar.f150132d));
                arrayList.add(Integer.valueOf(ruVar.f150131c));
                arrayList.add(Integer.valueOf(ruVar.f150134f));
                arrayList.add(Integer.valueOf(ruVar.f150133e));
                arrayList.add(Integer.valueOf(ruVar.f150135g));
            }
            ArrayList<Long> arrayList2 = new ArrayList<>();
            for (ru ruVar2 : ruVarArr) {
                arrayList2.add(Long.valueOf(ruVar2.f150137i));
            }
            rttRequest.crcs = arrayList2;
            ru ruVar3 = ruVarArr[0];
            rttRequest.type = ruVar3.f150136h;
            rttRequest.bounds = arrayList;
            rttRequest.zip = (short) 1;
            rttRequest.zoom = (short) ruVar3.f150129a;
        }
        return rttRequest;
    }

    public final void a() {
        this.f150148f = true;
        synchronized (this) {
            notifyAll();
        }
    }

    public final void b() {
        this.f150148f = false;
        synchronized (this) {
            notifyAll();
        }
    }

    public final void c() {
        this.f150149g = true;
        synchronized (this) {
            notifyAll();
        }
        interrupt();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        int i3 = 0;
        while (!this.f150149g) {
            if (!this.f150148f) {
                if (this.f150145c == null) {
                    return;
                }
                i3 = d();
                this.f150145c.f149412y = true;
            }
            try {
                synchronized (this) {
                    if (this.f150147e || i3 > 0) {
                        this.f150147e = true;
                        wait(30000L);
                    }
                }
            } catch (InterruptedException e16) {
                LogUtil.a(this.f150145c.N).e(lb.a.f149160g, "traffic thread wait error", e16);
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private void a(rt rtVar) {
        List<rt> list = this.f150144a;
        if (list == null || rtVar == null) {
            return;
        }
        list.add(rtVar);
    }

    private void b(rt rtVar) {
        List<rt> list = this.f150144a;
        if (list == null || rtVar == null) {
            return;
        }
        list.remove(rtVar);
    }

    private static byte[] a(RttRequest rttRequest) {
        user_login_t user_login_tVar = new user_login_t();
        user_login_tVar.f147625pf = "android_sdk";
        user_login_tVar.is_login = false;
        user_login_tVar.channel = ho.m();
        user_login_tVar.imei = ho.d();
        f fVar = new f();
        fVar.c(f150139h);
        fVar.d(f150140i);
        fVar.a("info", (String) user_login_tVar);
        fVar.a("req", (String) rttRequest);
        return fVar.f();
    }

    private a a(double d16, double d17) {
        double sin = Math.sin((d17 * 3.1415926d) / 180.0d);
        double log = ((180.0d - ((Math.log((sin + 1.0d) / (1.0d - sin)) * 180.0d) / 6.2831852d)) / 360.0d) * 2.68435456E8d;
        a aVar = new a(this, (byte) 0);
        aVar.f150150a = (int) ((((d16 + 180.0d) / 360.0d) * 2.68435456E8d) + 0.5d);
        aVar.f150151b = (int) (log + 0.5d);
        return aVar;
    }
}
