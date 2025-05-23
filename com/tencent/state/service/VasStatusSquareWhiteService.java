package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareWhitelist;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zt4.a;
import zt4.b;
import zt4.c;
import zt4.d;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/service/VasStatusSquareWhiteService;", "", "()V", "addWhiteList", "", "source", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "queryUserWhite", "Lcom/tencent/state/square/data/SquareWhitelist;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasStatusSquareWhiteService {
    private static final String ADD_WHITELIST_METHOD = "AddWhitelist";
    private static final String CMD_SERVICE = "trpc.qmeta.status_square_whitelist_svr.StatusSquareWhitelistSvr";
    private static final String QUERY_METHOD = "QueryUserWhitelistStatus";
    private static final String TAG = "VasStatusSquareWhiteService";

    public final void addWhiteList(String source, final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(source, "source");
        a aVar = new a();
        aVar.f453408a = source;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, ADD_WHITELIST_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareWhiteService$addWhiteList$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasStatusSquareWhiteService", "errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        boolean z16 = b.c(rspData) != null;
                        ResultCallback resultCallback = ResultCallback.this;
                        if (resultCallback != null) {
                            resultCallback.onResultSuccess(Boolean.valueOf(z16));
                        }
                    } catch (Exception e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasStatusSquareWhiteService", "parse error " + e16, null, 4, null);
                        ResultCallback resultCallback2 = ResultCallback.this;
                        if (resultCallback2 != null) {
                            resultCallback2.onResultFailure(-1, e16.getMessage());
                        }
                    }
                }
            });
        }
    }

    public final void queryUserWhite(String source, final ResultCallback<SquareWhitelist> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        c cVar = new c();
        cVar.f453409a = source;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, QUERY_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareWhiteService$queryUserWhite$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasStatusSquareWhiteService", "errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        d rsp = d.c(rspData);
                        if (rsp == null) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasStatusSquareWhiteService", "rsp is null", null, 4, null);
                        }
                        ResultCallback resultCallback = ResultCallback.this;
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        resultCallback.onResultSuccess(UserFormatKt.formatWhitelistStatus(rsp));
                    } catch (Exception e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasStatusSquareWhiteService", "parse error " + e16, null, 4, null);
                        ResultCallback.this.onResultFailure(-1, e16.getMessage());
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addWhiteList$default(VasStatusSquareWhiteService vasStatusSquareWhiteService, String str, ResultCallback resultCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            resultCallback = null;
        }
        vasStatusSquareWhiteService.addWhiteList(str, resultCallback);
    }
}
