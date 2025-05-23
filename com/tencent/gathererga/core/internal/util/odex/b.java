package com.tencent.gathererga.core.internal.util.odex;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface b {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f108323a;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(55961), (Class<?>) b.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            f108323a = new byte[]{Byte.MAX_VALUE, 69, 76, 70};
        }
    }

    c getHeader();
}
