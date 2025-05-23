package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.mobileqq.uftransfer.api.m;
import com.tencent.open.base.MD5Utils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private int f305380j;

    /* renamed from: k, reason: collision with root package name */
    private m f305381k;

    /* renamed from: l, reason: collision with root package name */
    private h f305382l;

    d(long j3, int i3, m mVar, k kVar) {
        super(j3, i3, kVar, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), mVar, kVar);
            return;
        }
        this.f305381k = mVar;
        k(com.tencent.mobileqq.uftransfer.depend.a.i(mVar.a()));
        File file = new File(mVar.a());
        if (file.exists()) {
            l(file.length());
        }
        this.f305380j = mVar.m();
    }

    public static d n(long j3, int i3, m mVar, k kVar) {
        if (mVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(mVar.c())) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadTaskInfo", 1, "TId[" + j3 + "] create task info fail. peer uin is null");
            return null;
        }
        return new d(j3, i3, mVar, kVar);
    }

    public void A(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f305380j = i3;
        }
    }

    public void B(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) hVar);
        } else {
            this.f305382l = hVar;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.taskinfo.a
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "troop" + MD5Utils.encodeHexStr(s());
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f305380j;
    }

    public byte[] p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (byte[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        h hVar = this.f305382l;
        if (hVar != null) {
            return hVar.m();
        }
        return null;
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f305381k.p();
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f305381k.n();
    }

    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305381k.a();
    }

    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f305381k.b();
    }

    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305381k.c();
    }

    public String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        h hVar = this.f305382l;
        if (hVar != null) {
            return hVar.t();
        }
        return "";
    }

    public h w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (h) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f305382l;
    }

    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f305381k.q();
    }

    public String y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        h hVar = this.f305382l;
        if (hVar != null) {
            return hVar.w();
        }
        return "";
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f305381k.f();
    }
}
