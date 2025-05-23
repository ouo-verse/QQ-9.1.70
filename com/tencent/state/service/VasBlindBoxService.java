package com.tencent.state.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfoKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wr4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/service/VasBlindBoxService;", "", "()V", "SOURCE_DETAIL_PAGE", "", "SOURCE_SQUARE", "TAG", "", "blindBoxService", "Lcom/tencent/state/service/IVasBlindBoxService;", "getBlindBoxEntrance", "", "source", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasBlindBoxService {
    public static final int SOURCE_DETAIL_PAGE = 2;
    public static final int SOURCE_SQUARE = 1;
    private static final String TAG = "VasBlindBoxService";
    public static final VasBlindBoxService INSTANCE = new VasBlindBoxService();
    private static final IVasBlindBoxService blindBoxService = (IVasBlindBoxService) Square.INSTANCE.getConfig().getRapier().b(IVasBlindBoxService.class);

    VasBlindBoxService() {
    }

    public final void getBlindBoxEntrance(int source, final ResultCallback<SquareBlindBoxEntranceInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a();
        aVar.f446134a = source;
        blindBoxService.getBlindBoxEntrance(aVar).a(new b<wr4.b>() { // from class: com.tencent.state.service.VasBlindBoxService$getBlindBoxEntrance$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasBlindBoxService", "getBlindBoxEntrance: " + errorCode + ", " + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(wr4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                ResultCallback.this.onResultSuccess(SquareBlindBoxEntranceInfoKt.parse(response));
                SquareBaseKt.getSquareLog().i("VasBlindBoxService", "getBlindBoxEntrance isShow: " + response.f446135a);
            }
        });
    }

    public static /* synthetic */ void getBlindBoxEntrance$default(VasBlindBoxService vasBlindBoxService, int i3, ResultCallback resultCallback, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 1;
        }
        vasBlindBoxService.getBlindBoxEntrance(i3, resultCallback);
    }
}
