package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
final class TroopMemberDistinctFragment$loadPagSoAsync$1$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function1<Boolean, Unit> $resultBlock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TroopMemberDistinctFragment$loadPagSoAsync$1$1(Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$resultBlock = function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 resultBlock, boolean z16) {
        Intrinsics.checkNotNullParameter(resultBlock, "$resultBlock");
        resultBlock.invoke(Boolean.valueOf(z16));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        final boolean initPagSo = ((IVasTempApi) QRoute.api(IVasTempApi.class)).initPagSo();
        if (!initPagSo) {
            QLog.e("TroopMemberDistinct", 1, "load so failed.");
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Function1<Boolean, Unit> function1 = this.$resultBlock;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberDistinctFragment$loadPagSoAsync$1$1.b(Function1.this, initPagSo);
            }
        });
    }
}
