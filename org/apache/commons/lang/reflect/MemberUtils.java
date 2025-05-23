package org.apache.commons.lang.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.SystemUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Method IS_SYNTHETIC;
    private static final Class[] ORDERED_PRIMITIVE_TYPES;
    static /* synthetic */ Class class$java$lang$reflect$Member;

    static {
        Method method;
        if (SystemUtils.isJavaVersionAtLeast(1.5f)) {
            try {
                Class cls = class$java$lang$reflect$Member;
                if (cls == null) {
                    cls = class$("java.lang.reflect.Member");
                    class$java$lang$reflect$Member = cls;
                }
                method = cls.getMethod("isSynthetic", ArrayUtils.EMPTY_CLASS_ARRAY);
            } catch (Exception unused) {
            }
            IS_SYNTHETIC = method;
            ORDERED_PRIMITIVE_TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        }
        method = null;
        IS_SYNTHETIC = method;
        ORDERED_PRIMITIVE_TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
    }

    MemberUtils() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e16) {
            throw new NoClassDefFoundError(e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int compareParameterTypes(Class[] clsArr, Class[] clsArr2, Class[] clsArr3) {
        float totalTransformationCost = getTotalTransformationCost(clsArr3, clsArr);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr3, clsArr2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        if (totalTransformationCost2 < totalTransformationCost) {
            return 1;
        }
        return 0;
    }

    private static float getObjectTransformationCost(Class cls, Class cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f16 = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && ClassUtils.isAssignable(cls, cls2)) {
                    f16 += 0.25f;
                    break;
                }
                f16 += 1.0f;
                cls = cls.getSuperclass();
            } else {
                break;
            }
        }
        if (cls == null) {
            return f16 + 1.5f;
        }
        return f16;
    }

    private static float getPrimitivePromotionCost(Class cls, Class cls2) {
        float f16;
        if (!cls.isPrimitive()) {
            cls = ClassUtils.wrapperToPrimitive(cls);
            f16 = 0.1f;
        } else {
            f16 = 0.0f;
        }
        int i3 = 0;
        while (cls != cls2) {
            Class[] clsArr = ORDERED_PRIMITIVE_TYPES;
            if (i3 >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i3]) {
                f16 += 0.1f;
                if (i3 < clsArr.length - 1) {
                    cls = clsArr[i3 + 1];
                }
            }
            i3++;
        }
        return f16;
    }

    private static float getTotalTransformationCost(Class[] clsArr, Class[] clsArr2) {
        float f16 = 0.0f;
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            f16 += getObjectTransformationCost(clsArr[i3], clsArr2[i3]);
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAccessible(Member member) {
        if (member != null && Modifier.isPublic(member.getModifiers()) && !isSynthetic(member)) {
            return true;
        }
        return false;
    }

    static boolean isPackageAccess(int i3) {
        if ((i3 & 7) == 0) {
            return true;
        }
        return false;
    }

    static boolean isSynthetic(Member member) {
        Method method = IS_SYNTHETIC;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(member, null)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void setAccessibleWorkaround(AccessibleObject accessibleObject) {
        if (accessibleObject != 0 && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                } catch (SecurityException unused) {
                }
            }
        }
    }
}
