package com.tencent.state.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.guide.SquareNoviceGuideConfig;
import com.tencent.state.square.guide.SquareNoviceGuideConfigKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ws4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/service/VasNoviceGuideService;", "", "Lcom/tencent/rapier/b;", "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "callback", "", "getGuidanceInfo", "Lcom/tencent/state/service/IVasNoviceGuideService;", "service", "Lcom/tencent/state/service/IVasNoviceGuideService;", "<init>", "()V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasNoviceGuideService {
    private static final String TAG = "VasNoviceGuideService";
    private final IVasNoviceGuideService service = (IVasNoviceGuideService) Square.INSTANCE.getConfig().getRapier().b(IVasNoviceGuideService.class);

    public final void getGuidanceInfo(final b<SquareNoviceGuideConfig> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] getGuidanceInfo");
        this.service.getGuidanceInfo(new a()).a(new b<ws4.b>() { // from class: com.tencent.state.service.VasNoviceGuideService$getGuidanceInfo$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().d("VasNoviceGuideService", "[NoviceGuide] getGuidanceInfo, failed");
                b.this.onFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ws4.b response) {
                SquareNoviceGuideConfig squareNoviceGuideConfig;
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().d("VasNoviceGuideService", "[NoviceGuide] getGuidanceInfo, success");
                try {
                    squareNoviceGuideConfig = SquareNoviceGuideConfigKt.parse(response);
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e("VasNoviceGuideService", "[NoviceGuide] getGuidanceInfo, parse err.", th5);
                    squareNoviceGuideConfig = null;
                }
                if (squareNoviceGuideConfig == null) {
                    b.this.onFailure(-1, "parse error");
                } else {
                    b.this.onSuccess(squareNoviceGuideConfig);
                }
            }
        });
    }
}
