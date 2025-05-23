package com.tencent.mobileqq.qqperftool.crashdefend;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private C8422a f274280a;

    /* renamed from: b, reason: collision with root package name */
    private String f274281b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqperftool.crashdefend.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C8422a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f274282a;

        /* renamed from: b, reason: collision with root package name */
        String f274283b;

        public C8422a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f274282a = str;
                this.f274283b = str2;
            }
        }
    }

    public a(@NonNull C8422a c8422a, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c8422a, (Object) str);
        } else {
            this.f274280a = c8422a;
            this.f274281b = str;
        }
    }

    @Override // com.tencent.mobileqq.qqperftool.crashdefend.d
    public boolean a(com.tencent.mobileqq.qqperftool.crash.b bVar) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar)).booleanValue();
        }
        C8422a c8422a = this.f274280a;
        if (c8422a == null) {
            return false;
        }
        if (!com.tencent.mobileqq.qqperftool.common.f.a(c8422a.f274282a)) {
            z16 = false;
            for (String str : this.f274280a.f274282a.split("\\|")) {
                if (str.equalsIgnoreCase(bVar.b())) {
                    com.tencent.mobileqq.qqperftool.common.e.b("ConfigCrashDefendChecker", "checkCrashIsNeedHold crashType = " + str);
                    z16 = true;
                }
            }
        } else {
            z16 = false;
        }
        if (!com.tencent.mobileqq.qqperftool.common.f.a(this.f274280a.f274283b)) {
            z17 = false;
            for (String str2 : this.f274280a.f274283b.split("\\|")) {
                if (bVar.c().contains(str2)) {
                    com.tencent.mobileqq.qqperftool.common.e.b("ConfigCrashDefendChecker", "checkCrashIsNeedHold crashStack = " + str2);
                    z17 = true;
                }
            }
        } else {
            z17 = false;
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqperftool.common.c
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f274281b;
    }
}
