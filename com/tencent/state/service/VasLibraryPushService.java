package com.tencent.state.service;

import com.tencent.rapier.b;
import com.tencent.state.common.push.PullMsgResponse;
import com.tencent.state.common.push.service.IVasLibraryPushService;
import com.tencent.state.library.push.LibraryPushMessageParserKt;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ps4.a;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/service/VasLibraryPushService;", "", "()V", "service", "Lcom/tencent/state/common/push/service/IVasLibraryPushService;", "pullMessage", "", "roomId", "", "offset", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/common/push/PullMsgResponse;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasLibraryPushService {
    private static final String TAG = "VasLibraryPushService";
    private final IVasLibraryPushService service = (IVasLibraryPushService) Square.INSTANCE.getConfig().getRapier().b(IVasLibraryPushService.class);

    public final void pullMessage(long roomId, byte[] offset, final ResultCallback<PullMsgResponse> callback) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IVasLibraryPushService iVasLibraryPushService = this.service;
        a aVar = new a();
        aVar.f427084a = roomId;
        aVar.f427085b = offset;
        Unit unit = Unit.INSTANCE;
        IVasLibraryPushService.DefaultImpls.pullMessage$default(iVasLibraryPushService, aVar, 0, 2, null).a(new b<ps4.b>() { // from class: com.tencent.state.service.VasLibraryPushService$pullMessage$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryPushService", "pullMessage failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ps4.b response) {
                PullMsgResponse pullMsgResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    pullMsgResponse = LibraryPushMessageParserKt.parse(response);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryPushService", "pullMessage parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "enterRoom parse failed.");
                    pullMsgResponse = null;
                }
                SquareBaseKt.getSquareLog().i("VasLibraryPushService", "pullMessage success: info = " + pullMsgResponse);
                if (pullMsgResponse != null) {
                    ResultCallback.this.onResultSuccess(pullMsgResponse);
                }
            }
        });
    }
}
