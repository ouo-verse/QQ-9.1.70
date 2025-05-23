package com.tencent.state.service;

import bu4.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002Js\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2S\u0010\u000f\u001aO\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\n0\u0010j\u0002`\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/service/VasSquareTempChatService;", "", "()V", "SERVICE_TYPE", "", "TAG", "", "service", "Lcom/tencent/state/service/IVasGetTokenService;", "getToken", "", "scene", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "", "receiverUin", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "result", "receiverUid", "Lcom/tencent/state/service/GetTokenCallback;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareTempChatService {
    private static final int SERVICE_TYPE = 173;
    private static final String TAG = "VasSquareTempChatService";
    public static final VasSquareTempChatService INSTANCE = new VasSquareTempChatService();
    private static final IVasGetTokenService service = (IVasGetTokenService) Square.INSTANCE.getConfig().getRapier().b(IVasGetTokenService.class);

    VasSquareTempChatService() {
    }

    public final void getToken(int scene, long senderUin, long receiverUin, final Function3<? super Boolean, ? super byte[], ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (senderUin != 0 && receiverUin != 0) {
            IVasGetTokenService iVasGetTokenService = service;
            a aVar = new a();
            aVar.f29231a = senderUin;
            aVar.f29232b = receiverUin;
            aVar.f29234d = 173;
            aVar.f29233c = 1;
            aVar.f29236f = scene;
            Unit unit = Unit.INSTANCE;
            iVasGetTokenService.getToken(aVar).a(new b<bu4.b>() { // from class: com.tencent.state.service.VasSquareTempChatService$getToken$1
                @Override // com.tencent.rapier.b
                public void onFailure(int errorCode, String errorMessage) {
                    Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareTempChatService", "errorCode is " + errorCode + ", errorMsg is " + errorMessage, null, 4, null);
                    Function3.this.invoke(Boolean.FALSE, null, null);
                }

                @Override // com.tencent.rapier.b
                public void onSuccess(bu4.b response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    SquareBaseKt.getSquareLog().i("VasSquareTempChatService", "getToken success " + response.f29237a + TokenParser.SP + response.f29238b);
                    Function3.this.invoke(Boolean.TRUE, response.f29237a, response.f29238b);
                }
            });
            return;
        }
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("senderUin OR receiverUin is 0 ");
        sb5.append(senderUin);
        sb5.append(TokenParser.SP);
        sb5.append(receiverUin);
        sb5.append(TokenParser.SP);
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        sb5.append(currentThread.getStackTrace());
        SquareLogger.DefaultImpls.e$default(squareLog, TAG, sb5.toString(), null, 4, null);
        callback.invoke(Boolean.FALSE, null, null);
    }
}
