package com.tencent.qui.quilistitem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qui.quilistitem.Group;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final /* synthetic */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f363779a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f363780b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f363781c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[QUIListItemStyle.values().length];
        f363779a = iArr;
        QUIListItemStyle qUIListItemStyle = QUIListItemStyle.Card;
        iArr[qUIListItemStyle.ordinal()] = 1;
        QUIListItemStyle qUIListItemStyle2 = QUIListItemStyle.FullWidth;
        iArr[qUIListItemStyle2.ordinal()] = 2;
        int[] iArr2 = new int[Group.PositionType.values().length];
        f363780b = iArr2;
        iArr2[Group.PositionType.Only.ordinal()] = 1;
        iArr2[Group.PositionType.Top.ordinal()] = 2;
        iArr2[Group.PositionType.Bottom.ordinal()] = 3;
        iArr2[Group.PositionType.Middle.ordinal()] = 4;
        iArr2[Group.PositionType.Other.ordinal()] = 5;
        int[] iArr3 = new int[QUIListItemStyle.values().length];
        f363781c = iArr3;
        iArr3[qUIListItemStyle.ordinal()] = 1;
        iArr3[qUIListItemStyle2.ordinal()] = 2;
    }
}
