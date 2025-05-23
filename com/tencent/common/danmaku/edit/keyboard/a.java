package com.tencent.common.danmaku.edit.keyboard;

import android.view.ViewTreeObserver;
import com.tencent.common.danmaku.inject.b;
import com.tencent.common.danmaku.util.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements ViewTreeObserver.OnGlobalLayoutListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final int f99691d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f99692e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f99693f;

    /* renamed from: h, reason: collision with root package name */
    private static final int f99694h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f99695i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f99691d = c.b(100.0f);
        f99692e = b.p().j();
        f99693f = c.b(220.0f);
        f99694h = c.b(380.0f);
        f99695i = c.b(300.0f);
    }

    public static boolean a(int i3) {
        if (i3 < f99692e - f99691d) {
            return true;
        }
        return false;
    }
}
