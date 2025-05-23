package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.NewInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vt4.a;
import vt4.b;
import vt4.c;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/service/VasSquareReportService;", "", "()V", "reportNewInfo", "", "uin", "", "infoList", "", "Lcom/tencent/state/square/data/NewInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareReportService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_square_report_svr.StatusSquareReportSvr";
    private static final String METHOD = "UserExposureReport";
    private static final String TAG = "VasSquareReportService";

    public final void reportNewInfo(long uin, List<NewInfo> infoList) {
        int collectionSizeOrDefault;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        b bVar = new b();
        c[] cVarArr = new c[1];
        c cVar = new c();
        cVar.f443502a = uin;
        List<NewInfo> list = infoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (NewInfo newInfo : list) {
            a aVar = new a();
            aVar.f443498a = newInfo.getType();
            aVar.f443499b = newInfo.getUniqueId();
            arrayList.add(aVar);
        }
        Object[] array = arrayList.toArray(new a[0]);
        if (array != null) {
            cVar.f443503b = (a[]) array;
            Unit unit = Unit.INSTANCE;
            cVarArr[0] = cVar;
            bVar.f443500a = cVarArr;
            SquareBaseKt.getSquareLog().i(TAG, "reportNewInfo uin=" + uin + ", " + infoList);
            INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
            if (networkDelegate != null) {
                byte[] byteArray = MessageNano.toByteArray(bVar);
                Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
                emptyMap = MapsKt__MapsKt.emptyMap();
                networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareReportService$reportNewInfo$1
                    @Override // com.tencent.state.api.INetworkDelegateCallBack
                    public void onError(SquareErrorData data) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareReportService", "reportNewInfo errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    }

                    @Override // com.tencent.state.api.INetworkDelegateCallBack
                    public void onReceive(byte[] rspData) {
                        SquareBaseKt.getSquareLog().i("VasSquareReportService", "reportNewInfo success");
                    }
                });
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
