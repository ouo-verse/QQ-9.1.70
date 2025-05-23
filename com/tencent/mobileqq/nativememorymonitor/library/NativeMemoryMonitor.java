package com.tencent.mobileqq.nativememorymonitor.library;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.INativeHookMonitor;
import com.tencent.mobileqq.nlog.b;
import com.tencent.mobileqq.nlog.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NativeMemoryMonitor {
    static IPatchRedirector $redirector_ = null;
    public static final String ALL_SO_HOOK = "all_so_hook";
    public static final long FLAG_JNI_CALLXXMETHOD_MONITOR = 32;
    public static final long FLAG_JNI_GLOBAL_REF_MONITOR = 1;
    public static final long FLAG_JNI_LOCAL_REF_MONITOR = 2;
    public static final long FLAG_JNI_LONG_SET_FIELD_MONITOR = 8;
    public static final long FLAG_JNI_NATIVE_THREAD_MONITOR = 64;
    public static final long FLAG_JNI_PRIMITIVE_ARRAY_MONITOR = 4;
    public static final long FLAG_JNI_WEAK_GLOBAL_REF_MONITOR = 16;
    public static final long FLAG_LARGE_OBJECT_ALLOC_MONITOR = 4294967296L;
    public static final long FLAG_LOG_ALL = 4611686018427387904L;
    public static final long FLAG_OVER_ALLOCATE_PER_TIME_MONITOR = 2147483648L;
    private static final String TAG = "NativeMemoryMonitor";
    private static IASanErrorReporter aSanErrorReporter;
    private static ExternalProvider externalProvider;
    private static IJniExceptionReporter jniExceptionReporter;
    private static volatile boolean jniHookInited;
    private static volatile boolean sFileHooked;
    private static volatile boolean sOpenDexFileHooked;
    private static volatile boolean sOpenFileHooked;
    private static volatile boolean sSoLoadRes;
    private static volatile boolean sSoLoaded;
    private static ISoLoader sSoLoader;
    private static volatile boolean soLoadHooked;
    private IDexMonitor dexMonitor;
    private final Set<IFileMonitor> fileMonitors;
    private final ReadWriteLock fileMonitorsLock;
    private boolean mInit;
    private boolean mInitThreadHook;
    private INativeHookMonitor nativeHookMonitor;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class Holder {
        static IPatchRedirector $redirector_;
        private static NativeMemoryMonitor INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11876);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new NativeMemoryMonitor(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        jniHookInited = false;
        sSoLoaded = false;
        sSoLoadRes = false;
        sSoLoader = new ISoLoader() { // from class: com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.nativememorymonitor.library.ISoLoader
            public boolean loadSo(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
                }
                System.loadLibrary(str);
                return true;
            }
        };
    }

    /* synthetic */ NativeMemoryMonitor(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) anonymousClass1);
    }

    private native boolean applyHiddenApiPolicyCrack(ApplicationInfo applicationInfo);

    public static void e(String str, String str2) {
        c.a(str, str2);
    }

    public static NativeMemoryMonitor getInstance() {
        loadSoIfNeeded();
        return Holder.INSTANCE;
    }

    public static boolean getSoLoadRes() {
        return sSoLoadRes;
    }

    private static String[] getThreadStackTrace() {
        String name = Thread.currentThread().getName();
        StringBuilder sb5 = new StringBuilder();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            sb5.append(stackTraceElement);
            sb5.append("\n");
        }
        return new String[]{name, sb5.toString()};
    }

    public static void i(String str, String str2) {
        c.c(str, str2);
    }

    public static void loadSoIfNeeded() {
        boolean z16;
        if (sSoLoaded) {
            return;
        }
        try {
            if (sSoLoader.loadSo("c++_shared") && sSoLoader.loadSo("native-memory-library-lib")) {
                z16 = true;
            } else {
                z16 = false;
            }
            sSoLoadRes = z16;
            c.c(TAG, "load so res: " + sSoLoadRes);
        } catch (UnsatisfiedLinkError e16) {
            sSoLoadRes = false;
            c.b(TAG, "load so res: " + sSoLoadRes, e16);
        }
        sSoLoaded = true;
    }

    private static void logErrorFromNative(String str) {
        c.a(TAG, str);
    }

    private static void logInfoFromNative(String str) {
        c.c(TAG, str);
    }

    private native void nativeDump();

    private native void nativeFileHook(long j3, long j16);

    private native int nativeGetJavaThreadPeakCount();

    private native void nativeInit(long j3, String[] strArr, long j16, long j17, long j18);

    private native void nativeJniHookInit(long j3, long j16);

    private native void nativeOpenDexFileHook(long j3);

    private native void nativeOpenFileHook(long j3);

    private native void nativeSoLoadHook(String str, String str2, long j3, boolean z16);

    private native void nativeThreadCreateHookInit(String str);

    private native void nativeThreadHook();

    @Keep
    private String[] onDexFileOpen(String str, String str2, int i3, ClassLoader classLoader, Object[] objArr) {
        IDexMonitor iDexMonitor = this.dexMonitor;
        if (iDexMonitor == null) {
            return null;
        }
        return iDexMonitor.onOpenDexFile(str, str2, i3, classLoader, objArr);
    }

    @Keep
    private void onFileOpen(String str, int i3, int i16) {
        try {
            this.fileMonitorsLock.readLock().lock();
            Iterator<IFileMonitor> it = this.fileMonitors.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onFileOpen(str, i3, i16);
                } catch (Throwable th5) {
                    c.b(TAG, "onFileOpen", th5);
                }
            }
        } finally {
            this.fileMonitorsLock.readLock().unlock();
        }
    }

    @Keep
    private void onFileRemove(String str) {
        try {
            this.fileMonitorsLock.readLock().lock();
            Iterator<IFileMonitor> it = this.fileMonitors.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onFileRemove(str);
                } catch (Throwable th5) {
                    c.b(TAG, "onFileRemove", th5);
                }
            }
        } finally {
            this.fileMonitorsLock.readLock().unlock();
        }
    }

    @Keep
    private void onFileRename(String str, String str2) {
        try {
            this.fileMonitorsLock.readLock().lock();
            Iterator<IFileMonitor> it = this.fileMonitors.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onFileRename(str, str2);
                } catch (Throwable th5) {
                    c.b(TAG, "onFileRename", th5);
                }
            }
        } finally {
            this.fileMonitorsLock.readLock().unlock();
        }
    }

    @Keep
    private void onNativeHook(String str, String str2, int i3) {
        INativeHookMonitor iNativeHookMonitor = this.nativeHookMonitor;
        if (iNativeHookMonitor != null) {
            iNativeHookMonitor.onNativeHook(str, str2, i3);
        }
    }

    @Keep
    private static void onSoLoad(String str, String str2) {
        ExternalProvider externalProvider2 = externalProvider;
        if (externalProvider2 != null) {
            String replaceAll = str2.replaceAll("\\t", " ");
            if (replaceAll.startsWith("java.lang.Throwable: \n")) {
                replaceAll = replaceAll.substring(22);
            }
            externalProvider2.onSoLoad(str, replaceAll);
        }
    }

    @Keep
    private static void reportASanError(String str) {
        IASanErrorReporter iASanErrorReporter = aSanErrorReporter;
        if (iASanErrorReporter != null) {
            iASanErrorReporter.reportASanError(str);
        }
    }

    @Keep
    private static void reportJniException(String str, String str2) {
        IJniExceptionReporter iJniExceptionReporter = jniExceptionReporter;
        if (iJniExceptionReporter != null) {
            iJniExceptionReporter.reportJniException(str, str2);
        }
    }

    public static void setASanErrorReporter(IASanErrorReporter iASanErrorReporter) {
        aSanErrorReporter = iASanErrorReporter;
    }

    public static void setJniExceptionReporter(IJniExceptionReporter iJniExceptionReporter) {
        jniExceptionReporter = iJniExceptionReporter;
    }

    public static void setSoLoader(@NonNull ISoLoader iSoLoader) {
        sSoLoader = iSoLoader;
    }

    private void setupOpenHook() {
        if (!sOpenFileHooked) {
            sOpenFileHooked = true;
            if (Build.VERSION.SDK_INT > 28) {
                Class cls = Integer.TYPE;
                nativeOpenFileHook(Utils.getHiddenArtMethod("libcore.io.Linux", "open", String.class, cls, cls));
            } else {
                nativeOpenFileHook(0L);
            }
        }
    }

    private void setupRemoveHook() {
        if (!sFileHooked) {
            sFileHooked = true;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 > 28) {
                nativeFileHook(Utils.getHiddenArtMethod("libcore.io.Linux", "remove", String.class), Utils.getHiddenArtMethod("libcore.io.Linux", "rename", String.class, String.class));
            } else if (i3 == 28) {
                nativeFileHook(Utils.getHiddenArtMethod("java.io.UnixFileSystem", "delete0", File.class), Utils.getHiddenArtMethod("java.io.UnixFileSystem", "rename0", File.class, File.class));
            } else {
                nativeFileHook(0L, 0L);
            }
        }
    }

    private native boolean threadDumpBySigQuit(String str);

    public boolean applyHiddenApiPolicyCrack(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context)).booleanValue();
        }
        return applyHiddenApiPolicyCrack(context.getApplicationInfo());
    }

    public synchronized void dump() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            nativeDump();
        }
    }

    public int getJavaThreadPeakCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        if (!sSoLoadRes) {
            return 0;
        }
        return nativeGetJavaThreadPeakCount();
    }

    public native String getUndetachThreads();

    public synchronized void init(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            init(j3, null, 0L, 0L, 0L);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
    }

    public synchronized void initJniHook() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (jniHookInited) {
                return;
            }
            ClassToFindJniOffset.initFromJava();
            nativeJniHookInit(ClassToFindJniOffset.markArtMethod, ClassToFindJniOffset.mark2ArtMethod);
            jniHookInited = true;
        }
    }

    public synchronized void initThreadHook(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        if (!sSoLoadRes) {
            return;
        }
        if (this.mInitThreadHook) {
            return;
        }
        this.mInitThreadHook = true;
        Utils.setFieldAccessible("java.lang.Thread", "nativePeer");
        nativeThreadCreateHookInit(str);
        nativeThreadHook();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeJavaFieldHook(Class[] clsArr, String[] strArr, String[] strArr2, AccessFieldCallback[] accessFieldCallbackArr, Class[] clsArr2, String[] strArr3, String[] strArr4, AccessFieldCallback[] accessFieldCallbackArr2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeJavaMethodHook(Class[] clsArr, String[] strArr, String[] strArr2, CallMethodCallback[] callMethodCallbackArr, Class[] clsArr2, String[] strArr3, String[] strArr4, CallMethodCallback[] callMethodCallbackArr2);

    public void removeFileMonitor(IFileMonitor iFileMonitor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iFileMonitor);
            return;
        }
        try {
            this.fileMonitorsLock.writeLock().lock();
            this.fileMonitors.remove(iFileMonitor);
        } finally {
            this.fileMonitorsLock.writeLock().unlock();
        }
    }

    public void removeNativeHookMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.nativeHookMonitor = null;
        }
    }

    public void removeOpenDexFileHook() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.dexMonitor = null;
        }
    }

    public void setEventLog(@NonNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            c.e(bVar);
        }
    }

    public void setNativeHookMonitor(INativeHookMonitor iNativeHookMonitor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iNativeHookMonitor);
        } else {
            this.nativeHookMonitor = iNativeHookMonitor;
        }
    }

    public native void setupASanCallback();

    public synchronized void setupFileHook(@NonNull IFileMonitor iFileMonitor, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, iFileMonitor, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        try {
            this.fileMonitorsLock.writeLock().lock();
            this.fileMonitors.add(iFileMonitor);
            this.fileMonitorsLock.writeLock().unlock();
            initJniHook();
            if (z16) {
                setupRemoveHook();
            }
            if (z17) {
                setupOpenHook();
            }
        } catch (Throwable th5) {
            this.fileMonitorsLock.writeLock().unlock();
            throw th5;
        }
    }

    public void setupOpenDexFileHook(@NonNull IDexMonitor iDexMonitor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iDexMonitor);
        } else {
            this.dexMonitor = iDexMonitor;
            setupOpenDexFileHook();
        }
    }

    public synchronized void setupSoLoadHook(Context context, ExternalProvider externalProvider2, boolean z16) {
        long hiddenArtMethod;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, externalProvider2, Boolean.valueOf(z16));
            return;
        }
        externalProvider = externalProvider2;
        if (soLoadHooked) {
            return;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        initJniHook();
        String packageName = context.getPackageName();
        String str = applicationInfo.nativeLibraryDir;
        if (Build.VERSION.SDK_INT < 29) {
            hiddenArtMethod = 0;
        } else {
            hiddenArtMethod = Utils.getHiddenArtMethod("java.lang.Runtime", "nativeLoad", String.class, ClassLoader.class, Class.class);
        }
        nativeSoLoadHook(packageName, str, hiddenArtMethod, z16);
        soLoadHooked = true;
    }

    public boolean threadDumpTraceFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).booleanValue();
        }
        Log.d(TAG, "threadDumpTraceFile. anr_trace path:" + str);
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean threadDumpBySigQuit = threadDumpBySigQuit(str);
        Log.d(TAG, "threadDumpTraceFile cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
        return threadDumpBySigQuit;
    }

    NativeMemoryMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.mInit = false;
        this.mInitThreadHook = false;
        this.fileMonitors = new HashSet();
        this.fileMonitorsLock = new ReentrantReadWriteLock();
    }

    public static void e(String str, String str2, Throwable th5) {
        c.b(str, str2, th5);
    }

    public static void i(String str, String str2, Throwable th5) {
        c.d(str, str2, th5);
    }

    private void setupOpenDexFileHook() {
        if (sOpenDexFileHooked) {
            return;
        }
        sOpenDexFileHooked = true;
        initJniHook();
        if (Build.VERSION.SDK_INT > 28) {
            try {
                nativeOpenDexFileHook(Utils.getHiddenArtMethod("dalvik.system.DexFile", "openDexFileNative", String.class, String.class, Integer.TYPE, ClassLoader.class, Class.forName("[Ldalvik.system.DexPathList$Element;")));
                return;
            } catch (ClassNotFoundException e16) {
                c.b(TAG, "setupOpenDexFileHook failed", e16);
                return;
            }
        }
        nativeOpenDexFileHook(0L);
    }

    public synchronized void init(long j3, String[] strArr, long j16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), strArr, Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        if (this.mInit) {
            return;
        }
        if (!sSoLoadRes) {
            logErrorFromNative("SoLoad fail");
            return;
        }
        logErrorFromNative("init");
        logInfoFromNative("init");
        nativeInit(j3, strArr, j16, j17, j18);
        this.mInit = true;
    }
}
