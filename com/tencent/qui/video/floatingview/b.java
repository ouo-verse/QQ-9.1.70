package com.tencent.qui.video.floatingview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f363897a;

    /* renamed from: b, reason: collision with root package name */
    public String f363898b;

    public b(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
        } else {
            this.f363897a = i3;
            this.f363898b = str;
        }
    }

    public static b a() {
        return new b(5, "\u6b63\u5728\u8bed\u97f3\u901a\u8bdd\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }

    public static b b() {
        return new b(2, "context \u4e3a\u7a7a");
    }

    public static b c() {
        return new b(1, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR);
    }

    public static b d() {
        return new b(4, "\u6ca1\u6709\u6743\u9650");
    }

    public static b e() {
        return new b(3, "\u5df2\u6709\u60ac\u6d6e\u7a97,\u5982\u679c\u9700\u8981\u663e\u793a");
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QUIVideoFloatError{mErrorCode=" + this.f363897a + ", mErrorMsg='" + this.f363898b + "'}";
    }
}
