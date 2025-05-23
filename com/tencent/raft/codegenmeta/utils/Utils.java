package com.tencent.raft.codegenmeta.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.Collection;
import java.util.Map;

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

    public static String getDeclareRefName(String str) {
        return str.replace(Constants.Configs.DECLARES_REF, "");
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.size() == 0;
    }
}
