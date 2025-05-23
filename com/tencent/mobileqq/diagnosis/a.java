package com.tencent.mobileqq.diagnosis;

import android.content.Context;
import com.tencent.component.media.MtpConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f203562a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MtpConstants.FORMAT_AAC);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203562a = new AtomicBoolean(false);
        }
    }

    public static void a(Context context) {
        QLog.w("QQDiagnosisManager", 1, "QQDiagnosisManager init jump for PublicVersion!");
    }
}
