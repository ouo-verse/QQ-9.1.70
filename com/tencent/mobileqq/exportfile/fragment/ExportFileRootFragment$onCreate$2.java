package com.tencent.mobileqq.exportfile.fragment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
/* synthetic */ class ExportFileRootFragment$onCreate$2 extends FunctionReferenceImpl implements Function1<com.tencent.mobileqq.exportfile.fragment.rootpage.view.a, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExportFileRootFragment$onCreate$2(Object obj) {
        super(1, obj, ExportFileRootFragment.class, "handleUIState", "handleUIState(Lcom/tencent/mobileqq/exportfile/fragment/rootpage/view/RootPageUIState;)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.exportfile.fragment.rootpage.view.a aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.mobileqq.exportfile.fragment.rootpage.view.a p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((ExportFileRootFragment) this.receiver).handleUIState(p06);
    }
}
