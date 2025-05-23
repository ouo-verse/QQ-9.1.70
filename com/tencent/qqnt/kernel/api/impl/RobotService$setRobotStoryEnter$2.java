package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRequest;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRsp;
import com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(I)Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class RobotService$setRobotStoryEnter$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ICommandCbCallback $cb;
    final /* synthetic */ CommandCbRequest $req;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$setRobotStoryEnter$2(RobotService robotService, CommandCbRequest commandCbRequest, ICommandCbCallback iCommandCbCallback) {
        super(1);
        this.this$0 = robotService;
        this.$req = commandCbRequest;
        this.$cb = iCommandCbCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, commandCbRequest, iCommandCbCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RobotService this$0, final ICommandCbCallback iCommandCbCallback, final int i3, final String str, final CommandCbRsp commandCbRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pj
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$setRobotStoryEnter$2.d(ICommandCbCallback.this, i3, str, commandCbRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ICommandCbCallback iCommandCbCallback, int i3, String str, CommandCbRsp commandCbRsp) {
        if (iCommandCbCallback != null) {
            iCommandCbCallback.onResult(i3, str, commandCbRsp);
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
        CommandCbRequest commandCbRequest = this.$req;
        final RobotService robotService = this.this$0;
        final ICommandCbCallback iCommandCbCallback = this.$cb;
        service.setRobotStoryEnter(commandCbRequest, new ICommandCbCallback() { // from class: com.tencent.qqnt.kernel.api.impl.pi
            @Override // com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback
            public final void onResult(int i16, String str, CommandCbRsp commandCbRsp) {
                RobotService$setRobotStoryEnter$2.c(RobotService.this, iCommandCbCallback, i16, str, commandCbRsp);
            }
        });
        return Unit.INSTANCE;
    }
}
