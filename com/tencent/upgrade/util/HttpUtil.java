package com.tencent.upgrade.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.upgrade.bean.HttpPostParams;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HttpUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static IRNetwork f383901a;

    /* compiled from: P */
    /* renamed from: com.tencent.upgrade.util.HttpUtil$4, reason: invalid class name */
    /* loaded from: classes27.dex */
    static class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f383912d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f383913e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f383914f;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int i3 = this.f383912d;
            if (i3 == 200) {
                this.f383913e.onSuccess(this.f383914f);
            } else {
                this.f383913e.onFail(i3, this.f383914f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class a implements IRNetwork.INetworkResult {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f383915a;

        a(b bVar) {
            this.f383915a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
        public void onFail(@NotNull IRNetwork.ResultInfo resultInfo) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) resultInfo);
            } else if (this.f383915a != null) {
                if (resultInfo.getErrorCode() != null) {
                    i3 = resultInfo.getErrorCode().intValue();
                } else {
                    i3 = -1;
                }
                this.f383915a.onFail(i3, resultInfo.getErrorMessage());
            }
        }

        @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
        public void onSuccess(@NotNull Object obj) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = "";
            }
            b bVar = this.f383915a;
            if (bVar != null) {
                bVar.onSuccess(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface b {
        void onFail(int i3, String str);

        void onSuccess(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383901a = null;
        }
    }

    public static String e(String str, Map<String, String> map) throws UnsupportedEncodingException {
        String j3 = j(map);
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        } else if (!str.endsWith(ContainerUtils.FIELD_DELIMITER) && !TextUtils.isEmpty(j3)) {
            str = str + ContainerUtils.FIELD_DELIMITER;
        }
        return str + j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, int i3, @NonNull String str2, @Nullable b bVar) {
        d.a("HttpUtils", "doRequestWithCustomNetImpl ");
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept", "application/json");
            if (map2 != null) {
                hashMap.putAll(map2);
            }
            f383901a.requestWithMethod(IRNetwork.HttpMethod.POST, e(str, map), hashMap, new HashMap(), str2, new a(bVar));
        } catch (Exception e16) {
            d.a("HttpUtils", "doRequestWithCustomNetImpl Exception " + Log.getStackTraceString(e16));
            if (bVar != null) {
                bVar.onFail(-1, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v7 */
    public static void g(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, int i3, @NonNull String str2, @Nullable b bVar) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2;
        String message;
        String str3;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream3;
        DataOutputStream dataOutputStream = null;
        int i16 = -1;
        try {
            try {
                httpURLConnection3 = (HttpURLConnection) new URL(e(str, map)).openConnection();
                try {
                    httpURLConnection3.setRequestMethod("POST");
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.setDoInput(true);
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection3.setRequestProperty("Accept", "application/json");
                    if (map2 != 0) {
                        for (Map.Entry entry : map2.entrySet()) {
                            httpURLConnection3.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    httpURLConnection3.setConnectTimeout(i3);
                    httpURLConnection3.setReadTimeout(i3);
                    httpURLConnection3.connect();
                    d.a("HttpUtils", "doPost, bodyStr: " + str2);
                    byte[] bytes = str2.getBytes("utf-8");
                    DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection3.getOutputStream());
                    try {
                        dataOutputStream2.write(bytes);
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                        i16 = httpURLConnection3.getResponseCode();
                        inputStream3 = httpURLConnection3.getInputStream();
                    } catch (Exception e16) {
                        e = e16;
                        httpURLConnection2 = httpURLConnection3;
                        inputStream2 = null;
                        dataOutputStream = dataOutputStream2;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        httpURLConnection = httpURLConnection3;
                        inputStream = null;
                        dataOutputStream = dataOutputStream2;
                    } catch (Throwable th5) {
                        th = th5;
                        map2 = httpURLConnection3;
                        str = 0;
                        dataOutputStream = dataOutputStream2;
                    }
                } catch (Exception e18) {
                    e = e18;
                    httpURLConnection2 = httpURLConnection3;
                    inputStream2 = null;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    httpURLConnection = httpURLConnection3;
                    inputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    map2 = httpURLConnection3;
                    str = 0;
                }
            } catch (Exception e26) {
                e = e26;
                inputStream2 = null;
                httpURLConnection2 = null;
            } catch (OutOfMemoryError e27) {
                e = e27;
                inputStream = null;
                httpURLConnection = null;
            } catch (Throwable th7) {
                th = th7;
                str = 0;
                map2 = 0;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream3, "utf-8"));
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append("\r\n");
                }
                bufferedReader.close();
                String sb6 = sb5.toString();
                c.a(null);
                c.a(inputStream3);
                httpURLConnection3.disconnect();
                str3 = sb6;
            } catch (Exception e28) {
                httpURLConnection2 = httpURLConnection3;
                inputStream2 = inputStream3;
                e = e28;
                e.printStackTrace();
                message = e.getMessage();
                c.a(dataOutputStream);
                c.a(inputStream2);
                str = inputStream2;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    str = inputStream2;
                }
                map2 = message;
                str3 = map2;
                i(bVar, i16, str3);
            } catch (OutOfMemoryError e29) {
                httpURLConnection = httpURLConnection3;
                inputStream = inputStream3;
                e = e29;
                message = e.getMessage();
                c.a(dataOutputStream);
                c.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                i16 = -1000;
                str = inputStream;
                map2 = message;
                str3 = map2;
                i(bVar, i16, str3);
            } catch (Throwable th8) {
                map2 = httpURLConnection3;
                str = inputStream3;
                th = th8;
                c.a(dataOutputStream);
                c.a(str);
                if (map2 != 0) {
                    map2.disconnect();
                }
                throw th;
            }
            i(bVar, i16, str3);
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static void h(@NotNull String str, int i3, @Nullable Map<String, String> map, @Nullable b bVar) {
        com.tencent.upgrade.thread.a.d().b(new Runnable(str, map, i3, bVar) { // from class: com.tencent.upgrade.util.HttpUtil.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f383908d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Map f383909e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f383910f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ b f383911h;

            {
                this.f383908d = str;
                this.f383909e = map;
                this.f383910f = i3;
                this.f383911h = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, map, Integer.valueOf(i3), bVar);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v2 */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r2v9, types: [java.net.HttpURLConnection, java.net.URLConnection] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                ?? r26;
                InputStream inputStream;
                InputStream inputStream2;
                InputStream inputStream3;
                String message;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && (r26 = iPatchRedirector.hasPatch((short) 2)) != 0) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int i16 = -1;
                try {
                    try {
                        r26 = (HttpURLConnection) new URL(this.f383908d).openConnection();
                    } catch (Exception e16) {
                        e = e16;
                        r26 = 0;
                        inputStream3 = null;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        r26 = 0;
                        inputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        r26 = 0;
                        inputStream = null;
                    }
                    try {
                        r26.setRequestMethod("GET");
                        r26.setDoOutput(true);
                        r26.setDoInput(true);
                        r26.setUseCaches(false);
                        Map map2 = this.f383909e;
                        if (map2 != null) {
                            for (Map.Entry entry : map2.entrySet()) {
                                r26.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                        r26.setConnectTimeout(this.f383910f);
                        r26.setReadTimeout(this.f383910f);
                        r26.connect();
                        i16 = r26.getResponseCode();
                        inputStream2 = r26.getInputStream();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "utf-8"));
                            StringBuilder sb5 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb5.append(readLine);
                                sb5.append("\r\n");
                            }
                            bufferedReader.close();
                            message = sb5.toString();
                            c.a(null);
                            c.a(inputStream2);
                            r26.disconnect();
                        } catch (Exception e18) {
                            inputStream3 = inputStream2;
                            e = e18;
                            r26 = r26;
                            try {
                                e.printStackTrace();
                                String message2 = e.getMessage();
                                c.a(null);
                                c.a(inputStream3);
                                if (r26 != 0) {
                                    r26.disconnect();
                                }
                                message = message2;
                                HttpUtil.i(this.f383911h, i16, message);
                            } catch (Throwable th6) {
                                th = th6;
                                inputStream = inputStream3;
                                c.a(null);
                                c.a(inputStream);
                                if (r26 != 0) {
                                    r26.disconnect();
                                }
                                throw th;
                            }
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            message = e.getMessage();
                            c.a(null);
                            c.a(inputStream2);
                            if (r26 != 0) {
                                r26.disconnect();
                            }
                            i16 = -1000;
                            HttpUtil.i(this.f383911h, i16, message);
                        }
                    } catch (Exception e26) {
                        e = e26;
                        inputStream3 = null;
                        r26 = r26;
                    } catch (OutOfMemoryError e27) {
                        e = e27;
                        inputStream2 = null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStream = null;
                        c.a(null);
                        c.a(inputStream);
                        if (r26 != 0) {
                        }
                        throw th;
                    }
                    HttpUtil.i(this.f383911h, i16, message);
                } catch (Throwable th8) {
                    th = th8;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(@Nullable b bVar, int i3, String str) {
        if (bVar != null) {
            if (i3 == 200) {
                bVar.onSuccess(str);
            } else {
                bVar.onFail(i3, str);
            }
        }
    }

    private static String j(Map<String, String> map) throws UnsupportedEncodingException {
        if (map == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            boolean z17 = str2 instanceof String;
            if (z17 || (str2 instanceof String[])) {
                if (z16) {
                    z16 = false;
                } else {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                if (z17) {
                    sb5.append(URLEncoder.encode(str, "utf-8"));
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(URLEncoder.encode(map.get(str), "utf-8"));
                }
            }
        }
        return sb5.toString();
    }

    public static void k(@NotNull String str, @NotNull HttpPostParams httpPostParams, @Nullable b bVar) {
        l(str, httpPostParams.getContent(), httpPostParams.getTimeout(), httpPostParams.getHeadParams(), httpPostParams.getQueryParams(), bVar);
    }

    public static void l(@NotNull String str, @NotNull String str2, int i3, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable b bVar) {
        com.tencent.upgrade.thread.a.d().b(new Runnable(str, map2, map, i3, str2, bVar) { // from class: com.tencent.upgrade.util.HttpUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f383902d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Map f383903e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Map f383904f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f383905h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f383906i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ b f383907m;

            {
                this.f383902d = str;
                this.f383903e = map2;
                this.f383904f = map;
                this.f383905h = i3;
                this.f383906i = str2;
                this.f383907m = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, map2, map, Integer.valueOf(i3), str2, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                d.a("HttpUtils", "executeNetworkTask ,thread = " + Thread.currentThread().getName());
                if (HttpUtil.f383901a != null) {
                    HttpUtil.f(this.f383902d, this.f383903e, this.f383904f, this.f383905h, this.f383906i, this.f383907m);
                } else {
                    HttpUtil.g(this.f383902d, this.f383903e, this.f383904f, this.f383905h, this.f383906i, this.f383907m);
                }
            }
        });
    }

    public static void m(IRNetwork iRNetwork) {
        f383901a = iRNetwork;
    }
}
