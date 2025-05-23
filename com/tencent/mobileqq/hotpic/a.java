package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f237004a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f237005b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51332);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f237004a = HardCodeUtil.qqStr(R.string.j_b);
            f237005b = HardCodeUtil.qqStr(R.string.j_a);
        }
    }
}
