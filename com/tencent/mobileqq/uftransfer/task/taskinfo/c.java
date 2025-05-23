package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.k;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.api.g f305378j;

    /* renamed from: k, reason: collision with root package name */
    private g f305379k;

    c(long j3, int i3, com.tencent.mobileqq.uftransfer.api.g gVar, k kVar) {
        super(j3, i3, kVar, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), gVar, kVar);
            return;
        }
        this.f305378j = gVar;
        k(com.tencent.mobileqq.uftransfer.depend.a.i(gVar.a()));
        File file = new File(gVar.a());
        if (file.exists()) {
            l(file.length());
        }
    }

    public static c n(long j3, int i3, com.tencent.mobileqq.uftransfer.api.g gVar, k kVar) {
        if (gVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(gVar.c())) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadTaskInfo", 1, "TId[" + j3 + "] create task info fail. peer uin is null");
            return null;
        }
        return new c(j3, i3, gVar, kVar);
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305378j.a();
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f305378j.b();
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305378j.c();
    }

    public g r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (g) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f305379k;
    }

    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        g gVar = this.f305379k;
        if (gVar != null) {
            return gVar.p();
        }
        return "";
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f305378j.f();
    }

    public void u(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) gVar);
        } else {
            this.f305379k = gVar;
        }
    }
}
