package com.tencent.paysdk.jsbridge;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.api.IUserInfoProvider;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final /* synthetic */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f342028a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12737);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[IUserInfoProvider.UserType.values().length];
        f342028a = iArr;
        iArr[IUserInfoProvider.UserType.QQ.ordinal()] = 1;
        iArr[IUserInfoProvider.UserType.QQ_SKEY.ordinal()] = 2;
        iArr[IUserInfoProvider.UserType.WX.ordinal()] = 3;
    }
}
