package com.tencent.turingfd.sdk.xq;

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

/* loaded from: classes27.dex */
public class Pineapple {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final String f383002e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f383003f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f383004g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f383005h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f383006i;

    /* renamed from: a, reason: collision with root package name */
    public long f383007a;

    /* renamed from: b, reason: collision with root package name */
    public int f383008b;

    /* renamed from: c, reason: collision with root package name */
    public String f383009c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f383010d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f383002e = Ccontinue.a(Ccontinue.O0);
        f383003f = Ccontinue.a(Ccontinue.P0);
        f383004g = Ccontinue.a(Ccontinue.Q0);
        f383005h = Ccontinue.a(Ccontinue.R0);
        f383006i = Ccontinue.a(Ccontinue.S0);
    }

    public Pineapple(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f383007a = -1L;
        this.f383008b = -1;
        this.f383009c = "";
        this.f383010d = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str3 = f383006i;
            if (jSONObject.has(str3)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str3);
                optJSONArray.length();
                this.f383010d = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.f383010d.add(optJSONArray.getString(i3));
                }
                a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.f383010d.get(0).getBytes())));
                jSONObject.put(f383004g, this.f383009c);
                jSONObject.put(f383005h, this.f383008b);
                jSONObject.put(f383003f, this.f383007a);
                jSONObject.toString();
                return;
            }
            this.f383007a = jSONObject.optLong(f383003f);
            this.f383008b = jSONObject.optInt(f383005h);
            this.f383009c = jSONObject.optString(f383004g);
            jSONObject.optString(f383002e);
        } catch (Exception unused) {
        }
    }

    public final void a(X509Certificate x509Certificate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) x509Certificate);
        } else {
            try {
                Csuper.a(x509Certificate, this);
            } catch (Exception unused) {
            }
        }
    }

    public Pineapple(Certificate[] certificateArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) certificateArr);
            return;
        }
        this.f383007a = -1L;
        this.f383008b = -1;
        this.f383009c = "";
        this.f383010d = null;
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < certificateArr.length; i3++) {
                    Certificate certificate = certificateArr[i3];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a16 = Csuper.a(certificate);
                    if (i3 == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.mo162put(a16);
                    arrayList.add(a16);
                }
                this.f383010d = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f383006i, jSONArray);
                jSONObject.put(f383004g, this.f383009c);
                jSONObject.put(f383005h, this.f383008b);
                jSONObject.put(f383003f, this.f383007a);
                jSONObject.toString();
            } catch (Exception unused) {
            }
        }
    }
}
