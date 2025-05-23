package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.service.PatchAddToSquareItem;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.detail.DetailFragmentLauncherKt;
import com.tencent.state.square.detail.MainScene;
import dt4.a;
import dt4.b;
import dt4.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0084\u0001\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112S\u0010\u0007\u001aO\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u0012\u00a2\u0006\u0002\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/service/VasSquarePatchAddService;", "", "()V", "checkUserInSquare", "", "uin", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "patchAddToSquare", "list", "", "Lcom/tencent/state/service/PatchAddToSquareItem;", "source", "Lcom/tencent/state/square/detail/MainScene;", "scene", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "errCode", "errMsg", "(Ljava/util/List;Lcom/tencent/state/square/detail/MainScene;Ljava/lang/Integer;Lkotlin/jvm/functions/Function3;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquarePatchAddService {
    private static final String CHECK_METHOD = "CheckUserInSquare";
    private static final String METHOD = "AddToSquare";
    private static final String SERVICE = "trpc.qmeta.square_add_svr.SquareAddSvr";
    private static final String TAG = "VasSquarePatchAddService";

    public final void checkUserInSquare(String uin, ResultCallback<Boolean> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final void patchAddToSquare(List<PatchAddToSquareItem> list, MainScene source, Integer scene, final Function3<? super List<PatchAddToSquareItem>, ? super Integer, ? super String, Unit> callback) {
        int covertToSource;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (list.isEmpty()) {
            callback.invoke(new ArrayList(), -1, "empty req list");
            return;
        }
        a aVar = new a();
        c[] cVarArr = new c[list.size()];
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            cVarArr[i3] = PatchAddToSquareItem.INSTANCE.covertToUnit((PatchAddToSquareItem) obj);
            i3 = i16;
        }
        aVar.f394843a = cVarArr;
        if (scene != null) {
            covertToSource = scene.intValue();
        } else {
            covertToSource = DetailFragmentLauncherKt.covertToSource(source);
        }
        aVar.f394844b = covertToSource;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquarePatchAddService$patchAddToSquare$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquarePatchAddService", "patchAddToSquare, errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function3 function3 = Function3.this;
                    ArrayList arrayList = new ArrayList();
                    Integer errCode = data.getErrCode();
                    function3.invoke(arrayList, Integer.valueOf(errCode != null ? errCode.intValue() : -1), data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().i("VasSquarePatchAddService", "patchAddToSquare success");
                    ArrayList arrayList = new ArrayList();
                    try {
                        c[] cVarArr2 = b.c(rspData).f394845a;
                        Intrinsics.checkNotNullExpressionValue(cVarArr2, "rsp.succUnits");
                        for (c it : cVarArr2) {
                            PatchAddToSquareItem.Companion companion = PatchAddToSquareItem.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            arrayList.add(companion.covertFromUnit(it));
                        }
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("VasSquarePatchAddService", "patchAddToSquare parse err.", th5);
                    }
                    Function3.this.invoke(arrayList, 0, null);
                }
            });
        }
    }

    public static /* synthetic */ void patchAddToSquare$default(VasSquarePatchAddService vasSquarePatchAddService, List list, MainScene mainScene, Integer num, Function3 function3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            mainScene = MainScene.SQUARE;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        vasSquarePatchAddService.patchAddToSquare(list, mainScene, num, function3);
    }
}
