package com.tencent.imcore.message;

import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class z extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static a f116745e;

    /* renamed from: a, reason: collision with root package name */
    private MsgPool f116746a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f116747b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f116748c;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, f> f116749d;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void a(long j3, b bVar, z zVar);

        void b(z zVar);

        List<b> c(z zVar);

        void d(z zVar);

        void e(long j3, b bVar, z zVar);

        f f(int i3, z zVar);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f116750a;

        /* renamed from: b, reason: collision with root package name */
        int f116751b;

        public b(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                this.f116750a = str;
                this.f116751b = i3;
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f116751b;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37386);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f116745e = new ab();
            s.a();
        }
    }

    public z(AppRuntime appRuntime, BaseProxyManager baseProxyManager, MsgPool msgPool) {
        super(appRuntime, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, baseProxyManager, msgPool);
            return;
        }
        this.f116747b = false;
        this.f116748c = false;
        this.f116749d = new ConcurrentHashMap<>();
        this.f116746a = msgPool;
        i();
    }

    private void a() {
        for (f fVar : this.f116749d.values()) {
            if (fVar != null) {
                fVar.destroy();
            }
        }
    }

    private void b() {
        for (f fVar : this.f116749d.values()) {
            if (fVar != null) {
                fVar.init();
            }
        }
    }

    private void g(int i3) {
        char c16;
        long currentTimeMillis = System.currentTimeMillis();
        List<b> c17 = f116745e.c(this);
        if (c17 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMsgProxyContainer", 2, "init listRecent=" + c17.size());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < c17.size() && i18 < i3; i18++) {
            try {
                b bVar = c17.get(i18);
                if (bVar.a() == 6000) {
                    c16 = 2;
                } else {
                    f116745e.a(currentTimeMillis, bVar, this);
                    List<MessageRecord> h16 = h(bVar.f116750a, bVar.a());
                    if (h16 != null) {
                        i16 += h16.size();
                        i17++;
                    }
                    c16 = 2;
                    QLog.d("Q.msg.BaseMsgProxyContainer", 1, "INIT cost: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), " msgSize: ", Integer.valueOf(i16), " convSize:", Integer.valueOf(i17));
                    f116745e.e(currentTimeMillis, bVar, this);
                }
            } catch (Exception e16) {
                QLog.e("Q.msg.BaseMsgProxyContainer", 1, "initLocked: ", e16);
            }
        }
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
        MsgAutoMonitorUtil.getInstance().printKeyAndValue(MsgAutoMonitorUtil.MSG_PROXY_INIT_TIME_KEY, currentTimeMillis3 + "");
        MsgAutoMonitorUtil.getInstance().printKeyAndValue(MsgAutoMonitorUtil.MSG_INIT_MSG_NUM, i16 + "");
        f116745e.b(this);
    }

    private List<MessageRecord> h(String str, int i3) {
        Lock e16 = this.f116746a.e(str, i3);
        e16.lock();
        try {
            List<MessageRecord> M = e(i3).M(str, i3);
            if (M != null && !M.isEmpty()) {
                this.f116746a.d().put(ao.f(str, i3), M);
            }
            return M;
        } finally {
            e16.unlock();
        }
    }

    private void i() {
        f116745e.d(this);
    }

    private f j(int i3) {
        return f116745e.f(i3, this);
    }

    public static void k(a aVar) {
        f116745e = aVar;
    }

    public AppRuntime c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.app;
    }

    public MsgPool d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MsgPool) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f116746a;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            a();
        }
    }

    public f e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        f fVar = this.f116749d.get(Integer.valueOf(i3));
        if (fVar == null) {
            fVar = j(i3);
            if (fVar == null) {
                QLog.e("Q.msg.BaseMsgProxyContainer", 1, "getMsgProxy: ", new IllegalStateException(i3 + " onCreateMsgProxy return null"));
            }
            this.f116749d.put(Integer.valueOf(i3), fVar);
        }
        return fVar;
    }

    public BaseProxyManager f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BaseProxyManager) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.proxyManager;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f116747b) {
            return;
        }
        synchronized (this) {
            if (this.f116747b) {
                return;
            }
            b();
            g(15);
            this.f116747b = true;
        }
    }
}
