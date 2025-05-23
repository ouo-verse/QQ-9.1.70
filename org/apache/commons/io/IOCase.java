package org.apache.commons.io;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum IOCase implements Serializable {
    SENSITIVE("Sensitive", true),
    INSENSITIVE("Insensitive", false),
    SYSTEM("System", !FilenameUtils.isSystemWindows());

    private static final long serialVersionUID = -6343169151696340687L;
    private final String name;
    private final transient boolean sensitive;

    IOCase(String str, boolean z16) {
        this.name = str;
        this.sensitive = z16;
    }

    public static IOCase forName(String str) {
        for (IOCase iOCase : values()) {
            if (iOCase.getName().equals(str)) {
                return iOCase;
            }
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public int checkCompareTo(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.sensitive) {
                return str.compareTo(str2);
            }
            return str.compareToIgnoreCase(str2);
        }
        throw new NullPointerException("The strings must not be null");
    }

    public boolean checkEndsWith(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.sensitive, str.length() - length, str2, 0, length);
    }

    public boolean checkEquals(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.sensitive) {
                return str.equals(str2);
            }
            return str.equalsIgnoreCase(str2);
        }
        throw new NullPointerException("The strings must not be null");
    }

    public int checkIndexOf(String str, int i3, String str2) {
        int length = str.length() - str2.length();
        if (length >= i3) {
            while (i3 <= length) {
                if (checkRegionMatches(str, i3, str2)) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        return -1;
    }

    public boolean checkRegionMatches(String str, int i3, String str2) {
        return str.regionMatches(!this.sensitive, i3, str2, 0, str2.length());
    }

    public boolean checkStartsWith(String str, String str2) {
        return str.regionMatches(!this.sensitive, 0, str2, 0, str2.length());
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.sensitive;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
