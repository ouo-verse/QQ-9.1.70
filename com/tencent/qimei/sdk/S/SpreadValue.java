package com.tencent.qimei.sdk.S;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ab.a;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SpreadValue implements Serializable {
    static IPatchRedirector $redirector_;
    private String aid;
    private String appKey;
    private long firstTime;
    private String fromKey;
    private String fromSource;
    private String oaid;
    private String q16;
    private String q36;
    private String source;
    private long updateTime;

    public SpreadValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public SpreadValue a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 8, (Object) this, j3);
        }
        this.firstTime = j3;
        return this;
    }

    public SpreadValue b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 9, (Object) this, j3);
        }
        this.updateTime = j3;
        return this;
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.firstTime : ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
    }

    public SpreadValue d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        this.fromSource = str;
        return this;
    }

    public SpreadValue e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        this.oaid = str;
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, obj)).booleanValue();
        }
        if (obj == null || !(obj instanceof SpreadValue)) {
            return false;
        }
        SpreadValue spreadValue = (SpreadValue) obj;
        if (!a.a(this.oaid, spreadValue.oaid) || !a.a(this.aid, spreadValue.aid) || !a.a(this.q16, spreadValue.q16) || !a.a(this.q36, spreadValue.q36)) {
            return false;
        }
        return true;
    }

    public SpreadValue f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.q16 = str;
        return this;
    }

    public SpreadValue g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.q36 = str;
        return this;
    }

    public SpreadValue h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        this.source = str;
        return this;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.source;
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.updateTime;
    }

    public SpreadValue a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.aid = str;
        return this;
    }

    public SpreadValue b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        this.appKey = str;
        return this;
    }

    public SpreadValue c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SpreadValue) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        this.fromKey = str;
        return this;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? this.fromKey : (String) iPatchRedirector.redirect((short) 20, (Object) this);
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? this.fromSource : (String) iPatchRedirector.redirect((short) 21, (Object) this);
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this.oaid : (String) iPatchRedirector.redirect((short) 14, (Object) this);
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? this.q16 : (String) iPatchRedirector.redirect((short) 16, (Object) this);
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? this.q36 : (String) iPatchRedirector.redirect((short) 17, (Object) this);
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? this.aid : (String) iPatchRedirector.redirect((short) 15, (Object) this);
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.appKey : (String) iPatchRedirector.redirect((short) 12, (Object) this);
    }
}
