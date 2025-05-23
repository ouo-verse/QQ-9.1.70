package com.tencent.luggage.wxa.np;

import android.util.Base64;
import com.tencent.soter.core.model.SoterPubKeyModel;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public long f135900a;

    /* renamed from: b, reason: collision with root package name */
    public int f135901b;

    /* renamed from: c, reason: collision with root package name */
    public String f135902c;

    /* renamed from: d, reason: collision with root package name */
    public String f135903d;

    /* renamed from: e, reason: collision with root package name */
    public String f135904e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f135905f;

    /* renamed from: g, reason: collision with root package name */
    public String f135906g;

    public k(String str, String str2) {
        this.f135900a = -1L;
        this.f135901b = -1;
        this.f135902c = "";
        this.f135903d = "";
        this.f135904e = "";
        this.f135905f = null;
        this.f135906g = "";
        b(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(SoterPubKeyModel.JSON_KEY_CERTS)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(SoterPubKeyModel.JSON_KEY_CERTS);
                if (optJSONArray.length() < 2) {
                    e.b("Soter.SoterPubKeyModel", "certificates train not enough", new Object[0]);
                }
                e.c("Soter.SoterPubKeyModel", "certs size: [%d]", Integer.valueOf(optJSONArray.length()));
                this.f135905f = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.f135905f.add(optJSONArray.getString(i3));
                }
                a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((String) this.f135905f.get(0)).getBytes())));
                jSONObject.put("cpu_id", this.f135902c);
                jSONObject.put("uid", this.f135901b);
                jSONObject.put("counter", this.f135900a);
                b(jSONObject.toString());
            } else {
                this.f135900a = jSONObject.optLong("counter");
                this.f135901b = jSONObject.optInt("uid");
                this.f135902c = jSONObject.optString("cpu_id");
                this.f135903d = jSONObject.optString(SoterPubKeyModel.JSON_KEY_PUBLIC);
            }
        } catch (Exception unused) {
            e.b("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        }
        this.f135906g = str2;
    }

    public final void a(X509Certificate x509Certificate) {
        try {
            a.a(x509Certificate, this);
        } catch (Exception e16) {
            e.a("Soter.SoterPubKeyModel", e16, "soter: loadDeviceInfo from attestationCert failed");
        }
    }

    public String b() {
        return this.f135906g;
    }

    public void c(String str) {
        this.f135906g = str;
    }

    public String toString() {
        return "SoterPubKeyModel{counter=" + this.f135900a + ", uid=" + this.f135901b + ", cpu_id='" + this.f135902c + "', pub_key_in_x509='" + this.f135903d + "', rawJson='" + this.f135904e + "', signature='" + this.f135906g + "'}";
    }

    public void b(String str) {
        this.f135904e = str;
    }

    public void a(long j3) {
        this.f135900a = j3;
    }

    public void a(int i3) {
        this.f135901b = i3;
    }

    public void a(String str) {
        this.f135902c = str;
    }

    public String a() {
        return this.f135904e;
    }

    public k(Certificate[] certificateArr) {
        this.f135900a = -1L;
        this.f135901b = -1;
        this.f135902c = "";
        this.f135903d = "";
        this.f135904e = "";
        this.f135905f = null;
        this.f135906g = "";
        if (certificateArr != null) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < certificateArr.length; i3++) {
                    Certificate certificate = certificateArr[i3];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a16 = a.a(certificate);
                    if (i3 == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.mo162put(a16);
                    arrayList.add(a16);
                }
                this.f135905f = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SoterPubKeyModel.JSON_KEY_CERTS, jSONArray);
                jSONObject.put("cpu_id", this.f135902c);
                jSONObject.put("uid", this.f135901b);
                jSONObject.put("counter", this.f135900a);
                b(jSONObject.toString());
            } catch (Exception unused) {
                e.b("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
            }
        }
    }
}
