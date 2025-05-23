package com.tencent.mobileqq.uniformdownload.util;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f306005a;

    /* renamed from: b, reason: collision with root package name */
    public int f306006b;

    /* renamed from: c, reason: collision with root package name */
    public String f306007c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f306008d;

    public e(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.f306005a = str;
        this.f306006b = i3;
        this.f306008d = new Bundle();
    }
}
