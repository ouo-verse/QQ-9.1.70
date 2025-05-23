package com.tencent.qimei.ai;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.foundation.net.protocol.CMD;
import com.tencent.qimei.uin.U;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final Map<String, k> f343041f;

    /* renamed from: a, reason: collision with root package name */
    public final String f343042a;

    /* renamed from: b, reason: collision with root package name */
    public String f343043b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f343044c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f343045d;

    /* renamed from: e, reason: collision with root package name */
    public String f343046e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18864);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343041f = new ConcurrentHashMap();
        }
    }

    public k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f343044c = new Object();
        this.f343045d = new Object();
        this.f343046e = "0";
        this.f343042a = str;
    }

    public static synchronized k b(String str) {
        k kVar;
        synchronized (k.class) {
            Map<String, k> map = f343041f;
            kVar = map.get(str);
            if (kVar == null) {
                kVar = new k(str);
                map.put(str, kVar);
            }
        }
        return kVar;
    }

    public final String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        try {
            JSONObject jSONObject = !TextUtils.isEmpty(str) ? new JSONObject(str) : new JSONObject();
            jSONObject.put(com.heytap.mcssdk.a.a.f36102l, this.f343042a);
            jSONObject.put("crypt", "1");
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public String a() {
        String d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        synchronized (this.f343044c) {
            if (!TextUtils.isEmpty(this.f343043b)) {
                return this.f343043b;
            }
            synchronized (this.f343045d) {
                d16 = com.tencent.qimei.aa.f.b(this.f343042a).d("tn");
            }
            String str = "2";
            if (d16.length() > 8192) {
                synchronized (this.f343045d) {
                    com.tencent.qimei.aa.f.b(this.f343042a).a("tn");
                }
                d16 = "";
            }
            if (com.tencent.qimei.ak.a.a(this.f343042a).a()) {
                b();
                String a16 = c.f343001a.a(this.f343042a);
                String a17 = a(d16);
                String str2 = this.f343042a;
                CMD cmd = CMD.REGISTER;
                d16 = U.a(str2, cmd.b(), a16, cmd.a(), a17);
                str = "4";
            } else if (d16.isEmpty()) {
                d16 = b();
                str = "3";
            } else if (com.tencent.qimei.ab.d.a(com.tencent.qimei.aa.f.b(this.f343042a).c("t_s_t"), 24L)) {
                d16 = b();
                str = "5";
            }
            if (TextUtils.isEmpty(d16)) {
                com.tencent.qimei.f.a.b(this.f343042a, str);
            }
            synchronized (this.f343044c) {
                if (TextUtils.isEmpty(this.f343043b)) {
                    this.f343043b = d16;
                }
            }
            return d16;
        }
    }

    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String a16 = c.f343001a.a(this.f343042a);
        String a17 = a(null);
        String str = this.f343042a;
        CMD cmd = CMD.REGISTER;
        String a18 = U.a(str, cmd.b(), a16, cmd.a(), a17);
        com.tencent.qimei.t.a.a().a(new j(this, a18));
        return a18;
    }
}
