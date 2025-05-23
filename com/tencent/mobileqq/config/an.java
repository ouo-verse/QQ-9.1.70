package com.tencent.mobileqq.config;

import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class an {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final an f202305a = new an();
    }

    an() {
    }

    public static an b() {
        return a.f202305a;
    }

    private static void h(Exception exc, String str, String str2) {
        CaughtExceptionReportProxy.e(new QConfigureException(exc, "TAG: " + str2 + " Message: " + exc.getMessage()), str);
    }

    public void c(l<?> lVar, int i3, Exception exc) {
        int type = lVar.type();
        if (QLog.isColorLevel()) {
            QLog.d("QConfigWatchDog", 2, "handleParsedJsonOrXmlException, parsed type=" + type + ", version=" + i3, exc);
        }
        h(exc, "parsed config failed, type=" + type + ", version=" + i3, "QConfigWatchDog_parsedConfig");
        a(lVar, i3, exc);
    }

    public void d(m<?, ?> mVar, File file, Exception exc) {
        if (QLog.isColorLevel()) {
            QLog.d("QConfigWatchDog", 2, "handleParsedIOException", exc);
        }
        h(exc, "write\\read IO failed", "QConfigWatchDog_parsedIO");
        f(mVar, file, exc);
    }

    public void e(Class<?> cls, Exception exc) {
        if (QLog.isColorLevel()) {
            QLog.d("QConfigWatchDog", 2, "handleParsedJsonOrXmlException", exc);
        }
        h(exc, "parsed json\\Xml failed", "QConfigWatchDog_parsedIO");
        g(cls, exc);
    }

    private void g(Class<?> cls, Exception exc) {
    }

    private void a(l<?> lVar, int i3, Exception exc) {
    }

    private void f(m<?, ?> mVar, File file, Exception exc) {
    }
}
