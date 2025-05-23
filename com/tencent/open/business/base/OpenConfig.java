package com.tencent.open.business.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.base.f;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenConfig {

    /* renamed from: g, reason: collision with root package name */
    protected static HashMap<String, OpenConfig> f341039g;

    /* renamed from: h, reason: collision with root package name */
    protected static String f341040h;

    /* renamed from: a, reason: collision with root package name */
    protected Context f341041a;

    /* renamed from: b, reason: collision with root package name */
    protected String f341042b;

    /* renamed from: c, reason: collision with root package name */
    protected JSONObject f341043c = new JSONObject();

    /* renamed from: d, reason: collision with root package name */
    protected long f341044d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected int f341045e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f341046f;

    protected OpenConfig(Context context, String str) {
        this.f341041a = null;
        this.f341042b = null;
        this.f341041a = context;
        this.f341042b = str;
        m();
        t();
    }

    public static OpenConfig i(Context context, String str) {
        if (f341039g == null) {
            f341039g = new HashMap<>();
        }
        if (str != null) {
            f341040h = str;
        }
        if (str == null && (str = f341040h) == null) {
            str = "0";
        }
        OpenConfig openConfig = f341039g.get(str);
        if (openConfig == null) {
            OpenConfig openConfig2 = new OpenConfig(context, str);
            f341039g.put(str, openConfig2);
            return openConfig2;
        }
        return openConfig;
    }

    public static boolean o() {
        try {
            String processName = MsfSdkUtils.getProcessName(com.tencent.open.adapter.a.f().e());
            f.a("OpenConfig", "isMainProcess=" + processName);
            return "com.tencent.mobileqq".equals(processName);
        } catch (Exception unused) {
            return false;
        }
    }

    public static void q() {
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("share_myAppApi", 0).edit();
        edit.putLong("last_get_config_trigger", System.currentTimeMillis());
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String r(String str, Bundle bundle) {
        Throwable th5;
        Exception e16;
        HttpURLConnection httpURLConnection;
        int responseCode;
        ?? c16 = HttpBaseUtil.c(MsfSdkUtils.insertMtype("yingyongbao", str), bundle);
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(c16).openConnection();
            } catch (Exception e17) {
                e16 = e17;
                httpURLConnection = null;
            } catch (Throwable th6) {
                th5 = th6;
                c16 = 0;
                if (c16 != 0) {
                }
                throw th5;
            }
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
            } catch (Exception e18) {
                e16 = e18;
                f.d("OpenConfig", "sendHttpGetRequest exception ", e16);
                if (httpURLConnection == null) {
                    return "";
                }
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused) {
                    return "";
                }
            }
            if (responseCode == 200) {
                f.e("OpenConfig", "request success");
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 == read) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                inputStream.close();
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                byteArrayOutputStream.close();
                f.e("OpenConfig", "onResponse: " + byteArrayOutputStream2);
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused2) {
                }
                return byteArrayOutputStream2;
            }
            f.c("OpenConfig", "request failed, code = " + responseCode + "  Msg = " + httpURLConnection.getResponseMessage());
            httpURLConnection.disconnect();
        } catch (Throwable th7) {
            th5 = th7;
            if (c16 != 0) {
                try {
                    c16.disconnect();
                } catch (Throwable unused3) {
                }
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(String str, Bundle bundle) {
        Request build = new Request.Builder().url(HttpBaseUtil.c(MsfSdkUtils.insertMtype("yingyongbao", str), bundle)).get().build();
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build2 = newBuilder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).build();
        Response response = null;
        try {
            try {
                response = build2.newCall(build).execute();
                int code = response.code();
                if (code == 200) {
                    f.e("OpenConfig", "request success");
                } else {
                    f.c("OpenConfig", "request failed, code = " + code + "  Msg = " + response.message());
                }
                String string = response.body().string();
                response.close();
                return string;
            } catch (IOException e16) {
                f.d("OpenConfig", "sendHttpGetRequest exception ", e16);
                if (response != null) {
                    response.close();
                    return "";
                }
                return "";
            }
        } catch (Throwable th5) {
            if (response != null) {
                response.close();
            }
            throw th5;
        }
    }

    protected void d() {
        int i3;
        JSONObject jSONObject = this.f341043c;
        if (jSONObject != null) {
            i3 = jSONObject.optInt("Common_frequency");
        } else {
            i3 = 0;
        }
        if (SystemClock.elapsedRealtime() - this.f341044d >= Math.max(i3, 1) * 3600 * 1000) {
            t();
        }
    }

    protected void e(JSONObject jSONObject) {
        this.f341043c = jSONObject;
        u("com.tencent.open.config.json", jSONObject.toString());
        this.f341044d = SystemClock.elapsedRealtime();
        q();
    }

    public boolean f(String str) {
        Object opt;
        d();
        JSONObject jSONObject = this.f341043c;
        if (jSONObject == null || (opt = jSONObject.opt(str)) == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (!(opt instanceof Boolean)) {
            return false;
        }
        return ((Boolean) opt).booleanValue();
    }

    public boolean g(String str) {
        Object opt;
        d();
        JSONObject jSONObject = this.f341043c;
        if (jSONObject == null || (opt = jSONObject.opt(str)) == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (!(opt instanceof Boolean)) {
            return false;
        }
        return ((Boolean) opt).booleanValue();
    }

    public boolean h(String str) {
        Object opt;
        d();
        JSONObject jSONObject = this.f341043c;
        if (jSONObject == null || (opt = jSONObject.opt(str)) == null) {
            return true;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (!(opt instanceof Boolean)) {
            return false;
        }
        return ((Boolean) opt).booleanValue();
    }

    public int j(String str) {
        d();
        JSONObject jSONObject = this.f341043c;
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.optInt(str);
    }

    public long k(String str) {
        d();
        JSONObject jSONObject = this.f341043c;
        if (jSONObject == null) {
            return 0L;
        }
        return jSONObject.optLong(str);
    }

    public String l(String str) {
        d();
        JSONObject jSONObject = this.f341043c;
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.optString(str);
    }

    protected void m() {
        if (!this.f341046f) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.business.base.OpenConfig.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        OpenConfig.this.f341043c = new JSONObject(OpenConfig.this.p("com.tencent.open.config.json"));
                        OpenConfig.this.f341046f = true;
                        f.a("TAMST_WAKE", "config=" + OpenConfig.this.f341043c.toString());
                    } catch (JSONException unused) {
                    }
                }
            });
        }
    }

    public boolean n() {
        int i3;
        long j3 = com.tencent.open.adapter.a.f().e().getSharedPreferences("share_myAppApi", 0).getLong("last_get_config_trigger", 0L);
        JSONObject jSONObject = this.f341043c;
        if (jSONObject != null) {
            i3 = jSONObject.optInt("Common_frequency");
        } else {
            i3 = 24;
        }
        long j16 = i3 * 3600 * 1000;
        long currentTimeMillis = System.currentTimeMillis() - j3;
        f.a("isLastRequestReady", "lastTriggerTime=" + j3 + "wakeInterval=" + j16 + " Interval=" + currentTimeMillis);
        if (currentTimeMillis < j16) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    protected synchronized String p(String str) {
        String str2;
        InputStream open;
        BufferedReader bufferedReader;
        String readLine;
        String str3;
        str2 = "";
        try {
            try {
                if (this.f341042b != null) {
                    str3 = str + "." + this.f341042b;
                } else {
                    str3 = str;
                }
                open = this.f341041a.openFileInput(str3);
            } catch (IOException e16) {
                e16.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException unused) {
            open = this.f341041a.getAssets().open(str);
        }
        StringBuffer stringBuffer = new StringBuffer();
        ?? r26 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open));
                while (true) {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (IOException e17) {
                        e = e17;
                        bufferedReader2 = bufferedReader;
                        e.printStackTrace();
                        try {
                            open.close();
                            bufferedReader2.close();
                            r26 = bufferedReader2;
                        } catch (IOException e18) {
                            e = e18;
                            e.printStackTrace();
                            return str2;
                        }
                        return str2;
                    } catch (Throwable th5) {
                        th = th5;
                        r26 = bufferedReader;
                        try {
                            open.close();
                            r26.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                        throw th;
                    }
                }
                str2 = stringBuffer.toString();
            } catch (IOException e26) {
                e = e26;
            }
            try {
                open.close();
                bufferedReader.close();
                r26 = readLine;
            } catch (IOException e27) {
                e = e27;
                e.printStackTrace();
                return str2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
        return str2;
    }

    protected void t() {
        if (this.f341045e != 0) {
            return;
        }
        if (!o()) {
            f.a("TAMST_WAKE", "updateConfig= isMainProcess=false");
            return;
        }
        if (!n()) {
            return;
        }
        this.f341045e = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.f341042b);
        bundle.putString("appid_for_getting_config", this.f341042b);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", DeviceInfoMonitor.getModel());
        bundle.putString("status_brand", Build.BRAND);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", "1.5");
        bundle.putString("sdkp", "a");
        bundle.putString("blacklist_logic_version", String.valueOf(1));
        bundle.putString("yyb_version", String.valueOf(0));
        bundle.putString(AppConstants.Preferences.QQ_VERSION, String.valueOf(GlobalUtil.getAppVersionCode(com.tencent.open.adapter.a.f().e())));
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.open.business.base.OpenConfig.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_openconfig_http_refactor_switch", true);
                    f.a("OpenConfig", "updateConfig switch=" + isSwitchOn);
                    JSONObject o16 = HttpBaseUtil.o(isSwitchOn ? OpenConfig.r("https://qappcenterv6.3g.qq.com/cgi-bin/mapp/mapp_policy_config", bundle) : OpenConfig.s("https://qappcenterv6.3g.qq.com/cgi-bin/mapp/mapp_policy_config", bundle));
                    f.a("TAMST_WAKE", "updateConfig=" + o16);
                    OpenConfig.this.e(o16);
                } catch (Throwable th5) {
                    f.c("OpenConfig", th5.getMessage());
                }
                OpenConfig.this.f341045e = 0;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void u(String str, String str2) {
        OutputStreamWriter outputStreamWriter;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (this.f341042b != null) {
                str = str + "." + this.f341042b;
            }
            fileOutputStream = this.f341041a.openFileOutput(str, 0);
            try {
                outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                try {
                    outputStreamWriter.write(str2);
                    outputStreamWriter.flush();
                } catch (IOException e16) {
                    e = e16;
                    fileOutputStream2 = fileOutputStream;
                    e = e;
                    e.printStackTrace();
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    if (outputStreamWriter == null) {
                    }
                }
            } catch (IOException e17) {
                e = e17;
                outputStreamWriter = null;
            }
        } catch (IOException e18) {
            e = e18;
            outputStreamWriter = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
        }
        if (outputStreamWriter == null) {
            try {
                outputStreamWriter.close();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        }
    }
}
