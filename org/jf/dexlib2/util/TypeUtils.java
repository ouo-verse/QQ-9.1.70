package org.jf.dexlib2.util;

import javax.annotation.Nonnull;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TypeUtils {
    TypeUtils() {
    }

    public static boolean canAccessClass(@Nonnull String str, @Nonnull ClassDef classDef) {
        if (AccessFlags.PUBLIC.isSet(classDef.getAccessFlags())) {
            return true;
        }
        return getPackage(classDef.getType()).equals(getPackage(str));
    }

    @Nonnull
    public static String getPackage(@Nonnull String str) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf < 0) {
            return "";
        }
        return str.substring(1, lastIndexOf);
    }

    public static boolean isPrimitiveType(String str) {
        if (str.length() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isWideType(@Nonnull String str) {
        char charAt = str.charAt(0);
        return charAt == 'J' || charAt == 'D';
    }

    public static boolean isWideType(@Nonnull TypeReference typeReference) {
        return isWideType(typeReference.getType());
    }
}
