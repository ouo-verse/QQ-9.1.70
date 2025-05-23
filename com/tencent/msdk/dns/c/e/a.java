package com.tencent.msdk.dns.c.e;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a {
    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static String b(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    public static String c(String[] strArr, String str) {
        if (!i(strArr) && !TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : strArr) {
                sb5.append(str2);
                sb5.append(str);
            }
            if (sb5.length() > 0) {
                sb5.setLength(sb5.length() - 1);
            }
            return sb5.toString();
        }
        return "";
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            com.tencent.msdk.dns.base.log.c.c("Close %s", closeable);
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static boolean f(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static <E> String h(Collection<E> collection) {
        StringBuilder sb5 = new StringBuilder("[");
        if (!f(collection)) {
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                sb5.append(b(it.next()));
                sb5.append(", ");
            }
            sb5.setLength(sb5.length() - 2);
        }
        sb5.append(']');
        return sb5.toString();
    }

    public static boolean i(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            return false;
        }
        return true;
    }
}
