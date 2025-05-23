package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* synthetic */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f69681a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53143);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[IMsgListRepository.MsgListRepoOpType.values().length];
        f69681a = iArr;
        iArr[IMsgListRepository.MsgListRepoOpType.LoadNextPageFail.ordinal()] = 1;
        iArr[IMsgListRepository.MsgListRepoOpType.LoadPrePageFail.ordinal()] = 2;
    }
}
