package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import oicq.wlogin_sdk.persistence.d;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.request.u;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public u f422997a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            String str;
            long j3;
            String str2;
            util.LOGI("[pubkey]start check local pub key", "");
            c cVar = b.f422998a;
            try {
                if (cVar.f422997a == null) {
                    util.LOGI("[pubkey]checkLocalPubKey g is null", "");
                    return;
                }
                String b16 = cVar.b();
                if (TextUtils.isEmpty(b16)) {
                    str2 = "[pubkey]checkLocalPubKey local empty";
                } else {
                    C10918c a16 = cVar.a(b16);
                    if (a16 == null) {
                        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_ROTATE_PUB_KEY_ERROR, "json_error", b16));
                        str2 = "[pubkey]checkLocalPubKey value is null";
                    } else {
                        long j16 = 0;
                        try {
                            Context context = u.f422949w;
                            if (context != null) {
                                j3 = ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getLong("pubKeyTime", 0L);
                            } else {
                                j3 = 0;
                            }
                            util.LOGI("[pubkey]getReqTimeFromSp " + j3, "");
                            j16 = j3;
                        } catch (Throwable th5) {
                            util.printThrowable(th5, "getReqTimeFromSp");
                        }
                        if ((a16.f422999a * 1000) + j16 < System.currentTimeMillis()) {
                            str = "[pubkey]checkLocalPubKey lastTime:" + j16 + " span:" + a16.f422999a;
                        } else {
                            util.LOGI("[pubkey]checkLocalPubKey span valid", "");
                            if (!cVar.a(a16.f423000b, a16.f423001c, a16.f423002d)) {
                                oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_ROTATE_PUB_KEY_ERROR, "key_error", ""));
                                str = "[pubkey]checkLocalPubKey wrong sign";
                            } else {
                                util.LOGI("[pubkey]checkLocalPubKey sign valid", "");
                                return;
                            }
                        }
                        util.LOGI(str, "");
                        cVar.a();
                    }
                }
                util.LOGI(str2, "");
                cVar.a();
            } catch (Throwable th6) {
                util.printThrowable(th6, "checkLocalPubKey");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f422998a = new c();
    }

    /* compiled from: P */
    /* renamed from: oicq.wlogin_sdk.tools.c$c, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C10918c {

        /* renamed from: a, reason: collision with root package name */
        public int f422999a;

        /* renamed from: b, reason: collision with root package name */
        public int f423000b;

        /* renamed from: c, reason: collision with root package name */
        public String f423001c;

        /* renamed from: d, reason: collision with root package name */
        public String f423002d;

        public C10918c(int i3, int i16, String str, String str2) {
            this.f422999a = i3;
            this.f423000b = i16;
            this.f423001c = str;
            this.f423002d = str2;
        }
    }

    public C10918c a(String str) {
        C10918c c10918c = null;
        try {
            if (TextUtils.isEmpty(str)) {
                util.LOGI("[pubkey]parseJsonResult empty json", "");
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("QuerySpan", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("PubKeyMeta");
                if (optJSONObject != null) {
                    c10918c = new C10918c(optInt, optJSONObject.optInt("KeyVer", 0), optJSONObject.optString("PubKey"), optJSONObject.optString("PubKeySign"));
                } else {
                    util.LOGI("[pubkey]parseJsonResult empty keyMetaObj", "");
                }
            } catch (JSONException e16) {
                util.LOGI("[pubkey]parseJsonResult exception" + e16.toString(), "");
            }
            return c10918c;
        } catch (Throwable th5) {
            util.printThrowable(th5, "parseJsonResult");
            return c10918c;
        }
    }

    public String b() {
        try {
            Context context = u.f422949w;
            String string = context != null ? ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("pubKey", "") : "";
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[pubkey]getPubKeyFromFile ");
            sb5.append(string != null ? string.length() : 0);
            util.LOGI(sb5.toString(), "");
            return string;
        } catch (Throwable th5) {
            util.printThrowable(th5, "savePubKeyToFile");
            return "";
        }
    }

    public Pair<String, Integer> c() {
        try {
            String b16 = b();
            if (TextUtils.isEmpty(b16)) {
                util.LOGI("[pubkey]syncGetPubKey json is empty");
                return null;
            }
            C10918c a16 = a(b16);
            if (a16 == null) {
                util.LOGI("[pubkey]syncGetPubKey value is null");
                return null;
            }
            if (!a(a16.f423000b, a16.f423001c, a16.f423002d)) {
                util.LOGI("[pubkey]syncGetPubKey key sign not right");
                return null;
            }
            return new Pair<>(a16.f423001c, Integer.valueOf(a16.f423000b));
        } catch (Throwable th5) {
            util.printThrowable(th5, "syncGetPubKey");
            return null;
        }
    }

    public final void a() {
        StringBuilder sb5;
        try {
            u uVar = this.f422997a;
            if (uVar == null) {
                util.LOGI("[pubkey]fetchPubKey g null", "");
                return;
            }
            long j3 = uVar.f422957d;
            String valueOf = j3 == 0 ? MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN : String.valueOf(j3);
            util.LOGI("[pubkey]fetchPubKey uin:" + valueOf, "");
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.format("https://keyrotate.qq.com/rotate_key?cipher_suite_ver=%s&uin=%s", String.valueOf(305), valueOf)).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(this.f422997a.f422963j);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                int responseCode = httpURLConnection.getResponseCode();
                util.LOGI("[pubkey]response code=" + responseCode, "" + this.f422997a.f422957d);
                if (200 == responseCode) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    byteArrayOutputStream.close();
                    inputStream.close();
                    String str = new String(byteArrayOutputStream.toByteArray());
                    util.LOGI("[pubkey]json:" + str, "");
                    C10918c a16 = a(str);
                    if (!a(a16.f423000b, a16.f423001c, a16.f423002d)) {
                        util.LOGI("[pubkey]fetchPubKey not valid", "");
                    } else {
                        b(str);
                        a(System.currentTimeMillis());
                    }
                }
            } catch (ConnectException e16) {
                sb5 = new StringBuilder();
                sb5.append("[pubkey]connect exception");
                sb5.append(e16.toString());
                util.LOGI(sb5.toString(), "");
            } catch (Exception e17) {
                sb5 = new StringBuilder();
                sb5.append("[pubkey]connect exception");
                sb5.append(e17.toString());
                util.LOGI(sb5.toString(), "");
            }
        } catch (Throwable th5) {
            util.printThrowable(th5, "fetchPubKey");
        }
    }

    public boolean a(int i3, String str, String str2) {
        StringBuilder sb5;
        try {
            String str3 = String.valueOf(305) + String.valueOf(i3) + str;
            try {
                try {
                    try {
                        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuJTW4abQJXeVdAODw1CamZH4QJZChyT08ribet1Gp0wpSabIgyKFZAOxeArcCbknKyBrRY3FFI9HgY1AyItH8DOUe6ajDEb6c+vrgjgeCiOiCVyum4lI5Fmp38iHKH14xap6xGaXcBccdOZNzGT82sPDM2Oc6QYSZpfs8EO7TYT7KSB2gaHz99RQ4A/Lel1Vw0krk+DescN6TgRCaXjSGn268jD7lOO23x5JS1mavsUJtOZpXkK9GqCGSTCTbCwZhI33CpwdQ2EHLhiP5RaXZCio6lksu+d8sKTWU1eEiEb3cQ7nuZXLYH7leeYFoPtbFV4RicIWp0/YG+RP7rLPCwIDAQAB", 0)));
                        Signature signature = Signature.getInstance("SHA256WithRSA");
                        signature.initVerify(generatePublic);
                        signature.update(str3.getBytes());
                        boolean verify = signature.verify(Base64.decode(str2, 0));
                        util.LOGI("[pubkey]checkPubKeyValid result:" + verify, "");
                        return verify;
                    } catch (NoSuchAlgorithmException e16) {
                        sb5 = new StringBuilder();
                        sb5.append("[pubkey]checkPubKeyValid ");
                        sb5.append(e16.toString());
                        util.LOGI(sb5.toString(), "");
                        return false;
                    } catch (SignatureException e17) {
                        sb5 = new StringBuilder();
                        sb5.append("[pubkey]checkPubKeyValid ");
                        sb5.append(e17.toString());
                        util.LOGI(sb5.toString(), "");
                        return false;
                    }
                } catch (InvalidKeyException e18) {
                    sb5 = new StringBuilder();
                    sb5.append("[pubkey]checkPubKeyValid ");
                    sb5.append(e18.toString());
                    util.LOGI(sb5.toString(), "");
                    return false;
                }
            } catch (InvalidKeySpecException e19) {
                sb5 = new StringBuilder();
                sb5.append("[pubkey]checkPubKeyValid ");
                sb5.append(e19.toString());
                util.LOGI(sb5.toString(), "");
                return false;
            }
        } catch (Throwable th5) {
            util.printThrowable(th5, "checkPubKeyValid");
        }
    }

    public void b(String str) {
        try {
            Context context = u.f422949w;
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("pubKey", str);
            dVar.f422793b.commit();
            util.LOGI("[pubkey]savePubKeyToFile json:" + str.length(), "");
        } catch (Throwable th5) {
            util.printThrowable(th5, "savePubKeyToFile");
        }
    }

    public void a(long j3) {
        try {
            Context context = u.f422949w;
            if (context != null) {
                d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
                dVar.putLong("pubKeyTime", j3);
                dVar.f422793b.commit();
                util.LOGI("[pubkey]saveReqTimeToSp time:" + j3, "");
            }
        } catch (Throwable th5) {
            util.printThrowable(th5, "saveReqTimeToSp");
        }
    }
}
