package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface f {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: g4, reason: collision with root package name */
    public static final String f211019g4;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(38206), (Class<?>) f.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            f211019g4 = HardCodeUtil.qqStr(R.string.mom);
        }
    }
}
