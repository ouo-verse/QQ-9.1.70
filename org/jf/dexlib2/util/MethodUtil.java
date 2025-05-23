package org.jf.dexlib2.util;

import com.google.common.base.k;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.util.CharSequenceUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MethodUtil {
    private static int directMask = (AccessFlags.STATIC.getValue() | AccessFlags.PRIVATE.getValue()) | AccessFlags.CONSTRUCTOR.getValue();
    public static k<Method> METHOD_IS_DIRECT = new k<Method>() { // from class: org.jf.dexlib2.util.MethodUtil.1
        @Override // com.google.common.base.k
        public boolean apply(@Nullable Method method) {
            return method != null && MethodUtil.isDirect(method);
        }
    };
    public static k<Method> METHOD_IS_VIRTUAL = new k<Method>() { // from class: org.jf.dexlib2.util.MethodUtil.2
        @Override // com.google.common.base.k
        public boolean apply(@Nullable Method method) {
            return (method == null || MethodUtil.isDirect(method)) ? false : true;
        }
    };

    MethodUtil() {
    }

    public static int getParameterRegisterCount(@Nonnull Method method) {
        return getParameterRegisterCount(method, isStatic(method));
    }

    public static String getShorty(Collection<? extends CharSequence> collection, String str) {
        StringBuilder sb5 = new StringBuilder(collection.size() + 1);
        sb5.append(getShortyType(str));
        Iterator<? extends CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            sb5.append(getShortyType(it.next()));
        }
        return sb5.toString();
    }

    private static char getShortyType(CharSequence charSequence) {
        if (charSequence.length() > 1) {
            return 'L';
        }
        return charSequence.charAt(0);
    }

    public static boolean isConstructor(@Nonnull MethodReference methodReference) {
        return methodReference.getName().equals("<init>");
    }

    public static boolean isDirect(@Nonnull Method method) {
        if ((method.getAccessFlags() & directMask) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isPackagePrivate(@Nonnull Method method) {
        if ((method.getAccessFlags() & (AccessFlags.PRIVATE.getValue() | AccessFlags.PROTECTED.getValue() | AccessFlags.PUBLIC.getValue())) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isStatic(@Nonnull Method method) {
        return AccessFlags.STATIC.isSet(method.getAccessFlags());
    }

    public static boolean methodSignaturesMatch(@Nonnull MethodReference methodReference, @Nonnull MethodReference methodReference2) {
        if (methodReference.getName().equals(methodReference2.getName()) && methodReference.getReturnType().equals(methodReference2.getReturnType()) && CharSequenceUtils.listEquals(methodReference.getParameterTypes(), methodReference2.getParameterTypes())) {
            return true;
        }
        return false;
    }

    public static int getParameterRegisterCount(@Nonnull MethodReference methodReference, boolean z16) {
        return getParameterRegisterCount(methodReference.getParameterTypes(), z16);
    }

    public static int getParameterRegisterCount(@Nonnull Collection<? extends CharSequence> collection, boolean z16) {
        Iterator<? extends CharSequence> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            char charAt = it.next().charAt(0);
            i3 = (charAt == 'J' || charAt == 'D') ? i3 + 2 : i3 + 1;
        }
        return !z16 ? i3 + 1 : i3;
    }
}
