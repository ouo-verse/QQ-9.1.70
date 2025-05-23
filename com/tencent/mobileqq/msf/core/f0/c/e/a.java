package com.tencent.mobileqq.msf.core.f0.c.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "msf_high_frequency_packet_send";
    public static final String B = "msf_repeat_packet_send";
    public static final String C = "msf_work_thread_sleep";
    public static final String D = "Public";
    public static final String E = "Gray";
    public static final String F = "Develop";
    public static final String G = "sample_rate_public";
    public static final String H = "sample_rate_gray";
    public static final String I = "sample_rate_develop";

    /* renamed from: d, reason: collision with root package name */
    public static final String f248106d = "msf_IPv6_User";

    /* renamed from: e, reason: collision with root package name */
    public static final String f248107e = "msf_IPv6_Network";

    /* renamed from: f, reason: collision with root package name */
    public static final String f248108f = "msf_tcpEngine_connect";

    /* renamed from: g, reason: collision with root package name */
    public static final String f248109g = "msf_tcp_connect_hold_time";

    /* renamed from: h, reason: collision with root package name */
    public static final String f248110h = "msf_IPv4_Connect_NT";

    /* renamed from: i, reason: collision with root package name */
    public static final String f248111i = "msf_IPv6_Connect_NT";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248112j = "msf_IPv4_Ping_NT";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248113k = "msf_IPv6_Ping_NT";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248114l = "msf_IPv4_Get_Msg_NT";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248115m = "msf_IPv6_Get_Msg_NT";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248116n = "msf_IPv4_Send_Msg_NT";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248117o = "msf_IPv6_Send_Msg_NT";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248118p = "msf_Send_Packet_Grouped_Cost";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248119q = "msf_Send_Packet";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248120r = "msf_recv_uncompress_nt";

    /* renamed from: s, reason: collision with root package name */
    public static final String f248121s = "msf_send_SSO_combine_packet";

    /* renamed from: t, reason: collision with root package name */
    public static final String f248122t = "msf_recv_SSO_combine_packet";

    /* renamed from: u, reason: collision with root package name */
    public static final String f248123u = "msf_enter_bad_net";

    /* renamed from: v, reason: collision with root package name */
    public static final String f248124v = "msf_delayNetworkChange";

    /* renamed from: w, reason: collision with root package name */
    public static final String f248125w = "msf_dual_happyeyeballs";

    /* renamed from: x, reason: collision with root package name */
    public static final String f248126x = "msf_probe_report";

    /* renamed from: y, reason: collision with root package name */
    public static final String f248127y = "msf_network_connect_time_cost";

    /* renamed from: z, reason: collision with root package name */
    public static final String f248128z = "msf_pull_network_info";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final HashMap<String, Integer> f248129c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248129c = new HashMap<>();
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) {
                c();
                return;
            } else {
                d();
                return;
            }
        }
        b();
    }

    private void b() {
        String a16 = a(I, "");
        if (!TextUtils.isEmpty(a16)) {
            try {
                JSONObject jSONObject = new JSONObject(a16);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    this.f248129c.put(str, Integer.valueOf(jSONObject.getInt(str)));
                }
            } catch (Exception e16) {
                QLog.d("MSFConfig", 2, "initDevelopVersionSampleRate error, ", e16);
            }
        }
    }

    private void c() {
        this.f248129c.put(f248118p, 10);
        this.f248129c.put(f248119q, 100);
        this.f248129c.put(f248120r, 10);
        this.f248129c.put(A, 10);
        this.f248129c.put(C, 10);
        String a16 = a(H, "");
        if (!TextUtils.isEmpty(a16)) {
            try {
                JSONObject jSONObject = new JSONObject(a16);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    this.f248129c.put(str, Integer.valueOf(jSONObject.getInt(str)));
                }
            } catch (Exception e16) {
                QLog.d("MSFConfig", 2, "initGrayVersionSampleRate error, ", e16);
            }
        }
    }

    private void d() {
        this.f248129c.put(f248106d, 100);
        this.f248129c.put(f248107e, 10);
        this.f248129c.put(f248108f, 100);
        this.f248129c.put(f248109g, 100);
        this.f248129c.put(f248110h, 100);
        this.f248129c.put(f248111i, 100);
        this.f248129c.put(f248112j, 100);
        this.f248129c.put(f248113k, 100);
        this.f248129c.put(f248114l, 100);
        this.f248129c.put(f248115m, 100);
        this.f248129c.put(f248116n, 10);
        this.f248129c.put(f248117o, 10);
        this.f248129c.put(f248118p, 1000);
        this.f248129c.put(f248119q, 10000);
        this.f248129c.put(f248120r, 1000);
        this.f248129c.put(f248121s, 100);
        this.f248129c.put(f248122t, 100);
        this.f248129c.put(f248123u, 100);
        this.f248129c.put(f248124v, 10);
        this.f248129c.put(f248125w, 100);
        this.f248129c.put(f248126x, 100);
        this.f248129c.put(f248127y, 100);
        this.f248129c.put(f248128z, 100);
        this.f248129c.put(A, 1000);
        this.f248129c.put(B, 100);
        this.f248129c.put(C, 1000);
        String a16 = a(G, "");
        if (!TextUtils.isEmpty(a16)) {
            try {
                JSONObject jSONObject = new JSONObject(a16);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    this.f248129c.put(str, Integer.valueOf(jSONObject.getInt(str)));
                }
            } catch (Exception e16) {
                QLog.d("MSFConfig", 1, "initPublicVersionSampleRate error, ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.x.f
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap<String, Integer> hashMap = new HashMap<>();
            HashMap<String, Integer> hashMap2 = new HashMap<>();
            HashMap<String, Integer> hashMap3 = new HashMap<>();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                Iterator keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String str3 = (String) keys2.next();
                    if (str3.equals("Public")) {
                        hashMap.put(str2, Integer.valueOf(jSONObject2.optInt(str3, 1)));
                    } else if (str3.equals("Gray")) {
                        hashMap2.put(str2, Integer.valueOf(jSONObject2.optInt(str3, 1)));
                    } else if (str3.equals(F)) {
                        hashMap3.put(str2, Integer.valueOf(jSONObject2.optInt(str3, 1)));
                    }
                }
            }
            String a16 = a(hashMap);
            if (!TextUtils.isEmpty(a16)) {
                b(G, a16);
            }
            String a17 = a(hashMap2);
            if (!TextUtils.isEmpty(a17)) {
                b(H, a17);
            }
            String a18 = a(hashMap3);
            if (TextUtils.isEmpty(a18)) {
                return;
            }
            b(I, a18);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 1, "update MSFCoreBeaconSampleRateConfig error, ", e16);
        }
    }

    public HashMap<String, Integer> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248129c : (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    private String a(HashMap<String, Integer> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.d("MSFConfig", 1, "convertHashMapToJson with exception !", e16);
            return "";
        }
    }
}
