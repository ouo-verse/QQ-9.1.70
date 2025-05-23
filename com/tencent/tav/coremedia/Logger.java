package com.tencent.tav.coremedia;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Logger {
    private static ILoggerProxy proxy;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface ILoggerProxy {
        void e(String str, String str2, Exception exc);
    }

    public static synchronized void e(String str, String str2, Exception exc) {
        synchronized (Logger.class) {
            ILoggerProxy iLoggerProxy = proxy;
            if (iLoggerProxy != null) {
                iLoggerProxy.e(str, str2, exc);
            }
        }
    }

    public static synchronized void setProxy(ILoggerProxy iLoggerProxy) {
        synchronized (Logger.class) {
            proxy = iLoggerProxy;
        }
    }
}
