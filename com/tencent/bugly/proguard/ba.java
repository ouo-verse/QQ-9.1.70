package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.rmonitor.base.thread.suspend.ThreadSuspend;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.util.PerfTracer;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f98179a = new ThreadLocal<SimpleDateFormat>() { // from class: com.tencent.bugly.proguard.ba.1
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, String> f98180b = null;

    public static String a(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th5.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th6) {
            if (av.a(th6)) {
                return "fail";
            }
            th6.printStackTrace();
            return "fail";
        }
    }

    public static String b(Date date) {
        try {
            return f98179a.get().format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b16 : digest) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return null;
            }
            th5.printStackTrace();
            return null;
        }
    }

    public static long d(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return -1L;
        }
    }

    private static Date e(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\s++");
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(Calendar.getInstance().get(1) + "-" + split[0] + " " + split[1]);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        av.c("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return ca.a().b(bArr);
        } catch (Throwable th5) {
            if (th5.getMessage() != null && th5.getMessage().contains("Not in GZIP format")) {
                av.d(th5.getMessage(), new Object[0]);
                return null;
            }
            if (av.a(th5)) {
                return null;
            }
            th5.printStackTrace();
            return null;
        }
    }

    public static String d(String str, String str2) {
        return (ai.c() == null || ai.c().V == null) ? "" : ai.c().V.getString(str, str2);
    }

    public static String d(String str) {
        return (str == null || str.indexOf(0) == -1) ? str : str.replace("\u0000", "");
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String a(Date date) {
        try {
            return f98179a.get().format(date);
        } catch (Throwable unused) {
            return date.toString();
        }
    }

    public static String a(long j3) {
        try {
            return f98179a.get().format(new Date(j3));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000) * 86400000) - TimeZone.getDefault().getRawOffset();
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return -1L;
            }
            th5.printStackTrace();
            return -1L;
        }
    }

    public static byte[] a(String str, String str2) {
        ZipOutputStream zipOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        if (str == null || str.length() == 0) {
            return null;
        }
        av.c("rqdp{  ZF start}", new Object[0]);
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        } catch (Throwable th5) {
            th = th5;
            zipOutputStream = null;
        }
        try {
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                zipOutputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            av.c("rqdp{  ZF end}", new Object[0]);
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                if (!av.a(th)) {
                    th.printStackTrace();
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                av.c("rqdp{  ZF end}", new Object[0]);
                return null;
            } catch (Throwable th7) {
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                av.c("rqdp{  ZF end}", new Object[0]);
                throw th7;
            }
        }
    }

    public static byte[] c(long j3) {
        try {
            return String.valueOf(j3).getBytes("utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static boolean b(File file, File file2) {
        if (file != null && file2 != null && !file.equals(file2)) {
            if (file.exists() && file.canRead()) {
                try {
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (Throwable th5) {
                    if (!av.a(th5)) {
                        th5.printStackTrace();
                    }
                }
                return file2.exists() && file2.canWrite();
            }
            av.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
        av.d("rqdp{  err ZF 1R!}", new Object[0]);
        return false;
    }

    public static boolean c(String str) {
        if (b(str)) {
            return false;
        }
        if (str.length() > 255) {
            av.a("URL(%s)'s length is larger than 255.", str);
            return false;
        }
        if (str.toLowerCase().startsWith("http")) {
            return true;
        }
        av.a("URL(%s) is not start with \"http\".", str);
        return false;
    }

    public static void c(String str, String str2) {
        if (ai.c() == null || ai.c().V == null) {
            return;
        }
        ai.c().V.edit().putString(str, str2).apply();
    }

    public static void b(long j3) {
        try {
            LockMethodProxy.sleep(j3);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static String b(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th5.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("keys", arrayList);
            bundle.putStringArrayList("values", arrayList2);
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        av.c("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return ca.a().a(bArr);
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return null;
            }
            th5.printStackTrace();
            return null;
        }
    }

    public static boolean a(File file, File file2) {
        ZipOutputStream zipOutputStream;
        av.c("rqdp{  ZF start}", new Object[0]);
        if (!b(file, file2)) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
            } catch (Throwable th5) {
                th = th5;
                zipOutputStream = null;
            }
            try {
                zipOutputStream.setMethod(8);
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                byte[] bArr = new byte[Math.max(5000, 1000)];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                try {
                    fileInputStream2.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                try {
                    zipOutputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                av.c("rqdp{  ZF end}", new Object[0]);
                return true;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
                try {
                    if (!av.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    av.c("rqdp{  ZF end}", new Object[0]);
                    return false;
                } catch (Throwable th7) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    av.c("rqdp{  ZF end}", new Object[0]);
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            zipOutputStream = null;
        }
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList != null && stringArrayList2 != null && stringArrayList.size() == stringArrayList2.size()) {
            hashMap = new HashMap(stringArrayList.size());
            for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                hashMap.put(stringArrayList.get(i3), stringArrayList2.get(i3));
            }
        } else {
            av.e("map parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static boolean b(Context context, String str) {
        av.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            av.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th5) {
            av.a(th5);
            return false;
        }
    }

    public static BufferedReader b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return a(file);
            }
            return null;
        } catch (NullPointerException e16) {
            av.a(e16);
            return null;
        }
    }

    public static String a(String str) {
        if (str.trim().equals("")) {
            return "";
        }
        try {
            if (f98180b == null) {
                f98180b = new HashMap();
            }
            if (f98180b.containsKey(str)) {
                return f98180b.get(str);
            }
            String systemProperty = NativeCrashHandler.getInstance().getSystemProperty(str);
            if (!TextUtils.isEmpty(systemProperty)) {
                f98180b.put(str, systemProperty);
            }
            return TextUtils.isEmpty(systemProperty) ? "fail" : systemProperty;
        } catch (Throwable th5) {
            av.b(th5);
            return "fail";
        }
    }

    public static Context a(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static void a(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (Exception unused) {
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putInt("pluginNum", arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                bundle.putString("pluginKey".concat(String.valueOf(i3)), (String) arrayList.get(i3));
            }
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                bundle.putString("pluginVal" + i16 + "plugInId", ((PlugInBean) arrayList2.get(i16)).f97833a);
                bundle.putString("pluginVal" + i16 + "plugInUUID", ((PlugInBean) arrayList2.get(i16)).f97835c);
                bundle.putString("pluginVal" + i16 + "plugInVersion", ((PlugInBean) arrayList2.get(i16)).f97834b);
            }
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i3 = 0; i3 < intValue; i3++) {
            arrayList.add(readBundle.getString("pluginKey".concat(String.valueOf(i3))));
        }
        for (int i16 = 0; i16 < intValue; i16++) {
            arrayList2.add(new PlugInBean(readBundle.getString("pluginVal" + i16 + "plugInId"), readBundle.getString("pluginVal" + i16 + "plugInVersion"), readBundle.getString("pluginVal" + i16 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                hashMap.put(arrayList.get(i17), PlugInBean.class.cast(arrayList2.get(i17)));
            }
        } else {
            av.e("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static String a(int i3, int i16, String str, long j3, long j16, int i17) {
        Throwable th5;
        Process process;
        av.a("start to read logcat.", new Object[0]);
        Process process2 = null;
        if (j3 == -1) {
            av.c("No exception time, exit!", new Object[0]);
            return null;
        }
        String format = new SimpleDateFormat("MM-dd HH:mm:ss.SSS").format(Long.valueOf(j3 - (1000 * j16)));
        av.a("logcat start time: ".concat(String.valueOf(format)), new Object[0]);
        try {
            process = RuntimeMonitor.exec(Runtime.getRuntime(), str == null ? new String[]{"logcat", Argument.DURATION, format, "-v", PerfTracer.THREADTIME_TAG} : new String[]{"logcat", Argument.DURATION, format, "-v", PerfTracer.THREADTIME_TAG, "-s", str});
        } catch (IOException e16) {
            e = e16;
            process = null;
        } catch (Throwable th6) {
            th5 = th6;
        }
        try {
            try {
                String a16 = a(new BufferedReader(new InputStreamReader(process.getInputStream())), i3, i16, i17, (String) null, j3);
                try {
                    process.getOutputStream().close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                try {
                    process.getInputStream().close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                try {
                    process.getErrorStream().close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                return a16;
            } catch (IOException e26) {
                e = e26;
                e.printStackTrace();
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th7) {
            th5 = th7;
            process2 = process;
            if (process2 != null) {
                try {
                    process2.getOutputStream().close();
                } catch (IOException e36) {
                    e36.printStackTrace();
                }
                try {
                    process2.getInputStream().close();
                } catch (IOException e37) {
                    e37.printStackTrace();
                }
                try {
                    process2.getErrorStream().close();
                    throw th5;
                } catch (IOException e38) {
                    e38.printStackTrace();
                    throw th5;
                }
            }
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.String] */
    public static String a(BufferedReader bufferedReader, int i3, int i16, int i17, String str, long j3) {
        String str2;
        Date date = new Date(j3);
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        int i18 = 0;
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (str != null) {
                            if (Pattern.compile(str + "[ ]*:").matcher(readLine).find()) {
                                sb5.append(readLine);
                                sb5.append("\n");
                            }
                        } else {
                            sb5.append(readLine);
                            sb5.append("\n");
                        }
                        if (i3 > 0 && sb5.length() > i3) {
                            Date e16 = e(readLine);
                            if (e16 != null) {
                                if (z16) {
                                    z16 = false;
                                }
                                if (e16.getTime() >= date.getTime() || i18 >= i17) {
                                    break;
                                }
                                sb5.delete(0, i16);
                                i18++;
                            } else {
                                if (z16) {
                                    av.c("Failed to get current date twice, do not get more logcat!", new Object[0]);
                                    break;
                                }
                                z16 = true;
                            }
                        }
                    } else {
                        break;
                    }
                } catch (Throwable th5) {
                    try {
                        sb5.append("\n[error:");
                        sb5.append(th5.toString());
                        sb5.append("]");
                        String sb6 = sb5.toString();
                        bufferedReader.close();
                        str2 = sb6;
                    } catch (Throwable th6) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e17) {
                            av.a(e17);
                        }
                        throw th6;
                    }
                }
            } catch (Exception e18) {
                av.a(e18);
                str2 = i3;
            }
        }
        i3 = sb5.toString();
        bufferedReader.close();
        str2 = i3;
        return str2;
    }

    public static Map<String, String> a(boolean z16, int i3, boolean z17) {
        if (!z16) {
            av.c("get all thread stack not enable", new Object[0]);
            return new HashMap();
        }
        Map<String, String> a16 = a(i3, z17);
        return a16 == null ? new HashMap() : a16;
    }

    private static Map<String, String> a(int i3, boolean z16) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id5 = Thread.currentThread().getId();
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (!z16 || id5 != entry.getKey().getId()) {
                int i16 = 0;
                sb5.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i16 >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = value[i16];
                        if (i3 > 0 && sb5.length() >= i3) {
                            sb5.append("\n[Stack over limit size :" + i3 + " , has been cut!]");
                            break;
                        }
                        sb5.append(stackTraceElement.toString());
                        sb5.append("\n");
                        i16++;
                    }
                    hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb5.toString());
                }
            }
        }
        return hashMap;
    }

    public static String a(Thread thread) {
        if (thread == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        long g16 = ThreadSuspend.c().g(thread);
        StackTraceElement[] stackTrace = thread.getStackTrace();
        ThreadSuspend.c().f(g16);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append(stackTraceElement.toString());
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public static boolean a(Context context, String str) {
        av.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < 10000) {
                    return false;
                }
                av.c("[Util] Lock file (%s) is expired, unlock it.", str);
                b(context, str);
            }
            if (file.createNewFile()) {
                av.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            av.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th5) {
            av.a(th5);
            return false;
        }
    }

    public static String a(File file, int i3) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append("\n");
                    if (i3 > 0 && sb5.length() > i3) {
                        sb5.delete(i3, sb5.length());
                        break;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        av.a(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e16) {
                                av.a(e16);
                            }
                        }
                    }
                }
            }
            String sb6 = sb5.toString();
            try {
                bufferedReader.close();
            } catch (Exception e17) {
                av.a(e17);
            }
            return sb6;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
    }

    public static BufferedReader a(File file) {
        if (file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new FileReader(file));
            } catch (Throwable th5) {
                av.a(th5);
            }
        }
        return null;
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setName(str);
            baseThread.start();
            return baseThread;
        } catch (Throwable th5) {
            av.e("[Util] Failed to start a thread to execute task with message: %s", th5.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        at a16 = at.a();
        if (a16 != null) {
            return a16.a(runnable);
        }
        String[] split = runnable.getClass().getName().split("\\.");
        return a(runnable, split[split.length - 1]) != null;
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static String a(Context context, NativeCrashHandler nativeCrashHandler) {
        nativeCrashHandler.getFd();
        String str = context.getFilesDir().getAbsoluteFile() + "/fd_record_temp.txt";
        String a16 = a(new File(str), 0);
        if (str != null) {
            File file = new File(str);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        }
        return a16;
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            return creator.createFromParcel(obtain);
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                OaidMonitor.parcelRecycle(obtain);
                return null;
            } finally {
                OaidMonitor.parcelRecycle(obtain);
            }
        }
    }
}
