package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotUpMicReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotUpMicRsp;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import com.tencent.qqnt.kernel.nativeinterface.IUpMicGuildRobotCallback;
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
final class RobotService$upMicGuildRobot$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ IUpMicGuildRobotCallback $cb;
    final /* synthetic */ String $method;
    final /* synthetic */ GProGuildRobotUpMicReq $req;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$upMicGuildRobot$2(RobotService robotService, GProGuildRobotUpMicReq gProGuildRobotUpMicReq, String str, IUpMicGuildRobotCallback iUpMicGuildRobotCallback) {
        super(1);
        this.this$0 = robotService;
        this.$req = gProGuildRobotUpMicReq;
        this.$method = str;
        this.$cb = iUpMicGuildRobotCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, gProGuildRobotUpMicReq, str, iUpMicGuildRobotCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final RobotService this$0, final String method, final int i3, final IUpMicGuildRobotCallback iUpMicGuildRobotCallback, final int i16, final String str, final GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pl
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$upMicGuildRobot$2.d(RobotService.this, method, i16, str, i3, iUpMicGuildRobotCallback, gProGuildRobotUpMicRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RobotService this$0, String method, int i3, String str, int i16, IUpMicGuildRobotCallback iUpMicGuildRobotCallback, GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        if (iUpMicGuildRobotCallback != null) {
            iUpMicGuildRobotCallback.onUpMicGuildRobot(i3, str, gProGuildRobotUpMicRsp);
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
        GProGuildRobotUpMicReq gProGuildRobotUpMicReq = this.$req;
        final RobotService robotService = this.this$0;
        final String str = this.$method;
        final IUpMicGuildRobotCallback iUpMicGuildRobotCallback = this.$cb;
        service.upMicGuildRobot(gProGuildRobotUpMicReq, new IUpMicGuildRobotCallback() { // from class: com.tencent.qqnt.kernel.api.impl.pk
            @Override // com.tencent.qqnt.kernel.nativeinterface.IUpMicGuildRobotCallback
            public final void onUpMicGuildRobot(int i16, String str2, GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
                RobotService$upMicGuildRobot$2.c(RobotService.this, str, i3, iUpMicGuildRobotCallback, i16, str2, gProGuildRobotUpMicRsp);
            }
        });
        return Unit.INSTANCE;
    }
}
