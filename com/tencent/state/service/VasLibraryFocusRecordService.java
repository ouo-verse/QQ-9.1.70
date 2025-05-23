package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ms4.b;
import ms4.d;
import ms4.e;
import ms4.f;
import ms4.g;
import ms4.h;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eJ\u001c\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/service/VasLibraryFocusRecordService;", "", "()V", "CMD_SERVICE", "", "METHOD_GET_SIMPLE_FOCUS_RECORD", "METHOD_QUERY_USER_FOCUS_TASK", "TAG", "requestFocusRecord", "", "startTimestamp", "", "endTimestamp", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/service/VasLibraryFocusRecord;", "requestFocusTask", "scene", "Lcom/tencent/state/service/VasLibraryFocusTaskScene;", "Lcom/tencent/state/service/VasLibraryFocusTask;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasLibraryFocusRecordService {
    private static final String CMD_SERVICE = "trpc.qmeta.library_focus_record_svr.LibraryFocusRecordSvr";
    public static final VasLibraryFocusRecordService INSTANCE = new VasLibraryFocusRecordService();
    private static final String METHOD_GET_SIMPLE_FOCUS_RECORD = "GetSimpleFocusRecord";
    private static final String METHOD_QUERY_USER_FOCUS_TASK = "QueryUserFocusTask";
    private static final String TAG = "VasLibraryFocusRecordService";

    VasLibraryFocusRecordService() {
    }

    public final void requestFocusRecord(long startTimestamp, long endTimestamp, final ResultCallback<VasLibraryFocusRecord> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        e eVar = new e();
        eVar.f417522a = startTimestamp;
        eVar.f417523b = endTimestamp;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(eVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_SIMPLE_FOCUS_RECORD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasLibraryFocusRecordService$requestFocusRecord$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryFocusRecordService", "requestFocusRecord on error, buildingIds:" + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    Object firstOrNull;
                    try {
                        b[] bVarArr = f.c(rspData).f417524a;
                        Intrinsics.checkNotNullExpressionValue(bVarArr, "rsp.gathers");
                        firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
                        b bVar = (b) firstOrNull;
                        if (bVar != null) {
                            ResultCallback.this.onResultSuccess(new VasLibraryFocusRecord(bVar.f417506d, bVar.f417504b));
                        } else {
                            ResultCallback.this.onResultSuccess(null);
                        }
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("VasLibraryFocusRecordService", "requestFocusRecord on receive but parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "requestFocusRecord parse error");
                    }
                }
            });
        }
    }

    public final void requestFocusTask(VasLibraryFocusTaskScene scene, final ResultCallback<VasLibraryFocusTask> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(callback, "callback");
        g gVar = new g();
        gVar.f417525a = scene.getScene();
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(gVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_QUERY_USER_FOCUS_TASK, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasLibraryFocusRecordService$requestFocusTask$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryFocusRecordService", "queryUserFocusTask on error, buildingIds:" + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    Map hashMap;
                    try {
                        h c16 = h.c(rspData);
                        d dVar = c16.f417526a;
                        long j3 = dVar != null ? dVar.f417517b : 0L;
                        long j16 = dVar != null ? dVar.f417518c : 0L;
                        long j17 = dVar != null ? dVar.f417520e : 0L;
                        if (dVar == null || (hashMap = dVar.f417519d) == null) {
                            hashMap = new HashMap();
                        }
                        ResultCallback.this.onResultSuccess(new VasLibraryFocusTask(j3, j16, j17, hashMap, c16.f417528c, 1000 * c16.f417531f));
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("VasLibraryFocusRecordService", "queryUserFocusTask on receive but parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "queryUserFocusTask parse error");
                    }
                }
            });
        }
    }
}
