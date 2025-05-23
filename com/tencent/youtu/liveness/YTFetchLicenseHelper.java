package com.tencent.youtu.liveness;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.fileupload.FileUploadBase;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTFetchLicenseHelper {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.youtu.liveness.YTFetchLicenseHelper$1FetchThreadRunnable, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class C1FetchThreadRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public FetchLicenseResult f385189a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f385190b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f385191c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f385192d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f385193e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f385194f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f385195g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f385196h;

        public C1FetchThreadRunnable(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f385190b = str;
            this.f385191c = str2;
            this.f385192d = str3;
            this.f385193e = str4;
            this.f385194f = str5;
            this.f385195g = str6;
            this.f385196h = str7;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, YTFetchLicenseHelper.this, str, str2, str3, str4, str5, str6, str7);
            } else {
                this.f385189a = new FetchLicenseResult(YTFetchLicenseHelper.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v21, types: [java.net.HttpURLConnection, javax.net.ssl.HttpsURLConnection, java.net.URLConnection] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.net.HttpURLConnection] */
        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            ?? r36 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            BufferedReader bufferedReader = null;
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    String str = this.f385190b + "-" + currentTimeMillis;
                    Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256);
                    mac.init(new SecretKeySpec(this.f385191c.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256));
                    String encodeToString = Base64.encodeToString(mac.doFinal(str.getBytes()), 2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", this.f385190b);
                    jSONObject.put("auth_string", encodeToString);
                    jSONObject.put("machine_type", this.f385192d);
                    jSONObject.put("machine_id", this.f385193e);
                    jSONObject.put("machine_info", this.f385194f);
                    jSONObject.put("package_name", this.f385195g);
                    jSONObject.put("time_stamp", currentTimeMillis);
                    String jSONObject2 = jSONObject.toString();
                    r36 = (HttpsURLConnection) new URL(this.f385196h).openConnection();
                    try {
                        r36.setRequestMethod("POST");
                        r36.setDoInput(true);
                        r36.setDoOutput(true);
                        r36.setUseCaches(false);
                        r36.setInstanceFollowRedirects(false);
                        r36.setRequestProperty(FileUploadBase.CONTENT_TYPE, "application/json");
                        r36.setConnectTimeout(5000);
                        r36.setReadTimeout(5000);
                        r36.connect();
                        DataOutputStream dataOutputStream = new DataOutputStream(r36.getOutputStream());
                        dataOutputStream.write(jSONObject2.getBytes());
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        this.f385189a.http_status = r36.getResponseCode();
                        if (this.f385189a.http_status == 200) {
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(r36.getInputStream()));
                            try {
                                StringBuilder sb5 = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else {
                                        sb5.append(readLine);
                                    }
                                }
                                JSONObject jSONObject3 = new JSONObject(sb5.toString());
                                if (jSONObject3.has("error_code")) {
                                    this.f385189a.error_code = jSONObject3.optInt("error_code");
                                    this.f385189a.error_msg = jSONObject3.optString("error_msg");
                                    FetchLicenseResult fetchLicenseResult = this.f385189a;
                                    if (fetchLicenseResult.error_code == 0) {
                                        fetchLicenseResult.license = jSONObject3.optString("license");
                                        this.f385189a.bind_type = jSONObject3.optString(AppConstants.Key.BIND_TYPE);
                                        this.f385189a.auth_type = jSONObject3.optString(StartupReportKey.AUTH_TYPE);
                                    }
                                }
                                bufferedReader = bufferedReader2;
                            } catch (MalformedURLException e16) {
                                e = e16;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                if (r36 == 0) {
                                    return;
                                }
                                r36.disconnect();
                            } catch (ProtocolException e18) {
                                e = e18;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                    }
                                }
                                if (r36 == 0) {
                                    return;
                                }
                                r36.disconnect();
                            } catch (SocketTimeoutException e26) {
                                e = e26;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e27) {
                                        e27.printStackTrace();
                                    }
                                }
                                if (r36 == 0) {
                                    return;
                                }
                                r36.disconnect();
                            } catch (IOException e28) {
                                e = e28;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e29) {
                                        e29.printStackTrace();
                                    }
                                }
                                if (r36 == 0) {
                                    return;
                                }
                                r36.disconnect();
                            } catch (InvalidKeyException e36) {
                                e = e36;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e37) {
                                        e37.printStackTrace();
                                    }
                                }
                                if (r36 == 0) {
                                    return;
                                }
                                r36.disconnect();
                            } catch (NoSuchAlgorithmException e38) {
                                e = e38;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e39) {
                                        e39.printStackTrace();
                                    }
                                }
                                if (r36 == 0) {
                                    return;
                                }
                                r36.disconnect();
                            } catch (JSONException e46) {
                                e = e46;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e47) {
                                        e47.printStackTrace();
                                    }
                                }
                                if (r36 == 0) {
                                    return;
                                }
                                r36.disconnect();
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e48) {
                                        e48.printStackTrace();
                                    }
                                }
                                if (r36 != 0) {
                                    r36.disconnect();
                                    throw th;
                                }
                                throw th;
                            }
                        } else {
                            Log.e("YTCommon_FetchLicense", "connection status: " + this.f385189a.http_status);
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e49) {
                                e49.printStackTrace();
                            }
                        }
                    } catch (MalformedURLException e56) {
                        e = e56;
                    } catch (ProtocolException e57) {
                        e = e57;
                    } catch (SocketTimeoutException e58) {
                        e = e58;
                    } catch (IOException e59) {
                        e = e59;
                    } catch (InvalidKeyException e65) {
                        e = e65;
                    } catch (NoSuchAlgorithmException e66) {
                        e = e66;
                    } catch (JSONException e67) {
                        e = e67;
                    }
                } catch (MalformedURLException e68) {
                    e = e68;
                    r36 = 0;
                } catch (ProtocolException e69) {
                    e = e69;
                    r36 = 0;
                } catch (SocketTimeoutException e75) {
                    e = e75;
                    r36 = 0;
                } catch (IOException e76) {
                    e = e76;
                    r36 = 0;
                } catch (InvalidKeyException e77) {
                    e = e77;
                    r36 = 0;
                } catch (NoSuchAlgorithmException e78) {
                    e = e78;
                    r36 = 0;
                } catch (JSONException e79) {
                    e = e79;
                    r36 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    r36 = 0;
                }
                r36.disconnect();
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class FetchLicenseResult {
        static IPatchRedirector $redirector_;
        public String auth_type;
        public String bind_type;
        public int error_code;
        public String error_msg;
        public int http_status;
        public String license;

        public FetchLicenseResult(YTFetchLicenseHelper yTFetchLicenseHelper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) yTFetchLicenseHelper);
                return;
            }
            this.error_code = 1002;
            this.http_status = -1;
            this.error_msg = "";
            this.license = "";
            this.bind_type = "";
            this.auth_type = "";
        }
    }

    public YTFetchLicenseHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public FetchLicenseResult fetchLicenseOnline(Context context, String str, String str2, String str3, YTDeviceInfo yTDeviceInfo) {
        String str4;
        String str5;
        String str6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FetchLicenseResult) iPatchRedirector.redirect((short) 2, this, context, str, str2, str3, yTDeviceInfo);
        }
        if (yTDeviceInfo == null) {
            str4 = "";
        } else {
            str4 = yTDeviceInfo.device_id;
        }
        if (yTDeviceInfo == null) {
            str5 = "ANDROID";
        } else {
            str5 = yTDeviceInfo.platform;
        }
        String str7 = str5;
        if (yTDeviceInfo == null) {
            str6 = "";
        } else {
            str6 = yTDeviceInfo.device_info_encrypted;
        }
        C1FetchThreadRunnable c1FetchThreadRunnable = new C1FetchThreadRunnable(str2, str3, str7, str4, str6, context.getPackageName(), str);
        BaseThread baseThread = new BaseThread(c1FetchThreadRunnable);
        try {
            baseThread.start();
            baseThread.join();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        return c1FetchThreadRunnable.f385189a;
    }
}
