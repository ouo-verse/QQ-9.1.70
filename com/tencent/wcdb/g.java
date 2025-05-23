package com.tencent.wcdb;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.Collator;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f384434a;

    /* renamed from: b, reason: collision with root package name */
    private static Collator f384435b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f384434a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            f384435b = null;
        }
    }

    public static int a(int i3, int i16) {
        return Math.max(i3 - (i16 / 3), 0);
    }

    private static int b(String str) {
        int i3 = 0;
        for (int i16 = 0; i16 < 3; i16++) {
            int charAt = str.charAt(i16);
            if (charAt >= 97 && charAt <= 122) {
                charAt = (charAt - 97) + 65;
            } else if (charAt >= 128) {
                return 0;
            }
            i3 |= (charAt & 127) << (i16 * 8);
        }
        return i3;
    }

    public static int c(String[] strArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (strArr[i3].equals("_id")) {
                return i3;
            }
        }
        return -1;
    }

    public static int d(String str) {
        String trim = str.trim();
        if (trim.length() < 3) {
            return 99;
        }
        switch (b(trim)) {
            case 4279873:
            case 5522756:
                return 9;
            case 4280912:
                return 7;
            case 4476485:
            case 5066563:
                return 5;
            case 4477013:
            case 4998468:
            case 5260626:
            case 5459529:
                return 2;
            case 4543043:
            case 5198404:
            case 5524545:
                return 8;
            case 4670786:
                return 4;
            case 4998483:
                return 1;
            case 5001042:
                return 6;
            case 5526593:
                return 3;
            default:
                return 99;
        }
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if (!(obj instanceof Float) && !(obj instanceof Double)) {
            if (!(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
                return 3;
            }
            return 1;
        }
        return 2;
    }

    public static boolean f(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }
}
