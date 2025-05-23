package com.tencent.luggage.wxa.vl;

import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {
    public static Object a(Object obj, Object obj2) {
        return obj == null ? obj2 : obj;
    }

    public static int a(Class cls) {
        if (!cls.isEnum()) {
            return 0;
        }
        int i3 = 0;
        for (Object obj : cls.getEnumConstants()) {
            i3 = Math.max(((Enum) obj).name().length(), i3);
        }
        return i3;
    }

    public static Enum a(String str, Class cls) {
        int a16 = a(cls);
        if (!w0.c(str) && str.length() <= a16) {
            String upperCase = str.toUpperCase();
            for (Enum r36 : (Enum[]) cls.getEnumConstants()) {
                if (upperCase.equals(r36.name())) {
                    return r36;
                }
            }
        }
        return null;
    }

    public static Integer a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf((int) Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
