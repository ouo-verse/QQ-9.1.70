package com.tencent.mobileqq.msf.sdk.report;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f250708a = "MSFCatchedExceptionReporter";

    /* renamed from: b, reason: collision with root package name */
    private static Field f250709b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Throwable th5, String str, String str2) {
        if (th5 == null || str == null || str2 == null) {
            return;
        }
        a(th5, str);
        BaseApplication.getContext().getMSFInterfaceAdapter().handleCatchException(Thread.currentThread(), th5, str2, null);
    }

    private static void a(Throwable th5, String str) {
        try {
            if (f250709b == null) {
                f250709b = Throwable.class.getDeclaredField("detailMessage");
            }
            f250709b.setAccessible(true);
            f250709b.set(th5, str + ProgressTracer.SEPARATOR + th5.getMessage());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f250708a, 2, "addCatchedMsgTag failed : ", e16);
            }
        }
    }
}
