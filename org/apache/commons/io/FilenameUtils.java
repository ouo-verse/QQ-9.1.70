package org.apache.commons.io;

import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FilenameUtils {
    public static final char EXTENSION_SEPARATOR = '.';
    private static final int NOT_FOUND = -1;
    private static final char OTHER_SEPARATOR;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    static {
        if (isSystemWindows()) {
            OTHER_SEPARATOR = '/';
        } else {
            OTHER_SEPARATOR = '\\';
        }
    }

    public static String concat(String str, String str2) {
        int prefixLength = getPrefixLength(str2);
        if (prefixLength < 0) {
            return null;
        }
        if (prefixLength > 0) {
            return normalize(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return normalize(str2);
        }
        if (isSeparator(str.charAt(length - 1))) {
            return normalize(str + str2);
        }
        return normalize(str + '/' + str2);
    }

    public static boolean directoryContains(String str, String str2) throws IOException {
        if (str != null) {
            if (str2 == null) {
                return false;
            }
            IOCase iOCase = IOCase.SYSTEM;
            if (iOCase.checkEquals(str, str2)) {
                return false;
            }
            return iOCase.checkStartsWith(str2, str);
        }
        throw new IllegalArgumentException("Directory must not be null");
    }

    private static String doGetFullPath(String str, boolean z16) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength >= str.length()) {
            if (z16) {
                return getPrefix(str);
            }
            return str;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        if (indexOfLastSeparator < 0) {
            return str.substring(0, prefixLength);
        }
        int i3 = indexOfLastSeparator + (z16 ? 1 : 0);
        if (i3 == 0) {
            i3++;
        }
        return str.substring(0, i3);
    }

    private static String doGetPath(String str, int i3) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        int i16 = i3 + indexOfLastSeparator;
        if (prefixLength < str.length() && indexOfLastSeparator >= 0 && prefixLength < i16) {
            String substring = str.substring(prefixLength, i16);
            failIfNullBytePresent(substring);
            return substring;
        }
        return "";
    }

    private static String doNormalize(String str, char c16, boolean z16) {
        boolean z17;
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int prefixLength = getPrefixLength(str);
        if (prefixLength < 0) {
            return null;
        }
        int i3 = length + 2;
        char[] cArr = new char[i3];
        str.getChars(0, str.length(), cArr, 0);
        char c17 = SYSTEM_SEPARATOR;
        if (c16 == c17) {
            c17 = OTHER_SEPARATOR;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            if (cArr[i16] == c17) {
                cArr[i16] = c16;
            }
        }
        if (cArr[length - 1] != c16) {
            cArr[length] = c16;
            length++;
            z17 = false;
        } else {
            z17 = true;
        }
        int i17 = prefixLength + 1;
        int i18 = i17;
        while (i18 < length) {
            if (cArr[i18] == c16) {
                int i19 = i18 - 1;
                if (cArr[i19] == c16) {
                    System.arraycopy(cArr, i18, cArr, i19, length - i18);
                    length--;
                    i18--;
                }
            }
            i18++;
        }
        int i26 = i17;
        while (i26 < length) {
            if (cArr[i26] == c16) {
                int i27 = i26 - 1;
                if (cArr[i27] == '.' && (i26 == i17 || cArr[i26 - 2] == c16)) {
                    if (i26 == length - 1) {
                        z17 = true;
                    }
                    System.arraycopy(cArr, i26 + 1, cArr, i27, length - i26);
                    length -= 2;
                    i26--;
                }
            }
            i26++;
        }
        int i28 = prefixLength + 2;
        int i29 = i28;
        while (i29 < length) {
            if (cArr[i29] == c16 && cArr[i29 - 1] == '.' && cArr[i29 - 2] == '.' && (i29 == i28 || cArr[i29 - 3] == c16)) {
                if (i29 == i28) {
                    return null;
                }
                if (i29 == length - 1) {
                    z17 = true;
                }
                int i36 = i29 - 4;
                while (true) {
                    if (i36 >= prefixLength) {
                        if (cArr[i36] == c16) {
                            int i37 = i36 + 1;
                            System.arraycopy(cArr, i29 + 1, cArr, i37, length - i29);
                            length -= i29 - i36;
                            i29 = i37;
                            break;
                        }
                        i36--;
                    } else {
                        int i38 = i29 + 1;
                        System.arraycopy(cArr, i38, cArr, prefixLength, length - i29);
                        length -= i38 - prefixLength;
                        i29 = i17;
                        break;
                    }
                }
            }
            i29++;
        }
        if (length <= 0) {
            return "";
        }
        if (length <= prefixLength) {
            return new String(cArr, 0, length);
        }
        if (z17 && z16) {
            return new String(cArr, 0, length);
        }
        return new String(cArr, 0, length - 1);
    }

    public static boolean equals(String str, String str2) {
        return equals(str, str2, false, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalized(String str, String str2) {
        return equals(str, str2, true, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalizedOnSystem(String str, String str2) {
        return equals(str, str2, true, IOCase.SYSTEM);
    }

    public static boolean equalsOnSystem(String str, String str2) {
        return equals(str, str2, false, IOCase.SYSTEM);
    }

    private static void failIfNullBytePresent(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static String getBaseName(String str) {
        return removeExtension(getName(str));
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        if (indexOfExtension == -1) {
            return "";
        }
        return str.substring(indexOfExtension + 1);
    }

    public static String getFullPath(String str) {
        return doGetFullPath(str, true);
    }

    public static String getFullPathNoEndSeparator(String str) {
        return doGetFullPath(str, false);
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    public static String getPath(String str) {
        return doGetPath(str, 1);
    }

    public static String getPathNoEndSeparator(String str) {
        return doGetPath(str, 0);
    }

    public static String getPrefix(String str) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength > str.length()) {
            failIfNullBytePresent(str + '/');
            return str + '/';
        }
        String substring = str.substring(0, prefixLength);
        failIfNullBytePresent(substring);
        return substring;
    }

    public static int getPrefixLength(String str) {
        int min;
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            return isSeparator(charAt) ? 1 : 0;
        }
        if (charAt == '~') {
            int indexOf = str.indexOf(47, 1);
            int indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                return length + 1;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            min = Math.min(indexOf, indexOf2);
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char upperCase = Character.toUpperCase(charAt);
                if (upperCase >= 'A' && upperCase <= 'Z') {
                    if (length == 2 || !isSeparator(str.charAt(2))) {
                        return 2;
                    }
                    return 3;
                }
                if (upperCase != '/') {
                    return -1;
                }
                return 1;
            }
            if (!isSeparator(charAt) || !isSeparator(charAt2)) {
                return isSeparator(charAt) ? 1 : 0;
            }
            int indexOf3 = str.indexOf(47, 2);
            int indexOf4 = str.indexOf(92, 2);
            if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
                return -1;
            }
            if (indexOf3 == -1) {
                indexOf3 = indexOf4;
            }
            if (indexOf4 == -1) {
                indexOf4 = indexOf3;
            }
            min = Math.min(indexOf3, indexOf4);
        }
        return min + 1;
    }

    public static int indexOfExtension(String str) {
        int lastIndexOf;
        if (str == null || indexOfLastSeparator(str) > (lastIndexOf = str.lastIndexOf(46))) {
            return -1;
        }
        return lastIndexOf;
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isExtension(String str, String str2) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        if (str2 == null || str2.isEmpty()) {
            return indexOfExtension(str) == -1;
        }
        return getExtension(str).equals(str2);
    }

    private static boolean isSeparator(char c16) {
        if (c16 != '/' && c16 != '\\') {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSystemWindows() {
        if (SYSTEM_SEPARATOR == '\\') {
            return true;
        }
        return false;
    }

    public static String normalize(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, true);
    }

    public static String normalizeNoEndSeparator(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, false);
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        int indexOfExtension = indexOfExtension(str);
        if (indexOfExtension == -1) {
            return str;
        }
        return str.substring(0, indexOfExtension);
    }

    public static String separatorsToSystem(String str) {
        if (str == null) {
            return null;
        }
        if (isSystemWindows()) {
            return separatorsToWindows(str);
        }
        return separatorsToUnix(str);
    }

    public static String separatorsToUnix(String str) {
        if (str != null && str.indexOf(92) != -1) {
            return str.replace('\\', '/');
        }
        return str;
    }

    public static String separatorsToWindows(String str) {
        if (str != null && str.indexOf(47) != -1) {
            return str.replace('/', '\\');
        }
        return str;
    }

    static String[] splitOnTokens(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        int length = charArray.length;
        int i3 = 0;
        char c16 = 0;
        while (i3 < length) {
            char c17 = charArray[i3];
            if (c17 != '?' && c17 != '*') {
                sb5.append(c17);
            } else {
                if (sb5.length() != 0) {
                    arrayList.add(sb5.toString());
                    sb5.setLength(0);
                }
                if (c17 == '?') {
                    arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                } else if (c16 != '*') {
                    arrayList.add("*");
                }
            }
            i3++;
            c16 = c17;
        }
        if (sb5.length() != 0) {
            arrayList.add(sb5.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean wildcardMatch(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatchOnSystem(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SYSTEM);
    }

    public static boolean equals(String str, String str2, boolean z16, IOCase iOCase) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z16) {
            str = normalize(str);
            str2 = normalize(str2);
            if (str == null || str2 == null) {
                throw new NullPointerException("Error normalizing one or both of the file names");
            }
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        return iOCase.checkEquals(str, str2);
    }

    public static String normalize(String str, boolean z16) {
        return doNormalize(str, z16 ? '/' : '\\', true);
    }

    public static String normalizeNoEndSeparator(String str, boolean z16) {
        return doNormalize(str, z16 ? '/' : '\\', false);
    }

    public static boolean wildcardMatch(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            if (iOCase == null) {
                iOCase = IOCase.SENSITIVE;
            }
            String[] splitOnTokens = splitOnTokens(str2);
            Stack stack = new Stack();
            boolean z16 = false;
            int i3 = 0;
            int i16 = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i16 = iArr[0];
                    i3 = iArr[1];
                    z16 = true;
                }
                while (i16 < splitOnTokens.length) {
                    if (splitOnTokens[i16].equals(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        i3++;
                        if (i3 > str.length()) {
                            break;
                        }
                        z16 = false;
                        i16++;
                    } else if (splitOnTokens[i16].equals("*")) {
                        if (i16 == splitOnTokens.length - 1) {
                            i3 = str.length();
                        }
                        z16 = true;
                        i16++;
                    } else {
                        if (z16) {
                            i3 = iOCase.checkIndexOf(str, i3, splitOnTokens[i16]);
                            if (i3 == -1) {
                                break;
                            }
                            int checkIndexOf = iOCase.checkIndexOf(str, i3 + 1, splitOnTokens[i16]);
                            if (checkIndexOf >= 0) {
                                stack.push(new int[]{i16, checkIndexOf});
                            }
                            i3 += splitOnTokens[i16].length();
                            z16 = false;
                        } else {
                            if (!iOCase.checkRegionMatches(str, i3, splitOnTokens[i16])) {
                                break;
                            }
                            i3 += splitOnTokens[i16].length();
                            z16 = false;
                        }
                        i16++;
                    }
                }
                if (i16 == splitOnTokens.length && i3 == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }

    public static boolean isExtension(String str, String[] strArr) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        if (strArr == null || strArr.length == 0) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        for (String str2 : strArr) {
            if (extension.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExtension(String str, Collection<String> collection) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        if (collection == null || collection.isEmpty()) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (extension.equals(it.next())) {
                return true;
            }
        }
        return false;
    }
}
