package com.tencent.turingcam;

import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class d3EI1 {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final String f382180e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f382181f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f382182g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f382183h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f382184i;

    /* renamed from: a, reason: collision with root package name */
    public long f382185a;

    /* renamed from: b, reason: collision with root package name */
    public int f382186b;

    /* renamed from: c, reason: collision with root package name */
    public String f382187c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f382188d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f382180e = LwgsO.a(LwgsO.O0);
        f382181f = LwgsO.a(LwgsO.P0);
        f382182g = LwgsO.a(LwgsO.Q0);
        f382183h = LwgsO.a(LwgsO.R0);
        f382184i = LwgsO.a(LwgsO.S0);
    }

    public d3EI1(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f382185a = -1L;
        this.f382186b = -1;
        this.f382187c = "";
        this.f382188d = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str3 = f382184i;
            if (jSONObject.has(str3)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str3);
                optJSONArray.length();
                this.f382188d = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.f382188d.add(optJSONArray.getString(i3));
                }
                a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.f382188d.get(0).getBytes())));
                jSONObject.put(f382182g, this.f382187c);
                jSONObject.put(f382183h, this.f382186b);
                jSONObject.put(f382181f, this.f382185a);
                jSONObject.toString();
                return;
            }
            this.f382185a = jSONObject.optLong(f382181f);
            this.f382186b = jSONObject.optInt(f382183h);
            this.f382187c = jSONObject.optString(f382182g);
            jSONObject.optString(f382180e);
        } catch (Exception unused) {
        }
    }

    public final void a(X509Certificate x509Certificate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) x509Certificate);
        } else {
            try {
                nq6Fd.a(x509Certificate, this);
            } catch (Exception unused) {
            }
        }
    }

    public d3EI1(Certificate[] certificateArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) certificateArr);
            return;
        }
        this.f382185a = -1L;
        this.f382186b = -1;
        this.f382187c = "";
        this.f382188d = null;
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < certificateArr.length; i3++) {
                    Certificate certificate = certificateArr[i3];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a16 = nq6Fd.a(certificate);
                    if (i3 == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.mo162put(a16);
                    arrayList.add(a16);
                }
                this.f382188d = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f382184i, jSONArray);
                jSONObject.put(f382182g, this.f382187c);
                jSONObject.put(f382183h, this.f382186b);
                jSONObject.put(f382181f, this.f382185a);
                jSONObject.toString();
            } catch (Exception unused) {
            }
        }
    }
}
