package org.apache.commons.lang;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import java.io.File;
import java.io.PrintStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SystemUtils {
    public static final boolean IS_JAVA_1_1;
    public static final boolean IS_JAVA_1_2;
    public static final boolean IS_JAVA_1_3;
    public static final boolean IS_JAVA_1_4;
    public static final boolean IS_JAVA_1_5;
    public static final boolean IS_JAVA_1_6;
    public static final boolean IS_JAVA_1_7;
    public static final boolean IS_OS_AIX;
    public static final boolean IS_OS_HP_UX;
    public static final boolean IS_OS_IRIX;
    public static final boolean IS_OS_LINUX;
    public static final boolean IS_OS_MAC;
    public static final boolean IS_OS_MAC_OSX;
    public static final boolean IS_OS_OS2;
    public static final boolean IS_OS_SOLARIS;
    public static final boolean IS_OS_SUN_OS;
    public static final boolean IS_OS_UNIX;
    public static final boolean IS_OS_WINDOWS;
    public static final boolean IS_OS_WINDOWS_2000;
    public static final boolean IS_OS_WINDOWS_7;
    public static final boolean IS_OS_WINDOWS_95;
    public static final boolean IS_OS_WINDOWS_98;
    public static final boolean IS_OS_WINDOWS_ME;
    public static final boolean IS_OS_WINDOWS_NT;
    public static final boolean IS_OS_WINDOWS_VISTA;
    public static final boolean IS_OS_WINDOWS_XP;
    public static final float JAVA_VERSION_FLOAT;
    public static final int JAVA_VERSION_INT;
    public static final String JAVA_VERSION_TRIMMED;
    private static final int JAVA_VERSION_TRIM_SIZE = 3;
    private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
    public static final String USER_COUNTRY;
    public static final String USER_DIR;
    private static final String USER_DIR_KEY = "user.dir";
    public static final String USER_HOME;
    private static final String USER_HOME_KEY = "user.home";
    public static final String USER_LANGUAGE;
    public static final String USER_NAME;
    public static final String USER_TIMEZONE;
    public static final String AWT_TOOLKIT = getSystemProperty("awt.toolkit");
    public static final String FILE_ENCODING = getSystemProperty("file.encoding");
    public static final String FILE_SEPARATOR = getSystemProperty("file.separator");
    public static final String JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");
    public static final String JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");
    public static final String JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");
    public static final String JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");
    public static final String JAVA_CLASS_PATH = getSystemProperty("java.class.path");
    public static final String JAVA_CLASS_VERSION = getSystemProperty("java.class.version");
    public static final String JAVA_COMPILER = getSystemProperty("java.compiler");
    public static final String JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");
    public static final String JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");
    private static final String JAVA_HOME_KEY = "java.home";
    public static final String JAVA_HOME = getSystemProperty(JAVA_HOME_KEY);
    private static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
    public static final String JAVA_IO_TMPDIR = getSystemProperty(JAVA_IO_TMPDIR_KEY);
    public static final String JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");
    public static final String JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");
    public static final String JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");
    public static final String JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");
    public static final String JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");
    public static final String JAVA_SPECIFICATION_VERSION = getSystemProperty("java.specification.version");
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty("java.util.prefs.PreferencesFactory");
    public static final String JAVA_VENDOR = getSystemProperty("java.vendor");
    public static final String JAVA_VENDOR_URL = getSystemProperty("java.vendor.url");
    public static final String JAVA_VERSION = getSystemProperty("java.version");
    public static final String JAVA_VM_INFO = getSystemProperty("java.vm.info");
    public static final String JAVA_VM_NAME = getSystemProperty("java.vm.name");
    public static final String JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");
    public static final String JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");
    public static final String JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");
    public static final String JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");
    public static final String JAVA_VM_VERSION = getSystemProperty("java.vm.version");
    public static final String LINE_SEPARATOR = getSystemProperty("line.separator");
    public static final String OS_ARCH = getSystemProperty("os.arch");
    public static final String OS_NAME = getSystemProperty("os.name");
    public static final String OS_VERSION = getSystemProperty("os.version");
    public static final String PATH_SEPARATOR = getSystemProperty("path.separator");

    static {
        boolean z16;
        String str = "user.country";
        if (getSystemProperty("user.country") == null) {
            str = "user.region";
        }
        USER_COUNTRY = getSystemProperty(str);
        USER_DIR = getSystemProperty(USER_DIR_KEY);
        USER_HOME = getSystemProperty(USER_HOME_KEY);
        USER_LANGUAGE = getSystemProperty("user.language");
        USER_NAME = getSystemProperty("user.name");
        USER_TIMEZONE = getSystemProperty("user.timezone");
        JAVA_VERSION_TRIMMED = getJavaVersionTrimmed();
        JAVA_VERSION_FLOAT = getJavaVersionAsFloat();
        JAVA_VERSION_INT = getJavaVersionAsInt();
        IS_JAVA_1_1 = getJavaVersionMatches("1.1");
        IS_JAVA_1_2 = getJavaVersionMatches(Global.TRACKING_SDKVS_VALUE);
        IS_JAVA_1_3 = getJavaVersionMatches("1.3");
        IS_JAVA_1_4 = getJavaVersionMatches("1.4");
        IS_JAVA_1_5 = getJavaVersionMatches("1.5");
        IS_JAVA_1_6 = getJavaVersionMatches("1.6");
        IS_JAVA_1_7 = getJavaVersionMatches("1.7");
        boolean oSMatchesName = getOSMatchesName("AIX");
        IS_OS_AIX = oSMatchesName;
        boolean oSMatchesName2 = getOSMatchesName("HP-UX");
        IS_OS_HP_UX = oSMatchesName2;
        boolean oSMatchesName3 = getOSMatchesName("Irix");
        IS_OS_IRIX = oSMatchesName3;
        boolean z17 = false;
        if (!getOSMatchesName("Linux") && !getOSMatchesName("LINUX")) {
            z16 = false;
        } else {
            z16 = true;
        }
        IS_OS_LINUX = z16;
        IS_OS_MAC = getOSMatchesName("Mac");
        boolean oSMatchesName4 = getOSMatchesName("Mac OS X");
        IS_OS_MAC_OSX = oSMatchesName4;
        IS_OS_OS2 = getOSMatchesName("OS/2");
        boolean oSMatchesName5 = getOSMatchesName("Solaris");
        IS_OS_SOLARIS = oSMatchesName5;
        boolean oSMatchesName6 = getOSMatchesName("SunOS");
        IS_OS_SUN_OS = oSMatchesName6;
        if (oSMatchesName || oSMatchesName2 || oSMatchesName3 || z16 || oSMatchesName4 || oSMatchesName5 || oSMatchesName6) {
            z17 = true;
        }
        IS_OS_UNIX = z17;
        IS_OS_WINDOWS = getOSMatchesName(OS_NAME_WINDOWS_PREFIX);
        IS_OS_WINDOWS_2000 = getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.0");
        IS_OS_WINDOWS_95 = getOSMatches("Windows 9", "4.0");
        IS_OS_WINDOWS_98 = getOSMatches("Windows 9", TVKCKeyGenerator.ENCRYPT_VER_4);
        IS_OS_WINDOWS_ME = getOSMatches(OS_NAME_WINDOWS_PREFIX, "4.9");
        IS_OS_WINDOWS_NT = getOSMatchesName("Windows NT");
        IS_OS_WINDOWS_XP = getOSMatches(OS_NAME_WINDOWS_PREFIX, TVKCKeyGenerator.ENCRYPT_VER_5);
        IS_OS_WINDOWS_VISTA = getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.0");
        IS_OS_WINDOWS_7 = getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.1");
    }

    public static File getJavaHome() {
        return new File(System.getProperty(JAVA_HOME_KEY));
    }

    public static File getJavaIoTmpDir() {
        return new File(System.getProperty(JAVA_IO_TMPDIR_KEY));
    }

    public static float getJavaVersion() {
        return JAVA_VERSION_FLOAT;
    }

    private static float getJavaVersionAsFloat() {
        return toVersionFloat(toJavaVersionIntArray(JAVA_VERSION, 3));
    }

    private static int getJavaVersionAsInt() {
        return toVersionInt(toJavaVersionIntArray(JAVA_VERSION, 3));
    }

    private static boolean getJavaVersionMatches(String str) {
        return isJavaVersionMatch(JAVA_VERSION_TRIMMED, str);
    }

    private static String getJavaVersionTrimmed() {
        if (JAVA_VERSION != null) {
            int i3 = 0;
            while (true) {
                String str = JAVA_VERSION;
                if (i3 < str.length()) {
                    char charAt = str.charAt(i3);
                    if (charAt >= '0' && charAt <= '9') {
                        return str.substring(i3);
                    }
                    i3++;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    private static boolean getOSMatches(String str, String str2) {
        return isOSMatch(OS_NAME, OS_VERSION, str, str2);
    }

    private static boolean getOSMatchesName(String str) {
        return isOSNameMatch(OS_NAME, str);
    }

    private static String getSystemProperty(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Caught a SecurityException reading the system property '");
            stringBuffer.append(str);
            stringBuffer.append("'; the SystemUtils property value will default to null.");
            printStream.println(stringBuffer.toString());
            return null;
        }
    }

    public static File getUserDir() {
        return new File(System.getProperty(USER_DIR_KEY));
    }

    public static File getUserHome() {
        return new File(System.getProperty(USER_HOME_KEY));
    }

    public static boolean isJavaAwtHeadless() {
        String str = JAVA_AWT_HEADLESS;
        if (str != null) {
            return str.equals(Boolean.TRUE.toString());
        }
        return false;
    }

    public static boolean isJavaVersionAtLeast(float f16) {
        return JAVA_VERSION_FLOAT >= f16;
    }

    static boolean isJavaVersionMatch(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    static boolean isOSMatch(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null || !str.startsWith(str3) || !str2.startsWith(str4)) {
            return false;
        }
        return true;
    }

    static boolean isOSNameMatch(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    static float toJavaVersionFloat(String str) {
        return toVersionFloat(toJavaVersionIntArray(str, 3));
    }

    static int toJavaVersionInt(String str) {
        return toVersionInt(toJavaVersionIntArray(str, 3));
    }

    static int[] toJavaVersionIntArray(String str) {
        return toJavaVersionIntArray(str, Integer.MAX_VALUE);
    }

    private static float toVersionFloat(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (iArr.length == 1) {
                return iArr[0];
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iArr[0]);
            stringBuffer.append('.');
            for (int i3 = 1; i3 < iArr.length; i3++) {
                stringBuffer.append(iArr[i3]);
            }
            try {
                return Float.parseFloat(stringBuffer.toString());
            } catch (Exception unused) {
            }
        }
        return 0.0f;
    }

    private static int toVersionInt(int[] iArr) {
        int i3 = 0;
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        if (length >= 1) {
            i3 = iArr[0] * 100;
        }
        if (length >= 2) {
            i3 += iArr[1] * 10;
        }
        if (length >= 3) {
            return i3 + iArr[2];
        }
        return i3;
    }

    public static boolean isJavaVersionAtLeast(int i3) {
        return JAVA_VERSION_INT >= i3;
    }

    private static int[] toJavaVersionIntArray(String str, int i3) {
        if (str == null) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        String[] split = StringUtils.split(str, "._- ");
        int min = Math.min(i3, split.length);
        int[] iArr = new int[min];
        int i16 = 0;
        for (int i17 = 0; i17 < split.length && i16 < i3; i17++) {
            String str2 = split[i17];
            if (str2.length() > 0) {
                try {
                    iArr[i16] = Integer.parseInt(str2);
                    i16++;
                } catch (Exception unused) {
                }
            }
        }
        if (min <= i16) {
            return iArr;
        }
        int[] iArr2 = new int[i16];
        System.arraycopy(iArr, 0, iArr2, 0, i16);
        return iArr2;
    }
}
