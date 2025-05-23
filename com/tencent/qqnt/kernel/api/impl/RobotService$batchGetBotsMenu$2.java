package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetBotsMenuResponse;
import com.tencent.qqnt.kernel.nativeinterface.BotsMenuRequest;
import com.tencent.qqnt.kernel.nativeinterface.IBatchGetBotsMenuCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "workSeq", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class RobotService$batchGetBotsMenu$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ IBatchGetBotsMenuCallback $cb;
    final /* synthetic */ String $method;
    final /* synthetic */ BotsMenuRequest $req;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$batchGetBotsMenu$2(RobotService robotService, BotsMenuRequest botsMenuRequest, String str, IBatchGetBotsMenuCallback iBatchGetBotsMenuCallback) {
        super(1);
        this.this$0 = robotService;
        this.$req = botsMenuRequest;
        this.$method = str;
        this.$cb = iBatchGetBotsMenuCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, botsMenuRequest, str, iBatchGetBotsMenuCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final RobotService this$0, final String method, final int i3, final IBatchGetBotsMenuCallback cb5, final int i16, final String str, final BatchGetBotsMenuResponse batchGetBotsMenuResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.nk
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$batchGetBotsMenu$2.d(RobotService.this, method, i16, str, i3, cb5, batchGetBotsMenuResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RobotService this$0, String method, int i3, String str, int i16, IBatchGetBotsMenuCallback cb5, BatchGetBotsMenuResponse batchGetBotsMenuResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        cb5.onResult(i3, str, batchGetBotsMenuResponse);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        IKernelRobotService service = this.this$0.getService();
        if (service != null) {
            BotsMenuRequest botsMenuRequest = this.$req;
            final RobotService robotService = this.this$0;
            final String str = this.$method;
            final IBatchGetBotsMenuCallback iBatchGetBotsMenuCallback = this.$cb;
            service.batchGetBotsMenu(botsMenuRequest, new IBatchGetBotsMenuCallback() { // from class: com.tencent.qqnt.kernel.api.impl.nj
                @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchGetBotsMenuCallback
                public final void onResult(int i16, String str2, BatchGetBotsMenuResponse batchGetBotsMenuResponse) {
                    RobotService$batchGetBotsMenu$2.c(RobotService.this, str, i3, iBatchGetBotsMenuCallback, i16, str2, batchGetBotsMenuResponse);
                }
            });
        }
    }
}
