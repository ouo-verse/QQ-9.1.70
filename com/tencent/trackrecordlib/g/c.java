package com.tencent.trackrecordlib.g;

import android.view.ViewConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f381135a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f381136b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f381137c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final float f381138d = 10.0f;

    /* renamed from: e, reason: collision with root package name */
    public static final int f381139e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f381135a = "unknown";
        f381136b = "unkonwn";
        f381137c = "";
        f381139e = ViewConfiguration.getLongPressTimeout();
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
