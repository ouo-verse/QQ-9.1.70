package com.tencent.mobileqq.app.identity.jwt;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.interfaces.RSAKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
class JsonWebSignature {
    static IPatchRedirector $redirector_ = null;
    public static final String AGREEMENT_PARTY_U_INFO = "apu";
    public static final String AGREEMENT_PARTY_V_INFO = "apv";
    public static final String ALGORITHM = "alg";
    public static final String AUTHENTICATION_TAG = "tag";
    public static final String BASE64URL_ENCODE_PAYLOAD = "b64";
    public static final String CONTENT_TYPE = "cty";
    public static final String CRITICAL = "crit";
    public static final String ECDSA_USING_P256_CURVE_AND_SHA256 = "ES256";
    public static final String ECDSA_USING_P384_CURVE_AND_SHA384 = "ES384";
    public static final String ECDSA_USING_P521_CURVE_AND_SHA512 = "ES512";
    private static final String EMPTY_STRING = "";
    public static final String ENCRYPTION_METHOD = "enc";
    public static final String EPHEMERAL_PUBLIC_KEY = "epk";
    public static final String HMAC_SHA256 = "HS256";
    public static final String HMAC_SHA384 = "HS384";
    public static final String HMAC_SHA512 = "HS512";
    public static final String INITIALIZATION_VECTOR = "iv";
    public static final int MIN_RSA_KEY_LENGTH = 2048;
    public static final String NONE = "none";
    public static final String PBES2_ITERATION_COUNT = "p2c";
    public static final String PBES2_SALT_INPUT = "p2s";
    private static final String PERIOD_SEPARATOR = ".";
    private static final String PERIOD_SEPARATOR_REGEX = "\\.";
    public static final String RSA_PSS_USING_SHA256 = "PS256";
    public static final String RSA_PSS_USING_SHA384 = "PS384";
    public static final String RSA_PSS_USING_SHA512 = "PS512";
    public static final String RSA_USING_SHA256 = "RS256";
    public static final String RSA_USING_SHA384 = "RS384";
    public static final String RSA_USING_SHA512 = "RS512";
    private static final String TAG = "JsonWebSignature";
    public static final String TYPE = "typ";
    private static final String US_ASCII = "US-ASCII";
    public static final String X509_CERTIFICATE_SHA256_THUMBPRINT = "x5t#S256";
    public static final String X509_CERTIFICATE_THUMBPRINT = "x5t";
    public static final String ZIP = "zip";
    private String mDecryptHead;
    private String mDecryptPayload;
    private String mHead;
    private Key mKey;
    private String mPayload;
    private String mSignature;
    private String mSrc;

    JsonWebSignature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static JsonWebSignature fromCompactSerialization(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "token is null");
            return null;
        }
        String[] split = str.split(PERIOD_SEPARATOR_REGEX);
        if (split.length != 3) {
            QLog.e(TAG, 1, "jwt token illegal, length is ", Integer.valueOf(split.length));
            return null;
        }
        JsonWebSignature jsonWebSignature = new JsonWebSignature();
        jsonWebSignature.mSrc = str;
        String str2 = split[0];
        jsonWebSignature.mHead = str2;
        jsonWebSignature.mDecryptHead = new String(android.util.Base64.decode(str2, 11));
        String str3 = split[1];
        jsonWebSignature.mPayload = str3;
        jsonWebSignature.mDecryptPayload = new String(android.util.Base64.decode(str3, 11));
        jsonWebSignature.mSignature = split[2];
        return jsonWebSignature;
    }

    private byte[] getSigningInputBytes() {
        try {
            return serialize(this.mHead, this.mPayload).getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String serialize(String... strArr) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            if (str == null) {
                str = "";
            }
            sb5.append(str);
            if (i3 != strArr.length - 1) {
                sb5.append(".");
            }
        }
        return sb5.toString();
    }

    public String getDecryptHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mDecryptHead;
    }

    public String getDecryptPayload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mDecryptPayload;
    }

    public String getHead(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(this.mDecryptHead)) {
            return null;
        }
        try {
            return new JSONObject(this.mDecryptHead).optString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getPayload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(this.mDecryptPayload)) {
            return null;
        }
        try {
            return new JSONObject(this.mDecryptPayload).optString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getSignature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mSignature;
    }

    public String getSrc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mSrc;
    }

    public void setKey(Key key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) key);
        } else {
            this.mKey = key;
        }
    }

    public boolean verifySignature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        RsaUsingShaAlgorithm rsaUsingShaAlgorithm = new RsaUsingShaAlgorithm();
        Key key = this.mKey;
        if ((key instanceof RSAKey) && ((RSAKey) key).getModulus().bitLength() < 2048) {
            return false;
        }
        return rsaUsingShaAlgorithm.verifySignature(android.util.Base64.decode(this.mSignature, 11), this.mKey, getSigningInputBytes());
    }

    public String getHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.mHead : (String) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    public String getPayload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.mPayload : (String) iPatchRedirector.redirect((short) 9, (Object) this);
    }
}
