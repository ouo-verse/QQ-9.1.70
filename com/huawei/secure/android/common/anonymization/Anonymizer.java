package com.huawei.secure.android.common.anonymization;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Anonymizer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37740a = "Anonymizer";

    public static String maskAccountId(String str) {
        if (str != null && str.length() > 0) {
            if (str.length() <= 1) {
                return "*";
            }
            if (str.length() < 8) {
                return maskCommonString(str, 0, 1);
            }
            return maskCommonString(str, 0, 4);
        }
        return "";
    }

    public static String maskBankAccount(String str) {
        if (str != null && str.length() > 0) {
            if (str.length() <= 2) {
                return a.a(str, '*');
            }
            if (str.length() >= 11 && str.length() < 20) {
                return maskCommonString(str, 4, 4);
            }
            return maskCommonString(str, 6, 4);
        }
        return "";
    }

    public static String maskBirthday(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return a.a(str, '*');
        }
        String[] a16 = a.a(str, 4);
        return a.a("", a.a(a16, 0), a.a(a.a(a16, 1), "0123456789", "*"));
    }

    public static String maskCommonString(String str, int i3, int i16) {
        int length;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 < 0) {
            i16 = 0;
        }
        if (str.length() <= i3 + i16) {
            length = str.length() - 1;
            i3 = 1;
        } else {
            length = str.length() - i16;
        }
        String[] a16 = a.a(str, i3, length);
        return a.a("", a.a(a16, 0), a.a(a.a(a16, 1), '*'), a.a(a16, 2));
    }

    public static String maskEmail(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            String[] a16 = a.a(str, 1);
            return a.a("", a.a(a16, 0), a.a(a.a(a16, 1), '*'));
        }
        String[] a17 = a.a(str, indexOf, indexOf + 1, str.lastIndexOf(46));
        return a.a("", a.a(a.a(a17, 0), '*'), a.a(a17, 1), a.a(a.a(a17, 2), '*'), a.a(a17, 3));
    }

    public static String maskId(String str) {
        if (str != null && str.length() > 0) {
            return maskCommonString(str, str.length() - 12, 0);
        }
        return "";
    }

    public static String maskImeiImsi(String str) {
        if (str != null && str.length() > 0) {
            return maskCommonString(str, str.length() - 4, 0);
        }
        return "";
    }

    public static String maskIpV4(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return a.a(str, '*');
        }
        String[] a16 = a.a(str, lastIndexOf + 1);
        return a.a("", a.a(a16, 0), a.a(a.a(a16, 1), '*'));
    }

    public static String maskIpV6(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String[] b16 = a.b(str, ':');
        if (b16.length <= 1) {
            return a.a(str, '*');
        }
        if (b16.length != 8) {
            String[] a16 = a.a(str, str.indexOf(58) + 1);
            return a.a("", a.a(a16, 0), a.a(a.a(a16, 1), "0123456789ABCDEFabcdef", "*"));
        }
        b16[2] = maskLower8Bit(b16[2]);
        for (int i3 = 3; i3 < b16.length; i3++) {
            b16[i3] = a.a(b16[i3], '*');
        }
        return a.a(":", b16);
    }

    public static String maskLower8Bit(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f37740a, "maskLower8Bit: s is null");
            return "";
        }
        if (str.length() <= 2) {
            return a.a(str, '*');
        }
        String[] a16 = a.a(str, str.length() - 2);
        return a.a("", a.a(a16, 0), a.a(a.a(a16, 1), '*'));
    }

    public static String maskMac(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int a16 = a.a(str, '-', 2);
        if (a16 < 0) {
            return a.a(str, "0123456789ABCDEFabcdef", "*");
        }
        String[] a17 = a.a(str, a16);
        return a.a("", a.a(a17, 0), a.a(a.a(a17, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static String maskName(String str) {
        if (str != null && str.length() > 0) {
            if (str.length() <= 1) {
                return "*";
            }
            return maskCommonString(str, 1, 0);
        }
        return "";
    }

    public static String maskPhone(String str) {
        if (str != null && str.length() > 0) {
            if (str.length() <= 2) {
                return a.a(str, '*');
            }
            if (str.length() >= 8 && str.length() < 11) {
                return maskCommonString(str, 2, 2);
            }
            return maskCommonString(str, 3, 4);
        }
        return "";
    }
}
