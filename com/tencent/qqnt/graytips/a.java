package com.tencent.qqnt.graytips;

import android.graphics.Color;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int f356790a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f356791b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f356792c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f356793d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31796);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f356790a = Color.parseColor("#8C8C8C");
        f356791b = Color.parseColor("#FF4D94FF");
        f356792c = Color.parseColor("#FFFF596A");
        f356793d = Color.parseColor("#FF3DCAA5");
    }
}
