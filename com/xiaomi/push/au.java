package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<a<x>> f388207a = new AtomicReference<>(d());

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f388208b = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f388209c = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f388210d = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a<T> extends FutureTask<T> {

        /* renamed from: d, reason: collision with root package name */
        private long f388211d;

        public a(Callable<T> callable) {
            super(callable);
        }

        public boolean e() {
            if (!hz.j(ii.b()) && (!isDone() || Math.abs(SystemClock.elapsedRealtime() - this.f388211d) <= 1800000)) {
                return false;
            }
            return true;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f388211d = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            au.u();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            au.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c implements Callable<x> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public x call() {
            NetworkInfo activeNetworkInfo;
            Context b16 = ii.b();
            if (b16 == null) {
                return null;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) b16.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return null;
                }
                return new x(activeNetworkInfo);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class d extends FilterInputStream {

        /* renamed from: d, reason: collision with root package name */
        private boolean f388212d;

        public d(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) {
            int read;
            if (!this.f388212d && (read = super.read(bArr, i3, i16)) != -1) {
                return read;
            }
            this.f388212d = true;
            return -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class e {
    }

    public static boolean A(Context context) {
        x f16 = f(context);
        if (f16 == null || f16.a() != 0) {
            return false;
        }
        String h16 = f16.h();
        if (!"TD-SCDMA".equalsIgnoreCase(h16) && !"CDMA2000".equalsIgnoreCase(h16) && !"WCDMA".equalsIgnoreCase(h16)) {
            switch (f16.g()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean B(Context context) {
        x f16 = f(context);
        if (f16 == null || f16.a() != 0) {
            return false;
        }
        int g16 = f16.g();
        if (g16 != 1 && g16 != 2 && g16 != 4 && g16 != 7 && g16 != 11) {
            return false;
        }
        return true;
    }

    public static int a(Context context) {
        x e16 = e();
        if (e16 == null) {
            return -1;
        }
        return e16.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static v b(Context context, String str, String str2, Map<String, String> map, String str3) {
        boolean z16;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        v vVar = new v();
        try {
            try {
                try {
                    HttpURLConnection p16 = p(context, q(str));
                    p16.setConnectTimeout(10000);
                    p16.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    p16.setRequestMethod(str4);
                    int i3 = 0;
                    if (map != null) {
                        z16 = "gzip".equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            p16.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        z16 = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        p16.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (z16) {
                            outputStream = new GZIPOutputStream(p16.getOutputStream());
                        } else {
                            outputStream = p16.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e16) {
                            e = e16;
                            throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
                        } catch (Throwable th5) {
                            th = th5;
                            throw new IOException(th.getMessage());
                        }
                    }
                    vVar.f389862a = p16.getResponseCode();
                    jz4.c.m("Http POST Response Code: " + vVar.f389862a);
                    while (true) {
                        String headerFieldKey = p16.getHeaderFieldKey(i3);
                        String headerField = p16.getHeaderField(i3);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new d(p16.getErrorStream())));
                            }
                        } else {
                            vVar.f389863b.put(headerFieldKey, headerField);
                            i3 = i3 + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new d(p16.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                        }
                        vVar.f389864c = stringBuffer.toString();
                        bufferedReader.close();
                        in.b(null);
                        in.b(null);
                        return vVar;
                    } catch (IOException e17) {
                        e = e17;
                        throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
                    } catch (Throwable th6) {
                        th = th6;
                        throw new IOException(th.getMessage());
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (IOException e18) {
                e = e18;
            }
        } catch (Throwable th8) {
            in.b(null);
            in.b(str2);
            throw th8;
        }
    }

    public static v c(Context context, String str, Map<String, String> map) {
        return b(context, str, "POST", null, o(map));
    }

    private static a<x> d() {
        return new a<>(new c());
    }

    public static x e() {
        AtomicReference<a<x>> atomicReference = f388207a;
        a<x> aVar = atomicReference.get();
        if (aVar != null) {
            try {
                if (aVar.e()) {
                    aVar = d();
                    atomicReference.set(aVar);
                }
                if (!aVar.isDone()) {
                    aVar.run();
                }
                return aVar.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static x f(Context context) {
        return e();
    }

    public static InputStream g(Context context, URL url, boolean z16, String str, String str2) {
        return h(context, url, z16, str, str2, null, null);
    }

    public static InputStream h(Context context, URL url, boolean z16, String str, String str2, Map<String, String> map, e eVar) {
        if (context != null) {
            if (url != null) {
                if (!z16) {
                    url = new URL(m(url.toString()));
                }
                try {
                    HttpURLConnection.setFollowRedirects(true);
                    HttpURLConnection p16 = p(context, url);
                    p16.setConnectTimeout(10000);
                    p16.setReadTimeout(15000);
                    if (!TextUtils.isEmpty(str)) {
                        p16.setRequestProperty("User-Agent", str);
                    }
                    if (str2 != null) {
                        p16.setRequestProperty("Cookie", str2);
                    }
                    if (map != null) {
                        for (String str3 : map.keySet()) {
                            p16.setRequestProperty(str3, map.get(str3));
                        }
                    }
                    return new d(p16.getInputStream());
                } catch (IOException e16) {
                    throw new IOException("IOException:" + e16.getClass().getSimpleName());
                } catch (Throwable th5) {
                    throw new IOException(th5.getMessage());
                }
            }
            throw new IllegalArgumentException("url");
        }
        throw new IllegalArgumentException("context");
    }

    public static Object i(Context context) {
        ConnectivityManager connectivityManager;
        NetworkRequest build;
        b bVar;
        if (context == null) {
            context = ii.b();
        }
        b bVar2 = null;
        if (context == null || hz.j(context)) {
            return null;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            build = new NetworkRequest.Builder().build();
            bVar = new b();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            connectivityManager.registerNetworkCallback(build, bVar);
            return bVar;
        } catch (Throwable th6) {
            th = th6;
            bVar2 = bVar;
            jz4.c.m("exception occurred in adding network callback :" + th);
            return bVar2;
        }
    }

    public static String j(Context context) {
        if (x(context)) {
            return "wifi";
        }
        x e16 = e();
        if (e16 == null) {
            return "";
        }
        return (e16.e() + "-" + e16.h()).toLowerCase();
    }

    public static String k(Context context, URL url) {
        return l(context, url, false, null, "UTF-8", null);
    }

    public static String l(Context context, URL url, boolean z16, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = g(context, url, z16, str, str3);
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            StringBuilder sb5 = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 != read) {
                    sb5.append(cArr, 0, read);
                } else {
                    in.b(inputStream);
                    return sb5.toString();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            in.b(inputStream);
            throw th;
        }
    }

    public static String m(String str) {
        if (!TextUtils.isEmpty(str)) {
            new String();
            return String.format("%s&key=%s", str, ad.b(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String n(String str, Map<String, String> map, File file, String str2) {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new d(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuffer.append(readLine);
                            } else {
                                String stringBuffer2 = stringBuffer.toString();
                                in.b(fileInputStream);
                                in.b(bufferedReader);
                                return stringBuffer2;
                            }
                        } catch (IOException e16) {
                            e = e16;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th5) {
                            th = th5;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e17) {
                    e = e17;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e18) {
                e = e18;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            in.b(null);
            in.b(file);
            throw th8;
        }
    }

    public static String o(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                } catch (UnsupportedEncodingException e16) {
                    jz4.c.m("Failed to convert from params map to string: " + e16);
                    jz4.c.m("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static HttpURLConnection p(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    private static URL q(String str) {
        return new URL(str);
    }

    public static void r() {
        u();
    }

    public static void s(Context context, Object obj) {
        if (context != null && obj != null) {
            try {
                if (obj instanceof ConnectivityManager.NetworkCallback) {
                    ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
                }
            } catch (Throwable th5) {
                jz4.c.m("exception occurred in removing network callback :" + th5);
            }
        }
    }

    public static boolean t(Context context) {
        if (a(context) >= 0) {
            return true;
        }
        return false;
    }

    public static void u() {
        f388207a.set(d());
    }

    public static boolean v(Context context) {
        NetworkCapabilities networkCapabilities;
        boolean hasCapability;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            } catch (Exception unused) {
            }
            if (networkCapabilities != null) {
                hasCapability = networkCapabilities.hasCapability(16);
                if (!hasCapability && w(context)) {
                    return true;
                }
            }
        }
        hasCapability = false;
        return !hasCapability ? false : false;
    }

    public static boolean w(Context context) {
        x e16 = e();
        if (e16 != null && e16.f()) {
            return true;
        }
        return false;
    }

    public static boolean x(Context context) {
        x e16 = e();
        if (e16 == null || 1 != e16.a()) {
            return false;
        }
        return true;
    }

    public static boolean y(Context context) {
        x f16 = f(context);
        if (f16 == null || f16.a() != 0 || 20 != f16.g()) {
            return false;
        }
        return true;
    }

    public static boolean z(Context context) {
        x f16 = f(context);
        if (f16 == null || f16.a() != 0 || 13 != f16.g()) {
            return false;
        }
        return true;
    }
}
