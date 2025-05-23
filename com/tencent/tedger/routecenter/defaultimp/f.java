package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f extends c<ve4.g> implements ve4.g {
    static IPatchRedirector $redirector_;

    public f(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // ve4.g
    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.g) this.f375322c).D();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.g) this.f375322c).a();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.g) this.f375322c).e();
    }

    @Override // ve4.g
    public List<String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (v()) {
            return new ArrayList();
        }
        return ((ve4.g) this.f375322c).f();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public String getConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (v()) {
            return null;
        }
        return ((ve4.g) this.f375322c).getConfig(str);
    }

    @Override // com.tencent.tedger.outapi.api.d
    public long h(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3))).longValue();
        }
        if (v()) {
            return 0L;
        }
        return ((ve4.g) this.f375322c).h(str, j3);
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean i(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.g) this.f375322c).i(str, z16);
    }

    @Override // ve4.g
    public int initConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (v()) {
            return -1;
        }
        return ((ve4.g) this.f375322c).initConfig();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.g) this.f375322c).j();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.g) this.f375322c).r();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (v()) {
            return true;
        }
        return ((ve4.g) this.f375322c).s();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.g) this.f375322c).t();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.g) this.f375322c).x();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (v()) {
            return "";
        }
        return ((ve4.g) this.f375322c).z();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public String getConfig(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        if (v()) {
            return null;
        }
        return ((ve4.g) this.f375322c).getConfig(str, str2);
    }
}
