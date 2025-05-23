package com.tencent.state.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import ts4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/service/VasLibraryStatisticsService;", "", "()V", "service", "Lcom/tencent/state/service/IVasLibraryStatisticsService;", "getUserFocusStatistics", "", "callback", "Lkotlin/Function1;", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasLibraryStatisticsService {
    private static final String TAG = "VasLibraryStatisticsService";
    private final IVasLibraryStatisticsService service = (IVasLibraryStatisticsService) Square.INSTANCE.getConfig().getRapier().b(IVasLibraryStatisticsService.class);

    public final void getUserFocusStatistics(final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getUserFocusStatistics");
        this.service.getFocusStatistics(new a()).a(new b<ts4.b>() { // from class: com.tencent.state.service.VasLibraryStatisticsService$getUserFocusStatistics$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryStatisticsService", "getUserFocusStatistics failed: parse error " + errorCode + TokenParser.SP + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ts4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasLibraryStatisticsService", "getUserFocusStatistics success: " + response.f437432a);
                Function1 function1 = Function1.this;
                String str = response.f437432a;
                if (str == null) {
                    str = "";
                }
                function1.invoke(str);
            }
        });
    }
}
