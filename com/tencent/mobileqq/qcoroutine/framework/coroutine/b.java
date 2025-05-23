package com.tencent.mobileqq.qcoroutine.framework.coroutine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final /* synthetic */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f261822a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f261823b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10948);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[RunnableType.values().length];
        f261822a = iArr;
        RunnableType runnableType = RunnableType.LAUNCH;
        iArr[runnableType.ordinal()] = 1;
        RunnableType runnableType2 = RunnableType.ASYNC;
        iArr[runnableType2.ordinal()] = 2;
        int[] iArr2 = new int[RunnableType.values().length];
        f261823b = iArr2;
        iArr2[runnableType.ordinal()] = 1;
        iArr2[runnableType2.ordinal()] = 2;
    }
}
