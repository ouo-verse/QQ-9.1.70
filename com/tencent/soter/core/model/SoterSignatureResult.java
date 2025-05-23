package com.tencent.soter.core.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterSignatureResult {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_SALT_LEN = 20;
    private static final String SIGNATURE_KEY_COUNTER = "counter";
    private static final String SIGNATURE_KEY_CPU_ID = "cpu_id";
    private static final String SIGNATURE_KEY_FID = "fid";
    private static final String SIGNATURE_KEY_FP_NAME = "fp_n";
    private static final String SIGNATURE_KEY_FP_VERSION = "fp_v";
    private static final String SIGNATURE_KEY_RAW = "raw";
    private static final String SIGNATURE_KEY_SALTLEN = "rsa_pss_saltlen";
    private static final String SIGNATURE_KEY_TEE_NAME = "tee_n";
    private static final String SIGNATURE_KEY_TEE_VERSION = "tee_v";
    private static final String TAG = "Soter.SoterSignatureResult";
    private String FpName;
    private String FpVersion;
    private String TEEName;
    private String TEEVersion;
    private long counter;
    private String cpuId;
    private String fid;
    private String jsonValue;
    private String rawValue;
    private int saltLen;
    private String signature;

    public SoterSignatureResult(String str, String str2, long j3, String str3, String str4, String str5, String str6, String str7, String str8, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Long.valueOf(j3), str3, str4, str5, str6, str7, str8, Integer.valueOf(i3));
            return;
        }
        this.jsonValue = "";
        this.rawValue = str;
        this.fid = str2;
        this.counter = j3;
        this.TEEName = str3;
        this.TEEVersion = str4;
        this.FpName = str5;
        this.FpVersion = str6;
        this.cpuId = str7;
        this.signature = str8;
        this.saltLen = i3;
    }

    public static SoterSignatureResult convertFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SoterSignatureResult soterSignatureResult = new SoterSignatureResult();
            soterSignatureResult.setJsonValue(str);
            soterSignatureResult.setRawValue(jSONObject.optString(SIGNATURE_KEY_RAW));
            soterSignatureResult.setFid(jSONObject.optString("fid"));
            soterSignatureResult.setCounter(jSONObject.optLong("counter"));
            soterSignatureResult.setTEEName(jSONObject.optString(SIGNATURE_KEY_TEE_NAME));
            soterSignatureResult.setTEEVersion(jSONObject.optString(SIGNATURE_KEY_TEE_VERSION));
            soterSignatureResult.setFpName(jSONObject.optString(SIGNATURE_KEY_FP_NAME));
            soterSignatureResult.setFpVersion(jSONObject.optString(SIGNATURE_KEY_FP_VERSION));
            soterSignatureResult.setCpuId(jSONObject.optString("cpu_id"));
            soterSignatureResult.setSaltLen(jSONObject.optInt(SIGNATURE_KEY_SALTLEN, 20));
            return soterSignatureResult;
        } catch (JSONException e16) {
            SLogger.e(TAG, "soter: convert from json failed." + e16.toString(), new Object[0]);
            return null;
        }
    }

    private void setCounter(long j3) {
        this.counter = j3;
    }

    private void setFid(String str) {
        this.fid = str;
    }

    private void setFpName(String str) {
        this.FpName = str;
    }

    private void setFpVersion(String str) {
        this.FpVersion = str;
    }

    private void setJsonValue(String str) {
        this.jsonValue = str;
    }

    private void setRawValue(String str) {
        this.rawValue = str;
    }

    private void setSaltLen(int i3) {
        this.saltLen = i3;
    }

    private void setTEEName(String str) {
        this.TEEName = str;
    }

    private void setTEEVersion(String str) {
        this.TEEVersion = str;
    }

    public long getCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.counter;
    }

    public String getCpuId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.cpuId;
    }

    public String getFid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.fid;
    }

    public String getFpName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.FpName;
    }

    public String getFpVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.FpVersion;
    }

    public String getJsonValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.jsonValue;
    }

    public String getRawValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.rawValue;
    }

    public int getSaltLen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.saltLen;
    }

    public String getSignature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.signature;
    }

    public String getTEEName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.TEEName;
    }

    public String getTEEVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.TEEVersion;
    }

    public void setCpuId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.cpuId = str;
        }
    }

    public void setSignature(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.signature = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "SoterSignatureResult{rawValue='" + this.rawValue + "', fid='" + this.fid + "', counter=" + this.counter + ", TEEName='" + this.TEEName + "', TEEVersion='" + this.TEEVersion + "', FpName='" + this.FpName + "', FpVersion='" + this.FpVersion + "', cpuId='" + this.cpuId + "', saltLen=" + this.saltLen + ", jsonValue='" + this.jsonValue + "', signature='" + this.signature + "'}";
    }

    public SoterSignatureResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.rawValue = null;
        this.fid = null;
        this.counter = -1L;
        this.TEEName = "";
        this.TEEVersion = "";
        this.FpName = "";
        this.FpVersion = "";
        this.cpuId = "";
        this.saltLen = 20;
        this.jsonValue = "";
        this.signature = "";
    }
}
