package com.tencent.soter.core.model;

import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes25.dex */
public class SoterPubKeyModel {
    static IPatchRedirector $redirector_ = null;
    public static final String JSON_KEY_CERTS = "certs";
    public static final String JSON_KEY_COUNTER = "counter";
    public static final String JSON_KEY_CPU_ID = "cpu_id";
    public static final String JSON_KEY_PUBLIC = "pub_key";
    public static final String JSON_KEY_UID = "uid";
    private static final String TAG = "Soter.SoterPubKeyModel";
    private ArrayList<String> certs;
    private long counter;
    private String cpu_id;
    private String pub_key_in_x509;
    private String rawJson;
    private String signature;
    private int uid;

    public SoterPubKeyModel(long j3, int i3, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2, str3);
            return;
        }
        this.rawJson = "";
        this.certs = null;
        this.counter = j3;
        this.uid = i3;
        this.cpu_id = str;
        this.pub_key_in_x509 = str2;
        this.signature = str3;
    }

    private void loadDeviceInfo(X509Certificate x509Certificate) {
        try {
            CertUtil.extractAttestationSequence(x509Certificate, this);
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: loadDeviceInfo from attestationCert failed");
        }
    }

    public long getCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.counter;
    }

    public String getCpu_id() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.cpu_id;
    }

    public String getPub_key_in_x509() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.pub_key_in_x509;
    }

    public String getRawJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.rawJson;
    }

    public String getSignature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.signature;
    }

    public int getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.uid;
    }

    public void setCounter(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.counter = j3;
        }
    }

    public void setCpu_id(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.cpu_id = str;
        }
    }

    public void setPub_key_in_x509(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.pub_key_in_x509 = str;
        }
    }

    public void setRawJson(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.rawJson = str;
        }
    }

    public void setSignature(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.signature = str;
        }
    }

    public void setUid(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.uid = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "SoterPubKeyModel{counter=" + this.counter + ", uid=" + this.uid + ", cpu_id='" + this.cpu_id + "', pub_key_in_x509='" + this.pub_key_in_x509 + "', rawJson='" + this.rawJson + "', signature='" + this.signature + "'}";
    }

    public SoterPubKeyModel(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.counter = -1L;
        this.uid = -1;
        this.cpu_id = "";
        this.pub_key_in_x509 = "";
        this.rawJson = "";
        this.certs = null;
        this.signature = "";
        setRawJson(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(JSON_KEY_CERTS)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(JSON_KEY_CERTS);
                if (optJSONArray.length() < 2) {
                    SLogger.e(TAG, "certificates train not enough", new Object[0]);
                }
                SLogger.i(TAG, "certs size: [%d]", Integer.valueOf(optJSONArray.length()));
                this.certs = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.certs.add(optJSONArray.getString(i3));
                }
                loadDeviceInfo((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.certs.get(0).getBytes())));
                jSONObject.put("cpu_id", this.cpu_id);
                jSONObject.put("uid", this.uid);
                jSONObject.put("counter", this.counter);
                setRawJson(jSONObject.toString());
            } else {
                this.counter = jSONObject.optLong("counter");
                this.uid = jSONObject.optInt("uid");
                this.cpu_id = jSONObject.optString("cpu_id");
                this.pub_key_in_x509 = jSONObject.optString(JSON_KEY_PUBLIC);
            }
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: pub key model failed", new Object[0]);
        }
        this.signature = str2;
    }

    public SoterPubKeyModel(Certificate[] certificateArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) certificateArr);
            return;
        }
        this.counter = -1L;
        this.uid = -1;
        this.cpu_id = "";
        this.pub_key_in_x509 = "";
        this.rawJson = "";
        this.certs = null;
        this.signature = "";
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < certificateArr.length; i3++) {
                    Certificate certificate = certificateArr[i3];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String format = CertUtil.format(certificate);
                    if (i3 == 0) {
                        loadDeviceInfo((X509Certificate) certificate);
                    }
                    jSONArray.mo162put(format);
                    arrayList.add(format);
                }
                this.certs = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JSON_KEY_CERTS, jSONArray);
                jSONObject.put("cpu_id", this.cpu_id);
                jSONObject.put("uid", this.uid);
                jSONObject.put("counter", this.counter);
                setRawJson(jSONObject.toString());
            } catch (Exception unused) {
                SLogger.e(TAG, "soter: pub key model failed", new Object[0]);
            }
        }
    }
}
