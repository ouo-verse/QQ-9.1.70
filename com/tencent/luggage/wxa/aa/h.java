package com.tencent.luggage.wxa.aa;

import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.cso.CsoLoader;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f121008a = new TreeSet();

    /* renamed from: b, reason: collision with root package name */
    public static final List f121009b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f121010c = new HashMap(64);

    /* renamed from: d, reason: collision with root package name */
    public static final b f121011d = new b("load-lib-spin");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f121012e = Pattern.compile("lib([^\\s/]+?)\\.so");

    /* renamed from: f, reason: collision with root package name */
    public static final Method[] f121013f = {null};

    /* renamed from: g, reason: collision with root package name */
    public static final Boolean[] f121014g = {null};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f121015h = {null};

    /* renamed from: i, reason: collision with root package name */
    public static final ThreadLocal f121016i = new ThreadLocal();

    /* renamed from: j, reason: collision with root package name */
    public static final ThreadLocal f121017j = new ThreadLocal();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f121018a;

        /* renamed from: b, reason: collision with root package name */
        public volatile int f121019b = 0;

        /* renamed from: c, reason: collision with root package name */
        public LocalServerSocket f121020c = null;

        public b(String str) {
            this.f121018a = str;
        }

        public synchronized void a() {
            if (this.f121020c != null) {
                this.f121019b++;
                return;
            }
            do {
                try {
                    this.f121020c = new LocalServerSocket(this.f121018a + Process.myUid());
                    this.f121019b = this.f121019b + 1;
                    break;
                } catch (Throwable unused) {
                    try {
                        LockMethodProxy.sleep(1L);
                    } catch (Throwable unused2) {
                    }
                }
            } while (this.f121020c != null);
        }

        public synchronized void b() {
            LocalServerSocket localServerSocket;
            if (this.f121019b == 0) {
                return;
            }
            this.f121019b--;
            if (this.f121019b == 0 && (localServerSocket = this.f121020c) != null) {
                h.b(localServerSocket);
                this.f121020c = null;
            }
        }

        public synchronized void finalize() {
            LocalServerSocket localServerSocket = this.f121020c;
            if (localServerSocket != null) {
                h.b(localServerSocket);
                this.f121020c = null;
            }
            super.finalize();
        }
    }

    public static void b(String str, ClassLoader classLoader) {
        g(str);
    }

    public static String c(String str) {
        return a(str, c.a());
    }

    public static String d(String str) {
        return a(str, c.f121021a);
    }

    public static String e(String str) {
        ArrayList arrayList;
        String f16 = f(str);
        Set set = f121008a;
        synchronized (set) {
            arrayList = new ArrayList(set);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next(), f16);
            if (!file.isDirectory() && file.canRead()) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }

    public static String f(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    public static void g(String str) {
        b(str, c.a());
    }

    public static void h(String str) {
        b(str, c.f121021a);
    }

    public static void i(String str) {
        c.f121021a.b(str);
    }

    public static void a(String str) {
        Set set = f121008a;
        synchronized (set) {
            set.add(str);
            a(2, "MicroMsg.LoadLibrary", "[+] Prior library search path '%s' added.", str);
        }
    }

    public static void b(String str, c cVar) {
        ClassLoader a16 = a();
        Map map = f121010c;
        boolean[] zArr = (boolean[]) map.get(str);
        if (zArr == null) {
            synchronized (map) {
                zArr = (boolean[]) map.get(str);
                if (zArr == null) {
                    zArr = new boolean[]{false};
                    map.put(str, zArr);
                }
            }
        }
        synchronized (zArr) {
            if (!zArr[0]) {
                b(str, a16, cVar);
                zArr[0] = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f121021a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final Object f121022b = new Object();

        /* renamed from: c, reason: collision with root package name */
        public static volatile c f121023c = null;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static class a extends c {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.aa.h.c
            public void a(String str) {
                CsoLoader.loadByName(str);
            }

            @Override // com.tencent.luggage.wxa.aa.h.c
            public String b(String str) {
                String loadByPathForResult = CsoLoader.loadByPathForResult(str);
                if (loadByPathForResult.equals("<skipped>")) {
                    return str;
                }
                return loadByPathForResult;
            }

            @Override // com.tencent.luggage.wxa.aa.h.c
            public String c(String str) {
                String preloadByPath = CsoLoader.preloadByPath(str);
                if (preloadByPath.equals("<skipped>")) {
                    return str;
                }
                return preloadByPath;
            }
        }

        public static void a(c cVar) {
            if (cVar != null) {
                synchronized (f121022b) {
                    f121023c = cVar;
                }
            }
        }

        public abstract void a(String str);

        public abstract String b(String str);

        public abstract String c(String str);

        public static c a() {
            if (f121023c == null) {
                synchronized (f121022b) {
                    if (f121023c == null) {
                        if (!z.n() && com.tencent.luggage.wxa.tn.e.f141570l) {
                            f121023c = new a();
                        }
                        f121023c = f121021a;
                    }
                }
            }
            return f121023c;
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static class b extends c {
            public b() {
            }

            @Override // com.tencent.luggage.wxa.aa.h.c
            public void a(String str) {
                System.loadLibrary(str);
            }

            @Override // com.tencent.luggage.wxa.aa.h.c
            public String b(String str) {
                System.load(str);
                return str;
            }

            @Override // com.tencent.luggage.wxa.aa.h.c
            public String c(String str) {
                return str;
            }
        }
    }

    public static void a(String str, String str2, ClassLoader classLoader) {
        List list = f121009b;
        synchronized (list) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                com.tencent.luggage.wxa.k0.d.a(it.next());
                throw null;
            }
        }
    }

    public static void a(String str, UnsatisfiedLinkError unsatisfiedLinkError) {
        List list = f121009b;
        synchronized (list) {
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                throw unsatisfiedLinkError;
            }
            com.tencent.luggage.wxa.k0.d.a(it.next());
            throw null;
        }
    }

    public static boolean b(String str) {
        boolean z16;
        Map map = f121010c;
        boolean[] zArr = (boolean[]) map.get(str);
        if (zArr == null) {
            synchronized (map) {
                zArr = (boolean[]) map.get(str);
                if (zArr == null) {
                    return false;
                }
            }
        }
        synchronized (zArr) {
            z16 = zArr[0];
        }
        return z16;
    }

    public static String a(String str, c cVar) {
        String e16 = e(str);
        if (e16 != null) {
            String c16 = cVar.c(e16);
            a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", str, c16);
            return c16;
        }
        String a16 = a(str, a());
        if (a16 != null) {
            String c17 = cVar.c(a16);
            a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", str, c17);
            return c17;
        }
        String a17 = a(z.c(), str);
        if (a17 != null) {
            String c18 = cVar.c(a17);
            a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", str, c18);
            return c18;
        }
        a(4, "MicroMsg.LoadLibrary", "[-] Fail to find library [%s].", a17);
        return null;
    }

    public static void b(String str, ClassLoader classLoader, c cVar) {
        String e16 = e(str);
        if (e16 != null) {
            try {
                a(2, "MicroMsg.LoadLibrary", "[+] Library [%s] was loaded, path: %s, origin: %s", str, cVar.b(e16), e16);
                a(str, e16, classLoader);
                return;
            } catch (UnsatisfiedLinkError e17) {
                a(50L);
                try {
                    a(2, "MicroMsg.LoadLibrary", "[+] [RE] Library [%s] was loaded, path: %s, origin: %s", str, cVar.b(e16), e16);
                } catch (UnsatisfiedLinkError unused) {
                    if (e.a()) {
                        a(2, "MicroMsg.LoadLibrary", "[+] Try to load library with expansions", new Object[0]);
                        try {
                            if (e.b(str)) {
                                return;
                            }
                        } catch (Throwable unused2) {
                            a("MicroMsg.LoadLibrary", e17, "[-] Fail to load library with expansions", new Object[0]);
                        }
                    } else {
                        w.a("MicroMsg.LoadLibrary", e17, " [-] Fail to load library", new Object[0]);
                    }
                }
                a(str, e16, classLoader);
                return;
            }
        }
        a(2, "MicroMsg.LoadLibrary", "[+] Try to load library [%s] with cl: %s", str, classLoader);
        String a16 = a(str, classLoader);
        if (a16 != null) {
            try {
                a(2, "MicroMsg.LoadLibrary", "[+] Library [%s] was loaded, path: %s, origin: %s", str, cVar.b(a16), a16);
                a(str, a16, classLoader);
                return;
            } catch (UnsatisfiedLinkError unused3) {
                a(5L);
                try {
                    a(2, "MicroMsg.LoadLibrary", "[+] [RE] Library [%s] was loaded, path: %s, origin: %s", str, cVar.b(a16), a16);
                    a(str, a16, classLoader);
                    return;
                } catch (UnsatisfiedLinkError unused4) {
                }
            }
        } else {
            a(4, "MicroMsg.LoadLibrary", "[-] Fail to find library path", new Object[0]);
        }
        a(2, "MicroMsg.LoadLibrary", "[=] Try to load library with other ways", new Object[0]);
        a(2, "MicroMsg.LoadLibrary", "[+] Try to load with usual System API", new Object[0]);
        try {
            cVar.a(str);
        } catch (Throwable th5) {
            a("MicroMsg.LoadLibrary", th5, "[-] Fail to load with usual System API", new Object[0]);
            if (e.a()) {
                a(2, "MicroMsg.LoadLibrary", "[+] Try to load library with expansions", new Object[0]);
                try {
                    if (e.b(str)) {
                        return;
                    }
                } catch (Throwable th6) {
                    a("MicroMsg.LoadLibrary", th6, "[-] Fail to load library with expansions", new Object[0]);
                }
            }
            a(str, classLoader, cVar);
        }
    }

    public static void a(String str, ClassLoader classLoader, c cVar) {
        b bVar;
        String a16;
        b bVar2 = f121011d;
        synchronized (bVar2) {
            try {
                try {
                    try {
                        try {
                            bVar2.a();
                            Context c16 = z.c();
                            a(c16, f(str), a(c16));
                            a16 = a(z.c(), str);
                        } finally {
                            bVar.b();
                        }
                    } catch (UnsatisfiedLinkError e16) {
                        a(str, e16);
                        bVar = f121011d;
                        bVar.b();
                    }
                    if (a16 != null) {
                        try {
                            a(2, "MicroMsg.LoadLibrary", "[+] Library [%s] was loaded, path: %s, origin: %s", str, cVar.b(a16), a16);
                            a(str, a16, classLoader);
                        } catch (UnsatisfiedLinkError unused) {
                            try {
                                a(5L);
                                a(2, "MicroMsg.LoadLibrary", "[+] [RE] Library [%s] was loaded, path: %s, origin: %s", str, cVar.b(a16), a16);
                                a(str, a16, classLoader);
                            } catch (UnsatisfiedLinkError e17) {
                                a("MicroMsg.LoadLibrary", e17, "[-] [RE] Failure, try to recovery depend lib recursively.", new Object[0]);
                                String a17 = a(e17);
                                if (a17 != null && !a17.equals(str)) {
                                    a(a17, classLoader, cVar);
                                    a(2, "MicroMsg.LoadLibrary", "[+] [RE] Library [%s] was loaded, path: %s, origin: %s", str, cVar.b(a16), a16);
                                    a(str, a16, classLoader);
                                } else {
                                    throw e17;
                                }
                            }
                        }
                        bVar = f121011d;
                        bVar.b();
                    } else {
                        throw new UnsatisfiedLinkError("Cannot find [" + str + "] in recovery dir.");
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (Throwable th6) {
                f121011d.b();
            }
        }
    }

    public static boolean b() {
        boolean booleanValue;
        Boolean[] boolArr = f121014g;
        synchronized (boolArr) {
            Boolean bool = boolArr[0];
            if (bool == null) {
                bool = Boolean.valueOf(Process.is64Bit());
                boolArr[0] = bool;
            }
            booleanValue = bool.booleanValue();
        }
        return booleanValue;
    }

    public static String b(Context context, String str) {
        String str2;
        ZipFile zipFile;
        String[] strArr = f121015h;
        synchronized (strArr) {
            String str3 = strArr[0];
            if (str3 == null) {
                String[] strArr2 = b() ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS;
                str2 = null;
                try {
                    try {
                        zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                        try {
                            int length = strArr2.length;
                            int i3 = 0;
                            String str4 = null;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                String str5 = strArr2[i3];
                                String str6 = "lib/" + str5 + "/" + str;
                                if (zipFile.getEntry(str6) != null) {
                                    str3 = str5;
                                    str4 = str6;
                                    break;
                                }
                                i3++;
                                str4 = str6;
                            }
                            if (str3 == null) {
                                a(4, "MicroMsg.LoadLibrary", "[-] ", new Object[0]);
                            } else {
                                str2 = str4;
                            }
                            b(zipFile);
                            f121015h[0] = str3;
                        } catch (IOException e16) {
                            e = e16;
                            throw new IllegalStateException(e);
                        } catch (Throwable th5) {
                            th = th5;
                            b(zipFile);
                            throw th;
                        }
                    } catch (IOException e17) {
                        e = e17;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    zipFile = null;
                }
            } else {
                str2 = "lib/" + str3 + "/" + str;
            }
        }
        return str2;
    }

    public static String a(UnsatisfiedLinkError unsatisfiedLinkError) {
        String message = unsatisfiedLinkError.getMessage();
        if (TextUtils.isEmpty(message)) {
            return null;
        }
        Matcher matcher = f121012e.matcher(message);
        if (!matcher.find()) {
            return null;
        }
        String group = matcher.group(1);
        if (TextUtils.isEmpty(group)) {
            return null;
        }
        return group;
    }

    public static ClassLoader a() {
        return h.class.getClassLoader();
    }

    public static String a(String str, ClassLoader classLoader) {
        Method[] methodArr = f121013f;
        Method method = methodArr[0];
        if (method == null) {
            synchronized (methodArr) {
                method = methodArr[0];
                if (method == null) {
                    try {
                        method = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                        method.setAccessible(true);
                        methodArr[0] = method;
                    } catch (Throwable th5) {
                        a("MicroMsg.LoadLibrary", th5, "[-] Fail to reflect findLibrary method: " + classLoader, new Object[0]);
                        return null;
                    }
                }
            }
        }
        try {
            return (String) method.invoke(classLoader, str);
        } catch (Throwable th6) {
            a("MicroMsg.LoadLibrary", th6, "[-] Fail to find library in classloader: " + classLoader, new Object[0]);
            return null;
        }
    }

    public static void b(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
                return;
            }
            if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
                return;
            }
            if (obj instanceof ZipFile) {
                ((ZipFile) obj).close();
            } else {
                if (obj instanceof LocalServerSocket) {
                    ((LocalServerSocket) obj).close();
                    return;
                }
                throw new IllegalStateException(obj.getClass().getName() + " is not closeable.");
            }
        } catch (IllegalStateException e16) {
            throw e16;
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, String str) {
        b bVar = f121011d;
        synchronized (bVar) {
            try {
                bVar.a();
                File file = new File(a(context), f(str));
                if (file.isDirectory() || !file.canRead()) {
                    bVar.b();
                    return null;
                }
                String absolutePath = file.getAbsolutePath();
                bVar.b();
                return absolutePath;
            } catch (Throwable th5) {
                f121011d.b();
                throw th5;
            }
        }
    }

    public static File a(Context context) {
        return context.getDir("recovery_lib", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.OutputStream, java.lang.Object, java.io.BufferedOutputStream] */
    public static void a(Context context, String str, File file) {
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String b16 = b(context, str);
            if (b16 != null) {
                ZipEntry entry = zipFile.getEntry(b16);
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    a(3, "MicroMsg.LoadLibrary", "[!] Path %s is a directory, remove it first.", file2.getAbsolutePath());
                    file2.delete();
                } else if (file2.canRead() && a(file2) == entry.getCrc()) {
                    a(3, "MicroMsg.LoadLibrary", "[!] CRC check of [%s] in recovery dir was passed, skip extracting.", str);
                    b(zipFile);
                    return;
                }
                File file3 = new File(file2.getAbsolutePath() + ".tmp");
                try {
                    ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                    try {
                        bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                            }
                            b((Object) bufferedOutputStream);
                            b(bufferedInputStream);
                            if (file3.renameTo(file2)) {
                                b(zipFile);
                                return;
                            }
                            throw new IOException("Cannot rename " + file3.getAbsolutePath() + " to " + file2.getAbsolutePath());
                        } catch (Throwable th6) {
                            th = th6;
                            zipFile2 = bufferedOutputStream;
                            try {
                                file3.delete();
                                throw th;
                            } catch (Throwable th7) {
                                b(zipFile2);
                                b(bufferedInputStream);
                                throw th7;
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        bufferedInputStream = null;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    bufferedInputStream = null;
                }
            } else {
                throw new FileNotFoundException("Cannot find " + str + " in apk with best ABI.");
            }
        } catch (Throwable th10) {
            th = th10;
            zipFile2 = zipFile;
            b(zipFile2);
            throw th;
        }
    }

    public static long a(File file) {
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[4096];
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream2.read(bArr);
                    if (read > 0) {
                        crc32.update(bArr, 0, read);
                    } else {
                        long value = crc32.getValue();
                        b(bufferedInputStream2);
                        return value;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    b(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void a(int i3, String str, String str2, Object... objArr) {
        ThreadLocal threadLocal = f121016i;
        Boolean bool = (Boolean) threadLocal.get();
        if (bool != null && bool.booleanValue()) {
            if (objArr != null && objArr.length != 0) {
                Log.println(i3, str, String.format(str2, objArr));
                return;
            } else {
                Log.println(i3, str, str2);
                return;
            }
        }
        threadLocal.set(Boolean.TRUE);
        if (i3 == 0) {
            w.g(str, str2, objArr);
        } else if (i3 == 1) {
            w.a(str, str2, objArr);
        } else if (i3 == 2) {
            w.d(str, str2, objArr);
        } else if (i3 == 3) {
            w.h(str, str2, objArr);
        } else if (i3 == 4) {
            w.b(str, str2, objArr);
        }
        threadLocal.set(Boolean.FALSE);
    }

    public static void a(String str, Throwable th5, String str2, Object... objArr) {
        ThreadLocal threadLocal = f121017j;
        Boolean bool = (Boolean) threadLocal.get();
        if (bool != null && bool.booleanValue()) {
            if (objArr != null && objArr.length != 0) {
                Log.e(str, String.format(str2, objArr), th5);
                return;
            } else {
                Log.e(str, str2, th5);
                return;
            }
        }
        threadLocal.set(Boolean.TRUE);
        w.a(str, th5, str2, objArr);
        threadLocal.set(Boolean.FALSE);
    }

    public static void a(long j3) {
        try {
            LockMethodProxy.sleep(j3);
        } catch (Throwable unused) {
        }
    }
}
