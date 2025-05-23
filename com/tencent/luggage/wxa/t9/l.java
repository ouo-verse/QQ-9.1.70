package com.tencent.luggage.wxa.t9;

import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f141076a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final j f141077b = new b(new a("a", 5));

    /* renamed from: c, reason: collision with root package name */
    public static final j f141078c = new d(new c("f", 5));

    /* renamed from: d, reason: collision with root package name */
    public static final j f141079d = new e(new C6746l("g", 5));

    /* renamed from: e, reason: collision with root package name */
    public static final j f141080e = new f(new C6746l(tl.h.F, 5));

    /* renamed from: f, reason: collision with root package name */
    public static final j f141081f = new g(new C6746l("k", 5));

    /* renamed from: g, reason: collision with root package name */
    public static final j f141082g = new h(new C6746l("brand", 5));

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends j {
        public e(i iVar) {
            super(iVar);
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public String b() {
            if (!l.f141076a) {
                return null;
            }
            try {
                return DeviceInfoMonitor.getString(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.DeviceInfo", th5, "[-] Fail to get android id.", new Object[0]);
                return "";
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends j {

        /* renamed from: b, reason: collision with root package name */
        public final k f141085b;

        public f(i iVar) {
            super(iVar);
            this.f141085b = new k(256);
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public String b() {
            boolean z16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(l.b());
            String a16 = this.f141085b.a(null);
            if (a16 == null) {
                a16 = l.a(false);
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.DeviceInfo", "[!] fail to fetch devId from deprecated cache, using getIMEI instead. value: %s", a16);
                z16 = false;
            } else {
                z16 = true;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfo", "[+] devId: %s, useDeprecatedDevId: %s", a16, Boolean.valueOf(z16));
            if (z16) {
                sb5.append(a16);
            } else if (!TextUtils.isEmpty(a16)) {
                sb5.append((ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + a16 + "123456789ABCDEF").substring(0, 15));
            } else {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                sb5.append(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
                for (int i3 = 0; i3 < 15; i3++) {
                    sb5.append((char) (random.nextInt(25) + 65));
                }
                this.f141085b.b();
            }
            sb5.append(l.d());
            String sb6 = sb5.toString();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfo", "[+] new mmguid, dev:%s", sb6);
            return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + com.tencent.luggage.wxa.y8.c.a(sb6.getBytes()).substring(0, 15);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g extends j {
        public g(i iVar) {
            super(iVar);
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public String b() {
            return DeviceInfoMonitor.getModel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h extends j {
        public h(i iVar) {
            super(iVar);
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public String b() {
            return Build.BRAND;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class k extends i {

        /* renamed from: e, reason: collision with root package name */
        public final com.tencent.luggage.wxa.t9.f f141091e;

        /* renamed from: f, reason: collision with root package name */
        public final int f141092f;

        public k(int i3) {
            super(null);
            this.f141091e = com.tencent.luggage.wxa.t9.f.a();
            this.f141092f = i3;
        }

        @Override // com.tencent.luggage.wxa.t9.l.i
        public String a() {
            String str = (String) this.f141091e.a(this.f141092f);
            if (str == null) {
                this.f141091e.b();
            }
            return str;
        }

        public boolean b() {
            return this.f141091e.b();
        }

        @Override // com.tencent.luggage.wxa.t9.l.i
        public void b(String str) {
            this.f141091e.a(this.f141092f, str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t9.l$l, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6746l extends i {

        /* renamed from: j, reason: collision with root package name */
        public static final Set f141093j = new HashSet();

        /* renamed from: e, reason: collision with root package name */
        public final String f141094e;

        /* renamed from: f, reason: collision with root package name */
        public final int f141095f;

        /* renamed from: g, reason: collision with root package name */
        public final File f141096g;

        /* renamed from: h, reason: collision with root package name */
        public final m f141097h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f141098i;

        public C6746l(String str, int i3) {
            super(null);
            if (str != null && !str.isEmpty()) {
                if (i3 > 0) {
                    Set set = f141093j;
                    if (!set.contains(str)) {
                        set.add(str);
                        String uuid = UUID.nameUUIDFromBytes(str.getBytes(Charset.forName("UTF-8"))).toString();
                        this.f141094e = uuid;
                        this.f141095f = i3;
                        m mVar = new m(str);
                        this.f141097h = mVar;
                        synchronized (this) {
                            try {
                                mVar.a();
                                File file = new File(com.tencent.luggage.wxa.tn.z.c().getFilesDir().getParentFile(), ".auth_cache/" + uuid);
                                this.f141096g = file;
                                if (file.exists()) {
                                    this.f141098i = false;
                                } else {
                                    this.f141098i = true;
                                    if (!file.mkdirs()) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.DeviceInfo", "[-] Fail to make base dir: %s", file.getAbsolutePath());
                                    }
                                }
                                mVar.c();
                            } catch (Throwable th5) {
                                this.f141097h.c();
                                throw th5;
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("name: " + str + " is duplicated.");
                }
                throw new IllegalArgumentException("cacheFileCount is less or equal than zero.");
            }
            throw new IllegalArgumentException("id is null or empty.");
        }

        public void a(boolean z16) {
        }

        public void b() {
        }

        @Override // com.tencent.luggage.wxa.t9.l.i
        public synchronized String a() {
            try {
                this.f141097h.a();
                if (!this.f141096g.exists()) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.DeviceInfo", "[-] Base dir does not exist, base cache will return defValue.");
                    return null;
                }
                int i3 = this.f141095f;
                int i16 = 0;
                for (int i17 = 0; i17 < this.f141095f; i17++) {
                    File file = new File(this.f141096g, String.valueOf(i17));
                    if (file.exists()) {
                        String a16 = a(file);
                        if (a16 != null) {
                            return a16;
                        }
                        i16++;
                    } else {
                        i3--;
                    }
                }
                if (i16 > 0) {
                    a(i16 == i3);
                }
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.DeviceInfo", "[!] Cache missed, base cache will return defValue.");
                return null;
            } catch (Throwable th5) {
                try {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.DeviceInfo", th5, "[-] Exception occurred when fetch value, base cache will return defValue.", new Object[0]);
                    return null;
                } finally {
                    this.f141097h.c();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.t9.l.i
        public synchronized void b(String str) {
            int i3;
            try {
                this.f141097h.a();
                if (!this.f141096g.exists()) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.DeviceInfo", "[-] Base dir does not exist, skip rest logic.");
                    b();
                    return;
                }
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    i3 = this.f141095f;
                    if (i16 >= i3) {
                        break;
                    }
                    File file = new File(this.f141096g, String.valueOf(i16));
                    if (file.isDirectory()) {
                        com.tencent.luggage.wxa.tn.w.f("MicroMsg.DeviceInfo", "[!] Cache file %s is occupied by a directory, try to delete it first.");
                        file.delete();
                    }
                    if (!a(file, str)) {
                        i17++;
                    }
                    i16++;
                }
                if (i17 == i3) {
                    b();
                }
            } finally {
                this.f141097h.c();
            }
        }

        public final String a(File file) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                int lastIndexOf = readLine.lastIndexOf(44);
                if (lastIndexOf < 0) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.DeviceInfo", "[-] Illegal cached data.");
                    return null;
                }
                String substring = readLine.substring(0, lastIndexOf);
                String substring2 = readLine.substring(lastIndexOf + 1);
                CRC32 crc32 = new CRC32();
                crc32.update(substring.getBytes(Charset.forName("UTF-8")));
                if (crc32.getValue() == Long.parseLong(substring2)) {
                    return substring;
                }
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.DeviceInfo", "[-] crc32 of data mismatch.");
                return null;
            } catch (Throwable th6) {
                th = th6;
                try {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.DeviceInfo", th, "[-] Exception occurred when read from cache file.", new Object[0]);
                    return null;
                } finally {
                    w0.a((Closeable) bufferedReader);
                }
            }
        }

        public final boolean a(File file, String str) {
            PrintWriter printWriter = null;
            if (str == null) {
                try {
                    if (!file.exists()) {
                        return true;
                    }
                    new PrintWriter(file).close();
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.DeviceInfo", th, "[-] Exception occurred when store value to file: %s", file.getAbsolutePath());
                        return false;
                    } finally {
                        w0.a((Closeable) printWriter);
                    }
                }
            }
            PrintWriter printWriter2 = new PrintWriter(new FileWriter(file));
            try {
                CRC32 crc32 = new CRC32();
                crc32.update(str.getBytes(Charset.forName("UTF-8")));
                printWriter2.print(str + "," + crc32.getValue());
                w0.a((Closeable) printWriter2);
                return true;
            } catch (Throwable th6) {
                th = th6;
                printWriter = printWriter2;
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.DeviceInfo", th, "[-] Exception occurred when store value to file: %s", file.getAbsolutePath());
                return false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public final String f141099a;

        /* renamed from: b, reason: collision with root package name */
        public volatile LocalServerSocket f141100b = null;

        /* renamed from: c, reason: collision with root package name */
        public volatile int f141101c = 0;

        public m(String str) {
            if (!TextUtils.isEmpty(str)) {
                synchronized (this) {
                    this.f141099a = str;
                }
                return;
            }
            throw new IllegalArgumentException("lockName is null or empty.");
        }

        public synchronized void a() {
            while (!b()) {
                try {
                    LockMethodProxy.sleep(10L);
                } catch (Throwable unused) {
                }
            }
        }

        public synchronized boolean b() {
            if (this.f141100b == null) {
                try {
                    this.f141100b = new LocalServerSocket(this.f141099a);
                    this.f141101c++;
                    return true;
                } catch (Throwable unused) {
                    this.f141100b = null;
                    return false;
                }
            }
            this.f141101c++;
            return true;
        }

        public synchronized void c() {
            if (this.f141101c > 0) {
                this.f141101c--;
            }
            if (this.f141101c == 0 && this.f141100b != null) {
                try {
                    this.f141100b.close();
                } catch (Throwable unused) {
                }
                this.f141100b = null;
            }
        }
    }

    public static String b() {
        return w0.d(f141079d.a());
    }

    public static String c() {
        String a16 = f141082g.a();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfo", "getBrand:" + a16);
        return w0.d(a16);
    }

    public static String d() {
        return w0.d(f141078c.a());
    }

    public static String e() {
        return f();
    }

    public static String f() {
        return w0.d(f141080e.a());
    }

    public static String g() {
        String a16 = f141081f.a();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfo", "getModel:" + a16);
        return w0.d(a16);
    }

    public static String h() {
        return w0.d(v.b());
    }

    public static boolean i() {
        String str = Build.CPU_ABI;
        if (!"arm64-v8a".equalsIgnoreCase(str) && !"x86_64".equalsIgnoreCase(str) && !"mips64".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static String a(boolean z16) {
        String a16 = f141077b.a();
        return !w0.c(a16) ? a16 : z16 ? "1234567890ABCDEF" : "";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class i {

        /* renamed from: a, reason: collision with root package name */
        public boolean f141086a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f141087b;

        /* renamed from: c, reason: collision with root package name */
        public String f141088c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f141089d;

        public i() {
            this.f141086a = false;
            this.f141087b = false;
            this.f141088c = null;
            this.f141089d = new byte[0];
        }

        public abstract String a();

        public String a(String str) {
            synchronized (this.f141089d) {
                if (this.f141086a) {
                    return this.f141088c;
                }
                String a16 = a();
                this.f141088c = a16;
                if (a16 != null) {
                    this.f141086a = true;
                    return a16;
                }
                return str;
            }
        }

        public abstract void b(String str);

        public void c(String str) {
            synchronized (this.f141089d) {
                if (this.f141086a && TextUtils.equals(this.f141088c, str)) {
                    return;
                }
                this.f141088c = str;
                this.f141086a = true;
                this.f141087b = true;
                b(str);
            }
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends C6746l {
        public a(String str, int i3) {
            super(str, i3);
        }

        @Override // com.tencent.luggage.wxa.t9.l.C6746l
        public void b() {
        }

        @Override // com.tencent.luggage.wxa.t9.l.C6746l
        public void a(boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends j {

        /* renamed from: b, reason: collision with root package name */
        public final i f141083b;

        public b(i iVar) {
            super(iVar);
            this.f141083b = new k(258);
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public String b() {
            boolean z16;
            String a16 = this.f141083b.a("1234567890ABCDEF");
            if (!"1234567890ABCDEF".equals(a16)) {
                return a16;
            }
            Context c16 = com.tencent.luggage.wxa.tn.z.c();
            TelephonyManager telephonyManager = (TelephonyManager) c16.getSystemService("phone");
            if (c16.checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.DeviceInfo", "telMgr.getDeviceId fail, no permission");
                return null;
            }
            try {
                String str = (String) com.tencent.luggage.wxa.ia.a.a(telephonyManager, "com/tencent/mm/compatible/deviceinfo/DeviceInfo$2", "newValue", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
                TextUtils.isEmpty(str);
                return str;
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public void c() {
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public void d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends C6746l {
        public c(String str, int i3) {
            super(str, i3);
        }

        @Override // com.tencent.luggage.wxa.t9.l.C6746l
        public void b() {
        }

        @Override // com.tencent.luggage.wxa.t9.l.C6746l
        public void a(boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends j {

        /* renamed from: b, reason: collision with root package name */
        public final i f141084b;

        public d(i iVar) {
            super(iVar);
            this.f141084b = new k(259);
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public String b() {
            String a16 = this.f141084b.a(null);
            if (a16 != null) {
                return a16;
            }
            return Build.MANUFACTURER + l.g() + com.tencent.luggage.wxa.t9.i.c();
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public void c() {
        }

        @Override // com.tencent.luggage.wxa.t9.l.j
        public void d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class j {

        /* renamed from: a, reason: collision with root package name */
        public final i f141090a;

        public j(i iVar) {
            this.f141090a = iVar;
        }

        public final String a() {
            String a16 = this.f141090a.a(null);
            if (!TextUtils.isEmpty(a16)) {
                c();
                return a16;
            }
            d();
            return e();
        }

        public abstract String b();

        public final String e() {
            String b16 = b();
            if (!TextUtils.isEmpty(b16)) {
                this.f141090a.c(b16);
            }
            return b16;
        }

        public void c() {
        }

        public void d() {
        }
    }
}
