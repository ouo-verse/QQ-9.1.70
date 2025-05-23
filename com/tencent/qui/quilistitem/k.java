package com.tencent.qui.quilistitem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final /* synthetic */ class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f363805a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[QUIListItemBackgroundType.values().length];
        f363805a = iArr;
        iArr[QUIListItemBackgroundType.None.ordinal()] = 1;
        iArr[QUIListItemBackgroundType.NoneRound.ordinal()] = 2;
        iArr[QUIListItemBackgroundType.AllRound.ordinal()] = 3;
        iArr[QUIListItemBackgroundType.TopRound.ordinal()] = 4;
        iArr[QUIListItemBackgroundType.BottomRound.ordinal()] = 5;
        iArr[QUIListItemBackgroundType.FullWidth.ordinal()] = 6;
    }
}
