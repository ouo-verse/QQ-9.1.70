package com.tencent.state.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareMainPosterShareInfo;
import com.tencent.state.square.data.SquarePosterInfo;
import com.tencent.state.square.data.SquarePosterInfoKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kt4.c;
import lt4.a;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u000e\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/service/VasGetPosterService;", "", "()V", "TAG", "", "posterService", "Lcom/tencent/state/service/IVasGetPosterService;", "getPosterData", "", "motionId", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/SquarePosterInfo;", "getSquareShareData", "Lcom/tencent/state/square/data/SquareMainPosterShareInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasGetPosterService {
    private static final String TAG = "VasGetPosterService";
    public static final VasGetPosterService INSTANCE = new VasGetPosterService();
    private static final IVasGetPosterService posterService = (IVasGetPosterService) Square.INSTANCE.getConfig().getRapier().b(IVasGetPosterService.class);

    VasGetPosterService() {
    }

    public final void getPosterData(int motionId, final ResultCallback<SquarePosterInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a();
        aVar.f415551a = motionId;
        posterService.getPosterData(aVar).a(new b<lt4.b>() { // from class: com.tencent.state.service.VasGetPosterService$getPosterData$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasGetPosterService", "getPosterData fail " + errorCode + ", " + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(lt4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                ResultCallback.this.onResultSuccess(SquarePosterInfoKt.parse(response));
            }
        });
    }

    public final void getSquareShareData(final ResultCallback<SquareMainPosterShareInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        posterService.getSquareShareData(new kt4.a()).a(new b<kt4.b>() { // from class: com.tencent.state.service.VasGetPosterService$getSquareShareData$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasGetPosterService", "getPosterData fail " + errorCode + ", " + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(kt4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.f413009a == null) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasGetPosterService", "getPosterData fail info is null", null, 4, null);
                }
                ResultCallback resultCallback = ResultCallback.this;
                c cVar = response.f413009a;
                Intrinsics.checkNotNullExpressionValue(cVar, "response.info");
                resultCallback.onResultSuccess(SquarePosterInfoKt.parse(cVar));
            }
        });
    }
}
