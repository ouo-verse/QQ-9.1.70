package com.tencent.qui.quilistitem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qui.quilistitem.QUISettingsRecyclerView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final /* synthetic */ class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f363816a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[QUISettingsRecyclerView.DividerStyle.values().length];
        f363816a = iArr;
        iArr[QUISettingsRecyclerView.DividerStyle.Middle.ordinal()] = 1;
        iArr[QUISettingsRecyclerView.DividerStyle.ShowAll.ordinal()] = 2;
        iArr[QUISettingsRecyclerView.DividerStyle.Hidden.ordinal()] = 3;
    }
}
