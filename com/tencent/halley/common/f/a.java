package com.tencent.halley.common.f;

import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f113534a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f113535b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12685);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f113534a = true;
            f113535b = true;
        }
    }

    public static void a(String str, int i3, int i16, String str2, Map<String, String> map, Map<String, String> map2, boolean z16) {
        com.tencent.halley.common.a.b.a.a(str, i3, i16, str2, map, map2, z16);
    }

    public static void b(String str, int i3, int i16, String str2, Map<String, String> map, Map<String, String> map2, boolean z16) {
        com.tencent.halley.common.a.b.a.b(str, i3, i16, str2, map, map2, z16);
    }

    public static boolean a(String str, int i3, Map<String, String> map) {
        boolean z16;
        if (i3 != com.tencent.halley.common.a.c()) {
            return false;
        }
        if (f113534a && ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str))) {
            f113534a = false;
            z16 = true;
        } else {
            z16 = false;
        }
        if (f113535b && "HLHttpDirect".equals(str)) {
            String str2 = map.get("B15");
            if (!j.a(str2) && str2.equals("app")) {
                f113535b = false;
                return true;
            }
        }
        return z16;
    }
}
