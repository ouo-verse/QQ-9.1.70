package com.tencent.mobileqq.qqperftool.crashdefend;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqperftool.crashdefend.a;
import com.tencent.mobileqq.qqperftool.crashdefend.f;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile c f274284a;

    /* renamed from: b, reason: collision with root package name */
    private volatile f f274285b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqperftool.crashdefend.d
    public boolean a(com.tencent.mobileqq.qqperftool.crash.b bVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar)).booleanValue();
        }
        if (this.f274284a != null) {
            z16 = this.f274284a.a(bVar);
        } else {
            z16 = false;
        }
        if (!z16 && this.f274285b != null) {
            z16 = this.f274285b.a(bVar);
        }
        com.tencent.mobileqq.qqperftool.common.e.b("CrashDefendManager", "Crash Defender hold checker is " + z16);
        return z16;
    }

    public boolean c(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, str2, str3)).booleanValue();
        }
        if (this.f274284a == null) {
            com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "CrashDefendManager.addConfigCrashDefender crashDefenderCheckHolder is null");
            return false;
        }
        com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "CrashDefendManager.addConfigCrashDefender invoke :" + str + "|" + str2 + "|" + str3);
        return this.f274284a.h(new a(new a.C8422a(str2, str3), str));
    }

    public boolean d(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        if (!com.tencent.mobileqq.qqperftool.common.f.a(str) && this.f274284a != null) {
            com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "CrashDefendManager.containCrashDefender invoke :" + str);
            return this.f274284a.i(str);
        }
        com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "CrashDefendManager.containCrashDefender crashDefenderCheckHolder is null");
        return false;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f274285b == null) {
            com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "CrashDefendManager.endStartStepCrashDefend defaultStartStepCrashDefendChecker is null");
            return false;
        }
        this.f274285b.g();
        return true;
    }

    @Nullable
    public List<com.tencent.mobileqq.qqperftool.crash.b> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.f274285b == null) {
            return null;
        }
        return this.f274285b.d();
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f274284a == null) {
            this.f274284a = new c();
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqperftool.common.c
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "CrashDefendManager";
    }

    public boolean h(@NonNull f.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).booleanValue();
        }
        com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "CrashDefendManager.initStartStepCrashDefend invoke :" + aVar.toString());
        this.f274285b = new f("start_step_crash_defender");
        this.f274285b.e(aVar);
        this.f274285b.f();
        return true;
    }

    public boolean i(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        if (this.f274284a == null) {
            com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "CrashDefendManager.removeCrashDefenderByName crashDefenderCheckHolder is null");
            return false;
        }
        com.tencent.mobileqq.qqperftool.common.b.a("CrashDefender", "CrashDefendManager.removeCrashDefenderByName invoke :" + str);
        this.f274284a.j(str);
        return true;
    }
}
