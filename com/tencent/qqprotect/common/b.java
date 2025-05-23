package com.tencent.qqprotect.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.HexUtil;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f363496a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f363496a = -1;
        }
    }

    public static String b(int i3) {
        return String.format("%d.%d.%d", Integer.valueOf(i3 >> 24), Integer.valueOf((16711680 & i3) >> 16), Integer.valueOf((i3 & 65280) >> 8));
    }

    public static String c() {
        byte[] c16 = com.tencent.mobileqq.guid.c.f213821a.c();
        if (c16 != null && c16.length > 0) {
            return HexUtil.bytes2HexStr(c16);
        }
        return null;
    }

    public static String d() {
        try {
            return o.c();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        return b(33751040);
    }

    public static String f() {
        return b(f363496a);
    }
}
