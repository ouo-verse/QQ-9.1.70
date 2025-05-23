package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AssertUtil {
    static IPatchRedirector $redirector_;

    protected AssertUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void assertFalse(boolean z16) {
        assertTrue(null, !z16);
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertTrue(String str, boolean z16) {
        if (z16) {
            return;
        }
        fail(str);
    }

    public static void fail(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertTrue(boolean z16) {
        assertTrue(null, z16);
    }

    public static void fail() {
        fail(null);
    }
}
