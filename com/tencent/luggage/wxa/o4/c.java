package com.tencent.luggage.wxa.o4;

import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.n;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.ei.v;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.jg.j;
import com.tencent.luggage.wxa.tk.k;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.game.liblockstep.LockStepNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public LockStepNative f136146a;

    /* renamed from: b, reason: collision with root package name */
    public String f136147b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f136148c = true;

    /* renamed from: d, reason: collision with root package name */
    public final f f136149d = new f(new e());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements LockStepNative.ILockStepListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f136150a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o4.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6532a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f136152a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f136153b;

            public RunnableC6532a(String str, long j3) {
                this.f136152a = str;
                this.f136153b = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                w.a("Luggage.LockStepNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,locksteplogicId:%d", this.f136152a, Long.valueOf(this.f136153b));
                c.this.f136146a.updateNativeInterface(this.f136153b);
            }
        }

        public a(WeakReference weakReference) {
            this.f136150a = weakReference;
        }

        @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener
        public void onCallBack(long j3, String str) {
            ((q) this.f136150a.get()).a(new RunnableC6532a(str, j3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements LockStepNative.ILockStepReportListener {
        public b() {
        }

        @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
        public int getNetworkType() {
            return c.a();
        }

        @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
        public void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
            w.a("Luggage.LockStepNativeInstallHelper", "mmudp onIdKeyStat");
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < iArr.length; i3++) {
                arrayList.add(new IDKey(iArr[i3], iArr2[i3], iArr3[i3]));
            }
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(arrayList, false);
        }

        @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
        public void onKvStat(int i3, String str) {
            w.a("Luggage.LockStepNativeInstallHelper", "mmudp onKvStat logId:%d", Integer.valueOf(i3));
            ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(i3, str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o4.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6533c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f136156a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LockStepNative.ILockStepListener f136157b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LockStepNative.ILockStepReportListener f136158c;

        public RunnableC6533c(j jVar, LockStepNative.ILockStepListener iLockStepListener, LockStepNative.ILockStepReportListener iLockStepReportListener) {
            this.f136156a = jVar;
            this.f136157b = iLockStepListener;
            this.f136158c = iLockStepReportListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding setCallback ");
            if (c.this.f136146a != null) {
                w.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding lockStepNative != null");
                return;
            }
            v vVar = (v) this.f136156a.a(v.class);
            if (vVar == null) {
                w.b("Luggage.LockStepNativeInstallHelper", "createLockStepBinding v8Addon is null");
                return;
            }
            if (c.this.f136148c) {
                c.this.f136146a = new LockStepNative(vVar.f(), vVar.B(), vVar.j());
            } else {
                c.this.f136146a = new LockStepNative(vVar.f(), vVar.B(), 0L);
            }
            w.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding setCallback ret:%d", Integer.valueOf(c.this.f136146a.setCallback(this.f136157b, this.f136158c)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f136160a;

        public d(com.tencent.luggage.wxa.xd.d dVar) {
            this.f136160a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("Luggage.LockStepNativeInstallHelper", "initConfigLockStep initConfig ");
            if (c.this.f136146a == null) {
                w.d("Luggage.LockStepNativeInstallHelper", "initConfigLockStep lockStepNative is null");
                return;
            }
            com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) this.f136160a.a(com.tencent.luggage.wxa.fd.q.class);
            if (qVar != null) {
                w.d("Luggage.LockStepNativeInstallHelper", "lockstep appId:%s,pkgDebugType:%d,pkgVersion:%d,mbzType:%s", qVar.f125956b, Integer.valueOf(qVar.f125966l.f151861a + 1), Integer.valueOf(qVar.f125966l.pkgVersion), c.this.f136147b);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("appid", qVar.f125956b);
                hashMap.put("appstate", String.valueOf(qVar.f125966l.f151861a + 1));
                hashMap.put("appversion", String.valueOf(qVar.f125966l.pkgVersion));
                hashMap.put("apptype", c.this.f136147b);
                c.this.f136146a.initConfig(hashMap);
                return;
            }
            w.b("Luggage.LockStepNativeInstallHelper", "initConfigLockStep sysConfig is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                if (c.this.f136146a != null) {
                    w.d("Luggage.LockStepNativeInstallHelper", "DestroyTask destoryLockStep");
                    c.this.f136146a.destoryLockStep();
                    c.this.f136146a = null;
                } else {
                    w.d("Luggage.LockStepNativeInstallHelper", "DestroyTask lockStepNative is null");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends k implements n.a {
        public f(Runnable runnable) {
            super(runnable);
        }

        @Override // com.tencent.luggage.wxa.ei.n.a
        public void onDestroy() {
            run();
        }
    }

    public void a(j jVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        w.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
        if (jVar == null) {
            w.b("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
            return;
        }
        this.f136147b = String.valueOf(i3);
        com.tencent.luggage.wxa.da.a.a();
        q qVar = (q) jVar.a(q.class);
        if (qVar == null) {
            w.b("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
        } else {
            com.tencent.luggage.wxa.k0.d.a(g.a(com.tencent.luggage.wxa.o4.d.class));
            qVar.a(new RunnableC6533c(jVar, new a(new WeakReference(qVar)), new b()));
        }
    }

    public void a(j jVar, com.tencent.luggage.wxa.xd.d dVar) {
        w.d("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
        if (jVar == null) {
            w.b("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
            return;
        }
        q qVar = (q) jVar.a(q.class);
        if (qVar == null) {
            w.b("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
        } else {
            qVar.a(new d(dVar));
        }
    }

    public static int a() {
        try {
            j.g a16 = com.tencent.luggage.wxa.jg.j.a(z.c());
            w.d("Luggage.LockStepNativeInstallHelper", "networkType = %s", a16.f131107a);
            w.d("Luggage.LockStepNativeInstallHelper", "getStatisticsNetType ret:%d", Integer.valueOf(h0.d(z.c())));
            if (a16 == j.g.None) {
                return -1;
            }
            if (a16 == j.g.Mobile_2g) {
                return 2;
            }
            if (a16 == j.g.Mobile_3g) {
                return 3;
            }
            if (a16 == j.g.Mobile_4g) {
                return 4;
            }
            if (a16 == j.g.Mobile_5g) {
                return 5;
            }
            return a16 == j.g.Wifi ? 1 : 0;
        } catch (Exception e16) {
            w.a("Luggage.LockStepNativeInstallHelper", e16, "getStatisticsNetType_", new Object[0]);
            return -1;
        }
    }

    public void a(com.tencent.luggage.wxa.ei.j jVar) {
        w.d("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
        if (jVar == null) {
            w.b("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
        } else {
            ((n) jVar.a(n.class)).b(this.f136149d);
        }
    }
}
