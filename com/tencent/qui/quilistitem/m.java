package com.tencent.qui.quilistitem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qui.quilistitem.Group;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final /* synthetic */ class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f363806a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[Group.PositionType.values().length];
        f363806a = iArr;
        iArr[Group.PositionType.Top.ordinal()] = 1;
        iArr[Group.PositionType.Middle.ordinal()] = 2;
        iArr[Group.PositionType.Bottom.ordinal()] = 3;
        iArr[Group.PositionType.Only.ordinal()] = 4;
        iArr[Group.PositionType.Other.ordinal()] = 5;
    }
}
