package com.tencent.beacon.base.util;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.beacon.a.b.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f77783a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f77784b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f77785c;

    /* renamed from: d, reason: collision with root package name */
    private static final SimpleDateFormat f77786d;

    static {
        Locale locale = Locale.US;
        f77785c = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, locale);
        f77786d = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, locale);
    }

    public static boolean a(long j3, long j16) {
        SimpleDateFormat simpleDateFormat = f77785c;
        return simpleDateFormat.format(Long.valueOf(j3)).equals(simpleDateFormat.format(Long.valueOf(j16)));
    }

    public static byte[] b(byte[] bArr, int i3, String str) {
        if (bArr == null || bArr.length <= 0 || i3 == -1) {
            return bArr;
        }
        try {
            return com.tencent.beacon.base.net.b.c.a(i3, str, bArr);
        } catch (Throwable th5) {
            c.e("data length: " + bArr.length + ",type:" + i3 + ",key: " + str + ",error: " + th5.getMessage(), new Object[0]);
            i e16 = i.e();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("data length: ");
            sb5.append(bArr.length);
            sb5.append(",type:");
            sb5.append(i3);
            sb5.append(",key: ");
            sb5.append(str);
            e16.a("508", sb5.toString(), th5);
            return null;
        }
    }

    public static long c() {
        return new Date().getTime() + com.tencent.beacon.a.c.c.c().j();
    }

    public static String d() {
        try {
            return f77786d.format(new Date());
        } catch (Throwable th5) {
            c.a(th5);
            return "";
        }
    }

    public static byte[] a(Object obj) {
        ObjectOutputStream objectOutputStream;
        if (!(obj instanceof Serializable)) {
            c.b("not serial obj ", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th5) {
            th = th5;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(objectOutputStream);
            a(byteArrayOutputStream);
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                c.a(th);
                c.b(th.getMessage(), new Object[0]);
                i.e().a("520", th.getMessage(), th);
                a(objectOutputStream);
                a(byteArrayOutputStream);
                return null;
            } catch (Throwable th7) {
                a(objectOutputStream);
                a(byteArrayOutputStream);
                throw th7;
            }
        }
    }

    public static String c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes(Charset.forName("UTF-8")));
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (i3 < 16) {
                    sb5.append(0);
                }
                sb5.append(Integer.toHexString(i3));
            }
            return sb5.toString();
        } catch (Exception e16) {
            c.a(e16);
            return str;
        }
    }

    public static byte[] b(byte[] bArr, int i3) {
        if (bArr == null || i3 == -1) {
            return bArr;
        }
        c.a("zp: %s len: %s", Integer.valueOf(i3), Integer.valueOf(bArr.length));
        try {
            return com.tencent.beacon.base.net.b.a.a(i3, bArr);
        } catch (Throwable th5) {
            i.e().a("509", "zipData length: " + bArr.length + ",type:" + i3, th5);
            c.a(th5);
            c.b("err zp : %s", th5.toString());
            return null;
        }
    }

    private static String c(int i3) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i16 = 0; i16 < i3; i16++) {
            stringBuffer.append("abcdef0123456789".charAt(random.nextInt(16)));
        }
        return stringBuffer.toString();
    }

    public static byte[] b(byte[] bArr, int i3, int i16, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(b(bArr, i3), i16, str);
        } catch (Throwable th5) {
            c.a(th5);
            return null;
        }
    }

    public static String b(String str) {
        String c16 = c(str);
        if (c16 == null) {
            return c16;
        }
        try {
            return c16.substring(8, 24);
        } catch (Exception e16) {
            c.a(e16);
            return c16;
        }
    }

    public static Object a(byte[] bArr) {
        Throwable th5;
        ObjectInputStream objectInputStream;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (Throwable th6) {
            th5 = th6;
            objectInputStream = null;
        }
        try {
            Object readObject = objectInputStream.readObject();
            a(objectInputStream);
            a(byteArrayInputStream);
            return readObject;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                c.a(th5);
                c.b(th5.getMessage(), new Object[0]);
                i.e().a("520", th5.getMessage(), th5);
                a(objectInputStream);
                a(byteArrayInputStream);
                return null;
            } catch (Throwable th8) {
                a(objectInputStream);
                a(byteArrayInputStream);
                throw th8;
            }
        }
    }

    public static String b() {
        com.tencent.beacon.a.c.c c16 = com.tencent.beacon.a.c.c.c();
        return b((c16 != null ? c16.e() : "") + "_" + com.tencent.beacon.a.c.e.l().d() + "_" + new Date().getTime() + "_" + (f77783a.nextInt(2147473647) + 1000));
    }

    public static boolean b(int i3) {
        if (com.tencent.beacon.a.c.c.c().b() == null) {
            return false;
        }
        String d16 = com.tencent.beacon.a.c.e.l().d();
        return !TextUtils.isEmpty(d16) && ((double) Math.abs(d16.hashCode() % 10000)) < ((double) i3) * 1.0d;
    }

    public static byte[] a(byte[] bArr, int i3, String str) {
        if (bArr == null || i3 == -1) {
            return bArr;
        }
        c.a("CoreUtils", "encry data length:%d type: %d", Integer.valueOf(bArr.length), Integer.valueOf(i3));
        try {
            return com.tencent.beacon.base.net.b.c.b(i3, str, bArr);
        } catch (Throwable th5) {
            c.a(th5);
            i.e().a("507", "data length: " + bArr.length + ",type:" + i3 + ",key: " + str, th5);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i3) {
        if (bArr == null || i3 == -1) {
            return bArr;
        }
        c.a("unzp: %s len: %s", Integer.valueOf(i3), Integer.valueOf(bArr.length));
        try {
            return com.tencent.beacon.base.net.b.a.b(i3, bArr);
        } catch (Throwable th5) {
            i.e().a("509", "unzipData length: " + bArr.length + ",type:" + i3, th5);
            c.a(th5);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("err unzp}");
            sb5.append(th5.toString());
            c.b(sb5.toString(), new Object[0]);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i3, int i16, String str) {
        try {
            return a(b(bArr, i16, str), i3);
        } catch (Exception e16) {
            c.a(e16);
            return null;
        }
    }

    public static ArrayList<String> a(String[] strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charset.forName("UTF-8")));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader2 = null;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream(), Charset.forName("UTF-8")));
            while (true) {
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        a(bufferedReader);
                        a(bufferedReader2);
                        return arrayList;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        c.a(th);
                        a(bufferedReader);
                        a(bufferedReader2);
                        return null;
                    } catch (Throwable th7) {
                        a(bufferedReader);
                        a(bufferedReader2);
                        throw th7;
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    public static HashSet<String> a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>(arrayList.size());
        hashSet.addAll(arrayList);
        return hashSet;
    }

    public static int a(String str, int i3, int i16, int i17) {
        int i18;
        if (str == null) {
            return i3;
        }
        try {
            i18 = Integer.parseInt(str);
        } catch (Exception e16) {
            c.a(e16);
            i18 = i3;
        }
        return (i18 < i16 || i18 > i17) ? i3 : i18;
    }

    public static long a(String str, long j3, long j16, long j17) {
        long j18;
        if (str == null) {
            return j3;
        }
        try {
            j18 = Long.parseLong(str);
        } catch (Exception e16) {
            c.a(e16);
            j18 = j3;
        }
        return (j18 < j16 || j18 > j17) ? j3 : j18;
    }

    public static boolean a(String str, boolean z16) {
        if (str == null) {
            return z16;
        }
        if (str.toLowerCase().equals("y")) {
            return true;
        }
        if (str.toLowerCase().equals(DomainData.DOMAIN_NAME)) {
            return false;
        }
        return z16;
    }

    public static boolean a(String str) {
        return str.startsWith("rqd_");
    }

    public static String a(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        String replace = (th5.getMessage() + "\n" + stringWriter.getBuffer().toString()).replace("\t", " ").replace("\n", " ").replace("$", "-");
        return replace.length() > 10240 ? replace.substring(0, 10240) : replace;
    }

    public static void a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e16) {
                    c.a(e16);
                }
            }
        }
    }

    public static int a(int i3) {
        return f77783a.nextInt(i3);
    }

    public static boolean a(SharedPreferences.Editor editor) {
        if (editor != null) {
            return true;
        }
        c.b("BeaconProperties editor is null!", new Object[0]);
        return false;
    }

    public static String a() {
        return c(16);
    }
}
