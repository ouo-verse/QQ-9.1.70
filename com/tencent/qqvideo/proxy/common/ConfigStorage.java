package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.msf.core.auth.e;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ConfigStorage {
    private static final String PREFERENCE = "_httpproxy_preferences";
    public static final String PREF_DOWNPROXY_CONFIG = "DOWNPROXY_CONFIG";
    public static final String PREF_DOWNPROXY_CONFIG_VERSION = "DOWNPROXY_GUID_CONFIG_VERSION";
    private static String TAG = "TV_Httpproxy";
    private static final String TVHttpProxy_Version = "V1.0.188.0006";
    private static final String TVHttpProxy_Version_Code = "101880006";
    private static final String TVHttpProxy_channel_id = "188";
    private static final String httpsCrtFileName = "videosdkcrt/sec.video.qq.com.crt";
    private static final String ipflag = "1";
    private static final String otype = "json";
    private static final String platform = "aphone";
    private static String sharedPreferencesName = null;
    private static final String url = "https://sec.video.qq.com/p/wxconf/getmfomat";
    private Thread thread = null;
    private static final int[] retryTimes = {3, 2};
    private static final int[] connectTimeOut = {5000, 5000, 10000};
    private static final int[] readTimeOut = {10000, 10000, 15000};
    private static String Config_Version = "";
    private static String guid = e.f247445e;
    private static int isReport = -1;

    private String fetchTextFromUrl(String str, Context context) {
        String str2;
        HttpsURLConnection httpsURLConnection;
        BufferedReader bufferedReader;
        String sb5;
        SSLContext httpsSSLContext = getHttpsSSLContext(context);
        if (httpsSSLContext == null) {
            return "";
        }
        HttpsURLConnection httpsURLConnection2 = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader2 = null;
        int i3 = 0;
        while (i3 < 2) {
            if (i3 == 1) {
                str2 = getBkDomain(str);
                HttpproxyFacade.print(4, TAG, "\u8bf7\u6c42\u5907\u4efd\u57df\u540d:" + str2);
            } else {
                str2 = str;
            }
            BufferedReader bufferedReader3 = bufferedReader2;
            InputStream inputStream2 = inputStream;
            HttpsURLConnection httpsURLConnection3 = httpsURLConnection2;
            for (int i16 = 0; i16 < retryTimes[i3]; i16++) {
                try {
                    HttpproxyFacade.print(4, TAG, " \u7b2c" + (i16 + 1) + " \u6b21CGI\u8bf7\u6c42:" + str2);
                    long currentTimeMillis = System.currentTimeMillis();
                    httpsURLConnection = (HttpsURLConnection) new URL(str2).openConnection();
                    try {
                        httpsURLConnection.setConnectTimeout(connectTimeOut[i16]);
                        httpsURLConnection.setReadTimeout(readTimeOut[i16]);
                        httpsURLConnection.setSSLSocketFactory(httpsSSLContext.getSocketFactory());
                        inputStream2 = httpsURLConnection.getInputStream();
                        StringBuilder sb6 = new StringBuilder();
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb6.append(readLine);
                            } catch (IOException e16) {
                                e = e16;
                                bufferedReader3 = bufferedReader;
                                httpsURLConnection3 = httpsURLConnection;
                                try {
                                    e.printStackTrace();
                                    HttpproxyFacade.print(6, TAG, "IO Exception" + System.err);
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e17) {
                                            e17.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader3 != null) {
                                        try {
                                            bufferedReader3.close();
                                        } catch (IOException e18) {
                                            e18.printStackTrace();
                                        }
                                    }
                                    if (httpsURLConnection3 != null) {
                                        try {
                                            httpsURLConnection3.disconnect();
                                        } catch (Exception e19) {
                                            e19.printStackTrace();
                                        }
                                    }
                                } finally {
                                }
                            } catch (Throwable unused) {
                                bufferedReader3 = bufferedReader;
                                httpsURLConnection3 = httpsURLConnection;
                                HttpproxyFacade.print(6, TAG, "unknow exception");
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e26) {
                                        e26.printStackTrace();
                                    }
                                }
                                if (bufferedReader3 != null) {
                                    try {
                                        bufferedReader3.close();
                                    } catch (IOException e27) {
                                        e27.printStackTrace();
                                    }
                                }
                                if (httpsURLConnection3 != null) {
                                    httpsURLConnection3.disconnect();
                                }
                            }
                        }
                        sb5 = sb6.toString();
                        HttpproxyFacade.print(4, TAG, "\u3010connect\u3011\u8fde\u63a5\u65f6\u95f4\uff1a" + (System.currentTimeMillis() - currentTimeMillis) + "\u8fd4\u56de\u6570\u636e\uff1a" + sb5);
                    } catch (IOException e28) {
                        e = e28;
                    } catch (Throwable unused2) {
                    }
                } catch (IOException e29) {
                    e = e29;
                } catch (Throwable unused3) {
                }
                if (!TextUtils.isEmpty(sb5) && !sb5.trim().isEmpty()) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e36) {
                            e36.printStackTrace();
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e37) {
                        e37.printStackTrace();
                    }
                    try {
                        httpsURLConnection.disconnect();
                    } catch (Exception e38) {
                        e38.printStackTrace();
                    }
                    return sb5;
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e39) {
                        e39.printStackTrace();
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e46) {
                    e46.printStackTrace();
                }
                try {
                    httpsURLConnection.disconnect();
                } catch (Exception e47) {
                    e47.printStackTrace();
                }
                bufferedReader3 = bufferedReader;
                httpsURLConnection3 = httpsURLConnection;
            }
            i3++;
            httpsURLConnection2 = httpsURLConnection3;
            inputStream = inputStream2;
            bufferedReader2 = bufferedReader3;
        }
        return "";
    }

    public static SharedPreferences getAppSharedPreferences(Context context) {
        if (sharedPreferencesName == null) {
            sharedPreferencesName = String.valueOf(context.getPackageName()) + PREFERENCE;
        }
        return getSharedPreferences(context, sharedPreferencesName, 0);
    }

    private String getBkDomain(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getConfigVersion() {
        return Config_Version;
    }

    private static String getConfigVersionFromSharedPreference(Context context) {
        if (context == null) {
            return "";
        }
        return getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG_VERSION, "");
    }

    public static String getDownProxyConfig(Context context) {
        if (context == null) {
            return "";
        }
        Config_Version = getConfigVersionFromSharedPreference(context);
        return getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG, "");
    }

    public static String getHttpProxyVersion() {
        return TVHttpProxy_Version;
    }

    public static String getHttpProxyVersionCode() {
        return TVHttpProxy_Version_Code;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i3) {
        return context.getSharedPreferences(str, i3);
    }

    public static void setDownProxyConfig(Context context, String str) {
        getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG, str).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d A[Catch: JSONException -> 0x008c, TryCatch #0 {JSONException -> 0x008c, blocks: (B:12:0x0058, B:14:0x005d, B:17:0x006b, B:18:0x006d, B:20:0x0071), top: B:11:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[Catch: JSONException -> 0x008c, TRY_LEAVE, TryCatch #0 {JSONException -> 0x008c, blocks: (B:12:0x0058, B:14:0x005d, B:17:0x006b, B:18:0x006d, B:20:0x0071), top: B:11:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void synGetConfig(Context context) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject(fetchTextFromUrl(makeGetServerConfigUrl(context), context));
            if (jSONObject.has("httpproxy_config")) {
                try {
                    HttpproxyFacade.print(3, TAG, "get httpproxy_config:" + jSONObject.getString("httpproxy_config"));
                    setDownProxyConfig(context, jSONObject.getString("httpproxy_config"));
                    i3 = 0;
                } catch (Throwable unused) {
                    i3 = 0;
                    HttpproxyFacade.print(6, TAG, "get config exception");
                    if (isReport == -1) {
                    }
                    if (isReport == 1) {
                    }
                }
            } else {
                i3 = -1;
            }
            try {
                if (jSONObject.has("config_ver")) {
                    setConfigVersionToSharedPreference(context, jSONObject.getString("config_ver"));
                }
            } catch (Throwable unused2) {
                HttpproxyFacade.print(6, TAG, "get config exception");
                if (isReport == -1) {
                }
                if (isReport == 1) {
                }
            }
        } catch (Throwable unused3) {
            i3 = -1;
        }
        try {
            if (isReport == -1) {
                isReport = new Random().nextInt(1000) < 1 ? 1 : 0;
            }
            if (isReport == 1) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error_code", i3);
                jSONObject2.put(TVKDataBinder.KEY_REPORT_TYPE, 90);
                HttpproxyFacade.jsonReport(jSONObject2.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void stopGetServerConfig() {
        try {
            Thread thread = this.thread;
            if (thread != null) {
                thread.interrupt();
            }
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
        }
    }

    private SSLContext getHttpsSSLContext(Context context) {
        InputStream inputStream;
        CertificateFactory certificateFactory;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
            inputStream = context.getAssets().open(httpsCrtFileName);
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            Certificate generateCertificate = certificateFactory.generateCertificate(inputStream);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", generateCertificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            return sSLContext;
        } catch (Throwable th6) {
            th = th6;
            try {
                HttpproxyFacade.print(6, TAG, "getHttpsSSLContext unknow exception:" + Log.getStackTraceString(th));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                return null;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }

    private String makeGetServerConfigUrl(Context context) {
        return String.format("%s?platform=%s&appver=%s&player_channel_id=%s&otype=%s&ipflag=%s&guid=%s", url, "aphone", TVHttpProxy_Version, TVHttpProxy_channel_id, "json", "1", guid);
    }

    public void synGetServerConfig(final Context context) {
        if (context == null) {
            HttpproxyFacade.print(6, TAG, "synGetServerConfig context is null");
            return;
        }
        try {
            Thread thread = new Thread(new Runnable() { // from class: com.tencent.qqvideo.proxy.common.ConfigStorage.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigStorage.this.synGetConfig(context);
                }
            });
            this.thread = thread;
            thread.setName("TVDLProxyFetchConfigThread");
            this.thread.start();
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
        }
    }

    private static void setConfigVersionToSharedPreference(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG_VERSION, str).commit();
    }
}
