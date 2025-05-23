package c.t.m.g;

import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public class h1 {
    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean b(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            return false;
        }
        return true;
    }

    public static boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean a(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
