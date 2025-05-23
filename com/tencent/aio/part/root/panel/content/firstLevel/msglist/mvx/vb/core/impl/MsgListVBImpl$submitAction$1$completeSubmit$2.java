package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
final /* synthetic */ class MsgListVBImpl$submitAction$1$completeSubmit$2 extends FunctionReferenceImpl implements Function0<Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MsgListVBImpl$submitAction$1$completeSubmit$2(IListUIOperationApi iListUIOperationApi) {
        super(0, iListUIOperationApi, IListUIOperationApi.class, "finishRefresh", "finishRefresh()V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iListUIOperationApi);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((IListUIOperationApi) this.receiver).finishRefresh();
    }
}
