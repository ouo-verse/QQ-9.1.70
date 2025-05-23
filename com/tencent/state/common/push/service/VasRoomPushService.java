package com.tencent.state.common.push.service;

import com.tencent.rapier.b;
import com.tencent.state.SquareRuntime;
import com.tencent.state.common.push.IVasPushService;
import com.tencent.state.common.push.PullMsgResponse;
import com.tencent.state.common.push.RegisterKey;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.push.RoomPushMessageParserKt;
import ct4.a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/common/push/service/VasRoomPushService;", "Lcom/tencent/state/common/push/IVasPushService;", "appId", "", "(I)V", "service", "Lcom/tencent/state/common/push/service/IVasRoomPushService;", "getRegisterKey", "Lcom/tencent/state/common/push/RegisterKey;", "pullMessage", "", "roomId", "", "offset", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/common/push/PullMsgResponse;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class VasRoomPushService implements IVasPushService {
    private static final String TAG = "VasRoomPushService";
    private final int appId;
    private final IVasRoomPushService service = (IVasRoomPushService) Square.INSTANCE.getConfig().getRapier().b(IVasRoomPushService.class);

    public VasRoomPushService(int i3) {
        this.appId = i3;
    }

    @Override // com.tencent.state.common.push.IVasPushService
    public RegisterKey getRegisterKey() {
        Set of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{3, 300, 301, 4, 5, 6, 7, 16, 8, 9, 10, 11, 12, 13, 14, 15, 17});
        return new RegisterKey(of5);
    }

    @Override // com.tencent.state.common.push.IVasPushService
    public void pullMessage(long roomId, byte[] offset, final ResultCallback<PullMsgResponse> callback) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IVasRoomPushService iVasRoomPushService = this.service;
        a aVar = new a();
        aVar.f391834a = this.appId;
        aVar.f391835b = roomId;
        aVar.f391836c = offset;
        Unit unit = Unit.INSTANCE;
        iVasRoomPushService.pullMessage(aVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new b<ct4.b>() { // from class: com.tencent.state.common.push.service.VasRoomPushService$pullMessage$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasRoomPushService", "pullMessage failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ct4.b response) {
                PullMsgResponse pullMsgResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    pullMsgResponse = RoomPushMessageParserKt.parse(response);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasRoomPushService", "pullMessage parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "enterRoom parse failed.");
                    pullMsgResponse = null;
                }
                SquareBaseKt.getSquareLog().i("VasRoomPushService", "pullMessage success: info = " + pullMsgResponse);
                if (pullMsgResponse != null) {
                    ResultCallback.this.onResultSuccess(pullMsgResponse);
                }
            }
        });
    }
}
