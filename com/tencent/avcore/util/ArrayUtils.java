package com.tencent.avcore.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArrayUtils {
    static IPatchRedirector $redirector_;

    public ArrayUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static boolean contains(int[] iArr, int i3) {
        return indexOf(iArr, i3) != -1;
    }

    public static int indexOf(Object[] objArr, Object obj, int i3) {
        if (objArr == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (obj == null) {
            while (i3 < objArr.length) {
                if (objArr[i3] == null) {
                    return i3;
                }
                i3++;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i3 < objArr.length) {
                if (obj.equals(objArr[i3])) {
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i3) {
        if (objArr == null || i3 < 0) {
            return -1;
        }
        if (i3 >= objArr.length) {
            i3 = objArr.length - 1;
        }
        if (obj == null) {
            while (i3 >= 0) {
                if (objArr[i3] == null) {
                    return i3;
                }
                i3--;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i3 >= 0) {
                if (obj.equals(objArr[i3])) {
                    return i3;
                }
                i3--;
            }
        }
        return -1;
    }

    public static <T> boolean contains(List<T> list, T t16) {
        return list != null && list.indexOf(t16) >= 0;
    }

    public static int indexOf(int[] iArr, int i3) {
        return indexOf(iArr, i3, 0);
    }

    public static int indexOf(int[] iArr, int i3, int i16) {
        if (iArr == null) {
            return -1;
        }
        if (i16 < 0) {
            i16 = 0;
        }
        while (i16 < iArr.length) {
            if (i3 == iArr[i16]) {
                return i16;
            }
            i16++;
        }
        return -1;
    }
}
