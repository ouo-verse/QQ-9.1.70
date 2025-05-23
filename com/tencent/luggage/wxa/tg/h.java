package com.tencent.luggage.wxa.tg;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.oskplayer.report.VideoResultCode;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {

    /* renamed from: b, reason: collision with root package name */
    public static String f141311b = "<html";

    /* renamed from: a, reason: collision with root package name */
    public static final int f141310a = Build.VERSION.SDK_INT;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap f141312c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f141313d = new AtomicInteger(1);

    /* renamed from: e, reason: collision with root package name */
    public static HashMap f141314e = new HashMap();

    public static void a(HttpURLConnection httpURLConnection, long j3) {
        int i3 = f141310a;
        if (i3 == 19 || i3 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j3 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j3 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (IOException | Exception unused) {
            }
        }
    }

    public static long b(String str) {
        long j3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        v vVar = new v(str);
        if (vVar.q()) {
            return vVar.s();
        }
        v[] u16 = vVar.u();
        if (u16 != null) {
            for (v vVar2 : u16) {
                if (vVar2 != null) {
                    j3 += b(vVar2.g());
                }
            }
        }
        return j3;
    }

    public static boolean c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) z.c().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        a(5, "PlayerUtils", "isNetworkAvailable cant access ConnectivityManager missing permission?");
        return false;
    }

    public static boolean d(String str) {
        boolean z16;
        if (f141314e.containsKey(str)) {
            return ((Boolean) f141314e.get(str)).booleanValue();
        }
        if (!str.contains(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8) && !str.contains("m3u")) {
            z16 = false;
        } else {
            z16 = true;
        }
        f141314e.put(str, Boolean.valueOf(z16));
        return z16;
    }

    public static boolean e(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://")) {
            return true;
        }
        return false;
    }

    public static int f(String str) {
        int i3;
        String g16 = g(str);
        if (TextUtils.isEmpty(g16)) {
            return -1;
        }
        try {
            i3 = Integer.parseInt(g16);
        } catch (Exception e16) {
            a(6, "PlayerUtils", "parseM3u8Number error " + e16);
            i3 = -1;
        }
        if (i3 == -1) {
            try {
                return (int) Float.parseFloat(g16);
            } catch (Exception e17) {
                a(6, "PlayerUtils", "parseM3u8Number error " + e17);
                return i3;
            }
        }
        return i3;
    }

    public static String g(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith("#") || (indexOf = str.indexOf(":")) == -1) {
            return "";
        }
        String substring = str.substring(indexOf + 1);
        if (str.lastIndexOf(",") != -1) {
            return substring.substring(0, substring.length() - 1);
        }
        return substring;
    }

    public static String h(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = (String) f141312c.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        com.tencent.luggage.wxa.pg.e d16 = com.tencent.luggage.wxa.og.a.a().d();
        if (d16 == null) {
            d16 = new com.tencent.luggage.wxa.pg.g();
        }
        String a16 = d16.a(str);
        f141312c.put(str, a16);
        return a16;
    }

    public static String i(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/")) {
            return "file://" + str;
        }
        return str;
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("file:///android_asset");
    }

    public static String c(String str, String str2) {
        if (str2 == null) {
            str2 = "|";
        }
        return str != null ? str.replaceAll("\\r\\n", str2).replaceAll("\\r|\\n", str2) : str;
    }

    public static long b(List list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        String str = (String) list.get(0);
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            a(6, "PlayerUtils", "getSubErrorCode: long string is ill-format");
            return -1L;
        }
    }

    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static long b(long j3, long j16) {
        int i3;
        String[] b16 = b();
        if (b16 != null) {
            a(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(b16).iterator(), "|"));
            i3 = -3;
        } else {
            i3 = -2;
        }
        return (i3 * 100000000) + (j3 * JsonGrayBusiId.UI_RESERVE_100000_110000) + j16;
    }

    public static List a(String str, int i3) {
        ArrayList arrayList = new ArrayList(((str.length() + i3) - 1) / i3);
        int i16 = 0;
        while (i16 < str.length()) {
            int i17 = i16 + i3;
            arrayList.add(str.substring(i16, Math.min(str.length(), i17)));
            i16 = i17;
        }
        return arrayList;
    }

    public static String[] b() {
        try {
            Method method = ConnectivityManager.class.getMethod("getProxy", new Class[0]);
            com.tencent.luggage.wxa.og.a.a().b();
            Object invoke = method.invoke((ConnectivityManager) z.c().getSystemService("connectivity"), new Object[0]);
            if (invoke == null) {
                return null;
            }
            return a(invoke);
        } catch (NoSuchMethodException | Exception unused) {
            return null;
        }
    }

    public static int a(int i3) {
        try {
            return a();
        } catch (IllegalStateException unused) {
            for (int i16 = 0; i16 < i3; i16++) {
                try {
                    return a();
                } catch (IllegalStateException unused2) {
                    a(5, "PlayerUtils", "retry findFreePort i=" + i16);
                }
            }
            throw new IllegalStateException("Could not find a free TCP/IP port to start video proxy, maxRetry=" + i3);
        }
    }

    public static String b(String str, String str2) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        return str + str2;
    }

    public static int a() {
        ServerSocket serverSocket;
        ServerSocket serverSocket2 = null;
        try {
            serverSocket = new ServerSocket(0);
        } catch (IOException unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            try {
                serverSocket.setReuseAddress(true);
                int localPort = serverSocket.getLocalPort();
                try {
                    serverSocket.close();
                } catch (IOException unused2) {
                }
                try {
                    serverSocket.close();
                } catch (IOException unused3) {
                }
                return localPort;
            } catch (IOException unused4) {
                serverSocket2 = serverSocket;
                if (serverSocket2 != null) {
                    try {
                        serverSocket2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw new IllegalStateException("Could not find a free TCP/IP port to start video proxy");
            }
        } catch (Throwable th6) {
            th = th6;
            serverSocket2 = serverSocket;
            if (serverSocket2 != null) {
                try {
                    serverSocket2.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    public static long a(Map map) {
        if (map == null) {
            return VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
        }
        long b16 = b((List) map.get("x-server-error"));
        if (b16 != -1 && b16 != 0) {
            return b16;
        }
        long b17 = b((List) map.get("x-proxy-error"));
        if (b17 != -1) {
            return b17 - 20000;
        }
        long b18 = b((List) map.get("error"));
        return b18 != -1 ? b18 : VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
    }

    public static long a(long j3, long j16) {
        int i3;
        String[] b16 = b();
        if (b16 != null) {
            a(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(b16).iterator(), "|"));
            i3 = -3;
        } else {
            i3 = -2;
        }
        return ((j3 - j16) - (i3 * 100000000)) / JsonGrayBusiId.UI_RESERVE_100000_110000;
    }

    public static String a(Iterator it, String str) {
        String str2 = "";
        if (it != null) {
            while (it.hasNext()) {
                str2 = str2 + ((String) it.next());
                if (it.hasNext()) {
                    str2 = str2 + str;
                }
            }
        }
        return str2;
    }

    public static String a(List list, String str) {
        return list != null ? a(list.iterator(), str) : "";
    }

    public static String a(List list) {
        return a(list, "|");
    }

    public static boolean a(byte[] bArr) {
        if (bArr == null || bArr.length <= 100) {
            return false;
        }
        byte[] bArr2 = new byte[100];
        System.arraycopy(bArr, 0, bArr2, 0, 100);
        return new String(bArr2).toLowerCase().replaceAll("\\s", "").contains(f141311b);
    }

    public static boolean a(URL url) {
        String str;
        InetAddress inetAddress = null;
        try {
            str = url.getHost();
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            return false;
        }
        try {
            inetAddress = InetAddress.getByName(str);
        } catch (UnknownHostException unused2) {
        }
        if (inetAddress == null) {
            return false;
        }
        if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()) {
            return true;
        }
        try {
            return NetworkInterface.getByInetAddress(inetAddress) != null;
        } catch (SocketException unused3) {
            return false;
        }
    }

    public static String[] a(Object obj) {
        Class<?> cls = Class.forName("android.net.ProxyProperties");
        String[] strArr = {(String) cls.getMethod("getHost", new Class[0]).invoke(obj, new Object[0]), String.valueOf((Integer) cls.getMethod("getPort", new Class[0]).invoke(obj, new Object[0])), (String) cls.getMethod("getExclusionList", new Class[0]).invoke(obj, new Object[0])};
        if (strArr[0] != null) {
            return strArr;
        }
        return null;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str2.startsWith("http")) {
            return str2;
        }
        try {
            return new URL(new URL(str), str2).toString();
        } catch (MalformedURLException unused) {
            return b(str, str2);
        }
    }

    public static String a(Throwable th5) {
        return a(th5, false);
    }

    public static String a(Throwable th5, boolean z16) {
        if (th5 == null) {
            return "";
        }
        Thread currentThread = Thread.currentThread();
        StringBuilder sb5 = new StringBuilder();
        if (!z16) {
            sb5.append("Exception in thread \"");
            sb5.append(currentThread.getName());
            sb5.append("\"");
            sb5.append(th5.toString());
        }
        for (StackTraceElement stackTraceElement : th5.getStackTrace()) {
            sb5.append("\tat ");
            sb5.append(stackTraceElement);
            sb5.append("\n");
        }
        Throwable targetException = th5 instanceof InvocationTargetException ? ((InvocationTargetException) th5).getTargetException() : th5.getCause();
        if (targetException != null) {
            sb5.append("caused by: ");
            sb5.append(targetException.toString());
            sb5.append("\n");
            sb5.append(a(targetException, true));
        }
        return sb5.toString();
    }

    public static void a(int i3, String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a(i3, str, (String) it.next());
        }
    }

    public static void a(int i3, String str, String str2) {
        a(i3, str, str2, null);
    }

    public static void a(int i3, String str, String str2, Throwable th5) {
        if (th5 != null) {
            str2 = str2 + ":" + a(th5);
        }
        if (str2.length() > 1000) {
            a(i3, str, a(str2, 1000));
            return;
        }
        j i16 = com.tencent.luggage.wxa.og.a.a().i();
        if (i16 == null) {
            if (i3 == 2) {
                Log.v(str, str2);
                return;
            }
            if (i3 == 3) {
                Log.d(str, str2);
                return;
            }
            if (i3 == 4) {
                Log.i(str, str2);
                return;
            } else if (i3 == 5) {
                Log.w(str, str2);
                return;
            } else {
                if (i3 != 6) {
                    return;
                }
                Log.e(str, str2);
                return;
            }
        }
        if (i3 == 2) {
            i16.v(str, str2);
            return;
        }
        if (i3 == 3) {
            i16.d(str, str2);
            return;
        }
        if (i3 == 4) {
            i16.i(str, str2);
        } else if (i3 == 5) {
            i16.w(str, str2);
        } else {
            if (i3 != 6) {
                return;
            }
            i16.e(str, str2);
        }
    }
}
