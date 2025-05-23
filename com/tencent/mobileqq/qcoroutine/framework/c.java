package com.tencent.mobileqq.qcoroutine.framework;

import com.tencent.mobileqq.qcoroutine.api.DispatcherType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final /* synthetic */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f261819a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9577);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[DispatcherType.values().length];
        f261819a = iArr;
        iArr[DispatcherType.MAIN.ordinal()] = 1;
        iArr[DispatcherType.CPU.ordinal()] = 2;
    }
}
