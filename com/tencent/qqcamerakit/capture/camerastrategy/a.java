package com.tencent.qqcamerakit.capture.camerastrategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqcamerakit.capture.camerastrategy.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f344887a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f344888b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11435);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344888b = false;
        }
    }

    public static void a(boolean z16) {
        f344887a = z16;
        b();
    }

    private static void b() {
        boolean z16;
        if (!f344887a) {
            com.tencent.qqcamerakit.common.e.e("CameraAPIStrategy", 1, "[Camera2]initIsSupportCamera2 return false, isCamera2Usable: " + f344887a);
            f344888b = false;
            return;
        }
        if (b.c(c.a.f344897f)) {
            com.tencent.qqcamerakit.common.e.e("CameraAPIStrategy", 1, "[Camera2]initIsSupportCamera2 return false, black device model, " + f344887a);
            f344888b = false;
            return;
        }
        int b06 = com.tencent.qqcamerakit.capture.camera2.b.b0();
        if (b06 != 1 && b06 != 0 && b06 != 3) {
            z16 = false;
        } else {
            z16 = true;
        }
        f344888b = z16;
        com.tencent.qqcamerakit.common.e.e("CameraAPIStrategy", 1, "[Camera2]initIsSupportCamera2 result:" + f344888b);
    }
}
