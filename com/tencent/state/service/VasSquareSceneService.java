package com.tencent.state.service;

import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareBuildingInfo;
import com.tencent.state.square.data.SquareStyleInfo;
import it4.a;
import it4.b;
import it4.c;
import it4.d;
import it4.e;
import it4.f;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2&\u0010\t\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r\u0012\u0004\u0012\u00020\b0\nJ\u001e\u0010\u000e\u001a\u00020\b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/service/VasSquareSceneService;", "", "()V", "TAG", "", "service", "Lcom/tencent/state/service/IVasSquareSceneService;", "getAllBuildingStyle", "", "callback", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/data/SquareStyleInfo;", "Lkotlin/collections/ArrayList;", "saveBuildingStyle", "buildingInfos", "Lcom/tencent/state/square/data/SquareBuildingInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareSceneService {
    private static final String TAG = "VasSquareSceneService";
    public static final VasSquareSceneService INSTANCE = new VasSquareSceneService();
    private static final IVasSquareSceneService service = (IVasSquareSceneService) Square.INSTANCE.getConfig().getRapier().b(IVasSquareSceneService.class);

    VasSquareSceneService() {
    }

    public final void getAllBuildingStyle(final Function1<? super ArrayList<SquareStyleInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        service.getAllBuildingStyles(new b()).a(new com.tencent.rapier.b<c>() { // from class: com.tencent.state.service.VasSquareSceneService$getAllBuildingStyle$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareSceneService", "getAllBuildingStyle FAIL: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                Function1.this.invoke(null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(c response) {
                Intrinsics.checkNotNullParameter(response, "response");
                f[] fVarArr = response.f408743a;
                ArrayList arrayList = new ArrayList();
                for (f fVar : fVarArr) {
                    int i3 = fVar.f408746a;
                    String str = fVar.f408747b;
                    Intrinsics.checkNotNullExpressionValue(str, "info.picUrl");
                    arrayList.add(new SquareStyleInfo(i3, str));
                }
                Function1.this.invoke(arrayList);
            }
        });
    }

    public final void saveBuildingStyle(ArrayList<SquareBuildingInfo> buildingInfos) {
        Intrinsics.checkNotNullParameter(buildingInfos, "buildingInfos");
        ArrayList arrayList = new ArrayList();
        for (SquareBuildingInfo squareBuildingInfo : buildingInfos) {
            a aVar = new a();
            aVar.f408742b = squareBuildingInfo.getStyleId();
            aVar.f408741a = squareBuildingInfo.getEntranceId();
            Unit unit = Unit.INSTANCE;
            arrayList.add(aVar);
        }
        d dVar = new d();
        Object[] array = arrayList.toArray(new a[0]);
        if (array != null) {
            dVar.f408744a = (a[]) array;
            service.saveBuildingStyle(dVar).a(new com.tencent.rapier.b<e>() { // from class: com.tencent.state.service.VasSquareSceneService$saveBuildingStyle$2
                @Override // com.tencent.rapier.b
                public void onFailure(int errorCode, String errorMessage) {
                    Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareSceneService", "saveBuildingStyle FAIL: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                }

                @Override // com.tencent.rapier.b
                public void onSuccess(e response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareSceneService", "saveBuildingStyle success", null, 4, null);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
