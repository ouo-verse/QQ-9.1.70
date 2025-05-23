package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotStoryActionSetReq;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(I)Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class RobotService$reportRobotStoryActionData$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ IOperateCallback $cb;
    final /* synthetic */ RobotStoryActionSetReq $request;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$reportRobotStoryActionData$2(RobotService robotService, RobotStoryActionSetReq robotStoryActionSetReq, IOperateCallback iOperateCallback) {
        super(1);
        this.this$0 = robotService;
        this.$request = robotStoryActionSetReq;
        this.$cb = iOperateCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, robotStoryActionSetReq, iOperateCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RobotService this$0, final IOperateCallback iOperateCallback, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pf
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$reportRobotStoryActionData$2.d(IOperateCallback.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IOperateCallback iOperateCallback, int i3, String str) {
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
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
        RobotStoryActionSetReq robotStoryActionSetReq = this.$request;
        final RobotService robotService = this.this$0;
        final IOperateCallback iOperateCallback = this.$cb;
        service.reportRobotStoryActionData(robotStoryActionSetReq, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.pe
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str) {
                RobotService$reportRobotStoryActionData$2.c(RobotService.this, iOperateCallback, i16, str);
            }
        });
        return Unit.INSTANCE;
    }
}
