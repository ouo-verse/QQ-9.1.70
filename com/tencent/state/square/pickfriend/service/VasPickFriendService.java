package com.tencent.state.square.pickfriend.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ot4.g;
import ot4.h;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/pickfriend/service/VasPickFriendService;", "", "()V", "TAG", "", "service", "Lcom/tencent/state/square/pickfriend/service/IVasPickFriendService;", "getEntryInfo", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/state/square/pickfriend/service/PickFriendEntryInfoData;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasPickFriendService {
    private static final String TAG = "VasPickFriendService";
    public static final VasPickFriendService INSTANCE = new VasPickFriendService();
    private static final IVasPickFriendService service = (IVasPickFriendService) Square.INSTANCE.getConfig().getRapier().b(IVasPickFriendService.class);

    VasPickFriendService() {
    }

    public final void getEntryInfo(final Function1<? super PickFriendEntryInfoData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getEntryInfo.");
        service.getEntryInfo(new g()).a(new b<h>() { // from class: com.tencent.state.square.pickfriend.service.VasPickFriendService$getEntryInfo$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasPickFriendService", "getEntryInfo error: code=" + errorCode + ", message=" + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(h response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    PickFriendEntryInfoData parse = PickFriendDataConvertersKt.parse(response);
                    SquareBaseKt.getSquareLog().i("VasPickFriendService", "getEntryInfo success: " + parse);
                    Function1.this.invoke(parse);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasPickFriendService", "getEntryInfo parse error: code=" + th5, null, 4, null);
                }
            }
        });
    }
}
