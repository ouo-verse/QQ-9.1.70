package com.tencent.halley.common.c;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.a.k;
import com.tencent.halley.common.utils.j;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static volatile e f113398e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f113398e = null;
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static e e() {
        if (f113398e == null) {
            synchronized (e.class) {
                if (f113398e == null) {
                    f113398e = new e();
                }
            }
        }
        return f113398e;
    }

    @Override // com.tencent.halley.common.c.a
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? "halley-cloud-HalleyAction" : (String) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.halley.common.c.a
    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return h.a("report_insert_new_record_num_limit", 5, 100, 100);
    }

    @Override // com.tencent.halley.common.c.a
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "beacon";
    }

    public static String a(String str, boolean z16, Map<String, String> map) {
        String d16 = com.tencent.halley.common.a.c.d();
        map.put("A23", com.tencent.halley.common.a.f113176e);
        g gVar = new g();
        gVar.a(String.valueOf(str));
        gVar.f113405a = System.currentTimeMillis();
        gVar.f113406b = c.f113392a;
        gVar.f113407c = d16;
        if (!TextUtils.isEmpty(com.tencent.halley.common.a.f113175d)) {
            map.put("A1", com.tencent.halley.common.a.f113175d);
        }
        map.put(NowProxyConstants.AccountInfoKey.A2, j.d());
        map.put("A4", j.e());
        map.put("A6", j.f());
        map.put("A7", "");
        map.put("A23", com.tencent.halley.common.a.f113176e);
        map.put("A33", com.tencent.halley.common.a.c.f());
        map.put("A10", c.f113397f);
        map.put("A9", c.f113396e);
        map.put("A19", d16);
        gVar.a(map);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
        sb5.append("INFO|");
        sb5.append(k.f113283a + "|");
        sb5.append(c.f113395d + "|");
        sb5.append("beacon|");
        sb5.append("1.8.1|");
        String str2 = gVar.f113406b;
        try {
            str2 = URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        sb5.append(str2 + "|");
        sb5.append("|");
        sb5.append("upload_ip|");
        sb5.append("|");
        sb5.append(gVar.f113407c + "|");
        sb5.append(gVar.a() + "|");
        sb5.append(z16 + "|");
        sb5.append(gVar.f113409e + "|");
        sb5.append(gVar.f113408d + "|");
        sb5.append(a(gVar.b()) + "|");
        sb5.append(j.a(gVar.f113405a, "yyyy-MM-dd HH:mm:ss") + "|");
        sb5.append(s4.c.UPLOAD_TIME);
        return sb5.toString();
    }

    private static String a(Map<String, String> map) {
        Set<String> keySet;
        if (map == null || (keySet = map.keySet()) == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str : keySet) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(str);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(map.get(str));
        }
        String substring = sb5.substring(1);
        sb5.setLength(0);
        return substring;
    }
}
