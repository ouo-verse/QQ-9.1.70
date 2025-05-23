package com.tencent.state.square.mayknow;

import android.util.Size;
import at4.a;
import at4.b;
import at4.c;
import at4.d;
import at4.e;
import at4.f;
import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.UserFormatKt;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareRecommendUserItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J$\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0011J\u0016\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/mayknow/MayKnowService;", "", "()V", "CMD_HIDE_MAY_KNOW_ENTRANCE", "", "CMD_MAY_KNOW_LIST", "METHOD_GET_BLOCK_RECOMMEND_USER", "METHOD_HIDE_MAY_KNOW_ENTRANCE", "METHOD_MAY_KNOW_LIST", "TAG", "getMayKnowList", "", "cookies", "", "count", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/mayknow/MayKnowListInfo;", "getSquareRecommendUsers", "mapSize", "Landroid/util/Size;", "", "Lcom/tencent/state/square/data/SquareRecommendUserItem;", "hideMayKnowEntrance", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MayKnowService {
    private static final String CMD_HIDE_MAY_KNOW_ENTRANCE = "trpc.qmeta.hide_menu_svr.HideMenu";
    private static final String CMD_MAY_KNOW_LIST = "trpc.qmeta.recommend_user_svr.RecommendUserService";
    public static final MayKnowService INSTANCE = new MayKnowService();
    private static final String METHOD_GET_BLOCK_RECOMMEND_USER = "GetBlockRecomUser";
    private static final String METHOD_HIDE_MAY_KNOW_ENTRANCE = "HideRecommendUser";
    private static final String METHOD_MAY_KNOW_LIST = "GetRecommendUser";
    private static final String TAG = "MayKnowService";

    MayKnowService() {
    }

    public final void getMayKnowList(byte[] cookies, int count, final ResultCallback<MayKnowListInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d dVar = new d();
        dVar.f26927a = cookies;
        dVar.f26928b = count;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(dVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_MAY_KNOW_LIST, METHOD_MAY_KNOW_LIST, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.mayknow.MayKnowService$getMayKnowList$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MayKnowService", "getMayKnowList onError data:" + data, null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        e c16 = e.c(rspData);
                        SquareLogger squareLog = SquareBaseKt.getSquareLog();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getMayKnowList onReceive cookies:");
                        sb5.append(c16.f26929a);
                        sb5.append(", isEnd:");
                        sb5.append(c16.f26930b);
                        sb5.append(", size:");
                        f[] fVarArr = c16.f26931c;
                        sb5.append(fVarArr != null ? Integer.valueOf(fVarArr.length) : null);
                        squareLog.d("MayKnowService", sb5.toString());
                        ArrayList arrayList = new ArrayList();
                        f[] fVarArr2 = c16.f26931c;
                        if (fVarArr2 != null) {
                            for (f it : fVarArr2) {
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                arrayList.add(MayKnowServiceKt.formatMayKnowUser(it));
                            }
                        }
                        ResultCallback resultCallback = ResultCallback.this;
                        byte[] bArr = c16.f26929a;
                        Intrinsics.checkNotNullExpressionValue(bArr, "rsp.cookies");
                        resultCallback.onResultSuccess(new MayKnowListInfo(bArr, c16.f26930b, arrayList));
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("MayKnowService", "getMayKnowList parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "getMayKnowList parse error");
                    }
                }
            });
        }
    }

    public final void getSquareRecommendUsers(final Size mapSize, final ResultCallback<List<SquareRecommendUserItem>> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = new b();
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(bVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_MAY_KNOW_LIST, METHOD_GET_BLOCK_RECOMMEND_USER, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.mayknow.MayKnowService$getSquareRecommendUsers$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MayKnowService", "getSquareRecommendUsers onError data:" + data, null, 4, null);
                    ResultCallback resultCallback = callback;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        c c16 = c.c(rspData);
                        SquareLogger squareLog = SquareBaseKt.getSquareLog();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getSquareRecommendUsers onReceive size:");
                        a[] aVarArr = c16.f26926a;
                        sb5.append(aVarArr != null ? Integer.valueOf(aVarArr.length) : null);
                        squareLog.d("MayKnowService", sb5.toString());
                        ArrayList arrayList = new ArrayList();
                        a[] aVarArr2 = c16.f26926a;
                        if (aVarArr2 != null) {
                            for (a it : aVarArr2) {
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                arrayList.add(UserFormatKt.formatSquareRecommendUserItem(it, mapSize));
                            }
                        }
                        callback.onResultSuccess(arrayList);
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("MayKnowService", "getSquareRecommendUsers parse throw:", th5);
                        callback.onResultFailure(-2, "getSquareRecommendUsers parse error");
                    }
                }
            });
        }
    }

    public final void hideMayKnowEntrance(final ResultCallback<Object> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        ls4.d dVar = new ls4.d();
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(dVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_HIDE_MAY_KNOW_ENTRANCE, METHOD_HIDE_MAY_KNOW_ENTRANCE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.mayknow.MayKnowService$hideMayKnowEntrance$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MayKnowService", "hideMayKnowEntrance onError data:" + data, null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().d("MayKnowService", "hideMayKnowEntrance onReceive");
                    ResultCallback.this.onResultSuccess(null);
                }
            });
        }
    }
}
