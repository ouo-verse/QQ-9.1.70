package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.IFetchRobotRecommendCardsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardsReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardsRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "seq", "", "invoke", "(I)Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class RobotService$fetchMobileRobotRecommendCards$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ IFetchRobotRecommendCardsCallback $cb;
    final /* synthetic */ RobotRecommendCardsReq $request;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$fetchMobileRobotRecommendCards$2(RobotService robotService, RobotRecommendCardsReq robotRecommendCardsReq, IFetchRobotRecommendCardsCallback iFetchRobotRecommendCardsCallback) {
        super(1);
        this.this$0 = robotService;
        this.$request = robotRecommendCardsReq;
        this.$cb = iFetchRobotRecommendCardsCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, robotRecommendCardsReq, iFetchRobotRecommendCardsCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RobotService this$0, final IFetchRobotRecommendCardsCallback iFetchRobotRecommendCardsCallback, final int i3, final String str, final RobotRecommendCardsRsp robotRecommendCardsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.oh
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$fetchMobileRobotRecommendCards$2.d(IFetchRobotRecommendCardsCallback.this, i3, str, robotRecommendCardsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IFetchRobotRecommendCardsCallback iFetchRobotRecommendCardsCallback, int i3, String str, RobotRecommendCardsRsp robotRecommendCardsRsp) {
        if (iFetchRobotRecommendCardsCallback != null) {
            iFetchRobotRecommendCardsCallback.onResult(i3, str, robotRecommendCardsRsp);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        return invoke(num.intValue());
    }

    @Nullable
    public final Unit invoke(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        IKernelRobotService service = this.this$0.getService();
        if (service == null) {
            return null;
        }
        RobotRecommendCardsReq robotRecommendCardsReq = this.$request;
        final RobotService robotService = this.this$0;
        final IFetchRobotRecommendCardsCallback iFetchRobotRecommendCardsCallback = this.$cb;
        service.fetchMobileRobotRecommendCards(robotRecommendCardsReq, new IFetchRobotRecommendCardsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.og
            @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchRobotRecommendCardsCallback
            public final void onResult(int i16, String str, RobotRecommendCardsRsp robotRecommendCardsRsp) {
                RobotService$fetchMobileRobotRecommendCards$2.c(RobotService.this, iFetchRobotRecommendCardsCallback, i16, str, robotRecommendCardsRsp);
            }
        });
        return Unit.INSTANCE;
    }
}
