package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.open.base.MD5Utils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.api.f f305376j;

    /* renamed from: k, reason: collision with root package name */
    private f f305377k;

    b(long j3, int i3, com.tencent.mobileqq.uftransfer.api.f fVar, k kVar) {
        super(j3, i3, kVar, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), fVar, kVar);
            return;
        }
        this.f305376j = fVar;
        k(com.tencent.mobileqq.uftransfer.depend.a.i(fVar.a()));
        File file = new File(fVar.a());
        if (file.exists()) {
            l(file.length());
        }
    }

    public static b n(long j3, int i3, com.tencent.mobileqq.uftransfer.api.f fVar, k kVar) {
        if (fVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(fVar.c())) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTaskInfo", 1, "TId[" + j3 + "] create task info fail. peer uin is null");
            return null;
        }
        return new b(j3, i3, fVar, kVar);
    }

    public void A(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) fVar);
        } else {
            this.f305377k = fVar;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.taskinfo.a
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "c2c" + MD5Utils.encodeHexStr(o());
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305376j.a();
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f305376j.b();
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305376j.c();
    }

    public f r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (f) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f305377k;
    }

    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        f fVar = this.f305377k;
        if (fVar != null) {
            return fVar.t();
        }
        return "";
    }

    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        f fVar = this.f305377k;
        if (fVar != null) {
            return fVar.v();
        }
        return "";
    }

    public long u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.f305376j.m();
    }

    public byte[] v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f305376j.n();
    }

    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f305376j.o();
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        f fVar = this.f305377k;
        if (fVar != null) {
            return fVar.x();
        }
        return false;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f305376j.f();
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        f fVar = this.f305377k;
        if (fVar != null) {
            return fVar.y();
        }
        return false;
    }
}
