package com.tencent.mobileqq.qqperftool.crashdefend;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.qqperftool.crash.e f274287c;

    /* renamed from: d, reason: collision with root package name */
    private a f274288d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(com.tencent.mobileqq.qqperftool.crash.b bVar);
    }

    public f(@NonNull String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f274287c = new com.tencent.mobileqq.qqperftool.crash.e("StartStepCrashRecorder");
        }
    }

    @Override // com.tencent.mobileqq.qqperftool.crashdefend.g, com.tencent.mobileqq.qqperftool.crashdefend.d
    public boolean a(com.tencent.mobileqq.qqperftool.crash.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar)).booleanValue();
        }
        boolean a16 = super.a(bVar);
        if (a16) {
            this.f274287c.b(bVar);
            a aVar = this.f274288d;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }
        com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "StartStepCrashDefendChecker checkCrashIsNeedHold return " + a16);
        return a16;
    }

    public List<com.tencent.mobileqq.qqperftool.crash.b> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f274287c.d();
    }

    public void e(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f274288d = aVar;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            c(true);
            com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "StartStepCrashDefendChecker startStepBegin success");
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            c(false);
            com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "StartStepCrashDefendChecker startStepEnd success");
        }
    }
}
