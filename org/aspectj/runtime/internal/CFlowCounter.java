package org.aspectj.runtime.internal;

import org.aspectj.runtime.internal.cflowstack.ThreadCounter;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactory;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CFlowCounter {
    private static ThreadStackFactory tsFactory;
    private ThreadCounter flowHeightHandler = tsFactory.getNewThreadCounter();

    static {
        selectFactoryForVMVersion();
    }

    private static String getSystemPropertyWithoutSecurityException(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (SecurityException unused) {
            return str2;
        }
    }

    private static ThreadStackFactory getThreadLocalStackFactory() {
        return new ThreadStackFactoryImpl();
    }

    private static ThreadStackFactory getThreadLocalStackFactoryFor11() {
        return new ThreadStackFactoryImpl11();
    }

    public static String getThreadStackFactoryClassName() {
        return tsFactory.getClass().getName();
    }

    private static void selectFactoryForVMVersion() {
        String systemPropertyWithoutSecurityException = getSystemPropertyWithoutSecurityException("aspectj.runtime.cflowstack.usethreadlocal", "unspecified");
        boolean z16 = false;
        if (!systemPropertyWithoutSecurityException.equals("unspecified") ? systemPropertyWithoutSecurityException.equals("yes") || systemPropertyWithoutSecurityException.equals("true") : System.getProperty("java.class.version", "0.0").compareTo("46.0") >= 0) {
            z16 = true;
        }
        if (z16) {
            tsFactory = getThreadLocalStackFactory();
        } else {
            tsFactory = getThreadLocalStackFactoryFor11();
        }
    }

    public void dec() {
        this.flowHeightHandler.dec();
        if (!this.flowHeightHandler.isNotZero()) {
            this.flowHeightHandler.removeThreadCounter();
        }
    }

    public void inc() {
        this.flowHeightHandler.inc();
    }

    public boolean isValid() {
        return this.flowHeightHandler.isNotZero();
    }
}
