package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import ls4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/service/VasSquareAddFriendService;", "", "()V", "addFriendRequest", "", "uin", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/state/service/RspResult;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareAddFriendService {
    private static final String CMD_SERVICE = "trpc.qmeta.hide_menu_svr.HideMenu";
    private static final String METHOD = "AddToSquare";
    private static final String TAG = "VasSquareAddFriendService";

    public final void addFriendRequest(String uin, final Function1<? super RspResult, Unit> callback) {
        Long longOrNull;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a();
        long[] jArr = new long[1];
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        jArr[0] = longOrNull != null ? longOrNull.longValue() : 0L;
        aVar.f415514a = jArr;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareAddFriendService$addFriendRequest$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareAddFriendService", "errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function1.this.invoke(new RspResult(false, data));
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().i("VasSquareAddFriendService", "add friend success");
                    Function1.this.invoke(new RspResult(true, null, 2, null));
                }
            });
        }
    }
}
