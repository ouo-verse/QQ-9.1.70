package com.eclipsesource.mmv8;

import com.tencent.av.so.ResInfo;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PlatformDetector {

    /* loaded from: classes2.dex */
    public static class Arch {
        public static String getName() {
            String property = System.getProperty("os.arch");
            String normalizeArch = PlatformDetector.normalizeArch(property);
            if (!normalizeArch.equals("unknown")) {
                return normalizeArch;
            }
            throw new UnsatisfiedLinkError("Unsupported arch: " + property);
        }
    }

    /* loaded from: classes2.dex */
    public static class OS {
        public static String getLibFileExtension() {
            if (isWindows()) {
                return "dll";
            }
            if (isMac()) {
                return "dylib";
            }
            if (!isLinux() && !isAndroid() && !isNativeClient()) {
                throw new UnsatisfiedLinkError("Unsupported platform library-extension for: " + getName());
            }
            return ResInfo.RES_TYPE_SO;
        }

        public static String getName() {
            String property = System.getProperty("os.name");
            String normalizeOs = PlatformDetector.normalizeOs(property);
            String property2 = System.getProperty("java.specification.vendor");
            if (PlatformDetector.normalize(property2).contains("android") || normalizeOs.contains("android")) {
                return "android";
            }
            if (!normalizeOs.equals("unknown")) {
                return normalizeOs;
            }
            throw new UnsatisfiedLinkError("Unsupported platform/vendor: " + property + " / " + property2);
        }

        public static boolean isAndroid() {
            return getName().equals("android");
        }

        public static boolean isLinux() {
            return getName().equals("linux");
        }

        public static boolean isMac() {
            return getName().equals(Platform.MACOSX);
        }

        public static boolean isNativeClient() {
            return getName().equals(Platform.NATIVE_CLIENT);
        }

        public static boolean isWindows() {
            return getName().equals("windows");
        }
    }

    /* loaded from: classes2.dex */
    public static class Vendor {
        private static final String LINUX_ID_PREFIX = "ID=";
        private static final String[] LINUX_OS_RELEASE_FILES = {"/etc/os-release", "/usr/lib/os-release"};
        private static final String REDHAT_RELEASE_FILE = "/etc/redhat-release";

        private static void closeQuietly(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }

        private static String getLinuxOsReleaseId() {
            for (String str : LINUX_OS_RELEASE_FILES) {
                File file = new File(str);
                if (file.exists()) {
                    return parseLinuxOsReleaseFile(file);
                }
            }
            File file2 = new File(REDHAT_RELEASE_FILE);
            if (file2.exists()) {
                return parseLinuxRedhatReleaseFile(file2);
            }
            throw new UnsatisfiedLinkError("Unsupported linux vendor: " + getName());
        }

        public static String getName() {
            if (OS.isWindows()) {
                return "microsoft";
            }
            if (OS.isMac()) {
                return "apple";
            }
            if (OS.isLinux()) {
                return getLinuxOsReleaseId();
            }
            if (OS.isAndroid()) {
                return "google";
            }
            throw new UnsatisfiedLinkError("Unsupported vendor: " + getName());
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        
            r0 = com.eclipsesource.mmv8.PlatformDetector.normalizeOsReleaseValue(r4.substring(3));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static String parseLinuxOsReleaseFile(File file) {
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2 = null;
            String str = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith(LINUX_ID_PREFIX)) {
                            break;
                        }
                    } catch (IOException unused) {
                        closeQuietly(bufferedReader);
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader2 = bufferedReader;
                        closeQuietly(bufferedReader2);
                        throw th;
                    }
                }
                closeQuietly(bufferedReader);
                return str;
            } catch (IOException unused2) {
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
            }
        }

        private static String parseLinuxRedhatReleaseFile(File file) {
            BufferedReader bufferedReader;
            String readLine;
            String str = "fedora";
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (IOException unused) {
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException unused2) {
                closeQuietly(bufferedReader);
                return null;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                closeQuietly(bufferedReader2);
                throw th;
            }
            if (readLine != null) {
                String lowerCase = readLine.toLowerCase(Locale.US);
                if (lowerCase.contains("centos")) {
                    str = "centos";
                } else if (!lowerCase.contains("fedora")) {
                    if (lowerCase.contains("red hat enterprise linux")) {
                        str = "rhel";
                    } else {
                        closeQuietly(bufferedReader);
                        return null;
                    }
                }
                closeQuietly(bufferedReader);
                return str;
            }
            closeQuietly(bufferedReader);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String normalize(String str) {
        if (str == null) {
            return "";
        }
        return str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String normalizeArch(String str) {
        String normalize = normalize(str);
        if (normalize.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            return "x86_64";
        }
        if (normalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
            return "x86_32";
        }
        if (normalize.matches("^(ia64|itanium64)$")) {
            return "itanium_64";
        }
        if (normalize.matches("^(sparc|sparc32)$")) {
            return "sparc_32";
        }
        if (normalize.matches("^(sparcv9|sparc64)$")) {
            return "sparc_64";
        }
        if (normalize.matches("^(arm|arm32)$")) {
            return "arm_32";
        }
        if ("aarch64".equals(normalize)) {
            return "aarch_64";
        }
        if (normalize.matches("^(ppc|ppc32)$")) {
            return "ppc_32";
        }
        if (ResourceAttributes.HostArchValues.PPC64.equals(normalize)) {
            return "ppc_64";
        }
        if ("ppc64le".equals(normalize)) {
            return "ppcle_64";
        }
        if ("s390".equals(normalize)) {
            return "s390_32";
        }
        if ("s390x".equals(normalize)) {
            return "s390_64";
        }
        return "unknown";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String normalizeOs(String str) {
        String normalize = normalize(str);
        if (normalize.startsWith(ResourceAttributes.OsTypeValues.AIX)) {
            return ResourceAttributes.OsTypeValues.AIX;
        }
        if (normalize.startsWith(ResourceAttributes.OsTypeValues.HPUX)) {
            return ResourceAttributes.OsTypeValues.HPUX;
        }
        if (normalize.startsWith("os400") && (normalize.length() <= 5 || !Character.isDigit(normalize.charAt(5)))) {
            return "os400";
        }
        if (normalize.startsWith("android")) {
            return "android";
        }
        if (normalize.startsWith("linux")) {
            return "linux";
        }
        if (normalize.startsWith(Platform.NATIVE_CLIENT)) {
            return Platform.NATIVE_CLIENT;
        }
        if (normalize.startsWith(Platform.MACOSX) || normalize.startsWith("osx")) {
            return Platform.MACOSX;
        }
        if (normalize.startsWith(ResourceAttributes.OsTypeValues.FREEBSD)) {
            return ResourceAttributes.OsTypeValues.FREEBSD;
        }
        if (normalize.startsWith(ResourceAttributes.OsTypeValues.OPENBSD)) {
            return ResourceAttributes.OsTypeValues.OPENBSD;
        }
        if (normalize.startsWith(ResourceAttributes.OsTypeValues.NETBSD)) {
            return ResourceAttributes.OsTypeValues.NETBSD;
        }
        if (normalize.startsWith(ResourceAttributes.OsTypeValues.SOLARIS) || normalize.startsWith("sunos")) {
            return "sunos";
        }
        if (normalize.startsWith("windows")) {
            return "windows";
        }
        return "unknown";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String normalizeOsReleaseValue(String str) {
        return str.trim().replace("\"", "");
    }
}
