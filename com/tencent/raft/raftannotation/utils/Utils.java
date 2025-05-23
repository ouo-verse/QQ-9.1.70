package com.tencent.raft.raftannotation.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Utils {
    static IPatchRedirector $redirector_;

    public Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.trim().isEmpty();
    }

    public static Object makeParamValue(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Double.TYPE) {
            return 0;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
