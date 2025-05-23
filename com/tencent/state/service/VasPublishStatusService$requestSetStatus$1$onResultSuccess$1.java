package com.tencent.state.service;

import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareOnlineStatusService;
import com.tencent.state.square.api.OnlineStatusListener;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/state/service/VasPublishStatusService$requestSetStatus$1$onResultSuccess$1", "Lcom/tencent/state/square/api/OnlineStatusListener;", "onStatusChange", "", "isSuccess", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasPublishStatusService$requestSetStatus$1$onResultSuccess$1 implements OnlineStatusListener {
    final /* synthetic */ VasPublishStatusService$requestSetStatus$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VasPublishStatusService$requestSetStatus$1$onResultSuccess$1(VasPublishStatusService$requestSetStatus$1 vasPublishStatusService$requestSetStatus$1) {
        this.this$0 = vasPublishStatusService$requestSetStatus$1;
    }

    @Override // com.tencent.state.square.api.OnlineStatusListener
    public void onStatusChange(final boolean isSuccess, int statusId) {
        ISquareOnlineStatusService iSquareOnlineStatusService;
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d("VasPublishStatusService", "updateOnlineStatus is " + isSuccess);
        }
        Square.INSTANCE.getConfig().getThreadManager().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.service.VasPublishStatusService$requestSetStatus$1$onResultSuccess$1$onStatusChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VasPublishStatusService$requestSetStatus$1$onResultSuccess$1.this.this$0.$callback.invoke(new SetStatusResult(isSuccess, null, 2, null));
            }
        });
        iSquareOnlineStatusService = this.this$0.this$0.statusService;
        if (iSquareOnlineStatusService != null) {
            iSquareOnlineStatusService.unRegisterListener(this);
        }
    }
}
