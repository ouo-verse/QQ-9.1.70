package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ArrayUtils {
    static IPatchRedirector $redirector_;

    public ArrayUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T> boolean contains(T[] tArr, T t16) {
        if (tArr != null && t16 != null) {
            for (T t17 : tArr) {
                if (t17 != null && t17.equals(t16)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isOutOfArrayIndex(int i3, List list) {
        if (list != null && i3 >= 0 && i3 < list.size()) {
            return false;
        }
        return true;
    }
}
