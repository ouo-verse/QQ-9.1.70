package com.tencent.mobileqq.qsec.qsecest;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QsecEst {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f276822a;

    /* renamed from: b, reason: collision with root package name */
    private static String f276823b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276822a = "";
            f276823b = "";
        }
    }

    public QsecEst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return "e_null";
        }
        try {
            byte[] d16 = d(context, str, str2);
            if (d16 == null || d16.length <= 0) {
                return "e_null";
            }
            return b.a().c(d16);
        } catch (Throwable unused) {
            return "e_th";
        }
    }

    private static native byte[] d(Context context, String str, String str2);
}
