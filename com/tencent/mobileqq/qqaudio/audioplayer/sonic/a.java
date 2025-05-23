package com.tencent.mobileqq.qqaudio.audioplayer.sonic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.b;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static float f262196a;

    /* renamed from: b, reason: collision with root package name */
    public static float f262197b;

    /* renamed from: c, reason: collision with root package name */
    public static float f262198c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f262199d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f262196a = 1.0f;
        f262197b = 1.5f;
        f262198c = 1.8f;
        f262199d = false;
    }

    public static boolean a() {
        return f262199d;
    }

    public static boolean b(float f16) {
        if (f16 > 1.0f && Math.abs(f16 - 1.0f) > 0.0f) {
            return true;
        }
        return false;
    }

    public static void c() {
        if (!f262199d) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                System.loadLibrary("sonic");
                QLog.i("SonicLibraryLoad", 1, "9015 \u5361\u987f\u76d1\u6d4b, sonic so load cost: " + (System.currentTimeMillis() - currentTimeMillis));
                f262199d = true;
                b.c(true);
            } catch (Throwable th5) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("sonic", 2, "load error:" + th5.toString());
                    }
                    f262199d = false;
                    b.c(false);
                } catch (Throwable th6) {
                    b.c(f262199d);
                    throw th6;
                }
            }
        }
    }
}
