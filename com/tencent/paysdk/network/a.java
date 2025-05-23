package com.tencent.paysdk.network;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.network.RequestWrapper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f342044a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[RequestWrapper.RequestType.values().length];
        f342044a = iArr;
        iArr[RequestWrapper.RequestType.GET.ordinal()] = 1;
        iArr[RequestWrapper.RequestType.POST.ordinal()] = 2;
    }
}
