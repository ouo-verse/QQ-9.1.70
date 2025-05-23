package com.tencent.tbs.one.impl.c.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.util.AbiUtil;
import cooperation.qzone.patch.QZonePatchService;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f374643a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f374644b = "";

    /* renamed from: c, reason: collision with root package name */
    private static long f374645c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static String f374646d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final IBinder[] f374647e = {null};

    /* renamed from: f, reason: collision with root package name */
    private static final Handler f374648f;

    /* renamed from: g, reason: collision with root package name */
    private static final ResultReceiver f374649g;

    /* renamed from: h, reason: collision with root package name */
    private static final PackageManager[] f374650h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBinder f374657a;

        a(IBinder iBinder) {
            this.f374657a = iBinder;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ("transact".equals(method.getName())) {
                objArr[3] = 0;
            }
            return method.invoke(this.f374657a, objArr);
        }
    }

    static {
        Handler handler = new Handler(Looper.getMainLooper());
        f374648f = handler;
        f374649g = new ResultReceiver(handler);
        f374650h = new PackageManager[]{null};
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 29;
    }

    private static SharedPreferences c(Context context) {
        return context.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", "tbsDexOpt"), 0);
    }

    private static long d(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), com.tencent.tbs.one.impl.a.e.d(context), 0).firstInstallTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    private static long e(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), com.tencent.tbs.one.impl.a.e.d(context), 0).lastUpdateTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    private static boolean f(Context context) {
        return com.tencent.tbs.one.impl.a.a.a(context, a.EnumC9884a.Mtt);
    }

    private static boolean g(Context context) {
        if (f374645c == -1) {
            f374645c = c(context).getLong("package_last_update_time", 0L);
        }
        long j3 = f374645c;
        long d16 = d(context);
        long e16 = e(context);
        if (j3 != e16) {
            if (d16 != e16 || d16 == 0 || e16 == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean h(Context context) {
        if (TextUtils.isEmpty(f374646d)) {
            f374646d = c(context).getString("record_package_version_name", "");
        }
        String str = f374646d;
        String c16 = com.tencent.tbs.one.impl.a.e.c(context);
        if (!TextUtils.isEmpty(str) && str.equals(c16)) {
            return false;
        }
        return true;
    }

    private static final PackageManager i(Context context) throws IllegalStateException {
        PackageManager[] packageManagerArr = f374650h;
        synchronized (packageManagerArr) {
            try {
                if (packageManagerArr[0] != null) {
                    IBinder[] iBinderArr = f374647e;
                    synchronized (iBinderArr) {
                        IBinder iBinder = iBinderArr[0];
                        if (iBinder != null && iBinder.isBinderAlive()) {
                            return packageManagerArr[0];
                        }
                    }
                }
                IBinder c16 = c();
                IBinder iBinder2 = (IBinder) Proxy.newProxyInstance(context.getClassLoader(), c16.getClass().getInterfaces(), new a(c16));
                Method declaredMethod = Class.forName("android.content.pm.IPackageManager$Stub").getDeclaredMethod("asInterface", IBinder.class);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                Object invoke = declaredMethod.invoke(null, iBinder2);
                Class<?> cls = Class.forName("android.app.ApplicationPackageManager");
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(context.getClass(), Class.forName("android.content.pm.IPackageManager"));
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
                PackageManager packageManager = (PackageManager) declaredConstructor.newInstance(context, invoke);
                packageManagerArr[0] = packageManager;
                return packageManager;
            } catch (InvocationTargetException e16) {
                throw new IllegalStateException(e16.getTargetException());
            } catch (Throwable th5) {
                if (th5 instanceof IllegalStateException) {
                    throw th5;
                }
                throw new IllegalStateException(th5);
            }
        }
    }

    public static String a() {
        return f374644b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Context context, File[] fileArr, boolean z16) {
        boolean z17;
        if (b() && f(context) && z16 && a(context)) {
            int i3 = 0;
            while (true) {
                if (i3 >= fileArr.length) {
                    z17 = true;
                    break;
                }
                File file = fileArr[i3];
                if (file != null) {
                    File a16 = a(file, QZonePatchService.PATCH_SUFFIX, ".odex");
                    if (!a16.exists()) {
                        f374644b += ";OatNotExist:" + a16.getAbsolutePath();
                        z17 = false;
                        break;
                    }
                }
                i3++;
            }
            if (z17) {
                return;
            }
            a(context, false);
        }
    }

    public static boolean a(Context context) {
        if (f374643a == null) {
            f374643a = Boolean.valueOf(c(context).getBoolean("oat_file_valid", false));
        }
        return f374643a.booleanValue();
    }

    private static IBinder c() throws IllegalStateException {
        IBinder[] iBinderArr = f374647e;
        synchronized (iBinderArr) {
            IBinder iBinder = iBinderArr[0];
            if (iBinder != null && iBinder.isBinderAlive()) {
                return iBinder;
            }
            try {
                Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                IBinder iBinder2 = (IBinder) declaredMethod.invoke(null, "package");
                iBinderArr[0] = iBinder2;
                return iBinder2;
            } catch (Throwable th5) {
                if (th5 instanceof InvocationTargetException) {
                    throw new IllegalStateException(th5.getTargetException());
                }
                throw new IllegalStateException(th5);
            }
        }
    }

    public static void a(Context context, boolean z16) {
        f374643a = Boolean.valueOf(z16);
        c(context).edit().putBoolean("oat_file_valid", z16).commit();
    }

    public static void a(Context context, String str) {
        c(context).edit().putString("oat_trigger_type", str).commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, File[] fileArr, boolean z16) {
        if (b()) {
            if (z16) {
                if (f(context)) {
                    if ((h(context) || g(context) || !a(context)) ? false : b(fileArr)) {
                        f374644b += ";MayValid:true";
                        return;
                    }
                }
                f374644b += ";MayValid:false;QB:" + f(context) + ";NewVersion:" + h(context) + ";Updated:" + g(context) + ";OatFileValid:" + a(context);
                if (f(context)) {
                    a(context, false);
                    c(context).edit().putString("record_package_version_name", com.tencent.tbs.one.impl.a.e.c(context)).commit();
                    c(context).edit().putLong("package_last_update_time", e(context)).commit();
                }
            }
            for (File file : fileArr) {
                try {
                    String str = Build.CPU_ABI.equals("arm64-v8a") ? ResourceAttributes.HostArchValues.ARM64 : AbiUtil.ARM;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(file.getParent());
                    String str2 = File.separator;
                    sb5.append(str2);
                    sb5.append("oat");
                    sb5.append(str2);
                    sb5.append(str);
                    File file2 = new File(sb5.toString());
                    if (file2.exists()) {
                        f374644b += ";clearDirectory:" + file2.getAbsolutePath();
                        com.tencent.tbs.one.impl.a.d.a(file2);
                    }
                    com.tencent.tbs.one.impl.a.g.a("deleteOatFileIfNeeded finished oatFileParentDir=" + file2.getAbsolutePath(), new Object[0]);
                } catch (Exception e16) {
                    f374644b += ";clearError";
                    com.tencent.tbs.one.impl.a.g.a("Exception in deleteOatFileIfNeeded", e16.getMessage());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File[] fileArr) {
        for (File file : fileArr) {
            if (file != null) {
                File a16 = a(file, QZonePatchService.PATCH_SUFFIX, ".odex");
                if (!a16.exists() || !a16.canRead() || !a16.isFile() || a16.length() <= 0) {
                    f374644b += ";OatNotValid:" + a16.getAbsolutePath();
                    return false;
                }
            }
        }
        return true;
    }

    static /* synthetic */ void b(Context context) throws IllegalStateException {
        String[] strArr = new String[6];
        strArr[0] = "compile";
        strArr[1] = "-f";
        strArr[2] = "--secondary-dex";
        strArr[3] = "-m";
        strArr[4] = Build.VERSION.SDK_INT >= 31 ? "verify" : "speed-profile";
        strArr[5] = com.tencent.tbs.one.impl.a.e.d(context);
        a(strArr);
        a(new String[]{"bg-dexopt-job", context.getPackageName()});
    }

    static /* synthetic */ void b(Context context, String str) throws IllegalStateException {
        PackageManager i3 = i(context);
        try {
            Method declaredMethod = i3.getClass().getDeclaredMethod("registerDexModule", String.class, Class.forName("android.content.pm.PackageManager$DexModuleRegisterCallback"));
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            for (String str2 : str.split(":")) {
                declaredMethod.invoke(i3, str2, null);
            }
        } catch (InvocationTargetException e16) {
            e16.printStackTrace();
            throw new IllegalStateException(e16.getTargetException());
        } catch (Throwable th5) {
            if (th5 instanceof IllegalStateException) {
                throw th5;
            }
            throw new IllegalStateException(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(final Context context, final File[] fileArr, final String str, final String str2, final String str3, final ClassLoader classLoader) {
        if (b() && f(context) && Build.VERSION.SDK_INT >= 29) {
            f374644b += ";OatType:" + c(context).getString("oat_trigger_type", "unknown");
            if (a(context)) {
                return;
            }
            f374644b += ";WillDoDex2Oat";
            o.c(new Runnable() { // from class: com.tencent.tbs.one.impl.c.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.tbs.one.impl.a.g.a("Starting to doDex2oat dex %s", str);
                    try {
                        if (!c.a(context)) {
                            if (Build.VERSION.SDK_INT == 29) {
                                c.a(context, fileArr);
                                new DexClassLoader(str, str2, str3, classLoader);
                            }
                            if (c.b(fileArr)) {
                                c.a(context, TVKPlayerMsg.PLAYER_CHOICE_SYSTEM);
                                c.a(context, true);
                                return;
                            }
                            for (int i3 = 0; i3 < 10; i3++) {
                                c.b(context);
                                if (c.b(fileArr)) {
                                    c.a(context, "command");
                                    c.a(context, true);
                                    return;
                                }
                            }
                            c.a(context, "register");
                            c.b(context, str);
                            c.a(context, true);
                        }
                    } catch (Throwable th5) {
                        com.tencent.tbs.one.impl.a.g.c("Failed to doDex2oat dex %s", str, th5);
                        th5.printStackTrace();
                    }
                }
            }, 10000L);
        }
    }

    private static void a(String[] strArr) throws IllegalStateException {
        Parcel parcel;
        IBinder c16 = c();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        Parcel parcel2 = null;
        try {
            Parcel obtain = Parcel.obtain();
            try {
                parcel = Parcel.obtain();
                try {
                    obtain.writeFileDescriptor(FileDescriptor.in);
                    obtain.writeFileDescriptor(FileDescriptor.out);
                    obtain.writeFileDescriptor(FileDescriptor.err);
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(null);
                    f374649g.writeToParcel(obtain, 0);
                    OaidMonitor.binderTransact(c16, 1598246212, obtain, parcel, 0);
                    parcel.readException();
                    OaidMonitor.parcelRecycle(parcel);
                    OaidMonitor.parcelRecycle(obtain);
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                } catch (Throwable th5) {
                    th = th5;
                    parcel2 = obtain;
                    try {
                        throw new IllegalStateException("Failure on executing shell cmd.", th);
                    } catch (Throwable th6) {
                        if (parcel != null) {
                            OaidMonitor.parcelRecycle(parcel);
                        }
                        if (parcel2 != null) {
                            OaidMonitor.parcelRecycle(parcel2);
                        }
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                parcel = null;
            }
        } catch (Throwable th8) {
            th = th8;
            parcel = null;
        }
    }

    private static File a(File file, String str, String str2) {
        String str3;
        String str4 = Build.CPU_ABI.equals("arm64-v8a") ? ResourceAttributes.HostArchValues.ARM64 : AbiUtil.ARM;
        String parent = file.getParent();
        String name = file.getName();
        if (name.contains(str)) {
            str3 = name.replace(str, str2);
        } else {
            int lastIndexOf = parent.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str3 = new File(parent.substring(0, lastIndexOf)).getName() + str2;
            } else {
                str3 = "";
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(parent);
        String str5 = File.separator;
        sb5.append(str5);
        sb5.append("oat");
        sb5.append(str5);
        sb5.append(str4);
        sb5.append(str5);
        sb5.append(str3);
        return new File(sb5.toString());
    }

    static /* synthetic */ void a(Context context, File[] fileArr) {
        d.a(fileArr, true);
        a(new String[]{"reconcile-secondary-dex-files", com.tencent.tbs.one.impl.a.e.d(context)});
        d.a(fileArr, false);
    }
}
