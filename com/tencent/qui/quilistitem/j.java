package com.tencent.qui.quilistitem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final /* synthetic */ class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f363804a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13882);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[QUIListItemStyle.values().length];
        f363804a = iArr;
        iArr[QUIListItemStyle.Card.ordinal()] = 1;
        iArr[QUIListItemStyle.FullWidth.ordinal()] = 2;
    }
}
