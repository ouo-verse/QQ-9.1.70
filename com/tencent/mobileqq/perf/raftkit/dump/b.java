package com.tencent.mobileqq.perf.raftkit.dump;

import com.tencent.mobileqq.debug.perf.PerfDumpImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "AutoInjectYml/Foundation/QQPerf/Inject_PerfDump.yml", version = 1)
    public static ArrayList<Class<? extends a>> f257950b;

    /* renamed from: a, reason: collision with root package name */
    private a f257951a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47423);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList<Class<? extends a>> arrayList = new ArrayList<>();
        f257950b = arrayList;
        arrayList.add(PerfDumpImpl.class);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f257951a = f();
        }
    }

    private a f() {
        try {
            return f257950b.get(0).newInstance();
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return null;
        } catch (IndexOutOfBoundsException e17) {
            e17.printStackTrace();
            return null;
        } catch (InstantiationException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.perf.raftkit.dump.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        a aVar = this.f257951a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.mobileqq.perf.raftkit.dump.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a aVar = this.f257951a;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.tencent.mobileqq.perf.raftkit.dump.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        a aVar = this.f257951a;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.tencent.mobileqq.perf.raftkit.dump.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        a aVar = this.f257951a;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.tencent.mobileqq.perf.raftkit.dump.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        a aVar = this.f257951a;
        if (aVar != null) {
            aVar.e();
        }
    }
}
