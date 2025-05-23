package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class n {
    public static String a(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i3 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i16 = 0; i16 < objArr.length; i16++) {
                objArr[i16] = b(objArr[i16]);
            }
        }
        StringBuilder sb5 = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i17 = 0;
        while (i3 < objArr.length && (indexOf = valueOf.indexOf("%s", i17)) != -1) {
            sb5.append((CharSequence) valueOf, i17, indexOf);
            sb5.append(objArr[i3]);
            i17 = indexOf + 2;
            i3++;
        }
        sb5.append((CharSequence) valueOf, i17, valueOf.length());
        if (i3 < objArr.length) {
            sb5.append(" [");
            sb5.append(objArr[i3]);
            for (int i18 = i3 + 1; i18 < objArr.length; i18++) {
                sb5.append(", ");
                sb5.append(objArr[i18]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }

    private static String b(@NullableDecl Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e16) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e16);
            return "<" + str + " threw " + e16.getClass().getName() + ">";
        }
    }

    public static String c(String str, int i3) {
        j.m(str);
        boolean z16 = false;
        if (i3 <= 1) {
            if (i3 >= 0) {
                z16 = true;
            }
            j.f(z16, "invalid count: %s", i3);
            if (i3 == 0) {
                return "";
            }
            return str;
        }
        int length = str.length();
        long j3 = length * i3;
        int i16 = (int) j3;
        if (i16 == j3) {
            char[] cArr = new char[i16];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i17 = i16 - length;
                if (length < i17) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i17);
                    return new String(cArr);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j3);
        }
    }
}
