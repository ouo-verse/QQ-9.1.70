package com.tencent.hy.common.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MMKVOptionEntity f114711a;

    /* renamed from: b, reason: collision with root package name */
    private String f114712b;

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f114711a = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            this.f114712b = str;
        }
    }

    private String b(String str) {
        return this.f114712b + "_" + str;
    }

    public int a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).intValue();
        }
        return this.f114711a.decodeInt(b(str), i3);
    }

    public void c(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        } else {
            this.f114711a.encodeInt(b(str), i3);
        }
    }
}
