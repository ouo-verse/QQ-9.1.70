package com.tencent.cache.core.manager.control;

import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public final /* synthetic */ class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f98742a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13827);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[ClearMode.values().length];
        f98742a = iArr;
        iArr[ClearMode.LowMemory.ordinal()] = 1;
    }
}
