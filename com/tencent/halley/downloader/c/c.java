package com.tencent.halley.downloader.c;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.halley.common.e.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    public List<String> f113687a;

    /* renamed from: b */
    public boolean f113688b;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        private static final c f113689a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12127);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f113689a = new c((byte) 0);
            }
        }

        public static /* synthetic */ c a() {
            return f113689a;
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113687a = new ArrayList();
            this.f113688b = false;
        }
    }

    public static com.tencent.halley.downloader.d.a a(String str) {
        com.tencent.halley.common.e.a aVar;
        com.tencent.halley.common.utils.d.b("HttpDnsManager", "syncGetIpAddressesByName domain = ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.msdk.dns.core.c e16 = com.tencent.msdk.dns.c.h().e(str);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            HashMap hashMap = new HashMap();
            hashMap.put("qddCostTime", String.valueOf(currentTimeMillis2));
            hashMap.put("qddDomain", str);
            aVar = a.C1242a.f113533a;
            aVar.a("B_DLSDK_HttpDns", true, hashMap);
            com.tencent.halley.downloader.d.a aVar2 = new com.tencent.halley.downloader.d.a(com.tencent.halley.common.utils.j.a(e16.f336248a), com.tencent.halley.common.utils.j.a(e16.f336249b), com.tencent.halley.common.utils.j.a(e16.f336250c));
            Pair<Long, Long> b16 = b(str);
            aVar2.f113720c = ((Long) b16.first).longValue();
            aVar2.f113721d = ((Long) b16.second).longValue();
            com.tencent.halley.common.utils.d.b("HttpDnsManager", "syncGetIpAddressesByName ips = ".concat(String.valueOf(aVar2)));
            return aVar2;
        } catch (Exception e17) {
            Log.e("HttpDnsManager", "findIpAddressesByName exception!", e17);
            return new com.tencent.halley.downloader.d.a(new ArrayList(), new ArrayList(), new ArrayList());
        }
    }

    private static Pair<Long, Long> b(String str) {
        long j3;
        String str2;
        long j16 = 0;
        try {
            JSONObject jSONObject = new JSONObject(com.tencent.msdk.dns.c.h().g(str));
            String optString = jSONObject.optString("v4_ttl");
            if (!TextUtils.isEmpty(optString)) {
                j3 = Long.parseLong(optString);
            } else {
                j3 = 0;
            }
            try {
                if (!TextUtils.isEmpty(jSONObject.optString("v6_ttl"))) {
                    j16 = Long.parseLong(optString);
                }
            } catch (NumberFormatException e16) {
                e = e16;
                str2 = "getTTL NumberFormatException!";
                Log.e("HttpDnsManager", str2, e);
                return new Pair<>(Long.valueOf(j3), Long.valueOf(j16));
            } catch (JSONException e17) {
                e = e17;
                str2 = "getTTL JSONException!";
                Log.e("HttpDnsManager", str2, e);
                return new Pair<>(Long.valueOf(j3), Long.valueOf(j16));
            } catch (Exception e18) {
                e = e18;
                str2 = "getTTL exception!";
                Log.e("HttpDnsManager", str2, e);
                return new Pair<>(Long.valueOf(j3), Long.valueOf(j16));
            }
        } catch (NumberFormatException e19) {
            e = e19;
            j3 = 0;
        } catch (JSONException e26) {
            e = e26;
            j3 = 0;
        } catch (Exception e27) {
            e = e27;
            j3 = 0;
        }
        return new Pair<>(Long.valueOf(j3), Long.valueOf(j16));
    }

    /* synthetic */ c(byte b16) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
    }
}
