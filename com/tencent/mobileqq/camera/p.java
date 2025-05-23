package com.tencent.mobileqq.camera;

import android.hardware.Camera;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
class p implements Camera.PreviewCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static long f201023d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71181);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f201023d = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ g a(p pVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ h b(p pVar) {
        throw null;
    }
}
