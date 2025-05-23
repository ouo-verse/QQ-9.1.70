package com.tencent.mobileqq.qqperftool.crash;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f274255a;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f274255a = System.currentTimeMillis();
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CrashInfo:");
        sb5.append("\n CrashTime:" + com.tencent.mobileqq.qqperftool.common.f.f274254a.format(new Date(d())).toString() + " Crash Thread ID:" + h());
        sb5.append("\n CrashType:" + e() + " CrashName:" + b());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("\n CrashStack:");
        sb6.append(c());
        sb5.append(sb6.toString());
        String f16 = f();
        if (!com.tencent.mobileqq.qqperftool.common.f.a(f16)) {
            sb5.append("\n ExtendInfo:" + f16);
        }
        return sb5.toString();
    }

    @NonNull
    public abstract String b();

    @NonNull
    public abstract String c();

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.f274255a;
    }

    public abstract int e();

    public abstract String f();

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CrashName:" + b());
        sb5.append("\n CrashStack:" + c());
        String f16 = f();
        if (!com.tencent.mobileqq.qqperftool.common.f.a(f16)) {
            sb5.append("\n ExtendInfo:" + f16);
        }
        return sb5.toString();
    }

    public abstract long h();
}
