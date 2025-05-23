package com.tencent.state.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mt4.d;
import mt4.e;
import mt4.h;
import yt4.a;
import yt4.c;
import yt4.f;
import yt4.g;
import yt4.i;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ.\u0010\b\u001a\u00020\u00062&\u0010\u0007\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u0004\u0012\u00020\u00060\u0002J\u001c\u0010\n\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00060\u0002J$\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00060\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0002J$\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00060\u0002J*\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0002R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/service/ZTPSquareRewardService;", "", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lyt4/i;", "Lkotlin/collections/ArrayList;", "", "callback", "getRewardList", "", "getUserRewardPoints", "rewardId", "Lyt4/h;", "redeemReward", "", "finishShareTask", "", "groupIds", "Lmt4/i;", "getSkins", "groupId", "skinId", "dressSkin", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/state/service/IZTPSquareRewardService;", "service", "Lcom/tencent/state/service/IZTPSquareRewardService;", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ZTPSquareRewardService {
    private static final String TAG = "ZTPSquareTaskService";
    public static final ZTPSquareRewardService INSTANCE = new ZTPSquareRewardService();
    private static final IZTPSquareRewardService service = (IZTPSquareRewardService) Square.INSTANCE.getConfig().getRapier().b(IZTPSquareRewardService.class);

    ZTPSquareRewardService() {
    }

    public final void dressSkin(int groupId, int skinId, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IZTPSquareRewardService iZTPSquareRewardService = service;
        d dVar = new d();
        dVar.f417583a = groupId;
        dVar.f417584b = skinId;
        Unit unit = Unit.INSTANCE;
        iZTPSquareRewardService.dressSkin(dVar).a(new b<e>() { // from class: com.tencent.state.service.ZTPSquareRewardService$dressSkin$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZTPSquareTaskService", "dressSkin failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                Function1.this.invoke(Boolean.FALSE);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(e response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Function1.this.invoke(Boolean.TRUE);
            }
        });
    }

    public final void finishShareTask(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IZTPSquareRewardService iZTPSquareRewardService = service;
        a aVar = new a();
        aVar.f451202a = SquareFragment.INSTANCE.getChatLandAppId();
        Unit unit = Unit.INSTANCE;
        iZTPSquareRewardService.finishShareTask(aVar).a(new b<yt4.b>() { // from class: com.tencent.state.service.ZTPSquareRewardService$finishShareTask$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZTPSquareTaskService", "finishShareTask failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                Function1.this.invoke(Boolean.FALSE);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(yt4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Function1.this.invoke(Boolean.TRUE);
            }
        });
    }

    public final void getRewardList(final Function1<? super ArrayList<i>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        service.getRewardList(new c()).a(new b<yt4.d>() { // from class: com.tencent.state.service.ZTPSquareRewardService$getRewardList$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZTPSquareTaskService", "getRewardList failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                Function1.this.invoke(null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(yt4.d response) {
                List list;
                Intrinsics.checkNotNullParameter(response, "response");
                Function1 function1 = Function1.this;
                i[] iVarArr = response.f451203a;
                Intrinsics.checkNotNullExpressionValue(iVarArr, "response.rewards");
                list = ArraysKt___ArraysKt.toList(iVarArr);
                function1.invoke(new ArrayList(list));
            }
        });
    }

    public final void getSkins(int[] groupIds, final Function1<? super mt4.i, Unit> callback) {
        Intrinsics.checkNotNullParameter(groupIds, "groupIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IZTPSquareRewardService iZTPSquareRewardService = service;
        h hVar = new h();
        hVar.f417586a = groupIds;
        Unit unit = Unit.INSTANCE;
        iZTPSquareRewardService.getSkins(hVar).a(new b<mt4.i>() { // from class: com.tencent.state.service.ZTPSquareRewardService$getSkins$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZTPSquareTaskService", "getSkins failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                Function1.this.invoke(null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(mt4.i response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Function1.this.invoke(response);
            }
        });
    }

    public final void getUserRewardPoints(final Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        service.getUserRewardPoints(new yt4.e()).a(new b<f>() { // from class: com.tencent.state.service.ZTPSquareRewardService$getUserRewardPoints$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZTPSquareTaskService", "getUserRewardPoints failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                Function1.this.invoke(null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(f response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Function1.this.invoke(Integer.valueOf(response.f451204a));
            }
        });
    }

    public final void redeemReward(int rewardId, final Function1<? super yt4.h, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IZTPSquareRewardService iZTPSquareRewardService = service;
        g gVar = new g();
        gVar.f451205a = rewardId;
        Unit unit = Unit.INSTANCE;
        iZTPSquareRewardService.redeemRewards(gVar).a(new b<yt4.h>() { // from class: com.tencent.state.service.ZTPSquareRewardService$redeemReward$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZTPSquareTaskService", "redeemReward failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                Function1.this.invoke(null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(yt4.h response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Function1.this.invoke(response);
            }
        });
    }
}
