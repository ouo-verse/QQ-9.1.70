package com.tencent.treasurecard.report;

import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final a f381225h;

    /* renamed from: a, reason: collision with root package name */
    private final String f381226a;

    /* renamed from: b, reason: collision with root package name */
    private final String f381227b;

    /* renamed from: c, reason: collision with root package name */
    private final String f381228c;

    /* renamed from: d, reason: collision with root package name */
    private final String f381229d;

    /* renamed from: e, reason: collision with root package name */
    private final String f381230e;

    /* renamed from: f, reason: collision with root package name */
    public String f381231f;

    /* renamed from: g, reason: collision with root package name */
    private String f381232g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13081);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f381225h = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381226a = "qqvip_freeflow_make_request";
        this.f381227b = "qqvip_freeflow_back_result";
        this.f381228c = "0DOU0I3BWB4O47OD";
        this.f381229d = "q_consume_time";
        this.f381230e = "q_length";
        this.f381231f = "";
        this.f381232g = "";
        UserAction.registerTunnel(new TunnelInfo("0DOU0I3BWB4O47OD", "1000"));
    }

    public static a a() {
        return f381225h;
    }

    private String b() {
        return "" + com.tencent.treasurecard.util.a.b();
    }

    public void c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f381231f = str;
            this.f381232g = str2;
        }
    }

    public boolean d(String str, String str2, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        Map<String, String> map2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), map, Boolean.valueOf(z17), Boolean.valueOf(z18))).booleanValue();
        }
        if (map == null) {
            map2 = new HashMap();
        } else {
            map2 = map;
        }
        map2.put("q_consume_time", String.valueOf(j3));
        map2.put("q_length", String.valueOf(j16));
        return ReportMethodProxy.onUserActionToTunnel(str, str2, z16, j3, j16, map2, z17, z18);
    }

    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (TextUtils.isEmpty(this.f381231f)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", this.f381232g);
        hashMap.put("interface_type", str);
        hashMap.put("appid", this.f381231f);
        hashMap.put("current_operator", b());
        hashMap.put("url", str2 + "");
        d("0DOU0I3BWB4O47OD", "qqvip_freeflow_back_result", true, -1L, -1L, hashMap, true, true);
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(this.f381231f)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", this.f381232g);
        hashMap.put("interface_type", str);
        hashMap.put("appid", this.f381231f);
        hashMap.put("current_operator", b());
        d("0DOU0I3BWB4O47OD", "qqvip_freeflow_make_request", true, -1L, -1L, hashMap, true, true);
    }

    public void g(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        if (TextUtils.isEmpty(this.f381231f)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", this.f381232g);
        hashMap.put("interface_type", str);
        hashMap.put("appid", this.f381231f);
        hashMap.put("current_operator", b());
        hashMap.put("premium_status", Integer.valueOf(i3));
        d("0DOU0I3BWB4O47OD", "qqvip_freeflow_back_result", true, -1L, -1L, hashMap, true, true);
    }
}
