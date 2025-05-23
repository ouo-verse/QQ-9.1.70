package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final AppRuntime f305624a;

    /* renamed from: b, reason: collision with root package name */
    protected long f305625b;

    /* renamed from: c, reason: collision with root package name */
    protected int f305626c;

    /* renamed from: d, reason: collision with root package name */
    protected long f305627d;

    /* renamed from: e, reason: collision with root package name */
    protected long f305628e;

    /* renamed from: f, reason: collision with root package name */
    protected String f305629f;

    /* renamed from: g, reason: collision with root package name */
    protected String f305630g;

    /* renamed from: h, reason: collision with root package name */
    protected long f305631h;

    public u(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f305625b = 0L;
        this.f305626c = 0;
        this.f305627d = 0L;
        this.f305628e = 0L;
        this.f305631h = 0L;
        this.f305624a = appRuntime;
    }

    protected abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, String> b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HashMap) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_ReportVer", String.valueOf(1));
        hashMap.put("param_TransferType", String.valueOf(2));
        hashMap.put("param_Platform", String.valueOf(2));
        hashMap.put("param_AppType", String.valueOf(0));
        hashMap.put("param_Result", String.valueOf(this.f305626c));
        hashMap.put("param_FileName", String.valueOf(this.f305629f));
        hashMap.put("param_Suffix", String.valueOf(this.f305630g));
        hashMap.put("param_TargetUin", String.valueOf(this.f305627d));
        hashMap.put("param_GroupCode", String.valueOf(this.f305628e));
        hashMap.put("param_FileSize", String.valueOf(this.f305631h));
        return hashMap;
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            com.tencent.mobileqq.uftransfer.depend.a.b(this.f305624a.getCurrentAccountUin(), a(), z16, 0L, 0L, b(z16), "");
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f305626c = i3;
        }
    }

    public void e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.f305625b = j3;
        }
    }

    public void f(long j3, long j16, String str, String str2, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, Long.valueOf(j17));
            return;
        }
        this.f305627d = j3;
        this.f305628e = j16;
        this.f305629f = str;
        this.f305630g = str2;
        this.f305631h = j17;
    }
}
