package com.tencent.tfd.sdk.wxa;

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
/* loaded from: classes26.dex */
public final class Bagasse {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final String f375411e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f375412f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f375413g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f375414h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f375415i;

    /* renamed from: a, reason: collision with root package name */
    public long f375416a;

    /* renamed from: b, reason: collision with root package name */
    public int f375417b;

    /* renamed from: c, reason: collision with root package name */
    public String f375418c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f375419d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f375411e = Cswitch.a(Cswitch.N0);
        f375412f = Cswitch.a(Cswitch.O0);
        f375413g = Cswitch.a(Cswitch.P0);
        f375414h = Cswitch.a(Cswitch.Q0);
        f375415i = Cswitch.a(Cswitch.R0);
    }

    public Bagasse(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f375416a = -1L;
        this.f375417b = -1;
        this.f375418c = "";
        this.f375419d = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = f375415i;
            if (jSONObject.has(str2)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str2);
                optJSONArray.length();
                this.f375419d = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.f375419d.add(optJSONArray.getString(i3));
                }
                a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.f375419d.get(0).getBytes())));
                jSONObject.put(f375413g, this.f375418c);
                jSONObject.put(f375414h, this.f375417b);
                jSONObject.put(f375412f, this.f375416a);
                jSONObject.toString();
                return;
            }
            this.f375416a = jSONObject.optLong(f375412f);
            this.f375417b = jSONObject.optInt(f375414h);
            this.f375418c = jSONObject.optString(f375413g);
            jSONObject.optString(f375411e);
        } catch (Exception unused) {
        }
    }

    public final void a(X509Certificate x509Certificate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) x509Certificate);
        } else {
            try {
                Cconst.a(x509Certificate, this);
            } catch (Exception unused) {
            }
        }
    }

    public Bagasse(Certificate[] certificateArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) certificateArr);
            return;
        }
        this.f375416a = -1L;
        this.f375417b = -1;
        this.f375418c = "";
        this.f375419d = null;
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < certificateArr.length; i3++) {
                    Certificate certificate = certificateArr[i3];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a16 = Cconst.a(certificate);
                    if (i3 == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.mo162put(a16);
                    arrayList.add(a16);
                }
                this.f375419d = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f375415i, jSONArray);
                jSONObject.put(f375413g, this.f375418c);
                jSONObject.put(f375414h, this.f375417b);
                jSONObject.put(f375412f, this.f375416a);
                jSONObject.toString();
            } catch (Exception unused) {
            }
        }
    }
}
