package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f251615a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f251616b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f251615a = HardCodeUtil.qqStr(R.string.obz);
            f251616b = HardCodeUtil.qqStr(R.string.obw);
        }
    }
}
