package com.github.luben.zstd.util;

import com.tencent.av.so.ResInfo;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicBoolean;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum Native {
    ;

    private static final String nativePathOverride = "ZstdNativePath";
    private static final String libnameShort = "zstd-jni-1.5.6-1";
    private static final String libname = "libzstd-jni-1.5.6-1";
    private static final String errorMsg = "Unsupported OS/arch, cannot find " + resourceName() + " or load " + libnameShort + " from system libraries. Please try building from source the jar or providing " + libname + " in your system.";
    private static AtomicBoolean loaded = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements PrivilegedAction<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32917a;

        a(String str) {
            this.f32917a = str;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void run() {
            System.loadLibrary(this.f32917a);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements PrivilegedAction<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32918a;

        b(String str) {
            this.f32918a = str;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void run() {
            System.load(this.f32918a);
            return null;
        }
    }

    public static synchronized void assumeLoaded() {
        synchronized (Native.class) {
            loaded.set(true);
        }
    }

    public static synchronized boolean isLoaded() {
        boolean z16;
        synchronized (Native.class) {
            z16 = loaded.get();
        }
        return z16;
    }

    private static String libExtension() {
        if (!osName().contains("os_x") && !osName().contains(ResourceAttributes.OsTypeValues.DARWIN)) {
            if (osName().contains("win")) {
                return "dll";
            }
            return ResInfo.RES_TYPE_SO;
        }
        return "dylib";
    }

    public static synchronized void load() {
        synchronized (Native.class) {
            load(null);
        }
    }

    private static void loadLibrary(String str) {
        AccessController.doPrivileged(new a(str));
    }

    private static void loadLibraryFile(String str) {
        AccessController.doPrivileged(new b(str));
    }

    private static String osArch() {
        return System.getProperty("os.arch");
    }

    private static String osName() {
        String replace = System.getProperty("os.name").toLowerCase().replace(TokenParser.SP, util.base64_pad_url);
        if (replace.startsWith("win")) {
            return "win";
        }
        if (replace.startsWith("mac")) {
            return ResourceAttributes.OsTypeValues.DARWIN;
        }
        return replace;
    }

    private static String resourceName() {
        return "/" + osName() + "/" + osArch() + "/" + libname + "." + libExtension();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0150 A[Catch: IOException -> 0x015e, all -> 0x015f, TryCatch #12 {IOException -> 0x015e, blocks: (B:71:0x014b, B:73:0x0150, B:75:0x0155, B:77:0x015b), top: B:70:0x014b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void load(File file) {
        FileOutputStream fileOutputStream;
        Throwable th5;
        File file2;
        synchronized (Native.class) {
            if (loaded.get()) {
                return;
            }
            String resourceName = resourceName();
            String property = System.getProperty(nativePathOverride);
            if (property != null) {
                loadLibraryFile(property);
                loaded.set(true);
                return;
            }
            try {
                Class.forName("org.osgi.framework.BundleEvent");
                loadLibrary(libname);
                loaded.set(true);
            } catch (Throwable unused) {
                InputStream resourceAsStream = Native.class.getResourceAsStream(resourceName);
                if (resourceAsStream == null) {
                    try {
                        loadLibrary(libnameShort);
                        loaded.set(true);
                        return;
                    } catch (UnsatisfiedLinkError e16) {
                        UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(e16.getMessage() + "\n" + errorMsg);
                        unsatisfiedLinkError.setStackTrace(e16.getStackTrace());
                        throw unsatisfiedLinkError;
                    }
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    file2 = File.createTempFile(libname, "." + libExtension(), file);
                    try {
                        file2.deleteOnExit();
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (IOException e17) {
                        e = e17;
                        fileOutputStream = null;
                    } catch (Throwable th6) {
                        fileOutputStream = null;
                        th5 = th6;
                    }
                } catch (IOException e18) {
                    e = e18;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    fileOutputStream = null;
                    th5 = th7;
                    file2 = 0;
                }
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = resourceAsStream.read(bArr);
                            if (read == -1) {
                                try {
                                    break;
                                } catch (IOException unused2) {
                                    fileOutputStream2 = fileOutputStream;
                                }
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        try {
                            loadLibraryFile(file2.getAbsolutePath());
                        } catch (UnsatisfiedLinkError e19) {
                            try {
                                loadLibrary(libnameShort);
                            } catch (UnsatisfiedLinkError e26) {
                                UnsatisfiedLinkError unsatisfiedLinkError2 = new UnsatisfiedLinkError(e19.getMessage() + "\n" + e26.getMessage() + "\n" + errorMsg);
                                unsatisfiedLinkError2.setStackTrace(e26.getStackTrace());
                                throw unsatisfiedLinkError2;
                            }
                        }
                        loaded.set(true);
                        try {
                            resourceAsStream.close();
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (file2.exists()) {
                                file2.delete();
                            }
                        } catch (IOException unused3) {
                        }
                    } catch (Throwable th8) {
                        th5 = th8;
                        try {
                            resourceAsStream.close();
                            if (fileOutputStream != null) {
                            }
                            if (file2 != 0) {
                                file2.delete();
                            }
                        } catch (IOException unused4) {
                        }
                        throw th5;
                    }
                } catch (IOException e27) {
                    e = e27;
                    fileOutputStream2 = file2;
                    try {
                        ExceptionInInitializerError exceptionInInitializerError = new ExceptionInInitializerError("Cannot unpack libzstd-jni-1.5.6-1: " + e.getMessage());
                        exceptionInInitializerError.setStackTrace(e.getStackTrace());
                        throw exceptionInInitializerError;
                    } catch (Throwable th9) {
                        FileOutputStream fileOutputStream3 = fileOutputStream2;
                        th5 = th9;
                        file2 = fileOutputStream3;
                        resourceAsStream.close();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (file2 != 0 && file2.exists()) {
                            file2.delete();
                        }
                        throw th5;
                    }
                }
            }
        }
    }
}
