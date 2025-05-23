package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import android.os.SystemProperties;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes34.dex */
public final class TVHttpProxyLoadLibrary {
    public static final String ASSETS_LIBRARY_SRC_DIR = "libs/";
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap<>();
    private static Context mContext = null;

    /* loaded from: classes34.dex */
    private static class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f363554d;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f363554d = uncaughtExceptionHandler;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
        @Override // java.lang.Thread.UncaughtExceptionHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void uncaughtException(Thread thread, Throwable th5) {
            boolean z16 = true;
            if ((th5 instanceof UnsatisfiedLinkError) || ((th5 instanceof NoSuchMethodError) && th5.getMessage().matches(".*sig(nature)?[=:].*"))) {
                try {
                    TVHttpProxyLoadLibrary.extractAllLibraries(TVHttpProxyLoadLibrary.mContext);
                } catch (Exception unused) {
                }
                if (z16) {
                    th5 = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th5);
                }
                this.f363554d.uncaughtException(thread, th5);
            }
            z16 = false;
            if (z16) {
            }
            this.f363554d.uncaughtException(thread, th5);
        }
    }

    TVHttpProxyLoadLibrary() {
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) throws Exception {
        if (file.isFile()) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ZipEntry entry = zipFile.getEntry("lib/" + it.next() + "/lib" + str + ".so");
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            inputStream.close();
                            fileOutputStream.close();
                            file.setReadOnly();
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th5) {
                        inputStream.close();
                        fileOutputStream.close();
                        throw th5;
                    }
                }
            }
        }
        return false;
    }

    private static List<String> generateAbiList() throws Exception {
        ArrayList arrayList = new ArrayList(3);
        Method method = SystemProperties.class.getMethod("get", String.class);
        String str = (String) method.invoke(null, TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI);
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        String str2 = (String) method.invoke(null, TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI_2);
        if (str2 != null && str2.length() > 0) {
            arrayList.add(str2);
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, classLoader);
    }

    private static void reflectSystemLoadlibrary(String str, ClassLoader classLoader) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, classLoader);
    }

    public static void setupBrokenLibraryHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ea A[Catch: all -> 0x01ff, Exception -> 0x0202, TRY_ENTER, TryCatch #16 {Exception -> 0x0202, all -> 0x01ff, blocks: (B:42:0x0190, B:44:0x01ea, B:45:0x01fe), top: B:41:0x0190 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void load(String str, ClassLoader classLoader, Context context) throws UnsatisfiedLinkError {
        UnsatisfiedLinkError e16;
        ZipFile zipFile;
        HashMap<String, WeakReference<ClassLoader>> hashMap;
        if (str == null || str.length() == 0 || classLoader == null) {
            return;
        }
        mContext = context;
        HashMap<String, WeakReference<ClassLoader>> hashMap2 = mLoadedLibs;
        synchronized (hashMap2) {
            WeakReference<ClassLoader> weakReference = hashMap2.get(str);
            ZipFile zipFile2 = null;
            ClassLoader classLoader2 = weakReference != null ? weakReference.get() : null;
            if (classLoader2 != null) {
                if (classLoader2 == classLoader) {
                    return;
                }
                throw new UnsatisfiedLinkError("Library '" + str + "' was loaded by a different ClassLoader.");
            }
            if (context == null) {
                try {
                    reflectSystemLoadlibrary(str, classLoader);
                    synchronized (hashMap2) {
                        hashMap2.put(str, new WeakReference<>(classLoader));
                    }
                    return;
                } catch (InvocationTargetException e17) {
                    throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: " + str).initCause(e17.getCause()));
                } catch (Exception e18) {
                    throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: " + str).initCause(e18));
                }
            }
            File file = new File(context.getDir("recover_lib", 0), RFixConstants.SO_PATH + str + ".so");
            if (file.isFile()) {
                try {
                    reflectSystemLoad(file.getAbsolutePath(), classLoader);
                    synchronized (hashMap2) {
                        hashMap2.put(str, new WeakReference<>(classLoader));
                    }
                    return;
                } catch (UnsatisfiedLinkError e19) {
                    e16 = e19;
                    file.delete();
                    reflectSystemLoadlibrary(str, classLoader);
                    hashMap = mLoadedLibs;
                    synchronized (hashMap) {
                    }
                } catch (InvocationTargetException e26) {
                    if (e26.getCause() instanceof UnsatisfiedLinkError) {
                        e16 = (UnsatisfiedLinkError) e26.getCause();
                        file.delete();
                        reflectSystemLoadlibrary(str, classLoader);
                        hashMap = mLoadedLibs;
                        synchronized (hashMap) {
                        }
                    } else {
                        throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(e26.getCause()));
                    }
                } catch (Throwable th5) {
                    throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(th5));
                }
            } else {
                e16 = null;
            }
            try {
                reflectSystemLoadlibrary(str, classLoader);
                hashMap = mLoadedLibs;
                synchronized (hashMap) {
                    hashMap.put(str, new WeakReference<>(classLoader));
                }
            } catch (UnsatisfiedLinkError e27) {
                if (e16 == null) {
                    e16 = e27;
                }
                try {
                    try {
                        zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                        try {
                            if (!extractLibrary(zipFile, str, generateAbiList(), file)) {
                                try {
                                    zipFile.close();
                                } catch (IOException unused) {
                                }
                                try {
                                    reflectSystemLoad(file.getAbsolutePath(), classLoader);
                                    HashMap<String, WeakReference<ClassLoader>> hashMap3 = mLoadedLibs;
                                    synchronized (hashMap3) {
                                        hashMap3.put(str, new WeakReference<>(classLoader));
                                    }
                                    return;
                                } catch (InvocationTargetException e28) {
                                    if (e16 == null) {
                                        throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(e28.getCause()));
                                    }
                                    throw e16;
                                } catch (Exception e29) {
                                    if (e16 == null) {
                                        throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e29));
                                    }
                                    throw e16;
                                }
                            }
                            throw new RuntimeException("Can't find recover library: " + str);
                        } catch (Exception e36) {
                            e = e36;
                            zipFile2 = zipFile;
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e));
                        } catch (Throwable th6) {
                            th = th6;
                            zipFile2 = zipFile;
                            if (zipFile2 != null) {
                                try {
                                    zipFile2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e37) {
                        e = e37;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (InvocationTargetException e38) {
                if (!(e38.getCause() instanceof UnsatisfiedLinkError)) {
                    throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(e38.getCause()));
                }
                if (e16 == null) {
                    e16 = (UnsatisfiedLinkError) e38.getCause();
                }
                zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                if (!extractLibrary(zipFile, str, generateAbiList(), file)) {
                }
            } catch (Throwable th8) {
                throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(th8));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void extractAllLibraries(Context context) throws Exception {
        if (context == null) {
            return;
        }
        List<String> generateAbiList = generateAbiList();
        File dir = context.getDir("recover_lib", 0);
        ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
        try {
            HashSet hashSet = new HashSet();
            Pattern compile = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                Matcher matcher = compile.matcher(entries.nextElement().getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (!hashSet.contains(group)) {
                        extractLibrary(zipFile, group, generateAbiList, new File(dir, RFixConstants.SO_PATH + group + ".so"));
                        hashSet.add(group);
                    }
                }
            }
        } finally {
            zipFile.close();
        }
    }

    public static String find(String str, Context context) {
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            ClassLoader classLoader = TVHttpProxyLoadLibrary.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, str);
        } catch (Exception unused) {
        }
        if (str2 != null) {
            return str2;
        }
        File file = new File(context.getDir("recover_lib", 0), RFixConstants.SO_PATH + str + ".so");
        return file.canRead() ? file.getAbsolutePath() : str2;
    }
}
