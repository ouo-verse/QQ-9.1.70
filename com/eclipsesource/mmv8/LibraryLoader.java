package com.eclipsesource.mmv8;

import com.tencent.av.so.ResInfo;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
class LibraryLoader {
    static final String DELIMITER = System.getProperty("line.separator");
    static final String SEPARATOR = System.getProperty("file.separator");
    static final String SWT_LIB_DIR = ".j2v8";

    public static void chmod(String str, String str2) {
        if (isWindows()) {
            return;
        }
        try {
            RuntimeMonitor.exec(Runtime.getRuntime(), new String[]{"chmod", str, str2}).waitFor();
        } catch (Throwable unused) {
        }
    }

    private static String computeLibraryFullName() {
        return RFixConstants.SO_PATH + computeLibraryShortName() + "." + getOSFileExtension();
    }

    private static String computeLibraryShortName() {
        return "j2v8_" + getOS() + "_" + getArchSuffix();
    }

    public static boolean extract(String str, String str2, StringBuffer stringBuffer) {
        InputStream inputStream;
        boolean z16;
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            inputStream = LibraryLoader.class.getResourceAsStream("/" + str2);
            if (inputStream != null) {
                z16 = true;
                try {
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (Throwable unused) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (z16 && file.exists()) {
                                file.delete();
                            }
                            return false;
                        }
                    }
                    fileOutputStream2.close();
                    inputStream.close();
                    chmod("755", str);
                    if (load(str, stringBuffer)) {
                        return true;
                    }
                } catch (Throwable unused4) {
                }
            }
        } catch (Throwable unused5) {
            inputStream = null;
            z16 = false;
        }
        return false;
    }

    public static String getArchSuffix() {
        String property = System.getProperty("os.arch");
        if (property.equals("i686")) {
            return ResourceAttributes.HostArchValues.X86;
        }
        if (property.equals(ResourceAttributes.HostArchValues.AMD64)) {
            return "x86_64";
        }
        if (property.equals(Platform.NATIVE_CLIENT) || property.equals("aarch64")) {
            return "armv7l";
        }
        return property;
    }

    public static String getOS() {
        if (isWindows()) {
            return "win32";
        }
        if (isMac()) {
            return Platform.MACOSX;
        }
        if (isLinux() && !isAndroid()) {
            return "linux";
        }
        if (isAndroid()) {
            return "android";
        }
        throw new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
    }

    public static String getOSFileExtension() {
        if (isWindows()) {
            return "dll";
        }
        if (isMac()) {
            return "dylib";
        }
        if (isLinux() || isNativeClient()) {
            return ResInfo.RES_TYPE_SO;
        }
        throw new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
    }

    public static String getOsName() {
        return System.getProperty("os.name") + System.getProperty("java.specification.vendor");
    }

    public static boolean isAndroid() {
        return getOsName().contains("Android");
    }

    public static boolean isLinux() {
        return getOsName().startsWith("Linux");
    }

    public static boolean isMac() {
        return getOsName().startsWith("Mac");
    }

    public static boolean isNativeClient() {
        return getOsName().startsWith(Platform.NATIVE_CLIENT);
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    public static boolean load(String str, StringBuffer stringBuffer) {
        try {
            if (str.indexOf(SEPARATOR) != -1) {
                System.load(str);
                return true;
            }
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e16) {
            if (stringBuffer.length() == 0) {
                stringBuffer.append(DELIMITER);
            }
            stringBuffer.append('\t');
            stringBuffer.append(e16.getMessage());
            stringBuffer.append(DELIMITER);
            return false;
        }
    }

    public static void loadLibrary(String str) {
        if (isAndroid()) {
            System.loadLibrary("mmj2v8");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String computeLibraryShortName = computeLibraryShortName();
        String computeLibraryFullName = computeLibraryFullName();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(System.getProperty("user.dir"));
        String str2 = SEPARATOR;
        sb5.append(str2);
        sb5.append("jni");
        sb5.append(str2);
        sb5.append(computeLibraryFullName());
        String sb6 = sb5.toString();
        if (load(computeLibraryFullName, stringBuffer) || load(computeLibraryShortName, stringBuffer)) {
            return;
        }
        if (new File(sb6).exists() && load(sb6, stringBuffer)) {
            return;
        }
        if (str == null) {
            str = System.getProperty("java.io.tmpdir");
        }
        if (extract(str + str2 + computeLibraryFullName, computeLibraryFullName, stringBuffer)) {
            return;
        }
        throw new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + stringBuffer.toString());
    }
}
