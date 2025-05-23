package com.tencent.gathererga.tangram.internal;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gathererga.core.f;
import com.tencent.gathererga.tangram.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f108379a;

    /* renamed from: b, reason: collision with root package name */
    private long f108380b;

    /* renamed from: c, reason: collision with root package name */
    private Object f108381c;

    /* renamed from: d, reason: collision with root package name */
    private String f108382d;

    /* renamed from: e, reason: collision with root package name */
    private int f108383e;

    public a(Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj, (Object) str);
            return;
        }
        this.f108379a = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f108380b = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f108381c = null;
        this.f108382d = null;
        this.f108383e = 0;
        if (obj instanceof f) {
            f fVar = (f) obj;
            this.f108379a = fVar.getErrorCode();
            int a16 = fVar.a();
            this.f108383e = a16;
            if (a16 == 2 && (fVar.b() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) fVar.b();
                this.f108382d = jSONObject.optString("hash");
                this.f108381c = jSONObject.opt("raw");
            } else {
                this.f108382d = str;
                this.f108381c = fVar.b();
            }
            this.f108380b = fVar.e();
            return;
        }
        if (obj != null) {
            this.f108379a = -600L;
            this.f108381c = obj;
            this.f108382d = str;
            this.f108383e = 8;
        }
    }

    @Override // com.tencent.gathererga.tangram.d
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f108383e;
    }

    @Override // com.tencent.gathererga.tangram.d
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f108382d;
    }

    @Override // com.tencent.gathererga.tangram.d
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f108380b;
    }

    @Override // com.tencent.gathererga.tangram.d
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f108379a == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gathererga.tangram.d
    public long getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f108379a;
    }

    @Override // com.tencent.gathererga.tangram.d
    public Object getResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f108381c;
    }
}
