package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* synthetic */ class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f69545a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46440);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[IMsgListRepository.MsgListRepoOpType.values().length];
        f69545a = iArr;
        iArr[IMsgListRepository.MsgListRepoOpType.LoadNextPage.ordinal()] = 1;
        iArr[IMsgListRepository.MsgListRepoOpType.LoadPrePage.ordinal()] = 2;
    }
}
