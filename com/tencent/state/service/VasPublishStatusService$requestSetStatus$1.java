package com.tencent.state.service;

import com.tencent.state.api.SquareErrorData;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.api.ISquareOnlineStatusService;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/state/service/VasPublishStatusService$requestSetStatus$1", "Lcom/tencent/state/service/ResultCallback;", "", "onResultFailure", "error", "", "message", "", "prompt", "onResultSuccess", "result", "(Lkotlin/Unit;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasPublishStatusService$requestSetStatus$1 implements ResultCallback<Unit> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ OnlineStatus $status;
    final /* synthetic */ VasPublishStatusService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VasPublishStatusService$requestSetStatus$1(VasPublishStatusService vasPublishStatusService, Function1 function1, OnlineStatus onlineStatus) {
        this.this$0 = vasPublishStatusService;
        this.$callback = function1;
        this.$status = onlineStatus;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int error, String message, String prompt) {
        ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
        this.$callback.invoke(new SetStatusResult(false, new SquareErrorData(Integer.valueOf(error), message, prompt)));
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultSuccess(Unit result) {
        ISquareOnlineStatusService iSquareOnlineStatusService;
        ISquareOnlineStatusService iSquareOnlineStatusService2;
        Intrinsics.checkNotNullParameter(result, "result");
        iSquareOnlineStatusService = this.this$0.statusService;
        if (iSquareOnlineStatusService != null) {
            iSquareOnlineStatusService.registerListener(new VasPublishStatusService$requestSetStatus$1$onResultSuccess$1(this));
        }
        iSquareOnlineStatusService2 = this.this$0.statusService;
        if (iSquareOnlineStatusService2 != null) {
            iSquareOnlineStatusService2.updateOnlineStatus(this.$status.getId());
        }
    }
}
