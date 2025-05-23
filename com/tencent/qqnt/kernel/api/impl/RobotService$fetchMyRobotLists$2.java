package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.IFetchMyRobotListsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotsListReq;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotsListRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "seq", "", "invoke", "(I)Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class RobotService$fetchMyRobotLists$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ IFetchMyRobotListsCallback $cb;
    final /* synthetic */ MyRobotsListReq $request;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$fetchMyRobotLists$2(RobotService robotService, MyRobotsListReq myRobotsListReq, IFetchMyRobotListsCallback iFetchMyRobotListsCallback) {
        super(1);
        this.this$0 = robotService;
        this.$request = myRobotsListReq;
        this.$cb = iFetchMyRobotListsCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, myRobotsListReq, iFetchMyRobotListsCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RobotService this$0, final IFetchMyRobotListsCallback iFetchMyRobotListsCallback, final int i3, final String str, final MyRobotsListRsp myRobotsListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.oj
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$fetchMyRobotLists$2.d(IFetchMyRobotListsCallback.this, i3, str, myRobotsListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IFetchMyRobotListsCallback iFetchMyRobotListsCallback, int i3, String str, MyRobotsListRsp myRobotsListRsp) {
        if (iFetchMyRobotListsCallback != null) {
            iFetchMyRobotListsCallback.onResult(i3, str, myRobotsListRsp);
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
        MyRobotsListReq myRobotsListReq = this.$request;
        final RobotService robotService = this.this$0;
        final IFetchMyRobotListsCallback iFetchMyRobotListsCallback = this.$cb;
        service.fetchMyRobotLists(myRobotsListReq, new IFetchMyRobotListsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.oi
            @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchMyRobotListsCallback
            public final void onResult(int i16, String str, MyRobotsListRsp myRobotsListRsp) {
                RobotService$fetchMyRobotLists$2.c(RobotService.this, iFetchMyRobotListsCallback, i16, str, myRobotsListRsp);
            }
        });
        return Unit.INSTANCE;
    }
}
