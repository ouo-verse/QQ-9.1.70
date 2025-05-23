package com.tencent.state.square.flower.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.flower.data.FlowerDataConvertersKt;
import com.tencent.state.square.flower.data.FlowerDisplayData;
import com.tencent.state.square.flower.data.MedalData;
import hs4.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import ot4.a;
import ot4.c;
import ot4.d;
import ot4.e;
import ot4.f;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nJ*\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\b0\u000eJ\u001a\u0010\u0011\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/flower/service/VasFlowerService;", "", "()V", "TAG", "", "service", "Lcom/tencent/state/square/flower/service/IVasFlowerService;", "getFlowerDisplayInfo", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/state/square/flower/data/FlowerDisplayData;", "getFlowerToday", "uin", "Lkotlin/Function2;", "", "Lcom/tencent/state/square/flower/data/MedalData;", "getFlowerYesterday", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasFlowerService {
    private static final String TAG = "VasFlowerService";
    public static final VasFlowerService INSTANCE = new VasFlowerService();
    private static final IVasFlowerService service = (IVasFlowerService) Square.INSTANCE.getConfig().getRapier().b(IVasFlowerService.class);

    VasFlowerService() {
    }

    public final void getFlowerDisplayInfo(final Function1<? super FlowerDisplayData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getFlowerDisplayInfo.");
        service.getFlowerDisplayInfo(new a()).a(new b<ot4.b>() { // from class: com.tencent.state.square.flower.service.VasFlowerService$getFlowerDisplayInfo$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFlowerService", "getFlowerDisplayInfo error: code=" + errorCode + ", message=" + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ot4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    FlowerDisplayData parse = FlowerDataConvertersKt.parse(response);
                    SquareBaseKt.getSquareLog().i("VasFlowerService", "getFlowerDisplayInfo success: " + parse);
                    Function1.this.invoke(parse);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFlowerService", "getFlowerDisplayInfo parse error: code=" + th5, null, 4, null);
                }
            }
        });
    }

    public final void getFlowerToday(final String uin, final Function2<? super Integer, ? super MedalData, Unit> callback) {
        Long longOrNull;
        Long firstOrNull;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            c cVar = new c();
            cVar.f424052a = new long[]{longValue};
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getFlowerToday: touins=");
            long[] jArr = cVar.f424052a;
            Intrinsics.checkNotNullExpressionValue(jArr, "req.touins");
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(jArr);
            sb5.append(firstOrNull);
            squareLog.i(TAG, sb5.toString());
            service.getFlowerToday(cVar).a(new b<d>() { // from class: com.tencent.state.square.flower.service.VasFlowerService$getFlowerToday$1
                @Override // com.tencent.rapier.b
                public void onFailure(int errorCode, String errorMessage) {
                    Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFlowerService", "getFlowerToday error: code=" + errorCode + ", message=" + errorMessage, null, 4, null);
                }

                @Override // com.tencent.rapier.b
                public void onSuccess(d response) {
                    Object firstOrNull2;
                    Intrinsics.checkNotNullParameter(response, "response");
                    int[] iArr = response.f424053a;
                    MedalData medalData = null;
                    Integer firstOrNull3 = iArr != null ? ArraysKt___ArraysKt.firstOrNull(iArr) : null;
                    k[] kVarArr = response.f424054b;
                    if (kVarArr != null) {
                        firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(kVarArr);
                        k kVar = (k) firstOrNull2;
                        if (kVar != null) {
                            medalData = FlowerDataConvertersKt.parse(kVar);
                        }
                    }
                    SquareBaseKt.getSquareLog().i("VasFlowerService", "getFlowerToday success: uin=" + uin + " flowerCount=" + firstOrNull3);
                    if (firstOrNull3 != null) {
                        callback.invoke(Integer.valueOf(firstOrNull3.intValue()), medalData);
                    }
                }
            });
        }
    }

    public final void getFlowerYesterday(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        e eVar = new e();
        SquareBaseKt.getSquareLog().i(TAG, "getFlowerYesterday");
        service.getFlowerYesterday(eVar).a(new b<f>() { // from class: com.tencent.state.square.flower.service.VasFlowerService$getFlowerYesterday$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFlowerService", "getFlowerYesterday error: code=" + errorCode + ", message=" + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(f response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasFlowerService", "getFlowerYesterday success: flowerCount=" + response.f424055a + ", isShowDialog=" + response.f424056b);
                Function1.this.invoke(Boolean.valueOf(response.f424056b));
            }
        });
    }
}
