package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.rapier.b;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareEntry;
import com.tencent.state.square.data.SquareEntryKt;
import et4.c;
import et4.d;
import et4.e;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xr4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J*\u0010\u0007\u001a\u00020\u00062\"\u0010\b\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\u0004\u0012\u00020\u00060\tJ\u001a\u0010\r\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/service/VasSquareEntryService;", "", "()V", "service", "Lcom/tencent/state/service/IVasSquareGetEntryService;", "clearRedDot", "", "getAllEntry", "callback", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/data/SquareEntry;", "Lkotlin/collections/ArrayList;", "getEntry", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareEntryService {
    private static final String CMD_SERVICE = "trpc.qmeta.square_entry_svr.SquareEntry";
    private static final String METHOD = "GetEntry";
    private static final String TAG = "VasSquareEntryService";
    private final IVasSquareGetEntryService service = (IVasSquareGetEntryService) Square.INSTANCE.getConfig().getRapier().b(IVasSquareGetEntryService.class);

    public final void clearRedDot() {
        SquareBaseKt.getSquareLog().i(TAG, "clearRedDot.");
        this.service.clearRedDot(new a()).a(new b<xr4.b>() { // from class: com.tencent.state.service.VasSquareEntryService$clearRedDot$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareEntryService", "clearRedDot failed: errCode=" + errorCode + ", errMsg=" + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(xr4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasSquareEntryService", "clearRedDot success.");
            }
        });
    }

    public final void getAllEntry(final Function1<? super ArrayList<SquareEntry>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getAllEntry.");
        this.service.getAllEntry(new et4.b()).a(new b<c>() { // from class: com.tencent.state.service.VasSquareEntryService$getAllEntry$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareEntryService", "getAllEntry failed: errCode=" + errorCode + ", errMsg=" + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(c response) {
                Intrinsics.checkNotNullParameter(response, "response");
                et4.a[] aVarArr = response.f397122a;
                ArrayList arrayList = new ArrayList();
                for (et4.a entry : aVarArr) {
                    Intrinsics.checkNotNullExpressionValue(entry, "entry");
                    arrayList.add(SquareEntryKt.parse(entry));
                }
                SquareBaseKt.getSquareLog().i("VasSquareEntryService", "getAllEntry success: " + arrayList);
                Function1.this.invoke(arrayList);
            }
        });
    }

    public final void getEntry(final Function1<? super SquareEntry, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getEntry.");
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(new d());
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(GetEntryReq())");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareEntryService$getEntry$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareEntryService", "getEntry failed: errCode=" + data.getErrCode() + ", errMsg=" + data.getErrMsg(), null, 4, null);
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    et4.a aVar;
                    SquareBaseKt.getSquareLog().i("VasSquareEntryService", "getEntry success.");
                    e c16 = e.c(rspData);
                    SquareEntry parse = (c16 == null || (aVar = c16.f397123a) == null) ? null : SquareEntryKt.parse(aVar);
                    if (parse == null) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareEntryService", "parse entry failed: rsp=" + c16 + ", geomap=" + c16.f397123a, null, 4, null);
                        return;
                    }
                    Function1.this.invoke(parse);
                }
            });
        }
    }
}
