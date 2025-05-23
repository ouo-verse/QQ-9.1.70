package com.tencent.halley.common.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f113557a;

    /* renamed from: b, reason: collision with root package name */
    public String f113558b;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113557a = 0;
            this.f113558b = "";
        }
    }

    public h(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        this.f113558b = "";
        this.f113557a = i3;
        this.f113558b = TextUtils.isEmpty(str) ? "" : str;
    }
}
