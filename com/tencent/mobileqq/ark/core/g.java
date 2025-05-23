package com.tencent.mobileqq.ark.core;

import android.os.Bundle;
import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.ark.api.module.a;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends QIPCModule {

    /* renamed from: e, reason: collision with root package name */
    static volatile g f199349e;

    /* renamed from: f, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqark-impl/src/main/resources/Inject_ArkIPCService_APIList.yml", version = 1)
    public static final ArrayList<Class<? extends k91.d>> f199350f;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, Class<? extends k91.d>> f199351d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements k91.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f199352a;

        a(int i3) {
            this.f199352a = i3;
        }

        @Override // k91.c
        public void a(EIPCResult eIPCResult) {
            g.this.callbackResult(this.f199352a, eIPCResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements k91.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k91.b f199354a;

        b(k91.b bVar) {
            this.f199354a = bVar;
        }

        @Override // k91.c
        public void a(EIPCResult eIPCResult) {
            boolean z16;
            k91.b bVar = this.f199354a;
            if (eIPCResult.code == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.a(z16, eIPCResult.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k91.b f199356d;

        c(k91.b bVar) {
            this.f199356d = bVar;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            boolean z16;
            if (eIPCResult.code == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i("ArkApp.ArkIPCService", 1, "call.async, method=" + this.f199356d.getMethod() + " result=" + eIPCResult);
            }
            k91.b bVar = this.f199356d;
            Bundle bundle = eIPCResult.data;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bVar.a(z16, bundle);
        }
    }

    static {
        ArrayList<Class<? extends k91.d>> arrayList = new ArrayList<>();
        f199350f = arrayList;
        arrayList.add(a.r.class);
        arrayList.add(a.q.class);
        arrayList.add(a.m.class);
        arrayList.add(a.l.class);
        arrayList.add(a.p.class);
        arrayList.add(a.o.class);
        arrayList.add(a.u.class);
        arrayList.add(a.s.class);
        arrayList.add(a.k.class);
        arrayList.add(a.n.class);
        arrayList.add(a.t.class);
        arrayList.add(e.class);
        arrayList.add(com.tencent.mobileqq.ark.vipreport.c.class);
    }

    g(String str) {
        super(str);
        this.f199351d = new HashMap<>();
        init();
    }

    public static g e() {
        if (f199349e == null) {
            synchronized (g.class) {
                if (f199349e == null) {
                    f199349e = new g(IArkIPCService.NAME);
                }
            }
        }
        return f199349e;
    }

    void b(k91.b bVar, k91.d dVar) {
        boolean z16;
        if (dVar instanceof k91.e) {
            EIPCResult b16 = ((k91.e) dVar).b(bVar.getArguments());
            if (b16.code == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.a(z16, b16.data);
            return;
        }
        if (dVar instanceof k91.a) {
            ((k91.a) dVar).a(bVar.getArguments(), new b(bVar));
        }
    }

    void c(k91.b bVar, k91.d dVar) {
        boolean z16 = true;
        if (dVar instanceof k91.e) {
            EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IArkIPCService.NAME, bVar.getMethod(), bVar.getArguments());
            if (callServer.code != 0) {
                QLog.i("ArkApp.ArkIPCService", 1, "call.sync, method=" + bVar.getMethod() + " result=" + callServer);
            }
            if (callServer.code != 0) {
                z16 = false;
            }
            bVar.a(z16, callServer.data);
            return;
        }
        if (dVar instanceof k91.a) {
            QIPCClientHelper.getInstance().callServer(IArkIPCService.NAME, bVar.getMethod(), bVar.getArguments(), new c(bVar));
            return;
        }
        QLog.i("ArkApp.ArkIPCService", 1, "call, invalid handler class, " + dVar.getClass().toString());
    }

    public void call(k91.b bVar) {
        if (bVar == null) {
            QLog.i("ArkApp.ArkIPCService", 1, "call, method is null");
            return;
        }
        k91.d d16 = d(bVar.getMethod());
        if (d16 == null) {
            QLog.i("ArkApp.ArkIPCService", 1, "call, handler not found, method=" + bVar.getMethod());
            return;
        }
        if (f()) {
            b(bVar, d16);
        } else {
            c(bVar, d16);
        }
    }

    k91.d d(String str) {
        Class<? extends k91.d> cls = this.f199351d.get(str);
        if (cls == null) {
            QLog.i("ArkApp.ArkIPCService", 1, "action not found, action=" + str);
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    boolean f() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    void g(String str, Class<? extends k91.d> cls) {
        this.f199351d.put(str, cls);
    }

    protected void init() {
        Iterator<Class<? extends k91.d>> it = f199350f.iterator();
        while (it.hasNext()) {
            Class<? extends k91.d> next = it.next();
            try {
                g(next.newInstance().getMethod(), next);
            } catch (Exception unused) {
                QLog.w("ArkApp.ArkIPCService", 1, "ArkIPCService.cinit, init failed for " + next);
            }
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        k91.d d16 = d(str);
        if (d16 instanceof k91.e) {
            return ((k91.e) d16).b(bundle);
        }
        if (d16 instanceof k91.a) {
            ((k91.a) d16).a(bundle, new a(i3));
            return null;
        }
        QLog.i("ArkApp.ArkIPCService", 1, "onCall, invalid action, " + str);
        return null;
    }
}
