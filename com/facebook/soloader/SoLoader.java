package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes2.dex */
public class SoLoader {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    static j f32786b;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("sSoSourcesLock")
    @Nullable
    private static UnpackingSoSource[] f32790f;

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("sSoSourcesLock")
    @Nullable
    private static c f32791g;

    /* renamed from: k, reason: collision with root package name */
    @GuardedBy("sSoSourcesLock")
    private static int f32795k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f32796l;

    /* renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock f32787c = new ReentrantReadWriteLock();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("sSoSourcesLock")
    @Nullable
    private static k[] f32788d = null;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("sSoSourcesLock")
    private static volatile int f32789e = 0;

    /* renamed from: h, reason: collision with root package name */
    @GuardedBy("SoLoader.class")
    private static final HashSet<String> f32792h = new HashSet<>();

    /* renamed from: i, reason: collision with root package name */
    @GuardedBy("SoLoader.class")
    private static final Map<String, Object> f32793i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private static final Set<String> f32794j = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: a, reason: collision with root package name */
    static final boolean f32785a = true;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th5, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(l.h()) + " error: " + str);
            initCause(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f32797a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32798b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32799c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runtime f32800d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Method f32801e;

        a(boolean z16, String str, String str2, Runtime runtime, Method method) {
            this.f32797a = z16;
            this.f32798b = str;
            this.f32799c = str2;
            this.f32800d = runtime;
            this.f32801e = method;
        }

        private String b(String str) {
            try {
                File file = new File(str);
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            String format = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                            fileInputStream.close();
                            return format;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th7) {
                            th5.addSuppressed(th7);
                        }
                        throw th6;
                    }
                }
            } catch (IOException e16) {
                return e16.toString();
            } catch (SecurityException e17) {
                return e17.toString();
            } catch (NoSuchAlgorithmException e18) {
                return e18.toString();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        
            if (r1 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        
            android.util.Log.e("SoLoader", "Error when loading lib: " + r1 + " lib hash: " + b(r9) + " search path is " + r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        
            return;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2 */
        @Override // com.facebook.soloader.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(String str, int i3) {
            boolean z16;
            String str2;
            Throwable th5;
            Throwable e16;
            if (this.f32797a) {
                String str3 = 1;
                if ((i3 & 4) == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    str2 = this.f32798b;
                } else {
                    str2 = this.f32799c;
                }
                try {
                    try {
                        try {
                            synchronized (this.f32800d) {
                                try {
                                    String str4 = (String) this.f32801e.invoke(this.f32800d, str, SoLoader.class.getClassLoader(), str2);
                                    if (str4 != null) {
                                        throw new UnsatisfiedLinkError(str4);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (IllegalAccessException e17) {
                        e = e17;
                        e16 = e;
                        throw new RuntimeException("Error: Cannot load " + str, e16);
                    } catch (IllegalArgumentException e18) {
                        e = e18;
                        e16 = e;
                        throw new RuntimeException("Error: Cannot load " + str, e16);
                    } catch (InvocationTargetException e19) {
                        e = e19;
                        e16 = e;
                        throw new RuntimeException("Error: Cannot load " + str, e16);
                    } catch (Throwable th8) {
                        str3 = 0;
                        th5 = th8;
                        if (str3 != 0) {
                        }
                        throw th5;
                    }
                    try {
                        throw th;
                    } catch (IllegalAccessException e26) {
                        e16 = e26;
                        throw new RuntimeException("Error: Cannot load " + str, e16);
                    } catch (IllegalArgumentException e27) {
                        e16 = e27;
                        throw new RuntimeException("Error: Cannot load " + str, e16);
                    } catch (InvocationTargetException e28) {
                        e16 = e28;
                        throw new RuntimeException("Error: Cannot load " + str, e16);
                    }
                } catch (Throwable th9) {
                    th5 = th9;
                    if (str3 != 0) {
                        Log.e("SoLoader", "Error when loading lib: " + str3 + " lib hash: " + b(str) + " search path is " + str2);
                    }
                    throw th5;
                }
            }
            System.load(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @DoNotOptimize
    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class b {
        public static String a() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader != null && !(classLoader instanceof BaseDexClassLoader)) {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
            try {
                return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
            } catch (Exception e16) {
                throw new RuntimeException("Cannot call getLdLibraryPath", e16);
            }
        }
    }

    private static void a() {
        if (j()) {
        } else {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    private static boolean b(Context context, int i3) {
        if ((i3 & 32) != 0 || context == null || (context.getApplicationInfo().flags & 129) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(String str, int i3, @Nullable StrictMode.ThreadPolicy threadPolicy) throws UnsatisfiedLinkError {
        boolean z16;
        String message;
        int i16;
        ReentrantReadWriteLock reentrantReadWriteLock;
        ReentrantReadWriteLock reentrantReadWriteLock2 = f32787c;
        reentrantReadWriteLock2.readLock().lock();
        try {
            if (f32788d != null) {
                reentrantReadWriteLock2.readLock().unlock();
                int i17 = 0;
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (f32785a) {
                    com.facebook.soloader.a.a("SoLoader.loadLibrary[", str, "]");
                }
                try {
                    reentrantReadWriteLock2.readLock().lock();
                    i16 = 0;
                    int i18 = 0;
                    while (i16 == 0) {
                        try {
                            k[] kVarArr = f32788d;
                            if (i18 < kVarArr.length) {
                                i16 = kVarArr[i18].a(str, i3, threadPolicy);
                                if (i16 == 3 && f32790f != null) {
                                    Log.d("SoLoader", "Trying backup SoSource for " + str);
                                    UnpackingSoSource[] unpackingSoSourceArr = f32790f;
                                    int length = unpackingSoSourceArr.length;
                                    for (int i19 = 0; i19 < length; i19++) {
                                        UnpackingSoSource unpackingSoSource = unpackingSoSourceArr[i19];
                                        unpackingSoSource.n(str);
                                        int a16 = unpackingSoSource.a(str, i3, threadPolicy);
                                        if (a16 == 1) {
                                            i16 = a16;
                                            break;
                                        }
                                    }
                                } else {
                                    i18++;
                                }
                            }
                        } catch (Throwable th5) {
                            i17 = i16;
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (f32785a) {
                    }
                    if (z16) {
                    }
                    if (i17 == 0) {
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("couldn't find DSO to load: ");
                    sb5.append(str);
                    message = th.getMessage();
                    if (message == null) {
                    }
                    sb5.append(" caused by: ");
                    sb5.append(message);
                    th.printStackTrace();
                    sb5.append(" result: ");
                    sb5.append(i17);
                    String sb6 = sb5.toString();
                    Log.e("SoLoader", sb6);
                    UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(sb6);
                    unsatisfiedLinkError.initCause(th);
                    throw unsatisfiedLinkError;
                }
                try {
                    if (f32785a) {
                        com.facebook.soloader.a.b();
                    }
                    if (z16) {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                    if (i16 == 0 || i16 == 3) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("couldn't find DSO to load: ");
                        sb7.append(str);
                        reentrantReadWriteLock.readLock().lock();
                        while (i17 < f32788d.length) {
                            sb7.append("\n\tSoSource ");
                            sb7.append(i17);
                            sb7.append(MsgSummary.STR_COLON);
                            sb7.append(f32788d[i17].toString());
                            i17++;
                        }
                        c cVar = f32791g;
                        if (cVar != null) {
                            File d16 = c.d(cVar.e());
                            sb7.append("\n\tNative lib dir: ");
                            sb7.append(d16.getAbsolutePath());
                            sb7.append("\n");
                        }
                        f32787c.readLock().unlock();
                        sb7.append(" result: ");
                        sb7.append(i16);
                        String sb8 = sb7.toString();
                        Log.e("SoLoader", sb8);
                        throw new UnsatisfiedLinkError(sb8);
                    }
                    return;
                } catch (Throwable th7) {
                    th = th7;
                    i17 = i16;
                    if (f32785a) {
                        com.facebook.soloader.a.b();
                    }
                    if (z16) {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                    if (i17 == 0 && i17 != 3) {
                        return;
                    }
                    StringBuilder sb52 = new StringBuilder();
                    sb52.append("couldn't find DSO to load: ");
                    sb52.append(str);
                    message = th.getMessage();
                    if (message == null) {
                        message = th.toString();
                    }
                    sb52.append(" caused by: ");
                    sb52.append(message);
                    th.printStackTrace();
                    sb52.append(" result: ");
                    sb52.append(i17);
                    String sb62 = sb52.toString();
                    Log.e("SoLoader", sb62);
                    UnsatisfiedLinkError unsatisfiedLinkError2 = new UnsatisfiedLinkError(sb62);
                    unsatisfiedLinkError2.initCause(th);
                    throw unsatisfiedLinkError2;
                }
            }
            Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
            throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
        } finally {
            f32787c.readLock().unlock();
        }
    }

    @Nullable
    private static Method d() {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException | SecurityException e16) {
            Log.w("SoLoader", "Cannot get nativeLoad method", e16);
            return null;
        }
    }

    public static void e(Context context, int i3) throws IOException {
        f(context, i3, null);
    }

    public static void f(Context context, int i3, @Nullable j jVar) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            f32796l = b(context, i3);
            h(jVar);
            i(context, i3, jVar);
            s0.a.b(new i());
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void g(Context context, boolean z16) {
        int i3;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        try {
            e(context, i3);
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    private static synchronized void h(@Nullable j jVar) {
        boolean z16;
        String str;
        synchronized (SoLoader.class) {
            if (jVar != null) {
                f32786b = jVar;
                return;
            }
            Runtime runtime = Runtime.getRuntime();
            Method d16 = d();
            if (d16 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            if (z17) {
                str = b.a();
            } else {
                str = null;
            }
            String str2 = str;
            f32786b = new a(z17, str2, p(str2), runtime, d16);
        }
    }

    private static void i(Context context, int i3, @Nullable j jVar) throws IOException {
        int i16;
        f32787c.writeLock().lock();
        try {
            if (f32788d == null) {
                Log.d("SoLoader", "init start");
                f32795k = i3;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    if (l.i()) {
                        str = "/vendor/lib64:/system/lib64";
                    } else {
                        str = "/vendor/lib:/system/lib";
                    }
                }
                for (String str2 : str.split(":")) {
                    Log.d("SoLoader", "adding system library source: " + str2);
                    arrayList.add(new d(new File(str2), 2));
                }
                if (context != null) {
                    if ((i3 & 1) != 0) {
                        f32790f = null;
                        Log.d("SoLoader", "adding exo package source: lib-main");
                        arrayList.add(0, new e(context, "lib-main"));
                    } else {
                        if (f32796l) {
                            i16 = 0;
                        } else {
                            f32791g = new c(context, 0);
                            Log.d("SoLoader", "adding application source: " + f32791g.toString());
                            arrayList.add(0, f32791g);
                            i16 = 1;
                        }
                        if ((f32795k & 8) != 0) {
                            f32790f = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            com.facebook.soloader.b bVar = new com.facebook.soloader.b(context, file, "lib-main", i16);
                            arrayList2.add(bVar);
                            Log.d("SoLoader", "adding backup source from : " + bVar.toString());
                            if (context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d("SoLoader", "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i17 = 0;
                                int i18 = 0;
                                while (i17 < length) {
                                    File file2 = new File(strArr[i17]);
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("lib-");
                                    sb5.append(i18);
                                    com.facebook.soloader.b bVar2 = new com.facebook.soloader.b(context, file2, sb5.toString(), i16);
                                    Log.d("SoLoader", "adding backup source: " + bVar2.toString());
                                    arrayList2.add(bVar2);
                                    i17++;
                                    i18++;
                                }
                            }
                            f32790f = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                k[] kVarArr = (k[]) arrayList.toArray(new k[arrayList.size()]);
                int q16 = q();
                int length2 = kVarArr.length;
                while (true) {
                    int i19 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    Log.d("SoLoader", "Preparing SO source: " + kVarArr[i19]);
                    kVarArr[i19].b(q16);
                    length2 = i19;
                }
                f32788d = kVarArr;
                f32789e++;
                Log.d("SoLoader", "init finish: " + f32788d.length + " SO sources prepared");
            }
        } finally {
            Log.d("SoLoader", "init exiting");
            f32787c.writeLock().unlock();
        }
    }

    public static boolean j() {
        boolean z16;
        ReentrantReadWriteLock reentrantReadWriteLock = f32787c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f32788d != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            reentrantReadWriteLock.readLock().unlock();
            return z16;
        } catch (Throwable th5) {
            f32787c.readLock().unlock();
            throw th5;
        }
    }

    public static boolean k(String str) {
        return l(str, 0);
    }

    public static boolean l(String str, int i3) throws UnsatisfiedLinkError {
        String str2;
        boolean z16;
        ReentrantReadWriteLock reentrantReadWriteLock = f32787c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f32788d == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    a();
                } else {
                    synchronized (SoLoader.class) {
                        z16 = !f32792h.contains(str);
                        if (z16) {
                            System.loadLibrary(str);
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return z16;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            boolean z17 = f32796l;
            String b16 = h.b(str);
            if (b16 != null) {
                str2 = b16;
            } else {
                str2 = str;
            }
            return n(System.mapLibraryName(str2), str, b16, i3, null);
        } catch (Throwable th5) {
            f32787c.readLock().unlock();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(String str, int i3, StrictMode.ThreadPolicy threadPolicy) {
        o(str, null, null, i3, threadPolicy);
    }

    private static boolean n(String str, @Nullable String str2, @Nullable String str3, int i3, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z16;
        boolean z17 = false;
        do {
            try {
                z17 = o(str, str2, str3, i3, threadPolicy);
                z16 = false;
            } catch (UnsatisfiedLinkError e16) {
                int i16 = f32789e;
                f32787c.writeLock().lock();
                try {
                    try {
                        if (f32791g != null && f32791g.c()) {
                            Log.w("SoLoader", "sApplicationSoSource updated during load: " + str + ", attempting load again.");
                            z16 = true;
                            f32789e = f32789e + 1;
                        } else {
                            z16 = false;
                        }
                        f32787c.writeLock().unlock();
                        if (f32789e == i16) {
                            throw e16;
                        }
                    } catch (IOException e17) {
                        throw new RuntimeException(e17);
                    }
                } catch (Throwable th5) {
                    f32787c.writeLock().unlock();
                    throw th5;
                }
            }
        } while (z16);
        return z17;
    }

    private static boolean o(String str, @Nullable String str2, @Nullable String str3, int i3, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z16;
        Object obj;
        boolean z17 = false;
        if (!TextUtils.isEmpty(str2) && f32794j.contains(str2)) {
            return false;
        }
        synchronized (SoLoader.class) {
            HashSet<String> hashSet = f32792h;
            if (hashSet.contains(str)) {
                if (str3 == null) {
                    return false;
                }
                z16 = true;
            } else {
                z16 = false;
            }
            Map<String, Object> map = f32793i;
            if (map.containsKey(str)) {
                obj = map.get(str);
            } else {
                Object obj2 = new Object();
                map.put(str, obj2);
                obj = obj2;
            }
            ReentrantReadWriteLock reentrantReadWriteLock = f32787c;
            reentrantReadWriteLock.readLock().lock();
            try {
                synchronized (obj) {
                    if (!z16) {
                        try {
                            synchronized (SoLoader.class) {
                                if (hashSet.contains(str)) {
                                    if (str3 == null) {
                                        reentrantReadWriteLock.readLock().unlock();
                                        return false;
                                    }
                                    z16 = true;
                                }
                                if (!z16) {
                                    try {
                                        Log.d("SoLoader", "About to load: " + str);
                                        c(str, i3, threadPolicy);
                                        synchronized (SoLoader.class) {
                                            Log.d("SoLoader", "Loaded: " + str);
                                            hashSet.add(str);
                                        }
                                    } catch (UnsatisfiedLinkError e16) {
                                        String message = e16.getMessage();
                                        if (message != null && message.contains("unexpected e_machine:")) {
                                            throw new WrongAbiError(e16, message.substring(message.lastIndexOf("unexpected e_machine:")));
                                        }
                                        throw e16;
                                    }
                                }
                            }
                        } finally {
                        }
                    }
                    if ((i3 & 16) == 0) {
                        if (!TextUtils.isEmpty(str2) && f32794j.contains(str2)) {
                            z17 = true;
                        }
                        if (str3 != null && !z17) {
                            boolean z18 = f32785a;
                            if (z18) {
                                com.facebook.soloader.a.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                            }
                            try {
                                try {
                                    Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                    h.a(str2);
                                    f32794j.add(str2);
                                    if (z18) {
                                        com.facebook.soloader.a.b();
                                    }
                                } catch (UnsatisfiedLinkError e17) {
                                    throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e17);
                                }
                            } catch (Throwable th5) {
                                if (f32785a) {
                                    com.facebook.soloader.a.b();
                                }
                                throw th5;
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return !z16;
                }
            } catch (Throwable th6) {
                f32787c.readLock().unlock();
                throw th6;
            }
        }
    }

    @Nullable
    public static String p(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    private static int q() {
        int i3;
        ReentrantReadWriteLock reentrantReadWriteLock = f32787c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if ((f32795k & 2) != 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            reentrantReadWriteLock.writeLock().unlock();
            return i3;
        } catch (Throwable th5) {
            f32787c.writeLock().unlock();
            throw th5;
        }
    }
}
