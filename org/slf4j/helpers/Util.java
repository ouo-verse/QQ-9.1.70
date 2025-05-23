package org.slf4j.helpers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Util {
    private static ClassContextSecurityManager SECURITY_MANAGER = null;
    private static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ClassContextSecurityManager extends SecurityManager {
        ClassContextSecurityManager() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    Util() {
    }

    public static Class<?> getCallingClass() {
        int i3;
        ClassContextSecurityManager securityManager = getSecurityManager();
        if (securityManager == null) {
            return null;
        }
        Class<?>[] classContext = securityManager.getClassContext();
        String name = Util.class.getName();
        int i16 = 0;
        while (i16 < classContext.length && !name.equals(classContext[i16].getName())) {
            i16++;
        }
        if (i16 < classContext.length && (i3 = i16 + 2) < classContext.length) {
            return classContext[i3];
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    private static ClassContextSecurityManager getSecurityManager() {
        ClassContextSecurityManager classContextSecurityManager = SECURITY_MANAGER;
        if (classContextSecurityManager != null) {
            return classContextSecurityManager;
        }
        if (SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
            return null;
        }
        ClassContextSecurityManager safeCreateSecurityManager = safeCreateSecurityManager();
        SECURITY_MANAGER = safeCreateSecurityManager;
        SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
        return safeCreateSecurityManager;
    }

    public static final void report(String str, Throwable th5) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th5.printStackTrace();
    }

    private static ClassContextSecurityManager safeCreateSecurityManager() {
        try {
            return new ClassContextSecurityManager();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean safeGetBooleanSystemProperty(String str) {
        String safeGetSystemProperty = safeGetSystemProperty(str);
        if (safeGetSystemProperty == null) {
            return false;
        }
        return safeGetSystemProperty.equalsIgnoreCase("true");
    }

    public static String safeGetSystemProperty(String str) {
        if (str != null) {
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("null input");
    }

    public static final void report(String str) {
        System.err.println("SLF4J: " + str);
    }
}
