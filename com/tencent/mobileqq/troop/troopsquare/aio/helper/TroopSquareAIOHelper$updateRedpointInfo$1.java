package com.tencent.mobileqq.troop.troopsquare.aio.helper;

import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.j;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSquareRedpointInfoRsp;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSquareRedpointInfoRsp;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopSquareAIOHelper$updateRedpointInfo$1 extends Lambda implements Function1<GetGroupSquareRedpointInfoRsp, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSquareAIOHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSquareAIOHelper$updateRedpointInfo$1(TroopSquareAIOHelper troopSquareAIOHelper) {
        super(1);
        this.this$0 = troopSquareAIOHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSquareAIOHelper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSquareAIOHelper this$0, GetGroupSquareRedpointInfoRsp getGroupSquareRedpointInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.main.businesshelper.b bVar = this$0.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        j e16 = bVar.a().e();
        boolean z16 = getGroupSquareRedpointInfoRsp.showRedpoint;
        String str = getGroupSquareRedpointInfoRsp.content;
        Intrinsics.checkNotNullExpressionValue(str, "it.content");
        String str2 = getGroupSquareRedpointInfoRsp.ext;
        Intrinsics.checkNotNullExpressionValue(str2, "it.ext");
        e16.h(new AIOTitleEvent.GroupSquareRedpointEvent(z16, str, str2));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GetGroupSquareRedpointInfoRsp getGroupSquareRedpointInfoRsp) {
        invoke2(getGroupSquareRedpointInfoRsp);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final GetGroupSquareRedpointInfoRsp getGroupSquareRedpointInfoRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) getGroupSquareRedpointInfoRsp);
        } else {
            if (getGroupSquareRedpointInfoRsp == null) {
                return;
            }
            final TroopSquareAIOHelper troopSquareAIOHelper = this.this$0;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsquare.aio.helper.b
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSquareAIOHelper$updateRedpointInfo$1.b(TroopSquareAIOHelper.this, getGroupSquareRedpointInfoRsp);
                }
            });
        }
    }
}
