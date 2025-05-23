package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f293265a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75917);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f293265a = new int[]{1, 2, 3, 4, 5};
        }
    }

    public static final int a(int i3) {
        if (i3 >= 0) {
            int[] iArr = f293265a;
            if (i3 < iArr.length) {
                return iArr[i3];
            }
            return -1;
        }
        return -1;
    }

    public static final String b(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return "unknown";
                        }
                        return "BUSID_ASK_ANONYMOUSLY";
                    }
                    return "BUSID_NEWFRD_MINI_CARD";
                }
                return "BUSID_NICE_PICS";
            }
            return "BUSID_BASE_PROFILE";
        }
        return "BUSID_INTIMATE_ANNIVERSARY";
    }
}
