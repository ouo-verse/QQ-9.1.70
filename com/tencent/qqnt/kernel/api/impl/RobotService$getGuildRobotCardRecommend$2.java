package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotCardRecommendReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotCardRecommendRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotCardRecommendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "seq", "", "invoke", "(I)Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class RobotService$getGuildRobotCardRecommend$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ IGetGuildRobotCardRecommendCallback $cb;
    final /* synthetic */ String $method;
    final /* synthetic */ GProGuildRobotCardRecommendReq $req;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$getGuildRobotCardRecommend$2(RobotService robotService, GProGuildRobotCardRecommendReq gProGuildRobotCardRecommendReq, String str, IGetGuildRobotCardRecommendCallback iGetGuildRobotCardRecommendCallback) {
        super(1);
        this.this$0 = robotService;
        this.$req = gProGuildRobotCardRecommendReq;
        this.$method = str;
        this.$cb = iGetGuildRobotCardRecommendCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, gProGuildRobotCardRecommendReq, str, iGetGuildRobotCardRecommendCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final RobotService this$0, final String method, final int i3, final IGetGuildRobotCardRecommendCallback iGetGuildRobotCardRecommendCallback, final int i16, final String str, final GProGuildRobotCardRecommendRsp gProGuildRobotCardRecommendRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ox
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$getGuildRobotCardRecommend$2.d(RobotService.this, method, i16, str, i3, iGetGuildRobotCardRecommendCallback, gProGuildRobotCardRecommendRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RobotService this$0, String method, int i3, String str, int i16, IGetGuildRobotCardRecommendCallback iGetGuildRobotCardRecommendCallback, GProGuildRobotCardRecommendRsp gProGuildRobotCardRecommendRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        if (iGetGuildRobotCardRecommendCallback != null) {
            iGetGuildRobotCardRecommendCallback.onGetGuildRobotCardRecommend(i3, str, gProGuildRobotCardRecommendRsp);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        return invoke(num.intValue());
    }

    @Nullable
    public final Unit invoke(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        IKernelRobotService service = this.this$0.getService();
        if (service == null) {
            return null;
        }
        GProGuildRobotCardRecommendReq gProGuildRobotCardRecommendReq = this.$req;
        final RobotService robotService = this.this$0;
        final String str = this.$method;
        final IGetGuildRobotCardRecommendCallback iGetGuildRobotCardRecommendCallback = this.$cb;
        service.getGuildRobotCardRecommend(gProGuildRobotCardRecommendReq, new IGetGuildRobotCardRecommendCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ow
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotCardRecommendCallback
            public final void onGetGuildRobotCardRecommend(int i16, String str2, GProGuildRobotCardRecommendRsp gProGuildRobotCardRecommendRsp) {
                RobotService$getGuildRobotCardRecommend$2.c(RobotService.this, str, i3, iGetGuildRobotCardRecommendCallback, i16, str2, gProGuildRobotCardRecommendRsp);
            }
        });
        return Unit.INSTANCE;
    }
}
